package com.google.ads.util;

public abstract class i$a<T>
{
  protected T a;
  protected final String b;
  
  private i$a(i parami, String paramString)
  {
    this(parami, paramString, null);
  }
  
  private i$a(String paramString, T paramT)
  {
    this.b = paramT;
    i.a(paramString, this);
    Object localObject;
    this.a = localObject;
  }
  
  public String toString()
  {
    return this.c.toString() + "." + this.b + " = " + this.a;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/google/ads/util/i$a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */