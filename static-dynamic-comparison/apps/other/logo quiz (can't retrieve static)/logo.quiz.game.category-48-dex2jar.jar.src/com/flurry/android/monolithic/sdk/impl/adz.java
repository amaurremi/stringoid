package com.flurry.android.monolithic.sdk.impl;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class adz
{
  public static Class<? extends Enum<?>> a(Enum<?> paramEnum)
  {
    Class localClass = paramEnum.getClass();
    paramEnum = localClass;
    if (localClass.getSuperclass() != Enum.class) {
      paramEnum = localClass.getSuperclass();
    }
    return paramEnum;
  }
  
  public static Class<? extends Enum<?>> a(EnumMap<?, ?> paramEnumMap)
  {
    if (!paramEnumMap.isEmpty()) {
      return a((Enum)paramEnumMap.keySet().iterator().next());
    }
    return aea.a.a(paramEnumMap);
  }
  
  public static Class<? extends Enum<?>> a(EnumSet<?> paramEnumSet)
  {
    if (!paramEnumSet.isEmpty()) {
      return a((Enum)paramEnumSet.iterator().next());
    }
    return aea.a.a(paramEnumSet);
  }
  
  public static String a(Class<?> paramClass)
  {
    if (paramClass.isAnnotation()) {
      return "annotation";
    }
    if (paramClass.isArray()) {
      return "array";
    }
    if (paramClass.isEnum()) {
      return "enum";
    }
    if (paramClass.isPrimitive()) {
      return "primitive";
    }
    return null;
  }
  
  public static String a(Class<?> paramClass, boolean paramBoolean)
  {
    try
    {
      if (paramClass.getEnclosingMethod() != null) {
        return "local/anonymous";
      }
      if ((!paramBoolean) && (paramClass.getEnclosingClass() != null) && (!Modifier.isStatic(paramClass.getModifiers()))) {
        return "non-static member class";
      }
    }
    catch (NullPointerException paramClass)
    {
      return null;
    }
    catch (SecurityException paramClass)
    {
      for (;;) {}
    }
  }
  
  public static Throwable a(Throwable paramThrowable)
  {
    while (paramThrowable.getCause() != null) {
      paramThrowable = paramThrowable.getCause();
    }
    return paramThrowable;
  }
  
  public static List<Class<?>> a(Class<?> paramClass1, Class<?> paramClass2)
  {
    return a(paramClass1, paramClass2, new ArrayList(8));
  }
  
  public static List<Class<?>> a(Class<?> paramClass1, Class<?> paramClass2, List<Class<?>> paramList)
  {
    a(paramClass1, paramClass2, paramList, false);
    return paramList;
  }
  
  private static void a(Class<?> paramClass1, Class<?> paramClass2, Collection<Class<?>> paramCollection, boolean paramBoolean)
  {
    if ((paramClass1 == paramClass2) || (paramClass1 == null) || (paramClass1 == Object.class)) {}
    do
    {
      return;
      if (!paramBoolean) {
        break;
      }
    } while (paramCollection.contains(paramClass1));
    paramCollection.add(paramClass1);
    Class[] arrayOfClass = paramClass1.getInterfaces();
    int j = arrayOfClass.length;
    int i = 0;
    while (i < j)
    {
      a(arrayOfClass[i], paramClass2, paramCollection, true);
      i += 1;
    }
    a(paramClass1.getSuperclass(), paramClass2, paramCollection, true);
  }
  
  public static void a(Throwable paramThrowable, String paramString)
  {
    if ((paramThrowable instanceof RuntimeException)) {
      throw ((RuntimeException)paramThrowable);
    }
    if ((paramThrowable instanceof Error)) {
      throw ((Error)paramThrowable);
    }
    throw new IllegalArgumentException(paramString, paramThrowable);
  }
  
  public static void a(Member paramMember)
  {
    Object localObject = (AccessibleObject)paramMember;
    try
    {
      ((AccessibleObject)localObject).setAccessible(true);
      return;
    }
    catch (SecurityException localSecurityException)
    {
      while (((AccessibleObject)localObject).isAccessible()) {}
      localObject = paramMember.getDeclaringClass();
      throw new IllegalArgumentException("Can not access " + paramMember + " (from class " + ((Class)localObject).getName() + "; failed to set access: " + localSecurityException.getMessage());
    }
  }
  
  public static boolean a(Method paramMethod)
  {
    if (Modifier.isStatic(paramMethod.getModifiers())) {}
    Class[] arrayOfClass;
    do
    {
      return false;
      arrayOfClass = paramMethod.getParameterTypes();
    } while (((arrayOfClass != null) && (arrayOfClass.length != 0)) || (Void.TYPE == paramMethod.getReturnType()));
    return true;
  }
  
  public static Class<?> b(Class<?> paramClass)
  {
    try
    {
      if (paramClass.getEnclosingMethod() != null) {
        return null;
      }
      if (!Modifier.isStatic(paramClass.getModifiers()))
      {
        paramClass = paramClass.getEnclosingClass();
        return paramClass;
      }
    }
    catch (NullPointerException paramClass)
    {
      return null;
    }
    catch (SecurityException paramClass) {}
    return null;
  }
  
  public static <T> T b(Class<T> paramClass, boolean paramBoolean)
    throws IllegalArgumentException
  {
    Object localObject = c(paramClass, paramBoolean);
    if (localObject == null) {
      throw new IllegalArgumentException("Class " + paramClass.getName() + " has no default (no arg) constructor");
    }
    try
    {
      localObject = ((Constructor)localObject).newInstance(new Object[0]);
      return (T)localObject;
    }
    catch (Exception localException)
    {
      b(localException, "Failed to instantiate class " + paramClass.getName() + ", problem: " + localException.getMessage());
    }
    return null;
  }
  
  public static void b(Throwable paramThrowable)
  {
    a(paramThrowable, paramThrowable.getMessage());
  }
  
  public static void b(Throwable paramThrowable, String paramString)
  {
    a(a(paramThrowable), paramString);
  }
  
  public static <T> Constructor<T> c(Class<T> paramClass, boolean paramBoolean)
    throws IllegalArgumentException
  {
    try
    {
      Constructor localConstructor = paramClass.getDeclaredConstructor(new Class[0]);
      if (paramBoolean)
      {
        a(localConstructor);
        return localConstructor;
      }
      if (!Modifier.isPublic(localConstructor.getModifiers())) {
        throw new IllegalArgumentException("Default constructor for " + paramClass.getName() + " is not accessible (non-public?): not allowed to try modify access via Reflection: can not instantiate type");
      }
    }
    catch (NoSuchMethodException paramClass)
    {
      return null;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        b(localException, "Failed to find default constructor of class " + paramClass.getName() + ", problem: " + localException.getMessage());
      }
      return localException;
    }
  }
  
  public static void c(Throwable paramThrowable)
  {
    b(a(paramThrowable));
  }
  
  public static boolean c(Class<?> paramClass)
  {
    if (Proxy.isProxyClass(paramClass)) {}
    do
    {
      return true;
      paramClass = paramClass.getName();
    } while ((paramClass.startsWith("net.sf.cglib.proxy.")) || (paramClass.startsWith("org.hibernate.proxy.")));
    return false;
  }
  
  public static boolean d(Class<?> paramClass)
  {
    return (paramClass.getModifiers() & 0x600) == 0;
  }
  
  public static boolean e(Class<?> paramClass)
  {
    if (paramClass.isArray()) {}
    while ((Collection.class.isAssignableFrom(paramClass)) || (Map.class.isAssignableFrom(paramClass))) {
      return true;
    }
    return false;
  }
  
  public static Object f(Class<?> paramClass)
  {
    if (paramClass == Integer.TYPE) {
      return Integer.valueOf(0);
    }
    if (paramClass == Long.TYPE) {
      return Long.valueOf(0L);
    }
    if (paramClass == Boolean.TYPE) {
      return Boolean.FALSE;
    }
    if (paramClass == Double.TYPE) {
      return Double.valueOf(0.0D);
    }
    if (paramClass == Float.TYPE) {
      return Float.valueOf(0.0F);
    }
    if (paramClass == Byte.TYPE) {
      return Byte.valueOf((byte)0);
    }
    if (paramClass == Short.TYPE) {
      return Short.valueOf((short)0);
    }
    if (paramClass == Character.TYPE) {
      return Character.valueOf('\000');
    }
    throw new IllegalArgumentException("Class " + paramClass.getName() + " is not a primitive type");
  }
  
  public static Class<? extends Enum<?>> g(Class<?> paramClass)
  {
    Object localObject = paramClass;
    if (paramClass.getSuperclass() != Enum.class) {
      localObject = paramClass.getSuperclass();
    }
    return (Class<? extends Enum<?>>)localObject;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/adz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */