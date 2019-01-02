package projeto.estgf.ipp.pt.projeto;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class ResultvViewHolderSaveHoteis extends RecyclerView.ViewHolder implements View.OnClickListener {
    public TextView tipoHotel;
    public TextView nomeHotel;
    public TextView chainCodeHotel;
    public TextView roomTypeHotel;
    public TextView roomDescriptionHotel;
    public TextView totalPriceHotel;


    private ItemClickListener itemClickListener;

    public ResultvViewHolderSaveHoteis(@NonNull View itemView) {
        super(itemView);

        this.tipoHotel = (TextView) itemView.findViewById(R.id.typeHotelSave);
        this.nomeHotel = (TextView) itemView.findViewById(R.id.nameHotelSave);
        this.chainCodeHotel = (TextView) itemView.findViewById(R.id.chainCodeSave);
        this.roomTypeHotel = (TextView) itemView.findViewById(R.id.roomTypeSave);
        this.roomDescriptionHotel = (TextView) itemView.findViewById(R.id.roomDescriptionSave);
        this.totalPriceHotel = (TextView) itemView.findViewById(R.id.totalPriceSave);

    }




    @Override
    public void onClick(View v) {
        itemClickListener.onClick(v,getAdapterPosition());
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }
}
