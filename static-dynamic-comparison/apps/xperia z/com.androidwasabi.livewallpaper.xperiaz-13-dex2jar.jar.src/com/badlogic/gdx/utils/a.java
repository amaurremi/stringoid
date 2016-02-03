package com.badlogic.gdx.utils;

import java.util.Iterator;

public class a<T>
  implements Iterable<T>
{
  public T[] a;
  public int b;
  public boolean c;
  private b d;
  
  public a()
  {
    this(true, 16);
  }
  
  public a(int paramInt)
  {
    this(true, paramInt);
  }
  
  public a(a<? extends T> parama)
  {
    this(parama.c, parama.b, parama.a.getClass().getComponentType());
    this.b = parama.b;
    System.arraycopy(parama.a, 0, this.a, 0, this.b);
  }
  
  public a(boolean paramBoolean, int paramInt)
  {
    this.c = paramBoolean;
    this.a = ((Object[])new Object[paramInt]);
  }
  
  public a(boolean paramBoolean, int paramInt, Class paramClass)
  {
    this.c = paramBoolean;
    this.a = ((Object[])com.badlogic.gdx.utils.b.a.a(paramClass, paramInt));
  }
  
  public T a()
  {
    if (this.b == 0) {
      throw new IllegalStateException("Array is empty.");
    }
    this.b -= 1;
    Object localObject = this.a[this.b];
    this.a[this.b] = null;
    return (T)localObject;
  }
  
  public T a(int paramInt)
  {
    if (paramInt >= this.b) {
      throw new IndexOutOfBoundsException(String.valueOf(paramInt));
    }
    return (T)this.a[paramInt];
  }
  
  public void a(a<? extends T> parama)
  {
    a(parama, 0, parama.b);
  }
  
  public void a(a<? extends T> parama, int paramInt1, int paramInt2)
  {
    if (paramInt1 + paramInt2 > parama.b) {
      throw new IllegalArgumentException("offset + length must be <= size: " + paramInt1 + " + " + paramInt2 + " <= " + parama.b);
    }
    a((Object[])parama.a, paramInt1, paramInt2);
  }
  
  public void a(T paramT)
  {
    Object[] arrayOfObject2 = this.a;
    Object[] arrayOfObject1 = arrayOfObject2;
    if (this.b == arrayOfObject2.length) {
      arrayOfObject1 = c(Math.max(8, (int)(this.b * 1.75F)));
    }
    int i = this.b;
    this.b = (i + 1);
    arrayOfObject1[i] = paramT;
  }
  
  public void a(T[] paramArrayOfT, int paramInt1, int paramInt2)
  {
    Object[] arrayOfObject2 = this.a;
    int i = this.b + paramInt2;
    Object[] arrayOfObject1 = arrayOfObject2;
    if (i > arrayOfObject2.length) {
      arrayOfObject1 = c(Math.max(8, (int)(i * 1.75F)));
    }
    System.arraycopy(paramArrayOfT, paramInt1, arrayOfObject1, this.b, paramInt2);
    this.b += paramInt2;
  }
  
  public boolean a(T paramT, boolean paramBoolean)
  {
    Object[] arrayOfObject = this.a;
    int i = this.b - 1;
    int j = i;
    if (!paramBoolean)
    {
      j = i;
      if (paramT != null) {
        break label52;
      }
      j = i;
    }
    for (;;)
    {
      if (j >= 0)
      {
        if (arrayOfObject[j] == paramT)
        {
          return true;
          label52:
          do
          {
            j -= 1;
            if (j < 0) {
              break;
            }
          } while (!paramT.equals(arrayOfObject[j]));
          return true;
        }
      }
      else {
        return false;
      }
      j -= 1;
    }
  }
  
  public T b(int paramInt)
  {
    if (paramInt >= this.b) {
      throw new IndexOutOfBoundsException(String.valueOf(paramInt));
    }
    Object[] arrayOfObject = this.a;
    Object localObject = arrayOfObject[paramInt];
    this.b -= 1;
    if (this.c) {
      System.arraycopy(arrayOfObject, paramInt + 1, arrayOfObject, paramInt, this.b - paramInt);
    }
    for (;;)
    {
      arrayOfObject[this.b] = null;
      return (T)localObject;
      arrayOfObject[paramInt] = arrayOfObject[this.b];
    }
  }
  
  public void b()
  {
    Object[] arrayOfObject = this.a;
    int j = this.b;
    int i = 0;
    while (i < j)
    {
      arrayOfObject[i] = null;
      i += 1;
    }
    this.b = 0;
  }
  
  public boolean b(T paramT, boolean paramBoolean)
  {
    Object[] arrayOfObject = this.a;
    int j;
    int i;
    if ((paramBoolean) || (paramT == null))
    {
      j = this.b;
      i = 0;
    }
    while (i < j)
    {
      if (arrayOfObject[i] == paramT)
      {
        b(i);
        return true;
      }
      i += 1;
      continue;
      j = this.b;
      i = 0;
      while (i < j)
      {
        if (paramT.equals(arrayOfObject[i]))
        {
          b(i);
          return true;
        }
        i += 1;
      }
    }
    return false;
  }
  
  protected T[] c(int paramInt)
  {
    Object[] arrayOfObject1 = this.a;
    Object[] arrayOfObject2 = (Object[])com.badlogic.gdx.utils.b.a.a(arrayOfObject1.getClass().getComponentType(), paramInt);
    System.arraycopy(arrayOfObject1, 0, arrayOfObject2, 0, Math.min(this.b, arrayOfObject2.length));
    this.a = arrayOfObject2;
    return arrayOfObject2;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof a)) {
      return false;
    }
    Object localObject1 = (a)paramObject;
    int j = this.b;
    if (j != ((a)localObject1).b) {
      return false;
    }
    paramObject = this.a;
    localObject1 = ((a)localObject1).a;
    int i = 0;
    label52:
    Object localObject2;
    Object localObject3;
    if (i < j)
    {
      localObject2 = paramObject[i];
      localObject3 = localObject1[i];
      if (localObject2 != null) {
        break label85;
      }
      if (localObject3 != null) {
        break label95;
      }
    }
    label85:
    while (localObject2.equals(localObject3))
    {
      i += 1;
      break label52;
      break;
    }
    label95:
    return false;
  }
  
  public Iterator<T> iterator()
  {
    if (this.d == null) {
      this.d = new b(this);
    }
    return this.d.iterator();
  }
  
  public String toString()
  {
    if (this.b == 0) {
      return "[]";
    }
    Object[] arrayOfObject = this.a;
    t localt = new t(32);
    localt.b('[');
    localt.a(arrayOfObject[0]);
    int i = 1;
    while (i < this.b)
    {
      localt.b(", ");
      localt.a(arrayOfObject[i]);
      i += 1;
    }
    localt.b(']');
    return localt.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/badlogic/gdx/utils/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */