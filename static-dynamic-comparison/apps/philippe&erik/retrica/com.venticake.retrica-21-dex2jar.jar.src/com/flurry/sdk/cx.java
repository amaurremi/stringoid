package com.flurry.sdk;

import com.flurry.android.FlurryAgent;
import java.util.HashMap;
import java.util.Map;

public class cx
  implements dq.a, Thread.UncaughtExceptionHandler
{
  private static final String a = cx.class.getSimpleName();
  private static cx b;
  private final HashMap<String, Map<String, String>> c = new HashMap();
  private boolean d;
  
  private cx()
  {
    ec.a().a(this);
    d();
  }
  
  public static cx a()
  {
    try
    {
      if (b == null) {
        b = new cx();
      }
      cx localcx = b;
      return localcx;
    }
    finally {}
  }
  
  private void d()
  {
    dq localdq = dp.a();
    this.d = ((Boolean)localdq.a("CaptureUncaughtExceptions")).booleanValue();
    localdq.a("CaptureUncaughtExceptions", this);
    eo.a(4, a, "initSettings, CrashReportingEnabled = " + this.d);
    String str = (String)localdq.a("VersionName");
    localdq.a("VersionName", this);
    eb.a(str);
    eo.a(4, a, "initSettings, VersionName = " + str);
  }
  
  public void a(String paramString)
  {
    dj localdj = dl.a().c();
    if (localdj != null) {
      localdj.a(paramString, null, false);
    }
  }
  
  public void a(String paramString, Object paramObject)
  {
    if (paramString.equals("CaptureUncaughtExceptions"))
    {
      this.d = ((Boolean)paramObject).booleanValue();
      eo.a(4, a, "onSettingUpdate, CrashReportingEnabled = " + this.d);
      return;
    }
    if (paramString.equals("VersionName"))
    {
      paramString = (String)paramObject;
      eb.a(paramString);
      eo.a(4, a, "onSettingUpdate, VersionName = " + paramString);
      return;
    }
    eo.a(6, a, "onSettingUpdate internal error!");
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
      localObject1 = dl.a().c();
      if (localObject1 != null) {
        ((dj)localObject1).a(paramString1, paramString2, paramString3, (Throwable)localObject2);
      }
      return;
    }
  }
  
  public void a(String paramString1, String paramString2, Throwable paramThrowable)
  {
    dj localdj = dl.a().c();
    if (localdj != null) {
      localdj.a(paramString1, paramString2, paramThrowable.getClass().getName(), paramThrowable);
    }
  }
  
  public void a(String paramString1, String arg2, Map<String, String> paramMap)
  {
    Object localObject = paramMap;
    if (paramMap == null) {
      localObject = new HashMap();
    }
    if (((Map)localObject).size() >= 10)
    {
      eo.d(a, "MaxOriginParams exceeded: " + ((Map)localObject).size());
      return;
    }
    ((Map)localObject).put("flurryOriginVersion", ???);
    synchronized (this.c)
    {
      if ((this.c.size() >= 10) && (!this.c.containsKey(paramString1)))
      {
        eo.d(a, "MaxOrigins exceeded: " + this.c.size());
        return;
      }
    }
    this.c.put(paramString1, localObject);
  }
  
  public void a(String paramString, Map<String, String> paramMap)
  {
    dj localdj = dl.a().c();
    if (localdj != null) {
      localdj.a(paramString, paramMap, false);
    }
  }
  
  public void a(String paramString, Map<String, String> paramMap, boolean paramBoolean)
  {
    dj localdj = dl.a().c();
    if (localdj != null) {
      localdj.a(paramString, paramMap, paramBoolean);
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    dj localdj = dl.a().c();
    if (localdj != null) {
      localdj.a(paramString, null, paramBoolean);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    eo.a(paramBoolean);
  }
  
  public HashMap<String, Map<String, String>> b()
  {
    synchronized (this.c)
    {
      HashMap localHashMap2 = new HashMap(this.c);
      return localHashMap2;
    }
  }
  
  public void b(String paramString)
  {
    dj localdj = dl.a().c();
    if (localdj != null) {
      localdj.a(paramString, null);
    }
  }
  
  public void b(String paramString, Map<String, String> paramMap)
  {
    dj localdj = dl.a().c();
    if (localdj != null) {
      localdj.a(paramString, paramMap);
    }
  }
  
  public void c()
  {
    dj localdj = dl.a().c();
    if (localdj != null) {
      localdj.e();
    }
  }
  
  public void c(String paramString)
  {
    dj localdj = dl.a().c();
    if (localdj != null) {
      localdj.a(paramString, null, false);
    }
  }
  
  public void c(String paramString, Map<String, String> paramMap)
  {
    dj localdj = dl.a().c();
    if (localdj != null) {
      localdj.a(paramString, paramMap, false);
    }
  }
  
  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    paramThrowable.printStackTrace();
    if (this.d)
    {
      paramThread = "";
      StackTraceElement[] arrayOfStackTraceElement = paramThrowable.getStackTrace();
      if ((arrayOfStackTraceElement == null) || (arrayOfStackTraceElement.length <= 0)) {
        break label100;
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
      dl.a().d();
      dz.a().g();
      return;
      label100:
      if (paramThrowable.getMessage() != null) {
        paramThread = paramThrowable.getMessage();
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/flurry/sdk/cx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */