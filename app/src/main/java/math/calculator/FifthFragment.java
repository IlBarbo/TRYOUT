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

public class FifthFragment extends Fragment {


    Spinner spinnerTemFrom, spinnerTemTo;
    protected EditText number;
    protected TextView risultato;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_fifth, container, false);


        final Button convertiTempe= v.findViewById(R.id.converti5);

        number=v.findViewById(R.id.TextNumber5);

        risultato=v.findViewById(R.id.risultatoconv5);

        //creo il primo spinner
        spinnerTemFrom = (Spinner) v.findViewById(R.id.spinner9);

        // Creating an Array Adapter to populate the spinner with the data in the string resources
        ArrayAdapter<CharSequence> spinnerAdapter3 = ArrayAdapter.createFromResource(getContext(),R.array.temperatura
                ,android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        spinnerAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinnerTemFrom.setAdapter(spinnerAdapter3);
        //creo il secondo spinner
        spinnerTemTo = (Spinner) v.findViewById(R.id.spinner10);

        // Creating an Array Adapter to populate the spinner with the data in the string resources
        ArrayAdapter<CharSequence> spinnerAdapter4 = ArrayAdapter.createFromResource(getContext(),R.array.temperatura
                ,android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        spinnerAdapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinnerTemTo.setAdapter(spinnerAdapter4);


        convertiTempe.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {


                double c = 0;
                try{
                    double d = Double.parseDouble(number.getText().toString());
                    number.setError("");
                    number.setError(null);

                    String stringTo = spinnerTemTo.getSelectedItem().toString();
                    Log.d("stringTo",stringTo);
                    String stringFrom = spinnerTemFrom.getSelectedItem().toString();
                    Log.d("stringFrom",stringFrom);
                    switch (stringFrom) {
                        case "Celsius":
                            switch (stringTo) {
                                case "Celsius":
                                    c = new UnitOf.Temperature().fromCelsius(d).toCelsius();

                                    break;
                                case "grado Fahrenheit":
                                    c = new UnitOf.Temperature().fromCelsius(d).toFahrenheit();
                                    break;
                                case "Kelvin":
                                    c = new UnitOf.Temperature().fromCelsius(d).toKelvin();
                                    break;
                                default:
                                    throw new IllegalStateException("Unexpected value: " + spinnerTemFrom);
                            }
                            break;
                        case "grado Fahrenheit":
                            switch (stringTo) {
                                case "Celsius":
                                    c = new UnitOf.Temperature().fromFahrenheit(d).toCelsius();

                                    break;
                                case "grado Fahrenheit":
                                    c = new UnitOf.Temperature().fromFahrenheit(d).toFahrenheit();
                                    break;
                                case "Kelvin":
                                    c = new UnitOf.Temperature().fromFahrenheit(d).toKelvin();
                                    break;
                                default:
                                    throw new IllegalStateException("Unexpected value: " + spinnerTemFrom);
                            }
                            break;
                        case "Kelvin":
                            switch (stringTo) {
                                case "Celsius":
                                    c = new UnitOf.Temperature().fromKelvin(d).toCelsius();

                                    break;
                                case "grado Fahrenheit":
                                    c = new UnitOf.Temperature().fromKelvin(d).toFahrenheit();
                                    break;
                                case "Kelvin":
                                    c = new UnitOf.Temperature().fromKelvin(d).toKelvin();
                                    break;
                                default:
                                    throw new IllegalStateException("Unexpected value: " + spinnerTemFrom);
                            }
                            break;

                    }
                    risultato.setText(String.valueOf(c));
                    DBHelperConv dbHelperConv= new DBHelperConv(getActivity());
                    dbHelperConv.insertDataConv(number.getText().toString().trim(),risultato.getText().toString().trim(),stringFrom,stringTo);

                }catch (NumberFormatException e){

                    number.setError("Valore non valido");
                    number.requestFocus();
                }

            }
        });

        return v;

    }

}