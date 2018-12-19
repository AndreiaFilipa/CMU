package projeto.estgf.ipp.pt.projeto;

import android.content.Context;

import java.util.List;

import APIControllers.ControladoresAPI;
import APIControllers.Rotas;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ResultsVoos {

    private Rotas rotas;
    private Data lista;
    private Context contexto;

    public ResultsVoos (Context contexto) {
        this.contexto = contexto;
        this.rotas=ControladoresAPI.getRotas();

    }

    public void resultados (String origin, String destination, String departureDate, String returnDate, int adults) {
        Call<Data> resposta = rotas.searchFlights(origin, destination, departureDate, returnDate, adults);
        resposta.enqueue(new Callback<Data>() {
            @Override
            public void onResponse(Call<Data> call, Response<Data> response) {
                lista = response.body();
            }

            @Override
            public void onFailure(Call<Data> call, Throwable t) {
                t.printStackTrace();
            }
        });

    }


}
