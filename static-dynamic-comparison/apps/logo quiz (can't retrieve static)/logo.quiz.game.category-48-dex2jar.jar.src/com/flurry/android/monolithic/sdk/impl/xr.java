package com.flurry.android.monolithic.sdk.impl;

public class xr
  extends qf<xq>
{
  protected static final xq a;
  protected static final xq b;
  protected static final xq c;
  protected static final xq d;
  @Deprecated
  public static final xt e = new xt(null);
  @Deprecated
  public static final xw f = new xw();
  @Deprecated
  public static final xv g = new xv();
  protected static final xz h = new xu(null);
  public static final xr i = new xr();
  
  static
  {
    xh localxh = xh.b(String.class, null, null);
    a = xq.a(null, adh.d(String.class), localxh);
    localxh = xh.b(Boolean.TYPE, null, null);
    b = xq.a(null, adh.d(Boolean.TYPE), localxh);
    localxh = xh.b(Integer.TYPE, null, null);
    c = xq.a(null, adh.d(Integer.TYPE), localxh);
    localxh = xh.b(Long.TYPE, null, null);
    d = xq.a(null, adh.d(Long.TYPE), localxh);
  }
  
  protected xq a(afm paramafm)
  {
    paramafm = paramafm.p();
    if (paramafm == String.class) {
      return a;
    }
    if (paramafm == Boolean.TYPE) {
      return b;
    }
    if (paramafm == Integer.TYPE) {
      return c;
    }
    if (paramafm == Long.TYPE) {
      return d;
    }
    return null;
  }
  
  public yb a(rf<?> paramrf, afm paramafm, qg paramqg, boolean paramBoolean)
  {
    paramqg = c(paramrf, paramafm, paramqg);
    paramqg.a(h);
    paramqg.n();
    return a(paramrf, paramqg, paramafm, paramBoolean).k();
  }
  
  protected yb a(rf<?> paramrf, xh paramxh, afm paramafm, boolean paramBoolean)
  {
    return new yb(paramrf, paramBoolean, paramafm, paramxh);
  }
  
  public xq b(rf<?> paramrf, afm paramafm, qg paramqg)
  {
    boolean bool = paramrf.b();
    py localpy = paramrf.a();
    Class localClass = paramafm.p();
    if (bool) {}
    for (;;)
    {
      return xq.a(paramrf, paramafm, xh.a(localClass, localpy, paramqg));
      localpy = null;
    }
  }
  
  public xq b(rq paramrq, afm paramafm, qg paramqg)
  {
    xq localxq2 = a(paramafm);
    xq localxq1 = localxq2;
    if (localxq2 == null) {
      localxq1 = xq.b(a(paramrq, paramafm, paramqg, true));
    }
    return localxq1;
  }
  
  public xh c(rf<?> paramrf, afm paramafm, qg paramqg)
  {
    boolean bool = paramrf.b();
    paramrf = paramrf.a();
    paramafm = paramafm.p();
    if (bool) {}
    for (;;)
    {
      paramrf = xh.a(paramafm, paramrf, paramqg);
      paramrf.a(h);
      paramrf.a(true);
      return paramrf;
      paramrf = null;
    }
  }
  
  public xq c(qk paramqk, afm paramafm, qg paramqg)
  {
    xq localxq2 = a(paramafm);
    xq localxq1 = localxq2;
    if (localxq2 == null) {
      localxq1 = xq.a(a(paramqk, paramafm, paramqg, false));
    }
    return localxq1;
  }
  
  public xq d(qk paramqk, afm paramafm, qg paramqg)
  {
    xq localxq2 = a(paramafm);
    xq localxq1 = localxq2;
    if (localxq2 == null) {
      localxq1 = xq.a(a(paramqk, paramafm, paramqg, false));
    }
    return localxq1;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/xr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */