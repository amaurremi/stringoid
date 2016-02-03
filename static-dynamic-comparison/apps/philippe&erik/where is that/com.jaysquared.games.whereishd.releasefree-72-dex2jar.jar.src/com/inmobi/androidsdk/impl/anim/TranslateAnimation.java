package com.inmobi.androidsdk.impl.anim;

import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.Transformation;

public class TranslateAnimation
  extends Animation
{
  private int a = 0;
  private int b = 0;
  private int c = 0;
  private int d = 0;
  private float e = 0.0F;
  private float f = 0.0F;
  private float g = 0.0F;
  private float h = 0.0F;
  private float i;
  private float j;
  private float k;
  private float l;
  
  public TranslateAnimation(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.e = paramFloat1;
    this.f = paramFloat2;
    this.g = paramFloat3;
    this.h = paramFloat4;
    this.a = 0;
    this.b = 0;
    this.c = 0;
    this.d = 0;
  }
  
  public TranslateAnimation(int paramInt1, float paramFloat1, int paramInt2, float paramFloat2, int paramInt3, float paramFloat3, int paramInt4, float paramFloat4)
  {
    this.e = paramFloat1;
    this.f = paramFloat2;
    this.g = paramFloat3;
    this.h = paramFloat4;
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    this.d = paramInt4;
  }
  
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    float f1 = this.i;
    float f2 = this.k;
    if (this.i != this.j) {
      f1 = this.i + (this.j - this.i) * paramFloat;
    }
    if (this.k != this.l) {
      f2 = this.k + (this.l - this.k) * paramFloat;
    }
    paramTransformation.getMatrix().setTranslate(f1, f2);
  }
  
  public void initialize(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.initialize(paramInt1, paramInt2, paramInt3, paramInt4);
    this.i = resolveSize(this.a, this.e, paramInt1, paramInt3);
    this.j = resolveSize(this.b, this.f, paramInt1, paramInt3);
    this.k = resolveSize(this.c, this.g, paramInt2, paramInt4);
    this.l = resolveSize(this.d, this.h, paramInt2, paramInt4);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/inmobi/androidsdk/impl/anim/TranslateAnimation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */