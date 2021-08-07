package math.calculator;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder>{
    private Context context;
   private ArrayList espressione,risultato;
    CustomAdapter(Context context,ArrayList espressione,ArrayList risultato){
        this.context=context;
        this.espressione=espressione;
        this.risultato=risultato;
    }
   @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup holder, int i) {
       LayoutInflater inflater=LayoutInflater.from(context);
       View view=inflater.inflate(R.layout.row_cronologia,holder,false);
       return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  MyViewHolder holder, int i) {
    holder.espressione_txt.setText(String.valueOf(espressione.get(i)));
        holder.risultato_txt.setText(String.valueOf(risultato.get(i)));

    }

    @Override
    public int getItemCount() {
     return espressione.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView espressione_txt,risultato_txt;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            espressione_txt=itemView.findViewById(R.id.espressione_txt);
            risultato_txt=itemView.findViewById(R.id.risultato_txt);
        }
    }
}
