package projeto.estgf.ipp.pt.projeto;

import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.IntentService;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import projeto.estgf.ipp.pt.projeto.BD.InformacoesRegisto;
import projeto.estgf.ipp.pt.projeto.BD.Repo;
import projeto.estgf.ipp.pt.projeto.hoteis.PesquisaHoteis;
import projeto.estgf.ipp.pt.projeto.hoteis.ProcuraHotel;

public class Notificacao extends IntentService implements NotificaFimRegisto {

    private final String CHANNEL_ID= "C8";
    private int notificationID = 8;

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     */
    public Notificacao() {
        super("merda");
    }


    @Override
    protected void onHandleIntent(Intent intent) {


            createNotificationChannel();
            Repo repo = new Repo(this);
            repo.getAllRegistos(this);



    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = getString(R.string.channel_name);
            String description = getString(R.string.channel_description);
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);

            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }

    @Override
    public void fimPesquisa(List<InformacoesRegisto> result) {

        if(result.size()>0){
            NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this, CHANNEL_ID)
                    .setSmallIcon(R.drawable.ic_launcher_background)
                    .setContentTitle("Oportunidade")
                    .setContentText("Oportunidade de reserva num hotel no seu destino de preferência")
                    .setStyle(new NotificationCompat.BigTextStyle().bigText("Oportunidade"))
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT);

            Intent intent= new Intent(this, PesquisaHoteis.class);

            InformacoesRegisto informacoesRegisto=result.get(0);
            ProcuraHotel procuraHotel = new ProcuraHotel();
            procuraHotel.setCidadeDestino(informacoesRegisto.ciadadePreferencia);
            Calendar cal = Calendar.getInstance();
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            procuraHotel.setDataCheckIn(dateFormat.format(cal.getTime()));

            cal.add(Calendar.DAY_OF_YEAR,2);

            procuraHotel.setDataCheckOut(dateFormat.format(cal.getTime()));

            procuraHotel.setHospedes("1");
            intent.putExtra("Resultados",procuraHotel);
            PendingIntent resultPendingIntent = PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);

            mBuilder.setContentIntent(resultPendingIntent);

            NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);

            notificationManager.notify(notificationID,mBuilder.build());
        }

    }


    private boolean isMyServiceRunning() {
        ActivityManager manager = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
        for (ActivityManager.RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
            if ("projeto.estgf.ipp.pt.projeto.Notificacao".equals(service.service.getClassName())) {
                return true;
            }
        }
        return false;
    }
}
