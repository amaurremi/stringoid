package com.android.ex.chips;

import android.os.Handler;
import android.os.Message;

final class f
  extends Handler
{
  private f(c paramc) {}
  
  public void a()
  {
    sendMessageDelayed(obtainMessage(1, 0, 0, null), 1000L);
  }
  
  public void b()
  {
    removeMessages(1);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (c.l(this.a) > 0) {
      c.b(this.a, this.a.a(true, c.h(this.a), c.i(this.a), c.j(this.a)));
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/android/ex/chips/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */