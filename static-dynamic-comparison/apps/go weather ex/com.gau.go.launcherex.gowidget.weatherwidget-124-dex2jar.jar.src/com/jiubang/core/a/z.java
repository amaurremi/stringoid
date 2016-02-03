package com.jiubang.core.a;

import android.graphics.Bitmap;

class z
{
  private int b;
  private int c;
  private int d;
  private int e;
  private float f = 1.0F;
  private float g;
  private float h;
  
  public z(y paramy)
  {
    h();
  }
  
  private void i()
  {
    if (k()) {
      return;
    }
    if (this.b * this.e > this.d * this.c)
    {
      this.f = (this.e / this.c);
      return;
    }
    this.f = (this.d / this.b);
  }
  
  private void j()
  {
    if (k()) {
      return;
    }
    this.g = ((c() - a() * e()) * 0.5F);
    this.h = ((d() - b() * e()) * 0.5F);
  }
  
  private boolean k()
  {
    return (c() == 0) || (d() == 0);
  }
  
  public int a()
  {
    return this.b;
  }
  
  public int b()
  {
    return this.c;
  }
  
  public int c()
  {
    return this.d;
  }
  
  public int d()
  {
    return this.e;
  }
  
  public float e()
  {
    return this.f * 1.12F;
  }
  
  public float f()
  {
    return this.g;
  }
  
  public float g()
  {
    return this.h;
  }
  
  public void h()
  {
    if (this.a.j == null) {
      return;
    }
    this.b = this.a.j.getWidth();
    this.c = this.a.j.getHeight();
    this.d = this.a.a();
    this.e = this.a.b();
    i();
    j();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/core/a/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */