package com.badlogic.gdx.utils;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class n<K>
  extends o<K, Object>
  implements Iterable<K>, Iterator<K>
{
  public n(k<K, ?> paramk)
  {
    super(paramk);
  }
  
  public a<K> a()
  {
    a locala = new a(true, this.c.a);
    while (this.b) {
      locala.a(next());
    }
    return locala;
  }
  
  public boolean hasNext()
  {
    return this.b;
  }
  
  public Iterator<K> iterator()
  {
    return this;
  }
  
  public K next()
  {
    if (!this.b) {
      throw new NoSuchElementException();
    }
    if (!this.f) {
      throw new f("#iterator() cannot be used nested.");
    }
    Object localObject = this.c.b[this.d];
    this.e = this.d;
    c();
    return (K)localObject;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/badlogic/gdx/utils/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */