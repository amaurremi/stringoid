package com.vungle.publisher;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractCollection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Queue;

public final class cr<E>
  extends AbstractCollection<E>
  implements Serializable, Cloneable, Queue<E>
{
  private transient Object[] a = new Object[16];
  private transient int b;
  private transient int c;
  
  private cr<E> a()
  {
    try
    {
      cr localcr = (cr)super.clone();
      Object[] arrayOfObject = (Object[])Array.newInstance(this.a.getClass().getComponentType(), this.a.length);
      System.arraycopy(this.a, 0, arrayOfObject, 0, this.a.length);
      localcr.a = arrayOfObject;
      return localcr;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      throw new AssertionError();
    }
  }
  
  private boolean a(int paramInt)
  {
    Object[] arrayOfObject = this.a;
    int i = arrayOfObject.length - 1;
    int j = this.b;
    int k = this.c;
    int m = paramInt - j & i;
    int n = k - paramInt & i;
    if (m >= (k - j & i)) {
      throw new ConcurrentModificationException();
    }
    if (m < n)
    {
      if (j <= paramInt) {
        System.arraycopy(arrayOfObject, j, arrayOfObject, j + 1, m);
      }
      for (;;)
      {
        arrayOfObject[j] = null;
        this.b = (j + 1 & i);
        return false;
        System.arraycopy(arrayOfObject, 0, arrayOfObject, 1, paramInt);
        arrayOfObject[0] = arrayOfObject[i];
        System.arraycopy(arrayOfObject, j, arrayOfObject, j + 1, i - j);
      }
    }
    if (paramInt < k) {
      System.arraycopy(arrayOfObject, paramInt + 1, arrayOfObject, paramInt, n);
    }
    for (this.c = (k - 1);; this.c = (k - 1 & i))
    {
      return true;
      System.arraycopy(arrayOfObject, paramInt + 1, arrayOfObject, paramInt, i - paramInt);
      arrayOfObject[i] = arrayOfObject[0];
      System.arraycopy(arrayOfObject, 1, arrayOfObject, 0, k);
    }
  }
  
  public final boolean add(E paramE)
  {
    if (paramE == null) {
      throw new NullPointerException("e == null");
    }
    this.a[this.c] = paramE;
    int i = this.c + 1 & this.a.length - 1;
    this.c = i;
    if (i == this.b)
    {
      i = this.b;
      int j = this.a.length;
      int k = j - i;
      int m = j << 1;
      if (m < 0) {
        throw new IllegalStateException("Sorry, queue too big");
      }
      paramE = new Object[m];
      System.arraycopy(this.a, i, paramE, 0, k);
      System.arraycopy(this.a, 0, paramE, k, i);
      this.a = paramE;
      this.b = 0;
      this.c = j;
    }
    return true;
  }
  
  public final void clear()
  {
    int i = this.b;
    int k = this.c;
    if (i != k)
    {
      this.c = 0;
      this.b = 0;
      int m = this.a.length;
      int j;
      do
      {
        this.a[i] = null;
        j = i + 1 & m - 1;
        i = j;
      } while (j != k);
    }
  }
  
  public final boolean contains(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    int j = this.a.length;
    for (int i = this.b;; i = i + 1 & j - 1)
    {
      Object localObject = this.a[i];
      if (localObject == null) {
        break;
      }
      if (paramObject.equals(localObject)) {
        return true;
      }
    }
    return false;
  }
  
  public final E element()
  {
    Object localObject = this.a[this.b];
    if (localObject == null) {
      throw new NoSuchElementException();
    }
    return (E)localObject;
  }
  
  public final boolean isEmpty()
  {
    return this.b == this.c;
  }
  
  public final Iterator<E> iterator()
  {
    return new a((byte)0);
  }
  
  public final boolean offer(E paramE)
  {
    return add(paramE);
  }
  
  public final E peek()
  {
    return (E)this.a[this.b];
  }
  
  public final E poll()
  {
    int i = this.b;
    Object localObject = this.a[i];
    if (localObject == null) {
      return null;
    }
    this.a[i] = null;
    this.b = (i + 1 & this.a.length - 1);
    return (E)localObject;
  }
  
  public final E remove()
  {
    Object localObject = poll();
    if (localObject == null) {
      throw new NoSuchElementException();
    }
    return (E)localObject;
  }
  
  public final boolean remove(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    int j = this.a.length;
    for (int i = this.b;; i = i + 1 & j - 1)
    {
      Object localObject = this.a[i];
      if (localObject == null) {
        break;
      }
      if (paramObject.equals(localObject))
      {
        a(i);
        return true;
      }
    }
    return false;
  }
  
  public final int size()
  {
    return this.c - this.b & this.a.length - 1;
  }
  
  public final Object[] toArray()
  {
    return toArray(new Object[size()]);
  }
  
  public final <T> T[] toArray(T[] paramArrayOfT)
  {
    int i = size();
    Object localObject = paramArrayOfT;
    if (paramArrayOfT.length < i) {
      localObject = (Object[])Array.newInstance(paramArrayOfT.getClass().getComponentType(), i);
    }
    if (this.b < this.c) {
      System.arraycopy(this.a, this.b, localObject, 0, size());
    }
    for (;;)
    {
      if (localObject.length > i) {
        localObject[i] = null;
      }
      return (T[])localObject;
      if (this.b > this.c)
      {
        int j = this.a.length - this.b;
        System.arraycopy(this.a, this.b, localObject, 0, j);
        System.arraycopy(this.a, 0, localObject, j, this.c);
      }
    }
  }
  
  final class a
    implements Iterator<E>
  {
    private int b = cr.a(cr.this);
    private int c = cr.b(cr.this);
    private int d = -1;
    
    private a() {}
    
    public final boolean hasNext()
    {
      return this.b != this.c;
    }
    
    public final E next()
    {
      if (this.b == this.c) {
        throw new NoSuchElementException();
      }
      Object localObject = cr.c(cr.this)[this.b];
      if ((cr.b(cr.this) != this.c) || (localObject == null)) {
        throw new ConcurrentModificationException();
      }
      this.d = this.b;
      this.b = (this.b + 1 & cr.c(cr.this).length - 1);
      return (E)localObject;
    }
    
    public final void remove()
    {
      if (this.d < 0) {
        throw new IllegalStateException();
      }
      if (cr.a(cr.this, this.d))
      {
        this.b = (this.b - 1 & cr.c(cr.this).length - 1);
        this.c = cr.b(cr.this);
      }
      this.d = -1;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/cr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */