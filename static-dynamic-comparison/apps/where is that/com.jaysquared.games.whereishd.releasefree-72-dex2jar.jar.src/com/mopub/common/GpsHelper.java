package com.mopub.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Log;
import com.mopub.common.factories.MethodBuilderFactory;
import com.mopub.common.util.Reflection;
import com.mopub.common.util.Reflection.MethodBuilder;
import com.mopub.mobileads.AdTypeTranslator.CustomEventType;

public class GpsHelper
{
  public static final String ADVERTISING_ID_KEY = "advertisingId";
  public static final int GOOGLE_PLAY_SUCCESS_CODE = 0;
  public static final String IS_LIMIT_AD_TRACKING_ENABLED_KEY = "isLimitAdTrackingEnabled";
  private static String sAdvertisingIdClientClassName = "com.google.android.gms.ads.identifier.AdvertisingIdClient";
  private static String sPlayServicesUtilClassName = "com.google.android.gms.common.GooglePlayServicesUtil";
  
  public static void asyncFetchAdvertisingInfo(Context paramContext)
  {
    asyncFetchAdvertisingInfo(paramContext, null);
  }
  
  public static void asyncFetchAdvertisingInfo(Context paramContext, final GpsHelperListener paramGpsHelperListener)
  {
    if ((!Reflection.classFound(sAdvertisingIdClientClassName)) && (paramGpsHelperListener != null)) {
      paramGpsHelperListener.onFetchAdInfoCompleted();
    }
    new Thread(new Runnable()
    {
      public void run()
      {
        try
        {
          Object localObject1 = MethodBuilderFactory.create(null, "getAdvertisingIdInfo").setStatic(Class.forName(GpsHelper.sAdvertisingIdClientClassName)).addParam(Context.class, this.val$context).execute();
          if (localObject1 != null) {
            GpsHelper.updateSharedPreferences(this.val$context, localObject1);
          }
          return;
        }
        catch (Exception localException)
        {
          Log.d("MoPub", "Unable to obtain AdvertisingIdClient.getAdvertisingIdInfo()");
          return;
        }
        finally
        {
          if (paramGpsHelperListener != null) {
            paramGpsHelperListener.onFetchAdInfoCompleted();
          }
        }
      }
    }).start();
  }
  
  public static void asyncFetchAdvertisingInfoIfNotCached(Context paramContext, GpsHelperListener paramGpsHelperListener)
  {
    if ((isGpsAvailable(paramContext)) && (!isSharedPreferencesPopluated(paramContext)))
    {
      asyncFetchAdvertisingInfo(paramContext, paramGpsHelperListener);
      return;
    }
    paramGpsHelperListener.onFetchAdInfoCompleted();
  }
  
  public static AdTypeTranslator.CustomEventType convertAdMobToGooglePlayServices(Context paramContext, AdTypeTranslator.CustomEventType paramCustomEventType)
  {
    AdTypeTranslator.CustomEventType localCustomEventType;
    if ((paramCustomEventType == AdTypeTranslator.CustomEventType.ADMOB_BANNER) && (Reflection.classFound(AdTypeTranslator.CustomEventType.GOOGLE_PLAY_BANNER.toString())) && (isGpsAvailable(paramContext))) {
      localCustomEventType = AdTypeTranslator.CustomEventType.GOOGLE_PLAY_BANNER;
    }
    do
    {
      do
      {
        do
        {
          return localCustomEventType;
          localCustomEventType = paramCustomEventType;
        } while (paramCustomEventType != AdTypeTranslator.CustomEventType.ADMOB_INTERSTITIAL);
        localCustomEventType = paramCustomEventType;
      } while (!Reflection.classFound(AdTypeTranslator.CustomEventType.GOOGLE_PLAY_INTERSTITIAL.toString()));
      localCustomEventType = paramCustomEventType;
    } while (!isGpsAvailable(paramContext));
    return AdTypeTranslator.CustomEventType.GOOGLE_PLAY_INTERSTITIAL;
  }
  
  static String getAdvertisingId(Context paramContext)
  {
    String str = null;
    if (isGpsAvailable(paramContext)) {
      str = SharedPreferencesHelper.getSharedPreferences(paramContext).getString("advertisingId", null);
    }
    return str;
  }
  
  static boolean isGpsAvailable(Context paramContext)
  {
    boolean bool2 = false;
    try
    {
      paramContext = MethodBuilderFactory.create(null, "isGooglePlayServicesAvailable").setStatic(Class.forName(sPlayServicesUtilClassName)).addParam(Context.class, paramContext).execute();
      boolean bool1 = bool2;
      if (paramContext != null)
      {
        int i = ((Integer)paramContext).intValue();
        bool1 = bool2;
        if (i == 0) {
          bool1 = true;
        }
      }
      return bool1;
    }
    catch (Exception paramContext) {}
    return false;
  }
  
  public static boolean isLimitAdTrackingEnabled(Context paramContext)
  {
    boolean bool = false;
    if (isGpsAvailable(paramContext)) {
      bool = SharedPreferencesHelper.getSharedPreferences(paramContext).getBoolean("isLimitAdTrackingEnabled", false);
    }
    return bool;
  }
  
  static boolean isSharedPreferencesPopluated(Context paramContext)
  {
    paramContext = SharedPreferencesHelper.getSharedPreferences(paramContext);
    return (paramContext.contains("advertisingId")) && (paramContext.contains("isLimitAdTrackingEnabled"));
  }
  
  static String reflectedGetAdvertisingId(Object paramObject, String paramString)
  {
    try
    {
      paramObject = (String)MethodBuilderFactory.create(paramObject, "getId").execute();
      return (String)paramObject;
    }
    catch (Exception paramObject) {}
    return paramString;
  }
  
  static boolean reflectedIsLimitAdTrackingEnabled(Object paramObject, boolean paramBoolean)
  {
    try
    {
      paramObject = (Boolean)MethodBuilderFactory.create(paramObject, "isLimitAdTrackingEnabled").execute();
      boolean bool = paramBoolean;
      if (paramObject != null) {
        bool = ((Boolean)paramObject).booleanValue();
      }
      return bool;
    }
    catch (Exception paramObject) {}
    return paramBoolean;
  }
  
  @Deprecated
  public static void setClassNamesForTesting()
  {
    sPlayServicesUtilClassName = "java.lang.Class";
    sAdvertisingIdClientClassName = "java.lang.Class";
  }
  
  static void updateSharedPreferences(Context paramContext, Object paramObject)
  {
    String str = reflectedGetAdvertisingId(paramObject, null);
    boolean bool = reflectedIsLimitAdTrackingEnabled(paramObject, false);
    SharedPreferencesHelper.getSharedPreferences(paramContext).edit().putString("advertisingId", str).putBoolean("isLimitAdTrackingEnabled", bool).commit();
  }
  
  public static abstract interface GpsHelperListener
  {
    public abstract void onFetchAdInfoCompleted();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/mopub/common/GpsHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */