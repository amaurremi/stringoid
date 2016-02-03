package com.google.gson.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

class ConstructorConstructor$2
  implements ObjectConstructor<T>
{
  ConstructorConstructor$2(ConstructorConstructor paramConstructorConstructor, Constructor paramConstructor) {}
  
  public T construct()
  {
    try
    {
      Object localObject = this.val$constructor.newInstance(null);
      return (T)localObject;
    }
    catch (InstantiationException localInstantiationException)
    {
      throw new RuntimeException("Failed to invoke " + this.val$constructor + " with no args", localInstantiationException);
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      throw new RuntimeException("Failed to invoke " + this.val$constructor + " with no args", localInvocationTargetException.getTargetException());
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw new AssertionError(localIllegalAccessException);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/google/gson/internal/ConstructorConstructor$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */