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
  private static boolean uY;
  private static GoogleAnalytics vf;
  private Context mContext;
  private f sH;
  private String so;
  private String sp;
  private boolean uZ;
  private af va;
  private volatile Boolean vb = Boolean.valueOf(false);
  private Logger vc;
  private Set<a> vd;
  private boolean ve = false;
  
  protected GoogleAnalytics(Context paramContext)
  {
    this(paramContext, t.q(paramContext), r.ci());
  }
  
  private GoogleAnalytics(Context paramContext, f paramf, af paramaf)
  {
    if (paramContext == null) {
      throw new IllegalArgumentException("context cannot be null");
    }
    this.mContext = paramContext.getApplicationContext();
    this.sH = paramf;
    this.va = paramaf;
    g.n(this.mContext);
    ae.n(this.mContext);
    h.n(this.mContext);
    this.vc = new l();
    this.vd = new HashSet();
    cN();
  }
  
  private int I(String paramString)
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
    if (this.so != null) {
      paramTracker.set("&an", this.so);
    }
    if (this.sp != null) {
      paramTracker.set("&av", this.sp);
    }
    return paramTracker;
  }
  
  static GoogleAnalytics cM()
  {
    try
    {
      GoogleAnalytics localGoogleAnalytics = vf;
      return localGoogleAnalytics;
    }
    finally {}
  }
  
  private void cN()
  {
    if (uY) {}
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
              aa.z("Couldn't get ApplicationInfo to load gloabl config.");
              return;
            }
          }
          catch (PackageManager.NameNotFoundException localNameNotFoundException)
          {
            for (;;)
            {
              aa.y("PackageManager doesn't know about package: " + localNameNotFoundException);
              localObject = null;
            }
            localObject = ((ApplicationInfo)localObject).metaData;
          }
        } while (localObject == null);
        i = ((Bundle)localObject).getInt("com.google.android.gms.analytics.globalConfigResource");
      } while (i <= 0);
      localObject = (w)new v(this.mContext).p(i);
    } while (localObject == null);
    a((w)localObject);
  }
  
  private void d(Activity paramActivity)
  {
    Iterator localIterator = this.vd.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).f(paramActivity);
    }
  }
  
  private void e(Activity paramActivity)
  {
    Iterator localIterator = this.vd.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).g(paramActivity);
    }
  }
  
  public static GoogleAnalytics getInstance(Context paramContext)
  {
    try
    {
      if (vf == null) {
        vf = new GoogleAnalytics(paramContext);
      }
      paramContext = vf;
      return paramContext;
    }
    finally {}
  }
  
  void a(a parama)
  {
    this.vd.add(parama);
  }
  
  void a(w paramw)
  {
    aa.y("Loading global config values.");
    if (paramw.cC())
    {
      this.so = paramw.cD();
      aa.y("app name loaded: " + this.so);
    }
    if (paramw.cE())
    {
      this.sp = paramw.cF();
      aa.y("app version loaded: " + this.sp);
    }
    if (paramw.cG())
    {
      int i = I(paramw.cH());
      if (i >= 0)
      {
        aa.y("log level loaded: " + i);
        getLogger().setLogLevel(i);
      }
    }
    if (paramw.cI()) {
      this.va.setLocalDispatchPeriod(paramw.cJ());
    }
    if (paramw.cK()) {
      setDryRun(paramw.cL());
    }
  }
  
  void b(a parama)
  {
    this.vd.remove(parama);
  }
  
  @Deprecated
  public void dispatchLocalHits()
  {
    this.va.dispatchLocalHits();
  }
  
  public void enableAutoActivityReports(Application paramApplication)
  {
    if ((Build.VERSION.SDK_INT >= 14) && (!this.ve))
    {
      paramApplication.registerActivityLifecycleCallbacks(new b());
      this.ve = true;
    }
  }
  
  public boolean getAppOptOut()
  {
    u.cy().a(u.a.uz);
    return this.vb.booleanValue();
  }
  
  public Logger getLogger()
  {
    return this.vc;
  }
  
  public boolean isDryRunEnabled()
  {
    u.cy().a(u.a.uL);
    return this.uZ;
  }
  
  public Tracker newTracker(int paramInt)
  {
    try
    {
      u.cy().a(u.a.uv);
      Tracker localTracker = new Tracker(null, this);
      if (paramInt > 0)
      {
        aj localaj = (aj)new ai(this.mContext).p(paramInt);
        if (localaj != null) {
          localTracker.a(this.mContext, localaj);
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
      u.cy().a(u.a.uv);
      paramString = a(new Tracker(paramString, this));
      return paramString;
    }
    finally {}
  }
  
  void q(Map<String, String> paramMap)
  {
    if (paramMap == null) {
      try
      {
        throw new IllegalArgumentException("hit cannot be null");
      }
      finally {}
    }
    ak.a(paramMap, "&ul", ak.a(Locale.getDefault()));
    ak.a(paramMap, "&sr", ae.cZ().getValue("&sr"));
    paramMap.put("&_u", u.cy().cA());
    u.cy().cz();
    this.sH.q(paramMap);
  }
  
  public void reportActivityStart(Activity paramActivity)
  {
    if (!this.ve) {
      d(paramActivity);
    }
  }
  
  public void reportActivityStop(Activity paramActivity)
  {
    if (!this.ve) {
      e(paramActivity);
    }
  }
  
  public void setAppOptOut(boolean paramBoolean)
  {
    u.cy().a(u.a.uy);
    this.vb = Boolean.valueOf(paramBoolean);
    if (this.vb.booleanValue()) {
      this.sH.bR();
    }
  }
  
  public void setDryRun(boolean paramBoolean)
  {
    u.cy().a(u.a.uK);
    this.uZ = paramBoolean;
  }
  
  @Deprecated
  public void setLocalDispatchPeriod(int paramInt)
  {
    this.va.setLocalDispatchPeriod(paramInt);
  }
  
  public void setLogger(Logger paramLogger)
  {
    u.cy().a(u.a.uM);
    this.vc = paramLogger;
  }
  
  static abstract interface a
  {
    public abstract void f(Activity paramActivity);
    
    public abstract void g(Activity paramActivity);
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/analytics/GoogleAnalytics.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */