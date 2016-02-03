package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;

public final class cx
  extends dg.a
  implements ServiceConnection
{
  private Context mContext;
  private cs oW;
  private String pd;
  private cw ph;
  private boolean pm = false;
  private int pn;
  private Intent po;
  
  public cx(Context paramContext, String paramString, boolean paramBoolean, int paramInt, Intent paramIntent, cw paramcw)
  {
    this.pd = paramString;
    this.pn = paramInt;
    this.po = paramIntent;
    this.pm = paramBoolean;
    this.mContext = paramContext;
    this.ph = paramcw;
  }
  
  public void finishPurchase()
  {
    int i = cz.c(this.po);
    if ((this.pn != -1) || (i != 0)) {
      return;
    }
    this.oW = new cs(this.mContext);
    Context localContext1 = this.mContext;
    Intent localIntent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
    Context localContext2 = this.mContext;
    localContext1.bindService(localIntent, this, 1);
  }
  
  public String getProductId()
  {
    return this.pd;
  }
  
  public Intent getPurchaseData()
  {
    return this.po;
  }
  
  public int getResultCode()
  {
    return this.pn;
  }
  
  public boolean isVerified()
  {
    return this.pm;
  }
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    ev.B("In-app billing service connected.");
    this.oW.o(paramIBinder);
    paramComponentName = cz.q(cz.d(this.po));
    if (paramComponentName == null) {
      return;
    }
    if (this.oW.a(this.mContext.getPackageName(), paramComponentName) == 0) {
      cy.h(this.mContext).a(this.ph);
    }
    this.mContext.unbindService(this);
    this.oW.destroy();
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    ev.B("In-app billing service disconnected.");
    this.oW.destroy();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/internal/cx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */