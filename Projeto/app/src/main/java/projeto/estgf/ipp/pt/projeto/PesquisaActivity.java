package projeto.estgf.ipp.pt.projeto;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.support.v7.widget.SearchView;

public class PesquisaActivity extends AppCompatActivity {

    private IdaRegressoVoo resultadosPesquisa;
    private ResultAdapter adapter;
    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesquisa);
        context = this;

        resultadosPesquisa = (IdaRegressoVoo) getIntent().getSerializableExtra("Resultados");


        this.adapter = new ResultAdapter(this);
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(itemDecoration);


        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        ResultsVoos resultados = new ResultsVoos (this,adapter);

        resultados.resultados(resultadosPesquisa.getOrigem(),resultadosPesquisa.getDestino(),resultadosPesquisa.getDataPartida(), Integer.parseInt(resultadosPesquisa.getPassageiros()));



    }

}
