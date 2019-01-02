package projeto.estgf.ipp.pt.projeto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import projeto.estgf.ipp.pt.projeto.APIControllers.ControladoresAPI;
import projeto.estgf.ipp.pt.projeto.BD.InformacoesRegisto;
import projeto.estgf.ipp.pt.projeto.BD.Repo;
import projeto.estgf.ipp.pt.projeto.hoteis.SetupMaps;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,DialogRegistoInterface {


private InformacoesRegisto registo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Repo x = new Repo(this);
        x.getAllRegistos();
       // x.getAllVoos();
       // x.getAllHoteis();

        Button temp = (Button) findViewById(R.id.buttonVoo);
        Button temp1 = (Button) findViewById(R.id.buttonVooHotel);
        Button temp2 = (Button) findViewById(R.id.buttonHotel);

        temp.setOnClickListener(this);
        temp1.setOnClickListener(this);
        temp2.setOnClickListener(this);

        ControladoresAPI.x();
        Repo y = new Repo(this);
        //x.getAllVoos();
        //x.getAllHoteis();


    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.buttonVoo){
            Intent voo = new Intent(this,Main2Activity.class);
            startActivity(voo);
        }else if (v.getId()==R.id.buttonHotel){
            Intent hotel = new Intent(this,HotelActivity.class);
            startActivity(hotel);
        }else if(v.getId()==R.id.buttonVooHotel){
            Intent registo = new Intent(this,MenuPesquisasGuardadas.class);
            startActivity(registo);
        }
    }

    @Override
    public void onDialogPositiveClick() {
        Intent i = new Intent(this,Registo_Activity.class);
        startActivity(i);
    }
}
