package com.badlogic.gdx.graphics.glutils;

import com.badlogic.gdx.g;
import com.badlogic.gdx.graphics.d;
import com.badlogic.gdx.graphics.e;
import com.badlogic.gdx.utils.BufferUtils;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;

public class f
  implements h
{
  static final IntBuffer a = BufferUtils.c(1);
  ShortBuffer b;
  ByteBuffer c;
  int d;
  final boolean e;
  boolean f = true;
  boolean g = false;
  final int h;
  
  public f(boolean paramBoolean, int paramInt)
  {
    this.c = BufferUtils.d(paramInt * 2);
    this.e = true;
    this.b = this.c.asShortBuffer();
    this.b.flip();
    this.c.flip();
    this.d = g();
    if (paramBoolean) {}
    for (paramInt = 35044;; paramInt = 35048)
    {
      this.h = paramInt;
      return;
    }
  }
  
  private int g()
  {
    if (g.j != null)
    {
      g.j.glGenBuffers(1, a);
      return a.get(0);
    }
    if (g.i != null)
    {
      g.i.b(1, a);
      return a.get(0);
    }
    throw new com.badlogic.gdx.utils.f("Can not use IndexBufferObject with GLES 1.0, need 1.1 or 2.0");
  }
  
  public int a()
  {
    return this.b.limit();
  }
  
  public void a(short[] paramArrayOfShort, int paramInt1, int paramInt2)
  {
    this.f = true;
    this.b.clear();
    this.b.put(paramArrayOfShort, paramInt1, paramInt2);
    this.b.flip();
    this.c.position(0);
    this.c.limit(paramInt2 << 1);
    if (this.g)
    {
      if (g.i == null) {
        break label96;
      }
      g.i.a(34963, this.c.limit(), this.c, this.h);
    }
    for (;;)
    {
      this.f = false;
      return;
      label96:
      if (g.j != null) {
        g.j.glBufferData(34963, this.c.limit(), this.c, this.h);
      }
    }
  }
  
  public ShortBuffer b()
  {
    this.f = true;
    return this.b;
  }
  
  public void c()
  {
    Object localObject;
    if (g.j != null)
    {
      a.clear();
      a.put(this.d);
      a.flip();
      localObject = g.j;
      ((e)localObject).glBindBuffer(34963, 0);
      ((e)localObject).glDeleteBuffers(1, a);
      this.d = 0;
    }
    for (;;)
    {
      BufferUtils.a(this.c);
      return;
      if (g.i != null)
      {
        a.clear();
        a.put(this.d);
        a.flip();
        localObject = g.i;
        ((d)localObject).a(34963, 0);
        ((d)localObject).a(1, a);
        this.d = 0;
      }
    }
  }
  
  public void d()
  {
    if (this.d == 0) {
      throw new com.badlogic.gdx.utils.f("No buffer allocated!");
    }
    Object localObject;
    if (g.i != null)
    {
      localObject = g.i;
      ((d)localObject).a(34963, this.d);
      if (this.f)
      {
        this.c.limit(this.b.limit() * 2);
        ((d)localObject).a(34963, this.c.limit(), this.c, this.h);
        this.f = false;
      }
    }
    for (;;)
    {
      this.g = true;
      return;
      localObject = g.j;
      ((e)localObject).glBindBuffer(34963, this.d);
      if (this.f)
      {
        this.c.limit(this.b.limit() * 2);
        ((e)localObject).glBufferData(34963, this.c.limit(), this.c, this.h);
        this.f = false;
      }
    }
  }
  
  public void e()
  {
    if (g.i != null) {
      g.i.a(34963, 0);
    }
    for (;;)
    {
      this.g = false;
      return;
      if (g.j != null) {
        g.j.glBindBuffer(34963, 0);
      }
    }
  }
  
  public void f()
  {
    this.d = g();
    this.f = true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/badlogic/gdx/graphics/glutils/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */