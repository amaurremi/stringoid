package com.vungle.publisher;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;

public final class df<T>
  extends cs<T>
{
  private final Field[] a;
  private final ClassLoader b;
  private final Constructor<T> c;
  private final Class<?> d;
  private final String[] e;
  private final cs<?>[] f;
  private final cs<?>[] g;
  private cs<? super T> h;
  
  private df(String paramString1, String paramString2, boolean paramBoolean, Class<?> paramClass1, Field[] paramArrayOfField, Constructor<T> paramConstructor, int paramInt, Class<?> paramClass2, String[] paramArrayOfString)
  {
    super(paramString1, paramString2, paramBoolean, paramClass1);
    this.c = paramConstructor;
    this.a = paramArrayOfField;
    this.d = paramClass2;
    this.e = paramArrayOfString;
    this.g = new cs[paramInt];
    this.f = new cs[paramArrayOfField.length];
    this.b = paramClass1.getClassLoader();
  }
  
  public static <T> cs<T> a(Class<T> paramClass, boolean paramBoolean)
  {
    boolean bool = paramClass.isAnnotationPresent(Singleton.class);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Object localObject2;
    for (Object localObject1 = paramClass; localObject1 != Object.class; localObject1 = ((Class)localObject1).getSuperclass())
    {
      localObject2 = ((Class)localObject1).getDeclaredFields();
      j = localObject2.length;
      i = 0;
      while (i < j)
      {
        localObject4 = localObject2[i];
        if ((((Field)localObject4).isAnnotationPresent(Inject.class)) && (!Modifier.isStatic(((Field)localObject4).getModifiers())))
        {
          if ((((Field)localObject4).getModifiers() & 0x2) != 0) {
            throw new IllegalStateException("Can't inject private field: " + localObject4);
          }
          ((Field)localObject4).setAccessible(true);
          localArrayList2.add(localObject4);
          localArrayList1.add(cw.a(((Field)localObject4).getGenericType(), ((Field)localObject4).getAnnotations(), localObject4));
        }
        i += 1;
      }
    }
    Object localObject4 = (Constructor[])paramClass.getDeclaredConstructors();
    int j = localObject4.length;
    int i = 0;
    for (localObject1 = null; i < j; localObject1 = localObject2)
    {
      localObject2 = localObject4[i];
      if (((Constructor)localObject2).isAnnotationPresent(Inject.class))
      {
        if (localObject1 != null) {
          throw new cs.a(paramClass.getName(), "has too many injectable constructors");
        }
      }
      else {
        localObject2 = localObject1;
      }
      i += 1;
    }
    if (localObject1 == null) {
      if (localArrayList2.isEmpty()) {}
    }
    label552:
    label572:
    for (;;)
    {
      try
      {
        localObject2 = paramClass.getDeclaredConstructor(new Class[0]);
        localObject1 = localObject2;
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        continue;
      }
      Object localObject3;
      if (localObject1 != null)
      {
        if ((((Constructor)localObject1).getModifiers() & 0x2) != 0)
        {
          throw new IllegalStateException("Can't inject private constructor: " + localObject1);
          if (!paramBoolean) {
            break label572;
          }
          throw new cs.a(paramClass.getName(), "has no injectable members. Do you want to add an injectable constructor?");
        }
        localObject4 = cw.a(paramClass);
        ((Constructor)localObject1).setAccessible(true);
        localObject5 = ((Constructor)localObject1).getGenericParameterTypes();
        int k = localObject5.length;
        localObject3 = localObject4;
        j = k;
        if (k != 0)
        {
          Annotation[][] arrayOfAnnotation = ((Constructor)localObject1).getParameterAnnotations();
          i = 0;
          for (;;)
          {
            localObject3 = localObject4;
            j = k;
            if (i >= localObject5.length) {
              break;
            }
            localArrayList1.add(cw.a(localObject5[i], arrayOfAnnotation[i], localObject1));
            i += 1;
          }
        }
      }
      else
      {
        if (bool) {
          throw new IllegalArgumentException("No injectable constructor on @Singleton " + paramClass.getName());
        }
        localObject3 = null;
        j = 0;
      }
      Object localObject5 = paramClass.getSuperclass();
      localObject4 = localObject5;
      if (localObject5 != null) {
        if (!cw.e(((Class)localObject5).getName())) {
          break label552;
        }
      }
      for (localObject4 = null;; localObject4 = localObject5)
      {
        return new df((String)localObject3, cw.a(paramClass), bool, paramClass, (Field[])localArrayList2.toArray(new Field[localArrayList2.size()]), (Constructor)localObject1, j, (Class)localObject4, (String[])localArrayList1.toArray(new String[localArrayList1.size()]));
        localArrayList1.add(cw.a((Class)localObject5));
      }
    }
  }
  
  public final void attach(cy paramcy)
  {
    int j = 0;
    int i = 0;
    while (j < this.a.length)
    {
      if (this.f[j] == null) {
        this.f[j] = paramcy.a(this.e[i], this.a[j], this.b);
      }
      i += 1;
      j += 1;
    }
    int k = i;
    if (this.c != null)
    {
      j = 0;
      for (;;)
      {
        k = i;
        if (j >= this.g.length) {
          break;
        }
        if (this.g[j] == null) {
          this.g[j] = paramcy.a(this.e[i], this.c, this.b);
        }
        i += 1;
        j += 1;
      }
    }
    if ((this.d != null) && (this.h == null)) {
      this.h = paramcy.a(this.e[k], this.membersKey, this.b, false);
    }
  }
  
  public final T get()
  {
    if (this.c == null) {
      throw new UnsupportedOperationException();
    }
    Object localObject1 = new Object[this.g.length];
    int i = 0;
    while (i < this.g.length)
    {
      localObject1[i] = this.g[i].get();
      i += 1;
    }
    try
    {
      localObject1 = this.c.newInstance((Object[])localObject1);
      injectMembers(localObject1);
      return (T)localObject1;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      Object localObject2 = localInvocationTargetException.getCause();
      if ((localObject2 instanceof RuntimeException)) {}
      for (localObject2 = (RuntimeException)localObject2;; localObject2 = new RuntimeException((Throwable)localObject2)) {
        throw ((Throwable)localObject2);
      }
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw new AssertionError(localIllegalAccessException);
    }
    catch (InstantiationException localInstantiationException)
    {
      throw new RuntimeException(localInstantiationException);
    }
  }
  
  public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
  {
    if (this.g != null) {
      Collections.addAll(paramSet1, this.g);
    }
    Collections.addAll(paramSet2, this.f);
    if (this.h != null) {
      paramSet2.add(this.h);
    }
  }
  
  public final void injectMembers(T paramT)
  {
    int i = 0;
    try
    {
      while (i < this.a.length)
      {
        this.a[i].set(paramT, this.f[i].get());
        i += 1;
      }
      if (this.h != null) {
        this.h.injectMembers(paramT);
      }
      return;
    }
    catch (IllegalAccessException paramT)
    {
      throw new AssertionError(paramT);
    }
  }
  
  public final String toString()
  {
    if (this.provideKey != null) {
      return this.provideKey;
    }
    return this.membersKey;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/df.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */