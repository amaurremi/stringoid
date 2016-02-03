package com.flurry.android.monolithic.sdk.impl;

import java.io.IOException;
import java.lang.reflect.Method;

public final class sv
{
  protected final qc a;
  protected final Method b;
  protected final afm c;
  protected qu<Object> d;
  
  public sv(qc paramqc, xl paramxl, afm paramafm, qu<Object> paramqu)
  {
    this(paramqc, paramxl.e(), paramafm, paramqu);
  }
  
  public sv(qc paramqc, Method paramMethod, afm paramafm, qu<Object> paramqu)
  {
    this.a = paramqc;
    this.c = paramafm;
    this.b = paramMethod;
    this.d = paramqu;
  }
  
  private String d()
  {
    return this.b.getDeclaringClass().getName();
  }
  
  public qc a()
  {
    return this.a;
  }
  
  public sv a(qu<Object> paramqu)
  {
    return new sv(this.a, this.b, this.c, paramqu);
  }
  
  public final Object a(ow paramow, qm paramqm)
    throws IOException, oz
  {
    if (paramow.e() == pb.m) {
      return null;
    }
    return this.d.a(paramow, paramqm);
  }
  
  public final void a(ow paramow, qm paramqm, Object paramObject, String paramString)
    throws IOException, oz
  {
    a(paramObject, paramString, a(paramow, paramqm));
  }
  
  protected void a(Exception paramException, String paramString, Object paramObject)
    throws IOException
  {
    if ((paramException instanceof IllegalArgumentException))
    {
      if (paramObject == null)
      {
        paramObject = "[NULL]";
        paramString = new StringBuilder("Problem deserializing \"any\" property '").append(paramString);
        paramString.append("' of class " + d() + " (expected type: ").append(this.c);
        paramString.append("; actual type: ").append((String)paramObject).append(")");
        paramObject = paramException.getMessage();
        if (paramObject == null) {
          break label128;
        }
        paramString.append(", problem: ").append((String)paramObject);
      }
      for (;;)
      {
        throw new qw(paramString.toString(), null, paramException);
        paramObject = paramObject.getClass().getName();
        break;
        label128:
        paramString.append(" (no error message provided)");
      }
    }
    if ((paramException instanceof IOException)) {
      throw ((IOException)paramException);
    }
    paramString = paramException;
    if ((paramException instanceof RuntimeException)) {
      throw ((RuntimeException)paramException);
    }
    while (paramString.getCause() != null) {
      paramString = paramString.getCause();
    }
    throw new qw(paramString.getMessage(), null, paramString);
  }
  
  public final void a(Object paramObject1, String paramString, Object paramObject2)
    throws IOException
  {
    try
    {
      this.b.invoke(paramObject1, new Object[] { paramString, paramObject2 });
      return;
    }
    catch (Exception paramObject1)
    {
      a((Exception)paramObject1, paramString, paramObject2);
    }
  }
  
  public boolean b()
  {
    return this.d != null;
  }
  
  public afm c()
  {
    return this.c;
  }
  
  public String toString()
  {
    return "[any property on class " + d() + "]";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/sv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */