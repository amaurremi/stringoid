package com.go.weatherex.weatheralert;

import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.format.Time;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;
import com.gau.go.launcherex.gowidget.language.GoWeatherEXActivity;
import com.gau.go.launcherex.gowidget.statistics.y;
import com.gau.go.launcherex.gowidget.weather.c.e;
import com.gau.go.launcherex.gowidget.weather.model.NowBean;
import com.gau.go.launcherex.gowidget.weather.model.WeatherBean;
import com.gau.go.launcherex.gowidget.weather.model.q;
import com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider;
import com.gau.go.launcherex.gowidget.weather.scroller.WeatherDetailScrollGroup;
import com.gau.go.launcherex.gowidget.weather.scroller.l;
import com.gau.go.launcherex.gowidget.weather.view.Indicator;
import com.gau.go.launcherex.gowidget.weather.view.WeatherDetailActivity;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class WeatherAlertActivity
  extends GoWeatherEXActivity
  implements l
{
  private final com.gau.go.launcherex.gowidget.d.h a = new com.gau.go.launcherex.gowidget.d.h();
  private e b;
  private d c;
  private String d;
  private ArrayList e = new ArrayList();
  private f f;
  private TextView g;
  private View h;
  private h i;
  private WeatherDetailScrollGroup j = null;
  private Indicator k = null;
  private View l;
  private TextView m;
  private CheckBox n;
  
  private void a(String paramString, boolean paramBoolean)
  {
    Object localObject1 = this.b.a().F;
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = "";
    }
    if (paramBoolean)
    {
      localObject1 = localObject2;
      if (((String)localObject2).contains(paramString))
      {
        paramString = ((String)localObject2).replace(paramString, "");
        if (!paramString.startsWith("#")) {
          break label118;
        }
        paramString.replaceFirst("#", "");
        localObject1 = paramString;
      }
    }
    for (;;)
    {
      this.b.b((String)localObject1);
      this.b.a(WeatherContentProvider.g, "setting_key", "no_alerts_cities", "setting_value", (String)localObject1);
      this.b.a((String)localObject1);
      this.b.a(WeatherContentProvider.g, "setting_key", "no_notify_temp_change_cities", "setting_value", (String)localObject1);
      return;
      label118:
      if (paramString.contains("##"))
      {
        localObject1 = paramString.replace("##", "");
      }
      else
      {
        localObject1 = paramString;
        if (paramString.endsWith("#"))
        {
          localObject1 = paramString.substring(0, paramString.lastIndexOf("#"));
          continue;
          localObject1 = localObject2;
          if (!((String)localObject2).contains(paramString)) {
            if (TextUtils.isEmpty((CharSequence)localObject2)) {
              localObject1 = paramString;
            } else {
              localObject1 = (String)localObject2 + "#" + paramString;
            }
          }
        }
      }
    }
  }
  
  private boolean a(String paramString)
  {
    Object localObject3 = null;
    Object localObject1 = this.b.a().F;
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = "";
    }
    localObject1 = localObject3;
    if ((TextUtils.isEmpty((CharSequence)localObject2)) || (((String)localObject2).contains("#"))) {}
    for (;;)
    {
      int i1;
      try
      {
        localObject1 = ((String)localObject2).split("#");
        if (localObject1 == null) {
          break;
        }
        int i2 = localObject1.length;
        i1 = 0;
        if (i1 >= i2) {
          break;
        }
        localObject2 = localObject1[i1];
        if ((TextUtils.isEmpty((CharSequence)localObject2)) || (!((String)localObject2).equals(paramString))) {
          break label139;
        }
        return false;
      }
      catch (Exception localException)
      {
        localObject1 = localObject3;
        if (!com.gtp.a.a.b.c.a()) {
          continue;
        }
        localException.printStackTrace();
        localObject1 = localObject3;
        continue;
      }
      localObject1 = new String[1];
      localObject1[0] = localException;
      continue;
      label139:
      i1 += 1;
    }
    return true;
  }
  
  private String b(String paramString)
  {
    if (paramString != null)
    {
      int i1 = paramString.lastIndexOf(" ");
      if (i1 != -1) {
        return paramString.substring(0, i1);
      }
    }
    return "";
  }
  
  private void b()
  {
    Intent localIntent;
    if (this.j.b() < this.i.getCount())
    {
      com.gau.go.launcherex.gowidget.weather.model.c localc = (com.gau.go.launcherex.gowidget.weather.model.c)this.i.getItem(this.j.b());
      String str = com.gau.go.launcherex.gowidget.weather.c.c.a(getApplicationContext()).h().e(localc.j());
      localIntent = new Intent("android.intent.action.SEND");
      localIntent.setType("text/plain");
      localIntent.putExtra("android.intent.extra.SUBJECT", getString(2131165787));
      localIntent.putExtra("android.intent.extra.TEXT", getString(2131165788, new Object[] { str, localc.f(), c(localc.c()) }));
    }
    try
    {
      startActivity(Intent.createChooser(localIntent, getString(2131165347)));
      return;
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
      Toast.makeText(this, 2131165348, 0).show();
    }
  }
  
  @SuppressLint({"SimpleDateFormat"})
  private String c(String paramString)
  {
    Object localObject2 = new SimpleDateFormat("yyyy/MM/dd HH:mm Z");
    Object localObject1 = null;
    try
    {
      localObject2 = ((SimpleDateFormat)localObject2).parse(paramString);
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i1;
        localException.printStackTrace();
        continue;
        ((StringBuffer)localObject1).append(i1).append("/");
        continue;
        label274:
        ((StringBuffer)localObject1).append(i1).append(" ");
        continue;
        label288:
        ((StringBuffer)localObject1).append(i1).append(":");
        continue;
        label303:
        ((StringBuffer)localObject1).append(i1);
      }
    }
    if (localObject1 != null)
    {
      localObject2 = com.gau.go.launcherex.gowidget.weather.util.f.a(getApplicationContext()).a(this.d);
      if (localObject2 != null)
      {
        paramString = new Time();
        paramString.set(((Date)localObject1).getTime());
        paramString.set(paramString.toMillis(true) - (paramString.gmtoff * 1000L - ((WeatherBean)localObject2).k.n()));
        localObject1 = new StringBuffer();
        ((StringBuffer)localObject1).append(paramString.year).append("/");
        i1 = paramString.month + 1;
        if ((i1 >= 0) && (i1 <= 9))
        {
          ((StringBuffer)localObject1).append("0").append(i1).append("/");
          i1 = paramString.monthDay;
          if ((i1 < 0) || (i1 > 9)) {
            break label274;
          }
          ((StringBuffer)localObject1).append("0").append(i1).append(" ");
          i1 = paramString.hour;
          if ((i1 < 0) || (i1 > 9)) {
            break label288;
          }
          ((StringBuffer)localObject1).append("0").append(i1).append(":");
          i1 = paramString.minute;
          if ((i1 < 0) || (i1 > 9)) {
            break label303;
          }
          ((StringBuffer)localObject1).append("0").append(i1);
          return ((StringBuffer)localObject1).toString();
        }
      }
    }
    return b(paramString);
  }
  
  private void f()
  {
    if (this.e.size() == 0)
    {
      finish();
      return;
    }
    this.i.a(this.e);
    g();
  }
  
  private void g()
  {
    this.j.removeAllViews();
    int i1 = 0;
    while (i1 < this.i.getCount())
    {
      this.j.addView(this.i.getView(i1, null, null));
      i1 += 1;
    }
    this.j.a();
    this.k.a(this.j.getChildCount());
    this.k.c((int)(10.0F * e().getDisplayMetrics().density));
    this.k.b(this.j.b());
  }
  
  public void a()
  {
    f();
  }
  
  public void a(com.gau.go.launcherex.gowidget.language.b paramb)
  {
    super.a(paramb);
    if (this != null)
    {
      this.g.setText(getString(2131165785));
      this.m.setText(getString(2131165786));
    }
  }
  
  public void a(WeatherDetailScrollGroup paramWeatherDetailScrollGroup, int paramInt) {}
  
  public void b(WeatherDetailScrollGroup paramWeatherDetailScrollGroup, int paramInt)
  {
    this.k.b(paramInt);
  }
  
  public void c(WeatherDetailScrollGroup paramWeatherDetailScrollGroup, int paramInt) {}
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903341);
    getWindow().clearFlags(134217728);
    this.a.a(800L);
    this.b = com.gau.go.launcherex.gowidget.weather.c.c.a(getApplicationContext()).f();
    paramBundle = getIntent();
    if (paramBundle != null)
    {
      this.d = paramBundle.getStringExtra("cityId");
      if (TextUtils.isEmpty(this.d))
      {
        finish();
        return;
      }
    }
    this.f = new f(this, null);
    paramBundle = new IntentFilter();
    paramBundle.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_UPDATE_EXTREME_WEATHER");
    paramBundle.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_DELETE_EXPIRED_EXTREME_WEATHER");
    paramBundle.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_CLEAR_EXTREME_WEATHER");
    registerReceiver(this.f, paramBundle);
    this.g = ((TextView)findViewById(2131232043));
    this.h = findViewById(2131232044);
    this.h.setOnClickListener(new a(this));
    this.j = ((WeatherDetailScrollGroup)findViewById(2131232045));
    this.j.a(this);
    this.i = new h(this);
    this.k = ((Indicator)findViewById(2131232046));
    this.k.a(2130838962, 2130838961);
    this.k.c((int)(10.0F * e().getDisplayMetrics().density));
    this.l = findViewById(2131232047);
    this.l.setOnClickListener(new b(this));
    this.m = ((TextView)findViewById(2131232048));
    this.n = ((CheckBox)findViewById(2131232049));
    paramBundle = this.n;
    if (!a(this.d)) {}
    for (boolean bool = true;; bool = false)
    {
      paramBundle.setChecked(bool);
      this.n.setOnCheckedChangeListener(new c(this));
      this.c = new d(this, getContentResolver());
      this.c.a(this.d);
      return;
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    unregisterReceiver(this.f);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      setResult(-1, new Intent(this, WeatherDetailActivity.class));
      finish();
      overridePendingTransition(2130968606, 2130968585);
    }
    return false;
  }
  
  public void onStart()
  {
    super.onStart();
    y.a("weather_warning_detail_show", getApplicationContext());
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    setResult(-1, new Intent(this, WeatherDetailActivity.class));
    finish();
    overridePendingTransition(2130968606, 2130968585);
    return super.onTouchEvent(paramMotionEvent);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/weatheralert/WeatherAlertActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */