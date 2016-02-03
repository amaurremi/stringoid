package com.flurry.android.monolithic.sdk.impl;

public class qd
  implements qc
{
  protected final String a;
  protected final afm b;
  protected final xk c;
  protected final ado d;
  
  public qd(String paramString, afm paramafm, ado paramado, xk paramxk)
  {
    this.a = paramString;
    this.b = paramafm;
    this.c = paramxk;
    this.d = paramado;
  }
  
  public afm a()
  {
    return this.b;
  }
  
  public qd a(afm paramafm)
  {
    return new qd(this.a, paramafm, this.d, this.c);
  }
  
  public xk b()
  {
    return this.c;
  }
  
  public String c()
  {
    return this.a;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/qd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */