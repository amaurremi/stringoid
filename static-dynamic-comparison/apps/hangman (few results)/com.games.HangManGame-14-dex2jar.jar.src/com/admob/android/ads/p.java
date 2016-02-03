package com.admob.android.ads;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.view.animation.Animation;
import android.view.animation.Transformation;

public final class p
  extends Animation
{
  private float[] a;
  private float[] b;
  
  public p(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, PointF paramPointF)
  {
    this.a = paramArrayOfFloat1;
    this.b = paramArrayOfFloat2;
  }
  
  protected final void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    if ((paramFloat < 0.0D) || (paramFloat > 1.0D))
    {
      paramTransformation.setTransformationType(Transformation.TYPE_IDENTITY);
      return;
    }
    Matrix localMatrix = paramTransformation.getMatrix();
    float[] arrayOfFloat = new float[this.a.length];
    int i = 0;
    while (i < this.a.length)
    {
      arrayOfFloat[i] = (this.a[i] + (this.b[i] - this.a[i]) * paramFloat);
      i += 1;
    }
    localMatrix.setSkew(this.a[0], this.a[1]);
    paramTransformation.setTransformationType(Transformation.TYPE_MATRIX);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/hangman/com.games.HangManGame-14-dex2jar.jar!/com/admob/android/ads/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */