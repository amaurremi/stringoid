package com.flurry.android.monolithic.sdk.impl;

import com.flurry.org.codehaus.jackson.annotate.JsonTypeInfo.As;
import java.io.IOException;

public class yk
  extends yy
{
  public yk(afm paramafm, yi paramyi, qc paramqc, Class<?> paramClass)
  {
    super(paramafm, paramyi, paramqc, paramClass);
  }
  
  private final Object f(ow paramow, qm paramqm)
    throws IOException, oz
  {
    boolean bool = paramow.j();
    Object localObject = a(paramqm, e(paramow, paramqm)).a(paramow, paramqm);
    if ((bool) && (paramow.b() != pb.e)) {
      throw paramqm.a(paramow, pb.e, "expected closing END_ARRAY after type information and deserialized value");
    }
    return localObject;
  }
  
  public JsonTypeInfo.As a()
  {
    return JsonTypeInfo.As.WRAPPER_ARRAY;
  }
  
  public Object a(ow paramow, qm paramqm)
    throws IOException, oz
  {
    return f(paramow, paramqm);
  }
  
  public Object b(ow paramow, qm paramqm)
    throws IOException, oz
  {
    return f(paramow, paramqm);
  }
  
  public Object c(ow paramow, qm paramqm)
    throws IOException, oz
  {
    return f(paramow, paramqm);
  }
  
  public Object d(ow paramow, qm paramqm)
    throws IOException, oz
  {
    return f(paramow, paramqm);
  }
  
  protected final String e(ow paramow, qm paramqm)
    throws IOException, oz
  {
    if (!paramow.j())
    {
      if (((this.b instanceof yz)) && (this.e != null)) {
        return ((yz)this.b).a();
      }
      throw paramqm.a(paramow, pb.d, "need JSON Array to contain As.WRAPPER_ARRAY type information for class " + c());
    }
    if (paramow.b() != pb.h)
    {
      if (((this.b instanceof yz)) && (this.e != null)) {
        return ((yz)this.b).a();
      }
      throw paramqm.a(paramow, pb.h, "need JSON String that contains type id (for subtype of " + c() + ")");
    }
    paramqm = paramow.k();
    paramow.b();
    return paramqm;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/yk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */