package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeBindings;
import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.lang.reflect.Type;

public final class AnnotatedConstructor
  extends AnnotatedWithParams
{
  protected final Constructor<?> _constructor;
  
  public AnnotatedConstructor(Constructor<?> paramConstructor, AnnotationMap paramAnnotationMap, AnnotationMap[] paramArrayOfAnnotationMap)
  {
    super(paramAnnotationMap, paramArrayOfAnnotationMap);
    if (paramConstructor == null) {
      throw new IllegalArgumentException("Null constructor not allowed");
    }
    this._constructor = paramConstructor;
  }
  
  public final Object call()
  {
    return this._constructor.newInstance(new Object[0]);
  }
  
  public final Object call(Object[] paramArrayOfObject)
  {
    return this._constructor.newInstance(paramArrayOfObject);
  }
  
  public final Object call1(Object paramObject)
  {
    return this._constructor.newInstance(new Object[] { paramObject });
  }
  
  public Constructor<?> getAnnotated()
  {
    return this._constructor;
  }
  
  public Class<?> getDeclaringClass()
  {
    return this._constructor.getDeclaringClass();
  }
  
  public Type getGenericParameterType(int paramInt)
  {
    Type[] arrayOfType = this._constructor.getGenericParameterTypes();
    if (paramInt >= arrayOfType.length) {
      return null;
    }
    return arrayOfType[paramInt];
  }
  
  public Type getGenericType()
  {
    return getRawType();
  }
  
  public Member getMember()
  {
    return this._constructor;
  }
  
  public String getName()
  {
    return this._constructor.getName();
  }
  
  public int getParameterCount()
  {
    return this._constructor.getParameterTypes().length;
  }
  
  public Class<?> getRawParameterType(int paramInt)
  {
    Class[] arrayOfClass = this._constructor.getParameterTypes();
    if (paramInt >= arrayOfClass.length) {
      return null;
    }
    return arrayOfClass[paramInt];
  }
  
  public Class<?> getRawType()
  {
    return this._constructor.getDeclaringClass();
  }
  
  public JavaType getType(TypeBindings paramTypeBindings)
  {
    return getType(paramTypeBindings, this._constructor.getTypeParameters());
  }
  
  public Object getValue(Object paramObject)
  {
    throw new UnsupportedOperationException("Cannot call getValue() on constructor of " + getDeclaringClass().getName());
  }
  
  public void setValue(Object paramObject1, Object paramObject2)
  {
    throw new UnsupportedOperationException("Cannot call setValue() on constructor of " + getDeclaringClass().getName());
  }
  
  public String toString()
  {
    return "[constructor for " + getName() + ", annotations: " + this._annotations + "]";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/introspect/AnnotatedConstructor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */