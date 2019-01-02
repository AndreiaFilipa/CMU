package projeto.estgf.ipp.pt.projeto;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Calendar;
import java.util.List;

import projeto.estgf.ipp.pt.projeto.APIControllers.ControladoresAPI;
import projeto.estgf.ipp.pt.projeto.BD.InformacoesRegisto;
import projeto.estgf.ipp.pt.projeto.BD.Repo;
import projeto.estgf.ipp.pt.projeto.hoteis.SetupMaps;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, DialogRegistoInterface, NotificaFimRegisto,SharedPreferences.OnSharedPreferenceChangeListener {


    private InformacoesRegisto registo;
    private SharedPreferences settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Repo x = new Repo(this);
        x.getAllRegistos(this);

        Button temp = (Button) findViewById(R.id.buttonVoo);
        Button temp1 = (Button) findViewById(R.id.buttonVooHotel);
        Button temp2 = (Button) findViewById(R.id.buttonHotel);

        temp.setOnClickListener(this);
        temp1.setOnClickListener(this);
        temp2.setOnClickListener(this);

        ControladoresAPI.x();
        //Repo y = new Repo(this);
        //x.getAllVoos();
        //x.getAllHoteis();


    }

    @Override
    protected void onResume() {
        super.onResume();

        settings= PreferenceManager.getDefaultSharedPreferences(this);
       VerificaPreferencias();
            settings.registerOnSharedPreferenceChangeListener(this);
    }
public void VerificaPreferencias(){
    boolean temp = settings.getBoolean("notificacao",true);

    if(temp){
        //if(!isMyServiceRunning()){
        LancarServicoNotificao();
    }else{
        PesquisaAutomatica pesquisaAutomatica = new PesquisaAutomatica(this);
        pesquisaAutomatica.execute();
    }
}

    public void LancarServicoNotificao(){

        Intent notificacao = new Intent(this, Notificacao.class);
        notificacao.putExtra("start","start");
        PendingIntent pendingIntent = PendingIntent.getService(this, 0, notificacao, 0);

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY,11);
        cal.set(Calendar.MINUTE,20);

        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,cal.getTimeInMillis(),86400, pendingIntent);
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

    @Override
    public void fimPesquisa(List<InformacoesRegisto> result) {
        if(result.size()==0){
            DialogRegisto y = new DialogRegisto();
            y.show(getSupportFragmentManager(), "my_dialog");
        }
    }


    @Override
    protected void onPause() {
        super.onPause();
        settings.unregisterOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        if(key.equals("notificacao")){
            VerificaPreferencias();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent = new Intent(this, SettingsActivity.class);
            startActivity(intent);

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
