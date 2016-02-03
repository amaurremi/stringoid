package com.gtp.nextlauncher.widget.nextpanel;

class d
  implements Runnable
{
  d(Fog paramFog) {}
  
  public void run()
  {
    Fog.access$000(this.a)[0] = e.a().h(Fog.access$100(this.a));
    Fog.access$000(this.a)[1] = e.a().i(Fog.access$200(this.a));
    Fog.access$000(this.a)[2] = e.a().j(Fog.access$300(this.a));
    Fog.access$402(this.a, true);
    Fog.access$502(this.a, false);
    if ((Fog.access$600(this.a) > 0) && (Fog.access$700(this.a) > 0)) {
      Fog.access$1000(this.a, Fog.access$800(this.a), Fog.access$900(this.a));
    }
    if (Fog.access$1100(this.a))
    {
      Fog.access$1200(this.a);
      Fog.access$1102(this.a, false);
      Fog.access$1302(this.a, true);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/nextlauncher/widget/nextpanel/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */