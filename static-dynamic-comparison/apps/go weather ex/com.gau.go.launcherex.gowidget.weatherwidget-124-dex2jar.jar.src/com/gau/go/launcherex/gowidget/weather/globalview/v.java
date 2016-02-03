package com.gau.go.launcherex.gowidget.weather.globalview;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Iterator;

class v
{
  private View b;
  private TextView c;
  private RadioButton d;
  private a e;
  
  v(t paramt)
  {
    this.b = paramt.a.getLayoutInflater().inflate(2130903120, null);
    this.c = ((TextView)this.b.findViewById(2131231194));
    this.d = ((RadioButton)this.b.findViewById(2131231195));
  }
  
  private void b()
  {
    this.c.setText(this.e.a);
    this.d.setChecked(this.e.b);
  }
  
  public void a()
  {
    Iterator localIterator = t.a(this.a).iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (locala.b) {
        locala.b = false;
      }
    }
    this.e.b = true;
    t.b(this.a).notifyDataSetChanged();
    t.a(this.a, true);
    this.a.dismiss();
  }
  
  void a(int paramInt)
  {
    this.e = ((a)t.a(this.a).get(paramInt));
    b();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/globalview/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */