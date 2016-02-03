package com.google.analytics.tracking.android;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.android.gms.common.util.VisibleForTesting;

class GANetworkReceiver
  extends BroadcastReceiver
{
  @VisibleForTesting
  static final String SELF_IDENTIFYING_EXTRA = GANetworkReceiver.class.getName();
  private final ServiceManager mManager;
  
  GANetworkReceiver(ServiceManager paramServiceManager)
  {
    this.mManager = paramServiceManager;
  }
  
  public static void sendRadioPoweredBroadcast(Context paramContext)
  {
    Intent localIntent = new Intent("com.google.analytics.RADIO_POWERED");
    localIntent.addCategory(paramContext.getPackageName());
    localIntent.putExtra(SELF_IDENTIFYING_EXTRA, true);
    paramContext.sendBroadcast(localIntent);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    boolean bool1 = false;
    paramContext = paramIntent.getAction();
    if ("android.net.conn.CONNECTIVITY_CHANGE".equals(paramContext))
    {
      bool2 = paramIntent.getBooleanExtra("noConnectivity", false);
      paramContext = this.mManager;
      if (!bool2) {
        bool1 = true;
      }
      paramContext.updateConnectivityStatus(bool1);
    }
    while ((!"com.google.analytics.RADIO_POWERED".equals(paramContext)) || (paramIntent.hasExtra(SELF_IDENTIFYING_EXTRA)))
    {
      boolean bool2;
      return;
    }
    this.mManager.onRadioPowered();
  }
  
  public void register(Context paramContext)
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    paramContext.registerReceiver(this, localIntentFilter);
    localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.google.analytics.RADIO_POWERED");
    localIntentFilter.addCategory(paramContext.getPackageName());
    paramContext.registerReceiver(this, localIntentFilter);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/analytics/tracking/android/GANetworkReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */