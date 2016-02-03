package com.google.android.gms.internal;

import android.content.Context;
import android.view.MotionEvent;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

final class ql
  implements g, Runnable
{
  private final List<Object[]> a = new Vector();
  private final CountDownLatch b = new CountDownLatch(1);
  private final AtomicReference<g> c = new AtomicReference();
  private qm d;
  
  public ql(qm paramqm)
  {
    this.d = paramqm;
    if (et.bW())
    {
      en.execute(this);
      return;
    }
    run();
  }
  
  private void a()
  {
    try
    {
      this.b.await();
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      eu.c("Interrupted during GADSignals creation.", localInterruptedException);
    }
  }
  
  private void b()
  {
    if (this.a.isEmpty()) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        Object[] arrayOfObject = (Object[])localIterator.next();
        if (arrayOfObject.length == 1) {
          ((g)this.c.get()).a((MotionEvent)arrayOfObject[0]);
        } else if (arrayOfObject.length == 3) {
          ((g)this.c.get()).a(((Integer)arrayOfObject[0]).intValue(), ((Integer)arrayOfObject[1]).intValue(), ((Integer)arrayOfObject[2]).intValue());
        }
      }
    }
  }
  
  public String a(Context paramContext)
  {
    a();
    if (this.c.get() != null)
    {
      b();
      return ((g)this.c.get()).a(paramContext);
    }
    return "";
  }
  
  public String a(Context paramContext, String paramString)
  {
    a();
    if (this.c.get() != null)
    {
      b();
      return ((g)this.c.get()).a(paramContext, paramString);
    }
    return "";
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    g localg = (g)this.c.get();
    if (localg != null)
    {
      b();
      localg.a(paramInt1, paramInt2, paramInt3);
      return;
    }
    this.a.add(new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
  }
  
  public void a(MotionEvent paramMotionEvent)
  {
    g localg = (g)this.c.get();
    if (localg != null)
    {
      b();
      localg.a(paramMotionEvent);
      return;
    }
    this.a.add(new Object[] { paramMotionEvent });
  }
  
  public String b(Context paramContext)
  {
    a();
    if (this.c.get() != null)
    {
      b();
      return ((g)this.c.get()).b(paramContext);
    }
    return "";
  }
  
  public void run()
  {
    try
    {
      this.c.set(j.a(this.d.e.sw, this.d.c));
      return;
    }
    finally
    {
      this.b.countDown();
      this.d = null;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/ql.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */