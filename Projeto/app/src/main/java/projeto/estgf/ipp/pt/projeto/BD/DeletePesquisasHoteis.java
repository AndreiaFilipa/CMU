package projeto.estgf.ipp.pt.projeto.BD;

import android.os.AsyncTask;

public class DeletePesquisasHoteis extends AsyncTask<InformacoesHotel,Void,Void> {
    private final InformacoesHotelDAO daoHotel;

    public DeletePesquisasHoteis(InformacoesHotelDAO daoHotel) {
        this.daoHotel=daoHotel;
    }

    @Override
    protected Void doInBackground(InformacoesHotel... informacoesHoteis) {

        daoHotel.delete(informacoesHoteis[0]);

        return null;
    }
}
