package projeto.estgf.ipp.pt.projeto.BD;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.migration.Migration;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;

@android.arch.persistence.room.Database(entities = {InformacoesVoo.class, InformacoesHotel.class, InformacoesRegisto.class},version = 10)
public abstract class Database extends RoomDatabase {

    public abstract InformacoesVooDAO dao();
    public abstract InformacoesHotelDAO daoHotel();
    public abstract InformacoesRegistoDAO daoRegisto();

    private static  volatile Database INSTANCE;

    public static Database getDatabase(final Context context){
        if(INSTANCE == null){
            synchronized(Database.class){
                if(INSTANCE == null){
                    INSTANCE = android.arch.persistence.room.Room.databaseBuilder(
                            context.getApplicationContext(),Database.class,"database")
                           // .addMigrations(MIGRATION_1_2,MIGRATION_2_3,MIGRATION_3_4)
                            .fallbackToDestructiveMigration()
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

    @VisibleForTesting
    static final Migration MIGRATION_2_3 = new Migration(2,3) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
//            database.execSQL("ALTER TABLE InformacoesHotel" + " ADD COLUMN roomDescriptionHotel TEXT" +
//                    "ADD COLUMN priceHotel TEXT" + "ADD COLUMN roomTypeHotel TEXT" +
//                    "ADD COLUMN tipoHotel TEXT" + "ADD COLUMN nomeHotel TEXT");
     }
    };

    @VisibleForTesting
    static final Migration MIGRATION_3_4 = new Migration(3,4) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {

        }
    };
}
