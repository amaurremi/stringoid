package com.flurry.android.monolithic.sdk.impl;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.HashMap;

public class zf
  implements qc
{
  protected final xk a;
  protected final ado b;
  protected final afm c;
  protected final Method d;
  protected final Field e;
  protected HashMap<Object, Object> f;
  protected final pw g;
  protected final afm h;
  protected final ra<Object> i;
  protected aal j;
  protected final boolean k;
  protected final Object l;
  protected Class<?>[] m;
  protected rx n;
  protected afm o;
  
  public zf(xk paramxk, ado paramado, pw parampw, afm paramafm1, ra<Object> paramra, rx paramrx, afm paramafm2, Method paramMethod, Field paramField, boolean paramBoolean, Object paramObject)
  {
    this.a = paramxk;
    this.b = paramado;
    this.g = parampw;
    this.c = paramafm1;
    this.i = paramra;
    if (paramra == null) {}
    for (paramxk = aal.a();; paramxk = null)
    {
      this.j = paramxk;
      this.n = paramrx;
      this.h = paramafm2;
      this.d = paramMethod;
      this.e = paramField;
      this.k = paramBoolean;
      this.l = paramObject;
      return;
    }
  }
  
  public zf(xk paramxk, ado paramado, String paramString, afm paramafm1, ra<Object> paramra, rx paramrx, afm paramafm2, Method paramMethod, Field paramField, boolean paramBoolean, Object paramObject)
  {
    this(paramxk, paramado, new pw(paramString), paramafm1, paramra, paramrx, paramafm2, paramMethod, paramField, paramBoolean, paramObject);
  }
  
  protected zf(zf paramzf)
  {
    this(paramzf, paramzf.i);
  }
  
  protected zf(zf paramzf, ra<Object> paramra)
  {
    this.i = paramra;
    this.a = paramzf.a;
    this.b = paramzf.b;
    this.c = paramzf.c;
    this.d = paramzf.d;
    this.e = paramzf.e;
    if (paramzf.f != null) {
      this.f = new HashMap(paramzf.f);
    }
    this.g = paramzf.g;
    this.h = paramzf.h;
    this.j = paramzf.j;
    this.k = paramzf.k;
    this.l = paramzf.l;
    this.m = paramzf.m;
    this.n = paramzf.n;
    this.o = paramzf.o;
  }
  
  public afm a()
  {
    return this.c;
  }
  
  protected ra<Object> a(aal paramaal, Class<?> paramClass, ru paramru)
    throws qw
  {
    if (this.o != null) {}
    for (paramClass = paramaal.a(paramru.a(this.o, paramClass), paramru, this);; paramClass = paramaal.a(paramClass, paramru, this))
    {
      if (paramaal != paramClass.b) {
        this.j = paramClass.b;
      }
      return paramClass.a;
    }
  }
  
  public zf a(ra<Object> paramra)
  {
    if (getClass() != zf.class) {
      throw new IllegalStateException("BeanPropertyWriter sub-class does not override 'withSerializer()'; needs to!");
    }
    return new zf(this, paramra);
  }
  
  public final Object a(Object paramObject)
    throws Exception
  {
    if (this.d != null) {
      return this.d.invoke(paramObject, new Object[0]);
    }
    return this.e.get(paramObject);
  }
  
  public void a(afm paramafm)
  {
    this.o = paramafm;
  }
  
  public void a(Object paramObject, or paramor, ru paramru)
    throws Exception
  {
    Object localObject = a(paramObject);
    if (localObject == null) {
      if (!this.k)
      {
        paramor.a(this.g);
        paramru.a(paramor);
      }
    }
    do
    {
      return;
      if (localObject == paramObject) {
        b(paramObject);
      }
    } while ((this.l != null) && (this.l.equals(localObject)));
    ra localra = this.i;
    paramObject = localra;
    if (localra == null)
    {
      Class localClass = localObject.getClass();
      aal localaal = this.j;
      localra = localaal.a(localClass);
      paramObject = localra;
      if (localra == null) {
        paramObject = a(localaal, localClass, paramru);
      }
    }
    paramor.a(this.g);
    if (this.n == null)
    {
      ((ra)paramObject).a(localObject, paramor, paramru);
      return;
    }
    ((ra)paramObject).a(localObject, paramor, paramru, this.n);
  }
  
  public void a(Class<?>[] paramArrayOfClass)
  {
    this.m = paramArrayOfClass;
  }
  
  public xk b()
  {
    return this.a;
  }
  
  protected void b(Object paramObject)
    throws qw
  {
    throw new qw("Direct self-reference leading to cycle");
  }
  
  public zf c()
  {
    return new aaw(this);
  }
  
  public String d()
  {
    return this.g.a();
  }
  
  public boolean e()
  {
    return this.i != null;
  }
  
  public afm f()
  {
    return this.h;
  }
  
  public Type g()
  {
    if (this.d != null) {
      return this.d.getGenericReturnType();
    }
    return this.e.getGenericType();
  }
  
  public Class<?>[] h()
  {
    return this.m;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(40);
    localStringBuilder.append("property '").append(d()).append("' (");
    if (this.d != null)
    {
      localStringBuilder.append("via method ").append(this.d.getDeclaringClass().getName()).append("#").append(this.d.getName());
      if (this.i != null) {
        break label135;
      }
      localStringBuilder.append(", no static serializer");
    }
    for (;;)
    {
      localStringBuilder.append(')');
      return localStringBuilder.toString();
      localStringBuilder.append("field \"").append(this.e.getDeclaringClass().getName()).append("#").append(this.e.getName());
      break;
      label135:
      localStringBuilder.append(", static serializer of type " + this.i.getClass().getName());
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/zf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */