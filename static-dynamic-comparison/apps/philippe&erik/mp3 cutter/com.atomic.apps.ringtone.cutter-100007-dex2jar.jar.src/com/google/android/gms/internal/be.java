package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.WebViewClient;

public final class be
  implements Runnable
{
  protected final bW a;
  protected boolean b;
  private final Handler c = new Handler(Looper.getMainLooper());
  private final long d = 200L;
  private long e = 50L;
  private ca f;
  private boolean g;
  private final int h;
  private final int i;
  
  public be(ca paramca, bW parambW, int paramInt1, int paramInt2)
  {
    this(paramca, parambW, paramInt1, paramInt2, 200L, 50L);
  }
  
  private be(ca paramca, bW parambW, int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    this.a = parambW;
    this.f = paramca;
    this.g = false;
    this.b = false;
    this.h = paramInt2;
    this.i = paramInt1;
  }
  
  public final void a()
  {
    this.c.postDelayed(this, this.d);
  }
  
  public final void a(cz paramcz)
  {
    Object localObject = new cn(this, this.a, paramcz.q);
    this.a.setWebViewClient((WebViewClient)localObject);
    bW localbW = this.a;
    if (TextUtils.isEmpty(paramcz.b)) {}
    for (localObject = null;; localObject = bN.a(paramcz.b))
    {
      localbW.loadDataWithBaseURL((String)localObject, paramcz.c, "text/html", "UTF-8", null);
      return;
    }
  }
  
  public final void b()
  {
    try
    {
      this.g = true;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final boolean c()
  {
    try
    {
      boolean bool = this.g;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final boolean d()
  {
    return this.b;
  }
  
  public final void run()
  {
    if ((this.a == null) || (c()))
    {
      this.f.a(this.a);
      return;
    }
    new bf(this, this.a).execute(new Void[0]);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/mp3 cutter/com.atomic.apps.ringtone.cutter-100007-dex2jar.jar!/com/google/android/gms/internal/be.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */