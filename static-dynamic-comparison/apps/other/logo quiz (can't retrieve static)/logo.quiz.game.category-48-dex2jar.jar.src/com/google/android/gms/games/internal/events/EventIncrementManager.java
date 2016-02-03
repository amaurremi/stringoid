package com.google.android.gms.games.internal.events;

import java.util.concurrent.atomic.AtomicReference;

public abstract class EventIncrementManager
{
  private final AtomicReference<EventIncrementCache> aal = new AtomicReference();
  
  public void flush()
  {
    EventIncrementCache localEventIncrementCache = (EventIncrementCache)this.aal.get();
    if (localEventIncrementCache != null) {
      localEventIncrementCache.flush();
    }
  }
  
  protected abstract EventIncrementCache kv();
  
  public void n(String paramString, int paramInt)
  {
    EventIncrementCache localEventIncrementCache2 = (EventIncrementCache)this.aal.get();
    EventIncrementCache localEventIncrementCache1 = localEventIncrementCache2;
    if (localEventIncrementCache2 == null)
    {
      localEventIncrementCache2 = kv();
      localEventIncrementCache1 = localEventIncrementCache2;
      if (!this.aal.compareAndSet(null, localEventIncrementCache2)) {
        localEventIncrementCache1 = (EventIncrementCache)this.aal.get();
      }
    }
    localEventIncrementCache1.w(paramString, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/games/internal/events/EventIncrementManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */