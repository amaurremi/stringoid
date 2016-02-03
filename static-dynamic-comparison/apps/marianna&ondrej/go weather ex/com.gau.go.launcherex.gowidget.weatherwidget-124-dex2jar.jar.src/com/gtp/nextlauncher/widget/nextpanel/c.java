package com.gtp.nextlauncher.widget.nextpanel;

class c
  implements Runnable
{
  c(DayWallView paramDayWallView) {}
  
  public void run()
  {
    if (DayWallView.access$000(this.a) == null)
    {
      DayWallView.access$002(this.a, e.a().s(DayWallView.access$100(this.a)));
      DayWallView.access$202(this.a, false);
    }
    if ((DayWallView.access$300(this.a) > 0) && (DayWallView.access$400(this.a) > 0))
    {
      DayWallView.access$700(this.a, DayWallView.access$500(this.a), DayWallView.access$600(this.a));
      DayWallView.access$202(this.a, true);
    }
    if (DayWallView.access$800(this.a))
    {
      DayWallView.access$902(this.a, false);
      int i = 0;
      if (i < 3)
      {
        if (i == 0) {
          DayWallView.access$1000(this.a)[i] = e.a().x(DayWallView.access$1100(this.a));
        }
        for (;;)
        {
          i += 1;
          break;
          if (i == 1) {
            DayWallView.access$1000(this.a)[i] = e.a().B(DayWallView.access$1200(this.a));
          } else if (i == 2) {
            DayWallView.access$1000(this.a)[i] = e.a().C(DayWallView.access$1300(this.a));
          }
        }
      }
      if ((DayWallView.access$1400(this.a) > 0) && (DayWallView.access$1500(this.a) > 0))
      {
        DayWallView.access$1800(this.a, DayWallView.access$1600(this.a), DayWallView.access$1700(this.a));
        DayWallView.access$902(this.a, true);
      }
    }
    if (DayWallView.access$1900(this.a) == null) {
      DayWallView.access$1902(this.a, e.a().o(DayWallView.access$2000(this.a)));
    }
    if (DayWallView.access$2100(this.a) == null) {
      DayWallView.access$2102(this.a, e.a().p(DayWallView.access$2200(this.a)));
    }
    if (DayWallView.access$2300(this.a) == null) {
      DayWallView.access$2302(this.a, e.a().q(DayWallView.access$2400(this.a)));
    }
    if (DayWallView.access$2500(this.a) == null) {
      DayWallView.access$2502(this.a, e.a().r(DayWallView.access$2600(this.a)));
    }
    DayWallView.access$2702(this.a, false);
    if ((DayWallView.access$2800(this.a) > 0) && (DayWallView.access$2900(this.a) > 0))
    {
      DayWallView.access$3200(this.a, DayWallView.access$3000(this.a), DayWallView.access$3100(this.a));
      DayWallView.access$2702(this.a, true);
    }
    if (DayWallView.access$3300(this.a)) {
      DayWallView.access$3400(this.a);
    }
    DayWallView.access$3302(this.a, false);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/nextlauncher/widget/nextpanel/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */