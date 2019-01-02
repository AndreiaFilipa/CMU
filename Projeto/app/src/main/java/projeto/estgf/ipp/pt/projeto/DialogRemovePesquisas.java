package projeto.estgf.ipp.pt.projeto;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;

import projeto.estgf.ipp.pt.projeto.BD.Repo;

public class DialogRemovePesquisas  extends DialogFragment {

    private LongPressRemove removePesquisas;

    public void setRemovePesquisas(LongPressRemove removePesquisas) {
        this.removePesquisas = removePesquisas;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try{
            removePesquisas=(LongPressRemove) context;
        }catch(ClassCastException e){

        }
    }

    public Dialog onCreateDialog (Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("Deseja eliminar esta pesquisa?")
                .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        if(removePesquisas != null) {
                            removePesquisas.removePesquisas();
                        }
                        dialog.dismiss();
                    }
                })
                .setNegativeButton("Não", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                });

        return builder.create();
    }

}
