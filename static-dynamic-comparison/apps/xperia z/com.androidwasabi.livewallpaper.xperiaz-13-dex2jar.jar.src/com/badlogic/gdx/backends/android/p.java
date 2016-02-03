package com.badlogic.gdx.backends.android;

class p
  implements Runnable
{
  p(o paramo) {}
  
  public void run()
  {
    synchronized (this.a.l.l)
    {
      if (this.a.l.i == this.a)
      {
        i = 1;
        if (i != 0) {
          ((v)this.a.l.b.f).a(this.a.f, this.a.g, this.a.h, this.a.i, this.a.j, this.a.k);
        }
        return;
      }
      int i = 0;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/badlogic/gdx/backends/android/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */