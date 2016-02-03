package com.badlogic.gdx.a;

public class g
{
  Object a;
  int b = 1;
  
  public g(Object paramObject)
  {
    if (paramObject == null) {
      throw new IllegalArgumentException("Object must not be null");
    }
    this.a = paramObject;
  }
  
  public <T> T a(Class<T> paramClass)
  {
    return (T)this.a;
  }
  
  public void a()
  {
    this.b += 1;
  }
  
  public void a(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void b()
  {
    this.b -= 1;
  }
  
  public int c()
  {
    return this.b;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/badlogic/gdx/a/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */