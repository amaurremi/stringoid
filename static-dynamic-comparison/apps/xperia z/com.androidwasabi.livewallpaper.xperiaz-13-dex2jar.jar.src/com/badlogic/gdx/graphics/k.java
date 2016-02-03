package com.badlogic.gdx.graphics;

import com.badlogic.gdx.c.a;
import com.badlogic.gdx.graphics.g2d.Gdx2DPixmap;
import com.badlogic.gdx.utils.d;
import com.badlogic.gdx.utils.f;
import java.io.IOException;
import java.nio.ByteBuffer;

public class k
  implements d
{
  private static l c = l.b;
  final Gdx2DPixmap a;
  int b = 0;
  private boolean d;
  
  public k(int paramInt1, int paramInt2, m paramm)
  {
    this.a = new Gdx2DPixmap(paramInt1, paramInt2, m.a(paramm));
    a(0.0F, 0.0F, 0.0F, 0.0F);
    a();
  }
  
  public k(a parama)
  {
    try
    {
      byte[] arrayOfByte = parama.g();
      this.a = new Gdx2DPixmap(arrayOfByte, 0, arrayOfByte.length, 0);
      return;
    }
    catch (Exception localException)
    {
      throw new f("Couldn't load file: " + parama, localException);
    }
  }
  
  public k(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      this.a = new Gdx2DPixmap(paramArrayOfByte, paramInt1, paramInt2, 0);
      return;
    }
    catch (IOException paramArrayOfByte)
    {
      throw new f("Couldn't load pixmap from image data", paramArrayOfByte);
    }
  }
  
  public static void a(l paraml)
  {
    c = paraml;
    if (paraml == l.a) {}
    for (int i = 0;; i = 1)
    {
      Gdx2DPixmap.setBlend(i);
      return;
    }
  }
  
  public static l j()
  {
    return c;
  }
  
  public void a()
  {
    this.a.a(this.b);
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.b = b.a(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
  }
  
  public void a(k paramk, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    this.a.a(paramk.a, paramInt3, paramInt4, paramInt1, paramInt2, paramInt5, paramInt6);
  }
  
  public void a(k paramk, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    this.a.a(paramk.a, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8);
  }
  
  public int b()
  {
    return this.a.d();
  }
  
  public void c()
  {
    if (this.d) {
      throw new f("Pixmap already disposed!");
    }
    this.a.c();
    this.d = true;
  }
  
  public int d()
  {
    return this.a.b();
  }
  
  public int e()
  {
    return this.a.g();
  }
  
  public int f()
  {
    return this.a.f();
  }
  
  public int g()
  {
    return this.a.h();
  }
  
  public ByteBuffer h()
  {
    if (this.d) {
      throw new f("Pixmap already disposed");
    }
    return this.a.a();
  }
  
  public m i()
  {
    return m.a(this.a.e());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/badlogic/gdx/graphics/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */