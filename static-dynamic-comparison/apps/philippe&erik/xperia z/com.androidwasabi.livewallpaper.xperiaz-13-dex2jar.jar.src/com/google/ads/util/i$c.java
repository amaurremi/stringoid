package com.google.ads.util;

public final class i$c<T>
  extends i.a<T>
{
  private boolean e = false;
  
  public i$c(i parami, String paramString)
  {
    super(parami, paramString, null);
  }
  
  public i$c(String paramString, T paramT)
  {
    super(paramString, paramT, localObject, null);
  }
  
  public T a()
  {
    try
    {
      Object localObject1 = this.a;
      return (T)localObject1;
    }
    finally
    {
      localObject2 = finally;
      throw ((Throwable)localObject2);
    }
  }
  
  public void a(T paramT)
  {
    try
    {
      b.d("State changed - " + this.d.toString() + "." + this.b + ": '" + paramT + "' <-- '" + this.a + "'.");
      this.a = paramT;
      this.e = true;
      return;
    }
    finally
    {
      paramT = finally;
      throw paramT;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append(super.toString());
    if (this.e) {}
    for (String str = " (*)";; str = "") {
      return str;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/google/ads/util/i$c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */