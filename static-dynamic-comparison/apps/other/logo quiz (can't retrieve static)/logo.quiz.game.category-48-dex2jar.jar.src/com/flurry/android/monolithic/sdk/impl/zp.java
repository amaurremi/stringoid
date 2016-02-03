package com.flurry.android.monolithic.sdk.impl;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Map;

public class zp
{
  protected final rq a;
  protected final xq b;
  protected final sf c;
  protected final py d;
  protected Object e;
  
  public zp(rq paramrq, xq paramxq)
  {
    this.a = paramrq;
    this.b = paramxq;
    this.c = paramxq.a(paramrq.g());
    this.d = this.a.a();
  }
  
  public ado a()
  {
    return this.b.i();
  }
  
  protected afm a(xg paramxg, boolean paramBoolean, afm paramafm)
  {
    boolean bool = true;
    Object localObject = this.d.e(paramxg);
    Class localClass;
    if (localObject != null)
    {
      localClass = paramafm.p();
      if (((Class)localObject).isAssignableFrom(localClass))
      {
        paramafm = paramafm.h((Class)localObject);
        paramBoolean = true;
      }
    }
    for (;;)
    {
      localObject = zi.b(this.a, paramxg, paramafm);
      if (localObject != paramafm)
      {
        paramafm = (afm)localObject;
        paramBoolean = true;
      }
      for (;;)
      {
        if (!paramBoolean)
        {
          paramxg = this.d.f(paramxg);
          if (paramxg != null) {
            if (paramxg == sg.b) {
              paramBoolean = bool;
            }
          }
        }
        for (;;)
        {
          if (paramBoolean)
          {
            return paramafm;
            if (!localClass.isAssignableFrom((Class)localObject)) {
              throw new IllegalArgumentException("Illegal concrete-type annotation for method '" + paramxg.b() + "': class " + ((Class)localObject).getName() + " not a super-type of (declared) class " + localClass.getName());
            }
            paramafm = this.a.a(paramafm, (Class)localObject);
            break;
            paramBoolean = false;
            continue;
          }
          return null;
        }
      }
    }
  }
  
  protected zf a(String paramString, afm paramafm, ra<Object> paramra, rx paramrx1, rx paramrx2, xk paramxk, boolean paramBoolean)
  {
    Method localMethod;
    if ((paramxk instanceof xj)) {
      localMethod = null;
    }
    Object localObject;
    for (Field localField = ((xj)paramxk).e();; localField = null)
    {
      localafm = a(paramxk, paramBoolean, paramafm);
      if (paramrx2 == null) {
        break label397;
      }
      localObject = localafm;
      if (localafm == null) {
        localObject = paramafm;
      }
      if (((afm)localObject).g() != null) {
        break;
      }
      throw new IllegalStateException("Problem trying to create BeanPropertyWriter for property '" + paramString + "' (of type " + this.b.a() + "); serialization type " + localObject + " has no content");
      localMethod = ((xl)paramxk).e();
    }
    afm localafm = ((afm)localObject).e(paramrx2);
    localafm.g();
    label397:
    for (;;)
    {
      localObject = null;
      paramBoolean = false;
      boolean bool2 = false;
      sf localsf = this.d.a(paramxk, this.c);
      boolean bool1 = bool2;
      paramrx2 = (rx)localObject;
      if (localsf != null) {}
      switch (zq.a[localsf.ordinal()])
      {
      default: 
        paramrx2 = (rx)localObject;
        bool1 = bool2;
        paramBoolean = bool1;
      }
      for (;;)
      {
        paramafm = new zf(paramxk, this.b.i(), paramString, paramafm, paramra, paramrx1, localafm, localMethod, localField, paramBoolean, paramrx2);
        paramra = this.d.b(paramxk);
        paramString = paramafm;
        if (paramra != null)
        {
          paramString = paramafm;
          if (paramra.booleanValue()) {
            paramString = paramafm.c();
          }
        }
        return paramString;
        localObject = a(paramString, localMethod, localField);
        if (localObject == null)
        {
          paramBoolean = true;
          paramrx2 = (rx)localObject;
        }
        else
        {
          bool1 = bool2;
          paramrx2 = (rx)localObject;
          if (!localObject.getClass().isArray()) {
            break;
          }
          paramrx2 = aeb.a(localObject);
          paramBoolean = false;
          continue;
          paramrx2 = b(paramString, paramafm);
          paramBoolean = true;
          continue;
          paramBoolean = true;
          bool1 = paramBoolean;
          paramrx2 = (rx)localObject;
          if (!paramafm.f()) {
            break;
          }
          paramrx2 = a(paramString, paramafm);
        }
      }
    }
  }
  
  protected Object a(Exception paramException, String paramString, Object paramObject)
  {
    while (paramException.getCause() != null) {
      paramException = paramException.getCause();
    }
    if ((paramException instanceof Error)) {
      throw ((Error)paramException);
    }
    if ((paramException instanceof RuntimeException)) {
      throw ((RuntimeException)paramException);
    }
    throw new IllegalArgumentException("Failed to get property '" + paramString + "' of default " + paramObject.getClass().getName() + " instance");
  }
  
  protected Object a(String paramString, afm paramafm)
  {
    if (!this.a.a(rr.w))
    {
      if (paramafm.b()) {
        return new zr();
      }
      if (Collection.class.isAssignableFrom(paramafm.p())) {
        return new zs();
      }
    }
    return null;
  }
  
  protected Object a(String paramString, Method paramMethod, Field paramField)
  {
    Object localObject = b();
    if (paramMethod != null) {}
    try
    {
      return paramMethod.invoke(localObject, new Object[0]);
    }
    catch (Exception paramMethod) {}
    paramMethod = paramField.get(localObject);
    return paramMethod;
    return a(paramMethod, paramString, localObject);
  }
  
  protected Object b()
  {
    if (this.e == null)
    {
      this.e = this.b.a(this.a.a(rr.e));
      if (this.e == null)
      {
        Class localClass = this.b.c().e();
        throw new IllegalArgumentException("Class " + localClass.getName() + " has no default constructor; can not instantiate default bean value to support 'properties=JsonSerialize.Inclusion.NON_DEFAULT' annotation");
      }
    }
    return this.e;
  }
  
  protected Object b(String paramString, afm paramafm)
  {
    paramString = paramafm.p();
    if (paramString == String.class) {
      return new zu();
    }
    if (paramafm.b()) {
      return new zr();
    }
    if (Collection.class.isAssignableFrom(paramString)) {
      return new zs();
    }
    if (Map.class.isAssignableFrom(paramString)) {
      return new zt();
    }
    return null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/zp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */