package com.badlogic.gdx.utils;

class o<K, V>
{
  public boolean b;
  final k<K, V> c;
  int d;
  int e;
  boolean f = true;
  
  public o(k<K, V> paramk)
  {
    this.c = paramk;
    b();
  }
  
  public void b()
  {
    this.e = -1;
    this.d = -1;
    c();
  }
  
  void c()
  {
    this.b = false;
    Object[] arrayOfObject = this.c.b;
    int i = this.c.d;
    int j = this.c.e;
    do
    {
      int k = this.d + 1;
      this.d = k;
      if (k >= i + j) {
        break;
      }
    } while (arrayOfObject[this.d] == null);
    this.b = true;
  }
  
  public void remove()
  {
    if (this.e < 0) {
      throw new IllegalStateException("next must be called before remove.");
    }
    if (this.e >= this.c.d) {
      this.c.a(this.e);
    }
    for (;;)
    {
      this.e = -1;
      k localk = this.c;
      localk.a -= 1;
      return;
      this.c.b[this.e] = null;
      this.c.c[this.e] = null;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/badlogic/gdx/utils/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */