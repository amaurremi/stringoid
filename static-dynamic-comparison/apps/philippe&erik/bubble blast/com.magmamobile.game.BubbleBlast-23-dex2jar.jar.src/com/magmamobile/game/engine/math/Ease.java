package com.magmamobile.game.engine.math;

public final class Ease
{
  public static final float OutElastic(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    if (paramFloat1 == 0.0F) {
      return paramFloat2;
    }
    float f = paramFloat1 / paramFloat4;
    if (f == 1.0F) {
      return paramFloat2 + paramFloat3;
    }
    paramFloat1 = paramFloat6;
    if (paramFloat6 == 0.0F) {
      paramFloat1 = paramFloat4 * 0.3F;
    }
    if (paramFloat5 < Math.abs(paramFloat3)) {
      paramFloat5 = paramFloat3;
    }
    for (paramFloat6 = paramFloat1 / 4.0F;; paramFloat6 = (float)(paramFloat1 / 6.283185307179586D * Math.asin(paramFloat3 / paramFloat5))) {
      return (float)(paramFloat5 * Math.pow(2.0D, -10.0F * f) * Math.sin((f * paramFloat4 - paramFloat6) * 6.283185307179586D / paramFloat1) + paramFloat3 + paramFloat2);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/engine/math/Ease.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */