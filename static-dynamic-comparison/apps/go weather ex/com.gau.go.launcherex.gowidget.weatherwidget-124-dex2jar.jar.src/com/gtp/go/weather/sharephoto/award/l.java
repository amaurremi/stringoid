package com.gtp.go.weather.sharephoto.award;

import com.gau.go.launcherex.gowidget.weather.service.a.g;

class l
  extends g
{
  l(k paramk) {}
  
  public void b(com.gau.go.launcherex.gowidget.weather.service.a.a parama)
  {
    if ((parama instanceof w)) {
      k.a(this.a);
    }
    do
    {
      return;
      if ((parama instanceof v))
      {
        k.b(this.a);
        return;
      }
      if ((parama instanceof u))
      {
        parama = (u)parama;
        k.a(this.a, parama.c());
        return;
      }
      if ((parama instanceof t))
      {
        parama = (t)parama;
        k.a(this.a, parama.c(), parama.d(), parama.e());
        return;
      }
    } while (!(parama instanceof a));
    parama = (a)parama;
    k.a(this.a, parama.e(), parama.c(), parama.d());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/award/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */