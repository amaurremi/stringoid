package com.flurry.android;

final class m
  implements Runnable
{
  m(ak paramak, String paramString) {}
  
  public final void run()
  {
    if (this.a != null)
    {
      u.a(this.b.d, this.b.b, this.a);
      this.b.c.a(new f((byte)8, this.b.d.j()));
      return;
    }
    String str = "Unable to launch in app market: " + this.b.a;
    ah.d(u.a, str);
    u.b(this.b.d, str);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/paper toss/com.bfs.papertoss-7005-dex2jar.jar!/com/flurry/android/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */