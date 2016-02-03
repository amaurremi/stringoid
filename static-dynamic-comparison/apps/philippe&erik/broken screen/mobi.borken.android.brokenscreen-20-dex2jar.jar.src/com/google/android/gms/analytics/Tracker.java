package com.google.android.gms.analytics;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.internal.hn;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

public class Tracker
{
  private Context mContext;
  private final TrackerHandler xb;
  private final Map<String, String> xc = new HashMap();
  private ad xd;
  private final h xe;
  private final ae xf;
  private final g xg;
  private boolean xh;
  private a xi;
  private aj xj;
  private ExceptionReporter xk;
  
  Tracker(String paramString, TrackerHandler paramTrackerHandler, Context paramContext)
  {
    this(paramString, paramTrackerHandler, h.cq(), ae.dq(), g.cp(), new z("tracking"), paramContext);
  }
  
  Tracker(String paramString, TrackerHandler paramTrackerHandler, h paramh, ae paramae, g paramg, ad paramad, Context paramContext)
  {
    this.xb = paramTrackerHandler;
    if (paramContext != null) {
      this.mContext = paramContext.getApplicationContext();
    }
    if (paramString != null) {
      this.xc.put("&tid", paramString);
    }
    this.xc.put("useSecure", "1");
    this.xe = paramh;
    this.xf = paramae;
    this.xg = paramg;
    this.xc.put("&a", Integer.toString(new Random().nextInt(Integer.MAX_VALUE) + 1));
    this.xd = paramad;
    this.xi = new a();
    enableAdvertisingIdCollection(false);
  }
  
  void a(aj paramaj)
  {
    aa.C("Loading Tracker config values.");
    this.xj = paramaj;
    if (this.xj.dz())
    {
      paramaj = this.xj.dA();
      set("&tid", paramaj);
      aa.C("[Tracker] trackingId loaded: " + paramaj);
    }
    if (this.xj.dB())
    {
      paramaj = Double.toString(this.xj.dC());
      set("&sf", paramaj);
      aa.C("[Tracker] sample frequency loaded: " + paramaj);
    }
    if (this.xj.dD())
    {
      setSessionTimeout(this.xj.getSessionTimeout());
      aa.C("[Tracker] session timeout loaded: " + dt());
    }
    if (this.xj.dE())
    {
      enableAutoActivityTracking(this.xj.dF());
      aa.C("[Tracker] auto activity tracking loaded: " + du());
    }
    if (this.xj.dG())
    {
      if (this.xj.dH())
      {
        set("&aip", "1");
        aa.C("[Tracker] anonymize ip loaded: true");
      }
      aa.C("[Tracker] anonymize ip loaded: false");
    }
    enableExceptionReporting(this.xj.dI());
  }
  
  long dt()
  {
    return this.xi.dt();
  }
  
  boolean du()
  {
    return this.xi.du();
  }
  
  public void enableAdvertisingIdCollection(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      this.xc.put("&ate", null);
      this.xc.put("&adid", null);
    }
    do
    {
      return;
      if (this.xc.containsKey("&ate")) {
        this.xc.remove("&ate");
      }
    } while (!this.xc.containsKey("&adid"));
    this.xc.remove("&adid");
  }
  
  public void enableAutoActivityTracking(boolean paramBoolean)
  {
    this.xi.enableAutoActivityTracking(paramBoolean);
  }
  
  public void enableExceptionReporting(boolean paramBoolean)
  {
    if (this.xh == paramBoolean) {
      return;
    }
    this.xh = paramBoolean;
    if (paramBoolean)
    {
      this.xk = new ExceptionReporter(this, Thread.getDefaultUncaughtExceptionHandler(), this.mContext);
      Thread.setDefaultUncaughtExceptionHandler(this.xk);
      aa.C("Uncaught exceptions will be reported to Google Analytics.");
      return;
    }
    if (this.xk != null) {
      Thread.setDefaultUncaughtExceptionHandler(this.xk.cy());
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
    u.cP().a(u.a.vc);
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return null;
      if (this.xc.containsKey(paramString)) {
        return (String)this.xc.get(paramString);
      }
      if (paramString.equals("&ul")) {
        return ak.a(Locale.getDefault());
      }
      if ((this.xe != null) && (this.xe.J(paramString))) {
        return this.xe.getValue(paramString);
      }
      if ((this.xf != null) && (this.xf.J(paramString))) {
        return this.xf.getValue(paramString);
      }
    } while ((this.xg == null) || (!this.xg.J(paramString)));
    return this.xg.getValue(paramString);
  }
  
  public void send(Map<String, String> paramMap)
  {
    u.cP().a(u.a.ve);
    HashMap localHashMap = new HashMap();
    localHashMap.putAll(this.xc);
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
    if (this.xi.dv()) {
      localHashMap.put("&sc", "start");
    }
    paramMap = paramMap.toLowerCase();
    if (("screenview".equals(paramMap)) || ("pageview".equals(paramMap)) || ("appview".equals(paramMap)) || (TextUtils.isEmpty(paramMap)))
    {
      int j = Integer.parseInt((String)this.xc.get("&a")) + 1;
      int i = j;
      if (j >= Integer.MAX_VALUE) {
        i = 1;
      }
      this.xc.put("&a", Integer.toString(i));
    }
    if ((!paramMap.equals("transaction")) && (!paramMap.equals("item")) && (!this.xd.dj()))
    {
      aa.D("Too many hits sent too quickly, rate limiting invoked.");
      return;
    }
    this.xb.p(localHashMap);
  }
  
  public void set(String paramString1, String paramString2)
  {
    hn.b(paramString1, "Key should be non-null");
    u.cP().a(u.a.vd);
    this.xc.put(paramString1, paramString2);
  }
  
  public void setAnonymizeIp(boolean paramBoolean)
  {
    set("&aip", ak.v(paramBoolean));
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
    this.xi.setSessionTimeout(1000L * paramLong);
  }
  
  public void setTitle(String paramString)
  {
    set("&dt", paramString);
  }
  
  public void setUseSecure(boolean paramBoolean)
  {
    set("useSecure", ak.v(paramBoolean));
  }
  
  public void setViewportSize(String paramString)
  {
    set("&vp", paramString);
  }
  
  private class a
    implements GoogleAnalytics.a
  {
    private i ur = new i()
    {
      public long currentTimeMillis()
      {
        return System.currentTimeMillis();
      }
    };
    private boolean xl = false;
    private int xm = 0;
    private long xn = -1L;
    private boolean xo = false;
    private long xp;
    
    public a() {}
    
    private void dw()
    {
      GoogleAnalytics localGoogleAnalytics = GoogleAnalytics.dd();
      if (localGoogleAnalytics == null)
      {
        aa.A("GoogleAnalytics isn't initialized for the Tracker!");
        return;
      }
      if ((this.xn >= 0L) || (this.xl))
      {
        localGoogleAnalytics.a(Tracker.b(Tracker.this));
        return;
      }
      localGoogleAnalytics.b(Tracker.b(Tracker.this));
    }
    
    public long dt()
    {
      return this.xn;
    }
    
    public boolean du()
    {
      return this.xl;
    }
    
    public boolean dv()
    {
      boolean bool = this.xo;
      this.xo = false;
      return bool;
    }
    
    boolean dx()
    {
      return this.ur.currentTimeMillis() >= this.xp + Math.max(1000L, this.xn);
    }
    
    public void enableAutoActivityTracking(boolean paramBoolean)
    {
      this.xl = paramBoolean;
      dw();
    }
    
    public void h(Activity paramActivity)
    {
      u.cP().a(u.a.wb);
      if ((this.xm == 0) && (dx())) {
        this.xo = true;
      }
      this.xm += 1;
      HashMap localHashMap;
      Tracker localTracker;
      if (this.xl)
      {
        localHashMap = new HashMap();
        localHashMap.put("&t", "screenview");
        u.cP().u(true);
        localTracker = Tracker.this;
        if (Tracker.c(Tracker.this) == null) {
          break label121;
        }
      }
      label121:
      for (paramActivity = Tracker.c(Tracker.this).j(paramActivity);; paramActivity = paramActivity.getClass().getCanonicalName())
      {
        localTracker.set("&cd", paramActivity);
        Tracker.this.send(localHashMap);
        u.cP().u(false);
        return;
      }
    }
    
    public void i(Activity paramActivity)
    {
      u.cP().a(u.a.wc);
      this.xm -= 1;
      this.xm = Math.max(0, this.xm);
      if (this.xm == 0) {
        this.xp = this.ur.currentTimeMillis();
      }
    }
    
    public void setSessionTimeout(long paramLong)
    {
      this.xn = paramLong;
      dw();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/analytics/Tracker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */