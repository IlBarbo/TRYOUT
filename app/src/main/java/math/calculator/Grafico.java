package math.calculator;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Grafico extends AppCompatActivity {
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grafico);
       drawerLayout=findViewById(R.id.drawer_layout);
    }
    public void ClickMenu(View view)
    {
        //deve
        //apro drawer
        openDrawer(drawerLayout);
    }
    public static void openDrawer (DrawerLayout drawerLayout){
        //apro drawer layout
        drawerLayout.openDrawer(GravityCompat.START);
    }
    public void ClickLogo(View view){
        closeDrawer(drawerLayout);
    }
    public static void closeDrawer (DrawerLayout drawerLayout){
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            //quando il drawer è aperto lo chiudo
            drawerLayout.closeDrawer(GravityCompat.START);

        }
    }
    public void ClickHome(View view){
        redirectActivity(this,Activity_calc.class);
    }
    public void Clickgrafico(View view){
        //crea l'activity
        recreate();
    }
    /*public void Clickcronologia(View view){
        redirectActivity(this,Cronologia.class);
    }*/
    public void ClickLogout(View view){
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
    public void onPause(){
        super.onPause();
        Activity_calc.closeDrawer(drawerLayout);
    }
    public static void redirectActivity (Activity activity, Class aClass){
        Intent intent = new Intent(activity, aClass);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        //start activity
        activity.startActivity(intent);

    }



}