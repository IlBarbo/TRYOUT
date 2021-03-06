package math.calculator;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View;

import com.digidemic.unitof.F;

import org.mariuszgromada.math.mxparser.*;
import org.mariuszgromada.math.mxparser.mathcollection.Evaluate;

public class Activity_calc extends AppCompatActivity {

    private TextView risultato;
    private EditText schermo;
    private int id;
    Button uguale;
    private TextView title;
    DrawerLayout drawerLayout;
    //creare la finestra della cronologia
    private AlertDialog.Builder dialogBuilder;
    private AlertDialog dialog;
    ImageView cronologiaButton,info;
    Button buttonpunto, maggiore, seno, coseno, tangente, arcseno, arccoseno, arctangente,and;
    Dialog dialogpopup;
    SharedPreferences sharedPreferences;
    private static final String SHARED_PREF_NAME="save nickname";
    private static final String KEY_NICKNAME="nickname";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);
        dialogpopup = new Dialog(this);
        risultato = findViewById(R.id.risultato);
        schermo = findViewById(R.id.display);
        title = findViewById(R.id.benvenuto);
        uguale = findViewById(R.id.uguale);
        info=findViewById(R.id.info);
        maggiore = findViewById(R.id.maggiore);
        seno = findViewById(R.id.seno);
        coseno = findViewById(R.id.coseno);
        tangente = findViewById(R.id.tangente);
        arcseno = findViewById(R.id.arcseno);
        arccoseno = findViewById(R.id.arccoseno);
        arctangente = findViewById(R.id.arctangente);
        and=findViewById(R.id.and);
        schermo.setShowSoftInputOnFocus(false); /*Imposta un valore che indica se il metodo di
                                                 input soft verr?? reso visibile quando questo
                                                  TextView viene messo a punto. L'impostazione
                                                  predefinita ?? true */


       sharedPreferences= getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        String name = sharedPreferences.getString(KEY_NICKNAME, null);
        title.setText("Ciao " + name);

        uguale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uguale(v);
                DBHelper dbHelper = new DBHelper(Activity_calc.this);
                dbHelper.insertData(risultato.getText().toString().trim(), schermo.getText().toString().trim());
            }

        });


        buttonpunto = findViewById(R.id.punto);
        cronologiaButton = findViewById(R.id.cronologia);
        cronologiaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity_calc.this, CronologiaCalc.class);
                startActivity(intent);
            }

        });


        String datopassato = getIntent().getStringExtra("espressione");
        schermo.setText(datopassato);

        //assegnamento variabile
        drawerLayout = findViewById(R.id.drawer_layout);
        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowPopup();
            }
        });
    }
    public void ShowPopup() {
        TextView txtclose;
        Button btnFollow;
        dialogpopup.setContentView(R.layout.info);

        /*info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogpopup.dismiss();
            }
        });*/
        dialogpopup.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialogpopup.show();
    }

    //creo una finestra di dialogo
    public void createNewContactDialog() {
        dialogBuilder = new AlertDialog.Builder(this);
        final View contactPopupView = getLayoutInflater().inflate(R.layout.popup, null);
    }

    //navigation drawer
    public void ClickMenu(View view) {
        //apro drawer
        openDrawer(drawerLayout);



    }

    public static void openDrawer(DrawerLayout drawerLayout) {
        //apro drawer layout
        drawerLayout.openDrawer(GravityCompat.START);

    }

    public void ClickLogo(View view) {
        closeDrawer(drawerLayout);
    }

    public static void closeDrawer(DrawerLayout drawerLayout) {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            //quando il drawer ?? aperto lo chiudo
            drawerLayout.closeDrawer(GravityCompat.START);

        }
    }

    public void clickHome(View view) {
        recreate();

    }

    public void clickConvertitore(View view) {

        redirectActivity(this, Convertitore.class);
    }

    public void clickConvertitorebase(View view) {

        redirectActivity(this, ConvertitoreBase.class);
    }




    public void clickLogout(View view) {
        logout(this);
    }

    public static void logout(Activity activity_drawer) {
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

    protected void onPause() {
        super.onPause();
        closeDrawer(drawerLayout);
    }

    public static void redirectActivity(Activity activity, Class aClass) {
        Intent intent = new Intent(activity, aClass);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        //start activity
        activity.startActivity(intent);

    }


    //calcolatrice
    private void upText(String strToAdd) {
        String oldStr = schermo.getText().toString();
        int cursore = schermo.getSelectionStart();
        String leftStr = oldStr.substring(0, cursore);
        String rightStr = oldStr.substring(cursore);
        schermo.setText(String.format("%s%s%s", leftStr, strToAdd, rightStr));
        schermo.setSelection(cursore + strToAdd.length());

    }


    public void zero(View v) {
        upText("0");
    }

    public void uno(View v) {
        upText("1");
    }

    public void due(View v) {
        upText("2");
    }

    public void tre(View v) {
        upText("3");
    }

    public void quattro(View v) {
        upText("4");
    }

    public void cinque(View v) {
        upText("5");
    }

    public void sei(View v) {
        upText("6");
    }

    public void sette(View v) {
        upText("7");
    }

    public void otto(View v) {
        upText("8");
    }

    public void nove(View v) {
        upText("9");
    }

    public void clear(View v) {
        schermo.setText("");
        risultato.setText("");
    }

    public void esponente(View v) {
        upText("^(");
    }

    public void parentesi(View v) {
        int cursorePos = schermo.getSelectionStart();
        int apertaPar = 0;
        int chiusaPar = 0;
        int lunghezza = schermo.getText().length();
        for (int i = 0; i < cursorePos; i++) {
            if (schermo.getText().toString().substring(i, i + 1).equals("(")) {
                apertaPar += 1;
            }
            if (schermo.getText().toString().substring(i, i + 1).equals(")")) {
                chiusaPar += 1;
            }
        }
        if (apertaPar == chiusaPar || schermo.getText().toString().substring(lunghezza - 1, lunghezza).equals("(")) {
            upText("(");
        }
        if (chiusaPar < apertaPar && !schermo.getText().toString().substring(lunghezza - 1, lunghezza).equals("(")) {
            upText(")");
        }
        schermo.setSelection(cursorePos + 1);
    }

    public void divisione(View v) {
        upText("??");
    }

    public void moltiplicazione(View v) {
        upText("??");
    }

    public void add(View v) {
        upText("+");
    }

    public void sub(View v) {
        upText("-");
    }

    public void addsub(View v) {
        String user = schermo.getText().toString();
        String a = user.substring(0, 1);
        if (a.equals("-")) {
            clear(v);
            upText(user.substring(1));
        } else {
            clear(v);
            upText("-" + user);
        }
    }

    public void punto(View v) {
        upText(".");
        buttonpunto.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                upText(",");
                return true;
            }
        });
    }

    public void uguale(View v) {

        String user = schermo.getText().toString();
        risultato.setText(user);

        user = user.replaceAll("??", "/");
        user = user.replaceAll("??", "*");

        Expression exp = new Expression(user);
        String result = String.valueOf(exp.calculate()); //usa la libreria mxparser
        schermo.setText(result);
        schermo.setSelection(result.length());
    }

    public void spazio(View v) {
        int cursore = schermo.getSelectionStart();
        int textLen = schermo.getText().length();
        if (cursore != 0 && textLen != 0) {
            SpannableStringBuilder sel = (SpannableStringBuilder) schermo.getText();
            //replace sostituisce il testo compreso tra start e end con la stringa che vogliamo
            sel.replace(cursore - 1, cursore, "");
            schermo.setText(sel);
            schermo.setSelection(cursore - 1);
        }
    }

    public void coseno(View view) {

        upText("cos(");
        coseno.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                upText("cosh(");

                return true;
            }
        });


    }

    public void seno(View view) {
        upText("sin(");
        seno.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                upText("sinh(");

                return true;
            }
        });
    }

    public void percentuale(View view) {
        upText("%");
    }

    public void tangente(View view) {
        upText("tan(");
        tangente.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                upText("tanh(");

                return true;
            }
        });
    }

    public void arcseno(View view) {
        upText("arcsin(");
        arcseno.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                upText("arcsinh(");

                return true;
            }
        });
    }

    public void arccoseno(View view) {
        upText("arccos(");
        arccoseno.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                upText("arccosh(");

                return true;
            }
        });
    }

    public void arctangente(View view) {
        upText("arctan(");
        maggiore.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                upText("arctanh(");

                return true;
            }
        });
    }

    public void logaritmo_naturale(View view) {
        upText("ln(");
    }

    public void logaritmo(View view) {
        upText("log(");
    }

    public void radice(View view) {
        upText("sqrt(");
    }

    public void nepero(View view) {
        upText("e");
    }

    public void pigreco(View view) {
        upText("pi");
    }

    public void modulo(View view) {
        upText("abs(");
    }

    public void primo(View view) {
        upText("ispr(");
    }

    public void xQuadro(View view) {
        upText("^(2)");
    }

    public void scriviX(View view) {
        upText("x");
    }

    public void fattoriale(View view) {
        upText("!");
    }

    public void and(View view) {
        upText("&");
        and.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                upText("|");

                return true;
            }
        });
    }

    public void integrale(View view) {
        upText("int(");
    }

    public void derivata(View view) {
        upText("der(");
    }

    public void maggiore(View view) {
        upText(">");
        maggiore.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                upText("<");

                return true;
            }
        });
    }

    public void coefficientebinomiale(View view) {
        upText("C(");
    }

    public void Fibonacci(View view) {
        upText("Fib(");
    }


    public void fratto(View view) {

        try {
            uguale(view);
            double fratto = Double.parseDouble(schermo.getText().toString());
            String ris = String.valueOf(1 / fratto);
            schermo.setText(ris);
            schermo.setSelection(ris.length());
        }catch (NumberFormatException e){
            return;
        }catch(NullPointerException  e){
            return;
        }

    }
}
