package projeto.estgf.ipp.pt.projeto.BD;

import android.os.AsyncTask;

import java.util.List;

public class getVoos extends AsyncTask<Void,Void,Void> {

    private final InformacoesVooDAO dao;
    private Database db;

    public getVoos(InformacoesVooDAO dao) {
        this.dao=dao;
    }


    @Override
    protected Void doInBackground(Void... voids) {

       List<InformacoesVoo> list = dao.getAllVoos();

        return null;
    }
}
