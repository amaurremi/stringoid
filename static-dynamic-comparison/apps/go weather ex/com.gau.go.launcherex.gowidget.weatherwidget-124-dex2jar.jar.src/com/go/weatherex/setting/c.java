package com.go.weatherex.setting;

import android.app.Activity;
import android.app.Dialog;
import android.app.WallpaperInfo;
import android.app.WallpaperManager;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.gau.go.launcherex.gowidget.framework.GoWidgetApplication;
import com.gau.go.launcherex.gowidget.weather.model.q;
import com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider;
import com.gau.go.launcherex.gowidget.weather.view.VerticalStretchLayout;
import com.gau.go.launcherex.gowidget.weather.view.al;
import com.go.weatherex.framework.fragment.f;
import com.jiubang.core.b.a;
import java.io.IOException;

public class c
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  private View a;
  private CheckBox b;
  private e c;
  private boolean d;
  private View e;
  private CheckBox f;
  private VerticalStretchLayout g;
  private TextView h;
  private ImageView i;
  private boolean j = false;
  private int k;
  private int l;
  private SharedPreferences m;
  private Dialog n;
  private com.gau.go.launcherex.gowidget.weather.c.e o;
  private com.gau.go.launcherex.gowidget.d.h p;
  private g q;
  private ViewGroup r;
  private final BroadcastReceiver s = new d(this);
  
  public c(g paramg)
  {
    this.q = paramg;
  }
  
  private View a(int paramInt)
  {
    return this.r.findViewById(paramInt);
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i1 = 1;; i1 = 0)
    {
      this.o.u(i1);
      this.o.a(WeatherContentProvider.g, "setting_key", "dynamic_bg_switch", "setting_value", i1);
      return;
    }
  }
  
  private void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.h.setTextColor(this.k);
      this.h.setClickable(paramBoolean);
      this.h.setEnabled(paramBoolean);
      return;
    }
    this.h.setTextColor(this.l);
    this.h.setClickable(paramBoolean);
    this.h.setEnabled(paramBoolean);
  }
  
  private Activity d()
  {
    return this.q.getActivity();
  }
  
  private Resources e()
  {
    return this.q.getResources();
  }
  
  private void f()
  {
    Intent localIntent = new Intent("android.service.wallpaper.LIVE_WALLPAPER_CHOOSER");
    try
    {
      this.q.startActivity(localIntent);
      return;
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
      Toast.makeText(d(), 2131166151, 0).show();
      if (com.gau.go.launcherex.goweather.livewallpaper.b.h.a(d().getApplicationContext())) {
        this.f.setChecked(true);
      }
      for (;;)
      {
        b(this.f.isChecked());
        if (!this.f.isChecked()) {
          break;
        }
        this.g.b();
        return;
        this.f.setChecked(false);
      }
      this.g.a();
    }
  }
  
  private void g()
  {
    WallpaperManager localWallpaperManager = WallpaperManager.getInstance(d().getApplicationContext());
    if (localWallpaperManager != null)
    {
      WallpaperInfo localWallpaperInfo = localWallpaperManager.getWallpaperInfo();
      if ((localWallpaperInfo == null) || (!d().getApplicationContext().getPackageName().equals(localWallpaperInfo.getPackageName()))) {}
    }
    try
    {
      localWallpaperManager.clear();
      return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
  }
  
  private boolean h()
  {
    return this.o.a().l == 1;
  }
  
  private void i()
  {
    if (!d().isFinishing())
    {
      if (this.n == null) {
        break label35;
      }
      if (!this.n.isShowing()) {
        this.n.show();
      }
    }
    return;
    label35:
    this.n = al.a(d());
    this.n.show();
  }
  
  private void j()
  {
    if ((!d().isFinishing()) && (this.n != null) && (this.n.isShowing()))
    {
      this.n.dismiss();
      this.n = null;
    }
  }
  
  public void a()
  {
    if (com.gau.go.launcherex.goweather.livewallpaper.b.h.a(d().getApplicationContext())) {
      this.f.setChecked(true);
    }
    for (;;)
    {
      b(this.f.isChecked());
      if (!this.f.isChecked()) {
        break;
      }
      this.g.b();
      return;
      this.f.setChecked(false);
    }
    this.g.a();
  }
  
  public void a(Bundle paramBundle)
  {
    this.k = e().getColor(2131361899);
    this.l = e().getColor(2131361901);
    this.p = new com.gau.go.launcherex.gowidget.d.h();
    this.m = GoWidgetApplication.c(d().getApplicationContext()).a();
    this.c = new e(this);
    this.o = com.gau.go.launcherex.gowidget.weather.c.c.a(d().getApplicationContext()).f();
    this.a = a(2131231491);
    this.a.setOnClickListener(this);
    this.b = ((CheckBox)a(2131231492));
    this.b.setOnCheckedChangeListener(this);
    this.e = a(2131231493);
    this.i = ((ImageView)this.e.findViewById(2131231494));
    this.f = ((CheckBox)this.e.findViewById(2131231495));
    this.h = ((TextView)a(2131231497));
    this.g = ((VerticalStretchLayout)a(2131231496));
    this.f.setOnCheckedChangeListener(this);
    this.h.setOnClickListener(this);
    this.e.setOnClickListener(this);
    if (this.m.getInt("key_new_feature_live_wallpaper", 1) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      this.j = bool;
      if (this.j) {
        this.i.setVisibility(0);
      }
      this.d = h();
      this.b.setChecked(this.d);
      paramBundle = new IntentFilter();
      paramBundle.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_SCREEN_BACKGROUND_LOADING_FINISH");
      d().registerReceiver(this.s, paramBundle);
      return;
    }
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    this.q.i().a(2130903255, paramViewGroup, true);
    this.r = paramViewGroup;
  }
  
  public void b()
  {
    d().unregisterReceiver(this.s);
  }
  
  public void c() {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramCompoundButton.equals(this.b)) {
      if (this.d != paramBoolean)
      {
        this.d = paramBoolean;
        this.c.removeMessages(1);
        if (!this.d) {
          break label70;
        }
        paramCompoundButton = Message.obtain();
        paramCompoundButton.what = 1;
        paramCompoundButton.arg1 = 1;
        this.c.sendMessageDelayed(paramCompoundButton, 500L);
        i();
      }
    }
    for (;;)
    {
      return;
      label70:
      paramCompoundButton = Message.obtain();
      paramCompoundButton.what = 1;
      paramCompoundButton.arg1 = 2;
      this.c.sendMessageDelayed(paramCompoundButton, 500L);
      break;
      if (paramCompoundButton.equals(this.f))
      {
        b(paramBoolean);
        if (paramBoolean)
        {
          this.g.d();
          if (!com.gau.go.launcherex.goweather.livewallpaper.b.h.a(d().getApplicationContext())) {
            f();
          }
        }
        while (this.j)
        {
          this.i.setVisibility(8);
          paramCompoundButton = this.m.edit();
          paramCompoundButton.putInt("key_new_feature_live_wallpaper", 0);
          paramCompoundButton.commit();
          return;
          this.g.c();
          g();
        }
      }
    }
  }
  
  public void onClick(View paramView)
  {
    if (this.p.a(hashCode())) {}
    do
    {
      return;
      if (paramView.equals(this.a))
      {
        this.c.removeMessages(1);
        this.b.toggle();
        return;
      }
      if (paramView.equals(this.h))
      {
        this.q.a(an.class, null);
        return;
      }
    } while (!paramView.equals(this.e));
    this.f.toggle();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/setting/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */