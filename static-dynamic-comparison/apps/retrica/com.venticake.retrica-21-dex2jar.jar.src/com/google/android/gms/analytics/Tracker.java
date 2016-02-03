package com.google.android.gms.analytics;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.internal.hm;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

public class Tracker
{
  private Context mContext;
  private final e xe;
  private final Map<String, String> xf = new HashMap();
  private j xg;
  private final ac xh;
  private final l xi;
  private final ab xj;
  private boolean xk;
  private d xl;
  private s xm;
  private ExceptionReporter xn;
  
  Tracker(String paramString, e parame, Context paramContext)
  {
    this(paramString, parame, ac.a(), l.a(), ab.a(), new ax("tracking"), paramContext);
  }
  
  Tracker(String paramString, e parame, ac paramac, l paraml, ab paramab, j paramj, Context paramContext)
  {
    this.xe = parame;
    if (paramContext != null) {
      this.mContext = paramContext.getApplicationContext();
    }
    if (paramString != null) {
      this.xf.put("&tid", paramString);
    }
    this.xf.put("useSecure", "1");
    this.xh = paramac;
    this.xi = paraml;
    this.xj = paramab;
    this.xf.put("&a", Integer.toString(new Random().nextInt(Integer.MAX_VALUE) + 1));
    this.xg = paramj;
    this.xl = new d(this);
    enableAdvertisingIdCollection(false);
  }
  
  void a(s params)
  {
    aa.C("Loading Tracker config values.");
    this.xm = params;
    if (this.xm.a())
    {
      params = this.xm.b();
      set("&tid", params);
      aa.C("[Tracker] trackingId loaded: " + params);
    }
    if (this.xm.c())
    {
      params = Double.toString(this.xm.d());
      set("&sf", params);
      aa.C("[Tracker] sample frequency loaded: " + params);
    }
    if (this.xm.e())
    {
      setSessionTimeout(this.xm.f());
      aa.C("[Tracker] session timeout loaded: " + dy());
    }
    if (this.xm.g())
    {
      enableAutoActivityTracking(this.xm.h());
      aa.C("[Tracker] auto activity tracking loaded: " + dz());
    }
    if (this.xm.i())
    {
      if (this.xm.j())
      {
        set("&aip", "1");
        aa.C("[Tracker] anonymize ip loaded: true");
      }
      aa.C("[Tracker] anonymize ip loaded: false");
    }
    enableExceptionReporting(this.xm.k());
  }
  
  long dy()
  {
    return this.xl.a();
  }
  
  boolean dz()
  {
    return this.xl.b();
  }
  
  public void enableAdvertisingIdCollection(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      this.xf.put("&ate", null);
      this.xf.put("&adid", null);
    }
    do
    {
      return;
      if (this.xf.containsKey("&ate")) {
        this.xf.remove("&ate");
      }
    } while (!this.xf.containsKey("&adid"));
    this.xf.remove("&adid");
  }
  
  public void enableAutoActivityTracking(boolean paramBoolean)
  {
    this.xl.a(paramBoolean);
  }
  
  public void enableExceptionReporting(boolean paramBoolean)
  {
    if (this.xk == paramBoolean) {
      return;
    }
    this.xk = paramBoolean;
    if (paramBoolean)
    {
      this.xn = new ExceptionReporter(this, Thread.getDefaultUncaughtExceptionHandler(), this.mContext);
      Thread.setDefaultUncaughtExceptionHandler(this.xn);
      aa.C("Uncaught exceptions will be reported to Google Analytics.");
      return;
    }
    if (this.xn != null) {
      Thread.setDefaultUncaughtExceptionHandler(this.xn.cD());
    }
    for (;;)
    {
      aa.C("Uncaught exceptions will not be reported to Google Analytics.");
      return;
      Thread.setDefaultUncaughtExceptionHandler(null);
    }
  }
  
  public String get(String paramString)
  {
    u.a().a(u.a.vf);
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return null;
      if (this.xf.containsKey(paramString)) {
        return (String)this.xf.get(paramString);
      }
      if (paramString.equals("&ul")) {
        return t.a(Locale.getDefault());
      }
      if ((this.xh != null) && (this.xh.b(paramString))) {
        return this.xh.a(paramString);
      }
      if ((this.xi != null) && (this.xi.b(paramString))) {
        return this.xi.a(paramString);
      }
    } while ((this.xj == null) || (!this.xj.b(paramString)));
    return this.xj.a(paramString);
  }
  
  public void send(Map<String, String> paramMap)
  {
    u.a().a(u.a.vh);
    HashMap localHashMap = new HashMap();
    localHashMap.putAll(this.xf);
    if (paramMap != null) {
      localHashMap.putAll(paramMap);
    }
    if (TextUtils.isEmpty((CharSequence)localHashMap.get("&tid"))) {
      aa.D(String.format("Missing tracking id (%s) parameter.", new Object[] { "&tid" }));
    }
    String str = (String)localHashMap.get("&t");
    paramMap = str;
    if (TextUtils.isEmpty(str))
    {
      aa.D(String.format("Missing hit type (%s) parameter.", new Object[] { "&t" }));
      paramMap = "";
    }
    if (this.xl.c()) {
      localHashMap.put("&sc", "start");
    }
    paramMap = paramMap.toLowerCase();
    if (("screenview".equals(paramMap)) || ("pageview".equals(paramMap)) || ("appview".equals(paramMap)) || (TextUtils.isEmpty(paramMap)))
    {
      int j = Integer.parseInt((String)this.xf.get("&a")) + 1;
      int i = j;
      if (j >= Integer.MAX_VALUE) {
        i = 1;
      }
      this.xf.put("&a", Integer.toString(i));
    }
    if ((!paramMap.equals("transaction")) && (!paramMap.equals("item")) && (!this.xg.a()))
    {
      aa.D("Too many hits sent too quickly, rate limiting invoked.");
      return;
    }
    this.xe.p(localHashMap);
  }
  
  public void set(String paramString1, String paramString2)
  {
    hm.b(paramString1, "Key should be non-null");
    u.a().a(u.a.vg);
    this.xf.put(paramString1, paramString2);
  }
  
  public void setAnonymizeIp(boolean paramBoolean)
  {
    set("&aip", t.a(paramBoolean));
  }
  
  public void setAppId(String paramString)
  {
    set("&aid", paramString);
  }
  
  public void setAppInstallerId(String paramString)
  {
    set("&aiid", paramString);
  }
  
  public void setAppName(String paramString)
  {
    set("&an", paramString);
  }
  
  public void setAppVersion(String paramString)
  {
    set("&av", paramString);
  }
  
  public void setClientId(String paramString)
  {
    set("&cid", paramString);
  }
  
  public void setEncoding(String paramString)
  {
    set("&de", paramString);
  }
  
  public void setHostname(String paramString)
  {
    set("&dh", paramString);
  }
  
  public void setLanguage(String paramString)
  {
    set("&ul", paramString);
  }
  
  public void setLocation(String paramString)
  {
    set("&dl", paramString);
  }
  
  public void setPage(String paramString)
  {
    set("&dp", paramString);
  }
  
  public void setReferrer(String paramString)
  {
    set("&dr", paramString);
  }
  
  public void setSampleRate(double paramDouble)
  {
    set("&sf", Double.toHexString(paramDouble));
  }
  
  public void setScreenColors(String paramString)
  {
    set("&sd", paramString);
  }
  
  public void setScreenName(String paramString)
  {
    set("&cd", paramString);
  }
  
  public void setScreenResolution(int paramInt1, int paramInt2)
  {
    if ((paramInt1 < 0) && (paramInt2 < 0))
    {
      aa.D("Invalid width or height. The values should be non-negative.");
      return;
    }
    set("&sr", paramInt1 + "x" + paramInt2);
  }
  
  public void setSessionTimeout(long paramLong)
  {
    this.xl.a(1000L * paramLong);
  }
  
  public void setTitle(String paramString)
  {
    set("&dt", paramString);
  }
  
  public void setUseSecure(boolean paramBoolean)
  {
    set("useSecure", t.a(paramBoolean));
  }
  
  public void setViewportSize(String paramString)
  {
    set("&vp", paramString);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/analytics/Tracker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */