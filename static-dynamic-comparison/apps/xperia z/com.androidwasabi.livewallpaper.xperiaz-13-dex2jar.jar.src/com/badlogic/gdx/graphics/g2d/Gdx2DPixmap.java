package com.badlogic.gdx.graphics.g2d;

import com.badlogic.gdx.utils.d;
import com.badlogic.gdx.utils.f;
import java.io.IOException;
import java.nio.ByteBuffer;

public class Gdx2DPixmap
  implements d
{
  final long a;
  final int b;
  final int c;
  final int d;
  final ByteBuffer e;
  final long[] f = new long[4];
  
  static
  {
    setBlend(1);
    setScale(1);
  }
  
  public Gdx2DPixmap(int paramInt1, int paramInt2, int paramInt3)
  {
    this.e = newPixmap(this.f, paramInt1, paramInt2, paramInt3);
    if (this.e == null) {
      throw new f("couldn't load pixmap");
    }
    this.a = this.f[0];
    this.b = ((int)this.f[1]);
    this.c = ((int)this.f[2]);
    this.d = ((int)this.f[3]);
  }
  
  public Gdx2DPixmap(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    this.e = load(this.f, paramArrayOfByte, paramInt1, paramInt2, paramInt3);
    if (this.e == null) {
      throw new IOException("couldn't load pixmap " + getFailureReason());
    }
    this.a = this.f[0];
    this.b = ((int)this.f[1]);
    this.c = ((int)this.f[2]);
    this.d = ((int)this.f[3]);
  }
  
  private static native void clear(long paramLong, int paramInt);
  
  private static native void drawPixmap(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8);
  
  private static native void free(long paramLong);
  
  public static native String getFailureReason();
  
  private static native ByteBuffer load(long[] paramArrayOfLong, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3);
  
  private static native ByteBuffer newPixmap(long[] paramArrayOfLong, int paramInt1, int paramInt2, int paramInt3);
  
  public static native void setBlend(int paramInt);
  
  public static native void setScale(int paramInt);
  
  public ByteBuffer a()
  {
    return this.e;
  }
  
  public void a(int paramInt)
  {
    clear(this.a, paramInt);
  }
  
  public void a(Gdx2DPixmap paramGdx2DPixmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    drawPixmap(paramGdx2DPixmap.a, this.a, paramInt1, paramInt2, paramInt5, paramInt6, paramInt3, paramInt4, paramInt5, paramInt6);
  }
  
  public void a(Gdx2DPixmap paramGdx2DPixmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    drawPixmap(paramGdx2DPixmap.a, this.a, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8);
  }
  
  public int b()
  {
    return this.c;
  }
  
  public void c()
  {
    free(this.a);
  }
  
  public int d()
  {
    return this.b;
  }
  
  public int e()
  {
    return this.d;
  }
  
  public int f()
  {
    switch (this.d)
    {
    default: 
      throw new f("unknown format: " + this.d);
    case 1: 
      return 6406;
    case 2: 
      return 6410;
    case 3: 
    case 5: 
      return 6407;
    }
    return 6408;
  }
  
  public int g()
  {
    return f();
  }
  
  public int h()
  {
    switch (this.d)
    {
    default: 
      throw new f("unknown format: " + this.d);
    case 1: 
    case 2: 
    case 3: 
    case 4: 
      return 5121;
    case 5: 
      return 33635;
    }
    return 32819;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/badlogic/gdx/graphics/g2d/Gdx2DPixmap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */