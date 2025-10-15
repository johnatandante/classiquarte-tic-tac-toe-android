package it.volta.ts.quarte.prova.bean;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private int turn;
    private List<Player> players;

    private Player winner;

    public Game() {
        this(0);

    }

    public Game(int turn) {
        this.players = new ArrayList<>();
        this.turn = turn;
    }

    public Player getPlayer() {
        return this.players.get(turn);
    }

    public void nextTurn(){
        turn = (++turn) %2;
    }

    public void addPlayer(String playerName) {
        this.players.add(new Player(playerName));
    }

    public void setWinner(Player player) {
        this.winner = player;
    }

    public Player getWinner() {
        return this.winner;
    }
}
