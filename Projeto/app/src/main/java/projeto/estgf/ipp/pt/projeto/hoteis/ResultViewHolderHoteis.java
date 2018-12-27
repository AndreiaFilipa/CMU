package projeto.estgf.ipp.pt.projeto.hoteis;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import projeto.estgf.ipp.pt.projeto.ItemClickListener;
import projeto.estgf.ipp.pt.projeto.R;

public class ResultViewHolderHoteis extends RecyclerView.ViewHolder implements View.OnClickListener{
    public TextView textView;
    public TextView textView1;
    public TextView textView2;

    private ItemClickListener itemClickListener;

    public ResultViewHolderHoteis(@NonNull View itemView) {
        super(itemView);

        this.textView = (TextView) itemView.findViewById(R.id.typeHotel);
        this.textView1 = (TextView) itemView.findViewById(R.id.nameHotel);
        this.textView2 = (TextView) itemView.findViewById(R.id.chainCode);

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
