package projeto.estgf.ipp.pt.projeto.BD;

import android.os.AsyncTask;

import java.util.List;

public class SaveHoteisToBD extends AsyncTask<InformacoesHotel,Void,Void> {


    private final InformacoesHotelDAO daoHotel;

    public SaveHoteisToBD(InformacoesHotelDAO daoHotel) {
        this.daoHotel=daoHotel;
    }

    @Override
    protected Void doInBackground(InformacoesHotel... informacoesHoteis) {

        daoHotel.insertHotel(informacoesHoteis[0]);

        return null;
    }
}
