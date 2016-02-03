package com.google.analytics.tracking.android;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import java.util.Collection;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class GoogleAnalytics
  implements Analytics, TrackerHandler
{
  private static GoogleAnalytics instance;
  private AdHitIdGenerator adHitIdGenerator;
  private volatile Boolean appOptOut;
  private volatile String clientId;
  private Context context;
  private boolean debug;
  private Tracker defaultTracker;
  private String lastTrackingId;
  private AnalyticsThread thread;
  private final Map<String, Tracker> trackers = new HashMap();
  
  private GoogleAnalytics() {}
  
  private GoogleAnalytics(Context paramContext)
  {
    this(paramContext, GAThread.getInstance(paramContext));
  }
  
  private GoogleAnalytics(Context paramContext, AnalyticsThread paramAnalyticsThread)
  {
    if (paramContext == null) {
      throw new IllegalArgumentException("context cannot be null");
    }
    this.context = paramContext.getApplicationContext();
    this.thread = paramAnalyticsThread;
    this.adHitIdGenerator = new AdHitIdGenerator();
    this.thread.requestAppOptOut(new Analytics.AppOptOutCallback()
    {
      public void reportAppOptOut(boolean paramAnonymousBoolean)
      {
        GoogleAnalytics.access$002(GoogleAnalytics.this, Boolean.valueOf(paramAnonymousBoolean));
      }
    });
    this.thread.requestClientId(new AnalyticsThread.ClientIdCallback()
    {
      public void reportClientId(String paramAnonymousString)
      {
        GoogleAnalytics.access$102(GoogleAnalytics.this, paramAnonymousString);
      }
    });
  }
  
  static void clearInstance()
  {
    try
    {
      instance = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  static GoogleAnalytics getInstance()
  {
    try
    {
      GoogleAnalytics localGoogleAnalytics = instance;
      return localGoogleAnalytics;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static GoogleAnalytics getInstance(Context paramContext)
  {
    try
    {
      if (instance == null) {
        instance = new GoogleAnalytics(paramContext);
      }
      paramContext = instance;
      return paramContext;
    }
    finally {}
  }
  
  static GoogleAnalytics getNewInstance(Context paramContext, AnalyticsThread paramAnalyticsThread)
  {
    try
    {
      if (instance != null) {
        instance.close();
      }
      instance = new GoogleAnalytics(paramContext, paramAnalyticsThread);
      paramContext = instance;
      return paramContext;
    }
    finally {}
  }
  
  void close() {}
  
  public void closeTracker(Tracker paramTracker)
  {
    try
    {
      this.trackers.values().remove(paramTracker);
      if (paramTracker == this.defaultTracker) {
        this.defaultTracker = null;
      }
      return;
    }
    finally
    {
      paramTracker = finally;
      throw paramTracker;
    }
  }
  
  public boolean debugEnabled()
  {
    GAUsage.getInstance().setUsage(GAUsage.Field.GET_DEBUG);
    return this.debug;
  }
  
  Boolean getAppOptOut()
  {
    return this.appOptOut;
  }
  
  String getClientIdForAds()
  {
    if (this.clientId == null) {
      return null;
    }
    return this.clientId.toString();
  }
  
  public Tracker getDefaultTracker()
  {
    try
    {
      GAUsage.getInstance().setUsage(GAUsage.Field.GET_DEFAULT_TRACKER);
      Tracker localTracker = this.defaultTracker;
      return localTracker;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public Tracker getTracker(String paramString)
  {
    if (paramString == null) {
      try
      {
        throw new IllegalArgumentException("trackingId cannot be null");
      }
      finally {}
    }
    Object localObject2 = (Tracker)this.trackers.get(paramString);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject2 = new GoogleTracker(paramString, this);
      this.trackers.put(paramString, localObject2);
      localObject1 = localObject2;
      if (this.defaultTracker == null)
      {
        this.defaultTracker = ((Tracker)localObject2);
        localObject1 = localObject2;
      }
    }
    GAUsage.getInstance().setUsage(GAUsage.Field.GET_TRACKER);
    return (Tracker)localObject1;
  }
  
  String getTrackingIdForAds()
  {
    return this.lastTrackingId;
  }
  
  public void requestAppOptOut(Analytics.AppOptOutCallback paramAppOptOutCallback)
  {
    GAUsage.getInstance().setUsage(GAUsage.Field.REQUEST_APP_OPT_OUT);
    if (this.appOptOut != null)
    {
      paramAppOptOutCallback.reportAppOptOut(this.appOptOut.booleanValue());
      return;
    }
    this.thread.requestAppOptOut(paramAppOptOutCallback);
  }
  
  public void sendHit(Map<String, String> paramMap)
  {
    if (paramMap == null) {
      try
      {
        throw new IllegalArgumentException("hit cannot be null");
      }
      finally {}
    }
    paramMap.put("language", Utils.getLanguage(Locale.getDefault()));
    paramMap.put("adSenseAdMobHitId", Integer.toString(this.adHitIdGenerator.getAdHitId()));
    paramMap.put("screenResolution", this.context.getResources().getDisplayMetrics().widthPixels + "x" + this.context.getResources().getDisplayMetrics().heightPixels);
    paramMap.put("usage", GAUsage.getInstance().getAndClearSequence());
    GAUsage.getInstance().getAndClearUsage();
    this.thread.sendHit(paramMap);
    this.lastTrackingId = ((String)paramMap.get("trackingId"));
  }
  
  public void setAppOptOut(boolean paramBoolean)
  {
    GAUsage.getInstance().setUsage(GAUsage.Field.SET_APP_OPT_OUT);
    this.appOptOut = Boolean.valueOf(paramBoolean);
    this.thread.setAppOptOut(paramBoolean);
  }
  
  public void setDebug(boolean paramBoolean)
  {
    GAUsage.getInstance().setUsage(GAUsage.Field.SET_DEBUG);
    this.debug = paramBoolean;
    Log.setDebug(paramBoolean);
  }
  
  public void setDefaultTracker(Tracker paramTracker)
  {
    try
    {
      GAUsage.getInstance().setUsage(GAUsage.Field.SET_DEFAULT_TRACKER);
      this.defaultTracker = paramTracker;
      return;
    }
    finally
    {
      paramTracker = finally;
      throw paramTracker;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/analytics/tracking/android/GoogleAnalytics.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */