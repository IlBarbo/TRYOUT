package math.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import org.mariuszgromada.math.mxparser.*;

public class Activity_calc extends AppCompatActivity {

    private TextView risultato;
    private EditText schermo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);
        risultato=findViewById(R.id.risultato);
        schermo=findViewById(R.id.display);
        schermo.setShowSoftInputOnFocus(false); /*Imposta un valore che indica se il metodo di
                                                 input soft verrà reso visibile quando questo
                                                  TextView viene messo a punto. L'impostazione
                                                  predefinita è true */

    }

    private void upText(String strToAdd){
        String oldStr=schermo.getText().toString();
        int cursore=schermo.getSelectionStart();
        String leftStr= oldStr.substring(0,cursore);
        String rightStr= oldStr.substring(cursore);
        schermo.setText(String.format("%s%s%s",leftStr,strToAdd,rightStr));
        schermo.setSelection(cursore+strToAdd.length());
    }


    public void zero(View v){
        upText(getResources().getString(R.string.zero));
    }
    public void uno(View v){
        upText(getResources().getString(R.string.uno));
    }
    public void due(View v){
        upText(getResources().getString(R.string.due));
    }
    public void tre(View v){
        upText(getResources().getString(R.string.tre));
    }
    public void quattro(View v){
        upText(getResources().getString(R.string.quattro));
    }
    public void cinque(View v){
        upText(getResources().getString(R.string.cinque));
    }
    public void sei(View v){
        upText(getResources().getString(R.string.sei));
    }
    public void sette(View v){
        upText(getResources().getString(R.string.sette));
    }
    public void otto(View v){
        upText(getResources().getString(R.string.otto));
    }
    public void nove(View v){
        upText(getResources().getString(R.string.nove));
    }
    public void clear(View v){
        schermo.setText("");
        risultato.setText("");
    }
    public void esponente(View v){
        upText(getResources().getString(R.string.esponente));
    }
    public void parentesi(View v){
        int cursorePos=schermo.getSelectionStart();
        int apertaPar= 0;
        int chiusaPar=0;
        int lunghezza=schermo.getText().length();
        for(int i=0;i< cursorePos;i++)
        {
            if(schermo.getText().toString().substring(i,i+1).equals("(")){
                apertaPar+=1;
            }
            if(schermo.getText().toString().substring(i,i+1).equals(")")){
                chiusaPar+=1;
            }
        }
        if(apertaPar == chiusaPar || schermo.getText().toString().substring(lunghezza-1,lunghezza).equals("(")){
            upText("(");
        }
        if(chiusaPar < apertaPar && !schermo.getText().toString().substring(lunghezza-1,lunghezza).equals("(")){
            upText(")");
        }
        schermo.setSelection(cursorePos+1);
    }
    public void divisione(View v){
        upText(getResources().getString(R.string.divisione));
    }
    public void moltiplicazione(View v){
        upText(getResources().getString(R.string.moltiplicazione));
    }
    public void add(View v){
        upText(getResources().getString(R.string.add));
    }
    public void sub(View v){
        upText(getResources().getString(R.string.sub));
    }
    public void addsub(View v){
        upText(getResources().getString(R.string.addsub));
    }
    public void punto(View v){
        upText(getResources().getString(R.string.punto));
    }
    public void uguale(View v){
       String user=schermo.getText().toString();
        risultato.setText(user);

        user = user.replaceAll(getResources().getString(R.string.divisione), "/");
        user = user.replaceAll(getResources().getString(R.string.moltiplicazione), "*");

        Expression exp=new Expression(user);
       String result=String.valueOf(exp.calculate()); //usa la libreria mxparser
        schermo.setText(result);
        schermo.setSelection(result.length());
    }
    public void spazio(View v){
       int cursore= schermo.getSelectionStart();
       int textLen=schermo.getText().length();
       if(cursore != 0 && textLen != 0)
       {
           SpannableStringBuilder sel=(SpannableStringBuilder) schermo.getText();
           //replace sostituisce il testo compreso tra start e end con la stringa che vogliamo
           sel.replace(cursore-1,cursore,"");
           schermo.setText(sel);
           schermo.setSelection(cursore-1);
       }
    }
}
