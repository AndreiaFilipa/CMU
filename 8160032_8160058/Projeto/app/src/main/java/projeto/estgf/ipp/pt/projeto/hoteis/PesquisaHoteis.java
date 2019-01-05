package projeto.estgf.ipp.pt.projeto.hoteis;

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

public class PesquisaHoteis extends AppCompatActivity  {

    private ProcuraHotel resultadosPesquisa;
    private ResultAdapterHoteis adapter;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesquisa_hoteis);
        context = this;

        resultadosPesquisa = (ProcuraHotel) getIntent().getSerializableExtra("Resultados");

        this.adapter = new ResultAdapterHoteis(this);
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        RecyclerView recyclerView = findViewById(R.id.recyclerViewH);
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(itemDecoration);


        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        ResultsHoteis resultados = new ResultsHoteis(this, adapter);

        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();

        if(activeNetworkInfo != null && activeNetworkInfo.isConnected()) {

            resultados.resultados(resultadosPesquisa.getCidadeDestino(), resultadosPesquisa.getDataCheckIn(), resultadosPesquisa.getDataCheckOut(), Integer.parseInt(resultadosPesquisa.getHospedes()));

        }else{
            TextView erro = (TextView) findViewById(R.id.erroH);
            erro.setText("Verifique se esta conectado a internet");
            erro.setVisibility(View.VISIBLE);
            FrameLayout frameLayout = (FrameLayout) findViewById(R.id.frameLayoutH);
            frameLayout.setVisibility(View.GONE);
        }
    }

}
