package math.calculator;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.digidemic.unitof.S;

import java.util.ArrayList;

public class CustomAdapterBase extends RecyclerView.Adapter<CustomAdapterBase.MyViewHolder>{
    private Context context;
    private ArrayList tbinario,tottale,tdecimale,tesadecimale,id;
    RowDeletionListener listener;
    String row_id;

    CustomAdapterBase(Context context,ArrayList tbinario,ArrayList tottale,ArrayList tdecimale,ArrayList tesadecimale,ArrayList id, RowDeletionListener deletionListener){
        this.context=context;
        this.tbinario=tbinario;
        this.tottale=tottale;
        this.tdecimale=tdecimale;
        this.tesadecimale=tesadecimale;
        this.id=id;
        this.listener = deletionListener;
    }

    //rappresenta un nuovo elemento
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup holder, int i) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.row_cronologiabase,holder,false);
        return new MyViewHolder(view, listener);
    }
    //visualizza i dati nella posizione specifica
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int i) {
        holder.tbinario.setText(String.valueOf(tbinario.get(i)));
        holder.tottale.setText(String.valueOf(tottale.get(i)));
        holder.tdecimale.setText(String.valueOf(tdecimale.get(i)));
        holder.tesadecimale.setText(String.valueOf(tesadecimale.get(i)));
        holder.id_txt.setText(String.valueOf(id.get(i)));

    }

    @Override
    public int getItemCount() {
        return tbinario.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tbinario,tottale,tdecimale,tesadecimale,id_txt;
        ImageButton deleteSingleData;
        DBHelperBase dbHelperbase;

        public MyViewHolder(@NonNull View itemView, RowDeletionListener listener) {
            super(itemView);
            dbHelperbase= new DBHelperBase(itemView.getContext());
            tbinario=itemView.findViewById(R.id.tbinario_txt);
            tottale=itemView.findViewById(R.id.tottale_txt);
            tdecimale=itemView.findViewById(R.id.tdecimale_txt);
            tesadecimale=itemView.findViewById(R.id.tesadecimale_txt);
            id_txt=itemView.findViewById(R.id.id_txt);
            deleteSingleData = itemView.findViewById(R.id.deletesingledata);
            deleteSingleData.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dbHelperbase.deleteSingleData(Integer.parseInt(id_txt.getText().toString()));
                    listener.onRowDeleted(id_txt.getText().toString());
                }
            });
        }
    }
}
