package com.tapjoy;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import java.util.Hashtable;

public final class TapjoyConnect
{
  private static final String TAG = "TapjoyConnect";
  private static Hashtable<String, String> connectFlags = null;
  private static TapjoyConnect tapjoyConnectInstance = null;
  private static TapjoyDailyRewardAd tapjoyDailyRewardAd;
  private static TapjoyDisplayAd tapjoyDisplayAd;
  private static TapjoyEvent tapjoyEvent;
  private static TapjoyFullScreenAd tapjoyFullScreenAd;
  private static TJCOffers tapjoyOffers = null;
  private static TJPoints tapjoyPoints = null;
  private static TapjoyVideo tapjoyVideo;
  
  static
  {
    tapjoyFullScreenAd = null;
    tapjoyDisplayAd = null;
    tapjoyVideo = null;
    tapjoyEvent = null;
    tapjoyDailyRewardAd = null;
  }
  
  private TapjoyConnect(Context paramContext, String paramString1, String paramString2, Hashtable<String, String> paramHashtable, TapjoyConnectNotifier paramTapjoyConnectNotifier)
  {
    TapjoyConnectCore.requestTapjoyConnect(paramContext, paramString1, paramString2, paramHashtable, paramTapjoyConnectNotifier);
  }
  
  public static void enableLogging(boolean paramBoolean)
  {
    TapjoyLog.enableLogging(paramBoolean);
  }
  
  public static TapjoyConnect getTapjoyConnectInstance()
  {
    if (tapjoyConnectInstance == null)
    {
      Log.e("TapjoyConnect", "----------------------------------------");
      Log.e("TapjoyConnect", "ERROR -- call requestTapjoyConnect before any other Tapjoy methods");
      Log.e("TapjoyConnect", "----------------------------------------");
    }
    return tapjoyConnectInstance;
  }
  
  public static void requestTapjoyConnect(Context paramContext, String paramString1, String paramString2)
  {
    requestTapjoyConnect(paramContext, paramString1, paramString2, connectFlags);
  }
  
  public static void requestTapjoyConnect(Context paramContext, String paramString1, String paramString2, Hashtable<String, String> paramHashtable)
  {
    requestTapjoyConnect(paramContext, paramString1, paramString2, paramHashtable, null);
  }
  
  public static void requestTapjoyConnect(Context paramContext, String paramString1, String paramString2, Hashtable<String, String> paramHashtable, TapjoyConnectNotifier paramTapjoyConnectNotifier)
  {
    TapjoyConnectCore.setSDKType("offers");
    tapjoyConnectInstance = new TapjoyConnect(paramContext, paramString1, paramString2, paramHashtable, paramTapjoyConnectNotifier);
    tapjoyOffers = new TJCOffers(paramContext);
    tapjoyPoints = new TJPoints(paramContext);
    tapjoyFullScreenAd = new TapjoyFullScreenAd(paramContext);
    tapjoyDisplayAd = new TapjoyDisplayAd(paramContext);
    tapjoyVideo = new TapjoyVideo(paramContext);
    tapjoyEvent = new TapjoyEvent(paramContext);
    tapjoyDailyRewardAd = new TapjoyDailyRewardAd(paramContext);
    connectFlags = null;
  }
  
  public static void setFlagKeyValue(String paramString1, String paramString2)
  {
    if (connectFlags == null) {
      connectFlags = new Hashtable();
    }
    connectFlags.put(paramString1, paramString2);
  }
  
  public void actionComplete(String paramString)
  {
    TapjoyConnectCore.getInstance().actionComplete(paramString);
  }
  
  public void appPause()
  {
    TapjoyConnectCore.getInstance().appPause();
  }
  
  public void appResume()
  {
    TapjoyConnectCore.getInstance().appPause();
  }
  
  public void awardTapPoints(int paramInt, TapjoyAwardPointsNotifier paramTapjoyAwardPointsNotifier)
  {
    tapjoyPoints.awardTapPoints(paramInt, paramTapjoyAwardPointsNotifier);
  }
  
  public void cacheVideos()
  {
    tapjoyVideo.cacheVideos();
  }
  
  public void enableBannerAdAutoRefresh(boolean paramBoolean)
  {
    tapjoyDisplayAd.enableAutoRefresh(paramBoolean);
  }
  
  public void enableDisplayAdAutoRefresh(boolean paramBoolean)
  {
    tapjoyDisplayAd.enableAutoRefresh(paramBoolean);
  }
  
  public void enablePaidAppWithActionID(String paramString)
  {
    TapjoyConnectCore.getInstance().enablePaidAppWithActionID(paramString);
  }
  
  public void enableVideoCache(boolean paramBoolean)
  {
    tapjoyVideo.enableVideoCache(paramBoolean);
  }
  
  public String getAppID()
  {
    return TapjoyConnectCore.getAppID();
  }
  
  public float getCurrencyMultiplier()
  {
    return TapjoyConnectCore.getInstance().getCurrencyMultiplier();
  }
  
  public void getDailyRewardAd(TapjoyDailyRewardAdNotifier paramTapjoyDailyRewardAdNotifier)
  {
    tapjoyDailyRewardAd.getDailyRewardAd(paramTapjoyDailyRewardAdNotifier);
  }
  
  public void getDailyRewardAdWithCurrencyID(String paramString, TapjoyDailyRewardAdNotifier paramTapjoyDailyRewardAdNotifier)
  {
    tapjoyDailyRewardAd.getDailyRewardAdWithCurrencyID(paramString, paramTapjoyDailyRewardAdNotifier);
  }
  
  public void getDisplayAd(Activity paramActivity, TapjoyDisplayAdNotifier paramTapjoyDisplayAdNotifier)
  {
    tapjoyDisplayAd.getDisplayAd(paramActivity, paramTapjoyDisplayAdNotifier);
  }
  
  public void getDisplayAd(TapjoyDisplayAdNotifier paramTapjoyDisplayAdNotifier)
  {
    tapjoyDisplayAd.getDisplayAd(null, paramTapjoyDisplayAdNotifier);
  }
  
  public void getDisplayAdWithCurrencyID(Activity paramActivity, String paramString, TapjoyDisplayAdNotifier paramTapjoyDisplayAdNotifier)
  {
    tapjoyDisplayAd.getDisplayAd(paramActivity, paramString, paramTapjoyDisplayAdNotifier);
  }
  
  public void getDisplayAdWithCurrencyID(String paramString, TapjoyDisplayAdNotifier paramTapjoyDisplayAdNotifier)
  {
    tapjoyDisplayAd.getDisplayAd(null, paramString, paramTapjoyDisplayAdNotifier);
  }
  
  public void getFeaturedApp(TapjoyFeaturedAppNotifier paramTapjoyFeaturedAppNotifier)
  {
    tapjoyFullScreenAd.getFeaturedApp(paramTapjoyFeaturedAppNotifier);
  }
  
  public void getFeaturedAppWithCurrencyID(String paramString, TapjoyFeaturedAppNotifier paramTapjoyFeaturedAppNotifier)
  {
    tapjoyFullScreenAd.getFeaturedApp(paramString, paramTapjoyFeaturedAppNotifier);
  }
  
  public void getFullScreenAd(TapjoyFullScreenAdNotifier paramTapjoyFullScreenAdNotifier)
  {
    tapjoyFullScreenAd.getFullScreenAd(paramTapjoyFullScreenAdNotifier);
  }
  
  public void getFullScreenAdWithCurrencyID(String paramString, TapjoyFullScreenAdNotifier paramTapjoyFullScreenAdNotifier)
  {
    tapjoyFullScreenAd.getFullScreenAd(paramString, paramTapjoyFullScreenAdNotifier);
  }
  
  public void getTapPoints(TapjoyNotifier paramTapjoyNotifier)
  {
    tapjoyPoints.getTapPoints(paramTapjoyNotifier);
  }
  
  public String getUserID()
  {
    return TapjoyConnectCore.getUserID();
  }
  
  public void initVideoAd(TapjoyVideoNotifier paramTapjoyVideoNotifier)
  {
    tapjoyVideo.initVideoAd(paramTapjoyVideoNotifier);
  }
  
  public void sendIAPEvent(String paramString1, float paramFloat, int paramInt, String paramString2)
  {
    tapjoyEvent.sendIAPEvent(paramString1, paramFloat, paramInt, paramString2);
  }
  
  public void sendShutDownEvent()
  {
    tapjoyEvent.sendShutDownEvent();
  }
  
  public void setBannerAdSize(String paramString)
  {
    tapjoyDisplayAd.setBannerAdSize(paramString);
  }
  
  public void setCurrencyMultiplier(float paramFloat)
  {
    TapjoyConnectCore.getInstance().setCurrencyMultiplier(paramFloat);
  }
  
  public void setDisplayAdSize(String paramString)
  {
    tapjoyDisplayAd.setDisplayAdSize(paramString);
  }
  
  public void setEarnedPointsNotifier(TapjoyEarnedPointsNotifier paramTapjoyEarnedPointsNotifier)
  {
    tapjoyPoints.setEarnedPointsNotifier(paramTapjoyEarnedPointsNotifier);
  }
  
  public void setFeaturedAppDisplayCount(int paramInt)
  {
    tapjoyFullScreenAd.setDisplayCount(paramInt);
  }
  
  public void setMraidJsString(String paramString)
  {
    TapjoyUtil.setMraidJsString(paramString);
  }
  
  public void setTapjoyViewNotifier(TapjoyViewNotifier paramTapjoyViewNotifier)
  {
    TapjoyConnectCore.getInstance().setTapjoyViewNotifier(paramTapjoyViewNotifier);
  }
  
  public void setUserID(String paramString)
  {
    TapjoyConnectCore.setUserID(paramString);
  }
  
  public void setVideoCacheCount(int paramInt)
  {
    tapjoyVideo.setVideoCacheCount(paramInt);
  }
  
  public void setVideoNotifier(TapjoyVideoNotifier paramTapjoyVideoNotifier)
  {
    tapjoyVideo.setVideoNotifier(paramTapjoyVideoNotifier);
  }
  
  public void showDailyRewardAd()
  {
    tapjoyDailyRewardAd.showDailyRewardAd();
  }
  
  public void showFeaturedAppFullScreenAd()
  {
    tapjoyFullScreenAd.showFeaturedAppFullScreenAd();
  }
  
  public void showFullScreenAd()
  {
    tapjoyFullScreenAd.showFullScreenAd();
  }
  
  public void showOffers()
  {
    tapjoyOffers.showOffers();
  }
  
  public void showOffersWithCurrencyID(String paramString, boolean paramBoolean)
  {
    tapjoyOffers.showOffersWithCurrencyID(paramString, paramBoolean);
  }
  
  public void spendTapPoints(int paramInt, TapjoySpendPointsNotifier paramTapjoySpendPointsNotifier)
  {
    tapjoyPoints.spendTapPoints(paramInt, paramTapjoySpendPointsNotifier);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/tapjoy/TapjoyConnect.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */