package com.magmamobile.game.engine;

public final class Flash
{
  private static int alpha;
  private static float factor;
  private static boolean visible;
  
  public static void flash()
  {
    visible = true;
    alpha = 255;
    factor = 0.0F;
  }
  
  public static void onAction()
  {
    if (!visible) {}
    do
    {
      return;
      alpha = (int)MathUtils.lerpDecelerate(255.0F, 0.0F, factor);
      factor += 0.1F;
    } while (factor <= 1.0F);
    visible = false;
  }
  
  public static void onRender()
  {
    if (!visible) {
      return;
    }
    Game.drawColor(alpha << 24 | 0xFFFFFF);
  }
  
  public static void reset()
  {
    visible = false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/engine/Flash.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */