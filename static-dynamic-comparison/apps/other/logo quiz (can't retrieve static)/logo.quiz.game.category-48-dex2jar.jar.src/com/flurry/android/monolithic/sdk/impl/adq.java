package com.flurry.android.monolithic.sdk.impl;

import java.util.Iterator;
import java.util.NoSuchElementException;

final class adq<T>
  implements Iterable<T>, Iterator<T>
{
  private final T[] a;
  private int b;
  
  public adq(T[] paramArrayOfT)
  {
    this.a = paramArrayOfT;
    this.b = 0;
  }
  
  public boolean hasNext()
  {
    return this.b < this.a.length;
  }
  
  public Iterator<T> iterator()
  {
    return this;
  }
  
  public T next()
  {
    if (this.b >= this.a.length) {
      throw new NoSuchElementException();
    }
    Object[] arrayOfObject = this.a;
    int i = this.b;
    this.b = (i + 1);
    return (T)arrayOfObject[i];
  }
  
  public void remove()
  {
    throw new UnsupportedOperationException();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/adq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */