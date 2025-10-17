package it.volta.ts.quarte.tictactoe;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import it.volta.ts.quarte.tictactoe.bean.Game;
import it.volta.ts.quarte.tictactoe.business.GameManager;
import it.volta.ts.quarte.tictactoe.ui.ButtonTriaClickListener;

public class MainActivity extends AppCompatActivity {

    TextView title;
    Button reset;

    Button[][] tria = new Button[][] {
            { null, null, null},
            { null, null, null},
            { null, null, null}
    };

    private GameManager gameManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Game game = new Game();
        game.addPlayer("X");
        game.addPlayer("O");
        gameManager = new GameManager(game);

        title = findViewById(R.id.titolo);

        int i = 0, j = 0;
        tria[i][j++] = findViewById(R.id.tria1);
        tria[i][j++] = findViewById(R.id.tria2);
        tria[i][j] = findViewById(R.id.tria3);
        i++;
        j = 0;
        tria[i][j++] = findViewById(R.id.tria4);
        tria[i][j++] = findViewById(R.id.tria5);
        tria[i][j] = findViewById(R.id.tria6);
        i++;
        j = 0;
        tria[i][j++] = findViewById(R.id.tria7);
        tria[i][j++] = findViewById(R.id.tria8);
        tria[i][j] = findViewById(R.id.tria9);

        for(i = 0; i<3 ; i++) {
            for(j = 0; j<3 ; j++) {
                tria[i][j].setText("");
                tria[i][j].setOnClickListener(
                        new ButtonTriaClickListener(this, tria[i][j], gameManager, i, j));
            }
        }

        reset = findViewById(R.id.reset);

        reset.setOnClickListener( (view) -> {
            for(int  ii = 0; ii<3 ; ii++) {
                for(int jj = 0; jj<3 ; jj++) {
                    tria[ii][jj].setText("");
                    Game newgame = new Game();
                    newgame.addPlayer("X");
                    newgame.addPlayer("O");
                    gameManager.newGame(newgame);

                }
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }
}