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
import android.view.View.OnLongClickListener;
import com.gau.go.launcherex.gowidget.framework.GoWidgetFrame;
import com.gau.go.launcherex.gowidget.weather.f.a;
import com.gau.go.launcherex.gowidget.weather.model.WeatherBean;
import com.gau.go.launcherex.gowidget.weather.model.WidgetSettingBean;
import com.gau.go.launcherex.gowidget.weather.scroller.WidgetScrollGroup;
import com.gau.go.launcherex.gowidget.weather.scroller.m;
import com.gau.go.launcherex.gowidget.weather.service.WeatherService;
import com.gau.go.launcherex.gowidget.weather.service.f;
import com.gau.go.launcherex.gowidget.weather.util.p;
import com.gau.go.launcherex.gowidget.weather.util.r;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

public class WeatherWidget21
  extends GoWidgetFrame
  implements View.OnLongClickListener, m
{
  protected boolean b;
  WidgetSettingBean c = new WidgetSettingBean();
  private int d = 0;
  private String e;
  private int f;
  private a g = null;
  private String h = "";
  private int i = 0;
  private Resources j = null;
  private boolean k;
  private boolean l = true;
  private boolean m;
  private boolean n;
  private boolean o;
  private boolean p;
  private WidgetScrollGroup q = null;
  private com.gau.go.launcherex.gowidget.weather.c.g r = null;
  private cf s;
  private f t;
  private com.gau.go.launcherex.gowidget.weather.service.c u;
  private ServiceConnection v = null;
  private final BroadcastReceiver w = new cd(this);
  private final BroadcastReceiver x = new ce(this);
  
  public WeatherWidget21(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    d();
  }
  
  private bk a(WeatherBean paramWeatherBean)
  {
    bk localbk = j();
    localbk.a(paramWeatherBean);
    this.q.addView(localbk);
    this.q.a();
    return localbk;
  }
  
  private void a(Bundle paramBundle)
  {
    boolean bool2 = true;
    boolean bool3 = true;
    boolean bool4 = true;
    boolean bool1 = true;
    if (paramBundle.containsKey("world_clock")) {
      if (r.a(paramBundle, "world_clock") == 1) {
        a(bool1);
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
          b(this.c.f);
          return;
        }
      }
      if (paramBundle.containsKey("tempUnit"))
      {
        this.c.a = r.a(paramBundle, "tempUnit");
        l();
        return;
      }
      if (paramBundle.containsKey("go_widget_theme"))
      {
        this.h = paramBundle.getString("go_widget_theme");
        b(this.h);
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
  
  private void a(List paramList)
  {
    this.l = false;
    if (!paramList.isEmpty())
    {
      this.q.removeAllViews();
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        a((WeatherBean)paramList.next());
      }
      this.q.a();
    }
    for (;;)
    {
      f();
      return;
      this.k = true;
      paramList = new Intent("com.gau.go.launcherex.gowidget.weather.service.NotifyService");
      paramList.putExtra("notify_request", 50);
      getContext().startService(paramList);
    }
  }
  
  private void a(boolean paramBoolean)
  {
    this.c.h = paramBoolean;
    if ((this.c.h) && (!this.b)) {
      return;
    }
    this.r.a(this.c.h);
    f();
  }
  
  private boolean a(String paramString)
  {
    String str = getContext().getPackageName().substring("com.gau.go.launcherex.gowidget.".length());
    paramString = "widget_" + str + ".xml";
    Object localObject = com.gau.go.launcherex.gowidget.weather.f.g.a(getContext(), this.h, paramString);
    paramString = (String)localObject;
    if (localObject == null)
    {
      paramString = "widget_" + str;
      paramString = com.gau.go.launcherex.gowidget.weather.f.g.b(getContext(), this.h, paramString);
    }
    if (paramString == null) {
      return false;
    }
    localObject = com.gau.go.launcherex.gowidget.weather.f.g.a(paramString);
    this.g = new a();
    this.g.a = this.h;
    this.g.a("widget_style", String.valueOf(3));
    this.g.a("widget_theme_type", String.valueOf(this.i));
    if (localObject != null) {
      new com.gau.go.launcherex.gowidget.weather.f.c().a((XmlPullParser)localObject, this.g);
    }
    try
    {
      paramString.close();
      try
      {
        this.j = getContext().getPackageManager().getResourcesForApplication(this.h);
        this.g.b = this.j;
        paramString = this.g.a("gw_weather_41_bg");
        paramString = com.gau.go.launcherex.gowidget.weather.f.c.a(this.j, paramString, this.h);
        this.q.setBackgroundDrawable(paramString);
        paramString = this.q.c().iterator();
        while (paramString.hasNext())
        {
          localObject = (bk)paramString.next();
          if (localObject != null) {
            ((bk)localObject).a(this.g);
          }
        }
        return true;
      }
      catch (PackageManager.NameNotFoundException paramString)
      {
        paramString.printStackTrace();
      }
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  private void b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Message localMessage = this.s.obtainMessage();
      localMessage.what = 9;
      localMessage.obj = paramString;
      this.s.sendMessage(localMessage);
    }
  }
  
  private void b(boolean paramBoolean)
  {
    this.q.a(paramBoolean);
  }
  
  private void d()
  {
    this.v = new cb(this);
    this.s = new cf(this);
    i();
    this.r = new com.gau.go.launcherex.gowidget.weather.c.g(getContext());
    this.h = getContext().getPackageName();
  }
  
  private void e()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.TIME_TICK");
    localIntentFilter.addAction("android.intent.action.TIME_SET");
    localIntentFilter.addAction("android.intent.action.DATE_CHANGED");
    localIntentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
    localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
    localIntentFilter.addAction("android.intent.action.SCREEN_ON");
    localIntentFilter.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_INITIALIZED_CITY");
    localIntentFilter.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_RELOAD_DATA");
    localIntentFilter.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_DATA_READY");
    localIntentFilter.setPriority(1007);
    getContext().registerReceiver(this.w, localIntentFilter);
    localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.PACKAGE_DATA_CLEARED");
    localIntentFilter.addDataScheme("package");
    getContext().registerReceiver(this.x, localIntentFilter);
  }
  
  private void f()
  {
    Iterator localIterator = this.q.c().iterator();
    while (localIterator.hasNext()) {
      ((bk)localIterator.next()).f();
    }
  }
  
  private void g()
  {
    try
    {
      this.e = this.t.a(this.d);
      if (!TextUtils.isEmpty(this.e)) {
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
    int i3 = this.q.getChildCount();
    if (i3 < 1) {
      return;
    }
    int i1 = 0;
    label16:
    if (i1 < i3)
    {
      WeatherBean localWeatherBean = ((bk)this.q.getChildAt(i1)).d();
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
      this.q.a(i2);
      this.f = i2;
      return;
      i1 += 1;
      break label16;
      i1 = -1;
    }
  }
  
  private void i()
  {
    this.u = new cc(this);
  }
  
  private bk j()
  {
    bk localbk = new bk(this.a);
    localbk.a(this.r);
    localbk.setOnLongClickListener(this);
    localbk.a(this);
    localbk.a(this.a.getString(2131166457));
    localbk.b(this.c.a);
    if (this.g != null) {
      localbk.a(this.g);
    }
    return localbk;
  }
  
  private void k()
  {
    Iterator localIterator = this.q.c().iterator();
    while (localIterator.hasNext())
    {
      bk localbk = (bk)localIterator.next();
      if (localbk.b()) {
        this.q.removeView(localbk);
      }
    }
    this.q.a();
  }
  
  private void l()
  {
    Iterator localIterator = this.q.c().iterator();
    while (localIterator.hasNext()) {
      ((bk)localIterator.next()).a(this.c.a);
    }
  }
  
  private void m()
  {
    Object localObject = this.q.c();
    Iterator localIterator = ((ArrayList)localObject).iterator();
    bk localbk;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localbk = (bk)localIterator.next();
    } while (localbk.d().e() == 1);
    for (;;)
    {
      if (localbk != null)
      {
        if ((localbk.g() != 3) && (((ArrayList)localObject).size() != 1)) {
          break label72;
        }
        localbk.c(1);
      }
      label72:
      int i1;
      do
      {
        return;
        localObject = this.q.getChildAt(this.f);
        this.q.removeView(localbk);
        this.q.a();
        i1 = this.q.indexOfChild((View)localObject);
      } while (i1 == -1);
      this.q.a(i1);
      return;
      localbk = null;
    }
  }
  
  private void n()
  {
    this.m = true;
    this.q.removeAllViews();
    a(null).a(this.a.getString(2131166455));
  }
  
  protected void a(WidgetSettingBean paramWidgetSettingBean, List paramList, String paramString)
  {
    this.c = paramWidgetSettingBean;
    this.q.a(this.c.f);
    this.b = this.t.d();
    paramWidgetSettingBean = this.r;
    if ((this.b) && (this.c.h)) {}
    for (boolean bool = true;; bool = false)
    {
      paramWidgetSettingBean.a(bool);
      a(paramList);
      g();
      return;
    }
  }
  
  public void gotoWeatherDetail(String paramString)
  {
    paramString = p.a(getContext(), paramString, true, 6, "", -1);
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
  
  public boolean onApplyTheme(Bundle paramBundle)
  {
    this.p = true;
    String str = paramBundle.getString("gowidget_theme");
    this.i = paramBundle.getInt("gowidget_themeid");
    this.d = paramBundle.getInt("gowidget_Id");
    if (this.i == 1) {
      this.i = 0;
    }
    boolean bool1;
    if (this.o)
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
      this.q.requestLayout();
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
    this.r.a(paramBoolean);
    ArrayList localArrayList = this.q.c();
    int i1 = 0;
    if (i1 < localArrayList.size())
    {
      bk localbk = (bk)localArrayList.get(i1);
      if (this.q.b() == i1) {
        localbk.a(null, this.b, this.c.g, true);
      }
      for (;;)
      {
        i1 += 1;
        break;
        localbk.a(null, this.b, false, false);
      }
    }
  }
  
  public void onDelete(int paramInt)
  {
    super.onDelete(paramInt);
    com.gau.go.launcherex.gowidget.weather.e.h.b(getContext(), this.d);
    if (this.t != null) {}
    try
    {
      this.t.b(this.d);
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
    this.q = ((WidgetScrollGroup)findViewById(2131231977));
    this.q.a(this);
    e();
    a(null);
  }
  
  public void onLeave(int paramInt) {}
  
  public boolean onLongClick(View paramView)
  {
    if (!this.q.getScreenScroller().d()) {
      return false;
    }
    performLongClick();
    return true;
  }
  
  public void onPause(int paramInt) {}
  
  public void onRemove(int paramInt)
  {
    super.onRemove(paramInt);
    this.r.b();
    this.a.unregisterReceiver(this.w);
    this.a.unregisterReceiver(this.x);
    try
    {
      this.t.b(this.u);
      this.a.unbindService(this.v);
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
      this.e = ((bk)paramWidgetScrollGroup).c();
      if (this.t == null) {}
    }
    try
    {
      this.t.a(3, this.d, this.e);
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
    this.o = true;
    if (paramBundle != null)
    {
      this.d = paramBundle.getInt("gowidget_Id");
      this.n = paramBundle.getBoolean("gowidget_add_to_screen");
    }
    this.a.bindService(new Intent(this.a, WeatherService.class), this.v, 1);
    if (!this.p)
    {
      paramBundle = com.gau.go.launcherex.gowidget.weather.e.h.a(getContext(), this.d);
      if (TextUtils.isEmpty(paramBundle)) {
        break label162;
      }
      if (!paramBundle.equals("app_widget_theme_white")) {
        break label120;
      }
      this.h = getContext().getPackageName();
      this.i = 0;
    }
    for (;;)
    {
      a(this.h);
      return;
      label120:
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
        label162:
        this.h = getContext().getPackageName();
        this.i = 0;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/WeatherWidget21.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */