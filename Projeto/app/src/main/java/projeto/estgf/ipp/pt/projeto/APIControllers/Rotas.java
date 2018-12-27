package projeto.estgf.ipp.pt.projeto.APIControllers;

import projeto.estgf.ipp.pt.projeto.hoteis.DataHoteis;
import projeto.estgf.ipp.pt.projeto.Data;
import projeto.estgf.ipp.pt.projeto.Token;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;


public interface Rotas {

    @GET("shopping/flight-offers")
    Call<Data> searchFlights (@Header("Authorization") String token, @Query("origin") String origin, @Query("destination") String destination, @Query("departureDate") String departureDate, @Query("returnDate") String returnDate, @Query("adults") int adults);

    @GET("shopping/flight-offers")
    Call<Data> searchFlights (@Header("Authorization") String token, @Query("origin") String origin, @Query("destination") String destination, @Query("departureDate") String departureDate, @Query("adults") int adults);
//    @FormUrlEncoded
//    @POST("security/oauth2/token")
//    Call<Token> getToken(@Body HashMap<String, String> x);

    @GET("shopping/hotel-offers")
    Call<DataHoteis> searchHoteis (@Header("Authorization") String token, @Query("cityCode") String cityCode, @Query("checkInDate") String checkInDate, @Query("checkOutDate") String checkOutDate, @Query("adults") int adults);

    @FormUrlEncoded
    @POST("security/oauth2/token")
    Call<Token> getToken(@Field("client_id") String x,@Field("client_secret") String y,@Field("grant_type") String z);



}

