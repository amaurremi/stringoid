package com.skplanet.tad.common;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.Transformation;

public class g
  extends Animation
{
  private float a;
  private float b;
  private float c;
  private float d;
  private float e;
  private boolean f;
  private boolean g;
  private Camera h;
  
  public g(float paramFloat1, float paramFloat2, float paramFloat3, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.a = paramFloat1;
    this.b = paramFloat2;
    this.e = paramFloat3;
    this.f = paramBoolean1;
    this.g = paramBoolean2;
  }
  
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    float f1 = this.a;
    f1 += (this.b - f1) * paramFloat;
    float f2 = this.c;
    float f3 = this.d;
    Camera localCamera = this.h;
    paramTransformation = paramTransformation.getMatrix();
    localCamera.save();
    if (this.f)
    {
      localCamera.translate(0.0F, 0.0F, this.e * paramFloat);
      if (!this.g) {
        break label127;
      }
      localCamera.rotateY(f1);
    }
    for (;;)
    {
      localCamera.getMatrix(paramTransformation);
      localCamera.restore();
      paramTransformation.preTranslate(-f2, -f3);
      paramTransformation.postTranslate(f2, f3);
      return;
      localCamera.translate(0.0F, 0.0F, this.e * (1.0F - paramFloat));
      break;
      label127:
      localCamera.rotateX(f1);
    }
  }
  
  public void initialize(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.initialize(paramInt1, paramInt2, paramInt3, paramInt4);
    this.c = (paramInt1 / 2.0F);
    this.d = (paramInt2 / 2.0F);
    this.h = new Camera();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/skplanet/tad/common/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */