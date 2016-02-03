package com.gau.go.launcherex.gowidget.weather.view.gl;

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
import com.gau.go.launcherex.gowidget.framework.GLGoWidgetFrame;
import com.gau.go.launcherex.gowidget.weather.model.NowBean;
import com.gau.go.launcherex.gowidget.weather.model.RequestBean;
import com.gau.go.launcherex.gowidget.weather.model.WeatherBean;
import com.gau.go.launcherex.gowidget.weather.model.WidgetSettingBean;
import com.gau.go.launcherex.gowidget.weather.scroller.GLWidgetScrollGroup;
import com.gau.go.launcherex.gowidget.weather.service.NotifyService;
import com.gau.go.launcherex.gowidget.weather.service.WeatherService;
import com.gau.go.launcherex.gowidget.weather.service.f;
import com.gau.go.launcherex.gowidget.weather.systemwidget.al;
import com.gau.go.launcherex.gowidget.weather.view.dh;
import com.gau.go.launcherex.gowidget.weather.view.w;
import com.go.gl.animation.Translate3DAnimation;
import com.go.gl.view.GLView;
import com.go.gl.view.GLView.OnClickListener;
import com.go.gl.view.GLView.OnLongClickListener;
import com.go.gl.widget.GLTextViewWrapper;
import com.go.gowidget.core.WidgetCallback;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

public class GLWeatherWidget41
  extends GLGoWidgetFrame
  implements com.gau.go.launcherex.gowidget.weather.scroller.e, GLView.OnClickListener, GLView.OnLongClickListener
{
  private r A;
  private f B;
  private com.gau.go.launcherex.gowidget.weather.service.c C;
  private ServiceConnection D = null;
  private Translate3DAnimation E;
  private final BroadcastReceiver F = new p(this);
  private final BroadcastReceiver G = new q(this);
  private int a = 0;
  private String b;
  private int c;
  private com.gau.go.launcherex.gowidget.weather.f.a d = null;
  private String e = "";
  private int f = 0;
  private Resources g = null;
  private boolean h;
  private boolean i = true;
  private boolean j;
  private boolean k;
  private boolean l;
  private boolean m;
  protected boolean mIsPro;
  WidgetSettingBean mSettings = new WidgetSettingBean();
  private boolean n;
  private GLWidgetScrollGroup o = null;
  private GLView p;
  private GLTextViewWrapper q;
  private al r;
  private com.gau.go.launcherex.gowidget.weather.c.g s = null;
  private s t;
  private boolean u = false;
  private com.gau.go.launcherex.gowidget.weather.globaltheme.d v;
  private ArrayList w;
  private int x;
  private long y;
  private int z;
  
  public GLWeatherWidget41(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  private GLWeather41 a(WeatherBean paramWeatherBean)
  {
    GLWeather41 localGLWeather41 = h();
    localGLWeather41.setWeatherBean(paramWeatherBean);
    this.o.addView(localGLWeather41);
    this.o.notifyViewsChanged();
    return localGLWeather41;
  }
  
  private void a()
  {
    this.D = new m(this);
    this.t = new s(this);
    b();
    this.s = new com.gau.go.launcherex.gowidget.weather.c.g(getContext());
    this.e = getContext().getPackageName();
    this.r = new al(this.mContext);
    this.w = com.gau.go.launcherex.gowidget.weather.globaltheme.c.d.e(this.mContext, getResources());
    this.v = new com.gau.go.launcherex.gowidget.weather.globaltheme.d(this.mContext);
    this.E = new Translate3DAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F, 1, 0.0F, 1, 0.0F);
    this.E.setDuration(500L);
  }
  
  private void a(int paramInt)
  {
    this.s.a(1, paramInt);
    Iterator localIterator = this.o.getCitys().iterator();
    while (localIterator.hasNext())
    {
      GLWeather41 localGLWeather41 = (GLWeather41)localIterator.next();
      localGLWeather41.updateDataStyle(localGLWeather41.getCityTime());
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
      a(com.gau.go.launcherex.gowidget.weather.util.r.a(paramBundle, "dateStyle"));
    }
    do
    {
      return;
      if (paramBundle.containsKey("world_clock"))
      {
        if (com.gau.go.launcherex.gowidget.weather.util.r.a(paramBundle, "world_clock") == 1) {}
        for (;;)
        {
          c(bool1);
          return;
          bool1 = false;
        }
      }
      if (paramBundle.containsKey("isCycle"))
      {
        localWidgetSettingBean = this.mSettings;
        if (com.gau.go.launcherex.gowidget.weather.util.r.a(paramBundle, "isCycle") == 1) {}
        for (bool1 = bool2;; bool1 = false)
        {
          localWidgetSettingBean.f = bool1;
          d(this.mSettings.f);
          return;
        }
      }
      if (paramBundle.containsKey("tempUnit"))
      {
        this.mSettings.a = com.gau.go.launcherex.gowidget.weather.util.r.a(paramBundle, "tempUnit");
        k();
        return;
      }
      if (paramBundle.containsKey("widgt_calendar"))
      {
        this.mSettings.e = paramBundle.getString("widgt_calendar");
        return;
      }
      if (paramBundle.containsKey("widgt_clock"))
      {
        this.mSettings.d = paramBundle.getString("widgt_clock");
        return;
      }
      if (paramBundle.containsKey("go_widget_theme"))
      {
        this.e = paramBundle.getString("go_widget_theme");
        c(this.e);
        return;
      }
      if (paramBundle.containsKey("auto_location"))
      {
        localWidgetSettingBean = this.mSettings;
        if (com.gau.go.launcherex.gowidget.weather.util.r.a(paramBundle, "auto_location") == 1) {}
        for (bool1 = bool3;; bool1 = false)
        {
          localWidgetSettingBean.i = bool1;
          if (this.mSettings.i) {
            break;
          }
          l();
          return;
        }
      }
      if (paramBundle.containsKey("dynamic_icon_gowidget"))
      {
        localWidgetSettingBean = this.mSettings;
        if (com.gau.go.launcherex.gowidget.weather.util.r.a(paramBundle, "dynamic_icon_gowidget") == 1) {}
        for (bool1 = bool4;; bool1 = false)
        {
          localWidgetSettingBean.g = bool1;
          return;
        }
      }
    } while (!paramBundle.containsKey("widget_theme_switcher"));
    WidgetSettingBean localWidgetSettingBean = this.mSettings;
    if (com.gau.go.launcherex.gowidget.weather.util.r.a(paramBundle, "widget_theme_switcher") == 1) {}
    for (bool1 = bool5;; bool1 = false)
    {
      localWidgetSettingBean.l = bool1;
      b(this.mSettings.l);
      return;
    }
  }
  
  private void a(WidgetSettingBean paramWidgetSettingBean, List paramList, String paramString)
  {
    this.mSettings = paramWidgetSettingBean;
    this.o.setCycleMode(this.mSettings.f);
    this.mIsPro = this.B.d();
    paramWidgetSettingBean = this.s;
    if ((this.mIsPro) && (this.mSettings.h)) {}
    for (boolean bool = true;; bool = false)
    {
      paramWidgetSettingBean.a(bool);
      this.s.a(1, this.mSettings.c);
      a(paramList);
      e();
      a(this.B.e());
      b(this.mSettings.l);
      return;
    }
  }
  
  private void a(GLView paramGLView)
  {
    if (paramGLView != null) {
      paramGLView.cleanup();
    }
  }
  
  private void a(List paramList)
  {
    this.i = false;
    if (!paramList.isEmpty())
    {
      this.o.removeAllViews();
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        a((WeatherBean)paramList.next());
      }
      this.o.notifyViewsChanged();
    }
    for (;;)
    {
      d();
      return;
      this.h = true;
      paramList = new Intent("com.gau.go.launcherex.gowidget.weather.service.NotifyService");
      paramList.putExtra("notify_request", 50);
      getContext().startService(paramList);
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.p.setVisibility(0);
      this.p.startAnimation(this.E);
      return;
    }
    this.p.setVisibility(8);
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
    this.d = new com.gau.go.launcherex.gowidget.weather.f.a();
    this.d.a = paramString;
    this.d.a("widget_style", String.valueOf(1));
    this.d.a("widget_theme_type", String.valueOf(this.f));
    if (localObject2 != null) {
      new com.gau.go.launcherex.gowidget.weather.f.c().a((XmlPullParser)localObject2, this.d);
    }
    try
    {
      ((InputStream)localObject1).close();
      try
      {
        this.g = getContext().getPackageManager().getResourcesForApplication(paramString);
        this.d.b = this.g;
        localObject1 = this.d.a("gw_weather_41_bg");
        paramString = com.gau.go.launcherex.gowidget.weather.f.c.a(this.g, (String)localObject1, paramString);
        this.o.setBackgroundDrawable(paramString);
        paramString = this.o.getCitys().iterator();
        while (paramString.hasNext()) {
          ((GLWeather41)paramString.next()).onApplyTheme(this.d);
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
  
  private void b()
  {
    this.C = new n(this);
  }
  
  private void b(String paramString)
  {
    this.q.setText(paramString);
    this.q.setVisibility(0);
    paramString = new Translate3DAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F, 1, 0.0F, 1, 0.0F);
    paramString.setDuration(200L);
    this.q.startAnimation(paramString);
    this.q.postDelayed(new o(this), 3000L);
  }
  
  private void b(boolean paramBoolean)
  {
    Iterator localIterator = this.o.getCitys().iterator();
    while (localIterator.hasNext()) {
      ((GLWeather41)localIterator.next()).setThemeSwitcherVisible(paramBoolean);
    }
  }
  
  private void c()
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
    getContext().registerReceiver(this.F, localIntentFilter);
    localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.PACKAGE_DATA_CLEARED");
    localIntentFilter.addDataScheme("package");
    getContext().registerReceiver(this.G, localIntentFilter);
    this.A = new r(this, null);
    localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.PACKAGE_ADDED");
    localIntentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
    localIntentFilter.addDataScheme("package");
    this.mContext.registerReceiver(this.A, localIntentFilter);
  }
  
  private void c(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Message localMessage = this.t.obtainMessage();
      localMessage.what = 9;
      localMessage.obj = paramString;
      this.t.sendMessage(localMessage);
    }
  }
  
  private void c(boolean paramBoolean)
  {
    this.mSettings.h = paramBoolean;
    if ((this.mSettings.h) && (!this.mIsPro)) {
      return;
    }
    this.s.a(this.mSettings.h);
    d();
  }
  
  private void d()
  {
    Iterator localIterator = this.o.getCitys().iterator();
    while (localIterator.hasNext()) {
      ((GLWeather41)localIterator.next()).updateAllViews();
    }
  }
  
  private void d(boolean paramBoolean)
  {
    this.o.setCycleMode(paramBoolean);
  }
  
  private void e()
  {
    try
    {
      this.b = this.B.a(this.a);
      if (!TextUtils.isEmpty(this.b)) {
        f();
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
  
  private void e(boolean paramBoolean)
  {
    Iterator localIterator = this.o.getCitys().iterator();
    while (localIterator.hasNext()) {
      ((GLWeather41)localIterator.next()).startRefreshAni(paramBoolean);
    }
  }
  
  private void f()
  {
    int i3 = this.o.getChildCount();
    if (i3 < 1) {
      return;
    }
    int i1 = 0;
    label16:
    if (i1 < i3)
    {
      WeatherBean localWeatherBean = ((GLWeather41)this.o.getChildAt(i1)).getWeatherBean();
      if ((localWeatherBean == null) || (TextUtils.isEmpty(localWeatherBean.c())) || (!localWeatherBean.c().equals(this.b))) {}
    }
    for (;;)
    {
      int i2 = i1;
      if (i1 == -1) {
        i2 = this.c % i3;
      }
      if ((i3 <= 0) || (i2 >= i3)) {
        break;
      }
      this.o.setCurScreen(i2);
      this.c = i2;
      return;
      i1 += 1;
      break label16;
      i1 = -1;
    }
  }
  
  private void g()
  {
    if (this.e.equals(getContext().getPackageName())) {
      this.x = (this.w.size() - 1);
    }
    for (;;)
    {
      return;
      int i1 = 0;
      while (i1 < this.w.size())
      {
        com.gau.go.launcherex.gowidget.weather.globaltheme.b.e locale = (com.gau.go.launcherex.gowidget.weather.globaltheme.b.e)this.w.get(i1);
        if (this.e.equals(locale.x()))
        {
          this.x = i1;
          return;
        }
        i1 += 1;
      }
    }
  }
  
  private GLWeather41 h()
  {
    GLWeather41 localGLWeather41 = new GLWeather41(this.mContext);
    localGLWeather41.setTimeManager(this.s);
    localGLWeather41.setOnLongClickListener(this);
    localGLWeather41.setWidgetView(this);
    localGLWeather41.setTip(this.mContext.getString(2131166457));
    localGLWeather41.setTempUnit(this.mSettings.a);
    localGLWeather41.setThemeSwitcherVisible(this.mSettings.l);
    if (this.d != null) {
      localGLWeather41.onApplyTheme(this.d);
    }
    return localGLWeather41;
  }
  
  private void i()
  {
    Iterator localIterator = this.o.getCitys().iterator();
    while (localIterator.hasNext())
    {
      GLWeather41 localGLWeather41 = (GLWeather41)localIterator.next();
      if (localGLWeather41.isEmptyCity())
      {
        this.o.removeView(localGLWeather41);
        a(localGLWeather41);
      }
    }
    this.o.notifyViewsChanged();
  }
  
  private void j()
  {
    Iterator localIterator = this.o.getCitys().iterator();
    while (localIterator.hasNext()) {
      ((GLWeather41)localIterator.next()).playThemeChangeAnimation();
    }
  }
  
  private void k()
  {
    Iterator localIterator = this.o.getCitys().iterator();
    while (localIterator.hasNext()) {
      ((GLWeather41)localIterator.next()).showTemp(this.mSettings.a);
    }
  }
  
  private void l()
  {
    Object localObject = this.o.getCitys();
    Iterator localIterator = ((ArrayList)localObject).iterator();
    GLWeather41 localGLWeather41;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localGLWeather41 = (GLWeather41)localIterator.next();
    } while (localGLWeather41.getWeatherBean().e() == 1);
    for (;;)
    {
      if (localGLWeather41 != null)
      {
        if ((localGLWeather41.getMyLocation() != 3) && (((ArrayList)localObject).size() != 1)) {
          break label72;
        }
        localGLWeather41.setMyLocation(1);
      }
      label72:
      int i1;
      do
      {
        return;
        localObject = this.o.getChildAt(this.c);
        this.o.removeView(localGLWeather41);
        a(localGLWeather41);
        this.o.notifyViewsChanged();
        i1 = this.o.indexOfChild((GLView)localObject);
      } while (i1 == -1);
      this.o.setCurScreen(i1);
      return;
      localGLWeather41 = null;
    }
  }
  
  private void m()
  {
    Iterator localIterator = this.o.getCitys().iterator();
    while (localIterator.hasNext()) {
      ((GLWeather41)localIterator.next()).syncTime(true);
    }
  }
  
  private void n()
  {
    ArrayList localArrayList = this.o.getCitys();
    int i2 = localArrayList.size();
    int i1 = 0;
    if (i1 < i2)
    {
      GLWeather41 localGLWeather41 = (GLWeather41)localArrayList.get(i1);
      localGLWeather41.syncTime(true);
      if (this.o.getCurScreen() == i1) {
        localGLWeather41.showWeatherInfo(true);
      }
      for (;;)
      {
        i1 += 1;
        break;
        localGLWeather41.showWeatherInfo(false);
      }
    }
  }
  
  private void o()
  {
    this.k = true;
    Object localObject = this.o.getCitys().iterator();
    while (((Iterator)localObject).hasNext())
    {
      GLWeather41 localGLWeather41 = (GLWeather41)((Iterator)localObject).next();
      this.o.removeView(localGLWeather41);
      a(localGLWeather41);
    }
    localObject = a(null);
    ((GLWeather41)localObject).setTip(this.mContext.getString(2131166455));
    ((GLWeather41)localObject).syncTime(true);
    this.o.setCurScreen(0);
  }
  
  public GLView getContentView()
  {
    return this;
  }
  
  public com.gau.go.launcherex.gowidget.weather.widget.dynamicicon.a getDynamicIconManager()
  {
    return null;
  }
  
  public com.gau.go.launcherex.gowidget.weather.c.g getTimeManager()
  {
    return this.s;
  }
  
  public int getVersion()
  {
    return 0;
  }
  
  public int getWidgetId()
  {
    return this.a;
  }
  
  public void gotoCalendar()
  {
    this.r.a(this.mSettings.e);
  }
  
  public void gotoClock()
  {
    this.r.b(this.mSettings.d);
  }
  
  public void gotoThemeStore()
  {
    w.a(this.mContext, 20);
  }
  
  public void gotoWeatherDetail(String paramString)
  {
    paramString = com.gau.go.launcherex.gowidget.weather.util.p.a(getContext(), paramString, true, 5, "", -1);
    paramString.addFlags(67108864);
    paramString.putExtra("gowidget_Id", this.a);
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
    return this.i;
  }
  
  public boolean isLocatingCity()
  {
    return this.h;
  }
  
  public boolean onActivate(boolean paramBoolean, Bundle paramBundle)
  {
    return false;
  }
  
  public boolean onApplyTheme(Bundle paramBundle)
  {
    this.n = true;
    String str = paramBundle.getString("gowidget_theme");
    this.f = paramBundle.getInt("gowidget_themeid");
    this.a = paramBundle.getInt("gowidget_Id");
    if (this.f == 1) {
      this.f = 0;
    }
    boolean bool1;
    if (this.m)
    {
      if ((str.equals(getContext().getPackageName())) || ("app_widget_theme_white".equals(str)) || ("app_widget_theme_black".equals(str)))
      {
        this.e = getContext().getPackageName();
        paramBundle = "app_widget_theme_white";
        this.f = 0;
      }
      while (!com.gau.go.launcherex.gowidget.weather.e.h.a(getContext(), this.a, paramBundle))
      {
        bool1 = false;
        return bool1;
        this.e = str;
        paramBundle = str;
      }
    }
    paramBundle = com.gau.go.launcherex.gowidget.weather.e.h.a(getContext(), this.a);
    if (!TextUtils.isEmpty(paramBundle)) {
      if (paramBundle.equals("app_widget_theme_white"))
      {
        this.e = getContext().getPackageName();
        this.f = 0;
      }
    }
    for (;;)
    {
      boolean bool2 = a(this.e);
      bool1 = bool2;
      if (!bool2) {
        break;
      }
      this.o.requestLayout();
      return bool2;
      if (paramBundle.equals("app_widget_theme_black"))
      {
        this.e = getContext().getPackageName();
        this.f = 0;
      }
      else
      {
        this.e = paramBundle;
        this.f = 0;
        continue;
        this.e = str;
      }
    }
  }
  
  public void onBillingStatusChange(boolean paramBoolean)
  {
    this.mIsPro = paramBoolean;
    this.mSettings.h = this.mIsPro;
    this.s.a(this.mIsPro);
    d();
  }
  
  public void onClearMemory() {}
  
  public void onClick(GLView paramGLView)
  {
    if (paramGLView.equals(this.p)) {
      w.a(this.mContext, 31);
    }
    while (!paramGLView.equals(this.q)) {
      return;
    }
    w.a(this.mContext, 35);
  }
  
  public boolean onDeactivate(boolean paramBoolean, Bundle paramBundle)
  {
    return false;
  }
  
  public void onDelete()
  {
    super.onDelete();
    com.gau.go.launcherex.gowidget.weather.e.h.b(getContext(), this.a);
    if (this.B != null) {}
    try
    {
      this.B.b(this.a);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      localRemoteException.printStackTrace();
    }
  }
  
  public void onEnter() {}
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.o = ((GLWidgetScrollGroup)findViewById(2131231977));
    this.o.setEventListener(this);
    this.p = findViewById(2131231996);
    this.p.setOnClickListener(this);
    this.q = ((GLTextViewWrapper)findViewById(2131231997));
    this.q.setOnClickListener(this);
    c();
    a(null);
  }
  
  public void onLeave() {}
  
  public boolean onLongClick(GLView paramGLView)
  {
    if (!this.o.getScreenScroller().d()) {
      return false;
    }
    performLongClick();
    return true;
  }
  
  public void onRemove()
  {
    super.onRemove();
    this.s.b();
    this.mContext.unregisterReceiver(this.F);
    this.mContext.unregisterReceiver(this.G);
    this.mContext.unregisterReceiver(this.A);
    this.v.a();
    try
    {
      this.B.b(this.C);
      this.mContext.unbindService(this.D);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      localRemoteException.printStackTrace();
    }
  }
  
  public void onScrollGroupChange(GLWidgetScrollGroup paramGLWidgetScrollGroup, int paramInt) {}
  
  public void onScrollGroupFinishScroll(GLWidgetScrollGroup paramGLWidgetScrollGroup, int paramInt)
  {
    this.c = paramInt;
    paramGLWidgetScrollGroup = (GLWidgetChildView)paramGLWidgetScrollGroup.getChildAt(this.c);
    if ((paramGLWidgetScrollGroup != null) && (paramGLWidgetScrollGroup.getChildViewType() == dh.a))
    {
      this.b = ((GLWeather41)paramGLWidgetScrollGroup).getCityId();
      if (this.B == null) {}
    }
    try
    {
      this.B.a(1, this.a, this.b);
      return;
    }
    catch (RemoteException paramGLWidgetScrollGroup)
    {
      paramGLWidgetScrollGroup.printStackTrace();
    }
  }
  
  public void onScrollGroupStartScroll(GLWidgetScrollGroup paramGLWidgetScrollGroup, int paramInt) {}
  
  public void onStart(Bundle paramBundle)
  {
    this.m = true;
    if (paramBundle != null)
    {
      this.a = paramBundle.getInt("gowidget_Id");
      this.l = paramBundle.getBoolean("gowidget_add_to_screen");
    }
    this.mContext.bindService(new Intent(this.mContext, WeatherService.class), this.D, 1);
    if (!this.n)
    {
      paramBundle = com.gau.go.launcherex.gowidget.weather.e.h.a(getContext(), this.a);
      if (TextUtils.isEmpty(paramBundle)) {
        break label166;
      }
      if (!paramBundle.equals("app_widget_theme_white")) {
        break label124;
      }
      this.e = getContext().getPackageName();
      this.f = 0;
    }
    for (;;)
    {
      g();
      a(this.e);
      return;
      label124:
      if (paramBundle.equals("app_widget_theme_black"))
      {
        this.e = getContext().getPackageName();
        this.f = 0;
      }
      else
      {
        this.e = paramBundle;
        this.f = 0;
        continue;
        label166:
        this.e = getContext().getPackageName();
        this.f = 0;
      }
    }
  }
  
  public void onStop() {}
  
  public void onThemeSwitcherClick()
  {
    Intent localIntent = new Intent(this.mContext, NotifyService.class);
    localIntent.putExtra("notify_request", 51);
    this.mContext.startService(localIntent);
    int i1 = this.w.size();
    if (i1 == 1) {
      b(this.mContext.getString(2131166572));
    }
    do
    {
      return;
      long l1 = System.currentTimeMillis();
      if ((this.u) && (l1 - this.y > 180000L))
      {
        this.u = false;
        this.y = l1;
        b(this.mContext.getString(2131166573));
        return;
      }
      j();
      this.x += 1;
      this.z += 1;
      this.t.removeMessages(18);
      this.t.sendEmptyMessageDelayed(18, 450L);
    } while ((i1 != 2) || (this.z % 3 != 0));
    this.u = true;
  }
  
  public void refreshWeather()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = this.o.getCitys().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (GLWeather41)((Iterator)localObject1).next();
      if (!((GLWeather41)localObject2).isEmptyCity())
      {
        localObject2 = ((GLWeather41)localObject2).getWeatherBean();
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
      this.mContext.startService((Intent)localObject1);
    }
  }
  
  public void setWidgetCallback(WidgetCallback paramWidgetCallback) {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/gl/GLWeatherWidget41.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */