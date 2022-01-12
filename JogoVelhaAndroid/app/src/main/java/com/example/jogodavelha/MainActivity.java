package com.example.jogodavelha;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private boolean win = false;
    private TextView answer;
    private char[] board;
    private boolean yourTurn = true;
    private int cont = 0;
    private playerNamesDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        openPlayersDialog();
        board = new char[9];
    }

    public void openPlayersDialog () {
        dialog = new playerNamesDialog();
        dialog.show(getSupportFragmentManager(), "players Dialog");
    }

    public View findViewByString (String name, int i) {
        String buttonID = name + Integer.toString(i);
        int resID = getResources().getIdentifier(buttonID, "id", getPackageName());

        return findViewById(resID);
    }

    private void resetGame () {
        board = new char[9];
        answer.setText("");
        cont = 0;
        win = false;

        for(int x = 1; x <= 9; x++) {
            Button btn = (Button) findViewByString("button", x);

            btn.setTextColor(Color.parseColor("#FFFFFF"));
            btn.setText(String.valueOf(x));
        }
    }

    private boolean checkPositions () {
        boolean check = true;

        for(int x = 0; x < 3; x++) {
            if(board[x] != 0 &&
                    board[x] == board[x+3] &&
                    board[x] == board[x+6]) {
                check = false; // vertical lines
            }

            if(board[x*3] != 0 &&
                    board[x*3] == board[x*3+1] &&
                    board[x*3] == board[x*3+2]) {
                check = false; // horizontal lines
            }
        }

        if(board[0] != 0 && // main diagonal
                board[0] == board[4] &&
                board[0] == board[8]) {
            check = false;
        }

        if(board[2] != 0 && // secondary diagonal
                board[2] == board[4] &&
                board[2] == board[6]) {
            check = false;
        }

        if(!check) {
            win = true;
            answer = findViewById(R.id.winnerMessage);
        }

        cont++;
        return check;
    }

    public void play (View view) {
        Button button = (Button) findViewById(view.getId());
        char symbol = 'X';
        int position;
        String btnText = button.getText().toString();

        if(!btnText.equals("X") && !btnText.equals("O") && !win) {
            if (!yourTurn)
                symbol = 'O';

            position = Integer.parseInt(button.getText().toString());
            board[position - 1] = symbol;

            button.setTextColor(Color.parseColor("#FFC107"));
            button.setText(String.valueOf(symbol));

            if (yourTurn)
                yourTurn = false;
            else
                yourTurn = true;

            if(!checkPositions()) {
                String winnerName;

                if(symbol == 'X')
                    winnerName = dialog.getFirstPlayerName();
                else
                    winnerName = dialog.getSecndPlayerName();

                answer.setText(winnerName + " ganhou a partida!");
            }

            if(cont == 9)
                answer.setText("Empate!");

            if(win || cont == 9) {
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        resetGame();
                    }
                }, 5000);
            }
        }
    }
}