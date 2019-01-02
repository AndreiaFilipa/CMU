package projeto.estgf.ipp.pt.projeto.hoteis;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import projeto.estgf.ipp.pt.projeto.BD.InformacoesHotel;
import projeto.estgf.ipp.pt.projeto.R;

public class SetupMaps extends AppCompatActivity implements OnMapReadyCallback,GoogleMap.OnMarkerClickListener {

    private SupportMapFragment mMapFragment;
    private GoogleMap mGoogleMap;
    private InformacoesHotel infohotel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup_maps);

        infohotel = (InformacoesHotel) getIntent().getSerializableExtra("Hotel");


        mMapFragment =(SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mMapFragment.getMapAsync(this);
    }

    public void onMapReady(GoogleMap googleMap) {
        mGoogleMap =googleMap;

        mGoogleMap.setOnMarkerClickListener(this);

        LatLng latLng = new LatLng(infohotel.latitude, infohotel.longitude);

        Marker marker = mGoogleMap.addMarker(new MarkerOptions().position(latLng).title(infohotel.chainCodeHotel).snippet(infohotel.nomeHotel));
        zoomToLocation();
    }


    private void zoomToLocation() {
        LatLng latLng = new LatLng(infohotel.latitude, infohotel.longitude);

        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(latLng, 18);

        mGoogleMap.animateCamera(cameraUpdate);
    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        return false;
    }
}
