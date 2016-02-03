package com.appbrain.a;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import com.appbrain.AppBrainService;

public final class h
{
  private static final h a = new h();
  private static final h b = new h();
  private long c = Long.MIN_VALUE;
  
  public static void a(Context paramContext, String paramString)
  {
    b.a(paramContext, paramString, "icsample");
  }
  
  private void a(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      long l = SystemClock.elapsedRealtime();
      if (this.c < l - 30000L)
      {
        this.c = l;
        int i = aw.a().a(paramString2, 3);
        if (Math.random() < 1.0D / (1 << i))
        {
          paramString2 = new Intent(paramContext, AppBrainService.class);
          paramString2.putExtra("ip", paramString1);
          paramString2.putExtra("cp2", i);
          paramContext.startService(paramString2);
        }
      }
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/appbrain/a/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */