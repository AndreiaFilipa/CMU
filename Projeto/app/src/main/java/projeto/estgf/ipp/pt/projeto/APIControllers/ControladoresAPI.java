package projeto.estgf.ipp.pt.projeto.APIControllers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Calendar;

import projeto.estgf.ipp.pt.projeto.Voos.Token;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ControladoresAPI {

    private static Retrofit retrofit;
    private static Gson gson;
    private static final String BASE_URL = "https://test.api.amadeus.com/v1/";
    private static Rotas rotas;
    private static Token token;
    private static Calendar expireDate;
    private static boolean ready;

    public static Rotas getRotas () {

        if (retrofit == null && gson == null) {
            gson = new GsonBuilder().setLenient().create();

            retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create(gson)).build();

            rotas = retrofit.create(Rotas.class);


        }

        return rotas;
    }

    public static String getToken(){
        if(token != null){
            return "Bearer " +token.getAccess_token();
        }else{
            return null;
        }

    }

    public static void x(){
        getRotas();
        Call<Token> resposta = rotas.getToken("F6S9EKulXA3pAGduv0miIlvHVLNQeG1u","WK1CGi5OQBpeOjeo","client_credentials");
        resposta.enqueue(new Callback<Token>() {
            @Override
            public void onResponse(Call<Token> call, Response<Token> response) {
                token = response.body();
                ready = true;

            }

            @Override
            public void onFailure(Call<Token> call, Throwable t) {
                t.printStackTrace();
                ready = true;
            }
        });
    }

    public static boolean isReady(){
        return ready;
    }


}

