package com.google.gson.internal;

import com.google.gson.InstanceCreator;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Constructor;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedSet;

public final class ConstructorConstructor
{
  private final Map<Type, InstanceCreator<?>> instanceCreators;
  
  public ConstructorConstructor()
  {
    this(Collections.emptyMap());
  }
  
  public ConstructorConstructor(Map<Type, InstanceCreator<?>> paramMap)
  {
    this.instanceCreators = paramMap;
  }
  
  private <T> ObjectConstructor<T> newDefaultConstructor(Class<? super T> paramClass)
  {
    try
    {
      paramClass = paramClass.getDeclaredConstructor(new Class[0]);
      if (!paramClass.isAccessible()) {
        paramClass.setAccessible(true);
      }
      paramClass = new ConstructorConstructor.2(this, paramClass);
      return paramClass;
    }
    catch (NoSuchMethodException paramClass) {}
    return null;
  }
  
  private <T> ObjectConstructor<T> newDefaultImplementationConstructor(Class<? super T> paramClass)
  {
    if (Collection.class.isAssignableFrom(paramClass))
    {
      if (SortedSet.class.isAssignableFrom(paramClass)) {
        return new ConstructorConstructor.3(this);
      }
      if (Set.class.isAssignableFrom(paramClass)) {
        return new ConstructorConstructor.4(this);
      }
      if (Queue.class.isAssignableFrom(paramClass)) {
        return new ConstructorConstructor.5(this);
      }
      return new ConstructorConstructor.6(this);
    }
    if (Map.class.isAssignableFrom(paramClass)) {
      return new ConstructorConstructor.7(this);
    }
    return null;
  }
  
  private <T> ObjectConstructor<T> newUnsafeAllocator(Type paramType, Class<? super T> paramClass)
  {
    return new ConstructorConstructor.8(this, paramClass, paramType);
  }
  
  public <T> ObjectConstructor<T> get(TypeToken<T> paramTypeToken)
  {
    Type localType = paramTypeToken.getType();
    Class localClass = paramTypeToken.getRawType();
    paramTypeToken = (InstanceCreator)this.instanceCreators.get(localType);
    if (paramTypeToken != null) {
      paramTypeToken = new ConstructorConstructor.1(this, paramTypeToken, localType);
    }
    ObjectConstructor localObjectConstructor;
    do
    {
      do
      {
        return paramTypeToken;
        localObjectConstructor = newDefaultConstructor(localClass);
        paramTypeToken = localObjectConstructor;
      } while (localObjectConstructor != null);
      localObjectConstructor = newDefaultImplementationConstructor(localClass);
      paramTypeToken = localObjectConstructor;
    } while (localObjectConstructor != null);
    return newUnsafeAllocator(localType, localClass);
  }
  
  public String toString()
  {
    return this.instanceCreators.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/google/gson/internal/ConstructorConstructor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */