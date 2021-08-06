package math.calculator;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.digidemic.unitof.UnitOf;


public class FirstFragment extends Fragment {


Spinner spinnerLunFrom,spinnerLunTo;

    protected EditText number;
    protected TextView risultato;
    TextView messaggioerrore;
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


            View v = inflater.inflate(R.layout.fragment_first, container, false);

            final Button convertiLun= v.findViewById(R.id.converti);

            number=v.findViewById(R.id.TextNumber1);
            messaggioerrore= v.findViewById(R.id.messaggioerrore);
            risultato=v.findViewById(R.id.risultatoconv);



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



            convertiLun.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {

                    double c = 0;
                    try{
                        double d = Double.parseDouble(number.getText().toString());
                        messaggioerrore.setVisibility(View.INVISIBLE);

                        String stringTo = spinnerLunTo.getSelectedItem().toString();
                        Log.d("stringTo",stringTo);
                        String stringFrom = spinnerLunFrom.getSelectedItem().toString();
                        Log.d("stringFrom",stringFrom);
                        switch (stringFrom) {
                            case "metri":
                                switch (stringTo) {
                                    case "metri":
                                        c = new UnitOf.Length().fromMeters(d).toMeters();

                                        break;
                                    case "centimetri":
                                        c = new UnitOf.Length().fromMeters(d).toCentimeters();
                                        break;
                                    case "millimetri":
                                        c = new UnitOf.Length().fromMeters(d).toMillimeters();

                                        break;
                                    case "miglio":
                                        c = new UnitOf.Length().fromMeters(d).toMiles();

                                        break;
                                    case "feet":
                                        c = new UnitOf.Length().fromMeters(d).toFeet();
                                        break;
                                    case "inches":
                                        c = new UnitOf.Length().fromMeters(d).toInches();
                                        break;
                                    default:
                                        throw new IllegalStateException("Unexpected value: " + spinnerLunFrom);
                                }
                                break;
                            case "centimetri":
                                switch (stringTo) {
                                    case "metri":
                                        c = new UnitOf.Length().fromCentimeters(d).toMeters();

                                        break;
                                    case "centimetri":
                                        c = new UnitOf.Length().fromCentimeters(d).toCentimeters();
                                        break;
                                    case "millimetri":
                                        c = new UnitOf.Length().fromCentimeters(d).toMillimeters();

                                        break;
                                    case "miglio":
                                        c = new UnitOf.Length().fromCentimeters(d).toMiles();

                                        break;
                                    case "feet":
                                        c = new UnitOf.Length().fromCentimeters(d).toFeet();
                                        break;
                                    case "inches":
                                        c = new UnitOf.Length().fromCentimeters(d).toInches();
                                        break;
                                    default:
                                        throw new IllegalStateException("Unexpected value: " + spinnerLunFrom);
                                }
                                break;
                            case "millimetri":
                                switch (stringTo) {
                                    case "metri":
                                        c = new UnitOf.Length().fromMillimeters(d).toMeters();

                                        break;
                                    case "centimetri":
                                        c = new UnitOf.Length().fromMillimeters(d).toCentimeters();
                                        break;
                                    case "millimetri":
                                        c = new UnitOf.Length().fromMillimeters(d).toMillimeters();

                                        break;
                                    case "miglio":
                                        c = new UnitOf.Length().fromMillimeters(d).toMiles();

                                        break;
                                    case "feet":
                                        c = new UnitOf.Length().fromMillimeters(d).toFeet();
                                        break;
                                    case "inches":
                                        c = new UnitOf.Length().fromMillimeters(d).toInches();
                                        break;
                                    default:
                                        throw new IllegalStateException("Unexpected value: " + spinnerLunFrom);
                                }
                                break;
                            case "miglio":
                                switch (stringTo) {
                                    case "metri":
                                        c = new UnitOf.Length().fromMiles(d).toMeters();

                                        break;
                                    case "centimetri":
                                        c = new UnitOf.Length().fromMiles(d).toCentimeters();
                                        break;
                                    case "millimetri":
                                        c = new UnitOf.Length().fromMiles(d).toMillimeters();

                                        break;
                                    case "miglio":
                                        c = new UnitOf.Length().fromMiles(d).toMiles();

                                        break;
                                    case "feet":
                                        c = new UnitOf.Length().fromMiles(d).toFeet();
                                        break;
                                    case "inches":
                                        c = new UnitOf.Length().fromMiles(d).toInches();
                                        break;
                                    default:
                                        throw new IllegalStateException("Unexpected value: " + spinnerLunFrom);
                                }
                                break;
                            case "feet":
                                switch (stringTo) {
                                    case "metri":
                                        c = new UnitOf.Length().fromFeet(d).toMeters();

                                        break;
                                    case "centimetri":
                                        c = new UnitOf.Length().fromFeet(d).toCentimeters();
                                        break;
                                    case "millimetri":
                                        c = new UnitOf.Length().fromFeet(d).toMillimeters();

                                        break;
                                    case "miglio":
                                        c = new UnitOf.Length().fromFeet(d).toMiles();

                                        break;
                                    case "feet":
                                        c = new UnitOf.Length().fromFeet(d).toFeet();
                                        break;
                                    case "inches":
                                        c = new UnitOf.Length().fromFeet(d).toInches();
                                        break;
                                    default:
                                        throw new IllegalStateException("Unexpected value: " + spinnerLunFrom);
                                }
                                break;
                            case "inches":
                                switch (stringTo) {
                                    case "metri":
                                        c = new UnitOf.Length().fromInches(d).toMeters();

                                        break;
                                    case "centimetri":
                                        c = new UnitOf.Length().fromInches(d).toCentimeters();
                                        break;
                                    case "millimetri":
                                        c = new UnitOf.Length().fromInches(d).toMillimeters();

                                        break;
                                    case "miglio":
                                        c = new UnitOf.Length().fromInches(d).toMiles();

                                        break;
                                    case "feet":
                                        c = new UnitOf.Length().fromInches(d).toFeet();
                                        break;
                                    case "inches":
                                        c = new UnitOf.Length().fromInches(d).toInches();
                                        break;
                                    default:
                                        throw new IllegalStateException("Unexpected value: " + spinnerLunFrom);
                                }
                                break;
                        }
                        risultato.setText(String.valueOf(c));

                    }catch (NumberFormatException e){

                        messaggioerrore.setVisibility(View.VISIBLE);
                    }

                }
            });

            return v;

        }





}