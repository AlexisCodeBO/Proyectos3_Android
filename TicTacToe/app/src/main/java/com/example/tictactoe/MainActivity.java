package com.example.tictactoe;

import android.content.DialogInterface;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private BoardView boardView;
    private GameEngine gameEngine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        boardView = (BoardView) findViewById(R.id.board);

        gameEngine = new GameEngine();
        boardView.setGameEngine(gameEngine);
        boardView.setMainActivity(this);

    }

    public void gameEnded(char c) {
        String msg = (c == 'T') ? "Game Ended in a Tie" : "Game Ended - " + c + " is the winner";
        new AlertDialog.Builder(this).setTitle("Tic Tac Toe")
                .setMessage(msg)
                .setOnDismissListener(new DialogInterface.OnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dialog) {
                        newGame();
                    }
                })
                .show();
    }

    private void newGame() {
        gameEngine.newGame();
        boardView.invalidate();
    }
}