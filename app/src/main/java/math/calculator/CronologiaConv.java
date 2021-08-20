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

public class CronologiaConv extends AppCompatActivity implements RowDeletionListener
{
    private DBHelperConv dbHelperConv;

    private ImageButton deleteAllData,addData;
    RecyclerView recyclerView;
    ArrayList<String> fromnum,tonum,spinnerfrom,spinnerto,id;
    CustomAdapterConv customAdapterConv;
    CustomAdapterConv custom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cronologia_conv);
        recyclerView=findViewById(R.id.recyclerviewconv);
        dbHelperConv= new DBHelperConv(this);

        SQLiteDatabase sqLiteDatabase=dbHelperConv.getWritableDatabase();

        fromnum= new ArrayList<>();
        tonum=new ArrayList<>();
        spinnerfrom=new ArrayList<>();
        spinnerto=new ArrayList<>();
        id=new ArrayList<>();
        deleteAllData=findViewById(R.id.deleteAll);
        addData=findViewById(R.id.addData);

        insertDataConve();
        displayDataConve();
        deleteAllData();
        customAdapterConv=new CustomAdapterConv(CronologiaConv.this,fromnum,tonum,spinnerfrom,spinnerto,id,CronologiaConv.this);
        recyclerView.setAdapter(customAdapterConv);
        recyclerView.setLayoutManager(new LinearLayoutManager(CronologiaConv.this));

    }
    void displayDataConve(){
        Cursor cursor=dbHelperConv.readData();
        if(cursor.getCount() == 0){
            Toast.makeText(this,"CRONOLOGIA VUOTA",Toast.LENGTH_SHORT).show();
        }else{
            while(cursor.moveToNext()){
                fromnum.add(cursor.getString(0));
                tonum.add(cursor.getString(1));
                spinnerfrom.add(cursor.getString(2));
                spinnerto.add(cursor.getString(3));
                id.add(cursor.getString(4));
            }
        }
    }

    public void insertDataConve(){

        addData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               finish();
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

                        fromnum.clear();
                        tonum.clear();
                        spinnerfrom.clear();
                        spinnerto.clear();
                        id.clear();
                        custom=new CustomAdapterConv(CronologiaConv.this,fromnum,tonum,spinnerfrom,spinnerto,id,CronologiaConv.this);
                        recyclerView.setAdapter(custom);
                        recyclerView.setLayoutManager(new LinearLayoutManager(CronologiaConv.this));

                    });
                    cronologia.setNegativeButton("N0", (dialog, which) -> dialog.dismiss());
                    cronologia.show();


                } else {

                    Toast.makeText(getBaseContext(), "CRONOLOGIA VUOTA", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
    @Override
    public void onRowDeleted(String deletedId) {
        int deletedIndex = id.indexOf(deletedId);
        fromnum.remove(deletedIndex);
        tonum.remove(deletedIndex);
        spinnerfrom.remove(deletedIndex);
        spinnerto.remove(deletedIndex);
        id.remove(deletedIndex);
        custom=new CustomAdapterConv(CronologiaConv.this,fromnum,tonum,spinnerfrom,spinnerto,id, CronologiaConv.this);
        recyclerView.setAdapter(custom);
        recyclerView.setLayoutManager(new LinearLayoutManager(CronologiaConv.this));

    }


}
