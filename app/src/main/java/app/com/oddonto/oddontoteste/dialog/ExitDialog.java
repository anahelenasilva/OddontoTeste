package app.com.oddonto.oddontoteste.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import app.com.oddonto.oddontoteste.R;

public class ExitDialog extends DialogFragment implements DialogInterface.OnClickListener {

    private ExitDialogListener exitDialogListener;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
       return new AlertDialog.Builder(getActivity())
                              .setTitle("Título do Dialog")
                              .setMessage("Mensagem do Dialog")
                              .setPositiveButton("Ok", this)
                              .setNegativeButton("Não", this)
                              .create();

        /*return new AlertDialog.Builder(getActivity())
                              .setView(getActivity().getLayoutInflater().inflate(R.layout.nome_qualquer)).create();*/
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (!(context instanceof ExitDialogListener)) {
            throw new RuntimeException("Implementar a interface ExitDialogListener");
        }

        exitDialogListener = (ExitDialogListener)context;
    }

    @Override
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == AlertDialog.BUTTON_POSITIVE) {
            exitDialogListener.onExit();
        }
    }

    public interface ExitDialogListener {
        void onExit();
    }
}
