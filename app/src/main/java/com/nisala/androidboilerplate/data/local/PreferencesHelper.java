package com.nisala.androidboilerplate.data.local;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.nisala.androidboilerplate.data.model.User;
import com.nisala.androidboilerplate.util.AndroidBoilerplateConstant;

/**
 * Created by nisala on 12,October,2018
 */
public class PreferencesHelper {

    public static void saveToPreferences(Context context, User user, boolean userLoggedInState) {
        final SharedPreferences preferences = context.getSharedPreferences(
                AndroidBoilerplateConstant.PREFERENCES, Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = preferences.edit();

        try {
            editor.putString(
                    AndroidBoilerplateConstant.PREF_KEY_ACCESS_TOKEN, user.token
            );
            editor.putInt(AndroidBoilerplateConstant.PREF_KEY_USER_ID, user.id
            );

            editor.putBoolean(
                    AndroidBoilerplateConstant.PREF_KEY_USER_LOGGED_IN_STATE, userLoggedInState
            );

            editor.apply();
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }

    public static void saveUser(Context context, User user) {
        final SharedPreferences preferences = context.getSharedPreferences(
                AndroidBoilerplateConstant.PREFERENCES, Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = preferences.edit();

        Gson gson = new Gson();
        String userJson = gson.toJson(user);
        editor.putString(AndroidBoilerplateConstant.PREF_KEY_USER, userJson);
        editor.commit();
    }

    public static boolean getUserLoggedInState(Context context) {
        final SharedPreferences prefs = getPreferences(context);

        return prefs.getBoolean(AndroidBoilerplateConstant.PREF_KEY_USER_LOGGED_IN_STATE, false);
    }

    public static String getAccessToken(Context context) {
        final SharedPreferences prefs = getPreferences(context);

        return prefs.getString(AndroidBoilerplateConstant.PREF_KEY_ACCESS_TOKEN, "");
    }

    public static SharedPreferences getPreferences(Context context) {
        return context.getSharedPreferences(AndroidBoilerplateConstant.PREFERENCES, Context.MODE_PRIVATE);
    }

    public static void removePreferences(Context context) {
        SharedPreferences preferences = context.getSharedPreferences(AndroidBoilerplateConstant.PREFERENCES, Context.MODE_PRIVATE);

        preferences.edit().remove(AndroidBoilerplateConstant.PREF_KEY_ACCESS_TOKEN).commit();
        preferences.edit().remove(AndroidBoilerplateConstant.PREF_KEY_USER_ID).commit();

        preferences.edit().putBoolean(
                AndroidBoilerplateConstant.PREF_KEY_USER_LOGGED_IN_STATE, false
        ).commit();
    }

    public static void removeUser(Context context) {
        SharedPreferences preferences = context.getSharedPreferences(AndroidBoilerplateConstant.PREFERENCES, Context.MODE_PRIVATE);

        preferences.edit().remove(AndroidBoilerplateConstant.PREF_KEY_USER).commit();

    }

    public static String getUser(Context context) {
        final SharedPreferences prefs = getPreferences(context);

        return prefs.getString(AndroidBoilerplateConstant.PREF_KEY_USER, "");
    }
}

