package com.vungle.publisher.net;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.vungle.publisher.br;
import com.vungle.publisher.log.Logger;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
class NetworkBroadcastReceiver
  extends BroadcastReceiver
{
  private static final IntentFilter d = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
  boolean a;
  @Inject
  Context b;
  @Inject
  br c;
  
  final void a(boolean paramBoolean)
  {
    if (this.a != paramBoolean)
    {
      if (!this.a) {
        break label36;
      }
      Logger.d("VungleNetwork", "Network listener disabled");
      this.b.unregisterReceiver(this);
    }
    for (;;)
    {
      this.a = paramBoolean;
      return;
      label36:
      Logger.d("VungleNetwork", "Network listener enabled");
      this.b.registerReceiver(this, d);
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (("android.net.conn.CONNECTIVITY_CHANGE".equals(paramIntent.getAction())) && (!paramIntent.getBooleanExtra("noConnectivity", false)) && (!paramIntent.getBooleanExtra("isFailover", false))) {
      Logger.d("VungleNetwork", "Network connectivity established");
    }
    try
    {
      a(false);
      notifyAll();
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/net/NetworkBroadcastReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */