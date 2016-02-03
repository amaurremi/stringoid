package com.gtp.go.weather.sharephoto.takephoto;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;

public class ak
  extends ap
{
  public ak(Context paramContext)
  {
    super(paramContext, 3);
    a(LayoutInflater.from(this.a).inflate(2130903289, null));
    this.i = ((TextView)a(2131231924));
    this.j = ((TextView)a(2131231928));
    this.k = ((TextView)a(2131231929));
    this.l = ((TextView)a(2131231925));
    this.m = ((TextView)a(2131231926));
    this.o = ((ImageView)a(2131231254));
    this.p = new aq(this.a, a(2131231918), new int[] { 2130838568, 2130838569, 2130838570, 2130838571, 2130838572, 2130838573, 2130838574, 2130838575, 2130838576, 2130838577, 2130838578, 2130838537, 2130838538 });
  }
  
  public void b()
  {
    a((this.b - i()) / this.b);
    b((this.c - j()) / this.c);
  }
  
  protected void c()
  {
    if (this.b > this.c) {}
    for (this.f = (0.7F * this.b / this.g);; this.f = (1.0F * this.b / this.g))
    {
      if (j() > this.c) {
        super.c();
      }
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/takephoto/ak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */