package com.google.android.gms.analytics;

import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.google.android.gms.internal.fd;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;

class ar
  extends Thread
  implements z
{
  private static ar f;
  private final LinkedBlockingQueue<Runnable> a = new LinkedBlockingQueue();
  private volatile boolean b = false;
  private volatile boolean c = false;
  private volatile List<fd> d;
  private volatile String e;
  private volatile n g;
  private final Context h;
  
  private ar(Context paramContext)
  {
    super("GAThread");
    if (paramContext != null) {}
    for (this.h = paramContext.getApplicationContext();; this.h = paramContext)
    {
      start();
      return;
    }
  }
  
  static int a(String paramString)
  {
    int k = 1;
    if (!TextUtils.isEmpty(paramString))
    {
      int j = paramString.length();
      int i = 0;
      j -= 1;
      for (;;)
      {
        k = i;
        if (j < 0) {
          break;
        }
        k = paramString.charAt(j);
        k = (i << 6 & 0xFFFFFFF) + k + (k << 14);
        int m = 0xFE00000 & k;
        i = k;
        if (m != 0) {
          i = k ^ m >> 21;
        }
        j -= 1;
      }
    }
    return k;
  }
  
  static ar a(Context paramContext)
  {
    if (f == null) {
      f = new ar(paramContext);
    }
    return f;
  }
  
  private String a(Throwable paramThrowable)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    PrintStream localPrintStream = new PrintStream(localByteArrayOutputStream);
    paramThrowable.printStackTrace(localPrintStream);
    localPrintStream.flush();
    return new String(localByteArrayOutputStream.toByteArray());
  }
  
  static String b(Context paramContext)
  {
    try
    {
      localObject = paramContext.openFileInput("gaInstallData");
      arrayOfByte = new byte[' '];
      i = ((FileInputStream)localObject).read(arrayOfByte, 0, 8192);
      if (((FileInputStream)localObject).available() > 0)
      {
        aa.A("Too much campaign data, ignoring it.");
        ((FileInputStream)localObject).close();
        paramContext.deleteFile("gaInstallData");
        return null;
      }
      ((FileInputStream)localObject).close();
      paramContext.deleteFile("gaInstallData");
      if (i <= 0)
      {
        aa.D("Campaign file is empty.");
        return null;
      }
    }
    catch (FileNotFoundException paramContext)
    {
      byte[] arrayOfByte;
      int i;
      aa.B("No campaign data found.");
      return null;
      Object localObject = new String(arrayOfByte, 0, i);
      aa.B("Campaign found: " + (String)localObject);
      return (String)localObject;
    }
    catch (IOException localIOException)
    {
      aa.A("Error reading campaign data.");
      paramContext.deleteFile("gaInstallData");
    }
    return null;
  }
  
  private String b(Map<String, String> paramMap)
  {
    if (paramMap.containsKey("useSecure"))
    {
      if (t.a((String)paramMap.get("useSecure"), true)) {
        return "https:";
      }
      return "http:";
    }
    return "https:";
  }
  
  private boolean c(Map<String, String> paramMap)
  {
    if (paramMap.get("&sf") == null) {
      return false;
    }
    double d1 = t.a((String)paramMap.get("&sf"), 100.0D);
    if (d1 >= 100.0D) {
      return false;
    }
    if (a((String)paramMap.get("&cid")) % 10000 >= d1 * 100.0D)
    {
      if (paramMap.get("&t") == null) {}
      for (paramMap = "unknown";; paramMap = (String)paramMap.get("&t"))
      {
        aa.C(String.format("%s hit sampled out", new Object[] { paramMap }));
        return true;
      }
    }
    return false;
  }
  
  private void d(Map<String, String> paramMap)
  {
    ag localag = f.a(this.h);
    t.a(paramMap, "&adid", localag.a("&adid"));
    t.a(paramMap, "&ate", localag.a("&ate"));
  }
  
  private void e(Map<String, String> paramMap)
  {
    ab localab = ab.a();
    t.a(paramMap, "&an", localab.a("&an"));
    t.a(paramMap, "&av", localab.a("&av"));
    t.a(paramMap, "&aid", localab.a("&aid"));
    t.a(paramMap, "&aiid", localab.a("&aiid"));
    paramMap.put("&v", "1");
  }
  
  public void a()
  {
    a(new Runnable()
    {
      public void run()
      {
        ar.d(ar.this).c();
      }
    });
  }
  
  void a(Runnable paramRunnable)
  {
    this.a.add(paramRunnable);
  }
  
  public void a(Map<String, String> paramMap)
  {
    final HashMap localHashMap = new HashMap(paramMap);
    String str = (String)paramMap.get("&ht");
    paramMap = str;
    if (str != null) {}
    try
    {
      Long.valueOf(str);
      paramMap = str;
    }
    catch (NumberFormatException paramMap)
    {
      for (;;)
      {
        paramMap = null;
      }
    }
    if (paramMap == null) {
      localHashMap.put("&ht", Long.toString(System.currentTimeMillis()));
    }
    a(new Runnable()
    {
      public void run()
      {
        ar.a(ar.this, localHashMap);
        if (TextUtils.isEmpty((CharSequence)localHashMap.get("&cid"))) {
          localHashMap.put("&cid", ac.a().a("&cid"));
        }
        if ((GoogleAnalytics.getInstance(ar.a(ar.this)).getAppOptOut()) || (ar.b(ar.this, localHashMap))) {
          return;
        }
        if (!TextUtils.isEmpty(ar.b(ar.this)))
        {
          u.a().a(true);
          localHashMap.putAll(new HitBuilders.HitBuilder().setCampaignParamsFromUrl(ar.b(ar.this)).build());
          u.a().a(false);
          ar.a(ar.this, null);
        }
        ar.c(ar.this, localHashMap);
        Map localMap = aw.a(localHashMap);
        ar.d(ar.this).a(localMap, Long.valueOf((String)localHashMap.get("&ht")).longValue(), ar.d(ar.this, localHashMap), ar.c(ar.this));
      }
    });
  }
  
  public void b()
  {
    a(new Runnable()
    {
      public void run()
      {
        ar.d(ar.this).a();
      }
    });
  }
  
  public void c()
  {
    a(new Runnable()
    {
      public void run()
      {
        ar.d(ar.this).b();
      }
    });
  }
  
  public LinkedBlockingQueue<Runnable> d()
  {
    return this.a;
  }
  
  public Thread e()
  {
    return this;
  }
  
  protected void f()
  {
    this.g.d();
    this.d = new ArrayList();
    this.d.add(new fd("appendVersion", "&_v".substring(1), "ma4.0.2"));
    this.d.add(new fd("appendQueueTime", "&qt".substring(1), null));
    this.d.add(new fd("appendCacheBuster", "&z".substring(1), null));
  }
  
  public void run()
  {
    Process.setThreadPriority(10);
    try
    {
      Thread.sleep(5000L);
      for (;;)
      {
        try
        {
          if (this.g == null) {
            this.g = new al(this.h, this);
          }
          f();
          this.e = b(this.h);
          aa.C("Initialized GA Thread");
        }
        catch (Throwable localThrowable2)
        {
          aa.A("Error initializing the GAThread: " + a(localThrowable2));
          aa.A("Google Analytics will not start up.");
          this.b = true;
          continue;
        }
        if (this.c) {
          return;
        }
        try
        {
          Runnable localRunnable = (Runnable)this.a.take();
          if (!this.b) {
            localRunnable.run();
          }
        }
        catch (InterruptedException localInterruptedException1)
        {
          aa.B(localInterruptedException1.toString());
        }
        catch (Throwable localThrowable1)
        {
          aa.A("Error on GAThread: " + a(localThrowable1));
          aa.A("Google Analytics is shutting down.");
          this.b = true;
        }
      }
    }
    catch (InterruptedException localInterruptedException2)
    {
      for (;;)
      {
        aa.D("sleep interrupted in GAThread initialize");
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/analytics/ar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */