package APIControllers;

import java.util.List;

import projeto.estgf.ipp.pt.projeto.Data;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface Rotas {

    @Headers("Authorization: Bearer hKCJiBu7kjgQx7VUliqdjXnyKpMu")
    @GET("shopping/flight-offers")
    Call<Data> searchFlights (@Query("origin") String origin, @Query("destination") String destination, @Query("departureDate") String departureDate, @Query("returnDate") String returnDate, @Query("adults") int adults);




}
