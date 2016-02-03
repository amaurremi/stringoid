package com.gau.go.launcherex.gowidget.scriptengine.parser;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.gau.go.launcherex.gowidget.weather.c.b;
import com.gau.go.launcherex.gowidget.weather.c.c;
import com.gau.go.launcherex.gowidget.weather.f.g;
import com.gau.go.launcherex.gowidget.weather.model.q;
import com.gau.go.launcherex.gowidget.weather.util.o;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.xmlpull.v1.XmlPullParser;

public class i
  extends b
{
  public static int[] d = { 2130838042, 2130838046, 2130838047, 2130838039, 2130838040, 2130838043, 2130838045, 2130838041, 2130838044, 2130838048 };
  public static int[] e = { 2130838983, 2130838987, 2130838988, 2130838980, 2130838981, 2130838984, 2130838986, 2130838982, 2130838985, 2130838989 };
  public static int[] f = { 2130838993, 2130838997, 2130838998, 2130838990, 2130838991, 2130838994, 2130838996, 2130838992, 2130838995, 2130838999 };
  public static final int[] g = { 2130837647, 2130837651, 2130837652, 2130837644, 2130837645, 2130837648, 2130837650, 2130837646, 2130837649, 2130837653 };
  public static final int[] h = { 2130837916, 2130837920, 2130837921, 2130837913, 2130837914, 2130837917, 2130837919, 2130837915, 2130837918, 2130837922 };
  public static final int[] i = { 2130838917, 2130838914, 2130838915, 2130838908, 2130838909, 2130838910, 2130838913, 2130838911, 2130838912, 2130838916 };
  public static int[] j = new int[10];
  ConcurrentHashMap a;
  ConcurrentHashMap b;
  public String[] c = new String[10];
  private String k;
  private Context l;
  private Handler m;
  private ExecutorService n;
  private int o;
  private Resources p;
  private k q;
  private BroadcastReceiver r;
  private boolean s;
  private int t = -1;
  private boolean u = true;
  private q v;
  private HashMap w;
  
  public i()
  {
    this.w = new HashMap();
  }
  
  public i(Context paramContext)
  {
    this.l = paramContext;
    this.a = new ConcurrentHashMap();
    this.b = new ConcurrentHashMap();
    this.k = this.l.getPackageName();
    c();
    this.n = Executors.newCachedThreadPool();
    this.w = new HashMap();
    this.q = new k(this, null);
    paramContext = new IntentFilter();
    paramContext.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_APP_THEME_CHANGE");
    this.l.registerReceiver(this.q, paramContext);
    this.r = new m(this, null);
    paramContext = new IntentFilter();
    paramContext.addAction("android.intent.action.PACKAGE_REMOVED");
    paramContext.addAction("android.intent.action.PACKAGE_REPLACED");
    paramContext.addDataScheme("package");
    this.l.registerReceiver(this.r, paramContext);
  }
  
  private ArrayList c(boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramBoolean)
    {
      localArrayList.add("background/weather_dynamicbackground_sunny_day.xml");
      localArrayList.add("background/weather_dynamicbackground_sunny_night.xml");
      localArrayList.add("background/weather_dynamicbackground_cloudy_day.xml");
      localArrayList.add("background/weather_dynamicbackground_cloudy_night.xml");
      localArrayList.add("background/weather_dynamicbackground_overcast_day.xml");
      localArrayList.add("background/weather_dynamicbackground_overcast_night.xml");
      localArrayList.add("background/weather_dynamicbackground_rainy_day.xml");
      localArrayList.add("background/weather_dynamicbackground_rainy_night.xml");
      localArrayList.add("background/weather_dynamicbackground_snowy_day.xml");
      localArrayList.add("background/weather_dynamicbackground_snowy_night.xml");
      localArrayList.add("background/weather_dynamicbackground_foggy_day.xml");
      localArrayList.add("background/weather_dynamicbackground_foggy_night.xml");
      localArrayList.add("background/weather_dynamicbackground_thunderstorm_day.xml");
      localArrayList.add("background/weather_dynamicbackground_thunderstorm_night.xml");
      return localArrayList;
    }
    localArrayList.add("background/weather_background_sunny_day.xml");
    localArrayList.add("background/weather_background_sunny_night.xml");
    localArrayList.add("background/weather_background_cloudy_day.xml");
    localArrayList.add("background/weather_background_cloudy_night.xml");
    localArrayList.add("background/weather_background_overcast_day.xml");
    localArrayList.add("background/weather_background_overcast_night.xml");
    localArrayList.add("background/weather_background_rainy_day.xml");
    localArrayList.add("background/weather_background_rainy_night.xml");
    localArrayList.add("background/weather_background_snowy_day.xml");
    localArrayList.add("background/weather_background_snowy_night.xml");
    localArrayList.add("background/weather_background_foggy_day.xml");
    localArrayList.add("background/weather_background_foggy_night.xml");
    localArrayList.add("background/weather_background_thunderstorm_day.xml");
    localArrayList.add("background/weather_background_thunderstorm_night.xml");
    return localArrayList;
  }
  
  private void c()
  {
    this.m = new l(this);
  }
  
  private void d()
  {
    Message localMessage = Message.obtain();
    localMessage.what = 3;
    this.m.sendMessageDelayed(localMessage, 100L);
  }
  
  private void e(String paramString)
  {
    this.k = paramString;
  }
  
  public z a(String paramString)
  {
    z localz2 = (z)this.a.get(paramString);
    z localz1 = localz2;
    if (localz2 == null)
    {
      localz1 = localz2;
      if (this.b != null) {
        localz1 = (z)this.b.get(paramString);
      }
    }
    return localz1;
  }
  
  public String a()
  {
    return this.k;
  }
  
  public void a(Context paramContext)
  {
    try
    {
      this.l = paramContext.getApplicationContext().createPackageContext(this.k, 2);
      this.p = this.l.getResources();
      if (this.p == null) {
        this.p = paramContext.getApplicationContext().getResources();
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  public void a(o paramo)
  {
    boolean bool = true;
    super.a(paramo);
    this.v = c.a(this.l).f().a();
    if (this.v.l == 1) {}
    for (;;)
    {
      a(bool);
      d(this.v.d);
      b(this.l);
      return;
      bool = false;
    }
  }
  
  public void a(String paramString, ac paramac)
  {
    this.w.put(paramString, paramac);
  }
  
  public void a(boolean paramBoolean)
  {
    this.s = paramBoolean;
  }
  
  public void b(Context paramContext)
  {
    a(paramContext);
    Object localObject1 = "main_interface_theme.xml".replace(".xml", "");
    Object localObject2 = g.b(paramContext, this.k, (String)localObject1);
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = g.a(paramContext, this.k, "main_interface_theme.xml");
    }
    if (localObject1 == null) {}
    for (;;)
    {
      return;
      localObject2 = g.a((InputStream)localObject1);
      this.w.clear();
      e.a();
      if (localObject2 != null) {
        new w().a((XmlPullParser)localObject2, c.a(paramContext).d());
      }
      try
      {
        ((InputStream)localObject1).close();
        int i1 = 0;
        while (i1 < 10)
        {
          j[i1] = c(this.c[i1]);
          i1 += 1;
        }
      }
      catch (IOException paramContext)
      {
        for (;;)
        {
          paramContext.printStackTrace();
        }
      }
    }
  }
  
  public void b(String paramString)
  {
    this.t = 5;
    this.n.execute(new n(this, this.l, paramString, this.t, false, false));
  }
  
  public void b(boolean paramBoolean)
  {
    this.s = paramBoolean;
    this.m.sendEmptyMessageDelayed(0, 100L);
  }
  
  public int c(String paramString)
  {
    int i1 = 0;
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      i1 = this.p.getIdentifier(paramString, "drawable", this.k);
      return i1;
    }
    catch (Exception paramString) {}
    return 0;
  }
  
  public void d(String paramString)
  {
    this.k = paramString;
    this.m.sendEmptyMessageDelayed(0, 100L);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/scriptengine/parser/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */