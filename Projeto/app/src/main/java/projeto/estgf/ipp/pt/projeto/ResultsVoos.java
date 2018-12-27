package projeto.estgf.ipp.pt.projeto;

import android.content.Context;
import APIControllers.ControladoresAPI;
import APIControllers.Rotas;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ResultsVoos {

    private Rotas rotas;
    private Data lista;
    private Context contexto;
    private ResultAdapter adapter;

    public ResultsVoos (Context contexto,ResultAdapter adapter) {
        this.contexto = contexto;
        this.rotas=ControladoresAPI.getRotas();

        this.adapter=adapter;

    }

    public void resultados (String origin, String destination, String departureDate, String returnDate, int adults) {

        Call<Data> resposta = rotas.searchFlights(ControladoresAPI.getToken(),origin, destination, departureDate, returnDate, adults);
        resposta.enqueue(new Callback<Data>() {
            @Override
            public void onResponse(Call<Data> call, Response<Data> response) {
                lista = response.body();

                if(lista != null && lista.getData().size()>0){
                    adapter.addItems(lista.getData());
                }
            }

            @Override
            public void onFailure(Call<Data> call, Throwable t) {
                t.printStackTrace();
            }
        });

    }
    public void resultados (String origin, String destination, String departureDate, int adults) {

        Call<Data> resposta = rotas.searchFlights(ControladoresAPI.getToken(),origin, destination, departureDate, adults);
        resposta.enqueue(new Callback<Data>() {
            @Override
            public void onResponse(Call<Data> call, Response<Data> response) {
                lista = response.body();

                if(lista != null && lista.getData().size()>0){
                    adapter.addItems(lista.getData());
                }
            }

            @Override
            public void onFailure(Call<Data> call, Throwable t) {
                t.printStackTrace();
            }
        });

    }






}
