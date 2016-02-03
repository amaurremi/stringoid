package com.go.weatherex.home.current;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Window;
import android.widget.TextView;
import com.gau.go.launcherex.gowidget.language.GoWeatherEXActivity;
import com.gau.go.launcherex.gowidget.language.b;
import com.gau.go.launcherex.gowidget.weather.model.NowBean;
import com.gau.go.launcherex.gowidget.weather.model.WeatherBean;
import com.gau.go.launcherex.gowidget.weather.util.f;
import com.gau.go.launcherex.gowidget.weather.util.r;
import com.gtp.a.a.c.c;
import java.util.Map;

public class AirQualityIndex
  extends GoWeatherEXActivity
{
  public static final String a = c.a() + "/share/weibo/aqi.jpg";
  private static final int[] m = { -4740862, -616446, -1285886, -8519424 };
  private TextView b;
  private TextView c;
  private TextView d;
  private TextView e;
  private TextView f;
  private TextView g;
  private TextView h;
  private TextView i;
  private String j = "";
  private WeatherBean k = null;
  private String[] l = { getString(2131165932), getString(2131165933), getString(2131165934), getString(2131165935) };
  private f n;
  private BroadcastReceiver o = new a(this);
  
  private void a()
  {
    if (TextUtils.isEmpty(this.j)) {
      return;
    }
    this.k = ((WeatherBean)this.n.c().get(this.j));
    if (this.k != null)
    {
      Object localObject = this.k.k;
      this.b.setText(this.k.d() + "");
      int i1 = ((NowBean)localObject).p();
      if (i1 != 55536)
      {
        this.c.setText(i1 + "");
        i1 = ((NowBean)localObject).q() - 1;
        if ((i1 < 0) || (i1 > this.l.length + 1)) {
          break label473;
        }
        if ((i1 != 0) && (i1 != 1)) {
          break label403;
        }
        this.d.setText(this.l[0]);
        this.d.setTextColor(m[0]);
        label175:
        i1 = ((NowBean)localObject).r();
        if (i1 == 55536) {
          break label485;
        }
        this.f.setText(i1 + "");
        label213:
        i1 = ((NowBean)localObject).s();
        if (i1 == 55536) {
          break label497;
        }
        this.g.setText(i1 + "");
        label251:
        i1 = ((NowBean)localObject).t();
        if (i1 == 55536) {
          break label509;
        }
        this.h.setText(i1 + "");
        label289:
        i1 = ((NowBean)localObject).u();
        if (i1 == 55536) {
          break label521;
        }
        this.i.setText(i1 + "");
      }
      for (;;)
      {
        localObject = r.a(this, this.k.k.f());
        if (!((String)localObject).equals("-10000")) {
          break label533;
        }
        this.e.setText(e().getString(2131165888) + " : " + "--");
        return;
        this.c.setText("--");
        break;
        label403:
        if ((i1 == 4) || (i1 == 5))
        {
          this.d.setText(this.l[3]);
          this.d.setTextColor(m[3]);
          break label175;
        }
        this.d.setText(this.l[(i1 - 1)]);
        this.d.setTextColor(m[(i1 - 1)]);
        break label175;
        label473:
        this.d.setText("--");
        break label175;
        label485:
        this.f.setText("--");
        break label213;
        label497:
        this.g.setText("--");
        break label251;
        label509:
        this.h.setText("--");
        break label289;
        label521:
        this.i.setText("--");
      }
      label533:
      this.e.setText((CharSequence)localObject);
      return;
    }
    this.c.setText("--");
    this.d.setText("--");
    this.f.setText("--");
    this.g.setText("--");
    this.h.setText("--");
    this.i.setText("--");
    this.e.setText(e().getString(2131165888) + " : " + "--");
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903058);
    getWindow().clearFlags(134217728);
    this.b = ((TextView)findViewById(2131230904));
    this.c = ((TextView)findViewById(2131230903));
    this.d = ((TextView)findViewById(2131230905));
    this.f = ((TextView)findViewById(2131230909));
    this.g = ((TextView)findViewById(2131230913));
    this.h = ((TextView)findViewById(2131230918));
    this.i = ((TextView)findViewById(2131230923));
    this.e = ((TextView)findViewById(2131230925));
    paramBundle = new IntentFilter();
    paramBundle.addAction("com.gau.go.launcherex.gowidget.weatherwidget.goweather.ACTION_UPDATE_DATA");
    registerReceiver(this.o, paramBundle);
    paramBundle = getIntent();
    if (paramBundle != null) {
      this.j = paramBundle.getStringExtra("cityId");
    }
    this.n = f.a(getApplicationContext());
    a();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    unregisterReceiver(this.o);
    if (this.k != null) {
      this.k = null;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/home/current/AirQualityIndex.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */