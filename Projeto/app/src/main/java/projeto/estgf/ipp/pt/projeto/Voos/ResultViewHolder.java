package projeto.estgf.ipp.pt.projeto.Voos;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import projeto.estgf.ipp.pt.projeto.ItemClickListener;
import projeto.estgf.ipp.pt.projeto.R;

public class ResultViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public TextView preco;
    public TextView tipo;
    public TextView idResultado;

    private ItemClickListener itemClickListener;

    public ResultViewHolder(@NonNull View itemView) {
        super(itemView);

        this.preco = (TextView) itemView.findViewById(R.id.preco);
        this.tipo = (TextView) itemView.findViewById(R.id.tipo);
        this.idResultado = (TextView) itemView.findViewById(R.id.idResultado);

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
