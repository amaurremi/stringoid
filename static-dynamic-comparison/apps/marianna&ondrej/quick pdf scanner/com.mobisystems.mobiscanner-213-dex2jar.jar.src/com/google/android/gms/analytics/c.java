package com.google.android.gms.analytics;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public class c
  extends h
{
  private static boolean mi;
  private static c ms;
  private Context mContext;
  private boolean mj;
  private y mk;
  private o ml;
  private volatile Boolean mm = Boolean.valueOf(false);
  private e mn;
  private String mo;
  private String mp;
  private Set<GoogleAnalytics.a> mq;
  private boolean mr = false;
  
  protected c(Context paramContext)
  {
    this(paramContext, ak.t(paramContext), aj.lq());
  }
  
  private c(Context paramContext, y paramy, o paramo)
  {
    if (paramContext == null) {
      throw new IllegalArgumentException("context cannot be null");
    }
    this.mContext = paramContext.getApplicationContext();
    this.mk = paramy;
    this.ml = paramo;
    z.q(this.mContext);
    n.q(this.mContext);
    aa.q(this.mContext);
    this.mn = new ae();
    this.mq = new HashSet();
    kJ();
  }
  
  private int M(String paramString)
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
  
  private g a(g paramg)
  {
    if (this.mp != null) {
      paramg.set("&an", this.mp);
    }
    if (this.mo != null) {
      paramg.set("&av", this.mo);
    }
    return paramg;
  }
  
  static c kI()
  {
    try
    {
      c localc = ms;
      return localc;
    }
    finally {}
  }
  
  private void kJ()
  {
    if (mi) {}
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
              j.D("Couldn't get ApplicationInfo to load gloabl config.");
              return;
            }
          }
          catch (PackageManager.NameNotFoundException localNameNotFoundException)
          {
            for (;;)
            {
              j.C("PackageManager doesn't know about package: " + localNameNotFoundException);
              localObject = null;
            }
            localObject = ((ApplicationInfo)localObject).metaData;
          }
        } while (localObject == null);
        i = ((Bundle)localObject).getInt("com.google.android.gms.analytics.globalConfigResource");
      } while (i <= 0);
      localObject = (am)new al(this.mContext).bf(i);
    } while (localObject == null);
    a((am)localObject);
  }
  
  public static c o(Context paramContext)
  {
    try
    {
      if (ms == null) {
        ms = new c(paramContext);
      }
      paramContext = ms;
      return paramContext;
    }
    finally {}
  }
  
  public g N(String paramString)
  {
    try
    {
      u.lF().a(u.a.pq);
      paramString = a(new g(paramString, this));
      return paramString;
    }
    finally {}
  }
  
  void a(am paramam)
  {
    j.C("Loading global config values.");
    if (paramam.lJ())
    {
      this.mp = paramam.lK();
      j.C("app name loaded: " + this.mp);
    }
    if (paramam.lL())
    {
      this.mo = paramam.lM();
      j.C("app version loaded: " + this.mo);
    }
    if (paramam.lN())
    {
      int i = M(paramam.lO());
      if (i >= 0)
      {
        j.C("log level loaded: " + i);
        kK().bb(i);
      }
    }
    if (paramam.lP()) {
      this.ml.aX(paramam.lQ());
    }
    if (paramam.lR()) {
      p(paramam.lS());
    }
  }
  
  void i(Map<String, String> paramMap)
  {
    if (paramMap == null) {
      try
      {
        throw new IllegalArgumentException("hit cannot be null");
      }
      finally {}
    }
    r.b(paramMap, "&ul", r.b(Locale.getDefault()));
    r.b(paramMap, "&sr", n.kX().getValue("&sr"));
    paramMap.put("&_u", u.lF().lH());
    u.lF().lG();
    this.mk.i(paramMap);
  }
  
  @Deprecated
  public void jG()
  {
    this.ml.jG();
  }
  
  public boolean jY()
  {
    u.lF().a(u.a.pG);
    return this.mj;
  }
  
  public boolean jZ()
  {
    u.lF().a(u.a.pu);
    return this.mm.booleanValue();
  }
  
  public e kK()
  {
    return this.mn;
  }
  
  public void p(boolean paramBoolean)
  {
    u.lF().a(u.a.pF);
    this.mj = paramBoolean;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/analytics/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */