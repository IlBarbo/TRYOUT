package math.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import com.digidemic.unitof.UnitOf;

public class FourthFragment extends Fragment {


    Spinner spinnerAngFrom, spinnerAngTo;
    protected EditText number;
    protected TextView risultato;
    protected ImageButton clear;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_fourth, container, false);

        final Button convertiAngolo= v.findViewById(R.id.converti4);

        number=v.findViewById(R.id.TextNumber4);
        risultato=v.findViewById(R.id.risultatoconv4);
        clear=v.findViewById(R.id.deletesingle);
        //creo il primo spinner
        spinnerAngFrom = (Spinner) v.findViewById(R.id.spinner7);

        // Creating an Array Adapter to populate the spinner with the data in the string resources
        ArrayAdapter<CharSequence> spinnerAdapter3 = ArrayAdapter.createFromResource(getContext(),R.array.angolo
                ,android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        spinnerAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinnerAngFrom.setAdapter(spinnerAdapter3);
        //creo il secondo spinner
        spinnerAngTo = (Spinner) v.findViewById(R.id.spinner8);

        // Creating an Array Adapter to populate the spinner with the data in the string resources
        ArrayAdapter<CharSequence> spinnerAdapter4 = ArrayAdapter.createFromResource(getContext(),R.array.angolo
                ,android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        spinnerAdapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinnerAngTo.setAdapter(spinnerAdapter4);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number.setError("");
                number.setError(null);
                number.setText("");
                risultato.setText("");
            }
        });
        convertiAngolo.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                hideSoftKeyboard((Activity) getContext());
                return false;
            }
        });
        convertiAngolo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {


                double c = 0;
                try{
                    double d = Double.parseDouble(number.getText().toString());
                    number.setError("");
                    number.setError(null);

                    String stringTo = spinnerAngTo.getSelectedItem().toString();
                    Log.d("stringTo",stringTo);
                    String stringFrom = spinnerAngFrom.getSelectedItem().toString();
                    Log.d("stringFrom",stringFrom);
                    switch (stringFrom) {
                        case "gradi":
                            switch (stringTo) {
                                case "gradi":
                                    c = new UnitOf.Angle().fromDegrees(d).toDegrees();

                                    break;
                                case "radianti":
                                    c = new UnitOf.Angle().fromDegrees(d).toRadians();

                                    break;

                                case "sestante":
                                    c = new UnitOf.Angle().fromDegrees(d).toSextants();

                                    break;
                                case "giro":
                                    c = new UnitOf.Angle().fromDegrees(d).toCircles();
                                    break;
                                case "mils":
                                    c = new UnitOf.Angle().fromDegrees(d).toMils();
                                    break;
                                default:
                                    throw new IllegalStateException("Unexpected value: " + spinnerAngFrom);
                            }
                            break;
                        case "radianti":
                            switch (stringTo) {
                                case "gradi":
                                    c = new UnitOf.Angle().fromRadians(d).toDegrees();

                                    break;
                                case "radianti":
                                    c = new UnitOf.Angle().fromRadians(d).toRadians();

                                    break;

                                case "sestante":
                                    c = new UnitOf.Angle().fromRadians(d).toSextants();

                                    break;
                                case "giro":
                                    c = new UnitOf.Angle().fromRadians(d).toCircles();
                                    break;
                                case "mils":
                                    c = new UnitOf.Angle().fromRadians(d).toMils();
                                    break;
                                default:
                                    throw new IllegalStateException("Unexpected value: " + spinnerAngFrom);
                            }
                            break;
                        case "sestante":
                            switch (stringTo) {
                                case "gradi":
                                    c = new UnitOf.Angle().fromSextants(d).toDegrees();

                                    break;
                                case "radianti":
                                    c = new UnitOf.Angle().fromSextants(d).toRadians();

                                    break;

                                case "sestante":
                                    c = new UnitOf.Angle().fromSextants(d).toSextants();

                                    break;
                                case "giro":
                                    c = new UnitOf.Angle().fromSextants(d).toCircles();
                                    break;
                                case "mils":
                                    c = new UnitOf.Angle().fromSextants(d).toMils();
                                    break;
                                default:
                                    throw new IllegalStateException("Unexpected value: " + spinnerAngFrom);
                            }
                            break;
                        case "giro":
                            switch (stringTo) {
                                case "gradi":
                                    c = new UnitOf.Angle().fromCircles(d).toDegrees();

                                    break;
                                case "radianti":
                                    c = new UnitOf.Angle().fromCircles(d).toRadians();

                                    break;

                                case "sestante":
                                    c = new UnitOf.Angle().fromCircles(d).toSextants();

                                    break;
                                case "giro":
                                    c = new UnitOf.Angle().fromCircles(d).toCircles();
                                    break;
                                case "mils":
                                    c = new UnitOf.Angle().fromCircles(d).toMils();
                                    break;
                                default:
                                    throw new IllegalStateException("Unexpected value: " + spinnerAngFrom);
                            }
                            break;
                        case "mils":
                            switch (stringTo) {
                                case "gradi":
                                    c = new UnitOf.Angle().fromMils(d).toDegrees();

                                    break;
                                case "radianti":
                                    c = new UnitOf.Angle().fromMils(d).toRadians();

                                    break;

                                case "sestante":
                                    c = new UnitOf.Angle().fromMils(d).toSextants();

                                    break;
                                case "giro":
                                    c = new UnitOf.Angle().fromMils(d).toCircles();
                                    break;
                                case "mils":
                                    c = new UnitOf.Angle().fromMils(d).toMils();
                                    break;
                                default:
                                    throw new IllegalStateException("Unexpected value: " + spinnerAngFrom);
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
    public static void hideSoftKeyboard(Activity activity)
    {

        if(activity!= null && activity.getCurrentFocus() != null && activity.getCurrentFocus().getWindowToken() != null)
        {
            InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
        }
    }
}