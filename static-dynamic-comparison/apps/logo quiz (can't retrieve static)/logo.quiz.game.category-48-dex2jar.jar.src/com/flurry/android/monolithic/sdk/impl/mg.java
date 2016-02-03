package com.flurry.android.monolithic.sdk.impl;

import java.io.IOException;

public abstract class mg
  extends lx
  implements mk, mp
{
  protected final mo a = new mo(parammq, this, this);
  
  protected mg(mq parammq)
    throws IOException
  {}
  
  protected abstract void a()
    throws IOException;
  
  public void l()
    throws IOException
  {
    this.a.c();
  }
  
  public void t()
    throws IOException
  {
    mq localmq = this.a.d();
    if (localmq == mq.c) {
      b();
    }
    if (localmq == mq.d) {
      c();
    }
    do
    {
      return;
      if (localmq == mq.e)
      {
        d();
        return;
      }
      if (localmq == mq.f)
      {
        e();
        return;
      }
      if (localmq == mq.g)
      {
        f();
        return;
      }
      if (localmq == mq.h)
      {
        g();
        return;
      }
      if (localmq == mq.i)
      {
        i();
        return;
      }
      if (localmq == mq.j)
      {
        j();
        return;
      }
      if (localmq == mq.l)
      {
        k();
        return;
      }
      if (localmq == mq.k)
      {
        a();
        return;
      }
      if (localmq == mq.m)
      {
        s();
        return;
      }
      if (localmq == mq.n)
      {
        o();
        return;
      }
    } while (localmq != mq.p);
    r();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/mg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */