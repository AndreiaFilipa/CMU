package projeto.estgf.ipp.pt.projeto.hoteis;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import projeto.estgf.ipp.pt.projeto.ItemClickListener;
import projeto.estgf.ipp.pt.projeto.R;

public class ResultViewHolderHoteisDetalhes extends RecyclerView.ViewHolder implements View.OnClickListener {
    public TextView roomType;
    public TextView roomDescription;
    public TextView priceTotal;
    public TextView descriptionOffer;
    private ItemClickListener itemClickListener;

    public ResultViewHolderHoteisDetalhes(@NonNull View itemView) {
        super(itemView);

        this.roomType = (TextView) itemView.findViewById(R.id.roomType);
        this.roomDescription = (TextView) itemView.findViewById(R.id.roomDescription);
        this.priceTotal = (TextView) itemView.findViewById(R.id.totalPrice);
        this.descriptionOffer = (TextView) itemView.findViewById(R.id.descriptionOffer);
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

