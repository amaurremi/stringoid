package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;

public final class ab
  implements ad
{
  private final Object ls = new Object();
  private WeakHashMap<ef, ac> lt = new WeakHashMap();
  private ArrayList<ac> lu = new ArrayList();
  
  public ac a(al paramal, ef paramef)
  {
    synchronized (this.ls)
    {
      if (c(paramef))
      {
        paramal = (ac)this.lt.get(paramef);
        return paramal;
      }
      paramal = new ac(paramal, paramef);
      paramal.a(this);
      this.lt.put(paramef, paramal);
      this.lu.add(paramal);
      return paramal;
    }
  }
  
  public void a(ac paramac)
  {
    synchronized (this.ls)
    {
      if (!paramac.az()) {
        this.lu.remove(paramac);
      }
      return;
    }
  }
  
  public boolean c(ef paramef)
  {
    for (;;)
    {
      synchronized (this.ls)
      {
        paramef = (ac)this.lt.get(paramef);
        if ((paramef != null) && (paramef.az()))
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public void d(ef paramef)
  {
    synchronized (this.ls)
    {
      paramef = (ac)this.lt.get(paramef);
      if (paramef != null) {
        paramef.ax();
      }
      return;
    }
  }
  
  public void pause()
  {
    synchronized (this.ls)
    {
      Iterator localIterator = this.lu.iterator();
      if (localIterator.hasNext()) {
        ((ac)localIterator.next()).pause();
      }
    }
  }
  
  public void resume()
  {
    synchronized (this.ls)
    {
      Iterator localIterator = this.lu.iterator();
      if (localIterator.hasNext()) {
        ((ac)localIterator.next()).resume();
      }
    }
  }
  
  public void stop()
  {
    synchronized (this.ls)
    {
      Iterator localIterator = this.lu.iterator();
      if (localIterator.hasNext()) {
        ((ac)localIterator.next()).stop();
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */