package projeto.estgf.ipp.pt.projeto.BD;

import android.os.AsyncTask;

public class DeletePesquisasVoos extends AsyncTask<InformacoesVoo,Void,Void> {
    private final InformacoesVooDAO dao;

    public DeletePesquisasVoos(InformacoesVooDAO dao) {
        this.dao=dao;
    }

    @Override
    protected Void doInBackground(InformacoesVoo... informacoesVoos) {

        dao.delete(informacoesVoos[0]);

        return null;
    }

}
