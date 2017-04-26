package wurmatron.wurmcraft.yellow_car;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DataHelper {

    private static SharedPreferences appData;
    private static SharedPreferences.Editor editor;
    public static String[] players = new String[5];

    public DataHelper(Context ctx) {
        appData = ctx.getApplicationContext().getSharedPreferences("playerData", 0);
        editor = appData.edit();
    }

    public static int getPlayerScore(String player) {
        try {
            if (appData.contains(player) && appData.getInt(player, -1) != -1)
                return appData.getInt(player, 0);
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static void setPlayerScore(String player, int amount) {
        editor.putInt(player, amount);
        editor.commit();
    }

    public static void incPlayer(String player) {
        if (getPlayerScore(player) >= 0)
            setPlayerScore(player, getPlayerScore(player) + 1);
    }

    public static void decPlayer(String player) {
        if (getPlayerScore(player) > 0)
            setPlayerScore(player, getPlayerScore(player) - 1);
    }

    public static boolean isRunning() {
        return appData.getInt("status", 0) == 1;
    }

    public static void stopGame() {
        editor.putInt("status", 0);
        editor.commit();
    }

    public static void startGame() {
        editor.putInt("status", 1);
        editor.commit();
    }

    public static void savePlayers() {
        editor.putStringSet("players", new HashSet<>(Arrays.asList(players)));
        editor.commit();
    }

    public static void deletePlayers() {
        Set<String> playerData = appData.getStringSet("players", null);
        if (playerData != null && playerData.size() > 0) {
            for (String data : playerData)
                editor.putString(data, null);
            editor.commit();
        }
    }

    public static void loadPlayers() {
        Set<String> playerData = appData.getStringSet("players", null);
        if (playerData != null) {
            for (int i = 0; i < playerData.size(); i++)
                if (playerData.size() > i)
                    players[i] = playerData.toArray(new String[0])[i];
        }
    }
}
