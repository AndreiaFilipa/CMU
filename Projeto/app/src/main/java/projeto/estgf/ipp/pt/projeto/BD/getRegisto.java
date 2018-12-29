package projeto.estgf.ipp.pt.projeto.BD;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;

import java.util.List;

import projeto.estgf.ipp.pt.projeto.DialogRegisto;

public class getRegisto extends AsyncTask<Void,Void,Void> {

    private final InformacoesRegistoDAO daoRegisto;
    private final Context context;

    public getRegisto(InformacoesRegistoDAO daoRegisto, Context context) {
        this.daoRegisto=daoRegisto;
        this.context=context;
    }

    @Override
    protected Void doInBackground(Void... voids) {


        List<InformacoesRegisto> list = daoRegisto.getAllRegistos();

        if(list.size()==0){
            DialogRegisto y = new DialogRegisto();
            y.show(((AppCompatActivity)context).getSupportFragmentManager(), "my_dialog");
        }
        return null;
    }
}
