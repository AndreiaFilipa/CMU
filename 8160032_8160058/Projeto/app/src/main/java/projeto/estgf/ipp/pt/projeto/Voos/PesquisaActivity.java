package projeto.estgf.ipp.pt.projeto.Voos;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import projeto.estgf.ipp.pt.projeto.R;

public class PesquisaActivity extends AppCompatActivity {

    private IdaRegressoVoo resultadosPesquisa;
    private ResultAdapter adapter;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesquisa);
        context = this;
        boolean b = (boolean) getIntent().getBooleanExtra("IdaVolta",true);
        resultadosPesquisa = (IdaRegressoVoo) getIntent().getSerializableExtra("Resultados");


        this.adapter = new ResultAdapter(this, b);
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(itemDecoration);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        ResultsVoos resultados = new ResultsVoos (this,adapter);

        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();

        if(activeNetworkInfo != null && activeNetworkInfo.isConnected()){
            if(b){
                resultados.resultados(resultadosPesquisa.getOrigem(),resultadosPesquisa.getDestino(),resultadosPesquisa.getDataPartida(),resultadosPesquisa.getDataRegresso(), Integer.parseInt(resultadosPesquisa.getPassageiros()));

            }else {
                resultados.resultados(resultadosPesquisa.getOrigem(), resultadosPesquisa.getDestino(), resultadosPesquisa.getDataPartida(), Integer.parseInt(resultadosPesquisa.getPassageiros()));
            }
        }else{
            TextView erro = (TextView) findViewById(R.id.erro);
            erro.setText("Verifique se esta conectado a internet");
            erro.setVisibility(View.VISIBLE);
            FrameLayout frameLayout = (FrameLayout) findViewById(R.id.frameLayout);
            frameLayout.setVisibility(View.GONE);
        }

    }



}
