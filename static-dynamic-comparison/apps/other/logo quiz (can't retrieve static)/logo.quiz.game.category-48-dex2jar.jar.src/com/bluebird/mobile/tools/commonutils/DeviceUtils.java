package com.bluebird.mobile.tools.commonutils;

import android.content.Context;
import android.telephony.TelephonyManager;

public class DeviceUtils
{
  public static String getDeviceId(Context paramContext)
  {
    return ((TelephonyManager)paramContext.getSystemService("phone")).getDeviceId();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/bluebird/mobile/tools/commonutils/DeviceUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */