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

public class ct
  extends en
  implements ServiceConnection
{
  private final Object lq = new Object();
  private Context mContext;
  private boolean oU = false;
  private dh oV;
  private cs oW;
  private cy oX;
  private List<cw> oY = null;
  private da oZ;
  
  public ct(Context paramContext, dh paramdh, da paramda)
  {
    this.mContext = paramContext;
    this.oV = paramdh;
    this.oZ = paramda;
    this.oW = new cs(paramContext);
    this.oX = cy.h(this.mContext);
    this.oY = this.oX.d(10L);
  }
  
  private void a(final cw paramcw, String paramString1, String paramString2)
  {
    final Intent localIntent = new Intent();
    localIntent.putExtra("RESPONSE_CODE", 0);
    localIntent.putExtra("INAPP_PURCHASE_DATA", paramString1);
    localIntent.putExtra("INAPP_DATA_SIGNATURE", paramString2);
    eu.ss.post(new Runnable()
    {
      public void run()
      {
        try
        {
          if (ct.a(ct.this).a(paramcw.pk, -1, localIntent))
          {
            ct.c(ct.this).a(new cx(ct.b(ct.this), paramcw.pl, true, -1, localIntent, paramcw));
            return;
          }
          ct.c(ct.this).a(new cx(ct.b(ct.this), paramcw.pl, false, -1, localIntent, paramcw));
          return;
        }
        catch (RemoteException localRemoteException)
        {
          ev.D("Fail to verify and dispatch pending transaction");
        }
      }
    });
  }
  
  private void b(long paramLong)
  {
    do
    {
      if (!c(paramLong)) {
        ev.D("Timeout waiting for pending transaction to be processed.");
      }
    } while (!this.oU);
  }
  
  private void bd()
  {
    if (this.oY.isEmpty()) {
      return;
    }
    HashMap localHashMap = new HashMap();
    Object localObject1 = this.oY.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (cw)((Iterator)localObject1).next();
      localHashMap.put(((cw)localObject2).pl, localObject2);
    }
    localObject1 = null;
    for (;;)
    {
      localObject1 = this.oW.b(this.mContext.getPackageName(), (String)localObject1);
      if (localObject1 == null) {}
      do
      {
        do
        {
          localObject1 = localHashMap.keySet().iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (String)((Iterator)localObject1).next();
            this.oX.a((cw)localHashMap.get(localObject2));
          }
          break;
        } while (cz.a((Bundle)localObject1) != 0);
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
            cw localcw = (cw)localHashMap.get(str1);
            String str4 = cz.p(str2);
            if (localcw.pk.equals(str4))
            {
              a(localcw, str2, str3);
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
      this.lq.wait(paramLong);
      return true;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        ev.D("waitWithTimeout_lock interrupted");
      }
    }
  }
  
  public void bc()
  {
    synchronized (this.lq)
    {
      Context localContext1 = this.mContext;
      Intent localIntent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
      Context localContext2 = this.mContext;
      localContext1.bindService(localIntent, this, 1);
      b(SystemClock.elapsedRealtime());
      this.mContext.unbindService(this);
      this.oW.destroy();
      return;
    }
  }
  
  public void onServiceConnected(ComponentName arg1, IBinder paramIBinder)
  {
    synchronized (this.lq)
    {
      this.oW.o(paramIBinder);
      bd();
      this.oU = true;
      this.lq.notify();
      return;
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    ev.B("In-app billing service disconnected.");
    this.oW.destroy();
  }
  
  public void onStop()
  {
    synchronized (this.lq)
    {
      this.mContext.unbindService(this);
      this.oW.destroy();
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/internal/ct.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */