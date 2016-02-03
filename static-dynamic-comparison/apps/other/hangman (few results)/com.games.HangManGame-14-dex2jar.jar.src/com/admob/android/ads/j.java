package com.admob.android.ads;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.Transformation;

public final class j
  extends Animation
{
  private final float[] a;
  private final float[] b;
  private final float c;
  private final float d;
  private final float e;
  private final boolean f;
  private Camera g;
  
  public j(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, boolean paramBoolean)
  {
    this(new float[] { 0.0F, paramFloat1, 0.0F }, new float[] { 0.0F, paramFloat2, 0.0F }, paramFloat3, paramFloat4, paramFloat5, paramBoolean);
  }
  
  public j(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, float paramFloat1, float paramFloat2, float paramFloat3, boolean paramBoolean)
  {
    this.a = paramArrayOfFloat1;
    this.b = paramArrayOfFloat2;
    this.c = paramFloat1;
    this.d = paramFloat2;
    this.e = paramFloat3;
    this.f = paramBoolean;
  }
  
  protected final void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    if ((paramFloat < 0.0D) || (paramFloat > 1.0D))
    {
      paramTransformation.setTransformationType(Transformation.TYPE_IDENTITY);
      return;
    }
    Object localObject1 = this.a;
    Object localObject2 = this.b;
    float[] arrayOfFloat = new float[3];
    int i = 0;
    while (i < 3)
    {
      localObject1[i] += (localObject2[i] - localObject1[i]) * paramFloat;
      i += 1;
    }
    float f1 = this.c;
    float f2 = this.d;
    localObject1 = this.g;
    localObject2 = paramTransformation.getMatrix();
    ((Camera)localObject1).save();
    if (this.f) {
      ((Camera)localObject1).translate(0.0F, 0.0F, this.e * paramFloat);
    }
    for (;;)
    {
      ((Camera)localObject1).rotateX(arrayOfFloat[0]);
      ((Camera)localObject1).rotateY(arrayOfFloat[1]);
      ((Camera)localObject1).rotateZ(arrayOfFloat[2]);
      ((Camera)localObject1).getMatrix((Matrix)localObject2);
      ((Camera)localObject1).restore();
      ((Matrix)localObject2).preTranslate(-f1, -f2);
      ((Matrix)localObject2).postTranslate(f1, f2);
      paramTransformation.setTransformationType(Transformation.TYPE_MATRIX);
      return;
      ((Camera)localObject1).translate(0.0F, 0.0F, this.e * (1.0F - paramFloat));
    }
  }
  
  public final void initialize(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.initialize(paramInt1, paramInt2, paramInt3, paramInt4);
    this.g = new Camera();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/hangman/com.games.HangManGame-14-dex2jar.jar!/com/admob/android/ads/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */