package projeto.estgf.ipp.pt.projeto;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.migration.Migration;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;

@Database(entities = {InformacoesVoo.class},version = 2)
public abstract class VoosDatabase extends RoomDatabase {

    public abstract InformacoesVooDAO dao();
    private static  volatile VoosDatabase INSTANCE;

    public static VoosDatabase getDatabase(final Context context){
        if(INSTANCE == null){
            synchronized(VoosDatabase.class){
                if(INSTANCE == null){
                    INSTANCE = android.arch.persistence.room.Room.databaseBuilder(
                            context.getApplicationContext(),VoosDatabase.class,"database")
                            .addMigrations(MIGRATION_1_2)
                            .build();
                }
            }
        }
        return  INSTANCE;
    }

    @VisibleForTesting
    static final Migration MIGRATION_1_2 = new Migration(1,2) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {

        }
    };
}
