package com.flurry.android.monolithic.sdk.impl;

final class zo
  extends zf
{
  protected final zf p;
  protected final Class<?> q;
  
  protected zo(zf paramzf, Class<?> paramClass)
  {
    super(paramzf);
    this.p = paramzf;
    this.q = paramClass;
  }
  
  public zf a(ra<Object> paramra)
  {
    return new zo(this.p.a(paramra), this.q);
  }
  
  public void a(Object paramObject, or paramor, ru paramru)
    throws Exception
  {
    Class localClass = paramru.a();
    if ((localClass == null) || (this.q.isAssignableFrom(localClass))) {
      this.p.a(paramObject, paramor, paramru);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/zo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */