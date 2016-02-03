package com.flurry.android.monolithic.sdk.impl;

public class st
  extends qp
{
  protected static final re[] a = new re[0];
  protected static final su[] b = new su[0];
  protected static final px[] c = new px[0];
  protected static final ti[] d = new ti[0];
  protected final qr[] e;
  protected final re[] f;
  protected final su[] g;
  protected final px[] h;
  protected final ti[] i;
  
  public st()
  {
    this(null, null, null, null, null);
  }
  
  protected st(qr[] paramArrayOfqr, re[] paramArrayOfre, su[] paramArrayOfsu, px[] paramArrayOfpx, ti[] paramArrayOfti)
  {
    qr[] arrayOfqr = paramArrayOfqr;
    if (paramArrayOfqr == null) {
      arrayOfqr = ss.a();
    }
    this.e = arrayOfqr;
    paramArrayOfqr = paramArrayOfre;
    if (paramArrayOfre == null) {
      paramArrayOfqr = a;
    }
    this.f = paramArrayOfqr;
    paramArrayOfqr = paramArrayOfsu;
    if (paramArrayOfsu == null) {
      paramArrayOfqr = b;
    }
    this.g = paramArrayOfqr;
    paramArrayOfqr = paramArrayOfpx;
    if (paramArrayOfpx == null) {
      paramArrayOfqr = c;
    }
    this.h = paramArrayOfqr;
    paramArrayOfqr = paramArrayOfti;
    if (paramArrayOfti == null) {
      paramArrayOfqr = d;
    }
    this.i = paramArrayOfqr;
  }
  
  public Iterable<qr> a()
  {
    return adp.b(this.e);
  }
  
  public Iterable<re> b()
  {
    return adp.b(this.f);
  }
  
  public Iterable<su> c()
  {
    return adp.b(this.g);
  }
  
  public Iterable<px> d()
  {
    return adp.b(this.h);
  }
  
  public Iterable<ti> e()
  {
    return adp.b(this.i);
  }
  
  public boolean f()
  {
    return this.f.length > 0;
  }
  
  public boolean g()
  {
    return this.g.length > 0;
  }
  
  public boolean h()
  {
    return this.h.length > 0;
  }
  
  public boolean i()
  {
    return this.i.length > 0;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/st.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */