package com.gtp.go.weather.sharephoto.takephoto;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.TextView;

public class aj
  extends ap
{
  public aj(Context paramContext)
  {
    super(paramContext, 2);
    a(LayoutInflater.from(this.a).inflate(2130903288, null));
    this.i = ((TextView)a(2131231924));
    this.j = ((TextView)a(2131231928));
    this.k = ((TextView)a(2131231929));
    this.l = ((TextView)a(2131231925));
    this.m = ((TextView)a(2131231926));
    this.n = ((TextView)a(2131231927));
    this.p = new aq(this.a, a(2131231918), new int[] { 2130838568, 2130838569, 2130838570, 2130838571, 2130838572, 2130838573, 2130838574, 2130838575, 2130838576, 2130838577, 2130838578, 2130838532, 2130838533 });
  }
  
  public void b()
  {
    float f2 = this.b - i() - c(30);
    float f1 = f2;
    if (f2 < 0.0F) {
      f1 = this.b - i() / 2;
    }
    a(f1 / this.b);
    int i = d(40);
    f1 = i;
    if (i + j() > this.c) {
      f1 = this.c - j() / 2;
    }
    b(f1 / this.c);
  }
  
  protected void c()
  {
    super.c();
    if (this.b > this.c)
    {
      this.f *= 0.62F;
      return;
    }
    this.f *= 0.6F;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/takephoto/aj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */