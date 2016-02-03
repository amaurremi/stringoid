package com.gtp.go.weather.sharephoto.takephoto;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.gau.go.launcherex.gowidget.weather.model.NowBean;
import com.gau.go.launcherex.gowidget.weather.model.WeatherBean;
import com.gau.go.launcherex.gowidget.weather.viewframe.viewholder.b;

public class aq
  extends b
{
  private ImageView a;
  private ImageView b;
  private ImageView c;
  private ImageView d;
  private ImageView g;
  private int[] h = new int[13];
  
  public aq(Context paramContext, View paramView, int[] paramArrayOfInt)
  {
    super(paramContext, paramView);
    this.h = paramArrayOfInt;
    this.a = ((ImageView)this.e.findViewById(2131231919));
    this.b = ((ImageView)this.e.findViewById(2131231920));
    this.c = ((ImageView)this.e.findViewById(2131231921));
    this.d = ((ImageView)this.e.findViewById(2131231922));
    this.g = ((ImageView)this.e.findViewById(2131231923));
    this.a.setImageResource(this.h[10]);
  }
  
  public void a(WeatherBean paramWeatherBean, com.gau.go.launcherex.gowidget.weather.model.q paramq)
  {
    int j = paramq.g;
    if (paramWeatherBean != null) {}
    for (int i = com.gau.go.launcherex.gowidget.weather.util.q.a(paramWeatherBean.k.a(j));; i = 55536)
    {
      int k;
      label67:
      int m;
      if (i != 55536) {
        if (i < 0)
        {
          this.a.setVisibility(0);
          i = Math.abs(i);
          k = i / 100;
          if (k != 0) {
            break label147;
          }
          this.b.setVisibility(8);
          m = (i - k * 100) / 10;
          if ((m != 0) || (k != 0)) {
            break label172;
          }
          this.c.setVisibility(8);
          label98:
          this.d.setImageResource(this.h[(i % 10)]);
        }
      }
      for (;;)
      {
        if (j != 1) {
          break label248;
        }
        this.g.setImageResource(this.h[11]);
        return;
        this.a.setVisibility(8);
        break;
        label147:
        this.b.setImageResource(this.h[k]);
        this.b.setVisibility(0);
        break label67;
        label172:
        this.c.setImageResource(this.h[m]);
        this.c.setVisibility(0);
        break label98;
        this.a.setVisibility(0);
        this.b.setVisibility(0);
        this.b.setImageResource(this.h[10]);
        this.c.setVisibility(8);
        this.d.setVisibility(8);
      }
      label248:
      this.g.setImageResource(this.h[12]);
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/takephoto/aq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */