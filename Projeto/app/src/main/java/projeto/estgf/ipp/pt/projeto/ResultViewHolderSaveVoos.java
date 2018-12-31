package projeto.estgf.ipp.pt.projeto;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class ResultViewHolderSaveVoos extends RecyclerView.ViewHolder implements View.OnClickListener {
    public TextView preco;
    public TextView tipo;
    public TextView idResultado;
    public TextView voosIda;
    public TextView partida;
    public TextView companhia;
    public TextView hora;
    public TextView viagem;
    public TextView duracao;
    public TextView companhia1;
    public TextView hora1;
    public TextView viagem1;
    public TextView duracao1;

    private ItemClickListener itemClickListener;

    public ResultViewHolderSaveVoos(@NonNull View itemView) {
        super(itemView);

        this.preco = (TextView) itemView.findViewById(R.id.precoSave);
        this.tipo = (TextView) itemView.findViewById(R.id.tipoSave);
        this.idResultado = (TextView) itemView.findViewById(R.id.idResultadoSave);

        this.voosIda = (TextView) itemView.findViewById(R.id.voosIdaSave);
        this.partida = (TextView) itemView.findViewById(R.id.partidaSave);
        this.companhia = (TextView) itemView.findViewById(R.id.companhiaSave);
        this.hora = (TextView) itemView.findViewById(R.id.horaSave);
        this.viagem = (TextView) itemView.findViewById(R.id.viagemSave);
        this.duracao = (TextView) itemView.findViewById(R.id.duracaoSave);

        this.companhia1 = (TextView) itemView.findViewById(R.id.companhia1Save);
        this.hora1 = (TextView) itemView.findViewById(R.id.hora1Save);



        //////////////
        this.viagem1 = (TextView) itemView.findViewById(R.id.viagem1Save);

        ////////////
        this.duracao1 = (TextView) itemView.findViewById(R.id.duracao1Save);

       // itemView.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        itemClickListener.onClick(v,getAdapterPosition());
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }



}
