package projeto.estgf.ipp.pt.projeto.Voos;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import projeto.estgf.ipp.pt.projeto.ItemClickListener;
import projeto.estgf.ipp.pt.projeto.R;

public class ResultViewHolderViagem  extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView voosIda;
    public TextView partida;
    public TextView companhia;
    public TextView hora;
    public TextView viagem;
    public TextView duracao;
    public TextView hora1;


    private ItemClickListener itemClickListener;


    public ResultViewHolderViagem(@NonNull View itemView) {
        super(itemView);

        this.voosIda = (TextView) itemView.findViewById(R.id.voosIda);
        this.partida = (TextView) itemView.findViewById(R.id.partida);
        this.companhia = (TextView) itemView.findViewById(R.id.companhia);
        this.hora = (TextView) itemView.findViewById(R.id.hora);
        this.viagem = (TextView) itemView.findViewById(R.id.viagem);
        this.duracao = (TextView) itemView.findViewById(R.id.duracao);
        this.hora1 = (TextView) itemView.findViewById(R.id.hora1);

        itemView.setOnClickListener(this);
    }



    @Override
    public void onClick(View v) {
        itemClickListener.onClick(v,getAdapterPosition());
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }
}
