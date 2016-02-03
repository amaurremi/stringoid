package com.mopub.mobileads;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import com.mopub.common.AdUrlGenerator;
import com.mopub.common.GpsHelper;
import com.mopub.mobileads.util.Mraids;
import java.lang.reflect.Method;

public class WebViewAdUrlGenerator
  extends AdUrlGenerator
{
  public WebViewAdUrlGenerator(Context paramContext)
  {
    super(paramContext);
  }
  
  private static String addKeyword(String paramString1, String paramString2)
  {
    String str;
    if ((paramString2 == null) || (paramString2.length() == 0)) {
      str = paramString1;
    }
    do
    {
      do
      {
        return str;
        str = paramString2;
      } while (paramString1 == null);
      str = paramString2;
    } while (paramString1.length() == 0);
    return paramString1 + "," + paramString2;
  }
  
  private boolean detectIsMraidSupported()
  {
    try
    {
      Class.forName("com.mopub.mobileads.MraidView");
      return true;
    }
    catch (ClassNotFoundException localClassNotFoundException) {}
    return false;
  }
  
  private static String getFacebookKeyword(Context paramContext, boolean paramBoolean)
  {
    if (!paramBoolean) {
      return null;
    }
    try
    {
      Class localClass = Class.forName("com.mopub.mobileads.FacebookKeywordProvider");
      paramContext = (String)localClass.getMethod("getKeyword", new Class[] { Context.class }).invoke(localClass, new Object[] { paramContext });
      return paramContext;
    }
    catch (Exception paramContext) {}
    return null;
  }
  
  public String generateUrlString(String paramString)
  {
    initUrlString(paramString, "/m/ad");
    setApiVersion("6");
    setAdUnitId(this.mAdUnitId);
    setSdkVersion("2.0");
    setDeviceInfo(new String[] { Build.MANUFACTURER, Build.MODEL, Build.PRODUCT });
    setUdid(getUdidFromContext(this.mContext));
    setDoNotTrack(GpsHelper.isLimitAdTrackingEnabled(this.mContext));
    setKeywords(addKeyword(this.mKeywords, getFacebookKeyword(this.mContext, this.mFacebookSupportEnabled)));
    setLocation(this.mLocation);
    setTimezone(AdUrlGenerator.getTimeZoneOffsetString());
    setOrientation(this.mContext.getResources().getConfiguration().orientation);
    setDensity(this.mContext.getResources().getDisplayMetrics().density);
    setMraidFlag(detectIsMraidSupported());
    paramString = getNetworkOperator();
    setMccCode(paramString);
    setMncCode(paramString);
    setIsoCountryCode(this.mTelephonyManager.getNetworkCountryIso());
    setCarrierName(this.mTelephonyManager.getNetworkOperatorName());
    setNetworkType(getActiveNetworkType());
    setAppVersion(getAppVersionFromContext(this.mContext));
    setExternalStoragePermission(Mraids.isStorePictureSupported(this.mContext));
    setTwitterAppInstalledFlag();
    return getFinalUrlString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/mopub/mobileads/WebViewAdUrlGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */