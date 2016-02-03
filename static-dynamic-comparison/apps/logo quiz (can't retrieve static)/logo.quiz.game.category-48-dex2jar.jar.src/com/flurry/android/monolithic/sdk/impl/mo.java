package com.flurry.android.monolithic.sdk.impl;

import java.io.IOException;

public class mo
  extends mj
{
  private final mp e;
  
  static
  {
    if (!mo.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      d = bool;
      return;
    }
  }
  
  public mo(mq parammq, mk parammk, mp parammp)
    throws IOException
  {
    super(parammq, parammk);
    this.e = parammp;
  }
  
  public final void a(int paramInt)
    throws IOException
  {
    while (paramInt < this.c)
    {
      mq localmq = this.b[(this.c - 1)];
      if (localmq.a != na.a)
      {
        if ((localmq.a == na.f) || (localmq.a == na.g))
        {
          this.e.l();
        }
        else
        {
          this.c -= 1;
          b(localmq);
        }
      }
      else {
        this.e.t();
      }
    }
  }
  
  public final void d(mq parammq)
    throws IOException
  {
    int i = this.c;
    c(parammq);
    a(i);
  }
  
  public final void f()
    throws IOException
  {
    int i = this.c;
    Object localObject = this.b;
    int j = this.c - 1;
    this.c = j;
    localObject = localObject[j];
    if ((!d) && (((mq)localObject).a != na.d)) {
      throw new AssertionError();
    }
    b((mq)localObject);
    a(i);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/mo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */