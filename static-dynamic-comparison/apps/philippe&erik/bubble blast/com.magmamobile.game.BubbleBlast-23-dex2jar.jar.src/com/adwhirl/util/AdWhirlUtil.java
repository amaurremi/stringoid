package com.adwhirl.util;

import android.app.Activity;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

public class AdWhirlUtil
{
  public static final String ADWHIRL = "AdWhirl SDK";
  public static final int CUSTOM_TYPE_BANNER = 1;
  public static final int CUSTOM_TYPE_ICON = 2;
  public static final String KREACTIVE_KEY = "Kreactive|;|KREACTIVE".toLowerCase();
  public static final int NETWORK_TYPE_4THSCREEN = 13;
  public static final int NETWORK_TYPE_ADMOB = 1;
  public static final int NETWORK_TYPE_ADSENSE = 14;
  public static final int NETWORK_TYPE_ADWHIRL = 10;
  public static final int NETWORK_TYPE_CUSTOM = 9;
  public static final int NETWORK_TYPE_DOUBLECLICK = 15;
  public static final int NETWORK_TYPE_EVENT = 17;
  public static final int NETWORK_TYPE_GENERIC = 16;
  public static final int NETWORK_TYPE_GREYSTRIP = 7;
  public static final int NETWORK_TYPE_INMOBI = 18;
  public static final int NETWORK_TYPE_JUMPTAP = 2;
  public static final int NETWORK_TYPE_LIVERAIL = 5;
  public static final int NETWORK_TYPE_MDOTM = 12;
  public static final int NETWORK_TYPE_MEDIALETS = 4;
  public static final int NETWORK_TYPE_MILLENNIAL = 6;
  public static final int NETWORK_TYPE_MOBCLIX = 11;
  public static final int NETWORK_TYPE_ONERIOT = 23;
  public static final int NETWORK_TYPE_QUATTRO = 8;
  public static final int NETWORK_TYPE_VIDEOEGG = 3;
  public static final int NETWORK_TYPE_ZESTADZ = 20;
  public static final int VERSION = 300;
  private static double density = -1.0D;
  public static final String locationString = "&location=%f,%f&location_timestamp=%d";
  public static final String urlClick = "http://met.adwhirl.com/exclick.php?appid=%s&nid=%s&type=%d&uuid=%s&country_code=%s&appver=%d&client=2";
  public static final String urlConfig = "http://mob.adwhirl.com/getInfo.php?appid=%s&appver=%d&client=2";
  public static final String urlCustom = "http://cus.adwhirl.com/custom.php?appid=%s&nid=%s&uuid=%s&country_code=%s%s&appver=%d&client=2";
  public static final String urlImpression = "http://met.adwhirl.com/exmet.php?appid=%s&nid=%s&type=%d&uuid=%s&country_code=%s&appver=%d&client=2";
  public static final String urlKreative = "?cat=%s&appID=%s&w=%s&l=%s&devID=3&ver=1&con=%s&lang=%s";
  public static final String urlKreativeTracking = "?type=%s&cat=%s&userID=%s&dev=%s&os=%s&devID=3&appID=%s&adID=%s";
  
  public static String convertToHex(byte[] paramArrayOfByte)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int m = paramArrayOfByte.length;
    int i = 0;
    if (i >= m) {
      return localStringBuffer.toString();
    }
    int n = paramArrayOfByte[i];
    int k = n >>> 4 & 0xF;
    int j = 0;
    for (;;)
    {
      if ((k >= 0) && (k <= 9)) {
        localStringBuffer.append((char)(k + 48));
      }
      for (;;)
      {
        k = n & 0xF;
        if (j < 1) {
          break label98;
        }
        i += 1;
        break;
        localStringBuffer.append((char)(k - 10 + 97));
      }
      label98:
      j += 1;
    }
  }
  
  public static double convertToScreenPixels(double paramDouble1, double paramDouble2)
  {
    double d = paramDouble1;
    if (paramDouble2 > 0.0D) {
      d = paramDouble1 * paramDouble2;
    }
    return d;
  }
  
  public static int convertToScreenPixels(int paramInt, double paramDouble)
  {
    return (int)convertToScreenPixels(paramInt, paramDouble);
  }
  
  public static double getDensity(Activity paramActivity)
  {
    if (density == -1.0D)
    {
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      paramActivity.getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
      density = localDisplayMetrics.density;
    }
    return density;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/adwhirl/util/AdWhirlUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */