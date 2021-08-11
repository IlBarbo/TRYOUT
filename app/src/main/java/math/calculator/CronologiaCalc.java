package math.calculator;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

import static math.calculator.Convertitore.redirectActivity;

public class CronologiaCalc extends AppCompatActivity implements RowDeletionListener {

    private DBHelper dbHelper;

    private ImageButton deleteAllData,addData;
    RecyclerView recyclerView;
    ArrayList<String> espressione,risultato,id;
    String row_id;
    CustomAdapter customAdapter,custom;
    ImageButton deletesingledata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popup);
        recyclerView=findViewById(R.id.recyclerview);
        dbHelper= new DBHelper(this);


        SQLiteDatabase sqLiteDatabase=dbHelper.getWritableDatabase();
        id=new ArrayList<>();
        espressione=new ArrayList<>();
        risultato=new ArrayList<>();
        deleteAllData=findViewById(R.id.deleteAll);
        addData=findViewById(R.id.addData);

        insertData();
        displayData();
        setDeleteButtonListener();
        customAdapter=new CustomAdapter(CronologiaCalc.this,espressione,risultato,id, CronologiaCalc.this);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(CronologiaCalc.this));





    }
    void displayData(){
        Cursor cursor=dbHelper.readData();
        if(cursor.getCount() == 0){
            Toast.makeText(this,"NO DATA",Toast.LENGTH_SHORT).show();
        }else{
            while(cursor.moveToNext()){
                espressione.add(cursor.getString(0));
                risultato.add(cursor.getString(1));
                id.add(cursor.getString(2));
            }
        }
    }

    public void insertData(){

        addData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(CronologiaCalc.this,Activity_calc.class);
                startActivity(intent);
            }

        });


    }


    public void setDeleteButtonListener(){
        deleteAllData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder cronologia = new AlertDialog.Builder(CronologiaCalc.this);
                Cursor cursor = dbHelper.readData();
                if (cursor.getCount() != 0) {
                    cronologia.setTitle("Elimina Cronologia");
                    cronologia.setMessage("Sei sicuro di voler eliminare tutta la cronologia?");
                    cronologia.setPositiveButton("SI", (dialog, which) -> {
                        //elimino la cronologia

                        dbHelper.deleteData();

                        //mantengo R.layout.popup aperto eliminando la cronologia
                        espressione.clear();
                        risultato.clear();
                        id.clear();
                        custom=new CustomAdapter(CronologiaCalc.this,espressione,risultato,id, CronologiaCalc.this);
                        recyclerView.setAdapter(custom);
                        recyclerView.setLayoutManager(new LinearLayoutManager(CronologiaCalc.this));

                    });
                    cronologia.setNegativeButton("N0", (dialog, which) -> dialog.dismiss());
                    cronologia.show();


                } else {
                    Toast.makeText(getBaseContext(), "CRONOLOGIA VUOTA", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void newCalc(View view) {
        redirectActivity(CronologiaCalc.this, Activity_calc.class);
    }

    @Override
    public void onRowDeleted(String deletedId) {
        int deletedIndex = id.indexOf(deletedId);
        id.remove(deletedIndex);
        espressione.remove(deletedIndex);
        risultato.remove(deletedIndex);
        custom=new CustomAdapter(CronologiaCalc.this,espressione,risultato,id, CronologiaCalc.this);
        recyclerView.setAdapter(custom);
        recyclerView.setLayoutManager(new LinearLayoutManager(CronologiaCalc.this));

    }

}