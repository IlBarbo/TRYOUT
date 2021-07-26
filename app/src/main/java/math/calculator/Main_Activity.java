package math.calculator;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        final EditText nickname= findViewById(R.id.nickname);
        final Button accesbutton= findViewById(R.id.Access);
//oggetto visibile nel blocco inferiore


        accesbutton.setOnClickListener(new View.OnClickListener() { //utilizzo bottone
            @Override
            public void onClick(View v) {
                //configuro il colore giallo del bottone

                if(nickname.getText().toString().length()>=5){
                    Intent apricalc= new Intent(Main_Activity.this,Activity_calc.class);
                    apricalc.putExtra("nickname", nickname.getText().toString());
                    startActivity(apricalc);
                }
                else{ //to do pop up per avvisare l'utente che la lunghezza minima è 5
                    Toast toast=Toast.makeText(getBaseContext(),"inserire minimo 5 caratteri",Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });
    }

}
