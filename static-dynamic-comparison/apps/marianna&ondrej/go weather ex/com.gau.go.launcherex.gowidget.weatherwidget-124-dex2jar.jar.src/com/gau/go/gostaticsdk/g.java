package com.gau.go.gostaticsdk;

class g
  extends Thread
{
  g(f paramf, String paramString)
  {
    super(paramString);
  }
  
  public void run()
  {
    for (;;)
    {
      try
      {
        if (d.a(this.a.a))
        {
          com.gau.go.gostaticsdk.f.d.a("StatisticsManager", "quit post!");
          d.b(this.a.a);
          return;
        }
        com.gau.go.gostaticsdk.a.a locala = d.c(this.a.a).a();
        if ((locala != null) || (locala != null)) {
          break label106;
        }
        if (d.d(this.a.a))
        {
          com.gau.go.gostaticsdk.f.d.a("StatisticsManager", "now push data from DB!");
          continue;
          continue;
        }
      }
      catch (Exception localException)
      {
        com.gau.go.gostaticsdk.f.d.a(localException);
      }
      com.gau.go.gostaticsdk.f.d.a("StatisticsManager", "no data quit!");
      d.a(this.a.a, true);
      continue;
      label106:
      if (localException.g < 3) {
        d.a(this.a.a, localException);
      }
      if (localException.f == 3)
      {
        d.e(this.a.a).b(localException);
      }
      else
      {
        localException.g += 1;
        if (localException.g < 3) {
          d.c(this.a.a).a(localException);
        } else if (!localException.a()) {
          d.e(this.a.a).a(localException);
        }
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/gostaticsdk/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */