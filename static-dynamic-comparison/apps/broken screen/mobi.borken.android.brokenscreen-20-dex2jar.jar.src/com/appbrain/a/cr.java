package com.appbrain.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import com.appbrain.b.e;
import com.appbrain.e.a.c;
import com.appbrain.e.a.k;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public final class cr
{
  private static cr a;
  private final Handler b;
  private final Context c;
  private long d = Long.MAX_VALUE;
  private long e = 60000L;
  private final Runnable f = new cv(this);
  private final Runnable g = new cw(this);
  
  private cr(Context paramContext)
  {
    this.c = paramContext.getApplicationContext();
    this.b = aq.a();
  }
  
  public static cr a(Context paramContext)
  {
    try
    {
      if (a == null) {
        a = new cr(paramContext);
      }
      paramContext = a;
      return paramContext;
    }
    finally {}
  }
  
  private void a(long paramLong)
  {
    paramLong = System.currentTimeMillis() + paramLong;
    if (paramLong < d())
    {
      b(paramLong);
      c();
    }
  }
  
  private void a(a.k paramk)
  {
    int i = 4096;
    for (;;)
    {
      try
      {
        FileOutputStream localFileOutputStream = this.c.openFileOutput("com.appbrain.ping", 0);
        int j;
        try
        {
          j = paramk.c();
          if (j > 4096)
          {
            e locale = e.a(localFileOutputStream, i);
            paramk.a(locale);
            locale.a();
            return;
          }
        }
        finally
        {
          localFileOutputStream.close();
        }
        i = j;
      }
      catch (Exception paramk)
      {
        return;
      }
    }
  }
  
  private static void b(long paramLong)
  {
    SharedPreferences.Editor localEditor = aa.a().e().edit();
    localEditor.putLong("update_ping_deadline", paramLong);
    cmn.a.a().a(localEditor);
  }
  
  private void c()
  {
    long l = d();
    if (l < this.d)
    {
      this.d = l;
      l = Math.max(1000L, l - System.currentTimeMillis());
      this.b.removeCallbacks(this.g);
      this.b.postDelayed(this.g, l);
    }
  }
  
  private static long d()
  {
    return aa.a().e().getLong("update_ping_deadline", Long.MAX_VALUE);
  }
  
  private a.k e()
  {
    a.k localk = f();
    try
    {
      this.c.deleteFile("com.appbrain.ping");
      return localk;
    }
    catch (Exception localException) {}
    return localk;
  }
  
  private a.k f()
  {
    try
    {
      FileInputStream localFileInputStream = this.c.openFileInput("com.appbrain.ping");
      try
      {
        a.k localk = a.k.a(localFileInputStream);
        return localk;
      }
      finally
      {
        localFileInputStream.close();
      }
      return null;
    }
    catch (Exception localException) {}
  }
  
  public final void a()
  {
    this.b.post(this.f);
  }
  
  public final void a(a.c paramc)
  {
    this.b.post(new ct(this, paramc));
  }
  
  public final void a(String paramString, int paramInt)
  {
    this.b.post(new cu(this, paramString, paramInt));
  }
  
  public final void b()
  {
    this.b.post(new cs(this));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/appbrain/a/cr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */