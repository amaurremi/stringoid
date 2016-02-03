package com.badlogic.gdx.math;

import java.io.Serializable;

public class c
  implements Serializable
{
  public final g a = new g();
  public float b = 0.0F;
  
  public c(g paramg, float paramFloat)
  {
    this.a.a(paramg).d();
    this.b = paramFloat;
  }
  
  public void a(g paramg1, g paramg2, g paramg3)
  {
    paramg2 = paramg1.a().c(paramg2).e(paramg2.b().c(paramg3)).d();
    this.a.a(paramg2);
    this.b = (-paramg1.d(paramg2));
  }
  
  public String toString()
  {
    return this.a.toString() + ", " + this.b;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/badlogic/gdx/math/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */