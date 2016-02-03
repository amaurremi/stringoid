package com.flurry.android.monolithic.sdk.impl;

import java.io.IOException;

public class mj
{
  protected final mk a;
  protected mq[] b;
  protected int c;
  
  public mj(mq parammq, mk parammk)
    throws IOException
  {
    this.a = parammk;
    this.b = new mq[5];
    this.b[0] = parammq;
    this.c = 1;
  }
  
  private void f()
  {
    mq[] arrayOfmq = new mq[this.b.length + Math.max(this.b.length, 1024)];
    System.arraycopy(this.b, 0, arrayOfmq, 0, this.b.length);
    this.b = arrayOfmq;
  }
  
  public final mq a(mq parammq)
    throws IOException
  {
    for (;;)
    {
      Object localObject = this.b;
      int i = this.c - 1;
      this.c = i;
      localObject = localObject[i];
      if (localObject == parammq) {
        return (mq)localObject;
      }
      na localna = ((mq)localObject).a;
      if (localna == na.f)
      {
        localObject = this.a.a(parammq, (mq)localObject);
        if (localObject != null) {
          return (mq)localObject;
        }
      }
      else
      {
        if (localna == na.a) {
          throw new jh("Attempt to process a " + parammq + " when a " + localObject + " was expected.");
        }
        if ((localna == na.d) && (parammq == ((nb)localObject).z)) {
          return parammq;
        }
        b((mq)localObject);
      }
    }
  }
  
  public final void a()
    throws IOException
  {
    while (this.c > 1)
    {
      mq localmq = this.b[(this.c - 1)];
      if (localmq.a == na.f)
      {
        this.c -= 1;
        this.a.a(null, localmq);
      }
      else
      {
        if (localmq.a == na.a) {
          break;
        }
        this.c -= 1;
        b(localmq);
      }
    }
  }
  
  public final void b()
    throws IOException
  {
    while (this.c >= 1)
    {
      mq localmq = this.b[(this.c - 1)];
      if ((localmq.a != na.f) || (!((my)localmq).A)) {
        break;
      }
      this.c -= 1;
      this.a.a(null, localmq);
    }
  }
  
  public final void b(mq parammq)
  {
    parammq = parammq.b;
    while (this.c + parammq.length > this.b.length) {
      f();
    }
    System.arraycopy(parammq, 0, this.b, this.c, parammq.length);
    int i = this.c;
    this.c = (parammq.length + i);
  }
  
  public mq c()
  {
    mq[] arrayOfmq = this.b;
    int i = this.c - 1;
    this.c = i;
    return arrayOfmq[i];
  }
  
  public void c(mq parammq)
  {
    if (this.c == this.b.length) {
      f();
    }
    mq[] arrayOfmq = this.b;
    int i = this.c;
    this.c = (i + 1);
    arrayOfmq[i] = parammq;
  }
  
  public mq d()
  {
    return this.b[(this.c - 1)];
  }
  
  public void e()
  {
    this.c = 1;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/mj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */