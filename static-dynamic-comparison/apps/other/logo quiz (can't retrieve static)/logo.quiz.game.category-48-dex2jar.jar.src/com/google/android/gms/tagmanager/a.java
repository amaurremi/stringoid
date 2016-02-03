package com.google.android.gms.tagmanager;

import android.content.Context;
import android.os.Process;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.internal.ju;
import com.google.android.gms.internal.jw;
import java.io.IOException;

class a
{
  private static a anF;
  private static Object xz = new Object();
  private volatile long anB = 900000L;
  private volatile long anC = 30000L;
  private volatile long anD;
  private a anE = new a()
  {
    public AdvertisingIdClient.Info nK()
    {
      try
      {
        AdvertisingIdClient.Info localInfo = AdvertisingIdClient.getAdvertisingIdInfo(a.a(a.this));
        return localInfo;
      }
      catch (IllegalStateException localIllegalStateException)
      {
        bh.W("IllegalStateException getting Advertising Id Info");
        return null;
      }
      catch (GooglePlayServicesRepairableException localGooglePlayServicesRepairableException)
      {
        bh.W("GooglePlayServicesRepairableException getting Advertising Id Info");
        return null;
      }
      catch (IOException localIOException)
      {
        bh.W("IOException getting Ad Id Info");
        return null;
      }
      catch (GooglePlayServicesNotAvailableException localGooglePlayServicesNotAvailableException)
      {
        bh.W("GooglePlayServicesNotAvailableException getting Advertising Id Info");
        return null;
      }
      catch (Exception localException)
      {
        bh.W("Unknown exception. Could not get the Advertising Id Info.");
      }
      return null;
    }
  };
  private volatile boolean mClosed = false;
  private final Context mContext;
  private final Thread wf;
  private volatile AdvertisingIdClient.Info xB;
  private final ju yD;
  
  private a(Context paramContext)
  {
    this(paramContext, null, jw.hA());
  }
  
  a(Context paramContext, a parama, ju paramju)
  {
    this.yD = paramju;
    if (paramContext != null) {}
    for (this.mContext = paramContext.getApplicationContext();; this.mContext = paramContext)
    {
      if (parama != null) {
        this.anE = parama;
      }
      this.wf = new Thread(new Runnable()
      {
        public void run()
        {
          a.b(a.this);
        }
      });
      return;
    }
  }
  
  static a V(Context paramContext)
  {
    if (anF == null) {}
    synchronized (xz)
    {
      if (anF == null)
      {
        anF = new a(paramContext);
        anF.start();
      }
      return anF;
    }
  }
  
  private void nI()
  {
    Process.setThreadPriority(10);
    while (!this.mClosed) {
      try
      {
        this.xB = this.anE.nK();
        Thread.sleep(this.anB);
      }
      catch (InterruptedException localInterruptedException)
      {
        bh.U("sleep interrupted in AdvertiserDataPoller thread; continuing");
      }
    }
  }
  
  private void nJ()
  {
    if (this.yD.currentTimeMillis() - this.anD < this.anC) {
      return;
    }
    interrupt();
    this.anD = this.yD.currentTimeMillis();
  }
  
  void interrupt()
  {
    this.wf.interrupt();
  }
  
  public boolean isLimitAdTrackingEnabled()
  {
    nJ();
    if (this.xB == null) {
      return true;
    }
    return this.xB.isLimitAdTrackingEnabled();
  }
  
  public String nH()
  {
    nJ();
    if (this.xB == null) {
      return null;
    }
    return this.xB.getId();
  }
  
  void start()
  {
    this.wf.start();
  }
  
  public static abstract interface a
  {
    public abstract AdvertisingIdClient.Info nK();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/tagmanager/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */