package math.calculator;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main_Activity extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    EditText nickname;
    private static final String SHARED_PREF_NAME="save nickname";
    private static final String KEY_NICKNAME="nickname";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

         nickname= findViewById(R.id.nickname);
         Button accesbutton= findViewById(R.id.Access);
//oggetto visibile nel blocco inferiore
        sharedPreferences=getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);
        String name= sharedPreferences.getString(KEY_NICKNAME,null);

        accesbutton.setOnClickListener(new View.OnClickListener() { //utilizzo bottone
            @Override
            public void onClick(View v) {

                if(nickname.getText().toString().length()>=4){
                    nickname.setError("");
                    nickname.setError(null);

                   // apricalc.putExtra("nickname", nickname.getText().toString());

                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(KEY_NICKNAME, nickname.getText().toString());
                    //applicazione (salvataggio) delle modifiche
                    editor.apply();
                    Intent apricalc= new Intent(Main_Activity.this,Activity_calc.class);

                    startActivity(apricalc);
                }
                else{ //to do pop up per avvisare l'utente che la lunghezza minima è 4
                    nickname.setError("inserire minimo 4 caratteri");

                }
            }
        });
    }


}
