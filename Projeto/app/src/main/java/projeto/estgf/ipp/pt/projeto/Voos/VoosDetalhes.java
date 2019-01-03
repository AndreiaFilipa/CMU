package projeto.estgf.ipp.pt.projeto.Voos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import projeto.estgf.ipp.pt.projeto.BD.InformacoesVoo;
import projeto.estgf.ipp.pt.projeto.BD.Repo;
import projeto.estgf.ipp.pt.projeto.R;
import projeto.estgf.ipp.pt.projeto.SaveDialogListener;

public class VoosDetalhes extends AppCompatActivity implements SaveDialogListener {
private ArrayList<Service> list;
private InformacoesVoo voo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voos_detalhes);


        voo=(InformacoesVoo) getIntent().getSerializableExtra("voo") ;
        list=(ArrayList<Service>) getIntent().getSerializableExtra("prr");
        boolean x=getIntent().getBooleanExtra("IdaVolta",true);

        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        ResultAdapterViagem resultAdapterViagem = new ResultAdapterViagem(this,x,voo);
        resultAdapterViagem.setList(list);
        RecyclerView recyclerView = findViewById(R.id.recyclerViewViagem);
        recyclerView.setAdapter(resultAdapterViagem);
        recyclerView.addItemDecoration(itemDecoration);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onDialogSaveClick() {

    }

    @Override
    public void onDialogSaveClick(InformacoesVoo vooI) {
        Repo repo = new Repo(this);
        repo.insert(vooI);
    }
}
