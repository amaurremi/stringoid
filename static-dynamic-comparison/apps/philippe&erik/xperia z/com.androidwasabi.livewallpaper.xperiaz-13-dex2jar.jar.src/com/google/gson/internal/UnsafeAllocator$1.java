package com.google.gson.internal;

import java.lang.reflect.Method;

final class UnsafeAllocator$1
  extends UnsafeAllocator
{
  UnsafeAllocator$1(Method paramMethod, Object paramObject) {}
  
  public <T> T newInstance(Class<T> paramClass)
  {
    return (T)this.val$allocateInstance.invoke(this.val$unsafe, new Object[] { paramClass });
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/google/gson/internal/UnsafeAllocator$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */