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
import android.view.animation.AnimationUtils;
import com.gau.go.launcherex.gowidget.billing.BillingActivity;
import com.gau.go.launcherex.gowidget.framework.GoWidgetFrame;
import com.gau.go.launcherex.gowidget.weather.f.e;
import com.gau.go.launcherex.gowidget.weather.model.NowBean;
import com.gau.go.launcherex.gowidget.weather.model.RequestBean;
import com.gau.go.launcherex.gowidget.weather.model.WeatherBean;
import com.gau.go.launcherex.gowidget.weather.model.WidgetSettingBean;
import com.gau.go.launcherex.gowidget.weather.scroller.WidgetScrollGroup;
import com.gau.go.launcherex.gowidget.weather.scroller.m;
import com.gau.go.launcherex.gowidget.weather.service.WeatherService;
import com.gau.go.launcherex.gowidget.weather.service.c;
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

public class WeatherWidgetDays41
  extends GoWidgetFrame
  implements View.OnClickListener, View.OnLongClickListener, m
{
  private final BroadcastReceiver A = new de(this);
  protected boolean b;
  protected WidgetSettingBean c = new WidgetSettingBean();
  private int d = 0;
  private com.gau.go.launcherex.gowidget.weather.f.a e = null;
  private String f = "";
  private int g = 0;
  private Resources h = null;
  private String i;
  private int j;
  private boolean k;
  private boolean l = true;
  private boolean m;
  private boolean n;
  private boolean o;
  private boolean p;
  private boolean q;
  private WidgetScrollGroup r = null;
  private View s;
  private al t;
  private com.gau.go.launcherex.gowidget.weather.c.g u = null;
  private df v;
  private f w;
  private c x;
  private ServiceConnection y = null;
  private final BroadcastReceiver z = new dd(this);
  
  public WeatherWidgetDays41(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    d();
  }
  
  private bs a(WeatherBean paramWeatherBean)
  {
    bs localbs = i();
    localbs.a(paramWeatherBean, true);
    localbs.f();
    this.r.addView(localbs);
    this.r.a();
    return localbs;
  }
  
  private void a(Bundle paramBundle)
  {
    boolean bool2 = true;
    boolean bool3 = true;
    boolean bool4 = true;
    boolean bool1 = true;
    if (paramBundle.containsKey("world_clock")) {
      if (r.a(paramBundle, "world_clock") == 1) {
        b(bool1);
      }
    }
    do
    {
      return;
      bool1 = false;
      break;
      if (paramBundle.containsKey("isCycle"))
      {
        localWidgetSettingBean = this.c;
        if (r.a(paramBundle, "isCycle") == 1) {}
        for (bool1 = bool2;; bool1 = false)
        {
          localWidgetSettingBean.f = bool1;
          c(this.c.f);
          return;
        }
      }
      if (paramBundle.containsKey("tempUnit"))
      {
        this.c.a = r.a(paramBundle, "tempUnit");
        l();
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
        this.f = paramBundle.getString("go_widget_theme");
        b(this.f);
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
          m();
          return;
        }
      }
    } while (!paramBundle.containsKey("dynamic_icon_gowidget"));
    WidgetSettingBean localWidgetSettingBean = this.c;
    if (r.a(paramBundle, "dynamic_icon_gowidget") == 1) {}
    for (bool1 = bool4;; bool1 = false)
    {
      localWidgetSettingBean.g = bool1;
      return;
    }
  }
  
  private void a(WidgetSettingBean paramWidgetSettingBean, List paramList, String paramString)
  {
    this.c = paramWidgetSettingBean;
    this.r.a(this.c.f);
    this.b = this.w.d();
    paramWidgetSettingBean = this.u;
    if ((this.b) && (this.c.h)) {}
    for (boolean bool = true;; bool = false)
    {
      paramWidgetSettingBean.a(bool);
      a(paramList);
      g();
      a(this.w.e());
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
      e();
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
    Object localObject2 = getContext().getPackageName().substring("com.gau.go.launcherex.gowidget.".length());
    Object localObject1 = "widget_" + (String)localObject2 + ".xml";
    localObject1 = com.gau.go.launcherex.gowidget.weather.f.g.a(getContext(), paramString, (String)localObject1);
    if (localObject1 == null)
    {
      localObject1 = "widget_" + (String)localObject2;
      localObject1 = com.gau.go.launcherex.gowidget.weather.f.g.b(getContext(), this.f, (String)localObject1);
    }
    for (;;)
    {
      if (localObject1 == null) {
        return false;
      }
      XmlPullParser localXmlPullParser = com.gau.go.launcherex.gowidget.weather.f.g.a((InputStream)localObject1);
      localObject2 = new com.gau.go.launcherex.gowidget.weather.f.a();
      ((com.gau.go.launcherex.gowidget.weather.f.a)localObject2).a = paramString;
      ((com.gau.go.launcherex.gowidget.weather.f.a)localObject2).a("widget_style", String.valueOf(4));
      ((com.gau.go.launcherex.gowidget.weather.f.a)localObject2).a("widget_theme_type", String.valueOf(this.g));
      if (localXmlPullParser != null) {}
      for (boolean bool = new e().a(localXmlPullParser, (com.gau.go.launcherex.gowidget.weather.f.a)localObject2);; bool = false) {
        try
        {
          ((InputStream)localObject1).close();
          if (!bool) {
            break;
          }
          this.e = ((com.gau.go.launcherex.gowidget.weather.f.a)localObject2);
          try
          {
            this.h = getContext().getPackageManager().getResourcesForApplication(paramString);
            this.e.b = this.h;
            localObject1 = this.e.a("gw_weather_days_41_bg");
            paramString = e.a(this.h, (String)localObject1, paramString);
            this.r.setBackgroundDrawable(paramString);
            paramString = this.r.c().iterator();
            while (paramString.hasNext()) {
              ((bs)paramString.next()).a(this.e);
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
    }
  }
  
  private void b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Message localMessage = this.v.obtainMessage();
      localMessage.what = 9;
      localMessage.obj = paramString;
      this.v.sendMessage(localMessage);
    }
  }
  
  private void b(boolean paramBoolean)
  {
    this.c.h = paramBoolean;
    if ((this.c.h) && (!this.b)) {
      return;
    }
    this.u.a(this.c.h);
    e();
  }
  
  private void c(boolean paramBoolean)
  {
    this.r.a(paramBoolean);
  }
  
  private void d()
  {
    this.y = new db(this);
    this.v = new df(this);
    k();
    this.u = new com.gau.go.launcherex.gowidget.weather.c.g(getContext());
    this.f = getContext().getPackageName();
    this.t = new al(this.a);
  }
  
  private void d(boolean paramBoolean)
  {
    Iterator localIterator = this.r.c().iterator();
    while (localIterator.hasNext()) {
      ((bs)localIterator.next()).a(paramBoolean);
    }
  }
  
  private void e()
  {
    Iterator localIterator = this.r.c().iterator();
    while (localIterator.hasNext()) {
      ((bs)localIterator.next()).h();
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
    localIntentFilter.setPriority(1008);
    getContext().registerReceiver(this.z, localIntentFilter);
    localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.PACKAGE_DATA_CLEARED");
    localIntentFilter.addDataScheme("package");
    getContext().registerReceiver(this.A, localIntentFilter);
  }
  
  private void g()
  {
    try
    {
      this.i = this.w.a(this.d);
      if (!TextUtils.isEmpty(this.i)) {
        h();
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
  
  private void h()
  {
    int i3 = this.r.getChildCount();
    if (i3 < 1) {
      return;
    }
    int i1 = 0;
    label16:
    if (i1 < i3)
    {
      WeatherBean localWeatherBean = ((bs)this.r.getChildAt(i1)).d();
      if ((localWeatherBean == null) || (TextUtils.isEmpty(localWeatherBean.c())) || (!localWeatherBean.c().equals(this.i))) {}
    }
    for (;;)
    {
      int i2 = i1;
      if (i1 == -1) {
        i2 = this.j % i3;
      }
      if ((i3 <= 0) || (i2 >= i3)) {
        break;
      }
      this.r.a(i2);
      this.j = i2;
      return;
      i1 += 1;
      break label16;
      i1 = -1;
    }
  }
  
  private bs i()
  {
    bs localbs = new bs(this.a);
    localbs.a(this.u);
    localbs.setOnLongClickListener(this);
    localbs.a(this);
    localbs.a(this.a.getString(2131166457));
    if (this.e != null) {
      localbs.a(this.e);
    }
    return localbs;
  }
  
  private void j()
  {
    Iterator localIterator = this.r.c().iterator();
    while (localIterator.hasNext())
    {
      bs localbs = (bs)localIterator.next();
      if (localbs.b()) {
        this.r.removeView(localbs);
      }
    }
    this.r.a();
  }
  
  private void k()
  {
    this.x = new dc(this);
  }
  
  private void l()
  {
    Iterator localIterator = this.r.c().iterator();
    while (localIterator.hasNext()) {
      ((bs)localIterator.next()).i();
    }
  }
  
  private void m()
  {
    Object localObject = this.r.c();
    Iterator localIterator = ((ArrayList)localObject).iterator();
    bs localbs;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localbs = (bs)localIterator.next();
    } while (localbs.d().e() == 1);
    for (;;)
    {
      if (localbs != null)
      {
        if ((localbs.j() != 3) && (((ArrayList)localObject).size() != 1)) {
          break label72;
        }
        localbs.a(1);
      }
      label72:
      int i1;
      do
      {
        return;
        localObject = this.r.getChildAt(this.j);
        this.r.removeView(localbs);
        this.r.a();
        i1 = this.r.indexOfChild((View)localObject);
      } while (i1 == -1);
      this.r.a(i1);
      return;
      localbs = null;
    }
  }
  
  private void n()
  {
    Iterator localIterator = this.r.c().iterator();
    while (localIterator.hasNext()) {
      ((bs)localIterator.next()).a(null, true);
    }
  }
  
  private void o()
  {
    ArrayList localArrayList = this.r.c();
    int i2 = localArrayList.size();
    int i1 = 0;
    if (i1 < i2)
    {
      bs localbs = (bs)localArrayList.get(i1);
      localbs.a(null, true);
      if (this.r.b() == i1) {
        localbs.a(getDynamicIconManager(), this.b, false, true);
      }
      for (;;)
      {
        i1 += 1;
        break;
        localbs.a(null, this.b, false, false);
      }
    }
  }
  
  private void p()
  {
    this.n = true;
    Object localObject = this.r.c().iterator();
    while (((Iterator)localObject).hasNext())
    {
      bs localbs = (bs)((Iterator)localObject).next();
      this.r.removeView(localbs);
    }
    localObject = a(null);
    ((bs)localObject).a(this.a.getString(2131166455));
    ((bs)localObject).a(null, true);
    this.r.a(0);
  }
  
  public void doRefresh()
  {
    Object localObject = this.r.c();
    if ((((ArrayList)localObject).size() == 1) && (((bs)((ArrayList)localObject).get(0)).b())) {}
    ArrayList localArrayList;
    do
    {
      return;
      localArrayList = new ArrayList();
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        WeatherBean localWeatherBean = ((bs)((Iterator)localObject).next()).d();
        if (localWeatherBean != null)
        {
          RequestBean localRequestBean = new RequestBean();
          localRequestBean.a(localWeatherBean.c(), localWeatherBean.d(), localWeatherBean.k.g());
          localArrayList.add(localRequestBean);
        }
      }
    } while (localArrayList.isEmpty());
    localObject = new Intent("com.gau.go.launcherex.gowidget.weather.service.NotifyService");
    ((Intent)localObject).putExtra("notify_request", 22);
    ((Intent)localObject).putParcelableArrayListExtra("req_arg", localArrayList);
    this.a.startService((Intent)localObject);
  }
  
  public com.gau.go.launcherex.gowidget.weather.widget.dynamicicon.a getDynamicIconManager()
  {
    return null;
  }
  
  public com.gau.go.launcherex.gowidget.weather.c.g getTimeManager()
  {
    return this.u;
  }
  
  public int getWidgetId()
  {
    return this.d;
  }
  
  public void gotoBilling()
  {
    Intent localIntent = new Intent();
    localIntent.setClass(this.a, BillingActivity.class);
    localIntent.setFlags(268435456);
    localIntent.putExtra("recommend_type", 4);
    localIntent.putExtra("recommend_enterance", 12);
    this.a.startActivity(localIntent);
  }
  
  public void gotoCalendar()
  {
    this.t.a(this.c.e);
  }
  
  public void gotoClock()
  {
    this.t.b(this.c.d);
  }
  
  public void gotoThemeSetting()
  {
    w.a(this.a, 20);
  }
  
  public void gotoWeatherDetail(String paramString)
  {
    paramString = p.a(getContext(), paramString, true, 4, "", -1);
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
    this.g = paramBundle.getInt("gowidget_themeid");
    this.d = paramBundle.getInt("gowidget_Id");
    if (this.g == 1) {
      this.g = 0;
    }
    if (this.p)
    {
      if ((str.equals(getContext().getPackageName())) || ("app_widget_theme_white".equals(str)) || ("app_widget_theme_black".equals(str)))
      {
        this.f = getContext().getPackageName();
        paramBundle = "app_widget_theme_white";
        this.g = 0;
      }
      while (!com.gau.go.launcherex.gowidget.weather.e.h.a(getContext(), this.d, paramBundle))
      {
        return false;
        this.f = str;
        paramBundle = str;
      }
    }
    paramBundle = com.gau.go.launcherex.gowidget.weather.e.h.a(getContext(), this.d);
    if (!TextUtils.isEmpty(paramBundle)) {
      if (paramBundle.equals("app_widget_theme_white"))
      {
        this.f = getContext().getPackageName();
        this.g = 0;
      }
    }
    for (;;)
    {
      return a(this.f);
      if (paramBundle.equals("app_widget_theme_black"))
      {
        this.f = getContext().getPackageName();
        this.g = 0;
      }
      else
      {
        this.f = paramBundle;
        this.g = 0;
        continue;
        this.f = str;
      }
    }
  }
  
  public void onBillingStatusChange(boolean paramBoolean)
  {
    this.b = paramBoolean;
    this.c.h = this.b;
    this.u.a(this.b);
    e();
  }
  
  public void onClick(View paramView)
  {
    if (paramView.equals(this.s)) {
      w.a(this.a, 31);
    }
  }
  
  public void onDelete(int paramInt)
  {
    super.onDelete(paramInt);
    com.gau.go.launcherex.gowidget.weather.e.h.b(getContext(), this.d);
    if (this.w != null) {}
    try
    {
      this.w.b(this.d);
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
    this.u.b();
    this.a.unregisterReceiver(this.z);
    this.a.unregisterReceiver(this.A);
    try
    {
      this.w.b(this.x);
      this.a.unbindService(this.y);
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
    this.j = paramInt;
    paramWidgetScrollGroup = (dg)paramWidgetScrollGroup.getChildAt(this.j);
    if ((paramWidgetScrollGroup != null) && (paramWidgetScrollGroup.n() == dh.a))
    {
      this.i = ((bs)paramWidgetScrollGroup).c();
      if (this.w == null) {}
    }
    try
    {
      this.w.a(4, this.d, this.i);
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
    if (paramBundle == null) {}
    do
    {
      return;
      this.o = paramBundle.getBoolean("gowidget_add_to_screen");
      this.d = paramBundle.getInt("gowidget_Id");
      this.a.bindService(new Intent(this.a, WeatherService.class), this.y, 1);
    } while (this.q);
    paramBundle = com.gau.go.launcherex.gowidget.weather.e.h.a(getContext(), this.d);
    if (!TextUtils.isEmpty(paramBundle)) {
      if (paramBundle.equals("app_widget_theme_white"))
      {
        this.f = this.a.getPackageName();
        this.g = 0;
      }
    }
    for (;;)
    {
      a(this.f);
      return;
      if (paramBundle.equals("app_widget_theme_black"))
      {
        this.f = this.a.getPackageName();
        this.g = 0;
      }
      else
      {
        this.f = paramBundle;
        this.g = 0;
        continue;
        this.f = getContext().getPackageName();
        this.g = 0;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/WeatherWidgetDays41.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */