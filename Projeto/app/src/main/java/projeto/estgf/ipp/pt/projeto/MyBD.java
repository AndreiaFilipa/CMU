package projeto.estgf.ipp.pt.projeto;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.migration.Migration;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;

import projeto.estgf.ipp.pt.projeto.hoteis.Room;

@Database(entities = {InformacoesVoo.class},version = 1)
public abstract class MyBD extends RoomDatabase {
    public abstract InformacoesVooDAO dao();

}
