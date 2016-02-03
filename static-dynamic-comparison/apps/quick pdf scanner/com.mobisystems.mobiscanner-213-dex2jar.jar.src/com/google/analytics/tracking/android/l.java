package com.google.analytics.tracking.android;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public class l
  extends af
{
  private static l ia;
  private static String ib;
  private final s ic;
  private boolean ie;
  private boolean jdField_if;
  private int ig;
  private long ih;
  private long ii;
  private final Map<String, String> ij;
  private x ik;
  private ab il;
  private h im;
  private Timer io;
  private TimerTask ip;
  private boolean iq;
  private boolean ir;
  private Context mContext;
  
  private l(Context paramContext)
  {
    this(paramContext, new y(paramContext), s.j(paramContext), q.jC(), null);
  }
  
  private l(Context paramContext, x paramx, s params, ab paramab, ag paramag) {}
  
  private void a(Context paramContext, x paramx, ab paramab)
  {
    if (paramContext == null) {
      v.A("Context cannot be null");
    }
    this.mContext = paramContext.getApplicationContext();
    this.il = paramab;
    this.ik = paramx;
    jA();
  }
  
  private String c(Activity paramActivity)
  {
    String str1 = paramActivity.getClass().getCanonicalName();
    if (this.ij.containsKey(str1)) {
      return (String)this.ij.get(str1);
    }
    String str2 = this.ik.getString(str1);
    paramActivity = str2;
    if (str2 == null) {
      paramActivity = str1;
    }
    this.ij.put(str1, paramActivity);
    return paramActivity;
  }
  
  public static l e(Context paramContext)
  {
    if (ia == null) {
      ia = new l(paramContext);
    }
    return ia;
  }
  
  private void jA()
  {
    v.C("Starting EasyTracker.");
    Object localObject2 = this.ik.getString("ga_trackingId");
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = this.ik.getString("ga_api_key");
    }
    set("&tid", (String)localObject1);
    v.C("[EasyTracker] trackingId loaded: " + (String)localObject1);
    localObject1 = this.ik.getString("ga_appName");
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      v.C("[EasyTracker] app name loaded: " + (String)localObject1);
      set("&an", (String)localObject1);
    }
    localObject1 = this.ik.getString("ga_appVersion");
    if (localObject1 != null)
    {
      v.C("[EasyTracker] app version loaded: " + (String)localObject1);
      set("&av", (String)localObject1);
    }
    localObject1 = this.ik.getString("ga_logLevel");
    if (localObject1 != null)
    {
      localObject1 = t((String)localObject1);
      if (localObject1 != null)
      {
        v.C("[EasyTracker] log level loaded: " + localObject1);
        this.ic.ka().a((Logger.LogLevel)localObject1);
      }
    }
    localObject2 = this.ik.F("ga_sampleFrequency");
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new Double(this.ik.getInt("ga_sampleRate", 100));
    }
    if (((Double)localObject1).doubleValue() != 100.0D) {
      set("&sf", Double.toString(((Double)localObject1).doubleValue()));
    }
    v.C("[EasyTracker] sample rate loaded: " + localObject1);
    int i = this.ik.getInt("ga_dispatchPeriod", 1800);
    v.C("[EasyTracker] dispatch period loaded: " + i);
    this.il.aX(i);
    this.ih = (this.ik.getInt("ga_sessionTimeout", 30) * 1000);
    v.C("[EasyTracker] session timeout loaded: " + this.ih);
    if ((this.ik.getBoolean("ga_autoActivityTracking")) || (this.ik.getBoolean("ga_auto_activity_tracking"))) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_if = bool;
      v.C("[EasyTracker] auto activity tracking loaded: " + this.jdField_if);
      bool = this.ik.getBoolean("ga_anonymizeIp");
      if (bool)
      {
        set("&aip", "1");
        v.C("[EasyTracker] anonymize ip loaded: " + bool);
      }
      this.ie = this.ik.getBoolean("ga_reportUncaughtExceptions");
      if (this.ie)
      {
        Thread.setDefaultUncaughtExceptionHandler(new n(this, this.il, Thread.getDefaultUncaughtExceptionHandler(), this.mContext));
        v.C("[EasyTracker] report uncaught exceptions loaded: " + this.ie);
      }
      bool = this.ik.getBoolean("ga_dryRun");
      this.ic.p(bool);
      return;
    }
  }
  
  private void jB()
  {
    try
    {
      if (this.io != null)
      {
        this.io.cancel();
        this.io = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private Logger.LogLevel t(String paramString)
  {
    try
    {
      paramString = Logger.LogLevel.valueOf(paramString.toUpperCase());
      return paramString;
    }
    catch (IllegalArgumentException paramString) {}
    return null;
  }
  
  public void a(Activity paramActivity)
  {
    GAUsage.jU().a(GAUsage.Field.kK);
    jB();
    if ((!this.iq) && (this.ig == 0) && (jz())) {
      this.ir = true;
    }
    this.iq = true;
    this.ig += 1;
    if (this.jdField_if)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("&t", "appview");
      GAUsage.jU().o(true);
      set("&cd", c(paramActivity));
      c(localHashMap);
      GAUsage.jU().o(false);
    }
  }
  
  public void b(Activity paramActivity)
  {
    GAUsage.jU().a(GAUsage.Field.kL);
    this.ig -= 1;
    this.ig = Math.max(0, this.ig);
    this.ii = this.im.currentTimeMillis();
    if (this.ig == 0)
    {
      jB();
      this.ip = new a(null);
      this.io = new Timer("waitForActivityStart");
      this.io.schedule(this.ip, 1000L);
    }
  }
  
  public void c(Map<String, String> paramMap)
  {
    if (this.ir)
    {
      paramMap.put("&sc", "start");
      this.ir = false;
    }
    super.c(paramMap);
  }
  
  boolean jz()
  {
    return (this.ih == 0L) || ((this.ih > 0L) && (this.im.currentTimeMillis() > this.ii + this.ih));
  }
  
  private class a
    extends TimerTask
  {
    private a() {}
    
    public void run()
    {
      l.a(l.this, false);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/analytics/tracking/android/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */