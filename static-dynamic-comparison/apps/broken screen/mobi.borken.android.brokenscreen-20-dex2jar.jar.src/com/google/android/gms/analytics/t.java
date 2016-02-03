package com.google.android.gms.analytics;

import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.google.android.gms.internal.fe;
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
  private static t uL;
  private volatile boolean mClosed = false;
  private final Context mContext;
  private final LinkedBlockingQueue<Runnable> uH = new LinkedBlockingQueue();
  private volatile boolean uI = false;
  private volatile List<fe> uJ;
  private volatile String uK;
  private volatile ag uM;
  
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
  
  static int O(String paramString)
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
  
  private String q(Map<String, String> paramMap)
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
  
  private boolean r(Map<String, String> paramMap)
  {
    if (paramMap.get("&sf") == null) {
      return false;
    }
    double d = ak.a((String)paramMap.get("&sf"), 100.0D);
    if (d >= 100.0D) {
      return false;
    }
    if (O((String)paramMap.get("&cid")) % 10000 >= d * 100.0D)
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
  
  private void s(Map<String, String> paramMap)
  {
    m localm = a.p(this.mContext);
    ak.a(paramMap, "&adid", localm.getValue("&adid"));
    ak.a(paramMap, "&ate", localm.getValue("&ate"));
  }
  
  private void t(Map<String, String> paramMap)
  {
    g localg = g.cp();
    ak.a(paramMap, "&an", localg.getValue("&an"));
    ak.a(paramMap, "&av", localg.getValue("&av"));
    ak.a(paramMap, "&aid", localg.getValue("&aid"));
    ak.a(paramMap, "&aiid", localg.getValue("&aiid"));
    paramMap.put("&v", "1");
  }
  
  static t u(Context paramContext)
  {
    if (uL == null) {
      uL = new t(paramContext);
    }
    return uL;
  }
  
  static String v(Context paramContext)
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
  
  void a(Runnable paramRunnable)
  {
    this.uH.add(paramRunnable);
  }
  
  public void cg()
  {
    a(new Runnable()
    {
      public void run()
      {
        t.d(t.this).cg();
      }
    });
  }
  
  public void cl()
  {
    a(new Runnable()
    {
      public void run()
      {
        t.d(t.this).cl();
      }
    });
  }
  
  public void cn()
  {
    a(new Runnable()
    {
      public void run()
      {
        t.d(t.this).cn();
      }
    });
  }
  
  public LinkedBlockingQueue<Runnable> co()
  {
    return this.uH;
  }
  
  public Thread getThread()
  {
    return this;
  }
  
  protected void init()
  {
    this.uM.cG();
    this.uJ = new ArrayList();
    this.uJ.add(new fe("appendVersion", "&_v".substring(1), "ma4.0.2"));
    this.uJ.add(new fe("appendQueueTime", "&qt".substring(1), null));
    this.uJ.add(new fe("appendCacheBuster", "&z".substring(1), null));
  }
  
  public void p(Map<String, String> paramMap)
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
        t.a(t.this, localHashMap);
        if (TextUtils.isEmpty((CharSequence)localHashMap.get("&cid"))) {
          localHashMap.put("&cid", h.cq().getValue("&cid"));
        }
        if ((GoogleAnalytics.getInstance(t.a(t.this)).getAppOptOut()) || (t.b(t.this, localHashMap))) {
          return;
        }
        if (!TextUtils.isEmpty(t.b(t.this)))
        {
          u.cP().u(true);
          localHashMap.putAll(new HitBuilders.HitBuilder().setCampaignParamsFromUrl(t.b(t.this)).build());
          u.cP().u(false);
          t.a(t.this, null);
        }
        t.c(t.this, localHashMap);
        Map localMap = y.u(localHashMap);
        t.d(t.this).b(localMap, Long.valueOf((String)localHashMap.get("&ht")).longValue(), t.d(t.this, localHashMap), t.c(t.this));
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
          if (this.uM == null) {
            this.uM = new s(this.mContext, this);
          }
          init();
          this.uK = v(this.mContext);
          aa.C("Initialized GA Thread");
        }
        catch (Throwable localThrowable2)
        {
          aa.A("Error initializing the GAThread: " + a(localThrowable2));
          aa.A("Google Analytics will not start up.");
          this.uI = true;
          continue;
        }
        if (this.mClosed) {
          return;
        }
        try
        {
          Runnable localRunnable = (Runnable)this.uH.take();
          if (!this.uI) {
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
          this.uI = true;
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/analytics/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */