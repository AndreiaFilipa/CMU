package projeto.estgf.ipp.pt.projeto;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class TabOne extends Fragment implements View.OnClickListener {
    private Button temp;
    private Button temp1;
    private Context context;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.context = getActivity();

    }


    public void showDatePickerDialog(View v, final int TextViewID) {
        Calendar cal = Calendar.getInstance();
        AlertDialog newFragment = new DatePickerDialog(context,
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        Calendar cal = Calendar.getInstance();
                        cal.set(Calendar.YEAR, year);
                        cal.set(Calendar.MONTH, monthOfYear);
                        cal.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                        DateFormat sdf = SimpleDateFormat.getDateInstance();
                        EditText departureDate = (EditText) ((Activity)context).findViewById(TextViewID);
                        departureDate.setText(sdf.format(cal.getTime()));
                    }
                }, cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH));
        newFragment.show();

    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.buttonDateDialogDepartureVoo){
            showDatePickerDialog(v,R.id.editTextDepartureDateVoo);
        }else if(v.getId() == R.id.buttonDateDialogArriveVoo){
            showDatePickerDialog(v, R.id.editTextArriveDateVoo);
        }
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.tab_one, container, false);

        String[] aeroporto = getResources().getStringArray(R.array.airports);
        ArrayAdapter<String> originAirportsAdapter = new ArrayAdapter<String>(context, R.layout.support_simple_spinner_dropdown_item, aeroporto);
        ArrayAdapter<String> destinationAirportsAdapter = new ArrayAdapter<String>(context, R.layout.support_simple_spinner_dropdown_item, aeroporto);
        AutoCompleteTextView origins = (AutoCompleteTextView) view.findViewById(R.id.autoCompleteTextViewAirportsOriginVoo);
        AutoCompleteTextView destinations = (AutoCompleteTextView) view.findViewById(R.id.autoCompleteTextViewAirportsDestinationVoo);
        origins.setAdapter(originAirportsAdapter);
        destinations.setAdapter(destinationAirportsAdapter);


        temp = (Button) view.findViewById(R.id.buttonDateDialogDepartureVoo);
        temp.setOnClickListener(this);
        temp1 = (Button) view.findViewById(R.id.buttonDateDialogArriveVoo);
        temp1.setOnClickListener(this);

        return view;
    }


}
