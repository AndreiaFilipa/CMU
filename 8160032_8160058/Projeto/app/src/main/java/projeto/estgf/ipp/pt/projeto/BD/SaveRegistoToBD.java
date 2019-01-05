package projeto.estgf.ipp.pt.projeto.BD;

import android.os.AsyncTask;

public class SaveRegistoToBD extends AsyncTask<InformacoesRegisto,Void,Void> {

    private final InformacoesRegistoDAO daoRegisto;

    public SaveRegistoToBD(InformacoesRegistoDAO daoRegisto) {
        this.daoRegisto=daoRegisto;
    }

    @Override
    protected Void doInBackground(InformacoesRegisto... informacoesRegistos) {

        daoRegisto.insertRegisto(informacoesRegistos[0]);

        return null;
    }
}
