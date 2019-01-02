package projeto.estgf.ipp.pt.projeto.BD;

import android.os.AsyncTask;

import java.util.List;

import projeto.estgf.ipp.pt.projeto.Voos.OnGetAllInformation;

public class getVoos extends AsyncTask<Void,Void,Void> {

    private final InformacoesVooDAO dao;
    private final OnGetAllInformation info;


    public getVoos(InformacoesVooDAO dao, OnGetAllInformation info) {
        this.dao=dao;
        this.info=info;
    }


    @Override
    protected Void doInBackground(Void... voids) {
        List<InformacoesVoo> list = dao.getAllVoos();
        info.obterInformacao(list);
        return null;
    }
}
