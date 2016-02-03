package com.badlogic.gdx.a;

import com.badlogic.gdx.a.a.b;
import com.badlogic.gdx.utils.a.c;
import com.badlogic.gdx.utils.h;
import com.badlogic.gdx.utils.u;

class e
  implements com.badlogic.gdx.utils.a.d<Void>
{
  f a;
  final a b;
  final com.badlogic.gdx.a.a.a c;
  final com.badlogic.gdx.utils.a.a d;
  final long e;
  volatile boolean f = false;
  volatile boolean g = false;
  volatile com.badlogic.gdx.utils.a<a> h;
  volatile c<Void> i = null;
  volatile c<Void> j = null;
  volatile Object k = null;
  int l = 0;
  volatile boolean m = false;
  
  public e(f paramf, a parama, com.badlogic.gdx.a.a.a parama1, com.badlogic.gdx.utils.a.a parama2)
  {
    this.a = paramf;
    this.b = parama;
    this.c = parama1;
    this.d = parama2;
    if (paramf.k.a() == 3) {}
    for (long l1 = u.a();; l1 = 0L)
    {
      this.e = l1;
      return;
    }
  }
  
  private com.badlogic.gdx.c.a a(com.badlogic.gdx.a.a.a parama, a parama1)
  {
    if (parama1.d == null) {
      parama1.d = parama.a(parama1.a);
    }
    return parama1.d;
  }
  
  private void e()
  {
    com.badlogic.gdx.a.a.d locald = (com.badlogic.gdx.a.a.d)this.c;
    if (!this.g)
    {
      this.g = true;
      this.h = locald.a(this.b.a, a(this.c, this.b), this.b.c);
      if (this.h == null)
      {
        this.k = locald.a(this.a, this.b.a, a(this.c, this.b), this.b.c);
        return;
      }
      this.a.a(this.b.a, this.h);
      return;
    }
    this.k = locald.a(this.a, this.b.a, a(this.c, this.b), this.b.c);
  }
  
  private void f()
  {
    b localb = (b)this.c;
    if (!this.g) {
      if (this.i == null) {
        this.i = this.d.a(this);
      }
    }
    do
    {
      for (;;)
      {
        return;
        if (this.i.a()) {
          try
          {
            this.i.b();
            this.g = true;
            if (this.f)
            {
              this.k = localb.b(this.a, this.b.a, a(this.c, this.b), this.b.c);
              return;
            }
          }
          catch (Exception localException1)
          {
            throw new com.badlogic.gdx.utils.f("Couldn't load dependencies of asset: " + this.b.a, localException1);
          }
        }
      }
      if ((this.j == null) && (!this.f))
      {
        this.j = this.d.a(this);
        return;
      }
      if (this.f)
      {
        this.k = localException1.b(this.a, this.b.a, a(this.c, this.b), this.b.c);
        return;
      }
    } while (!this.j.a());
    try
    {
      this.j.b();
      this.k = localException1.b(this.a, this.b.a, a(this.c, this.b), this.b.c);
      return;
    }
    catch (Exception localException2)
    {
      throw new com.badlogic.gdx.utils.f("Couldn't load asset: " + this.b.a, localException2);
    }
  }
  
  public Void a()
  {
    b localb = (b)this.c;
    if (!this.g)
    {
      this.h = localb.a(this.b.a, a(this.c, this.b), this.b.c);
      if (this.h != null) {
        this.a.a(this.b.a, this.h);
      }
    }
    for (;;)
    {
      return null;
      localb.a(this.a, this.b.a, a(this.c, this.b), this.b.c);
      this.f = true;
      continue;
      localb.a(this.a, this.b.a, a(this.c, this.b), this.b.c);
    }
  }
  
  public boolean b()
  {
    this.l += 1;
    if ((this.c instanceof com.badlogic.gdx.a.a.d)) {
      e();
    }
    while (this.k != null)
    {
      return true;
      f();
    }
    return false;
  }
  
  public Object c()
  {
    return this.k;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/badlogic/gdx/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */