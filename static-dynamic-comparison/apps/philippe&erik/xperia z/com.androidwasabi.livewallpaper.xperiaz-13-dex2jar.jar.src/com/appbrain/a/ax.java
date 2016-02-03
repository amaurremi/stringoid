package com.appbrain.a;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.Timer;

final class ax
  extends aj
{
  ax(aw paramaw, String paramString, long paramLong)
  {
    super(paramString, paramLong);
  }
  
  protected final SharedPreferences a(Context paramContext)
  {
    return aw.a(this.a);
  }
  
  protected final void a()
  {
    try
    {
      aw.b(this.a);
      return;
    }
    catch (Exception localException)
    {
      ay localay = new ay(this);
      aw.d(this.a).schedule(localay, 60000L);
      throw localException;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/appbrain/a/ax.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */