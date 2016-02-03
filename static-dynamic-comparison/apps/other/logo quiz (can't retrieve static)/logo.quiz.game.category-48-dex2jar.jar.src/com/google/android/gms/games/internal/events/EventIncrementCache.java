package com.google.android.gms.games.internal.events;

import android.os.Handler;
import android.os.Looper;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class EventIncrementCache
{
  final Object aaf = new Object();
  private Handler aag;
  private boolean aah;
  private HashMap<String, AtomicInteger> aai;
  private int aaj;
  
  public EventIncrementCache(Looper paramLooper, int paramInt)
  {
    this.aag = new Handler(paramLooper);
    this.aai = new HashMap();
    this.aaj = paramInt;
  }
  
  private void kN()
  {
    synchronized (this.aaf)
    {
      this.aah = false;
      flush();
      return;
    }
  }
  
  public void flush()
  {
    synchronized (this.aaf)
    {
      Iterator localIterator = this.aai.entrySet().iterator();
      if (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        q((String)localEntry.getKey(), ((AtomicInteger)localEntry.getValue()).get());
      }
    }
    this.aai.clear();
  }
  
  protected abstract void q(String paramString, int paramInt);
  
  public void w(String paramString, int paramInt)
  {
    synchronized (this.aaf)
    {
      if (!this.aah)
      {
        this.aah = true;
        this.aag.postDelayed(new Runnable()
        {
          public void run()
          {
            EventIncrementCache.a(EventIncrementCache.this);
          }
        }, this.aaj);
      }
      AtomicInteger localAtomicInteger2 = (AtomicInteger)this.aai.get(paramString);
      AtomicInteger localAtomicInteger1 = localAtomicInteger2;
      if (localAtomicInteger2 == null)
      {
        localAtomicInteger1 = new AtomicInteger();
        this.aai.put(paramString, localAtomicInteger1);
      }
      localAtomicInteger1.addAndGet(paramInt);
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/games/internal/events/EventIncrementCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */