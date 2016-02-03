package com.android.a;

import android.os.Handler;
import android.os.Looper;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class s
{
  private AtomicInteger a = new AtomicInteger();
  private final Map b = new HashMap();
  private final Set c = new HashSet();
  private final PriorityBlockingQueue d = new PriorityBlockingQueue();
  private final PriorityBlockingQueue e = new PriorityBlockingQueue();
  private final b f;
  private final j g;
  private final w h;
  private k[] i;
  private d j;
  
  public s(b paramb, j paramj)
  {
    this(paramb, paramj, 4);
  }
  
  public s(b paramb, j paramj, int paramInt)
  {
    this(paramb, paramj, paramInt, new g(new Handler(Looper.getMainLooper())));
  }
  
  public s(b paramb, j paramj, int paramInt, w paramw)
  {
    this.f = paramb;
    this.g = paramj;
    this.i = new k[paramInt];
    this.h = paramw;
  }
  
  public p a(p paramp)
  {
    paramp.a(this);
    synchronized (this.c)
    {
      this.c.add(paramp);
      paramp.a(c());
      paramp.a("add-to-queue");
      if (!paramp.r())
      {
        this.e.add(paramp);
        return paramp;
      }
    }
    for (;;)
    {
      String str;
      synchronized (this.b)
      {
        str = paramp.e();
        if (this.b.containsKey(str))
        {
          Queue localQueue = (Queue)this.b.get(str);
          ??? = localQueue;
          if (localQueue == null) {
            ??? = new LinkedList();
          }
          ((Queue)???).add(paramp);
          this.b.put(str, ???);
          if (ab.b) {
            ab.a("Request for cacheKey=%s is in flight, putting on hold.", new Object[] { str });
          }
          return paramp;
        }
      }
      this.b.put(str, null);
      this.d.add(paramp);
    }
  }
  
  public void a()
  {
    b();
    this.j = new d(this.d, this.e, this.f, this.h);
    this.j.start();
    int k = 0;
    for (;;)
    {
      if (k >= this.i.length) {
        return;
      }
      k localk = new k(this.e, this.g, this.f, this.h);
      this.i[k] = localk;
      localk.start();
      k += 1;
    }
  }
  
  public void b()
  {
    if (this.j != null) {
      this.j.a();
    }
    int k = 0;
    for (;;)
    {
      if (k >= this.i.length) {
        return;
      }
      if (this.i[k] != null) {
        this.i[k].a();
      }
      k += 1;
    }
  }
  
  void b(p paramp)
  {
    synchronized (this.c)
    {
      this.c.remove(paramp);
      if (!paramp.r()) {}
    }
    synchronized (this.b)
    {
      paramp = paramp.e();
      Queue localQueue = (Queue)this.b.remove(paramp);
      if (localQueue != null)
      {
        if (ab.b) {
          ab.a("Releasing %d waiting requests for cacheKey=%s.", new Object[] { Integer.valueOf(localQueue.size()), paramp });
        }
        this.d.addAll(localQueue);
      }
      return;
      paramp = finally;
      throw paramp;
    }
  }
  
  public int c()
  {
    return this.a.incrementAndGet();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/android/a/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */