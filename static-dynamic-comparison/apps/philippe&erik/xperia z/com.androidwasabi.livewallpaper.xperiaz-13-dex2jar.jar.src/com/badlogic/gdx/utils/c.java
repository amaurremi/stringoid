package com.badlogic.gdx.utils;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class c<T>
  implements Iterable<T>, Iterator<T>
{
  int a;
  boolean b = true;
  private final a<T> c;
  private final boolean d;
  
  public c(a<T> parama, boolean paramBoolean)
  {
    this.c = parama;
    this.d = paramBoolean;
  }
  
  public boolean hasNext()
  {
    return this.a < this.c.b;
  }
  
  public Iterator<T> iterator()
  {
    return this;
  }
  
  public T next()
  {
    if (this.a >= this.c.b) {
      throw new NoSuchElementException(String.valueOf(this.a));
    }
    if (!this.b) {
      throw new f("#iterator() cannot be used nested.");
    }
    Object[] arrayOfObject = this.c.a;
    int i = this.a;
    this.a = (i + 1);
    return (T)arrayOfObject[i];
  }
  
  public void remove()
  {
    if (!this.d) {
      throw new f("Remove not allowed.");
    }
    this.a -= 1;
    this.c.b(this.a);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/badlogic/gdx/utils/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */