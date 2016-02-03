package com.badlogic.gdx.graphics.g2d;

import com.badlogic.gdx.graphics.p;

public class b
{
  p a;
  float b;
  float c;
  float d;
  float e;
  int f;
  int g;
  
  public b() {}
  
  public b(p paramp, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.a = paramp;
    a(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    int i = this.a.k();
    int j = this.a.l();
    this.f = Math.round(Math.abs(paramFloat3 - paramFloat1) * i);
    this.g = Math.round(Math.abs(paramFloat4 - paramFloat2) * j);
    float f4 = paramFloat1;
    float f3 = paramFloat2;
    float f2 = paramFloat3;
    float f1 = paramFloat4;
    if (this.f == 1)
    {
      f4 = paramFloat1;
      f3 = paramFloat2;
      f2 = paramFloat3;
      f1 = paramFloat4;
      if (this.g == 1)
      {
        f1 = 0.25F / i;
        f4 = paramFloat1 + f1;
        f2 = paramFloat3 - f1;
        paramFloat1 = 0.25F / j;
        f3 = paramFloat2 + paramFloat1;
        f1 = paramFloat4 - paramFloat1;
      }
    }
    this.b = f4;
    this.c = f3;
    this.d = f2;
    this.e = f1;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    float f1 = 1.0F / this.a.k();
    float f2 = 1.0F / this.a.l();
    a(paramInt1 * f1, paramInt2 * f2, f1 * (paramInt1 + paramInt3), f2 * (paramInt2 + paramInt4));
    this.f = Math.abs(paramInt3);
    this.g = Math.abs(paramInt4);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/badlogic/gdx/graphics/g2d/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */