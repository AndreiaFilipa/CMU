package projeto.estgf.ipp.pt.projeto;

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

public class ResultAdapterViagem extends RecyclerView.Adapter<ResultViewHolderViagem> {

    private Context context;
    private boolean b;
    private ArrayList<Service> list;
    private InformacoesVoo voo;


    public ResultAdapterViagem(Context context, boolean b,InformacoesVoo voo){
        this.context=context;
        this.b = b;
        list=new ArrayList<Service>();
        this.voo=voo;

    }

    public synchronized void setList (ArrayList<Service> list) {
        this.list=list;

    }

    @NonNull
    @Override
    public ResultViewHolderViagem onCreateViewHolder(@NonNull ViewGroup viewGroup, int i){
        Context context = viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View resultView = inflater.inflate(R.layout.resultados_voos_ida_volta, viewGroup, false);

        return new ResultViewHolderViagem(resultView);
    }

    @Override
    public void onBindViewHolder(@NonNull ResultViewHolderViagem resultViewHolder, int i){
        Service service = list.get(i);
        Segment temp = service.getSegments().get(0);


            TextView companhia = resultViewHolder.companhia;
            TextView hora = resultViewHolder.hora;
            TextView viagem = resultViewHolder.viagem;
            TextView duracao = resultViewHolder.duracao;
            companhia.setText(temp.getFlightSegment().getCarrierCode());
            hora.setText(temp.getFlightSegment().getDeparture().getAt());
            viagem.setText(String.format("%s-%s", temp.getFlightSegment().getDeparture().getIataCode(), temp.getFlightSegment().getArrival().getIataCode()));
            duracao.setText(temp.getFlightSegment().getDuration());

        if(b) {
            TextView regresso=resultViewHolder.regresso;
            TextView companhia1 = resultViewHolder.companhia1;
            TextView hora1 = resultViewHolder.hora1;
            TextView viagem1 = resultViewHolder.viagem1;
            TextView duracao1 = resultViewHolder.duracao1;
            regresso.setVisibility(View.VISIBLE);
            companhia1.setVisibility(View.VISIBLE);
            hora1.setVisibility(View.VISIBLE);
            viagem1.setVisibility(View.VISIBLE);
            duracao1.setVisibility(View.VISIBLE);
            companhia1.setText(temp.getFlightSegment().getCarrierCode());
            hora1.setText(temp.getFlightSegment().getArrival().getAt());
            viagem1.setText(String.format("%s-%s", temp.getFlightSegment().getDeparture().getIataCode(), temp.getFlightSegment().getArrival().getIataCode()));
            duracao1.setText(temp.getFlightSegment().getDuration());

            voo.companhiaV=temp.getFlightSegment().getCarrierCode();
            voo.horaV=temp.getFlightSegment().getArrival().getAt();
            voo.fluxoViagemV=String.format("%s-%s", temp.getFlightSegment().getDeparture().getIataCode(), temp.getFlightSegment().getArrival().getIataCode());
            voo.duracaoV=temp.getFlightSegment().getDuration();
        }

        voo.companhia=temp.getFlightSegment().getCarrierCode();
        voo.hora=temp.getFlightSegment().getDeparture().getAt();
        voo.fluxoViagem=String.format("%s-%s", temp.getFlightSegment().getDeparture().getIataCode(), temp.getFlightSegment().getArrival().getIataCode());
        voo.duracao=temp.getFlightSegment().getDuration();




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

    public void addItems(List<Service> x){
        list.addAll(x);
        notifyDataSetChanged();
    }



}
