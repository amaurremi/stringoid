package com.magmamobile.game.engine;

import android.graphics.Bitmap;

public final class TiledBackground
{
  private static Bitmap b;
  private static int h;
  private static int i;
  private static int j;
  private static int p;
  private static int q;
  private static int w;
  private static int x;
  private static int y;
  
  public static final void onAction()
  {
    x = (x + 1) % w;
    y = (y + 1) % h;
  }
  
  public static final void onInitialize(int paramInt)
  {
    b = Game.getBitmap(paramInt);
    w = b.getWidth();
    h = b.getHeight();
    q = Game.mBufferWidth + w;
    p = Game.mBufferHeight + h;
    x = 0;
    y = 0;
  }
  
  public static final void onRender()
  {
    i = 0;
    if (i >= q) {
      return;
    }
    for (j = 0;; j += h)
    {
      if (j >= p)
      {
        i += w;
        break;
      }
      Game.drawBitmap(b, i - x, j - y);
    }
  }
  
  public static final void onTerminate()
  {
    b = null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/engine/TiledBackground.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */