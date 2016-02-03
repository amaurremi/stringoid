package com.flurry.android.monolithic.sdk.impl;

import java.io.IOException;
import java.util.EnumSet;

public class ul
  extends vo<EnumSet<?>>
{
  protected final Class<Enum> a;
  protected final qu<Enum<?>> b;
  
  public ul(Class<?> paramClass, qu<?> paramqu)
  {
    super(EnumSet.class);
    this.a = paramClass;
    this.b = paramqu;
  }
  
  private EnumSet d()
  {
    return EnumSet.noneOf(this.a);
  }
  
  public Object a(ow paramow, qm paramqm, rw paramrw)
    throws IOException, oz
  {
    return paramrw.b(paramow, paramqm);
  }
  
  public EnumSet<?> b(ow paramow, qm paramqm)
    throws IOException, oz
  {
    if (!paramow.j()) {
      throw paramqm.b(EnumSet.class);
    }
    EnumSet localEnumSet = d();
    for (;;)
    {
      pb localpb = paramow.b();
      if (localpb == pb.e) {
        break;
      }
      if (localpb == pb.m) {
        throw paramqm.b(this.a);
      }
      localEnumSet.add((Enum)this.b.a(paramow, paramqm));
    }
    return localEnumSet;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/ul.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */