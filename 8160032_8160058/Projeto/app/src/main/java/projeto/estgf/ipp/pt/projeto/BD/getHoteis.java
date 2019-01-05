package projeto.estgf.ipp.pt.projeto.BD;

import android.os.AsyncTask;

import java.util.List;

import projeto.estgf.ipp.pt.projeto.hoteis.OnGetAllInformationHoteis;

public class getHoteis extends AsyncTask<Void,Void,Void> {

    private final InformacoesHotelDAO daoHotel;
    private final OnGetAllInformationHoteis infoH;

    public getHoteis(InformacoesHotelDAO daoHotel, OnGetAllInformationHoteis infoH) {
        this.daoHotel=daoHotel;
        this.infoH=infoH;
    }


    @Override
    protected Void doInBackground(Void... voids) {
        List<InformacoesHotel> list = daoHotel.getAllHoteis();
        infoH.obterInformacaoHoteis(list);
        return null;
    }
}

