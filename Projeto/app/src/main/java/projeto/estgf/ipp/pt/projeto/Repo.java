package projeto.estgf.ipp.pt.projeto;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.content.Context;

import java.util.List;

public class Repo {
    private InformacoesVooDAO dao;
    private List<InformacoesVoo> allVoos;
    private VoosDatabase db;

    public Repo(Context context){
        this.db = VoosDatabase.getDatabase(context);
        dao=db.dao();
    }

    public List<InformacoesVoo> getAllVoos() {
        new getVoos(dao).execute();
        return null;
    }
    public void insert (InformacoesVoo voo){
        new SaveVoosToBD(dao).execute(voo);
    }

    public void clear(){
        this.db.clearAllTables();
    }
}
