package com.google.android.gms.analytics;

import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.google.android.gms.internal.ef;
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

class t
  extends Thread
  implements f
{
  private static t tA;
  private volatile boolean mClosed = false;
  private final Context mContext;
  private volatile String su;
  private volatile ag tB;
  private final LinkedBlockingQueue<Runnable> tw = new LinkedBlockingQueue();
  private volatile boolean tx = false;
  private volatile List<ef> ty;
  private volatile String tz;
  
  private t(Context paramContext)
  {
    super("GAThread");
    if (paramContext != null) {}
    for (this.mContext = paramContext.getApplicationContext();; this.mContext = paramContext)
    {
      start();
      return;
    }
  }
  
  static int H(String paramString)
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
  
  private String a(Throwable paramThrowable)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    PrintStream localPrintStream = new PrintStream(localByteArrayOutputStream);
    paramThrowable.printStackTrace(localPrintStream);
    localPrintStream.flush();
    return new String(localByteArrayOutputStream.toByteArray());
  }
  
  static t q(Context paramContext)
  {
    if (tA == null) {
      tA = new t(paramContext);
    }
    return tA;
  }
  
  static String r(Context paramContext)
  {
    try
    {
      localObject = paramContext.openFileInput("gaInstallData");
      arrayOfByte = new byte[' '];
      i = ((FileInputStream)localObject).read(arrayOfByte, 0, 8192);
      if (((FileInputStream)localObject).available() > 0)
      {
        aa.w("Too much campaign data, ignoring it.");
        ((FileInputStream)localObject).close();
        paramContext.deleteFile("gaInstallData");
        return null;
      }
      ((FileInputStream)localObject).close();
      paramContext.deleteFile("gaInstallData");
      if (i <= 0)
      {
        aa.z("Campaign file is empty.");
        return null;
      }
    }
    catch (FileNotFoundException paramContext)
    {
      byte[] arrayOfByte;
      int i;
      aa.x("No campaign data found.");
      return null;
      Object localObject = new String(arrayOfByte, 0, i);
      aa.x("Campaign found: " + (String)localObject);
      return (String)localObject;
    }
    catch (IOException localIOException)
    {
      aa.w("Error reading campaign data.");
      paramContext.deleteFile("gaInstallData");
    }
    return null;
  }
  
  private String r(Map<String, String> paramMap)
  {
    if (paramMap.containsKey("useSecure"))
    {
      if (ak.d((String)paramMap.get("useSecure"), true)) {
        return "https:";
      }
      return "http:";
    }
    return "https:";
  }
  
  private boolean s(Map<String, String> paramMap)
  {
    if (paramMap.get("&sf") == null) {
      return false;
    }
    double d = ak.a((String)paramMap.get("&sf"), 100.0D);
    if (d >= 100.0D) {
      return false;
    }
    if (H((String)paramMap.get("&cid")) % 10000 >= d * 100.0D)
    {
      if (paramMap.get("&t") == null) {}
      for (paramMap = "unknown";; paramMap = (String)paramMap.get("&t"))
      {
        aa.y(String.format("%s hit sampled out", new Object[] { paramMap }));
        return true;
      }
    }
    return false;
  }
  
  private void t(Map<String, String> paramMap)
  {
    m localm = a.m(this.mContext);
    ak.a(paramMap, "&adid", localm.getValue("&adid"));
    ak.a(paramMap, "&ate", localm.getValue("&ate"));
  }
  
  private void u(Map<String, String> paramMap)
  {
    g localg = g.ca();
    ak.a(paramMap, "&an", localg.getValue("&an"));
    ak.a(paramMap, "&av", localg.getValue("&av"));
    ak.a(paramMap, "&aid", localg.getValue("&aid"));
    ak.a(paramMap, "&aiid", localg.getValue("&aiid"));
    paramMap.put("&v", "1");
  }
  
  void a(Runnable paramRunnable)
  {
    this.tw.add(paramRunnable);
  }
  
  public void bR()
  {
    a(new Runnable()
    {
      public void run()
      {
        t.e(t.this).bR();
      }
    });
  }
  
  public void bW()
  {
    a(new Runnable()
    {
      public void run()
      {
        t.e(t.this).bW();
      }
    });
  }
  
  public void bY()
  {
    a(new Runnable()
    {
      public void run()
      {
        t.e(t.this).bY();
      }
    });
  }
  
  public LinkedBlockingQueue<Runnable> bZ()
  {
    return this.tw;
  }
  
  public Thread getThread()
  {
    return this;
  }
  
  protected void init()
  {
    this.tB.cp();
    this.ty = new ArrayList();
    this.ty.add(new ef("appendVersion", "&_v".substring(1), "ma4.0.1"));
    this.ty.add(new ef("appendQueueTime", "&qt".substring(1), null));
    this.ty.add(new ef("appendCacheBuster", "&z".substring(1), null));
  }
  
  public void q(Map<String, String> paramMap)
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
        if (TextUtils.isEmpty((CharSequence)localHashMap.get("&cid"))) {
          localHashMap.put("&cid", t.a(t.this));
        }
        if ((GoogleAnalytics.getInstance(t.b(t.this)).getAppOptOut()) || (t.a(t.this, localHashMap))) {
          return;
        }
        if (!TextUtils.isEmpty(t.c(t.this)))
        {
          u.cy().t(true);
          localHashMap.putAll(new HitBuilders.HitBuilder().setCampaignParamsFromUrl(t.c(t.this)).build());
          u.cy().t(false);
          t.a(t.this, null);
        }
        t.b(t.this, localHashMap);
        t.c(t.this, localHashMap);
        Map localMap = y.v(localHashMap);
        t.e(t.this).b(localMap, Long.valueOf((String)localHashMap.get("&ht")).longValue(), t.d(t.this, localHashMap), t.d(t.this));
      }
    });
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
          if (this.tB == null) {
            this.tB = new s(this.mContext, this);
          }
          init();
          this.su = h.cb().getValue("&cid");
          if (this.su == null) {
            this.tx = true;
          }
          this.tz = r(this.mContext);
          aa.y("Initialized GA Thread");
        }
        catch (Throwable localThrowable2)
        {
          aa.w("Error initializing the GAThread: " + a(localThrowable2));
          aa.w("Google Analytics will not start up.");
          this.tx = true;
          continue;
        }
        if (this.mClosed) {
          break;
        }
        try
        {
          Runnable localRunnable = (Runnable)this.tw.take();
          if (!this.tx) {
            localRunnable.run();
          }
        }
        catch (InterruptedException localInterruptedException1)
        {
          aa.x(localInterruptedException1.toString());
        }
        catch (Throwable localThrowable1)
        {
          aa.w("Error on GAThread: " + a(localThrowable1));
          aa.w("Google Analytics is shutting down.");
          this.tx = true;
        }
      }
    }
    catch (InterruptedException localInterruptedException2)
    {
      for (;;)
      {
        aa.z("sleep interrupted in GAThread initialize");
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/analytics/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */