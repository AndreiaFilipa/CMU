package projeto.estgf.ipp.pt.projeto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import projeto.estgf.ipp.pt.projeto.BD.InformacoesHotel;
import projeto.estgf.ipp.pt.projeto.BD.Repo;

public class PesquisasGuardadasHoteis extends AppCompatActivity implements OnGetAllInformationHoteis {
    private Repo repo;
    private  ResultAdapterSaveHoteis resultAdapterPesquisa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesquisas_guardadas_hoteis);

        repo= new Repo(this);


        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        resultAdapterPesquisa = new ResultAdapterSaveHoteis(this);
        RecyclerView recyclerView = findViewById(R.id.recyclerViewPesquisasHoteis);
        repo.getAllHoteis(this);
        recyclerView.setAdapter(resultAdapterPesquisa);
        recyclerView.addItemDecoration(itemDecoration);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void obterInformacaoHoteis( final List<InformacoesHotel> infoHotel) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                resultAdapterPesquisa.addItems(infoHotel);
            }
        });

    }
}
