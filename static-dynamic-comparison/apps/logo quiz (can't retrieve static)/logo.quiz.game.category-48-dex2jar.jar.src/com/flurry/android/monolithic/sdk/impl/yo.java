package com.flurry.android.monolithic.sdk.impl;

import com.flurry.org.codehaus.jackson.annotate.JsonTypeInfo.As;
import java.io.IOException;

public class yo
  extends yk
{
  protected final String a;
  
  public yo(afm paramafm, yi paramyi, qc paramqc, Class<?> paramClass, String paramString)
  {
    super(paramafm, paramyi, paramqc, paramClass);
    this.a = paramString;
  }
  
  public JsonTypeInfo.As a()
  {
    return JsonTypeInfo.As.PROPERTY;
  }
  
  public Object a(ow paramow, qm paramqm)
    throws IOException, oz
  {
    Object localObject2 = paramow.e();
    Object localObject1;
    Object localObject3;
    if (localObject2 == pb.b)
    {
      localObject1 = paramow.b();
      localObject3 = null;
      localObject2 = localObject1;
      localObject1 = localObject3;
    }
    for (;;)
    {
      if (localObject2 != pb.f) {
        break label184;
      }
      localObject3 = paramow.g();
      paramow.b();
      if (this.a.equals(localObject3))
      {
        localObject3 = a(paramqm, paramow.k());
        localObject2 = paramow;
        if (localObject1 != null) {
          localObject2 = afx.a(((afz)localObject1).a(paramow), paramow);
        }
        ((ow)localObject2).b();
        return ((qu)localObject3).a((ow)localObject2, paramqm);
        if (localObject2 == pb.d) {
          return a(paramow, paramqm, null);
        }
        localObject1 = localObject2;
        if (localObject2 == pb.f) {
          break;
        }
        return a(paramow, paramqm, null);
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = new afz(null);
      }
      ((afz)localObject2).a((String)localObject3);
      ((afz)localObject2).c(paramow);
      localObject3 = paramow.b();
      localObject1 = localObject2;
      localObject2 = localObject3;
    }
    label184:
    return a(paramow, paramqm, (afz)localObject1);
  }
  
  protected Object a(ow paramow, qm paramqm, afz paramafz)
    throws IOException, oz
  {
    Object localObject;
    if (this.e != null)
    {
      qu localqu = a(paramqm);
      localObject = paramow;
      if (paramafz != null)
      {
        paramafz.e();
        localObject = paramafz.a(paramow);
        ((ow)localObject).b();
      }
      paramafz = localqu.a((ow)localObject, paramqm);
    }
    do
    {
      return paramafz;
      localObject = f(paramow, paramqm);
      paramafz = (afz)localObject;
    } while (localObject != null);
    if (paramow.e() == pb.d) {
      return super.d(paramow, paramqm);
    }
    throw paramqm.a(paramow, pb.f, "missing property '" + this.a + "' that is to contain type id  (for class " + c() + ")");
  }
  
  public String b()
  {
    return this.a;
  }
  
  public Object d(ow paramow, qm paramqm)
    throws IOException, oz
  {
    if (paramow.e() == pb.d) {
      return super.b(paramow, paramqm);
    }
    return a(paramow, paramqm);
  }
  
  protected Object f(ow paramow, qm paramqm)
    throws IOException, oz
  {
    switch (yp.a[paramow.e().ordinal()])
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return null;
            } while (!this.c.p().isAssignableFrom(String.class));
            return paramow.k();
          } while (!this.c.p().isAssignableFrom(Integer.class));
          return Integer.valueOf(paramow.t());
        } while (!this.c.p().isAssignableFrom(Double.class));
        return Double.valueOf(paramow.x());
      } while (!this.c.p().isAssignableFrom(Boolean.class));
      return Boolean.TRUE;
    } while (!this.c.p().isAssignableFrom(Boolean.class));
    return Boolean.FALSE;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/yo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */