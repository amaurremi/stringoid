package com.pocket.m.e;

import android.os.Handler;

public class g
{
  public static final f a = new j();
  public static final f b = new d();
  public static final f c = new e();
  private final Handler d;
  private h e;
  private int f = 0;
  
  public g(Handler paramHandler)
  {
    this.d = paramHandler;
  }
  
  public void a()
  {
    if (2 != this.f)
    {
      this.f = 2;
      com.ideashower.readitlater.a.g.a(new Runnable()
      {
        public void run()
        {
          new i(g.this, this.a).h();
        }
      });
    }
  }
  
  public void b()
  {
    if (this.e != null) {
      this.d.removeCallbacks(this.e);
    }
    if (com.ideashower.readitlater.a.g.j())
    {
      this.e = new h(this, null);
      this.d.postDelayed(this.e, 1000L);
      return;
    }
    this.e = new h(this, null);
    this.d.postDelayed(this.e, 4000L);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/m/e/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */