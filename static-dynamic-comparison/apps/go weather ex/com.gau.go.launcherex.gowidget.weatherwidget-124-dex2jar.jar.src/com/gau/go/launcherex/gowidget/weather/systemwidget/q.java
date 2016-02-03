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
import com.gau.go.launcherex.gowidget.billing.BillingActivity;
import com.gau.go.launcherex.gowidget.statistics.y;
import com.gau.go.launcherex.gowidget.weather.f.f;
import com.gau.go.launcherex.gowidget.weather.globaltheme.c;
import com.gau.go.launcherex.gowidget.weather.model.ForecastBean;
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
import java.util.Map;

public class q
  extends u
  implements aa, ae
{
  private int A;
  private int B;
  private int C;
  private String D = "";
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
  private int Q;
  private int R;
  private int S;
  private int T;
  private int U;
  private int V;
  private int W;
  private int X;
  private int Y;
  private int Z;
  private SparseArray a = new SparseArray();
  private int[] aA = new int[6];
  private int[] aB = new int[6];
  private int[] aC = new int[6];
  private int[] aD = new int[6];
  private int[] aE = new int[6];
  private int aF;
  private int aG;
  private int aH;
  private int aI = 0;
  private int aJ;
  private int aK;
  private int aL;
  private boolean aM = false;
  private boolean aN = false;
  private boolean aO = false;
  private boolean aP = false;
  private String aQ = "app_widget_theme_white";
  private boolean aR = false;
  private boolean aS = false;
  private String aT = "app_widget_theme_white";
  private t aU = null;
  private com.gau.go.launcherex.gowidget.weather.c.g aV = null;
  private f aW = null;
  private ar aX = null;
  private s aY;
  private Intent aZ;
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
  private int[] ay = new int[6];
  private int[] az = new int[6];
  private Resources f;
  private int[] g = new int[10];
  private int[] h = new int[10];
  private int[] i = new int[10];
  private int[] j = new int[10];
  private int[] k = new int[10];
  private int l = 0;
  private int[] m = { 2131165326, 2131165327, 2131165328, 2131165329, 2131165330, 2131165331, 2131165332 };
  private int[] n = { 2131166553, 2131166554, 2131166555, 2131166556, 2131166557, 2131166558, 2131166559, 2131166560, 2131166561, 2131166562, 2131166563, 2131166564 };
  private int o;
  private int p;
  private int q;
  private int r;
  private int s;
  private int t;
  private int u;
  private int v;
  private int w;
  private int x;
  private int y;
  private int z;
  
  public q(Context paramContext)
  {
    this.b = paramContext;
    this.f = com.gau.go.launcherex.gowidget.language.d.a(paramContext).a();
    if (this.f == null) {
      this.f = paramContext.getResources();
    }
    this.aV = new com.gau.go.launcherex.gowidget.weather.c.g(paramContext);
    this.aW = f.a(paramContext);
    this.aW.a(paramContext, this.aQ);
    this.aU = new t(paramContext.getContentResolver(), this);
    this.aY = new s(this, null);
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
    ((IntentFilter)localObject).addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_APPWIDGET_DAYS_42_NEXT_PAGE");
    ((IntentFilter)localObject).addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_INITIALIZED_CITY");
    paramContext.registerReceiver(this.aY, (IntentFilter)localObject);
    a.a().a("AppWidgetDays42ProviderHelper registerReceiver", "插件错误.txt");
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
    return r.a(this.j, paramInt, paramBoolean);
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
      return String.format(this.f.getString(2131165809), new Object[] { Float.valueOf(com.gau.go.launcherex.gowidget.weather.util.q.c(paramFloat, 1)) });
    }
    if (paramInt == 4) {
      return String.format(this.f.getString(2131165812), new Object[] { Float.valueOf(com.gau.go.launcherex.gowidget.weather.util.q.e(paramFloat, 1)) });
    }
    if (paramInt == 3) {
      return String.format(this.f.getString(2131165811), new Object[] { Float.valueOf(com.gau.go.launcherex.gowidget.weather.util.q.d(paramFloat, 1)) });
    }
    if (paramInt == 5) {
      return String.format(this.f.getString(2131165813), new Object[] { Integer.valueOf(com.gau.go.launcherex.gowidget.weather.util.q.a(paramFloat)) });
    }
    if (paramInt == 6) {
      return String.format(this.f.getString(2131165814), new Object[] { Float.valueOf(com.gau.go.launcherex.gowidget.weather.util.q.f(paramFloat, 1)) });
    }
    return String.format(this.f.getString(2131165810), new Object[] { Float.valueOf(paramFloat) });
  }
  
  private void a(int paramInt)
  {
    int i1 = 1;
    com.gau.go.launcherex.gowidget.weather.model.x localx;
    Object localObject;
    if (paramInt != 0)
    {
      localx = (com.gau.go.launcherex.gowidget.weather.model.x)this.a.get(paramInt);
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
    this.aU.a(1, Integer.valueOf(paramInt), WeatherContentProvider.t, new String[] { "current_cityid", "widget_location_type" }, "widget_id=?", new String[] { String.valueOf(paramInt) }, null);
  }
  
  private void a(Context paramContext, int paramInt)
  {
    if (this.aS)
    {
      com.gau.go.launcherex.gowidget.weather.model.x localx = (com.gau.go.launcherex.gowidget.weather.model.x)this.a.get(paramInt);
      if (localx != null)
      {
        String str = this.aQ;
        Log.d("appwidget_days_42_provider_helper", "mPreviewTheme: " + this.aT);
        if ((!TextUtils.isEmpty(this.aT)) && (!this.aT.equals(str)))
        {
          this.aQ = this.aT;
          localx.c(this.aQ);
          e(this.b);
        }
        paramContext = c(paramContext, localx);
        if (!str.equals(this.aQ))
        {
          this.aQ = str;
          localx.c(this.aQ);
          e(this.b);
        }
        a(paramContext);
      }
    }
  }
  
  private void a(Context paramContext, RemoteViews paramRemoteViews)
  {
    if (this.au != 0) {
      paramRemoteViews.setViewVisibility(this.au, 8);
    }
  }
  
  private void a(Context paramContext, RemoteViews paramRemoteViews, int paramInt1, Map paramMap, List paramList, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    int i1 = this.az.length;
    if (paramList != null) {
      i1 = paramList.size();
    }
    if ((paramInt1 >= 0) && (paramInt1 < i1))
    {
      paramContext = null;
      if (paramList != null) {
        paramContext = (ForecastBean)paramList.get(paramInt1);
      }
      if ((paramInt2 != 0) && (this.j != null) && (this.j[0] != 0))
      {
        if (paramContext == null) {
          break label375;
        }
        paramRemoteViews.setImageViewResource(paramInt2, b(paramContext.i(), true));
      }
      if (paramContext == null) {
        break label479;
      }
      paramInt1 = com.gau.go.launcherex.gowidget.weather.util.q.a(paramContext.a(this.aK));
      paramInt2 = com.gau.go.launcherex.gowidget.weather.util.q.a(paramContext.b(this.aK));
      paramContext = this.f.getString(this.m[r.b(paramContext.e(), paramContext.f(), paramContext.g())]);
    }
    for (;;)
    {
      if (paramInt3 != 0)
      {
        if ((paramInt2 != 55536) && (paramInt1 != 55536)) {
          paramRemoteViews.setTextViewText(paramInt3, paramContext + " " + paramInt2 + "°/" + paramInt1 + "°");
        }
      }
      else
      {
        label214:
        if (paramInt4 != 0)
        {
          if ((paramInt2 == 55536) || (paramInt1 == 55536)) {
            break label443;
          }
          paramRemoteViews.setTextViewText(paramInt4, paramInt2 + "°/" + paramInt1 + "°");
        }
        label271:
        if (paramInt5 != 0)
        {
          if (paramInt1 == 55536) {
            break label455;
          }
          paramRemoteViews.setTextViewText(paramInt5, paramInt1 + "°");
        }
        label309:
        if (paramInt6 != 0)
        {
          if (paramInt2 == 55536) {
            break label467;
          }
          paramRemoteViews.setTextViewText(paramInt6, paramInt2 + "°");
        }
      }
      for (;;)
      {
        if (paramInt7 != 0) {
          paramRemoteViews.setTextViewText(paramInt7, paramContext);
        }
        if (paramInt8 != 0) {
          paramRemoteViews.setViewVisibility(paramInt8, 8);
        }
        return;
        label375:
        paramRemoteViews.setImageViewResource(paramInt2, b(0, true));
        break;
        paramRemoteViews.setTextViewText(paramInt3, paramContext + " " + "-" + "°/" + "-" + "°");
        break label214;
        label443:
        paramRemoteViews.setTextViewText(paramInt4, "-°/-°");
        break label271;
        label455:
        paramRemoteViews.setTextViewText(paramInt5, "-°");
        break label309;
        label467:
        paramRemoteViews.setTextViewText(paramInt6, "-°");
      }
      label479:
      paramContext = "--";
      paramInt1 = 55536;
      paramInt2 = 55536;
    }
  }
  
  private void a(Context paramContext, RemoteViews paramRemoteViews, com.gau.go.launcherex.gowidget.weather.model.x paramx)
  {
    if (this.F != 0)
    {
      if (this.s == 0) {
        break label27;
      }
      paramRemoteViews.setImageViewResource(this.F, this.s);
    }
    label27:
    while ((this.t == 0) || (this.r == 0)) {
      return;
    }
    if (a(paramx))
    {
      paramRemoteViews.setImageViewResource(this.F, this.t);
      return;
    }
    paramRemoteViews.setImageViewResource(this.F, this.r);
  }
  
  private void a(Context paramContext, f paramf, String paramString1, String paramString2)
  {
    int i3 = 0;
    InputStream localInputStream2 = com.gau.go.launcherex.gowidget.weather.f.g.a(paramContext, paramString1, paramString2);
    InputStream localInputStream1 = localInputStream2;
    if (localInputStream2 == null) {
      localInputStream1 = com.gau.go.launcherex.gowidget.weather.f.g.b(paramContext, paramString1, paramString2.replace(".xml", ""));
    }
    if (localInputStream1 == null) {
      return;
    }
    paramContext = com.gau.go.launcherex.gowidget.weather.f.g.a(localInputStream1);
    if (this.aX == null) {
      this.aX = new ar();
    }
    ar.a = paramString1;
    this.aX.a("systemwidget_style", String.valueOf(425));
    if (paramContext != null) {
      new am().a(paramContext, this.aX);
    }
    try
    {
      localInputStream1.close();
      this.s = paramf.c(this.aX.a("go_weatherex_widget_bg"), paramString1);
      this.t = paramf.c(this.aX.a("go_weatherex_widget_bg_day"), paramString1);
      this.r = paramf.c(this.aX.a("go_weatherex_widget_bg_night"), paramString1);
      this.D = this.aX.a("go_weatherex_widget_date_style_color");
      this.q = paramf.c(this.aX.a("go_weatherex_widget_time_pm"), paramString1);
      this.A = paramf.c(this.aX.a("go_weatherex_widget_time_am"), paramString1);
      this.x = paramf.c(this.aX.a("go_weatherex_widget_time_ampm_empty"), paramString1);
      this.o = paramf.c(this.aX.a("go_weatherex_widget_time_bg"), paramString1);
      this.p = paramf.c(this.aX.a("go_weatherex_widget_change_city"), paramString1);
      this.u = paramf.c(this.aX.a("go_weatherex_widget_time_divider"), paramString1);
      this.w = paramf.c(this.aX.a("go_weatherex_widget_temp_unit"), paramString1);
      this.y = paramf.c(this.aX.a("go_weatherex_widget_temp_unit_centigrade"), paramString1);
      this.z = paramf.c(this.aX.a("go_weatherex_widget_temp_unit_fahrenheit"), paramString1);
      this.v = paramf.c(this.aX.a("go_weatherex_widget_temp_minus"), paramString1);
      i1 = 0;
      while (i1 < 10)
      {
        this.j[i1] = paramf.c(ar.c[i1], paramString1);
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
        this.g[i1] = paramf.c(ar.e[i1], paramString1);
        i1 += 1;
      }
      i1 = 0;
      while (i1 < 10)
      {
        this.h[i1] = paramf.c(ar.f[i1], paramString1);
        i1 += 1;
      }
      i1 = 0;
      int i2;
      for (;;)
      {
        i2 = i3;
        if (i1 >= 10) {
          break;
        }
        this.i[i1] = paramf.c(ar.g[i1], paramString1);
        i1 += 1;
      }
      while (i2 < 10)
      {
        this.k[i2] = paramf.c(ar.d[i2], paramString1);
        i2 += 1;
      }
      this.B = paramf.c(this.aX.a("go_weatherex_widget_next_page"), paramString1);
      this.C = paramf.c(this.aX.a("go_weatherex_widget_previous_page"), paramString1);
      this.l = this.v;
    }
  }
  
  private void a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    int i2 = 0;
    if (this.aW == null) {
      this.aW = f.a(paramContext);
    }
    this.aW.a(paramContext, paramString1);
    int i1;
    try
    {
      paramContext.getPackageManager().getPackageInfo(paramString1, 0);
      i1 = 1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        i1 = 0;
      }
      i1 = this.az.length - 1;
    }
    if (i1 != 0)
    {
      this.E = this.aW.a(paramString2, paramString1);
      this.F = this.aW.b("goweatherex_widget_days_l_bg", paramString1);
      this.I = this.aW.b("goweatherex_widget_days_l_am_pm", paramString1);
      this.Q = this.aW.b("goweatherex_widget_days_l_published_time", paramString1);
      this.G = this.aW.b("goweatherex_widget_days_l_weather_desp", paramString1);
      this.H = this.aW.b("goweatherex_widget_days_l_weather_temp_desp", paramString1);
      this.K = this.aW.b("goweatherex_widget_days_l_hour_num_1", paramString1);
      this.L = this.aW.b("goweatherex_widget_days_l_hour_num_2", paramString1);
      this.M = this.aW.b("goweatherex_widget_days_l_min_num_1", paramString1);
      this.N = this.aW.b("goweatherex_widget_days_l_min_num_2", paramString1);
      this.ac = this.aW.b("goweatherex_widget_days_l_layout_city", paramString1);
      this.af = this.aW.b("goweatherex_widget_days_l_text_next_city", paramString1);
      this.ae = this.aW.b("goweatherex_widget_days_l_img_next", paramString1);
      this.W = this.aW.b("goweatherex_widget_days_l_date_week", paramString1);
      this.ad = this.aW.b("goweatherex_widget_days_l_city_name", paramString1);
      this.ag = this.aW.b("goweatherex_widget_days_l_weather_icon", paramString1);
      this.J = this.aW.b("goweatherex_widget_l_time_fore", paramString1);
      this.O = this.aW.b("goweatherex_widget_days_l_time_divider", paramString1);
      this.P = this.aW.b("goweatherex_widget_days_l_timeboard", paramString1);
      this.ah = this.aW.b("goweatherex_widget_days_l_layout_now_temp", paramString1);
      this.ao = this.aW.b("goweatherex_widget_days_l_low_high_temp", paramString1);
      this.aq = this.aW.b("goweatherex_widget_days_l_low_temp", paramString1);
      this.ap = this.aW.b("goweatherex_widget_days_l_high_temp", paramString1);
      this.am = this.aW.b("goweatherex_widget_days_l_temp_minus", paramString1);
      this.ai = this.aW.b("goweatherex_widget_days_l_temp_num_1", paramString1);
      this.aj = this.aW.b("goweatherex_widget_days_l_temp_num_2", paramString1);
      this.ak = this.aW.b("goweatherex_widget_days_l_temp_num_3", paramString1);
      this.an = this.aW.b("goweatherex_widget_days_l_temp_unit", paramString1);
      this.ar = this.aW.b("goweatherex_widget_days_l_text_temp", paramString1);
      this.av = this.aW.b("goweatherex_widget_days_l_weather_refresh", paramString1);
      this.aw = this.aW.b("goweatherex_widget_days_l_refresh_progress", paramString1);
      this.al = this.aW.b("goweatherex_widget_days_l_detail_depict", paramString1);
      this.X = this.aW.b("goweatherex_widget_days_l_date", paramString1);
      this.Z = this.aW.b("goweatherex_widget_days_l_style_date", paramString1);
      this.aa = this.aW.b("goweatherex_widget_days_l_style_date_noyear", paramString1);
      this.Y = this.aW.b("goweatherex_widget_days_l_date_noyear", paramString1);
      this.ab = this.aW.b("goweatherex_widget_days_l_weekday", paramString1);
      this.at = this.aW.b("goweatherex_widget_days_l_wind", paramString1);
      this.as = this.aW.b("goweatherex_widget_days_l_detail_wind", paramString1);
      this.ax = this.aW.b("goweatherex_widget_days_l_theme_select", paramString1);
      this.au = this.aW.b("goweatherex_widget_days_l_extreme_icon", paramString1);
      i1 = i2;
      while (i1 < this.az.length)
      {
        this.az[i1] = this.aW.b("goweatherex_widget_days_l_weather_icon_forecast" + i1, paramString1);
        this.aE[i1] = this.aW.b("goweatherex_widget_days_l_week_low_high_temp_forecast" + i1, paramString1);
        this.aA[i1] = this.aW.b("goweatherex_widget_days_l_low_high_temp_forecast" + i1, paramString1);
        this.aB[i1] = this.aW.b("goweatherex_widget_days_l_low_temp_forecast" + i1, paramString1);
        this.aC[i1] = this.aW.b("goweatherex_widget_days_l_high_temp_forecast" + i1, paramString1);
        this.ay[i1] = this.aW.b("goweatherex_widget_days_l_weekday_forecast" + i1, paramString1);
        this.aD[i1] = this.aW.b("goweatherex_widget_days_l_extreme_icon_forecast" + i1, paramString1);
        i1 += 1;
      }
    }
    for (;;)
    {
      if (i1 >= 0)
      {
        if (this.az[i1] != 0) {
          this.aI = (i1 + 1);
        }
      }
      else
      {
        this.aF = this.aW.b("goweatherex_widget_days_l_next_page_forecast", paramString1);
        this.aG = this.aW.b("goweatherex_widget_days_l_page_pre_forecast", paramString1);
        this.aH = this.aW.b("goweatherex_widget_days_l_page_next_forecast", paramString1);
        this.R = this.aW.b("goweatherex_widget_days_l_text_time_ampm", paramString1);
        this.S = this.aW.b("goweatherex_widget_days_l_text_time", paramString1);
        this.T = this.aW.b("goweatherex_widget_days_l_text_time_hour", paramString1);
        this.U = this.aW.b("goweatherex_widget_days_l_text_time_min", paramString1);
        this.V = this.aW.b("goweatherex_widget_days_l_text_am_pm", paramString1);
        a(paramContext, this.aW, paramString1, paramString3);
        return;
      }
      i1 -= 1;
    }
  }
  
  private void a(RemoteViews paramRemoteViews)
  {
    if (paramRemoteViews == null) {
      return;
    }
    Intent localIntent = new Intent("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_APPWIDGET_UPDATE_PREVIEW");
    localIntent.putExtra("extra_widget_preview", paramRemoteViews);
    localIntent.putExtra("extra_widget_type", 4);
    this.b.sendBroadcast(localIntent);
  }
  
  private void a(Object paramObject, Cursor paramCursor)
  {
    Integer localInteger = (Integer)paramObject;
    int i1;
    if ((paramCursor != null) && (paramCursor.getCount() > 0))
    {
      paramObject = new com.gau.go.launcherex.gowidget.weather.model.x();
      ((com.gau.go.launcherex.gowidget.weather.model.x)paramObject).b(4);
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
            break label290;
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
          this.a.append(localInteger.intValue(), paramObject);
          b(this.b, (com.gau.go.launcherex.gowidget.weather.model.x)paramObject);
          a(this.b, localInteger.intValue());
        }
        if (this.aZ != null)
        {
          i1 = this.aZ.getIntExtra("extra_appwidget_ids", 0);
          if ((i1 != 0) && (i1 == localInteger.intValue()))
          {
            a(this.aZ);
            this.aZ = null;
          }
        }
        return;
        label290:
        i1 = 0;
        break;
        if (this.a.get(localInteger.intValue()) == null)
        {
          paramObject = b(localInteger.intValue());
          v.a(this.b).a((com.gau.go.launcherex.gowidget.weather.model.x)paramObject);
          Log.d("appwidget_days_42_provider_helper", "new widgetId > " + localInteger);
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
  
  private boolean a(com.gau.go.launcherex.gowidget.weather.model.x paramx)
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
    if ((this.aR) && (this.aV.d()))
    {
      int i1 = localWeatherBean.k.n();
      return r.a(paramx, str, this.aV.b(i1));
    }
    return r.a(paramx, str);
  }
  
  private int b(int paramInt, boolean paramBoolean)
  {
    return r.a(this.k, paramInt, paramBoolean);
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
  
  private Time b(com.gau.go.launcherex.gowidget.weather.model.x paramx)
  {
    WeatherBean localWeatherBean = null;
    if (paramx != null) {
      localWeatherBean = a(paramx.b());
    }
    if (localWeatherBean != null)
    {
      int i1 = localWeatherBean.k.n();
      return this.aV.b(i1);
    }
    return this.aV.b(55536);
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
        localx.b(4);
        return localx;
        localx.a("");
      }
    }
  }
  
  private void b()
  {
    Log.d("appwidget_days_42_provider_helper", "refreshUI");
    if (!this.aM) {
      break label17;
    }
    for (;;)
    {
      label17:
      return;
      if (!TextUtils.isEmpty(this.aQ))
      {
        if (this.E == 0)
        {
          e(this.b);
          if (this.E == 0) {
            break;
          }
        }
        int[] arrayOfInt = AppWidgetManager.getInstance(this.b).getAppWidgetIds(new ComponentName(this.b, AppWidgetDays42Provider.class));
        Log.d("appwidget_days_42_provider_helper", "共找到有" + arrayOfInt.length + "个该系统widget样式");
        int i1 = 0;
        while (i1 < arrayOfInt.length)
        {
          Log.d("appwidget_days_42_provider_helper", "第" + i1 + "个widgetID：" + arrayOfInt[i1]);
          if (i1 == 0) {
            a(this.b, arrayOfInt[i1]);
          }
          a(arrayOfInt[i1]);
          i1 += 1;
        }
      }
    }
  }
  
  private void b(Context paramContext, RemoteViews paramRemoteViews)
  {
    if ((this.av != 0) && (this.aw != 0))
    {
      if (this.aP)
      {
        paramRemoteViews.setViewVisibility(this.av, 4);
        paramRemoteViews.setViewVisibility(this.aw, 0);
      }
    }
    else {
      return;
    }
    paramRemoteViews.setViewVisibility(this.av, 0);
    paramRemoteViews.setViewVisibility(this.aw, 4);
  }
  
  private void b(Context paramContext, RemoteViews paramRemoteViews, com.gau.go.launcherex.gowidget.weather.model.x paramx)
  {
    int i2 = this.c.size();
    Object localObject = b(paramContext);
    int i1;
    if (localObject != null)
    {
      if (this.W != 0) {
        paramRemoteViews.setOnClickPendingIntent(this.W, (PendingIntent)localObject);
      }
      if (this.X != 0) {
        paramRemoteViews.setOnClickPendingIntent(this.X, (PendingIntent)localObject);
      }
      if (this.Y != 0) {
        paramRemoteViews.setOnClickPendingIntent(this.Y, (PendingIntent)localObject);
      }
      if (this.ab != 0) {
        paramRemoteViews.setOnClickPendingIntent(this.ab, (PendingIntent)localObject);
      }
      if (this.Z != 0) {
        paramRemoteViews.setOnClickPendingIntent(this.Z, (PendingIntent)localObject);
      }
      if (this.aa != 0) {
        paramRemoteViews.setOnClickPendingIntent(this.aa, (PendingIntent)localObject);
      }
      i1 = 0;
      while (i1 < this.ay.length)
      {
        if (this.ay[i1] != 0) {
          paramRemoteViews.setOnClickPendingIntent(this.ay[i1], (PendingIntent)localObject);
        }
        i1 += 1;
      }
    }
    localObject = a(paramContext);
    if (localObject != null)
    {
      if (this.J != 0) {
        paramRemoteViews.setOnClickPendingIntent(this.J, (PendingIntent)localObject);
      }
      if (this.K != 0) {
        paramRemoteViews.setOnClickPendingIntent(this.K, (PendingIntent)localObject);
      }
      if (this.L != 0) {
        paramRemoteViews.setOnClickPendingIntent(this.L, (PendingIntent)localObject);
      }
      if (this.M != 0) {
        paramRemoteViews.setOnClickPendingIntent(this.M, (PendingIntent)localObject);
      }
      if (this.N != 0) {
        paramRemoteViews.setOnClickPendingIntent(this.N, (PendingIntent)localObject);
      }
      if (this.R != 0) {
        paramRemoteViews.setOnClickPendingIntent(this.R, (PendingIntent)localObject);
      }
      if (this.I != 0) {
        paramRemoteViews.setOnClickPendingIntent(this.I, (PendingIntent)localObject);
      }
      if (this.S != 0) {
        paramRemoteViews.setOnClickPendingIntent(this.S, (PendingIntent)localObject);
      }
      if (this.T != 0) {
        paramRemoteViews.setOnClickPendingIntent(this.T, (PendingIntent)localObject);
      }
      if (this.U != 0) {
        paramRemoteViews.setOnClickPendingIntent(this.U, (PendingIntent)localObject);
      }
      if (this.V != 0) {
        paramRemoteViews.setOnClickPendingIntent(this.V, (PendingIntent)localObject);
      }
    }
    localObject = d(paramContext, paramx);
    if (localObject != null)
    {
      if (this.ag != 0) {
        paramRemoteViews.setOnClickPendingIntent(this.ag, (PendingIntent)localObject);
      }
      if (this.ah != 0) {
        paramRemoteViews.setOnClickPendingIntent(this.ah, (PendingIntent)localObject);
      }
      if (this.G != 0) {
        paramRemoteViews.setOnClickPendingIntent(this.G, (PendingIntent)localObject);
      }
      if (this.H != 0) {
        paramRemoteViews.setOnClickPendingIntent(this.H, (PendingIntent)localObject);
      }
      if (this.al != 0) {
        paramRemoteViews.setOnClickPendingIntent(this.al, (PendingIntent)localObject);
      }
      if (this.ao != 0) {
        paramRemoteViews.setOnClickPendingIntent(this.ao, (PendingIntent)localObject);
      }
      if (this.ap != 0) {
        paramRemoteViews.setOnClickPendingIntent(this.ap, (PendingIntent)localObject);
      }
      if (this.aq != 0) {
        paramRemoteViews.setOnClickPendingIntent(this.aq, (PendingIntent)localObject);
      }
      if (this.at != 0) {
        paramRemoteViews.setOnClickPendingIntent(this.at, (PendingIntent)localObject);
      }
      if (this.as != 0) {
        paramRemoteViews.setOnClickPendingIntent(this.as, (PendingIntent)localObject);
      }
      if (this.Q != 0) {
        paramRemoteViews.setOnClickPendingIntent(this.Q, (PendingIntent)localObject);
      }
      if (this.ar != 0) {
        paramRemoteViews.setOnClickPendingIntent(this.ar, (PendingIntent)localObject);
      }
      i1 = 0;
      while (i1 < this.az.length)
      {
        if (this.az[i1] != 0) {
          paramRemoteViews.setOnClickPendingIntent(this.az[i1], (PendingIntent)localObject);
        }
        i1 += 1;
      }
      i1 = 0;
      while (i1 < this.aE.length)
      {
        if (this.aE[i1] != 0) {
          paramRemoteViews.setOnClickPendingIntent(this.aE[i1], (PendingIntent)localObject);
        }
        i1 += 1;
      }
      i1 = 0;
      while (i1 < this.aA.length)
      {
        if (this.aA[i1] != 0) {
          paramRemoteViews.setOnClickPendingIntent(this.aA[i1], (PendingIntent)localObject);
        }
        i1 += 1;
      }
      i1 = 0;
      while (i1 < this.aB.length)
      {
        if (this.aB[i1] != 0) {
          paramRemoteViews.setOnClickPendingIntent(this.aB[i1], (PendingIntent)localObject);
        }
        i1 += 1;
      }
      i1 = 0;
      while (i1 < this.aC.length)
      {
        if (this.aC[i1] != 0) {
          paramRemoteViews.setOnClickPendingIntent(this.aC[i1], (PendingIntent)localObject);
        }
        i1 += 1;
      }
    }
    if ((this.aM) && (i2 > 1))
    {
      localObject = new Intent(paramContext, AppWidgetService.class);
      ((Intent)localObject).putExtra("appwidget_service_request", 21);
      ((Intent)localObject).putExtra("request_extra_appwidget_type", 4);
      if (paramx != null)
      {
        ((Intent)localObject).putExtra("extra_appwidget_ids", paramx.a());
        i1 = paramx.a() + 196608;
        localObject = PendingIntent.getService(paramContext, i1, (Intent)localObject, 134217728);
      }
    }
    for (;;)
    {
      if (localObject != null)
      {
        if (this.ac != 0) {
          paramRemoteViews.setOnClickPendingIntent(this.ac, (PendingIntent)localObject);
        }
        if (this.ad != 0) {
          paramRemoteViews.setOnClickPendingIntent(this.ad, (PendingIntent)localObject);
        }
        if (this.af != 0) {
          paramRemoteViews.setOnClickPendingIntent(this.af, (PendingIntent)localObject);
        }
      }
      if (this.ax != 0)
      {
        localObject = a(paramContext, paramx);
        if (localObject != null)
        {
          paramRemoteViews.setViewVisibility(this.ax, 0);
          paramRemoteViews.setOnClickPendingIntent(this.ax, (PendingIntent)localObject);
        }
      }
      if ((this.aM) && (i2 != 0))
      {
        localObject = c(paramContext);
        if ((this.av != 0) && (localObject != null)) {
          paramRemoteViews.setOnClickPendingIntent(this.av, (PendingIntent)localObject);
        }
      }
      if (this.aM)
      {
        paramContext = e(paramContext, paramx);
        if (paramContext != null)
        {
          if (this.aF != 0) {
            paramRemoteViews.setOnClickPendingIntent(this.aF, paramContext);
          }
          if (this.aG != 0) {
            paramRemoteViews.setOnClickPendingIntent(this.aG, paramContext);
          }
          if (this.aH != 0) {
            paramRemoteViews.setOnClickPendingIntent(this.aH, paramContext);
          }
        }
      }
      return;
      i1 = 196608;
      break;
    }
  }
  
  private void b(Context paramContext, com.gau.go.launcherex.gowidget.weather.model.x paramx)
  {
    int i1 = 0;
    if (paramx != null) {
      i1 = paramx.a();
    }
    if (i1 == 0) {}
    do
    {
      return;
      paramx = c(paramContext, paramx);
      paramContext = AppWidgetManager.getInstance(paramContext);
    } while ((paramx == null) || (paramContext == null) || (i1 == 0));
    paramContext.updateAppWidget(i1, paramx);
  }
  
  private RemoteViews c(Context paramContext, com.gau.go.launcherex.gowidget.weather.model.x paramx)
  {
    if ((TextUtils.isEmpty(this.aQ)) || (this.aQ.contains("app_widget_theme"))) {}
    for (RemoteViews localRemoteViews = new RemoteViews(paramContext.getPackageName(), this.E);; localRemoteViews = new RemoteViews(this.aQ, this.E))
    {
      a(paramContext, localRemoteViews, paramx);
      b(paramContext, localRemoteViews, paramx);
      c(paramContext, localRemoteViews, paramx);
      g(paramContext, localRemoteViews, paramx);
      d(paramContext, localRemoteViews, paramx);
      a(paramContext, localRemoteViews);
      b(paramContext, localRemoteViews);
      e(paramContext, localRemoteViews, paramx);
      f(paramContext, localRemoteViews, paramx);
      return localRemoteViews;
    }
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
  
  private void c(Context paramContext, RemoteViews paramRemoteViews, com.gau.go.launcherex.gowidget.weather.model.x paramx)
  {
    if ((this.P != 0) && (this.o != 0)) {
      paramRemoteViews.setImageViewResource(this.P, this.o);
    }
    if ((this.O != 0) && (this.u != 0)) {
      paramRemoteViews.setImageViewResource(this.O, this.u);
    }
    Time localTime = b(paramx);
    int i2 = localTime.hour;
    int i1 = i2;
    if (!r.b(paramContext))
    {
      i2 %= 12;
      i1 = i2;
      if (i2 == 0) {
        i1 = 12;
      }
    }
    i2 = localTime.minute;
    if ((this.K != 0) && (this.g != null) && (this.g[0] != 0)) {
      paramRemoteViews.setImageViewResource(this.K, r.a(i1 / 10, this.g));
    }
    if ((this.L != 0) && (this.g != null) && (this.g[0] != 0)) {
      paramRemoteViews.setImageViewResource(this.L, r.a(i1 % 10, this.g));
    }
    if (this.M != 0)
    {
      if ((this.h != null) && (this.h[0] != 0)) {
        paramRemoteViews.setImageViewResource(this.M, r.a(i2 / 10, this.h));
      }
    }
    else
    {
      if (this.N != 0)
      {
        if ((this.h == null) || (this.h[0] == 0)) {
          break label918;
        }
        paramRemoteViews.setImageViewResource(this.N, r.a(i2 % 10, this.h));
      }
      label276:
      if (this.S != 0) {
        paramRemoteViews.setTextViewText(this.S, r.e(i1) + ":" + r.e(i2));
      }
      if (this.T != 0) {
        paramRemoteViews.setTextViewText(this.T, r.e(i1));
      }
      if (this.U != 0) {
        paramRemoteViews.setTextViewText(this.U, r.e(i2));
      }
      if (!r.b(paramContext)) {
        break label970;
      }
      if (this.I != 0)
      {
        if (this.x == 0) {
          break label957;
        }
        paramRemoteViews.setViewVisibility(this.I, 0);
        paramRemoteViews.setImageViewResource(this.I, this.x);
      }
      label405:
      if (this.V != 0) {
        paramRemoteViews.setViewVisibility(this.V, 8);
      }
      if (this.R != 0) {
        paramRemoteViews.setTextViewText(this.R, r.e(i1) + ":" + r.e(i2));
      }
      label469:
      if (this.aV == null) {
        break label1236;
      }
      if (this.Y != 0)
      {
        this.aV.a(1, this.aL);
        paramContext = this.aV.a(localTime);
        paramRemoteViews.setTextViewText(this.Y, paramContext);
        this.aV.a(0, this.aL);
      }
      paramx = this.aV.a(localTime);
      paramContext = paramx;
      if (this.X != 0)
      {
        paramRemoteViews.setTextViewText(this.X, paramx);
        paramContext = paramx;
      }
      label556:
      i1 = this.m[localTime.weekDay];
      if (this.W != 0) {
        paramRemoteViews.setTextViewText(this.W, this.f.getString(i1) + "  " + paramContext);
      }
      if (this.ab != 0) {
        paramRemoteViews.setTextViewText(this.ab, this.f.getString(i1));
      }
      if (this.Z != 0)
      {
        if (TextUtils.isEmpty(this.D)) {
          break label1461;
        }
        paramContext = this.f.getString(this.n[localTime.month]);
      }
      switch (this.aL)
      {
      default: 
        paramContext = String.format(this.f.getString(2131166565), new Object[] { this.D, Integer.valueOf(localTime.year), paramContext, Integer.valueOf(localTime.monthDay) });
        label751:
        paramContext = Html.fromHtml(paramContext);
        paramRemoteViews.setTextViewText(this.Z, paramContext);
        if (this.aa != 0)
        {
          if (TextUtils.isEmpty(this.D)) {
            break label1694;
          }
          paramContext = this.f.getString(this.n[localTime.month]);
          switch (this.aL)
          {
          }
        }
        break;
      }
    }
    for (paramContext = String.format(this.f.getString(2131166568), new Object[] { this.D, paramContext, Integer.valueOf(localTime.monthDay) });; paramContext = String.format(this.f.getString(2131166569), new Object[] { this.D, paramContext, Integer.valueOf(localTime.monthDay) }))
    {
      paramContext = Html.fromHtml(paramContext);
      paramRemoteViews.setTextViewText(this.aa, paramContext);
      return;
      if ((this.g == null) || (this.g[0] == 0)) {
        break;
      }
      paramRemoteViews.setImageViewResource(this.M, r.a(i2 / 10, this.g));
      break;
      label918:
      if ((this.g == null) || (this.g[0] == 0)) {
        break label276;
      }
      paramRemoteViews.setImageViewResource(this.N, r.a(i2 % 10, this.g));
      break label276;
      label957:
      paramRemoteViews.setViewVisibility(this.I, 8);
      break label405;
      label970:
      if ((localTime.hour >= 0) && (localTime.hour <= 11))
      {
        if ((this.I != 0) && (this.A != 0))
        {
          paramRemoteViews.setViewVisibility(this.I, 0);
          paramRemoteViews.setImageViewResource(this.I, this.A);
        }
        if (this.V != 0)
        {
          paramRemoteViews.setViewVisibility(this.V, 0);
          paramRemoteViews.setTextViewText(this.V, "AM");
        }
        if (this.R == 0) {
          break label469;
        }
        paramRemoteViews.setTextViewText(this.R, r.e(i1) + ":" + r.e(i2) + " " + "AM");
        break label469;
      }
      if ((this.I != 0) && (this.q != 0))
      {
        paramRemoteViews.setViewVisibility(this.I, 0);
        paramRemoteViews.setImageViewResource(this.I, this.q);
      }
      if (this.V != 0)
      {
        paramRemoteViews.setViewVisibility(this.V, 0);
        paramRemoteViews.setTextViewText(this.V, "PM");
      }
      if (this.R == 0) {
        break label469;
      }
      paramRemoteViews.setTextViewText(this.R, r.e(i1) + ":" + r.e(i2) + " " + "PM");
      break label469;
      label1236:
      paramx = localTime.year + "/" + localTime.month + "/" + localTime.monthDay;
      if (this.X != 0) {
        paramRemoteViews.setTextViewText(this.X, paramx);
      }
      paramContext = paramx;
      if (this.Y == 0) {
        break label556;
      }
      paramRemoteViews.setTextViewText(this.Y, localTime.month + "/" + localTime.monthDay);
      paramContext = paramx;
      break label556;
      paramContext = String.format(this.f.getString(2131166566), new Object[] { this.D, Integer.valueOf(localTime.year), paramContext, Integer.valueOf(localTime.monthDay) });
      break label751;
      paramContext = String.format(this.f.getString(2131166567), new Object[] { this.D, Integer.valueOf(localTime.year), paramContext, Integer.valueOf(localTime.monthDay) });
      break label751;
      label1461:
      paramContext = this.f.getString(this.n[localTime.month]);
      switch (this.aL)
      {
      default: 
        paramContext = localTime.year + " " + paramContext + " " + localTime.monthDay;
      }
      for (;;)
      {
        paramRemoteViews.setTextViewText(this.Z, paramContext);
        break;
        paramContext = paramContext + " " + localTime.monthDay + " " + localTime.year;
        continue;
        paramContext = localTime.monthDay + " " + paramContext + " " + localTime.year;
      }
    }
    label1694:
    paramContext = this.f.getString(this.n[localTime.month]);
    switch (this.aL)
    {
    }
    for (paramContext = paramContext + " " + localTime.monthDay;; paramContext = localTime.monthDay + " " + paramContext)
    {
      paramRemoteViews.setTextViewText(this.aa, paramContext);
      return;
    }
  }
  
  private PendingIntent d(Context paramContext, com.gau.go.launcherex.gowidget.weather.model.x paramx)
  {
    Object localObject = "";
    if (paramx != null) {
      localObject = paramx.b();
    }
    localObject = WeatherDetailActivity.a(this.b, (String)localObject, true, 8, "", -1);
    ((Intent)localObject).addFlags(67108864);
    if (paramx != null) {}
    for (int i1 = paramx.a() + 262144;; i1 = 262144) {
      return PendingIntent.getActivity(paramContext, i1, (Intent)localObject, 134217728);
    }
  }
  
  private void d(Context paramContext)
  {
    AppWidgetManager localAppWidgetManager = AppWidgetManager.getInstance(paramContext);
    if (localAppWidgetManager != null) {
      localAppWidgetManager.updateAppWidget(new ComponentName(paramContext, AppWidgetDays42Provider.class), null);
    }
  }
  
  private void d(Context paramContext, RemoteViews paramRemoteViews, com.gau.go.launcherex.gowidget.weather.model.x paramx)
  {
    if (paramx != null) {}
    for (int i1 = b(paramx.b());; i1 = 0)
    {
      int i3 = this.c.size();
      int i2;
      if (i1 >= 0)
      {
        i2 = i1;
        if (i1 < i3) {}
      }
      else
      {
        i2 = 0;
      }
      if (i3 != 0)
      {
        i1 = com.gau.go.launcherex.gowidget.weather.util.q.a(((WeatherBean)this.c.get(i2)).k.a(this.aK));
        if (i1 != 55536) {
          if (this.ar != 0)
          {
            paramRemoteViews.setViewVisibility(this.ar, 0);
            if (this.aK == 1) {
              paramRemoteViews.setTextViewText(this.ar, String.valueOf(i1) + "°C");
            }
          }
          else if ((this.i != null) && (this.i[0] != 0))
          {
            if (this.am != 0)
            {
              if (i1 >= 0) {
                break label616;
              }
              paramRemoteViews.setViewVisibility(this.am, 0);
              if (this.v != 0) {
                paramRemoteViews.setImageViewResource(this.am, this.v);
              }
            }
            label198:
            i1 = Math.abs(i1);
            i2 = i1 / 100;
            if ((this.ai != 0) && (this.i != null) && (this.i[0] != 0))
            {
              if (i2 != 0) {
                break label629;
              }
              paramRemoteViews.setViewVisibility(this.ai, 8);
            }
            label250:
            i3 = (i1 - i2 * 100) / 10;
            if ((this.aj != 0) && (this.i != null) && (this.i[0] != 0))
            {
              if ((i3 != 0) || (i2 != 0)) {
                break label658;
              }
              paramRemoteViews.setViewVisibility(this.aj, 8);
            }
            label306:
            if ((this.ak != 0) && (this.i != null) && (this.i[0] != 0))
            {
              paramRemoteViews.setImageViewResource(this.ak, r.a(i1 % 10, this.i));
              paramRemoteViews.setViewVisibility(this.ak, 0);
            }
            if (this.an != 0)
            {
              if ((this.y == 0) || (this.z == 0)) {
                break label702;
              }
              if (this.aK != 1) {
                break label687;
              }
              paramRemoteViews.setImageViewResource(this.an, this.y);
            }
          }
        }
      }
      label399:
      for (i1 = 1;; i1 = 0)
      {
        if (i1 == 0)
        {
          if (this.ar != 0)
          {
            paramRemoteViews.setViewVisibility(this.ar, 0);
            if (this.aK != 1) {
              break label724;
            }
            paramRemoteViews.setTextViewText(this.ar, "--°C");
          }
          label442:
          if ((this.am != 0) && (this.ai != 0) && (this.aj != 0) && (this.ak != 0) && (this.l != 0))
          {
            paramRemoteViews.setViewVisibility(this.am, 8);
            paramRemoteViews.setViewVisibility(this.ai, 8);
            paramRemoteViews.setImageViewResource(this.aj, this.l);
            paramRemoteViews.setViewVisibility(this.aj, 0);
            paramRemoteViews.setImageViewResource(this.ak, this.l);
            paramRemoteViews.setViewVisibility(this.ak, 0);
            if (this.an != 0)
            {
              if ((this.y == 0) || (this.z == 0)) {
                break label751;
              }
              if (this.aK != 1) {
                break label738;
              }
              paramRemoteViews.setImageViewResource(this.an, this.y);
            }
          }
        }
        label616:
        label629:
        label658:
        label687:
        label702:
        label724:
        label738:
        label751:
        while (this.w == 0)
        {
          return;
          paramRemoteViews.setTextViewText(this.ar, String.valueOf(i1) + "°F");
          break;
          paramRemoteViews.setViewVisibility(this.am, 8);
          break label198;
          paramRemoteViews.setImageViewResource(this.ai, r.a(i2, this.i));
          paramRemoteViews.setViewVisibility(this.ai, 0);
          break label250;
          paramRemoteViews.setImageViewResource(this.aj, r.a(i3, this.i));
          paramRemoteViews.setViewVisibility(this.aj, 0);
          break label306;
          paramRemoteViews.setImageViewResource(this.an, this.z);
          break label399;
          if (this.w == 0) {
            break label399;
          }
          paramRemoteViews.setImageViewResource(this.an, this.w);
          break label399;
          paramRemoteViews.setTextViewText(this.ar, "--°F");
          break label442;
          paramRemoteViews.setImageViewResource(this.an, this.z);
          return;
        }
        paramRemoteViews.setImageViewResource(this.an, this.w);
        return;
      }
    }
  }
  
  private PendingIntent e(Context paramContext, com.gau.go.launcherex.gowidget.weather.model.x paramx)
  {
    int i1 = 393216;
    Intent localIntent = new Intent();
    if (!this.aR)
    {
      localIntent.setClass(paramContext, BillingActivity.class);
      localIntent.putExtra("recommend_type", 4);
      localIntent.putExtra("recommend_enterance", 12);
      return PendingIntent.getActivity(paramContext, 0, localIntent, 134217728);
    }
    localIntent = new Intent(paramContext, AppWidgetService.class);
    localIntent.putExtra("appwidget_service_request", 22);
    localIntent.putExtra("request_extra_appwidget_type", 4);
    if (paramx != null)
    {
      localIntent.putExtra("extra_appwidget_ids", paramx.a());
      i1 = 393216 + paramx.a();
    }
    return PendingIntent.getService(paramContext, i1, localIntent, 134217728);
  }
  
  private void e(Context paramContext)
  {
    Log.d("appwidget_days_42_provider_helper", "loadThemeRes");
    if (TextUtils.isEmpty(this.aQ)) {}
    String str;
    do
    {
      return;
      str = com.gau.go.launcherex.gowidget.weather.globaltheme.c.d.a(paramContext, this.aQ);
      this.E = 0;
      if (!this.aQ.contains("app_widget_theme"))
      {
        a(paramContext, this.aQ, "z_appwidget_days_l_provider", "systemwidget_weatherwidget.xml");
        if (this.E == 0) {
          this.aQ = "app_widget_theme_white";
        }
      }
    } while (this.E != 0);
    a(paramContext, paramContext.getPackageName(), c.a(3, str), c.a(str));
  }
  
  private void e(Context paramContext, RemoteViews paramRemoteViews, com.gau.go.launcherex.gowidget.weather.model.x paramx)
  {
    if (paramx != null) {}
    for (int i1 = b(paramx.b());; i1 = 0)
    {
      int i3 = this.c.size();
      int i2;
      if (i1 >= 0)
      {
        i2 = i1;
        if (i1 < i3) {}
      }
      else
      {
        i2 = 0;
      }
      if ((i3 != 0) && (this.Q != 0))
      {
        paramContext = r.a(paramContext, ((WeatherBean)this.c.get(i2)).k.f());
        if (paramContext.equals("-10000")) {
          paramRemoteViews.setTextViewText(this.Q, this.f.getString(2131165888) + " : " + "--");
        }
      }
      else
      {
        return;
      }
      paramRemoteViews.setTextViewText(this.Q, paramContext);
      return;
    }
  }
  
  private void f(Context paramContext, RemoteViews paramRemoteViews, com.gau.go.launcherex.gowidget.weather.model.x paramx)
  {
    int i2;
    if (paramx != null) {
      i2 = b(paramx.b());
    }
    for (int i1 = paramx.f();; i1 = 0)
    {
      int i4 = this.c.size();
      int i3;
      if (i2 >= 0)
      {
        i3 = i2;
        if (i2 < i4) {}
      }
      else
      {
        i3 = 0;
      }
      if (i4 != 0)
      {
        paramx = (WeatherBean)this.c.get(i3);
        if ((paramx != null) && (paramx.g != null))
        {
          i2 = paramx.k.n();
          Object localObject = this.aV.c(i2);
          localObject = r.a(paramx.g, (Time)localObject, true);
          if (this.az[0] != 0)
          {
            if (i1 < ((ArrayList)localObject).size()) {
              break label797;
            }
            i1 = 0;
            if (((ArrayList)localObject).size() > this.aI) {
              break label351;
            }
            if (this.aF != 0) {
              paramRemoteViews.setViewVisibility(this.aF, 4);
            }
            if (this.aG != 0) {
              paramRemoteViews.setViewVisibility(this.aG, 4);
            }
            if (this.aH != 0) {
              paramRemoteViews.setViewVisibility(this.aH, 4);
            }
            label195:
            String str = y.f(this.b);
            if ((str == null) || ((!str.equals("200")) && (!str.equals("414")))) {
              break label546;
            }
            label231:
            paramx = paramx.n();
            i2 = 0;
            label239:
            if (i2 >= this.aI) {
              break label661;
            }
            if (i1 + i2 >= ((ArrayList)localObject).size()) {
              break label600;
            }
            a(paramContext, paramRemoteViews, i1 + i2, paramx, (List)localObject, this.az[i2], this.aE[i2], this.aA[i2], this.aB[i2], this.aC[i2], this.ay[i2], this.aD[i2]);
          }
          for (;;)
          {
            i2 += 1;
            break label239;
            if (i1 < ((ArrayList)localObject).size() - 1) {
              break label797;
            }
            i1 = 0;
            break;
            label351:
            if (this.aF != 0) {
              paramRemoteViews.setViewVisibility(this.aF, 0);
            }
            if ((this.aG != 0) && (this.C != 0)) {
              paramRemoteViews.setImageViewResource(this.aG, this.C);
            }
            if ((this.aH != 0) && (this.B != 0)) {
              paramRemoteViews.setImageViewResource(this.aH, this.B);
            }
            if (i1 == 0)
            {
              if ((this.aF != 0) && (this.B != 0)) {
                paramRemoteViews.setImageViewResource(this.aF, this.B);
              }
              if (this.aG != 0) {
                paramRemoteViews.setViewVisibility(this.aG, 4);
              }
              if (this.aH == 0) {
                break label195;
              }
              paramRemoteViews.setViewVisibility(this.aH, 0);
              break label195;
            }
            if ((this.aF != 0) && (this.C != 0)) {
              paramRemoteViews.setImageViewResource(this.aF, this.C);
            }
            if (this.aG != 0) {
              paramRemoteViews.setViewVisibility(this.aG, 0);
            }
            if (this.aH == 0) {
              break label195;
            }
            paramRemoteViews.setViewVisibility(this.aH, 4);
            break label195;
            label546:
            if (this.aF != 0) {
              paramRemoteViews.setViewVisibility(this.aF, 8);
            }
            if (this.aG != 0) {
              paramRemoteViews.setViewVisibility(this.aG, 8);
            }
            if (this.aH == 0) {
              break label231;
            }
            paramRemoteViews.setViewVisibility(this.aH, 8);
            break label231;
            label600:
            a(paramContext, paramRemoteViews, 0, null, null, this.az[i2], this.aE[i2], this.aA[i2], this.aB[i2], this.aC[i2], this.ay[i2], this.aD[i2]);
          }
        }
      }
      label661:
      for (i1 = 0;; i1 = 1)
      {
        if (i1 != 0)
        {
          i1 = 0;
          while (i1 < this.aI)
          {
            a(paramContext, paramRemoteViews, 0, null, null, this.az[i1], this.aE[i1], this.aA[i1], this.aB[i1], this.aC[i1], this.ay[i1], this.aD[i1]);
            i1 += 1;
          }
          if (this.aF != 0) {
            paramRemoteViews.setViewVisibility(this.aF, 4);
          }
          if (this.aG != 0) {
            paramRemoteViews.setViewVisibility(this.aG, 4);
          }
          if (this.aH != 0) {
            paramRemoteViews.setViewVisibility(this.aH, 4);
          }
        }
        return;
        label797:
        break;
      }
      i2 = 0;
    }
  }
  
  private void g(Context paramContext, RemoteViews paramRemoteViews, com.gau.go.launcherex.gowidget.weather.model.x paramx)
  {
    if (paramx != null) {}
    for (int i1 = b(paramx.b());; i1 = 0)
    {
      int i3 = this.c.size();
      int i2;
      if (i1 >= 0)
      {
        i2 = i1;
        if (i1 < i3) {}
      }
      else
      {
        i2 = 0;
      }
      Object localObject;
      NowBean localNowBean;
      if (i3 != 0)
      {
        localObject = (WeatherBean)this.c.get(i2);
        if (localObject != null)
        {
          if (this.ae != 0)
          {
            paramRemoteViews.setViewVisibility(this.ae, 8);
            if (this.p != 0) {
              paramRemoteViews.setImageViewResource(this.ae, this.p);
            }
          }
          if (this.af != 0) {
            paramRemoteViews.setViewVisibility(this.af, 8);
          }
          if (this.ad != 0) {
            paramRemoteViews.setTextViewText(this.ad, ((WeatherBean)localObject).d());
          }
          localNowBean = ((WeatherBean)localObject).k;
          if ((this.ag != 0) && (this.j != null) && (this.j[0] != 0)) {
            paramRemoteViews.setImageViewResource(this.ag, a(localNowBean.d(), a(paramx)));
          }
          i1 = com.gau.go.launcherex.gowidget.weather.util.q.a(localNowBean.b(this.aK));
          i2 = com.gau.go.launcherex.gowidget.weather.util.q.a(localNowBean.c(this.aK));
          if (this.al != 0)
          {
            if ((i1 == 55536) || (i2 == 55536)) {
              break label1051;
            }
            if ((!localNowBean.e().equals("--")) && (!TextUtils.isEmpty(localNowBean.e())))
            {
              localObject = localNowBean.e() + "," + i1 + "°/" + i2 + "° ," + localNowBean.b();
              paramRemoteViews.setTextViewText(this.al, (CharSequence)localObject);
            }
          }
          else
          {
            if (this.G != 0)
            {
              if ((localNowBean.e().equals("--")) || (TextUtils.isEmpty(localNowBean.e()))) {
                break label1177;
              }
              paramRemoteViews.setTextViewText(this.G, localNowBean.e());
            }
            label382:
            if (this.H != 0)
            {
              localObject = new StringBuffer();
              if ((i1 == 55536) || (i2 == 55536)) {
                break label1198;
              }
              ((StringBuffer)localObject).append(i1 + "°/" + i2 + "°");
              label452:
              ((StringBuffer)localObject).append(", ");
              if ((localNowBean.e().equals("--")) || (TextUtils.isEmpty(localNowBean.e()))) {
                break label1210;
              }
              ((StringBuffer)localObject).append(localNowBean.e());
              label497:
              paramRemoteViews.setTextViewText(this.H, ((StringBuffer)localObject).toString());
            }
            if ((this.at != 0) && (!localNowBean.b().equals("--"))) {
              paramRemoteViews.setTextViewText(this.at, this.f.getString(2131166456) + localNowBean.b());
            }
            if (this.ao != 0)
            {
              if ((i1 == 55536) || (i2 == 55536)) {
                break label1229;
              }
              paramRemoteViews.setTextViewText(this.ao, i1 + "°/" + i2 + "° ");
            }
            label633:
            if (this.ap != 0)
            {
              if (i1 == 55536) {
                break label1243;
              }
              paramRemoteViews.setTextViewText(this.ap, i1 + "° ");
            }
            label677:
            if (this.aq != 0)
            {
              if (i2 == 55536) {
                break label1257;
              }
              paramRemoteViews.setTextViewText(this.aq, i2 + "° ");
            }
            label721:
            if (this.as != 0)
            {
              localObject = localNowBean.b();
              if (r.a((String)localObject)) {
                break label1271;
              }
              paramContext = paramContext.getText(2131165323).toString();
              paramRemoteViews.setTextViewText(this.as, paramContext);
            }
          }
        }
      }
      label763:
      for (i1 = 1;; i1 = 0)
      {
        if (i1 == 0)
        {
          if (this.G != 0) {
            paramRemoteViews.setTextViewText(this.G, "--");
          }
          if (this.H != 0) {
            paramRemoteViews.setTextViewText(this.H, "--");
          }
          if (this.al != 0) {
            paramRemoteViews.setTextViewText(this.al, "--");
          }
          if (this.at != 0) {
            paramRemoteViews.setTextViewText(this.at, "--");
          }
          if (this.ao != 0) {
            paramRemoteViews.setTextViewText(this.ao, "--");
          }
          if (this.ap != 0) {
            paramRemoteViews.setTextViewText(this.ap, "--");
          }
          if (this.aq != 0) {
            paramRemoteViews.setTextViewText(this.ap, "--");
          }
          if (this.as != 0) {
            paramRemoteViews.setTextViewText(this.as, "--");
          }
          if (this.ad != 0)
          {
            if (this.aM) {
              break label1463;
            }
            paramRemoteViews.setTextViewText(this.ad, this.f.getString(2131166457));
          }
        }
        for (;;)
        {
          if (this.af != 0) {
            paramRemoteViews.setViewVisibility(this.af, 8);
          }
          if ((this.ag != 0) && (this.j != null) && (this.j[0] != 0)) {
            paramRemoteViews.setImageViewResource(this.ag, a(0, a(paramx)));
          }
          return;
          localObject = i1 + "°/" + i2 + "° ," + localNowBean.b();
          break;
          label1051:
          if ((!localNowBean.b().equals("--")) && (!TextUtils.isEmpty(localNowBean.b())) && (!localNowBean.e().equals("--")) && (!TextUtils.isEmpty(localNowBean.e())))
          {
            localObject = localNowBean.e() + "," + "--" + "°/" + "--" + "° ," + localNowBean.b();
            break;
          }
          localObject = this.f.getString(2131165323);
          break;
          label1177:
          paramRemoteViews.setTextViewText(this.G, this.f.getString(2131165323));
          break label382;
          label1198:
          ((StringBuffer)localObject).append("--°/--°");
          break label452;
          label1210:
          ((StringBuffer)localObject).append(this.f.getString(2131165323));
          break label497;
          label1229:
          paramRemoteViews.setTextViewText(this.ao, "--°/--° ");
          break label633;
          label1243:
          paramRemoteViews.setTextViewText(this.ap, "--° ");
          break label677;
          label1257:
          paramRemoteViews.setTextViewText(this.aq, "--° ");
          break label721;
          label1271:
          i1 = this.aJ;
          float f1 = localNowBean.a();
          if (!r.b(f1))
          {
            paramRemoteViews.setTextViewText(this.as, this.f.getString(2131165880) + " : " + (String)localObject);
            break label763;
          }
          paramContext = a(paramContext, i1, f1);
          if (i1 == 5)
          {
            paramRemoteViews.setTextViewText(this.as, this.f.getString(2131165880) + " : " + (String)localObject + " ,  " + paramContext);
            break label763;
          }
          paramRemoteViews.setTextViewText(this.as, this.f.getString(2131165880) + " : " + paramContext + " , " + (String)localObject);
          break label763;
          label1463:
          if (this.d) {
            paramRemoteViews.setTextViewText(this.ad, this.f.getString(2131166458));
          } else {
            paramRemoteViews.setTextViewText(this.ad, this.f.getString(2131166455));
          }
        }
      }
    }
  }
  
  public void a()
  {
    this.aM = false;
    if (this.aZ != null) {
      this.aZ = null;
    }
    this.aV.b();
    this.b.unregisterReceiver(this.aY);
    this.a.clear();
    this.c.clear();
    ab.a(this.b).b(this);
    x.a(this.b).b(this);
    a.a().a("AppWidgetDays42ProviderHelper unregisterReceiver", "插件错误.txt");
    Log.d("appwidget_days_42_provider_helper", "appwidget_day_42_helper ==============================> onDestroy");
  }
  
  public void a(Intent paramIntent)
  {
    int i1 = 1;
    int i3 = 0;
    int i2 = 0;
    if (paramIntent != null)
    {
      localObject = paramIntent.getAction();
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        break label26;
      }
    }
    label26:
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
              Log.d("appwidget_days_42_provider_helper", "deal_action:" + (String)localObject);
              if ((!this.aM) && (((String)localObject).equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_APPWIDGET_DAYS_42_CITY_CHANGE"))) {
                this.aZ = paramIntent;
              }
              if (!"com.gau.go.launcherex.gowidget.weatherwidget.ACTION_APPWIDGET_ENABLED_UPDATE_PREVIEW".equals(localObject)) {
                break;
              }
            } while (paramIntent.getIntExtra("extra_widget_type", 0) != 4);
            this.aS = paramIntent.getBooleanExtra("extra_enabled_widget_update_preview", this.aS);
          } while (!this.aS);
          this.aT = paramIntent.getStringExtra("extra_app_widget_theme_package");
          b();
          return;
          if (((String)localObject).equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_APPWIDGET_DATA_READY"))
          {
            b();
            return;
          }
          if ((((String)localObject).equals("android.intent.action.TIME_TICK")) || (((String)localObject).equals("android.intent.action.TIME_SET")) || (((String)localObject).equals("android.intent.action.DATE_CHANGED")) || (((String)localObject).equals("android.intent.action.TIMEZONE_CHANGED")) || (((String)localObject).equals("android.intent.action.SCREEN_ON")))
          {
            if (((String)localObject).equals("android.intent.action.TIMEZONE_CHANGED")) {
              this.aV.a();
            }
            for (;;)
            {
              b();
              Log.d("appwidget_days_42_provider_helper", "刷新时间成功");
              return;
              if (this.aV.b(0).minute % 10 == 0) {
                this.aV.a();
              }
            }
          }
          if (((String)localObject).equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_REFRESH_STARTED"))
          {
            this.aP = true;
            b();
            return;
          }
          if (((String)localObject).equals("com.gau.go.launcherex.gowidget.weatherwidget.goweather.ACTION_UPDATE_DATA"))
          {
            this.aP = false;
            b();
            return;
          }
          if (!((String)localObject).equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_APPWIDGET_DAYS_42_CITY_CHANGE")) {
            break;
          }
          Log.d("appwidget_days_42_provider_helper", "切换城市 > mAllHasLoaded = " + this.aM);
          i2 = this.c.size();
        } while (i2 == 0);
        i3 = paramIntent.getIntExtra("extra_appwidget_ids", 0);
        Log.d("appwidget_days_42_provider_helper", "change city widgetId > " + i3);
        paramIntent = (com.gau.go.launcherex.gowidget.weather.model.x)this.a.get(i3);
      } while (paramIntent == null);
      if (this.aZ != null) {
        this.aZ = null;
      }
      Log.d("appwidget_days_42_provider_helper", "before change cityId > " + paramIntent.b());
      i3 = b(paramIntent.b());
      i2 = (i3 + 1) % i2;
    } while (i3 == i2);
    Object localObject = (WeatherBean)this.c.get(i2);
    if (localObject != null) {
      if (((WeatherBean)localObject).e() != 2) {
        break label901;
      }
    }
    for (;;)
    {
      paramIntent.c(i1);
      paramIntent.a(((WeatherBean)localObject).c());
      v.a(this.b).b(paramIntent);
      Log.d("appwidget_days_42_provider_helper", "after change cityId > " + paramIntent.b());
      b(this.b, paramIntent);
      return;
      if (((String)localObject).equals("appwidget_language_change"))
      {
        this.f = com.gau.go.launcherex.gowidget.language.d.a(this.b).a();
        if (this.f == null) {
          this.f = this.b.getResources();
        }
        b();
        return;
      }
      if (((String)localObject).equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_APPWIDGET_DAYS_42_NEXT_PAGE"))
      {
        i1 = paramIntent.getIntExtra("extra_appwidget_ids", 0);
        Log.d("appwidget_days_42_provider_helper", "change forecast widgetId > " + i1);
        paramIntent = (com.gau.go.launcherex.gowidget.weather.model.x)this.a.get(i1);
        if (paramIntent == null) {
          break;
        }
        i1 = i2;
        if (paramIntent.f() == 0) {
          if (this.az[0] == 0) {
            break label729;
          }
        }
        label729:
        for (i1 = this.aI;; i1 = this.aI - 1)
        {
          paramIntent.d(i1);
          b(this.b, paramIntent);
          return;
        }
      }
      if ((((String)localObject).equals("android.appwidget.action.APPWIDGET_UPDATE")) || (((String)localObject).equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_WIDGET_ADD_APPWIDGETDAYS42")))
      {
        b();
        return;
      }
      if (((String)localObject).equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_WIDGET_DELETE_APPWIDGETDAYS42"))
      {
        if (AppWidgetManager.getInstance(this.b).getAppWidgetIds(new ComponentName(this.b, AppWidgetDays42Provider.class)).length == 0)
        {
          this.a.clear();
          return;
        }
        paramIntent = paramIntent.getIntArrayExtra("extra_appwidget_ids");
        if (paramIntent == null) {
          break;
        }
        i1 = i3;
        while (i1 < paramIntent.length)
        {
          this.a.remove(paramIntent[i1]);
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
      label901:
      i1 = 0;
    }
  }
  
  public void a(com.gau.go.launcherex.gowidget.weather.model.q paramq)
  {
    boolean bool = false;
    this.aK = paramq.g;
    this.aJ = paramq.q;
    this.aL = paramq.k;
    this.aV.a(0, this.aL);
    this.aR = paramq.J;
    if (this.aR)
    {
      com.gau.go.launcherex.gowidget.weather.c.g localg = this.aV;
      if (paramq.r == 1) {
        bool = true;
      }
      localg.a(bool);
    }
    for (;;)
    {
      paramq = paramq.G;
      if (!paramq.equals(this.aQ))
      {
        this.aQ = paramq;
        e(this.b);
      }
      if (!this.aO) {
        this.aO = true;
      }
      if ((!this.aM) && (this.aN) && (this.aO))
      {
        this.aM = true;
        b();
      }
      return;
      this.aV.a(false);
    }
  }
  
  public void a(String paramString, com.gau.go.launcherex.gowidget.weather.model.q paramq)
  {
    Log.d("appwidget_days_42_provider_helper", "onLoadSettingBeanDone_key = " + paramString);
    if (TextUtils.isEmpty(paramString))
    {
      a(paramq);
      return;
    }
    b(paramString, paramq);
  }
  
  public void a(ArrayList paramArrayList)
  {
    Log.d("appwidget_days_42_provider_helper", "onLoadWeatherBeanDone");
    b(paramArrayList);
    if (this.aM) {
      b();
    }
  }
  
  public void b(String paramString, com.gau.go.launcherex.gowidget.weather.model.q paramq)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if (paramString.equals("world_clock")) {
      if (paramq.r == 1)
      {
        if (!this.aR) {
          break label51;
        }
        this.aV.a(bool1);
        label40:
        b();
      }
    }
    label51:
    label95:
    label128:
    label225:
    do
    {
      int i1;
      do
      {
        do
        {
          do
          {
            return;
            bool1 = false;
            break;
            this.aV.a(false);
            break label40;
            if (!paramString.equals("tempUnit")) {
              break label95;
            }
            i1 = paramq.g;
          } while (this.aK == i1);
          this.aK = i1;
          b();
          return;
          if (!paramString.equals("windUnit")) {
            break label128;
          }
          i1 = paramq.q;
        } while (this.aJ == i1);
        this.aJ = i1;
        b();
        return;
        if (paramString.equals("app_widget_theme"))
        {
          paramString = paramq.G;
          if (!paramString.equals(this.aQ))
          {
            this.aQ = paramString;
            d(this.b);
          }
          e(this.b);
          b();
          return;
        }
        if (!paramString.equals("dateStyle")) {
          break label225;
        }
        i1 = paramq.k;
      } while (this.aL == i1);
      this.aL = i1;
      this.aV.a(0, this.aL);
      b();
      return;
    } while (!paramString.equals("Google_play_billing"));
    this.aR = paramq.J;
    if (this.aR)
    {
      paramString = this.aV;
      if (paramq.r == 1)
      {
        bool1 = bool2;
        paramString.a(bool1);
      }
    }
    for (;;)
    {
      b();
      return;
      bool1 = false;
      break;
      this.aV.a(false);
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
    if (!this.aN) {
      this.aN = true;
    }
    if ((!this.aM) && (this.aN) && (this.aO))
    {
      this.aM = true;
      b();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/systemwidget/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */