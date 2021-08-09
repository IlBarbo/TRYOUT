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

public class SecondFragment extends Fragment {


    Spinner spinnerMassFrom,spinnerMassTo;

    protected EditText number;
    protected TextView risultato;
    TextView messaggioerrore;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_second, container, false);

        final Button convertiMass= v.findViewById(R.id.converti1);

        number=v.findViewById(R.id.TextNumber2);
        messaggioerrore= v.findViewById(R.id.messaggioerrore1);
        risultato=v.findViewById(R.id.risultatoconv1);


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


        convertiMass.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {


                double c = 0;
                try{
                    double d = Double.parseDouble(number.getText().toString());
                    messaggioerrore.setVisibility(View.INVISIBLE);

                    String stringTo = spinnerMassTo.getSelectedItem().toString();
                    Log.d("stringTo",stringTo);
                    String stringFrom = spinnerMassFrom.getSelectedItem().toString();
                    Log.d("stringFrom",stringFrom);
                    switch (stringFrom) {
                        case "chilogrammi":
                            switch (stringTo) {
                                case "chilogrammi":
                                    c = new UnitOf.Mass().fromKilograms(d).toKilograms();
                                    break;
                                case "grammi":
                                    c = new UnitOf.Mass().fromKilograms(d).toGrams();
                                    break;
                                case "decagrammi":
                                    c = new UnitOf.Mass().fromKilograms(d).toDekagrams();

                                    break;
                                case "ettogrammo":
                                    c = new UnitOf.Mass().fromKilograms(d).toHectograms();

                                    break;
                                case "quintale":
                                    c = new UnitOf.Mass().fromKilograms(d).toQuintals();
                                    break;
                                case "tonnellata":
                                    c = new UnitOf.Mass().fromKilograms(d).toTonsUS();
                                    break;
                                case "decigrammo":
                                    c = new UnitOf.Mass().fromKilograms(d).toDecigrams();
                                    break;
                                case "centigrammo":
                                    c = new UnitOf.Mass().fromKilograms(d).toCentigrams();
                                    break;
                                case "milligrammo":
                                    c = new UnitOf.Mass().fromKilograms(d).toMilligrams();
                                    break;
                                case "microgrammo":
                                    c = new UnitOf.Mass().fromKilograms(d).toMicrograms();
                                    break;
                                case "nanogrammo":
                                    c = new UnitOf.Mass().fromKilograms(d).toNanograms();
                                    break;
                                case "picogrammo":
                                    c = new UnitOf.Mass().fromKilograms(d).toPicograms();
                                    break;
                                default:
                                    throw new IllegalStateException("Unexpected value: " + spinnerMassFrom);
                            }
                            break;
                        case "grammi":
                            switch (stringTo) {
                                case "chilogrammi":
                                    c = new UnitOf.Mass().fromGrams(d).toKilograms();
                                    break;
                                case "grammi":
                                    c = new UnitOf.Mass().fromGrams(d).toGrams();
                                    break;
                                case "decagrammi":
                                    c = new UnitOf.Mass().fromGrams(d).toDekagrams();

                                    break;
                                case "ettogrammo":
                                    c = new UnitOf.Mass().fromGrams(d).toHectograms();

                                    break;
                                case "quintale":
                                    c = new UnitOf.Mass().fromGrams(d).toQuintals();
                                    break;
                                case "tonnellata":
                                    c = new UnitOf.Mass().fromGrams(d).toTonsUS();
                                    break;
                                case "decigrammo":
                                    c = new UnitOf.Mass().fromGrams(d).toDecigrams();
                                    break;
                                case "centigrammo":
                                    c = new UnitOf.Mass().fromGrams(d).toCentigrams();
                                    break;
                                case "milligrammo":
                                    c = new UnitOf.Mass().fromGrams(d).toMilligrams();
                                    break;
                                case "microgrammo":
                                    c = new UnitOf.Mass().fromGrams(d).toMicrograms();
                                    break;
                                case "nanogrammo":
                                    c = new UnitOf.Mass().fromGrams(d).toNanograms();
                                    break;
                                case "picogrammo":
                                    c = new UnitOf.Mass().fromGrams(d).toPicograms();
                                    break;
                                default:
                                    throw new IllegalStateException("Unexpected value: " + spinnerMassFrom);
                            }
                            break;
                        case "decagrammi":
                            switch (stringTo) {
                                case "chilogrammi":
                                    c = new UnitOf.Mass().fromDekagrams(d).toKilograms();
                                    break;
                                case "grammi":
                                    c = new UnitOf.Mass().fromDekagrams(d).toGrams();
                                    break;
                                case "decagrammi":
                                    c = new UnitOf.Mass().fromDekagrams(d).toDekagrams();

                                    break;
                                case "ettogrammo":
                                    c = new UnitOf.Mass().fromDekagrams(d).toHectograms();

                                    break;
                                case "quintale":
                                    c = new UnitOf.Mass().fromDekagrams(d).toQuintals();
                                    break;
                                case "tonnellata":
                                    c = new UnitOf.Mass().fromDekagrams(d).toTonsUS();
                                    break;
                                case "decigrammo":
                                    c = new UnitOf.Mass().fromDekagrams(d).toDecigrams();
                                    break;
                                case "centigrammo":
                                    c = new UnitOf.Mass().fromDekagrams(d).toCentigrams();
                                    break;
                                case "milligrammo":
                                    c = new UnitOf.Mass().fromDekagrams(d).toMilligrams();
                                    break;
                                case "microgrammo":
                                    c = new UnitOf.Mass().fromDekagrams(d).toMicrograms();
                                    break;
                                case "nanogrammo":
                                    c = new UnitOf.Mass().fromDekagrams(d).toNanograms();
                                    break;
                                case "picogrammo":
                                    c = new UnitOf.Mass().fromDekagrams(d).toPicograms();
                                    break;
                                default:
                                    throw new IllegalStateException("Unexpected value: " + spinnerMassFrom);
                            }
                            break;
                        case "ETTOGRAMMO":
                            switch (stringTo) {
                                case "chilogrammi":
                                    c = new UnitOf.Mass().fromHectograms(d).toKilograms();
                                    break;
                                case "grammi":
                                    c = new UnitOf.Mass().fromHectograms(d).toGrams();
                                    break;
                                case "decagrammi":
                                    c = new UnitOf.Mass().fromHectograms(d).toDekagrams();

                                    break;
                                case "ettogrammo":
                                    c = new UnitOf.Mass().fromHectograms(d).toHectograms();

                                    break;
                                case "quintale":
                                    c = new UnitOf.Mass().fromHectograms(d).toQuintals();
                                    break;
                                case "tonnellata":
                                    c = new UnitOf.Mass().fromHectograms(d).toTonsUS();
                                    break;
                                case "decigrammo":
                                    c = new UnitOf.Mass().fromHectograms(d).toDecigrams();
                                    break;
                                case "centigrammo":
                                    c = new UnitOf.Mass().fromHectograms(d).toCentigrams();
                                    break;
                                case "milligrammo":
                                    c = new UnitOf.Mass().fromHectograms(d).toMilligrams();
                                    break;
                                case "microgrammo":
                                    c = new UnitOf.Mass().fromHectograms(d).toMicrograms();
                                    break;
                                case "nanogrammo":
                                    c = new UnitOf.Mass().fromHectograms(d).toNanograms();
                                    break;
                                case "picogrammo":
                                    c = new UnitOf.Mass().fromHectograms(d).toPicograms();
                                    break;
                                default:
                                    throw new IllegalStateException("Unexpected value: " + spinnerMassFrom);
                            }
                            break;
                        case "quintale":
                            switch (stringTo) {
                                case "chilogrammi":
                                    c = new UnitOf.Mass().fromQuintals(d).toKilograms();
                                    break;
                                case "grammi":
                                    c = new UnitOf.Mass().fromQuintals(d).toGrams();
                                    break;
                                case "decagrammi":
                                    c = new UnitOf.Mass().fromQuintals(d).toDekagrams();

                                    break;
                                case "ettogrammo":
                                    c = new UnitOf.Mass().fromQuintals(d).toHectograms();

                                    break;
                                case "quintale":
                                    c = new UnitOf.Mass().fromQuintals(d).toQuintals();
                                    break;
                                case "tonnellata":
                                    c = new UnitOf.Mass().fromQuintals(d).toTonsUS();
                                    break;
                                case "decigrammo":
                                    c = new UnitOf.Mass().fromQuintals(d).toDecigrams();
                                    break;
                                case "centigrammo":
                                    c = new UnitOf.Mass().fromQuintals(d).toCentigrams();
                                    break;
                                case "milligrammo":
                                    c = new UnitOf.Mass().fromQuintals(d).toMilligrams();
                                    break;
                                case "microgrammo":
                                    c = new UnitOf.Mass().fromQuintals(d).toMicrograms();
                                    break;
                                case "nanogrammo":
                                    c = new UnitOf.Mass().fromQuintals(d).toNanograms();
                                    break;
                                case "picogrammo":
                                    c = new UnitOf.Mass().fromQuintals(d).toPicograms();
                                    break;
                                default:
                                    throw new IllegalStateException("Unexpected value: " + spinnerMassFrom);
                            }
                            break;
                        case "tonnellata":
                            switch (stringTo) {
                                case "chilogrammi":
                                    c = new UnitOf.Mass().fromTonsUS(d).toKilograms();
                                    break;
                                case "grammi":
                                    c = new UnitOf.Mass().fromTonsUS(d).toGrams();
                                    break;
                                case "decagrammi":
                                    c = new UnitOf.Mass().fromTonsUS(d).toDekagrams();

                                    break;
                                case "ettogrammo":
                                    c = new UnitOf.Mass().fromTonsUS(d).toHectograms();

                                    break;
                                case "quintale":
                                    c = new UnitOf.Mass().fromTonsUS(d).toQuintals();
                                    break;
                                case "tonnellata":
                                    c = new UnitOf.Mass().fromTonsUS(d).toTonsUS();
                                    break;
                                case "decigrammo":
                                    c = new UnitOf.Mass().fromTonsUS(d).toDecigrams();
                                    break;
                                case "centigrammo":
                                    c = new UnitOf.Mass().fromTonsUS(d).toCentigrams();
                                    break;
                                case "milligrammo":
                                    c = new UnitOf.Mass().fromTonsUS(d).toMilligrams();
                                    break;
                                case "microgrammo":
                                    c = new UnitOf.Mass().fromTonsUS(d).toMicrograms();
                                    break;
                                case "nanogrammo":
                                    c = new UnitOf.Mass().fromTonsUS(d).toNanograms();
                                    break;
                                case "picogrammo":
                                    c = new UnitOf.Mass().fromTonsUS(d).toPicograms();
                                    break;
                                default:
                                    throw new IllegalStateException("Unexpected value: " + spinnerMassFrom);
                            }
                            break;
                        case "decigrammo":
                            switch (stringTo) {
                                case "chilogrammi":
                                    c = new UnitOf.Mass().fromDecigrams(d).toKilograms();
                                    break;
                                case "grammi":
                                    c = new UnitOf.Mass().fromDecigrams(d).toGrams();
                                    break;
                                case "decagrammi":
                                    c = new UnitOf.Mass().fromDecigrams(d).toDekagrams();

                                    break;
                                case "ettogrammo":
                                    c = new UnitOf.Mass().fromDecigrams(d).toHectograms();

                                    break;
                                case "quintale":
                                    c = new UnitOf.Mass().fromDecigrams(d).toQuintals();
                                    break;
                                case "tonnellata":
                                    c = new UnitOf.Mass().fromDecigrams(d).toTonsUS();
                                    break;
                                case "decigrammo":
                                    c = new UnitOf.Mass().fromDecigrams(d).toDecigrams();
                                    break;
                                case "centigrammo":
                                    c = new UnitOf.Mass().fromDecigrams(d).toCentigrams();
                                    break;
                                case "milligrammo":
                                    c = new UnitOf.Mass().fromDecigrams(d).toMilligrams();
                                    break;
                                case "microgrammo":
                                    c = new UnitOf.Mass().fromDecigrams(d).toMicrograms();
                                    break;
                                case "nanogrammo":
                                    c = new UnitOf.Mass().fromDecigrams(d).toNanograms();
                                    break;
                                case "picogrammo":
                                    c = new UnitOf.Mass().fromDecigrams(d).toPicograms();
                                    break;
                                default:
                                    throw new IllegalStateException("Unexpected value: " + spinnerMassFrom);
                            }
                            break;
                        case "centigrammo":
                            switch (stringTo) {
                                case "chilogrammi":
                                    c = new UnitOf.Mass().fromCentigrams(d).toKilograms();
                                    break;
                                case "grammi":
                                    c = new UnitOf.Mass().fromCentigrams(d).toGrams();
                                    break;
                                case "decagrammi":
                                    c = new UnitOf.Mass().fromCentigrams(d).toDekagrams();

                                    break;
                                case "ettogrammo":
                                    c = new UnitOf.Mass().fromCentigrams(d).toHectograms();

                                    break;
                                case "quintale":
                                    c = new UnitOf.Mass().fromCentigrams(d).toQuintals();
                                    break;
                                case "tonnellata":
                                    c = new UnitOf.Mass().fromCentigrams(d).toTonsUS();
                                    break;
                                case "decigrammo":
                                    c = new UnitOf.Mass().fromCentigrams(d).toDecigrams();
                                    break;
                                case "centigrammo":
                                    c = new UnitOf.Mass().fromCentigrams(d).toCentigrams();
                                    break;
                                case "milligrammo":
                                    c = new UnitOf.Mass().fromCentigrams(d).toMilligrams();
                                    break;
                                case "microgrammo":
                                    c = new UnitOf.Mass().fromCentigrams(d).toMicrograms();
                                    break;
                                case "nanogrammo":
                                    c = new UnitOf.Mass().fromCentigrams(d).toNanograms();
                                    break;
                                case "picogrammo":
                                    c = new UnitOf.Mass().fromCentigrams(d).toPicograms();
                                    break;
                                default:
                                    throw new IllegalStateException("Unexpected value: " + spinnerMassFrom);
                            }
                            break;
                        case "milligrammo":
                            switch (stringTo) {
                                case "chilogrammi":
                                    c = new UnitOf.Mass().fromMilligrams(d).toKilograms();
                                    break;
                                case "grammi":
                                    c = new UnitOf.Mass().fromMilligrams(d).toGrams();
                                    break;
                                case "decagrammi":
                                    c = new UnitOf.Mass().fromMilligrams(d).toDekagrams();

                                    break;
                                case "ettogrammo":
                                    c = new UnitOf.Mass().fromMilligrams(d).toHectograms();

                                    break;
                                case "quintale":
                                    c = new UnitOf.Mass().fromMilligrams(d).toQuintals();
                                    break;
                                case "tonnellata":
                                    c = new UnitOf.Mass().fromMilligrams(d).toTonsUS();
                                    break;
                                case "decigrammo":
                                    c = new UnitOf.Mass().fromMilligrams(d).toDecigrams();
                                    break;
                                case "centigrammo":
                                    c = new UnitOf.Mass().fromMilligrams(d).toCentigrams();
                                    break;
                                case "milligrammo":
                                    c = new UnitOf.Mass().fromMilligrams(d).toMilligrams();
                                    break;
                                case "microgrammo":
                                    c = new UnitOf.Mass().fromMilligrams(d).toMicrograms();
                                    break;
                                case "nanogrammo":
                                    c = new UnitOf.Mass().fromMilligrams(d).toNanograms();
                                    break;
                                case "picogrammo":
                                    c = new UnitOf.Mass().fromMilligrams(d).toPicograms();
                                    break;
                                default:
                                    throw new IllegalStateException("Unexpected value: " + spinnerMassFrom);
                            }
                            break;
                        case "microgrammo":
                            switch (stringTo) {
                                case "chilogrammi":
                                    c = new UnitOf.Mass().fromMicrograms(d).toKilograms();
                                    break;
                                case "grammi":
                                    c = new UnitOf.Mass().fromMicrograms(d).toGrams();
                                    break;
                                case "decagrammi":
                                    c = new UnitOf.Mass().fromMicrograms(d).toDekagrams();

                                    break;
                                case "ettogrammo":
                                    c = new UnitOf.Mass().fromMicrograms(d).toHectograms();

                                    break;
                                case "quintale":
                                    c = new UnitOf.Mass().fromMicrograms(d).toQuintals();
                                    break;
                                case "tonnellata":
                                    c = new UnitOf.Mass().fromMicrograms(d).toTonsUS();
                                    break;
                                case "decigrammo":
                                    c = new UnitOf.Mass().fromMicrograms(d).toDecigrams();
                                    break;
                                case "centigrammo":
                                    c = new UnitOf.Mass().fromMicrograms(d).toCentigrams();
                                    break;
                                case "milligrammo":
                                    c = new UnitOf.Mass().fromMicrograms(d).toMilligrams();
                                    break;
                                case "microgrammo":
                                    c = new UnitOf.Mass().fromMicrograms(d).toMicrograms();
                                    break;
                                case "nanogrammo":
                                    c = new UnitOf.Mass().fromMicrograms(d).toNanograms();
                                    break;
                                case "picogrammo":
                                    c = new UnitOf.Mass().fromMicrograms(d).toPicograms();
                                    break;
                                default:
                                    throw new IllegalStateException("Unexpected value: " + spinnerMassFrom);
                            }
                            break;
                        case "nanogrammo":
                            switch (stringTo) {
                                case "chilogrammi":
                                    c = new UnitOf.Mass().fromNanograms(d).toKilograms();
                                    break;
                                case "grammi":
                                    c = new UnitOf.Mass().fromNanograms(d).toGrams();
                                    break;
                                case "decagrammi":
                                    c = new UnitOf.Mass().fromNanograms(d).toDekagrams();

                                    break;
                                case "ettogrammo":
                                    c = new UnitOf.Mass().fromNanograms(d).toHectograms();

                                    break;
                                case "quintale":
                                    c = new UnitOf.Mass().fromNanograms(d).toQuintals();
                                    break;
                                case "tonnellata":
                                    c = new UnitOf.Mass().fromNanograms(d).toTonsUS();
                                    break;
                                case "decigrammo":
                                    c = new UnitOf.Mass().fromNanograms(d).toDecigrams();
                                    break;
                                case "centigrammo":
                                    c = new UnitOf.Mass().fromNanograms(d).toCentigrams();
                                    break;
                                case "milligrammo":
                                    c = new UnitOf.Mass().fromNanograms(d).toMilligrams();
                                    break;
                                case "microgrammo":
                                    c = new UnitOf.Mass().fromNanograms(d).toMicrograms();
                                    break;
                                case "nanogrammo":
                                    c = new UnitOf.Mass().fromNanograms(d).toNanograms();
                                    break;
                                case "picogrammo":
                                    c = new UnitOf.Mass().fromNanograms(d).toPicograms();
                                    break;
                                default:
                                    throw new IllegalStateException("Unexpected value: " + spinnerMassFrom);
                            }
                            break;
                        case "picogrammo":
                            switch (stringTo) {
                                case "chilogrammi":
                                    c = new UnitOf.Mass().fromPicograms(d).toKilograms();
                                    break;
                                case "grammi":
                                    c = new UnitOf.Mass().fromPicograms(d).toGrams();
                                    break;
                                case "decagrammi":
                                    c = new UnitOf.Mass().fromPicograms(d).toDekagrams();

                                    break;
                                case "ettogrammo":
                                    c = new UnitOf.Mass().fromPicograms(d).toHectograms();

                                    break;
                                case "quintale":
                                    c = new UnitOf.Mass().fromPicograms(d).toQuintals();
                                    break;
                                case "tonnellata":
                                    c = new UnitOf.Mass().fromPicograms(d).toTonsUS();
                                    break;
                                case "decigrammo":
                                    c = new UnitOf.Mass().fromPicograms(d).toDecigrams();
                                    break;
                                case "centigrammo":
                                    c = new UnitOf.Mass().fromPicograms(d).toCentigrams();
                                    break;
                                case "milligrammo":
                                    c = new UnitOf.Mass().fromPicograms(d).toMilligrams();
                                    break;
                                case "microgrammo":
                                    c = new UnitOf.Mass().fromPicograms(d).toMicrograms();
                                    break;
                                case "nanogrammo":
                                    c = new UnitOf.Mass().fromPicograms(d).toNanograms();
                                    break;
                                case "picogrammo":
                                    c = new UnitOf.Mass().fromPicograms(d).toPicograms();
                                    break;
                                default:
                                    throw new IllegalStateException("Unexpected value: " + spinnerMassFrom);
                            }
                            break;
                    }
                    risultato.setText(String.valueOf(c));
                    DBHelperConv dbHelperConv= new DBHelperConv(getActivity());
                    dbHelperConv.insertDataConv(number.getText().toString().trim(),risultato.getText().toString().trim());

                }catch (NumberFormatException e){

                    messaggioerrore.setVisibility(View.VISIBLE);
                }

            }
        });

        return v;

    }

}