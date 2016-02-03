package com.tapjoy.mraid.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tapjoy.mraid.controller.Network;

public class NetworkBroadcastReceiver
  extends BroadcastReceiver
{
  private Network mMraidNetwork;
  
  public NetworkBroadcastReceiver(Network paramNetwork)
  {
    this.mMraidNetwork = paramNetwork;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
      this.mMraidNetwork.onConnectionChanged();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/tapjoy/mraid/util/NetworkBroadcastReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */