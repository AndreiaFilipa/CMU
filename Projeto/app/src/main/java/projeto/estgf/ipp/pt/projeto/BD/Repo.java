package projeto.estgf.ipp.pt.projeto.BD;

import android.content.Context;

import java.util.List;

public class Repo {
    private Database db;
    private InformacoesVooDAO dao;
    private List<InformacoesVoo> allVoos;
    private InformacoesHotelDAO daoHotel;
    private List<InformacoesHotel> allHoteis;
    private InformacoesRegistoDAO daoRegisto;
    private List<InformacoesRegisto> allRegistos;
    private Context context;

    public Repo(Context context){
        this.db = Database.getDatabase(context);
        dao=db.dao();
        daoHotel=db.daoHotel();
        daoRegisto=db.daoRegisto();
        this.context=context;
    }

    public List<InformacoesVoo> getAllVoos() {
        new getVoos(dao,db).execute();
        return null;
    }

    public List<InformacoesHotel> getAllHoteis() {
        new getHoteis(daoHotel).execute();
        return null;
    }

    public List<InformacoesRegisto> getAllRegistos() {
        new getRegisto(daoRegisto,context).execute();
        return null;
    }

    public void insert (InformacoesVoo voo){
        new SaveVoosToBD(dao).execute(voo);
    }

    public void insertHoteis (InformacoesHotel hotel){
        new SaveHoteisToBD(daoHotel).execute(hotel);
    }

    public void insertRegisto (InformacoesRegisto registo){
        new SaveRegistoToBD(daoRegisto).execute(registo);
    }

    public void clear(){
        this.db.clearAllTables();
    }
}
