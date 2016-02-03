package com.google.android.gms.tagmanager;

import android.content.Context;
import android.os.Process;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.internal.ij;
import com.google.android.gms.internal.il;
import java.io.IOException;

class a
{
  private static Object j = new Object();
  private static a k;
  private volatile long a = 900000L;
  private volatile long b = 30000L;
  private volatile boolean c = false;
  private volatile AdvertisingIdClient.Info d;
  private volatile long e;
  private final Context f;
  private final ij g;
  private final Thread h;
  private a.a i = new a.a()
  {
    public AdvertisingIdClient.Info lg()
    {
      try
      {
        AdvertisingIdClient.Info localInfo = AdvertisingIdClient.getAdvertisingIdInfo(a.a(a.this));
        return localInfo;
      }
      catch (IllegalStateException localIllegalStateException)
      {
        as.b("IllegalStateException getting Advertising Id Info");
        return null;
      }
      catch (GooglePlayServicesRepairableException localGooglePlayServicesRepairableException)
      {
        as.b("GooglePlayServicesRepairableException getting Advertising Id Info");
        return null;
      }
      catch (IOException localIOException)
      {
        as.b("IOException getting Ad Id Info");
        return null;
      }
      catch (GooglePlayServicesNotAvailableException localGooglePlayServicesNotAvailableException)
      {
        as.b("GooglePlayServicesNotAvailableException getting Advertising Id Info");
        return null;
      }
      catch (Exception localException)
      {
        as.b("Unknown exception. Could not get the Advertising Id Info.");
      }
      return null;
    }
  };
  
  private a(Context paramContext)
  {
    this(paramContext, null, il.gb());
  }
  
  a(Context paramContext, a.a parama, ij paramij)
  {
    this.g = paramij;
    if (paramContext != null) {}
    for (this.f = paramContext.getApplicationContext();; this.f = paramContext)
    {
      if (parama != null) {
        this.i = parama;
      }
      this.h = new Thread(new Runnable()
      {
        public void run()
        {
          a.b(a.this);
        }
      });
      return;
    }
  }
  
  static a a(Context paramContext)
  {
    if (k == null) {}
    synchronized (j)
    {
      if (k == null)
      {
        k = new a(paramContext);
        k.d();
      }
      return k;
    }
  }
  
  private void e()
  {
    Process.setThreadPriority(10);
    while (!this.c) {
      try
      {
        this.d = this.i.lg();
        Thread.sleep(this.a);
      }
      catch (InterruptedException localInterruptedException)
      {
        as.c("sleep interrupted in AdvertiserDataPoller thread; continuing");
      }
    }
  }
  
  private void f()
  {
    if (this.g.currentTimeMillis() - this.e < this.b) {
      return;
    }
    c();
    this.e = this.g.currentTimeMillis();
  }
  
  public String a()
  {
    f();
    if (this.d == null) {
      return null;
    }
    return this.d.getId();
  }
  
  public boolean b()
  {
    f();
    if (this.d == null) {
      return true;
    }
    return this.d.isLimitAdTrackingEnabled();
  }
  
  void c()
  {
    this.h.interrupt();
  }
  
  void d()
  {
    this.h.start();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/tagmanager/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */