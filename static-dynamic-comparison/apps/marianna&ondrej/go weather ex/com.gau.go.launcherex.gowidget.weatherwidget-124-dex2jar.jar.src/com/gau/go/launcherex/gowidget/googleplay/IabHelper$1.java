package com.gau.go.launcherex.gowidget.googleplay;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.android.vending.billing.IInAppBillingService;
import com.android.vending.billing.IInAppBillingService.Stub;

class IabHelper$1
  implements ServiceConnection
{
  IabHelper$1(IabHelper paramIabHelper, IabHelper.OnIabSetupFinishedListener paramOnIabSetupFinishedListener) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    if (this.this$0.mDisposed) {
      return;
    }
    this.this$0.logDebug("Billing service connected.");
    this.this$0.mService = IInAppBillingService.Stub.asInterface(paramIBinder);
    paramComponentName = this.this$0.mContext.getPackageName();
    try
    {
      this.this$0.logDebug("Checking for in-app billing 3 support.");
      i = this.this$0.mService.isBillingSupported(3, paramComponentName, "inapp");
      if (i != 0)
      {
        if (this.val$listener != null) {
          this.val$listener.onIabSetupFinished(new IabResult(i, "Error checking for billing v3 support."));
        }
        this.this$0.mSubscriptionsSupported = false;
        return;
      }
    }
    catch (RemoteException paramComponentName)
    {
      if (this.val$listener != null) {
        this.val$listener.onIabSetupFinished(new IabResult(64535, "RemoteException while setting up in-app billing."));
      }
      paramComponentName.printStackTrace();
      return;
    }
    this.this$0.logDebug("In-app billing version 3 supported for " + paramComponentName);
    int i = this.this$0.mService.isBillingSupported(3, paramComponentName, "subs");
    if (i == 0)
    {
      this.this$0.logDebug("Subscriptions AVAILABLE.");
      this.this$0.mSubscriptionsSupported = true;
    }
    for (;;)
    {
      this.this$0.mSetupDone = true;
      if (this.val$listener == null) {
        break;
      }
      this.val$listener.onIabSetupFinished(new IabResult(0, "Setup successful."));
      return;
      this.this$0.logDebug("Subscriptions NOT AVAILABLE. Response: " + i);
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    this.this$0.logDebug("Billing service disconnected.");
    this.this$0.mService = null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/googleplay/IabHelper$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */