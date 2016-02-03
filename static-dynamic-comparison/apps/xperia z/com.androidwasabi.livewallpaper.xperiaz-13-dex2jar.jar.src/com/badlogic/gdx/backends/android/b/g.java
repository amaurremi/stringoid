package com.badlogic.gdx.backends.android.b;

import java.nio.Buffer;
import java.nio.ByteBuffer;

class g
{
  public int a;
  public int b;
  public int c;
  public Buffer d;
  public ByteBuffer e;
  
  public g(f paramf, int paramInt1, int paramInt2, int paramInt3, Buffer paramBuffer)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    this.d = paramBuffer;
  }
  
  public int a()
  {
    if (this.c > 0) {
      return this.c;
    }
    return a(this.b) * this.a;
  }
  
  public int a(int paramInt)
  {
    int i = 1;
    switch (paramInt)
    {
    default: 
      i = 0;
    case 5120: 
    case 5121: 
      return i;
    case 5122: 
      return 2;
    case 5132: 
      return 4;
    }
    return 4;
  }
  
  public void b()
  {
    this.e = this.f.a(-1, this.d);
  }
  
  public void c()
  {
    this.e = null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/badlogic/gdx/backends/android/b/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */