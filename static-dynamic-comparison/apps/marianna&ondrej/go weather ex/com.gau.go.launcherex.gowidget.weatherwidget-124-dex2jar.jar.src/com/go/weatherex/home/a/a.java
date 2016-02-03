package com.go.weatherex.home.a;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Toast;
import com.gau.go.launcherex.gowidget.framework.GoWidgetApplication;
import com.gau.go.launcherex.gowidget.scriptengine.parser.i;
import com.gau.go.launcherex.gowidget.scriptengine.parser.z;
import com.gau.go.launcherex.gowidget.weather.c.e;
import com.gau.go.launcherex.gowidget.weather.c.g;
import com.gau.go.launcherex.gowidget.weather.dynamicbackground.DynamicBackgroundView;
import com.gau.go.launcherex.gowidget.weather.model.NowBean;
import com.gau.go.launcherex.gowidget.weather.model.WeatherBean;
import com.gau.go.launcherex.gowidget.weather.model.q;
import com.gau.go.launcherex.gowidget.weather.util.r;
import com.gtp.go.weather.sharephoto.d.h;
import com.gtp.go.weather.sharephoto.x;
import com.jiubang.core.a.l;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class a
  extends com.go.weatherex.framework.fragment.a
{
  private DynamicBackgroundView a = null;
  private int b = -1;
  private boolean c;
  private c d;
  private ExecutorService e;
  private Handler f;
  private boolean g = true;
  private com.gau.go.launcherex.gowidget.weather.util.f h;
  private e i;
  private g j;
  private int k = 6;
  private int l = 0;
  private int m = 18;
  private int n = 0;
  private WeatherBean o = null;
  private i p;
  private int q = 0;
  private x r;
  private int s = 255;
  private boolean t = false;
  private final BroadcastReceiver u = new b(this);
  
  public static Bundle a(String paramString, boolean paramBoolean)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("cityId", paramString);
    localBundle.putBoolean("EXTRA_BG_LOADING_IMMEDIATELY_", paramBoolean);
    return localBundle;
  }
  
  private String a(int paramInt, boolean paramBoolean)
  {
    boolean bool = d();
    switch (paramInt)
    {
    default: 
      if (!bool) {
        break label258;
      }
      if (paramBoolean) {
        return "background/weather_dynamicbackground_sunny_day.xml";
      }
      break;
    case 2: 
      if (bool)
      {
        if (paramBoolean) {
          return "background/weather_dynamicbackground_sunny_day.xml";
        }
        return "background/weather_background_sunny_day.xml";
      }
      if (paramBoolean) {
        return "background/weather_dynamicbackground_sunny_night.xml";
      }
      return "background/weather_background_sunny_night.xml";
    case 3: 
      if (bool)
      {
        if (paramBoolean) {
          return "background/weather_dynamicbackground_cloudy_day.xml";
        }
        return "background/weather_background_cloudy_day.xml";
      }
      if (paramBoolean) {
        return "background/weather_dynamicbackground_cloudy_night.xml";
      }
      return "background/weather_background_cloudy_night.xml";
    case 4: 
      if (bool)
      {
        if (paramBoolean) {
          return "background/weather_dynamicbackground_overcast_day.xml";
        }
        return "background/weather_background_overcast_day.xml";
      }
      if (paramBoolean) {
        return "background/weather_dynamicbackground_overcast_night.xml";
      }
      return "background/weather_background_overcast_night.xml";
    case 5: 
      if (bool)
      {
        if (paramBoolean) {
          return "background/weather_dynamicbackground_snowy_day.xml";
        }
        return "background/weather_background_snowy_day.xml";
      }
      if (paramBoolean) {
        return "background/weather_dynamicbackground_snowy_night.xml";
      }
      return "background/weather_background_snowy_night.xml";
    case 6: 
      if (bool)
      {
        if (paramBoolean) {
          return "background/weather_dynamicbackground_foggy_day.xml";
        }
        return "background/weather_background_foggy_day.xml";
      }
      if (paramBoolean) {
        return "background/weather_dynamicbackground_foggy_night.xml";
      }
      return "background/weather_background_foggy_night.xml";
    case 7: 
      if (bool)
      {
        if (paramBoolean) {
          return "background/weather_dynamicbackground_rainy_day.xml";
        }
        return "background/weather_background_rainy_day.xml";
      }
      if (paramBoolean) {
        return "background/weather_dynamicbackground_rainy_night.xml";
      }
      return "background/weather_background_rainy_night.xml";
    case 8: 
      if (bool)
      {
        if (paramBoolean) {
          return "background/weather_dynamicbackground_thunderstorm_day.xml";
        }
        return "background/weather_background_thunderstorm_day.xml";
      }
      if (paramBoolean) {
        return "background/weather_dynamicbackground_thunderstorm_night.xml";
      }
      return "background/weather_background_thunderstorm_night.xml";
    case 1: 
      if (bool)
      {
        if (paramBoolean) {
          return "background/weather_dynamicbackground_sunny_day.xml";
        }
        return "background/weather_background_sunny_day.xml";
      }
      if (paramBoolean) {
        return "background/weather_dynamicbackground_sunny_night.xml";
      }
      return "background/weather_background_sunny_night.xml";
    }
    return "background/weather_background_sunny_day.xml";
    label258:
    if (paramBoolean) {
      return "background/weather_dynamicbackground_sunny_night.xml";
    }
    return "background/weather_background_sunny_night.xml";
  }
  
  private void a(int paramInt)
  {
    Toast.makeText(getActivity(), paramInt, 0).show();
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (this.b == 1) {}
    while (((paramInt1 != this.k) || (paramInt2 != this.l)) && ((paramInt1 != this.m) || (paramInt2 != this.n) || (this.o == null))) {
      return;
    }
    a(this.b, this.c, true);
  }
  
  private void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (com.gau.go.launcherex.gowidget.weather.globaltheme.c.d.a(this.p.a())) {}
    String str;
    z localz;
    do
    {
      do
      {
        boolean bool;
        do
        {
          return;
          bool = d();
        } while ((this.b == paramInt) && (this.g == bool) && (!paramBoolean2));
        this.b = paramInt;
        this.g = bool;
        if (this.d != null) {
          this.d.a(true);
        }
      } while (this.e == null);
      str = a(this.b, paramBoolean1);
      localz = this.p.a(str);
      if (localz != null) {
        break;
      }
      a(2131165776);
    } while (this.q >= 3);
    this.q += 1;
    this.p.b(str);
    return;
    this.q = 0;
    this.d = new c(this, localz, this.p.a());
    this.e.execute(this.d);
  }
  
  private void a(l paraml, boolean paramBoolean)
  {
    int i1 = 1;
    Message localMessage = this.f.obtainMessage(1);
    localMessage.obj = paraml;
    if (paramBoolean) {}
    for (;;)
    {
      localMessage.arg1 = i1;
      this.f.sendMessage(localMessage);
      return;
      i1 = 0;
    }
  }
  
  private void b(int paramInt, boolean paramBoolean)
  {
    if (!paramBoolean) {
      a(paramInt, this.c, false);
    }
    do
    {
      return;
      this.b = paramInt;
      this.g = d();
      str = a(this.b, this.c);
      localObject = this.p.a(str);
      if (localObject != null) {
        break;
      }
      a(2131165776);
    } while (this.q >= 3);
    this.q += 1;
    this.p.b(str);
    return;
    this.q = 0;
    String str = this.p.a();
    Object localObject = new com.gau.go.launcherex.gowidget.scriptengine.parser.c((z)localObject, getActivity(), str, false, Boolean.valueOf(false)).a(this.p.a());
    this.a.a((l)localObject, this.c);
  }
  
  private void c()
  {
    this.f = new d(this);
  }
  
  private boolean d()
  {
    if (this.o == null) {
      return this.g;
    }
    String str1 = this.o.k.j();
    String str2 = this.o.k.k();
    if ((GoWidgetApplication.b(getActivity().getApplicationContext()).b()) && (this.j.d()))
    {
      int i1 = this.o.k.n();
      return r.a(str1, str2, this.j.b(i1));
    }
    return r.a(str1, str2);
  }
  
  private void j()
  {
    int i1 = 1;
    boolean bool2 = false;
    if (this.i.a().l == 1) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      this.c = bool1;
      Object localObject = getArguments();
      String str = null;
      bool1 = bool2;
      if (localObject != null)
      {
        str = ((Bundle)localObject).getString("cityId");
        bool1 = ((Bundle)localObject).getBoolean("EXTRA_BG_LOADING_IMMEDIATELY_", false);
      }
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      this.o = this.h.a((String)localObject);
      if (this.o != null)
      {
        i1 = this.o.k.d();
        k();
      }
      if (com.gau.go.launcherex.gowidget.weather.globaltheme.c.d.a(this.p.a())) {
        break;
      }
      b(i1, bool1);
      return;
    }
    if (!h.b(x.a))
    {
      this.p.d(getActivity().getPackageName());
      b(i1, bool1);
      return;
    }
    b();
  }
  
  private void k()
  {
    Object localObject2;
    Object localObject1;
    if (this.o != null)
    {
      localObject2 = this.o.k.j();
      localObject1 = this.o.k.k();
      if ((!r.a((String)localObject2)) || (!r.a((String)localObject1))) {}
    }
    else
    {
      try
      {
        localObject2 = ((String)localObject2).split(":");
        this.k = Integer.parseInt(localObject2[0]);
        this.l = Integer.parseInt(localObject2[1]);
        localObject1 = ((String)localObject1).split(":");
        this.m = Integer.parseInt(localObject1[0]);
        this.n = Integer.parseInt(localObject1[1]);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
    }
    this.k = 6;
    this.l = 0;
    this.m = 18;
    this.n = 0;
  }
  
  public void b()
  {
    Object localObject = this.r.a();
    if (localObject != null)
    {
      a((l)localObject, false);
      return;
    }
    localObject = new Intent("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_DYNAMICBACKGROUND_LOAD_DONE");
    getActivity().sendBroadcast((Intent)localObject);
  }
  
  protected void b(int paramInt, Object paramObject)
  {
    super.b(paramInt, paramObject);
    switch (paramInt)
    {
    case 4: 
    case 5: 
    case 7: 
    case 8: 
    case 10: 
    case 11: 
    default: 
    case 6: 
    case 9: 
    case 12: 
      do
      {
        do
        {
          return;
          this.t = ((Boolean)paramObject).booleanValue();
          return;
        } while (this.t);
        this.s = ((int)((1.0F - ((Float)paramObject).floatValue()) * 255.0F));
        this.a.a(this.s);
        this.a.e();
        return;
        paramObject = (String)paramObject;
        this.o = this.h.a((String)paramObject);
        k();
      } while (this.o == null);
      a(this.o.k.d(), this.c, false);
      return;
    case 3: 
      if (!this.t) {
        if (this.s != 0) {
          this.a.a((int)((1.0F - ((Float)paramObject).floatValue()) * 255.0F));
        }
      }
      for (;;)
      {
        this.a.e();
        return;
        this.a.a((int)((1.0F - ((Float)paramObject).floatValue()) * this.s));
      }
    case 13: 
      if (((Boolean)paramObject).booleanValue()) {
        this.a.a(0);
      }
      for (;;)
      {
        this.a.e();
        return;
        this.a.a(this.s);
      }
    }
    paramInt = ((Integer)paramObject).intValue();
    this.a.scrollTo(this.a.getScrollX(), -paramInt);
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    a(new int[] { 9, 12, 3, 6, 13, 14 });
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.a = new DynamicBackgroundView(getActivity());
    this.a.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.a.setId(2131230727);
    return this.a;
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    if (this.d != null) {
      this.d.a(true);
    }
    if (this.u != null) {
      getActivity().unregisterReceiver(this.u);
    }
    com.jiubang.core.a.f.b(this.a);
    com.jiubang.core.a.f.a();
    this.a.b();
    this.e.shutdown();
    this.e = null;
  }
  
  public void onStart()
  {
    super.onStart();
    com.jiubang.core.a.f.d();
    this.a.d();
  }
  
  public void onStop()
  {
    super.onStop();
    com.jiubang.core.a.f.c();
    this.a.c();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    c();
    paramView = com.gau.go.launcherex.gowidget.weather.c.c.a(getActivity().getApplicationContext());
    this.p = paramView.d();
    this.r = new x(getActivity());
    this.e = Executors.newFixedThreadPool(1);
    this.h = paramView.h();
    this.i = paramView.f();
    this.j = paramView.g();
    paramView = new IntentFilter();
    paramView.addAction("android.intent.action.TIME_TICK");
    paramView.addAction("android.intent.action.TIME_SET");
    paramView.addAction("android.intent.action.TIMEZONE_CHANGED");
    paramView.addAction("com.gau.go.launcherex.gowidget.weatherwidget.goweather.ACTION_UPDATE_DATA");
    paramView.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_SCREEN_BACKGROUND_LOADING_FINISH");
    paramView.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_BACKGROUND_CHANGE_FINISH");
    paramView.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_WORLD_CLOCK");
    paramView.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_CHANGE_DYNAMIC_BG");
    paramView.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_DYNAMICBACKGROUND_ONE_RELOAD_DONE");
    getActivity().registerReceiver(this.u, paramView);
    j();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/home/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */