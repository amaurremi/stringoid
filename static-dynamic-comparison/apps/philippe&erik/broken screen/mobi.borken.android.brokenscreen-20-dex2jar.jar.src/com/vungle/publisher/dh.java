package com.vungle.publisher;

import android.util.Log;

final class dh
  implements Runnable
{
  final dn a;
  volatile boolean b;
  private final di c;
  
  dh(di paramdi)
  {
    this.c = paramdi;
    this.a = new dn();
  }
  
  public final void run()
  {
    try
    {
      dm localdm2 = this.a.b();
      localdm1 = localdm2;
      if (localdm2 != null) {}
    }
    catch (InterruptedException localInterruptedException)
    {
      dm localdm1;
      localInterruptedException = localInterruptedException;
      Log.w("Event", Thread.currentThread().getName() + " was interruppted", localInterruptedException);
      return;
    }
    finally
    {
      this.b = false;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/dh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */