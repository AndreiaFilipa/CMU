package projeto.estgf.ipp.pt.projeto.Pesquisas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import projeto.estgf.ipp.pt.projeto.R;

public class MenuPesquisasGuardadas extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_pesquisas_guardadas);

        Button temp = (Button) findViewById(R.id.buttonPesqVoos);
        Button temp1 = (Button) findViewById(R.id.buttonPesqHoteis);

        temp.setOnClickListener(this);
        temp1.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.buttonPesqVoos) {
            Intent pesVoo = new Intent(this, PesquisasGuardadasVoos.class);
            startActivity(pesVoo);
        } else if (v.getId() == R.id.buttonPesqHoteis) {
            Intent pesHotel = new Intent(this, PesquisasGuardadasHoteis.class);
            startActivity(pesHotel);
        }
    }
}