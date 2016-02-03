package com.badlogic.gdx.graphics.glutils;

import com.badlogic.gdx.graphics.d;
import com.badlogic.gdx.graphics.e;
import com.badlogic.gdx.utils.BufferUtils;
import com.badlogic.gdx.utils.f;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;

public class g
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
  
  public g(boolean paramBoolean, int paramInt)
  {
    this.c = BufferUtils.b(paramInt * 2);
    this.e = true;
    if (paramBoolean) {}
    for (paramInt = 35044;; paramInt = 35048)
    {
      this.h = paramInt;
      this.b = this.c.asShortBuffer();
      this.b.flip();
      this.c.flip();
      this.d = g();
      return;
    }
  }
  
  private int g()
  {
    int i = 0;
    if (com.badlogic.gdx.g.j != null)
    {
      com.badlogic.gdx.g.j.glGenBuffers(1, a);
      com.badlogic.gdx.g.j.glBindBuffer(34963, a.get(0));
      com.badlogic.gdx.g.j.glBufferData(34963, this.c.capacity(), null, this.h);
      com.badlogic.gdx.g.j.glBindBuffer(34963, 0);
      i = a.get(0);
    }
    while (com.badlogic.gdx.g.i == null) {
      return i;
    }
    com.badlogic.gdx.g.i.b(1, a);
    com.badlogic.gdx.g.i.a(34963, a.get(0));
    com.badlogic.gdx.g.i.a(34963, this.c.capacity(), null, this.h);
    com.badlogic.gdx.g.i.a(34963, 0);
    return a.get(0);
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
      if (com.badlogic.gdx.g.i == null) {
        break label93;
      }
      com.badlogic.gdx.g.i.d(34963, 0, this.c.limit(), this.c);
    }
    for (;;)
    {
      this.f = false;
      return;
      label93:
      if (com.badlogic.gdx.g.j != null) {
        com.badlogic.gdx.g.j.glBufferSubData(34963, 0, this.c.limit(), this.c);
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
    if (com.badlogic.gdx.g.j != null)
    {
      a.clear();
      a.put(this.d);
      a.flip();
      localObject = com.badlogic.gdx.g.j;
      ((e)localObject).glBindBuffer(34963, 0);
      ((e)localObject).glDeleteBuffers(1, a);
      this.d = 0;
    }
    while (com.badlogic.gdx.g.i == null) {
      return;
    }
    a.clear();
    a.put(this.d);
    a.flip();
    Object localObject = com.badlogic.gdx.g.i;
    ((d)localObject).a(34963, 0);
    ((d)localObject).a(1, a);
    this.d = 0;
  }
  
  public void d()
  {
    if (this.d == 0) {
      throw new f("buuh");
    }
    Object localObject;
    if (com.badlogic.gdx.g.i != null)
    {
      localObject = com.badlogic.gdx.g.i;
      ((d)localObject).a(34963, this.d);
      if (this.f)
      {
        this.c.limit(this.b.limit() * 2);
        ((d)localObject).d(34963, 0, this.c.limit(), this.c);
        this.f = false;
      }
    }
    for (;;)
    {
      this.g = true;
      return;
      localObject = com.badlogic.gdx.g.j;
      ((e)localObject).glBindBuffer(34963, this.d);
      if (this.f)
      {
        this.c.limit(this.b.limit() * 2);
        ((e)localObject).glBufferSubData(34963, 0, this.c.limit(), this.c);
        this.f = false;
      }
    }
  }
  
  public void e()
  {
    if (com.badlogic.gdx.g.i != null) {
      com.badlogic.gdx.g.i.a(34963, 0);
    }
    for (;;)
    {
      this.g = false;
      return;
      if (com.badlogic.gdx.g.j != null) {
        com.badlogic.gdx.g.j.glBindBuffer(34963, 0);
      }
    }
  }
  
  public void f()
  {
    this.d = g();
    this.f = true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/badlogic/gdx/graphics/glutils/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */