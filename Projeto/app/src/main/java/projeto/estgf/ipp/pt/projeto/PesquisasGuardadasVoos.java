package projeto.estgf.ipp.pt.projeto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import projeto.estgf.ipp.pt.projeto.BD.InformacoesVoo;
import projeto.estgf.ipp.pt.projeto.BD.Repo;

public class PesquisasGuardadasVoos extends AppCompatActivity implements OnGetAllInformation {
    private Repo repo;
    private  ResultAdapterSaveVoos resultAdapterPesquisa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesquisas_guardadas_voos);

        repo= new Repo(this);


        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        resultAdapterPesquisa = new ResultAdapterSaveVoos(this);
        RecyclerView recyclerView = findViewById(R.id.recyclerViewPesquisas);
        repo.getAllVoos(this);
        recyclerView.setAdapter(resultAdapterPesquisa);
        recyclerView.addItemDecoration(itemDecoration);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


    }

    @Override
    public void obterInformacao( final List<InformacoesVoo> infoVoo) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                 resultAdapterPesquisa.addItems(infoVoo);
            }
        });

    }
}
