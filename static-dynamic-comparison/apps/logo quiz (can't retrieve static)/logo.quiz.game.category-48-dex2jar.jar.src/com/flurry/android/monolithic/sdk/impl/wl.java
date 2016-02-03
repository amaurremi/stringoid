package com.flurry.android.monolithic.sdk.impl;

final class wl
  extends we
{
  protected final aed<?> b;
  protected final xl c;
  
  protected wl(aed<?> paramaed, xl paramxl)
  {
    super(paramaed.a());
    this.b = paramaed;
    this.c = paramxl;
  }
  
  public Object b(String paramString, qm paramqm)
    throws qw
  {
    if (this.c != null) {}
    Enum localEnum;
    do
    {
      try
      {
        Object localObject1 = this.c.a(paramString);
        return localObject1;
      }
      catch (Exception localException)
      {
        adz.c(localException);
      }
      localEnum = this.b.a(paramString);
      Object localObject2 = localEnum;
    } while (localEnum != null);
    throw paramqm.a(this.a, paramString, "not one of values for Enum class");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/wl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */