package projeto.estgf.ipp.pt.projeto;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import projeto.estgf.ipp.pt.projeto.R;

public class ResultViewHolderViagem  extends RecyclerView.ViewHolder{

    public TextView voosIda;
    public TextView partida;
    public TextView companhia;
    public TextView hora;
    public TextView viagem;
    public TextView duracao;
    public TextView regresso;
    public TextView companhia1;
    public TextView hora1;
    public TextView viagem1;
    public TextView duracao1;


    public ResultViewHolderViagem(@NonNull View itemView) {
        super(itemView);

        this.voosIda = (TextView) itemView.findViewById(R.id.voosIda);
        this.partida = (TextView) itemView.findViewById(R.id.partida);
        this.companhia = (TextView) itemView.findViewById(R.id.companhia);
        this.hora = (TextView) itemView.findViewById(R.id.hora);
        this.viagem = (TextView) itemView.findViewById(R.id.viagem);
        this.duracao = (TextView) itemView.findViewById(R.id.duracao);

        this.regresso = (TextView) itemView.findViewById(R.id.regresso);
        this.companhia1 = (TextView) itemView.findViewById(R.id.companhia1);
        this.hora1 = (TextView) itemView.findViewById(R.id.hora1);
        this.viagem1 = (TextView) itemView.findViewById(R.id.viagem1);
        this.duracao1 = (TextView) itemView.findViewById(R.id.duracao1);


    }

}
