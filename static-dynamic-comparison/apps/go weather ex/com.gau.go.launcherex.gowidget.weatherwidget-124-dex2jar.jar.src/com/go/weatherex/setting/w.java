package com.go.weatherex.setting;

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
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
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
import com.gau.go.launcherex.gowidget.weather.c.c;
import com.gau.go.launcherex.gowidget.weather.c.e;
import com.gau.go.launcherex.gowidget.weather.model.q;
import com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider;
import com.gau.go.launcherex.gowidget.weather.view.VerticalStretchLayout;
import com.gau.go.launcherex.gowidget.weather.view.al;
import java.io.IOException;

public class w
  extends com.go.weatherex.framework.fragment.a
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  private TextView a;
  private View b;
  private View c;
  private CheckBox d;
  private y e;
  private boolean f;
  private View g;
  private CheckBox h;
  private VerticalStretchLayout i;
  private TextView j;
  private ImageView k;
  private boolean l = false;
  private int m;
  private int n;
  private SharedPreferences o;
  private Dialog p;
  private e q;
  private com.gau.go.launcherex.gowidget.d.h r;
  private final BroadcastReceiver s = new x(this);
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i1 = 1;; i1 = 0)
    {
      this.q.u(i1);
      this.q.a(WeatherContentProvider.g, "setting_key", "dynamic_bg_switch", "setting_value", i1);
      return;
    }
  }
  
  private void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.j.setTextColor(this.m);
      this.j.setClickable(paramBoolean);
      this.j.setEnabled(paramBoolean);
      return;
    }
    this.j.setTextColor(this.n);
    this.j.setClickable(paramBoolean);
    this.j.setEnabled(paramBoolean);
  }
  
  private void c()
  {
    Intent localIntent = new Intent("android.service.wallpaper.LIVE_WALLPAPER_CHOOSER");
    try
    {
      startActivity(localIntent);
      return;
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
      Toast.makeText(getActivity(), 2131166151, 0).show();
      if (com.gau.go.launcherex.goweather.livewallpaper.b.h.a(getActivity().getApplicationContext())) {
        this.h.setChecked(true);
      }
      for (;;)
      {
        b(this.h.isChecked());
        if (!this.h.isChecked()) {
          break;
        }
        this.i.b();
        return;
        this.h.setChecked(false);
      }
      this.i.a();
    }
  }
  
  private void d()
  {
    WallpaperManager localWallpaperManager = WallpaperManager.getInstance(getActivity().getApplicationContext());
    if (localWallpaperManager != null)
    {
      WallpaperInfo localWallpaperInfo = localWallpaperManager.getWallpaperInfo();
      if ((localWallpaperInfo == null) || (!getActivity().getApplicationContext().getPackageName().equals(localWallpaperInfo.getPackageName()))) {}
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
  
  private boolean j()
  {
    return this.q.a().l == 1;
  }
  
  private void k()
  {
    if (!getActivity().isFinishing())
    {
      if (this.p == null) {
        break label35;
      }
      if (!this.p.isShowing()) {
        this.p.show();
      }
    }
    return;
    label35:
    this.p = al.a(getActivity());
    this.p.show();
  }
  
  private void l()
  {
    if ((!getActivity().isFinishing()) && (this.p != null) && (this.p.isShowing()))
    {
      this.p.dismiss();
      this.p = null;
    }
  }
  
  protected boolean a()
  {
    return super.a();
  }
  
  public void b()
  {
    a(this.a, 4, true);
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    this.m = getResources().getColor(2131361899);
    this.n = getResources().getColor(2131361901);
    this.r = new com.gau.go.launcherex.gowidget.d.h();
    this.o = GoWidgetApplication.c(getActivity().getApplicationContext()).a();
    this.e = new y(this);
    this.q = c.a(getActivity().getApplicationContext()).f();
    this.a = ((TextView)c(2131231145));
    this.a.setText(2131166106);
    this.b = c(2131231196);
    this.b.setOnClickListener(this);
    this.c = c(2131231491);
    this.c.setOnClickListener(this);
    this.d = ((CheckBox)c(2131231492));
    this.d.setOnCheckedChangeListener(this);
    this.g = c(2131231493);
    this.k = ((ImageView)this.g.findViewById(2131231494));
    this.h = ((CheckBox)this.g.findViewById(2131231495));
    this.j = ((TextView)c(2131231497));
    this.i = ((VerticalStretchLayout)c(2131231496));
    this.h.setOnCheckedChangeListener(this);
    this.j.setOnClickListener(this);
    this.g.setOnClickListener(this);
    if (this.o.getInt("key_new_feature_live_wallpaper", 1) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      this.l = bool;
      if (this.l) {
        this.k.setVisibility(0);
      }
      this.f = j();
      this.d.setChecked(this.f);
      paramBundle = new IntentFilter();
      paramBundle.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_SCREEN_BACKGROUND_LOADING_FINISH");
      getActivity().registerReceiver(this.s, paramBundle);
      b();
      return;
    }
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramCompoundButton.equals(this.d)) {
      if (this.f != paramBoolean)
      {
        this.f = paramBoolean;
        this.e.removeMessages(1);
        if (!this.f) {
          break label70;
        }
        paramCompoundButton = Message.obtain();
        paramCompoundButton.what = 1;
        paramCompoundButton.arg1 = 1;
        this.e.sendMessageDelayed(paramCompoundButton, 500L);
        k();
      }
    }
    for (;;)
    {
      return;
      label70:
      paramCompoundButton = Message.obtain();
      paramCompoundButton.what = 1;
      paramCompoundButton.arg1 = 2;
      this.e.sendMessageDelayed(paramCompoundButton, 500L);
      break;
      if (paramCompoundButton.equals(this.h))
      {
        b(paramBoolean);
        if (paramBoolean)
        {
          this.i.d();
          if (!com.gau.go.launcherex.goweather.livewallpaper.b.h.a(getActivity().getApplicationContext())) {
            c();
          }
        }
        while (this.l)
        {
          this.k.setVisibility(8);
          paramCompoundButton = this.o.edit();
          paramCompoundButton.putInt("key_new_feature_live_wallpaper", 0);
          paramCompoundButton.commit();
          return;
          this.i.c();
          d();
        }
      }
    }
  }
  
  public void onClick(View paramView)
  {
    if (this.r.a(hashCode())) {}
    do
    {
      return;
      if (paramView.equals(this.b))
      {
        h();
        return;
      }
      if (paramView.equals(this.c))
      {
        this.e.removeMessages(1);
        this.d.toggle();
        return;
      }
      if (paramView.equals(this.j))
      {
        a(an.class, null);
        return;
      }
    } while (!paramView.equals(this.g));
    this.h.toggle();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130903156, paramViewGroup, false);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    getActivity().unregisterReceiver(this.s);
  }
  
  public void onResume()
  {
    super.onResume();
    if (com.gau.go.launcherex.goweather.livewallpaper.b.h.a(getActivity().getApplicationContext())) {
      this.h.setChecked(true);
    }
    for (;;)
    {
      b(this.h.isChecked());
      if (!this.h.isChecked()) {
        break;
      }
      this.i.b();
      return;
      this.h.setChecked(false);
    }
    this.i.a();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/setting/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */