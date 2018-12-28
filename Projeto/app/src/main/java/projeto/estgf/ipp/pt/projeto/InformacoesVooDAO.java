package projeto.estgf.ipp.pt.projeto;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface InformacoesVooDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertVoo(InformacoesVoo ... voos);

    @Query("SELECT * FROM informacoesvoo")
    public List<InformacoesVoo> getAllVoos();
}
