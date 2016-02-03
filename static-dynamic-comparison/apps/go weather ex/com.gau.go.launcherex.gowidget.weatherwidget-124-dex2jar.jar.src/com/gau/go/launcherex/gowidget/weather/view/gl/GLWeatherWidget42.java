package com.gau.go.launcherex.gowidget.weather.view.gl;

import android.content.ActivityNotFoundException;
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
import com.gau.go.launcherex.gowidget.framework.GLGoWidgetFrame;
import com.gau.go.launcherex.gowidget.weather.c.g;
import com.gau.go.launcherex.gowidget.weather.model.NowBean;
import com.gau.go.launcherex.gowidget.weather.model.RequestBean;
import com.gau.go.launcherex.gowidget.weather.model.WeatherBean;
import com.gau.go.launcherex.gowidget.weather.model.WidgetSettingBean;
import com.gau.go.launcherex.gowidget.weather.scroller.GLWidgetScrollGroup;
import com.gau.go.launcherex.gowidget.weather.service.NotifyService;
import com.gau.go.launcherex.gowidget.weather.service.WeatherService;
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
import com.go.gl.widget.GLTextViewWrapper;
import com.go.gowidget.core.WidgetCallback;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GLWeatherWidget42
  extends GLGoWidgetFrame
  implements com.gau.go.launcherex.gowidget.weather.scroller.e, GLView.OnClickListener, GLView.OnLongClickListener
{
  private int A;
  private boolean B;
  private boolean C;
  private boolean D;
  private GLWeatherWidget42.PackageChangeReceiver E;
  private final BroadcastReceiver F = new ad(this);
  private final BroadcastReceiver G = new ae(this);
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
  private GLTextViewWrapper n;
  private Animation o;
  private al p;
  private g q = null;
  private af r;
  private f s;
  private com.gau.go.launcherex.gowidget.weather.service.c t;
  private ServiceConnection u = null;
  private boolean v = false;
  private com.gau.go.launcherex.gowidget.weather.globaltheme.d w;
  private ArrayList x;
  private int y;
  private long z;
  
  public GLWeatherWidget42(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  private GLWeather a(WeatherBean paramWeatherBean)
  {
    GLWeather localGLWeather = f();
    localGLWeather.setWeatherBean(paramWeatherBean);
    this.l.addView(localGLWeather);
    this.l.notifyViewsChanged();
    return localGLWeather;
  }
  
  private void a()
  {
    this.u = new aa(this);
    this.r = new af(this);
    h();
    this.q = new g(getContext());
    this.c = getContext().getPackageName();
    this.p = new al(this.mContext);
    this.x = com.gau.go.launcherex.gowidget.weather.globaltheme.c.d.e(this.mContext, getResources());
    this.w = new com.gau.go.launcherex.gowidget.weather.globaltheme.d(this.mContext);
    this.o = new Translate3DAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F, 1, 0.0F, 1, 0.0F);
    this.o.setDuration(500L);
  }
  
  private void a(int paramInt)
  {
    this.q.a(0, paramInt);
    Iterator localIterator = this.l.getCitys().iterator();
    while (localIterator.hasNext())
    {
      GLWeather localGLWeather = (GLWeather)localIterator.next();
      localGLWeather.showDate(localGLWeather.getCityTime());
    }
  }
  
  private void a(Bundle paramBundle)
  {
    boolean bool2 = true;
    boolean bool3 = true;
    boolean bool4 = true;
    boolean bool5 = true;
    boolean bool6 = true;
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
      WidgetSettingBean localWidgetSettingBean;
      if (paramBundle.containsKey("isCycle"))
      {
        localWidgetSettingBean = this.mSettings;
        if (r.a(paramBundle, "isCycle") == 1) {}
        for (bool1 = bool2;; bool1 = false)
        {
          localWidgetSettingBean.f = bool1;
          d(this.mSettings.f);
          return;
        }
      }
      if (paramBundle.containsKey("tempUnit"))
      {
        this.mSettings.a = r.a(paramBundle, "tempUnit");
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
        this.c = paramBundle.getString("go_widget_theme");
        c(this.c);
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
          l();
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
      if (paramBundle.containsKey("widget_theme_switcher"))
      {
        localWidgetSettingBean = this.mSettings;
        if (r.a(paramBundle, "widget_theme_switcher") == 1) {}
        for (bool1 = bool5;; bool1 = false)
        {
          localWidgetSettingBean.l = bool1;
          b(this.mSettings.l);
          return;
        }
      }
      if (paramBundle.containsKey("calendarType"))
      {
        localWidgetSettingBean = this.mSettings;
        if (r.a(paramBundle, "calendarType") == 1) {}
        for (bool1 = bool6;; bool1 = false)
        {
          localWidgetSettingBean.j = bool1;
          this.q.b(this.mSettings.j);
          m();
          return;
        }
      }
      if (paramBundle.containsKey("festival"))
      {
        this.mSettings.k = r.a(paramBundle, "festival");
        this.q.d(this.mSettings.k);
        n();
        return;
      }
    } while (!paramBundle.containsKey("windUnit"));
    this.mSettings.b = r.a(paramBundle, "windUnit");
    o();
  }
  
  private void a(WidgetSettingBean paramWidgetSettingBean, List paramList, String paramString)
  {
    this.mSettings = paramWidgetSettingBean;
    this.l.setCycleMode(this.mSettings.f);
    this.mIsPro = this.s.d();
    paramWidgetSettingBean = this.q;
    if ((this.mIsPro) && (this.mSettings.h)) {}
    for (boolean bool = true;; bool = false)
    {
      paramWidgetSettingBean.a(bool);
      this.q.b(this.mSettings.j);
      this.q.d(this.mSettings.k);
      this.q.a(0, this.mSettings.c);
      a(paramList);
      d();
      a(this.s.e());
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
      this.m.startAnimation(this.o);
      return;
    }
    this.m.setVisibility(8);
  }
  
  /* Error */
  private boolean a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 149	com/gau/go/launcherex/gowidget/weather/view/gl/GLWeatherWidget42:getContext	()Landroid/content/Context;
    //   4: invokevirtual 158	android/content/Context:getPackageName	()Ljava/lang/String;
    //   7: ldc_w 393
    //   10: invokevirtual 399	java/lang/String:length	()I
    //   13: invokevirtual 403	java/lang/String:substring	(I)Ljava/lang/String;
    //   16: astore 4
    //   18: new 405	java/lang/StringBuilder
    //   21: dup
    //   22: invokespecial 406	java/lang/StringBuilder:<init>	()V
    //   25: ldc_w 408
    //   28: invokevirtual 412	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: aload 4
    //   33: invokevirtual 412	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: ldc_w 414
    //   39: invokevirtual 412	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: invokevirtual 417	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: astore_2
    //   46: aload_0
    //   47: invokevirtual 149	com/gau/go/launcherex/gowidget/weather/view/gl/GLWeatherWidget42:getContext	()Landroid/content/Context;
    //   50: aload_1
    //   51: aload_2
    //   52: invokestatic 422	com/gau/go/launcherex/gowidget/weather/f/g:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/io/InputStream;
    //   55: astore_3
    //   56: aload_3
    //   57: astore_2
    //   58: aload_3
    //   59: ifnonnull +38 -> 97
    //   62: new 405	java/lang/StringBuilder
    //   65: dup
    //   66: invokespecial 406	java/lang/StringBuilder:<init>	()V
    //   69: ldc_w 408
    //   72: invokevirtual 412	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: aload 4
    //   77: invokevirtual 412	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: invokevirtual 417	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   83: astore_2
    //   84: aload_0
    //   85: invokevirtual 149	com/gau/go/launcherex/gowidget/weather/view/gl/GLWeatherWidget42:getContext	()Landroid/content/Context;
    //   88: aload_0
    //   89: getfield 78	com/gau/go/launcherex/gowidget/weather/view/gl/GLWeatherWidget42:c	Ljava/lang/String;
    //   92: aload_2
    //   93: invokestatic 424	com/gau/go/launcherex/gowidget/weather/f/g:b	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/io/InputStream;
    //   96: astore_2
    //   97: aload_2
    //   98: ifnonnull +5 -> 103
    //   101: iconst_0
    //   102: ireturn
    //   103: aload_2
    //   104: invokestatic 427	com/gau/go/launcherex/gowidget/weather/f/g:a	(Ljava/io/InputStream;)Lorg/xmlpull/v1/XmlPullParser;
    //   107: astore_3
    //   108: aload_0
    //   109: new 429	com/gau/go/launcherex/gowidget/weather/f/a
    //   112: dup
    //   113: invokespecial 430	com/gau/go/launcherex/gowidget/weather/f/a:<init>	()V
    //   116: putfield 74	com/gau/go/launcherex/gowidget/weather/view/gl/GLWeatherWidget42:b	Lcom/gau/go/launcherex/gowidget/weather/f/a;
    //   119: aload_0
    //   120: getfield 74	com/gau/go/launcherex/gowidget/weather/view/gl/GLWeatherWidget42:b	Lcom/gau/go/launcherex/gowidget/weather/f/a;
    //   123: aload_1
    //   124: putfield 432	com/gau/go/launcherex/gowidget/weather/f/a:a	Ljava/lang/String;
    //   127: aload_0
    //   128: getfield 74	com/gau/go/launcherex/gowidget/weather/view/gl/GLWeatherWidget42:b	Lcom/gau/go/launcherex/gowidget/weather/f/a;
    //   131: ldc_w 434
    //   134: iconst_0
    //   135: invokestatic 437	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   138: invokevirtual 440	com/gau/go/launcherex/gowidget/weather/f/a:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   141: aload_0
    //   142: getfield 74	com/gau/go/launcherex/gowidget/weather/view/gl/GLWeatherWidget42:b	Lcom/gau/go/launcherex/gowidget/weather/f/a;
    //   145: ldc_w 442
    //   148: aload_0
    //   149: getfield 80	com/gau/go/launcherex/gowidget/weather/view/gl/GLWeatherWidget42:d	I
    //   152: invokestatic 437	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   155: invokevirtual 440	com/gau/go/launcherex/gowidget/weather/f/a:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   158: aload_3
    //   159: ifnull +18 -> 177
    //   162: new 444	com/gau/go/launcherex/gowidget/weather/f/d
    //   165: dup
    //   166: invokespecial 445	com/gau/go/launcherex/gowidget/weather/f/d:<init>	()V
    //   169: aload_3
    //   170: aload_0
    //   171: getfield 74	com/gau/go/launcherex/gowidget/weather/view/gl/GLWeatherWidget42:b	Lcom/gau/go/launcherex/gowidget/weather/f/a;
    //   174: invokevirtual 448	com/gau/go/launcherex/gowidget/weather/f/d:a	(Lorg/xmlpull/v1/XmlPullParser;Lcom/gau/go/launcherex/gowidget/weather/f/a;)V
    //   177: aload_2
    //   178: invokevirtual 453	java/io/InputStream:close	()V
    //   181: aload_0
    //   182: aload_0
    //   183: invokevirtual 149	com/gau/go/launcherex/gowidget/weather/view/gl/GLWeatherWidget42:getContext	()Landroid/content/Context;
    //   186: invokevirtual 457	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   189: aload_1
    //   190: invokevirtual 463	android/content/pm/PackageManager:getResourcesForApplication	(Ljava/lang/String;)Landroid/content/res/Resources;
    //   193: putfield 82	com/gau/go/launcherex/gowidget/weather/view/gl/GLWeatherWidget42:e	Landroid/content/res/Resources;
    //   196: aload_0
    //   197: getfield 74	com/gau/go/launcherex/gowidget/weather/view/gl/GLWeatherWidget42:b	Lcom/gau/go/launcherex/gowidget/weather/f/a;
    //   200: aload_0
    //   201: getfield 82	com/gau/go/launcherex/gowidget/weather/view/gl/GLWeatherWidget42:e	Landroid/content/res/Resources;
    //   204: putfield 465	com/gau/go/launcherex/gowidget/weather/f/a:b	Landroid/content/res/Resources;
    //   207: aload_0
    //   208: getfield 74	com/gau/go/launcherex/gowidget/weather/view/gl/GLWeatherWidget42:b	Lcom/gau/go/launcherex/gowidget/weather/f/a;
    //   211: ldc_w 467
    //   214: invokevirtual 469	com/gau/go/launcherex/gowidget/weather/f/a:a	(Ljava/lang/String;)Ljava/lang/String;
    //   217: astore_2
    //   218: aload_0
    //   219: getfield 82	com/gau/go/launcherex/gowidget/weather/view/gl/GLWeatherWidget42:e	Landroid/content/res/Resources;
    //   222: aload_2
    //   223: aload_1
    //   224: invokestatic 472	com/gau/go/launcherex/gowidget/weather/f/d:a	(Landroid/content/res/Resources;Ljava/lang/String;Ljava/lang/String;)Landroid/graphics/drawable/Drawable;
    //   227: astore_1
    //   228: aload_0
    //   229: getfield 86	com/gau/go/launcherex/gowidget/weather/view/gl/GLWeatherWidget42:l	Lcom/gau/go/launcherex/gowidget/weather/scroller/GLWidgetScrollGroup;
    //   232: aload_1
    //   233: invokevirtual 476	com/gau/go/launcherex/gowidget/weather/scroller/GLWidgetScrollGroup:setBackgroundDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   236: aload_0
    //   237: getfield 86	com/gau/go/launcherex/gowidget/weather/view/gl/GLWeatherWidget42:l	Lcom/gau/go/launcherex/gowidget/weather/scroller/GLWidgetScrollGroup;
    //   240: invokevirtual 206	com/gau/go/launcherex/gowidget/weather/scroller/GLWidgetScrollGroup:getCitys	()Ljava/util/ArrayList;
    //   243: invokevirtual 212	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   246: astore_1
    //   247: aload_1
    //   248: invokeinterface 218 1 0
    //   253: ifeq +27 -> 280
    //   256: aload_1
    //   257: invokeinterface 222 1 0
    //   262: checkcast 120	com/gau/go/launcherex/gowidget/weather/view/gl/GLWeather
    //   265: aload_0
    //   266: getfield 74	com/gau/go/launcherex/gowidget/weather/view/gl/GLWeatherWidget42:b	Lcom/gau/go/launcherex/gowidget/weather/f/a;
    //   269: invokevirtual 480	com/gau/go/launcherex/gowidget/weather/view/gl/GLWeather:onApplyTheme	(Lcom/gau/go/launcherex/gowidget/weather/f/a;)V
    //   272: goto -25 -> 247
    //   275: astore_1
    //   276: aload_1
    //   277: invokevirtual 483	android/content/pm/PackageManager$NameNotFoundException:printStackTrace	()V
    //   280: aload_0
    //   281: getfield 86	com/gau/go/launcherex/gowidget/weather/view/gl/GLWeatherWidget42:l	Lcom/gau/go/launcherex/gowidget/weather/scroller/GLWidgetScrollGroup;
    //   284: invokevirtual 486	com/gau/go/launcherex/gowidget/weather/scroller/GLWidgetScrollGroup:requestLayout	()V
    //   287: iconst_1
    //   288: ireturn
    //   289: astore_2
    //   290: aload_2
    //   291: invokevirtual 487	java/io/IOException:printStackTrace	()V
    //   294: goto -113 -> 181
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	297	0	this	GLWeatherWidget42
    //   0	297	1	paramString	String
    //   45	178	2	localObject1	Object
    //   289	2	2	localIOException	java.io.IOException
    //   55	115	3	localObject2	Object
    //   16	60	4	str	String
    // Exception table:
    //   from	to	target	type
    //   181	247	275	android/content/pm/PackageManager$NameNotFoundException
    //   247	272	275	android/content/pm/PackageManager$NameNotFoundException
    //   177	181	289	java/io/IOException
  }
  
  private void b()
  {
    Iterator localIterator = this.l.getCitys().iterator();
    while (localIterator.hasNext()) {
      ((GLWeather)localIterator.next()).updateAllViews();
    }
  }
  
  private void b(String paramString)
  {
    this.n.setText(paramString);
    this.n.setVisibility(0);
    paramString = new Translate3DAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F, 1, 0.0F, 1, 0.0F);
    paramString.setDuration(200L);
    this.n.startAnimation(paramString);
    this.n.postDelayed(new ac(this), 3000L);
  }
  
  private void b(boolean paramBoolean)
  {
    Iterator localIterator = this.l.getCitys().iterator();
    while (localIterator.hasNext()) {
      ((GLWeather)localIterator.next()).setThemeSwitcherVisible(paramBoolean);
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
    this.E = new GLWeatherWidget42.PackageChangeReceiver(this);
    localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.PACKAGE_ADDED");
    localIntentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
    localIntentFilter.addDataScheme("package");
    this.mContext.registerReceiver(this.E, localIntentFilter);
  }
  
  private void c(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Message localMessage = this.r.obtainMessage();
      localMessage.what = 9;
      localMessage.obj = paramString;
      this.r.sendMessage(localMessage);
    }
  }
  
  private void c(boolean paramBoolean)
  {
    this.mSettings.h = paramBoolean;
    if ((this.mSettings.h) && (!this.mIsPro)) {
      return;
    }
    this.q.a(this.mSettings.h);
    b();
  }
  
  private void d()
  {
    try
    {
      this.f = this.s.a(this.a);
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
    this.l.setCycleMode(paramBoolean);
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
      WeatherBean localWeatherBean = ((GLWeather)this.l.getChildAt(i1)).getWeatherBean();
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
  
  private void e(boolean paramBoolean)
  {
    Iterator localIterator = this.l.getCitys().iterator();
    while (localIterator.hasNext()) {
      ((GLWeather)localIterator.next()).startRefreshAni(paramBoolean);
    }
  }
  
  private GLWeather f()
  {
    GLWeather localGLWeather = new GLWeather(this.mContext);
    localGLWeather.setTimeManager(this.q);
    localGLWeather.setOnLongClickListener(this);
    localGLWeather.setWidgetView(this);
    localGLWeather.setTip(this.mContext.getString(2131166457));
    localGLWeather.setThemeSwitcherVisible(this.mSettings.l);
    if (this.b != null) {
      localGLWeather.onApplyTheme(this.b);
    }
    return localGLWeather;
  }
  
  private void g()
  {
    Iterator localIterator = this.l.getCitys().iterator();
    while (localIterator.hasNext())
    {
      GLWeather localGLWeather = (GLWeather)localIterator.next();
      if (localGLWeather.isEmptyCity())
      {
        this.l.removeView(localGLWeather);
        a(localGLWeather);
      }
    }
    this.l.notifyViewsChanged();
  }
  
  private void h()
  {
    this.t = new ab(this);
  }
  
  private void i()
  {
    Iterator localIterator = this.l.getCitys().iterator();
    while (localIterator.hasNext()) {
      ((GLWeather)localIterator.next()).playThemeChangeAnimation();
    }
  }
  
  private void j()
  {
    if (this.c.equals(getContext().getPackageName())) {
      this.y = (this.x.size() - 1);
    }
    for (;;)
    {
      return;
      int i1 = 0;
      while (i1 < this.x.size())
      {
        com.gau.go.launcherex.gowidget.weather.globaltheme.b.e locale = (com.gau.go.launcherex.gowidget.weather.globaltheme.b.e)this.x.get(i1);
        if (this.c.equals(locale.x()))
        {
          this.y = i1;
          return;
        }
        i1 += 1;
      }
    }
  }
  
  private void k()
  {
    Iterator localIterator = this.l.getCitys().iterator();
    while (localIterator.hasNext()) {
      ((GLWeather)localIterator.next()).refreshTemp();
    }
  }
  
  private void l()
  {
    Object localObject = this.l.getCitys();
    Iterator localIterator = ((ArrayList)localObject).iterator();
    GLWeather localGLWeather;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localGLWeather = (GLWeather)localIterator.next();
    } while (localGLWeather.getWeatherBean().e() == 1);
    for (;;)
    {
      if (localGLWeather != null)
      {
        if ((localGLWeather.getMyLocation() != 3) && (((ArrayList)localObject).size() != 1)) {
          break label72;
        }
        localGLWeather.setMyLocation(1);
      }
      label72:
      int i1;
      do
      {
        return;
        localObject = this.l.getChildAt(this.g);
        this.l.removeView(localGLWeather);
        a(localGLWeather);
        this.l.notifyViewsChanged();
        i1 = this.l.indexOfChild((GLView)localObject);
      } while (i1 == -1);
      this.l.setCurScreen(i1);
      return;
      localGLWeather = null;
    }
  }
  
  private void m()
  {
    Iterator localIterator = this.l.getCitys().iterator();
    while (localIterator.hasNext())
    {
      GLWeather localGLWeather = (GLWeather)localIterator.next();
      localGLWeather.showLunar(localGLWeather.getCityTime());
    }
  }
  
  private void n()
  {
    Iterator localIterator = this.l.getCitys().iterator();
    while (localIterator.hasNext())
    {
      GLWeather localGLWeather = (GLWeather)localIterator.next();
      localGLWeather.showFestival(localGLWeather.getCityTime());
    }
  }
  
  private void o()
  {
    Iterator localIterator = this.l.getCitys().iterator();
    while (localIterator.hasNext()) {
      ((GLWeather)localIterator.next()).refreshWind();
    }
  }
  
  private void p()
  {
    Iterator localIterator = this.l.getCitys().iterator();
    while (localIterator.hasNext()) {
      ((GLWeather)localIterator.next()).syncTime(true);
    }
  }
  
  private void q()
  {
    ArrayList localArrayList = this.l.getCitys();
    int i2 = localArrayList.size();
    int i1 = 0;
    if (i1 < i2)
    {
      GLWeather localGLWeather = (GLWeather)localArrayList.get(i1);
      localGLWeather.syncTime(true);
      if (this.l.getCurScreen() == i1) {
        localGLWeather.showWeatherInfo(true);
      }
      for (;;)
      {
        i1 += 1;
        break;
        localGLWeather.showWeatherInfo(false);
      }
    }
  }
  
  private void r()
  {
    this.k = true;
    Object localObject = this.l.getCitys().iterator();
    while (((Iterator)localObject).hasNext())
    {
      GLWeather localGLWeather = (GLWeather)((Iterator)localObject).next();
      this.l.removeView(localGLWeather);
      a(localGLWeather);
    }
    localObject = a(null);
    ((GLWeather)localObject).setTip(this.mContext.getString(2131166455));
    ((GLWeather)localObject).syncTime(true);
    this.l.setCurScreen(0);
  }
  
  public void doRefresh()
  {
    Object localObject = this.l.getCitys();
    if ((((ArrayList)localObject).size() == 1) && (((GLWeather)((ArrayList)localObject).get(0)).isEmptyCity())) {}
    ArrayList localArrayList;
    do
    {
      return;
      localArrayList = new ArrayList();
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        WeatherBean localWeatherBean = ((GLWeather)((Iterator)localObject).next()).getWeatherBean();
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
  
  public g getTimeManager()
  {
    return this.q;
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
    this.p.a(this.mSettings.e);
  }
  
  public void gotoClock()
  {
    this.p.b(this.mSettings.d);
  }
  
  public void gotoThemeSetting()
  {
    w.a(this.mContext, 20);
  }
  
  public void gotoWeatherDetail(String paramString)
  {
    paramString = p.a(getContext(), paramString, true, 4, "", -1);
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
    this.D = true;
    String str = paramBundle.getString("gowidget_theme");
    this.d = paramBundle.getInt("gowidget_themeid");
    this.a = paramBundle.getInt("gowidget_Id");
    if (this.d == 1) {
      this.d = 0;
    }
    if (this.C)
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
    com.gtp.a.a.b.c.a("lishen", "GOWidget42付费状态改变 【isPay】=" + paramBoolean);
    this.mIsPro = paramBoolean;
    this.mSettings.h = this.mIsPro;
    this.q.a(this.mIsPro);
    b();
  }
  
  public void onClearMemory() {}
  
  public void onClick(GLView paramGLView)
  {
    if (paramGLView.equals(this.m)) {
      w.a(this.mContext, 31);
    }
    while (!paramGLView.equals(this.n)) {
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
    if (this.s != null) {}
    try
    {
      this.s.b(this.a);
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
    this.n = ((GLTextViewWrapper)findViewById(2131231997));
    this.n.setOnClickListener(this);
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
    this.q.b();
    getContext().unregisterReceiver(this.F);
    getContext().unregisterReceiver(this.G);
    getContext().unregisterReceiver(this.E);
    this.w.a();
    try
    {
      this.s.b(this.t);
      this.mContext.unbindService(this.u);
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
      this.f = ((GLWeather)paramGLWidgetScrollGroup).getCityId();
      if (this.s == null) {}
    }
    try
    {
      this.s.a(0, this.a, this.f);
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
    this.C = true;
    if (paramBundle == null) {}
    do
    {
      return;
      this.B = paramBundle.getBoolean("gowidget_add_to_screen");
      this.a = paramBundle.getInt("gowidget_Id");
      this.mContext.bindService(new Intent(this.mContext, WeatherService.class), this.u, 1);
    } while (this.D);
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
      j();
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
  
  public void onThemeSwitcherClick()
  {
    Intent localIntent = new Intent(this.mContext, NotifyService.class);
    localIntent.putExtra("notify_request", 51);
    this.mContext.startService(localIntent);
    int i1 = this.x.size();
    if (i1 == 1) {
      b(this.mContext.getString(2131166572));
    }
    do
    {
      return;
      long l1 = System.currentTimeMillis();
      if ((this.v) && (l1 - this.z > 180000L))
      {
        this.v = false;
        this.z = l1;
        b(this.mContext.getString(2131166573));
        return;
      }
      i();
      this.y += 1;
      this.A += 1;
      this.r.removeMessages(18);
      this.r.sendEmptyMessageDelayed(18, 450L);
    } while ((i1 != 2) || (this.A % 3 != 0));
    this.v = true;
  }
  
  public void setWidgetCallback(WidgetCallback paramWidgetCallback) {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/gl/GLWeatherWidget42.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */