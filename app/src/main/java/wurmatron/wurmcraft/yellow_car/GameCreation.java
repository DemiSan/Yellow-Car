package wurmatron.wurmcraft.yellow_car;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameCreation extends AppCompatActivity {

    public DataHelper dataHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_creation);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        dataHelper = new DataHelper(getBaseContext());
    }

    public void newGame(View view) {
        DataHelper.stopGame();
        DataHelper.deletePlayers();
        sentToUserCreation(view);
    }

    public void sentToUserCreation(View view) {
        Intent intent = new Intent(this, UserCreation.class);
        startActivity(intent);
    }

    public void continueGame(View view) {
        DataHelper.loadPlayers();
        sentToGame(view);
    }

    public void sentToGame(View view) {
        Intent intent = new Intent(this, Game.class);
        startActivity(intent);
    }

    public void sentToRules(View view) {
        Intent intent = new Intent(this, Rules.class);
        startActivity(intent);
    }
}
