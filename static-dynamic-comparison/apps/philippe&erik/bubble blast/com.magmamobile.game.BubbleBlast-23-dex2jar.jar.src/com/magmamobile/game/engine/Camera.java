package com.magmamobile.game.engine;

public final class Camera
{
  public static boolean d;
  public static int maxX;
  public static int maxY;
  public static int tgx;
  public static int tgy;
  public static boolean tsf;
  public static float tsp;
  public static int tsx;
  public static int tsy;
  public static int tx;
  public static int ty;
  public static int x;
  public static int y;
  
  public static void anim()
  {
    if (!tsf) {
      return;
    }
    tsp = (float)(tsp + 0.1D);
    if (tsp >= 1.0F) {
      tsf = false;
    }
    x = (int)MathUtils.lerpDecelerate(tsx, tgx, tsp);
    y = (int)MathUtils.lerpDecelerate(tsy, tgy, tsp);
  }
  
  public static void follow()
  {
    x += tx - TouchScreen.x;
    y += ty - TouchScreen.y;
    tx = TouchScreen.x;
    ty = TouchScreen.y;
    tsf = false;
  }
  
  public static void follow(int paramInt1, int paramInt2)
  {
    tsf = false;
    x = paramInt1 - Game.mBufferCW;
    y = paramInt2 - Game.mBufferCH;
    if (x < 0) {
      x = 0;
    }
    if (y < 0) {
      y = 0;
    }
    paramInt1 = maxX - Game.mBufferCW;
    if (x > paramInt1) {
      x = paramInt1;
    }
    paramInt1 = maxY - Game.mBufferCH;
    if (y > paramInt1) {
      y = paramInt1;
    }
  }
  
  public static void follow(GameObject paramGameObject)
  {
    tsf = false;
    x = (int)paramGameObject.x - Game.mBufferCW;
    y = (int)paramGameObject.y - Game.mBufferCH;
    if (x < 0) {
      x = 0;
    }
    if (y < 0) {
      y = 0;
    }
    int i = maxX - Game.mBufferCW;
    if (x > i) {
      x = i;
    }
    i = maxY - Game.mBufferCH;
    if (y > i) {
      y = i;
    }
  }
  
  public static void followNoLimit(int paramInt1, int paramInt2)
  {
    x = paramInt1 - Game.mBufferCW;
    y = paramInt2 - Game.mBufferCH;
    tsf = false;
  }
  
  public static void setTarget(int paramInt1, int paramInt2)
  {
    tgx = paramInt1 - Game.mBufferCW;
    tgy = paramInt2 - Game.mBufferCH;
    tsx = x;
    tsy = y;
    tsp = 0.0F;
    tsf = true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/engine/Camera.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */