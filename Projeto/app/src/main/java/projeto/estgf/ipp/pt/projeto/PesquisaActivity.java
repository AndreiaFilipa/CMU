package projeto.estgf.ipp.pt.projeto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.support.v7.widget.SearchView;

public class PesquisaActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    private IdaRegressoVoo resultadosPesquisa;
    private SearchView searchView;
    private ResultAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesquisa);

        resultadosPesquisa = (IdaRegressoVoo) getIntent().getSerializableExtra("Resultados");

        searchView = (SearchView) findViewById(R.id.pesquisa);
        searchView.setOnQueryTextListener(this);

        this.adapter = new ResultAdapter(this);
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(itemDecoration);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public boolean onQueryTextSubmit(String x){
        ResultsVoos resultados = new ResultsVoos (this,adapter);

       resultados.resultados(resultadosPesquisa.getOrigem(),resultadosPesquisa.getDestino(),resultadosPesquisa.getDataPartida(),resultadosPesquisa.getDataRegresso(), Integer.parseInt(resultadosPesquisa.getPassageiros()));

        return true;

    }

    @Override
    public boolean onQueryTextChange(String x){
        return true;
    }
}
