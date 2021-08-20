package math.calculator;

import android.app.Activity;
import android.media.Image;
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


public class ThirdFragment extends Fragment {


    Spinner spinnerTempFrom, spinnerTempTo;

    protected EditText number;
    protected TextView risultato;
    protected ImageButton clear;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_third, container, false);
        final Button convertiTemp= v.findViewById(R.id.converti3);

        number=v.findViewById(R.id.TextNumber3);
        risultato=v.findViewById(R.id.risultatoconv3);
        clear=v.findViewById(R.id.deletesingle);
        //creo il primo spinner
        spinnerTempFrom = (Spinner) v.findViewById(R.id.spinner5);

        // Creating an Array Adapter to populate the spinner with the data in the string resources
        ArrayAdapter<CharSequence> spinnerAdapter3 = ArrayAdapter.createFromResource(getContext(),R.array.tempo
                ,android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        spinnerAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinnerTempFrom.setAdapter(spinnerAdapter3);
        //creo il secondo spinner
        spinnerTempTo = (Spinner) v.findViewById(R.id.spinner6);

        // Creating an Array Adapter to populate the spinner with the data in the string resources
        ArrayAdapter<CharSequence> spinnerAdapter4 = ArrayAdapter.createFromResource(getContext(),R.array.tempo
                ,android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        spinnerAdapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinnerTempTo.setAdapter(spinnerAdapter4);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number.setError("");
                number.setError(null);
                number.setText("");
                risultato.setText("");
            }
        });
        convertiTemp.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                hideSoftKeyboard((Activity) getContext());
                return false;
            }
        });
        convertiTemp.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {


                double c = 0;
                try{
                    double d = Double.parseDouble(number.getText().toString());
                    number.setError("");
                    number.setError(null);

                    String stringTo = spinnerTempTo.getSelectedItem().toString();
                    Log.d("stringTo",stringTo);
                    String stringFrom = spinnerTempFrom.getSelectedItem().toString();
                    Log.d("stringFrom",stringFrom);
                    switch (stringFrom) {
                        case "millisecondi":
                            switch (stringTo) {
                                case "millisecondi":
                                    c = new UnitOf.Time().fromMilliseconds(d).toMilliseconds();

                                    break;
                                case "secondi":
                                    c = new UnitOf.Time().fromMilliseconds(d).toSeconds();
                                    break;
                                case "minuti":
                                    c = new UnitOf.Time().fromMilliseconds(d).toMinutes();

                                    break;
                                case "ore":
                                    c = new UnitOf.Time().fromMilliseconds(d).toHours();

                                    break;
                                case "giorni":
                                    c = new UnitOf.Time().fromMilliseconds(d).toDays();
                                    break;
                                case "anni":
                                    c = new UnitOf.Time().fromMilliseconds(d).toYears();
                                    break;
                                default:
                                    throw new IllegalStateException("Unexpected value: " + spinnerTempFrom);
                            }
                            break;
                        case "secondi":
                            switch (stringTo) {
                                case "millisecondi":
                                    c = new UnitOf.Time().fromSeconds(d).toMilliseconds();

                                    break;
                                case "secondi":
                                    c = new UnitOf.Time().fromSeconds(d).toSeconds();
                                    break;
                                case "minuti":
                                    c = new UnitOf.Time().fromSeconds(d).toMinutes();

                                    break;
                                case "ore":
                                    c = new UnitOf.Time().fromSeconds(d).toHours();

                                    break;
                                case "giorni":
                                    c = new UnitOf.Time().fromSeconds(d).toDays();
                                    break;
                                case "anni":
                                    c = new UnitOf.Time().fromSeconds(d).toYears();
                                    break;
                                default:
                                    throw new IllegalStateException("Unexpected value: " + spinnerTempFrom);
                            }
                            break;
                        case "minuti":
                            switch (stringTo) {
                                case "millisecondi":
                                    c = new UnitOf.Time().fromMinutes(d).toMilliseconds();

                                    break;
                                case "secondi":
                                    c = new UnitOf.Time().fromMinutes(d).toSeconds();
                                    break;
                                case "minuti":
                                    c = new UnitOf.Time().fromMinutes(d).toMinutes();

                                    break;
                                case "ore":
                                    c = new UnitOf.Time().fromMinutes(d).toHours();

                                    break;
                                case "giorni":
                                    c = new UnitOf.Time().fromMinutes(d).toDays();
                                    break;
                                case "anni":
                                    c = new UnitOf.Time().fromMinutes(d).toYears();
                                    break;
                                default:
                                    throw new IllegalStateException("Unexpected value: " + spinnerTempFrom);
                            }
                            break;
                        case "ore":
                            switch (stringTo) {
                                case "millisecondi":
                                    c = new UnitOf.Time().fromHours(d).toMilliseconds();

                                    break;
                                case "secondi":
                                    c = new UnitOf.Time().fromHours(d).toSeconds();
                                    break;
                                case "minuti":
                                    c = new UnitOf.Time().fromHours(d).toMinutes();

                                    break;
                                case "ore":
                                    c = new UnitOf.Time().fromHours(d).toHours();

                                    break;
                                case "giorni":
                                    c = new UnitOf.Time().fromHours(d).toDays();
                                    break;
                                case "anni":
                                    c = new UnitOf.Time().fromHours(d).toYears();
                                    break;
                                default:
                                    throw new IllegalStateException("Unexpected value: " + spinnerTempFrom);
                            }
                            break;
                        case "giorni":
                            switch (stringTo) {
                                case "millisecondi":
                                    c = new UnitOf.Time().fromDays(d).toMilliseconds();

                                    break;
                                case "secondi":
                                    c = new UnitOf.Time().fromDays(d).toSeconds();
                                    break;
                                case "minuti":
                                    c = new UnitOf.Time().fromDays(d).toMinutes();

                                    break;
                                case "ore":
                                    c = new UnitOf.Time().fromDays(d).toHours();

                                    break;
                                case "giorni":
                                    c = new UnitOf.Time().fromDays(d).toDays();
                                    break;
                                case "anni":
                                    c = new UnitOf.Time().fromDays(d).toYears();
                                    break;
                                default:
                                    throw new IllegalStateException("Unexpected value: " + spinnerTempFrom);
                            }
                            break;
                        case "anni":
                            switch (stringTo) {
                                case "millisecondi":
                                    c = new UnitOf.Time().fromYears(d).toMilliseconds();

                                    break;
                                case "secondi":
                                    c = new UnitOf.Time().fromYears(d).toSeconds();
                                    break;
                                case "minuti":
                                    c = new UnitOf.Time().fromYears(d).toMinutes();

                                    break;
                                case "ore":
                                    c = new UnitOf.Time().fromYears(d).toHours();

                                    break;
                                case "giorni":
                                    c = new UnitOf.Time().fromYears(d).toDays();
                                    break;
                                case "anni":
                                    c = new UnitOf.Time().fromYears(d).toYears();
                                    break;
                                default:
                                    throw new IllegalStateException("Unexpected value: " + spinnerTempFrom);
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