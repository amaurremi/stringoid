package com.gau.go.launcherex.gowidget.weather.view;

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
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import com.gau.go.launcherex.gowidget.framework.GoWidgetFrame;
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
import com.gau.go.launcherex.gowidget.weather.service.c;
import com.gau.go.launcherex.gowidget.weather.service.f;
import com.gau.go.launcherex.gowidget.weather.systemwidget.al;
import com.gau.go.launcherex.gowidget.weather.util.p;
import com.gau.go.launcherex.gowidget.weather.util.r;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class WeatherWidget42
  extends GoWidgetFrame
  implements View.OnClickListener, View.OnLongClickListener, m
{
  private boolean A = false;
  private com.gau.go.launcherex.gowidget.weather.globaltheme.d B;
  private ArrayList C;
  private int D;
  private long E;
  private int F;
  private cz G;
  private final BroadcastReceiver H = new cx(this);
  private final BroadcastReceiver I = new cy(this);
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
  private TextView t;
  private al u;
  private g v = null;
  private da w;
  private f x;
  private c y;
  private ServiceConnection z = null;
  
  public WeatherWidget42(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    d();
  }
  
  private bg a(WeatherBean paramWeatherBean)
  {
    bg localbg = i();
    localbg.a(paramWeatherBean);
    this.r.addView(localbg);
    this.r.a();
    return localbg;
  }
  
  private void a(int paramInt)
  {
    this.v.a(0, paramInt);
    Iterator localIterator = this.r.c().iterator();
    while (localIterator.hasNext())
    {
      bg localbg = (bg)localIterator.next();
      localbg.a(localbg.c());
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
        this.f = paramBundle.getString("go_widget_theme");
        c(this.f);
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
      if (paramBundle.containsKey("widget_theme_switcher"))
      {
        localWidgetSettingBean = this.c;
        if (r.a(paramBundle, "widget_theme_switcher") == 1) {}
        for (bool1 = bool5;; bool1 = false)
        {
          localWidgetSettingBean.l = bool1;
          b(this.c.l);
          return;
        }
      }
      if (paramBundle.containsKey("calendarType"))
      {
        localWidgetSettingBean = this.c;
        if (r.a(paramBundle, "calendarType") == 1) {}
        for (bool1 = bool6;; bool1 = false)
        {
          localWidgetSettingBean.j = bool1;
          this.v.b(this.c.j);
          p();
          return;
        }
      }
      if (paramBundle.containsKey("festival"))
      {
        this.c.k = r.a(paramBundle, "festival");
        this.v.d(this.c.k);
        q();
        return;
      }
    } while (!paramBundle.containsKey("windUnit"));
    this.c.b = r.a(paramBundle, "windUnit");
    r();
  }
  
  private void a(WidgetSettingBean paramWidgetSettingBean, List paramList, String paramString)
  {
    this.c = paramWidgetSettingBean;
    this.r.a(this.c.f);
    this.b = this.x.d();
    paramWidgetSettingBean = this.v;
    if ((this.b) && (this.c.h)) {}
    for (boolean bool = true;; bool = false)
    {
      paramWidgetSettingBean.a(bool);
      this.v.b(this.c.j);
      this.v.d(this.c.k);
      this.v.a(0, this.c.c);
      a(paramList);
      g();
      a(this.x.e());
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
  
  /* Error */
  private boolean a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 327	com/gau/go/launcherex/gowidget/weather/view/WeatherWidget42:getContext	()Landroid/content/Context;
    //   4: invokevirtual 359	android/content/Context:getPackageName	()Ljava/lang/String;
    //   7: ldc_w 361
    //   10: invokevirtual 367	java/lang/String:length	()I
    //   13: invokevirtual 371	java/lang/String:substring	(I)Ljava/lang/String;
    //   16: astore 4
    //   18: new 373	java/lang/StringBuilder
    //   21: dup
    //   22: invokespecial 374	java/lang/StringBuilder:<init>	()V
    //   25: ldc_w 376
    //   28: invokevirtual 380	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: aload 4
    //   33: invokevirtual 380	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: ldc_w 382
    //   39: invokevirtual 380	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: invokevirtual 385	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: astore_2
    //   46: aload_0
    //   47: invokevirtual 327	com/gau/go/launcherex/gowidget/weather/view/WeatherWidget42:getContext	()Landroid/content/Context;
    //   50: aload_1
    //   51: aload_2
    //   52: invokestatic 390	com/gau/go/launcherex/gowidget/weather/f/g:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/io/InputStream;
    //   55: astore_3
    //   56: aload_3
    //   57: astore_2
    //   58: aload_3
    //   59: ifnonnull +38 -> 97
    //   62: new 373	java/lang/StringBuilder
    //   65: dup
    //   66: invokespecial 374	java/lang/StringBuilder:<init>	()V
    //   69: ldc_w 376
    //   72: invokevirtual 380	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: aload 4
    //   77: invokevirtual 380	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: invokevirtual 385	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   83: astore_2
    //   84: aload_0
    //   85: invokevirtual 327	com/gau/go/launcherex/gowidget/weather/view/WeatherWidget42:getContext	()Landroid/content/Context;
    //   88: aload_0
    //   89: getfield 75	com/gau/go/launcherex/gowidget/weather/view/WeatherWidget42:f	Ljava/lang/String;
    //   92: aload_2
    //   93: invokestatic 392	com/gau/go/launcherex/gowidget/weather/f/g:b	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/io/InputStream;
    //   96: astore_2
    //   97: aload_2
    //   98: ifnonnull +5 -> 103
    //   101: iconst_0
    //   102: ireturn
    //   103: aload_2
    //   104: invokestatic 395	com/gau/go/launcherex/gowidget/weather/f/g:a	(Ljava/io/InputStream;)Lorg/xmlpull/v1/XmlPullParser;
    //   107: astore_3
    //   108: aload_0
    //   109: new 397	com/gau/go/launcherex/gowidget/weather/f/a
    //   112: dup
    //   113: invokespecial 398	com/gau/go/launcherex/gowidget/weather/f/a:<init>	()V
    //   116: putfield 71	com/gau/go/launcherex/gowidget/weather/view/WeatherWidget42:e	Lcom/gau/go/launcherex/gowidget/weather/f/a;
    //   119: aload_0
    //   120: getfield 71	com/gau/go/launcherex/gowidget/weather/view/WeatherWidget42:e	Lcom/gau/go/launcherex/gowidget/weather/f/a;
    //   123: aload_1
    //   124: putfield 400	com/gau/go/launcherex/gowidget/weather/f/a:a	Ljava/lang/String;
    //   127: aload_0
    //   128: getfield 71	com/gau/go/launcherex/gowidget/weather/view/WeatherWidget42:e	Lcom/gau/go/launcherex/gowidget/weather/f/a;
    //   131: ldc_w 402
    //   134: iconst_0
    //   135: invokestatic 405	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   138: invokevirtual 408	com/gau/go/launcherex/gowidget/weather/f/a:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   141: aload_0
    //   142: getfield 71	com/gau/go/launcherex/gowidget/weather/view/WeatherWidget42:e	Lcom/gau/go/launcherex/gowidget/weather/f/a;
    //   145: ldc_w 410
    //   148: aload_0
    //   149: getfield 77	com/gau/go/launcherex/gowidget/weather/view/WeatherWidget42:g	I
    //   152: invokestatic 405	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   155: invokevirtual 408	com/gau/go/launcherex/gowidget/weather/f/a:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   158: aload_3
    //   159: ifnull +18 -> 177
    //   162: new 412	com/gau/go/launcherex/gowidget/weather/f/d
    //   165: dup
    //   166: invokespecial 413	com/gau/go/launcherex/gowidget/weather/f/d:<init>	()V
    //   169: aload_3
    //   170: aload_0
    //   171: getfield 71	com/gau/go/launcherex/gowidget/weather/view/WeatherWidget42:e	Lcom/gau/go/launcherex/gowidget/weather/f/a;
    //   174: invokevirtual 416	com/gau/go/launcherex/gowidget/weather/f/d:a	(Lorg/xmlpull/v1/XmlPullParser;Lcom/gau/go/launcherex/gowidget/weather/f/a;)V
    //   177: aload_2
    //   178: invokevirtual 421	java/io/InputStream:close	()V
    //   181: aload_0
    //   182: aload_0
    //   183: invokevirtual 327	com/gau/go/launcherex/gowidget/weather/view/WeatherWidget42:getContext	()Landroid/content/Context;
    //   186: invokevirtual 425	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   189: aload_1
    //   190: invokevirtual 431	android/content/pm/PackageManager:getResourcesForApplication	(Ljava/lang/String;)Landroid/content/res/Resources;
    //   193: putfield 79	com/gau/go/launcherex/gowidget/weather/view/WeatherWidget42:h	Landroid/content/res/Resources;
    //   196: aload_0
    //   197: getfield 71	com/gau/go/launcherex/gowidget/weather/view/WeatherWidget42:e	Lcom/gau/go/launcherex/gowidget/weather/f/a;
    //   200: aload_0
    //   201: getfield 79	com/gau/go/launcherex/gowidget/weather/view/WeatherWidget42:h	Landroid/content/res/Resources;
    //   204: putfield 433	com/gau/go/launcherex/gowidget/weather/f/a:b	Landroid/content/res/Resources;
    //   207: aload_0
    //   208: getfield 71	com/gau/go/launcherex/gowidget/weather/view/WeatherWidget42:e	Lcom/gau/go/launcherex/gowidget/weather/f/a;
    //   211: ldc_w 435
    //   214: invokevirtual 437	com/gau/go/launcherex/gowidget/weather/f/a:a	(Ljava/lang/String;)Ljava/lang/String;
    //   217: astore_2
    //   218: aload_0
    //   219: getfield 79	com/gau/go/launcherex/gowidget/weather/view/WeatherWidget42:h	Landroid/content/res/Resources;
    //   222: aload_2
    //   223: aload_1
    //   224: invokestatic 440	com/gau/go/launcherex/gowidget/weather/f/d:a	(Landroid/content/res/Resources;Ljava/lang/String;Ljava/lang/String;)Landroid/graphics/drawable/Drawable;
    //   227: astore_1
    //   228: aload_0
    //   229: getfield 83	com/gau/go/launcherex/gowidget/weather/view/WeatherWidget42:r	Lcom/gau/go/launcherex/gowidget/weather/scroller/WidgetScrollGroup;
    //   232: aload_1
    //   233: invokevirtual 444	com/gau/go/launcherex/gowidget/weather/scroller/WidgetScrollGroup:setBackgroundDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   236: aload_0
    //   237: getfield 83	com/gau/go/launcherex/gowidget/weather/view/WeatherWidget42:r	Lcom/gau/go/launcherex/gowidget/weather/scroller/WidgetScrollGroup;
    //   240: invokevirtual 159	com/gau/go/launcherex/gowidget/weather/scroller/WidgetScrollGroup:c	()Ljava/util/ArrayList;
    //   243: invokevirtual 165	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   246: astore_1
    //   247: aload_1
    //   248: invokeinterface 171 1 0
    //   253: ifeq +27 -> 280
    //   256: aload_1
    //   257: invokeinterface 175 1 0
    //   262: checkcast 132	com/gau/go/launcherex/gowidget/weather/view/bg
    //   265: aload_0
    //   266: getfield 71	com/gau/go/launcherex/gowidget/weather/view/WeatherWidget42:e	Lcom/gau/go/launcherex/gowidget/weather/f/a;
    //   269: invokevirtual 447	com/gau/go/launcherex/gowidget/weather/view/bg:a	(Lcom/gau/go/launcherex/gowidget/weather/f/a;)V
    //   272: goto -25 -> 247
    //   275: astore_1
    //   276: aload_1
    //   277: invokevirtual 450	android/content/pm/PackageManager$NameNotFoundException:printStackTrace	()V
    //   280: aload_0
    //   281: getfield 83	com/gau/go/launcherex/gowidget/weather/view/WeatherWidget42:r	Lcom/gau/go/launcherex/gowidget/weather/scroller/WidgetScrollGroup;
    //   284: invokevirtual 453	com/gau/go/launcherex/gowidget/weather/scroller/WidgetScrollGroup:requestLayout	()V
    //   287: iconst_1
    //   288: ireturn
    //   289: astore_2
    //   290: aload_2
    //   291: invokevirtual 454	java/io/IOException:printStackTrace	()V
    //   294: goto -113 -> 181
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	297	0	this	WeatherWidget42
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
  
  private void b(String paramString)
  {
    this.t.setText(paramString);
    this.t.setVisibility(0);
    paramString = AnimationUtils.loadAnimation(this.a, 2130968620);
    paramString.setDuration(200L);
    this.t.startAnimation(paramString);
    this.t.postDelayed(new cw(this), 3000L);
  }
  
  private void b(boolean paramBoolean)
  {
    Iterator localIterator = this.r.c().iterator();
    while (localIterator.hasNext()) {
      ((bg)localIterator.next()).c(paramBoolean);
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
    e();
  }
  
  private void d()
  {
    this.z = new cu(this);
    this.w = new da(this);
    k();
    this.v = new g(getContext());
    this.f = getContext().getPackageName();
    this.u = new al(this.a);
    this.C = com.gau.go.launcherex.gowidget.weather.globaltheme.c.d.e(this.a, getResources());
    this.B = new com.gau.go.launcherex.gowidget.weather.globaltheme.d(this.a);
  }
  
  private void d(boolean paramBoolean)
  {
    this.r.a(paramBoolean);
  }
  
  private void e()
  {
    Iterator localIterator = this.r.c().iterator();
    while (localIterator.hasNext()) {
      ((bg)localIterator.next()).l();
    }
  }
  
  private void e(boolean paramBoolean)
  {
    Iterator localIterator = this.r.c().iterator();
    while (localIterator.hasNext()) {
      ((bg)localIterator.next()).b(paramBoolean);
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
    this.G = new cz(this, null);
    localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.PACKAGE_ADDED");
    localIntentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
    localIntentFilter.addDataScheme("package");
    this.a.registerReceiver(this.G, localIntentFilter);
  }
  
  private void g()
  {
    try
    {
      this.i = this.x.a(this.d);
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
      WeatherBean localWeatherBean = ((bg)this.r.getChildAt(i1)).j();
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
  
  private bg i()
  {
    bg localbg = new bg(this.a);
    localbg.a(this.v);
    localbg.setOnLongClickListener(this);
    localbg.a(this);
    localbg.a(this.a.getString(2131166457));
    localbg.c(this.c.l);
    if (this.e != null) {
      localbg.a(this.e);
    }
    return localbg;
  }
  
  private void j()
  {
    Iterator localIterator = this.r.c().iterator();
    while (localIterator.hasNext())
    {
      bg localbg = (bg)localIterator.next();
      if (localbg.g()) {
        this.r.removeView(localbg);
      }
    }
    this.r.a();
  }
  
  private void k()
  {
    this.y = new cv(this);
  }
  
  private void l()
  {
    Iterator localIterator = this.r.c().iterator();
    while (localIterator.hasNext()) {
      ((bg)localIterator.next()).m();
    }
  }
  
  private void m()
  {
    if (this.f.equals(getContext().getPackageName())) {
      this.D = (this.C.size() - 1);
    }
    for (;;)
    {
      return;
      int i1 = 0;
      while (i1 < this.C.size())
      {
        e locale = (e)this.C.get(i1);
        if (this.f.equals(locale.x()))
        {
          this.D = i1;
          return;
        }
        i1 += 1;
      }
    }
  }
  
  private void n()
  {
    Iterator localIterator = this.r.c().iterator();
    while (localIterator.hasNext()) {
      ((bg)localIterator.next()).e();
    }
  }
  
  private void o()
  {
    Object localObject = this.r.c();
    Iterator localIterator = ((ArrayList)localObject).iterator();
    bg localbg;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localbg = (bg)localIterator.next();
    } while (localbg.j().e() == 1);
    for (;;)
    {
      if (localbg != null)
      {
        if ((localbg.i() != 3) && (((ArrayList)localObject).size() != 1)) {
          break label72;
        }
        localbg.a(1);
      }
      label72:
      int i1;
      do
      {
        return;
        localObject = this.r.getChildAt(this.j);
        this.r.removeView(localbg);
        this.r.a();
        i1 = this.r.indexOfChild((View)localObject);
      } while (i1 == -1);
      this.r.a(i1);
      return;
      localbg = null;
    }
  }
  
  private void p()
  {
    Iterator localIterator = this.r.c().iterator();
    while (localIterator.hasNext())
    {
      bg localbg = (bg)localIterator.next();
      localbg.c(localbg.c());
    }
  }
  
  private void q()
  {
    Iterator localIterator = this.r.c().iterator();
    while (localIterator.hasNext())
    {
      bg localbg = (bg)localIterator.next();
      localbg.b(localbg.c());
    }
  }
  
  private void r()
  {
    Iterator localIterator = this.r.c().iterator();
    while (localIterator.hasNext()) {
      ((bg)localIterator.next()).f();
    }
  }
  
  private void s()
  {
    Iterator localIterator = this.r.c().iterator();
    while (localIterator.hasNext()) {
      ((bg)localIterator.next()).a(true);
    }
  }
  
  private void t()
  {
    ArrayList localArrayList = this.r.c();
    int i2 = localArrayList.size();
    int i1 = 0;
    if (i1 < i2)
    {
      bg localbg = (bg)localArrayList.get(i1);
      localbg.a(true);
      if (this.r.b() == i1) {
        localbg.a(getDynamicIconManager(), this.b, false, true);
      }
      for (;;)
      {
        i1 += 1;
        break;
        localbg.a(null, this.b, false, false);
      }
    }
  }
  
  private void u()
  {
    this.n = true;
    Object localObject = this.r.c().iterator();
    while (((Iterator)localObject).hasNext())
    {
      bg localbg = (bg)((Iterator)localObject).next();
      this.r.removeView(localbg);
    }
    localObject = a(null);
    ((bg)localObject).a(this.a.getString(2131166455));
    ((bg)localObject).a(true);
    this.r.a(0);
  }
  
  public void doRefresh()
  {
    Object localObject = this.r.c();
    if ((((ArrayList)localObject).size() == 1) && (((bg)((ArrayList)localObject).get(0)).g())) {}
    ArrayList localArrayList;
    do
    {
      return;
      localArrayList = new ArrayList();
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        WeatherBean localWeatherBean = ((bg)((Iterator)localObject).next()).j();
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
  
  public g getTimeManager()
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
    this.v.a(this.b);
    e();
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
    if (this.x != null) {}
    try
    {
      this.x.b(this.d);
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
    this.a.unregisterReceiver(this.G);
    this.B.a();
    try
    {
      this.x.b(this.y);
      this.a.unbindService(this.z);
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
      this.i = ((bg)paramWidgetScrollGroup).h();
      if (this.x == null) {}
    }
    try
    {
      this.x.a(0, this.d, this.i);
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
      this.a.bindService(new Intent(this.a, WeatherService.class), this.z, 1);
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
      m();
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
  
  public void onThemeSwitcherClick()
  {
    Intent localIntent = new Intent(this.a, NotifyService.class);
    localIntent.putExtra("notify_request", 51);
    this.a.startService(localIntent);
    int i1 = this.C.size();
    if (i1 == 1) {
      b(this.a.getString(2131166572));
    }
    do
    {
      return;
      long l1 = System.currentTimeMillis();
      if ((this.A) && (l1 - this.E > 180000L))
      {
        this.A = false;
        this.E = l1;
        b(this.a.getString(2131166573));
        return;
      }
      l();
      this.D += 1;
      this.F += 1;
      this.w.removeMessages(18);
      this.w.sendEmptyMessageDelayed(18, 450L);
    } while ((i1 != 2) || (this.F % 3 != 0));
    this.A = true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/WeatherWidget42.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */