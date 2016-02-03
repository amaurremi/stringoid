package com.appbrain.a;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.concurrent.atomic.AtomicBoolean;

final class ak
  implements Runnable
{
  ak(aj paramaj, Context paramContext, long paramLong, SharedPreferences paramSharedPreferences) {}
  
  public final void run()
  {
    try
    {
      aj localaj = this.d;
      Context localContext = this.a;
      localaj.a();
      aj.a(this.d, this.b, 0L, 0L, this.c);
      aj.c(this.d).set(false);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        aj.a(this.d, this.c.getLong(aj.a(this.d), 0L), this.b, this.c.getLong(aj.b(this.d), 0L) + 1L, this.c);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/appbrain/a/ak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */