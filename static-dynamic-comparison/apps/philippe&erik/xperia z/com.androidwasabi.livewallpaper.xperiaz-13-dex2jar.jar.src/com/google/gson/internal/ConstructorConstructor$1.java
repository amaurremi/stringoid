package com.google.gson.internal;

import com.google.gson.InstanceCreator;
import java.lang.reflect.Type;

class ConstructorConstructor$1
  implements ObjectConstructor<T>
{
  ConstructorConstructor$1(ConstructorConstructor paramConstructorConstructor, InstanceCreator paramInstanceCreator, Type paramType) {}
  
  public T construct()
  {
    return (T)this.val$creator.createInstance(this.val$type);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/google/gson/internal/ConstructorConstructor$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */