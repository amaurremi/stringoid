package com.badlogic.gdx.graphics;

public final class v
{
  public final int a;
  public final int b;
  public int c;
  public String d;
  public int e;
  private final int f;
  
  public v(int paramInt1, int paramInt2, String paramString)
  {
    this(paramInt1, paramInt2, paramString, 0);
  }
  
  public v(int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.d = paramString;
    this.e = paramInt3;
    this.f = Integer.numberOfTrailingZeros(paramInt1);
  }
  
  public boolean a(v paramv)
  {
    return (paramv != null) && (this.a == paramv.a) && (this.b == paramv.b) && (this.d.equals(paramv.d)) && (this.e == paramv.e);
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof v)) {
      return false;
    }
    return a((v)paramObject);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/badlogic/gdx/graphics/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */