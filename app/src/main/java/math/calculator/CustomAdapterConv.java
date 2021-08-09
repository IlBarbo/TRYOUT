package math.calculator;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapterConv extends RecyclerView.Adapter<CustomAdapterConv.MyViewHolder>{



        private Context context;
        private ArrayList fromnum, tonum;

    CustomAdapterConv(Context context, ArrayList fromnum, ArrayList tonum) {
            this.context = context;
            this.fromnum = fromnum;
            this.tonum = tonum;
        }

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup holder, int i) {
            LayoutInflater inflater = LayoutInflater.from(context);
            View view = inflater.inflate(R.layout.row_cronologia_conv, holder, false);
            return new MyViewHolder(view);
        }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int i) {
        holder.from_txt.setText(String.valueOf(fromnum.get(i)));
        holder.to_txt.setText(String.valueOf(tonum.get(i)));
    }



        @Override
        public int getItemCount() {
            return fromnum.size();
        }


        public class MyViewHolder extends RecyclerView.ViewHolder {
            TextView from_txt, to_txt;

            public MyViewHolder(@NonNull View itemView) {
                super(itemView);
                from_txt = itemView.findViewById(R.id.from_txt);
              to_txt = itemView.findViewById(R.id.to_txt);
            }
        }
    }

