package com.badlogic.gdx.math;

public final class h
{
  float[] a;
  int b = 0;
  int c;
  float d = 0.0F;
  boolean e = true;
  
  public h(int paramInt)
  {
    this.a = new float[paramInt];
  }
  
  public void a(float paramFloat)
  {
    this.b += 1;
    float[] arrayOfFloat = this.a;
    int i = this.c;
    this.c = (i + 1);
    arrayOfFloat[i] = paramFloat;
    if (this.c > this.a.length - 1) {
      this.c = 0;
    }
    this.e = true;
  }
  
  public boolean a()
  {
    return this.b >= this.a.length;
  }
  
  public void b()
  {
    int i = 0;
    this.b = 0;
    this.c = 0;
    while (i < this.a.length)
    {
      this.a[i] = 0.0F;
      i += 1;
    }
    this.e = true;
  }
  
  public float c()
  {
    float f = 0.0F;
    if (a())
    {
      if (this.e == true)
      {
        f = 0.0F;
        int i = 0;
        while (i < this.a.length)
        {
          f += this.a[i];
          i += 1;
        }
        this.d = (f / this.a.length);
        this.e = false;
      }
      f = this.d;
    }
    return f;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/badlogic/gdx/math/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */