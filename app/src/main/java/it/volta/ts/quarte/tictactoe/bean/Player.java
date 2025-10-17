package it.volta.ts.quarte.tictactoe.bean;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class Player {

    private final String name;

    public Player(String name){
        this.name = name;

    }

    public String getName(){
        return this.name;
    }

    @NonNull
    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        return obj != null && this.toString().equals(obj.toString());
    }
}
