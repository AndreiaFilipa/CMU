package projeto.estgf.ipp.pt.projeto.hoteis;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

import projeto.estgf.ipp.pt.projeto.BD.InformacoesHotel;
import projeto.estgf.ipp.pt.projeto.ItemClickListener;
import projeto.estgf.ipp.pt.projeto.R;


public class ResultAdapterHoteis extends RecyclerView.Adapter<ResultViewHolderHoteis>  {
    private Context context;
    private ArrayList<DatumHoteis> list;
    private ArrayList<Offer>offers;
    private InformacoesHotel informacoesHotel;


    public ResultAdapterHoteis(Context context){
        this.context=context;
        list=new ArrayList<DatumHoteis>();

    }

    public synchronized void setList (ArrayList<DatumHoteis> list) {
        this.list=list;

    }

    @NonNull
    @Override
    public ResultViewHolderHoteis onCreateViewHolder(@NonNull ViewGroup viewGroup, int i){
        Context context = viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        
        View resultView = inflater.inflate(R.layout.row_layout_search_hoteis, viewGroup, false);

        return new ResultViewHolderHoteis(resultView);
    }

    @Override
    public void onBindViewHolder(@NonNull ResultViewHolderHoteis resultViewHolder, int i){
        DatumHoteis temp = list.get(i);

        TextView tipo = resultViewHolder.textView;
        TextView nome = resultViewHolder.textView1;
        TextView chainCode = resultViewHolder.textView2;

        tipo.setText(temp.getHotel().getType());
        nome.setText(temp.getHotel().getName());
        chainCode.setText(temp.getHotel().getChainCode());
        offers= (ArrayList<Offer>) temp.getOffers();

        informacoesHotel= new InformacoesHotel();

        informacoesHotel.tipoHotel=temp.getHotel().getType();
        informacoesHotel.nomeHotel=temp.getHotel().getName();
        informacoesHotel.chainCodeHotel=temp.getHotel().getChainCode();

        informacoesHotel.latitude=temp.getHotel().getLatitude();
        informacoesHotel.longitude=temp.getHotel().getLongitude();

            resultViewHolder.setItemClickListener(new ItemClickListener() {
                @Override
                public void onClick(View view, int position) {
                    Intent intent = new Intent(context, HoteisDetalhes.class);

                    intent.putExtra("offers",offers);
                    intent.putExtra("hotel",informacoesHotel);
                    //intent.putExtra("IdaVolta",true);
                    context.startActivity(intent);
                }
            });

    }

    @Override
    public int getItemCount() {
        return  list.size();
    }

    public void addItems(List<DatumHoteis> x){
        list.addAll(x);
        notifyDataSetChanged();
    }


}
