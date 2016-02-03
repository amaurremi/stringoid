package com.androidwasabi.livewallpaper.xperiaz;

import com.androidwasabi.a.d;
import com.badlogic.gdx.graphics.g2d.b;
import com.badlogic.gdx.math.e;
import com.badlogic.gdx.math.f;
import java.util.Random;

public class l
  extends com.androidwasabi.a.a
{
  public final f g;
  boolean h = false;
  float i = 1.0F;
  float j = 1.0F;
  float k = 1.0F;
  float l = 0.0F;
  float m = 0.0F;
  float n = 0.0F;
  float o = 0.0F;
  f p = new f();
  float q;
  float r;
  float s;
  double t;
  
  public l(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    super(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    this.g = new f(paramFloat1, paramFloat2);
  }
  
  public void a()
  {
    if (this.c.e > d.b() + 50.0F) {
      b();
    }
    do
    {
      while (this.c.e < -this.d.f * 2.0F - 50.0F)
      {
        b();
        return;
        if (this.c.d > d.a() + 50.0F) {
          b();
        }
      }
    } while (this.c.d >= -this.d.f * 2.0F - 50.0F);
    b();
  }
  
  public void a(float paramFloat)
  {
    this.c.b((this.a.d + this.p.d) * paramFloat, (this.a.e + this.p.e) * paramFloat);
    this.p.b(0.92F);
    a();
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.i = paramFloat1;
    this.j = paramFloat1;
    this.k = paramFloat2;
    this.l = (paramFloat2 - paramFloat1);
    this.n = 0.0F;
    this.m = paramFloat3;
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, boolean paramBoolean)
  {
    a(paramFloat1, paramFloat2, paramFloat3);
    this.h = paramBoolean;
  }
  
  public void a(com.badlogic.gdx.graphics.g2d.a parama, b paramb)
  {
    parama.a(1.0F, 1.0F, 1.0F, this.i);
    parama.a(paramb, this.c.d, this.c.e, this.d.e, this.d.f);
  }
  
  public boolean a(float paramFloat1, float paramFloat2)
  {
    this.q = (paramFloat1 - this.c.d);
    this.r = (paramFloat2 - this.c.e);
    this.s = (this.q * this.q + this.r * this.r);
    if (this.s < 36000.0F)
    {
      this.t = Math.atan2(this.r, this.q);
      this.p.d = ((float)(this.c.d + Math.cos(this.t) - paramFloat1) * 2.0F);
      this.p.e = ((float)(this.c.e + Math.sin(this.t) - paramFloat2) * 2.0F);
      return true;
    }
    return false;
  }
  
  public void b()
  {
    Random localRandom = new Random();
    this.c.d = (localRandom.nextFloat() * d.a());
    this.c.e = (localRandom.nextFloat() * (d.b() / 4.0F * 2.0F) + d.b() / 4.0F);
    this.a.a(localRandom.nextFloat() * 70.0F + 10.0F, localRandom.nextFloat() * 15.0F + 5.0F);
    this.b.a(0.0F, 0.0F);
    this.p.a(0.0F, 0.0F);
    a(0.0F, localRandom.nextFloat() * 0.4F + 0.6F, localRandom.nextFloat() * 1.6F + 0.4F, true);
  }
  
  public void b(float paramFloat)
  {
    this.n += paramFloat;
    this.o = (this.n / this.m);
    if (this.n >= this.m)
    {
      this.i = this.k;
      if (this.h) {
        a(this.k, this.j, this.m);
      }
      return;
    }
    this.i = (this.j + this.l * this.o);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/androidwasabi/livewallpaper/xperiaz/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */