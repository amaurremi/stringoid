package com.google.android.gms.analytics;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.os.Bundle;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public class GoogleAnalytics
  extends TrackerHandler
{
  private static boolean wj;
  private static GoogleAnalytics wq;
  private Context mContext;
  private String tA;
  private f tS;
  private String tz;
  private boolean wk;
  private af wl;
  private volatile Boolean wm = Boolean.valueOf(false);
  private Logger wn;
  private Set<a> wo;
  private boolean wp = false;
  
  protected GoogleAnalytics(Context paramContext)
  {
    this(paramContext, t.u(paramContext), r.cz());
  }
  
  private GoogleAnalytics(Context paramContext, f paramf, af paramaf)
  {
    if (paramContext == null) {
      throw new IllegalArgumentException("context cannot be null");
    }
    this.mContext = paramContext.getApplicationContext();
    this.tS = paramf;
    this.wl = paramaf;
    g.r(this.mContext);
    ae.r(this.mContext);
    h.r(this.mContext);
    this.wn = new l();
    this.wo = new HashSet();
    de();
  }
  
  private int P(String paramString)
  {
    paramString = paramString.toLowerCase();
    if ("verbose".equals(paramString)) {
      return 0;
    }
    if ("info".equals(paramString)) {
      return 1;
    }
    if ("warning".equals(paramString)) {
      return 2;
    }
    if ("error".equals(paramString)) {
      return 3;
    }
    return -1;
  }
  
  private Tracker a(Tracker paramTracker)
  {
    if (this.tz != null) {
      paramTracker.set("&an", this.tz);
    }
    if (this.tA != null) {
      paramTracker.set("&av", this.tA);
    }
    return paramTracker;
  }
  
  static GoogleAnalytics dd()
  {
    try
    {
      GoogleAnalytics localGoogleAnalytics = wq;
      return localGoogleAnalytics;
    }
    finally {}
  }
  
  private void de()
  {
    if (wj) {}
    Object localObject;
    do
    {
      int i;
      do
      {
        do
        {
          return;
          try
          {
            ApplicationInfo localApplicationInfo = this.mContext.getPackageManager().getApplicationInfo(this.mContext.getPackageName(), 129);
            if (localApplicationInfo == null)
            {
              aa.D("Couldn't get ApplicationInfo to load gloabl config.");
              return;
            }
          }
          catch (PackageManager.NameNotFoundException localNameNotFoundException)
          {
            for (;;)
            {
              aa.C("PackageManager doesn't know about package: " + localNameNotFoundException);
              localObject = null;
            }
            localObject = ((ApplicationInfo)localObject).metaData;
          }
        } while (localObject == null);
        i = ((Bundle)localObject).getInt("com.google.android.gms.analytics.globalConfigResource");
      } while (i <= 0);
      localObject = (w)new v(this.mContext).r(i);
    } while (localObject == null);
    a((w)localObject);
  }
  
  private void f(Activity paramActivity)
  {
    Iterator localIterator = this.wo.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).h(paramActivity);
    }
  }
  
  private void g(Activity paramActivity)
  {
    Iterator localIterator = this.wo.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).i(paramActivity);
    }
  }
  
  public static GoogleAnalytics getInstance(Context paramContext)
  {
    try
    {
      if (wq == null) {
        wq = new GoogleAnalytics(paramContext);
      }
      paramContext = wq;
      return paramContext;
    }
    finally {}
  }
  
  void a(a parama)
  {
    this.wo.add(parama);
  }
  
  void a(w paramw)
  {
    aa.C("Loading global config values.");
    if (paramw.cT())
    {
      this.tz = paramw.cU();
      aa.C("app name loaded: " + this.tz);
    }
    if (paramw.cV())
    {
      this.tA = paramw.cW();
      aa.C("app version loaded: " + this.tA);
    }
    if (paramw.cX())
    {
      int i = P(paramw.cY());
      if (i >= 0)
      {
        aa.C("log level loaded: " + i);
        getLogger().setLogLevel(i);
      }
    }
    if (paramw.cZ()) {
      this.wl.setLocalDispatchPeriod(paramw.da());
    }
    if (paramw.db()) {
      setDryRun(paramw.dc());
    }
  }
  
  void b(a parama)
  {
    this.wo.remove(parama);
  }
  
  @Deprecated
  public void dispatchLocalHits()
  {
    this.wl.dispatchLocalHits();
  }
  
  public void enableAutoActivityReports(Application paramApplication)
  {
    if ((Build.VERSION.SDK_INT >= 14) && (!this.wp))
    {
      paramApplication.registerActivityLifecycleCallbacks(new b());
      this.wp = true;
    }
  }
  
  public boolean getAppOptOut()
  {
    u.cP().a(u.a.vK);
    return this.wm.booleanValue();
  }
  
  public Logger getLogger()
  {
    return this.wn;
  }
  
  public boolean isDryRunEnabled()
  {
    u.cP().a(u.a.vW);
    return this.wk;
  }
  
  public Tracker newTracker(int paramInt)
  {
    try
    {
      u.cP().a(u.a.vG);
      Tracker localTracker = new Tracker(null, this, this.mContext);
      if (paramInt > 0)
      {
        aj localaj = (aj)new ai(this.mContext).r(paramInt);
        if (localaj != null) {
          localTracker.a(localaj);
        }
      }
      localTracker = a(localTracker);
      return localTracker;
    }
    finally {}
  }
  
  public Tracker newTracker(String paramString)
  {
    try
    {
      u.cP().a(u.a.vG);
      paramString = a(new Tracker(paramString, this, this.mContext));
      return paramString;
    }
    finally {}
  }
  
  void p(Map<String, String> paramMap)
  {
    if (paramMap == null) {
      try
      {
        throw new IllegalArgumentException("hit cannot be null");
      }
      finally {}
    }
    ak.a(paramMap, "&ul", ak.a(Locale.getDefault()));
    ak.a(paramMap, "&sr", ae.dq().getValue("&sr"));
    paramMap.put("&_u", u.cP().cR());
    u.cP().cQ();
    this.tS.p(paramMap);
  }
  
  public void reportActivityStart(Activity paramActivity)
  {
    if (!this.wp) {
      f(paramActivity);
    }
  }
  
  public void reportActivityStop(Activity paramActivity)
  {
    if (!this.wp) {
      g(paramActivity);
    }
  }
  
  public void setAppOptOut(boolean paramBoolean)
  {
    u.cP().a(u.a.vJ);
    this.wm = Boolean.valueOf(paramBoolean);
    if (this.wm.booleanValue()) {
      this.tS.cg();
    }
  }
  
  public void setDryRun(boolean paramBoolean)
  {
    u.cP().a(u.a.vV);
    this.wk = paramBoolean;
  }
  
  @Deprecated
  public void setLocalDispatchPeriod(int paramInt)
  {
    this.wl.setLocalDispatchPeriod(paramInt);
  }
  
  public void setLogger(Logger paramLogger)
  {
    u.cP().a(u.a.vX);
    this.wn = paramLogger;
  }
  
  static abstract interface a
  {
    public abstract void h(Activity paramActivity);
    
    public abstract void i(Activity paramActivity);
  }
  
  class b
    implements Application.ActivityLifecycleCallbacks
  {
    b() {}
    
    public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
    
    public void onActivityDestroyed(Activity paramActivity) {}
    
    public void onActivityPaused(Activity paramActivity) {}
    
    public void onActivityResumed(Activity paramActivity) {}
    
    public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
    
    public void onActivityStarted(Activity paramActivity)
    {
      GoogleAnalytics.a(GoogleAnalytics.this, paramActivity);
    }
    
    public void onActivityStopped(Activity paramActivity)
    {
      GoogleAnalytics.b(GoogleAnalytics.this, paramActivity);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/analytics/GoogleAnalytics.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */