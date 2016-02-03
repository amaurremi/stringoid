package com.inmobi.commons.analytics.net;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

public class AnalyticsConnectivityReceiver
  extends BroadcastReceiver
{
  private a a;
  private boolean b;
  
  public AnalyticsConnectivityReceiver(Context paramContext, a parama)
  {
    this.a = parama;
    bind(paramContext);
  }
  
  public final void bind(Context paramContext)
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    paramContext.registerReceiver(this, localIntentFilter);
  }
  
  public boolean isConnected()
  {
    return this.b;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getBooleanExtra("noConnectivity", false))
    {
      this.b = false;
      if (this.a != null) {
        this.a.a();
      }
    }
    do
    {
      do
      {
        return;
      } while (paramIntent.getBooleanExtra("noConnectivity", false));
      this.b = true;
    } while (this.a == null);
    this.a.b();
  }
  
  public void unbind(Context paramContext)
  {
    paramContext.unregisterReceiver(this);
  }
  
  static abstract interface a
  {
    public abstract void a();
    
    public abstract void b();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/inmobi/commons/analytics/net/AnalyticsConnectivityReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */