package com.flurry.android.monolithic.sdk.impl;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class xh
  extends xg
{
  private static final xp[] l = new xp[0];
  protected final Class<?> a;
  protected final List<Class<?>> b;
  protected final py c;
  protected final qg d;
  protected final Class<?> e;
  protected xp f;
  protected xi g;
  protected List<xi> h;
  protected List<xl> i;
  protected xm j;
  protected List<xj> k;
  
  private xh(Class<?> paramClass, List<Class<?>> paramList, py parampy, qg paramqg, xp paramxp)
  {
    this.a = paramClass;
    this.b = paramList;
    this.c = parampy;
    this.d = paramqg;
    if (this.d == null) {}
    for (paramClass = null;; paramClass = this.d.a(this.a))
    {
      this.e = paramClass;
      this.f = paramxp;
      return;
    }
  }
  
  public static xh a(Class<?> paramClass, py parampy, qg paramqg)
  {
    paramClass = new xh(paramClass, adz.a(paramClass, null), parampy, paramqg, null);
    paramClass.m();
    return paramClass;
  }
  
  private xp[] a(int paramInt)
  {
    Object localObject;
    if (paramInt == 0)
    {
      localObject = l;
      return (xp[])localObject;
    }
    xp[] arrayOfxp = new xp[paramInt];
    int m = 0;
    for (;;)
    {
      localObject = arrayOfxp;
      if (m >= paramInt) {
        break;
      }
      arrayOfxp[m] = o();
      m += 1;
    }
  }
  
  public static xh b(Class<?> paramClass, py parampy, qg paramqg)
  {
    paramClass = new xh(paramClass, Collections.emptyList(), parampy, paramqg, null);
    paramClass.m();
    return paramClass;
  }
  
  private boolean b(Field paramField)
  {
    if (paramField.isSynthetic()) {}
    int m;
    do
    {
      return false;
      m = paramField.getModifiers();
    } while ((Modifier.isStatic(m)) || (Modifier.isTransient(m)));
    return true;
  }
  
  private xp o()
  {
    return new xp();
  }
  
  protected xi a(Constructor<?> paramConstructor, boolean paramBoolean)
  {
    if (this.c == null) {
      return new xi(paramConstructor, o(), a(paramConstructor.getParameterTypes().length));
    }
    if (paramBoolean) {
      return new xi(paramConstructor, a(paramConstructor.getDeclaredAnnotations()), null);
    }
    Object localObject2 = paramConstructor.getParameterAnnotations();
    int m = paramConstructor.getParameterTypes().length;
    Object localObject1;
    Object localObject3;
    if (m != localObject2.length)
    {
      localObject1 = paramConstructor.getDeclaringClass();
      if ((((Class)localObject1).isEnum()) && (m == localObject2.length + 2))
      {
        localObject1 = new Annotation[localObject2.length + 2][];
        System.arraycopy(localObject2, 0, localObject1, 2, localObject2.length);
        localObject3 = a((Annotation[][])localObject1);
        localObject2 = localObject1;
        localObject1 = localObject3;
      }
    }
    for (;;)
    {
      localObject3 = localObject1;
      if (localObject1 == null)
      {
        throw new IllegalStateException("Internal error: constructor for " + paramConstructor.getDeclaringClass().getName() + " has mismatch: " + m + " parameters; " + localObject2.length + " sets of annotations");
        if ((((Class)localObject1).isMemberClass()) && (m == localObject2.length + 1))
        {
          localObject3 = new Annotation[localObject2.length + 1][];
          System.arraycopy(localObject2, 0, localObject3, 1, localObject2.length);
          localObject1 = a((Annotation[][])localObject3);
          localObject2 = localObject3;
          continue;
          localObject3 = a((Annotation[][])localObject2);
        }
      }
      else
      {
        return new xi(paramConstructor, a(paramConstructor.getDeclaredAnnotations()), (xp[])localObject3);
      }
      localObject1 = null;
    }
  }
  
  protected xj a(Field paramField)
  {
    if (this.c == null) {
      return new xj(paramField, o());
    }
    return new xj(paramField, a(paramField.getDeclaredAnnotations()));
  }
  
  public xl a(String paramString, Class<?>[] paramArrayOfClass)
  {
    return this.j.a(paramString, paramArrayOfClass);
  }
  
  protected xl a(Method paramMethod)
  {
    if (this.c == null) {
      return new xl(paramMethod, o(), null);
    }
    return new xl(paramMethod, a(paramMethod.getDeclaredAnnotations()), null);
  }
  
  protected xp a(Annotation[] paramArrayOfAnnotation)
  {
    xp localxp = new xp();
    if (paramArrayOfAnnotation != null)
    {
      int n = paramArrayOfAnnotation.length;
      int m = 0;
      while (m < n)
      {
        Annotation localAnnotation = paramArrayOfAnnotation[m];
        if (this.c.a(localAnnotation)) {
          localxp.b(localAnnotation);
        }
        m += 1;
      }
    }
    return localxp;
  }
  
  public <A extends Annotation> A a(Class<A> paramClass)
  {
    if (this.f == null) {
      return null;
    }
    return this.f.a(paramClass);
  }
  
  protected void a(xp paramxp, Class<?> paramClass)
  {
    if (this.d != null) {
      a(paramxp, paramClass, this.d.a(paramClass));
    }
  }
  
  protected void a(xp paramxp, Class<?> paramClass1, Class<?> paramClass2)
  {
    if (paramClass2 == null) {
      return;
    }
    Annotation[] arrayOfAnnotation = paramClass2.getDeclaredAnnotations();
    int n = arrayOfAnnotation.length;
    int m = 0;
    while (m < n)
    {
      Annotation localAnnotation = arrayOfAnnotation[m];
      if (this.c.a(localAnnotation)) {
        paramxp.a(localAnnotation);
      }
      m += 1;
    }
    paramClass1 = adz.a(paramClass2, paramClass1).iterator();
    while (paramClass1.hasNext())
    {
      paramClass2 = ((Class)paramClass1.next()).getDeclaredAnnotations();
      n = paramClass2.length;
      m = 0;
      while (m < n)
      {
        arrayOfAnnotation = paramClass2[m];
        if (this.c.a(arrayOfAnnotation)) {
          paramxp.a(arrayOfAnnotation);
        }
        m += 1;
      }
    }
  }
  
  public void a(xz paramxz)
  {
    this.j = new xm();
    Object localObject2 = new xm();
    a(this.a, paramxz, this.j, this.e, (xm)localObject2);
    Iterator localIterator = this.b.iterator();
    Object localObject1;
    if (localIterator.hasNext())
    {
      Class localClass = (Class)localIterator.next();
      if (this.d == null) {}
      for (localObject1 = null;; localObject1 = this.d.a(localClass))
      {
        a(localClass, paramxz, this.j, (Class)localObject1, (xm)localObject2);
        break;
      }
    }
    if (this.d != null)
    {
      localObject1 = this.d.a(Object.class);
      if (localObject1 != null) {
        a(paramxz, this.j, (Class)localObject1, (xm)localObject2);
      }
    }
    if ((this.c != null) && (!((xm)localObject2).a()))
    {
      paramxz = ((xm)localObject2).iterator();
      while (paramxz.hasNext())
      {
        localObject1 = (xl)paramxz.next();
        try
        {
          localObject2 = Object.class.getDeclaredMethod(((xl)localObject1).b(), ((xl)localObject1).m());
          if (localObject2 != null)
          {
            localObject2 = a((Method)localObject2);
            a(((xl)localObject1).e(), (xl)localObject2, false);
            this.j.a((xl)localObject2);
          }
        }
        catch (Exception localException) {}
      }
    }
  }
  
  protected void a(xz paramxz, xm paramxm1, Class<?> paramClass, xm paramxm2)
  {
    paramClass = paramClass.getDeclaredMethods();
    int n = paramClass.length;
    int m = 0;
    if (m < n)
    {
      Method localMethod = paramClass[m];
      if (!a(localMethod, paramxz)) {}
      for (;;)
      {
        m += 1;
        break;
        xl localxl = paramxm1.b(localMethod);
        if (localxl != null) {
          a(localMethod, localxl);
        } else {
          paramxm2.a(a(localMethod));
        }
      }
    }
  }
  
  protected void a(Class<?> paramClass1, xz paramxz, xm paramxm1, Class<?> paramClass2, xm paramxm2)
  {
    if (paramClass2 != null) {
      a(paramxz, paramxm1, paramClass2, paramxm2);
    }
    if (paramClass1 == null) {
      return;
    }
    paramClass1 = paramClass1.getDeclaredMethods();
    int n = paramClass1.length;
    int m = 0;
    label32:
    if (m < n)
    {
      paramClass2 = paramClass1[m];
      if (a(paramClass2, paramxz)) {
        break label64;
      }
    }
    for (;;)
    {
      m += 1;
      break label32;
      break;
      label64:
      xl localxl = paramxm1.b(paramClass2);
      if (localxl == null)
      {
        localxl = a(paramClass2);
        paramxm1.a(localxl);
        paramClass2 = paramxm2.a(paramClass2);
        if (paramClass2 != null) {
          a(paramClass2.e(), localxl, false);
        }
      }
      else
      {
        a(paramClass2, localxl);
        if ((localxl.h().isInterface()) && (!paramClass2.getDeclaringClass().isInterface())) {
          paramxm1.a(localxl.a(paramClass2));
        }
      }
    }
  }
  
  protected void a(Class<?> paramClass, Map<String, xj> paramMap)
  {
    paramClass = paramClass.getDeclaredFields();
    int i1 = paramClass.length;
    int m = 0;
    if (m < i1)
    {
      Object localObject = paramClass[m];
      if (!b((Field)localObject)) {}
      for (;;)
      {
        m += 1;
        break;
        xj localxj = (xj)paramMap.get(((Field)localObject).getName());
        if (localxj != null)
        {
          localObject = ((Field)localObject).getDeclaredAnnotations();
          int i2 = localObject.length;
          int n = 0;
          while (n < i2)
          {
            Annotation localAnnotation = localObject[n];
            if (this.c.a(localAnnotation)) {
              localxj.a(localAnnotation);
            }
            n += 1;
          }
        }
      }
    }
  }
  
  protected void a(Constructor<?> paramConstructor, xi paramxi, boolean paramBoolean)
  {
    Annotation[] arrayOfAnnotation = paramConstructor.getDeclaredAnnotations();
    int n = arrayOfAnnotation.length;
    int m = 0;
    while (m < n)
    {
      Annotation localAnnotation = arrayOfAnnotation[m];
      if (this.c.a(localAnnotation)) {
        paramxi.a(localAnnotation);
      }
      m += 1;
    }
    if (paramBoolean)
    {
      paramConstructor = paramConstructor.getParameterAnnotations();
      int i1 = paramConstructor.length;
      m = 0;
      while (m < i1)
      {
        arrayOfAnnotation = paramConstructor[m];
        int i2 = arrayOfAnnotation.length;
        n = 0;
        while (n < i2)
        {
          paramxi.a(m, arrayOfAnnotation[n]);
          n += 1;
        }
        m += 1;
      }
    }
  }
  
  protected void a(Method paramMethod, xl paramxl)
  {
    paramMethod = paramMethod.getDeclaredAnnotations();
    int n = paramMethod.length;
    int m = 0;
    while (m < n)
    {
      Annotation localAnnotation = paramMethod[m];
      if (this.c.a(localAnnotation)) {
        paramxl.b(localAnnotation);
      }
      m += 1;
    }
  }
  
  protected void a(Method paramMethod, xl paramxl, boolean paramBoolean)
  {
    Annotation[] arrayOfAnnotation = paramMethod.getDeclaredAnnotations();
    int n = arrayOfAnnotation.length;
    int m = 0;
    while (m < n)
    {
      Annotation localAnnotation = arrayOfAnnotation[m];
      if (this.c.a(localAnnotation)) {
        paramxl.a(localAnnotation);
      }
      m += 1;
    }
    if (paramBoolean)
    {
      paramMethod = paramMethod.getParameterAnnotations();
      int i1 = paramMethod.length;
      m = 0;
      while (m < i1)
      {
        arrayOfAnnotation = paramMethod[m];
        int i2 = arrayOfAnnotation.length;
        n = 0;
        while (n < i2)
        {
          paramxl.a(m, arrayOfAnnotation[n]);
          n += 1;
        }
        m += 1;
      }
    }
  }
  
  protected void a(Map<String, xj> paramMap, Class<?> paramClass)
  {
    Object localObject = paramClass.getSuperclass();
    if (localObject != null)
    {
      a(paramMap, (Class)localObject);
      localObject = paramClass.getDeclaredFields();
      int n = localObject.length;
      int m = 0;
      if (m < n)
      {
        Field localField = localObject[m];
        if (!b(localField)) {}
        for (;;)
        {
          m += 1;
          break;
          paramMap.put(localField.getName(), a(localField));
        }
      }
      if (this.d != null)
      {
        paramClass = this.d.a(paramClass);
        if (paramClass != null) {
          a(paramClass, paramMap);
        }
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.h = null;
    Object localObject = this.a.getDeclaredConstructors();
    int n = localObject.length;
    int m = 0;
    Constructor localConstructor;
    if (m < n)
    {
      localConstructor = localObject[m];
      if (localConstructor.getParameterTypes().length == 0) {
        this.g = a(localConstructor, true);
      }
      for (;;)
      {
        m += 1;
        break;
        if (paramBoolean)
        {
          if (this.h == null) {
            this.h = new ArrayList(Math.max(10, localObject.length));
          }
          this.h.add(a(localConstructor, false));
        }
      }
    }
    if ((this.e != null) && ((this.g != null) || (this.h != null))) {
      c(this.e);
    }
    if (this.c != null)
    {
      if ((this.g != null) && (this.c.a(this.g))) {
        this.g = null;
      }
      if (this.h != null) {
        m = this.h.size();
      }
    }
    for (;;)
    {
      m -= 1;
      if (m >= 0)
      {
        if (this.c.a((xi)this.h.get(m))) {
          this.h.remove(m);
        }
      }
      else
      {
        this.i = null;
        if (paramBoolean)
        {
          localObject = this.a.getDeclaredMethods();
          n = localObject.length;
          m = 0;
          if (m < n)
          {
            localConstructor = localObject[m];
            if (!Modifier.isStatic(localConstructor.getModifiers())) {}
            for (;;)
            {
              m += 1;
              break;
              if (localConstructor.getParameterTypes().length >= 1)
              {
                if (this.i == null) {
                  this.i = new ArrayList(8);
                }
                this.i.add(b(localConstructor));
              }
            }
          }
          if ((this.e != null) && (this.i != null)) {
            d(this.e);
          }
          if ((this.c != null) && (this.i != null)) {
            m = this.i.size();
          }
        }
        for (;;)
        {
          m -= 1;
          if (m >= 0)
          {
            if (this.c.a((xl)this.i.get(m))) {
              this.i.remove(m);
            }
          }
          else {
            return;
          }
        }
      }
    }
  }
  
  protected boolean a(Method paramMethod, xz paramxz)
  {
    if ((paramxz != null) && (!paramxz.a(paramMethod))) {}
    while ((paramMethod.isSynthetic()) || (paramMethod.isBridge())) {
      return false;
    }
    return true;
  }
  
  protected xp[] a(Annotation[][] paramArrayOfAnnotation)
  {
    int n = paramArrayOfAnnotation.length;
    xp[] arrayOfxp = new xp[n];
    int m = 0;
    while (m < n)
    {
      arrayOfxp[m] = a(paramArrayOfAnnotation[m]);
      m += 1;
    }
    return arrayOfxp;
  }
  
  protected xl b(Method paramMethod)
  {
    if (this.c == null) {
      return new xl(paramMethod, o(), a(paramMethod.getParameterTypes().length));
    }
    return new xl(paramMethod, a(paramMethod.getDeclaredAnnotations()), a(paramMethod.getParameterAnnotations()));
  }
  
  public String b()
  {
    return this.a.getName();
  }
  
  public Type c()
  {
    return this.a;
  }
  
  protected void c(Class<?> paramClass)
  {
    int m;
    int n;
    label24:
    Constructor localConstructor;
    Object localObject;
    if (this.h == null)
    {
      m = 0;
      Constructor[] arrayOfConstructor = paramClass.getDeclaredConstructors();
      int i2 = arrayOfConstructor.length;
      n = 0;
      paramClass = null;
      if (n >= i2) {
        break label220;
      }
      localConstructor = arrayOfConstructor[n];
      if (localConstructor.getParameterTypes().length != 0) {
        break label92;
      }
      localObject = paramClass;
      if (this.g != null)
      {
        a(localConstructor, this.g, false);
        localObject = paramClass;
      }
    }
    for (;;)
    {
      n += 1;
      paramClass = (Class<?>)localObject;
      break label24;
      m = this.h.size();
      break;
      label92:
      if (paramClass == null)
      {
        localObject = new xy[m];
        i1 = 0;
        for (;;)
        {
          paramClass = (Class<?>)localObject;
          if (i1 >= m) {
            break;
          }
          localObject[i1] = new xy(((xi)this.h.get(i1)).e());
          i1 += 1;
        }
      }
      localObject = new xy(localConstructor);
      int i1 = 0;
      for (;;)
      {
        if (i1 < m) {
          if (!((xy)localObject).equals(paramClass[i1]))
          {
            i1 += 1;
          }
          else
          {
            a(localConstructor, (xi)this.h.get(i1), true);
            localObject = paramClass;
            break;
            label220:
            return;
          }
        }
      }
      localObject = paramClass;
    }
  }
  
  public Class<?> d()
  {
    return this.a;
  }
  
  protected void d(Class<?> paramClass)
  {
    Object localObject = null;
    int i1 = this.i.size();
    Method[] arrayOfMethod = paramClass.getDeclaredMethods();
    int i2 = arrayOfMethod.length;
    int m = 0;
    paramClass = (Class<?>)localObject;
    Method localMethod;
    if (m < i2)
    {
      localMethod = arrayOfMethod[m];
      if (!Modifier.isStatic(localMethod.getModifiers())) {
        localObject = paramClass;
      }
    }
    for (;;)
    {
      m += 1;
      paramClass = (Class<?>)localObject;
      break;
      localObject = paramClass;
      if (localMethod.getParameterTypes().length != 0)
      {
        if (paramClass == null)
        {
          localObject = new xy[i1];
          n = 0;
          for (;;)
          {
            paramClass = (Class<?>)localObject;
            if (n >= i1) {
              break;
            }
            localObject[n] = new xy(((xl)this.i.get(n)).e());
            n += 1;
          }
        }
        localObject = new xy(localMethod);
        int n = 0;
        for (;;)
        {
          if (n < i1) {
            if (!((xy)localObject).equals(paramClass[n]))
            {
              n += 1;
            }
            else
            {
              a(localMethod, (xl)this.i.get(n), true);
              localObject = paramClass;
              break;
              return;
            }
          }
        }
        localObject = paramClass;
      }
    }
  }
  
  public Class<?> e()
  {
    return this.a;
  }
  
  public ado f()
  {
    return this.f;
  }
  
  public boolean g()
  {
    return this.f.a() > 0;
  }
  
  public xi h()
  {
    return this.g;
  }
  
  public List<xi> i()
  {
    if (this.h == null) {
      return Collections.emptyList();
    }
    return this.h;
  }
  
  public List<xl> j()
  {
    if (this.i == null) {
      return Collections.emptyList();
    }
    return this.i;
  }
  
  public Iterable<xl> k()
  {
    return this.j;
  }
  
  public Iterable<xj> l()
  {
    if (this.k == null) {
      return Collections.emptyList();
    }
    return this.k;
  }
  
  public void m()
  {
    this.f = new xp();
    if (this.c == null) {
      return;
    }
    if (this.e != null) {
      a(this.f, this.a, this.e);
    }
    Object localObject1 = this.a.getDeclaredAnnotations();
    int n = localObject1.length;
    int m = 0;
    Object localObject2;
    while (m < n)
    {
      localObject2 = localObject1[m];
      if (this.c.a((Annotation)localObject2)) {
        this.f.a((Annotation)localObject2);
      }
      m += 1;
    }
    localObject1 = this.b.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Class)((Iterator)localObject1).next();
      a(this.f, (Class)localObject2);
      localObject2 = ((Class)localObject2).getDeclaredAnnotations();
      n = localObject2.length;
      m = 0;
      while (m < n)
      {
        Annotation localAnnotation = localObject2[m];
        if (this.c.a(localAnnotation)) {
          this.f.a(localAnnotation);
        }
        m += 1;
      }
    }
    a(this.f, Object.class);
  }
  
  public void n()
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    a(localLinkedHashMap, this.a);
    if (localLinkedHashMap.isEmpty())
    {
      this.k = Collections.emptyList();
      return;
    }
    this.k = new ArrayList(localLinkedHashMap.size());
    this.k.addAll(localLinkedHashMap.values());
  }
  
  public String toString()
  {
    return "[AnnotedClass " + this.a.getName() + "]";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/xh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */