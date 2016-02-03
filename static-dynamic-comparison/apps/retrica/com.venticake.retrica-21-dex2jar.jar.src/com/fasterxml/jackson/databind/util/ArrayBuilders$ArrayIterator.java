package com.fasterxml.jackson.databind.util;

import java.util.Iterator;
import java.util.NoSuchElementException;

final class ArrayBuilders$ArrayIterator<T>
  implements Iterable<T>, Iterator<T>
{
  private final T[] _array;
  private int _index;
  
  public ArrayBuilders$ArrayIterator(T[] paramArrayOfT)
  {
    this._array = paramArrayOfT;
    this._index = 0;
  }
  
  public boolean hasNext()
  {
    return this._index < this._array.length;
  }
  
  public Iterator<T> iterator()
  {
    return this;
  }
  
  public T next()
  {
    if (this._index >= this._array.length) {
      throw new NoSuchElementException();
    }
    Object[] arrayOfObject = this._array;
    int i = this._index;
    this._index = (i + 1);
    return (T)arrayOfObject[i];
  }
  
  public void remove()
  {
    throw new UnsupportedOperationException();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/util/ArrayBuilders$ArrayIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */