package com.flurry.android;

import android.os.Handler;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class ag
{
  private List a = new ArrayList();
  private Handler b;
  private Handler c;
  private int d;
  private Runnable e;
  
  ag(Handler paramHandler, int paramInt)
  {
    this.b = paramHandler;
    this.c = new Handler();
    this.d = paramInt;
    this.e = new k(this);
    b();
  }
  
  private void a()
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        o localo = (o)((WeakReference)localIterator.next()).get();
        if (localo != null) {
          localArrayList.add(localo);
        }
      }
      this.c.post(new j(localList));
    }
    finally {}
    b();
  }
  
  private void b()
  {
    try
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        if (((WeakReference)localIterator.next()).get() == null) {
          localIterator.remove();
        }
      }
      this.b.removeCallbacks(this.e);
    }
    finally {}
    this.b.postDelayed(this.e, this.d);
  }
  
  final void a(o paramo)
  {
    try
    {
      paramo.a();
      this.a.add(new WeakReference(paramo));
      return;
    }
    finally
    {
      paramo = finally;
      throw paramo;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/paper toss/com.bfs.papertoss-7005-dex2jar.jar!/com/flurry/android/ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */