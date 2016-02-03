package com.flurry.android.monolithic.sdk.impl;

import java.util.List;

public class zh
{
  private static final zf[] f = new zf[0];
  protected final xq a;
  protected List<zf> b;
  protected zf[] c;
  protected zc d;
  protected Object e;
  
  public zh(xq paramxq)
  {
    this.a = paramxq;
  }
  
  public List<zf> a()
  {
    return this.b;
  }
  
  public void a(zc paramzc)
  {
    this.d = paramzc;
  }
  
  public void a(Object paramObject)
  {
    this.e = paramObject;
  }
  
  public void a(List<zf> paramList)
  {
    this.b = paramList;
  }
  
  public void a(zf[] paramArrayOfzf)
  {
    this.c = paramArrayOfzf;
  }
  
  public ra<?> b()
  {
    if ((this.b == null) || (this.b.isEmpty())) {
      if (this.d == null) {
        return null;
      }
    }
    for (zf[] arrayOfzf = f;; arrayOfzf = (zf[])this.b.toArray(new zf[this.b.size()])) {
      return new zg(this.a.a(), arrayOfzf, this.c, this.d, this.e);
    }
  }
  
  public zg c()
  {
    return zg.a(this.a.b());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/zh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */