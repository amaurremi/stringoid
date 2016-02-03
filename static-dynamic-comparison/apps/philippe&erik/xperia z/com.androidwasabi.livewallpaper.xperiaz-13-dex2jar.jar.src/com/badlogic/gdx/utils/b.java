package com.badlogic.gdx.utils;

import java.util.Iterator;

public class b<T>
  implements Iterable<T>
{
  private final a<T> a;
  private final boolean b;
  private c c;
  private c d;
  
  public b(a<T> parama)
  {
    this(parama, true);
  }
  
  public b(a<T> parama, boolean paramBoolean)
  {
    this.a = parama;
    this.b = paramBoolean;
  }
  
  public Iterator<T> iterator()
  {
    if (this.c == null)
    {
      this.c = new c(this.a, this.b);
      this.d = new c(this.a, this.b);
    }
    if (!this.c.b)
    {
      this.c.a = 0;
      this.c.b = true;
      this.d.b = false;
      return this.c;
    }
    this.d.a = 0;
    this.d.b = true;
    this.c.b = false;
    return this.d;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/badlogic/gdx/utils/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */