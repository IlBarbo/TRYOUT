package math.calculator;

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
import android.widget.Toast;

import java.util.ArrayList;

import static math.calculator.Convertitore.redirectActivity;

public class CronologiaBase extends AppCompatActivity implements RowDeletionListener {

    private DBHelperBase dbHelperBase;

    private ImageButton deleteAllData,addData;
    RecyclerView recyclerView;
    ArrayList<String> tbinario,tottale,tdecimale,tesadecimale,id;
    CustomAdapterBase customAdapter,custom;
    ImageButton deletesingledata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cronologia_base);
        recyclerView=findViewById(R.id.recyclerviewconv);
        dbHelperBase= new DBHelperBase(this);


        SQLiteDatabase sqLiteDatabase=dbHelperBase.getWritableDatabase();
        id=new ArrayList<>();
        tbinario=new ArrayList<>();
        tottale=new ArrayList<>();
        tdecimale=new ArrayList<>();
        tesadecimale=new ArrayList<>();
        deleteAllData=findViewById(R.id.deleteAll);
        addData=findViewById(R.id.addData);

        insertData();
        displayData();
        setDeleteButtonListener();
        customAdapter=new CustomAdapterBase(CronologiaBase.this,tbinario,tottale,tdecimale,tesadecimale,id,CronologiaBase.this);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(CronologiaBase.this));





    }
    void displayData(){
        Cursor cursor=dbHelperBase.readData();
        if(cursor.getCount() == 0){
            Toast.makeText(this,"CRONOLOGIA VUOTA",Toast.LENGTH_SHORT).show();
        }else{
            while(cursor.moveToNext()){
                tbinario.add(cursor.getString(0));
                tottale.add(cursor.getString(1));
                tdecimale.add(cursor.getString(2));
                tesadecimale.add(cursor.getString(3));
                id.add(cursor.getString(4));
            }
        }
    }

    public void insertData(){

        addData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(CronologiaBase.this,ConvertitoreBase.class);
                startActivity(intent);
            }

        });


    }


    public void setDeleteButtonListener(){
        deleteAllData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder cronologia = new AlertDialog.Builder(CronologiaBase.this);
                Cursor cursor = dbHelperBase.readData();
                if (cursor.getCount() != 0) {
                    cronologia.setTitle("Elimina Cronologia");
                    cronologia.setMessage("Sei sicuro di voler eliminare tutta la cronologia?");
                    cronologia.setPositiveButton("SI", (dialog, which) -> {
                        //elimino la cronologia

                        dbHelperBase.deleteData();

                        //mantengo R.layout.popup aperto eliminando la cronologia
                        tbinario.clear();
                        tottale.clear();
                        tdecimale.clear();
                        tesadecimale.clear();
                        id.clear();
                        custom=new CustomAdapterBase(CronologiaBase.this,tbinario,tottale,tdecimale,tesadecimale,id, CronologiaBase.this);
                        recyclerView.setAdapter(custom);
                        recyclerView.setLayoutManager(new LinearLayoutManager(CronologiaBase.this));

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
        redirectActivity(CronologiaBase.this, ConvertitoreBase.class);
    }

    @Override
    public void onRowDeleted(String deletedId) {

        int deletedIndex = id.indexOf(deletedId);
        id.remove(deletedIndex);
        tbinario.remove(deletedIndex);
        tottale.remove(deletedIndex);
        tdecimale.remove(deletedIndex);
        tesadecimale.remove(deletedIndex);
        custom=new CustomAdapterBase(CronologiaBase.this,tbinario,tottale,tdecimale,tesadecimale,id, CronologiaBase.this);
        recyclerView.setAdapter(custom);
        recyclerView.setLayoutManager(new LinearLayoutManager(CronologiaBase.this));

    }
}
