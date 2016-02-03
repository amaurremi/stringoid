package com.flurry.android.monolithic.sdk.impl;

import java.io.IOException;
import java.util.EnumMap;

public class uk
  extends vo<EnumMap<?, ?>>
{
  protected final Class<?> a;
  protected final qu<Enum<?>> b;
  protected final qu<Object> c;
  
  public uk(Class<?> paramClass, qu<?> paramqu, qu<Object> paramqu1)
  {
    super(EnumMap.class);
    this.a = paramClass;
    this.b = paramqu;
    this.c = paramqu1;
  }
  
  private EnumMap<?, ?> d()
  {
    return new EnumMap(this.a);
  }
  
  public Object a(ow paramow, qm paramqm, rw paramrw)
    throws IOException, oz
  {
    return paramrw.a(paramow, paramqm);
  }
  
  public EnumMap<?, ?> b(ow paramow, qm paramqm)
    throws IOException, oz
  {
    if (paramow.e() != pb.b) {
      throw paramqm.b(EnumMap.class);
    }
    EnumMap localEnumMap = d();
    if (paramow.b() != pb.c)
    {
      Enum localEnum = (Enum)this.b.a(paramow, paramqm);
      if (localEnum == null) {
        throw paramqm.b(this.a, "value not one of declared Enum instance names");
      }
      if (paramow.b() == pb.m) {}
      for (Object localObject = null;; localObject = this.c.a(paramow, paramqm))
      {
        localEnumMap.put(localEnum, localObject);
        break;
      }
    }
    return localEnumMap;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/uk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */