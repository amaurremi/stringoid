package com.google.api.client.util;

import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.TypeVariable<*>;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public class ae
{
  public static Class<?> a(ParameterizedType paramParameterizedType)
  {
    return (Class)paramParameterizedType.getRawType();
  }
  
  private static IllegalArgumentException a(Exception paramException, Class<?> paramClass)
  {
    StringBuilder localStringBuilder = new StringBuilder("unable to create new instance of class ").append(paramClass.getName());
    Object localObject = new ArrayList();
    int i;
    if (paramClass.isArray())
    {
      ((ArrayList)localObject).add("because it is an array");
      paramClass = ((ArrayList)localObject).iterator();
      i = 0;
      label49:
      if (!paramClass.hasNext()) {
        break label244;
      }
      localObject = (String)paramClass.next();
      if (i == 0) {
        break label239;
      }
      localStringBuilder.append(" and");
    }
    for (;;)
    {
      localStringBuilder.append(" ").append((String)localObject);
      break label49;
      if (paramClass.isPrimitive())
      {
        ((ArrayList)localObject).add("because it is primitive");
        break;
      }
      if (paramClass == Void.class)
      {
        ((ArrayList)localObject).add("because it is void");
        break;
      }
      if (Modifier.isInterface(paramClass.getModifiers())) {
        ((ArrayList)localObject).add("because it is an interface");
      }
      for (;;)
      {
        if ((paramClass.getEnclosingClass() != null) && (!Modifier.isStatic(paramClass.getModifiers()))) {
          ((ArrayList)localObject).add("because it is not static");
        }
        if (Modifier.isPublic(paramClass.getModifiers())) {
          break label215;
        }
        ((ArrayList)localObject).add("possibly because it is not public");
        break;
        if (Modifier.isAbstract(paramClass.getModifiers())) {
          ((ArrayList)localObject).add("because it is abstract");
        }
      }
      try
      {
        label215:
        paramClass.getConstructor(new Class[0]);
      }
      catch (NoSuchMethodException paramClass)
      {
        ((ArrayList)localObject).add("because it has no accessible default constructor");
      }
      break;
      label239:
      i = 1;
    }
    label244:
    return new IllegalArgumentException(localStringBuilder.toString(), paramException);
  }
  
  public static Object a(Collection<?> paramCollection, Class<?> paramClass)
  {
    if (paramClass.isPrimitive())
    {
      paramClass = Array.newInstance(paramClass, paramCollection.size());
      int i = 0;
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext())
      {
        Array.set(paramClass, i, paramCollection.next());
        i += 1;
      }
      return paramClass;
    }
    return paramCollection.toArray((Object[])Array.newInstance(paramClass, paramCollection.size()));
  }
  
  public static ParameterizedType a(Type paramType, Class<?> paramClass)
  {
    if (((paramType instanceof Class)) || ((paramType instanceof ParameterizedType))) {
      if ((paramType != null) && (paramType != Object.class)) {
        if (!(paramType instanceof Class)) {}
      }
    }
    Class localClass;
    for (paramType = (Class)paramType;; paramType = localClass)
    {
      paramType = paramType.getGenericSuperclass();
      break;
      paramType = (ParameterizedType)paramType;
      localClass = a(paramType);
      if (localClass == paramClass) {
        return paramType;
      }
      if (paramClass.isInterface())
      {
        Type[] arrayOfType = localClass.getGenericInterfaces();
        int j = arrayOfType.length;
        int i = 0;
        for (;;)
        {
          if (i < j)
          {
            Type localType = arrayOfType[i];
            if ((localType instanceof Class)) {}
            for (paramType = (Class)localType;; paramType = a((ParameterizedType)localType))
            {
              if (!paramClass.isAssignableFrom(paramType)) {
                break label134;
              }
              paramType = localType;
              break;
            }
            label134:
            i += 1;
            continue;
            return null;
          }
        }
      }
    }
  }
  
  private static Type a(Type paramType, Class<?> paramClass, int paramInt)
  {
    Type localType = a(paramType, paramClass).getActualTypeArguments()[paramInt];
    paramClass = localType;
    if ((localType instanceof TypeVariable))
    {
      paramType = a(Arrays.asList(new Type[] { paramType }), (TypeVariable)localType);
      paramClass = localType;
      if (paramType != null) {
        paramClass = paramType;
      }
    }
    return paramClass;
  }
  
  public static Type a(WildcardType paramWildcardType)
  {
    Type[] arrayOfType = paramWildcardType.getLowerBounds();
    if (arrayOfType.length != 0) {
      return arrayOfType[0];
    }
    return paramWildcardType.getUpperBounds()[0];
  }
  
  public static Type a(List<Type> paramList, TypeVariable<?> paramTypeVariable)
  {
    Object localObject2 = paramTypeVariable.getGenericDeclaration();
    if ((localObject2 instanceof Class))
    {
      Class localClass = (Class)localObject2;
      int i = paramList.size();
      for (Object localObject1 = null; localObject1 == null; localObject1 = a((Type)paramList.get(i), localClass))
      {
        i -= 1;
        if (i < 0) {
          break;
        }
      }
      if (localObject1 != null)
      {
        localObject2 = ((GenericDeclaration)localObject2).getTypeParameters();
        i = 0;
        for (;;)
        {
          if ((i >= localObject2.length) || (localObject2[i].equals(paramTypeVariable)))
          {
            localObject1 = localObject1.getActualTypeArguments()[i];
            paramTypeVariable = (TypeVariable<?>)localObject1;
            if ((localObject1 instanceof TypeVariable))
            {
              paramList = a(paramList, (TypeVariable)localObject1);
              paramTypeVariable = (TypeVariable<?>)localObject1;
              if (paramList != null) {
                paramTypeVariable = paramList;
              }
            }
            return paramTypeVariable;
          }
          i += 1;
        }
      }
    }
    return null;
  }
  
  public static boolean a(Class<?> paramClass1, Class<?> paramClass2)
  {
    return (paramClass1.isAssignableFrom(paramClass2)) || (paramClass2.isAssignableFrom(paramClass1));
  }
  
  public static <T> Iterable<T> ak(Object paramObject)
  {
    if ((paramObject instanceof Iterable)) {
      return (Iterable)paramObject;
    }
    Class localClass = paramObject.getClass();
    x.b(localClass.isArray(), "not an array or Iterable: %s", new Object[] { localClass });
    if (!localClass.getComponentType().isPrimitive()) {
      return Arrays.asList((Object[])paramObject);
    }
    new Iterable()
    {
      public Iterator<T> iterator()
      {
        new Iterator()
        {
          int index = 0;
          final int length = Array.getLength(ae.1.this.aeh);
          
          public boolean hasNext()
          {
            return this.index < this.length;
          }
          
          public T next()
          {
            if (!hasNext()) {
              throw new NoSuchElementException();
            }
            Object localObject = ae.1.this.aeh;
            int i = this.index;
            this.index = (i + 1);
            return (T)Array.get(localObject, i);
          }
          
          public void remove()
          {
            throw new UnsupportedOperationException();
          }
        };
      }
    };
  }
  
  public static Class<?> b(List<Type> paramList, Type paramType)
  {
    if ((paramType instanceof TypeVariable)) {
      paramType = a(paramList, (TypeVariable)paramType);
    }
    for (;;)
    {
      if ((paramType instanceof GenericArrayType)) {
        return Array.newInstance(b(paramList, d(paramType)), 0).getClass();
      }
      if ((paramType instanceof Class)) {
        return (Class)paramType;
      }
      if ((paramType instanceof ParameterizedType)) {
        return a((ParameterizedType)paramType);
      }
      if (paramType == null) {}
      for (boolean bool = true;; bool = false)
      {
        x.b(bool, "wildcard type is not supported: %s", new Object[] { paramType });
        return Object.class;
      }
    }
  }
  
  public static boolean c(Type paramType)
  {
    return ((paramType instanceof GenericArrayType)) || (((paramType instanceof Class)) && (((Class)paramType).isArray()));
  }
  
  public static Type d(Type paramType)
  {
    if ((paramType instanceof GenericArrayType)) {
      return ((GenericArrayType)paramType).getGenericComponentType();
    }
    return ((Class)paramType).getComponentType();
  }
  
  public static Type e(Type paramType)
  {
    return a(paramType, Iterable.class, 0);
  }
  
  public static Type f(Type paramType)
  {
    return a(paramType, Map.class, 1);
  }
  
  public static <T> T l(Class<T> paramClass)
  {
    try
    {
      Object localObject = paramClass.newInstance();
      return (T)localObject;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw a(localIllegalAccessException, paramClass);
    }
    catch (InstantiationException localInstantiationException)
    {
      throw a(localInstantiationException, paramClass);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/api/client/util/ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */