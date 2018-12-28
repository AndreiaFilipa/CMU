package projeto.estgf.ipp.pt.projeto.hoteis;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

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

        resultados.resultados(resultadosPesquisa.getCidadeDestino(), resultadosPesquisa.getDataCheckIn(), resultadosPesquisa.getDataCheckOut(), Integer.parseInt(resultadosPesquisa.getHospedes()));


    }

}
