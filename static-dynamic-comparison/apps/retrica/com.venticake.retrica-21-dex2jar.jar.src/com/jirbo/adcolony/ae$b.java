package com.jirbo.adcolony;

import android.os.Handler;
import android.os.Message;

class ae$b
  extends Handler
{
  ae$b(ae paramae)
  {
    a();
  }
  
  void a()
  {
    sendMessageDelayed(obtainMessage(), 500L);
  }
  
  public void handleMessage(Message paramMessage)
  {
    a();
    if (this.a.d.isFinishing()) {}
    while (this.a.d.D == null) {
      return;
    }
    try
    {
      if ((this.a.Z != null) && (this.a.Z.a()) && (!this.a.d.D.isPlaying()))
      {
        this.a.Z = null;
        this.a.t = 0;
        if (this.a.d.D != null) {
          this.a.d.D.a();
        }
        this.a.d.n = true;
        this.a.f();
      }
      return;
    }
    finally {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/jirbo/adcolony/ae$b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */