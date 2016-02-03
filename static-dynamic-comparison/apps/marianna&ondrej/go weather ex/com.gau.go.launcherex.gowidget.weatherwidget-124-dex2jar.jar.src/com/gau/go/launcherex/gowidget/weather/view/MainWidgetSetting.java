package com.gau.go.launcherex.gowidget.weather.view;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import android.widget.Toast;
import com.gau.go.launcherex.gowidget.billing.BillingActivity;
import com.gau.go.launcherex.gowidget.d.h;
import com.gau.go.launcherex.gowidget.framework.GoWidgetApplication;
import com.gau.go.launcherex.gowidget.language.GoWeatherEXActivity;
import com.gau.go.launcherex.gowidget.language.b;
import com.gau.go.launcherex.gowidget.weather.c.e;
import com.gau.go.launcherex.gowidget.weather.globalview.t;
import com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider;
import java.util.ArrayList;

public class MainWidgetSetting
  extends GoWeatherEXActivity
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  private static String D = "";
  private static String E = "";
  private static TextView n;
  private static TextView p;
  private PackageManager A;
  private String B;
  private String C;
  private boolean F = false;
  private boolean G = false;
  private ai H;
  private com.gau.go.launcherex.gowidget.weather.d.f I;
  private t J;
  private h K;
  public int a;
  public int b;
  public int c;
  public int d = 0;
  private View e;
  private View f;
  private CheckBox g;
  private View h;
  private TextView i;
  private int j;
  private String[] k;
  private int[] l;
  private View m;
  private View o;
  private View q;
  private CheckBox r;
  private View s;
  private CheckBox t;
  private View u;
  private View v;
  private CheckBox w;
  private e x;
  private ag y;
  private ah z;
  
  private void a(int paramInt)
  {
    Intent localIntent = new Intent(this, BillingActivity.class);
    localIntent.putExtra("recommend_type", paramInt);
    localIntent.putExtra("recommend_enterance", -1);
    startActivity(localIntent);
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
    paramArrayOfCharSequence = i();
    paramArrayOfCharSequence.b(paramInt1);
    paramArrayOfCharSequence.a(localArrayList);
    paramInt1 = i2;
    if (i3 > 4) {
      paramInt1 = 4;
    }
    paramArrayOfCharSequence.c(paramInt1);
    paramArrayOfCharSequence.a(new af(this, paramInt2));
    paramArrayOfCharSequence.a();
  }
  
  private void a(Context paramContext)
  {
    Cursor localCursor = paramContext.getContentResolver().query(WeatherContentProvider.g, new String[] { "setting_value" }, "setting_key=?", new String[] { "app_widget_theme" }, null);
    if (localCursor != null) {
      if ((localCursor.getCount() > 0) && (localCursor.moveToNext())) {
        this.B = localCursor.getString(0);
      }
    }
    try
    {
      localCursor.close();
      if (!TextUtils.isEmpty(this.B)) {
        this.C = com.gau.go.launcherex.gowidget.weather.globaltheme.a.c(paramContext, this.B);
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
              E = str;
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
          D = str;
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
        if (this.I.b())
        {
          localObject2 = this.w;
          if (this.d != 1) {
            break label294;
          }
          bool = true;
          ((CheckBox)localObject2).setChecked(bool);
          this.v.setVisibility(8);
          this.w.setEnabled(true);
          break;
        }
        this.v.setVisibility(0);
        this.w.setEnabled(false);
      }
      catch (NumberFormatException localNumberFormatException) {}
      if (!((String)localObject2).equals("widget_theme_switcher")) {
        break;
      }
      this.c = paramCursor.getInt(i2);
      break;
      break;
      label294:
      bool = false;
    }
  }
  
  private void h()
  {
    if (!TextUtils.isEmpty(this.B))
    {
      if (this.B.equals("app_widget_theme_white"))
      {
        this.F = true;
        this.G = true;
      }
    }
    else {
      return;
    }
    com.gau.go.launcherex.gowidget.weather.f.f localf = com.gau.go.launcherex.gowidget.weather.f.f.a(getApplicationContext());
    localf.a(getApplicationContext(), this.B);
    int i2 = localf.b("goweatherex_widget_l_lunar_fore", this.B);
    int i1 = i2;
    if (i2 == 0) {
      i1 = localf.b("goweatherex_widget_l_lunar", this.B);
    }
    if (i1 != 0) {}
    for (this.F = true;; this.F = false)
    {
      i2 = localf.b("goweatherex_widget_l_festival_fore", this.B);
      i1 = i2;
      if (i2 == 0) {
        i1 = localf.b("goweatherex_widget_l_festival", this.B);
      }
      if (i1 == 0) {
        break;
      }
      this.G = true;
      return;
    }
    this.G = false;
  }
  
  private t i()
  {
    if (this.J == null) {
      this.J = new t(this);
    }
    return this.J;
  }
  
  private void j()
  {
    this.y.a(1, null, WeatherContentProvider.g, new String[] { "setting_key", "setting_value" }, "setting_key in ('widgt_calendar', 'dynamic_icon_gowidget', '', 'widget_theme_switcher', 'widgt_clock')", null, null);
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    int i2 = 1;
    int i3 = 1;
    int i4 = 1;
    int i1 = 1;
    if (paramCompoundButton.equals(this.g)) {
      if (this.F) {
        if (paramBoolean) {
          if (this.a != i1)
          {
            this.a = i1;
            this.x.a(WeatherContentProvider.g, "setting_key", "calendarType", "setting_value", this.a);
            this.x.k(this.a);
          }
        }
      }
    }
    for (;;)
    {
      return;
      i1 = 0;
      break;
      Toast.makeText(getApplicationContext(), "(" + this.C + ") " + getString(2131166186), 0).show();
      return;
      if (paramCompoundButton.equals(this.r))
      {
        if (paramBoolean) {}
        for (i1 = i2; this.b != i1; i1 = 0)
        {
          this.b = i1;
          this.x.a(WeatherContentProvider.g, "setting_key", "isCycle", "setting_value", this.b);
          return;
        }
      }
      else if (paramCompoundButton.equals(this.t))
      {
        if (paramBoolean) {}
        for (i1 = i3; this.c != i1; i1 = 0)
        {
          this.c = i1;
          this.x.a(WeatherContentProvider.g, "setting_key", "widget_theme_switcher", "setting_value", this.c);
          return;
        }
      }
      else if (paramCompoundButton.equals(this.w))
      {
        if (paramBoolean) {}
        for (i1 = i4; this.d != i1; i1 = 0)
        {
          this.d = i1;
          this.x.a(WeatherContentProvider.g, "setting_key", "dynamic_icon_gowidget", "setting_value", this.d);
          return;
        }
      }
    }
  }
  
  public void onClick(View paramView)
  {
    int i1 = 0;
    if (paramView.equals(this.e)) {
      finish();
    }
    label208:
    do
    {
      for (;;)
      {
        return;
        if (paramView.equals(this.f))
        {
          if (this.F)
          {
            this.g.toggle();
            return;
          }
          Toast.makeText(getApplicationContext(), "(" + this.C + ") " + getString(2131166186), 0).show();
          return;
        }
        if (!paramView.equals(this.h)) {
          break label208;
        }
        if (!this.G) {
          break;
        }
        int i2 = this.l.length;
        while (i1 < i2)
        {
          if (this.j == this.l[i1])
          {
            a(2131166166, i1, this.k);
            return;
          }
          i1 += 1;
        }
      }
      Toast.makeText(getApplicationContext(), "(" + this.C + ") " + getString(2131166187), 0).show();
      return;
      if ((paramView.equals(this.m)) && (!this.K.a(this.m.getId())))
      {
        paramView = new Intent("android.intent.action.VIEW");
        paramView.setClass(this, AppListActivity.class);
        paramView.putExtra("calendar_clock_binding_app", 2);
        paramView.putExtra("app_widget", D);
        startActivityForResult(paramView, 0);
        overridePendingTransition(2130968584, 2130968606);
        return;
      }
      if ((paramView.equals(this.o)) && (!this.K.a(this.o.getId())))
      {
        paramView = new Intent("android.intent.action.VIEW");
        paramView.setClass(this, AppListActivity.class);
        paramView.putExtra("calendar_clock_binding_app", 1);
        paramView.putExtra("app_widget", E);
        startActivityForResult(paramView, 0);
        overridePendingTransition(2130968584, 2130968606);
        return;
      }
      if (paramView.equals(this.q))
      {
        this.r.toggle();
        return;
      }
      if (paramView.equals(this.s))
      {
        this.t.toggle();
        return;
      }
    } while (!paramView.equals(this.u));
    if (!this.I.b())
    {
      a(1);
      return;
    }
    this.w.toggle();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903277);
    getWindow().clearFlags(134217728);
    this.K = new h();
    this.A = getPackageManager();
    this.I = GoWidgetApplication.b(getApplicationContext());
    this.m = findViewById(2131231500);
    this.m.setOnClickListener(this);
    n = (TextView)findViewById(2131231501);
    this.o = findViewById(2131231502);
    this.o.setOnClickListener(this);
    p = (TextView)findViewById(2131231503);
    this.y = new ag(this, getContentResolver());
    j();
    this.x = com.gau.go.launcherex.gowidget.weather.c.c.a(getApplicationContext()).f();
    this.e = findViewById(2131230796);
    this.e.setOnClickListener(this);
    this.h = findViewById(2131231076);
    this.h.setOnClickListener(this);
    this.i = ((TextView)findViewById(2131231077));
    this.k = com.gau.go.launcherex.gowidget.weather.util.c.b(this);
    this.l = e().getIntArray(2131558440);
    this.f = findViewById(2131231074);
    this.f.setOnClickListener(this);
    this.g = ((CheckBox)findViewById(2131231504));
    this.g.setOnCheckedChangeListener(this);
    this.q = findViewById(2131231505);
    this.q.setOnClickListener(this);
    this.r = ((CheckBox)findViewById(2131231506));
    this.r.setOnCheckedChangeListener(this);
    this.s = findViewById(2131231498);
    this.s.setOnClickListener(this);
    this.t = ((CheckBox)findViewById(2131231499));
    this.t.setOnCheckedChangeListener(this);
    this.u = findViewById(2131231507);
    this.u.setOnClickListener(this);
    this.w = ((CheckBox)findViewById(2131231509));
    this.w.setOnCheckedChangeListener(this);
    this.v = findViewById(2131231508);
    if (this.I.b())
    {
      this.v.setVisibility(8);
      this.w.setEnabled(true);
    }
    for (;;)
    {
      a(this);
      h();
      if (!this.F) {
        this.g.setEnabled(false);
      }
      this.z = new ah(this, null);
      paramBundle = new IntentFilter("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_DATA_READY");
      registerReceiver(this.z, paramBundle);
      this.H = new ai(this, null);
      paramBundle = new IntentFilter("com.gau.go.launcherex.gowidget.weatherwidget.PURCHASE_CHANGE");
      registerReceiver(this.H, paramBundle);
      return;
      this.v.setVisibility(0);
      this.w.setEnabled(false);
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    unregisterReceiver(this.z);
    unregisterReceiver(this.H);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      finish();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/MainWidgetSetting.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */