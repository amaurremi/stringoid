package com.magmamobile.game.engine;

public class MarketAmazon
  extends MarketWrapper
{
  public String getCurrentGameUrl()
  {
    return "http://www.amazon.com/gp/mas/dl/android?p=" + Game.getPackageName();
  }
  
  public String getGameUrl(String paramString)
  {
    return "http://www.amazon.com/gp/mas/dl/android?p=" + paramString;
  }
  
  public String getName()
  {
    return "Amazon";
  }
  
  public String getPublisherUrl()
  {
    return "http://www.amazon.com/gp/mas/dl/android?showAll=1&p=" + Game.getPackageName();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/engine/MarketAmazon.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */