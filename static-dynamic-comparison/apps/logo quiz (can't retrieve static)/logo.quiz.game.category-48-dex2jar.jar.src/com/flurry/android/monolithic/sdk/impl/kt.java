package com.flurry.android.monolithic.sdk.impl;

import java.util.Iterator;

class kt
  implements Iterator<T>
{
  private int b = 0;
  
  kt(ks paramks) {}
  
  public boolean hasNext()
  {
    return this.b < ks.a(this.a);
  }
  
  public T next()
  {
    Object[] arrayOfObject = ks.b(this.a);
    int i = this.b;
    this.b = (i + 1);
    return (T)arrayOfObject[i];
  }
  
  public void remove()
  {
    throw new UnsupportedOperationException();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/kt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */