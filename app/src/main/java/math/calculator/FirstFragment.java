package math.calculator;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import static android.widget.ArrayAdapter.createFromResource;


public class FirstFragment extends Fragment {


Spinner spinnerLunFrom,spinnerLunTo;
//Button convertiLun;


        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

            View v = inflater.inflate(R.layout.fragment_first, container, false);

            //creo il primo spinner
             spinnerLunFrom = (Spinner) v.findViewById(R.id.spinner1);

            // Creating an Array Adapter to populate the spinner with the data in the string resources
            ArrayAdapter<CharSequence> spinnerAdapter = ArrayAdapter.createFromResource(getContext(),R.array.lunghezza
                    ,android.R.layout.simple_spinner_item);
            // Specify the layout to use when the list of choices appears
            spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            // Apply the adapter to the spinner
            spinnerLunFrom.setAdapter(spinnerAdapter);
            //creo il secondo spinner
            spinnerLunTo = (Spinner) v.findViewById(R.id.spinner2);

            // Creating an Array Adapter to populate the spinner with the data in the string resources
            ArrayAdapter<CharSequence> spinnerAdapter1 = ArrayAdapter.createFromResource(getContext(),R.array.lunghezza
                    ,android.R.layout.simple_spinner_item);
            // Specify the layout to use when the list of choices appears
            spinnerAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            // Apply the adapter to the spinner
            spinnerLunTo.setAdapter(spinnerAdapter1);


            return v;

        }


}