package com.google.android.gms.analytics;

import android.app.Activity;
import android.app.Application;
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
  extends e
{
  private static boolean wm;
  private static GoogleAnalytics wt;
  private Context mContext;
  private String tC;
  private String tD;
  private z tV;
  private boolean wn;
  private m wo;
  private volatile Boolean wp = Boolean.valueOf(false);
  private Logger wq;
  private Set<a> wr;
  private boolean ws = false;
  
  protected GoogleAnalytics(Context paramContext)
  {
    this(paramContext, ar.a(paramContext), ak.c());
  }
  
  private GoogleAnalytics(Context paramContext, z paramz, m paramm)
  {
    if (paramContext == null) {
      throw new IllegalArgumentException("context cannot be null");
    }
    this.mContext = paramContext.getApplicationContext();
    this.tV = paramz;
    this.wo = paramm;
    ab.a(this.mContext);
    l.a(this.mContext);
    ac.a(this.mContext);
    this.wq = new af();
    this.wr = new HashSet();
    dj();
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
    if (this.tC != null) {
      paramTracker.set("&an", this.tC);
    }
    if (this.tD != null) {
      paramTracker.set("&av", this.tD);
    }
    return paramTracker;
  }
  
  static GoogleAnalytics di()
  {
    try
    {
      GoogleAnalytics localGoogleAnalytics = wt;
      return localGoogleAnalytics;
    }
    finally {}
  }
  
  private void dj()
  {
    if (wm) {}
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
      localObject = (au)new as(this.mContext).a(i);
    } while (localObject == null);
    a((au)localObject);
  }
  
  private void f(Activity paramActivity)
  {
    Iterator localIterator = this.wr.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).a(paramActivity);
    }
  }
  
  private void g(Activity paramActivity)
  {
    Iterator localIterator = this.wr.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).b(paramActivity);
    }
  }
  
  public static GoogleAnalytics getInstance(Context paramContext)
  {
    try
    {
      if (wt == null) {
        wt = new GoogleAnalytics(paramContext);
      }
      paramContext = wt;
      return paramContext;
    }
    finally {}
  }
  
  void a(a parama)
  {
    this.wr.add(parama);
  }
  
  void a(au paramau)
  {
    aa.C("Loading global config values.");
    if (paramau.a())
    {
      this.tC = paramau.b();
      aa.C("app name loaded: " + this.tC);
    }
    if (paramau.c())
    {
      this.tD = paramau.d();
      aa.C("app version loaded: " + this.tD);
    }
    if (paramau.e())
    {
      int i = P(paramau.f());
      if (i >= 0)
      {
        aa.C("log level loaded: " + i);
        getLogger().setLogLevel(i);
      }
    }
    if (paramau.g()) {
      this.wo.a(paramau.h());
    }
    if (paramau.i()) {
      setDryRun(paramau.j());
    }
  }
  
  void b(a parama)
  {
    this.wr.remove(parama);
  }
  
  @Deprecated
  public void dispatchLocalHits()
  {
    this.wo.a();
  }
  
  public void enableAutoActivityReports(Application paramApplication)
  {
    if ((Build.VERSION.SDK_INT >= 14) && (!this.ws))
    {
      paramApplication.registerActivityLifecycleCallbacks(new b(this));
      this.ws = true;
    }
  }
  
  public boolean getAppOptOut()
  {
    u.a().a(u.a.vN);
    return this.wp.booleanValue();
  }
  
  public Logger getLogger()
  {
    return this.wq;
  }
  
  public boolean isDryRunEnabled()
  {
    u.a().a(u.a.vZ);
    return this.wn;
  }
  
  public Tracker newTracker(int paramInt)
  {
    try
    {
      u.a().a(u.a.vJ);
      Tracker localTracker = new Tracker(null, this, this.mContext);
      if (paramInt > 0)
      {
        s locals = (s)new q(this.mContext).a(paramInt);
        if (locals != null) {
          localTracker.a(locals);
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
      u.a().a(u.a.vJ);
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
    t.a(paramMap, "&ul", t.a(Locale.getDefault()));
    t.a(paramMap, "&sr", l.a().a("&sr"));
    paramMap.put("&_u", u.a().c());
    u.a().b();
    this.tV.a(paramMap);
  }
  
  public void reportActivityStart(Activity paramActivity)
  {
    if (!this.ws) {
      f(paramActivity);
    }
  }
  
  public void reportActivityStop(Activity paramActivity)
  {
    if (!this.ws) {
      g(paramActivity);
    }
  }
  
  public void setAppOptOut(boolean paramBoolean)
  {
    u.a().a(u.a.vM);
    this.wp = Boolean.valueOf(paramBoolean);
    if (this.wp.booleanValue()) {
      this.tV.b();
    }
  }
  
  public void setDryRun(boolean paramBoolean)
  {
    u.a().a(u.a.vY);
    this.wn = paramBoolean;
  }
  
  @Deprecated
  public void setLocalDispatchPeriod(int paramInt)
  {
    this.wo.a(paramInt);
  }
  
  public void setLogger(Logger paramLogger)
  {
    u.a().a(u.a.wa);
    this.wq = paramLogger;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/analytics/GoogleAnalytics.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */