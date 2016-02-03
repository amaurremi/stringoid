package com.flurry.android.monolithic.sdk.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;
import com.flurry.android.FlurryAgent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public class eg
  implements ff, id, jb, Thread.UncaughtExceptionHandler
{
  private static final String a = eg.class.getSimpleName();
  private static eg b;
  private String c = "";
  private boolean d;
  private fb e;
  private Map<String, fb> f = new HashMap();
  private em g;
  
  private eg()
  {
    jc.a().a(this);
    is.a().a(this);
    l();
  }
  
  public static eg a()
  {
    if (b == null) {
      b = new eg();
    }
    return b;
  }
  
  private void a(fb paramfb)
  {
    this.e = paramfb;
  }
  
  private Map<String, List<String>> b(Context paramContext)
  {
    Iterator localIterator = null;
    Object localObject = localIterator;
    if ((paramContext instanceof Activity))
    {
      Bundle localBundle = ((Activity)paramContext).getIntent().getExtras();
      localObject = localIterator;
      if (localBundle != null)
      {
        ja.a(3, a, "Launch Options Bundle is present " + localBundle.toString());
        localObject = new HashMap();
        localIterator = localBundle.keySet().iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          if (str != null)
          {
            paramContext = localBundle.get(str);
            if (paramContext != null) {}
            for (paramContext = paramContext.toString();; paramContext = "null")
            {
              ((Map)localObject).put(str, new ArrayList(Arrays.asList(new String[] { paramContext })));
              ja.a(3, a, "Launch options Key: " + str + ". Its value: " + paramContext);
              break;
            }
          }
        }
      }
    }
    return (Map<String, List<String>>)localObject;
  }
  
  public static int i()
  {
    return 0;
  }
  
  private void l()
  {
    ic localic = ib.a();
    this.d = ((Boolean)localic.a("CaptureUncaughtExceptions")).booleanValue();
    localic.a("CaptureUncaughtExceptions", this);
    ja.a(4, a, "initSettings, CrashReportingEnabled = " + this.d);
    String str = (String)localic.a("VesionName");
    localic.a("VesionName", this);
    ir.a(str);
    ja.a(4, a, "initSettings, VersionName = " + str);
  }
  
  private void m()
  {
    if (this.g == null) {
      this.g = new em();
    }
  }
  
  public void a(Context paramContext)
  {
    paramContext = d();
    if (paramContext != null) {
      paramContext.d();
    }
  }
  
  public void a(Context paramContext, String paramString)
  {
    jc.a().b();
    in.a().b();
    m();
    if (this.f.isEmpty()) {
      in.a().c();
    }
    if (this.f.containsKey(paramString)) {}
    fb localfb;
    for (paramContext = (fb)this.f.get(paramString);; paramContext = localfb)
    {
      paramContext.c();
      a(paramContext);
      return;
      localfb = new fb(paramContext, paramString, this);
      localfb.a(b(paramContext));
      this.f.put(paramString, localfb);
    }
  }
  
  public void a(String paramString)
  {
    fb localfb = d();
    if (localfb != null) {
      localfb.a(paramString, null, false);
    }
  }
  
  public void a(String paramString, Object paramObject)
  {
    if (paramString.equals("CaptureUncaughtExceptions"))
    {
      this.d = ((Boolean)paramObject).booleanValue();
      ja.a(4, a, "onSettingUpdate, CrashReportingEnabled = " + this.d);
      return;
    }
    if (paramString.equals("VesionName"))
    {
      paramString = (String)paramObject;
      ir.a(paramString);
      ja.a(4, a, "onSettingUpdate, VersionName = " + paramString);
      return;
    }
    ja.a(6, a, "onSettingUpdate internal error!");
  }
  
  @Deprecated
  public void a(String paramString1, String paramString2, String paramString3)
  {
    Object localObject1 = Thread.currentThread().getStackTrace();
    Object localObject2;
    if ((localObject1 != null) && (localObject1.length > 2))
    {
      localObject2 = new StackTraceElement[localObject1.length - 2];
      System.arraycopy(localObject1, 2, localObject2, 0, localObject2.length);
      localObject1 = localObject2;
    }
    for (;;)
    {
      localObject2 = new Throwable(paramString2);
      ((Throwable)localObject2).setStackTrace((StackTraceElement[])localObject1);
      localObject1 = d();
      if (localObject1 != null) {
        ((fb)localObject1).a(paramString1, paramString2, paramString3, (Throwable)localObject2);
      }
      return;
    }
  }
  
  public void a(String paramString1, String paramString2, Throwable paramThrowable)
  {
    fb localfb = d();
    if (localfb != null) {
      localfb.a(paramString1, paramString2, paramThrowable.getClass().getName(), paramThrowable);
    }
  }
  
  public void a(String paramString, Map<String, String> paramMap)
  {
    fb localfb = d();
    if (localfb != null) {
      localfb.a(paramString, paramMap, false);
    }
  }
  
  public void a(String paramString, Map<String, String> paramMap, boolean paramBoolean)
  {
    fb localfb = d();
    if (localfb != null) {
      localfb.a(paramString, paramMap, paramBoolean);
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    fb localfb = d();
    if (localfb != null) {
      localfb.a(paramString, null, paramBoolean);
    }
  }
  
  public int b()
  {
    int i = ((Integer)ib.a().a("AgentVersion")).intValue();
    ja.a(4, a, "getAgentVersion() = " + i);
    return i;
  }
  
  public void b(String paramString)
  {
    fb localfb = d();
    if (localfb != null) {
      localfb.a(paramString, null);
    }
  }
  
  public void b(String paramString, Map<String, String> paramMap)
  {
    fb localfb = d();
    if (localfb != null) {
      localfb.a(paramString, paramMap);
    }
  }
  
  public void b(boolean paramBoolean) {}
  
  public String c()
  {
    if (this.c.length() > 0) {}
    for (String str = ".";; str = "") {
      return String.format(Locale.getDefault(), "Flurry_Android_%d_%d.%d.%d%s%s", new Object[] { Integer.valueOf(b()), Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(2), str, this.c });
    }
  }
  
  public void c(String paramString)
  {
    fb localfb = d();
    if (localfb != null) {
      localfb.a(paramString, null, false);
    }
  }
  
  public void c(String paramString, Map<String, String> paramMap)
  {
    fb localfb = d();
    if (localfb != null) {
      localfb.a(paramString, paramMap, false);
    }
  }
  
  public fb d()
  {
    return this.e;
  }
  
  public void d(String paramString)
  {
    if (!this.f.containsKey(paramString)) {
      ja.a(6, a, "Ended session is not in the session map! Maybe it was already destroyed.");
    }
    for (;;)
    {
      if (this.f.isEmpty())
      {
        ja.a(5, a, "LocationProvider is going to be unsubscribed");
        in.a().d();
      }
      return;
      fb localfb = d();
      if ((localfb != null) && (TextUtils.equals(localfb.i(), paramString))) {
        a(null);
      }
      this.f.remove(paramString);
    }
  }
  
  public void e()
  {
    fb localfb = d();
    if (localfb != null) {
      localfb.f();
    }
  }
  
  public String f()
  {
    String str = null;
    fb localfb = d();
    if (localfb != null) {
      str = localfb.i();
    }
    return str;
  }
  
  public String g()
  {
    String str = null;
    fb localfb = d();
    if (localfb != null) {
      str = localfb.j();
    }
    return str;
  }
  
  public String h()
  {
    String str = null;
    fb localfb = d();
    if (localfb != null) {
      str = localfb.k();
    }
    return str;
  }
  
  public Location j()
  {
    return in.a().e();
  }
  
  public em k()
  {
    return this.g;
  }
  
  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    paramThrowable.printStackTrace();
    if (this.d)
    {
      paramThread = "";
      StackTraceElement[] arrayOfStackTraceElement = paramThrowable.getStackTrace();
      if ((arrayOfStackTraceElement == null) || (arrayOfStackTraceElement.length <= 0)) {
        break label142;
      }
      paramThread = new StringBuilder();
      if (paramThrowable.getMessage() != null) {
        paramThread.append(" (" + paramThrowable.getMessage() + ")\n");
      }
      paramThread = paramThread.toString();
    }
    for (;;)
    {
      FlurryAgent.onError("uncaught", paramThread, paramThrowable);
      paramThread = new HashMap(this.f).values().iterator();
      while (paramThread.hasNext())
      {
        paramThrowable = (fb)paramThread.next();
        if (paramThrowable != null) {
          paramThrowable.e();
        }
      }
      label142:
      if (paramThrowable.getMessage() != null) {
        paramThread = paramThrowable.getMessage();
      }
    }
    in.a().f();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/eg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */