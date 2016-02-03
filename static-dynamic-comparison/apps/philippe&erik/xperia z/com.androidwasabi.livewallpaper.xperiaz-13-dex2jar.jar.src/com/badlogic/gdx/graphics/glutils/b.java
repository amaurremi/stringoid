package com.badlogic.gdx.graphics.glutils;

import com.badlogic.gdx.g;
import com.badlogic.gdx.graphics.e;
import com.badlogic.gdx.graphics.k;
import com.badlogic.gdx.graphics.m;
import com.badlogic.gdx.graphics.t;
import com.badlogic.gdx.graphics.u;
import com.badlogic.gdx.h;
import java.nio.ByteBuffer;

public class b
  implements t
{
  com.badlogic.gdx.c.a a;
  a b;
  boolean c;
  int d = 0;
  int e = 0;
  boolean f = false;
  
  public b(com.badlogic.gdx.c.a parama, boolean paramBoolean)
  {
    this.a = parama;
    this.c = paramBoolean;
  }
  
  public void a(int paramInt)
  {
    if (!this.f) {
      throw new com.badlogic.gdx.utils.f("Call prepare() before calling consumeCompressedData()");
    }
    if ((!g.b.a("GL_OES_compressed_ETC1_RGB8_texture")) || (!g.b.a()))
    {
      k localk = ETC1.a(this.b, m.d);
      g.g.glTexImage2D(paramInt, 0, localk.f(), localk.b(), localk.d(), 0, localk.e(), localk.g(), localk.h());
      if (this.c) {
        i.a(paramInt, localk, localk.b(), localk.d());
      }
      localk.c();
      this.c = false;
    }
    for (;;)
    {
      this.b.c();
      this.b = null;
      this.f = false;
      return;
      g.g.glCompressedTexImage2D(paramInt, 0, ETC1.b, this.d, this.e, 0, this.b.c.capacity() - this.b.d, this.b.c);
      if (h()) {
        g.j.glGenerateMipmap(3553);
      }
    }
  }
  
  public boolean a()
  {
    return this.f;
  }
  
  public void b()
  {
    if (this.f) {
      throw new com.badlogic.gdx.utils.f("Already prepared");
    }
    if ((this.a == null) && (this.b == null)) {
      throw new com.badlogic.gdx.utils.f("Can only load once from ETC1Data");
    }
    if (this.a != null) {
      this.b = new a(this.a);
    }
    this.d = this.b.a;
    this.e = this.b.b;
    this.f = true;
  }
  
  public k c()
  {
    throw new com.badlogic.gdx.utils.f("This TextureData implementation does not return a Pixmap");
  }
  
  public boolean d()
  {
    throw new com.badlogic.gdx.utils.f("This TextureData implementation does not return a Pixmap");
  }
  
  public int e()
  {
    return this.d;
  }
  
  public int f()
  {
    return this.e;
  }
  
  public m g()
  {
    return m.d;
  }
  
  public boolean h()
  {
    return this.c;
  }
  
  public boolean i()
  {
    return true;
  }
  
  public u j()
  {
    return u.b;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/badlogic/gdx/graphics/glutils/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */