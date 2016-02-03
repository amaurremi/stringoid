package com.gtp.go.weather.sharephoto.takephoto;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;

public class al
  extends ap
{
  public al(Context paramContext)
  {
    super(paramContext, 4);
    a(LayoutInflater.from(this.a).inflate(2130903290, null));
    this.i = ((TextView)a(2131231924));
    this.j = ((TextView)a(2131231928));
    this.k = ((TextView)a(2131231929));
    this.o = ((ImageView)a(2131231254));
    this.l = ((TextView)a(2131231925));
    this.p = new aq(this.a, a(2131231918), new int[] { 2130838550, 2130838551, 2130838552, 2130838553, 2130838554, 2130838555, 2130838556, 2130838557, 2130838558, 2130838559, 2130838549, 2130838542, 2130838543 });
  }
  
  public void b()
  {
    int i = c(50);
    float f = i;
    if (i + i() > this.b) {
      f = this.b - i() / 2;
    }
    a(f / this.b);
    i = d(50);
    f = i;
    if (i + j() > this.c) {
      f = this.c - j() / 2;
    }
    b(f / this.c);
  }
  
  protected void c()
  {
    super.c();
    if (this.b > this.c)
    {
      this.f *= 0.58F;
      return;
    }
    this.f *= 0.4F;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/takephoto/al.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */