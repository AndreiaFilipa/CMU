package projeto.estgf.ipp.pt.projeto;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class VooHotelActivity extends AppCompatActivity implements View.OnClickListener {
    private Button temp;
    private Button temp1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voo_hotel);


        String[] aeroporto = getResources().getStringArray(R.array.airports);
        ArrayAdapter<String> originAirportsAdapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, aeroporto);
        ArrayAdapter<String> destinationAirportsAdapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, aeroporto);
        AutoCompleteTextView origins = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextViewAirportsOrigin1);
        AutoCompleteTextView destinations = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextViewAirportsDestination1);
        origins.setAdapter(originAirportsAdapter);
        destinations.setAdapter(destinationAirportsAdapter);

        temp = (Button) findViewById(R.id.buttonDateDialogDeparture);
        temp.setOnClickListener(this);
        temp1 = (Button) findViewById(R.id.buttonDateDialogArrive);
        temp1.setOnClickListener(this);
    }


    public void showDatePickerDialog(View v, final int TextViewID) {
        Calendar cal = Calendar.getInstance();
        AlertDialog newFragment = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        Calendar cal = Calendar.getInstance();
                        cal.set(Calendar.YEAR, year);
                        cal.set(Calendar.MONTH, monthOfYear);
                        cal.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                        DateFormat sdf = SimpleDateFormat.getDateInstance();
                        EditText departureDate = (EditText) findViewById(TextViewID);
                        departureDate.setText(sdf.format(cal.getTime()));
                    }
                }, cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH));
        newFragment.show();

    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.buttonDateDialogDeparture){
            showDatePickerDialog(v,R.id.editTextDepartureDate);
        }else if(v.getId() == R.id.buttonDateDialogArrive){
            showDatePickerDialog(v,R.id.editTextArriveDate);
        }
    }
}
