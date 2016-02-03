package com.badlogic.gdx.backends.android;

class q
  implements Runnable
{
  q(o paramo, boolean paramBoolean) {}
  
  public void run()
  {
    int i = 0;
    synchronized (this.b.l.l)
    {
      if ((!this.b.l.j) || (this.b.l.k != this.a))
      {
        this.b.l.k = this.a;
        this.b.l.j = true;
        i = 1;
      }
      if (i != 0)
      {
        ??? = this.b.l.b;
        if (??? != null) {
          ((v)((n)???).f).a(this.a);
        }
      }
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/badlogic/gdx/backends/android/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */