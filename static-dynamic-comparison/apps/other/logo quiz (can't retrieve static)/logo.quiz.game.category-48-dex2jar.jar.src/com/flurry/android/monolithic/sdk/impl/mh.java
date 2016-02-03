package com.flurry.android.monolithic.sdk.impl;

import java.io.IOException;

public class mh
  extends mi
{
  private lx d;
  
  static
  {
    if (!mh.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      b = bool;
      return;
    }
  }
  
  mh(ji paramji1, ji paramji2, lx paramlx)
    throws IOException
  {
    this(a(paramji1, paramji2), paramlx);
  }
  
  private mh(Object paramObject, lx paramlx)
    throws IOException
  {
    super((mq)paramObject, paramlx);
  }
  
  public static Object a(ji paramji1, ji paramji2)
    throws IOException
  {
    if (paramji1 == null) {
      throw new NullPointerException("writer cannot be null!");
    }
    if (paramji2 == null) {
      throw new NullPointerException("reader cannot be null!");
    }
    return new ml().a(paramji1, paramji2);
  }
  
  public mq a(mq parammq1, mq parammq2)
    throws IOException
  {
    if ((parammq2 instanceof mw))
    {
      if (parammq1 == mq.s) {
        return parammq2;
      }
      return null;
    }
    if ((parammq2 instanceof nc))
    {
      parammq2 = (nc)parammq2;
      if (parammq2.B != parammq1) {
        throw new jh("Found " + parammq2.B + " while looking for " + parammq1);
      }
      return parammq2.z;
    }
    if ((parammq2 instanceof ng))
    {
      parammq1 = ((ng)parammq2).z;
      this.a.d(parammq1);
    }
    for (;;)
    {
      return null;
      if ((parammq2 instanceof nj))
      {
        parammq1 = (ms)this.a.c();
        this.a.c(parammq1.a(this.c.s()));
      }
      else
      {
        if ((parammq2 instanceof mv)) {
          throw new jh(((mv)parammq2).z);
        }
        if ((parammq2 instanceof mt))
        {
          parammq1 = (mt)parammq2;
          this.d = this.c;
          this.c = ly.a().a(parammq1.z, null);
        }
        else
        {
          if (parammq2 != mq.x) {
            break;
          }
          this.c = this.d;
        }
      }
    }
    throw new jh("Unknown action: " + parammq2);
  }
  
  public long e()
    throws IOException
  {
    mq localmq = this.a.a(mq.f);
    if (localmq == mq.e) {
      return this.c.d();
    }
    if (localmq == mq.h) {
      return this.c.g();
    }
    if ((!b) && (localmq != mq.f)) {
      throw new AssertionError();
    }
    return this.c.e();
  }
  
  public float f()
    throws IOException
  {
    mq localmq = this.a.a(mq.g);
    if (localmq == mq.e) {
      return this.c.d();
    }
    if (localmq == mq.f) {
      return (float)this.c.e();
    }
    if ((!b) && (localmq != mq.g)) {
      throw new AssertionError();
    }
    return this.c.f();
  }
  
  public double g()
    throws IOException
  {
    mq localmq = this.a.a(mq.h);
    if (localmq == mq.e) {
      return this.c.d();
    }
    if (localmq == mq.f) {
      return this.c.e();
    }
    if (localmq == mq.g) {
      return this.c.f();
    }
    if ((!b) && (localmq != mq.h)) {
      throw new AssertionError();
    }
    return this.c.g();
  }
  
  public int k()
    throws IOException
  {
    this.a.a(mq.l);
    Object localObject = (mu)this.a.c();
    int i = this.c.k();
    localObject = localObject.z[i];
    if ((localObject instanceof Integer)) {
      return ((Integer)localObject).intValue();
    }
    throw new jh((String)localObject);
  }
  
  public void l()
    throws IOException
  {
    Object localObject = this.a.c();
    if ((localObject instanceof nc)) {
      this.a.c(((nc)localObject).z);
    }
    do
    {
      return;
      if ((localObject instanceof ng))
      {
        this.a.c(((ng)localObject).z);
        return;
      }
      if ((localObject instanceof nj))
      {
        localObject = (ms)this.a.c();
        this.a.c(((ms)localObject).a(this.c.s()));
        return;
      }
      if ((localObject instanceof mv)) {
        throw new jh(((mv)localObject).z);
      }
      if ((localObject instanceof mt))
      {
        localObject = (mt)localObject;
        this.d = this.c;
        this.c = ly.a().a(((mt)localObject).z, null);
        return;
      }
    } while (localObject != mq.x);
    this.c = this.d;
  }
  
  public int s()
    throws IOException
  {
    this.a.a(mq.m);
    ni localni = (ni)this.a.c();
    this.a.c(localni.B);
    return localni.z;
  }
  
  public final js[] u()
    throws IOException
  {
    return ((mw)this.a.a(mq.s)).z;
  }
  
  public final void v()
    throws IOException
  {
    this.a.a();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/mh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */