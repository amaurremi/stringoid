package com.ideashower.readitlater.objects;

import android.os.Handler;
import com.ideashower.readitlater.g.g;

public class l
{
  private final Handler a;
  private final long b;
  private m c;
  
  public l(Handler paramHandler, long paramLong)
  {
    this.a = paramHandler;
    this.b = paramLong;
  }
  
  public void a(g paramg)
  {
    if (this.c != null)
    {
      this.c.a();
      this.a.removeCallbacks(this.c);
    }
    this.c = new m(this, paramg);
    this.a.postDelayed(this.c, this.b);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/objects/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */