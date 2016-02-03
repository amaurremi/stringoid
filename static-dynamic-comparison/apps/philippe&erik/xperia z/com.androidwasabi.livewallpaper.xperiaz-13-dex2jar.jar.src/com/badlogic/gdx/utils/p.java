package com.badlogic.gdx.utils;

public abstract class p<T>
{
  private final a<T> a;
  public final int b;
  public int c;
  
  public p(int paramInt1, int paramInt2)
  {
    this.a = new a(false, paramInt1);
    this.b = paramInt2;
  }
  
  public void a(T paramT)
  {
    if (paramT == null) {
      throw new IllegalArgumentException("object cannot be null.");
    }
    if (this.a.b < this.b)
    {
      this.a.a(paramT);
      this.c = Math.max(this.c, this.a.b);
    }
    if ((paramT instanceof q)) {
      ((q)paramT).a();
    }
  }
  
  protected abstract T b();
  
  public T c()
  {
    if (this.a.b == 0) {
      return (T)b();
    }
    return (T)this.a.a();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/badlogic/gdx/utils/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */