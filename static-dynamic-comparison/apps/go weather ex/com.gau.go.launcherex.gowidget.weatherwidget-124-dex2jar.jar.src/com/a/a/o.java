package com.a.a;

import android.view.animation.Interpolator;

public abstract class o
  implements Cloneable
{
  float a;
  Class b;
  boolean c = false;
  private Interpolator d = null;
  
  public static o a(float paramFloat)
  {
    return new q(paramFloat);
  }
  
  public static o a(float paramFloat1, float paramFloat2)
  {
    return new p(paramFloat1, paramFloat2);
  }
  
  public static o a(float paramFloat, int paramInt)
  {
    return new q(paramFloat, paramInt);
  }
  
  public static o b(float paramFloat)
  {
    return new p(paramFloat);
  }
  
  public void a(Interpolator paramInterpolator)
  {
    this.d = paramInterpolator;
  }
  
  public abstract void a(Object paramObject);
  
  public boolean a()
  {
    return this.c;
  }
  
  public abstract Object b();
  
  public float c()
  {
    return this.a;
  }
  
  public Interpolator d()
  {
    return this.d;
  }
  
  public abstract o e();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/a/a/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */