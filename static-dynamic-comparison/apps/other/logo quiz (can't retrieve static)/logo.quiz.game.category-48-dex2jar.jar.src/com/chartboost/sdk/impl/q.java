package com.chartboost.sdk.impl;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.Transformation;

public final class q
  extends Animation
{
  private final float a;
  private final float b;
  private final float c;
  private final float d;
  private boolean e = true;
  private Camera f;
  
  public q(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, boolean paramBoolean)
  {
    this.a = paramFloat1;
    this.b = paramFloat2;
    this.c = paramFloat3;
    this.d = paramFloat4;
    this.e = paramBoolean;
  }
  
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    paramFloat = this.a + (this.b - this.a) * paramFloat;
    Camera localCamera = this.f;
    paramTransformation = paramTransformation.getMatrix();
    localCamera.save();
    if (this.e) {
      localCamera.rotateY(paramFloat);
    }
    for (;;)
    {
      localCamera.getMatrix(paramTransformation);
      localCamera.restore();
      paramTransformation.preTranslate(-this.c, -this.d);
      paramTransformation.postTranslate(this.c, this.d);
      return;
      localCamera.rotateX(paramFloat);
    }
  }
  
  public void initialize(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.initialize(paramInt1, paramInt2, paramInt3, paramInt4);
    this.f = new Camera();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/chartboost/sdk/impl/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */