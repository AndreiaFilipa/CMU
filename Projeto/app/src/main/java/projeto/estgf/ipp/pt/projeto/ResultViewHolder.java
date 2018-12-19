package projeto.estgf.ipp.pt.projeto;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class ResultViewHolder extends RecyclerView.ViewHolder {
    public TextView textView;
    public TextView textView1;
    public TextView textView2;
    public TextView textView3;
    public TextView textView4;
    public TextView textView5;
    public TextView textView6;
    public TextView textView7;
    public TextView textView8;
    public TextView textView9;
    public TextView textView10;

    public ResultViewHolder(@NonNull View itemView) {
        super(itemView);

        this.textView = (TextView) itemView.findViewById(R.id.preco);
        this.textView1 = (TextView) itemView.findViewById(R.id.partida);
        this.textView2 = (TextView) itemView.findViewById(R.id.companhia);
        this.textView3 = (TextView) itemView.findViewById(R.id.hora);
        this.textView4 = (TextView) itemView.findViewById(R.id.viagem);
        this.textView5 = (TextView) itemView.findViewById(R.id.duracao);
        this.textView6 = (TextView) itemView.findViewById(R.id.regresso);
        this.textView7 = (TextView) itemView.findViewById(R.id.companhia1);
        this.textView8 = (TextView) itemView.findViewById(R.id.hora1);
        this.textView9 = (TextView) itemView.findViewById(R.id.viagem1);
        this.textView10 = (TextView) itemView.findViewById(R.id.duracao1);

    }

}
