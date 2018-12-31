package projeto.estgf.ipp.pt.projeto.BD;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {InformacoesVoo.class,InformacoesHotel.class,InformacoesRegisto.class},version = 1)
public abstract class MyBD extends RoomDatabase {
    public abstract InformacoesVooDAO dao();
    public abstract InformacoesHotelDAO daoHotel();
    public abstract InformacoesRegistoDAO daoRegisto();

}
