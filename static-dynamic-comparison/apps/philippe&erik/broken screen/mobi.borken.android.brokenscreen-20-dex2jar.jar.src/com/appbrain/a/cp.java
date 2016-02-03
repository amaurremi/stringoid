package com.appbrain.a;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.concurrent.atomic.AtomicBoolean;

final class cp
  implements Runnable
{
  cp(co paramco, Context paramContext, long paramLong, SharedPreferences paramSharedPreferences) {}
  
  public final void run()
  {
    try
    {
      this.d.b(this.a);
      co.a(this.d, this.b, 0L, 0L, this.c);
      co.c(this.d).set(false);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        co.a(this.d, this.c.getLong(co.a(this.d), 0L), this.b, this.c.getLong(co.b(this.d), 0L) + 1L, this.c);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/appbrain/a/cp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */