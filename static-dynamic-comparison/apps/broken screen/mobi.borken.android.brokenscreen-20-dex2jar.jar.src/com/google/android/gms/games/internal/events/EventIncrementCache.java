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
  final Object Rj = new Object();
  private Handler Rk;
  private boolean Rl;
  private HashMap<String, AtomicInteger> Rm;
  private int Rn;
  
  public EventIncrementCache(Looper paramLooper, int paramInt)
  {
    this.Rk = new Handler(paramLooper);
    this.Rm = new HashMap();
    this.Rn = paramInt;
  }
  
  private void hK()
  {
    synchronized (this.Rj)
    {
      this.Rl = false;
      flush();
      return;
    }
  }
  
  public void flush()
  {
    synchronized (this.Rj)
    {
      Iterator localIterator = this.Rm.entrySet().iterator();
      if (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        o((String)localEntry.getKey(), ((AtomicInteger)localEntry.getValue()).get());
      }
    }
    this.Rm.clear();
  }
  
  protected abstract void o(String paramString, int paramInt);
  
  public void u(String paramString, int paramInt)
  {
    synchronized (this.Rj)
    {
      if (!this.Rl)
      {
        this.Rl = true;
        this.Rk.postDelayed(new Runnable()
        {
          public void run()
          {
            EventIncrementCache.a(EventIncrementCache.this);
          }
        }, this.Rn);
      }
      AtomicInteger localAtomicInteger2 = (AtomicInteger)this.Rm.get(paramString);
      AtomicInteger localAtomicInteger1 = localAtomicInteger2;
      if (localAtomicInteger2 == null)
      {
        localAtomicInteger1 = new AtomicInteger();
        this.Rm.put(paramString, localAtomicInteger1);
      }
      localAtomicInteger1.addAndGet(paramInt);
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/games/internal/events/EventIncrementCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */