package com.gau.go.launcherex.gowidget.framework;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.text.format.Time;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.gau.go.launcherex.gowidget.language.GoWeatherEXActivity;
import com.gau.go.launcherex.gowidget.statistics.y;
import com.gau.go.launcherex.gowidget.weather.service.NotifyService;
import com.gau.go.launcherex.gowidget.weather.view.WeatherDetailActivity;
import com.go.weatherex.framework.a.a;
import com.go.weatherex.home.a.e;
import com.jiubang.ggheart.uninstallcheck.UninstallService;
import java.io.File;

public class GoWidgetActivity
  extends GoWeatherEXActivity
{
  private long a;
  private String b = "";
  private int c = 0;
  private String d;
  private boolean e = true;
  private int f = -1;
  private Bitmap g = null;
  private Bitmap h = null;
  private boolean i = true;
  private ImageView j;
  private int[] k = { 2130838236, 2130838237, 2130838238, 2130838239, 2130838240, 2130838241, 2130838242, 2130838243 };
  private int[] l = { 2130838228, 2130838229, 2130838230, 2130838231, 2130838232, 2130838233, 2130838234, 2130838235 };
  private int[] m = { 2130837841, 2130837843, 2130837845, 2130837847, 2130837849, 2130837851, 2130837853 };
  private int[] n = { 2130837842, 2130837844, 2130837846, 2130837848, 2130837850, 2130837852, 2130837854 };
  private Drawable[] o = new Drawable[8];
  private int p = 0;
  private d q = new d(this);
  private BroadcastReceiver r = new c(this);
  
  private void a(boolean paramBoolean)
  {
    com.gau.go.launcherex.gowidget.language.b localb = e();
    int i2 = this.o.length;
    if (this.i) {}
    for (int[] arrayOfInt = this.k;; arrayOfInt = this.l)
    {
      int i1 = 0;
      while (i1 < i2)
      {
        this.o[i1] = localb.getDrawable(arrayOfInt[i1]);
        i1 += 1;
      }
    }
  }
  
  private void f()
  {
    Time localTime = new Time();
    localTime.setToNow();
    if ((localTime.hour >= 6) && (localTime.hour < 18))
    {
      this.i = true;
      return;
    }
    this.i = false;
  }
  
  private void g()
  {
    Intent localIntent = new Intent(getApplicationContext(), NotifyService.class);
    Bundle localBundle = new Bundle();
    localBundle.putInt("notify_request", 9);
    localIntent.putExtras(localBundle);
    getApplicationContext().startService(localIntent);
  }
  
  public void a()
  {
    this.p = ((this.p + 1) % this.o.length);
    this.j.setImageDrawable(this.o[this.p]);
  }
  
  public void b()
  {
    a(WeatherDetailActivity.a(this, this.b, this.e, this.c, this.d, this.f), 0, 0);
    b(2130968587, 2130968589);
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(0, 0);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903128);
    getWindow().setFormat(-3);
    getWindow().clearFlags(134217728);
    f();
    if (y.a()) {
      paramBundle = new File(Environment.getExternalStorageDirectory(), "/GOWeatherEX/download" + File.separator + "hiWeather.ex");
    }
    for (;;)
    {
      if ((paramBundle != null) && (paramBundle.exists())) {}
      try
      {
        this.g = BitmapFactory.decodeFile(paramBundle.getAbsolutePath());
        paramBundle = (ImageView)findViewById(2131231302);
        if (this.g != null)
        {
          paramBundle.setImageBitmap(this.g);
          paramBundle = com.go.weatherex.framework.a.b.a();
          paramBundle.a(findViewById(2131231301), 2, true);
          paramBundle.a((TextView)findViewById(2131230934), 4, true);
          this.j = ((ImageView)findViewById(2131231304));
          if (this.g != null) {
            break label635;
          }
          a(this.i);
          this.j.setImageDrawable(this.o[0]);
          this.q.sendEmptyMessageDelayed(2, 80L);
          paramBundle = getIntent();
          if ((paramBundle != null) && (paramBundle.getExtras() != null))
          {
            this.e = paramBundle.getBooleanExtra("EXTRA_BG_LOADING_IMMEDIATELY_", true);
            this.f = paramBundle.getIntExtra("detail_goto", -1);
            this.b = paramBundle.getStringExtra("cityId");
            this.c = paramBundle.getIntExtra("detailSrc", 0);
            this.d = paramBundle.getStringExtra("extra_src_app_package_name");
            if (TextUtils.isEmpty(this.d)) {
              this.d = "--";
            }
            if (this.c == 3) {
              sendBroadcast(new Intent("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_HIDE_THEME_ICON"));
            }
          }
          paramBundle = new IntentFilter();
          paramBundle.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_DATA_READY");
          registerReceiver(this.r, paramBundle);
          g();
          this.a = System.currentTimeMillis();
          UninstallService.a(this);
          return;
          paramBundle = getFileStreamPath("hiWeather.ex");
        }
      }
      catch (OutOfMemoryError paramBundle)
      {
        for (;;)
        {
          if (com.gtp.a.a.b.c.a()) {
            paramBundle.printStackTrace();
          }
          if ((this.g != null) && (!this.g.isRecycled()))
          {
            this.g.recycle();
            this.g = null;
            continue;
            int i1 = (int)(Math.random() * 10.0D) % this.m.length;
            if (this.i) {
              i1 = this.m[i1];
            }
            for (;;)
            {
              try
              {
                Object localObject = new BitmapFactory.Options();
                ((BitmapFactory.Options)localObject).inSampleSize = 2;
                ((BitmapFactory.Options)localObject).inPreferredConfig = Bitmap.Config.ALPHA_8;
                this.h = BitmapFactory.decodeResource(e(), i1, (BitmapFactory.Options)localObject);
                if (Build.VERSION.SDK_INT < 11) {
                  continue;
                }
                localObject = e.a(getApplicationContext(), this.h, 15);
                if (localObject == null) {
                  continue;
                }
                this.h.recycle();
                this.h = ((Bitmap)localObject);
              }
              catch (OutOfMemoryError localOutOfMemoryError)
              {
                if (!com.gtp.a.a.b.c.a()) {
                  continue;
                }
                localOutOfMemoryError.printStackTrace();
                if ((this.h == null) || (this.h.isRecycled())) {
                  continue;
                }
                this.h.recycle();
                this.h = null;
                continue;
                findViewById(2131231303).setBackgroundColor(Color.argb(90, 0, 0, 0));
                continue;
              }
              if (this.h == null) {
                break;
              }
              paramBundle.setImageBitmap(this.h);
              break;
              i1 = this.n[i1];
              continue;
              findViewById(2131231303).setBackgroundColor(Color.argb(90, 0, 0, 0));
            }
            label635:
            this.j.setVisibility(8);
          }
        }
      }
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if ((this.g != null) && (!this.g.isRecycled()))
    {
      this.g.recycle();
      this.g = null;
    }
    if ((this.h != null) && (!this.h.isRecycled()))
    {
      this.h.recycle();
      this.h = null;
    }
    unregisterReceiver(this.r);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    switch (paramInt)
    {
    default: 
      return super.onKeyDown(paramInt, paramKeyEvent);
    }
    return true;
  }
  
  protected void onStop()
  {
    super.onStop();
    UninstallService.b(this);
  }
  
  public void startActivity(Intent paramIntent)
  {
    super.startActivity(paramIntent);
    overridePendingTransition(0, 0);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/framework/GoWidgetActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */