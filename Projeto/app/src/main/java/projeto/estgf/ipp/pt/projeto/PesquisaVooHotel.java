package projeto.estgf.ipp.pt.projeto;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class PesquisaVooHotel extends AppCompatActivity {
    private ProcuraVooHotel resultadosPesquisa;
    //private ResultAdapterHoteis adapter;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesquisa_voo_hotel);
        context = this;

        resultadosPesquisa = (ProcuraVooHotel) getIntent().getSerializableExtra("Resultados");



    }
}
