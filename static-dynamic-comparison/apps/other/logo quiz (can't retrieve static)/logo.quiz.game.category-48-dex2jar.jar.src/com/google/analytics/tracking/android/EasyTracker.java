package com.google.analytics.tracking.android;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public class EasyTracker
{
  static final int NUM_MILLISECONDS_TO_WAIT_FOR_OPEN_ACTIVITY = 1000;
  private static EasyTracker instance;
  private int activitiesActive = 0;
  private final Map<String, String> activityNameMap = new HashMap();
  private boolean autoActivityTracking = false;
  private Clock clock = new Clock()
  {
    public long currentTimeMillis()
    {
      return System.currentTimeMillis();
    }
  };
  private Analytics ga;
  private boolean gaAnonymizeIp;
  private String gaAppName;
  private String gaAppVersion;
  private Context gaContext;
  private boolean gaDebug;
  private int gaDispatchPeriod = 1800;
  private boolean gaEnabled = false;
  private boolean gaReportUncaughtExceptions;
  private Double gaSampleRate;
  private long gaSessionTimeout;
  private String gaTrackingId;
  private Thread.UncaughtExceptionHandler handler;
  private boolean inForeground = false;
  private long lastOnStopTime;
  private ParameterLoader parameterFetcher;
  private ServiceManager serviceManager;
  private Timer timer;
  private TimerTask timerTask;
  private Tracker tracker = null;
  
  private void clearExistingTimer()
  {
    try
    {
      if (this.timer != null)
      {
        this.timer.cancel();
        this.timer = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  static void clearTracker()
  {
    instance = null;
  }
  
  private String getActivityName(Activity paramActivity)
  {
    String str1 = paramActivity.getClass().getCanonicalName();
    if (this.activityNameMap.containsKey(str1)) {
      return (String)this.activityNameMap.get(str1);
    }
    String str2 = this.parameterFetcher.getString(str1);
    paramActivity = str2;
    if (str2 == null) {
      paramActivity = str1;
    }
    this.activityNameMap.put(str1, paramActivity);
    return paramActivity;
  }
  
  public static EasyTracker getInstance()
  {
    if (instance == null) {
      instance = new EasyTracker();
    }
    return instance;
  }
  
  public static Tracker getTracker()
  {
    if (getInstance().gaContext == null) {
      throw new IllegalStateException("You must call EasyTracker.getInstance().setContext(context) or startActivity(activity) before calling getTracker()");
    }
    return getInstance().tracker;
  }
  
  private void loadParameters()
  {
    boolean bool2 = true;
    this.gaTrackingId = this.parameterFetcher.getString("ga_trackingId");
    if (TextUtils.isEmpty(this.gaTrackingId))
    {
      this.gaTrackingId = this.parameterFetcher.getString("ga_api_key");
      if (TextUtils.isEmpty(this.gaTrackingId))
      {
        Log.e("EasyTracker requested, but missing required ga_trackingId");
        this.tracker = new NoopTracker();
        return;
      }
    }
    this.gaEnabled = true;
    this.gaAppName = this.parameterFetcher.getString("ga_appName");
    this.gaAppVersion = this.parameterFetcher.getString("ga_appVersion");
    this.gaDebug = this.parameterFetcher.getBoolean("ga_debug");
    this.gaSampleRate = this.parameterFetcher.getDoubleFromString("ga_sampleFrequency");
    if (this.gaSampleRate == null) {
      this.gaSampleRate = new Double(this.parameterFetcher.getInt("ga_sampleRate", 100));
    }
    this.gaDispatchPeriod = this.parameterFetcher.getInt("ga_dispatchPeriod", 1800);
    this.gaSessionTimeout = (this.parameterFetcher.getInt("ga_sessionTimeout", 30) * 1000);
    boolean bool1 = bool2;
    if (!this.parameterFetcher.getBoolean("ga_autoActivityTracking")) {
      if (!this.parameterFetcher.getBoolean("ga_auto_activity_tracking")) {
        break label461;
      }
    }
    label461:
    for (bool1 = bool2;; bool1 = false)
    {
      this.autoActivityTracking = bool1;
      this.gaAnonymizeIp = this.parameterFetcher.getBoolean("ga_anonymizeIp");
      this.gaReportUncaughtExceptions = this.parameterFetcher.getBoolean("ga_reportUncaughtExceptions");
      this.tracker = this.ga.getTracker(this.gaTrackingId);
      if (!TextUtils.isEmpty(this.gaAppName))
      {
        Log.i("setting appName to " + this.gaAppName);
        this.tracker.setAppName(this.gaAppName);
      }
      if (this.gaAppVersion != null) {
        this.tracker.setAppVersion(this.gaAppVersion);
      }
      this.tracker.setAnonymizeIp(this.gaAnonymizeIp);
      this.tracker.setSampleRate(this.gaSampleRate.doubleValue());
      this.ga.setDebug(this.gaDebug);
      this.serviceManager.setDispatchPeriod(this.gaDispatchPeriod);
      if (!this.gaReportUncaughtExceptions) {
        break;
      }
      Thread.UncaughtExceptionHandler localUncaughtExceptionHandler = this.handler;
      Object localObject = localUncaughtExceptionHandler;
      if (localUncaughtExceptionHandler == null) {
        localObject = new ExceptionReporter(this.tracker, this.serviceManager, Thread.getDefaultUncaughtExceptionHandler());
      }
      Thread.setDefaultUncaughtExceptionHandler((Thread.UncaughtExceptionHandler)localObject);
      return;
    }
  }
  
  public void activityStart(Activity paramActivity)
  {
    setContext(paramActivity);
    if (!this.gaEnabled) {}
    do
    {
      return;
      clearExistingTimer();
      if ((!this.inForeground) && (this.activitiesActive == 0) && (checkForNewSession()))
      {
        this.tracker.setStartSession(true);
        if (this.autoActivityTracking) {}
      }
      this.inForeground = true;
      this.activitiesActive += 1;
    } while (!this.autoActivityTracking);
    this.tracker.trackView(getActivityName(paramActivity));
  }
  
  public void activityStop(Activity paramActivity)
  {
    setContext(paramActivity);
    if (!this.gaEnabled) {}
    do
    {
      return;
      this.activitiesActive -= 1;
      this.activitiesActive = Math.max(0, this.activitiesActive);
      this.lastOnStopTime = this.clock.currentTimeMillis();
    } while (this.activitiesActive != 0);
    clearExistingTimer();
    this.timerTask = new NotInForegroundTimerTask(null);
    this.timer = new Timer("waitForActivityStart");
    this.timer.schedule(this.timerTask, 1000L);
  }
  
  boolean checkForNewSession()
  {
    return (this.gaSessionTimeout == 0L) || ((this.gaSessionTimeout > 0L) && (this.clock.currentTimeMillis() > this.lastOnStopTime + this.gaSessionTimeout));
  }
  
  public void dispatch()
  {
    if (this.gaEnabled) {
      this.serviceManager.dispatch();
    }
  }
  
  int getActivitiesActive()
  {
    return this.activitiesActive;
  }
  
  void setClock(Clock paramClock)
  {
    this.clock = paramClock;
  }
  
  public void setContext(Context paramContext)
  {
    if (paramContext == null)
    {
      Log.e("Context cannot be null");
      return;
    }
    GAServiceManager localGAServiceManager = GAServiceManager.getInstance();
    setContext(paramContext, new ParameterLoaderImpl(paramContext.getApplicationContext()), GoogleAnalytics.getInstance(paramContext.getApplicationContext()), localGAServiceManager);
  }
  
  void setContext(Context paramContext, ParameterLoader paramParameterLoader, Analytics paramAnalytics, ServiceManager paramServiceManager)
  {
    if (paramContext == null) {
      Log.e("Context cannot be null");
    }
    if (this.gaContext == null)
    {
      this.gaContext = paramContext.getApplicationContext();
      this.ga = paramAnalytics;
      this.serviceManager = paramServiceManager;
      this.parameterFetcher = paramParameterLoader;
      loadParameters();
    }
  }
  
  void setUncaughtExceptionHandler(Thread.UncaughtExceptionHandler paramUncaughtExceptionHandler)
  {
    this.handler = paramUncaughtExceptionHandler;
  }
  
  class NoopTracker
    implements Tracker
  {
    private boolean anonymizeIp;
    private String appId;
    private String appInstallerId;
    private ExceptionParser exceptionParser;
    private double sampleRate = 100.0D;
    private boolean useSecure;
    
    NoopTracker() {}
    
    public boolean anonymizeIpEnabled()
    {
      return this.anonymizeIp;
    }
    
    public void close() {}
    
    public Map<String, String> constructEvent(String paramString1, String paramString2, String paramString3, Long paramLong)
    {
      return new HashMap();
    }
    
    public Map<String, String> constructException(String paramString, boolean paramBoolean)
    {
      return new HashMap();
    }
    
    public Map<String, String> constructRawException(String paramString, Throwable paramThrowable, boolean paramBoolean)
    {
      return new HashMap();
    }
    
    public Map<String, String> constructSocial(String paramString1, String paramString2, String paramString3)
    {
      return new HashMap();
    }
    
    public Map<String, String> constructTiming(String paramString1, long paramLong, String paramString2, String paramString3)
    {
      return new HashMap();
    }
    
    public Map<String, String> constructTransaction(Transaction paramTransaction)
    {
      return new HashMap();
    }
    
    public String get(String paramString)
    {
      return "";
    }
    
    public String getAppId()
    {
      return this.appId;
    }
    
    public String getAppInstallerId()
    {
      return this.appInstallerId;
    }
    
    public ExceptionParser getExceptionParser()
    {
      return this.exceptionParser;
    }
    
    public double getSampleRate()
    {
      return this.sampleRate;
    }
    
    public String getTrackingId()
    {
      return "";
    }
    
    public boolean getUseSecure()
    {
      return this.useSecure;
    }
    
    public void send(String paramString, Map<String, String> paramMap) {}
    
    public void set(String paramString1, String paramString2) {}
    
    public void setAnonymizeIp(boolean paramBoolean)
    {
      this.anonymizeIp = paramBoolean;
    }
    
    public void setAppId(String paramString)
    {
      this.appId = paramString;
    }
    
    public void setAppInstallerId(String paramString)
    {
      this.appInstallerId = paramString;
    }
    
    public void setAppName(String paramString) {}
    
    public void setAppScreen(String paramString) {}
    
    public void setAppVersion(String paramString) {}
    
    public void setCampaign(String paramString) {}
    
    public void setCustomDimension(int paramInt, String paramString) {}
    
    public void setCustomDimensionsAndMetrics(Map<Integer, String> paramMap, Map<Integer, Long> paramMap1) {}
    
    public void setCustomMetric(int paramInt, Long paramLong) {}
    
    public void setExceptionParser(ExceptionParser paramExceptionParser)
    {
      this.exceptionParser = paramExceptionParser;
    }
    
    public void setReferrer(String paramString) {}
    
    public void setSampleRate(double paramDouble)
    {
      this.sampleRate = paramDouble;
    }
    
    public void setStartSession(boolean paramBoolean) {}
    
    public void setUseSecure(boolean paramBoolean)
    {
      this.useSecure = paramBoolean;
    }
    
    public void trackEvent(String paramString1, String paramString2, String paramString3, Long paramLong) {}
    
    public void trackException(String paramString, Throwable paramThrowable, boolean paramBoolean) {}
    
    public void trackException(String paramString, boolean paramBoolean) {}
    
    public void trackSocial(String paramString1, String paramString2, String paramString3) {}
    
    public void trackTiming(String paramString1, long paramLong, String paramString2, String paramString3) {}
    
    public void trackTransaction(Transaction paramTransaction) {}
    
    public void trackView() {}
    
    public void trackView(String paramString) {}
  }
  
  private class NotInForegroundTimerTask
    extends TimerTask
  {
    private NotInForegroundTimerTask() {}
    
    public void run()
    {
      EasyTracker.access$102(EasyTracker.this, false);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/analytics/tracking/android/EasyTracker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */