package com.badlogic.gdx.d;

import com.badlogic.gdx.g;
import com.badlogic.gdx.k;
import com.badlogic.gdx.math.f;
import com.badlogic.gdx.n;
import com.badlogic.gdx.utils.u;
import com.badlogic.gdx.utils.v;
import com.badlogic.gdx.utils.w;

public class a
  extends n
{
  final c a;
  boolean b;
  f c = new f();
  private float d;
  private long e;
  private float f;
  private long g;
  private boolean h;
  private int i;
  private long j;
  private float k;
  private float l;
  private int m;
  private int n;
  private boolean o;
  private boolean p;
  private final d q = new d();
  private float r;
  private float s;
  private long t;
  private final f u = new f();
  private final f v = new f();
  private final f w = new f();
  private final w x = new b(this);
  
  public a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, c paramc)
  {
    this.d = paramFloat1;
    this.e = ((paramFloat2 * 1.0E9F));
    this.f = paramFloat3;
    this.g = ((paramFloat4 * 1.0E9F));
    this.a = paramc;
  }
  
  public a(c paramc)
  {
    this(20.0F, 0.4F, 1.1F, 0.15F, paramc);
  }
  
  private boolean a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    return (Math.abs(paramFloat1 - paramFloat3) < this.d) && (Math.abs(paramFloat2 - paramFloat4) < this.d);
  }
  
  public boolean a(float paramFloat1, float paramFloat2, int paramInt)
  {
    if (paramInt > 1) {}
    label123:
    do
    {
      do
      {
        return false;
      } while (this.b);
      if (paramInt == 0) {
        this.c.a(paramFloat1, paramFloat2);
      }
      for (;;)
      {
        if (!this.o) {
          break label123;
        }
        if (this.a == null) {
          break;
        }
        boolean bool = this.a.a(this.v, this.w, this.c, this.u);
        if ((!this.a.b(this.v.b(this.w), this.c.b(this.u))) && (!bool)) {
          break;
        }
        return true;
        this.u.a(paramFloat1, paramFloat2);
      }
      this.q.b(paramFloat1, paramFloat2, g.d.a());
      if ((this.h) && (!a(paramFloat1, paramFloat2, this.r, this.s)))
      {
        this.x.a();
        this.h = false;
      }
    } while (this.h);
    this.p = true;
    return this.a.a(paramFloat1, paramFloat2, this.q.d, this.q.e);
  }
  
  public boolean a(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    if (paramInt1 > 1) {
      return false;
    }
    if (paramInt1 == 0)
    {
      this.c.a(paramFloat1, paramFloat2);
      this.t = g.d.a();
      this.q.a(paramFloat1, paramFloat2, this.t);
      if (g.d.a(1))
      {
        this.h = false;
        this.o = true;
        this.v.a(this.c);
        this.w.a(this.u);
        this.x.a();
      }
    }
    for (;;)
    {
      return this.a.a(paramFloat1, paramFloat2, paramInt1, paramInt2);
      this.h = true;
      this.o = false;
      this.b = false;
      this.r = paramFloat1;
      this.s = paramFloat2;
      if (!this.x.b())
      {
        v.b(this.x, this.f);
        continue;
        this.u.a(paramFloat1, paramFloat2);
        this.h = false;
        this.o = true;
        this.v.a(this.c);
        this.w.a(this.u);
        this.x.a();
      }
    }
  }
  
  public boolean a(int paramInt1, int paramInt2, int paramInt3)
  {
    return a(paramInt1, paramInt2, paramInt3);
  }
  
  public boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return a(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public boolean b(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    if (paramInt1 > 1) {}
    do
    {
      return false;
      if ((this.h) && (!a(paramFloat1, paramFloat2, this.r, this.s))) {
        this.h = false;
      }
      bool = this.p;
      this.p = false;
      this.x.a();
    } while (this.b);
    if (this.h)
    {
      if ((this.m != paramInt2) || (this.n != paramInt1) || (u.a() - this.j > this.e) || (!a(paramFloat1, paramFloat2, this.k, this.l))) {
        this.i = 0;
      }
      this.i += 1;
      this.j = u.a();
      this.k = paramFloat1;
      this.l = paramFloat2;
      this.m = paramInt2;
      this.n = paramInt1;
      this.t = 0L;
      return this.a.b(paramFloat1, paramFloat2, this.i, paramInt2);
    }
    if (this.o)
    {
      this.o = false;
      this.p = true;
      if (paramInt1 == 0)
      {
        this.q.a(this.u.d, this.u.e, g.d.a());
        return false;
      }
      this.q.a(this.c.d, this.c.e, g.d.a());
      return false;
    }
    if ((bool) && (!this.p)) {}
    for (boolean bool = this.a.c(paramFloat1, paramFloat2, paramInt1, paramInt2);; bool = false)
    {
      this.t = 0L;
      long l1 = g.d.a();
      if (l1 - this.q.f < this.g)
      {
        this.q.b(paramFloat1, paramFloat2, l1);
        if ((!this.a.a(this.q.a(), this.q.b(), paramInt2)) && (!bool)) {
          break;
        }
        return true;
      }
      return bool;
    }
  }
  
  public boolean b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return b(paramInt1, paramInt2, paramInt3, paramInt4);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/badlogic/gdx/d/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */