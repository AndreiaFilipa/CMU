package projeto.estgf.ipp.pt.projeto;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
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

import projeto.estgf.ipp.pt.projeto.hoteis.ProcuraHotel;

public class VooHotelActivity extends AppCompatActivity implements View.OnClickListener {
    private Button temp;
    private Button temp1;
    private Button temp2;
    private Context context;

    private String[] aeroporto;
    private ArrayAdapter<String> originAirportsAdapter;
    private ArrayAdapter<String> destinationAirportsAdapter;
    AutoCompleteTextView origins;
    AutoCompleteTextView destinations;

    EditText editT3;
    EditText editT4;
    EditText editT5;
    EditText editT6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voo_hotel);
        context=this;

        aeroporto = getResources().getStringArray(R.array.airports);
        originAirportsAdapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, aeroporto);
        destinationAirportsAdapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, aeroporto);
        origins = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextViewAirportsOrigin1);
        destinations = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextViewAirportsDestination1);
        origins.setAdapter(originAirportsAdapter);
        destinations.setAdapter(destinationAirportsAdapter);

        editT3 = (EditText) findViewById(R.id.editTextDepartureDate);
        editT4 = (EditText)findViewById(R.id.editTextArriveDate);
        editT5 = (EditText) findViewById(R.id.passageiros1);
        editT6 = (EditText) findViewById(R.id.quartos);

        temp = (Button) findViewById(R.id.buttonDateDialogDeparture);
        temp.setOnClickListener(this);
        temp1 = (Button) findViewById(R.id.buttonDateDialogArrive);
        temp1.setOnClickListener(this);
        temp2 = (Button) findViewById(R.id.buttonExecute);
        temp2.setOnClickListener(this);
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
        } else if (v.getId()== R.id.buttonExecute){
            Intent pesquisa = new Intent(context, PesquisaVooHotel.class);

            ProcuraVooHotel TextV1 = new ProcuraVooHotel();
            TextV1.setOrigem(origins.getText().toString());
            TextV1.setDestino(destinations.getText().toString());
            TextV1.setDataPartida(editT3.getText().toString());
            TextV1.setDataRegresso(editT4.getText().toString());
            TextV1.setPassageiros(editT5.getText().toString());
            TextV1.setHospedes(editT6.getText().toString());

            pesquisa.putExtra("Resultados",TextV1);



            startActivity(pesquisa);


        }
    }
}
