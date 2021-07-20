package math.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Activity_calc extends AppCompatActivity {

    private EditText schermo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);
        schermo=findViewById(R.id.display);
        schermo.setShowSoftInputOnFocus(false); /*Imposta un valore che indica se il metodo di
                                                 input soft verrà reso visibile quando questo
                                                  TextView viene messo a punto. L'impostazione
                                                  predefinita è true */
        schermo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(getString(R.string.display).equals(schermo.getText().toString())){
                    schermo.setText("");
                }
            }
        });
    }


    public void zero(View v){

    }
    public void uno(View v){

    }
    public void due(View v){

    }
    public void tre(View v){

    }
    public void quattro(View v){

    }
    public void cinque(View v){

    }
    public void sei(View v){

    }
    public void sette(View v){

    }
    public void otto(View v){

    }
    public void nove(View v){

    }
    public void clear(View v){

    }
    public void esponente(View v){

    }
    public void parentesi(View v){

    }
    public void divisione(View v){

    }
    public void moltiplicazione(View v){

    }
    public void add(View v){

    }
    public void sub(View v){

    }
    public void addsub(View v){

    }
    public void punto(View v){

    }
    public void uguale(View v){

    }
    public void spazio(View v){

    }
}
