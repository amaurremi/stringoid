package com.venticake.retrica.engine;

public class TextureRotationUtil
{
  public static final float[] TEXTURE_NO_ROTATION = { 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F };
  public static final float[] TEXTURE_ROTATED_180 = { 1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, 1.0F };
  public static final float[] TEXTURE_ROTATED_270 = { 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, 1.0F, 1.0F };
  public static final float[] TEXTURE_ROTATED_90 = { 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F };
  
  private static float flip(float paramFloat)
  {
    float f = 0.0F;
    if (paramFloat == 0.0F) {
      f = 1.0F;
    }
    return f;
  }
  
  public static float[] getRotation(Rotation paramRotation, boolean paramBoolean1, boolean paramBoolean2)
  {
    switch (paramRotation)
    {
    default: 
      paramRotation = TEXTURE_NO_ROTATION;
      if (paramBoolean1)
      {
        float[] arrayOfFloat = new float[8];
        arrayOfFloat[0] = flip(paramRotation[0]);
        arrayOfFloat[1] = paramRotation[1];
        arrayOfFloat[2] = flip(paramRotation[2]);
        arrayOfFloat[3] = paramRotation[3];
        arrayOfFloat[4] = flip(paramRotation[4]);
        arrayOfFloat[5] = paramRotation[5];
        arrayOfFloat[6] = flip(paramRotation[6]);
        arrayOfFloat[7] = paramRotation[7];
        paramRotation = arrayOfFloat;
      }
      break;
    }
    for (;;)
    {
      if (paramBoolean2)
      {
        return new float[] { paramRotation[0], flip(paramRotation[1]), paramRotation[2], flip(paramRotation[3]), paramRotation[4], flip(paramRotation[5]), paramRotation[6], flip(paramRotation[7]) };
        paramRotation = TEXTURE_ROTATED_90;
        break;
        paramRotation = TEXTURE_ROTATED_180;
        break;
        paramRotation = TEXTURE_ROTATED_270;
        break;
      }
      return paramRotation;
    }
  }
  
  public static float[] getRotation(float[] paramArrayOfFloat, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      float[] arrayOfFloat = new float[8];
      arrayOfFloat[0] = flip(paramArrayOfFloat[0]);
      arrayOfFloat[1] = paramArrayOfFloat[1];
      arrayOfFloat[2] = flip(paramArrayOfFloat[2]);
      arrayOfFloat[3] = paramArrayOfFloat[3];
      arrayOfFloat[4] = flip(paramArrayOfFloat[4]);
      arrayOfFloat[5] = paramArrayOfFloat[5];
      arrayOfFloat[6] = flip(paramArrayOfFloat[6]);
      arrayOfFloat[7] = paramArrayOfFloat[7];
      paramArrayOfFloat = arrayOfFloat;
    }
    for (;;)
    {
      if (paramBoolean2) {
        return new float[] { paramArrayOfFloat[0], flip(paramArrayOfFloat[1]), paramArrayOfFloat[2], flip(paramArrayOfFloat[3]), paramArrayOfFloat[4], flip(paramArrayOfFloat[5]), paramArrayOfFloat[6], flip(paramArrayOfFloat[7]) };
      }
      return paramArrayOfFloat;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/venticake/retrica/engine/TextureRotationUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */