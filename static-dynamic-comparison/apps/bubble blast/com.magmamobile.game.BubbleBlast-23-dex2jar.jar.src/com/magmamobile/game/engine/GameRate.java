package com.magmamobile.game.engine;

public enum GameRate
{
  private static final float[] FPS = { 0.0F, 62.5F, 30.30303F, 24.390244F, 12.5F, 4.1666665F };
  private static final int[] TIMES;
  
  static
  {
    faster = new GameRate("faster", 1);
    fast = new GameRate("fast", 2);
    normal = new GameRate("normal", 3);
    slow = new GameRate("slow", 4);
    slowest = new GameRate("slowest", 5);
    ENUM$VALUES = new GameRate[] { fastest, faster, fast, normal, slow, slowest };
    int[] arrayOfInt = new int[6];
    arrayOfInt[1] = 16;
    arrayOfInt[2] = 33;
    arrayOfInt[3] = 41;
    arrayOfInt[4] = 80;
    arrayOfInt[5] = 240;
    TIMES = arrayOfInt;
  }
  
  public final float getFps()
  {
    return FPS[ordinal()];
  }
  
  public final long getTime()
  {
    return TIMES[ordinal()];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/engine/GameRate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */