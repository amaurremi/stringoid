package com.jaysquared.games.whereishd.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;

public class PersistantSettings
{
  private static final String KEY_DISTANCE_UNIT = "mileskm";
  private static final String KEY_LANGUAGE = "language";
  private static final String KEY_LEVEL = "level";
  private static final String KEY_NUMBER_OF_ROUNDS = "numrounds";
  private static final String KEY_PLAY = "play";
  private static final String KEY_REMOVE_ADS = "removeads";
  private static final String KEY_TIMER = "timer";
  private static final String KEY_VERSION = "version";
  private final SharedPreferences preferences;
  
  public PersistantSettings(Context paramContext)
  {
    this.preferences = PreferenceManager.getDefaultSharedPreferences(paramContext);
  }
  
  private void putBoolean(String paramString, boolean paramBoolean)
  {
    synchronized (this.preferences)
    {
      SharedPreferences.Editor localEditor = this.preferences.edit();
      localEditor.putBoolean(paramString, paramBoolean);
      localEditor.commit();
      return;
    }
  }
  
  private void putInt(String paramString, int paramInt)
  {
    synchronized (this.preferences)
    {
      SharedPreferences.Editor localEditor = this.preferences.edit();
      localEditor.putInt(paramString, paramInt);
      localEditor.commit();
      return;
    }
  }
  
  private void putString(String paramString1, String paramString2)
  {
    synchronized (this.preferences)
    {
      SharedPreferences.Editor localEditor = this.preferences.edit();
      localEditor.putString(paramString1, paramString2);
      localEditor.commit();
      return;
    }
  }
  
  public DistanceUnit getDistanceUnit()
  {
    DistanceUnit localDistanceUnit = DistanceUnit.KILOMETERS;
    return DistanceUnit.get(this.preferences.getInt("mileskm", localDistanceUnit.value()));
  }
  
  public GameDifficulty getGameDifficulty()
  {
    GameDifficulty localGameDifficulty = GameDifficulty.EASY;
    return GameDifficulty.get(this.preferences.getInt("level", localGameDifficulty.value()));
  }
  
  public Language getLanguage()
  {
    Language localLanguage = Language.EN;
    return Language.get(this.preferences.getString("language", localLanguage.value()));
  }
  
  public int getNumerOfRounds()
  {
    return this.preferences.getInt("numrounds", 0);
  }
  
  public PayStatus getPayStatus()
  {
    if (PayStatus.NOADS == PayStatus.NOADS) {}
    for (boolean bool = true; this.preferences.getBoolean("removeads", bool); bool = false) {
      return PayStatus.NOADS;
    }
    return PayStatus.FREE;
  }
  
  @Deprecated
  public boolean getPlay()
  {
    return this.preferences.getBoolean("play", false);
  }
  
  public GuessTimer getTimer()
  {
    GuessTimer localGuessTimer = GuessTimer.OFF;
    return GuessTimer.get(this.preferences.getInt("timer", localGuessTimer.value()));
  }
  
  public int getVersionCode()
  {
    return this.preferences.getInt("version", -1);
  }
  
  public void setDistanceUnit(DistanceUnit paramDistanceUnit)
  {
    putInt("mileskm", paramDistanceUnit.value());
  }
  
  public void setGameDifficulty(GameDifficulty paramGameDifficulty)
  {
    putInt("level", paramGameDifficulty.value());
  }
  
  public void setLanguage(Language paramLanguage)
  {
    putString("language", paramLanguage.value());
  }
  
  public void setNumerOfRounds(int paramInt)
  {
    putInt("numrounds", paramInt);
  }
  
  public void setPayStatus(PayStatus paramPayStatus)
  {
    if (paramPayStatus == PayStatus.NOADS) {}
    for (boolean bool = true;; bool = false)
    {
      putBoolean("removeads", bool);
      return;
    }
  }
  
  @Deprecated
  public void setPlay(boolean paramBoolean)
  {
    putBoolean("play", paramBoolean);
  }
  
  public void setTimer(GuessTimer paramGuessTimer)
  {
    putInt("timer", paramGuessTimer.value());
  }
  
  public void setVersionCode(int paramInt)
  {
    putInt("version", paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/jaysquared/games/whereishd/utils/PersistantSettings.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */