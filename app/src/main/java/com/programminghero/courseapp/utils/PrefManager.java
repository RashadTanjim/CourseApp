package com.programminghero.courseapp.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class PrefManager {
    // Shared preferences file name
    private final String PREF_NAME = "hero";
    //private  PrefManager prefManager;
    private final String IS_FIRST_TIME_LAUNCH = "IsFirstTimeLaunch";

    private final String Version = "Version";
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context _context;
    // shared pref mode
    int PRIVATE_MODE = 0;


    public PrefManager(Context context) {
        this._context = context.getApplicationContext();
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public boolean getVersion() {
        return pref.getBoolean(Version, false);
    }

    public void setVersion(boolean version) {
        editor.putBoolean(Version, version);
        editor.commit();
    }

    public boolean isFirstTimeLaunch() {
        return pref.getBoolean(IS_FIRST_TIME_LAUNCH, true);
    }


    //todo intro screen
    public void setFirstTimeLaunch(boolean isFirstTime) {
        editor.putBoolean(IS_FIRST_TIME_LAUNCH, isFirstTime);
        editor.commit();
    }

    //todo App Version to check app is updated or not
    public void setVersionNumber(String id) {
        editor.putString("VersionNumber", id);
        editor.commit();
    }
    public void setInstalledTime(long now) {
        editor.putLong("APP_INSTALLED_TIME", now);
        editor.commit();
    }

}
