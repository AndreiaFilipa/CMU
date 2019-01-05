package projeto.estgf.ipp.pt.projeto.Registo;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;

public class DialogRegisto extends DialogFragment {
    DialogRegistoInterface mListener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mListener =	(DialogRegistoInterface) context;
        }	catch (ClassCastException	e)	{ }
    }


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("Tem que realizar registo na aplicação")
                .setPositiveButton("Registar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        mListener.onDialogPositiveClick();
                    }
                });

        // Create the AlertDialog object and return it
        return builder.create();
    }




}
