package com.jtpgodorncrqoeurl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class AdConfigurationBroadcastReceiver
  extends BroadcastReceiver
{
  private AdDisplayController a;
  private int b;
  
  public AdConfigurationBroadcastReceiver(AdDisplayController paramAdDisplayController)
  {
    this.a = paramAdDisplayController;
    this.b = this.a.getOrientation();
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getAction().equals("android.intent.action.CONFIGURATION_CHANGED"))
    {
      int i = this.a.getOrientation();
      if (i != this.b)
      {
        this.b = i;
        this.a.onOrientationChanged(this.b);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/rage meme camera free/com.troll.face-25-dex2jar.jar!/com/jtpgodorncrqoeurl/AdConfigurationBroadcastReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */