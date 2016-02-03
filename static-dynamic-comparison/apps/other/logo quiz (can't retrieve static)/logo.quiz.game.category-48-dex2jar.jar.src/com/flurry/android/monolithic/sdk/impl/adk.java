package com.flurry.android.monolithic.sdk.impl;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class adk
{
  @Deprecated
  public static final adk a = new adk();
  private static final afm[] f = new afm[0];
  protected final adl[] b = null;
  protected final adm c = new adm(this);
  protected ade d;
  protected ade e;
  
  public static adk a()
  {
    return a;
  }
  
  public static afm a(String paramString)
    throws IllegalArgumentException
  {
    return a.b(paramString);
  }
  
  public static afm b()
  {
    return a().c();
  }
  
  private afm b(Class<?> paramClass)
  {
    afm[] arrayOfafm = a(paramClass, Map.class);
    if (arrayOfafm == null) {
      return adg.a(paramClass, c(), c());
    }
    if (arrayOfafm.length != 2) {
      throw new IllegalArgumentException("Strange Map type " + paramClass.getName() + ": can not determine type parameters");
    }
    return adg.a(paramClass, arrayOfafm[0], arrayOfafm[1]);
  }
  
  private afm c(Class<?> paramClass)
  {
    afm[] arrayOfafm = a(paramClass, Collection.class);
    if (arrayOfafm == null) {
      return add.a(paramClass, c());
    }
    if (arrayOfafm.length != 1) {
      throw new IllegalArgumentException("Strange Collection type " + paramClass.getName() + ": can not determine type parameters");
    }
    return add.a(paramClass, arrayOfafm[0]);
  }
  
  protected ade a(ade paramade)
  {
    try
    {
      if (this.d == null)
      {
        localade = paramade.a();
        a(localade, Map.class);
        this.d = localade.b();
      }
      ade localade = this.d.a();
      paramade.a(localade);
      localade.b(paramade);
      return paramade;
    }
    finally {}
  }
  
  protected ade a(ade paramade, Class<?> paramClass)
  {
    Object localObject = paramade.e();
    Type[] arrayOfType = ((Class)localObject).getGenericInterfaces();
    if (arrayOfType != null)
    {
      int j = arrayOfType.length;
      int i = 0;
      while (i < j)
      {
        ade localade = b(arrayOfType[i], paramClass);
        if (localade != null)
        {
          localade.b(paramade);
          paramade.a(localade);
          return paramade;
        }
        i += 1;
      }
    }
    localObject = ((Class)localObject).getGenericSuperclass();
    if (localObject != null)
    {
      paramClass = b((Type)localObject, paramClass);
      if (paramClass != null)
      {
        paramClass.b(paramade);
        paramade.a(paramClass);
        return paramade;
      }
    }
    return null;
  }
  
  protected ade a(Type paramType, Class<?> paramClass)
  {
    paramType = new ade(paramType);
    Object localObject = paramType.e();
    if (localObject == paramClass) {
      return paramType;
    }
    localObject = ((Class)localObject).getGenericSuperclass();
    if (localObject != null)
    {
      paramClass = a((Type)localObject, paramClass);
      if (paramClass != null)
      {
        paramClass.b(paramType);
        paramType.a(paramClass);
        return paramType;
      }
    }
    return null;
  }
  
  public adg a(Class<? extends Map> paramClass, Class<?> paramClass1, Class<?> paramClass2)
  {
    return adg.a(paramClass, a(paramClass1), a(paramClass2));
  }
  
  public afm a(afm paramafm, Class<?> paramClass)
  {
    if (((paramafm instanceof adh)) && ((paramClass.isArray()) || (Map.class.isAssignableFrom(paramClass)) || (Collection.class.isAssignableFrom(paramClass))))
    {
      if (!paramafm.p().isAssignableFrom(paramClass)) {
        throw new IllegalArgumentException("Class " + paramClass.getClass().getName() + " not subtype of " + paramafm);
      }
      Object localObject1 = a(paramClass, new adj(this, paramafm.p()));
      Object localObject2 = paramafm.n();
      paramClass = (Class<?>)localObject1;
      if (localObject2 != null) {
        paramClass = ((afm)localObject1).d(localObject2);
      }
      localObject1 = paramafm.o();
      paramafm = paramClass;
      if (localObject1 != null) {
        paramafm = paramClass.f(localObject1);
      }
      return paramafm;
    }
    return paramafm.f(paramClass);
  }
  
  public afm a(Class<?> paramClass)
  {
    return new adh(paramClass);
  }
  
  protected afm a(Class<?> paramClass, adj paramadj)
  {
    if (paramClass.isArray()) {
      return ada.a(b(paramClass.getComponentType(), null), null, null);
    }
    if (paramClass.isEnum()) {
      return new adh(paramClass);
    }
    if (Map.class.isAssignableFrom(paramClass)) {
      return b(paramClass);
    }
    if (Collection.class.isAssignableFrom(paramClass)) {
      return c(paramClass);
    }
    return new adh(paramClass);
  }
  
  protected afm a(Class<?> paramClass, List<afm> paramList)
  {
    if (paramClass.isArray()) {
      return ada.a(b(paramClass.getComponentType(), null), null, null);
    }
    if (paramClass.isEnum()) {
      return new adh(paramClass);
    }
    if (Map.class.isAssignableFrom(paramClass))
    {
      if (paramList.size() > 0)
      {
        afm localafm = (afm)paramList.get(0);
        if (paramList.size() >= 2) {}
        for (paramList = (afm)paramList.get(1);; paramList = c()) {
          return adg.a(paramClass, localafm, paramList);
        }
      }
      return b(paramClass);
    }
    if (Collection.class.isAssignableFrom(paramClass))
    {
      if (paramList.size() >= 1) {
        return add.a(paramClass, (afm)paramList.get(0));
      }
      return c(paramClass);
    }
    if (paramList.size() == 0) {
      return new adh(paramClass);
    }
    return a(paramClass, (afm[])paramList.toArray(new afm[paramList.size()]));
  }
  
  public afm a(Class<?> paramClass, afm[] paramArrayOfafm)
  {
    TypeVariable[] arrayOfTypeVariable = paramClass.getTypeParameters();
    if (arrayOfTypeVariable.length != paramArrayOfafm.length) {
      throw new IllegalArgumentException("Parameter type mismatch for " + paramClass.getName() + ": expected " + arrayOfTypeVariable.length + " parameters, was given " + paramArrayOfafm.length);
    }
    String[] arrayOfString = new String[arrayOfTypeVariable.length];
    int i = 0;
    int j = arrayOfTypeVariable.length;
    while (i < j)
    {
      arrayOfString[i] = arrayOfTypeVariable[i].getName();
      i += 1;
    }
    return new adh(paramClass, arrayOfString, paramArrayOfafm, null, null);
  }
  
  protected afm a(GenericArrayType paramGenericArrayType, adj paramadj)
  {
    return ada.a(b(paramGenericArrayType.getGenericComponentType(), paramadj), null, null);
  }
  
  protected afm a(ParameterizedType paramParameterizedType, adj paramadj)
  {
    Class localClass = (Class)paramParameterizedType.getRawType();
    Type[] arrayOfType = paramParameterizedType.getActualTypeArguments();
    if (arrayOfType == null) {}
    for (int i = 0; i == 0; i = arrayOfType.length)
    {
      paramParameterizedType = f;
      if (!Map.class.isAssignableFrom(localClass)) {
        break label174;
      }
      paramParameterizedType = b(a(localClass, paramParameterizedType), Map.class);
      if (paramParameterizedType.length == 2) {
        break label162;
      }
      throw new IllegalArgumentException("Could not find 2 type parameters for Map class " + localClass.getName() + " (found " + paramParameterizedType.length + ")");
    }
    afm[] arrayOfafm = new afm[i];
    int j = 0;
    for (;;)
    {
      paramParameterizedType = arrayOfafm;
      if (j >= i) {
        break;
      }
      arrayOfafm[j] = b(arrayOfType[j], paramadj);
      j += 1;
    }
    label162:
    return adg.a(localClass, paramParameterizedType[0], paramParameterizedType[1]);
    label174:
    if (Collection.class.isAssignableFrom(localClass))
    {
      paramParameterizedType = b(a(localClass, paramParameterizedType), Collection.class);
      if (paramParameterizedType.length != 1) {
        throw new IllegalArgumentException("Could not find 1 type parameter for Collection class " + localClass.getName() + " (found " + paramParameterizedType.length + ")");
      }
      return add.a(localClass, paramParameterizedType[0]);
    }
    if (i == 0) {
      return new adh(localClass);
    }
    return a(localClass, paramParameterizedType);
  }
  
  public afm a(Type paramType)
  {
    return b(paramType, null);
  }
  
  public afm a(Type paramType, adj paramadj)
  {
    return b(paramType, paramadj);
  }
  
  protected afm a(TypeVariable<?> paramTypeVariable, adj paramadj)
  {
    Object localObject;
    if (paramadj == null) {
      localObject = c();
    }
    String str;
    afm localafm;
    do
    {
      return (afm)localObject;
      str = paramTypeVariable.getName();
      localafm = paramadj.a(str);
      localObject = localafm;
    } while (localafm != null);
    paramTypeVariable = paramTypeVariable.getBounds();
    paramadj.b(str);
    return b(paramTypeVariable[0], paramadj);
  }
  
  protected afm a(WildcardType paramWildcardType, adj paramadj)
  {
    return b(paramWildcardType.getUpperBounds()[0], paramadj);
  }
  
  public afm[] a(Class<?> paramClass1, Class<?> paramClass2)
  {
    return a(paramClass1, paramClass2, new adj(this, paramClass1));
  }
  
  public afm[] a(Class<?> paramClass1, Class<?> paramClass2, adj paramadj)
  {
    Object localObject2 = c(paramClass1, paramClass2);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      throw new IllegalArgumentException("Class " + paramClass1.getName() + " is not a subtype of " + paramClass2.getName());
    }
    for (;;)
    {
      paramadj = paramClass1;
      if (((ade)localObject1).b() == null) {
        break;
      }
      localObject1 = ((ade)localObject1).b();
      localObject2 = ((ade)localObject1).e();
      paramClass1 = new adj(this, (Class)localObject2);
      if (((ade)localObject1).c())
      {
        paramClass2 = ((ade)localObject1).d().getActualTypeArguments();
        localObject2 = ((Class)localObject2).getTypeParameters();
        int j = paramClass2.length;
        int i = 0;
        while (i < j)
        {
          paramClass1.a(localObject2[i].getName(), a.b(paramClass2[i], paramadj));
          i += 1;
        }
      }
    }
    if (!((ade)localObject1).c()) {
      return null;
    }
    return paramadj.b();
  }
  
  public add b(Class<? extends Collection> paramClass, Class<?> paramClass1)
  {
    return add.a(paramClass, a(paramClass1));
  }
  
  protected ade b(ade paramade)
  {
    try
    {
      if (this.e == null)
      {
        localade = paramade.a();
        a(localade, List.class);
        this.e = localade.b();
      }
      ade localade = this.e.a();
      paramade.a(localade);
      localade.b(paramade);
      return paramade;
    }
    finally {}
  }
  
  protected ade b(Type paramType, Class<?> paramClass)
  {
    ade localade = new ade(paramType);
    Class localClass = localade.e();
    if (localClass == paramClass) {
      return new ade(paramType);
    }
    if ((localClass == HashMap.class) && (paramClass == Map.class)) {
      return a(localade);
    }
    if ((localClass == ArrayList.class) && (paramClass == List.class)) {
      return b(localade);
    }
    return a(localade, paramClass);
  }
  
  public afm b(String paramString)
    throws IllegalArgumentException
  {
    return this.c.a(paramString);
  }
  
  public afm b(Type paramType, adj paramadj)
  {
    Object localObject2;
    Object localObject1;
    if ((paramType instanceof Class))
    {
      localObject2 = (Class)paramType;
      localObject1 = paramadj;
      if (paramadj == null) {
        localObject1 = new adj(this, (Class)localObject2);
      }
      localObject2 = a((Class)localObject2, (adj)localObject1);
      paramadj = (adj)localObject1;
      localObject1 = localObject2;
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (this.b == null) {
        break label231;
      }
      localObject2 = localObject1;
      if (((afm)localObject1).f()) {
        break label231;
      }
      adl[] arrayOfadl = this.b;
      int j = arrayOfadl.length;
      int i = 0;
      for (;;)
      {
        localObject2 = localObject1;
        if (i >= j) {
          break;
        }
        localObject1 = arrayOfadl[i].a((afm)localObject1, paramType, paramadj, this);
        i += 1;
      }
      if ((paramType instanceof ParameterizedType))
      {
        localObject1 = a((ParameterizedType)paramType, paramadj);
      }
      else if ((paramType instanceof GenericArrayType))
      {
        localObject1 = a((GenericArrayType)paramType, paramadj);
      }
      else if ((paramType instanceof TypeVariable))
      {
        localObject1 = a((TypeVariable)paramType, paramadj);
      }
      else
      {
        if (!(paramType instanceof WildcardType)) {
          break;
        }
        localObject1 = a((WildcardType)paramType, paramadj);
      }
    }
    throw new IllegalArgumentException("Unrecognized Type: " + paramType.toString());
    label231:
    return (afm)localObject2;
  }
  
  public afm[] b(afm paramafm, Class<?> paramClass)
  {
    Object localObject = paramafm.p();
    if (localObject == paramClass)
    {
      int j = paramafm.h();
      if (j == 0)
      {
        paramClass = null;
        return paramClass;
      }
      localObject = new afm[j];
      int i = 0;
      for (;;)
      {
        paramClass = (Class<?>)localObject;
        if (i >= j) {
          break;
        }
        localObject[i] = paramafm.b(i);
        i += 1;
      }
    }
    return a((Class)localObject, paramClass, new adj(this, paramafm));
  }
  
  protected ade c(Class<?> paramClass1, Class<?> paramClass2)
  {
    if (paramClass2.isInterface()) {
      return b(paramClass1, paramClass2);
    }
    return a(paramClass1, paramClass2);
  }
  
  protected afm c()
  {
    return new adh(Object.class);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/adk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */