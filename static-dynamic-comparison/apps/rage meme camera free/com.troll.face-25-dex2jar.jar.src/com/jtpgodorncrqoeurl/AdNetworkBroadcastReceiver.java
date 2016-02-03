package com.jtpgodorncrqoeurl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class AdNetworkBroadcastReceiver
  extends BroadcastReceiver
{
  private AdNetworkController a;
  
  public AdNetworkBroadcastReceiver(AdNetworkController paramAdNetworkController)
  {
    this.a = paramAdNetworkController;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
      this.a.onConnectionChanged();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/rage meme camera free/com.troll.face-25-dex2jar.jar!/com/jtpgodorncrqoeurl/AdNetworkBroadcastReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */