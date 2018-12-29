package projeto.estgf.ipp.pt.projeto.BD;

import android.os.AsyncTask;

import java.util.List;

public class getVoos extends AsyncTask<Void,Void,Void> {

    private final InformacoesVooDAO dao;
    private Database db;

    public getVoos(InformacoesVooDAO dao, Database db) {
        this.dao=dao;
        this.db=db;
    }


    @Override
    protected Void doInBackground(Void... voids) {

        List<InformacoesVoo> list = dao.getAllVoos();

    //db.clearAllTables();
        return null;
    }
}
