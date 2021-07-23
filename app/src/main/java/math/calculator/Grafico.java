package math.calculator;

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
        //apro drawer
        Activity_calc.openDrawer(drawerLayout);
    }
    public void ClickLogo(View view){
        Activity_calc.closeDrawer(drawerLayout);
    }
    public void ClickHome(View view){
        Activity_calc.redirectActivity(this,Activity_calc.class);
    }
    public void Clickgrafico(View view){
        //crea l'activity
        recreate();
    }
    public void Clickcronologia(View view){
        Activity_calc.redirectActivity(this,Cronologia.class);
    }
    public void ClickLogout(View view){
        Activity_calc.logout(this);
    }
    public void onPause(){
        super.onPause();
        Activity_calc.closeDrawer(drawerLayout);
    }



}