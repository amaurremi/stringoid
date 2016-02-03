package com.google.android.gms.tagmanager;

import android.content.Context;
import android.os.Process;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.internal.gl;
import com.google.android.gms.internal.gn;
import java.io.IOException;

class a
{
  private static a Wx;
  private static Object sf = new Object();
  private volatile long Ws = 900000L;
  private volatile long Wt = 30000L;
  private volatile long Wu;
  private final gl Wv;
  private a Ww = new a()
  {
    public AdvertisingIdClient.Info jW()
    {
      try
      {
        AdvertisingIdClient.Info localInfo = AdvertisingIdClient.getAdvertisingIdInfo(a.a(a.this));
        return localInfo;
      }
      catch (IllegalStateException localIllegalStateException)
      {
        bh.z("IllegalStateException getting Advertising Id Info");
        return null;
      }
      catch (GooglePlayServicesRepairableException localGooglePlayServicesRepairableException)
      {
        bh.z("GooglePlayServicesRepairableException getting Advertising Id Info");
        return null;
      }
      catch (IOException localIOException)
      {
        bh.z("IOException getting Ad Id Info");
        return null;
      }
      catch (GooglePlayServicesNotAvailableException localGooglePlayServicesNotAvailableException)
      {
        bh.z("GooglePlayServicesNotAvailableException getting Advertising Id Info");
        return null;
      }
      catch (Exception localException)
      {
        bh.z("Unknown exception. Could not get the Advertising Id Info.");
      }
      return null;
    }
  };
  private volatile boolean mClosed = false;
  private final Context mContext;
  private final Thread qY;
  private volatile AdvertisingIdClient.Info sh;
  
  private a(Context paramContext)
  {
    this(paramContext, null, gn.ft());
  }
  
  a(Context paramContext, a parama, gl paramgl)
  {
    this.Wv = paramgl;
    if (paramContext != null) {}
    for (this.mContext = paramContext.getApplicationContext();; this.mContext = paramContext)
    {
      if (parama != null) {
        this.Ww = parama;
      }
      this.qY = new Thread(new Runnable()
      {
        public void run()
        {
          a.b(a.this);
        }
      });
      return;
    }
  }
  
  static a E(Context paramContext)
  {
    if (Wx == null) {}
    synchronized (sf)
    {
      if (Wx == null)
      {
        Wx = new a(paramContext);
        Wx.start();
      }
      return Wx;
    }
  }
  
  private void jU()
  {
    Process.setThreadPriority(10);
    while (!this.mClosed) {
      try
      {
        this.sh = this.Ww.jW();
        Thread.sleep(this.Ws);
      }
      catch (InterruptedException localInterruptedException)
      {
        bh.x("sleep interrupted in AdvertiserDataPoller thread; continuing");
      }
    }
  }
  
  private void jV()
  {
    if (this.Wv.currentTimeMillis() - this.Wu < this.Wt) {
      return;
    }
    interrupt();
    this.Wu = this.Wv.currentTimeMillis();
  }
  
  void interrupt()
  {
    this.qY.interrupt();
  }
  
  public boolean isLimitAdTrackingEnabled()
  {
    jV();
    if (this.sh == null) {
      return true;
    }
    return this.sh.isLimitAdTrackingEnabled();
  }
  
  public String jT()
  {
    jV();
    if (this.sh == null) {
      return null;
    }
    return this.sh.getId();
  }
  
  void start()
  {
    this.qY.start();
  }
  
  public static abstract interface a
  {
    public abstract AdvertisingIdClient.Info jW();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/tagmanager/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */