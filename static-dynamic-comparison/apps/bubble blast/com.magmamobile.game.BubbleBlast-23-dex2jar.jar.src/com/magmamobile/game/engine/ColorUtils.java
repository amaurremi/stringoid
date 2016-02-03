package com.magmamobile.game.engine;

public final class ColorUtils
{
  public static int getRandom()
  {
    return rgb(MathUtils.randomi(255), MathUtils.randomi(255), MathUtils.randomi(255));
  }
  
  public static int lerp(int paramInt1, int paramInt2, float paramFloat)
  {
    if (paramFloat <= 0.0F) {
      return paramInt1;
    }
    if (paramFloat >= 1.0F) {
      return paramInt2;
    }
    int i = paramInt1 & 0xFF;
    int j = paramInt1 >> 8 & 0xFF;
    int k = paramInt1 >> 16 & 0xFF;
    paramInt1 = paramInt1 >> 24 & 0xFF;
    return (int)(i + ((paramInt2 & 0xFF) - i) * paramFloat) & 0xFF | ((int)(j + ((paramInt2 >> 8 & 0xFF) - j) * paramFloat) & 0xFF) << 8 | ((int)(k + ((paramInt2 >> 16 & 0xFF) - k) * paramFloat) & 0xFF) << 16 | ((int)(paramInt1 + ((paramInt2 >> 24 & 0xFF) - paramInt1) * paramFloat) & 0xFF) << 24;
  }
  
  public static int rgb(int paramInt1, int paramInt2, int paramInt3)
  {
    return paramInt1 & 0xFF | (paramInt2 & 0xFF) << 8 | (paramInt3 & 0xFF) << 16 | 0xFF000000;
  }
  
  public static int rgba(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return paramInt1 & 0xFF | (paramInt2 & 0xFF) << 8 | (paramInt3 & 0xFF) << 16 | (paramInt4 & 0xFF) << 24;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/engine/ColorUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */