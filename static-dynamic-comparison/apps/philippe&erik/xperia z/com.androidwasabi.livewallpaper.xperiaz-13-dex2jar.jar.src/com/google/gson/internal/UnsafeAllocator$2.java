package com.google.gson.internal;

import java.lang.reflect.Method;

final class UnsafeAllocator$2
  extends UnsafeAllocator
{
  UnsafeAllocator$2(Method paramMethod) {}
  
  public <T> T newInstance(Class<T> paramClass)
  {
    return (T)this.val$newInstance.invoke(null, new Object[] { paramClass, Object.class });
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/google/gson/internal/UnsafeAllocator$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */