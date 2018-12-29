package projeto.estgf.ipp.pt.projeto;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import projeto.estgf.ipp.pt.projeto.BD.InformacoesVoo;

public class ResultAdapterSaveVoos extends RecyclerView.Adapter<ResultViewHolderSaveVoos> {
    private Context context;
    private ArrayList<InformacoesVoo> list;

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
        TextView companhia1 = resultViewHolder.companhia1;
        TextView hora1 = resultViewHolder.hora1;
        TextView viagem1 = resultViewHolder.voosIda;
        TextView duracao1 = resultViewHolder.duracao1;

        preco.setText(temp.preco);
        tipo.setText(temp.tipo);
        idResultado.setText(temp.id);
        companhia.setText(temp.companhia);
        hora.setText(temp.hora);
        viagem.setText(temp.fluxoViagem);
        duracao.setText(temp.duracao);
        companhia1.setText(temp.companhiaV);
        hora1.setText(temp.horaV);
        viagem1.setText(temp.fluxoViagemV);
        duracao1.setText(temp.duracaoV);



    }

    @Override
    public int getItemCount() {
        return  list.size();
    }

    public void addItems(List<InformacoesVoo> x){
        list.addAll(x);
        notifyDataSetChanged();
    }








}
