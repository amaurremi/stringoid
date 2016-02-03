package com.google.android.gms.tagmanager;

import android.content.Context;
import android.os.Process;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.internal.ik;
import com.google.android.gms.internal.im;
import java.io.IOException;

class a
{
  private static a aee;
  private static Object tn = new Object();
  private volatile long adZ = 900000L;
  private volatile long aea = 30000L;
  private volatile long aeb;
  private final ik aec;
  private a aed = new a()
  {
    public AdvertisingIdClient.Info lb()
    {
      try
      {
        AdvertisingIdClient.Info localInfo = AdvertisingIdClient.getAdvertisingIdInfo(a.a(a.this));
        return localInfo;
      }
      catch (IllegalStateException localIllegalStateException)
      {
        bh.D("IllegalStateException getting Advertising Id Info");
        return null;
      }
      catch (GooglePlayServicesRepairableException localGooglePlayServicesRepairableException)
      {
        bh.D("GooglePlayServicesRepairableException getting Advertising Id Info");
        return null;
      }
      catch (IOException localIOException)
      {
        bh.D("IOException getting Ad Id Info");
        return null;
      }
      catch (GooglePlayServicesNotAvailableException localGooglePlayServicesNotAvailableException)
      {
        bh.D("GooglePlayServicesNotAvailableException getting Advertising Id Info");
        return null;
      }
      catch (Exception localException)
      {
        bh.D("Unknown exception. Could not get the Advertising Id Info.");
      }
      return null;
    }
  };
  private volatile boolean mClosed = false;
  private final Context mContext;
  private final Thread sc;
  private volatile AdvertisingIdClient.Info tp;
  
  private a(Context paramContext)
  {
    this(paramContext, null, im.fW());
  }
  
  a(Context paramContext, a parama, ik paramik)
  {
    this.aec = paramik;
    if (paramContext != null) {}
    for (this.mContext = paramContext.getApplicationContext();; this.mContext = paramContext)
    {
      if (parama != null) {
        this.aed = parama;
      }
      this.sc = new Thread(new Runnable()
      {
        public void run()
        {
          a.b(a.this);
        }
      });
      return;
    }
  }
  
  static a J(Context paramContext)
  {
    if (aee == null) {}
    synchronized (tn)
    {
      if (aee == null)
      {
        aee = new a(paramContext);
        aee.start();
      }
      return aee;
    }
  }
  
  private void kZ()
  {
    Process.setThreadPriority(10);
    while (!this.mClosed) {
      try
      {
        this.tp = this.aed.lb();
        Thread.sleep(this.adZ);
      }
      catch (InterruptedException localInterruptedException)
      {
        bh.B("sleep interrupted in AdvertiserDataPoller thread; continuing");
      }
    }
  }
  
  private void la()
  {
    if (this.aec.currentTimeMillis() - this.aeb < this.aea) {
      return;
    }
    interrupt();
    this.aeb = this.aec.currentTimeMillis();
  }
  
  void interrupt()
  {
    this.sc.interrupt();
  }
  
  public boolean isLimitAdTrackingEnabled()
  {
    la();
    if (this.tp == null) {
      return true;
    }
    return this.tp.isLimitAdTrackingEnabled();
  }
  
  public String kY()
  {
    la();
    if (this.tp == null) {
      return null;
    }
    return this.tp.getId();
  }
  
  void start()
  {
    this.sc.start();
  }
  
  public static abstract interface a
  {
    public abstract AdvertisingIdClient.Info lb();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/tagmanager/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */