package com.magmamobile.game.engine;

import android.graphics.Paint;

public final class SolidBackground
{
  private static Paint _pn;
  
  public static int getColor()
  {
    return _pn.getColor();
  }
  
  public static void onAction() {}
  
  public static void onInitialize(int paramInt)
  {
    _pn = new Paint();
    _pn.setColor(paramInt);
  }
  
  public static void onRender()
  {
    Game.drawPaint(_pn);
  }
  
  public static void onTerminate()
  {
    _pn = null;
  }
  
  public static void setColor(int paramInt)
  {
    _pn.setColor(paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/engine/SolidBackground.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */