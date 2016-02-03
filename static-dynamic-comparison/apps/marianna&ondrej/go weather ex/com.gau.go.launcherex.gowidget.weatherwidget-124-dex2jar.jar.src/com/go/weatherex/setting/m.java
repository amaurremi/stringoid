package com.go.weatherex.setting;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.gau.go.launcherex.gowidget.billing.BillingActivity;
import com.gau.go.launcherex.gowidget.framework.GoWidgetApplication;
import com.gau.go.launcherex.gowidget.language.d;
import com.gau.go.launcherex.gowidget.statistics.y;
import com.gau.go.launcherex.gowidget.weather.d.f;
import java.util.ArrayList;
import java.util.Iterator;

public class m
  extends com.go.weatherex.framework.fragment.a
  implements View.OnClickListener
{
  private TextView a;
  private View b;
  private TextView c;
  private TextView d;
  private TextView e;
  private TextView f;
  private TextView g;
  private TextView h;
  private TextView i;
  private TextView j;
  private TextView k;
  private TextView l;
  private View m;
  private View n;
  private TextView o;
  private View p;
  private View q;
  private SharedPreferences r;
  private p s;
  private ArrayList t;
  private boolean u = false;
  private BroadcastReceiver v;
  private com.gau.go.launcherex.gowidget.d.h w;
  private View x;
  
  private void a(int paramInt)
  {
    Intent localIntent = new Intent(getActivity(), BillingActivity.class);
    localIntent.putExtra("recommend_type", paramInt);
    localIntent.putExtra("recommend_enterance", 7);
    startActivity(localIntent);
  }
  
  private void c()
  {
    if (y.p(getActivity()))
    {
      this.c.setVisibility(8);
      return;
    }
    if (GoWidgetApplication.b(getActivity().getApplicationContext()).b())
    {
      this.c.setVisibility(0);
      this.c.setText(getText(2131166007));
      return;
    }
    this.c.setVisibility(8);
  }
  
  private void d()
  {
    this.u = false;
    if (this.t == null) {
      this.t = d.a(getActivity()).g();
    }
    Iterator localIterator = this.t.iterator();
    while (localIterator.hasNext()) {
      if (((com.gau.go.launcherex.gowidget.weather.model.h)localIterator.next()).b) {
        this.u = true;
      }
    }
  }
  
  private void j()
  {
    if ((com.gau.go.launcherex.gowidget.c.a.d) || (this.u))
    {
      this.n.setVisibility(0);
      return;
    }
    this.n.setVisibility(8);
  }
  
  private void k()
  {
    if (com.gau.go.launcherex.gowidget.c.a.f)
    {
      this.q.setVisibility(0);
      return;
    }
    this.q.setVisibility(8);
  }
  
  private void l()
  {
    boolean bool = false;
    if (!com.gau.go.launcherex.gowidget.c.a.a)
    {
      com.gau.go.launcherex.gowidget.c.a.b = this.r.getBoolean("setting_forecast", false);
      com.gau.go.launcherex.gowidget.c.a.c = this.r.getBoolean("setting_notification_sound", false);
      com.gau.go.launcherex.gowidget.c.a.e = this.r.getBoolean("key_new_feature_temp_change", false);
      com.gau.go.launcherex.gowidget.c.a.d = this.r.getBoolean("setting_language", false);
      if ((this.r.getBoolean("key_about_go_weather_ex_new", true)) || (this.r.getBoolean("key_has_new_version", false))) {
        bool = true;
      }
      com.gau.go.launcherex.gowidget.c.a.f = bool;
      com.gau.go.launcherex.gowidget.c.a.a = true;
    }
  }
  
  private void m()
  {
    if (this.r.getBoolean("key_is_new_user", true)) {
      return;
    }
    this.x.setVisibility(0);
  }
  
  protected boolean a()
  {
    return super.a();
  }
  
  public void b()
  {
    a(this.a, 4, true);
  }
  
  protected void f()
  {
    super.f();
    this.a.setText(2131166106);
    c();
    this.e.setText(2131166152);
    this.f.setText(2131166260);
    this.g.setText(2131166261);
    this.i.setText(2131166263);
    this.j.setText(2131166145);
    this.l.setText(2131166209);
    this.o.setText(2131166146);
    this.d.setText(2131166259);
    this.h.setText(2131166262);
    this.k.setText(2131166264);
    if (this.x.getVisibility() == 0)
    {
      ((TextView)this.x.findViewById(2131231394)).setText(2131166262);
      ((TextView)this.x.findViewById(2131231395)).setText(2131166450);
    }
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    this.w = new com.gau.go.launcherex.gowidget.d.h();
    this.r = GoWidgetApplication.c(getActivity().getApplicationContext()).a();
    this.a = ((TextView)c(2131231145));
    this.a.setText(2131166106);
    this.b = c(2131231196);
    this.b.setOnClickListener(this);
    this.d = ((TextView)c(2131231378));
    this.h = ((TextView)c(2131231382));
    this.k = ((TextView)c(2131231385));
    this.c = ((TextView)c(2131231389));
    this.c.setOnClickListener(this);
    this.e = ((TextView)c(2131231379));
    this.e.setOnClickListener(this);
    this.f = ((TextView)c(2131231380));
    this.f.setOnClickListener(this);
    this.g = ((TextView)c(2131231381));
    this.g.setOnClickListener(this);
    this.i = ((TextView)c(2131231383));
    this.i.setOnClickListener(this);
    this.j = ((TextView)c(2131231384));
    this.j.setOnClickListener(this);
    this.l = ((TextView)c(2131231387));
    this.n = c(2131231388);
    this.m = c(2131231386);
    this.m.setOnClickListener(this);
    this.o = ((TextView)c(2131231391));
    this.q = c(2131231392);
    this.p = c(2131231390);
    this.p.setOnClickListener(this);
    this.x = c(2131231393);
    l();
    d();
    c();
    this.s = new p(this, null);
    paramBundle = new IntentFilter("com.gau.go.launcherex.gowidget.weatherwidget.PURCHASE_CHANGE");
    getActivity().registerReceiver(this.s, paramBundle);
    this.v = new o(this, null);
    paramBundle = new IntentFilter();
    paramBundle.addAction("android.intent.action.PACKAGE_ADDED");
    paramBundle.addAction("android.intent.action.PACKAGE_REMOVED");
    paramBundle.addAction("android.intent.action.PACKAGE_REPLACED");
    paramBundle.addDataScheme("package");
    getActivity().registerReceiver(this.v, paramBundle);
    b();
    m();
  }
  
  public void onClick(View paramView)
  {
    if (this.w.a(hashCode())) {}
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
        a(-1);
        return;
      }
      if (paramView.equals(this.e))
      {
        a(z.class, null);
        return;
      }
      if (paramView.equals(this.f))
      {
        a(bb.class, null);
        return;
      }
      if (paramView.equals(this.g))
      {
        a(ay.class, null);
        return;
      }
      if (paramView.equals(this.i))
      {
        a(w.class, null);
        return;
      }
      if (paramView.equals(this.j))
      {
        a(bm.class, null);
        return;
      }
      if (paramView.equals(this.m))
      {
        if (com.gau.go.launcherex.gowidget.c.a.d)
        {
          com.gau.go.launcherex.gowidget.c.a.d = false;
          paramView = this.r.edit();
          paramView.putBoolean("setting_language", false);
          paramView.commit();
          j();
        }
        a(ag.class, null);
        return;
      }
    } while (!paramView.equals(this.p));
    if (com.gau.go.launcherex.gowidget.c.a.f)
    {
      com.gau.go.launcherex.gowidget.c.a.f = false;
      paramView = this.r.edit();
      paramView.putBoolean("key_about_go_weather_ex_new", false);
      paramView.commit();
      k();
    }
    a(q.class, null);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130903149, paramViewGroup, false);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    getActivity().unregisterReceiver(this.s);
    getActivity().unregisterReceiver(this.v);
  }
  
  public void onResume()
  {
    super.onResume();
    j();
    k();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/setting/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */