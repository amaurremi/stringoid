package com.flurry.android.monolithic.sdk.impl;

import android.content.Context;
import android.os.SystemClock;
import com.flurry.android.impl.ads.FlurryAdModule;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

public class bt
  implements ih, Thread.UncaughtExceptionHandler
{
  private static final String b = bt.class.getSimpleName();
  private static bt c;
  Map<Context, Context> a = new WeakHashMap();
  private long d;
  private long e;
  private long f;
  private Map<ie, ByteBuffer> g = new HashMap();
  private volatile boolean h = false;
  private volatile boolean i = false;
  private FlurryAdModule j;
  
  public bt()
  {
    is.a().a(this);
    this.j = FlurryAdModule.getInstance();
  }
  
  public static bt a()
  {
    if (c == null) {
      c = new bt();
    }
    return c;
  }
  
  private void c()
  {
    this.a.clear();
  }
  
  public void f(Context paramContext)
  {
    jc.a().b();
    in.a().b();
    in.a().c();
    if ((Context)this.a.put(paramContext, paramContext) != null) {
      ja.a(5, b, "onStartSession called with duplicate context, use a specific Activity or Service as context instead of using a global context");
    }
    if (!this.h)
    {
      long l1 = SystemClock.elapsedRealtime();
      long l2 = ((Long)ib.a().a("ContinueSessionMillis")).longValue();
      if (l1 - this.f <= l2) {
        break label132;
      }
      this.e = l1;
      this.d = System.currentTimeMillis();
      this.j.a(paramContext, this.d, this.e);
      this.j.a(new bu(this));
    }
    for (;;)
    {
      this.h = true;
      return;
      label132:
      this.j.b(paramContext);
    }
  }
  
  public void g(Context paramContext)
  {
    in.a().d();
    if ((paramContext != null) && ((Context)this.a.remove(paramContext) == null)) {
      ja.a(5, b, "onEndSession called without context from corresponding onStartSession");
    }
    if (this.h) {
      this.j.d(paramContext);
    }
    if ((this.h) && (this.a.isEmpty()))
    {
      this.f = SystemClock.elapsedRealtime();
      this.j.c(paramContext);
      this.h = false;
    }
  }
  
  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    c();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/bt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */