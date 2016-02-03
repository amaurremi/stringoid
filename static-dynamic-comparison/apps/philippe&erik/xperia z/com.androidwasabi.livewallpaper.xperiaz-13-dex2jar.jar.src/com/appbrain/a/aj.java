package com.appbrain.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import cmn.a;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class aj
{
  private static String a = "last_check_";
  private static String b = "last_err_";
  private static String c = "errorcount_";
  private final String d;
  private final long e;
  private final AtomicBoolean f = new AtomicBoolean(false);
  private final String g;
  private final String h;
  private final String i;
  private final boolean j;
  
  public aj(String paramString, long paramLong)
  {
    this.g = (a + paramString);
    this.h = (b + paramString);
    this.i = (c + paramString);
    this.d = paramString;
    this.e = paramLong;
    this.j = true;
  }
  
  private void a(long paramLong1, long paramLong2, long paramLong3, SharedPreferences paramSharedPreferences)
  {
    for (;;)
    {
      try
      {
        paramSharedPreferences = paramSharedPreferences.edit();
        paramSharedPreferences.putLong(this.g, paramLong1);
        if (paramLong2 > 0L)
        {
          paramSharedPreferences.putLong(this.h, paramLong2);
          if (paramLong3 > 0L)
          {
            paramSharedPreferences.putLong(this.i, paramLong3);
            a.a().a(paramSharedPreferences);
          }
        }
        else
        {
          paramSharedPreferences.remove(this.h);
          continue;
        }
        paramSharedPreferences.remove(this.i);
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
  
  protected abstract void a();
  
  public final boolean b(Context paramContext)
  {
    long l1 = System.currentTimeMillis();
    if (this.f.compareAndSet(false, true))
    {
      SharedPreferences localSharedPreferences = a(paramContext);
      long l2 = localSharedPreferences.getLong(this.g, 0L);
      long l3 = localSharedPreferences.getLong(this.h, 0L);
      long l4 = localSharedPreferences.getLong(this.i, 0L);
      int k;
      if (l4 > 0L)
      {
        if (Math.max(l2 + this.e, l3 + Math.pow(1.5D, Math.min(12L, l4)) * 10.0D * 1000.0D) > System.currentTimeMillis()) {
          break label181;
        }
        k = 1;
        if (k == 0) {
          break label195;
        }
        paramContext = new ak(this, paramContext, l1, localSharedPreferences);
        if (!this.j) {
          break label186;
        }
        new Thread(paramContext).start();
      }
      for (;;)
      {
        return true;
        if (System.currentTimeMillis() >= l2 + this.e)
        {
          k = 1;
          break;
        }
        k = 0;
        break;
        label181:
        k = 0;
        break;
        label186:
        paramContext.run();
      }
      label195:
      if ((localSharedPreferences.getLong(this.g, 0L) > 3600000L + l1) || (localSharedPreferences.getLong(this.h, 0L) > l1 + 3600000L)) {
        a(0L, 0L, 0L, localSharedPreferences);
      }
      this.f.set(false);
    }
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/appbrain/a/aj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */