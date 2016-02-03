package com.google.analytics.tracking.android;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.analytics.internal.Command;
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

class r
  extends Thread
  implements e
{
  private static r jt;
  private volatile String hV;
  private final LinkedBlockingQueue<Runnable> jp = new LinkedBlockingQueue();
  private volatile boolean jq = false;
  private volatile List<Command> jr;
  private volatile String js;
  private volatile ac ju;
  private volatile boolean mClosed = false;
  private final Context mContext;
  
  private r(Context paramContext)
  {
    super("GAThread");
    if (paramContext != null) {}
    for (this.mContext = paramContext.getApplicationContext();; this.mContext = paramContext)
    {
      start();
      return;
    }
  }
  
  private String a(Throwable paramThrowable)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    PrintStream localPrintStream = new PrintStream(localByteArrayOutputStream);
    paramThrowable.printStackTrace(localPrintStream);
    localPrintStream.flush();
    return new String(localByteArrayOutputStream.toByteArray());
  }
  
  private String d(Map<String, String> paramMap)
  {
    if (paramMap.containsKey("useSecure"))
    {
      if (ah.a((String)paramMap.get("useSecure"), true)) {
        return "https:";
      }
      return "http:";
    }
    return "https:";
  }
  
  private boolean e(Map<String, String> paramMap)
  {
    if (paramMap.get("&sf") == null) {
      return false;
    }
    double d = ah.a((String)paramMap.get("&sf"), 100.0D);
    if (d >= 100.0D) {
      return false;
    }
    if (x((String)paramMap.get("&cid")) % 10000 >= d * 100.0D)
    {
      if (paramMap.get("&t") == null) {}
      for (paramMap = "unknown";; paramMap = (String)paramMap.get("&t"))
      {
        v.C(String.format("%s hit sampled out", new Object[] { paramMap }));
        return true;
      }
    }
    return false;
  }
  
  private void f(Map<String, String> paramMap)
  {
    f localf = f.jr();
    ah.a(paramMap, "&an", localf.getValue("&an"));
    ah.a(paramMap, "&av", localf.getValue("&av"));
    ah.a(paramMap, "&aid", localf.getValue("&aid"));
    ah.a(paramMap, "&aiid", localf.getValue("&aiid"));
    paramMap.put("&v", "1");
  }
  
  static r h(Context paramContext)
  {
    if (jt == null) {
      jt = new r(paramContext);
    }
    return jt;
  }
  
  static String i(Context paramContext)
  {
    try
    {
      localObject = paramContext.openFileInput("gaInstallData");
      arrayOfByte = new byte[' '];
      i = ((FileInputStream)localObject).read(arrayOfByte, 0, 8192);
      if (((FileInputStream)localObject).available() > 0)
      {
        v.A("Too much campaign data, ignoring it.");
        ((FileInputStream)localObject).close();
        paramContext.deleteFile("gaInstallData");
        return null;
      }
      ((FileInputStream)localObject).close();
      paramContext.deleteFile("gaInstallData");
      if (i <= 0)
      {
        v.D("Campaign file is empty.");
        return null;
      }
    }
    catch (FileNotFoundException paramContext)
    {
      byte[] arrayOfByte;
      int i;
      v.B("No campaign data found.");
      return null;
      Object localObject = new String(arrayOfByte, 0, i);
      v.B("Campaign found: " + (String)localObject);
      return (String)localObject;
    }
    catch (IOException localIOException)
    {
      v.A("Error reading campaign data.");
      paramContext.deleteFile("gaInstallData");
    }
    return null;
  }
  
  static int x(String paramString)
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
  
  void a(Runnable paramRunnable)
  {
    this.jp.add(paramRunnable);
  }
  
  public void b(Map<String, String> paramMap)
  {
    final HashMap localHashMap = new HashMap(paramMap);
    String str = (String)paramMap.get("&ht");
    paramMap = str;
    if (str != null) {}
    try
    {
      Long.valueOf(str).longValue();
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
        if (TextUtils.isEmpty((CharSequence)localHashMap.get("&cid"))) {
          localHashMap.put("&cid", r.a(r.this));
        }
        if ((s.j(r.b(r.this)).jZ()) || (r.a(r.this, localHashMap))) {
          return;
        }
        if (!TextUtils.isEmpty(r.c(r.this)))
        {
          GAUsage.jU().o(true);
          localHashMap.putAll(new w().E(r.c(r.this)).kg());
          GAUsage.jU().o(false);
          r.a(r.this, null);
        }
        r.b(r.this, localHashMap);
        Map localMap = u.g(localHashMap);
        r.e(r.this).b(localMap, Long.valueOf((String)localHashMap.get("&ht")).longValue(), r.c(r.this, localHashMap), r.d(r.this));
      }
    });
  }
  
  public Thread getThread()
  {
    return this;
  }
  
  protected void init()
  {
    this.ju.jK();
    this.jr = new ArrayList();
    this.jr.add(new Command("appendVersion", "&_v".substring(1), "ma3.0.1"));
    this.jr.add(new Command("appendQueueTime", "&qt".substring(1), null));
    this.jr.add(new Command("appendCacheBuster", "&z".substring(1), null));
  }
  
  public void jn()
  {
    a(new Runnable()
    {
      public void run()
      {
        r.e(r.this).jn();
      }
    });
  }
  
  public void jp()
  {
    a(new Runnable()
    {
      public void run()
      {
        r.e(r.this).jp();
      }
    });
  }
  
  public LinkedBlockingQueue<Runnable> jq()
  {
    return this.jp;
  }
  
  public void run()
  {
    try
    {
      Thread.sleep(5000L);
      for (;;)
      {
        try
        {
          if (this.ju == null) {
            this.ju = new GAServiceProxy(this.mContext, this);
          }
          init();
          this.hV = g.js().getValue("&cid");
          this.js = i(this.mContext);
        }
        catch (Throwable localThrowable2)
        {
          v.A("Error initializing the GAThread: " + a(localThrowable2));
          v.A("Google Analytics will not start up.");
          this.jq = true;
          continue;
        }
        if (this.mClosed) {
          return;
        }
        try
        {
          Runnable localRunnable = (Runnable)this.jp.take();
          if (!this.jq) {
            localRunnable.run();
          }
        }
        catch (InterruptedException localInterruptedException1)
        {
          v.B(localInterruptedException1.toString());
        }
        catch (Throwable localThrowable1)
        {
          v.A("Error on GAThread: " + a(localThrowable1));
          v.A("Google Analytics is shutting down.");
          this.jq = true;
        }
      }
    }
    catch (InterruptedException localInterruptedException2)
    {
      for (;;)
      {
        v.D("sleep interrupted in GAThread initialize");
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/analytics/tracking/android/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */