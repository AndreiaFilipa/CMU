package projeto.estgf.ipp.pt.projeto.BD;

import android.content.Context;

import java.util.List;

public class Repo {
    private Database db;
    private InformacoesVooDAO dao;
    private List<InformacoesVoo> allVoos;
    private InformacoesHotelDAO daoHotel;
    private List<InformacoesHotel> allHoteis;

    public Repo(Context context){
        this.db = Database.getDatabase(context);
        dao=db.dao();
        daoHotel=db.daoHotel();
    }

    public List<InformacoesVoo> getAllVoos() {
        new getVoos(dao).execute();
        return null;
    }

    public List<InformacoesHotel> getAllHoteis() {
        new getHoteis(daoHotel).execute();
        return null;
    }

    public void insert (InformacoesVoo voo){
        new SaveVoosToBD(dao).execute(voo);
    }

    public void insertHoteis (InformacoesHotel hotel){
        new SaveHoteisToBD(daoHotel).execute(hotel);
    }

    public void clear(){
        this.db.clearAllTables();
    }
}