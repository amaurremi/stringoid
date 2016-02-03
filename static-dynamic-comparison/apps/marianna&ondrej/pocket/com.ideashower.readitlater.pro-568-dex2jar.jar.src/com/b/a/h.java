package com.b.a;

import android.view.animation.Interpolator;

public abstract class h
  implements Cloneable
{
  float a;
  Class b;
  boolean c = false;
  private Interpolator d = null;
  
  public static h a(float paramFloat)
  {
    return new j(paramFloat);
  }
  
  public static h a(float paramFloat1, float paramFloat2)
  {
    return new i(paramFloat1, paramFloat2);
  }
  
  public static h a(float paramFloat, int paramInt)
  {
    return new j(paramFloat, paramInt);
  }
  
  public static h b(float paramFloat)
  {
    return new i(paramFloat);
  }
  
  public abstract Object a();
  
  public void a(Interpolator paramInterpolator)
  {
    this.d = paramInterpolator;
  }
  
  public float b()
  {
    return this.a;
  }
  
  public Interpolator c()
  {
    return this.d;
  }
  
  public abstract h d();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/b/a/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */