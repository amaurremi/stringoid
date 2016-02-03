package com.gau.go.launcherex.gowidget.weather.view;

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
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import com.gau.go.launcherex.gowidget.framework.GoWidgetFrame;
import com.gau.go.launcherex.gowidget.language.b;
import com.gau.go.launcherex.gowidget.weather.c.g;
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
import com.gau.go.launcherex.gowidget.weather.util.r;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class WeatherWidget41Style2
  extends GoWidgetFrame
  implements View.OnClickListener, View.OnLongClickListener, m
{
  private boolean A;
  private boolean B;
  private TextView C;
  private boolean D = false;
  private com.gau.go.launcherex.gowidget.weather.globaltheme.d E;
  private ArrayList F;
  private int G = 0;
  private long H = 0L;
  private int I;
  private WeatherWidget41Style2.PackageChangeReceiver J;
  private Runnable K = new co(this);
  private final BroadcastReceiver L = new cp(this);
  private final BroadcastReceiver M = new cq(this);
  boolean b;
  WidgetSettingBean c = new WidgetSettingBean();
  private int d = 0;
  private g e;
  private com.gau.go.launcherex.gowidget.weather.widget.dynamicicon.a f = null;
  private View g;
  private boolean h = true;
  private boolean i = false;
  private boolean j = true;
  private final cs k = new cs(this);
  private String l;
  private int m;
  public WidgetScrollGroup mWidgetScrollGroup;
  private boolean n;
  private al o;
  private ct p;
  private f q;
  private com.gau.go.launcherex.gowidget.weather.service.c r;
  private ServiceConnection s = null;
  private String t;
  private boolean u;
  private com.gau.go.launcherex.gowidget.weather.f.a v = null;
  private String w = "";
  private int x = 5;
  private int y = 0;
  private Resources z = null;
  
  public WeatherWidget41Style2(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    d();
  }
  
  private bo a(WeatherBean paramWeatherBean)
  {
    bo localbo = new bo(this.a);
    localbo.a(this);
    localbo.setOnLongClickListener(this);
    localbo.a(paramWeatherBean);
    localbo.a(this.c.l);
    localbo.f();
    if (this.v != null) {
      localbo.a(this.v);
    }
    this.mWidgetScrollGroup.addView(localbo);
    this.mWidgetScrollGroup.a();
    return localbo;
  }
  
  private void a(int paramInt)
  {
    this.e.a(0, paramInt);
    Iterator localIterator = this.mWidgetScrollGroup.c().iterator();
    while (localIterator.hasNext()) {
      ((bo)localIterator.next()).g();
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
        localWidgetSettingBean = this.c;
        if (r.a(paramBundle, "isCycle") == 1) {}
        for (bool1 = bool2;; bool1 = false)
        {
          localWidgetSettingBean.f = bool1;
          e(this.c.f);
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
        this.t = paramBundle.getString("go_widget_theme");
        c(this.t);
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
          n();
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
    this.mWidgetScrollGroup.a(this.c.f);
    this.b = this.q.d();
    paramWidgetSettingBean = this.e;
    if ((this.b) && (this.c.h)) {}
    for (boolean bool = true;; bool = false)
    {
      paramWidgetSettingBean.a(bool);
      this.e.a(0, this.c.c);
      a(paramList);
      k();
      a(this.q.e());
      b(this.c.l);
      return;
    }
  }
  
  private void a(List paramList)
  {
    this.j = false;
    if (!paramList.isEmpty())
    {
      this.mWidgetScrollGroup.removeAllViews();
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        a((WeatherBean)paramList.next());
      }
    }
    this.i = true;
    paramList = new Intent("com.gau.go.launcherex.gowidget.weather.service.NotifyService");
    paramList.putExtra("notify_request", 50);
    getContext().startService(paramList);
    p();
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.g.setVisibility(0);
      this.g.startAnimation(AnimationUtils.loadAnimation(getContext(), 2130968620));
      return;
    }
    this.g.setVisibility(8);
  }
  
  /* Error */
  private boolean a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 345	com/gau/go/launcherex/gowidget/weather/view/WeatherWidget41Style2:getContext	()Landroid/content/Context;
    //   4: invokevirtual 380	android/content/Context:getPackageName	()Ljava/lang/String;
    //   7: ldc_w 382
    //   10: invokevirtual 388	java/lang/String:length	()I
    //   13: invokevirtual 392	java/lang/String:substring	(I)Ljava/lang/String;
    //   16: astore 4
    //   18: new 394	java/lang/StringBuilder
    //   21: dup
    //   22: invokespecial 395	java/lang/StringBuilder:<init>	()V
    //   25: ldc_w 397
    //   28: invokevirtual 401	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: aload 4
    //   33: invokevirtual 401	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: ldc_w 403
    //   39: invokevirtual 401	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: invokevirtual 406	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: astore_2
    //   46: aload_0
    //   47: invokevirtual 345	com/gau/go/launcherex/gowidget/weather/view/WeatherWidget41Style2:getContext	()Landroid/content/Context;
    //   50: aload_1
    //   51: aload_2
    //   52: invokestatic 411	com/gau/go/launcherex/gowidget/weather/f/g:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/io/InputStream;
    //   55: astore_3
    //   56: aload_3
    //   57: astore_2
    //   58: aload_3
    //   59: ifnonnull +38 -> 97
    //   62: new 394	java/lang/StringBuilder
    //   65: dup
    //   66: invokespecial 395	java/lang/StringBuilder:<init>	()V
    //   69: ldc_w 397
    //   72: invokevirtual 401	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: aload 4
    //   77: invokevirtual 401	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: invokevirtual 406	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   83: astore_2
    //   84: aload_0
    //   85: invokevirtual 345	com/gau/go/launcherex/gowidget/weather/view/WeatherWidget41Style2:getContext	()Landroid/content/Context;
    //   88: aload_0
    //   89: getfield 106	com/gau/go/launcherex/gowidget/weather/view/WeatherWidget41Style2:w	Ljava/lang/String;
    //   92: aload_2
    //   93: invokestatic 413	com/gau/go/launcherex/gowidget/weather/f/g:b	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/io/InputStream;
    //   96: astore_2
    //   97: aload_2
    //   98: ifnonnull +5 -> 103
    //   101: iconst_0
    //   102: ireturn
    //   103: aload_2
    //   104: invokestatic 416	com/gau/go/launcherex/gowidget/weather/f/g:a	(Ljava/io/InputStream;)Lorg/xmlpull/v1/XmlPullParser;
    //   107: astore_3
    //   108: aload_0
    //   109: new 418	com/gau/go/launcherex/gowidget/weather/f/a
    //   112: dup
    //   113: invokespecial 419	com/gau/go/launcherex/gowidget/weather/f/a:<init>	()V
    //   116: putfield 102	com/gau/go/launcherex/gowidget/weather/view/WeatherWidget41Style2:v	Lcom/gau/go/launcherex/gowidget/weather/f/a;
    //   119: aload_0
    //   120: getfield 102	com/gau/go/launcherex/gowidget/weather/view/WeatherWidget41Style2:v	Lcom/gau/go/launcherex/gowidget/weather/f/a;
    //   123: aload_1
    //   124: putfield 421	com/gau/go/launcherex/gowidget/weather/f/a:a	Ljava/lang/String;
    //   127: aload_0
    //   128: getfield 102	com/gau/go/launcherex/gowidget/weather/view/WeatherWidget41Style2:v	Lcom/gau/go/launcherex/gowidget/weather/f/a;
    //   131: ldc_w 423
    //   134: aload_0
    //   135: getfield 108	com/gau/go/launcherex/gowidget/weather/view/WeatherWidget41Style2:x	I
    //   138: invokestatic 426	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   141: invokevirtual 429	com/gau/go/launcherex/gowidget/weather/f/a:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   144: aload_0
    //   145: getfield 102	com/gau/go/launcherex/gowidget/weather/view/WeatherWidget41Style2:v	Lcom/gau/go/launcherex/gowidget/weather/f/a;
    //   148: ldc_w 431
    //   151: aload_0
    //   152: getfield 110	com/gau/go/launcherex/gowidget/weather/view/WeatherWidget41Style2:y	I
    //   155: invokestatic 426	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   158: invokevirtual 429	com/gau/go/launcherex/gowidget/weather/f/a:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   161: aload_3
    //   162: ifnull +18 -> 180
    //   165: new 433	com/gau/go/launcherex/gowidget/weather/f/c
    //   168: dup
    //   169: invokespecial 434	com/gau/go/launcherex/gowidget/weather/f/c:<init>	()V
    //   172: aload_3
    //   173: aload_0
    //   174: getfield 102	com/gau/go/launcherex/gowidget/weather/view/WeatherWidget41Style2:v	Lcom/gau/go/launcherex/gowidget/weather/f/a;
    //   177: invokevirtual 437	com/gau/go/launcherex/gowidget/weather/f/c:a	(Lorg/xmlpull/v1/XmlPullParser;Lcom/gau/go/launcherex/gowidget/weather/f/a;)V
    //   180: aload_2
    //   181: invokevirtual 442	java/io/InputStream:close	()V
    //   184: aload_0
    //   185: aload_0
    //   186: invokevirtual 345	com/gau/go/launcherex/gowidget/weather/view/WeatherWidget41Style2:getContext	()Landroid/content/Context;
    //   189: invokevirtual 446	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   192: aload_1
    //   193: invokevirtual 452	android/content/pm/PackageManager:getResourcesForApplication	(Ljava/lang/String;)Landroid/content/res/Resources;
    //   196: putfield 112	com/gau/go/launcherex/gowidget/weather/view/WeatherWidget41Style2:z	Landroid/content/res/Resources;
    //   199: aload_0
    //   200: getfield 102	com/gau/go/launcherex/gowidget/weather/view/WeatherWidget41Style2:v	Lcom/gau/go/launcherex/gowidget/weather/f/a;
    //   203: aload_0
    //   204: getfield 112	com/gau/go/launcherex/gowidget/weather/view/WeatherWidget41Style2:z	Landroid/content/res/Resources;
    //   207: putfield 454	com/gau/go/launcherex/gowidget/weather/f/a:b	Landroid/content/res/Resources;
    //   210: aload_0
    //   211: getfield 102	com/gau/go/launcherex/gowidget/weather/view/WeatherWidget41Style2:v	Lcom/gau/go/launcherex/gowidget/weather/f/a;
    //   214: ldc_w 456
    //   217: invokevirtual 458	com/gau/go/launcherex/gowidget/weather/f/a:a	(Ljava/lang/String;)Ljava/lang/String;
    //   220: astore_3
    //   221: aconst_null
    //   222: astore_2
    //   223: aload_3
    //   224: invokestatic 463	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   227: ifne +13 -> 240
    //   230: aload_0
    //   231: getfield 112	com/gau/go/launcherex/gowidget/weather/view/WeatherWidget41Style2:z	Landroid/content/res/Resources;
    //   234: aload_3
    //   235: aload_1
    //   236: invokestatic 466	com/gau/go/launcherex/gowidget/weather/f/c:a	(Landroid/content/res/Resources;Ljava/lang/String;Ljava/lang/String;)Landroid/graphics/drawable/Drawable;
    //   239: astore_2
    //   240: aload_0
    //   241: getfield 184	com/gau/go/launcherex/gowidget/weather/view/WeatherWidget41Style2:mWidgetScrollGroup	Lcom/gau/go/launcherex/gowidget/weather/scroller/WidgetScrollGroup;
    //   244: aload_2
    //   245: invokevirtual 470	com/gau/go/launcherex/gowidget/weather/scroller/WidgetScrollGroup:setBackgroundDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   248: aload_0
    //   249: getfield 184	com/gau/go/launcherex/gowidget/weather/view/WeatherWidget41Style2:mWidgetScrollGroup	Lcom/gau/go/launcherex/gowidget/weather/scroller/WidgetScrollGroup;
    //   252: invokevirtual 210	com/gau/go/launcherex/gowidget/weather/scroller/WidgetScrollGroup:c	()Ljava/util/ArrayList;
    //   255: invokevirtual 216	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   258: astore_1
    //   259: aload_1
    //   260: invokeinterface 222 1 0
    //   265: ifeq +27 -> 292
    //   268: aload_1
    //   269: invokeinterface 226 1 0
    //   274: checkcast 157	com/gau/go/launcherex/gowidget/weather/view/bo
    //   277: aload_0
    //   278: getfield 102	com/gau/go/launcherex/gowidget/weather/view/WeatherWidget41Style2:v	Lcom/gau/go/launcherex/gowidget/weather/f/a;
    //   281: invokevirtual 182	com/gau/go/launcherex/gowidget/weather/view/bo:a	(Lcom/gau/go/launcherex/gowidget/weather/f/a;)V
    //   284: goto -25 -> 259
    //   287: astore_1
    //   288: aload_1
    //   289: invokevirtual 473	android/content/pm/PackageManager$NameNotFoundException:printStackTrace	()V
    //   292: aload_0
    //   293: getfield 184	com/gau/go/launcherex/gowidget/weather/view/WeatherWidget41Style2:mWidgetScrollGroup	Lcom/gau/go/launcherex/gowidget/weather/scroller/WidgetScrollGroup;
    //   296: invokevirtual 476	com/gau/go/launcherex/gowidget/weather/scroller/WidgetScrollGroup:requestLayout	()V
    //   299: iconst_1
    //   300: ireturn
    //   301: astore_2
    //   302: aload_2
    //   303: invokevirtual 477	java/io/IOException:printStackTrace	()V
    //   306: goto -122 -> 184
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	309	0	this	WeatherWidget41Style2
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
  
  private void b(String paramString)
  {
    this.C.setText(paramString);
    this.C.setVisibility(0);
    paramString = AnimationUtils.loadAnimation(this.a, 2130968620);
    paramString.setDuration(200L);
    this.C.startAnimation(paramString);
    this.C.removeCallbacks(this.K);
    this.C.postDelayed(this.K, 3000L);
  }
  
  private void b(boolean paramBoolean)
  {
    Iterator localIterator = this.mWidgetScrollGroup.c().iterator();
    while (localIterator.hasNext()) {
      ((bo)localIterator.next()).a(paramBoolean);
    }
  }
  
  private void c(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (d(paramString))
      {
        Message localMessage = this.k.obtainMessage();
        localMessage.what = 3;
        localMessage.obj = paramString;
        this.k.sendMessage(localMessage);
      }
    }
    else {
      return;
    }
    b(this.a.getString(2131166574));
  }
  
  private void c(boolean paramBoolean)
  {
    Iterator localIterator = this.mWidgetScrollGroup.c().iterator();
    while (localIterator.hasNext()) {
      ((bo)localIterator.next()).b(paramBoolean);
    }
  }
  
  private void d()
  {
    this.s = new cn(this);
    this.p = new ct(this);
    r();
    this.e = new g(getContext());
    this.t = getContext().getPackageName();
    this.o = new al(this.a);
    this.F = com.gau.go.launcherex.gowidget.weather.globaltheme.c.d.e(this.a, getResources());
    m();
    this.E = new com.gau.go.launcherex.gowidget.weather.globaltheme.d(this.a);
    getContext().startService(new Intent("com.gau.go.launcherex.gowidget.weather.service.NotifyService"));
  }
  
  private void d(boolean paramBoolean)
  {
    this.c.h = paramBoolean;
    if ((this.c.h) && (!this.b)) {
      return;
    }
    this.e.a(this.c.h);
    p();
  }
  
  private boolean d(String paramString)
  {
    Iterator localIterator = this.F.iterator();
    while (localIterator.hasNext())
    {
      e locale = (e)localIterator.next();
      if (locale.x().equals(paramString)) {
        return locale.i();
      }
    }
    return false;
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
    localIntentFilter.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_REFRESH_STARTED");
    localIntentFilter.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_RELOAD_DATA");
    localIntentFilter.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_DATA_READY");
    localIntentFilter.addAction("com.gau.go.launcherex.gowidget.weatherwidget.PRODUCT_THEME_VIP_PURCHASE_STATE_CHANGE_ACTION");
    localIntentFilter.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_THEME_PURCHASE_SUCCESS");
    localIntentFilter.setPriority(1008);
    getContext().registerReceiver(this.L, localIntentFilter);
    localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.PACKAGE_DATA_CLEARED");
    localIntentFilter.addDataScheme("package");
    getContext().registerReceiver(this.M, localIntentFilter);
    this.J = new WeatherWidget41Style2.PackageChangeReceiver(this);
    localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.PACKAGE_ADDED");
    localIntentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
    localIntentFilter.addDataScheme("package");
    this.a.registerReceiver(this.J, localIntentFilter);
  }
  
  private void e(boolean paramBoolean)
  {
    this.mWidgetScrollGroup.a(paramBoolean);
  }
  
  private void f()
  {
    Iterator localIterator = this.mWidgetScrollGroup.c().iterator();
    while (localIterator.hasNext()) {
      ((bo)localIterator.next()).k();
    }
  }
  
  private void g()
  {
    Iterator localIterator = this.mWidgetScrollGroup.c().iterator();
    while (localIterator.hasNext()) {
      ((bo)localIterator.next()).b();
    }
  }
  
  private void h()
  {
    if (this.h)
    {
      Iterator localIterator = this.mWidgetScrollGroup.c().iterator();
      while (localIterator.hasNext())
      {
        bo localbo = (bo)localIterator.next();
        localbo.j();
        localbo.g();
        localbo.a = false;
        localbo.i();
      }
    }
  }
  
  private void i()
  {
    this.n = true;
    this.mWidgetScrollGroup.removeAllViews();
    a(null);
  }
  
  private void j()
  {
    if (this.w.equals(getContext().getPackageName())) {
      this.G = (this.F.size() - 1);
    }
    for (;;)
    {
      return;
      int i1 = 0;
      while (i1 < this.F.size())
      {
        e locale = (e)this.F.get(i1);
        if (this.w.equals(locale.x()))
        {
          this.G = i1;
          return;
        }
        i1 += 1;
      }
    }
  }
  
  private void k()
  {
    try
    {
      this.l = this.q.a(this.d);
      if (!TextUtils.isEmpty(this.l)) {
        o();
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
  
  private void l()
  {
    int i2 = this.mWidgetScrollGroup.getChildCount();
    int i1 = 0;
    while (i1 < i2)
    {
      ((bo)this.mWidgetScrollGroup.getChildAt(i1)).h();
      i1 += 1;
    }
  }
  
  private void m()
  {
    Iterator localIterator = this.F.iterator();
    while (localIterator.hasNext()) {
      if (!((e)localIterator.next()).i()) {
        localIterator.remove();
      }
    }
  }
  
  private void n()
  {
    Object localObject = this.mWidgetScrollGroup.c();
    Iterator localIterator = ((ArrayList)localObject).iterator();
    bo localbo;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localbo = (bo)localIterator.next();
    } while (localbo.c().e() == 1);
    for (;;)
    {
      if (localbo != null)
      {
        if ((localbo.c().e() != 3) && (((ArrayList)localObject).size() != 1)) {
          break label78;
        }
        localbo.c().a(1);
      }
      label78:
      int i1;
      do
      {
        return;
        localObject = this.mWidgetScrollGroup.getChildAt(this.m);
        this.mWidgetScrollGroup.removeView(localbo);
        this.mWidgetScrollGroup.a();
        i1 = this.mWidgetScrollGroup.indexOfChild((View)localObject);
      } while (i1 == -1);
      this.mWidgetScrollGroup.a(i1);
      return;
      localbo = null;
    }
  }
  
  private void o()
  {
    int i3 = this.mWidgetScrollGroup.getChildCount();
    if (i3 < 1) {
      return;
    }
    int i1 = 0;
    label16:
    if (i1 < i3)
    {
      WeatherBean localWeatherBean = ((bo)this.mWidgetScrollGroup.getChildAt(i1)).c();
      if ((localWeatherBean == null) || (TextUtils.isEmpty(localWeatherBean.c())) || (!localWeatherBean.c().equals(this.l))) {}
    }
    for (;;)
    {
      int i2 = i1;
      if (i1 == -1) {
        i2 = this.m % i3;
      }
      if ((i3 <= 0) || (i2 >= i3)) {
        break;
      }
      this.mWidgetScrollGroup.a(i2);
      this.m = i2;
      return;
      i1 += 1;
      break label16;
      i1 = -1;
    }
  }
  
  private void p()
  {
    Iterator localIterator = this.mWidgetScrollGroup.c().iterator();
    while (localIterator.hasNext())
    {
      bo localbo = (bo)localIterator.next();
      localbo.a = true;
      localbo.f();
    }
  }
  
  private void q()
  {
    Iterator localIterator = this.mWidgetScrollGroup.c().iterator();
    while (localIterator.hasNext()) {
      ((bo)localIterator.next()).i();
    }
  }
  
  private void r()
  {
    this.r = new cr(this);
  }
  
  private void s()
  {
    Iterator localIterator = this.mWidgetScrollGroup.c().iterator();
    while (localIterator.hasNext())
    {
      bo localbo = (bo)localIterator.next();
      if (localbo.e()) {
        this.mWidgetScrollGroup.removeView(localbo);
      }
    }
    this.mWidgetScrollGroup.a();
  }
  
  protected void a() {}
  
  protected void b() {}
  
  public com.gau.go.launcherex.gowidget.weather.widget.dynamicicon.a getDynamicIconManager()
  {
    return this.f;
  }
  
  public g getTimeManager()
  {
    return this.e;
  }
  
  public int getWidgetId()
  {
    return this.d;
  }
  
  public void gotoCalendar()
  {
    this.o.a(this.c.e);
  }
  
  public void gotoClock()
  {
    this.o.b(this.c.d);
  }
  
  public void gotoThemeStore()
  {
    w.a(this.a, 20);
  }
  
  public boolean isLoadingDatas()
  {
    return this.j;
  }
  
  public boolean isLocatingCity()
  {
    return this.i;
  }
  
  public boolean onApplyTheme(Bundle paramBundle)
  {
    this.B = true;
    String str = paramBundle.getString("gowidget_theme");
    this.x = paramBundle.getInt("gowidget_type");
    this.y = paramBundle.getInt("gowidget_themeid");
    this.d = paramBundle.getInt("gowidget_Id");
    if (this.y == 1) {
      this.y = 0;
    }
    if (this.A)
    {
      if ((str.equals(getContext().getPackageName())) || ("app_widget_theme_white".equals(str)) || ("app_widget_theme_black".equals(str)))
      {
        this.w = getContext().getPackageName();
        paramBundle = "app_widget_theme_white";
        this.y = 0;
      }
      while (!com.gau.go.launcherex.gowidget.weather.e.h.a(getContext(), this.d, paramBundle))
      {
        return false;
        this.w = str;
        paramBundle = str;
      }
    }
    paramBundle = com.gau.go.launcherex.gowidget.weather.e.h.a(getContext(), this.d);
    if (!TextUtils.isEmpty(paramBundle)) {
      if (paramBundle.equals("app_widget_theme_white"))
      {
        this.w = getContext().getPackageName();
        this.y = 0;
      }
    }
    for (;;)
    {
      return a(this.w);
      if (paramBundle.equals("app_widget_theme_black"))
      {
        this.w = getContext().getPackageName();
        this.y = 0;
      }
      else
      {
        this.w = paramBundle;
        this.y = 0;
        continue;
        this.w = str;
      }
    }
  }
  
  public void onBillingStatusChange(boolean paramBoolean)
  {
    this.b = paramBoolean;
    this.c.h = this.b;
    this.e.a(this.b);
    p();
  }
  
  public void onClick(View paramView)
  {
    if (paramView.equals(this.g)) {
      w.a(this.a, 31);
    }
    while (!paramView.equals(this.C)) {
      return;
    }
    w.a(this.a, 35);
  }
  
  public void onDelete(int paramInt)
  {
    super.onDelete(paramInt);
    com.gau.go.launcherex.gowidget.weather.e.h.b(getContext(), this.d);
    if (this.q != null) {}
    try
    {
      this.q.b(this.d);
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
    this.mWidgetScrollGroup = ((WidgetScrollGroup)findViewById(2131231977));
    this.mWidgetScrollGroup.a(this);
    this.g = findViewById(2131231996);
    this.g.setOnClickListener(this);
    this.C = ((TextView)findViewById(2131231997));
    this.C.setOnClickListener(this);
    e();
    a(null);
  }
  
  public void onLanguageChanged(b paramb)
  {
    super.onLanguageChanged(paramb);
    f();
  }
  
  public void onLeave(int paramInt) {}
  
  public boolean onLongClick(View paramView)
  {
    if (!this.mWidgetScrollGroup.getScreenScroller().d()) {
      return false;
    }
    performLongClick();
    return true;
  }
  
  public void onPause(int paramInt) {}
  
  public void onRemove(int paramInt)
  {
    super.onRemove(paramInt);
    this.e.b();
    this.a.unregisterReceiver(this.L);
    this.a.unregisterReceiver(this.M);
    this.a.unregisterReceiver(this.J);
    try
    {
      this.q.b(this.r);
      this.a.unbindService(this.s);
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
    this.m = paramInt;
    paramWidgetScrollGroup = (bo)paramWidgetScrollGroup.getChildAt(paramInt);
    if (paramWidgetScrollGroup != null)
    {
      paramWidgetScrollGroup = paramWidgetScrollGroup.c();
      if (paramWidgetScrollGroup != null)
      {
        this.l = paramWidgetScrollGroup.c();
        if (this.q == null) {}
      }
    }
    try
    {
      this.q.a(5, this.d, this.l);
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
    this.A = true;
    if (paramBundle == null) {}
    do
    {
      return;
      com.gtp.a.a.b.c.a("lishen", getClass().getSimpleName() + " onStart.");
      this.u = paramBundle.getBoolean("gowidget_add_to_screen");
      this.d = paramBundle.getInt("gowidget_Id");
      this.a.bindService(new Intent(this.a, WeatherService.class), this.s, 1);
    } while (this.B);
    paramBundle = com.gau.go.launcherex.gowidget.weather.e.h.a(getContext(), this.d);
    if ((TextUtils.isEmpty(paramBundle)) || (!d(paramBundle)))
    {
      this.w = getContext().getPackageName();
      this.y = 0;
    }
    for (;;)
    {
      j();
      a(this.w);
      return;
      if (paramBundle.equals("app_widget_theme_white"))
      {
        this.w = this.a.getPackageName();
        this.y = 0;
      }
      else if (paramBundle.equals("app_widget_theme_black"))
      {
        this.w = this.a.getPackageName();
        this.y = 0;
      }
      else
      {
        this.w = paramBundle;
        this.y = 0;
      }
    }
  }
  
  public void onThemeSwitcherClick()
  {
    Intent localIntent = new Intent(this.a, NotifyService.class);
    localIntent.putExtra("notify_request", 51);
    this.a.startService(localIntent);
    int i1 = this.F.size();
    if (i1 == 1) {
      b(this.a.getString(2131166572));
    }
    do
    {
      return;
      long l1 = System.currentTimeMillis();
      if ((this.D) && (l1 - this.H > 180000L))
      {
        this.D = false;
        this.H = l1;
        b(this.a.getString(2131166573));
        return;
      }
      g();
      this.G += 1;
      this.I += 1;
      this.k.removeMessages(6);
      this.k.sendEmptyMessageDelayed(6, 450L);
    } while ((i1 != 2) || (this.I % 3 != 0));
    this.D = true;
  }
  
  public void refreshWeather()
  {
    Object localObject = this.mWidgetScrollGroup.c();
    if ((((ArrayList)localObject).size() == 1) && (((bo)((ArrayList)localObject).get(0)).c() == null)) {}
    ArrayList localArrayList;
    do
    {
      return;
      localArrayList = new ArrayList();
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        WeatherBean localWeatherBean = ((bo)((Iterator)localObject).next()).c();
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
    getContext().startService((Intent)localObject);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/WeatherWidget41Style2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */