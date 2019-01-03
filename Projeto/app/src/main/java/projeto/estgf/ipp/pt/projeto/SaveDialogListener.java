package projeto.estgf.ipp.pt.projeto;

import android.support.v4.app.DialogFragment;

import projeto.estgf.ipp.pt.projeto.BD.InformacoesVoo;

public interface SaveDialogListener {
    public void onDialogSaveClick();
    public void onDialogSaveClick(InformacoesVoo vooI);
}
