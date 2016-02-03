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
  final Object Rm = new Object();
  private Handler Rn;
  private boolean Ro;
  private HashMap<String, AtomicInteger> Rp;
  private int Rq;
  
  public EventIncrementCache(Looper paramLooper, int paramInt)
  {
    this.Rn = new Handler(paramLooper);
    this.Rp = new HashMap();
    this.Rq = paramInt;
  }
  
  private void hP()
  {
    synchronized (this.Rm)
    {
      this.Ro = false;
      flush();
      return;
    }
  }
  
  public void flush()
  {
    synchronized (this.Rm)
    {
      Iterator localIterator = this.Rp.entrySet().iterator();
      if (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        o((String)localEntry.getKey(), ((AtomicInteger)localEntry.getValue()).get());
      }
    }
    this.Rp.clear();
  }
  
  protected abstract void o(String paramString, int paramInt);
  
  public void u(String paramString, int paramInt)
  {
    synchronized (this.Rm)
    {
      if (!this.Ro)
      {
        this.Ro = true;
        this.Rn.postDelayed(new Runnable()
        {
          public void run()
          {
            EventIncrementCache.a(EventIncrementCache.this);
          }
        }, this.Rq);
      }
      AtomicInteger localAtomicInteger2 = (AtomicInteger)this.Rp.get(paramString);
      AtomicInteger localAtomicInteger1 = localAtomicInteger2;
      if (localAtomicInteger2 == null)
      {
        localAtomicInteger1 = new AtomicInteger();
        this.Rp.put(paramString, localAtomicInteger1);
      }
      localAtomicInteger1.addAndGet(paramInt);
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/internal/events/EventIncrementCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */