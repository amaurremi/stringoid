package com.google.android.gms.internal;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender.SendIntentException;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;

public class cu
  extends dd.a
  implements ServiceConnection
{
  private dg oX;
  private cr oY;
  private final cx oZ;
  private final Activity og;
  private cz pb;
  private Context ph;
  private db pi;
  private cv pj;
  private String pk = null;
  
  public cu(Activity paramActivity)
  {
    this.og = paramActivity;
    this.oZ = cx.k(this.og.getApplicationContext());
  }
  
  public static void a(Context paramContext, boolean paramBoolean, cq paramcq)
  {
    Intent localIntent = new Intent();
    localIntent.setClassName(paramContext, "com.google.android.gms.ads.purchase.InAppPurchaseActivity");
    localIntent.putExtra("com.google.android.gms.ads.internal.purchase.useClientJar", paramBoolean);
    cq.a(localIntent, paramcq);
    paramContext.startActivity(localIntent);
  }
  
  private void a(String paramString, boolean paramBoolean, int paramInt, Intent paramIntent)
  {
    try
    {
      this.oX.a(new cw(this.ph, paramString, paramBoolean, paramInt, paramIntent, this.pj));
      return;
    }
    catch (RemoteException paramString)
    {
      eu.D("Fail to invoke PlayStorePurchaseListener.");
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 1001) {}
    for (;;)
    {
      try
      {
        paramInt1 = cy.c(paramIntent);
        if ((paramInt2 != -1) || (paramInt1 != 0)) {
          continue;
        }
        if (!this.pb.a(this.pk, paramInt2, paramIntent)) {
          continue;
        }
        a(this.pi.getProductId(), true, paramInt2, paramIntent);
      }
      catch (RemoteException paramIntent)
      {
        eu.D("Fail to process purchase result.");
        return;
        this.oZ.a(this.pj);
        a(this.pi.getProductId(), false, paramInt2, paramIntent);
        continue;
      }
      finally
      {
        this.pk = null;
        this.og.finish();
      }
      this.pi.recordPlayBillingResolution(paramInt1);
      this.pk = null;
      this.og.finish();
      return;
      a(this.pi.getProductId(), false, paramInt2, paramIntent);
    }
  }
  
  public void onCreate()
  {
    Object localObject = cq.b(this.og.getIntent());
    this.oX = ((cq)localObject).kX;
    this.pb = ((cq)localObject).kZ;
    this.pi = ((cq)localObject).oT;
    this.oY = new cr(this.og.getApplicationContext());
    this.ph = ((cq)localObject).oU;
    localObject = this.og;
    Intent localIntent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
    this.og.getApplicationContext();
    ((Activity)localObject).bindService(localIntent, this, 1);
  }
  
  public void onDestroy()
  {
    this.og.unbindService(this);
    this.oY.destroy();
  }
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    this.oY.o(paramIBinder);
    try
    {
      this.pk = this.pb.bm();
      paramComponentName = this.oY.a(this.og.getPackageName(), this.pi.getProductId(), this.pk);
      paramIBinder = (PendingIntent)paramComponentName.getParcelable("BUY_INTENT");
      if (paramIBinder == null)
      {
        int i = cy.a(paramComponentName);
        this.pi.recordPlayBillingResolution(i);
        a(this.pi.getProductId(), false, i, null);
        this.og.finish();
        return;
      }
      this.pj = new cv(this.pi.getProductId(), this.pk);
      this.oZ.b(this.pj);
      this.og.startIntentSenderForResult(paramIBinder.getIntentSender(), 1001, new Intent(), Integer.valueOf(0).intValue(), Integer.valueOf(0).intValue(), Integer.valueOf(0).intValue());
      return;
    }
    catch (RemoteException paramComponentName)
    {
      eu.c("Error when connecting in-app billing service", paramComponentName);
      this.og.finish();
      return;
    }
    catch (IntentSender.SendIntentException paramComponentName)
    {
      for (;;) {}
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    eu.B("In-app billing service disconnected.");
    this.oY.destroy();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/cu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */