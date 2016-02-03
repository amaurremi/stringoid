package com.flurry.android.monolithic.sdk.impl;

import java.util.AbstractList;
import java.util.Iterator;

public class ks<T>
  extends AbstractList<T>
  implements ko<T>, Comparable<ko<T>>
{
  private static final Object[] a = new Object[0];
  private final ji b;
  private int c;
  private Object[] d = a;
  
  public ks(int paramInt, ji paramji)
  {
    if ((paramji == null) || (!kj.c.equals(paramji.a()))) {
      throw new jg("Not an array schema: " + paramji);
    }
    this.b = paramji;
    if (paramInt != 0) {
      this.d = new Object[paramInt];
    }
  }
  
  public int a(ko<T> paramko)
  {
    return kq.a().a(this, paramko, a());
  }
  
  public ji a()
  {
    return this.b;
  }
  
  public void add(int paramInt, T paramT)
  {
    if ((paramInt > this.c) || (paramInt < 0)) {
      throw new IndexOutOfBoundsException("Index " + paramInt + " out of bounds.");
    }
    if (this.c == this.d.length)
    {
      Object[] arrayOfObject = new Object[this.c * 3 / 2 + 1];
      System.arraycopy(this.d, 0, arrayOfObject, 0, this.c);
      this.d = arrayOfObject;
    }
    System.arraycopy(this.d, paramInt, this.d, paramInt + 1, this.c - paramInt);
    this.d[paramInt] = paramT;
    this.c += 1;
  }
  
  public boolean add(T paramT)
  {
    if (this.c == this.d.length)
    {
      arrayOfObject = new Object[this.c * 3 / 2 + 1];
      System.arraycopy(this.d, 0, arrayOfObject, 0, this.c);
      this.d = arrayOfObject;
    }
    Object[] arrayOfObject = this.d;
    int i = this.c;
    this.c = (i + 1);
    arrayOfObject[i] = paramT;
    return true;
  }
  
  public T b()
  {
    if (this.c < this.d.length) {
      return (T)this.d[this.c];
    }
    return null;
  }
  
  public void clear()
  {
    this.c = 0;
  }
  
  public T get(int paramInt)
  {
    if (paramInt >= this.c) {
      throw new IndexOutOfBoundsException("Index " + paramInt + " out of bounds.");
    }
    return (T)this.d[paramInt];
  }
  
  public Iterator<T> iterator()
  {
    return new kt(this);
  }
  
  public T remove(int paramInt)
  {
    if (paramInt >= this.c) {
      throw new IndexOutOfBoundsException("Index " + paramInt + " out of bounds.");
    }
    Object localObject = this.d[paramInt];
    this.c -= 1;
    System.arraycopy(this.d, paramInt + 1, this.d, paramInt, this.c - paramInt);
    this.d[this.c] = null;
    return (T)localObject;
  }
  
  public T set(int paramInt, T paramT)
  {
    if (paramInt >= this.c) {
      throw new IndexOutOfBoundsException("Index " + paramInt + " out of bounds.");
    }
    Object localObject = this.d[paramInt];
    this.d[paramInt] = paramT;
    return (T)localObject;
  }
  
  public int size()
  {
    return this.c;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("[");
    int i = 0;
    Iterator localIterator = iterator();
    if (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (localObject == null) {}
      for (localObject = "null";; localObject = localObject.toString())
      {
        localStringBuffer.append((String)localObject);
        int j = i + 1;
        i = j;
        if (j >= size()) {
          break;
        }
        localStringBuffer.append(", ");
        i = j;
        break;
      }
    }
    localStringBuffer.append("]");
    return localStringBuffer.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/ks.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */