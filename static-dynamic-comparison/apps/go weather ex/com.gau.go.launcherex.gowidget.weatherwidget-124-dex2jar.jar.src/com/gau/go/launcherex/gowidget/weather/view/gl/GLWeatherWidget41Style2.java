package com.gau.go.launcherex.gowidget.weather.view.gl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.gau.go.launcherex.gowidget.framework.GLGoWidgetFrame;
import com.gau.go.launcherex.gowidget.language.b;
import com.gau.go.launcherex.gowidget.weather.c.g;
import com.gau.go.launcherex.gowidget.weather.model.NowBean;
import com.gau.go.launcherex.gowidget.weather.model.RequestBean;
import com.gau.go.launcherex.gowidget.weather.model.WeatherBean;
import com.gau.go.launcherex.gowidget.weather.model.WidgetSettingBean;
import com.gau.go.launcherex.gowidget.weather.scroller.GLWidgetScrollGroup;
import com.gau.go.launcherex.gowidget.weather.service.NotifyService;
import com.gau.go.launcherex.gowidget.weather.service.WeatherService;
import com.gau.go.launcherex.gowidget.weather.service.c;
import com.gau.go.launcherex.gowidget.weather.service.f;
import com.gau.go.launcherex.gowidget.weather.systemwidget.al;
import com.gau.go.launcherex.gowidget.weather.util.r;
import com.go.gl.animation.Translate3DAnimation;
import com.go.gl.view.GLView;
import com.go.gl.view.GLView.OnClickListener;
import com.go.gl.view.GLView.OnLongClickListener;
import com.go.gl.widget.GLTextViewWrapper;
import com.go.gowidget.core.WidgetCallback;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GLWeatherWidget41Style2
  extends GLGoWidgetFrame
  implements com.gau.go.launcherex.gowidget.weather.scroller.e, GLView.OnClickListener, GLView.OnLongClickListener
{
  private GLTextViewWrapper A;
  private boolean B = false;
  private com.gau.go.launcherex.gowidget.weather.globaltheme.d C;
  private ArrayList D;
  private int E = 0;
  private long F = 0L;
  private int G;
  private GLWeatherWidget41Style2.PackageChangeReceiver H;
  private final BroadcastReceiver I = new u(this);
  private final BroadcastReceiver J = new v(this);
  private Runnable K = new x(this);
  private int a = 0;
  private g b;
  private com.gau.go.launcherex.gowidget.weather.widget.dynamicicon.a c;
  private GLWidgetScrollGroup d;
  private GLView e;
  private Translate3DAnimation f;
  private boolean g = true;
  private boolean h = false;
  private boolean i = true;
  private final y j = new y(this);
  private String k;
  private int l;
  private boolean m;
  boolean mIsPro;
  WidgetSettingBean mSettings = new WidgetSettingBean();
  private al n;
  private z o;
  private f p;
  private c q;
  private ServiceConnection r = null;
  private boolean s;
  private com.gau.go.launcherex.gowidget.weather.f.a t = null;
  private String u = "";
  private int v = 5;
  private int w = 0;
  private Resources x = null;
  private boolean y;
  private boolean z;
  
  public GLWeatherWidget41Style2(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  private GLWeather41Style2 a(WeatherBean paramWeatherBean)
  {
    GLWeather41Style2 localGLWeather41Style2 = new GLWeather41Style2(this.mContext);
    localGLWeather41Style2.setWidgetView(this);
    localGLWeather41Style2.setOnLongClickListener(this);
    localGLWeather41Style2.setWeatherBean(paramWeatherBean);
    localGLWeather41Style2.setThemeSwitcherVisible(this.mSettings.l);
    localGLWeather41Style2.updateAllViews();
    if (this.t != null) {
      localGLWeather41Style2.onApplyTheme(this.t);
    }
    this.d.addView(localGLWeather41Style2);
    this.d.notifyViewsChanged();
    return localGLWeather41Style2;
  }
  
  private void a()
  {
    this.r = new t(this);
    this.o = new z(this);
    o();
    this.b = new g(this.mContext);
    this.u = this.mContext.getPackageName();
    this.n = new al(this.mContext);
    this.f = new Translate3DAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F, 1, 0.0F, 1, 0.0F);
    this.f.setDuration(500L);
    this.D = com.gau.go.launcherex.gowidget.weather.globaltheme.c.d.e(this.mContext, getResources());
    g();
    this.C = new com.gau.go.launcherex.gowidget.weather.globaltheme.d(this.mContext);
    getContext().startService(new Intent("com.gau.go.launcherex.gowidget.weather.service.NotifyService"));
  }
  
  private void a(int paramInt)
  {
    this.b.a(0, paramInt);
    int i1 = this.d.getChildCount();
    paramInt = 0;
    while (paramInt < i1)
    {
      ((GLWeather41Style2)this.d.getChildAt(paramInt)).updateDateWeek();
      paramInt += 1;
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
          d(bool1);
          return;
          bool1 = false;
        }
      }
      if (paramBundle.containsKey("isCycle"))
      {
        localWidgetSettingBean = this.mSettings;
        if (r.a(paramBundle, "isCycle") == 1) {}
        for (bool1 = bool2;; bool1 = false)
        {
          localWidgetSettingBean.f = bool1;
          e(this.mSettings.f);
          return;
        }
      }
      if (paramBundle.containsKey("tempUnit"))
      {
        this.mSettings.a = r.a(paramBundle, "tempUnit");
        f();
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
        this.u = paramBundle.getString("go_widget_theme");
        b(this.u);
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
          h();
          return;
        }
      }
      if (paramBundle.containsKey("dynamic_icon_gowidget"))
      {
        localWidgetSettingBean = this.mSettings;
        if (r.a(paramBundle, "dynamic_icon_gowidget") == 1) {}
        for (bool1 = bool4;; bool1 = false)
        {
          localWidgetSettingBean.g = bool1;
          return;
        }
      }
    } while (!paramBundle.containsKey("widget_theme_switcher"));
    WidgetSettingBean localWidgetSettingBean = this.mSettings;
    if (r.a(paramBundle, "widget_theme_switcher") == 1) {}
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
    this.d.setCycleMode(this.mSettings.f);
    this.mIsPro = this.p.d();
    paramWidgetSettingBean = this.b;
    if ((this.mIsPro) && (this.mSettings.h)) {}
    for (boolean bool = true;; bool = false)
    {
      paramWidgetSettingBean.a(bool);
      this.b.a(0, this.mSettings.c);
      a(paramList);
      i();
      a(this.p.e());
      b(this.mSettings.l);
      return;
    }
  }
  
  private void a(GLWeather41Style2 paramGLWeather41Style2)
  {
    if (paramGLWeather41Style2 != null) {
      paramGLWeather41Style2.cleanup();
    }
  }
  
  private void a(List paramList)
  {
    this.i = false;
    if (!paramList.isEmpty())
    {
      n();
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        a((WeatherBean)paramList.next());
      }
    }
    this.h = true;
    paramList = new Intent("com.gau.go.launcherex.gowidget.weather.service.NotifyService");
    paramList.putExtra("notify_request", 50);
    this.mContext.startService(paramList);
    k();
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.e.setVisibility(0);
      this.e.startAnimation(this.f);
      return;
    }
    this.e.setVisibility(8);
  }
  
  /* Error */
  private boolean a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 241	com/gau/go/launcherex/gowidget/weather/view/gl/GLWeatherWidget41Style2:getContext	()Landroid/content/Context;
    //   4: invokevirtual 201	android/content/Context:getPackageName	()Ljava/lang/String;
    //   7: ldc_w 405
    //   10: invokevirtual 410	java/lang/String:length	()I
    //   13: invokevirtual 414	java/lang/String:substring	(I)Ljava/lang/String;
    //   16: astore 4
    //   18: new 416	java/lang/StringBuilder
    //   21: dup
    //   22: invokespecial 417	java/lang/StringBuilder:<init>	()V
    //   25: ldc_w 419
    //   28: invokevirtual 423	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: aload 4
    //   33: invokevirtual 423	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: ldc_w 425
    //   39: invokevirtual 423	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: invokevirtual 428	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: astore_2
    //   46: aload_0
    //   47: invokevirtual 241	com/gau/go/launcherex/gowidget/weather/view/gl/GLWeatherWidget41Style2:getContext	()Landroid/content/Context;
    //   50: aload_1
    //   51: aload_2
    //   52: invokestatic 433	com/gau/go/launcherex/gowidget/weather/f/g:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/io/InputStream;
    //   55: astore_3
    //   56: aload_3
    //   57: astore_2
    //   58: aload_3
    //   59: ifnonnull +38 -> 97
    //   62: new 416	java/lang/StringBuilder
    //   65: dup
    //   66: invokespecial 417	java/lang/StringBuilder:<init>	()V
    //   69: ldc_w 419
    //   72: invokevirtual 423	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: aload 4
    //   77: invokevirtual 423	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: invokevirtual 428	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   83: astore_2
    //   84: aload_0
    //   85: invokevirtual 241	com/gau/go/launcherex/gowidget/weather/view/gl/GLWeatherWidget41Style2:getContext	()Landroid/content/Context;
    //   88: aload_0
    //   89: getfield 105	com/gau/go/launcherex/gowidget/weather/view/gl/GLWeatherWidget41Style2:u	Ljava/lang/String;
    //   92: aload_2
    //   93: invokestatic 435	com/gau/go/launcherex/gowidget/weather/f/g:b	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/io/InputStream;
    //   96: astore_2
    //   97: aload_2
    //   98: ifnonnull +5 -> 103
    //   101: iconst_0
    //   102: ireturn
    //   103: aload_2
    //   104: invokestatic 438	com/gau/go/launcherex/gowidget/weather/f/g:a	(Ljava/io/InputStream;)Lorg/xmlpull/v1/XmlPullParser;
    //   107: astore_3
    //   108: aload_0
    //   109: new 440	com/gau/go/launcherex/gowidget/weather/f/a
    //   112: dup
    //   113: invokespecial 441	com/gau/go/launcherex/gowidget/weather/f/a:<init>	()V
    //   116: putfield 101	com/gau/go/launcherex/gowidget/weather/view/gl/GLWeatherWidget41Style2:t	Lcom/gau/go/launcherex/gowidget/weather/f/a;
    //   119: aload_0
    //   120: getfield 101	com/gau/go/launcherex/gowidget/weather/view/gl/GLWeatherWidget41Style2:t	Lcom/gau/go/launcherex/gowidget/weather/f/a;
    //   123: aload_1
    //   124: putfield 443	com/gau/go/launcherex/gowidget/weather/f/a:a	Ljava/lang/String;
    //   127: aload_0
    //   128: getfield 101	com/gau/go/launcherex/gowidget/weather/view/gl/GLWeatherWidget41Style2:t	Lcom/gau/go/launcherex/gowidget/weather/f/a;
    //   131: ldc_w 445
    //   134: aload_0
    //   135: getfield 107	com/gau/go/launcherex/gowidget/weather/view/gl/GLWeatherWidget41Style2:v	I
    //   138: invokestatic 448	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   141: invokevirtual 451	com/gau/go/launcherex/gowidget/weather/f/a:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   144: aload_0
    //   145: getfield 101	com/gau/go/launcherex/gowidget/weather/view/gl/GLWeatherWidget41Style2:t	Lcom/gau/go/launcherex/gowidget/weather/f/a;
    //   148: ldc_w 453
    //   151: aload_0
    //   152: getfield 109	com/gau/go/launcherex/gowidget/weather/view/gl/GLWeatherWidget41Style2:w	I
    //   155: invokestatic 448	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   158: invokevirtual 451	com/gau/go/launcherex/gowidget/weather/f/a:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   161: aload_3
    //   162: ifnull +18 -> 180
    //   165: new 455	com/gau/go/launcherex/gowidget/weather/f/c
    //   168: dup
    //   169: invokespecial 456	com/gau/go/launcherex/gowidget/weather/f/c:<init>	()V
    //   172: aload_3
    //   173: aload_0
    //   174: getfield 101	com/gau/go/launcherex/gowidget/weather/view/gl/GLWeatherWidget41Style2:t	Lcom/gau/go/launcherex/gowidget/weather/f/a;
    //   177: invokevirtual 459	com/gau/go/launcherex/gowidget/weather/f/c:a	(Lorg/xmlpull/v1/XmlPullParser;Lcom/gau/go/launcherex/gowidget/weather/f/a;)V
    //   180: aload_2
    //   181: invokevirtual 464	java/io/InputStream:close	()V
    //   184: aload_0
    //   185: aload_0
    //   186: invokevirtual 241	com/gau/go/launcherex/gowidget/weather/view/gl/GLWeatherWidget41Style2:getContext	()Landroid/content/Context;
    //   189: invokevirtual 468	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   192: aload_1
    //   193: invokevirtual 474	android/content/pm/PackageManager:getResourcesForApplication	(Ljava/lang/String;)Landroid/content/res/Resources;
    //   196: putfield 111	com/gau/go/launcherex/gowidget/weather/view/gl/GLWeatherWidget41Style2:x	Landroid/content/res/Resources;
    //   199: aload_0
    //   200: getfield 101	com/gau/go/launcherex/gowidget/weather/view/gl/GLWeatherWidget41Style2:t	Lcom/gau/go/launcherex/gowidget/weather/f/a;
    //   203: aload_0
    //   204: getfield 111	com/gau/go/launcherex/gowidget/weather/view/gl/GLWeatherWidget41Style2:x	Landroid/content/res/Resources;
    //   207: putfield 476	com/gau/go/launcherex/gowidget/weather/f/a:b	Landroid/content/res/Resources;
    //   210: aload_0
    //   211: getfield 101	com/gau/go/launcherex/gowidget/weather/view/gl/GLWeatherWidget41Style2:t	Lcom/gau/go/launcherex/gowidget/weather/f/a;
    //   214: ldc_w 478
    //   217: invokevirtual 480	com/gau/go/launcherex/gowidget/weather/f/a:a	(Ljava/lang/String;)Ljava/lang/String;
    //   220: astore_3
    //   221: aconst_null
    //   222: astore_2
    //   223: aload_3
    //   224: invokestatic 485	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   227: ifne +13 -> 240
    //   230: aload_0
    //   231: getfield 111	com/gau/go/launcherex/gowidget/weather/view/gl/GLWeatherWidget41Style2:x	Landroid/content/res/Resources;
    //   234: aload_3
    //   235: aload_1
    //   236: invokestatic 488	com/gau/go/launcherex/gowidget/weather/f/c:a	(Landroid/content/res/Resources;Ljava/lang/String;Ljava/lang/String;)Landroid/graphics/drawable/Drawable;
    //   239: astore_2
    //   240: aload_0
    //   241: getfield 171	com/gau/go/launcherex/gowidget/weather/view/gl/GLWeatherWidget41Style2:d	Lcom/gau/go/launcherex/gowidget/weather/scroller/GLWidgetScrollGroup;
    //   244: aload_2
    //   245: invokevirtual 492	com/gau/go/launcherex/gowidget/weather/scroller/GLWidgetScrollGroup:setBackgroundDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   248: aload_0
    //   249: getfield 171	com/gau/go/launcherex/gowidget/weather/view/gl/GLWeatherWidget41Style2:d	Lcom/gau/go/launcherex/gowidget/weather/scroller/GLWidgetScrollGroup;
    //   252: invokevirtual 496	com/gau/go/launcherex/gowidget/weather/scroller/GLWidgetScrollGroup:getCitys	()Ljava/util/ArrayList;
    //   255: invokevirtual 499	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   258: astore_1
    //   259: aload_1
    //   260: invokeinterface 372 1 0
    //   265: ifeq +27 -> 292
    //   268: aload_1
    //   269: invokeinterface 376 1 0
    //   274: checkcast 138	com/gau/go/launcherex/gowidget/weather/view/gl/GLWeather41Style2
    //   277: aload_0
    //   278: getfield 101	com/gau/go/launcherex/gowidget/weather/view/gl/GLWeatherWidget41Style2:t	Lcom/gau/go/launcherex/gowidget/weather/f/a;
    //   281: invokevirtual 169	com/gau/go/launcherex/gowidget/weather/view/gl/GLWeather41Style2:onApplyTheme	(Lcom/gau/go/launcherex/gowidget/weather/f/a;)V
    //   284: goto -25 -> 259
    //   287: astore_1
    //   288: aload_1
    //   289: invokevirtual 502	android/content/pm/PackageManager$NameNotFoundException:printStackTrace	()V
    //   292: aload_0
    //   293: getfield 171	com/gau/go/launcherex/gowidget/weather/view/gl/GLWeatherWidget41Style2:d	Lcom/gau/go/launcherex/gowidget/weather/scroller/GLWidgetScrollGroup;
    //   296: invokevirtual 505	com/gau/go/launcherex/gowidget/weather/scroller/GLWidgetScrollGroup:requestLayout	()V
    //   299: iconst_1
    //   300: ireturn
    //   301: astore_2
    //   302: aload_2
    //   303: invokevirtual 506	java/io/IOException:printStackTrace	()V
    //   306: goto -122 -> 184
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	309	0	this	GLWeatherWidget41Style2
    //   0	309	1	paramString	String
    //   45	200	2	localObject1	Object
    //   301	2	2	localIOException	java.io.IOException
    //   55	180	3	localObject2	Object
    //   16	60	4	str	String
    // Exception table:
    //   from	to	target	type
    //   184	221	287	android/content/pm/PackageManager$NameNotFoundException
    //   223	240	287	android/content/pm/PackageManager$NameNotFoundException
    //   240	259	287	android/content/pm/PackageManager$NameNotFoundException
    //   259	284	287	android/content/pm/PackageManager$NameNotFoundException
    //   180	184	301	java/io/IOException
  }
  
  private void b()
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
    getContext().registerReceiver(this.I, localIntentFilter);
    localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.PACKAGE_DATA_CLEARED");
    localIntentFilter.addDataScheme("package");
    getContext().registerReceiver(this.J, localIntentFilter);
    this.H = new GLWeatherWidget41Style2.PackageChangeReceiver(this);
    localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.PACKAGE_ADDED");
    localIntentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
    localIntentFilter.addDataScheme("package");
    this.mContext.registerReceiver(this.H, localIntentFilter);
  }
  
  private void b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (c(paramString))
      {
        Message localMessage = this.j.obtainMessage();
        localMessage.what = 3;
        localMessage.obj = paramString;
        this.j.sendMessage(localMessage);
      }
    }
    else {
      return;
    }
    d(this.mContext.getString(2131166574));
  }
  
  private void b(boolean paramBoolean)
  {
    Iterator localIterator = this.d.getCitys().iterator();
    while (localIterator.hasNext()) {
      ((GLWeather41Style2)localIterator.next()).setThemeSwitcherVisible(paramBoolean);
    }
  }
  
  private void c()
  {
    Iterator localIterator = this.d.getCitys().iterator();
    while (localIterator.hasNext()) {
      ((GLWeather41Style2)localIterator.next()).notifyLanguageChanged();
    }
  }
  
  private void c(boolean paramBoolean)
  {
    int i2 = this.d.getChildCount();
    int i1 = 0;
    while (i1 < i2)
    {
      ((GLWeather41Style2)this.d.getChildAt(i1)).showProgerssView(paramBoolean);
      i1 += 1;
    }
  }
  
  private boolean c(String paramString)
  {
    Iterator localIterator = this.D.iterator();
    while (localIterator.hasNext())
    {
      com.gau.go.launcherex.gowidget.weather.globaltheme.b.e locale = (com.gau.go.launcherex.gowidget.weather.globaltheme.b.e)localIterator.next();
      if (locale.x().equals(paramString)) {
        return locale.i();
      }
    }
    return false;
  }
  
  private void d()
  {
    if (this.g)
    {
      int i2 = this.d.getChildCount();
      int i1 = 0;
      while (i1 < i2)
      {
        GLWeather41Style2 localGLWeather41Style2 = (GLWeather41Style2)this.d.getChildAt(i1);
        localGLWeather41Style2.updateTime();
        localGLWeather41Style2.updateDateWeek();
        localGLWeather41Style2.mAnimationWeatherIcon = false;
        localGLWeather41Style2.updateWeatherIcon();
        i1 += 1;
      }
    }
  }
  
  private void d(String paramString)
  {
    this.A.setText(paramString);
    this.A.setVisibility(0);
    paramString = new Translate3DAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F, 1, 0.0F, 1, 0.0F);
    paramString.setDuration(200L);
    this.A.startAnimation(paramString);
    this.A.removeCallbacks(this.K);
    this.A.postDelayed(this.K, 3000L);
  }
  
  private void d(boolean paramBoolean)
  {
    Message localMessage = this.j.obtainMessage();
    localMessage.what = 2;
    localMessage.obj = Boolean.valueOf(paramBoolean);
    this.j.sendMessage(localMessage);
  }
  
  private void e()
  {
    this.m = true;
    n();
    a(null);
  }
  
  private void e(boolean paramBoolean)
  {
    this.d.setCycleMode(paramBoolean);
  }
  
  private void f()
  {
    int i2 = this.d.getChildCount();
    int i1 = 0;
    while (i1 < i2)
    {
      ((GLWeather41Style2)this.d.getChildAt(i1)).updateNowTemp();
      i1 += 1;
    }
  }
  
  private void g()
  {
    Iterator localIterator = this.D.iterator();
    while (localIterator.hasNext()) {
      if (!((com.gau.go.launcherex.gowidget.weather.globaltheme.b.e)localIterator.next()).i()) {
        localIterator.remove();
      }
    }
  }
  
  private void h()
  {
    Object localObject = this.d.getCitys();
    Iterator localIterator = ((ArrayList)localObject).iterator();
    GLWeather41Style2 localGLWeather41Style2;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localGLWeather41Style2 = (GLWeather41Style2)localIterator.next();
    } while (localGLWeather41Style2.getWeatherBean().e() == 1);
    for (;;)
    {
      if (localGLWeather41Style2 != null)
      {
        if ((localGLWeather41Style2.getWeatherBean().e() != 3) && (((ArrayList)localObject).size() != 1)) {
          break label78;
        }
        localGLWeather41Style2.getWeatherBean().a(1);
      }
      label78:
      int i1;
      do
      {
        return;
        localObject = this.d.getChildAt(this.l);
        this.d.removeView(localGLWeather41Style2);
        this.d.notifyViewsChanged();
        i1 = this.d.indexOfChild((GLView)localObject);
      } while (i1 == -1);
      this.d.setCurScreen(i1);
      return;
      localGLWeather41Style2 = null;
    }
  }
  
  private void i()
  {
    try
    {
      this.k = this.p.a(this.a);
      if (!TextUtils.isEmpty(this.k)) {
        j();
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
  
  private void j()
  {
    int i3 = this.d.getChildCount();
    if (i3 < 1) {
      return;
    }
    int i1 = 0;
    label16:
    if (i1 < i3)
    {
      WeatherBean localWeatherBean = ((GLWeather41Style2)this.d.getChildAt(i1)).getWeatherBean();
      if ((localWeatherBean == null) || (TextUtils.isEmpty(localWeatherBean.c())) || (!localWeatherBean.c().equals(this.k))) {}
    }
    for (;;)
    {
      int i2 = i1;
      if (i1 == -1) {
        i2 = this.l % i3;
      }
      if ((i3 <= 0) || (i2 >= i3)) {
        break;
      }
      this.d.setCurScreen(i2);
      this.l = i2;
      return;
      i1 += 1;
      break label16;
      i1 = -1;
    }
  }
  
  private void k()
  {
    int i2 = this.d.getChildCount();
    int i1 = 0;
    while (i1 < i2)
    {
      GLWeather41Style2 localGLWeather41Style2 = (GLWeather41Style2)this.d.getChildAt(i1);
      localGLWeather41Style2.mAnimationWeatherIcon = true;
      localGLWeather41Style2.updateAllViews();
      i1 += 1;
    }
  }
  
  private void l()
  {
    Iterator localIterator = this.d.getCitys().iterator();
    while (localIterator.hasNext()) {
      ((GLWeather41Style2)localIterator.next()).updateWeatherIcon();
    }
  }
  
  private void m()
  {
    this.d.setEventListener(null);
    if (this.e != null) {
      this.e.setOnClickListener(null);
    }
  }
  
  private void n()
  {
    int i2 = this.d.getChildCount();
    Object localObject = new ArrayList(i2);
    int i1 = 0;
    while (i1 < i2)
    {
      ((ArrayList)localObject).add(this.d.getChildAt(i1));
      i1 += 1;
    }
    this.d.removeAllViews();
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      a((GLWeather41Style2)((Iterator)localObject).next());
    }
  }
  
  private void o()
  {
    this.q = new w(this);
  }
  
  private void p()
  {
    Iterator localIterator = this.d.getCitys().iterator();
    while (localIterator.hasNext())
    {
      GLWeather41Style2 localGLWeather41Style2 = (GLWeather41Style2)localIterator.next();
      if (localGLWeather41Style2.isEmptyCity()) {
        this.d.removeView(localGLWeather41Style2);
      }
    }
    this.d.notifyViewsChanged();
  }
  
  private void q()
  {
    if (this.u.equals(getContext().getPackageName())) {
      this.E = (this.D.size() - 1);
    }
    for (;;)
    {
      return;
      int i1 = 0;
      while (i1 < this.D.size())
      {
        com.gau.go.launcherex.gowidget.weather.globaltheme.b.e locale = (com.gau.go.launcherex.gowidget.weather.globaltheme.b.e)this.D.get(i1);
        if (this.u.equals(locale.x()))
        {
          this.E = i1;
          return;
        }
        i1 += 1;
      }
    }
  }
  
  private void r()
  {
    Iterator localIterator = this.d.getCitys().iterator();
    while (localIterator.hasNext()) {
      ((GLWeather41Style2)localIterator.next()).playThemeChangeAnimation();
    }
  }
  
  public void cleanup()
  {
    super.cleanup();
    m();
  }
  
  public GLView getContentView()
  {
    return this;
  }
  
  public com.gau.go.launcherex.gowidget.weather.widget.dynamicicon.a getDynamicIconManager()
  {
    return this.c;
  }
  
  public g getTimeManager()
  {
    return this.b;
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
    this.n.a(this.mSettings.e);
  }
  
  public void gotoClock()
  {
    this.n.b(this.mSettings.d);
  }
  
  public void gotoThemeStore()
  {
    com.gau.go.launcherex.gowidget.weather.view.w.a(this.mContext, 20);
  }
  
  protected void initData() {}
  
  protected void initViews() {}
  
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
    this.z = true;
    String str = paramBundle.getString("gowidget_theme");
    this.v = paramBundle.getInt("gowidget_type");
    this.w = paramBundle.getInt("gowidget_themeid");
    this.a = paramBundle.getInt("gowidget_Id");
    if (this.w == 1) {
      this.w = 0;
    }
    if (this.y)
    {
      if ((str.equals(getContext().getPackageName())) || ("app_widget_theme_white".equals(str)) || ("app_widget_theme_black".equals(str)))
      {
        this.u = getContext().getPackageName();
        paramBundle = "app_widget_theme_white";
        this.w = 0;
      }
      while (!com.gau.go.launcherex.gowidget.weather.e.h.a(getContext(), this.a, paramBundle))
      {
        return false;
        this.u = str;
        paramBundle = str;
      }
    }
    paramBundle = com.gau.go.launcherex.gowidget.weather.e.h.a(getContext(), this.a);
    if (!TextUtils.isEmpty(paramBundle)) {
      if (paramBundle.equals("app_widget_theme_white"))
      {
        this.u = getContext().getPackageName();
        this.w = 0;
      }
    }
    for (;;)
    {
      return a(this.u);
      if (paramBundle.equals("app_widget_theme_black"))
      {
        this.u = getContext().getPackageName();
        this.w = 0;
      }
      else
      {
        this.u = paramBundle;
        this.w = 0;
        continue;
        this.u = str;
      }
    }
  }
  
  public void onBillingStatusChange(boolean paramBoolean)
  {
    this.mIsPro = paramBoolean;
    this.mSettings.h = this.mIsPro;
    this.b.a(this.mIsPro);
    k();
  }
  
  public void onClearMemory() {}
  
  public void onClick(GLView paramGLView)
  {
    if (paramGLView.equals(this.e)) {
      com.gau.go.launcherex.gowidget.weather.view.w.a(this.mContext, 31);
    }
    while (!paramGLView.equals(this.A)) {
      return;
    }
    com.gau.go.launcherex.gowidget.weather.view.w.a(this.mContext, 35);
  }
  
  public boolean onDeactivate(boolean paramBoolean, Bundle paramBundle)
  {
    return false;
  }
  
  public void onDelete()
  {
    super.onDelete();
    com.gau.go.launcherex.gowidget.weather.e.h.b(this.mContext, this.a);
    if (this.p != null) {}
    try
    {
      this.p.b(this.a);
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
    this.d = ((GLWidgetScrollGroup)findViewById(2131231977));
    this.d.setEventListener(this);
    this.e = findViewById(2131231996);
    this.e.setOnClickListener(this);
    this.A = ((GLTextViewWrapper)findViewById(2131231997));
    this.A.setOnClickListener(this);
    b();
    a(null);
  }
  
  public void onLanguageChanged(b paramb)
  {
    super.onLanguageChanged(paramb);
    c();
  }
  
  public void onLeave()
  {
    this.j.sendEmptyMessage(5);
  }
  
  public boolean onLongClick(GLView paramGLView)
  {
    if (!this.d.getScreenScroller().d()) {
      return false;
    }
    performLongClick();
    return true;
  }
  
  public void onRemove()
  {
    super.onRemove();
    this.b.b();
    this.mContext.unregisterReceiver(this.I);
    this.mContext.unregisterReceiver(this.J);
    this.mContext.unregisterReceiver(this.H);
  }
  
  public void onScrollGroupChange(GLWidgetScrollGroup paramGLWidgetScrollGroup, int paramInt) {}
  
  public void onScrollGroupFinishScroll(GLWidgetScrollGroup paramGLWidgetScrollGroup, int paramInt)
  {
    this.l = paramInt;
    paramGLWidgetScrollGroup = (GLWeather41Style2)paramGLWidgetScrollGroup.getChildAt(paramInt);
    if (paramGLWidgetScrollGroup != null)
    {
      paramGLWidgetScrollGroup = paramGLWidgetScrollGroup.getWeatherBean();
      if (paramGLWidgetScrollGroup != null)
      {
        this.k = paramGLWidgetScrollGroup.c();
        if (this.p == null) {}
      }
    }
    try
    {
      this.p.a(5, this.a, this.k);
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
    this.y = true;
    if (paramBundle == null) {}
    do
    {
      return;
      this.s = paramBundle.getBoolean("gowidget_add_to_screen");
      this.a = paramBundle.getInt("gowidget_Id");
      this.mContext.bindService(new Intent(this.mContext, WeatherService.class), this.r, 1);
    } while (this.z);
    paramBundle = com.gau.go.launcherex.gowidget.weather.e.h.a(this.mContext, this.a);
    if ((TextUtils.isEmpty(paramBundle)) || (!c(paramBundle)))
    {
      this.u = this.mContext.getPackageName();
      this.w = 0;
    }
    for (;;)
    {
      q();
      a(this.u);
      return;
      if (paramBundle.equals("app_widget_theme_white"))
      {
        this.u = this.mContext.getPackageName();
        this.w = 0;
      }
      else if (paramBundle.equals("app_widget_theme_black"))
      {
        this.u = this.mContext.getPackageName();
        this.w = 0;
      }
      else
      {
        this.u = paramBundle;
        this.w = 0;
      }
    }
  }
  
  public void onStop() {}
  
  public void onThemeSwitcherClick()
  {
    Intent localIntent = new Intent(this.mContext, NotifyService.class);
    localIntent.putExtra("notify_request", 51);
    this.mContext.startService(localIntent);
    int i1 = this.D.size();
    if (i1 == 1) {
      d(this.mContext.getString(2131166572));
    }
    do
    {
      return;
      long l1 = System.currentTimeMillis();
      if ((this.B) && (l1 - this.F > 180000L))
      {
        this.B = false;
        this.F = l1;
        d(this.mContext.getString(2131166573));
        return;
      }
      r();
      this.E += 1;
      this.G += 1;
      this.j.removeMessages(6);
      this.j.sendEmptyMessageDelayed(6, 450L);
    } while ((i1 != 2) || (this.G % 3 != 0));
    this.B = true;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public void refreshWeather()
  {
    if ((this.d.getChildCount() == 1) && (((GLWeather41Style2)this.d.getChildAt(0)).getWeatherBean() == null)) {}
    ArrayList localArrayList;
    do
    {
      return;
      localArrayList = new ArrayList();
      localObject = this.d.getCitys().iterator();
      while (((Iterator)localObject).hasNext())
      {
        WeatherBean localWeatherBean = ((GLWeather41Style2)((Iterator)localObject).next()).getWeatherBean();
        if (localWeatherBean != null)
        {
          RequestBean localRequestBean = new RequestBean();
          localRequestBean.a(localWeatherBean.c(), localWeatherBean.d(), localWeatherBean.k.g());
          localArrayList.add(localRequestBean);
        }
      }
    } while (localArrayList.isEmpty());
    Object localObject = new Intent("com.gau.go.launcherex.gowidget.weather.service.NotifyService");
    ((Intent)localObject).putExtra("notify_request", 22);
    ((Intent)localObject).putParcelableArrayListExtra("req_arg", localArrayList);
    this.mContext.startService((Intent)localObject);
  }
  
  public void setWidgetCallback(WidgetCallback paramWidgetCallback) {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/gl/GLWeatherWidget41Style2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */