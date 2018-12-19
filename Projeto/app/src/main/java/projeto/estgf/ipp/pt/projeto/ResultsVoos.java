package projeto.estgf.ipp.pt.projeto;

import android.content.Context;

import java.util.HashMap;
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
    private ResultAdapter adapter;

    public ResultsVoos (Context contexto,ResultAdapter adapter) {
        this.contexto = contexto;
        this.rotas=ControladoresAPI.getRotas();

        this.adapter=adapter;

    }

    public void resultados (String origin, String destination, String departureDate, String returnDate, int adults) {
        getTokenFromInternet();
        Call<Data> resposta = rotas.searchFlights("aaa",origin, destination, departureDate, returnDate, adults);
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




    private void getTokenFromInternet(){
        HashMap<String, String> x = new HashMap<>();
        x.put("client_id","F6S9EKulXA3pAGduv0miIlvHVLNQeG1u");

        x.put("client_secret","WK1CGi5OQBpeOjeo");

        x.put("grant_type","client_credentials");

        Call<Token> resposta = rotas.getToken(x);
        resposta.enqueue(new Callback<Token>() {
            @Override
            public void onResponse(Call<Token> call, Response<Token> response) {
               Token token = response.body();
              //  ready = true;

            }

            @Override
            public void onFailure(Call<Token> call, Throwable t) {
                t.printStackTrace();
              //  ready = true;
            }
        });
    }


}
