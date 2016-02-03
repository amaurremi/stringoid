package com.google.gson.internal;

import java.lang.reflect.Method;

final class UnsafeAllocator$3
  extends UnsafeAllocator
{
  UnsafeAllocator$3(Method paramMethod, int paramInt) {}
  
  public <T> T newInstance(Class<T> paramClass)
  {
    return (T)this.val$newInstance.invoke(null, new Object[] { paramClass, Integer.valueOf(this.val$constructorId) });
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/google/gson/internal/UnsafeAllocator$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */