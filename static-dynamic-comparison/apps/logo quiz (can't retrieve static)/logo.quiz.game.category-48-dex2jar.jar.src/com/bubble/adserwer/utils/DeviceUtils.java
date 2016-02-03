package com.bubble.adserwer.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.preference.PreferenceManager;
import android.telephony.TelephonyManager;
import com.bubble.adserwer.R.bool;

public class DeviceUtils
{
  public static boolean isTablet(Context paramContext)
  {
    boolean bool1 = false;
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(paramContext);
    int j = localSharedPreferences.getInt("IS_TABLET", 1);
    int i = j;
    if (j == 1)
    {
      i = 1;
      if (((TelephonyManager)paramContext.getSystemService("phone")).getPhoneType() == 0) {
        i = 0;
      }
      boolean bool2 = paramContext.getResources().getBoolean(R.bool.isTablet);
      if ((i != 0) && (!bool2)) {
        break label104;
      }
    }
    label104:
    for (i = 10;; i = 0)
    {
      paramContext = localSharedPreferences.edit();
      paramContext.putInt("IS_TABLET", i);
      paramContext.commit();
      if (i == 10) {
        bool1 = true;
      }
      return bool1;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/bubble/adserwer/utils/DeviceUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */