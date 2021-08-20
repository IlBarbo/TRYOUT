package math.calculator;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import static android.text.InputType.TYPE_CLASS_NUMBER;
import static android.text.InputType.TYPE_TEXT_FLAG_CAP_CHARACTERS;

public class ConvertitoreBase extends AppCompatActivity {
    private EditText numero;
    private Button converti;
    private ImageButton clear;
    private TextView bin, dec, oct, esa,conta;
    private TextView ris2,ris8,ris10,ris16,eticnumero;
    private RadioButton radio2,radio8,radio10,radio16;
    private double BaseFrom;
    ImageView cronologiaBaseButton;
    DrawerLayout drawerLayout;
    private int maxcifre,MAXNUMERO;
    private TextView title;
    final Context context = this;
    SharedPreferences sharedPreferences;
    private static final String SHARED_PREF_NAME="save nickname";
    private static final String KEY_NICKNAME="nickname";
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.convertitore_basi);
        BaseFrom = 10.0;
        MAXNUMERO = 2147483647;
        title=findViewById(R.id.benvenuto);
        /*numero max che può essere convertito dall'app*/
        drawerLayout=findViewById(R.id.drawer_layout);
        cronologiaBaseButton=findViewById(R.id.cronologia);
        cronologiaBaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ConvertitoreBase.this, CronologiaBase.class);
                startActivity(intent);
            }
        });
        converti = (Button) findViewById(R.id.baseConverti);

        numero = (EditText) findViewById(R.id.numero);
        numero.addTextChangedListener(new MyTextWatcher(numero));
        conta = (TextView) findViewById(R.id.tConta);
        numero.setInputType(TYPE_CLASS_NUMBER);//setta la tastiera numerica
        maxcifre = 10;
        eticnumero = (TextView) findViewById(R.id.radionumero);
        eticnumero.setText("Numero in base 10 da convertire");

        clear = (ImageButton) findViewById(R.id.bClear);
        //risultati delle conversioni
        ris2 = (TextView) findViewById(R.id.tBase2);
        ris8 = (TextView) findViewById(R.id.tBase8);
        ris10 = (TextView) findViewById(R.id.tBase10);
        ris16 = (TextView) findViewById(R.id.tBase16);
        // text view dei risultati delle conversioni
        bin = (TextView) findViewById(R.id.tBinario);
        dec = (TextView) findViewById(R.id.tDecimale);
        oct = (TextView) findViewById(R.id.tOttale);
        esa = (TextView) findViewById(R.id.tEsadecimale);

        //RadioButton
        radio2 = (RadioButton) findViewById(R.id.radio2);
        radio8 = (RadioButton) findViewById(R.id.radio8);
        radio10 = (RadioButton) findViewById(R.id.radio10);
        radio16 = (RadioButton) findViewById(R.id.radio16);
        conta.setText("0/10");

        sharedPreferences= getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        String name = sharedPreferences.getString(KEY_NICKNAME, null);
        title.setText("Ciao " + name);

        radio2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetradiobutton();
                radio2.setChecked(true);
                BaseFrom = 2.0;
                maxcifre = 31;
                String msg = "Numero in base 2 da convertire";
                numero.setInputType(TYPE_CLASS_NUMBER);//setta la tastiera numerica
                eticnumero.setText(msg);
                String contatore = "0/" + String.valueOf(maxcifre);
                conta.setText(contatore);

            }
        });

        radio8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetradiobutton();
                radio8.setChecked(true);
                BaseFrom = 8.0;
                maxcifre = 11;
                String msg = "Numero in base 8 da convertire";
                numero.setInputType(TYPE_CLASS_NUMBER);//setta la tastiera numerica
                eticnumero.setText(msg);
                String contatore = "0/" + String.valueOf(maxcifre);
                conta.setText(contatore);

            }
        });

        radio10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetradiobutton();
                radio10.setChecked(true);
                BaseFrom = 10.0;
                maxcifre = 10;
                numero.setInputType(TYPE_CLASS_NUMBER);//setta la tastiera numerica
                String msg = "Numero in base 10 da convertire";
                numero.setInputType(TYPE_CLASS_NUMBER);//setta la tastiera numerica
                eticnumero.setText(msg);
                String contatore = "0/" + String.valueOf(maxcifre);
                conta.setText(contatore);

            }
        });

        radio16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetradiobutton();
                radio16.setChecked(true);
                BaseFrom = 16.0;
                maxcifre = 8;
                numero.setInputType(TYPE_TEXT_FLAG_CAP_CHARACTERS);//setta la tastiera alfanumerica
                String msg = "Numero in base 16 da convertire";
                eticnumero.setText(msg);
                String contatore = "0/" + String.valueOf(maxcifre);
                conta.setText(contatore);

            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearall();
            }
        });
        converti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            if(!numero.getText().toString().trim().isEmpty()) {

                convertfrombase();
                DBHelperBase dbHelperbase = new DBHelperBase(ConvertitoreBase.this);
                dbHelperbase.insertData(bin.getText().toString().trim(), oct.getText().toString().trim(), dec.getText().toString().trim(), esa.getText().toString().trim());
            }else{
                    numero.setError("nessun numero inserito");
                    numero.requestFocus();

            }
            }
        });
    }
    //navigation drawer
    public void ClickMenu (View view)
    {
        //apro drawer
        openDrawer(drawerLayout);
    }

    public static void openDrawer (DrawerLayout drawerLayout){
        //apro drawer layout
        drawerLayout.openDrawer(GravityCompat.START);
    }
    public void ClickLogo (View view)
    {
        closeDrawer(drawerLayout);
    }

    public static void closeDrawer (DrawerLayout drawerLayout){
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            //quando il drawer è aperto lo chiudo
            drawerLayout.closeDrawer(GravityCompat.START);

        }
    }
    //Menu
    public void clickHome (View view)
    {
        redirectActivity(this, Activity_calc.class);
    }

    public void clickConvertitore (View view){
        redirectActivity(this,Convertitore.class);
    }

    public void clickGrafico (View view){
        redirectActivity(this, Grafico.class);
    }
    public void clickConvertitorebase (View view){
       recreate();
    }


    public void clickLogout (View view){
        logout(this);
    }

    public static void logout (Activity activity_drawer){
        AlertDialog.Builder builder = new AlertDialog.Builder(activity_drawer);
        builder.setTitle("Logout");
        builder.setMessage("sei sicuro di voler fare il logout?");
        builder.setPositiveButton("SI", (dialog, which) -> {
            //finish activity
            activity_drawer.finishAffinity();
            System.exit(0);
        });
        builder.setNegativeButton("N0", (dialog, which) -> dialog.dismiss());
        builder.show();
    }
    protected void onPause () {
        super.onPause();
        closeDrawer(drawerLayout);
    }

    public static void redirectActivity (Activity activity, Class aClass){
        Intent intent = new Intent(activity, aClass);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        //start activity
        activity.startActivity(intent);

    }

//inizio convertitore di misura
    private void resetradiobutton()//uncheck di tutti i RadioButton
    {
        radio2.setChecked(false);
        radio8.setChecked(false);
        radio10.setChecked(false);
        radio16.setChecked(false);
        numero.setText(""); // quando si cambia la base il numero in input viene resettato
    }
    private void clearall()//pulisce i campi Text e nasconde i campi dei risultati
    {
        numero.setText("");
        bin.setText("");
        oct.setText("");
        dec.setText("");
        esa.setText("");
        //elimina il messaggio di errore
        numero.setError("");
        //elimina il simbolo di errore
        numero.setError(null);
    }

    private void convertfrombase()
    {


        String v = numero.getText().toString();

        if (BaseFrom==10.0)
        {
            if(Double.parseDouble(v)>2147483647) // se il valore decimale è superiore a 2^31
            {
                numero.setError("Max numero decimale: "+String.valueOf(MAXNUMERO));
                numero.requestFocus();
                return;
            }
            int decimale= Integer.parseInt(v);
            dec.setText(String.valueOf(decimale));
            bin.setText(convertfrombase10(decimale,2));
            oct.setText(convertfrombase10(decimale,8));
            esa.setText(convertfrombase10(decimale,16));
        }

        if (BaseFrom==2.0){
            //il controllo sul valore del numero viene fatto controllando la lunghezza della stringa,
            // che viene fattta in TextWatcher, che non può essere superiore a 31
            int decimale=(int)converttobase10();
            dec.setText(String.valueOf(decimale));
            bin.setText(convertfrombase10(decimale,2));
            oct.setText(convertfrombase10(decimale,8));
            esa.setText(convertfrombase10(decimale,16));
        }

        if (BaseFrom==8.0){

            if(converttobase10()>MAXNUMERO)// se il valore decimale è superiore a 2^31
            {
                numero.setError("Max numero ottale: 17777777777");
                numero.requestFocus();
                return;
            }
            int decimale=(int) converttobase10();
            dec.setText(String.valueOf(decimale));
            bin.setText(convertfrombase10(decimale,2));
            oct.setText(convertfrombase10(decimale,8));
            esa.setText(convertfrombase10(decimale,16));
        }
 /* Nel caso della base 16 il controllo dei simboli viene fatto sull'evento onClick()
 del button converti. Non ho utilizzato la classe inputFilter che all'interno di textWatcher
 funziona perfettamente nel filtraggio di valori numerici (e quindi per le basi 2, 8 e 10) e
 del limite massimo del numero fornito in input, ma non ha funzionato per quel che riguarda
 il filtraggio di valori alfanumeri. Non ho insistito nel risolvere il problema riscontrato,
qualche studente volenteroso può provare a farlo 
 */
        if (BaseFrom==16.0){
            if(!v.matches("^[a-fA-F0-9]*$")){
                numero.setError("Simboli ammessi da 0 a 9 e da A a F");
                numero.requestFocus();
                return;
            }

            if(converttobase10()>MAXNUMERO)// se il valore decimale è superiore a 2^31
            {
                numero.setError("Max numero esadecimale: 7FFFFFFF");
                numero.requestFocus();
                return;
            }
            int decimale=(int) converttobase10();
            dec.setText(String.valueOf(decimale));
            bin.setText(convertfrombase10(decimale,2));
            oct.setText(convertfrombase10(decimale,8));
            esa.setText(convertfrombase10(decimale,16));
        }

        closekb(); //chiudo la tastiera dopo aver premuto il tasto converti

    }

    private double converttobase10() {
        String v = numero.getText().toString();
        double b=BaseFrom;
        int l=v.length();
        double c=0,somma=0;

        if (b==2.0 || b==8.0)
        {
            for(int i=0;i<l;i++)
            {
                String ch=v.substring(i,i+1);
                c=Double.parseDouble(ch);
                somma+=c*Math.pow(b,l-i-1);
            }

        }
        if(b==16.0)
        {
            for(int i=0;i<l;i++)
            {
                String ch=v.substring(i,i+1);

                if(ch.equals("A") || ch.equals("a"))
                    c=10.0;
                else if(ch.equals("B") || ch.equals("b"))
                    c=11.0;
                else if(ch.equals("C") || ch.equals("c"))
                    c=12.0;
                else if(ch.equals("D") || ch.equals("d"))
                    c=13.0;
                else if(ch.equals("E") || ch.equals("e"))
                    c=14.0;
                else if(ch.equals("F") || ch.equals("f"))
                    c=15.0;
                else
                    c=Double.parseDouble(ch);

                somma+=c*Math.pow(b,l-i-1);
            }
        }
        return somma;
    }

    private String convertfrombase10( int num, int b)
    {
        String risultato = "";
        int resto;
        while (num > 0) {
            resto = num % b;
            if (b == 16) {
                if (resto == 10)
                    risultato = "A"+risultato;
                else if (resto == 11)
                    risultato = "B"+risultato;
                else if (resto == 12)
                    risultato = "C"+risultato;
                else if (resto == 13)
                    risultato = "D"+risultato;
                else if (resto == 14)
                    risultato = "E"+risultato;
                else if (resto == 15)
                    risultato = "F"+risultato;
                else
                    risultato = resto+risultato;
            } else
                risultato= resto+risultato;
            num /= b;
        }
        return risultato;
    }

//chiude la tastiera dopo aver cliccato su converti
    private void closekb()
    {
        View view=this.getCurrentFocus();
        InputMethodManager inputMethodManager=(InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(),0);
    }


    private class MyTextWatcher implements TextWatcher {
        private View view;
        public MyTextWatcher(View view) {
            this.view=view;
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
// Se la prima cifra del numero da convertire vale 0, essendo non significativa,non viene accettata
            if(numero.getText().toString().equals("0")){
                numero.setText("");
                numero.requestFocus();
                return;
            }
            controllanumero();
        }
    }
    private void controllanumero() {
        String s = numero.getText().toString();
        // viene aggiornato il contatore di cifre inserite
        String contatore=String.valueOf(s.length())+"/"+String.valueOf(maxcifre);
        conta.setText(contatore);


        InputFilter filtrasimboli= new InputFilter()
        {
            @Override
            public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend)
            {
                boolean ok;

                for (int i = start; i < end; i++)
                {
                    char c = source.charAt(i);
                    String ch=String.valueOf(c);
                    ok=true;
                    if(BaseFrom==2.0)
                    {
                        if (c!='0' && c!='1')ok=false;
                    }
                    if(BaseFrom==8.0)
                    {
                        if(!ch.matches(".*[0-7]"))ok=false;
                    }
                    if(!ok) return "";
                }
                return null;
            }
        };
        //imposto i controlli sui numeri in base due e otto nell'editText
        numero.setFilters(new InputFilter[] {
                    filtrasimboli, new InputFilter.LengthFilter(maxcifre)
        });
       /* Il controllo della massima lunghezza del numero in input viene fatto da
        InputFilter.LengthFilter(maxcifre)*/

        numero.requestFocus();
    }
}

