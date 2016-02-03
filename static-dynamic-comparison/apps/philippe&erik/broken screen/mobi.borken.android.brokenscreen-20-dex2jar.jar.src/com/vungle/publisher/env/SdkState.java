package com.vungle.publisher.env;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.SystemClock;
import com.vungle.publisher.VungleService;
import com.vungle.publisher.bh;
import com.vungle.publisher.cg.a;
import com.vungle.publisher.cj;
import com.vungle.publisher.di;
import com.vungle.publisher.inject.annotations.SdkStateSharedPreferences;
import com.vungle.publisher.inject.annotations.VungleServiceClass;
import com.vungle.publisher.log.Logger;
import com.vungle.publisher.u;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
public class SdkState
{
  @Inject
  Context a;
  @Inject
  public di b;
  @Inject
  public Provider<PlayAdEndEventListener> c;
  @VungleServiceClass
  @Inject
  Class d;
  public final a e = new a();
  public final AtomicBoolean f = new AtomicBoolean();
  final AtomicLong g = new AtomicLong();
  @SdkStateSharedPreferences
  @Inject
  public SharedPreferences h;
  
  public static long b()
  {
    return SystemClock.elapsedRealtime();
  }
  
  public final long a()
  {
    long l = this.h.getLong("VgLastViewedTime", 0L);
    Logger.v("VungleAd", "returning last ad end millis: " + l);
    return l;
  }
  
  public final void c()
  {
    Intent localIntent = new Intent(this.a, this.d);
    localIntent.setAction(VungleService.SESSION_EVENT_ACTION);
    localIntent.putExtra("activityEvent", "activityResume");
    long l = System.currentTimeMillis() / 1000L;
    if (this.g.compareAndSet(0L, l)) {
      localIntent.putExtra("sessionStartSeconds", l);
    }
    this.a.startService(localIntent);
  }
  
  public final void d()
  {
    Intent localIntent = new Intent(this.a, this.d);
    localIntent.setAction(VungleService.SESSION_EVENT_ACTION);
    localIntent.putExtra("activityEvent", "activityPause");
    localIntent.putExtra("sessionStartSeconds", this.g.get());
    localIntent.putExtra("activityPauseSeconds", System.currentTimeMillis());
    this.a.startService(localIntent);
  }
  
  @Singleton
  public static class PlayAdEndEventListener
    extends bh
  {
    @Inject
    SdkState a;
    
    public void onEvent(u paramu)
    {
      Logger.d("VungleAd", "received ad end event");
      SdkState.a(this.a).set(false);
      d();
    }
  }
  
  @Singleton
  public static class SessionEndListener
    implements cg.a
  {
    @Inject
    SdkState a;
    
    public final void a(long paramLong)
    {
      this.a.g.compareAndSet(paramLong, 0L);
    }
  }
  
  public static final class a
  {
    public cj<Throwable> a = new cj(Throwable.class);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/env/SdkState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */