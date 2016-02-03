package com.jaysquared.games.whereishd;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.jaysquared.games.whereishd.utils.PayStatus;
import com.jaysquared.games.whereishd.utils.SLog;

public class ReleaseConfiguration
{
  public static final String EMAIL = "whereis@jaysquared.com";
  public static final String FACEBOOK_PAGE_BROWSER = "https://www.facebook.com/jaysquaredcom";
  public static final String FACEBOOK_PAGE_INAPP = "fb://page/116476558442748";
  public static final int INTERSTITIAL_CYCLE_TIME = 90000;
  public static final boolean IS_ADS_TESTING_MODE = false;
  private static final String LOG_TAG = ReleaseConfiguration.class.getSimpleName();
  public static final String MOPUB_BANNER_ID = "839ee51f8b814b948645d5f0268a1aae";
  public static final String MOPUB_INTERSTITIAL_ID_PHONE = "308f6009b0c94ccd87dab536c8310816";
  public static final String MOPUB_INTERSTITIAL_ID_TABLET = "e4f45acc5fae45b09cec4e981b864737";
  public static final String PACKAGE_NAME_CURRENT;
  public static final String PACKAGE_NAME_FREE = "com.jaysquared.games.whereishd.releasefree";
  public static final String PACKAGE_NAME_HD = "com.jaysquared.games.whereishd.release";
  public static final PayStatus PAY_STATUS = PayStatus.FREE;
  public static final boolean SHOULD_USE_FACEBOOK = true;
  public static final String TILES_NAME_EASY = "easy.mbtiles";
  public static final String TILES_NAME_HARD = "hard.mbtiles";
  public static final String TILES_NAME_HD_EDITION = "hdedition.mbtiles";
  @Deprecated
  public static final boolean isGooglePlayLicensingActive = false;
  
  static
  {
    if (PAY_STATUS == PayStatus.NOADS) {}
    for (String str = "com.jaysquared.games.whereishd.release";; str = "com.jaysquared.games.whereishd.releasefree")
    {
      PACKAGE_NAME_CURRENT = str;
      return;
    }
  }
  
  public static boolean isDebug(Context paramContext)
  {
    return (paramContext.getApplicationInfo().flags & 0x2) != 0;
  }
  
  public static boolean isReadyForRelease(Context paramContext)
  {
    boolean bool3 = isDebug(paramContext);
    SLog.d(LOG_TAG, "Debug mode: " + bool3);
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (!bool3)
    {
      bool1 = bool2;
      if (!paramContext.getPackageName().equals(PACKAGE_NAME_CURRENT))
      {
        bool1 = false;
        SLog.e(LOG_TAG, "Package name must be set before release.");
      }
    }
    if (!bool1)
    {
      paramContext = new AlertDialog.Builder(paramContext);
      paramContext.setMessage("Release configuration is not properly configured. Check ad testing mode, package names etc...").setTitle("Invalid release configuration");
      paramContext.create().show();
    }
    return bool1;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/jaysquared/games/whereishd/ReleaseConfiguration.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */