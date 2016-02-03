package com.flurry.android.monolithic.sdk.impl;

import java.io.IOException;

public abstract class aay<T>
  extends abc<T>
  implements rp
{
  protected final boolean a;
  protected final afm b;
  protected final rx c;
  protected ra<Object> d;
  protected final qc e;
  protected aal f;
  
  protected aay(Class<?> paramClass, afm paramafm, boolean paramBoolean, rx paramrx, qc paramqc, ra<Object> paramra)
  {
    super(paramClass, false);
    this.b = paramafm;
    if (!paramBoolean)
    {
      paramBoolean = bool;
      if (paramafm != null)
      {
        paramBoolean = bool;
        if (!paramafm.u()) {}
      }
    }
    else
    {
      paramBoolean = true;
    }
    this.a = paramBoolean;
    this.c = paramrx;
    this.e = paramqc;
    this.d = paramra;
    this.f = aal.a();
  }
  
  protected final ra<Object> a(aal paramaal, afm paramafm, ru paramru)
    throws qw
  {
    paramafm = paramaal.a(paramafm, paramru, this.e);
    if (paramaal != paramafm.b) {
      this.f = paramafm.b;
    }
    return paramafm.a;
  }
  
  protected final ra<Object> a(aal paramaal, Class<?> paramClass, ru paramru)
    throws qw
  {
    paramClass = paramaal.a(paramClass, paramru, this.e);
    if (paramaal != paramClass.b) {
      this.f = paramClass.b;
    }
    return paramClass.a;
  }
  
  public void a(ru paramru)
    throws qw
  {
    if ((this.a) && (this.b != null) && (this.d == null)) {
      this.d = paramru.a(this.b, this.e);
    }
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/aay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */