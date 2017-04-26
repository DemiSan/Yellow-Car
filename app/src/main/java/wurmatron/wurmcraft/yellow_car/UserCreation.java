package wurmatron.wurmcraft.yellow_car;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

public class UserCreation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_user_creation);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        EditText player1 = (EditText) findViewById(R.id.player1);
        player1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    hideKeyboard(v);
                }
            }
        });
        EditText player2 = (EditText) findViewById(R.id.player2);
        player2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    hideKeyboard(v);
                }
            }
        });
        EditText player3 = (EditText) findViewById(R.id.player3);
        player3.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    hideKeyboard(v);
                }
            }
        });
        EditText player4 = (EditText) findViewById(R.id.player4);
        player4.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    hideKeyboard(v);
                }
            }
        });
    }

    private void collectPlayerData() {
        EditText player1 = (EditText) findViewById(R.id.player1);
        if (player1.getText().toString().length() > 0)
            DataHelper.players[0] = player1.getText().toString();
        EditText player2 = (EditText) findViewById(R.id.player2);
        if (player2.getText().toString().length() > 0)
            DataHelper.players[1] = player2.getText().toString();
        EditText player3 = (EditText) findViewById(R.id.player3);
        if (player3.getText().toString().length() > 0)
            DataHelper.players[2] = player3.getText().toString();
        EditText player4 = (EditText) findViewById(R.id.player4);
        if (player4.getText().toString().length() > 0)
            DataHelper.players[3] = player4.getText().toString();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_user_creation, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings)
            return true;
        return super.onOptionsItemSelected(item);
    }

    public void sendMessage(View view) {
        Intent intent = new Intent(this, Game.class);
        collectPlayerData();
        if (DataHelper.players[0] != null)
            startActivity(intent);
    }

    public void hideKeyboard(View view) {
        InputMethodManager inputMethodManager =(InputMethodManager)getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}
