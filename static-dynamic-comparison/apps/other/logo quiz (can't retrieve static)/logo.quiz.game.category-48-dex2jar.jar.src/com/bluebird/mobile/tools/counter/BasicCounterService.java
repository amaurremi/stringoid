package com.bluebird.mobile.tools.counter;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.bluebird.mobile.tools.PreferencesName;

public class BasicCounterService
  implements CounterService
{
  private final String preferenceName = "counter_value";
  private final SharedPreferences sharedPreferences;
  
  BasicCounterService(Context paramContext, PreferencesName paramPreferencesName)
  {
    this(paramContext, paramPreferencesName.name());
  }
  
  BasicCounterService(Context paramContext, String paramString)
  {
    this.sharedPreferences = paramContext.getSharedPreferences(paramString, 0);
  }
  
  public void add(int paramInt)
  {
    int i = getCurrent();
    SharedPreferences.Editor localEditor = this.sharedPreferences.edit();
    getClass();
    localEditor.putInt("counter_value", i + paramInt);
    localEditor.commit();
  }
  
  public int getCurrent()
  {
    return this.sharedPreferences.getInt("counter_value", 0);
  }
  
  public void minus(int paramInt)
  {
    int i = getCurrent();
    SharedPreferences.Editor localEditor = this.sharedPreferences.edit();
    getClass();
    localEditor.putInt("counter_value", i - paramInt);
    localEditor.commit();
  }
  
  public void reset()
  {
    SharedPreferences.Editor localEditor = this.sharedPreferences.edit();
    localEditor.clear();
    localEditor.commit();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/bluebird/mobile/tools/counter/BasicCounterService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */