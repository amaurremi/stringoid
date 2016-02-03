package com.appbrain.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import cmn.a;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class co
{
  private final long a;
  private final AtomicBoolean b = new AtomicBoolean(false);
  private final String c;
  private final String d;
  private final String e;
  private final boolean f;
  
  public co(String paramString, long paramLong)
  {
    this.c = ("last_check_" + paramString);
    this.d = ("last_err_" + paramString);
    this.e = ("errorcount_" + paramString);
    this.a = paramLong;
    this.f = false;
  }
  
  private void a(long paramLong1, long paramLong2, long paramLong3, SharedPreferences paramSharedPreferences)
  {
    for (;;)
    {
      try
      {
        paramSharedPreferences = paramSharedPreferences.edit();
        paramSharedPreferences.putLong(this.c, paramLong1);
        if (paramLong2 > 0L)
        {
          paramSharedPreferences.putLong(this.d, paramLong2);
          if (paramLong3 > 0L)
          {
            paramSharedPreferences.putLong(this.e, paramLong3);
            a.a().a(paramSharedPreferences);
          }
        }
        else
        {
          paramSharedPreferences.remove(this.d);
          continue;
        }
        paramSharedPreferences.remove(this.e);
      }
      catch (Exception paramSharedPreferences)
      {
        paramSharedPreferences.printStackTrace();
        return;
      }
    }
  }
  
  protected SharedPreferences a(Context paramContext)
  {
    return paramContext.getSharedPreferences("update_check", 0);
  }
  
  protected abstract void b(Context paramContext);
  
  public final boolean c(Context paramContext)
  {
    long l3 = System.currentTimeMillis();
    if (this.b.compareAndSet(false, true))
    {
      SharedPreferences localSharedPreferences = a(paramContext);
      long l1 = localSharedPreferences.getLong(this.c, 0L);
      long l4 = localSharedPreferences.getLong(this.d, 0L);
      long l5 = localSharedPreferences.getLong(this.e, 0L);
      long l2 = l1 + this.a;
      l1 = l2;
      if (l5 > 0L) {
        l1 = Math.max(l2, l4 + Math.pow(1.5D, Math.min(12L, l5)) * 10.0D * 1000.0D);
      }
      int i;
      if (l1 <= System.currentTimeMillis())
      {
        i = 1;
        if (i == 0) {
          break label180;
        }
        paramContext = new cp(this, paramContext, l3, localSharedPreferences);
        if (!this.f) {
          break label171;
        }
        new Thread(paramContext).start();
      }
      for (;;)
      {
        return true;
        i = 0;
        break;
        label171:
        paramContext.run();
      }
      label180:
      if ((localSharedPreferences.getLong(this.c, 0L) > 3600000L + l3) || (localSharedPreferences.getLong(this.d, 0L) > l3 + 3600000L)) {
        a(0L, 0L, 0L, localSharedPreferences);
      }
      this.b.set(false);
    }
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/appbrain/a/co.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */