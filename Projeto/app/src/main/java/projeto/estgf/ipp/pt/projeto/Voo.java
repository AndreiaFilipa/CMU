package projeto.estgf.ipp.pt.projeto;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class Voo extends AppCompatActivity {
private ArrayList<Service> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voo);

        list=(ArrayList<Service>) getIntent().getSerializableExtra("prr");
        boolean x=getIntent().getBooleanExtra("IdaVolta",true);
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        ResultAdapterViagem resultAdapterViagem = new ResultAdapterViagem(this,x);
        resultAdapterViagem.setList(list);
        RecyclerView recyclerView = findViewById(R.id.recyclerViewViagem);
        recyclerView.setAdapter(resultAdapterViagem);
        recyclerView.addItemDecoration(itemDecoration);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
