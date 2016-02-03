package com.flurry.android.monolithic.sdk.impl;

import java.util.Iterator;
import java.util.NoSuchElementException;

class nf
  implements Iterator<mq>
{
  private int b = this.a.b.length;
  
  nf(ne paramne) {}
  
  public mq a()
  {
    if (this.b > 0)
    {
      mq[] arrayOfmq = this.a.b;
      int i = this.b - 1;
      this.b = i;
      return arrayOfmq[i];
    }
    throw new NoSuchElementException();
  }
  
  public boolean hasNext()
  {
    return this.b > 0;
  }
  
  public void remove()
  {
    throw new UnsupportedOperationException();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/nf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */