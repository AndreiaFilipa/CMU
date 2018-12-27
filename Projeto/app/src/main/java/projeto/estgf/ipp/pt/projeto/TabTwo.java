package projeto.estgf.ipp.pt.projeto;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
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


public class TabTwo extends Fragment implements View.OnClickListener{
    private Button temp;
    private Button temp2;
    private Context context;

    private IdaRegressoVoo Input;

    private AutoCompleteTextView origins ;
    private AutoCompleteTextView destinations ;
    private EditText editT3;
    private EditText editT4;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.context = getActivity();

    }


    public void showDatePickerDialog(View v) {

        Calendar cal = Calendar.getInstance();
        AlertDialog newFragment = new DatePickerDialog(context,
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        Calendar cal = Calendar.getInstance();
                        cal.set(Calendar.YEAR, year);
                        cal.set(Calendar.MONTH, monthOfYear);
                        cal.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        EditText departureDate = (EditText) ((Activity)context).findViewById(R.id.editTextDepartureDate);
                        departureDate.setText(sdf.format(cal.getTime()));

                    }
                }, cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH));
        newFragment.show();

    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.buttonDateDialog){
            showDatePickerDialog(v);
        }else if(v.getId() == R.id.buttonExecuteIda){
            Intent pesquisa = new Intent(context,PesquisaActivity.class);
            pesquisa.putExtra("Ida",false);

            Input = new IdaRegressoVoo();
            Input.setOrigem(origins.getText().toString());
            Input.setDestino(destinations.getText().toString());
            Input.setDataPartida(editT3.getText().toString());
            Input.setPassageiros(editT4.getText().toString());

            pesquisa.putExtra("Resultados",Input);

            startActivity(pesquisa);

        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.tab_two, container, false);

        String[] aeroporto = getResources().getStringArray(R.array.airports);
        ArrayAdapter<String> originAirportsAdapter = new ArrayAdapter<String>(context, R.layout.support_simple_spinner_dropdown_item, aeroporto);
        ArrayAdapter<String> destinationAirportsAdapter = new ArrayAdapter<String>(context, R.layout.support_simple_spinner_dropdown_item, aeroporto);
        origins = (AutoCompleteTextView) view.findViewById(R.id.autoCompleteTextViewAirportsOrigin);
        destinations = (AutoCompleteTextView) view.findViewById(R.id.autoCompleteTextViewAirportsDestination);
        origins.setAdapter(originAirportsAdapter);
        destinations.setAdapter(destinationAirportsAdapter);

        temp = (Button) view.findViewById(R.id.buttonDateDialog);
        temp.setOnClickListener(this);

        editT3 = (EditText) view.findViewById(R.id.editTextDepartureDate);
        editT4 = (EditText) view.findViewById(R.id.passageiros_tabtwo);

        temp2 = (Button) view.findViewById(R.id.buttonExecuteIda);
        temp2.setOnClickListener(this);

        return view;
    }



}
