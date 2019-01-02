package projeto.estgf.ipp.pt.projeto.Pesquisas;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import projeto.estgf.ipp.pt.projeto.BD.InformacoesVoo;
import projeto.estgf.ipp.pt.projeto.BD.Repo;
import projeto.estgf.ipp.pt.projeto.DialogRemovePesquisas;
import projeto.estgf.ipp.pt.projeto.LongPressItem;
import projeto.estgf.ipp.pt.projeto.LongPressRemove;
import projeto.estgf.ipp.pt.projeto.R;

public class ResultAdapterSaveVoos extends RecyclerView.Adapter<ResultViewHolderSaveVoos> implements LongPressItem, LongPressRemove {
    private Context context;
    private ArrayList<InformacoesVoo> list;
    private InformacoesVoo temp;

    public ResultAdapterSaveVoos(Context context){
        this.context=context;
        list= new ArrayList<InformacoesVoo>();
    }


    @NonNull
    @Override
    public ResultViewHolderSaveVoos onCreateViewHolder(@NonNull ViewGroup viewGroup, int i){
        Context context = viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View resultView = inflater.inflate(R.layout.row_layout_search_save_voos, viewGroup, false);

        return new ResultViewHolderSaveVoos(resultView);
    }

    @Override
    public void onBindViewHolder(@NonNull ResultViewHolderSaveVoos resultViewHolder, int i){
        InformacoesVoo temp = list.get(i);

        TextView preco = resultViewHolder.preco;
        TextView tipo = resultViewHolder.tipo;
        TextView idResultado = resultViewHolder.idResultado;
        TextView companhia = resultViewHolder.companhia;
        TextView hora = resultViewHolder.hora;
        TextView viagem = resultViewHolder.viagem;
        TextView duracao = resultViewHolder.duracao;
        TextView hora1 = resultViewHolder.hora1;
        TextView idaVolta = resultViewHolder.voosIda;

        preco.setText(temp.preco);
        tipo.setText(temp.tipo);
        idResultado.setText(temp.id);
        companhia.setText(temp.companhia);
        hora.setText(temp.hora);
        viagem.setText(temp.fluxoViagem);
        duracao.setText(temp.duracao);
        hora1.setText(temp.horaV);
        idaVolta.setText(temp.idaVolta);

        resultViewHolder.setItemClickListener(this);

    }

    @Override
    public int getItemCount() {
        return  list.size();
    }

    public void addItems(List<InformacoesVoo> x){
        list.addAll(x);
        notifyDataSetChanged();
    }


    @Override
    public void onClickLongPress(View view, int position) {
        this.temp = list.get(position);
        DialogRemovePesquisas dialogRemovePesquisas = new DialogRemovePesquisas();
        dialogRemovePesquisas.setRemovePesquisas(this);
        dialogRemovePesquisas.show(((AppCompatActivity)context).getSupportFragmentManager(), "Remove");
    }

    @Override
    public void removePesquisas() {
        list.remove(temp);
        notifyDataSetChanged();
        Repo repo = new Repo(context);
        repo.deleteInformacoesVoo(temp);
    }
}
