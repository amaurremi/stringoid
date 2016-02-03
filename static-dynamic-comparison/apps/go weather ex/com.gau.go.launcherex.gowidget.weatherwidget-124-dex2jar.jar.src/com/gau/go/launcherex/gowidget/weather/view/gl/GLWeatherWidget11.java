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
import com.gau.go.launcherex.gowidget.weather.f.a;
import com.gau.go.launcherex.gowidget.weather.f.b;
import com.gau.go.launcherex.gowidget.weather.model.WeatherBean;
import com.gau.go.launcherex.gowidget.weather.model.WidgetSettingBean;
import com.gau.go.launcherex.gowidget.weather.scroller.GLWidgetScrollGroup;
import com.gau.go.launcherex.gowidget.weather.service.WeatherService;
import com.gau.go.launcherex.gowidget.weather.util.p;
import com.gau.go.launcherex.gowidget.weather.util.r;
import com.gau.go.launcherex.gowidget.weather.view.dh;
import com.go.gl.view.GLView;
import com.go.gl.view.GLView.OnLongClickListener;
import com.go.gowidget.core.WidgetCallback;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

public class GLWeatherWidget11
  extends GLGoWidgetFrame
  implements com.gau.go.launcherex.gowidget.weather.scroller.e, GLView.OnLongClickListener
{
  private int a = 0;
  private String b;
  private int c;
  private a d = null;
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
  private GLWidgetScrollGroup n = null;
  private com.gau.go.launcherex.gowidget.weather.c.g o = null;
  private g p;
  private com.gau.go.launcherex.gowidget.weather.service.f q;
  private com.gau.go.launcherex.gowidget.weather.service.c r;
  private ServiceConnection s = null;
  private final BroadcastReceiver t = new e(this);
  private final BroadcastReceiver u = new f(this);
  
  public GLWeatherWidget11(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  private GLWeather11 a(WeatherBean paramWeatherBean)
  {
    GLWeather11 localGLWeather11 = g();
    localGLWeather11.setWeatherBean(paramWeatherBean);
    this.n.addView(localGLWeather11);
    this.n.notifyViewsChanged();
    return localGLWeather11;
  }
  
  private void a()
  {
    this.s = new c(this);
    this.p = new g(this);
    b();
    this.o = new com.gau.go.launcherex.gowidget.weather.c.g(getContext());
    this.e = getContext().getPackageName();
  }
  
  private void a(Bundle paramBundle)
  {
    boolean bool2 = true;
    boolean bool3 = true;
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
        localWidgetSettingBean = this.mSettings;
        if (r.a(paramBundle, "isCycle") == 1) {}
        for (bool1 = bool2;; bool1 = false)
        {
          localWidgetSettingBean.f = bool1;
          b(this.mSettings.f);
          return;
        }
      }
      if (paramBundle.containsKey("tempUnit"))
      {
        this.mSettings.a = r.a(paramBundle, "tempUnit");
        i();
        return;
      }
      if (paramBundle.containsKey("go_widget_theme"))
      {
        this.e = paramBundle.getString("go_widget_theme");
        b(this.e);
        return;
      }
    } while (!paramBundle.containsKey("auto_location"));
    WidgetSettingBean localWidgetSettingBean = this.mSettings;
    if (r.a(paramBundle, "auto_location") == 1) {}
    for (bool1 = bool3;; bool1 = false)
    {
      localWidgetSettingBean.i = bool1;
      if (this.mSettings.i) {
        break;
      }
      j();
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
      this.n.removeAllViews();
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        a((WeatherBean)paramList.next());
      }
      this.n.notifyViewsChanged();
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
    this.mSettings.h = paramBoolean;
    if ((this.mSettings.h) && (!this.mIsPro)) {
      return;
    }
    this.o.a(this.mSettings.h);
    d();
  }
  
  private boolean a(String paramString)
  {
    String str = getContext().getPackageName().substring("com.gau.go.launcherex.gowidget.".length());
    paramString = "widget_" + str + ".xml";
    Object localObject = com.gau.go.launcherex.gowidget.weather.f.g.a(getContext(), this.e, paramString);
    paramString = (String)localObject;
    if (localObject == null)
    {
      paramString = "widget_" + str;
      paramString = com.gau.go.launcherex.gowidget.weather.f.g.b(getContext(), this.e, paramString);
    }
    if (paramString == null) {
      return false;
    }
    localObject = com.gau.go.launcherex.gowidget.weather.f.g.a(paramString);
    this.d = new a();
    this.d.a = this.e;
    this.d.a("widget_style", String.valueOf(2));
    this.d.a("widget_theme_type", String.valueOf(this.f));
    if (localObject != null) {
      new b().a((XmlPullParser)localObject, this.d);
    }
    try
    {
      paramString.close();
      try
      {
        this.g = getContext().getPackageManager().getResourcesForApplication(this.e);
        this.d.b = this.g;
        paramString = this.d.a("gw_weather_11_bg");
        paramString = b.a(this.g, paramString, this.e);
        this.n.setBackgroundDrawable(paramString);
        paramString = this.n.getCitys().iterator();
        while (paramString.hasNext()) {
          ((GLWeather11)paramString.next()).onApplyTheme(this.d);
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
  
  private void b()
  {
    this.r = new d(this);
  }
  
  private void b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Message localMessage = this.p.obtainMessage();
      localMessage.what = 9;
      localMessage.obj = paramString;
      this.p.sendMessage(localMessage);
    }
  }
  
  private void b(boolean paramBoolean)
  {
    this.n.setCycleMode(paramBoolean);
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
    localIntentFilter.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_RELOAD_DATA");
    localIntentFilter.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_DATA_READY");
    localIntentFilter.setPriority(1006);
    getContext().registerReceiver(this.t, localIntentFilter);
    localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.PACKAGE_DATA_CLEARED");
    localIntentFilter.addDataScheme("package");
    getContext().registerReceiver(this.u, localIntentFilter);
  }
  
  private void d()
  {
    Iterator localIterator = this.n.getCitys().iterator();
    while (localIterator.hasNext()) {
      ((GLWeather11)localIterator.next()).updateAllViews();
    }
  }
  
  private void e()
  {
    try
    {
      this.b = this.q.a(this.a);
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
  
  private void f()
  {
    int i3 = this.n.getChildCount();
    if (i3 < 1) {
      return;
    }
    int i1 = 0;
    label16:
    if (i1 < i3)
    {
      WeatherBean localWeatherBean = ((GLWeather11)this.n.getChildAt(i1)).getWeatherBean();
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
      this.n.setCurScreen(i2);
      this.c = i2;
      return;
      i1 += 1;
      break label16;
      i1 = -1;
    }
  }
  
  private GLWeather11 g()
  {
    GLWeather11 localGLWeather11 = new GLWeather11(this.mContext);
    localGLWeather11.setTimeManager(this.o);
    localGLWeather11.setOnLongClickListener(this);
    localGLWeather11.setWidgetView(this);
    localGLWeather11.setTip(this.mContext.getString(2131166457));
    if (this.d != null) {
      localGLWeather11.onApplyTheme(this.d);
    }
    return localGLWeather11;
  }
  
  private void h()
  {
    Iterator localIterator = this.n.getCitys().iterator();
    while (localIterator.hasNext())
    {
      GLWeather11 localGLWeather11 = (GLWeather11)localIterator.next();
      if (localGLWeather11.isEmptyCity())
      {
        this.n.removeView(localGLWeather11);
        a(localGLWeather11);
      }
    }
    this.n.notifyViewsChanged();
  }
  
  private void i()
  {
    Iterator localIterator = this.n.getCitys().iterator();
    while (localIterator.hasNext()) {
      ((GLWeather11)localIterator.next()).showTemp(this.mSettings.a);
    }
  }
  
  private void j()
  {
    Object localObject = this.n.getCitys();
    Iterator localIterator = ((ArrayList)localObject).iterator();
    GLWeather11 localGLWeather11;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localGLWeather11 = (GLWeather11)localIterator.next();
    } while (localGLWeather11.getWeatherBean().e() == 1);
    for (;;)
    {
      if (localGLWeather11 != null)
      {
        if ((localGLWeather11.getMyLocation() != 3) && (((ArrayList)localObject).size() != 1)) {
          break label72;
        }
        localGLWeather11.setMyLocation(1);
      }
      label72:
      int i1;
      do
      {
        return;
        localObject = this.n.getChildAt(this.c);
        this.n.removeView(localGLWeather11);
        a(localGLWeather11);
        this.n.notifyViewsChanged();
        i1 = this.n.indexOfChild((GLView)localObject);
      } while (i1 == -1);
      this.n.setCurScreen(i1);
      return;
      localGLWeather11 = null;
    }
  }
  
  private void k()
  {
    this.j = true;
    this.n.removeAllViews();
    a(null).setTip(this.mContext.getString(2131166455));
  }
  
  public GLView getContentView()
  {
    return this;
  }
  
  public int getVersion()
  {
    return 0;
  }
  
  public void gotoWeatherDetail(String paramString)
  {
    paramString = p.a(this.mContext, paramString, true, 7, "", -1);
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
  
  protected void initWidget(WidgetSettingBean paramWidgetSettingBean, List paramList, String paramString)
  {
    this.mSettings = paramWidgetSettingBean;
    this.n.setCycleMode(this.mSettings.f);
    this.mIsPro = this.q.d();
    paramWidgetSettingBean = this.o;
    if ((this.mIsPro) && (this.mSettings.h)) {}
    for (boolean bool = true;; bool = false)
    {
      paramWidgetSettingBean.a(bool);
      a(paramList);
      e();
      return;
    }
  }
  
  public boolean onActivate(boolean paramBoolean, Bundle paramBundle)
  {
    return false;
  }
  
  public boolean onApplyTheme(Bundle paramBundle)
  {
    this.m = true;
    String str = paramBundle.getString("gowidget_theme");
    this.f = paramBundle.getInt("gowidget_themeid");
    this.a = paramBundle.getInt("gowidget_Id");
    if (this.f == 1) {
      this.f = 0;
    }
    boolean bool1;
    if (this.l)
    {
      if ((str.equals(getContext().getPackageName())) || ("app_widget_theme_white".equals(str)) || ("app_widget_theme_black".equals(str)))
      {
        this.e = getContext().getPackageName();
        paramBundle = "app_widget_theme_white";
        this.f = 0;
      }
      while (!com.gau.go.launcherex.gowidget.weather.e.h.a(this.mContext, this.a, paramBundle))
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
      this.n.requestLayout();
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
    this.o.a(true);
    ArrayList localArrayList = this.n.getCitys();
    int i1 = 0;
    if (i1 < localArrayList.size())
    {
      GLWeather11 localGLWeather11 = (GLWeather11)localArrayList.get(i1);
      if (i1 == this.n.getCurScreen()) {
        localGLWeather11.showWeatherInfo(true);
      }
      for (;;)
      {
        i1 += 1;
        break;
        localGLWeather11.showWeatherInfo(false);
      }
    }
  }
  
  public void onClearMemory() {}
  
  public boolean onDeactivate(boolean paramBoolean, Bundle paramBundle)
  {
    return false;
  }
  
  public void onDelete()
  {
    super.onDelete();
    com.gau.go.launcherex.gowidget.weather.e.h.b(getContext(), this.a);
    if (this.q != null) {}
    try
    {
      this.q.b(this.a);
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
    this.n = ((GLWidgetScrollGroup)findViewById(2131231977));
    this.n.setEventListener(this);
    c();
    a(null);
  }
  
  public void onLeave() {}
  
  public boolean onLongClick(GLView paramGLView)
  {
    if (!this.n.getScreenScroller().d()) {
      return false;
    }
    performLongClick();
    return true;
  }
  
  public void onRemove()
  {
    super.onRemove();
    this.o.b();
    this.mContext.unregisterReceiver(this.t);
    this.mContext.unregisterReceiver(this.u);
    try
    {
      this.q.b(this.r);
      this.mContext.unbindService(this.s);
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
      this.b = ((GLWeather11)paramGLWidgetScrollGroup).getCityId();
      if (this.q == null) {}
    }
    try
    {
      this.q.a(2, this.a, this.b);
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
    this.l = true;
    if (paramBundle != null)
    {
      this.a = paramBundle.getInt("gowidget_Id");
      this.k = paramBundle.getBoolean("gowidget_add_to_screen");
    }
    this.mContext.bindService(new Intent(this.mContext, WeatherService.class), this.s, 1);
    if (!this.m)
    {
      paramBundle = com.gau.go.launcherex.gowidget.weather.e.h.a(getContext(), this.a);
      if (TextUtils.isEmpty(paramBundle)) {
        break label162;
      }
      if (!paramBundle.equals("app_widget_theme_white")) {
        break label120;
      }
      this.e = getContext().getPackageName();
      this.f = 0;
    }
    for (;;)
    {
      a(this.e);
      return;
      label120:
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
        label162:
        this.e = getContext().getPackageName();
        this.f = 0;
      }
    }
  }
  
  public void onStop() {}
  
  public void setWidgetCallback(WidgetCallback paramWidgetCallback) {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/gl/GLWeatherWidget11.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */