package com.badlogic.gdx.graphics.glutils;

import com.badlogic.gdx.utils.BufferUtils;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;

public class e
  implements h
{
  static final IntBuffer a = BufferUtils.c(1);
  ShortBuffer b;
  ByteBuffer c;
  
  public e(int paramInt)
  {
    this.c = BufferUtils.d(paramInt * 2);
    this.b = this.c.asShortBuffer();
    this.b.flip();
    this.c.flip();
  }
  
  public int a()
  {
    return this.b.limit();
  }
  
  public void a(short[] paramArrayOfShort, int paramInt1, int paramInt2)
  {
    this.b.clear();
    this.b.put(paramArrayOfShort, paramInt1, paramInt2);
    this.b.flip();
    this.c.position(0);
    this.c.limit(paramInt2 << 1);
  }
  
  public ShortBuffer b()
  {
    return this.b;
  }
  
  public void c()
  {
    BufferUtils.a(this.c);
  }
  
  public void d() {}
  
  public void e() {}
  
  public void f() {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/badlogic/gdx/graphics/glutils/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */