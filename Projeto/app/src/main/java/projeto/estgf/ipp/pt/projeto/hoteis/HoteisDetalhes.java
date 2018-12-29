package projeto.estgf.ipp.pt.projeto.hoteis;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import projeto.estgf.ipp.pt.projeto.BD.InformacoesHotel;
import projeto.estgf.ipp.pt.projeto.BD.Repo;
import projeto.estgf.ipp.pt.projeto.R;
import projeto.estgf.ipp.pt.projeto.SaveDialogListener;

public class HoteisDetalhes extends AppCompatActivity implements SaveDialogListener {
    private ArrayList<Offer> list;
    private InformacoesHotel hotel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoteis_detalhes);

        hotel=(InformacoesHotel) getIntent().getSerializableExtra("hotel") ;
        list=(ArrayList<Offer>) getIntent().getSerializableExtra("offers");

        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        ResultAdapterHoteisDetalhes resultAdapterHoteisDetalhes = new ResultAdapterHoteisDetalhes(this,hotel);
        resultAdapterHoteisDetalhes.setList(list);

        RecyclerView recyclerView = findViewById(R.id.recyclerViewHotel);
        recyclerView.setAdapter(resultAdapterHoteisDetalhes);
        recyclerView.addItemDecoration(itemDecoration);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onDialogSaveClick() {
        Repo repo = new Repo(this);
        repo.insertHoteis(hotel);
    }
}
