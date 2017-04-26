package wurmatron.wurmcraft.yellow_car;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Game extends AppCompatActivity {

    public DataHelper dataHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        dataHelper = new DataHelper(getBaseContext());
        handlePlayerStartup(0, (TextView) findViewById(R.id.player1Text), (Button) findViewById(R.id.player1Yellow), (Button) findViewById(R.id.player1Green), (TextView) findViewById(R.id.player1Score), false);
        handlePlayerStartup(1, (TextView) findViewById(R.id.player2Text), (Button) findViewById(R.id.player2Yellow), (Button) findViewById(R.id.player2Green), (TextView) findViewById(R.id.player2Score), false);
        handlePlayerStartup(2, (TextView) findViewById(R.id.player3Text), (Button) findViewById(R.id.player3Yellow), (Button) findViewById(R.id.player3Green), (TextView) findViewById(R.id.player3Score), false);
        handlePlayerStartup(3, (TextView) findViewById(R.id.player4Text), (Button) findViewById(R.id.player4Yellow), (Button) findViewById(R.id.player4Green), (TextView) findViewById(R.id.player4Score), false);
        DataHelper.startGame();
    }

    @Override
    protected void onPause() {
        super.onPause();
        DataHelper.savePlayers();
    }

    public void handlePlayerStartup(int playerIndex, TextView playerText, Button yellowButton, Button greenButton, TextView scoreText, boolean resetScore) {
        if (dataHelper.players.length > playerIndex && dataHelper.players[playerIndex] != null && dataHelper.players[playerIndex].length() > 0) {
            playerText.setText(dataHelper.players[playerIndex]);
            playerText.setTextColor(Global.NAME);
            if (dataHelper.getPlayerScore(dataHelper.players[playerIndex]) == -1 || resetScore)
                dataHelper.setPlayerScore(dataHelper.players[playerIndex], 0);
            scoreText.setText("" + dataHelper.getPlayerScore(dataHelper.players[playerIndex]));
            scoreText.setTextColor(Global.DEFAULT_COLOR);
        } else {
            playerText.setVisibility(View.GONE);
            yellowButton.setVisibility(View.GONE);
            greenButton.setVisibility(View.GONE);
            scoreText.setVisibility(View.GONE);
        }
    }

    private void update() {
        updatePlayer1();
        updatePlayer2();
        updatePlayer3();
        updatePlayer4();
    }

    private void updatePlayer1() {
        TextView view = (TextView) findViewById(R.id.player1Score);
        int score = DataHelper.getPlayerScore(DataHelper.players[0]);
        view.setText("" + score);
        if (score == 0)
            view.setTextColor(Color.RED);
        else if (score <= 5)
            view.setTextColor(Color.YELLOW);
        else if (score <= 20)
            view.setTextColor(Color.GREEN);
        else if (score >= 50)
            view.setTextColor(Color.BLUE);
    }

    private void updatePlayer2() {
        TextView view = (TextView) findViewById(R.id.player2Score);
        int score = DataHelper.getPlayerScore(DataHelper.players[1]);
        view.setText("" + score);
        if (score == 0)
            view.setTextColor(Color.RED);
        else if (score <= 5)
            view.setTextColor(Color.YELLOW);
        else if (score <= 20)
            view.setTextColor(Color.GREEN);
        else if (score >= 50)
            view.setTextColor(Color.BLUE);
    }

    private void updatePlayer3() {
        TextView view = (TextView) findViewById(R.id.player3Score);
        int score = DataHelper.getPlayerScore(DataHelper.players[2]);
        view.setText("" + score);
        if (score == 0)
            view.setTextColor(Color.RED);
        else if (score <= 5)
            view.setTextColor(Color.YELLOW);
        else if (score <= 20)
            view.setTextColor(Color.GREEN);
        else if (score >= 50)
            view.setTextColor(Color.BLUE);
    }

    private void updatePlayer4() {
        TextView view = (TextView) findViewById(R.id.player4Score);
        int score = DataHelper.getPlayerScore(DataHelper.players[3]);
        view.setText("" + score);
        if (score == 0)
            view.setTextColor(Color.RED);
        else if (score <= 5)
            view.setTextColor(Color.YELLOW);
        else if (score <= 20)
            view.setTextColor(Color.GREEN);
        else if (score >= 50)
            view.setTextColor(Color.BLUE);
    }


    public void player1Yellow(View view) {
        DataHelper.incPlayer(DataHelper.players[0]);
        update();
    }

    public void player1Green(View view) {
        if (DataHelper.players[1] != null && DataHelper.players[1].length() > 0 && DataHelper.getPlayerScore(DataHelper.players[1]) > 0)
            DataHelper.decPlayer(DataHelper.players[1]);
        if (DataHelper.players[2] != null && DataHelper.players[2].length() > 0 && DataHelper.getPlayerScore(DataHelper.players[2]) > 0)
            DataHelper.decPlayer(DataHelper.players[2]);
        if (DataHelper.players[3] != null && DataHelper.players[3].length() > 0 && DataHelper.getPlayerScore(DataHelper.players[3]) > 0)
            DataHelper.decPlayer(DataHelper.players[3]);
        update();
    }

    public void player2Yellow(View view) {
        DataHelper.incPlayer(DataHelper.players[1]);
        update();
    }

    public void player2Green(View view) {
        if (DataHelper.players[0] != null && DataHelper.players[0].length() > 0 && DataHelper.getPlayerScore(DataHelper.players[0]) > 0)
            DataHelper.decPlayer(DataHelper.players[0]);
        if (DataHelper.players[2] != null && DataHelper.players[2].length() > 0 && DataHelper.getPlayerScore(DataHelper.players[2]) > 0)
            DataHelper.decPlayer(DataHelper.players[2]);
        if (DataHelper.players[3] != null && DataHelper.players[3].length() > 0 && DataHelper.getPlayerScore(DataHelper.players[3]) > 0)
            DataHelper.decPlayer(DataHelper.players[3]);
        update();
    }

    public void player3Yellow(View view) {
        DataHelper.incPlayer(DataHelper.players[2]);
        update();
    }

    public void player3Green(View view) {
        if (DataHelper.players[1] != null && DataHelper.players[1].length() > 0 && DataHelper.getPlayerScore(DataHelper.players[1]) > 0)
            DataHelper.decPlayer(DataHelper.players[1]);
        if (DataHelper.players[0] != null && DataHelper.players[0].length() > 0 && DataHelper.getPlayerScore(DataHelper.players[0]) > 0)
            DataHelper.decPlayer(DataHelper.players[0]);
        if (DataHelper.players[3] != null && DataHelper.players[3].length() > 0 && DataHelper.getPlayerScore(DataHelper.players[3]) > 0)
            DataHelper.decPlayer(DataHelper.players[3]);
        update();
    }

    public void player4Yellow(View view) {
        DataHelper.incPlayer(DataHelper.players[3]);
        update();
    }

    public void player4Green(View view) {
        if (DataHelper.players[1] != null && DataHelper.players[1].length() > 0 && DataHelper.getPlayerScore(DataHelper.players[1]) > 0)
            DataHelper.decPlayer(DataHelper.players[1]);
        if (DataHelper.players[2] != null && DataHelper.players[2].length() > 0 && DataHelper.getPlayerScore(DataHelper.players[2]) > 0)
            DataHelper.decPlayer(DataHelper.players[2]);
        if (DataHelper.players[0] != null && DataHelper.players[0].length() > 0 && DataHelper.getPlayerScore(DataHelper.players[0]) > 0)
            DataHelper.decPlayer(DataHelper.players[0]);
        update();
    }
}
