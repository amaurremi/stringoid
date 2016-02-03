package com.jiubang.playsdk.imageload;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

class g
  implements Runnable
{
  g(d paramd) {}
  
  public void run()
  {
    Iterator localIterator1 = d.b(this.a).values().iterator();
    while (localIterator1.hasNext())
    {
      h localh = (h)localIterator1.next();
      Iterator localIterator2 = h.a(localh).iterator();
      while (localIterator2.hasNext())
      {
        j localj = (j)localIterator2.next();
        if (j.a(localj) != null) {
          if (localh.a() == null)
          {
            j.a(localj, h.b(localh));
            j.a(localj).a(localj, false);
          }
          else
          {
            j.a(localj).a(localh.a());
          }
        }
      }
    }
    d.b(this.a).clear();
    d.a(this.a, null);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/playsdk/imageload/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */