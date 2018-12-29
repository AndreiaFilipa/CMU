package projeto.estgf.ipp.pt.projeto.BD;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.io.Serializable;

@Entity
public class InformacoesHotel implements Serializable {
    @PrimaryKey
    @NonNull
    public String tipoHotel;
    public String nomeHotel;
    public String chainCodeHotel;

    public String roomTypeHotel;
    public String roomDescriptionHotel;
    public String priceHotel;
}
