package com.badlogic.gdx.graphics.glutils;

import com.badlogic.gdx.c.a;
import com.badlogic.gdx.g;
import com.badlogic.gdx.graphics.k;
import com.badlogic.gdx.graphics.m;
import com.badlogic.gdx.graphics.n;
import com.badlogic.gdx.graphics.t;
import com.badlogic.gdx.graphics.u;
import com.badlogic.gdx.math.b;
import com.badlogic.gdx.utils.f;

public class c
  implements t
{
  public static boolean a;
  final a b;
  int c = 0;
  int d = 0;
  m e;
  k f;
  boolean g;
  boolean h = false;
  
  public c(a parama, k paramk, m paramm, boolean paramBoolean)
  {
    this.b = parama;
    this.f = paramk;
    this.e = paramm;
    this.g = paramBoolean;
    if (this.f != null)
    {
      this.f = a(this.f);
      this.c = this.f.b();
      this.d = this.f.d();
      if (paramm == null) {
        this.e = this.f.i();
      }
    }
  }
  
  private k a(k paramk)
  {
    if ((g.j == null) && (a))
    {
      int i = paramk.b();
      int j = paramk.d();
      int k = b.b(i);
      int m = b.b(j);
      if ((i != k) || (j != m))
      {
        k localk = new k(k, m, paramk.i());
        localk.a(paramk, 0, 0, 0, 0, i, j);
        paramk.c();
        return localk;
      }
    }
    return paramk;
  }
  
  public void a(int paramInt)
  {
    throw new f("This TextureData implementation does not upload data itself");
  }
  
  public boolean a()
  {
    return this.h;
  }
  
  public void b()
  {
    if (this.h) {
      throw new f("Already prepared");
    }
    if (this.f == null) {
      if (!this.b.e().equals("cim")) {
        break label96;
      }
    }
    label96:
    for (this.f = n.a(this.b);; this.f = a(new k(this.b)))
    {
      this.c = this.f.b();
      this.d = this.f.d();
      if (this.e == null) {
        this.e = this.f.i();
      }
      this.h = true;
      return;
    }
  }
  
  public k c()
  {
    if (!this.h) {
      throw new f("Call prepare() before calling getPixmap()");
    }
    this.h = false;
    k localk = this.f;
    this.f = null;
    return localk;
  }
  
  public boolean d()
  {
    return true;
  }
  
  public int e()
  {
    return this.c;
  }
  
  public int f()
  {
    return this.d;
  }
  
  public m g()
  {
    return this.e;
  }
  
  public boolean h()
  {
    return this.g;
  }
  
  public boolean i()
  {
    return true;
  }
  
  public u j()
  {
    return u.a;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/badlogic/gdx/graphics/glutils/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */