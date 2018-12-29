package projeto.estgf.ipp.pt.projeto.BD;

import android.os.AsyncTask;

import java.util.List;

public class getHoteis extends AsyncTask<Void,Void,Void> {

    private final InformacoesHotelDAO daoHotel;

    public getHoteis(InformacoesHotelDAO daoHotel) {
        this.daoHotel=daoHotel;
    }


    @Override
    protected Void doInBackground(Void... voids) {


        List<InformacoesHotel> list = daoHotel.getAllHoteis();
        return null;
    }
}

