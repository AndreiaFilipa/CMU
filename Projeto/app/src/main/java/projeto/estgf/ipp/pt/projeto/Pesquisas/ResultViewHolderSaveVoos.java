package projeto.estgf.ipp.pt.projeto.Pesquisas;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import projeto.estgf.ipp.pt.projeto.ItemClickListener;
import projeto.estgf.ipp.pt.projeto.LongPressItem;
import projeto.estgf.ipp.pt.projeto.R;

public class ResultViewHolderSaveVoos extends RecyclerView.ViewHolder implements View.OnLongClickListener {
    public TextView preco;
    public TextView tipo;
    public TextView idResultado;
    public TextView voosIda;
    public TextView partida;
    public TextView companhia;
    public TextView hora;
    public TextView viagem;
    public TextView duracao;
    public TextView hora1;


    private LongPressItem itemClickListener;

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

        this.hora1 = (TextView) itemView.findViewById(R.id.hora1Save);

        itemView.setOnLongClickListener(this);

    }

    public void setItemClickListener(LongPressItem itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @Override
    public boolean onLongClick(View v) {
        itemClickListener.onClickLongPress(v,getAdapterPosition());
        return true;
    }


}
