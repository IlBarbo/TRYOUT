package math.calculator;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class SecondFragment extends Fragment {


    Spinner spinnerMassFrom,spinnerMassTo;
    //Button convertiLun;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_second, container, false);

        //creo il primo spinner
        spinnerMassFrom = (Spinner) v.findViewById(R.id.spinner3);

        // Creating an Array Adapter to populate the spinner with the data in the string resources
        ArrayAdapter<CharSequence> spinnerAdapter3 = ArrayAdapter.createFromResource(getContext(),R.array.massa
                ,android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        spinnerAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinnerMassFrom.setAdapter(spinnerAdapter3);
        //creo il secondo spinner
        spinnerMassTo = (Spinner) v.findViewById(R.id.spinner4);

        // Creating an Array Adapter to populate the spinner with the data in the string resources
        ArrayAdapter<CharSequence> spinnerAdapter4 = ArrayAdapter.createFromResource(getContext(),R.array.massa
                ,android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        spinnerAdapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinnerMassTo.setAdapter(spinnerAdapter4);


        return v;

    }

}