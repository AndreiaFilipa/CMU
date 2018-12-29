package projeto.estgf.ipp.pt.projeto.BD;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface InformacoesRegistoDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertRegisto(InformacoesRegisto... registo);

    @Query("SELECT * FROM informacoesregisto")
    public List<InformacoesRegisto> getAllRegistos();
}
