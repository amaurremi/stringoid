package com.badlogic.gdx.utils;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class l<K, V>
  extends o<K, V>
  implements Iterable<m<K, V>>, Iterator<m<K, V>>
{
  m<K, V> a = new m();
  
  public l(k<K, V> paramk)
  {
    super(paramk);
  }
  
  public m<K, V> a()
  {
    if (!this.b) {
      throw new NoSuchElementException();
    }
    if (!this.f) {
      throw new f("#iterator() cannot be used nested.");
    }
    Object[] arrayOfObject = this.c.b;
    this.a.a = arrayOfObject[this.d];
    this.a.b = this.c.c[this.d];
    this.e = this.d;
    c();
    return this.a;
  }
  
  public boolean hasNext()
  {
    return this.b;
  }
  
  public Iterator<m<K, V>> iterator()
  {
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/badlogic/gdx/utils/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */