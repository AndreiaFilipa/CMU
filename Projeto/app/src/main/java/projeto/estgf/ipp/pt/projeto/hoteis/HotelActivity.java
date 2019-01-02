package projeto.estgf.ipp.pt.projeto.hoteis;

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

import projeto.estgf.ipp.pt.projeto.R;
import projeto.estgf.ipp.pt.projeto.hoteis.PesquisaHoteis;
import projeto.estgf.ipp.pt.projeto.hoteis.ProcuraHotel;

public class HotelActivity extends AppCompatActivity implements View.OnClickListener {
    private Button temp;
    private Button temp1;
    private Button temp2;
    private Context context;

    private String[] aeroporto;

    private ArrayAdapter<String> originAirportsAdapter;

    ProcuraHotel TextV1;

    AutoCompleteTextView origins;
    EditText editT3;
    EditText editT4;
    EditText editT5;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel);
        context=this;


        aeroporto = getResources().getStringArray(R.array.airports);
        originAirportsAdapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, aeroporto);
        origins = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextViewOrigemHotel);
        origins.setAdapter(originAirportsAdapter);


        editT3 = (EditText) findViewById(R.id.editTextChegada);
        editT4 = (EditText)findViewById(R.id.editTextPartida);
        editT5 = (EditText) findViewById(R.id.quartosH);

        temp = (Button) findViewById(R.id.buttonChegada);
        temp.setOnClickListener(this);
        temp1 = (Button) findViewById(R.id.buttonPartida);
        temp1.setOnClickListener(this);
        temp2 = (Button) findViewById(R.id.buttonExecuteH);
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
        if(v.getId() == R.id.buttonChegada){
            showDatePickerDialog(v,R.id.editTextChegada);
        }else if(v.getId() == R.id.buttonPartida){
            showDatePickerDialog(v,R.id.editTextPartida);
        } else if (v.getId()== R.id.buttonExecuteH){
            Intent pesquisa = new Intent(context, PesquisaHoteis.class);


            ProcuraHotel TextV1 = new ProcuraHotel();
            TextV1.setCidadeDestino(origins.getText().toString());
            TextV1.setDataCheckIn(editT3.getText().toString());
            TextV1.setDataCheckOut(editT4.getText().toString());
            TextV1.setHospedes(editT5.getText().toString());

            pesquisa.putExtra("Resultados",TextV1);

            startActivity(pesquisa);
        }
    }






}
