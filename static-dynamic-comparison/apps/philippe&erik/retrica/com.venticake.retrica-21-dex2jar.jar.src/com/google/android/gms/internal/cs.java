package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class cs
  extends em
  implements ServiceConnection
{
  private final Object ls = new Object();
  private Context mContext;
  private boolean oW = false;
  private dg oX;
  private cr oY;
  private cx oZ;
  private List<cv> pa = null;
  private cz pb;
  
  public cs(Context paramContext, dg paramdg, cz paramcz)
  {
    this.mContext = paramContext;
    this.oX = paramdg;
    this.pb = paramcz;
    this.oY = new cr(paramContext);
    this.oZ = cx.k(this.mContext);
    this.pa = this.oZ.d(10L);
  }
  
  private void a(final cv paramcv, String paramString1, String paramString2)
  {
    final Intent localIntent = new Intent();
    localIntent.putExtra("RESPONSE_CODE", 0);
    localIntent.putExtra("INAPP_PURCHASE_DATA", paramString1);
    localIntent.putExtra("INAPP_DATA_SIGNATURE", paramString2);
    et.sv.post(new Runnable()
    {
      public void run()
      {
        try
        {
          if (cs.a(cs.this).a(paramcv.pm, -1, localIntent))
          {
            cs.c(cs.this).a(new cw(cs.b(cs.this), paramcv.pn, true, -1, localIntent, paramcv));
            return;
          }
          cs.c(cs.this).a(new cw(cs.b(cs.this), paramcv.pn, false, -1, localIntent, paramcv));
          return;
        }
        catch (RemoteException localRemoteException)
        {
          eu.D("Fail to verify and dispatch pending transaction");
        }
      }
    });
  }
  
  private void b(long paramLong)
  {
    do
    {
      if (!c(paramLong)) {
        eu.D("Timeout waiting for pending transaction to be processed.");
      }
    } while (!this.oW);
  }
  
  private void bi()
  {
    if (this.pa.isEmpty()) {
      return;
    }
    HashMap localHashMap = new HashMap();
    Object localObject1 = this.pa.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (cv)((Iterator)localObject1).next();
      localHashMap.put(((cv)localObject2).pn, localObject2);
    }
    localObject1 = null;
    for (;;)
    {
      localObject1 = this.oY.b(this.mContext.getPackageName(), (String)localObject1);
      if (localObject1 == null) {}
      do
      {
        do
        {
          localObject1 = localHashMap.keySet().iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (String)((Iterator)localObject1).next();
            this.oZ.a((cv)localHashMap.get(localObject2));
          }
          break;
        } while (cy.a((Bundle)localObject1) != 0);
        localObject2 = ((Bundle)localObject1).getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
        ArrayList localArrayList1 = ((Bundle)localObject1).getStringArrayList("INAPP_PURCHASE_DATA_LIST");
        ArrayList localArrayList2 = ((Bundle)localObject1).getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
        localObject1 = ((Bundle)localObject1).getString("INAPP_CONTINUATION_TOKEN");
        int i = 0;
        while (i < ((ArrayList)localObject2).size())
        {
          if (localHashMap.containsKey(((ArrayList)localObject2).get(i)))
          {
            String str1 = (String)((ArrayList)localObject2).get(i);
            String str2 = (String)localArrayList1.get(i);
            String str3 = (String)localArrayList2.get(i);
            cv localcv = (cv)localHashMap.get(str1);
            String str4 = cy.p(str2);
            if (localcv.pm.equals(str4))
            {
              a(localcv, str2, str3);
              localHashMap.remove(str1);
            }
          }
          i += 1;
        }
      } while ((localObject1 == null) || (localHashMap.isEmpty()));
    }
  }
  
  private boolean c(long paramLong)
  {
    paramLong = 60000L - (SystemClock.elapsedRealtime() - paramLong);
    if (paramLong <= 0L) {
      return false;
    }
    try
    {
      this.ls.wait(paramLong);
      return true;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        eu.D("waitWithTimeout_lock interrupted");
      }
    }
  }
  
  public void bh()
  {
    synchronized (this.ls)
    {
      Context localContext1 = this.mContext;
      Intent localIntent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
      Context localContext2 = this.mContext;
      localContext1.bindService(localIntent, this, 1);
      b(SystemClock.elapsedRealtime());
      this.mContext.unbindService(this);
      this.oY.destroy();
      return;
    }
  }
  
  public void onServiceConnected(ComponentName arg1, IBinder paramIBinder)
  {
    synchronized (this.ls)
    {
      this.oY.o(paramIBinder);
      bi();
      this.oW = true;
      this.ls.notify();
      return;
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    eu.B("In-app billing service disconnected.");
    this.oY.destroy();
  }
  
  public void onStop()
  {
    synchronized (this.ls)
    {
      this.mContext.unbindService(this);
      this.oY.destroy();
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/cs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */