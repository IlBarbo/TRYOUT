package math.calculator;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Cronologia extends AppCompatActivity {
    private DBHelper dbHelper;

    private ImageButton deleteAllData,addData;
    RecyclerView recyclerView;
    ArrayList<String> espressione,risultato;
    CustomAdapter customAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popup);
        recyclerView=findViewById(R.id.recyclerview);
        dbHelper= new DBHelper(this);

        SQLiteDatabase sqLiteDatabase=dbHelper.getWritableDatabase();

        espressione=new ArrayList<>();
        risultato=new ArrayList<>();
        deleteAllData=findViewById(R.id.deleteAll);
        addData=findViewById(R.id.addData);
        insertData();
        displayData();
        customAdapter=new CustomAdapter(Cronologia.this,espressione,risultato);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(Cronologia.this));

    }
    void displayData(){
        Cursor cursor=dbHelper.readData();
        if(cursor.getCount() == 0){
            Toast.makeText(this,"NO DATA",Toast.LENGTH_SHORT).show();
        }else{
            while(cursor.moveToNext()){
                espressione.add(cursor.getString(0));
                risultato.add(cursor.getString(1));
            }
        }
    }

    public void insertData(){

        addData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent intent=new Intent(Cronologia.this,Activity_calc.class);
            startActivity(intent);
            }

        });

    }




}
