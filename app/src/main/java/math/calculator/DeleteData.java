/*package math.calculator;

import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class DeleteData extends AppCompatActivity {

    ImageButton deletesingledata;

    String row_id;
    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.row_cronologia);

        deletesingledata = (ImageButton) findViewById(R.id.deletesingledata);
        setDeleteSingleButtonListener();


    }


    public void setDeleteSingleButtonListener() {
        deletesingledata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), " ciaooo", Toast.LENGTH_SHORT).show();
            }
        });
    }

            /*    DBHelper myDb = new DBHelper(DeleteData.this);
                myDb.deleteSingleData(row_id);
                espressione.clear();
                risultato.clear();
                id.clear();*/
         /* dbHelper.deleteSingleData(row_id);
        espressione.clear();
        risultato.clear();
        id.clear();*/






