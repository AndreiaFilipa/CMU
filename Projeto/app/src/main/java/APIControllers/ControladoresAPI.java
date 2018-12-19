package APIControllers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import projeto.estgf.ipp.pt.projeto.Credenciais;
import projeto.estgf.ipp.pt.projeto.Data;
import projeto.estgf.ipp.pt.projeto.Token;
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


}
