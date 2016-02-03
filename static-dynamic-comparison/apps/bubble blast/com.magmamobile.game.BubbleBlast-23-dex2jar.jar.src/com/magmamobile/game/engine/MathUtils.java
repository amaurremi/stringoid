package com.magmamobile.game.engine;

public final class MathUtils
{
  public static final float DEGREE = 57.29578F;
  public static final float EPSILON = 1.0E-4F;
  public static final float PI = 3.1415927F;
  public static final float RADIAN = 0.017453292F;
  
  public static final boolean BoxInBox(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    return (paramInt1 >= paramInt5) && (paramInt2 >= paramInt6) && (paramInt3 <= paramInt7) && (paramInt4 <= paramInt8);
  }
  
  public static final boolean BoxIntersect(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    return (paramInt1 < paramInt7) && (paramInt5 < paramInt3) && (paramInt2 < paramInt8) && (paramInt6 < paramInt4);
  }
  
  public static final int Int(float paramFloat)
  {
    int i = (int)paramFloat;
    if (paramFloat >= 0.0F) {}
    while (paramFloat - i == 0.0F) {
      return i;
    }
    return i - 1;
  }
  
  public static final boolean PtInRect(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    return (paramInt5 >= paramInt1) && (paramInt5 <= paramInt3) && (paramInt6 >= paramInt2) && (paramInt6 <= paramInt4);
  }
  
  public static final boolean RectIntersect(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    if (PtInRect(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6)) {
      return true;
    }
    if (PtInRect(paramInt1, paramInt2, paramInt3, paramInt4, paramInt7, paramInt8)) {
      return true;
    }
    return (SegmentInRect(paramInt1, paramInt2, paramInt3, paramInt2, paramInt5, paramInt6, paramInt7, paramInt8)) || (SegmentInRect(paramInt1, paramInt2, paramInt1, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8)) || (SegmentInRect(paramInt3, paramInt2, paramInt3, paramInt2, paramInt5, paramInt6, paramInt7, paramInt8)) || (SegmentInRect(paramInt3, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8));
  }
  
  public static final boolean SegmentInRect(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    paramInt3 -= paramInt1;
    paramInt4 -= paramInt2;
    paramInt7 -= paramInt5;
    paramInt8 -= paramInt6;
    if (paramInt7 * paramInt4 - paramInt8 * paramInt3 != 0)
    {
      float f1 = ((paramInt6 - paramInt2) * paramInt3 + (paramInt1 - paramInt5) * paramInt4) / (paramInt7 * paramInt4 - paramInt8 * paramInt3);
      float f2 = ((paramInt2 - paramInt6) * paramInt7 + (paramInt5 - paramInt1) * paramInt8) / (paramInt8 * paramInt3 - paramInt7 * paramInt4);
      return (f1 >= 0.0F) && (f1 <= 1.0F) && (f2 >= 0.0F) && (f2 <= 1.0F);
    }
    return false;
  }
  
  public static final float absf(float paramFloat)
  {
    float f;
    if (paramFloat == 0.0F) {
      f = 0.0F;
    }
    do
    {
      return f;
      f = paramFloat;
    } while (paramFloat > 0.0F);
    return -paramFloat;
  }
  
  public static final int absi(int paramInt)
  {
    int i;
    if (paramInt == 0) {
      i = 0;
    }
    do
    {
      return i;
      i = paramInt;
    } while (paramInt > 0);
    return -paramInt;
  }
  
  public static final int argb(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    return (int)(paramFloat1 * 255.0F) << 24 | (int)(paramFloat2 * 255.0F) << 16 | (int)(paramFloat3 * 255.0F) << 8 | (int)(paramFloat4 * 255.0F);
  }
  
  public static final int argb(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return (paramInt1 & 0xFF) << 24 | (paramInt2 & 0xFF) << 16 | (paramInt3 & 0xFF) << 8 | paramInt4 & 0xFF;
  }
  
  public static final float getAccelerateInterpolation(float paramFloat1, float paramFloat2)
  {
    if (paramFloat2 == 1.0F) {
      return paramFloat1 * paramFloat1;
    }
    return (float)Math.pow(paramFloat1, 2.0F * paramFloat2);
  }
  
  public static final float getAngle(float paramFloat1, float paramFloat2)
  {
    if (paramFloat1 > 1.0E-4F) {
      return (float)Math.atan(paramFloat2 / paramFloat1);
    }
    if (paramFloat1 < -1.0E-4F) {
      return (float)(3.1415927410125732D - Math.atan(-paramFloat2 / paramFloat1));
    }
    return Math.signum(paramFloat2) * 3.1415927F / 2.0F;
  }
  
  public static final float getAnticipateInterpolation(float paramFloat1, float paramFloat2)
  {
    return paramFloat1 * paramFloat1 * ((1.0F + paramFloat2) * paramFloat1 - paramFloat2);
  }
  
  public static final float getBackAndForthInterpolation(float paramFloat)
  {
    if (paramFloat < 0.5F) {
      return paramFloat + paramFloat;
    }
    return 2.0F - paramFloat - paramFloat;
  }
  
  public static final float getCycleInterpolation(float paramFloat1, float paramFloat2)
  {
    return (float)Math.abs(Math.sin(paramFloat2 * 3.141592653589793D * paramFloat1));
  }
  
  public static final float getDecelerateInterpolation(float paramFloat1, float paramFloat2)
  {
    if (paramFloat2 == 1.0F) {
      return 1.0F - (1.0F - paramFloat1) * (1.0F - paramFloat1);
    }
    return (float)(1.0D - Math.pow(1.0F - paramFloat1, 2.0F * paramFloat2));
  }
  
  public static final int getDirection(int paramInt1, int paramInt2)
  {
    if ((paramInt2 < 0) && (paramInt1 == 0)) {
      return 0;
    }
    if ((paramInt1 > 0) && (paramInt2 == 0)) {
      return 1;
    }
    if ((paramInt2 > 0) && (paramInt1 == 0)) {
      return 2;
    }
    if ((paramInt1 < 0) && (paramInt2 == 0)) {
      return 3;
    }
    return -1;
  }
  
  public static final float getFactor(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    paramFloat3 -= paramFloat2;
    if (paramFloat3 == 0.0F) {
      return 0.0F;
    }
    return (paramFloat1 - paramFloat2) / paramFloat3;
  }
  
  public static final float getOvershootInterpolation(float paramFloat1, float paramFloat2)
  {
    paramFloat1 -= 1.0F;
    return paramFloat1 * paramFloat1 * ((paramFloat2 + 1.0F) * paramFloat1 + paramFloat2) + 1.0F;
  }
  
  public static final float getShakeInterpolation(float paramFloat1, float paramFloat2)
  {
    float f1 = 0.5F;
    float f2 = paramFloat2 / 4.0F;
    float f3 = 2.0F / paramFloat2;
    if (paramFloat1 < paramFloat2)
    {
      if (paramFloat1 < f2) {
        f1 = 0.5F + paramFloat1 * f3;
      }
    }
    else {
      return f1;
    }
    if (paramFloat1 < 3.0F * f2) {
      return 1.5F - paramFloat1 * f3;
    }
    return paramFloat1 * f3 - 1.5F;
  }
  
  public static final float length(float paramFloat1, float paramFloat2)
  {
    return (float)Math.sqrt(paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2);
  }
  
  public static final float lerpAccelerate(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return (paramFloat2 - paramFloat1) * getAccelerateInterpolation(paramFloat3, 1.0F) + paramFloat1;
  }
  
  public static final float lerpAnim(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return paramInt1 + (paramInt2 - paramInt1) * getDecelerateInterpolation(paramInt3 / paramInt4, 1.0F);
  }
  
  public static final float lerpAnticipate(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return (paramFloat2 - paramFloat1) * getAnticipateInterpolation(paramFloat3, 2.0F) + paramFloat1;
  }
  
  public static final float lerpBackAndForth(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return (paramFloat2 - paramFloat1) * getBackAndForthInterpolation(paramFloat3) + paramFloat1;
  }
  
  public static final float lerpCycle(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    return (paramFloat2 - paramFloat1) * getCycleInterpolation(paramFloat3, paramFloat4) + paramFloat1;
  }
  
  public static final float lerpDecelerate(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return (paramFloat2 - paramFloat1) * getDecelerateInterpolation(paramFloat3, 1.0F) + paramFloat1;
  }
  
  public static final float lerpLinear(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return (paramFloat2 - paramFloat1) * paramFloat3 + paramFloat1;
  }
  
  public static final float lerpOvershoot(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return (paramFloat2 - paramFloat1) * getOvershootInterpolation(paramFloat3, 2.0F) + paramFloat1;
  }
  
  public static final float lerpShake(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    return (paramFloat2 - paramFloat1) * getShakeInterpolation(paramFloat3, paramFloat4) + paramFloat1;
  }
  
  public static final float maxf(float paramFloat1, float paramFloat2)
  {
    if (paramFloat1 > paramFloat2) {
      return paramFloat1;
    }
    return paramFloat2;
  }
  
  public static final int maxi(int paramInt1, int paramInt2)
  {
    if (paramInt1 > paramInt2) {
      return paramInt1;
    }
    return paramInt2;
  }
  
  public static final float minf(float paramFloat1, float paramFloat2)
  {
    if (paramFloat1 < paramFloat2) {
      return paramFloat1;
    }
    return paramFloat2;
  }
  
  public static final int mini(int paramInt1, int paramInt2)
  {
    if (paramInt1 < paramInt2) {
      return paramInt1;
    }
    return paramInt2;
  }
  
  public static final float minmaxf(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (paramFloat1 > paramFloat3) {
      return paramFloat3;
    }
    if (paramFloat1 < paramFloat2) {
      return paramFloat2;
    }
    return paramFloat1;
  }
  
  public static final int minmaxi(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 > paramInt3) {
      return paramInt3;
    }
    if (paramInt1 < paramInt2) {
      return paramInt2;
    }
    return paramInt1;
  }
  
  public static final int modulo(int paramInt1, int paramInt2)
  {
    if (paramInt1 < 0) {
      return paramInt1 % paramInt2 + paramInt2;
    }
    return paramInt1 % paramInt2;
  }
  
  public static final boolean randomb()
  {
    return Math.random() > 0.5D;
  }
  
  public static final float randomf()
  {
    return (float)Math.random();
  }
  
  public static final float randomf(float paramFloat)
  {
    return (float)(Math.random() * paramFloat);
  }
  
  public static final float randomf(float paramFloat1, float paramFloat2)
  {
    return (float)(paramFloat1 + Math.random() * (paramFloat2 - paramFloat1));
  }
  
  public static final int randomi(int paramInt)
  {
    return (int)(Math.random() * paramInt);
  }
  
  public static final int randomi(int paramInt1, int paramInt2)
  {
    return (int)(paramInt1 + Math.random() * (paramInt2 - paramInt1));
  }
  
  public static final int sgnf(float paramFloat)
  {
    if (paramFloat == 0.0F) {
      return 0;
    }
    if (paramFloat > 0.0F) {
      return 1;
    }
    return -1;
  }
  
  public static final int sgni(int paramInt)
  {
    if (paramInt == 0) {
      return 0;
    }
    if (paramInt > 0) {
      return 1;
    }
    return -1;
  }
  
  public static final float toDegree(float paramFloat)
  {
    return 57.29578F * paramFloat;
  }
  
  public static final float toRadian(float paramFloat)
  {
    return 0.017453292F * paramFloat;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/engine/MathUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */