package com.gtp.go.weather.sharephoto;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import com.gau.go.launcherex.gowidget.weather.globalview.a;
import java.util.ArrayList;
import java.util.Iterator;

class v
{
  private View b;
  private TextView c;
  private CheckBox d;
  private a e;
  
  v(PhotoReportActivity paramPhotoReportActivity)
  {
    this.b = paramPhotoReportActivity.getLayoutInflater().inflate(2130903117, null);
    this.c = ((TextView)this.b.findViewById(2131231119));
    this.d = ((CheckBox)this.b.findViewById(2131231256));
  }
  
  private void b()
  {
    this.c.setText(this.e.a);
    this.d.setChecked(this.e.b);
  }
  
  public void a()
  {
    Iterator localIterator = PhotoReportActivity.a(this.a).iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (locala.b) {
        locala.b = false;
      }
    }
    this.e.b = true;
    PhotoReportActivity.b(this.a).notifyDataSetChanged();
  }
  
  void a(int paramInt)
  {
    this.e = ((a)PhotoReportActivity.a(this.a).get(paramInt));
    b();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */