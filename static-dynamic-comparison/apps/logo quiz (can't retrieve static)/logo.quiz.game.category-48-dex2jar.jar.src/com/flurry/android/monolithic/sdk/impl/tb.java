package com.flurry.android.monolithic.sdk.impl;

public final class tb
{
  private final Object a;
  private final boolean b;
  private final Class<?> c;
  
  protected tb(afm paramafm, Object paramObject)
  {
    this.a = paramObject;
    this.b = paramafm.t();
    this.c = paramafm.p();
  }
  
  public Object a(qm paramqm)
    throws oz
  {
    if ((this.b) && (paramqm.a(ql.l))) {
      throw paramqm.b("Can not map JSON null into type " + this.c.getName() + " (set DeserializationConfig.Feature.FAIL_ON_NULL_FOR_PRIMITIVES to 'false' to allow)");
    }
    return this.a;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/tb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */