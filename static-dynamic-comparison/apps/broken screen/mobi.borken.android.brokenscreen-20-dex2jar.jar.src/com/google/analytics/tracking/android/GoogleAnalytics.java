package com.google.analytics.tracking.android;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class GoogleAnalytics
  extends TrackerHandler
{
  private static GoogleAnalytics sInstance;
  private volatile Boolean mAppOptOut = Boolean.valueOf(false);
  private Context mContext;
  private Tracker mDefaultTracker;
  private boolean mDryRun;
  private Logger mLogger;
  private AnalyticsThread mThread;
  private final Map<String, Tracker> mTrackers = new HashMap();
  
  @VisibleForTesting
  protected GoogleAnalytics(Context paramContext)
  {
    this(paramContext, GAThread.getInstance(paramContext));
  }
  
  private GoogleAnalytics(Context paramContext, AnalyticsThread paramAnalyticsThread)
  {
    if (paramContext == null) {
      throw new IllegalArgumentException("context cannot be null");
    }
    this.mContext = paramContext.getApplicationContext();
    this.mThread = paramAnalyticsThread;
    AppFieldsDefaultProvider.initializeProvider(this.mContext);
    ScreenResolutionDefaultProvider.initializeProvider(this.mContext);
    ClientIdDefaultProvider.initializeProvider(this.mContext);
    this.mLogger = new DefaultLoggerImpl();
  }
  
  @VisibleForTesting
  static void clearDefaultProviders()
  {
    AppFieldsDefaultProvider.dropInstance();
    ScreenResolutionDefaultProvider.dropInstance();
    ClientIdDefaultProvider.dropInstance();
  }
  
  @VisibleForTesting
  static void clearInstance()
  {
    try
    {
      sInstance = null;
      clearDefaultProviders();
      return;
    }
    finally {}
  }
  
  static GoogleAnalytics getInstance()
  {
    try
    {
      GoogleAnalytics localGoogleAnalytics = sInstance;
      return localGoogleAnalytics;
    }
    finally {}
  }
  
  public static GoogleAnalytics getInstance(Context paramContext)
  {
    try
    {
      if (sInstance == null) {
        sInstance = new GoogleAnalytics(paramContext);
      }
      paramContext = sInstance;
      return paramContext;
    }
    finally {}
  }
  
  @VisibleForTesting
  static GoogleAnalytics getNewInstance(Context paramContext, AnalyticsThread paramAnalyticsThread)
  {
    try
    {
      if (sInstance != null) {
        sInstance.close();
      }
      sInstance = new GoogleAnalytics(paramContext, paramAnalyticsThread);
      paramContext = sInstance;
      return paramContext;
    }
    finally {}
  }
  
  @VisibleForTesting
  void close() {}
  
  public void closeTracker(String paramString)
  {
    try
    {
      GAUsage.getInstance().setUsage(GAUsage.Field.CLOSE_TRACKER);
      if ((Tracker)this.mTrackers.remove(paramString) == this.mDefaultTracker) {
        this.mDefaultTracker = null;
      }
      return;
    }
    finally {}
  }
  
  public boolean getAppOptOut()
  {
    GAUsage.getInstance().setUsage(GAUsage.Field.GET_APP_OPT_OUT);
    return this.mAppOptOut.booleanValue();
  }
  
  public Tracker getDefaultTracker()
  {
    try
    {
      GAUsage.getInstance().setUsage(GAUsage.Field.GET_DEFAULT_TRACKER);
      Tracker localTracker = this.mDefaultTracker;
      return localTracker;
    }
    finally {}
  }
  
  public Logger getLogger()
  {
    return this.mLogger;
  }
  
  public Tracker getTracker(String paramString)
  {
    return getTracker(paramString, paramString);
  }
  
  public Tracker getTracker(String paramString1, String paramString2)
  {
    try
    {
      if (TextUtils.isEmpty(paramString1)) {
        throw new IllegalArgumentException("Tracker name cannot be empty");
      }
    }
    finally {}
    Tracker localTracker2 = (Tracker)this.mTrackers.get(paramString1);
    Tracker localTracker1 = localTracker2;
    if (localTracker2 == null)
    {
      localTracker2 = new Tracker(paramString1, paramString2, this);
      this.mTrackers.put(paramString1, localTracker2);
      localTracker1 = localTracker2;
      if (this.mDefaultTracker == null)
      {
        this.mDefaultTracker = localTracker2;
        localTracker1 = localTracker2;
      }
    }
    if (!TextUtils.isEmpty(paramString2)) {
      localTracker1.set("&tid", paramString2);
    }
    GAUsage.getInstance().setUsage(GAUsage.Field.GET_TRACKER);
    return localTracker1;
  }
  
  public boolean isDryRunEnabled()
  {
    GAUsage.getInstance().setUsage(GAUsage.Field.GET_DRY_RUN);
    return this.mDryRun;
  }
  
  void sendHit(Map<String, String> paramMap)
  {
    if (paramMap == null) {
      try
      {
        throw new IllegalArgumentException("hit cannot be null");
      }
      finally {}
    }
    Utils.putIfAbsent(paramMap, "&ul", Utils.getLanguage(Locale.getDefault()));
    Utils.putIfAbsent(paramMap, "&sr", ScreenResolutionDefaultProvider.getProvider().getValue("&sr"));
    paramMap.put("&_u", GAUsage.getInstance().getAndClearSequence());
    GAUsage.getInstance().getAndClearUsage();
    this.mThread.sendHit(paramMap);
  }
  
  public void setAppOptOut(boolean paramBoolean)
  {
    GAUsage.getInstance().setUsage(GAUsage.Field.SET_APP_OPT_OUT);
    this.mAppOptOut = Boolean.valueOf(paramBoolean);
    if (this.mAppOptOut.booleanValue()) {
      this.mThread.clearHits();
    }
  }
  
  public void setDefaultTracker(Tracker paramTracker)
  {
    try
    {
      GAUsage.getInstance().setUsage(GAUsage.Field.SET_DEFAULT_TRACKER);
      this.mDefaultTracker = paramTracker;
      return;
    }
    finally {}
  }
  
  public void setDryRun(boolean paramBoolean)
  {
    GAUsage.getInstance().setUsage(GAUsage.Field.SET_DRY_RUN);
    this.mDryRun = paramBoolean;
  }
  
  public void setLogger(Logger paramLogger)
  {
    GAUsage.getInstance().setUsage(GAUsage.Field.SET_LOGGER);
    this.mLogger = paramLogger;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/analytics/tracking/android/GoogleAnalytics.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */