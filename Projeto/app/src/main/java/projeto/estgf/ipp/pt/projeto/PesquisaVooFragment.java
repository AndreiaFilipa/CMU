package projeto.estgf.ipp.pt.projeto;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class PesquisaVooFragment extends Fragment {
    private Context context;
    private ProcuraVooHotel resultadosPesquisa;
    private ResultAdapter adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getActivity();

    }

    public void setResultadosPesquisa(ProcuraVooHotel resultadosPesquisa) {
        this.resultadosPesquisa = resultadosPesquisa;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_pesquisa, container, false);


        this.adapter = new ResultAdapter(context);
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(context, DividerItemDecoration.VERTICAL);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(itemDecoration);


        recyclerView.setLayoutManager(new LinearLayoutManager(context));


        ResultsVoos resultados = new ResultsVoos (context,adapter);

        resultados.resultados(resultadosPesquisa.getOrigem(),resultadosPesquisa.getDestino(),resultadosPesquisa.getDataPartida(), resultadosPesquisa.getDataRegresso(), Integer.parseInt(resultadosPesquisa.getPassageiros()));

        return view;
    }
}
