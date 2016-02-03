package com.gau.go.launcherex.gowidget.weather.systemwidget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.database.Cursor;
import android.text.Html;
import android.text.TextUtils;
import android.text.format.Time;
import android.util.Log;
import android.util.SparseArray;
import android.widget.RemoteViews;
import com.gau.go.launcherex.gowidget.weather.f.f;
import com.gau.go.launcherex.gowidget.weather.model.NowBean;
import com.gau.go.launcherex.gowidget.weather.model.WeatherBean;
import com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider;
import com.gau.go.launcherex.gowidget.weather.service.AppWidgetService;
import com.gau.go.launcherex.gowidget.weather.util.r;
import com.gau.go.launcherex.gowidget.weather.view.WeatherDetailActivity;
import com.gtp.a.a.a.a;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class i
  extends u
  implements aa, ae
{
  public static String a = "";
  private int[] A = new int[10];
  private int[] B = new int[10];
  private int C;
  private int D;
  private int E;
  private int F;
  private int G;
  private int H;
  private int I;
  private int J;
  private int K;
  private int L;
  private int M;
  private int N;
  private int O;
  private int P;
  private String Q = "";
  private int R;
  private int S;
  private int T;
  private int U;
  private int V;
  private int W;
  private int X;
  private int Y;
  private int Z;
  private int aA;
  private int aB;
  private int aC;
  private int aD;
  private int aE;
  private int aF;
  private int aG;
  private int aH;
  private int aI;
  private int aJ;
  private int aK;
  private int aL;
  private int aM;
  private int[] aN = { 2131165326, 2131165327, 2131165328, 2131165329, 2131165330, 2131165331, 2131165332 };
  private int[] aO = { 2131166553, 2131166554, 2131166555, 2131166556, 2131166557, 2131166558, 2131166559, 2131166560, 2131166561, 2131166562, 2131166563, 2131166564 };
  private k aP;
  private Intent aQ;
  private int aa;
  private int ab;
  private int ac;
  private int ad;
  private int ae;
  private int af;
  private int ag;
  private int ah;
  private int ai;
  private int aj;
  private int ak;
  private int al;
  private int am;
  private int an;
  private int ao;
  private int ap;
  private int aq;
  private int ar;
  private int as;
  private int at;
  private int au;
  private int av;
  private int aw;
  private int ax;
  private int ay;
  private int az;
  private SparseArray f = new SparseArray();
  private Resources g;
  private int h;
  private int i;
  private int j;
  private int k;
  private int l;
  private com.gau.go.launcherex.gowidget.weather.c.g m;
  private boolean n = false;
  private boolean o = false;
  private boolean p = false;
  private boolean q = false;
  private boolean r = false;
  private boolean s = false;
  private String t = "app_widget_theme_white";
  private l u;
  private boolean v = false;
  private f w = null;
  private ap x = null;
  private int[] y = new int[10];
  private int[] z = new int[10];
  
  public i(Context paramContext)
  {
    this.b = paramContext;
    this.g = com.gau.go.launcherex.gowidget.language.d.a(paramContext).a();
    if (this.g == null) {
      this.g = paramContext.getResources();
    }
    this.m = new com.gau.go.launcherex.gowidget.weather.c.g(paramContext);
    this.w = f.a(paramContext);
    this.w.a(paramContext, a);
    this.u = new l(paramContext.getContentResolver(), this);
    this.aP = new k(this, null);
    Object localObject = new IntentFilter();
    ((IntentFilter)localObject).addAction("android.intent.action.TIME_TICK");
    ((IntentFilter)localObject).addAction("android.intent.action.TIME_SET");
    ((IntentFilter)localObject).addAction("android.intent.action.DATE_CHANGED");
    ((IntentFilter)localObject).addAction("android.intent.action.TIMEZONE_CHANGED");
    ((IntentFilter)localObject).addAction("android.intent.action.SCREEN_ON");
    ((IntentFilter)localObject).addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_NEW_THEME_FLAG_CHANGE");
    ((IntentFilter)localObject).addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_APPWIDGET_DATA_READY");
    ((IntentFilter)localObject).addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_REFRESH_STARTED");
    ((IntentFilter)localObject).addAction("com.gau.go.launcherex.gowidget.weatherwidget.goweather.ACTION_UPDATE_DATA");
    ((IntentFilter)localObject).addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_INITIALIZED_CITY");
    paramContext.registerReceiver(this.aP, (IntentFilter)localObject);
    a.a().a("AppWidget42ProviderHelper registerReceiver", "插件错误.txt");
    localObject = ab.a(paramContext);
    ((ab)localObject).a(this);
    if (((ab)localObject).a) {
      b(((ab)localObject).a());
    }
    paramContext = x.a(paramContext);
    paramContext.a(this);
    if (paramContext.a) {
      a(paramContext.a());
    }
  }
  
  private int a(int paramInt, boolean paramBoolean)
  {
    return r.a(this.B, paramInt, paramBoolean);
  }
  
  private Time a(com.gau.go.launcherex.gowidget.weather.model.x paramx)
  {
    WeatherBean localWeatherBean = null;
    if (paramx != null) {
      localWeatherBean = a(paramx.b());
    }
    if (localWeatherBean != null)
    {
      int i1 = localWeatherBean.k.n();
      return this.m.b(i1);
    }
    return this.m.b(55536);
  }
  
  private WeatherBean a(String paramString)
  {
    if (this.c.isEmpty()) {
      return null;
    }
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext())
    {
      WeatherBean localWeatherBean = (WeatherBean)localIterator.next();
      if (localWeatherBean.c().equals(paramString)) {
        return localWeatherBean;
      }
    }
    return null;
  }
  
  private String a(Context paramContext, int paramInt, float paramFloat)
  {
    if (paramInt == 1) {
      return String.format(this.g.getString(2131165809), new Object[] { Float.valueOf(com.gau.go.launcherex.gowidget.weather.util.q.c(paramFloat, 1)) });
    }
    if (paramInt == 4) {
      return String.format(this.g.getString(2131165812), new Object[] { Float.valueOf(com.gau.go.launcherex.gowidget.weather.util.q.e(paramFloat, 1)) });
    }
    if (paramInt == 3) {
      return String.format(this.g.getString(2131165811), new Object[] { Float.valueOf(com.gau.go.launcherex.gowidget.weather.util.q.d(paramFloat, 1)) });
    }
    if (paramInt == 5) {
      return String.format(this.g.getString(2131165813), new Object[] { Integer.valueOf(com.gau.go.launcherex.gowidget.weather.util.q.a(paramFloat)) });
    }
    if (paramInt == 6) {
      return String.format(this.g.getString(2131165814), new Object[] { Float.valueOf(com.gau.go.launcherex.gowidget.weather.util.q.f(paramFloat, 1)) });
    }
    return String.format(this.g.getString(2131165810), new Object[] { Float.valueOf(paramFloat) });
  }
  
  private void a(int paramInt)
  {
    int i1 = 1;
    com.gau.go.launcherex.gowidget.weather.model.x localx;
    Object localObject;
    if (paramInt != 0)
    {
      localx = (com.gau.go.launcherex.gowidget.weather.model.x)this.f.get(paramInt);
      if (localx == null) {
        break label216;
      }
      localObject = localx.b();
      if (!this.c.isEmpty())
      {
        if ((!TextUtils.isEmpty((CharSequence)localObject)) && (a((String)localObject) != null)) {
          break label159;
        }
        if (localx.e() != 1) {
          break label106;
        }
        localObject = c();
        if (localObject == null) {
          break label106;
        }
        localx.a(((WeatherBean)localObject).c());
        v.a(this.b).b(localx);
      }
    }
    for (;;)
    {
      b(this.b, localx);
      return;
      label106:
      localObject = (WeatherBean)this.c.get(0);
      if (localObject == null) {
        break;
      }
      localx.a(((WeatherBean)localObject).c());
      if (((WeatherBean)localObject).e() == 2) {}
      for (paramInt = i1;; paramInt = 0)
      {
        localx.c(paramInt);
        break;
      }
      label159:
      if (localx.e() == 1)
      {
        localObject = c();
        if ((localObject != null) && (!localx.b().equals(((WeatherBean)localObject).c())))
        {
          localx.a(((WeatherBean)localObject).c());
          v.a(this.b).b(localx);
        }
      }
    }
    label216:
    this.u.a(1, Integer.valueOf(paramInt), WeatherContentProvider.t, new String[] { "current_cityid", "widget_location_type" }, "widget_id=?", new String[] { String.valueOf(paramInt) }, null);
  }
  
  private void a(Context paramContext, int paramInt)
  {
    if (this.s)
    {
      com.gau.go.launcherex.gowidget.weather.model.x localx = (com.gau.go.launcherex.gowidget.weather.model.x)this.f.get(paramInt);
      if (localx != null)
      {
        String str = a;
        Log.d("appwidget_42_helper", "mPreviewTheme: " + this.t);
        if ((!TextUtils.isEmpty(this.t)) && (!this.t.equals(str)))
        {
          a = this.t;
          localx.c(a);
          d(this.b);
        }
        paramContext = c(paramContext, localx);
        if (!str.equals(a))
        {
          a = str;
          localx.c(a);
          d(this.b);
        }
        a(paramContext);
      }
    }
  }
  
  private void a(Context paramContext, f paramf, String paramString1, String paramString2)
  {
    InputStream localInputStream;
    if (!a.contains("app_widget_theme"))
    {
      paramString2 = "systemwidget_weatherwidget.xml";
      localInputStream = com.gau.go.launcherex.gowidget.weather.f.g.a(paramContext, paramString1, paramString2);
      if (localInputStream != null) {
        break label556;
      }
    }
    label556:
    for (paramContext = com.gau.go.launcherex.gowidget.weather.f.g.b(paramContext, paramString1, paramString2.replace(".xml", ""));; paramContext = localInputStream)
    {
      if (paramContext == null)
      {
        return;
        paramString2 = com.gau.go.launcherex.gowidget.weather.globaltheme.c.a(paramString2);
        break;
      }
      paramString2 = com.gau.go.launcherex.gowidget.weather.f.g.a(paramContext);
      if (this.x == null) {
        this.x = new ap();
      }
      ap.a = paramString1;
      this.x.a("systemwidget_style", String.valueOf(42));
      if (paramString2 != null) {
        new am().a(paramString2, this.x);
      }
      try
      {
        paramContext.close();
        this.H = paramf.c(this.x.a("go_weatherex_widget_bg"), paramString1);
        this.I = paramf.c(this.x.a("go_weatherex_widget_bg_day"), paramString1);
        this.G = paramf.c(this.x.a("go_weatherex_widget_bg_night"), paramString1);
        this.F = paramf.c(this.x.a("go_weatherex_widget_time_pm"), paramString1);
        this.P = paramf.c(this.x.a("go_weatherex_widget_time_am"), paramString1);
        this.Q = this.x.a("go_weatherex_widget_date_style_color");
        this.M = paramf.c(this.x.a("go_weatherex_widget_time_ampm_empty"), paramString1);
        this.D = paramf.c(this.x.a("go_weatherex_widget_time_bg"), paramString1);
        this.E = paramf.c(this.x.a("go_weatherex_widget_change_city"), paramString1);
        this.J = paramf.c(this.x.a("go_weatherex_widget_time_divider"), paramString1);
        this.L = paramf.c(this.x.a("go_weatherex_widget_temp_unit"), paramString1);
        this.N = paramf.c(this.x.a("go_weatherex_widget_temp_unit_centigrade"), paramString1);
        this.O = paramf.c(this.x.a("go_weatherex_widget_temp_unit_fahrenheit"), paramString1);
        this.K = paramf.c(this.x.a("go_weatherex_widget_temp_minus"), paramString1);
        i1 = 0;
        while (i1 < 10)
        {
          this.B[i1] = paramf.c(ap.c[i1], paramString1);
          i1 += 1;
        }
      }
      catch (IOException paramContext)
      {
        for (;;)
        {
          paramContext.printStackTrace();
        }
        int i1 = 0;
        while (i1 < 10)
        {
          this.y[i1] = paramf.c(ap.d[i1], paramString1);
          i1 += 1;
        }
        i1 = 0;
        while (i1 < 10)
        {
          this.z[i1] = paramf.c(ap.e[i1], paramString1);
          i1 += 1;
        }
        i1 = 0;
        while (i1 < 10)
        {
          this.A[i1] = paramf.c(ap.f[i1], paramString1);
          i1 += 1;
        }
        this.C = this.K;
        return;
      }
    }
  }
  
  private void a(Context paramContext, com.gau.go.launcherex.gowidget.weather.model.x paramx, RemoteViews paramRemoteViews)
  {
    int i1 = 0;
    if (paramx != null) {
      i1 = b(paramx.b());
    }
    int i4;
    if (this.S != 0)
    {
      if (this.H != 0) {
        paramRemoteViews.setImageViewResource(this.S, this.H);
      }
    }
    else
    {
      i4 = this.c.size();
      if ((i1 >= 0) && (i1 < i4)) {
        break label5300;
      }
    }
    label1102:
    label1145:
    label1274:
    label1338:
    label1433:
    label1633:
    label1750:
    label1826:
    label1878:
    label2161:
    label2216:
    label2286:
    label2331:
    label2467:
    label2511:
    label2555:
    label2599:
    label2783:
    label2939:
    label2995:
    label3047:
    label3103:
    label3196:
    label3239:
    label3377:
    label3615:
    label3654:
    label3667:
    label3933:
    label4168:
    label4530:
    label4543:
    label4601:
    label4727:
    label4748:
    label4760:
    label4779:
    label4793:
    label4807:
    label4821:
    label5014:
    label5098:
    label5111:
    label5140:
    label5169:
    label5184:
    label5206:
    label5220:
    label5235:
    label5257:
    label5278:
    label5300:
    for (int i2 = 0;; i2 = i1)
    {
      Object localObject1 = b(paramContext);
      if (localObject1 != null)
      {
        if (this.ag != 0) {
          paramRemoteViews.setOnClickPendingIntent(this.ag, (PendingIntent)localObject1);
        }
        if (this.ah != 0) {
          paramRemoteViews.setOnClickPendingIntent(this.ah, (PendingIntent)localObject1);
        }
        if (this.al != 0) {
          paramRemoteViews.setOnClickPendingIntent(this.al, (PendingIntent)localObject1);
        }
        if (this.am != 0) {
          paramRemoteViews.setOnClickPendingIntent(this.am, (PendingIntent)localObject1);
        }
        if (this.ai != 0) {
          paramRemoteViews.setOnClickPendingIntent(this.ai, (PendingIntent)localObject1);
        }
        if (this.aj != 0) {
          paramRemoteViews.setOnClickPendingIntent(this.aj, (PendingIntent)localObject1);
        }
        if (this.aJ != 0) {
          paramRemoteViews.setOnClickPendingIntent(this.aJ, (PendingIntent)localObject1);
        }
        if (this.ak != 0) {
          paramRemoteViews.setOnClickPendingIntent(this.ak, (PendingIntent)localObject1);
        }
      }
      localObject1 = a(paramContext);
      if (localObject1 != null)
      {
        if (this.U != 0) {
          paramRemoteViews.setOnClickPendingIntent(this.U, (PendingIntent)localObject1);
        }
        if (this.V != 0) {
          paramRemoteViews.setOnClickPendingIntent(this.V, (PendingIntent)localObject1);
        }
        if (this.W != 0) {
          paramRemoteViews.setOnClickPendingIntent(this.W, (PendingIntent)localObject1);
        }
        if (this.X != 0) {
          paramRemoteViews.setOnClickPendingIntent(this.X, (PendingIntent)localObject1);
        }
        if (this.Y != 0) {
          paramRemoteViews.setOnClickPendingIntent(this.Y, (PendingIntent)localObject1);
        }
        if (this.ab != 0) {
          paramRemoteViews.setOnClickPendingIntent(this.ab, (PendingIntent)localObject1);
        }
        if (this.T != 0) {
          paramRemoteViews.setOnClickPendingIntent(this.T, (PendingIntent)localObject1);
        }
        if (this.ac != 0) {
          paramRemoteViews.setOnClickPendingIntent(this.ac, (PendingIntent)localObject1);
        }
        if (this.ad != 0) {
          paramRemoteViews.setOnClickPendingIntent(this.ad, (PendingIntent)localObject1);
        }
        if (this.ae != 0) {
          paramRemoteViews.setOnClickPendingIntent(this.ae, (PendingIntent)localObject1);
        }
        if (this.af != 0) {
          paramRemoteViews.setOnClickPendingIntent(this.af, (PendingIntent)localObject1);
        }
      }
      Object localObject2 = e(paramContext, paramx);
      if (localObject2 != null)
      {
        if (this.aF != 0) {
          paramRemoteViews.setOnClickPendingIntent(this.aF, (PendingIntent)localObject2);
        }
        if (this.as != 0) {
          paramRemoteViews.setOnClickPendingIntent(this.as, (PendingIntent)localObject2);
        }
        if (this.aE != 0) {
          paramRemoteViews.setOnClickPendingIntent(this.aE, (PendingIntent)localObject2);
        }
        if (this.aG != 0) {
          paramRemoteViews.setOnClickPendingIntent(this.aG, (PendingIntent)localObject2);
        }
        if (this.ax != 0) {
          paramRemoteViews.setOnClickPendingIntent(this.ax, (PendingIntent)localObject2);
        }
        if (this.az != 0) {
          paramRemoteViews.setOnClickPendingIntent(this.az, (PendingIntent)localObject2);
        }
        if (this.aA != 0) {
          paramRemoteViews.setOnClickPendingIntent(this.aA, (PendingIntent)localObject2);
        }
        if (this.aB != 0) {
          paramRemoteViews.setOnClickPendingIntent(this.aB, (PendingIntent)localObject2);
        }
        if (this.aD != 0) {
          paramRemoteViews.setOnClickPendingIntent(this.aD, (PendingIntent)localObject2);
        }
        if (this.aC != 0) {
          paramRemoteViews.setOnClickPendingIntent(this.aC, (PendingIntent)localObject2);
        }
        if (this.aK != 0) {
          paramRemoteViews.setOnClickPendingIntent(this.aK, (PendingIntent)localObject2);
        }
        if (this.ar != 0) {
          paramRemoteViews.setOnClickPendingIntent(this.ar, (PendingIntent)localObject2);
        }
      }
      localObject1 = localObject2;
      if (this.n)
      {
        localObject1 = localObject2;
        if (i4 > 1)
        {
          localObject1 = new Intent(paramContext, AppWidgetService.class);
          ((Intent)localObject1).putExtra("appwidget_service_request", 21);
          ((Intent)localObject1).putExtra("request_extra_appwidget_type", 1);
          i1 = 196608;
          if (paramx != null)
          {
            ((Intent)localObject1).putExtra("extra_appwidget_ids", paramx.a());
            i1 = paramx.a() + 196608;
          }
          localObject1 = PendingIntent.getService(paramContext, i1, (Intent)localObject1, 134217728);
        }
      }
      if (localObject1 != null)
      {
        if (this.an != 0) {
          paramRemoteViews.setOnClickPendingIntent(this.an, (PendingIntent)localObject1);
        }
        if (this.ao != 0) {
          paramRemoteViews.setOnClickPendingIntent(this.ao, (PendingIntent)localObject1);
        }
        if (this.aq != 0) {
          paramRemoteViews.setOnClickPendingIntent(this.aq, (PendingIntent)localObject1);
        }
      }
      if (this.aL != 0)
      {
        localObject1 = a(paramContext, paramx);
        if (localObject1 != null)
        {
          paramRemoteViews.setViewVisibility(this.aL, 0);
          paramRemoteViews.setOnClickPendingIntent(this.aL, (PendingIntent)localObject1);
        }
      }
      if ((this.n) && (i4 != 0))
      {
        localObject1 = c(paramContext);
        if ((this.aH != 0) && (localObject1 != null)) {
          paramRemoteViews.setOnClickPendingIntent(this.aH, (PendingIntent)localObject1);
        }
      }
      if ((this.Z != 0) && (this.D != 0)) {
        paramRemoteViews.setImageViewResource(this.Z, this.D);
      }
      if ((this.aa != 0) && (this.J != 0)) {
        paramRemoteViews.setImageViewResource(this.aa, this.J);
      }
      Time localTime = a(paramx);
      int i3 = localTime.hour;
      i1 = i3;
      if (!r.b(paramContext))
      {
        i3 %= 12;
        i1 = i3;
        if (i3 == 0) {
          i1 = 12;
        }
      }
      i3 = localTime.minute;
      if ((this.V != 0) && (this.y != null) && (this.y[0] != 0)) {
        paramRemoteViews.setImageViewResource(this.V, r.a(i1 / 10, this.y));
      }
      if ((this.W != 0) && (this.y != null) && (this.y[0] != 0)) {
        paramRemoteViews.setImageViewResource(this.W, r.a(i1 % 10, this.y));
      }
      if (this.X != 0)
      {
        if ((this.z != null) && (this.z[0] != 0)) {
          paramRemoteViews.setImageViewResource(this.X, r.a(i3 / 10, this.z));
        }
      }
      else
      {
        if (this.Y != 0)
        {
          if ((this.z == null) || (this.z[0] == 0)) {
            break label3615;
          }
          paramRemoteViews.setImageViewResource(this.Y, r.a(i3 % 10, this.z));
        }
        if (this.ac != 0) {
          paramRemoteViews.setTextViewText(this.ac, r.e(i1) + ":" + r.e(i3));
        }
        if (this.ad != 0) {
          paramRemoteViews.setTextViewText(this.ad, r.e(i1));
        }
        if (this.ae != 0) {
          paramRemoteViews.setTextViewText(this.ae, r.e(i3));
        }
        if (!r.b(paramContext)) {
          break label3667;
        }
        if (this.T != 0)
        {
          if (this.M == 0) {
            break label3654;
          }
          paramRemoteViews.setViewVisibility(this.T, 0);
          paramRemoteViews.setImageViewResource(this.T, this.M);
        }
        if (this.af != 0) {
          paramRemoteViews.setViewVisibility(this.af, 8);
        }
        if (this.ab != 0) {
          paramRemoteViews.setTextViewText(this.ab, r.e(i1) + ":" + r.e(i3));
        }
        if (this.m == null) {
          break label3933;
        }
        if (this.ai != 0)
        {
          this.m.a(1, this.k);
          localObject1 = this.m.a(localTime);
          paramRemoteViews.setTextViewText(this.ai, (CharSequence)localObject1);
          this.m.a(0, this.k);
        }
        localObject2 = this.m.a(localTime);
        localObject1 = localObject2;
        if (this.ah != 0)
        {
          paramRemoteViews.setTextViewText(this.ah, (CharSequence)localObject2);
          localObject1 = localObject2;
        }
        i1 = this.aN[localTime.weekDay];
        if (this.ag != 0) {
          paramRemoteViews.setTextViewText(this.ag, this.g.getString(i1) + " " + (String)localObject1);
        }
        if (this.ak != 0) {
          paramRemoteViews.setTextViewText(this.ak, this.g.getString(i1));
        }
        if (this.al != 0)
        {
          if (TextUtils.isEmpty(this.Q)) {
            break label4168;
          }
          localObject1 = this.g.getString(this.aO[localTime.month]);
        }
        switch (this.k)
        {
        default: 
          localObject1 = String.format(this.g.getString(2131166565), new Object[] { this.Q, Integer.valueOf(localTime.year), localObject1, Integer.valueOf(localTime.monthDay) });
          localObject1 = Html.fromHtml((String)localObject1);
          paramRemoteViews.setTextViewText(this.al, (CharSequence)localObject1);
          if (this.am != 0)
          {
            if (!TextUtils.isEmpty(this.Q)) {
              localObject1 = this.g.getString(this.aO[localTime.month]);
            }
          }
          else {
            switch (this.k)
            {
            default: 
              localObject1 = String.format(this.g.getString(2131166568), new Object[] { this.Q, localObject1, Integer.valueOf(localTime.monthDay) });
              localObject1 = Html.fromHtml((String)localObject1);
              paramRemoteViews.setTextViewText(this.am, (CharSequence)localObject1);
              if (this.m != null)
              {
                if (this.aj != 0)
                {
                  localObject1 = this.m.d(localTime);
                  if ((localObject1 == null) || ("".equals(localObject1))) {
                    break label4530;
                  }
                  paramRemoteViews.setTextViewText(this.aj, (CharSequence)localObject1);
                  paramRemoteViews.setViewVisibility(this.aj, 0);
                }
                if (this.aJ != 0)
                {
                  localObject1 = this.m.c(localTime);
                  if ((localObject1 == null) || ("".equals(localObject1))) {
                    break label4543;
                  }
                  paramRemoteViews.setTextViewText(this.aJ, (CharSequence)localObject1);
                  paramRemoteViews.setViewVisibility(this.aJ, 0);
                }
              }
              if (i4 != 0)
              {
                localObject1 = (WeatherBean)this.c.get(i2);
                if (localObject1 != null)
                {
                  if (this.ap != 0)
                  {
                    paramRemoteViews.setViewVisibility(this.ap, 8);
                    if (this.E != 0) {
                      paramRemoteViews.setImageViewResource(this.ap, this.E);
                    }
                  }
                  if (this.aq != 0) {
                    paramRemoteViews.setViewVisibility(this.aq, 8);
                  }
                  if (this.ao != 0) {
                    paramRemoteViews.setTextViewText(this.ao, ((WeatherBean)localObject1).d());
                  }
                  localObject2 = ((WeatherBean)localObject1).k;
                  if ((this.aF != 0) && (this.B != null) && (this.B[0] != 0)) {
                    paramRemoteViews.setImageViewResource(this.aF, a(((NowBean)localObject2).d(), b(paramx)));
                  }
                  i1 = com.gau.go.launcherex.gowidget.weather.util.q.a(((NowBean)localObject2).b(this.h));
                  i3 = com.gau.go.launcherex.gowidget.weather.util.q.a(((NowBean)localObject2).c(this.h));
                  if (this.ax != 0)
                  {
                    if ((i1 == 55536) || (i3 == 55536)) {
                      break label4601;
                    }
                    if ((!((NowBean)localObject2).e().equals("--")) && (!TextUtils.isEmpty(((NowBean)localObject2).e())))
                    {
                      localObject1 = ((NowBean)localObject2).e() + "," + i1 + "°/" + i3 + "° ," + ((NowBean)localObject2).b();
                      paramRemoteViews.setTextViewText(this.ax, (CharSequence)localObject1);
                    }
                  }
                  else
                  {
                    if (this.aE != 0)
                    {
                      if ((((NowBean)localObject2).e().equals("--")) || (TextUtils.isEmpty(((NowBean)localObject2).e()))) {
                        break label4727;
                      }
                      paramRemoteViews.setTextViewText(this.aE, ((NowBean)localObject2).e());
                    }
                    if (this.aG != 0)
                    {
                      localObject1 = new StringBuffer();
                      if ((i1 == 55536) || (i3 == 55536)) {
                        break label4748;
                      }
                      ((StringBuffer)localObject1).append(i1 + "°/" + i3 + "°");
                      ((StringBuffer)localObject1).append(", ");
                      if ((((NowBean)localObject2).e().equals("--")) || (TextUtils.isEmpty(((NowBean)localObject2).e()))) {
                        break label4760;
                      }
                      ((StringBuffer)localObject1).append(((NowBean)localObject2).e());
                      paramRemoteViews.setTextViewText(this.aG, ((StringBuffer)localObject1).toString());
                    }
                    if ((this.aD != 0) && (!((NowBean)localObject2).b().equals("--"))) {
                      paramRemoteViews.setTextViewText(this.aD, this.g.getString(2131166456) + ((NowBean)localObject2).b());
                    }
                    if (this.az != 0)
                    {
                      if ((i1 == 55536) || (i3 == 55536)) {
                        break label4779;
                      }
                      paramRemoteViews.setTextViewText(this.az, i1 + "°/" + i3 + "° ");
                    }
                    if (this.aA != 0)
                    {
                      if (i1 == 55536) {
                        break label4793;
                      }
                      paramRemoteViews.setTextViewText(this.aA, i1 + "° ");
                    }
                    if (this.aB != 0)
                    {
                      if (i3 == 55536) {
                        break label4807;
                      }
                      paramRemoteViews.setTextViewText(this.aB, i3 + "° ");
                    }
                    if (this.aC != 0)
                    {
                      localObject1 = ((NowBean)localObject2).b();
                      if (r.a((String)localObject1)) {
                        break label4821;
                      }
                      localObject1 = paramContext.getText(2131165323).toString();
                      paramRemoteViews.setTextViewText(this.aC, (CharSequence)localObject1);
                    }
                  }
                }
              }
              break;
            }
          }
          break;
        }
      }
      for (i1 = 1;; i1 = 0)
      {
        if (i1 == 0)
        {
          if (this.aE != 0) {
            paramRemoteViews.setTextViewText(this.aE, "--");
          }
          if (this.aG != 0) {
            paramRemoteViews.setTextViewText(this.aG, "--");
          }
          if (this.ax != 0) {
            paramRemoteViews.setTextViewText(this.ax, "--");
          }
          if (this.aD != 0) {
            paramRemoteViews.setTextViewText(this.aD, "--");
          }
          if (this.az != 0) {
            paramRemoteViews.setTextViewText(this.az, "--");
          }
          if (this.aA != 0) {
            paramRemoteViews.setTextViewText(this.aA, "--");
          }
          if (this.aB != 0) {
            paramRemoteViews.setTextViewText(this.aA, "--");
          }
          if (this.aC != 0) {
            paramRemoteViews.setTextViewText(this.aC, "--");
          }
          if (this.ao != 0)
          {
            if (this.n) {
              break label5014;
            }
            paramRemoteViews.setTextViewText(this.ao, this.g.getString(2131166457));
          }
          if (this.aq != 0) {
            paramRemoteViews.setViewVisibility(this.aq, 8);
          }
          if ((this.aF != 0) && (this.B != null) && (this.B[0] != 0)) {
            paramRemoteViews.setImageViewResource(this.aF, a(0, b(paramx)));
          }
        }
        int i5;
        if (i4 != 0)
        {
          i1 = com.gau.go.launcherex.gowidget.weather.util.q.a(((WeatherBean)this.c.get(i2)).k.a(this.h));
          if (i1 != 55536) {
            if (this.ar != 0)
            {
              paramRemoteViews.setViewVisibility(this.ar, 0);
              if (this.h == 1) {
                paramRemoteViews.setTextViewText(this.ar, String.valueOf(i1) + "°C");
              }
            }
            else if ((this.A != null) && (this.A[0] != 0))
            {
              if (this.ay != 0)
              {
                if (i1 >= 0) {
                  break label5098;
                }
                paramRemoteViews.setViewVisibility(this.ay, 0);
                if (this.K != 0) {
                  paramRemoteViews.setImageViewResource(this.ay, this.K);
                }
              }
              i1 = Math.abs(i1);
              i3 = i1 / 100;
              if ((this.au != 0) && (this.A != null) && (this.A[0] != 0))
              {
                if (i3 != 0) {
                  break label5111;
                }
                paramRemoteViews.setViewVisibility(this.au, 8);
              }
              i5 = (i1 - i3 * 100) / 10;
              if ((this.av != 0) && (this.A != null) && (this.A[0] != 0))
              {
                if ((i5 != 0) || (i3 != 0)) {
                  break label5140;
                }
                paramRemoteViews.setViewVisibility(this.av, 8);
              }
              if ((this.aw != 0) && (this.A != null) && (this.A[0] != 0))
              {
                paramRemoteViews.setImageViewResource(this.aw, r.a(i1 % 10, this.A));
                paramRemoteViews.setViewVisibility(this.aw, 0);
              }
              if (this.at != 0)
              {
                if ((this.N == 0) || (this.O == 0)) {
                  break label5184;
                }
                if (this.h != 1) {
                  break label5169;
                }
                paramRemoteViews.setImageViewResource(this.at, this.N);
              }
            }
          }
        }
        for (i1 = 1;; i1 = 0)
        {
          if (i1 == 0)
          {
            if (this.ar != 0)
            {
              paramRemoteViews.setViewVisibility(this.ar, 0);
              if (this.h != 1) {
                break label5206;
              }
              paramRemoteViews.setTextViewText(this.ar, "--°C");
            }
            if ((this.ay != 0) && (this.au != 0) && (this.av != 0) && (this.aw != 0) && (this.C != 0))
            {
              paramRemoteViews.setViewVisibility(this.ay, 8);
              paramRemoteViews.setViewVisibility(this.au, 8);
              paramRemoteViews.setImageViewResource(this.av, this.C);
              paramRemoteViews.setViewVisibility(this.av, 0);
              paramRemoteViews.setImageViewResource(this.aw, this.C);
              paramRemoteViews.setViewVisibility(this.aw, 0);
              if (this.at != 0)
              {
                if ((this.N == 0) || (this.O == 0)) {
                  break label5235;
                }
                if (this.h != 1) {
                  break label5220;
                }
                paramRemoteViews.setImageViewResource(this.at, this.N);
              }
            }
          }
          if (this.aM != 0) {
            paramRemoteViews.setViewVisibility(this.aM, 8);
          }
          if ((this.aH != 0) && (this.aI != 0))
          {
            if (!this.r) {
              break label5257;
            }
            paramRemoteViews.setViewVisibility(this.aH, 4);
            paramRemoteViews.setViewVisibility(this.aI, 0);
          }
          for (;;)
          {
            if ((i4 != 0) && (this.aK != 0))
            {
              paramContext = r.a(paramContext, ((WeatherBean)this.c.get(i2)).k.f());
              if (!paramContext.equals("-10000")) {
                break label5278;
              }
              paramRemoteViews.setTextViewText(this.aK, this.g.getString(2131165888) + " : " + "--");
            }
            return;
            if ((this.I == 0) || (this.G == 0)) {
              break;
            }
            if (b(paramx))
            {
              paramRemoteViews.setImageViewResource(this.S, this.I);
              break;
            }
            paramRemoteViews.setImageViewResource(this.S, this.G);
            break;
            if ((this.y == null) || (this.y[0] == 0)) {
              break label1102;
            }
            paramRemoteViews.setImageViewResource(this.X, r.a(i3 / 10, this.y));
            break label1102;
            if ((this.y == null) || (this.y[0] == 0)) {
              break label1145;
            }
            paramRemoteViews.setImageViewResource(this.Y, r.a(i3 % 10, this.y));
            break label1145;
            paramRemoteViews.setViewVisibility(this.T, 8);
            break label1274;
            if ((localTime.hour >= 0) && (localTime.hour <= 11))
            {
              if ((this.T != 0) && (this.P != 0))
              {
                paramRemoteViews.setViewVisibility(this.T, 0);
                paramRemoteViews.setImageViewResource(this.T, this.P);
              }
              if (this.af != 0)
              {
                paramRemoteViews.setViewVisibility(this.af, 0);
                paramRemoteViews.setTextViewText(this.af, "AM");
              }
              if (this.ab == 0) {
                break label1338;
              }
              paramRemoteViews.setTextViewText(this.ab, r.e(i1) + ":" + r.e(i3) + " " + "AM");
              break label1338;
            }
            if ((this.T != 0) && (this.F != 0))
            {
              paramRemoteViews.setViewVisibility(this.T, 0);
              paramRemoteViews.setImageViewResource(this.T, this.F);
            }
            if (this.af != 0)
            {
              paramRemoteViews.setViewVisibility(this.af, 0);
              paramRemoteViews.setTextViewText(this.af, "PM");
            }
            if (this.ab == 0) {
              break label1338;
            }
            paramRemoteViews.setTextViewText(this.ab, r.e(i1) + ":" + r.e(i3) + " " + "PM");
            break label1338;
            localObject2 = localTime.year + "/" + localTime.month + "/" + localTime.monthDay;
            if (this.ah != 0) {
              paramRemoteViews.setTextViewText(this.ah, (CharSequence)localObject2);
            }
            localObject1 = localObject2;
            if (this.ai == 0) {
              break label1433;
            }
            paramRemoteViews.setTextViewText(this.ai, localTime.month + "/" + localTime.monthDay);
            localObject1 = localObject2;
            break label1433;
            localObject1 = String.format(this.g.getString(2131166566), new Object[] { this.Q, Integer.valueOf(localTime.year), localObject1, Integer.valueOf(localTime.monthDay) });
            break label1633;
            localObject1 = String.format(this.g.getString(2131166567), new Object[] { this.Q, Integer.valueOf(localTime.year), localObject1, Integer.valueOf(localTime.monthDay) });
            break label1633;
            localObject1 = this.g.getString(this.aO[localTime.month]);
            switch (this.k)
            {
            default: 
              localObject1 = localTime.year + " " + (String)localObject1 + " " + localTime.monthDay;
            }
            for (;;)
            {
              paramRemoteViews.setTextViewText(this.al, (CharSequence)localObject1);
              break;
              localObject1 = (String)localObject1 + " " + localTime.monthDay + " " + localTime.year;
              continue;
              localObject1 = localTime.monthDay + " " + (String)localObject1 + " " + localTime.year;
            }
            localObject1 = String.format(this.g.getString(2131166569), new Object[] { this.Q, localObject1, Integer.valueOf(localTime.monthDay) });
            break label1750;
            localObject1 = this.g.getString(this.aO[localTime.month]);
            switch (this.k)
            {
            }
            for (localObject1 = (String)localObject1 + " " + localTime.monthDay;; localObject1 = localTime.monthDay + " " + (String)localObject1)
            {
              paramRemoteViews.setTextViewText(this.am, (CharSequence)localObject1);
              break;
            }
            paramRemoteViews.setViewVisibility(this.aj, 8);
            break label1826;
            paramRemoteViews.setViewVisibility(this.aJ, 8);
            break label1878;
            localObject1 = i1 + "°/" + i3 + "° ," + ((NowBean)localObject2).b();
            break label2161;
            if ((!((NowBean)localObject2).b().equals("--")) && (!TextUtils.isEmpty(((NowBean)localObject2).b())) && (!((NowBean)localObject2).e().equals("--")) && (!TextUtils.isEmpty(((NowBean)localObject2).e())))
            {
              localObject1 = ((NowBean)localObject2).e() + "," + "--" + "°/" + "--" + "° ," + ((NowBean)localObject2).b();
              break label2161;
            }
            localObject1 = this.g.getString(2131165323);
            break label2161;
            paramRemoteViews.setTextViewText(this.aE, this.g.getString(2131165323));
            break label2216;
            ((StringBuffer)localObject1).append("--°/--°");
            break label2286;
            ((StringBuffer)localObject1).append(this.g.getString(2131165323));
            break label2331;
            paramRemoteViews.setTextViewText(this.az, "--°/--° ");
            break label2467;
            paramRemoteViews.setTextViewText(this.aA, "--° ");
            break label2511;
            paramRemoteViews.setTextViewText(this.aB, "--° ");
            break label2555;
            float f1 = ((NowBean)localObject2).a();
            if (!r.b(f1))
            {
              paramRemoteViews.setTextViewText(this.aC, this.g.getString(2131165880) + " : " + (String)localObject1);
              break label2599;
            }
            localObject2 = a(paramContext, this.l, f1);
            if (this.l == 5)
            {
              paramRemoteViews.setTextViewText(this.aC, this.g.getString(2131165880) + " : " + (String)localObject1 + " ,  " + (String)localObject2);
              break label2599;
            }
            paramRemoteViews.setTextViewText(this.aC, this.g.getString(2131165880) + " : " + (String)localObject2 + " , " + (String)localObject1);
            break label2599;
            if (this.d)
            {
              paramRemoteViews.setTextViewText(this.ao, this.g.getString(2131166458));
              break label2783;
            }
            paramRemoteViews.setTextViewText(this.ao, this.g.getString(2131166455));
            break label2783;
            paramRemoteViews.setTextViewText(this.ar, String.valueOf(i1) + "°F");
            break label2939;
            paramRemoteViews.setViewVisibility(this.ay, 8);
            break label2995;
            paramRemoteViews.setImageViewResource(this.au, r.a(i3, this.A));
            paramRemoteViews.setViewVisibility(this.au, 0);
            break label3047;
            paramRemoteViews.setImageViewResource(this.av, r.a(i5, this.A));
            paramRemoteViews.setViewVisibility(this.av, 0);
            break label3103;
            paramRemoteViews.setImageViewResource(this.at, this.O);
            break label3196;
            if (this.L == 0) {
              break label3196;
            }
            paramRemoteViews.setImageViewResource(this.at, this.L);
            break label3196;
            paramRemoteViews.setTextViewText(this.ar, "--°F");
            break label3239;
            paramRemoteViews.setImageViewResource(this.at, this.O);
            break label3377;
            if (this.L == 0) {
              break label3377;
            }
            paramRemoteViews.setImageViewResource(this.at, this.L);
            break label3377;
            paramRemoteViews.setViewVisibility(this.aH, 0);
            paramRemoteViews.setViewVisibility(this.aI, 4);
          }
          paramRemoteViews.setTextViewText(this.aK, paramContext);
          return;
        }
      }
    }
  }
  
  private void a(RemoteViews paramRemoteViews)
  {
    if (paramRemoteViews == null) {
      return;
    }
    Intent localIntent = new Intent("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_APPWIDGET_UPDATE_PREVIEW");
    localIntent.putExtra("extra_widget_preview", paramRemoteViews);
    localIntent.putExtra("extra_widget_type", 1);
    this.b.sendBroadcast(localIntent);
  }
  
  private void a(Object paramObject, Cursor paramCursor)
  {
    Integer localInteger = (Integer)paramObject;
    int i1;
    if ((paramCursor != null) && (paramCursor.getCount() > 0))
    {
      paramObject = new com.gau.go.launcherex.gowidget.weather.model.x();
      ((com.gau.go.launcherex.gowidget.weather.model.x)paramObject).b(1);
      ((com.gau.go.launcherex.gowidget.weather.model.x)paramObject).a(localInteger.intValue());
      paramCursor.moveToFirst();
      int i2 = paramCursor.getColumnCount();
      i1 = 0;
      Object localObject;
      if (i1 < i2)
      {
        localObject = paramCursor.getColumnName(i1);
        if (((String)localObject).equals("current_cityid")) {
          ((com.gau.go.launcherex.gowidget.weather.model.x)paramObject).a(paramCursor.getString(i1));
        }
        for (;;)
        {
          i1 += 1;
          break;
          if (((String)localObject).equals("widget_location_type")) {
            ((com.gau.go.launcherex.gowidget.weather.model.x)paramObject).c(paramCursor.getInt(i1));
          }
        }
      }
      if ((!this.c.isEmpty()) && (a(((com.gau.go.launcherex.gowidget.weather.model.x)paramObject).b()) == null))
      {
        localObject = (WeatherBean)this.c.get(0);
        if (localObject != null)
        {
          ((com.gau.go.launcherex.gowidget.weather.model.x)paramObject).a(((WeatherBean)localObject).c());
          if (((WeatherBean)localObject).e() != 2) {
            break label277;
          }
          i1 = 1;
          ((com.gau.go.launcherex.gowidget.weather.model.x)paramObject).c(i1);
        }
      }
    }
    for (;;)
    {
      if (paramCursor != null) {}
      try
      {
        paramCursor.close();
        if (paramObject != null)
        {
          this.f.append(localInteger.intValue(), paramObject);
          b(this.b, (com.gau.go.launcherex.gowidget.weather.model.x)paramObject);
        }
        if (this.aQ != null)
        {
          i1 = this.aQ.getIntExtra("extra_appwidget_ids", 0);
          if ((i1 != 0) && (i1 == localInteger.intValue()))
          {
            a(this.aQ);
            this.aQ = null;
          }
        }
        return;
        label277:
        i1 = 0;
        break;
        if (this.f.get(localInteger.intValue()) == null)
        {
          paramObject = b(localInteger.intValue());
          v.a(this.b).a((com.gau.go.launcherex.gowidget.weather.model.x)paramObject);
          Log.d("appwidget_42_helper", "new widgetId > " + localInteger);
        }
      }
      catch (Exception paramCursor)
      {
        for (;;)
        {
          paramCursor.printStackTrace();
        }
        paramObject = null;
      }
    }
  }
  
  private int b(String paramString)
  {
    if ((this.c.isEmpty()) || (TextUtils.isEmpty(paramString))) {}
    for (;;)
    {
      return 0;
      int i1 = 0;
      while (i1 < this.c.size())
      {
        WeatherBean localWeatherBean = (WeatherBean)this.c.get(i1);
        if ((localWeatherBean != null) && (localWeatherBean.c().equals(paramString))) {
          return i1;
        }
        i1 += 1;
      }
    }
  }
  
  private com.gau.go.launcherex.gowidget.weather.model.x b(int paramInt)
  {
    com.gau.go.launcherex.gowidget.weather.model.x localx = new com.gau.go.launcherex.gowidget.weather.model.x();
    localx.a(paramInt);
    if (!this.c.isEmpty())
    {
      localx.a(((WeatherBean)this.c.get(0)).c());
      if (((WeatherBean)this.c.get(0)).e() != 2) {
        break label88;
      }
    }
    label88:
    for (paramInt = 1;; paramInt = 0)
    {
      localx.c(paramInt);
      for (;;)
      {
        localx.b(1);
        return localx;
        localx.a("");
      }
    }
  }
  
  private void b()
  {
    Log.d("appwidget_42_helper", "refreshUI");
    if (TextUtils.isEmpty(a)) {
      a = "app_widget_theme_white";
    }
    int[] arrayOfInt = AppWidgetManager.getInstance(this.b).getAppWidgetIds(new ComponentName(this.b, AppWidget42Provider.class));
    Log.d("appwidget_42_helper", "共找到有" + arrayOfInt.length + "个该系统widget样式");
    int i1 = 0;
    while (i1 < arrayOfInt.length)
    {
      Log.d("appwidget_42_helper", "第" + i1 + "个widgetID：" + arrayOfInt[i1]);
      if (i1 == 0) {
        a(this.b, arrayOfInt[i1]);
      }
      a(arrayOfInt[i1]);
      i1 += 1;
    }
  }
  
  private void b(Context paramContext, com.gau.go.launcherex.gowidget.weather.model.x paramx)
  {
    if (paramx != null) {}
    for (int i1 = paramx.a();; i1 = 0)
    {
      if (i1 == 0) {
        return;
      }
      if (a.equals("com.gau.go.weatherex.systemwidgetskin.moonlightskin")) {
        if (b(paramContext, "com.gau.go.weatherex.systemwidgetskin.moonlightskin") < 6)
        {
          paramx = new RemoteViews(paramContext.getPackageName(), 2130903073);
          paramx.setOnClickPendingIntent(2131230979, a(paramContext, "market://details?id=com.gau.go.weatherex.systemwidgetskin.moonlightskin"));
          paramContext = paramx;
        }
      }
      for (;;)
      {
        paramx = AppWidgetManager.getInstance(this.b);
        if ((paramContext == null) || (paramx == null) || (i1 == 0)) {
          break;
        }
        paramx.updateAppWidget(i1, paramContext);
        return;
        if (!this.e)
        {
          this.e = true;
          d(paramContext);
        }
        paramContext = c(paramContext, paramx);
        continue;
        paramContext = c(paramContext, paramx);
      }
    }
  }
  
  private boolean b(com.gau.go.launcherex.gowidget.weather.model.x paramx)
  {
    WeatherBean localWeatherBean = null;
    if (paramx != null) {
      localWeatherBean = a(paramx.b());
    }
    if (localWeatherBean == null) {
      return true;
    }
    paramx = localWeatherBean.k.j();
    String str = localWeatherBean.k.k();
    if ((this.q) && (this.m.d()))
    {
      int i1 = localWeatherBean.k.n();
      return r.a(paramx, str, this.m.b(i1));
    }
    return r.a(paramx, str);
  }
  
  private RemoteViews c(Context paramContext, com.gau.go.launcherex.gowidget.weather.model.x paramx)
  {
    return d(paramContext, paramx);
  }
  
  private WeatherBean c()
  {
    if (!this.c.isEmpty())
    {
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext())
      {
        WeatherBean localWeatherBean = (WeatherBean)localIterator.next();
        if ((localWeatherBean != null) && (localWeatherBean.e() != 1)) {
          return localWeatherBean;
        }
      }
    }
    return null;
  }
  
  private RemoteViews d(Context paramContext, com.gau.go.launcherex.gowidget.weather.model.x paramx)
  {
    int i1 = 0;
    if (paramx != null) {
      i1 = paramx.a();
    }
    Object localObject2;
    if (i1 == 0)
    {
      localObject2 = null;
      return (RemoteViews)localObject2;
    }
    if ((TextUtils.isEmpty(a)) || (a.contains("app_widget_theme")))
    {
      localObject1 = paramContext.getPackageName();
      label48:
      if (this.R == 0) {
        break label100;
      }
    }
    for (Object localObject1 = new RemoteViews((String)localObject1, this.R);; localObject1 = new RemoteViews((String)localObject1, this.R))
    {
      localObject2 = localObject1;
      if (this.R == 0) {
        break;
      }
      a(paramContext, paramx, (RemoteViews)localObject1);
      return (RemoteViews)localObject1;
      localObject1 = a;
      break label48;
      label100:
      d(this.b);
      if (this.R == 0) {
        break label133;
      }
    }
    label133:
    return null;
  }
  
  private void d(Context paramContext)
  {
    int i1 = 1;
    Log.d("appwidget_42_helper", "loadThemeRes");
    if (TextUtils.isEmpty(a)) {
      return;
    }
    String str2 = com.gau.go.launcherex.gowidget.weather.globaltheme.c.d.a(paramContext, a);
    String str1;
    if (a.contains("app_widget_theme"))
    {
      str1 = paramContext.getPackageName();
      label48:
      if (this.w == null) {
        this.w = f.a(paramContext);
      }
      this.w.a(paramContext, str1);
      this.R = 0;
      if (!a.contains("app_widget_theme")) {
        if (!str1.equals(paramContext.getPackageName())) {
          break label893;
        }
      }
    }
    for (;;)
    {
      if (i1 != 0)
      {
        this.R = this.w.a("z_appwidget_l_provider_ex", str1);
        if (this.R == 0) {
          a = "app_widget_theme_white";
        }
      }
      if (this.R == 0)
      {
        str1 = paramContext.getPackageName();
        this.R = this.w.a(com.gau.go.launcherex.gowidget.weather.globaltheme.c.a(0, str2), str1);
      }
      if (this.R == 0) {
        break;
      }
      this.S = this.w.b("goweatherex_widget_l_bg", str1);
      this.T = this.w.b("goweatherex_widget_l_am_pm", str1);
      this.aK = this.w.b("goweatherex_widget_l_published_time", str1);
      this.aE = this.w.b("goweatherex_widget_l_weather_desp", str1);
      this.aG = this.w.b("goweatherex_widget_l_weather_temp_desp", str1);
      this.V = this.w.b("goweatherex_widget_l_hour_num_1", str1);
      this.W = this.w.b("goweatherex_widget_l_hour_num_2", str1);
      this.X = this.w.b("goweatherex_widget_l_min_num_1", str1);
      this.Y = this.w.b("goweatherex_widget_l_min_num_2", str1);
      this.an = this.w.b("goweatherex_widget_l_layout_city", str1);
      this.ap = this.w.b("goweatherex_widget_l_img_next", str1);
      this.ag = this.w.b("goweatherex_widget_l_date_week", str1);
      this.ao = this.w.b("goweatherex_widget_l_city_name", str1);
      this.aq = this.w.b("goweatherex_widget_l_text_next_city", str1);
      this.aF = this.w.b("goweatherex_widget_l_weather_icon", str1);
      this.U = this.w.b("goweatherex_widget_l_time", str1);
      this.aa = this.w.b("goweatherex_widget_l_time_divider", str1);
      this.Z = this.w.b("goweatherex_widget_l_timeboard", str1);
      this.as = this.w.b("goweatherex_widget_l_layout_now_temp", str1);
      this.az = this.w.b("goweatherex_widget_l_low_high_temp", str1);
      this.aB = this.w.b("goweatherex_widget_l_low_temp", str1);
      this.aA = this.w.b("goweatherex_widget_l_high_temp", str1);
      this.ay = this.w.b("goweatherex_widget_l_temp_minus", str1);
      this.au = this.w.b("goweatherex_widget_l_temp_num_1", str1);
      this.av = this.w.b("goweatherex_widget_l_temp_num_2", str1);
      this.aw = this.w.b("goweatherex_widget_l_temp_num_3", str1);
      this.at = this.w.b("goweatherex_widget_l_temp_unit", str1);
      this.ar = this.w.b("goweatherex_widget_l_text_temp", str1);
      this.aH = this.w.b("goweatherex_widget_l_weather_refresh", str1);
      this.aI = this.w.b("goweatherex_widget_l_refresh_progress", str1);
      this.ax = this.w.b("goweatherex_widget_l_detail_depict", str1);
      this.ah = this.w.b("goweatherex_widget_l_date", str1);
      this.al = this.w.b("goweatherex_widget_l_style_date", str1);
      this.am = this.w.b("goweatherex_widget_l_style_date_noyear", str1);
      this.ai = this.w.b("goweatherex_widget_l_date_noyear", str1);
      this.aj = this.w.b("goweatherex_widget_l_lunar", str1);
      this.ak = this.w.b("goweatherex_widget_l_weekday", str1);
      this.aJ = this.w.b("goweatherex_widget_l_festival", str1);
      this.aD = this.w.b("goweatherex_widget_l_wind", str1);
      this.aC = this.w.b("goweatherex_widget_l_detail_wind", str1);
      this.aM = this.w.b("goweatherex_widget_l_extreme_icon", str1);
      this.aL = this.w.b("goweatherex_widget_l_theme_select", str1);
      this.ab = this.w.b("goweatherex_widget_l_text_time_ampm", str1);
      this.ac = this.w.b("goweatherex_widget_l_text_time", str1);
      this.ad = this.w.b("goweatherex_widget_l_text_time_hour", str1);
      this.ae = this.w.b("goweatherex_widget_l_text_time_min", str1);
      this.af = this.w.b("goweatherex_widget_l_text_am_pm", str1);
      a(paramContext, this.w, str1, str2);
      return;
      str1 = a;
      break label48;
      try
      {
        label893:
        paramContext.getPackageManager().getPackageInfo(str1, 0);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        i1 = 0;
      }
    }
  }
  
  private PendingIntent e(Context paramContext, com.gau.go.launcherex.gowidget.weather.model.x paramx)
  {
    Object localObject = "";
    if (paramx != null) {
      localObject = paramx.b();
    }
    localObject = WeatherDetailActivity.a(paramContext, (String)localObject, true, 8, "", -1);
    ((Intent)localObject).addFlags(67108864);
    if (paramx != null) {}
    for (int i1 = paramx.a() + 262144;; i1 = 262144) {
      return PendingIntent.getActivity(paramContext, i1, (Intent)localObject, 134217728);
    }
  }
  
  private void e(Context paramContext)
  {
    AppWidgetManager localAppWidgetManager = AppWidgetManager.getInstance(paramContext);
    if (localAppWidgetManager != null) {
      localAppWidgetManager.updateAppWidget(new ComponentName(paramContext, AppWidget42Provider.class), null);
    }
  }
  
  public void a()
  {
    this.n = false;
    if (this.aQ != null) {
      this.aQ = null;
    }
    this.m.b();
    this.b.unregisterReceiver(this.aP);
    this.f.clear();
    this.c.clear();
    ab.a(this.b).b(this);
    x.a(this.b).b(this);
    a.a().a("AppWidget42ProviderHelper unregisterReceiver", "插件错误.txt");
    Log.d("appwidget_42_helper", "appwidget_42_helper ==============================> onDestroy");
  }
  
  public void a(Intent paramIntent)
  {
    int i1 = 1;
    int i2 = 0;
    if (paramIntent != null)
    {
      localObject = paramIntent.getAction();
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        break label23;
      }
    }
    label23:
    label135:
    label160:
    int i3;
    do
    {
      do
      {
        do
        {
          return;
          Log.d("appwidget_42_helper", "deal_action:" + (String)localObject);
          if (!this.n)
          {
            if (!((String)localObject).equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_APPWIDGET42_CITY_CHANGE")) {
              break label135;
            }
            this.aQ = paramIntent;
          }
          for (;;)
          {
            if (!"com.gau.go.launcherex.gowidget.weatherwidget.ACTION_APPWIDGET_ENABLED_UPDATE_PREVIEW".equals(localObject)) {
              break label160;
            }
            if (paramIntent.getIntExtra("extra_widget_type", 0) != 1) {
              break;
            }
            this.s = paramIntent.getBooleanExtra("extra_enabled_widget_update_preview", this.s);
            if (!this.s) {
              break;
            }
            this.t = paramIntent.getStringExtra("extra_app_widget_theme_package");
            b();
            return;
            if ((((String)localObject).equals("android.appwidget.action.APPWIDGET_UPDATE")) || (!((String)localObject).equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_WIDGET_ADD_APPWIDGET42"))) {}
          }
          if (((String)localObject).equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_APPWIDGET_DATA_READY"))
          {
            b();
            return;
          }
          if ((((String)localObject).equals("android.intent.action.TIME_SET")) || (((String)localObject).equals("android.intent.action.TIME_TICK")) || (((String)localObject).equals("android.intent.action.DATE_CHANGED")) || (((String)localObject).equals("android.intent.action.TIMEZONE_CHANGED")) || (((String)localObject).equals("android.intent.action.SCREEN_ON")))
          {
            if (((String)localObject).equals("android.intent.action.TIMEZONE_CHANGED")) {
              this.m.a();
            }
            for (;;)
            {
              b();
              Log.d("appwidget_42_helper", "刷新时间成功");
              return;
              if (this.m.b(0).minute % 10 == 0) {
                this.m.a();
              }
            }
          }
          if (((String)localObject).equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_REFRESH_STARTED"))
          {
            this.r = true;
            b();
            return;
          }
          if (((String)localObject).equals("com.gau.go.launcherex.gowidget.weatherwidget.goweather.ACTION_UPDATE_DATA"))
          {
            this.r = false;
            b();
            return;
          }
          if (!((String)localObject).equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_APPWIDGET42_CITY_CHANGE")) {
            break;
          }
          Log.d("appwidget_42_helper", "切换城市 > mAllHasLoaded = " + this.n);
          i2 = this.c.size();
        } while (i2 == 0);
        i3 = paramIntent.getIntExtra("extra_appwidget_ids", 0);
        Log.d("appwidget_42_helper", "change city widgetId > " + i3);
        paramIntent = (com.gau.go.launcherex.gowidget.weather.model.x)this.f.get(i3);
      } while (paramIntent == null);
      if (this.aQ != null) {
        this.aQ = null;
      }
      Log.d("appwidget_42_helper", "before change cityId > " + paramIntent.b());
      i3 = b(paramIntent.b());
      i2 = (i3 + 1) % i2;
    } while (i3 == i2);
    Object localObject = (WeatherBean)this.c.get(i2);
    if (localObject != null) {
      if (((WeatherBean)localObject).e() != 2) {
        break label861;
      }
    }
    for (;;)
    {
      paramIntent.c(i1);
      paramIntent.a(((WeatherBean)localObject).c());
      v.a(this.b).b(paramIntent);
      com.gtp.a.a.b.c.a("appwidget_42_helper", "after change cityId > " + paramIntent.b());
      b(this.b, paramIntent);
      return;
      if (((String)localObject).equals("appwidget_language_change"))
      {
        this.g = com.gau.go.launcherex.gowidget.language.d.a(this.b).a();
        if (this.g == null) {
          this.g = this.b.getResources();
        }
        b();
        return;
      }
      if (((String)localObject).equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_NEW_THEME_FLAG_CHANGE"))
      {
        if (!a.equals("app_widget_theme_white")) {
          break;
        }
        i1 = paramIntent.getIntExtra("extra_new_theme_flag", 0);
        if (i1 == 0)
        {
          this.v = false;
          b();
          return;
        }
        if (i1 != 1) {
          break;
        }
        this.v = true;
        b();
        return;
      }
      if ((((String)localObject).equals("android.appwidget.action.APPWIDGET_UPDATE")) || (((String)localObject).equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_WIDGET_ADD_APPWIDGET42")))
      {
        b();
        return;
      }
      if (((String)localObject).equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_WIDGET_DELETE_APPWIDGET42"))
      {
        if (AppWidgetManager.getInstance(this.b).getAppWidgetIds(new ComponentName(this.b, AppWidget42Provider.class)).length == 0)
        {
          this.f.clear();
          return;
        }
        paramIntent = paramIntent.getIntArrayExtra("extra_appwidget_ids");
        if (paramIntent == null) {
          break;
        }
        i1 = i2;
        while (i1 < paramIntent.length)
        {
          this.f.remove(paramIntent[i1]);
          i1 += 1;
        }
        break;
      }
      if (!((String)localObject).equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_INITIALIZED_CITY")) {
        break;
      }
      i1 = paramIntent.getIntExtra("city_location_state", 3);
      paramIntent = paramIntent.getStringExtra("city_location_id");
      if ((i1 == 4) && (!TextUtils.isEmpty(paramIntent))) {
        break;
      }
      this.d = false;
      b();
      return;
      label861:
      i1 = 0;
    }
  }
  
  public void a(com.gau.go.launcherex.gowidget.weather.model.q paramq)
  {
    boolean bool2 = false;
    this.h = paramq.g;
    this.l = paramq.q;
    this.i = paramq.h;
    com.gau.go.launcherex.gowidget.weather.c.g localg = this.m;
    boolean bool1;
    if (this.i == 1)
    {
      bool1 = true;
      localg.b(bool1);
      this.j = paramq.i;
      this.m.d(this.j);
      this.k = paramq.k;
      this.m.a(0, this.k);
      this.q = paramq.J;
      if (!this.q) {
        break label201;
      }
      localg = this.m;
      bool1 = bool2;
      if (paramq.r == 1) {
        bool1 = true;
      }
      localg.a(bool1);
    }
    for (;;)
    {
      paramq = paramq.G;
      if (!paramq.equals(a))
      {
        a = paramq;
        d(this.b);
      }
      if (!this.p) {
        this.p = true;
      }
      if ((!this.n) && (this.o) && (this.p))
      {
        this.n = true;
        b();
      }
      return;
      bool1 = false;
      break;
      label201:
      this.m.a(false);
    }
  }
  
  public void a(String paramString, com.gau.go.launcherex.gowidget.weather.model.q paramq)
  {
    Log.d("appwidget_42_helper", "onLoadSettingBeanDone_key = " + paramString);
    if (TextUtils.isEmpty(paramString))
    {
      a(paramq);
      return;
    }
    b(paramString, paramq);
  }
  
  public void a(ArrayList paramArrayList)
  {
    Log.d("appwidget_42_helper", "onLoadWeatherBeanDone");
    b(paramArrayList);
    if (this.n) {
      b();
    }
  }
  
  public void b(String paramString, com.gau.go.launcherex.gowidget.weather.model.q paramq)
  {
    boolean bool2 = true;
    boolean bool3 = true;
    boolean bool1 = true;
    if (paramString.equals("world_clock")) {
      if (paramq.r == 1)
      {
        if (!this.q) {
          break label54;
        }
        this.m.a(bool1);
        label43:
        b();
      }
    }
    label54:
    label98:
    label131:
    label226:
    label288:
    label332:
    do
    {
      int i1;
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return;
                bool1 = false;
                break;
                this.m.a(false);
                break label43;
                if (!paramString.equals("tempUnit")) {
                  break label98;
                }
                i1 = paramq.g;
              } while (this.h == i1);
              this.h = i1;
              b();
              return;
              if (!paramString.equals("windUnit")) {
                break label131;
              }
              i1 = paramq.q;
            } while (this.l == i1);
            this.l = i1;
            b();
            return;
            if (paramString.equals("app_widget_theme"))
            {
              paramString = paramq.G;
              if (!paramString.equals(a))
              {
                a = paramString;
                e(this.b);
              }
              d(this.b);
              b();
              return;
            }
            if (!paramString.equals("dateStyle")) {
              break label226;
            }
            i1 = paramq.k;
          } while (this.k == i1);
          this.k = i1;
          this.m.a(0, this.k);
          b();
          return;
          if (!paramString.equals("calendarType")) {
            break label288;
          }
          i1 = paramq.h;
        } while (this.i == i1);
        this.i = i1;
        paramString = this.m;
        if (this.i == 1) {}
        for (bool1 = bool2;; bool1 = false)
        {
          paramString.b(bool1);
          b();
          return;
        }
        if (!paramString.equals("festival")) {
          break label332;
        }
        i1 = paramq.i;
      } while (this.j == i1);
      this.j = i1;
      this.m.d(this.j);
      b();
      return;
    } while (!paramString.equals("Google_play_billing"));
    this.q = paramq.J;
    if (this.q)
    {
      paramString = this.m;
      if (paramq.r == 1)
      {
        bool1 = bool3;
        paramString.a(bool1);
      }
    }
    for (;;)
    {
      b();
      return;
      bool1 = false;
      break;
      this.m.a(false);
    }
  }
  
  public void b(ArrayList paramArrayList)
  {
    this.c.clear();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      WeatherBean localWeatherBean = (WeatherBean)paramArrayList.next();
      this.c.add(localWeatherBean);
    }
    if (!this.o) {
      this.o = true;
    }
    if ((!this.n) && (this.o) && (this.p))
    {
      this.n = true;
      b();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/systemwidget/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */