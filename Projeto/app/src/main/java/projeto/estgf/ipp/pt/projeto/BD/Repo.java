package projeto.estgf.ipp.pt.projeto.BD;

import android.content.Context;

import java.util.List;

import projeto.estgf.ipp.pt.projeto.Voos.OnGetAllInformation;
import projeto.estgf.ipp.pt.projeto.hoteis.OnGetAllInformationHoteis;

import projeto.estgf.ipp.pt.projeto.NotificaFimRegisto;



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

    public List<InformacoesVoo> getAllVoos(OnGetAllInformation info) {
        new getVoos(dao, info).execute();
        return null;
    }

    public List<InformacoesHotel> getAllHoteis(OnGetAllInformationHoteis infoHoteis) {
        new getHoteis(daoHotel, infoHoteis).execute();
        return null;
    }

    public List<InformacoesRegisto> getAllRegistos(NotificaFimRegisto notificaFimRegisto) {
        new getRegisto(daoRegisto, notificaFimRegisto).execute();
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

    public void deleteInformacoesVoo(InformacoesVoo voo) {
        new DeletePesquisasVoos(dao).execute(voo);
    }

    public void deleteInformacoesHotel(InformacoesHotel hotel) {
        new DeletePesquisasHoteis(daoHotel).execute(hotel);
    }
}
