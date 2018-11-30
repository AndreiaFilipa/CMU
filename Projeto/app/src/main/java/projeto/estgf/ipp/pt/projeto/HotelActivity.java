package projeto.estgf.ipp.pt.projeto;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class HotelActivity extends AppCompatActivity implements View.OnClickListener {
    private Button temp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel);

        temp = (Button) findViewById(R.id.buttonDateDialogHotel);
        temp.setOnClickListener(this);
    }


    public void showDatePickerDialog(View v) {

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
                        EditText departureDate = (EditText) findViewById(R.id.editTextDepartureDate);
                        departureDate.setText(sdf.format(cal.getTime()));

                    }
                }, cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH));
        newFragment.show();

    }

    public void onClick(View v) {
        if(v.getId() == R.id.buttonDateDialogHotel){
            showDatePickerDialog(v);
        }
    }

}
