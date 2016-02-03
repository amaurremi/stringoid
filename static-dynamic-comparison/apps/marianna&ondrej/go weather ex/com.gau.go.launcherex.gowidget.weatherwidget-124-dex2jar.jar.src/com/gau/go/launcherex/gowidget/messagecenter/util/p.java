package com.gau.go.launcherex.gowidget.messagecenter.util;

import com.gau.go.launcherex.gowidget.messagecenter.a.c;
import com.gau.go.launcherex.gowidget.messagecenter.a.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

class p
  implements ag
{
  p(m paramm, Vector paramVector1, Vector paramVector2, ArrayList paramArrayList) {}
  
  public void a(c paramc)
  {
    paramc = paramc.a();
    m.a(this.d, paramc, this.a, this.b);
    m.a(this.d, paramc);
    paramc = this.b.iterator();
    while (paramc.hasNext()) {
      ((d)paramc.next()).C = 3;
    }
    paramc = this.a.iterator();
    while (paramc.hasNext()) {
      ((d)paramc.next()).C = 1;
    }
    m.b(this.d, this.a, this.b);
    paramc = this.b.iterator();
    while (paramc.hasNext())
    {
      d locald = (d)paramc.next();
      if (locald.C == 3) {
        this.a.add(locald);
      }
    }
    m.a(this.d, this.a, this.c);
    m.b(this.d, this.a, this.c);
    m.b(this.d, this.a);
    m.c(this.d, this.a);
    m.c(this.d, this.a, this.c);
    i.b(this.a);
    m.d(this.d, this.a, this.c);
    m.c(this.d).a(3, null, "com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider", this.c);
  }
  
  public void a(d paramd) {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/messagecenter/util/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */