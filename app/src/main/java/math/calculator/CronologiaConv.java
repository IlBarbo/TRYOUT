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

public class CronologiaConv extends AppCompatActivity
{
    private DBHelperConv dbHelperConv;

    private ImageButton deleteAllData,addData;
    RecyclerView recyclerView;
    ArrayList<String> fromnum,tonum;
    CustomAdapterConv customAdapterConv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cronologia_conv);
        recyclerView=findViewById(R.id.recyclerviewconv);
        dbHelperConv= new DBHelperConv(this);

        SQLiteDatabase sqLiteDatabase=dbHelperConv.getWritableDatabase();

        fromnum=new ArrayList<>();
        tonum=new ArrayList<>();
        deleteAllData=findViewById(R.id.deleteAll);
        addData=findViewById(R.id.addData);

        insertDataConve();
        displayDataConve();
        deleteAllData();
        customAdapterConv=new CustomAdapterConv(CronologiaConv.this,fromnum,tonum);
        recyclerView.setAdapter(customAdapterConv);
        recyclerView.setLayoutManager(new LinearLayoutManager(CronologiaConv.this));

    }
    void displayDataConve(){
        Cursor cursor=dbHelperConv.readData();
        if(cursor.getCount() == 0){
            Toast.makeText(this,"NO DATA",Toast.LENGTH_SHORT).show();
        }else{
            while(cursor.moveToNext()){
                fromnum.add(cursor.getString(0));
                tonum.add(cursor.getString(1));
            }
        }
    }

    public void insertDataConve(){

        addData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(CronologiaConv.this,Convertitore.class);
                startActivity(intent);
            }

        });


    }
    public void deleteAllData(){
        deleteAllData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder cronologia = new AlertDialog.Builder(CronologiaConv.this);
                Cursor cursor = dbHelperConv.readData();
                if (cursor.getCount() != 0) {
                    cronologia.setTitle("Elimina Cronologia");
                    cronologia.setMessage("Sei sicuro di voler eliminare tutta la cronologia?");
                    cronologia.setPositiveButton("SI", (dialog, which) -> {
                        //elimino la cronologia

                        dbHelperConv.deleteData();
                        //mantengo R.layout.popup aperto eliminando la cronologia
                        setContentView(R.layout.cronologia_conv);
					/*
                    con finish(); chiudo direttamente R.layout.popup
                     dopo aver eliminato la cronologia

					 */
                        //finish();

                        //  Toast.makeText(getBaseContext(),"Cronologia eliminata", Toast.LENGTH_SHORT).show();
                    });
                    cronologia.setNegativeButton("N0", (dialog, which) -> dialog.dismiss());
                    cronologia.show();


                } else {

                    Toast.makeText(getBaseContext(), "CRONOLOGIA VUOTA", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}
