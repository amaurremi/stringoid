package com.gau.go.launcherex.gowidget.weather.b;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.text.format.Time;
import android.widget.RemoteViews;
import com.gau.go.launcherex.gowidget.framework.GoWidgetApplication;
import com.gau.go.launcherex.gowidget.weather.c.c;
import com.gau.go.launcherex.gowidget.weather.c.e;
import com.gau.go.launcherex.gowidget.weather.c.g;
import com.gau.go.launcherex.gowidget.weather.model.NowBean;
import com.gau.go.launcherex.gowidget.weather.model.WeatherBean;
import com.gau.go.launcherex.gowidget.weather.util.r;
import com.gau.go.launcherex.gowidget.weather.view.WeatherDetailActivity;
import java.util.Map;

public class ag
{
  private static final int[] o = { 2130838361, 2130838369, 2130838370, 2130838353, 2130838354, 2130838363, 2130838367, 2130838359, 2130838365, 2130838373 };
  private static final int[] p = { 2130838362, 2130838372, 2130838371, 2130838356, 2130838355, 2130838364, 2130838368, 2130838360, 2130838366, 2130838374 };
  private static final int[] q = { 2130838071, 2130838068, 2130838069, 2130838062, 2130838063, 2130838064, 2130838067, 2130838065, 2130838066, 2130838070 };
  private Context a;
  private ah b = null;
  private NotificationManager c = null;
  private Notification d = null;
  private com.gau.go.launcherex.gowidget.weather.util.f e = null;
  private g f = null;
  private e g = null;
  private com.gau.go.launcherex.gowidget.weather.model.q h = null;
  private String i = null;
  private int j = 0;
  private int k;
  private int l;
  private int m;
  private int n;
  private int[] r;
  private int s;
  private int t;
  private int u;
  private int v;
  
  public ag(Context paramContext)
  {
    this.a = paramContext;
  }
  
  private int a(int paramInt)
  {
    if (paramInt <= 0)
    {
      switch (paramInt)
      {
      default: 
        return 0;
      case 0: 
        return 2130838598;
      case -1: 
        return 2130838749;
      case -2: 
        return 2130838760;
      case -3: 
        return 2130838771;
      case -4: 
        return 2130838782;
      case -5: 
        return 2130838793;
      case -6: 
        return 2130838804;
      case -7: 
        return 2130838815;
      case -8: 
        return 2130838826;
      case -9: 
        return 2130838837;
      case -10: 
        return 2130838750;
      case -11: 
        return 2130838751;
      case -12: 
        return 2130838752;
      case -13: 
        return 2130838753;
      case -14: 
        return 2130838754;
      case -15: 
        return 2130838755;
      case -16: 
        return 2130838756;
      case -17: 
        return 2130838757;
      case -18: 
        return 2130838758;
      case -19: 
        return 2130838759;
      case -20: 
        return 2130838761;
      case -21: 
        return 2130838762;
      case -22: 
        return 2130838763;
      case -23: 
        return 2130838764;
      case -24: 
        return 2130838765;
      case -25: 
        return 2130838766;
      case -26: 
        return 2130838767;
      case -27: 
        return 2130838768;
      case -28: 
        return 2130838769;
      case -29: 
        return 2130838770;
      case -30: 
        return 2130838772;
      case -31: 
        return 2130838773;
      case -32: 
        return 2130838774;
      case -33: 
        return 2130838775;
      case -34: 
        return 2130838776;
      case -35: 
        return 2130838777;
      case -36: 
        return 2130838778;
      case -37: 
        return 2130838779;
      case -38: 
        return 2130838780;
      case -39: 
        return 2130838781;
      case -40: 
        return 2130838783;
      case -41: 
        return 2130838784;
      case -42: 
        return 2130838785;
      case -43: 
        return 2130838786;
      case -44: 
        return 2130838787;
      case -45: 
        return 2130838788;
      case -46: 
        return 2130838789;
      case -47: 
        return 2130838790;
      case -48: 
        return 2130838791;
      case -49: 
        return 2130838792;
      case -50: 
        return 2130838794;
      case -51: 
        return 2130838795;
      case -52: 
        return 2130838796;
      case -53: 
        return 2130838797;
      case -54: 
        return 2130838798;
      case -55: 
        return 2130838799;
      case -56: 
        return 2130838800;
      case -57: 
        return 2130838801;
      case -58: 
        return 2130838802;
      case -59: 
        return 2130838803;
      case -60: 
        return 2130838805;
      case -61: 
        return 2130838806;
      case -62: 
        return 2130838807;
      case -63: 
        return 2130838808;
      case -64: 
        return 2130838809;
      case -65: 
        return 2130838810;
      case -66: 
        return 2130838811;
      case -67: 
        return 2130838812;
      case -68: 
        return 2130838813;
      case -69: 
        return 2130838814;
      case -70: 
        return 2130838816;
      case -71: 
        return 2130838817;
      case -72: 
        return 2130838818;
      case -73: 
        return 2130838819;
      case -74: 
        return 2130838820;
      case -75: 
        return 2130838821;
      case -76: 
        return 2130838822;
      case -77: 
        return 2130838823;
      case -78: 
        return 2130838824;
      case -79: 
        return 2130838825;
      case -80: 
        return 2130838827;
      case -81: 
        return 2130838828;
      case -82: 
        return 2130838829;
      case -83: 
        return 2130838830;
      case -84: 
        return 2130838831;
      case -85: 
        return 2130838832;
      case -86: 
        return 2130838833;
      case -87: 
        return 2130838834;
      case -88: 
        return 2130838835;
      case -89: 
        return 2130838836;
      case -90: 
        return 2130838838;
      case -91: 
        return 2130838839;
      case -92: 
        return 2130838840;
      case -93: 
        return 2130838841;
      case -94: 
        return 2130838842;
      case -95: 
        return 2130838843;
      case -96: 
        return 2130838844;
      case -97: 
        return 2130838845;
      case -98: 
        return 2130838846;
      }
      return 2130838847;
    }
    switch (paramInt)
    {
    default: 
      return 0;
    case 1: 
      return 2130838599;
    case 2: 
      return 2130838661;
    case 3: 
      return 2130838672;
    case 4: 
      return 2130838683;
    case 5: 
      return 2130838694;
    case 6: 
      return 2130838705;
    case 7: 
      return 2130838716;
    case 8: 
      return 2130838727;
    case 9: 
      return 2130838738;
    case 10: 
      return 2130838600;
    case 11: 
      return 2130838611;
    case 12: 
      return 2130838622;
    case 13: 
      return 2130838633;
    case 14: 
      return 2130838644;
    case 15: 
      return 2130838655;
    case 16: 
      return 2130838657;
    case 17: 
      return 2130838658;
    case 18: 
      return 2130838659;
    case 19: 
      return 2130838660;
    case 20: 
      return 2130838662;
    case 21: 
      return 2130838663;
    case 22: 
      return 2130838664;
    case 23: 
      return 2130838665;
    case 24: 
      return 2130838666;
    case 25: 
      return 2130838667;
    case 26: 
      return 2130838668;
    case 27: 
      return 2130838669;
    case 28: 
      return 2130838670;
    case 29: 
      return 2130838671;
    case 30: 
      return 2130838673;
    case 31: 
      return 2130838674;
    case 32: 
      return 2130838675;
    case 33: 
      return 2130838676;
    case 34: 
      return 2130838677;
    case 35: 
      return 2130838678;
    case 36: 
      return 2130838679;
    case 37: 
      return 2130838680;
    case 38: 
      return 2130838681;
    case 39: 
      return 2130838682;
    case 40: 
      return 2130838684;
    case 41: 
      return 2130838685;
    case 42: 
      return 2130838686;
    case 43: 
      return 2130838687;
    case 44: 
      return 2130838688;
    case 45: 
      return 2130838689;
    case 46: 
      return 2130838690;
    case 47: 
      return 2130838691;
    case 48: 
      return 2130838692;
    case 49: 
      return 2130838693;
    case 50: 
      return 2130838695;
    case 51: 
      return 2130838696;
    case 52: 
      return 2130838697;
    case 53: 
      return 2130838698;
    case 54: 
      return 2130838699;
    case 55: 
      return 2130838700;
    case 56: 
      return 2130838701;
    case 57: 
      return 2130838702;
    case 58: 
      return 2130838703;
    case 59: 
      return 2130838704;
    case 60: 
      return 2130838706;
    case 61: 
      return 2130838707;
    case 62: 
      return 2130838708;
    case 63: 
      return 2130838709;
    case 64: 
      return 2130838710;
    case 65: 
      return 2130838711;
    case 66: 
      return 2130838712;
    case 67: 
      return 2130838713;
    case 68: 
      return 2130838714;
    case 69: 
      return 2130838715;
    case 70: 
      return 2130838717;
    case 71: 
      return 2130838718;
    case 72: 
      return 2130838719;
    case 73: 
      return 2130838720;
    case 74: 
      return 2130838721;
    case 75: 
      return 2130838722;
    case 76: 
      return 2130838723;
    case 77: 
      return 2130838724;
    case 78: 
      return 2130838725;
    case 79: 
      return 2130838726;
    case 80: 
      return 2130838728;
    case 81: 
      return 2130838729;
    case 82: 
      return 2130838730;
    case 83: 
      return 2130838731;
    case 84: 
      return 2130838732;
    case 85: 
      return 2130838733;
    case 86: 
      return 2130838734;
    case 87: 
      return 2130838735;
    case 88: 
      return 2130838736;
    case 89: 
      return 2130838737;
    case 90: 
      return 2130838739;
    case 91: 
      return 2130838740;
    case 92: 
      return 2130838741;
    case 93: 
      return 2130838742;
    case 94: 
      return 2130838743;
    case 95: 
      return 2130838744;
    case 96: 
      return 2130838745;
    case 97: 
      return 2130838746;
    case 98: 
      return 2130838747;
    case 99: 
      return 2130838748;
    case 100: 
      return 2130838601;
    case 101: 
      return 2130838602;
    case 102: 
      return 2130838603;
    case 103: 
      return 2130838604;
    case 104: 
      return 2130838605;
    case 105: 
      return 2130838606;
    case 106: 
      return 2130838607;
    case 107: 
      return 2130838608;
    case 108: 
      return 2130838609;
    case 109: 
      return 2130838610;
    case 110: 
      return 2130838612;
    case 111: 
      return 2130838613;
    case 112: 
      return 2130838614;
    case 113: 
      return 2130838615;
    case 114: 
      return 2130838616;
    case 115: 
      return 2130838617;
    case 116: 
      return 2130838618;
    case 117: 
      return 2130838619;
    case 118: 
      return 2130838620;
    case 119: 
      return 2130838621;
    case 120: 
      return 2130838623;
    case 121: 
      return 2130838624;
    case 122: 
      return 2130838625;
    case 123: 
      return 2130838626;
    case 124: 
      return 2130838627;
    case 125: 
      return 2130838628;
    case 126: 
      return 2130838629;
    case 127: 
      return 2130838630;
    case 128: 
      return 2130838631;
    case 129: 
      return 2130838632;
    case 130: 
      return 2130838634;
    case 131: 
      return 2130838635;
    case 132: 
      return 2130838636;
    case 133: 
      return 2130838637;
    case 134: 
      return 2130838638;
    case 135: 
      return 2130838639;
    case 136: 
      return 2130838640;
    case 137: 
      return 2130838641;
    case 138: 
      return 2130838642;
    case 139: 
      return 2130838643;
    case 140: 
      return 2130838645;
    case 141: 
      return 2130838646;
    case 142: 
      return 2130838647;
    case 143: 
      return 2130838648;
    case 144: 
      return 2130838649;
    case 145: 
      return 2130838650;
    case 146: 
      return 2130838651;
    case 147: 
      return 2130838652;
    case 148: 
      return 2130838653;
    case 149: 
      return 2130838654;
    }
    return 2130838656;
  }
  
  private int a(int[] paramArrayOfInt, int paramInt, WeatherBean paramWeatherBean)
  {
    return r.a(paramArrayOfInt, paramInt, a(paramWeatherBean));
  }
  
  private boolean a(WeatherBean paramWeatherBean)
  {
    if (paramWeatherBean == null) {
      return true;
    }
    String str1 = paramWeatherBean.k.j();
    String str2 = paramWeatherBean.k.k();
    if ((GoWidgetApplication.b(this.a.getApplicationContext()).b()) && (this.f.d()))
    {
      int i1 = paramWeatherBean.k.n();
      return r.a(str1, str2, this.f.b(i1));
    }
    return r.a(str1, str2);
  }
  
  private void b(WeatherBean paramWeatherBean)
  {
    Object localObject = paramWeatherBean.k.j();
    paramWeatherBean = paramWeatherBean.k.k();
    if ((r.a((String)localObject)) && (r.a(paramWeatherBean))) {
      try
      {
        localObject = ((String)localObject).split(":");
        this.k = Integer.parseInt(localObject[0]);
        this.l = Integer.parseInt(localObject[1]);
        paramWeatherBean = paramWeatherBean.split(":");
        this.m = Integer.parseInt(paramWeatherBean[0]);
        this.n = Integer.parseInt(paramWeatherBean[1]);
        return;
      }
      catch (Exception paramWeatherBean)
      {
        paramWeatherBean.printStackTrace();
        return;
      }
    }
    this.k = 6;
    this.l = 0;
    this.m = 18;
    this.n = 0;
  }
  
  private void c()
  {
    if (this.h.C.equals("notification_style_default"))
    {
      e();
      c();
    }
    do
    {
      return;
      if (this.h.C.equals("notification_style_default_black"))
      {
        localResources = this.a.getResources();
        this.r = p;
        this.s = localResources.getColor(2131361859);
        this.t = localResources.getColor(2131361860);
        this.u = localResources.getColor(2131361861);
        this.v = 2130838358;
        return;
      }
    } while (!this.h.C.equals("notification_style_default_white"));
    Resources localResources = this.a.getResources();
    this.r = o;
    this.s = localResources.getColor(2131361862);
    this.t = localResources.getColor(2131361863);
    this.u = localResources.getColor(2131361864);
    this.v = 2130838357;
  }
  
  private void d()
  {
    Object localObject = c.a(this.a.getApplicationContext());
    this.e = ((c)localObject).h();
    this.f = ((c)localObject).g();
    this.g = ((c)localObject).f();
    this.h = this.g.a();
    this.i = this.h.n;
    this.j = this.h.p;
    if (this.b == null)
    {
      this.b = new ah(this);
      localObject = new IntentFilter();
      ((IntentFilter)localObject).addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_TEMPERATURE_UNIT");
      ((IntentFilter)localObject).addAction("com.gau.go.launcherex.gowidget.weatherwidget.goweather.ACTION_UPDATE_DATA");
      ((IntentFilter)localObject).addAction("android.intent.action.TIME_SET");
      ((IntentFilter)localObject).addAction("android.intent.action.TIME_TICK");
      ((IntentFilter)localObject).addAction("android.intent.action.TIMEZONE_CHANGED");
      ((IntentFilter)localObject).addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_USER_LANGUAGE_CHANGED");
      this.a.registerReceiver(this.b, (IntentFilter)localObject);
    }
    if (this.c == null) {
      this.c = ((NotificationManager)this.a.getSystemService("notification"));
    }
    if (this.d == null)
    {
      this.d = new Notification();
      this.d.flags = 2;
    }
  }
  
  private void e()
  {
    TypedArray localTypedArray = this.a.obtainStyledAttributes(16973928, new int[] { 16842904 });
    int i1 = localTypedArray.getColor(0, 0);
    localTypedArray.recycle();
    if ((0xFFFFFF & i1) < 8388607) {}
    for (this.h.C = "notification_style_default_white";; this.h.C = "notification_style_default_black")
    {
      this.g.a("notification_style", this.h.C);
      return;
    }
  }
  
  private void f()
  {
    if (this.c == null) {
      this.c = ((NotificationManager)this.a.getSystemService("notification"));
    }
    this.c.cancel("com.gau.go.launcherex.gowidget.weather.handler.NotifyWeatherHandler", 1);
  }
  
  private void g()
  {
    Object localObject3 = "--";
    Object localObject2 = this.a.getString(2131165323);
    Object localObject1 = this.a.getString(2131166455);
    int i2 = this.r[0];
    Object localObject5 = (WeatherBean)this.e.c().get(this.i);
    String str;
    int i1;
    int i3;
    Object localObject4;
    if (localObject5 != null)
    {
      b((WeatherBean)localObject5);
      str = ((WeatherBean)localObject5).d();
      i2 = a(this.r, ((WeatherBean)localObject5).k.d(), (WeatherBean)localObject5);
      i1 = this.h.g;
      if (i1 == 1)
      {
        localObject1 = "°C";
        i3 = com.gau.go.launcherex.gowidget.weather.util.q.a(((WeatherBean)localObject5).k.a(i1));
        localObject2 = r.a(this.a, ((WeatherBean)localObject5).k.f());
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          localObject3 = localObject2;
          if (!((String)localObject2).equals("-10000")) {}
        }
        else
        {
          localObject3 = "--";
        }
        localObject4 = ((WeatherBean)localObject5).k.e();
        if ((!TextUtils.isEmpty((CharSequence)localObject4)) && (!((String)localObject4).equals("--")))
        {
          localObject2 = localObject4;
          if (!((String)localObject4).equals("-10000")) {}
        }
        else
        {
          localObject2 = this.a.getString(2131165323);
        }
        i1 = a(q, ((WeatherBean)localObject5).k.d(), (WeatherBean)localObject5);
        localObject4 = localObject1;
        localObject1 = str;
      }
    }
    for (;;)
    {
      if (i3 == 55536)
      {
        if (this.j == 1) {
          this.d.icon = 2130838071;
        }
        for (;;)
        {
          str = "--";
          localObject5 = new RemoteViews(this.a.getPackageName(), 2130903248);
          ((RemoteViews)localObject5).setTextColor(2131231781, this.s);
          ((RemoteViews)localObject5).setTextColor(2131231788, this.s);
          ((RemoteViews)localObject5).setTextColor(2131231789, this.s);
          ((RemoteViews)localObject5).setTextColor(2131231786, this.t);
          ((RemoteViews)localObject5).setTextColor(2131231787, this.u);
          ((RemoteViews)localObject5).setTextViewText(2131231781, (CharSequence)localObject1);
          ((RemoteViews)localObject5).setTextViewText(2131231788, str);
          ((RemoteViews)localObject5).setTextViewText(2131231789, (CharSequence)localObject4);
          ((RemoteViews)localObject5).setImageViewResource(2131231785, i2);
          ((RemoteViews)localObject5).setTextViewText(2131231786, (CharSequence)localObject2);
          ((RemoteViews)localObject5).setTextViewText(2131231787, (CharSequence)localObject3);
          ((RemoteViews)localObject5).setImageViewResource(2131231780, this.v);
          this.d.contentView = ((RemoteViews)localObject5);
          this.d.contentIntent = h();
          if (this.c == null) {
            this.c = ((NotificationManager)this.a.getSystemService("notification"));
          }
          this.c.notify("com.gau.go.launcherex.gowidget.weather.handler.NotifyWeatherHandler", 1, this.d);
          return;
          localObject1 = "°F";
          break;
          if (this.j == 0) {
            this.d.icon = i1;
          }
        }
      }
      if (this.j == 1) {
        this.d.icon = a(i3);
      }
      for (;;)
      {
        str = String.valueOf(i3);
        break;
        if (this.j == 0) {
          this.d.icon = i1;
        }
      }
      i1 = 2130838071;
      localObject4 = "°";
      i3 = 55536;
    }
  }
  
  private PendingIntent h()
  {
    Intent localIntent = WeatherDetailActivity.a(this.a, this.i, true, 11, "", -1);
    localIntent.addFlags(67108864);
    return PendingIntent.getActivity(this.a, 6, localIntent, 134217728);
  }
  
  private boolean i()
  {
    Time localTime = this.f.c();
    return ((localTime.hour == this.k) && (localTime.minute == this.l)) || ((localTime.hour == this.m) && (localTime.minute == this.n));
  }
  
  public void a()
  {
    d();
    c();
    g();
  }
  
  public void b()
  {
    f();
    if (this.b != null)
    {
      this.a.unregisterReceiver(this.b);
      this.b = null;
    }
    if (this.d != null) {
      this.d = null;
    }
    if (this.c != null) {
      this.c = null;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/b/ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */