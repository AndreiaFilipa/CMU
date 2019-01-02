package projeto.estgf.ipp.pt.projeto.Pesquisas;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import projeto.estgf.ipp.pt.projeto.ItemClickListener;
import projeto.estgf.ipp.pt.projeto.LongPressItem;
import projeto.estgf.ipp.pt.projeto.R;

public class ResultvViewHolderSaveHoteis extends RecyclerView.ViewHolder implements View.OnLongClickListener {
    public TextView tipoHotel;
    public TextView nomeHotel;
    public TextView chainCodeHotel;
    public TextView roomTypeHotel;
    public TextView roomDescriptionHotel;
    public TextView totalPriceHotel;


    private LongPressItem itemClickListener;

    public ResultvViewHolderSaveHoteis(@NonNull View itemView) {
        super(itemView);

        this.tipoHotel = (TextView) itemView.findViewById(R.id.typeHotelSave);
        this.nomeHotel = (TextView) itemView.findViewById(R.id.nameHotelSave);
        this.chainCodeHotel = (TextView) itemView.findViewById(R.id.chainCodeSave);
        this.roomTypeHotel = (TextView) itemView.findViewById(R.id.roomTypeSave);
        this.roomDescriptionHotel = (TextView) itemView.findViewById(R.id.roomDescriptionSave);
        this.totalPriceHotel = (TextView) itemView.findViewById(R.id.totalPriceSave);

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
