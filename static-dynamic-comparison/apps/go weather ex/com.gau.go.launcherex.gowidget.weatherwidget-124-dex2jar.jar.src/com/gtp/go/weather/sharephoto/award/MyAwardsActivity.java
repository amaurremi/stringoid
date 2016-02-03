package com.gtp.go.weather.sharephoto.award;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;
import com.gau.go.launcherex.goweather.goplay.ThemeDetailActivity;
import com.gau.go.launcherex.gowidget.language.GoWeatherEXActivity;
import com.gau.go.launcherex.gowidget.weather.globalview.g;
import com.gau.go.launcherex.gowidget.weather.model.ThemeDataBean;
import com.gau.go.launcherex.gowidget.weather.util.r;
import com.gtp.go.weather.sharephoto.b.d;
import com.gtp.go.weather.sharephoto.takephoto.ab;
import com.jiubang.ggheart.apps.desks.diy.filter.core.FilterService;
import java.io.File;

public class MyAwardsActivity
  extends GoWeatherEXActivity
  implements View.OnClickListener, AdapterView.OnItemClickListener
{
  private LayoutInflater a;
  private View b;
  private int c;
  private ListView d;
  private y e;
  private k f;
  private aa g;
  private c h;
  private g i;
  
  private Bitmap a(Bitmap paramBitmap)
  {
    return ab.a(paramBitmap);
  }
  
  private void a(long paramLong, com.gtp.go.weather.sharephoto.b.a parama)
  {
    ThemeDataBean localThemeDataBean = new ThemeDataBean();
    localThemeDataBean.a(parama.d());
    localThemeDataBean.e(parama.c());
    localThemeDataBean.a((int)paramLong);
    switch (parama.f())
    {
    }
    for (;;)
    {
      com.gau.go.launcherex.gowidget.weather.globaltheme.a.a(this, localThemeDataBean);
      return;
      localThemeDataBean.j(parama.e());
      continue;
      localThemeDataBean.k(parama.e());
      continue;
      localThemeDataBean.n(parama.e());
    }
  }
  
  private void a(long paramLong, com.gtp.go.weather.sharephoto.b.a parama, String paramString)
  {
    if (this.i == null)
    {
      this.i = new g(this);
      this.i.d(2131165382);
      this.i.b(null);
      this.i.c(null);
    }
    boolean bool = r.a(this, parama.c());
    if (bool)
    {
      this.i.c(2131166400);
      this.i.b(2131166402);
    }
    for (;;)
    {
      this.i.a(BitmapFactory.decodeFile(parama.b()));
      this.i.a(new x(this, bool, parama, paramLong));
      this.i.show();
      return;
      this.i.c(2131165547);
      this.i.b(2131166401);
    }
  }
  
  private void a(String paramString)
  {
    paramString = ThemeDetailActivity.a(this, 2, 2, paramString);
    paramString.addFlags(67108864);
    startActivity(paramString);
  }
  
  private void b(String paramString)
  {
    Toast.makeText(this, paramString, 0).show();
  }
  
  private Bitmap c(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return ab.a(this.c, this.c, new File(paramString));
    }
    return null;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.equals(this.b)) {
      finish();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903042);
    this.a = LayoutInflater.from(this);
    this.c = ((int)(e().getDisplayMetrics().density * 100.0F));
    this.b = findViewById(2131230796);
    this.b.setOnClickListener(this);
    this.d = ((ListView)findViewById(2131230798));
    this.d.setDivider(null);
    this.d.setCacheColorHint(0);
    this.e = new y(this, null);
    this.d.setAdapter(this.e);
    this.d.setOnItemClickListener(this);
    this.f = new k(getApplicationContext());
    this.g = new aa(this, null);
    this.f.a(this.g);
    this.f.a(false);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    FilterService.destroy();
  }
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (r.c(this))
    {
      paramView = this.e.a(paramInt);
      if (paramView != null)
      {
        if (paramView.j() != 0) {
          break label63;
        }
        if (this.h == null)
        {
          this.h = new c(this);
          this.h.setCanceledOnTouchOutside(false);
        }
        this.h.a(paramView);
      }
      label63:
      do
      {
        return;
        paramAdapterView = null;
        com.gtp.go.weather.sharephoto.b.b localb = paramView.i();
        if (localb != null) {
          paramAdapterView = localb.d();
        }
      } while (paramAdapterView == null);
      a(paramView.h(), paramAdapterView, paramAdapterView.c());
      return;
    }
    b(getString(2131165704));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/award/MyAwardsActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */