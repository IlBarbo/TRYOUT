package math.calculator;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.wifi.aware.IdentityChangedListener;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.digidemic.unitof.T;

import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder>{
    private Context context;
    private ArrayList espressione,risultato,id;
    RowDeletionListener listener;
    String row_id;



    CustomAdapter(Context context,ArrayList espressione,ArrayList risultato,ArrayList id, RowDeletionListener deletionListener){
        this.context=context;
        this.espressione=espressione;
        this.risultato=risultato;
        this.id=id;
        this.listener = deletionListener;
    }

    //rappresenta un nuovo elemento
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup holder, int i) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.row_cronologia,holder,false);
        return new MyViewHolder(view, listener);
    }
    //visualizza i dati nella posizione specifica
    @Override
    public void onBindViewHolder(@NonNull  MyViewHolder holder, int i) {
        holder.espressione_txt.setText(String.valueOf(espressione.get(i)));
        holder.risultato_txt.setText(String.valueOf(risultato.get(i)));
        holder.id_txt.setText(String.valueOf(id.get(i)));


    }

    @Override
    public int getItemCount() {
        return espressione.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView espressione_txt,risultato_txt,id_txt;
        ImageButton deleteSingleData;
        DBHelper dbHelper;

        public MyViewHolder(@NonNull View itemView, RowDeletionListener listener) {
            super(itemView);
            dbHelper= new DBHelper(itemView.getContext());
            espressione_txt=itemView.findViewById(R.id.espressione_txt);
            risultato_txt=itemView.findViewById(R.id.risultato_txt);
            id_txt=itemView.findViewById(R.id.id_txt);
            deleteSingleData = itemView.findViewById(R.id.deletesingledata);
            deleteSingleData.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dbHelper.deleteSingleData(Integer.parseInt(id_txt.getText().toString()));
                    listener.onRowDeleted(id_txt.getText().toString());

                }
            });
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent=new Intent(itemView.getContext(),Activity_calc.class);
                    try {
                       intent.putExtra("espressione",espressione.get(id.indexOf(id_txt.getText().toString())).toString());

                    } catch (NumberFormatException e){
                    return;
                    }catch (IndexOutOfBoundsException e) {
                        return;
                    }

                    context.startActivity(intent);
                }
            });
        }
    }
}