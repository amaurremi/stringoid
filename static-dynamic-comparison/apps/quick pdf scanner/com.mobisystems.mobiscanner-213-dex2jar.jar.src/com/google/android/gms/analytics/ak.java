package com.google.android.gms.analytics;

import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.google.android.gms.internal.di;
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

class ak
  extends Thread
  implements y
{
  private static ak ov;
  private volatile boolean mClosed = false;
  private final Context mContext;
  private volatile String nu;
  private final LinkedBlockingQueue<Runnable> or = new LinkedBlockingQueue();
  private volatile boolean os = false;
  private volatile List<di> ot;
  private volatile String ou;
  private volatile p ow;
  
  private ak(Context paramContext)
  {
    super("GAThread");
    if (paramContext != null) {}
    for (this.mContext = paramContext.getApplicationContext();; this.mContext = paramContext)
    {
      start();
      return;
    }
  }
  
  static int ai(String paramString)
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
  
  private String d(Throwable paramThrowable)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    PrintStream localPrintStream = new PrintStream(localByteArrayOutputStream);
    paramThrowable.printStackTrace(localPrintStream);
    localPrintStream.flush();
    return new String(localByteArrayOutputStream.toByteArray());
  }
  
  private String k(Map<String, String> paramMap)
  {
    if (paramMap.containsKey("useSecure"))
    {
      if (r.b((String)paramMap.get("useSecure"), true)) {
        return "https:";
      }
      return "http:";
    }
    return "https:";
  }
  
  private boolean l(Map<String, String> paramMap)
  {
    if (paramMap.get("&sf") == null) {
      return false;
    }
    double d = r.b((String)paramMap.get("&sf"), 100.0D);
    if (d >= 100.0D) {
      return false;
    }
    if (ai((String)paramMap.get("&cid")) % 10000 >= d * 100.0D)
    {
      if (paramMap.get("&t") == null) {}
      for (paramMap = "unknown";; paramMap = (String)paramMap.get("&t"))
      {
        j.C(String.format("%s hit sampled out", new Object[] { paramMap }));
        return true;
      }
    }
    return false;
  }
  
  private void m(Map<String, String> paramMap)
  {
    af localaf = i.p(this.mContext);
    r.b(paramMap, "&adid", localaf.getValue("&adid"));
    r.b(paramMap, "&ate", localaf.getValue("&ate"));
  }
  
  private void n(Map<String, String> paramMap)
  {
    z localz = z.lj();
    r.b(paramMap, "&an", localz.getValue("&an"));
    r.b(paramMap, "&av", localz.getValue("&av"));
    r.b(paramMap, "&aid", localz.getValue("&aid"));
    r.b(paramMap, "&aiid", localz.getValue("&aiid"));
    paramMap.put("&v", "1");
  }
  
  static ak t(Context paramContext)
  {
    if (ov == null) {
      ov = new ak(paramContext);
    }
    return ov;
  }
  
  static String u(Context paramContext)
  {
    try
    {
      localObject = paramContext.openFileInput("gaInstallData");
      arrayOfByte = new byte[' '];
      i = ((FileInputStream)localObject).read(arrayOfByte, 0, 8192);
      if (((FileInputStream)localObject).available() > 0)
      {
        j.Z("Too much campaign data, ignoring it.");
        ((FileInputStream)localObject).close();
        paramContext.deleteFile("gaInstallData");
        return null;
      }
      ((FileInputStream)localObject).close();
      paramContext.deleteFile("gaInstallData");
      if (i <= 0)
      {
        j.D("Campaign file is empty.");
        return null;
      }
    }
    catch (FileNotFoundException paramContext)
    {
      byte[] arrayOfByte;
      int i;
      j.aa("No campaign data found.");
      return null;
      Object localObject = new String(arrayOfByte, 0, i);
      j.aa("Campaign found: " + (String)localObject);
      return (String)localObject;
    }
    catch (IOException localIOException)
    {
      j.Z("Error reading campaign data.");
      paramContext.deleteFile("gaInstallData");
    }
    return null;
  }
  
  void b(Runnable paramRunnable)
  {
    this.or.add(paramRunnable);
  }
  
  public Thread getThread()
  {
    return this;
  }
  
  public void i(Map<String, String> paramMap)
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
    b(new Runnable()
    {
      public void run()
      {
        if (TextUtils.isEmpty((CharSequence)localHashMap.get("&cid"))) {
          localHashMap.put("&cid", ak.a(ak.this));
        }
        if ((c.o(ak.b(ak.this)).jZ()) || (ak.a(ak.this, localHashMap))) {
          return;
        }
        if (!TextUtils.isEmpty(ak.c(ak.this)))
        {
          u.lF().u(true);
          localHashMap.putAll(new d.c().S(ak.c(ak.this)).kg());
          u.lF().u(false);
          ak.a(ak.this, null);
        }
        ak.b(ak.this, localHashMap);
        ak.c(ak.this, localHashMap);
        Map localMap = ao.o(localHashMap);
        ak.e(ak.this).c(localMap, Long.valueOf((String)localHashMap.get("&ht")).longValue(), ak.d(ak.this, localHashMap), ak.d(ak.this));
      }
    });
  }
  
  protected void init()
  {
    this.ow.lb();
    this.ot = new ArrayList();
    this.ot.add(new di("appendVersion", "&_v".substring(1), "ma4.0.0"));
    this.ot.add(new di("appendQueueTime", "&qt".substring(1), null));
    this.ot.add(new di("appendCacheBuster", "&z".substring(1), null));
  }
  
  public void kT()
  {
    b(new Runnable()
    {
      public void run()
      {
        ak.e(ak.this).kT();
      }
    });
  }
  
  public void la()
  {
    b(new Runnable()
    {
      public void run()
      {
        ak.e(ak.this).la();
      }
    });
  }
  
  public LinkedBlockingQueue<Runnable> li()
  {
    return this.or;
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
          if (this.ow == null) {
            this.ow = new s(this.mContext, this);
          }
          init();
          this.nu = aa.lk().getValue("&cid");
          if (this.nu == null) {
            this.os = true;
          }
          this.ou = u(this.mContext);
          j.C("Initialized GA Thread");
        }
        catch (Throwable localThrowable2)
        {
          j.Z("Error initializing the GAThread: " + d(localThrowable2));
          j.Z("Google Analytics will not start up.");
          this.os = true;
          continue;
        }
        if (this.mClosed) {
          break;
        }
        try
        {
          Runnable localRunnable = (Runnable)this.or.take();
          if (!this.os) {
            localRunnable.run();
          }
        }
        catch (InterruptedException localInterruptedException1)
        {
          j.aa(localInterruptedException1.toString());
        }
        catch (Throwable localThrowable1)
        {
          j.Z("Error on GAThread: " + d(localThrowable1));
          j.Z("Google Analytics is shutting down.");
          this.os = true;
        }
      }
    }
    catch (InterruptedException localInterruptedException2)
    {
      for (;;)
      {
        j.D("sleep interrupted in GAThread initialize");
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/analytics/ak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */