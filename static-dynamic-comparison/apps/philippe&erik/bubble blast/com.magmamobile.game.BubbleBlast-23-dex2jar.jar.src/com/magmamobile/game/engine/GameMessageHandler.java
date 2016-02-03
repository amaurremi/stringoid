package com.magmamobile.game.engine;

import android.os.Handler;
import android.os.Message;

public final class GameMessageHandler
  extends Handler
{
  public void handleMessage(Message paramMessage)
  {
    Game.handleMessage(paramMessage);
  }
  
  public void hideAds(AdLayout paramAdLayout)
  {
    sendMessage(obtainMessage(65538, 0, 0, paramAdLayout));
  }
  
  public void pushToast(String paramString)
  {
    sendMessage(obtainMessage(7, 0, 0, paramString));
  }
  
  public void showAds(AdLayout paramAdLayout)
  {
    sendMessage(obtainMessage(65537, 0, 0, paramAdLayout));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/engine/GameMessageHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */