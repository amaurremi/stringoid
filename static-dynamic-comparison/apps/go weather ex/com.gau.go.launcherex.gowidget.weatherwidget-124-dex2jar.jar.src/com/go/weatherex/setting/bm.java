package com.go.weatherex.setting;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import android.widget.Toast;
import com.gau.go.launcherex.gowidget.billing.BillingActivity;
import com.gau.go.launcherex.gowidget.d.h;
import com.gau.go.launcherex.gowidget.framework.GoWidgetApplication;
import com.gau.go.launcherex.gowidget.weather.c.e;
import com.gau.go.launcherex.gowidget.weather.globalview.t;
import com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider;
import com.gau.go.launcherex.gowidget.weather.view.AppListActivity;
import java.util.ArrayList;

public class bm
  extends com.go.weatherex.framework.fragment.a
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  private bp A;
  private PackageManager B;
  private String C;
  private String D;
  private String E = "";
  private String F = "";
  private boolean G = false;
  private boolean H = false;
  private bq I;
  private com.gau.go.launcherex.gowidget.weather.d.f J;
  private t K;
  private h L;
  public int a;
  public int b;
  public int c;
  public int d = 0;
  private TextView e;
  private View f;
  private View g;
  private CheckBox h;
  private View i;
  private TextView j;
  private int k;
  private String[] l;
  private int[] m;
  private View n;
  private TextView o;
  private View p;
  private TextView q;
  private View r;
  private CheckBox s;
  private View t;
  private CheckBox u;
  private View v;
  private View w;
  private CheckBox x;
  private e y;
  private bo z;
  
  private void a(int paramInt)
  {
    Intent localIntent = new Intent(getActivity(), BillingActivity.class);
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
    paramArrayOfCharSequence = d();
    paramArrayOfCharSequence.b(paramInt1);
    paramArrayOfCharSequence.a(localArrayList);
    paramInt1 = i2;
    if (i3 > 4) {
      paramInt1 = 4;
    }
    paramArrayOfCharSequence.c(paramInt1);
    paramArrayOfCharSequence.a(new bn(this, paramInt2));
    paramArrayOfCharSequence.a();
  }
  
  private void a(Context paramContext)
  {
    Cursor localCursor = paramContext.getContentResolver().query(WeatherContentProvider.g, new String[] { "setting_value" }, "setting_key=?", new String[] { "app_widget_theme" }, null);
    if (localCursor != null) {
      if ((localCursor.getCount() > 0) && (localCursor.moveToNext())) {
        this.C = localCursor.getString(0);
      }
    }
    try
    {
      localCursor.close();
      if (!TextUtils.isEmpty(this.C)) {
        this.D = com.gau.go.launcherex.gowidget.weather.globaltheme.a.c(paramContext, this.C);
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
              this.F = str;
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
          this.E = str;
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
        if (this.J.b())
        {
          localObject2 = this.x;
          if (this.d != 1) {
            break label313;
          }
          bool = true;
          ((CheckBox)localObject2).setChecked(bool);
          this.w.setVisibility(8);
          this.x.setVisibility(0);
          this.x.setEnabled(true);
          break;
        }
        this.w.setVisibility(0);
        this.x.setVisibility(8);
        this.x.setEnabled(false);
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
    if (this.o != null) {
      this.o.setText(paramString);
    }
  }
  
  private void b(String paramString)
  {
    this.E = paramString;
  }
  
  private void c()
  {
    if (!TextUtils.isEmpty(this.C))
    {
      if (this.C.equals("app_widget_theme_white"))
      {
        this.G = true;
        this.H = true;
      }
    }
    else {
      return;
    }
    com.gau.go.launcherex.gowidget.weather.f.f localf = com.gau.go.launcherex.gowidget.weather.f.f.a(getActivity().getApplicationContext());
    localf.a(getActivity().getApplicationContext(), this.C);
    int i2 = localf.b("goweatherex_widget_l_lunar_fore", this.C);
    int i1 = i2;
    if (i2 == 0) {
      i1 = localf.b("goweatherex_widget_l_lunar", this.C);
    }
    if (i1 != 0) {}
    for (this.G = true;; this.G = false)
    {
      i2 = localf.b("goweatherex_widget_l_festival_fore", this.C);
      i1 = i2;
      if (i2 == 0) {
        i1 = localf.b("goweatherex_widget_l_festival", this.C);
      }
      if (i1 == 0) {
        break;
      }
      this.H = true;
      return;
    }
    this.H = false;
  }
  
  private void c(String paramString)
  {
    this.F = paramString;
  }
  
  private t d()
  {
    if (this.K == null) {
      this.K = new t(getActivity());
    }
    return this.K;
  }
  
  private void d(String paramString)
  {
    if (this.q != null) {
      this.q.setText(paramString);
    }
  }
  
  private void j()
  {
    this.z.a(1, null, WeatherContentProvider.g, new String[] { "setting_key", "setting_value" }, "setting_key in ('widgt_calendar', 'dynamic_icon_gowidget', '', 'widget_theme_switcher', 'widgt_clock')", null, null);
  }
  
  protected boolean a()
  {
    return super.a();
  }
  
  public void b()
  {
    a(this.e, 4, true);
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    this.L = new h();
    this.B = getActivity().getPackageManager();
    this.J = GoWidgetApplication.b(getActivity().getApplicationContext());
    this.n = c(2131231500);
    this.n.setOnClickListener(this);
    this.o = ((TextView)c(2131231501));
    this.p = c(2131231502);
    this.p.setOnClickListener(this);
    this.q = ((TextView)c(2131231503));
    this.z = new bo(this, getActivity().getContentResolver());
    j();
    this.y = com.gau.go.launcherex.gowidget.weather.c.c.a(getActivity().getApplicationContext()).f();
    this.e = ((TextView)c(2131231145));
    this.e.setText(2131166106);
    this.f = c(2131231196);
    this.f.setOnClickListener(this);
    this.i = c(2131231076);
    this.i.setOnClickListener(this);
    this.j = ((TextView)c(2131231077));
    this.l = com.gau.go.launcherex.gowidget.weather.util.c.b(getActivity());
    this.m = getResources().getIntArray(2131558440);
    this.g = c(2131231074);
    this.g.setOnClickListener(this);
    this.h = ((CheckBox)c(2131231504));
    this.h.setOnCheckedChangeListener(this);
    this.r = c(2131231505);
    this.r.setOnClickListener(this);
    this.s = ((CheckBox)c(2131231506));
    this.s.setOnCheckedChangeListener(this);
    this.t = c(2131231498);
    this.t.setOnClickListener(this);
    this.u = ((CheckBox)c(2131231499));
    this.u.setOnCheckedChangeListener(this);
    this.v = c(2131231507);
    this.v.setOnClickListener(this);
    this.x = ((CheckBox)c(2131231509));
    this.x.setOnCheckedChangeListener(this);
    this.w = c(2131231508);
    if (this.J.b())
    {
      this.w.setVisibility(8);
      this.x.setVisibility(0);
      this.x.setEnabled(true);
    }
    for (;;)
    {
      a(getActivity());
      c();
      if (!this.G) {
        this.h.setEnabled(false);
      }
      this.A = new bp(this, null);
      paramBundle = new IntentFilter("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_DATA_READY");
      getActivity().registerReceiver(this.A, paramBundle);
      this.I = new bq(this, null);
      paramBundle = new IntentFilter();
      paramBundle.addAction("com.gau.go.launcherex.gowidget.weatherwidget.PURCHASE_CHANGE");
      paramBundle.addAction("com.gau.go.launcherex.gowidget.weatherwidget.action_calendar_binding_app");
      paramBundle.addAction("com.gau.go.launcherex.gowidget.weatherwidget.action_clock_binding_app");
      getActivity().registerReceiver(this.I, paramBundle);
      b();
      return;
      this.w.setVisibility(0);
      this.x.setVisibility(8);
      this.x.setEnabled(false);
    }
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    int i2 = 1;
    int i3 = 1;
    int i4 = 1;
    int i1 = 1;
    if (paramCompoundButton.equals(this.h)) {
      if (this.G) {
        if (paramBoolean) {
          if (this.a != i1)
          {
            this.a = i1;
            this.y.a(WeatherContentProvider.g, "setting_key", "calendarType", "setting_value", this.a);
            this.y.k(this.a);
          }
        }
      }
    }
    for (;;)
    {
      return;
      i1 = 0;
      break;
      Toast.makeText(getActivity().getApplicationContext(), "(" + this.D + ") " + getString(2131166186), 0).show();
      return;
      if (paramCompoundButton.equals(this.s))
      {
        if (paramBoolean) {}
        for (i1 = i2; this.b != i1; i1 = 0)
        {
          this.b = i1;
          this.y.a(WeatherContentProvider.g, "setting_key", "isCycle", "setting_value", this.b);
          return;
        }
      }
      else if (paramCompoundButton.equals(this.u))
      {
        if (paramBoolean) {}
        for (i1 = i3; this.c != i1; i1 = 0)
        {
          this.c = i1;
          this.y.a(WeatherContentProvider.g, "setting_key", "widget_theme_switcher", "setting_value", this.c);
          return;
        }
      }
      else if (paramCompoundButton.equals(this.x))
      {
        if (paramBoolean) {}
        for (i1 = i4; this.d != i1; i1 = 0)
        {
          this.d = i1;
          this.y.a(WeatherContentProvider.g, "setting_key", "dynamic_icon_gowidget", "setting_value", this.d);
          return;
        }
      }
    }
  }
  
  public void onClick(View paramView)
  {
    int i1 = 0;
    if (paramView.equals(this.f)) {
      h();
    }
    label214:
    do
    {
      for (;;)
      {
        return;
        if (paramView.equals(this.g))
        {
          if (this.G)
          {
            this.h.toggle();
            return;
          }
          Toast.makeText(getActivity().getApplicationContext(), "(" + this.D + ") " + getString(2131166186), 0).show();
          return;
        }
        if (!paramView.equals(this.i)) {
          break label214;
        }
        if (!this.H) {
          break;
        }
        int i2 = this.m.length;
        while (i1 < i2)
        {
          if (this.k == this.m[i1])
          {
            a(2131166166, i1, this.l);
            return;
          }
          i1 += 1;
        }
      }
      Toast.makeText(getActivity().getApplicationContext(), "(" + this.D + ") " + getString(2131166187), 0).show();
      return;
      if ((paramView.equals(this.n)) && (!this.L.a(this.n.getId())))
      {
        paramView = new Intent("android.intent.action.VIEW");
        paramView.setClass(getActivity(), AppListActivity.class);
        paramView.putExtra("calendar_clock_binding_app", 2);
        paramView.putExtra("app_widget", this.E);
        startActivityForResult(paramView, 101);
        getActivity().overridePendingTransition(2130968584, 2130968606);
        return;
      }
      if ((paramView.equals(this.p)) && (!this.L.a(this.p.getId())))
      {
        paramView = new Intent("android.intent.action.VIEW");
        paramView.setClass(getActivity(), AppListActivity.class);
        paramView.putExtra("calendar_clock_binding_app", 1);
        paramView.putExtra("app_widget", this.F);
        startActivityForResult(paramView, 102);
        getActivity().overridePendingTransition(2130968584, 2130968606);
        return;
      }
      if (paramView.equals(this.r))
      {
        this.s.toggle();
        return;
      }
      if (paramView.equals(this.t))
      {
        this.u.toggle();
        return;
      }
    } while (!paramView.equals(this.v));
    if (!this.J.b())
    {
      a(1);
      return;
    }
    this.x.toggle();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130903157, paramViewGroup, false);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    getActivity().unregisterReceiver(this.A);
    getActivity().unregisterReceiver(this.I);
  }
  
  public void onResume()
  {
    super.onResume();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/setting/bm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */