package com.google.android.gms.internal;

import android.content.Context;
import android.os.Handler;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import com.atomic.apps.ringtone.cutter.aa;

public final class ac
  implements af
{
  private final String a;
  private final ai b;
  private final long c;
  private final Y d;
  private final ah e;
  private final ak f;
  private final Context g;
  private final Object h = new Object();
  private final dx i;
  private am j;
  private int k = -2;
  
  public ac(Context paramContext, String paramString, ai paramai, Z paramZ, Y paramY, ah paramah, ak paramak, dx paramdx)
  {
    this.g = paramContext;
    this.a = paramString;
    this.b = paramai;
    if (paramZ.b != -1L) {}
    for (long l = paramZ.b;; l = 10000L)
    {
      this.c = l;
      this.d = paramY;
      this.e = paramah;
      this.f = paramak;
      this.i = paramdx;
      return;
    }
  }
  
  private void a(long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    long l = SystemClock.elapsedRealtime();
    paramLong1 = paramLong2 - (l - paramLong1);
    paramLong2 = paramLong4 - (l - paramLong3);
    if ((paramLong1 <= 0L) || (paramLong2 <= 0L))
    {
      aa.c("Timed out waiting for adapter.");
      this.k = 3;
      return;
    }
    try
    {
      this.h.wait(Math.min(paramLong1, paramLong2));
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      this.k = -1;
    }
  }
  
  private am b()
  {
    aa.c("Instantiating mediation adapter: " + this.a);
    try
    {
      am localam = this.b.a(this.a);
      return localam;
    }
    catch (RemoteException localRemoteException)
    {
      String str = "Could not instantiate mediation adapter: " + this.a;
      if (aa.a(3)) {
        Log.d("Ads", str, localRemoteException);
      }
    }
    return null;
  }
  
  public final ae a(long paramLong1, long paramLong2)
  {
    synchronized (this.h)
    {
      long l1 = SystemClock.elapsedRealtime();
      ab localab1 = new ab();
      bU.a.post(new ad(this, localab1));
      long l2 = this.c;
      if (this.k == -2) {
        a(l1, l2, paramLong1, paramLong2);
      }
    }
    ae localae = new ae(this.d, this.j, this.a, localab2, this.k);
    return localae;
  }
  
  public final void a()
  {
    synchronized (this.h)
    {
      try
      {
        if (this.j != null) {
          this.j.c();
        }
        this.k = -1;
        this.h.notify();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        for (;;)
        {
          aa.b("Could not destroy mediation adapter.", localRemoteException);
        }
      }
    }
  }
  
  public final void a(int paramInt)
  {
    synchronized (this.h)
    {
      this.k = paramInt;
      this.h.notify();
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/mp3 cutter/com.atomic.apps.ringtone.cutter-100007-dex2jar.jar!/com/google/android/gms/internal/ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */