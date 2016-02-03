package com.flurry.android.monolithic.sdk.impl;

public class zj
  extends rt
{
  protected static final rv[] a = new rv[0];
  protected static final zk[] b = new zk[0];
  protected final rv[] c;
  protected final rv[] d;
  protected final zk[] e;
  
  public zj()
  {
    this(null, null, null);
  }
  
  protected zj(rv[] paramArrayOfrv1, rv[] paramArrayOfrv2, zk[] paramArrayOfzk)
  {
    rv[] arrayOfrv = paramArrayOfrv1;
    if (paramArrayOfrv1 == null) {
      arrayOfrv = a;
    }
    this.c = arrayOfrv;
    paramArrayOfrv1 = paramArrayOfrv2;
    if (paramArrayOfrv2 == null) {
      paramArrayOfrv1 = a;
    }
    this.d = paramArrayOfrv1;
    paramArrayOfrv1 = paramArrayOfzk;
    if (paramArrayOfzk == null) {
      paramArrayOfrv1 = b;
    }
    this.e = paramArrayOfrv1;
  }
  
  public boolean a()
  {
    return this.d.length > 0;
  }
  
  public boolean b()
  {
    return this.e.length > 0;
  }
  
  public Iterable<rv> c()
  {
    return adp.b(this.c);
  }
  
  public Iterable<rv> d()
  {
    return adp.b(this.d);
  }
  
  public Iterable<zk> e()
  {
    return adp.b(this.e);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/zj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */