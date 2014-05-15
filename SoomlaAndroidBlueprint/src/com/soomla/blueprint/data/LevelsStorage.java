package com.soomla.blueprint.data;

import com.soomla.blueprint.Blueprint;
import com.soomla.blueprint.Level;
import com.soomla.store.data.StorageManager;

/**
 * Created by refaelos on 13/05/14.
 */
public class LevelsStorage {

    private static String keyLevels(String levelId, String postfix) {
        return Blueprint.DB_KEY_PREFIX + "levels." + levelId + "." + postfix;
    }

    private static String keyTimesStarted(String levelId) {
        return keyLevels(levelId, "started");
    }

    private static String keyTimesPlayed(String levelId) {
        return keyLevels(levelId, "played");
    }

    private static String keySlowestDuration(String levelId) {
        return keyLevels(levelId, "slowest");
    }

    private static String keyFastestDuration(String levelId) {
        return keyLevels(levelId, "fastest");
    }


    /** Level Duration **/

    public static void setSlowestDuration(Level level, double duration) {
        String levelId = level.getWorldId();
        String key = keySlowestDuration(levelId);
        String val = String.valueOf(duration);

        StorageManager.getKeyValueStorage().setValue(key, val);
    }

    public static double getSlowestDuration(Level level) {
        String levelId = level.getWorldId();
        String key = keySlowestDuration(levelId);
        String val = StorageManager.getKeyValueStorage().getValue(key);

        return val == null ? Double.MIN_VALUE : Double.parseDouble(val);
    }

    public static void setFastestDuration(Level level, double duration) {
        String levelId = level.getWorldId();
        String key = keyFastestDuration(levelId);
        String val = String.valueOf(duration);

        StorageManager.getKeyValueStorage().setValue(key, val);
    }

    public static double getFastestDuration(Level level) {
        String levelId = level.getWorldId();
        String key = keyFastestDuration(levelId);
        String val = StorageManager.getKeyValueStorage().getValue(key);

        return val == null ? Double.MAX_VALUE : Double.parseDouble(val);
    }



    /** Level Times Started **/

    public static int incTimesStarted(Level level){

        int started = getTimesStarted(level);
        if (started < 0) { /* can't be negative */
            started = 0;
        }
        String levelId = level.getWorldId();
        String startedStr = "" + (started + 1);
        String key = keyTimesStarted(levelId);
        StorageManager.getKeyValueStorage().setValue(key, startedStr);

        return started+1;
    }

    public static int decTimesStarted(Level level){

        int started = getTimesStarted(level);
        if (started <= 0) { /* can't be negative or zero */
            return 0;
        }
        String levelId = level.getWorldId();
        String startedStr = "" + (started - 1);
        String key = keyTimesStarted(levelId);
        StorageManager.getKeyValueStorage().setValue(key, startedStr);

        return started-1;
    }

    public static int getTimesStarted(Level level){

        String levelId = level.getWorldId();
        String key = keyTimesStarted(levelId);
        String val = StorageManager.getKeyValueStorage().getValue(key);

        int started = 0;
        if (val != null) {
            started = Integer.parseInt(val);
        }

        return started;
    }


    /** Level Times Played **/

    public static int incTimesPlayed(Level level){

        int played = getTimesPlayed(level);
        if (played < 0) { /* can't be negative */
            played = 0;
        }
        String levelId = level.getWorldId();
        String playedStr = "" + (played + 1);
        String key = keyTimesPlayed(levelId);
        StorageManager.getKeyValueStorage().setValue(key, playedStr);

        return played+1;
    }

    public static int decTimesPlayed(Level level){

        int played = getTimesPlayed(level);
        if (played <= 0) { /* can't be negative or zero */
            return 0;
        }
        String levelId = level.getWorldId();
        String playedStr = "" + (played - 1);
        String key = keyTimesPlayed(levelId);
        StorageManager.getKeyValueStorage().setValue(key, playedStr);

        return played-1;
    }

    public static int getTimesPlayed(Level level){

        String levelId = level.getWorldId();
        String key = keyTimesPlayed(levelId);
        String val = StorageManager.getKeyValueStorage().getValue(key);

        int played = 0;
        if (val != null) {
            played = Integer.parseInt(val);
        }

        return played;
    }

}
