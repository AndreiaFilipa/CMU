package projeto.estgf.ipp.pt.projeto;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;


public class Registo_Activity extends AppCompatActivity implements View.OnClickListener {
    private Button temp;
    private Context context;

    private String[] aeroporto;

    private ArrayAdapter<String> originAirportsAdapter;
    private ArrayAdapter<String> destinationAirportsAdapter;


    ProcuraCidade TextV1;

    EditText editT;
    AutoCompleteTextView cidade;
    AutoCompleteTextView cidadeHabita;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registo_);
        context = this;

        aeroporto = getResources().getStringArray(R.array.airports);
        originAirportsAdapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, aeroporto);
        destinationAirportsAdapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, aeroporto);
        cidade = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextViewOrigemHotel2);
        cidade.setAdapter(originAirportsAdapter);
        cidadeHabita = (AutoCompleteTextView) findViewById(R.id.cidadehabita);
        cidadeHabita.setAdapter(destinationAirportsAdapter);


        editT = (EditText) findViewById(R.id.nome);

        temp = (Button) findViewById(R.id.buttonRegista);
        temp.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.buttonRegista) {
            //mudar para onde vai o botão
            Intent registar = new Intent(context, PesquisaActivity.class);

            ProcuraCidade TextV1 = new ProcuraCidade();
            TextV1.setNome(editT.getText().toString());
            TextV1.setCidadePref(cidade.getText().toString());
            TextV1.setCidadeHabita(cidadeHabita.getText().toString());

            registar.putExtra("Registar", TextV1);

            startActivity(registar);
        }
    }
}
