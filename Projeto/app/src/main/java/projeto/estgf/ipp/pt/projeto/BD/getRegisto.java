package projeto.estgf.ipp.pt.projeto.BD;

import android.os.AsyncTask;

import java.util.List;

import projeto.estgf.ipp.pt.projeto.NotificaFimRegisto;

public class getRegisto extends AsyncTask<Void,Void,List<InformacoesRegisto>> {

    private final InformacoesRegistoDAO daoRegisto;
    private final NotificaFimRegisto notificaFimRegisto;

    public getRegisto(InformacoesRegistoDAO daoRegisto, NotificaFimRegisto notificaFimRegisto) {
        this.daoRegisto=daoRegisto;
        this.notificaFimRegisto=notificaFimRegisto;
    }

    @Override
    protected List<InformacoesRegisto> doInBackground(Void... voids) {


        List<InformacoesRegisto> list = daoRegisto.getAllRegistos();

        return list;
    }

    @Override
    protected void onPostExecute(List<InformacoesRegisto> informacoesRegistos) {
        super.onPostExecute(informacoesRegistos);

        notificaFimRegisto.fimPesquisa(informacoesRegistos);
    }
}
