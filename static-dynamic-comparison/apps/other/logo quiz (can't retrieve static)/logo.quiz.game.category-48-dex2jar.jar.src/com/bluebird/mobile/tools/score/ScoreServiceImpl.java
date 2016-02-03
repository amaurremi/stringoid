package com.bluebird.mobile.tools.score;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.bluebird.mobile.tools.PreferencesName;

public class ScoreServiceImpl
  implements ScoreService
{
  private final SharedPreferences scores;
  private final String totalPrefKey = "total";
  
  public ScoreServiceImpl(Context paramContext, PreferencesName paramPreferencesName)
  {
    this.scores = paramContext.getSharedPreferences(paramPreferencesName.name(), 0);
  }
  
  private void addToGroupScore(String paramString, int paramInt)
  {
    int i = this.scores.getInt("g_" + paramString, 0);
    SharedPreferences.Editor localEditor = this.scores.edit();
    localEditor.putInt("g_" + paramString, i + paramInt);
    localEditor.commit();
  }
  
  private void addToTotalScore(int paramInt)
  {
    int i = this.scores.getInt("total", 0);
    SharedPreferences.Editor localEditor = this.scores.edit();
    localEditor.putInt("total", i + paramInt);
    localEditor.commit();
  }
  
  private void setLevelScore(String paramString1, String paramString2, int paramInt)
  {
    SharedPreferences.Editor localEditor = this.scores.edit();
    localEditor.putInt(paramString1 + "_" + paramString2, paramInt);
    localEditor.commit();
  }
  
  private void setLevelSubmit(String paramString1, String paramString2)
  {
    SharedPreferences.Editor localEditor = this.scores.edit();
    localEditor.putBoolean("ans_" + paramString1 + "_" + paramString2, true);
    localEditor.commit();
  }
  
  public int getGroupScore(String paramString)
  {
    return this.scores.getInt("g_" + paramString, Integer.MIN_VALUE);
  }
  
  public int getScore(int paramInt1, int paramInt2)
  {
    return getScore(String.valueOf(paramInt1), String.valueOf(paramInt2));
  }
  
  public int getScore(String paramString1, String paramString2)
  {
    return this.scores.getInt(paramString1 + "_" + paramString2, 0);
  }
  
  public int getTotalScore()
  {
    return this.scores.getInt("total", 0);
  }
  
  public int levelsSubmittedCount(int paramInt1, int paramInt2)
  {
    return levelsSubmittedCount(String.valueOf(paramInt1), paramInt2);
  }
  
  public int levelsSubmittedCount(String paramString, int paramInt)
  {
    int j = 0;
    int i = 0;
    while (i < paramInt + 1)
    {
      int k = j;
      if (wasLevelSubmitted(paramString, String.valueOf(i))) {
        k = j + 1;
      }
      i += 1;
      j = k;
    }
    return j;
  }
  
  public void reset()
  {
    SharedPreferences.Editor localEditor = this.scores.edit();
    localEditor.clear();
    localEditor.commit();
  }
  
  public boolean submitLevelScoreIfItsBetter(int paramInt1, int paramInt2, int paramInt3)
  {
    return submitLevelScoreIfItsBetter(String.valueOf(paramInt1), String.valueOf(paramInt2), paramInt3);
  }
  
  public boolean submitLevelScoreIfItsBetter(String paramString1, String paramString2, int paramInt)
  {
    boolean bool2 = wasLevelSubmitted(paramString1, paramString2);
    boolean bool1 = false;
    if (!bool2)
    {
      bool1 = true;
      setLevelScore(paramString1, paramString2, paramInt);
      addToGroupScore(paramString1, paramInt);
      addToTotalScore(paramInt);
      setLevelSubmit(paramString1, paramString2);
    }
    do
    {
      return bool1;
      i = getScore(paramString1, paramString2);
    } while (paramInt <= i);
    int i = paramInt - i;
    setLevelScore(paramString1, paramString2, paramInt);
    addToGroupScore(paramString1, i);
    addToTotalScore(i);
    setLevelSubmit(paramString1, paramString2);
    return true;
  }
  
  public boolean wasLevelSubmitted(int paramInt1, int paramInt2)
  {
    return wasLevelSubmitted(String.valueOf(paramInt1), String.valueOf(paramInt2));
  }
  
  public boolean wasLevelSubmitted(String paramString1, String paramString2)
  {
    return this.scores.getBoolean("ans_" + paramString1 + "_" + paramString2, false);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/bluebird/mobile/tools/score/ScoreServiceImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */