package math.calculator;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import static androidx.navigation.fragment.NavHostFragment.findNavController;

public class Convertitore extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    private static final String SHARED_PREF_NAME="save nickname";
    private static final String KEY_NICKNAME="nickname";
    DrawerLayout drawerLayout;
    ImageView cronologiaButton;
    private TextView title;


    @Override
    protected  void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convertitore);
        //menu
        drawerLayout=findViewById(R.id.drawer_layout);

        title=findViewById(R.id.benvenuto);
        //BottomNavigationView
        BottomNavigationView bottomNavigationView= findViewById(R.id.bottomNavigationView);
        NavController navController= Navigation.findNavController(this,R.id.fragment);
        NavigationUI.setupWithNavController(bottomNavigationView,navController);
        //cronologia
        cronologiaButton=findViewById(R.id.cronologia);
        cronologiaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Convertitore.this, CronologiaConv.class);
                startActivity(intent);
            }

        });
        sharedPreferences= getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        String name = sharedPreferences.getString(KEY_NICKNAME, null);
        title.setText("Ciao " + name);

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
    public void clickHome (View view)
    {
        redirectActivity(this, Activity_calc.class);
    }

    public void clickConvertitore (View view){
        recreate();
    }
    public void clickConvertitorebase (View view){
        redirectActivity(this, ConvertitoreBase.class);
    }

    public void clickGrafico (View view){
        redirectActivity(this, Grafico.class);
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

}