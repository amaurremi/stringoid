package com.magmamobile.game.engine;

import android.content.Intent;
import android.net.Uri;

public abstract class MarketWrapper
{
  private boolean showBrowser(String paramString)
  {
    try
    {
      Game.getContext().startActivityForResult(new Intent("android.intent.action.VIEW", Uri.parse(paramString)), -1);
      return true;
    }
    catch (Exception paramString) {}
    return false;
  }
  
  public abstract String getCurrentGameUrl();
  
  public abstract String getGameUrl(String paramString);
  
  public abstract String getName();
  
  public abstract String getPublisherUrl();
  
  public boolean showCurrentGame()
  {
    return showCurrentGame(null);
  }
  
  public boolean showCurrentGame(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf(getCurrentGameUrl()));
    if (paramString != null) {}
    for (;;)
    {
      return showBrowser(paramString);
      paramString = "";
    }
  }
  
  public boolean showGame(String paramString)
  {
    return showGame(paramString, null);
  }
  
  public boolean showGame(String paramString1, String paramString2)
  {
    paramString1 = new StringBuilder(String.valueOf(getGameUrl(paramString1)));
    if (paramString2 != null) {}
    for (;;)
    {
      return showBrowser(paramString2);
      paramString2 = "";
    }
  }
  
  public boolean showPublisher()
  {
    return showPublisher(null);
  }
  
  public boolean showPublisher(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf(getPublisherUrl()));
    if (paramString != null) {}
    for (;;)
    {
      return showBrowser(paramString);
      paramString = "";
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/engine/MarketWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */