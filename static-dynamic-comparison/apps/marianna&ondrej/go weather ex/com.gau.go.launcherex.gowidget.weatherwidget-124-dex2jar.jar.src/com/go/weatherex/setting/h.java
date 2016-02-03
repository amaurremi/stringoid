package com.go.weatherex.setting;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import android.widget.Toast;
import com.gau.go.launcherex.gowidget.billing.BillingActivity;
import com.gau.go.launcherex.gowidget.framework.GoWidgetApplication;
import com.gau.go.launcherex.gowidget.weather.c.e;
import com.gau.go.launcherex.gowidget.weather.globalview.t;
import com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider;
import com.gau.go.launcherex.gowidget.weather.view.AppListActivity;
import java.util.ArrayList;

public class h
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  private String A;
  private String B;
  private String C = "";
  private String D = "";
  private boolean E = false;
  private boolean F = false;
  private l G;
  private com.gau.go.launcherex.gowidget.weather.d.f H;
  private t I;
  private com.gau.go.launcherex.gowidget.d.h J;
  private g K;
  private ViewGroup L;
  public int a;
  public int b;
  public int c;
  public int d = 0;
  private View e;
  private CheckBox f;
  private View g;
  private TextView h;
  private int i;
  private String[] j;
  private int[] k;
  private View l;
  private TextView m;
  private View n;
  private TextView o;
  private View p;
  private CheckBox q;
  private View r;
  private CheckBox s;
  private View t;
  private View u;
  private CheckBox v;
  private e w;
  private j x;
  private k y;
  private PackageManager z;
  
  public h(g paramg)
  {
    this.K = paramg;
  }
  
  private View a(int paramInt)
  {
    return this.L.findViewById(paramInt);
  }
  
  private void a(int paramInt1, int paramInt2, CharSequence[] paramArrayOfCharSequence)
  {
    int i2 = 0;
    ArrayList localArrayList = new ArrayList();
    int i3 = paramArrayOfCharSequence.length;
    int i1 = 0;
    if (i1 < i3)
    {
      com.gau.go.launcherex.gowidget.weather.globalview.a locala = new com.gau.go.launcherex.gowidget.weather.globalview.a();
      locala.a = paramArrayOfCharSequence[i1].toString();
      locala.c = Integer.valueOf(i1);
      if (paramInt2 == i1) {}
      for (boolean bool = true;; bool = false)
      {
        locala.b = bool;
        localArrayList.add(locala);
        i1 += 1;
        break;
      }
    }
    paramArrayOfCharSequence = g();
    paramArrayOfCharSequence.b(paramInt1);
    paramArrayOfCharSequence.a(localArrayList);
    paramInt1 = i2;
    if (i3 > 4) {
      paramInt1 = 4;
    }
    paramArrayOfCharSequence.c(paramInt1);
    paramArrayOfCharSequence.a(new i(this, paramInt2));
    paramArrayOfCharSequence.a();
  }
  
  private void a(Context paramContext)
  {
    Cursor localCursor = paramContext.getContentResolver().query(WeatherContentProvider.g, new String[] { "setting_value" }, "setting_key=?", new String[] { "app_widget_theme" }, null);
    if (localCursor != null) {
      if ((localCursor.getCount() > 0) && (localCursor.moveToNext())) {
        this.A = localCursor.getString(0);
      }
    }
    try
    {
      localCursor.close();
      if (!TextUtils.isEmpty(this.A)) {
        this.B = com.gau.go.launcherex.gowidget.weather.globaltheme.a.c(paramContext, this.A);
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  private void a(Cursor paramCursor)
  {
    int i2;
    boolean bool;
    Object localObject2;
    do
    {
      for (;;)
      {
        try
        {
          if (paramCursor.getCount() > 0)
          {
            paramCursor.moveToFirst();
            int i1 = paramCursor.getColumnIndex("setting_key");
            i2 = paramCursor.getColumnIndex("setting_value");
            str = paramCursor.getString(i1);
            if (!str.equals("widgt_calendar")) {
              continue;
            }
            str = paramCursor.getString(i2);
            if (!TextUtils.isEmpty(str)) {
              this.D = str;
            }
            bool = paramCursor.moveToNext();
            if (bool) {
              continue;
            }
          }
        }
        catch (Exception localException)
        {
          String str;
          localException.printStackTrace();
          continue;
        }
        finally
        {
          paramCursor.close();
        }
        paramCursor.close();
        return;
        if (!str.equals("widgt_clock")) {
          break;
        }
        str = paramCursor.getString(i2);
        if (!TextUtils.isEmpty(str)) {
          this.C = str;
        }
      }
      if (!((String)localObject1).equals("dynamic_icon_gowidget")) {
        break;
      }
      localObject2 = paramCursor.getString(i2);
      bool = TextUtils.isEmpty((CharSequence)localObject2);
    } while (bool);
    for (;;)
    {
      try
      {
        this.d = Integer.parseInt((String)localObject2);
        if (this.H.b())
        {
          localObject2 = this.v;
          if (this.d != 1) {
            break label313;
          }
          bool = true;
          ((CheckBox)localObject2).setChecked(bool);
          this.u.setVisibility(8);
          this.v.setVisibility(0);
          this.v.setEnabled(true);
          break;
        }
        this.u.setVisibility(0);
        this.v.setVisibility(8);
        this.v.setEnabled(false);
      }
      catch (NumberFormatException localNumberFormatException) {}
      if (!((String)localObject2).equals("widget_theme_switcher")) {
        break;
      }
      this.c = paramCursor.getInt(i2);
      break;
      break;
      label313:
      bool = false;
    }
  }
  
  private void a(String paramString)
  {
    if (this.m != null) {
      this.m.setText(paramString);
    }
  }
  
  private String b(int paramInt)
  {
    return this.K.getString(paramInt);
  }
  
  private void b(String paramString)
  {
    this.C = paramString;
  }
  
  private void c(int paramInt)
  {
    Intent localIntent = new Intent(d(), BillingActivity.class);
    localIntent.putExtra("recommend_type", paramInt);
    localIntent.putExtra("recommend_enterance", -1);
    this.K.startActivity(localIntent);
  }
  
  private void c(String paramString)
  {
    this.D = paramString;
  }
  
  private Activity d()
  {
    return this.K.getActivity();
  }
  
  private void d(String paramString)
  {
    if (this.o != null) {
      this.o.setText(paramString);
    }
  }
  
  private Resources e()
  {
    return this.K.getResources();
  }
  
  private void f()
  {
    if (!TextUtils.isEmpty(this.A))
    {
      if (this.A.equals("app_widget_theme_white"))
      {
        this.E = true;
        this.F = true;
      }
    }
    else {
      return;
    }
    com.gau.go.launcherex.gowidget.weather.f.f localf = com.gau.go.launcherex.gowidget.weather.f.f.a(d().getApplicationContext());
    localf.a(d().getApplicationContext(), this.A);
    int i2 = localf.b("goweatherex_widget_l_lunar_fore", this.A);
    int i1 = i2;
    if (i2 == 0) {
      i1 = localf.b("goweatherex_widget_l_lunar", this.A);
    }
    if (i1 != 0) {}
    for (this.E = true;; this.E = false)
    {
      i2 = localf.b("goweatherex_widget_l_festival_fore", this.A);
      i1 = i2;
      if (i2 == 0) {
        i1 = localf.b("goweatherex_widget_l_festival", this.A);
      }
      if (i1 == 0) {
        break;
      }
      this.F = true;
      return;
    }
    this.F = false;
  }
  
  private t g()
  {
    if (this.I == null) {
      this.I = new t(d());
    }
    return this.I;
  }
  
  private void h()
  {
    this.x.a(1, null, WeatherContentProvider.g, new String[] { "setting_key", "setting_value" }, "setting_key in ('widgt_calendar', 'dynamic_icon_gowidget', '', 'widget_theme_switcher', 'widgt_clock')", null, null);
  }
  
  public void a() {}
  
  public void a(Bundle paramBundle)
  {
    this.J = new com.gau.go.launcherex.gowidget.d.h();
    this.z = d().getPackageManager();
    this.H = GoWidgetApplication.b(d().getApplicationContext());
    this.l = a(2131231500);
    this.l.setOnClickListener(this);
    this.m = ((TextView)a(2131231501));
    this.n = a(2131231502);
    this.n.setOnClickListener(this);
    this.o = ((TextView)a(2131231503));
    this.x = new j(this, d().getContentResolver());
    h();
    this.w = com.gau.go.launcherex.gowidget.weather.c.c.a(d().getApplicationContext()).f();
    this.g = a(2131231076);
    this.g.setOnClickListener(this);
    this.h = ((TextView)a(2131231077));
    this.j = com.gau.go.launcherex.gowidget.weather.util.c.b(d());
    this.k = e().getIntArray(2131558440);
    this.e = a(2131231074);
    this.e.setOnClickListener(this);
    this.f = ((CheckBox)a(2131231504));
    this.f.setOnCheckedChangeListener(this);
    this.p = a(2131231505);
    this.p.setOnClickListener(this);
    this.q = ((CheckBox)a(2131231506));
    this.q.setOnCheckedChangeListener(this);
    this.r = a(2131231498);
    this.r.setOnClickListener(this);
    this.s = ((CheckBox)a(2131231499));
    this.s.setOnCheckedChangeListener(this);
    this.t = a(2131231507);
    this.t.setOnClickListener(this);
    this.v = ((CheckBox)a(2131231509));
    this.v.setOnCheckedChangeListener(this);
    this.u = a(2131231508);
    if (this.H.b())
    {
      this.u.setVisibility(8);
      this.v.setVisibility(0);
      this.v.setEnabled(true);
    }
    for (;;)
    {
      a(d());
      f();
      if (!this.E) {
        this.f.setEnabled(false);
      }
      this.y = new k(this, null);
      paramBundle = new IntentFilter("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_DATA_READY");
      d().registerReceiver(this.y, paramBundle);
      this.G = new l(this, null);
      paramBundle = new IntentFilter();
      paramBundle.addAction("com.gau.go.launcherex.gowidget.weatherwidget.PURCHASE_CHANGE");
      paramBundle.addAction("com.gau.go.launcherex.gowidget.weatherwidget.action_calendar_binding_app");
      paramBundle.addAction("com.gau.go.launcherex.gowidget.weatherwidget.action_clock_binding_app");
      d().registerReceiver(this.G, paramBundle);
      return;
      this.u.setVisibility(0);
      this.v.setVisibility(8);
      this.v.setEnabled(false);
    }
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    this.K.i().a(2130903254, paramViewGroup, true);
    this.L = paramViewGroup;
  }
  
  public void b()
  {
    d().unregisterReceiver(this.y);
    d().unregisterReceiver(this.G);
  }
  
  public void c() {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    int i2 = 1;
    int i3 = 1;
    int i4 = 1;
    int i1 = 1;
    if (paramCompoundButton.equals(this.f)) {
      if (this.E) {
        if (paramBoolean) {
          if (this.a != i1)
          {
            this.a = i1;
            this.w.a(WeatherContentProvider.g, "setting_key", "calendarType", "setting_value", this.a);
            this.w.k(this.a);
          }
        }
      }
    }
    for (;;)
    {
      return;
      i1 = 0;
      break;
      Toast.makeText(d().getApplicationContext(), "(" + this.B + ") " + b(2131166186), 0).show();
      return;
      if (paramCompoundButton.equals(this.q))
      {
        if (paramBoolean) {}
        for (i1 = i2; this.b != i1; i1 = 0)
        {
          this.b = i1;
          this.w.a(WeatherContentProvider.g, "setting_key", "isCycle", "setting_value", this.b);
          return;
        }
      }
      else if (paramCompoundButton.equals(this.s))
      {
        if (paramBoolean) {}
        for (i1 = i3; this.c != i1; i1 = 0)
        {
          this.c = i1;
          this.w.a(WeatherContentProvider.g, "setting_key", "widget_theme_switcher", "setting_value", this.c);
          return;
        }
      }
      else if (paramCompoundButton.equals(this.v))
      {
        if (paramBoolean) {}
        for (i1 = i4; this.d != i1; i1 = 0)
        {
          this.d = i1;
          this.w.a(WeatherContentProvider.g, "setting_key", "dynamic_icon_gowidget", "setting_value", this.d);
          return;
        }
      }
    }
  }
  
  public void onClick(View paramView)
  {
    int i1 = 0;
    if (paramView.equals(this.e)) {
      if (this.E) {
        this.f.toggle();
      }
    }
    label198:
    do
    {
      for (;;)
      {
        return;
        Toast.makeText(d().getApplicationContext(), "(" + this.B + ") " + b(2131166186), 0).show();
        return;
        if (!paramView.equals(this.g)) {
          break label198;
        }
        if (!this.F) {
          break;
        }
        int i2 = this.k.length;
        while (i1 < i2)
        {
          if (this.i == this.k[i1])
          {
            a(2131166166, i1, this.j);
            return;
          }
          i1 += 1;
        }
      }
      Toast.makeText(d().getApplicationContext(), "(" + this.B + ") " + b(2131166187), 0).show();
      return;
      if ((paramView.equals(this.l)) && (!this.J.a(this.l.getId())))
      {
        paramView = new Intent("android.intent.action.VIEW");
        paramView.setClass(d(), AppListActivity.class);
        paramView.putExtra("calendar_clock_binding_app", 2);
        paramView.putExtra("app_widget", this.C);
        this.K.startActivityForResult(paramView, 101);
        d().overridePendingTransition(2130968584, 2130968606);
        return;
      }
      if ((paramView.equals(this.n)) && (!this.J.a(this.n.getId())))
      {
        paramView = new Intent("android.intent.action.VIEW");
        paramView.setClass(d(), AppListActivity.class);
        paramView.putExtra("calendar_clock_binding_app", 1);
        paramView.putExtra("app_widget", this.D);
        this.K.startActivityForResult(paramView, 102);
        d().overridePendingTransition(2130968584, 2130968606);
        return;
      }
      if (paramView.equals(this.p))
      {
        this.q.toggle();
        return;
      }
      if (paramView.equals(this.r))
      {
        this.s.toggle();
        return;
      }
    } while (!paramView.equals(this.t));
    if (!this.H.b())
    {
      c(1);
      return;
    }
    this.v.toggle();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/setting/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */