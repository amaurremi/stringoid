package com.mopub.mobileads.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class Utils
{
  public static boolean executeIntent(Context paramContext, Intent paramIntent, String paramString)
  {
    try
    {
      if (!(paramContext instanceof Activity)) {
        paramIntent.addFlags(268435456);
      }
      paramContext.startActivity(paramIntent);
      return true;
    }
    catch (Exception paramContext)
    {
      if (paramString == null) {}
    }
    for (;;)
    {
      Log.d("MoPub", paramString);
      return false;
      paramString = "Unable to start intent.";
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/mopub/mobileads/util/Utils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */