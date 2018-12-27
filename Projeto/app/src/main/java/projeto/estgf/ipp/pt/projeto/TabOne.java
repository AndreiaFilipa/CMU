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


public class TabOne extends Fragment implements View.OnClickListener {
    private Button temp;
    private Button temp1;
    private Button temp2;
    private Context context;

    private String[] aeroporto;

    private ArrayAdapter<String> originAirportsAdapter;
    private ArrayAdapter<String> destinationAirportsAdapter;

    private IdaRegressoVoo TextV1;

    private AutoCompleteTextView origins ;
    private AutoCompleteTextView destinations ;
    private EditText editT3;
    private EditText editT4;
    private EditText editT5;



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
                        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
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
        }else if (v.getId()== R.id.buttonExecute){
            Intent pesquisa = new Intent(context,PesquisaActivity.class);
            pesquisa.putExtra("IdaVolta",true);

            IdaRegressoVoo TextV1 = new IdaRegressoVoo();
            TextV1.setOrigem(origins.getText().toString());
            TextV1.setDestino(destinations.getText().toString());
            TextV1.setDataPartida(editT3.getText().toString());
            TextV1.setDataRegresso(editT4.getText().toString());
            TextV1.setPassageiros(editT5.getText().toString());

            pesquisa.putExtra("Resultados",TextV1);

            startActivity(pesquisa);
        }
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.tab_one, container, false);

        aeroporto = getResources().getStringArray(R.array.airports);
        originAirportsAdapter = new ArrayAdapter<String>(context, R.layout.support_simple_spinner_dropdown_item, aeroporto);
        destinationAirportsAdapter = new ArrayAdapter<String>(context, R.layout.support_simple_spinner_dropdown_item, aeroporto);
        origins = (AutoCompleteTextView) view.findViewById(R.id.autoCompleteTextViewAirportsOriginVoo);
        destinations = (AutoCompleteTextView) view.findViewById(R.id.autoCompleteTextViewAirportsDestinationVoo);
        origins.setAdapter(originAirportsAdapter);
        destinations.setAdapter(destinationAirportsAdapter);


        editT3 = (EditText) view.findViewById(R.id.editTextDepartureDateVoo);
        editT4 = (EditText) view.findViewById(R.id.editTextArriveDateVoo);
        editT5 = (EditText) view.findViewById(R.id.passageiros);

        temp = (Button) view.findViewById(R.id.buttonDateDialogDepartureVoo);
        temp.setOnClickListener(this);
        temp1 = (Button) view.findViewById(R.id.buttonDateDialogArriveVoo);
        temp1.setOnClickListener(this);
        temp2 = (Button) view.findViewById(R.id.buttonExecute);
        temp2.setOnClickListener(this);

        return view;
    }


}

