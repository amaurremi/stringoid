package com.google.analytics.tracking.android;

import android.text.TextUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Tracker
{
  private final AppFieldsDefaultProvider mAppFieldsDefaultProvider;
  private final ClientIdDefaultProvider mClientIdDefaultProvider;
  private final TrackerHandler mHandler;
  private final String mName;
  private final Map<String, String> mParams = new HashMap();
  private RateLimiter mRateLimiter;
  private final ScreenResolutionDefaultProvider mScreenResolutionDefaultProvider;
  
  Tracker(String paramString1, String paramString2, TrackerHandler paramTrackerHandler)
  {
    this(paramString1, paramString2, paramTrackerHandler, ClientIdDefaultProvider.getProvider(), ScreenResolutionDefaultProvider.getProvider(), AppFieldsDefaultProvider.getProvider(), new SendHitRateLimiter());
  }
  
  @VisibleForTesting
  Tracker(String paramString1, String paramString2, TrackerHandler paramTrackerHandler, ClientIdDefaultProvider paramClientIdDefaultProvider, ScreenResolutionDefaultProvider paramScreenResolutionDefaultProvider, AppFieldsDefaultProvider paramAppFieldsDefaultProvider, RateLimiter paramRateLimiter)
  {
    if (TextUtils.isEmpty(paramString1)) {
      throw new IllegalArgumentException("Tracker name cannot be empty.");
    }
    this.mName = paramString1;
    this.mHandler = paramTrackerHandler;
    this.mParams.put("&tid", paramString2);
    this.mParams.put("useSecure", "1");
    this.mClientIdDefaultProvider = paramClientIdDefaultProvider;
    this.mScreenResolutionDefaultProvider = paramScreenResolutionDefaultProvider;
    this.mAppFieldsDefaultProvider = paramAppFieldsDefaultProvider;
    this.mRateLimiter = paramRateLimiter;
  }
  
  public String get(String paramString)
  {
    GAUsage.getInstance().setUsage(GAUsage.Field.GET);
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return null;
      if (this.mParams.containsKey(paramString)) {
        return (String)this.mParams.get(paramString);
      }
      if (paramString.equals("&ul")) {
        return Utils.getLanguage(Locale.getDefault());
      }
      if ((this.mClientIdDefaultProvider != null) && (this.mClientIdDefaultProvider.providesField(paramString))) {
        return this.mClientIdDefaultProvider.getValue(paramString);
      }
      if ((this.mScreenResolutionDefaultProvider != null) && (this.mScreenResolutionDefaultProvider.providesField(paramString))) {
        return this.mScreenResolutionDefaultProvider.getValue(paramString);
      }
    } while ((this.mAppFieldsDefaultProvider == null) || (!this.mAppFieldsDefaultProvider.providesField(paramString)));
    return this.mAppFieldsDefaultProvider.getValue(paramString);
  }
  
  public String getName()
  {
    GAUsage.getInstance().setUsage(GAUsage.Field.GET_TRACKER_NAME);
    return this.mName;
  }
  
  @VisibleForTesting
  RateLimiter getRateLimiter()
  {
    return this.mRateLimiter;
  }
  
  public void send(Map<String, String> paramMap)
  {
    GAUsage.getInstance().setUsage(GAUsage.Field.SEND);
    HashMap localHashMap = new HashMap();
    localHashMap.putAll(this.mParams);
    if (paramMap != null) {
      localHashMap.putAll(paramMap);
    }
    if (TextUtils.isEmpty((CharSequence)localHashMap.get("&tid"))) {
      Log.w(String.format("Missing tracking id (%s) parameter.", new Object[] { "&tid" }));
    }
    String str = (String)localHashMap.get("&t");
    paramMap = str;
    if (TextUtils.isEmpty(str))
    {
      Log.w(String.format("Missing hit type (%s) parameter.", new Object[] { "&t" }));
      paramMap = "";
    }
    if ((!paramMap.equals("transaction")) && (!paramMap.equals("item")) && (!this.mRateLimiter.tokenAvailable()))
    {
      Log.w("Too many hits sent too quickly, rate limiting invoked.");
      return;
    }
    this.mHandler.sendHit(localHashMap);
  }
  
  public void set(String paramString1, String paramString2)
  {
    GAUsage.getInstance().setUsage(GAUsage.Field.SET);
    if (paramString2 == null)
    {
      this.mParams.remove(paramString1);
      return;
    }
    this.mParams.put(paramString1, paramString2);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/analytics/tracking/android/Tracker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */