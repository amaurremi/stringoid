package com.bubble.tapjoy.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;

public class TapjoyState
{
  public static void enableTapjoy(Context paramContext)
  {
    if (!isTapjoyCheckEnable(paramContext))
    {
      paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
      paramContext.putBoolean("tapjoyRefreshEnable", true);
      paramContext.commit();
    }
  }
  
  public static boolean isTapjoyCheckEnable(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getBoolean("tapjoyRefreshEnable", false);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/bubble/tapjoy/utils/TapjoyState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */