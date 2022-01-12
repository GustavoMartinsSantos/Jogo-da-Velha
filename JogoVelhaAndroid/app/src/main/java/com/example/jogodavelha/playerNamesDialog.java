package com.example.jogodavelha;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatDialogFragment;

public class playerNamesDialog extends AppCompatDialogFragment {
    private EditText firstPlayer;
    private EditText secndPlayer;

    public String getFirstPlayerName () {
        return firstPlayer.getText().toString();
    }

    public String getSecndPlayerName () {
        return secndPlayer.getText().toString();
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.player_names, null);

        builder.setView(view)
                .setTitle("Player Names")
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

        firstPlayer = view.findViewById(R.id.firstPlayer);
        secndPlayer = view.findViewById(R.id.secndPlayer);

        return builder.create();
    }
}
