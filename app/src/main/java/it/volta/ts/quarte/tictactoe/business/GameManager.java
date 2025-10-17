package it.volta.ts.quarte.tictactoe.business;

import it.volta.ts.quarte.tictactoe.bean.Game;
import it.volta.ts.quarte.tictactoe.bean.Player;

public class GameManager {

    private Game game;

    private final Player[][] cells = new Player[3][3];

    public GameManager(Game game) {
        this.game = game;

        init();

    }

    private void init() {
        // init
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                cells[i][j] = null;
            }
        }
    }

    public Player getCurrentPlayer() {
        return this.game.getPlayer();
    }

    public void setMove(int i, int j){
        this.cells[i][j] = this.getCurrentPlayer();
    }

    public void next() {
        this.game.nextTurn();
    }

    public Player checkWinner() {

        Player winner;

        // controllo le diagonali
        winner = checkDiagonals();
        if(winner == null) {
            // controllo le righe
            winner = checkRows();
            if(winner == null) {
                // controllo le colonne
                winner = checkCols();
            }
        }

        if (winner != null) {
            this.game.setWinner(winner);
        }

        return winner;
    }

    private Player checkCols() {
        Player pivot;
        boolean check;

        for(int i = 0; i<3; i++) {
            pivot = this.cells[0][i];
            check = true;
            for(int j = 1; j<3; j++) {
                check = check && pivot != null && pivot.equals(this.cells[j][i]);
            }

            if (check)
                return pivot;
        }

        return null;
    }

    private Player checkRows() {
        Player pivot;
        boolean check;

        for(int i = 0; i<3; i++) {
            pivot = this.cells[i][0];
            check = true;
            for(int j = 1; j<3; j++) {
                check = check && pivot != null && pivot.equals(this.cells[i][j]);
            }
            if (check)
                return pivot;
        }

        return null;
    }

    private Player checkDiagonals() {
        // diag sx
        Player pivot = this.cells[0][0];
        boolean check = true;
        for(int i = 1; i<3; i++)
            check = check && pivot != null && pivot.equals(this.cells[i][i]);
        if (check)
            return pivot;

        // diag dx
        pivot = this.cells[0][2];
        check = true;
        for(int i = 1; i<3; i++)
            check = check && pivot != null && pivot.equals(this.cells[i][2-i]);
        if (check)
            return pivot;

        return null;
    }

    public boolean isOn() {
        return this.game.getWinner() == null;
    }

    public void newGame(Game game) {
        this.game = game;
        init();
    }

    public boolean isSetted(int x, int y) {
        return this.cells[x][y] != null;
    }
}
