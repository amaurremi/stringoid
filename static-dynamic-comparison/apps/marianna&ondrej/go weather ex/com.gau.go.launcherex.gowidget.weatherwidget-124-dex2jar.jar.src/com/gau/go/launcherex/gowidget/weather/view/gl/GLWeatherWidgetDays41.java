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
import com.gau.go.launcherex.gowidget.billing.BillingActivity;
import com.gau.go.launcherex.gowidget.framework.GLGoWidgetFrame;
import com.gau.go.launcherex.gowidget.weather.model.NowBean;
import com.gau.go.launcherex.gowidget.weather.model.RequestBean;
import com.gau.go.launcherex.gowidget.weather.model.WeatherBean;
import com.gau.go.launcherex.gowidget.weather.model.WidgetSettingBean;
import com.gau.go.launcherex.gowidget.weather.scroller.GLWidgetScrollGroup;
import com.gau.go.launcherex.gowidget.weather.service.WeatherService;
import com.gau.go.launcherex.gowidget.weather.service.c;
import com.gau.go.launcherex.gowidget.weather.service.f;
import com.gau.go.launcherex.gowidget.weather.systemwidget.al;
import com.gau.go.launcherex.gowidget.weather.util.p;
import com.gau.go.launcherex.gowidget.weather.util.r;
import com.gau.go.launcherex.gowidget.weather.view.dh;
import com.gau.go.launcherex.gowidget.weather.view.w;
import com.go.gl.animation.Animation;
import com.go.gl.animation.Translate3DAnimation;
import com.go.gl.view.GLView;
import com.go.gl.view.GLView.OnClickListener;
import com.go.gl.view.GLView.OnLongClickListener;
import com.go.gowidget.core.WidgetCallback;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

public class GLWeatherWidgetDays41
  extends GLGoWidgetFrame
  implements com.gau.go.launcherex.gowidget.weather.scroller.e, GLView.OnClickListener, GLView.OnLongClickListener
{
  private int a = 0;
  private com.gau.go.launcherex.gowidget.weather.f.a b = null;
  private String c = "";
  private int d = 0;
  private Resources e = null;
  private String f;
  private int g;
  private boolean h;
  private boolean i = true;
  private boolean j;
  private boolean k;
  private GLWidgetScrollGroup l = null;
  private GLView m;
  protected boolean mIsPro;
  protected WidgetSettingBean mSettings = new WidgetSettingBean();
  private Animation n;
  private al o;
  private com.gau.go.launcherex.gowidget.weather.c.g p = null;
  private ak q;
  private f r;
  private c s;
  private ServiceConnection t = null;
  private boolean u;
  private boolean v;
  private boolean w;
  private final BroadcastReceiver x = new ai(this);
  private final BroadcastReceiver y = new aj(this);
  
  public GLWeatherWidgetDays41(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  private GLWeatherDays41 a(WeatherBean paramWeatherBean)
  {
    GLWeatherDays41 localGLWeatherDays41 = f();
    localGLWeatherDays41.setWeatherBean(paramWeatherBean, true);
    this.l.getChildCount();
    this.l.addView(localGLWeatherDays41);
    this.l.notifyViewsChanged();
    return localGLWeatherDays41;
  }
  
  private void a()
  {
    this.t = new ag(this);
    this.q = new ak(this);
    h();
    this.p = new com.gau.go.launcherex.gowidget.weather.c.g(getContext());
    this.c = getContext().getPackageName();
    this.o = new al(this.mContext);
    this.n = new Translate3DAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F, 1, 0.0F, 1, 0.0F);
    this.n.setDuration(500L);
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
        localWidgetSettingBean = this.mSettings;
        if (r.a(paramBundle, "isCycle") == 1) {}
        for (bool1 = bool2;; bool1 = false)
        {
          localWidgetSettingBean.f = bool1;
          c(this.mSettings.f);
          return;
        }
      }
      if (paramBundle.containsKey("tempUnit"))
      {
        this.mSettings.a = r.a(paramBundle, "tempUnit");
        i();
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
        this.c = paramBundle.getString("go_widget_theme");
        b(this.c);
        return;
      }
      if (paramBundle.containsKey("auto_location"))
      {
        localWidgetSettingBean = this.mSettings;
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
    } while (!paramBundle.containsKey("dynamic_icon_gowidget"));
    WidgetSettingBean localWidgetSettingBean = this.mSettings;
    if (r.a(paramBundle, "dynamic_icon_gowidget") == 1) {}
    for (bool1 = bool4;; bool1 = false)
    {
      localWidgetSettingBean.g = bool1;
      return;
    }
  }
  
  private void a(WidgetSettingBean paramWidgetSettingBean, List paramList, String paramString)
  {
    this.mSettings = paramWidgetSettingBean;
    this.l.setCycleMode(this.mSettings.f);
    this.mIsPro = this.r.d();
    paramWidgetSettingBean = this.p;
    if ((this.mIsPro) && (this.mSettings.h)) {}
    for (boolean bool = true;; bool = false)
    {
      paramWidgetSettingBean.a(bool);
      a(paramList);
      d();
      a(this.r.e());
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
      this.l.removeAllViews();
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        a((WeatherBean)paramList.next());
      }
      this.l.notifyViewsChanged();
    }
    for (;;)
    {
      b();
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
      this.m.setVisibility(0);
      this.m.startAnimation(this.n);
      return;
    }
    this.m.setVisibility(8);
  }
  
  private boolean a(String paramString)
  {
    Object localObject2 = getContext().getPackageName().substring("com.gau.go.launcherex.gowidget.".length());
    Object localObject1 = "widget_" + (String)localObject2 + ".xml";
    localObject1 = com.gau.go.launcherex.gowidget.weather.f.g.a(getContext(), paramString, (String)localObject1);
    if (localObject1 == null)
    {
      localObject1 = "widget_" + (String)localObject2;
      localObject1 = com.gau.go.launcherex.gowidget.weather.f.g.b(getContext(), this.c, (String)localObject1);
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
      ((com.gau.go.launcherex.gowidget.weather.f.a)localObject2).a("widget_theme_type", String.valueOf(this.d));
      if (localXmlPullParser != null) {}
      for (boolean bool = new com.gau.go.launcherex.gowidget.weather.f.e().a(localXmlPullParser, (com.gau.go.launcherex.gowidget.weather.f.a)localObject2);; bool = false) {
        try
        {
          ((InputStream)localObject1).close();
          if (!bool) {
            break;
          }
          this.b = ((com.gau.go.launcherex.gowidget.weather.f.a)localObject2);
          try
          {
            this.e = getContext().getPackageManager().getResourcesForApplication(paramString);
            this.b.b = this.e;
            localObject1 = this.b.a("gw_weather_days_41_bg");
            paramString = com.gau.go.launcherex.gowidget.weather.f.e.a(this.e, (String)localObject1, paramString);
            this.l.setBackgroundDrawable(paramString);
            paramString = this.l.getCitys().iterator();
            while (paramString.hasNext()) {
              ((GLWeatherDays41)paramString.next()).onApplyTheme(this.b);
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
  
  private void b()
  {
    Iterator localIterator = this.l.getCitys().iterator();
    while (localIterator.hasNext()) {
      ((GLWeatherDays41)localIterator.next()).updateAllViews();
    }
  }
  
  private void b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Message localMessage = this.q.obtainMessage();
      localMessage.what = 9;
      localMessage.obj = paramString;
      this.q.sendMessage(localMessage);
    }
  }
  
  private void b(boolean paramBoolean)
  {
    this.mSettings.h = paramBoolean;
    if ((this.mSettings.h) && (!this.mIsPro)) {
      return;
    }
    this.p.a(this.mSettings.h);
    b();
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
    getContext().registerReceiver(this.x, localIntentFilter);
    localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.PACKAGE_DATA_CLEARED");
    localIntentFilter.addDataScheme("package");
    getContext().registerReceiver(this.y, localIntentFilter);
  }
  
  private void c(boolean paramBoolean)
  {
    this.l.setCycleMode(paramBoolean);
  }
  
  private void d()
  {
    try
    {
      this.f = this.r.a(this.a);
      if (!TextUtils.isEmpty(this.f)) {
        e();
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
  
  private void d(boolean paramBoolean)
  {
    Iterator localIterator = this.l.getCitys().iterator();
    while (localIterator.hasNext()) {
      ((GLWeatherDays41)localIterator.next()).showProgerssView(paramBoolean);
    }
  }
  
  private void e()
  {
    int i3 = this.l.getChildCount();
    if (i3 < 1) {
      return;
    }
    int i1 = 0;
    label16:
    if (i1 < i3)
    {
      WeatherBean localWeatherBean = ((GLWeatherDays41)this.l.getChildAt(i1)).getWeatherBean();
      if ((localWeatherBean == null) || (TextUtils.isEmpty(localWeatherBean.c())) || (!localWeatherBean.c().equals(this.f))) {}
    }
    for (;;)
    {
      int i2 = i1;
      if (i1 == -1) {
        i2 = this.g % i3;
      }
      if ((i3 <= 0) || (i2 >= i3)) {
        break;
      }
      this.l.setCurScreen(i2);
      this.g = i2;
      return;
      i1 += 1;
      break label16;
      i1 = -1;
    }
  }
  
  private GLWeatherDays41 f()
  {
    GLWeatherDays41 localGLWeatherDays41 = new GLWeatherDays41(this.mContext);
    localGLWeatherDays41.setTimeManager(this.p);
    localGLWeatherDays41.setOnLongClickListener(this);
    localGLWeatherDays41.setWidgetView(this);
    localGLWeatherDays41.setTip(this.mContext.getString(2131166457));
    if (this.b != null) {
      localGLWeatherDays41.onApplyTheme(this.b);
    }
    return localGLWeatherDays41;
  }
  
  private void g()
  {
    Iterator localIterator = this.l.getCitys().iterator();
    while (localIterator.hasNext())
    {
      GLWeatherDays41 localGLWeatherDays41 = (GLWeatherDays41)localIterator.next();
      if (localGLWeatherDays41.isEmptyCity())
      {
        this.l.removeView(localGLWeatherDays41);
        a(localGLWeatherDays41);
      }
    }
    this.l.notifyViewsChanged();
  }
  
  private void h()
  {
    this.s = new ah(this);
  }
  
  private void i()
  {
    Iterator localIterator = this.l.getCitys().iterator();
    while (localIterator.hasNext()) {
      ((GLWeatherDays41)localIterator.next()).refreshTemp();
    }
  }
  
  private void j()
  {
    Object localObject = this.l.getCitys();
    Iterator localIterator = ((ArrayList)localObject).iterator();
    GLWeatherDays41 localGLWeatherDays41;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localGLWeatherDays41 = (GLWeatherDays41)localIterator.next();
    } while (localGLWeatherDays41.getWeatherBean().e() == 1);
    for (;;)
    {
      if (localGLWeatherDays41 != null)
      {
        if ((localGLWeatherDays41.getMyLocation() != 3) && (((ArrayList)localObject).size() != 1)) {
          break label72;
        }
        localGLWeatherDays41.setMyLocation(1);
      }
      label72:
      int i1;
      do
      {
        return;
        localObject = this.l.getChildAt(this.g);
        this.l.removeView(localGLWeatherDays41);
        a(localGLWeatherDays41);
        this.l.notifyViewsChanged();
        i1 = this.l.indexOfChild((GLView)localObject);
      } while (i1 == -1);
      this.l.setCurScreen(i1);
      return;
      localGLWeatherDays41 = null;
    }
  }
  
  private void k()
  {
    Iterator localIterator = this.l.getCitys().iterator();
    while (localIterator.hasNext()) {
      ((GLWeatherDays41)localIterator.next()).syncTime(true);
    }
  }
  
  private void l()
  {
    ArrayList localArrayList = this.l.getCitys();
    int i2 = localArrayList.size();
    int i1 = 0;
    if (i1 < i2)
    {
      GLWeatherDays41 localGLWeatherDays41 = (GLWeatherDays41)localArrayList.get(i1);
      localGLWeatherDays41.syncTime(true);
      if (this.l.getCurScreen() == i1) {
        localGLWeatherDays41.showWeatherInfo(true);
      }
      for (;;)
      {
        i1 += 1;
        break;
        localGLWeatherDays41.showWeatherInfo(false);
      }
    }
  }
  
  private void m()
  {
    this.k = true;
    Object localObject = this.l.getCitys().iterator();
    while (((Iterator)localObject).hasNext())
    {
      GLWeatherDays41 localGLWeatherDays41 = (GLWeatherDays41)((Iterator)localObject).next();
      this.l.removeView(localGLWeatherDays41);
      a(localGLWeatherDays41);
    }
    localObject = a(null);
    ((GLWeatherDays41)localObject).setTip(this.mContext.getString(2131166455));
    ((GLWeatherDays41)localObject).syncTime(true);
    this.l.setCurScreen(0);
  }
  
  public void doRefresh()
  {
    Object localObject = this.l.getCitys();
    if ((((ArrayList)localObject).size() == 1) && (((GLWeatherDays41)((ArrayList)localObject).get(0)).isEmptyCity())) {}
    ArrayList localArrayList;
    do
    {
      return;
      localArrayList = new ArrayList();
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        WeatherBean localWeatherBean = ((GLWeatherDays41)((Iterator)localObject).next()).getWeatherBean();
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
    this.mContext.startService((Intent)localObject);
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
    return this.p;
  }
  
  public int getVersion()
  {
    return 0;
  }
  
  public int getWidgetId()
  {
    return this.a;
  }
  
  public void gotoBilling()
  {
    Intent localIntent = new Intent();
    localIntent.setClass(this.mContext, BillingActivity.class);
    localIntent.setFlags(268435456);
    localIntent.putExtra("recommend_type", 4);
    localIntent.putExtra("recommend_enterance", 12);
    this.mContext.startActivity(localIntent);
  }
  
  public void gotoCalendar()
  {
    this.o.a(this.mSettings.e);
  }
  
  public void gotoClock()
  {
    this.o.b(this.mSettings.d);
  }
  
  public void gotoThemeSetting()
  {
    w.a(this.mContext, 20);
  }
  
  public void gotoWeatherDetail(String paramString)
  {
    paramString = p.a(getContext(), paramString, true, 5, "", -1);
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
    this.w = true;
    String str = paramBundle.getString("gowidget_theme");
    this.d = paramBundle.getInt("gowidget_themeid");
    this.a = paramBundle.getInt("gowidget_Id");
    if (this.d == 1) {
      this.d = 0;
    }
    if (this.v)
    {
      if ((str.equals(getContext().getPackageName())) || ("app_widget_theme_white".equals(str)) || ("app_widget_theme_black".equals(str)))
      {
        this.c = getContext().getPackageName();
        paramBundle = "app_widget_theme_white";
        this.d = 0;
      }
      while (!com.gau.go.launcherex.gowidget.weather.e.h.a(getContext(), this.a, paramBundle))
      {
        return false;
        this.c = str;
        paramBundle = str;
      }
    }
    paramBundle = com.gau.go.launcherex.gowidget.weather.e.h.a(getContext(), this.a);
    if (!TextUtils.isEmpty(paramBundle)) {
      if (paramBundle.equals("app_widget_theme_white"))
      {
        this.c = getContext().getPackageName();
        this.d = 0;
      }
    }
    for (;;)
    {
      return a(this.c);
      if (paramBundle.equals("app_widget_theme_black"))
      {
        this.c = getContext().getPackageName();
        this.d = 0;
      }
      else
      {
        this.c = paramBundle;
        this.d = 0;
        continue;
        this.c = str;
      }
    }
  }
  
  public void onBillingStatusChange(boolean paramBoolean)
  {
    this.mIsPro = paramBoolean;
    this.mSettings.h = this.mIsPro;
    this.p.a(this.mIsPro);
    b();
  }
  
  public void onClearMemory() {}
  
  public void onClick(GLView paramGLView)
  {
    if (paramGLView.equals(this.m)) {
      w.a(this.mContext, 31);
    }
  }
  
  public boolean onDeactivate(boolean paramBoolean, Bundle paramBundle)
  {
    return false;
  }
  
  public void onDelete()
  {
    super.onDelete();
    com.gau.go.launcherex.gowidget.weather.e.h.b(getContext(), this.a);
    if (this.r != null) {}
    try
    {
      this.r.b(this.a);
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
    this.l = ((GLWidgetScrollGroup)findViewById(2131231977));
    this.l.setEventListener(this);
    this.m = findViewById(2131231996);
    this.m.setOnClickListener(this);
    c();
    a(null);
  }
  
  public void onLeave() {}
  
  public boolean onLongClick(GLView paramGLView)
  {
    if (!this.l.getScreenScroller().d()) {
      return false;
    }
    performLongClick();
    return true;
  }
  
  public void onRemove()
  {
    super.onRemove();
    this.p.b();
    getContext().unregisterReceiver(this.x);
    getContext().unregisterReceiver(this.y);
    try
    {
      this.r.b(this.s);
      this.mContext.unbindService(this.t);
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
    this.g = paramInt;
    paramGLWidgetScrollGroup = (GLWidgetChildView)paramGLWidgetScrollGroup.getChildAt(this.g);
    if ((paramGLWidgetScrollGroup != null) && (paramGLWidgetScrollGroup.getChildViewType() == dh.a))
    {
      this.f = ((GLWeatherDays41)paramGLWidgetScrollGroup).getCityId();
      if (this.r == null) {}
    }
    try
    {
      this.r.a(4, this.a, this.f);
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
    this.v = true;
    if (paramBundle == null) {}
    do
    {
      return;
      this.u = paramBundle.getBoolean("gowidget_add_to_screen");
      this.a = paramBundle.getInt("gowidget_Id");
      this.mContext.bindService(new Intent(this.mContext, WeatherService.class), this.t, 1);
    } while (this.w);
    paramBundle = com.gau.go.launcherex.gowidget.weather.e.h.a(getContext(), this.a);
    if (!TextUtils.isEmpty(paramBundle)) {
      if (paramBundle.equals("app_widget_theme_white"))
      {
        this.c = this.mContext.getPackageName();
        this.d = 0;
      }
    }
    for (;;)
    {
      a(this.c);
      return;
      if (paramBundle.equals("app_widget_theme_black"))
      {
        this.c = this.mContext.getPackageName();
        this.d = 0;
      }
      else
      {
        this.c = paramBundle;
        this.d = 0;
        continue;
        this.c = getContext().getPackageName();
        this.d = 0;
      }
    }
  }
  
  public void onStop() {}
  
  public void setWidgetCallback(WidgetCallback paramWidgetCallback) {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/gl/GLWeatherWidgetDays41.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */