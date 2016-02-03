package com.badlogic.gdx.graphics.glutils;

import com.badlogic.gdx.graphics.k;
import com.badlogic.gdx.graphics.m;
import com.badlogic.gdx.graphics.t;
import com.badlogic.gdx.graphics.u;
import com.badlogic.gdx.utils.f;

public class j
  implements t
{
  final k a;
  final m b;
  final boolean c;
  final boolean d;
  
  public j(k paramk, m paramm, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.a = paramk;
    m localm = paramm;
    if (paramm == null) {
      localm = paramk.i();
    }
    this.b = localm;
    this.c = paramBoolean1;
    this.d = paramBoolean2;
  }
  
  public void a(int paramInt)
  {
    throw new f("This TextureData implementation does not upload data itself");
  }
  
  public boolean a()
  {
    return true;
  }
  
  public void b()
  {
    throw new f("prepare() must not be called on a PixmapTextureData instance as it is already prepared.");
  }
  
  public k c()
  {
    return this.a;
  }
  
  public boolean d()
  {
    return this.d;
  }
  
  public int e()
  {
    return this.a.b();
  }
  
  public int f()
  {
    return this.a.d();
  }
  
  public m g()
  {
    return this.b;
  }
  
  public boolean h()
  {
    return this.c;
  }
  
  public boolean i()
  {
    return false;
  }
  
  public u j()
  {
    return u.a;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/badlogic/gdx/graphics/glutils/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */