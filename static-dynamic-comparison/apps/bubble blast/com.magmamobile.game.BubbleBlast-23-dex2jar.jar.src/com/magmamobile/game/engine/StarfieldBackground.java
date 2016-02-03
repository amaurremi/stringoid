package com.magmamobile.game.engine;

import android.graphics.Paint;

public final class StarfieldBackground
{
  private static final int c = 8;
  private static int height;
  private static int numstars;
  private static Paint paint;
  private static int[] starx;
  private static int[] stary;
  private static int[] starz;
  private static int width;
  
  public static void onAction() {}
  
  public static void onInitialize(int paramInt)
  {
    numstars = paramInt;
    width = Game.mBufferWidth;
    height = Game.mBufferHeight;
    paint = new Paint();
    paint.setColor(-16777216);
    stary = new int[numstars];
    starx = new int[numstars];
    starz = new int[numstars];
    paramInt = 0;
    for (;;)
    {
      if (paramInt >= numstars) {
        return;
      }
      starx[paramInt] = ((int)(Math.random() * width - Game.mBufferCW) * 8);
      stary[paramInt] = ((int)(Math.random() * height - Game.mBufferCH) * 8);
      starz[paramInt] = (paramInt + 2);
      paramInt += 1;
    }
  }
  
  public static void onRender()
  {
    paint.setColor(-1);
    int i = 0;
    if (i >= numstars) {
      return;
    }
    int j = starx[i] / starz[i];
    int k = Game.mBufferCW;
    int m = stary[i] / starz[i];
    int n = Game.mBufferCH;
    int[] arrayOfInt = starz;
    arrayOfInt[i] -= 1;
    int i1 = starx[i] / starz[i] + Game.mBufferCW;
    int i2 = stary[i] / starz[i] + Game.mBufferCH;
    if ((i1 < 0) || (i1 > Game.mBufferWidth) || (i2 < 0) || (i2 > Game.mBufferHeight) || (starz[i] < 2))
    {
      starx[i] = ((int)(Math.random() * width - Game.mBufferCW) * 8);
      stary[i] = ((int)(Math.random() * height - Game.mBufferCH) * 8);
      starz[i] = 66;
    }
    for (;;)
    {
      i += 1;
      break;
      int i3 = 255 - starz[i] * 3;
      paint.setColor(0xFF000000 | i3 | i3 << 8 | i3 << 16);
      Game.drawLine(j + k, m + n, i1, i2, paint);
    }
  }
  
  public static void onTerminate()
  {
    paint = null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/engine/StarfieldBackground.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */