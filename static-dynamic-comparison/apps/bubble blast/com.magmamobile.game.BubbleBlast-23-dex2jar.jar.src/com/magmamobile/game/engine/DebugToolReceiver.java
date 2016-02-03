package com.magmamobile.game.engine;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

final class DebugToolReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (Game.application == null) {}
    while (paramIntent == null) {
      return;
    }
    Game.application.onReceiveDebugMessage(paramIntent);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/engine/DebugToolReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */