package com.pocket.m;

import com.ideashower.readitlater.g.g;
import com.pocket.m.b.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

class c
  extends g
{
  protected void a()
  {
    synchronized ()
    {
      Object localObject2 = new ArrayList(a.y());
      a.y().clear();
      ??? = ((ArrayList)localObject2).iterator();
      if (((Iterator)???).hasNext())
      {
        int i = ((Integer)((Iterator)???).next()).intValue();
        localObject2 = (f)a.s().remove(Integer.valueOf(i));
        if (localObject2 != null) {
          ((f)localObject2).D();
        }
        localObject2 = (f)a.t().remove(Integer.valueOf(i));
        if (localObject2 != null) {
          ((f)localObject2).D();
        }
        a.v().decrementAndGet();
        a.u().decrementAndGet();
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/m/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */