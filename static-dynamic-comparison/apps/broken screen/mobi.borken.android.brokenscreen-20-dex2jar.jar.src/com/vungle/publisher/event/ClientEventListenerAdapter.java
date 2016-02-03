package com.vungle.publisher.event;

import com.vungle.publisher.EventListener;
import com.vungle.publisher.aa;
import com.vungle.publisher.ac;
import com.vungle.publisher.ad;
import com.vungle.publisher.ae;
import com.vungle.publisher.async.ScheduledPriorityExecutor;
import com.vungle.publisher.async.ScheduledPriorityExecutor.b;
import com.vungle.publisher.bh;
import com.vungle.publisher.log.Logger;
import com.vungle.publisher.t;
import com.vungle.publisher.v;
import com.vungle.publisher.x;
import com.vungle.publisher.y;
import com.vungle.publisher.z;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

public class ClientEventListenerAdapter
  extends bh
{
  public EventListener a;
  @Inject
  ScheduledPriorityExecutor b;
  private int c;
  private int d;
  
  public void onEvent(aa paramaa)
  {
    Logger.d("VungleEvent", "onAdUnavailable(unavailable) callback");
    this.a.onAdUnavailable("No cached or streaming ad available");
  }
  
  public void onEvent(ac paramac)
  {
    this.d = paramac.a;
  }
  
  public void onEvent(ad paramad)
  {
    int i = paramad.a;
    if (i > this.c)
    {
      Logger.d("VungleEvent", "new watched millis " + i);
      this.c = i;
      return;
    }
    Logger.d("VungleEvent", "shorter watched millis " + i);
  }
  
  public void onEvent(t paramt)
  {
    Logger.d("VungleEvent", "onCachedAdAvailable() callback");
    this.a.onCachedAdAvailable();
  }
  
  public void onEvent(v paramv)
  {
    Logger.d("VungleEvent", "onAdUnavailable(error) callback");
    this.a.onAdUnavailable("Error launching ad");
  }
  
  public void onEvent(x paramx)
  {
    Logger.d("VungleEvent", "onAdStart() callback");
    this.c = 0;
    this.d = 0;
    this.b.a(new Runnable()
    {
      public final void run()
      {
        ClientEventListenerAdapter.this.a.onAdStart();
      }
    }, ScheduledPriorityExecutor.b.l);
  }
  
  public void onEvent(y paramy)
  {
    final int i = this.c;
    final int j = this.d;
    if (i / j > 0.8F) {}
    for (final boolean bool = true;; bool = false)
    {
      Logger.d("VungleEvent", "onVideoEnd(" + bool + ", " + i + ", " + j + ") callback");
      this.b.a(new Runnable()
      {
        public final void run()
        {
          ClientEventListenerAdapter.this.a.onVideoView(bool, i, j);
        }
      }, ScheduledPriorityExecutor.b.l);
      Logger.d("VungleEvent", "onAdEnd() callback");
      this.b.a(new Runnable()
      {
        public final void run()
        {
          ClientEventListenerAdapter.this.a.onAdEnd();
        }
      }, ScheduledPriorityExecutor.b.l);
      return;
    }
  }
  
  public void onEvent(z paramz)
  {
    Logger.d("VungleEvent", "onAdUnavailable(throttled) callback");
    this.a.onAdUnavailable("Only " + paramz.a + " of minimum " + paramz.b + " seconds elapsed between ads");
  }
  
  @Singleton
  public static class Factory
  {
    @Inject
    public Provider<ClientEventListenerAdapter> a;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/event/ClientEventListenerAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */