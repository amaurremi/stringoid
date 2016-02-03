package com.go.weatherex.f;

import android.view.View;
import android.widget.TextView;
import com.go.weatherex.framework.fragment.a;
import com.go.weatherex.framework.fragment.f;

class p
  extends com.gau.go.launcherex.gowidget.weather.viewframe.viewholder.b
{
  private TextView b;
  private com.gau.go.launcherex.gowidget.weather.model.b c;
  
  public p(n paramn)
  {
    this.e = n.b(paramn).i().a(2130903270, null);
    this.b = ((TextView)b(2131231887));
    this.e.setTag(this);
  }
  
  void a(com.gau.go.launcherex.gowidget.weather.model.b paramb)
  {
    this.c = paramb;
    this.b.setText(this.c.f());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/f/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */