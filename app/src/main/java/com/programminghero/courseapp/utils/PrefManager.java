package com.programminghero.courseapp.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;


import java.util.Map;

public class PrefManager {
    private static final String CURRENT_GALAXY = "CURRENT_GALAXY";
    // Shared preferences file name
    private final String PREF_NAME = "hero";
    //basketball variables
    private final String SHOW_USER_HINT = "BasketballUserHint";
    private final String FIRST_TIME_LAUNCH = "FirstTimeLaunch";
    //private  PrefManager prefManager;
    private final String IS_FIRST_TIME_LAUNCH = "IsFirstTimeLaunch";
    private final String SOUNDONOFF = "SOUNDONOFF";
    private final String HOMEMODULEPOSITION = "HOMEMODULEPOSITION";
    private final String ONESIGNALTOKEN = "ONESIGNALTOKEN";
    private final String ONESIGNALAPPID = "ONESIGNALAPPID";
    private final String GOBACK = "GOBACK";
    private final String FIRST = "FIRST";
    private final String SECEND = "SECEND";
    private final String PROMOSTATUS = "PROMOSTATUS";
    private final String CurrentModule = "CurrentModule";
    private final String PrevGem = "PrevGem";
    private final String PrevRank = "PrevRank";
    private final String PrevCrt = "PrevCrt";
    private final String PlanetName = "PlanetName";
    private final String PlanetName2 = "PlanetName2";
    private final String PlanetName3 = "PlanetName3";
    private final String PlanetSize = "PlanetSize";
    private final String PlanetMoving = "PlanetMoving";
    private final String PlanetWeapon = "PlanetWeapon";
    private final String Sound = "Sound";
    private final String Voice = "VOICE";
    private final String VOICESTATUS = "VOICESTATUS";
    private final String LastCompletedPlanet = "LastCompletedPlanet";
    private final String LastCompletedPlanetLast = "LastCompletedPlanetLast";
    private final String PrvGem = "PrvGem";
    private final String Gender = "Gender";
    //Streak
    private final String StreakChallenge = "StreakChallenge";
    private final String StreakCounter = "StreakCounter";
    private final String StreakLastDay = "StreakLastDay";
    private final String TotalStreakChallenge = "TotalStreakChallenge";
    private final String Streak3Day = "Streak3Day";
    private final String Streak6Day = "Streak6Day";
    private final String GenerateName = "GenerateName";
    private final String GenerateID = "GenerateID";
    private final String EventKey = "EventKey";
    private final String OrginalName = "OrginalName";
    private final String Version = "Version";
    private final String USERID = "USERID";
    private final String PREVUSERID = "PREVUSERID";
    private final String VARIABLEGAME = "VARIABLEGAME";
    private final String ContentStatus = "ContentStatus";
    private final String RateStatus = "RateStatus";
    private final String CustomId = "CustomId";
    private final String MileStoneSkip = "MileStoneSkip";
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
