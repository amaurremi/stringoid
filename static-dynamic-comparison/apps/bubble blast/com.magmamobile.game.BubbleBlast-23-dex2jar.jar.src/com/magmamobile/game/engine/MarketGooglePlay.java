package com.magmamobile.game.engine;

public final class MarketGooglePlay
  extends MarketWrapper
{
  public String getCurrentGameUrl()
  {
    return "market://details?id=" + Game.getPackageName();
  }
  
  public String getGameUrl(String paramString)
  {
    return "market://details?id=" + paramString;
  }
  
  public String getName()
  {
    return "Google Play";
  }
  
  public String getPublisherUrl()
  {
    return "market://search?q=pub:Magma%20Mobile";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/engine/MarketGooglePlay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */