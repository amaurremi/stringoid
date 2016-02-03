package com.gtp.go.weather.sharephoto.view;

import com.gtp.go.weather.sharephoto.b.e;
import com.gtp.go.weather.sharephoto.b.p;
import com.gtp.go.weather.sharephoto.c.a;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;

class h
  implements a
{
  h(g paramg) {}
  
  public void a(e parame) {}
  
  public void b(e parame)
  {
    long l = parame.f();
    Iterator localIterator1 = g.a(this.a).iterator();
    p localp;
    do
    {
      Iterator localIterator2;
      while (!localIterator2.hasNext())
      {
        if (!localIterator1.hasNext()) {
          break;
        }
        localIterator2 = ((com.gtp.go.weather.sharephoto.b.h)localIterator1.next()).b().values().iterator();
      }
      localp = (p)localIterator2.next();
    } while ((localp.c() != l) || (!localp.b()));
    localp.a(parame);
    this.a.notifyDataSetChanged();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/view/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */