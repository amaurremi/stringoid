package com.go.weatherex.home.current;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.format.Time;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.gau.go.launcherex.gowidget.language.GoWeatherEXActivity;
import com.gau.go.launcherex.gowidget.language.b;
import com.gau.go.launcherex.gowidget.weather.model.NowBean;
import com.gau.go.launcherex.gowidget.weather.model.PollenIndexBean;
import com.gau.go.launcherex.gowidget.weather.model.WeatherBean;
import com.gau.go.launcherex.gowidget.weather.model.m;
import com.gau.go.launcherex.gowidget.weather.util.f;
import com.gau.go.launcherex.gowidget.weather.util.r;
import com.gau.go.launcherex.gowidget.weather.view.WeatherDetailActivity;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PollenIndex
  extends GoWeatherEXActivity
{
  private static final int[] n = { 2131165941, 2131165942, 2131165943, 2131165944, 2131165945 };
  private static final int[] o = { 2131361869, 2131361870, 2131361871, 2131361872, 2131361873 };
  private static final int[] p = { 2130838459, 2130838460, 2130838461, 2130838462, 2130838458 };
  private static final int[] q = { 2130838454, 2130838455, 2130838456, 2130838457, 2130838453 };
  private String a = "";
  private WeatherBean b = null;
  private f c = null;
  private TextView d;
  private TextView e;
  private TextView f;
  private LinearLayout g;
  private LinearLayout[] h;
  private ImageView[] i;
  private TextView[] j;
  private TextView[] k;
  private ImageView[] l;
  private TextView[] m;
  private BroadcastReceiver r = new w(this);
  
  private void a()
  {
    b();
    if (!TextUtils.isEmpty(this.a))
    {
      this.b = ((WeatherBean)this.c.c().get(this.a));
      if (this.b != null)
      {
        this.d.setText(this.b.d());
        Time localTime = com.gau.go.launcherex.gowidget.weather.c.c.a(getApplicationContext()).g().c(this.b.k.n());
        ArrayList localArrayList = new ArrayList(this.b.i);
        if (localArrayList != null)
        {
          Object localObject;
          if (localArrayList.size() > 4)
          {
            localObject = (PollenIndexBean)localArrayList.get(0);
            localObject = String.valueOf(((PollenIndexBean)localObject).b()) + String.valueOf(((PollenIndexBean)localObject).c()) + String.valueOf(((PollenIndexBean)localObject).d());
            if ((String.valueOf(localTime.year) + String.valueOf(localTime.month) + String.valueOf(localTime.monthDay)).compareTo((String)localObject) > 0) {
              localArrayList.remove(0);
            }
          }
          int i1 = 0;
          if (i1 < localArrayList.size())
          {
            PollenIndexBean localPollenIndexBean = (PollenIndexBean)localArrayList.get(i1);
            float f1;
            if (localPollenIndexBean != null)
            {
              localObject = com.gau.go.launcherex.gowidget.weather.util.c.h(this)[localPollenIndexBean.e()];
              f1 = localPollenIndexBean.f();
              if (f1 != -10000.0F)
              {
                f1 = Math.round(f1 * 10.0F) / 10.0F;
                int i3 = (int)(f1 / 2.4D);
                int i2 = i3;
                if (i3 > 4) {
                  i2 = 4;
                }
                if (r.a(localPollenIndexBean.b(), localPollenIndexBean.c() + 1, localPollenIndexBean.d(), localTime))
                {
                  localObject = getString(2131165919);
                  this.e.setText(String.valueOf(f1));
                  this.f.setText(getString(n[i2]));
                  this.f.setTextColor(e().getColor(o[i2]));
                  a(localPollenIndexBean);
                }
                if (i1 < 4)
                {
                  this.k[i1].setText((CharSequence)localObject);
                  this.k[i1].setVisibility(0);
                  this.m[i1].setBackgroundResource(p[i2]);
                  this.m[i1].setText(String.valueOf(f1));
                  this.m[i1].setVisibility(0);
                  this.l[i1].setBackgroundResource(q[i2]);
                  localObject = this.l[i1].getLayoutParams();
                  if (f1 > 13.2D) {
                    break label578;
                  }
                }
              }
            }
            label578:
            for (double d1 = f1;; d1 = 13.2D)
            {
              ((ViewGroup.LayoutParams)localObject).height = ((int)(d1 * e().getDimension(2131427758) / 2.4D));
              this.l[i1].setLayoutParams((ViewGroup.LayoutParams)localObject);
              this.l[i1].setVisibility(0);
              i1 += 1;
              break;
            }
          }
        }
      }
    }
  }
  
  private void a(PollenIndexBean paramPollenIndexBean)
  {
    int i1;
    if (paramPollenIndexBean != null)
    {
      paramPollenIndexBean = paramPollenIndexBean.g();
      if (paramPollenIndexBean != null) {
        i1 = 0;
      }
    }
    for (;;)
    {
      Object localObject1;
      Object localObject2;
      if ((i1 < paramPollenIndexBean.size()) && (i1 < 2))
      {
        localObject1 = (m)paramPollenIndexBean.get(i1);
        if (localObject1 != null)
        {
          localObject2 = ((m)localObject1).a();
          if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!((String)localObject2).equals("--")))
          {
            this.j[i1].setText((CharSequence)localObject2);
            com.gtp.a.a.b.c.a("PollenIndex", (String)localObject2);
            localObject2 = ((m)localObject1).b();
            if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!((String)localObject2).equals("--")))
            {
              localObject1 = new File(com.gtp.a.a.b.a.c + com.jiubang.core.c.a.g.a((String)localObject2) + ".png");
              this.i[i1].setTag(((File)localObject1).getPath());
              if (!((File)localObject1).exists()) {
                break label243;
              }
            }
          }
        }
      }
      try
      {
        this.i[i1].setImageBitmap(BitmapFactory.decodeFile(((File)localObject1).getPath(), null));
        this.g.setVisibility(0);
        this.h[i1].setVisibility(0);
        com.gtp.a.a.b.c.a("PollenIndex", "show: " + ((File)localObject1).getPath());
        for (;;)
        {
          i1 += 1;
          break;
          label243:
          localObject2 = new com.jiubang.core.c.a.a((String)localObject2, com.gtp.a.a.b.a.c, ((File)localObject1).getName());
          com.jiubang.core.c.a.g.a(getApplicationContext()).a((com.jiubang.core.c.a.a)localObject2);
          com.gtp.a.a.b.c.a("PollenIndex", "download: " + ((File)localObject1).getPath());
        }
        return;
      }
      catch (Exception localException)
      {
        for (;;) {}
      }
    }
  }
  
  private void b()
  {
    int i1 = 0;
    this.d.setText("N/A");
    this.e.setText("N/A");
    this.f.setText("N/A");
    this.f.setTextColor(e().getColor(o[0]));
    this.g.setVisibility(4);
    this.h[0].setVisibility(4);
    this.i[0].setImageBitmap(null);
    this.j[0].setText("N/A");
    this.h[1].setVisibility(4);
    this.i[1].setImageBitmap(null);
    this.j[1].setText("N/A");
    while (i1 < 4)
    {
      this.k[i1].setVisibility(4);
      this.l[i1].setVisibility(4);
      this.m[i1].setVisibility(4);
      i1 += 1;
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903264);
    getWindow().clearFlags(134217728);
    this.d = ((TextView)findViewById(2131231834));
    this.e = ((TextView)findViewById(2131231835));
    this.f = ((TextView)findViewById(2131231836));
    this.g = ((LinearLayout)findViewById(2131231837));
    this.h = new LinearLayout[] { (LinearLayout)findViewById(2131231839), (LinearLayout)findViewById(2131231842) };
    this.i = new ImageView[] { (ImageView)findViewById(2131231840), (ImageView)findViewById(2131231843) };
    this.j = new TextView[] { (TextView)findViewById(2131231841), (TextView)findViewById(2131231844) };
    this.l = new ImageView[] { (ImageView)findViewById(2131231855), (ImageView)findViewById(2131231858), (ImageView)findViewById(2131231861), (ImageView)findViewById(2131231864) };
    this.m = new TextView[] { (TextView)findViewById(2131231854), (TextView)findViewById(2131231857), (TextView)findViewById(2131231860), (TextView)findViewById(2131231863) };
    this.k = new TextView[] { (TextView)findViewById(2131231848), (TextView)findViewById(2131231849), (TextView)findViewById(2131231850), (TextView)findViewById(2131231851) };
    paramBundle = new IntentFilter();
    paramBundle.addAction("com.gau.go.launcherex.gowidget.weatherwidget.goweather.ACTION_UPDATE_DATA");
    paramBundle.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_DOWNLOAD_PHOTO");
    registerReceiver(this.r, paramBundle);
    paramBundle = getIntent();
    if (paramBundle != null) {
      this.a = paramBundle.getStringExtra("cityId");
    }
    this.c = f.a(getApplicationContext());
    a();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    unregisterReceiver(this.r);
    if (this.b != null) {
      this.b = null;
    }
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
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    setResult(-1, new Intent(this, WeatherDetailActivity.class));
    finish();
    overridePendingTransition(2130968606, 2130968585);
    return super.onTouchEvent(paramMotionEvent);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/home/current/PollenIndex.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */