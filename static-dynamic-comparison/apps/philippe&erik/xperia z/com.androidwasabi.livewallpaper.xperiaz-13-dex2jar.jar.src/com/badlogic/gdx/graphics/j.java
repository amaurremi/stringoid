package com.badlogic.gdx.graphics;

import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.g;

public class j
  extends a
{
  public float n = 1.0F;
  private final g o = new g();
  
  public j()
  {
    this.h = 0.0F;
  }
  
  public j(float paramFloat1, float paramFloat2)
  {
    this.j = paramFloat1;
    this.k = paramFloat2;
    this.h = 0.0F;
    a();
  }
  
  public void a()
  {
    a(true);
  }
  
  public void a(boolean paramBoolean)
  {
    this.d.a(this.n * -this.j / 2.0F, this.n * (this.j / 2.0F), this.n * -(this.k / 2.0F), this.n * this.k / 2.0F, this.h, this.i);
    this.e.a(this.a, this.o.a(this.a).b(this.b), this.c);
    this.f.a(this.d);
    Matrix4.mul(this.f.b, this.e.b);
    if (paramBoolean)
    {
      this.g.a(this.f);
      Matrix4.inv(this.g.b);
      this.l.a(this.g);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/badlogic/gdx/graphics/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */