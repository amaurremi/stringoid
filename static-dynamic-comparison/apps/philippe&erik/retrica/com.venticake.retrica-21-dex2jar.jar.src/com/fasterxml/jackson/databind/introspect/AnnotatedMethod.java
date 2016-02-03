package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeBindings;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

public final class AnnotatedMethod
  extends AnnotatedWithParams
  implements Serializable
{
  protected final transient Method _method;
  protected Class<?>[] _paramClasses;
  
  public AnnotatedMethod(Method paramMethod, AnnotationMap paramAnnotationMap, AnnotationMap[] paramArrayOfAnnotationMap)
  {
    super(paramAnnotationMap, paramArrayOfAnnotationMap);
    if (paramMethod == null) {
      throw new IllegalArgumentException("Can not construct AnnotatedMethod with null Method");
    }
    this._method = paramMethod;
  }
  
  public final Object call()
  {
    return this._method.invoke(null, new Object[0]);
  }
  
  public final Object call(Object[] paramArrayOfObject)
  {
    return this._method.invoke(null, paramArrayOfObject);
  }
  
  public final Object call1(Object paramObject)
  {
    return this._method.invoke(null, new Object[] { paramObject });
  }
  
  public Method getAnnotated()
  {
    return this._method;
  }
  
  public Class<?> getDeclaringClass()
  {
    return this._method.getDeclaringClass();
  }
  
  public String getFullName()
  {
    return getDeclaringClass().getName() + "#" + getName() + "(" + getParameterCount() + " params)";
  }
  
  public Type getGenericParameterType(int paramInt)
  {
    Type[] arrayOfType = this._method.getGenericParameterTypes();
    if (paramInt >= arrayOfType.length) {
      return null;
    }
    return arrayOfType[paramInt];
  }
  
  public Type getGenericType()
  {
    return this._method.getGenericReturnType();
  }
  
  public Method getMember()
  {
    return this._method;
  }
  
  public String getName()
  {
    return this._method.getName();
  }
  
  public int getParameterCount()
  {
    return getRawParameterTypes().length;
  }
  
  public Class<?> getRawParameterType(int paramInt)
  {
    Class[] arrayOfClass = getRawParameterTypes();
    if (paramInt >= arrayOfClass.length) {
      return null;
    }
    return arrayOfClass[paramInt];
  }
  
  public Class<?>[] getRawParameterTypes()
  {
    if (this._paramClasses == null) {
      this._paramClasses = this._method.getParameterTypes();
    }
    return this._paramClasses;
  }
  
  public Class<?> getRawReturnType()
  {
    return this._method.getReturnType();
  }
  
  public Class<?> getRawType()
  {
    return this._method.getReturnType();
  }
  
  public JavaType getType(TypeBindings paramTypeBindings)
  {
    return getType(paramTypeBindings, this._method.getTypeParameters());
  }
  
  public Object getValue(Object paramObject)
  {
    try
    {
      paramObject = this._method.invoke(paramObject, new Object[0]);
      return paramObject;
    }
    catch (IllegalAccessException paramObject)
    {
      throw new IllegalArgumentException("Failed to getValue() with method " + getFullName() + ": " + ((IllegalAccessException)paramObject).getMessage(), (Throwable)paramObject);
    }
    catch (InvocationTargetException paramObject)
    {
      throw new IllegalArgumentException("Failed to getValue() with method " + getFullName() + ": " + ((InvocationTargetException)paramObject).getMessage(), (Throwable)paramObject);
    }
  }
  
  public void setValue(Object paramObject1, Object paramObject2)
  {
    try
    {
      this._method.invoke(paramObject1, new Object[] { paramObject2 });
      return;
    }
    catch (IllegalAccessException paramObject1)
    {
      throw new IllegalArgumentException("Failed to setValue() with method " + getFullName() + ": " + ((IllegalAccessException)paramObject1).getMessage(), (Throwable)paramObject1);
    }
    catch (InvocationTargetException paramObject1)
    {
      throw new IllegalArgumentException("Failed to setValue() with method " + getFullName() + ": " + ((InvocationTargetException)paramObject1).getMessage(), (Throwable)paramObject1);
    }
  }
  
  public String toString()
  {
    return "[method " + getFullName() + "]";
  }
  
  public AnnotatedMethod withAnnotations(AnnotationMap paramAnnotationMap)
  {
    return new AnnotatedMethod(this._method, paramAnnotationMap, this._paramAnnotations);
  }
  
  public AnnotatedMethod withMethod(Method paramMethod)
  {
    return new AnnotatedMethod(paramMethod, this._annotations, this._paramAnnotations);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/introspect/AnnotatedMethod.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */