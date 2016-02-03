package com.gau.go.launcherex.gowidget.weather.globalview;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import java.util.ArrayList;

class k
{
  private View b;
  private TextView c;
  private CheckBox d;
  private a e;
  
  k(i parami)
  {
    this.b = parami.a.getLayoutInflater().inflate(2130903115, null);
    this.c = ((TextView)this.b.findViewById(2131231194));
    this.d = ((CheckBox)this.b.findViewById(2131231195));
  }
  
  private void b()
  {
    this.c.setText(this.e.a);
    this.d.setChecked(this.e.b);
  }
  
  public void a()
  {
    a locala = this.e;
    if (!this.e.b) {}
    for (boolean bool = true;; bool = false)
    {
      locala.b = bool;
      b();
      return;
    }
  }
  
  void a(int paramInt)
  {
    this.e = ((a)i.a(this.a).get(paramInt));
    b();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/globalview/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */