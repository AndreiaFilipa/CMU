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
    private List<Data> lista;
    private Context contexto;

    public ResultsVoos (Context contexto) {
        this.contexto = contexto;
        this.rotas=ControladoresAPI.getRotas();

    }

    public void resultados (String origin, String destination, String departureDate, String returnDate, int adults) {
        Call<List<Data>> resposta = rotas.searchFlights(origin, destination, departureDate, returnDate, adults);
        resposta.enqueue(new Callback<List<Data>>() {
            @Override
            public void onResponse(Call<List<Data>> call, Response<List<Data>> response) {
                lista = response.body();
            }

            @Override
            public void onFailure(Call<List<Data>> call, Throwable t) {
                t.printStackTrace();
            }
        });

    }


}
