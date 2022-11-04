package com.example.tictactoe;

import java.util.Random;

public class GameEngine {
    private static final Random RANDOM = new Random();
    private char [] elements;
    private char currentPlayer;
    private boolean ended;

    public GameEngine() {
        elements = new char[9];
        newGame();
    }

    public boolean isEnded() {
        return ended;
    }

    public char play(int x, int y) {
        if(!ended && elements[3*y+x] == ' ') {
            elements[3*y+x] = currentPlayer;
            changePlayer();
        }
        return checkEnd();
    }

    public void changePlayer() {
        currentPlayer = (currentPlayer == 'X' ? 'O' : 'X');
    }

    public char getElement(int x, int y) {
        return elements[3*y+x];
    }

    public void newGame() {
        for(int i = 0; i < elements.length; i++) {
            elements[i] = ' ';
        }
        currentPlayer = 'X';
        ended = false;
    }

    public char checkEnd() {
        for (int i = 0; i < 3; i++) {
            // columns
            if (getElement(i, 0) != ' ' && getElement(i, 0) == getElement(i, 1) && getElement(i, 1) == getElement(i, 2)) {
                ended = true;
                return getElement(i, 0);
            }
            // rows
            if (getElement(0, i) != ' ' && getElement(0, i) == getElement(1, i) && getElement(1, i) == getElement(2, i)) {
                ended = true;
                return getElement(0, i);
            }
        }
        // backslash
        if (getElement(0, 0) != ' ' && getElement(0, 0) == getElement(1, 1) && getElement(1, 1) == getElement(2, 2)) {
            ended = true;
            return getElement(0, 0);
        }
        // slash
        if (getElement(2, 0) != ' ' && getElement(2, 0) == getElement(1, 1) && getElement(1, 1) == getElement(0, 2)) {
            ended = true;
            return getElement(2, 0);
        }
        // tie
        for (int i = 0; i < 9; i++) {
            if (elements[i] == ' ') {
                return ' ';
            }
        }
        return 'T';
    }

    public char computer() {
        if (!ended) {
            int position = -1;
            do {
                position = RANDOM.nextInt(9);
            } while (elements[position] != ' ');
            elements[position] = currentPlayer;
            changePlayer();
        }
        return checkEnd();
    }
}