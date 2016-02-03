package com.gau.go.launcherex.gowidget.weather.view;

import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import com.gau.go.launcherex.gowidget.framework.GoWidgetFrame;
import com.gau.go.launcherex.gowidget.weather.globaltheme.b.e;
import com.gau.go.launcherex.gowidget.weather.model.NowBean;
import com.gau.go.launcherex.gowidget.weather.model.RequestBean;
import com.gau.go.launcherex.gowidget.weather.model.WeatherBean;
import com.gau.go.launcherex.gowidget.weather.model.WidgetSettingBean;
import com.gau.go.launcherex.gowidget.weather.scroller.WidgetScrollGroup;
import com.gau.go.launcherex.gowidget.weather.scroller.m;
import com.gau.go.launcherex.gowidget.weather.service.NotifyService;
import com.gau.go.launcherex.gowidget.weather.service.WeatherService;
import com.gau.go.launcherex.gowidget.weather.service.f;
import com.gau.go.launcherex.gowidget.weather.systemwidget.al;
import com.gau.go.launcherex.gowidget.weather.util.p;
import com.gau.go.launcherex.gowidget.weather.util.r;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

public class WeatherWidget41
  extends GoWidgetFrame
  implements View.OnClickListener, View.OnLongClickListener, m
{
  private int A;
  private long B;
  private int C;
  private cl D;
  private f E;
  private com.gau.go.launcherex.gowidget.weather.service.c F;
  private ServiceConnection G = null;
  private final BroadcastReceiver H = new cj(this);
  private final BroadcastReceiver I = new ck(this);
  protected boolean b;
  WidgetSettingBean c = new WidgetSettingBean();
  private int d = 0;
  private String e;
  private int f;
  private com.gau.go.launcherex.gowidget.weather.f.a g = null;
  private String h = "";
  private int i = 0;
  private Resources j = null;
  private boolean k;
  private boolean l = true;
  private boolean m;
  private boolean n;
  private boolean o;
  private boolean p;
  private boolean q;
  private WidgetScrollGroup r = null;
  private View s;
  private TextView t;
  private al u;
  private com.gau.go.launcherex.gowidget.weather.c.g v = null;
  private cm w;
  private boolean x = false;
  private com.gau.go.launcherex.gowidget.weather.globaltheme.d y;
  private ArrayList z;
  
  public WeatherWidget41(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    d();
  }
  
  private bl a(WeatherBean paramWeatherBean)
  {
    bl localbl = k();
    localbl.a(paramWeatherBean);
    this.r.addView(localbl);
    this.r.a();
    return localbl;
  }
  
  private void a(int paramInt)
  {
    this.v.a(1, paramInt);
    Iterator localIterator = this.r.c().iterator();
    while (localIterator.hasNext())
    {
      bl localbl = (bl)localIterator.next();
      localbl.a(localbl.c());
    }
  }
  
  private void a(Bundle paramBundle)
  {
    boolean bool2 = true;
    boolean bool3 = true;
    boolean bool4 = true;
    boolean bool5 = true;
    boolean bool1 = true;
    if (paramBundle.containsKey("dateStyle")) {
      a(r.a(paramBundle, "dateStyle"));
    }
    do
    {
      return;
      if (paramBundle.containsKey("world_clock"))
      {
        if (r.a(paramBundle, "world_clock") == 1) {}
        for (;;)
        {
          c(bool1);
          return;
          bool1 = false;
        }
      }
      if (paramBundle.containsKey("isCycle"))
      {
        localWidgetSettingBean = this.c;
        if (r.a(paramBundle, "isCycle") == 1) {}
        for (bool1 = bool2;; bool1 = false)
        {
          localWidgetSettingBean.f = bool1;
          d(this.c.f);
          return;
        }
      }
      if (paramBundle.containsKey("tempUnit"))
      {
        this.c.a = r.a(paramBundle, "tempUnit");
        n();
        return;
      }
      if (paramBundle.containsKey("widgt_calendar"))
      {
        this.c.e = paramBundle.getString("widgt_calendar");
        return;
      }
      if (paramBundle.containsKey("widgt_clock"))
      {
        this.c.d = paramBundle.getString("widgt_clock");
        return;
      }
      if (paramBundle.containsKey("go_widget_theme"))
      {
        this.h = paramBundle.getString("go_widget_theme");
        c(this.h);
        return;
      }
      if (paramBundle.containsKey("auto_location"))
      {
        localWidgetSettingBean = this.c;
        if (r.a(paramBundle, "auto_location") == 1) {}
        for (bool1 = bool3;; bool1 = false)
        {
          localWidgetSettingBean.i = bool1;
          if (this.c.i) {
            break;
          }
          o();
          return;
        }
      }
      if (paramBundle.containsKey("dynamic_icon_gowidget"))
      {
        localWidgetSettingBean = this.c;
        if (r.a(paramBundle, "dynamic_icon_gowidget") == 1) {}
        for (bool1 = bool4;; bool1 = false)
        {
          localWidgetSettingBean.g = bool1;
          return;
        }
      }
    } while (!paramBundle.containsKey("widget_theme_switcher"));
    WidgetSettingBean localWidgetSettingBean = this.c;
    if (r.a(paramBundle, "widget_theme_switcher") == 1) {}
    for (bool1 = bool5;; bool1 = false)
    {
      localWidgetSettingBean.l = bool1;
      b(this.c.l);
      return;
    }
  }
  
  private void a(WidgetSettingBean paramWidgetSettingBean, List paramList, String paramString)
  {
    this.c = paramWidgetSettingBean;
    this.r.a(this.c.f);
    this.b = this.E.d();
    paramWidgetSettingBean = this.v;
    if ((this.b) && (this.c.h)) {}
    for (boolean bool = true;; bool = false)
    {
      paramWidgetSettingBean.a(bool);
      this.v.a(1, this.c.c);
      a(paramList);
      h();
      a(this.E.e());
      b(this.c.l);
      return;
    }
  }
  
  private void a(List paramList)
  {
    this.l = false;
    if (!paramList.isEmpty())
    {
      this.r.removeAllViews();
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        a((WeatherBean)paramList.next());
      }
      this.r.a();
    }
    for (;;)
    {
      g();
      return;
      this.k = true;
      paramList = new Intent("com.gau.go.launcherex.gowidget.weather.service.NotifyService");
      paramList.putExtra("notify_request", 50);
      getContext().startService(paramList);
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.s.setVisibility(0);
      this.s.startAnimation(AnimationUtils.loadAnimation(this.a, 2130968620));
      return;
    }
    this.s.setVisibility(8);
  }
  
  private boolean a(String paramString)
  {
    String str = getContext().getPackageName().substring("com.gau.go.launcherex.gowidget.".length());
    Object localObject1 = "widget_" + str + ".xml";
    Object localObject2 = com.gau.go.launcherex.gowidget.weather.f.g.a(getContext(), paramString, (String)localObject1);
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = "widget_" + str;
      localObject1 = com.gau.go.launcherex.gowidget.weather.f.g.b(getContext(), paramString, (String)localObject1);
    }
    if (localObject1 == null) {
      return false;
    }
    localObject2 = com.gau.go.launcherex.gowidget.weather.f.g.a((InputStream)localObject1);
    this.g = new com.gau.go.launcherex.gowidget.weather.f.a();
    this.g.a = paramString;
    this.g.a("widget_style", String.valueOf(1));
    this.g.a("widget_theme_type", String.valueOf(this.i));
    if (localObject2 != null) {
      new com.gau.go.launcherex.gowidget.weather.f.c().a((XmlPullParser)localObject2, this.g);
    }
    try
    {
      ((InputStream)localObject1).close();
      try
      {
        this.j = getContext().getPackageManager().getResourcesForApplication(paramString);
        this.g.b = this.j;
        localObject1 = this.g.a("gw_weather_41_bg");
        paramString = com.gau.go.launcherex.gowidget.weather.f.c.a(this.j, (String)localObject1, paramString);
        this.r.setBackgroundDrawable(paramString);
        paramString = this.r.c().iterator();
        while (paramString.hasNext()) {
          ((bl)paramString.next()).a(this.g);
        }
        return true;
      }
      catch (PackageManager.NameNotFoundException paramString)
      {
        paramString.printStackTrace();
      }
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        localIOException.printStackTrace();
      }
    }
  }
  
  private void b(String paramString)
  {
    this.t.setText(paramString);
    this.t.setVisibility(0);
    paramString = AnimationUtils.loadAnimation(this.a, 2130968620);
    paramString.setDuration(200L);
    this.t.startAnimation(paramString);
    this.t.postDelayed(new ci(this), 3000L);
  }
  
  private void b(boolean paramBoolean)
  {
    Iterator localIterator = this.r.c().iterator();
    while (localIterator.hasNext()) {
      ((bl)localIterator.next()).c(paramBoolean);
    }
  }
  
  private void c(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Message localMessage = this.w.obtainMessage();
      localMessage.what = 9;
      localMessage.obj = paramString;
      this.w.sendMessage(localMessage);
    }
  }
  
  private void c(boolean paramBoolean)
  {
    this.c.h = paramBoolean;
    if ((this.c.h) && (!this.b)) {
      return;
    }
    this.v.a(this.c.h);
    g();
  }
  
  private void d()
  {
    this.G = new cg(this);
    this.w = new cm(this);
    e();
    this.v = new com.gau.go.launcherex.gowidget.weather.c.g(getContext());
    this.h = getContext().getPackageName();
    this.u = new al(this.a);
    this.z = com.gau.go.launcherex.gowidget.weather.globaltheme.c.d.e(this.a, getResources());
    this.y = new com.gau.go.launcherex.gowidget.weather.globaltheme.d(this.a);
  }
  
  private void d(boolean paramBoolean)
  {
    this.r.a(paramBoolean);
  }
  
  private void e()
  {
    this.F = new ch(this);
  }
  
  private void e(boolean paramBoolean)
  {
    Iterator localIterator = this.r.c().iterator();
    while (localIterator.hasNext()) {
      ((bl)localIterator.next()).b(paramBoolean);
    }
  }
  
  private void f()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.TIME_TICK");
    localIntentFilter.addAction("android.intent.action.TIME_SET");
    localIntentFilter.addAction("android.intent.action.DATE_CHANGED");
    localIntentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
    localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
    localIntentFilter.addAction("android.intent.action.SCREEN_ON");
    localIntentFilter.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_INITIALIZED_CITY");
    localIntentFilter.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_REFRESH_STARTED");
    localIntentFilter.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_RELOAD_DATA");
    localIntentFilter.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_DATA_READY");
    localIntentFilter.addAction("com.gau.go.launcherex.gowidget.weatherwidget.PRODUCT_THEME_VIP_PURCHASE_STATE_CHANGE_ACTION");
    localIntentFilter.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_THEME_PURCHASE_SUCCESS");
    localIntentFilter.setPriority(1008);
    getContext().registerReceiver(this.H, localIntentFilter);
    localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.PACKAGE_DATA_CLEARED");
    localIntentFilter.addDataScheme("package");
    getContext().registerReceiver(this.I, localIntentFilter);
    this.D = new cl(this, null);
    localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.PACKAGE_ADDED");
    localIntentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
    localIntentFilter.addDataScheme("package");
    this.a.registerReceiver(this.D, localIntentFilter);
  }
  
  private void g()
  {
    Iterator localIterator = this.r.c().iterator();
    while (localIterator.hasNext()) {
      ((bl)localIterator.next()).h();
    }
  }
  
  private void h()
  {
    try
    {
      this.e = this.E.a(this.d);
      if (!TextUtils.isEmpty(this.e)) {
        i();
      }
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        localRemoteException.printStackTrace();
      }
    }
  }
  
  private void i()
  {
    int i3 = this.r.getChildCount();
    if (i3 < 1) {
      return;
    }
    int i1 = 0;
    label16:
    if (i1 < i3)
    {
      WeatherBean localWeatherBean = ((bl)this.r.getChildAt(i1)).f();
      if ((localWeatherBean == null) || (TextUtils.isEmpty(localWeatherBean.c())) || (!localWeatherBean.c().equals(this.e))) {}
    }
    for (;;)
    {
      int i2 = i1;
      if (i1 == -1) {
        i2 = this.f % i3;
      }
      if ((i3 <= 0) || (i2 >= i3)) {
        break;
      }
      this.r.a(i2);
      this.f = i2;
      return;
      i1 += 1;
      break label16;
      i1 = -1;
    }
  }
  
  private void j()
  {
    if (this.h.equals(getContext().getPackageName())) {
      this.A = (this.z.size() - 1);
    }
    for (;;)
    {
      return;
      int i1 = 0;
      while (i1 < this.z.size())
      {
        e locale = (e)this.z.get(i1);
        if (this.h.equals(locale.x()))
        {
          this.A = i1;
          return;
        }
        i1 += 1;
      }
    }
  }
  
  private bl k()
  {
    bl localbl = new bl(this.a);
    localbl.a(this.v);
    localbl.setOnLongClickListener(this);
    localbl.a(this);
    localbl.a(this.a.getString(2131166457));
    localbl.b(this.c.a);
    localbl.c(this.c.l);
    if (this.g != null) {
      localbl.a(this.g);
    }
    return localbl;
  }
  
  private void l()
  {
    Iterator localIterator = this.r.c().iterator();
    while (localIterator.hasNext())
    {
      bl localbl = (bl)localIterator.next();
      if (localbl.d()) {
        this.r.removeView(localbl);
      }
    }
    this.r.a();
  }
  
  private void m()
  {
    Iterator localIterator = this.r.c().iterator();
    while (localIterator.hasNext()) {
      ((bl)localIterator.next()).k();
    }
  }
  
  private void n()
  {
    Iterator localIterator = this.r.c().iterator();
    while (localIterator.hasNext()) {
      ((bl)localIterator.next()).a(this.c.a);
    }
  }
  
  private void o()
  {
    Object localObject = this.r.c();
    Iterator localIterator = ((ArrayList)localObject).iterator();
    bl localbl;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localbl = (bl)localIterator.next();
    } while (localbl.f().e() == 1);
    for (;;)
    {
      if (localbl != null)
      {
        if ((localbl.i() != 3) && (((ArrayList)localObject).size() != 1)) {
          break label72;
        }
        localbl.c(1);
      }
      label72:
      int i1;
      do
      {
        return;
        localObject = this.r.getChildAt(this.f);
        this.r.removeView(localbl);
        this.r.a();
        i1 = this.r.indexOfChild((View)localObject);
      } while (i1 == -1);
      this.r.a(i1);
      return;
      localbl = null;
    }
  }
  
  private void p()
  {
    Iterator localIterator = this.r.c().iterator();
    while (localIterator.hasNext()) {
      ((bl)localIterator.next()).a(true);
    }
  }
  
  private void q()
  {
    ArrayList localArrayList = this.r.c();
    int i2 = localArrayList.size();
    int i1 = 0;
    if (i1 < i2)
    {
      bl localbl = (bl)localArrayList.get(i1);
      localbl.a(true);
      if (this.r.b() == i1) {
        localbl.a(getDynamicIconManager(), this.b, false, true);
      }
      for (;;)
      {
        i1 += 1;
        break;
        localbl.a(null, this.b, false, false);
      }
    }
  }
  
  private void r()
  {
    this.n = true;
    Object localObject = this.r.c().iterator();
    while (((Iterator)localObject).hasNext())
    {
      bl localbl = (bl)((Iterator)localObject).next();
      this.r.removeView(localbl);
    }
    localObject = a(null);
    ((bl)localObject).a(this.a.getString(2131166455));
    ((bl)localObject).a(true);
    this.r.a(0);
  }
  
  public com.gau.go.launcherex.gowidget.weather.widget.dynamicicon.a getDynamicIconManager()
  {
    return null;
  }
  
  public com.gau.go.launcherex.gowidget.weather.c.g getTimeManager()
  {
    return this.v;
  }
  
  public int getWidgetId()
  {
    return this.d;
  }
  
  public void gotoCalendar()
  {
    this.u.a(this.c.e);
  }
  
  public void gotoClock()
  {
    this.u.b(this.c.d);
  }
  
  public void gotoThemeStore()
  {
    w.a(this.a, 20);
  }
  
  public void gotoWeatherDetail(String paramString)
  {
    paramString = p.a(getContext(), paramString, true, 5, "", -1);
    paramString.addFlags(67108864);
    paramString.putExtra("gowidget_Id", this.d);
    try
    {
      getContext().startActivity(paramString);
      return;
    }
    catch (ActivityNotFoundException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public boolean isLoadingDatas()
  {
    return this.l;
  }
  
  public boolean isLocatingCity()
  {
    return this.k;
  }
  
  public boolean onApplyTheme(Bundle paramBundle)
  {
    this.q = true;
    String str = paramBundle.getString("gowidget_theme");
    this.i = paramBundle.getInt("gowidget_themeid");
    this.d = paramBundle.getInt("gowidget_Id");
    if (this.i == 1) {
      this.i = 0;
    }
    boolean bool1;
    if (this.p)
    {
      if ((str.equals(getContext().getPackageName())) || ("app_widget_theme_white".equals(str)) || ("app_widget_theme_black".equals(str)))
      {
        this.h = getContext().getPackageName();
        paramBundle = "app_widget_theme_white";
        this.i = 0;
      }
      while (!com.gau.go.launcherex.gowidget.weather.e.h.a(getContext(), this.d, paramBundle))
      {
        bool1 = false;
        return bool1;
        this.h = str;
        paramBundle = str;
      }
    }
    paramBundle = com.gau.go.launcherex.gowidget.weather.e.h.a(getContext(), this.d);
    if (!TextUtils.isEmpty(paramBundle)) {
      if (paramBundle.equals("app_widget_theme_white"))
      {
        this.h = getContext().getPackageName();
        this.i = 0;
      }
    }
    for (;;)
    {
      boolean bool2 = a(this.h);
      bool1 = bool2;
      if (!bool2) {
        break;
      }
      this.r.requestLayout();
      return bool2;
      if (paramBundle.equals("app_widget_theme_black"))
      {
        this.h = getContext().getPackageName();
        this.i = 0;
      }
      else
      {
        this.h = paramBundle;
        this.i = 0;
        continue;
        this.h = str;
      }
    }
  }
  
  public void onBillingStatusChange(boolean paramBoolean)
  {
    this.b = paramBoolean;
    this.c.h = this.b;
    this.v.a(this.b);
    g();
  }
  
  public void onClick(View paramView)
  {
    if (paramView.equals(this.s)) {
      w.a(this.a, 31);
    }
    while (!paramView.equals(this.t)) {
      return;
    }
    w.a(this.a, 35);
  }
  
  public void onDelete(int paramInt)
  {
    super.onDelete(paramInt);
    com.gau.go.launcherex.gowidget.weather.e.h.b(getContext(), this.d);
    if (this.E != null) {}
    try
    {
      this.E.b(this.d);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      localRemoteException.printStackTrace();
    }
  }
  
  public void onEnter(int paramInt) {}
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.r = ((WidgetScrollGroup)findViewById(2131231977));
    this.r.a(this);
    this.s = findViewById(2131231996);
    this.s.setOnClickListener(this);
    this.t = ((TextView)findViewById(2131231997));
    this.t.setOnClickListener(this);
    f();
    a(null);
  }
  
  public void onLeave(int paramInt) {}
  
  public boolean onLongClick(View paramView)
  {
    if (!this.r.getScreenScroller().d()) {
      return false;
    }
    performLongClick();
    return true;
  }
  
  public void onPause(int paramInt) {}
  
  public void onRemove(int paramInt)
  {
    super.onRemove(paramInt);
    this.v.b();
    this.a.unregisterReceiver(this.H);
    this.a.unregisterReceiver(this.I);
    this.a.unregisterReceiver(this.D);
    this.y.a();
    try
    {
      this.E.b(this.F);
      this.a.unbindService(this.G);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      localRemoteException.printStackTrace();
    }
  }
  
  public void onResume(int paramInt) {}
  
  public void onScrollGroupChange(WidgetScrollGroup paramWidgetScrollGroup, int paramInt) {}
  
  public void onScrollGroupFinishScroll(WidgetScrollGroup paramWidgetScrollGroup, int paramInt)
  {
    this.f = paramInt;
    paramWidgetScrollGroup = (dg)paramWidgetScrollGroup.getChildAt(this.f);
    if ((paramWidgetScrollGroup != null) && (paramWidgetScrollGroup.n() == dh.a))
    {
      this.e = ((bl)paramWidgetScrollGroup).e();
      if (this.E == null) {}
    }
    try
    {
      this.E.a(1, this.d, this.e);
      return;
    }
    catch (RemoteException paramWidgetScrollGroup)
    {
      paramWidgetScrollGroup.printStackTrace();
    }
  }
  
  public void onScrollGroupStartScroll(WidgetScrollGroup paramWidgetScrollGroup, int paramInt) {}
  
  public void onStart(Bundle paramBundle)
  {
    this.p = true;
    if (paramBundle != null)
    {
      this.d = paramBundle.getInt("gowidget_Id");
      this.o = paramBundle.getBoolean("gowidget_add_to_screen");
    }
    this.a.bindService(new Intent(this.a, WeatherService.class), this.G, 1);
    if (!this.q)
    {
      paramBundle = com.gau.go.launcherex.gowidget.weather.e.h.a(getContext(), this.d);
      if (TextUtils.isEmpty(paramBundle)) {
        break label166;
      }
      if (!paramBundle.equals("app_widget_theme_white")) {
        break label124;
      }
      this.h = getContext().getPackageName();
      this.i = 0;
    }
    for (;;)
    {
      j();
      a(this.h);
      return;
      label124:
      if (paramBundle.equals("app_widget_theme_black"))
      {
        this.h = getContext().getPackageName();
        this.i = 0;
      }
      else
      {
        this.h = paramBundle;
        this.i = 0;
        continue;
        label166:
        this.h = getContext().getPackageName();
        this.i = 0;
      }
    }
  }
  
  public void onThemeSwitcherClick()
  {
    Intent localIntent = new Intent(this.a, NotifyService.class);
    localIntent.putExtra("notify_request", 51);
    this.a.startService(localIntent);
    int i1 = this.z.size();
    if (i1 == 1) {
      b(this.a.getString(2131166572));
    }
    do
    {
      return;
      long l1 = System.currentTimeMillis();
      if ((this.x) && (l1 - this.B > 180000L))
      {
        this.x = false;
        this.B = l1;
        b(this.a.getString(2131166573));
        return;
      }
      m();
      this.A += 1;
      this.C += 1;
      this.w.removeMessages(18);
      this.w.sendEmptyMessageDelayed(18, 450L);
    } while ((i1 != 2) || (this.C % 3 != 0));
    this.x = true;
  }
  
  public void refreshWeather()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = this.r.c().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (bl)((Iterator)localObject1).next();
      if (!((bl)localObject2).d())
      {
        localObject2 = ((bl)localObject2).f();
        RequestBean localRequestBean = new RequestBean();
        localRequestBean.a(((WeatherBean)localObject2).c(), ((WeatherBean)localObject2).d(), ((WeatherBean)localObject2).k.g());
        localArrayList.add(localRequestBean);
      }
    }
    if (!localArrayList.isEmpty())
    {
      localObject1 = new Intent("com.gau.go.launcherex.gowidget.weather.service.NotifyService");
      ((Intent)localObject1).putExtra("notify_request", 22);
      ((Intent)localObject1).putParcelableArrayListExtra("req_arg", localArrayList);
      this.a.startService((Intent)localObject1);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/WeatherWidget41.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */