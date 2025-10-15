package it.volta.ts.quarte.prova.ui;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import it.volta.ts.quarte.prova.bean.Player;
import it.volta.ts.quarte.prova.business.GameManager;

public class ButtonTriaClickListener implements View.OnClickListener {

    Button button;
    GameManager gameManager;
    Context context;

    int x, y;

    public ButtonTriaClickListener(Context context, Button button, GameManager gameManager, int x, int y) {
        this.button = button;
        this.gameManager = gameManager;
        this.context = context;
        this.x = x;
        this.y = y;

    }

        @Override
    public void onClick(View v) {

        if(this.gameManager.isSetted(this.x, this.y)) return;
        if(!gameManager.isOn()) return;

        Player player = this.gameManager.getCurrentPlayer();
        this.gameManager.setMove(this.x, this.y);
        button.setText(player.getName());

        gameManager.next();
        Player winne = gameManager.checkWinner();

        if(winne != null)
            Toast.makeText(this.button.getContext(), "The winner is " + winne.getName(), Toast.LENGTH_LONG)
                .show();


    }
}
