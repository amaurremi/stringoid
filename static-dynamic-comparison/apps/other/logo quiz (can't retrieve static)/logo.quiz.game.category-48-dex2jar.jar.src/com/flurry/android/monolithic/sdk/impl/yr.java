package com.flurry.android.monolithic.sdk.impl;

import com.flurry.org.codehaus.jackson.annotate.JsonTypeInfo.As;
import java.io.IOException;

public class yr
  extends yy
{
  public yr(afm paramafm, yi paramyi, qc paramqc, Class<?> paramClass)
  {
    super(paramafm, paramyi, paramqc, null);
  }
  
  private final Object e(ow paramow, qm paramqm)
    throws IOException, oz
  {
    if (paramow.e() != pb.b) {
      throw paramqm.a(paramow, pb.b, "need JSON Object to contain As.WRAPPER_OBJECT type information for class " + c());
    }
    if (paramow.b() != pb.f) {
      throw paramqm.a(paramow, pb.f, "need JSON String that contains type id (for subtype of " + c() + ")");
    }
    Object localObject = a(paramqm, paramow.k());
    paramow.b();
    localObject = ((qu)localObject).a(paramow, paramqm);
    if (paramow.b() != pb.c) {
      throw paramqm.a(paramow, pb.c, "expected closing END_OBJECT after type information and deserialized value");
    }
    return localObject;
  }
  
  public JsonTypeInfo.As a()
  {
    return JsonTypeInfo.As.WRAPPER_OBJECT;
  }
  
  public Object a(ow paramow, qm paramqm)
    throws IOException, oz
  {
    return e(paramow, paramqm);
  }
  
  public Object b(ow paramow, qm paramqm)
    throws IOException, oz
  {
    return e(paramow, paramqm);
  }
  
  public Object c(ow paramow, qm paramqm)
    throws IOException, oz
  {
    return e(paramow, paramqm);
  }
  
  public Object d(ow paramow, qm paramqm)
    throws IOException, oz
  {
    return e(paramow, paramqm);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/yr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */