package com.venticake.retrica.view.album;

public class FloatUtils
{
  private static final float ANIMATION_SPEED = 4.0F;
  
  public static final float animate(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return animateAfterFactoringSpeed(paramFloat1, paramFloat2, 4.0F * paramFloat3);
  }
  
  public static final void animate(Vector3f paramVector3f1, Vector3f paramVector3f2, float paramFloat)
  {
    paramFloat = 4.0F * paramFloat;
    paramVector3f1.x = animateAfterFactoringSpeed(paramVector3f1.x, paramVector3f2.x, paramFloat);
    paramVector3f1.y = animateAfterFactoringSpeed(paramVector3f1.y, paramVector3f2.y, paramFloat);
    paramVector3f1.z = animateAfterFactoringSpeed(paramVector3f1.z, paramVector3f2.z, paramFloat);
  }
  
  private static final float animateAfterFactoringSpeed(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (paramFloat1 == paramFloat2) {}
    do
    {
      return paramFloat2;
      paramFloat3 = (paramFloat2 - paramFloat1) * paramFloat3 + paramFloat1;
    } while ((Math.abs(paramFloat3 - paramFloat1) < 1.0E-4F) || (paramFloat3 == paramFloat1) || ((paramFloat1 > paramFloat2) && (paramFloat3 < paramFloat2)) || ((paramFloat1 < paramFloat2) && (paramFloat3 > paramFloat2)));
    return paramFloat3;
  }
  
  public static final boolean boundsContainsPoint(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    return (paramFloat5 >= paramFloat1) && (paramFloat5 <= paramFloat2) && (paramFloat6 >= paramFloat3) && (paramFloat6 <= paramFloat4);
  }
  
  public static final float clamp(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (paramFloat1 < paramFloat2) {
      return paramFloat2;
    }
    if (paramFloat1 > paramFloat3) {
      return paramFloat3;
    }
    return paramFloat1;
  }
  
  public static final int clamp(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 < paramInt2) {
      return paramInt2;
    }
    if (paramInt1 > paramInt3) {
      return paramInt3;
    }
    return paramInt1;
  }
  
  public static final float clampMax(float paramFloat1, float paramFloat2)
  {
    if (paramFloat1 > paramFloat2) {
      return paramFloat2;
    }
    return paramFloat1;
  }
  
  public static final float clampMin(float paramFloat1, float paramFloat2)
  {
    if (paramFloat1 < paramFloat2) {
      return paramFloat2;
    }
    return paramFloat1;
  }
  
  public static final float max(float paramFloat1, float paramFloat2)
  {
    if (paramFloat1 > paramFloat2) {
      return paramFloat1;
    }
    return paramFloat2;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/venticake/retrica/view/album/FloatUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */