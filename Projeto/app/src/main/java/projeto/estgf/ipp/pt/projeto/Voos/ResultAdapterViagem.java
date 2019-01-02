package projeto.estgf.ipp.pt.projeto.Voos;

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
import projeto.estgf.ipp.pt.projeto.GuardarDialog;
import projeto.estgf.ipp.pt.projeto.ItemClickListener;
import projeto.estgf.ipp.pt.projeto.R;

public class ResultAdapterViagem extends RecyclerView.Adapter<ResultViewHolderViagem> {

    private Context context;
    private boolean b;
    private String voo;
    private ArrayList<Service> list;
    private InformacoesVoo vooInfo;


    public ResultAdapterViagem(Context context, boolean b,InformacoesVoo voo){
        this.context=context;
        this.b = b;
        list=new ArrayList<Service>();
        this.vooInfo=voo;

    }

    public synchronized void setList (ArrayList<Service> list) {
        this.list=list;

    }

    @NonNull
    @Override
    public ResultViewHolderViagem onCreateViewHolder(@NonNull ViewGroup viewGroup, int i){
        Context context = viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View resultView = inflater.inflate(R.layout.resultados_voos, viewGroup, false);

        return new ResultViewHolderViagem(resultView);
    }

    @Override
    public void onBindViewHolder(@NonNull ResultViewHolderViagem resultViewHolder, int i){
        Service service = list.get(i);
        final Segment temp = service.getSegments().get(0);

        if(i == 0){
            this.voo = String.format("%s-%s", temp.getFlightSegment().getDeparture().getIataCode(), temp.getFlightSegment().getArrival().getIataCode());
        }
        final TextView VoosIda = resultViewHolder.voosIda;
        if(voo.equals(String.format("%s-%s", temp.getFlightSegment().getDeparture().getIataCode(), temp.getFlightSegment().getArrival().getIataCode()))){

            VoosIda.setText("Voos Ida");


        }else{
            VoosIda.setText("Voos Volta");


        }
            TextView companhia = resultViewHolder.companhia;
            TextView hora = resultViewHolder.hora;
            TextView viagem = resultViewHolder.viagem;
            TextView duracao = resultViewHolder.duracao;
            companhia.setText(temp.getFlightSegment().getCarrierCode());
            hora.setText(temp.getFlightSegment().getDeparture().getAt());
            viagem.setText(String.format("%s-%s", temp.getFlightSegment().getDeparture().getIataCode(), temp.getFlightSegment().getArrival().getIataCode()));
            duracao.setText(temp.getFlightSegment().getDuration());
            TextView hora1 = resultViewHolder.hora1;hora1.setVisibility(View.VISIBLE);
            hora1.setText(temp.getFlightSegment().getArrival().getAt());


            resultViewHolder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position) {
                vooInfo.idaVolta= (String) VoosIda.getText();
                vooInfo.companhia=temp.getFlightSegment().getCarrierCode();
                vooInfo.hora=temp.getFlightSegment().getDeparture().getAt();
                vooInfo.fluxoViagem=String.format("%s-%s", temp.getFlightSegment().getDeparture().getIataCode(), temp.getFlightSegment().getArrival().getIataCode());
                vooInfo.duracao=temp.getFlightSegment().getDuration();
                vooInfo.horaV=temp.getFlightSegment().getArrival().getAt();
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
