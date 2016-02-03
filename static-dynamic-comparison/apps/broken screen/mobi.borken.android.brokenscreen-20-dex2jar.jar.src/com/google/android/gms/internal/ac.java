package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;

public final class ac
  implements ae
{
  private final Object lq = new Object();
  private WeakHashMap<eg, ad> lr = new WeakHashMap();
  private ArrayList<ad> ls = new ArrayList();
  
  public ad a(am paramam, eg parameg)
  {
    synchronized (this.lq)
    {
      if (c(parameg))
      {
        paramam = (ad)this.lr.get(parameg);
        return paramam;
      }
      paramam = new ad(paramam, parameg);
      paramam.a(this);
      this.lr.put(parameg, paramam);
      this.ls.add(paramam);
      return paramam;
    }
  }
  
  public void a(ad paramad)
  {
    synchronized (this.lq)
    {
      if (!paramad.au()) {
        this.ls.remove(paramad);
      }
      return;
    }
  }
  
  public boolean c(eg parameg)
  {
    for (;;)
    {
      synchronized (this.lq)
      {
        parameg = (ad)this.lr.get(parameg);
        if ((parameg != null) && (parameg.au()))
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public void d(eg parameg)
  {
    synchronized (this.lq)
    {
      parameg = (ad)this.lr.get(parameg);
      if (parameg != null) {
        parameg.as();
      }
      return;
    }
  }
  
  public void pause()
  {
    synchronized (this.lq)
    {
      Iterator localIterator = this.ls.iterator();
      if (localIterator.hasNext()) {
        ((ad)localIterator.next()).pause();
      }
    }
  }
  
  public void resume()
  {
    synchronized (this.lq)
    {
      Iterator localIterator = this.ls.iterator();
      if (localIterator.hasNext()) {
        ((ad)localIterator.next()).resume();
      }
    }
  }
  
  public void stop()
  {
    synchronized (this.lq)
    {
      Iterator localIterator = this.ls.iterator();
      if (localIterator.hasNext()) {
        ((ad)localIterator.next()).stop();
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/internal/ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */