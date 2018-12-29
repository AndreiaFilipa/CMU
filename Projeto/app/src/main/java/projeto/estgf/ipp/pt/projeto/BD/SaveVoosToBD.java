package projeto.estgf.ipp.pt.projeto.BD;

import android.os.AsyncTask;

public class SaveVoosToBD extends AsyncTask<InformacoesVoo,Void,Void> {


    private final InformacoesVooDAO dao;

    public SaveVoosToBD(InformacoesVooDAO dao) {
        this.dao=dao;
    }

    @Override
    protected Void doInBackground(InformacoesVoo... informacoesVoos) {

        dao.insertVoo(informacoesVoos[0]);

        return null;
    }
}
