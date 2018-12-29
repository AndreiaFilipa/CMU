package projeto.estgf.ipp.pt.projeto.BD;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;
@Dao
public interface InformacoesHotelDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertHotel(InformacoesHotel... hoteis);

    @Query("SELECT * FROM informacoeshotel")
    public List<InformacoesHotel> getAllHoteis();
}
