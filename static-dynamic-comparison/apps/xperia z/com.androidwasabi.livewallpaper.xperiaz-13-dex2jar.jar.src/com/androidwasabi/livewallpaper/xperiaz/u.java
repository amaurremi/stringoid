package com.androidwasabi.livewallpaper.xperiaz;

import com.androidwasabi.a.d;
import com.badlogic.gdx.d.c;
import com.badlogic.gdx.graphics.j;
import com.badlogic.gdx.math.f;
import com.badlogic.gdx.math.g;

class u
  implements c
{
  boolean a = false;
  int b = 5;
  float c = 0.0F;
  float d = 0.0F;
  float e = 0.0F;
  float f = 0.0F;
  float g = 0.0F;
  
  u(t paramt) {}
  
  public void a(int paramInt)
  {
    this.c = d.c();
    this.d = ((d.a() - this.c) / 2.0F);
    this.g = Math.abs((d.a() - this.c) / (paramInt - 1));
  }
  
  public boolean a(float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public boolean a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    if (this.h.b != v.b) {}
    do
    {
      do
      {
        return false;
      } while (!this.h.w);
      if ((this.h.a) || (!this.h.q))
      {
        this.d = ((d.a() - this.c) / 2.0F);
        this.h.p.g.d = this.d;
        return false;
      }
    } while (paramFloat3 == 0.0F);
    if (paramFloat3 > 0.0F)
    {
      paramFloat1 = 6.0F;
      this.e = paramFloat1;
      this.f += this.e;
      if (this.e >= 0.0F) {
        break label203;
      }
      if (this.f <= 0.0F) {
        break label174;
      }
      this.f = 0.0F;
      label135:
      if (this.d < 0.0F) {
        break label257;
      }
      this.d = 0.0F;
    }
    for (;;)
    {
      this.h.p.g.d = this.d;
      return false;
      paramFloat1 = -6.0F;
      break;
      label174:
      if (this.f < -this.g) {
        break label135;
      }
      this.d += this.e;
      break label135;
      label203:
      if (this.e <= 0.0F) {
        break label135;
      }
      if (this.f < 0.0F)
      {
        this.f = 0.0F;
        break label135;
      }
      if (this.f > this.g) {
        break label135;
      }
      this.d += this.e;
      break label135;
      label257:
      if (this.d <= d.a() - this.c) {
        this.d = (d.a() - this.c);
      }
    }
  }
  
  public boolean a(float paramFloat1, float paramFloat2, int paramInt)
  {
    this.a = true;
    return false;
  }
  
  public boolean a(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    if (this.h.b != v.b) {}
    for (;;)
    {
      return false;
      this.a = false;
      this.f = 0.0F;
      if (this.h.r)
      {
        this.h.f.a(this.h.h.a(paramFloat1, paramFloat2, 0.0F));
        paramInt1 = 0;
        while (paramInt1 < this.h.s.length)
        {
          this.h.s[paramInt1].a(this.h.h.a, this.h.h.b);
          paramInt1 += 1;
        }
      }
    }
  }
  
  public boolean a(f paramf1, f paramf2, f paramf3, f paramf4)
  {
    return false;
  }
  
  public boolean b(float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public boolean b(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    return false;
  }
  
  public boolean c(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/androidwasabi/livewallpaper/xperiaz/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */