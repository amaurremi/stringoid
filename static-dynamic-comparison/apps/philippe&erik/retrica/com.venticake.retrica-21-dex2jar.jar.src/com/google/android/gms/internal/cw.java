package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;

public final class cw
  extends df.a
  implements ServiceConnection
{
  private Context mContext;
  private cr oY;
  private String pf;
  private cv pj;
  private boolean po = false;
  private int pp;
  private Intent pq;
  
  public cw(Context paramContext, String paramString, boolean paramBoolean, int paramInt, Intent paramIntent, cv paramcv)
  {
    this.pf = paramString;
    this.pp = paramInt;
    this.pq = paramIntent;
    this.po = paramBoolean;
    this.mContext = paramContext;
    this.pj = paramcv;
  }
  
  public void finishPurchase()
  {
    int i = cy.c(this.pq);
    if ((this.pp != -1) || (i != 0)) {
      return;
    }
    this.oY = new cr(this.mContext);
    Context localContext1 = this.mContext;
    Intent localIntent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
    Context localContext2 = this.mContext;
    localContext1.bindService(localIntent, this, 1);
  }
  
  public String getProductId()
  {
    return this.pf;
  }
  
  public Intent getPurchaseData()
  {
    return this.pq;
  }
  
  public int getResultCode()
  {
    return this.pp;
  }
  
  public boolean isVerified()
  {
    return this.po;
  }
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    eu.B("In-app billing service connected.");
    this.oY.o(paramIBinder);
    paramComponentName = cy.q(cy.d(this.pq));
    if (paramComponentName == null) {
      return;
    }
    if (this.oY.a(this.mContext.getPackageName(), paramComponentName) == 0) {
      cx.k(this.mContext).a(this.pj);
    }
    this.mContext.unbindService(this);
    this.oY.destroy();
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    eu.B("In-app billing service disconnected.");
    this.oY.destroy();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/cw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */