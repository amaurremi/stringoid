package com.flurry.android.monolithic.sdk.impl;

import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;

public class adj
{
  public static final afm a = new adh(Object.class);
  private static final afm[] g = new afm[0];
  protected final adk b;
  protected final afm c;
  protected final Class<?> d;
  protected Map<String, afm> e;
  protected HashSet<String> f;
  private final adj h;
  
  private adj(adk paramadk, adj paramadj, Class<?> paramClass, afm paramafm)
  {
    this.b = paramadk;
    this.h = paramadj;
    this.d = paramClass;
    this.c = paramafm;
  }
  
  public adj(adk paramadk, afm paramafm)
  {
    this(paramadk, null, paramafm.p(), paramafm);
  }
  
  public adj(adk paramadk, Class<?> paramClass)
  {
    this(paramadk, null, paramClass, null);
  }
  
  public adj a()
  {
    return new adj(this.b, this, this.d, this.c);
  }
  
  public afm a(String paramString)
  {
    if (this.e == null) {
      c();
    }
    Object localObject = (afm)this.e.get(paramString);
    if (localObject != null) {
      return (afm)localObject;
    }
    if ((this.f != null) && (this.f.contains(paramString))) {
      return a;
    }
    if (this.h != null) {
      return this.h.a(paramString);
    }
    if ((this.d != null) && (this.d.getEnclosingClass() != null) && (!Modifier.isStatic(this.d.getModifiers()))) {
      return a;
    }
    if (this.d != null) {
      localObject = this.d.getName();
    }
    for (;;)
    {
      throw new IllegalArgumentException("Type variable '" + paramString + "' can not be resolved (with context of class " + (String)localObject + ")");
      if (this.c != null) {
        localObject = this.c.toString();
      } else {
        localObject = "UNKNOWN";
      }
    }
  }
  
  public afm a(Type paramType)
  {
    return this.b.b(paramType, this);
  }
  
  public void a(String paramString, afm paramafm)
  {
    if ((this.e == null) || (this.e.size() == 0)) {
      this.e = new LinkedHashMap();
    }
    this.e.put(paramString, paramafm);
  }
  
  public void b(String paramString)
  {
    if (this.f == null) {
      this.f = new HashSet();
    }
    this.f.add(paramString);
  }
  
  protected void b(Type paramType)
  {
    int j = 0;
    if (paramType == null) {
      return;
    }
    Object localObject1;
    Object localObject3;
    Object localObject2;
    int k;
    int i;
    if ((paramType instanceof ParameterizedType))
    {
      paramType = (ParameterizedType)paramType;
      localObject1 = paramType.getActualTypeArguments();
      if ((localObject1 != null) && (localObject1.length > 0))
      {
        localObject3 = (Class)paramType.getRawType();
        localObject2 = ((Class)localObject3).getTypeParameters();
        if (localObject2.length != localObject1.length) {
          throw new IllegalArgumentException("Strange parametrized type (in class " + ((Class)localObject3).getName() + "): number of type arguments != number of type parameters (" + localObject1.length + " vs " + localObject2.length + ")");
        }
        k = localObject1.length;
        i = 0;
        if (i < k)
        {
          localObject3 = localObject2[i].getName();
          if (this.e == null)
          {
            this.e = new LinkedHashMap();
            label165:
            b((String)localObject3);
            this.e.put(localObject3, this.b.b(localObject1[i], this));
          }
          for (;;)
          {
            i += 1;
            break;
            if (!this.e.containsKey(localObject3)) {
              break label165;
            }
          }
        }
      }
    }
    for (paramType = (Class)paramType.getRawType();; paramType = (Type)localObject1)
    {
      b(paramType.getGenericSuperclass());
      paramType = paramType.getGenericInterfaces();
      k = paramType.length;
      i = j;
      while (i < k)
      {
        b(paramType[i]);
        i += 1;
      }
      break;
      if (!(paramType instanceof Class)) {
        break;
      }
      localObject1 = (Class)paramType;
      b(((Class)localObject1).getDeclaringClass());
      localObject3 = ((Class)localObject1).getTypeParameters();
      if ((localObject3 != null) && (localObject3.length > 0))
      {
        localObject2 = null;
        paramType = (Type)localObject2;
        if (this.c != null)
        {
          paramType = (Type)localObject2;
          if (((Class)localObject1).isAssignableFrom(this.c.p())) {
            paramType = this.b.b(this.c, (Class)localObject1);
          }
        }
        i = 0;
        if (i < localObject3.length)
        {
          Type localType = localObject3[i];
          localObject2 = localType.getName();
          localType = localType.getBounds()[0];
          if (localType != null)
          {
            if (this.e != null) {
              break label443;
            }
            this.e = new LinkedHashMap();
            label411:
            b((String)localObject2);
            if (paramType == null) {
              break label460;
            }
            this.e.put(localObject2, paramType[i]);
          }
          for (;;)
          {
            i += 1;
            break;
            label443:
            if (!this.e.containsKey(localObject2)) {
              break label411;
            }
            continue;
            label460:
            this.e.put(localObject2, this.b.b(localType, this));
          }
        }
      }
    }
  }
  
  public afm[] b()
  {
    if (this.e == null) {
      c();
    }
    if (this.e.size() == 0) {
      return g;
    }
    return (afm[])this.e.values().toArray(new afm[this.e.size()]);
  }
  
  protected void c()
  {
    b(this.d);
    if (this.c != null)
    {
      int j = this.c.h();
      if (j > 0)
      {
        if (this.e == null) {
          this.e = new LinkedHashMap();
        }
        int i = 0;
        while (i < j)
        {
          String str = this.c.a(i);
          afm localafm = this.c.b(i);
          this.e.put(str, localafm);
          i += 1;
        }
      }
    }
    if (this.e == null) {
      this.e = Collections.emptyMap();
    }
  }
  
  public String toString()
  {
    if (this.e == null) {
      c();
    }
    StringBuilder localStringBuilder = new StringBuilder("[TypeBindings for ");
    if (this.c != null) {
      localStringBuilder.append(this.c.toString());
    }
    for (;;)
    {
      localStringBuilder.append(": ").append(this.e).append("]");
      return localStringBuilder.toString();
      localStringBuilder.append(this.d.getName());
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/adj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */