package projeto.estgf.ipp.pt.projeto;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;

import projeto.estgf.ipp.pt.projeto.BD.InformacoesVoo;

public class GuardarDialog extends DialogFragment {
    SaveDialogListener listener;
    private InformacoesVoo voo;

    public void setVoo(InformacoesVoo voo) {
        this.voo = voo;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try{
            listener=(SaveDialogListener) context;
        }catch(ClassCastException e){

        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("Deseja guardar na base de dados?")
                .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        if(voo != null){
                            listener.onDialogSaveClick(voo);
                        }else{
                            listener.onDialogSaveClick();
                        }

                    }
                })
                .setNegativeButton("Não", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                       getActivity().finish();
                    }
                });
        // Create the AlertDialog object and return it
        return builder.create();
    }
}
