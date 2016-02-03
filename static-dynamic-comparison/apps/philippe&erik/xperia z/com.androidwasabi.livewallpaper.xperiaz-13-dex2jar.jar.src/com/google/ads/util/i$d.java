package com.google.ads.util;

import java.lang.ref.WeakReference;

public final class i$d<T>
  extends i.a<WeakReference<T>>
{
  public i$d(String paramString, T paramT)
  {
    super(paramString, paramT, new WeakReference(localObject), null);
  }
  
  public T a()
  {
    return (T)((WeakReference)this.a).get();
  }
  
  public String toString()
  {
    return this.d.toString() + "." + this.b + " = " + a() + " (?)";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/google/ads/util/i$d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */