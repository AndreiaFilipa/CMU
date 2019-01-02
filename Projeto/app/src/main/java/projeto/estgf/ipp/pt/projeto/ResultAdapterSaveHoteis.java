package projeto.estgf.ipp.pt.projeto;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import projeto.estgf.ipp.pt.projeto.BD.InformacoesHotel;

public class ResultAdapterSaveHoteis extends RecyclerView.Adapter<ResultvViewHolderSaveHoteis> {
    private Context context;
    private ArrayList<InformacoesHotel> list;

    public ResultAdapterSaveHoteis(Context context){
        this.context=context;
        list= new ArrayList<InformacoesHotel>();
    }

    @NonNull
    @Override
    public ResultvViewHolderSaveHoteis onCreateViewHolder(@NonNull ViewGroup viewGroup, int i){
        Context context = viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View resultView = inflater.inflate(R.layout.row_layout_search_save_hoteis, viewGroup, false);

        return new ResultvViewHolderSaveHoteis(resultView);
    }

    @Override
    public void onBindViewHolder(@NonNull ResultvViewHolderSaveHoteis resultViewHolder, int i){
        InformacoesHotel temp = list.get(i);


        TextView tipoHotel = resultViewHolder.tipoHotel;
        TextView nomeHotel = resultViewHolder.nomeHotel;
        TextView chainHotel = resultViewHolder.chainCodeHotel;
        TextView roomTipoHotel = resultViewHolder.roomTypeHotel;
        TextView descriptionRoom = resultViewHolder.roomDescriptionHotel;
        TextView precoHotel = resultViewHolder.totalPriceHotel;


        tipoHotel.setText(temp.tipoHotel);
        nomeHotel.setText(temp.nomeHotel);
        chainHotel.setText(temp.chainCodeHotel);
        roomTipoHotel.setText(temp.roomTypeHotel);
        descriptionRoom.setText(temp.roomDescriptionHotel);
        precoHotel.setText(temp.priceHotel);


    }

    @Override
    public int getItemCount() {
        return  list.size();
    }

    public void addItems(List<InformacoesHotel> x){
        list.addAll(x);
        notifyDataSetChanged();
    }
}
