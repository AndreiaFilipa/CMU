package projeto.estgf.ipp.pt.projeto;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import java.net.ContentHandler;

import projeto.estgf.ipp.pt.projeto.hoteis.ProcuraHotel;

import static android.content.Context.ACTIVITY_SERVICE;


public class PesquisaAutomatica extends AsyncTask<ProcuraHotel,Void,ProcuraHotel> {

    private Context context;

    public PesquisaAutomatica(Context context) {
        this.context = context;
    }

    @Override
    protected ProcuraHotel doInBackground(ProcuraHotel... procuraHotels) {
        ActivityManager manager = (ActivityManager) context.getSystemService(ACTIVITY_SERVICE);
        for (ActivityManager.RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
            if ("projeto.estgf.ipp.pt.projeto.Notificacao".equals(service.service.getClassName())) {

                Intent intent = new Intent(context, Notificacao.class);
                context.stopService(intent);

                return null;
            }
        }
        return null;
    }
}
