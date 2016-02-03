package com.admob.android.ads;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

public final class b
  extends Animation
{
  private View a;
  private float b;
  private float c;
  
  public b(float paramFloat1, float paramFloat2, View paramView)
  {
    this.b = paramFloat1;
    this.c = paramFloat2;
    this.a = paramView;
  }
  
  protected final void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    paramTransformation.setTransformationType(Transformation.TYPE_IDENTITY);
    if ((paramFloat < 0.0D) || (paramFloat > 1.0D)) {}
    do
    {
      return;
      float f1 = this.b;
      float f2 = this.c;
      float f3 = this.b;
      paramTransformation = this.a;
      if (paramTransformation != null)
      {
        f localf = f.c(paramTransformation);
        localf.a = (f1 + (f2 - f3) * paramFloat);
        paramTransformation.setTag(localf);
      }
      paramTransformation = this.a.getParent();
    } while (!(paramTransformation instanceof a));
    ((a)paramTransformation).f();
  }
  
  public static abstract interface a
  {
    public abstract void f();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/hangman/com.games.HangManGame-14-dex2jar.jar!/com/admob/android/ads/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */