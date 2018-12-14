package APIControllers;

import java.util.List;

import projeto.estgf.ipp.pt.projeto.Data;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface Rotas {

    @Headers("Authorization: Bearer hKCJiBu7kjgQx7VUliqdjXnyKpMu")
    @GET("/shopping/flight-offers")
    Call<List<Data>> searchFlights (@Query("origin") String origin, @Query("destination") int destination, @Query("departureDate") int departureDate, @Query("returnDate") int returnDate, @Query("adults") int adults);




}
