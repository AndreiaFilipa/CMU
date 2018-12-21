package Hoteis;

import android.content.Context;
import APIControllers.ControladoresAPI;
import APIControllers.Rotas;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ResultsHoteis {
    private Rotas rotas;
    private DataHoteis lista;
    private Context contexto;
    private ResultAdapterHoteis adapter;

    public ResultsHoteis(Context contexto,ResultAdapterHoteis adapter) {
        this.contexto = contexto;
        this.rotas=ControladoresAPI.getRotas();
        this.adapter=adapter;

    }

    public void resultados (String cityCode, String checkInDate, String checkOutDate, int adults) {

        Call<DataHoteis> resposta = rotas.searchHoteis(ControladoresAPI.getToken(), cityCode, checkInDate, checkOutDate, adults);
        resposta.enqueue(new Callback<DataHoteis>() {
            @Override
            public void onResponse(Call<DataHoteis> call, Response<DataHoteis> response) {
                lista = response.body();

                if(lista != null && lista.getData().size()>0){
                    adapter.addItems(lista.getData());
                }
            }

            @Override
            public void onFailure(Call<DataHoteis> call, Throwable t) {
                t.printStackTrace();
            }
        });

    }
}
