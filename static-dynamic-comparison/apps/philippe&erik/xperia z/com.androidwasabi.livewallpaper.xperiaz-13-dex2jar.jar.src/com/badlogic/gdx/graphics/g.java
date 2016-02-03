package com.badlogic.gdx.graphics;

import com.badlogic.gdx.c.a;
import com.badlogic.gdx.graphics.glutils.c;
import com.badlogic.gdx.graphics.glutils.i;
import com.badlogic.gdx.utils.BufferUtils;
import com.badlogic.gdx.utils.d;
import java.nio.IntBuffer;

public abstract class g
  implements d
{
  private static boolean g = true;
  private static final IntBuffer h = BufferUtils.c(1);
  public final int a;
  protected int b;
  protected r c = r.a;
  protected r d = r.a;
  protected s e = s.b;
  protected s f = s.b;
  
  public g(int paramInt1, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramInt2;
  }
  
  protected static t a(a parama, m paramm, boolean paramBoolean)
  {
    if (parama == null) {
      return null;
    }
    if (parama.d().endsWith(".etc1")) {
      return new com.badlogic.gdx.graphics.glutils.b(parama, paramBoolean);
    }
    return new c(parama, null, paramm, paramBoolean);
  }
  
  protected static void a(int paramInt, t paramt)
  {
    if (paramt == null) {
      return;
    }
    if (!paramt.a()) {
      paramt.b();
    }
    if ((g) && (com.badlogic.gdx.g.j == null) && ((!com.badlogic.gdx.math.b.c(paramt.e())) || (!com.badlogic.gdx.math.b.c(paramt.f())))) {
      throw new com.badlogic.gdx.utils.f("Texture width and height must be powers of two: " + paramt.e() + "x" + paramt.f());
    }
    Object localObject = paramt.j();
    if ((localObject == u.b) || (localObject == u.c))
    {
      paramt.a(paramInt);
      return;
    }
    localObject = paramt.c();
    boolean bool = paramt.d();
    if (paramt.g() != ((k)localObject).i())
    {
      k localk = new k(((k)localObject).b(), ((k)localObject).d(), paramt.g());
      l locall = k.j();
      k.a(l.a);
      localk.a((k)localObject, 0, 0, 0, 0, ((k)localObject).b(), ((k)localObject).d());
      k.a(locall);
      if (paramt.d()) {
        ((k)localObject).c();
      }
      bool = true;
      localObject = localk;
    }
    for (;;)
    {
      com.badlogic.gdx.g.g.glPixelStorei(3317, 1);
      if (paramt.h()) {
        i.a(paramInt, (k)localObject, ((k)localObject).b(), ((k)localObject).d());
      }
      while (bool)
      {
        ((k)localObject).c();
        return;
        com.badlogic.gdx.g.g.glTexImage2D(paramInt, 0, ((k)localObject).f(), ((k)localObject).b(), ((k)localObject).d(), 0, ((k)localObject).e(), ((k)localObject).g(), ((k)localObject).h());
      }
      break;
    }
  }
  
  protected static int i()
  {
    h.position(0);
    h.limit(h.capacity());
    com.badlogic.gdx.g.g.glGenTextures(1, h);
    return h.get(0);
  }
  
  public void a()
  {
    com.badlogic.gdx.g.g.glBindTexture(this.a, this.b);
  }
  
  public void a(r paramr1, r paramr2)
  {
    this.c = paramr1;
    this.d = paramr2;
    a();
    com.badlogic.gdx.g.g.glTexParameterf(this.a, 10241, paramr1.a());
    com.badlogic.gdx.g.g.glTexParameterf(this.a, 10240, paramr2.a());
  }
  
  public void a(s params1, s params2)
  {
    this.e = params1;
    this.f = params2;
    a();
    com.badlogic.gdx.g.g.glTexParameterf(this.a, 10242, params1.a());
    com.badlogic.gdx.g.g.glTexParameterf(this.a, 10243, params2.a());
  }
  
  public r b()
  {
    return this.c;
  }
  
  public void c()
  {
    h();
  }
  
  public r d()
  {
    return this.d;
  }
  
  public s e()
  {
    return this.e;
  }
  
  public s f()
  {
    return this.f;
  }
  
  public int g()
  {
    return this.b;
  }
  
  protected void h()
  {
    if (this.b != 0)
    {
      h.put(0, this.b);
      com.badlogic.gdx.g.g.glDeleteTextures(1, h);
      this.b = 0;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/badlogic/gdx/graphics/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */