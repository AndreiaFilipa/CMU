package projeto.estgf.ipp.pt.projeto.hoteis;


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

import projeto.estgf.ipp.pt.projeto.BD.InformacoesHotel;
import projeto.estgf.ipp.pt.projeto.GuardarDialog;
import projeto.estgf.ipp.pt.projeto.ItemClickListener;
import projeto.estgf.ipp.pt.projeto.R;


public class ResultAdapterHoteisDetalhes extends RecyclerView.Adapter<ResultViewHolderHoteisDetalhes> {
    private Context context;
    private ArrayList<Offer> list;
    private InformacoesHotel hotelInfo;

    public ResultAdapterHoteisDetalhes(Context context, InformacoesHotel hotel){
        this.context=context;
        list=new ArrayList<Offer>();
        this.hotelInfo=hotel;

    }

    public synchronized void setList (ArrayList<Offer> list) {
        this.list=list;

    }

    @NonNull
    @Override
    public ResultViewHolderHoteisDetalhes onCreateViewHolder(@NonNull ViewGroup viewGroup, int i){
        Context context = viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View resultView = inflater.inflate(R.layout.resultados_hoteis, viewGroup, false);

        return new ResultViewHolderHoteisDetalhes(resultView);
    }

    @Override
    public void onBindViewHolder(@NonNull ResultViewHolderHoteisDetalhes resultViewHolder, int i) {
        Offer offer = list.get(i);
        Room room = offer.getRoom();
        Price price = offer.getPrice();
        Description_  description = offer.getDescription();


        TextView roomType = resultViewHolder.roomType;
        TextView roomDescription = resultViewHolder.roomDescription;
        TextView totalPrice = resultViewHolder.priceTotal;
        TextView descriptionOffer = resultViewHolder.descriptionOffer;

        roomType.setText(room.getType());
        roomDescription.setText(room.getDescription().getText());
        totalPrice.setText(price.getTotal());
        //descriptionOffer.setText(description.getText());

        hotelInfo.roomTypeHotel = room.getType();
        hotelInfo.roomDescriptionHotel = room.getDescription().getText();
        hotelInfo.priceHotel = price.getTotal();

        resultViewHolder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position) {
                GuardarDialog x = new GuardarDialog();
                x.show(((AppCompatActivity)context).getSupportFragmentManager(),"guardar_bd");
            }
        });



    }



    @Override
    public int getItemCount() {
        return  list.size();
    }

    public void addItems(List<Offer> x){
        list.addAll(x);
        notifyDataSetChanged();
    }




}
