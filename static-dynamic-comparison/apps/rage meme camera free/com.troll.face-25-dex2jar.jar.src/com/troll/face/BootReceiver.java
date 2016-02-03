package com.troll.face;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.jtpgodorncrqoeurl.AdController;

public class BootReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    new AdController(paramContext, "409491362").loadReEngagement();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/rage meme camera free/com.troll.face-25-dex2jar.jar!/com/troll/face/BootReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */