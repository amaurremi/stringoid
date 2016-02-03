package com.flurry.android.monolithic.sdk.impl;

import java.io.IOException;

public abstract class abw<T>
  extends abc<T>
{
  protected final rx e;
  protected final qc f;
  
  protected abw(Class<T> paramClass, rx paramrx, qc paramqc)
  {
    super(paramClass);
    this.e = paramrx;
    this.f = paramqc;
  }
  
  public final void a(T paramT, or paramor, ru paramru)
    throws IOException, oq
  {
    paramor.b();
    b(paramT, paramor, paramru);
    paramor.c();
  }
  
  public final void a(T paramT, or paramor, ru paramru, rx paramrx)
    throws IOException, oq
  {
    paramrx.c(paramT, paramor);
    b(paramT, paramor, paramru);
    paramrx.f(paramT, paramor);
  }
  
  protected abstract void b(T paramT, or paramor, ru paramru)
    throws IOException, oq;
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/abw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */