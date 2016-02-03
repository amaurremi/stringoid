package com.flurry.sdk;

import java.util.TimerTask;

class dm$a
  extends TimerTask
{
  private dm.b b;
  
  dm$a(dm paramdm, dm.b paramb)
  {
    this.b = paramb;
  }
  
  public void run()
  {
    this.a.a();
    if (this.b != null) {
      this.b.q();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/flurry/sdk/dm$a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */