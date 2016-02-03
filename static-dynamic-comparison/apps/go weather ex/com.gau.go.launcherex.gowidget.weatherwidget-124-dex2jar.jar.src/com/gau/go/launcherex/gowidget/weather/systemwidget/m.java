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

public class m
  extends u
  implements aa, ae
{
  private int A;
  private String B = "";
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
  private int aB;
  private int aC;
  private int aD;
  private int aE = 0;
  private int aF;
  private int aG;
  private int aH;
  private boolean aI = false;
  private boolean aJ = false;
  private boolean aK = false;
  private boolean aL = false;
  private String aM = "app_widget_theme_white";
  private boolean aN = false;
  private boolean aO = false;
  private String aP = "app_widget_theme_white";
  private p aQ = null;
  private com.gau.go.launcherex.gowidget.weather.c.g aR = null;
  private f aS = null;
  private aq aT = null;
  private Resources aU;
  private o aV;
  private Intent aW;
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
  private int[] au = new int[6];
  private int[] av = new int[6];
  private int[] aw = new int[6];
  private int[] ax = new int[6];
  private int[] ay = new int[6];
  private int[] az = new int[6];
  private int[] f = new int[10];
  private int[] g = new int[10];
  private int[] h = new int[10];
  private int[] i = new int[10];
  private int[] j = new int[10];
  private int[] k = { 2131165326, 2131165327, 2131165328, 2131165329, 2131165330, 2131165331, 2131165332 };
  private int[] l = { 2131166553, 2131166554, 2131166555, 2131166556, 2131166557, 2131166558, 2131166559, 2131166560, 2131166561, 2131166562, 2131166563, 2131166564 };
  private int m;
  private int n;
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
  
  public m(Context paramContext)
  {
    this.b = paramContext;
    this.aU = com.gau.go.launcherex.gowidget.language.d.a(paramContext).a();
    if (this.aU == null) {
      this.aU = paramContext.getResources();
    }
    this.aR = new com.gau.go.launcherex.gowidget.weather.c.g(paramContext);
    this.aS = f.a(paramContext);
    this.aS.a(paramContext, this.aM);
    this.aQ = new p(paramContext.getContentResolver(), this);
    this.aV = new o(this, null);
    Object localObject = new IntentFilter();
    ((IntentFilter)localObject).addAction("android.intent.action.TIME_TICK");
    ((IntentFilter)localObject).addAction("android.intent.action.TIME_SET");
    ((IntentFilter)localObject).addAction("android.intent.action.DATE_CHANGED");
    ((IntentFilter)localObject).addAction("android.intent.action.TIMEZONE_CHANGED");
    ((IntentFilter)localObject).addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_THEME_PACKAGE_REMOVED");
    ((IntentFilter)localObject).addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_APPWIDGET_THEME_CHANGE");
    ((IntentFilter)localObject).addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_NEW_THEME_FLAG_CHANGE");
    ((IntentFilter)localObject).addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_APPWIDGET_DATA_READY");
    ((IntentFilter)localObject).addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_REFRESH_STARTED");
    ((IntentFilter)localObject).addAction("com.gau.go.launcherex.gowidget.weatherwidget.goweather.ACTION_UPDATE_DATA");
    ((IntentFilter)localObject).addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_APPWIDGET_DAYS_41_NEXT_PAGE");
    ((IntentFilter)localObject).addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_INITIALIZED_CITY");
    paramContext.registerReceiver(this.aV, (IntentFilter)localObject);
    a.a().a("AppWidgetDays41ProviderHelper registerReceiver", "插件错误.txt");
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
  
  private int a(String paramString)
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
  
  private String a(Context paramContext, int paramInt, float paramFloat)
  {
    if (paramInt == 1) {
      return String.format(this.aU.getString(2131165809), new Object[] { Float.valueOf(com.gau.go.launcherex.gowidget.weather.util.q.c(paramFloat, 1)) });
    }
    if (paramInt == 4) {
      return String.format(this.aU.getString(2131165812), new Object[] { Float.valueOf(com.gau.go.launcherex.gowidget.weather.util.q.e(paramFloat, 1)) });
    }
    if (paramInt == 3) {
      return String.format(this.aU.getString(2131165811), new Object[] { Float.valueOf(com.gau.go.launcherex.gowidget.weather.util.q.d(paramFloat, 1)) });
    }
    if (paramInt == 5) {
      return String.format(this.aU.getString(2131165813), new Object[] { Integer.valueOf(com.gau.go.launcherex.gowidget.weather.util.q.a(paramFloat)) });
    }
    if (paramInt == 6) {
      return String.format(this.aU.getString(2131165814), new Object[] { Float.valueOf(com.gau.go.launcherex.gowidget.weather.util.q.f(paramFloat, 1)) });
    }
    return String.format(this.aU.getString(2131165810), new Object[] { Float.valueOf(paramFloat) });
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
        if ((!TextUtils.isEmpty((CharSequence)localObject)) && (b((String)localObject) != null)) {
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
    this.aQ.a(1, Integer.valueOf(paramInt), WeatherContentProvider.t, new String[] { "current_cityid", "widget_location_type" }, "widget_id=?", new String[] { String.valueOf(paramInt) }, null);
  }
  
  private void a(Context paramContext, int paramInt)
  {
    if (this.aO)
    {
      com.gau.go.launcherex.gowidget.weather.model.x localx = (com.gau.go.launcherex.gowidget.weather.model.x)this.a.get(paramInt);
      if (localx != null)
      {
        String str = this.aM;
        Log.d("appwidget_days_41_helper", "mPreviewTheme: " + this.aP);
        if ((!TextUtils.isEmpty(this.aP)) && (!this.aP.equals(str)))
        {
          this.aM = this.aP;
          localx.c(this.aM);
          e(this.b);
        }
        paramContext = c(paramContext, localx);
        if (!str.equals(this.aM))
        {
          this.aM = str;
          localx.c(this.aM);
          e(this.b);
        }
        a(paramContext);
      }
    }
  }
  
  private void a(Context paramContext, RemoteViews paramRemoteViews)
  {
    if (this.aq != 0) {
      paramRemoteViews.setViewVisibility(this.aq, 8);
    }
  }
  
  private void a(Context paramContext, RemoteViews paramRemoteViews, int paramInt1, Map paramMap, List paramList, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    int i1 = this.av.length;
    if (paramList != null) {
      i1 = paramList.size();
    }
    if ((paramInt1 >= 0) && (paramInt1 < i1))
    {
      paramContext = null;
      if (paramList != null) {
        paramContext = (ForecastBean)paramList.get(paramInt1);
      }
      if ((paramInt2 != 0) && (this.i != null) && (this.i[0] != 0))
      {
        if (paramContext == null) {
          break label375;
        }
        paramRemoteViews.setImageViewResource(paramInt2, a(paramContext.i(), true));
      }
      if (paramContext == null) {
        break label479;
      }
      paramInt1 = com.gau.go.launcherex.gowidget.weather.util.q.a(paramContext.a(this.aG));
      paramInt2 = com.gau.go.launcherex.gowidget.weather.util.q.a(paramContext.b(this.aG));
      paramContext = this.aU.getString(this.k[r.b(paramContext.e(), paramContext.f(), paramContext.g())]);
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
        paramRemoteViews.setImageViewResource(paramInt2, a(0, true));
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
    if (this.D != 0)
    {
      if (this.q == 0) {
        break label27;
      }
      paramRemoteViews.setImageViewResource(this.D, this.q);
    }
    label27:
    while ((this.r == 0) || (this.p == 0)) {
      return;
    }
    if (a(paramx))
    {
      paramRemoteViews.setImageViewResource(this.D, this.r);
      return;
    }
    paramRemoteViews.setImageViewResource(this.D, this.p);
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
    if (this.aT == null) {
      this.aT = new aq();
    }
    aq.a = paramString1;
    this.aT.a("systemwidget_style", String.valueOf(415));
    if (paramContext != null) {
      new am().a(paramContext, this.aT);
    }
    try
    {
      localInputStream1.close();
      this.q = paramf.c(this.aT.a("go_weatherex_widget_bg"), paramString1);
      this.r = paramf.c(this.aT.a("go_weatherex_widget_bg_day"), paramString1);
      this.p = paramf.c(this.aT.a("go_weatherex_widget_bg_night"), paramString1);
      this.B = this.aT.a("go_weatherex_widget_date_style_color");
      this.o = paramf.c(this.aT.a("go_weatherex_widget_time_pm"), paramString1);
      this.y = paramf.c(this.aT.a("go_weatherex_widget_time_am"), paramString1);
      this.v = paramf.c(this.aT.a("go_weatherex_widget_time_ampm_empty"), paramString1);
      this.m = paramf.c(this.aT.a("go_weatherex_widget_time_bg"), paramString1);
      this.n = paramf.c(this.aT.a("go_weatherex_widget_change_city"), paramString1);
      this.s = paramf.c(this.aT.a("go_weatherex_widget_time_divider"), paramString1);
      this.u = paramf.c(this.aT.a("go_weatherex_widget_temp_unit"), paramString1);
      this.w = paramf.c(this.aT.a("go_weatherex_widget_temp_unit_centigrade"), paramString1);
      this.x = paramf.c(this.aT.a("go_weatherex_widget_temp_unit_fahrenheit"), paramString1);
      this.t = paramf.c(this.aT.a("go_weatherex_widget_temp_minus"), paramString1);
      i1 = 0;
      while (i1 < 10)
      {
        this.i[i1] = paramf.c(aq.c[i1], paramString1);
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
        this.f[i1] = paramf.c(aq.e[i1], paramString1);
        i1 += 1;
      }
      i1 = 0;
      while (i1 < 10)
      {
        this.g[i1] = paramf.c(aq.f[i1], paramString1);
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
        this.h[i1] = paramf.c(aq.g[i1], paramString1);
        i1 += 1;
      }
      while (i2 < 10)
      {
        this.j[i2] = paramf.c(aq.d[i2], paramString1);
        i2 += 1;
      }
      this.z = paramf.c(this.aT.a("go_weatherex_widget_next_page"), paramString1);
      this.A = paramf.c(this.aT.a("go_weatherex_widget_previous_page"), paramString1);
    }
  }
  
  private void a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    int i2 = 0;
    if (this.aS == null) {
      this.aS = f.a(paramContext);
    }
    this.aS.a(paramContext, paramString1);
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
      i1 = this.av.length - 1;
    }
    if (i1 != 0)
    {
      this.C = this.aS.a(paramString2, paramString1);
      this.D = this.aS.b("goweatherex_widget_days_m_bg", paramString1);
      this.G = this.aS.b("goweatherex_widget_days_m_am_pm", paramString1);
      this.O = this.aS.b("goweatherex_widget_days_m_published_time", paramString1);
      this.E = this.aS.b("goweatherex_widget_days_m_weather_desp", paramString1);
      this.F = this.aS.b("goweatherex_widget_days_m_weather_temp_desp", paramString1);
      this.I = this.aS.b("goweatherex_widget_days_m_hour_num_1", paramString1);
      this.J = this.aS.b("goweatherex_widget_days_m_hour_num_2", paramString1);
      this.K = this.aS.b("goweatherex_widget_days_m_min_num_1", paramString1);
      this.L = this.aS.b("goweatherex_widget_days_m_min_num_2", paramString1);
      this.Y = this.aS.b("goweatherex_widget_days_m_layout_city", paramString1);
      this.ab = this.aS.b("goweatherex_widget_days_m_text_next_city", paramString1);
      this.aa = this.aS.b("goweatherex_widget_days_m_img_next", paramString1);
      this.U = this.aS.b("goweatherex_widget_days_m_date_week", paramString1);
      this.Z = this.aS.b("goweatherex_widget_days_m_city_name", paramString1);
      this.ac = this.aS.b("goweatherex_widget_days_m_weather_icon", paramString1);
      this.H = this.aS.b("goweatherex_widget_m_time_fore", paramString1);
      this.M = this.aS.b("goweatherex_widget_days_m_time_divider", paramString1);
      this.N = this.aS.b("goweatherex_widget_days_m_timeboard", paramString1);
      this.ad = this.aS.b("goweatherex_widget_days_m_layout_now_temp", paramString1);
      this.ak = this.aS.b("goweatherex_widget_days_m_low_high_temp", paramString1);
      this.am = this.aS.b("goweatherex_widget_days_m_low_temp", paramString1);
      this.al = this.aS.b("goweatherex_widget_days_m_high_temp", paramString1);
      this.ai = this.aS.b("goweatherex_widget_days_m_temp_minus", paramString1);
      this.ae = this.aS.b("goweatherex_widget_days_m_temp_num_1", paramString1);
      this.af = this.aS.b("goweatherex_widget_days_m_temp_num_2", paramString1);
      this.ag = this.aS.b("goweatherex_widget_days_m_temp_num_3", paramString1);
      this.aj = this.aS.b("goweatherex_widget_days_m_temp_unit", paramString1);
      this.an = this.aS.b("goweatherex_widget_days_m_text_temp", paramString1);
      this.ar = this.aS.b("goweatherex_widget_days_m_weather_refresh", paramString1);
      this.as = this.aS.b("goweatherex_widget_days_m_refresh_progress", paramString1);
      this.ah = this.aS.b("goweatherex_widget_days_m_detail_depict", paramString1);
      this.V = this.aS.b("goweatherex_widget_days_m_date", paramString1);
      this.W = this.aS.b("goweatherex_widget_days_m_style_date", paramString1);
      this.X = this.aS.b("goweatherex_widget_days_m_weekday", paramString1);
      this.ap = this.aS.b("goweatherex_widget_days_m_wind", paramString1);
      this.ao = this.aS.b("goweatherex_widget_days_m_detail_wind", paramString1);
      this.at = this.aS.b("goweatherex_widget_days_m_theme_select", paramString1);
      this.aq = this.aS.b("goweatherex_widget_days_m_extreme_icon", paramString1);
      i1 = i2;
      while (i1 < this.av.length)
      {
        this.av[i1] = this.aS.b("goweatherex_widget_days_m_weather_icon_forecast" + i1, paramString1);
        this.aA[i1] = this.aS.b("goweatherex_widget_days_m_week_low_high_temp_forecast" + i1, paramString1);
        this.aw[i1] = this.aS.b("goweatherex_widget_days_m_low_high_temp_forecast" + i1, paramString1);
        this.ax[i1] = this.aS.b("goweatherex_widget_days_m_low_temp_forecast" + i1, paramString1);
        this.ay[i1] = this.aS.b("goweatherex_widget_days_m_high_temp_forecast" + i1, paramString1);
        this.au[i1] = this.aS.b("goweatherex_widget_days_m_weekday_forecast" + i1, paramString1);
        this.az[i1] = this.aS.b("goweatherex_widget_days_m_extreme_icon_forecast" + i1, paramString1);
        i1 += 1;
      }
    }
    for (;;)
    {
      if (i1 >= 0)
      {
        if (this.av[i1] != 0) {
          this.aE = (i1 + 1);
        }
      }
      else
      {
        this.aB = this.aS.b("goweatherex_widget_days_m_next_page_forecast", paramString1);
        this.aC = this.aS.b("goweatherex_widget_days_m_page_pre_forecast", paramString1);
        this.aD = this.aS.b("goweatherex_widget_days_m_page_next_forecast", paramString1);
        this.P = this.aS.b("goweatherex_widget_days_m_text_time_ampm", paramString1);
        this.Q = this.aS.b("goweatherex_widget_days_m_text_time", paramString1);
        this.R = this.aS.b("goweatherex_widget_days_m_text_time_hour", paramString1);
        this.S = this.aS.b("goweatherex_widget_days_m_text_time_min", paramString1);
        this.T = this.aS.b("goweatherex_widget_days_m_text_am_pm", paramString1);
        a(paramContext, this.aS, paramString1, paramString3);
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
    localIntent.putExtra("extra_widget_type", 5);
    this.b.sendBroadcast(localIntent);
  }
  
  private void a(Object paramObject, Cursor paramCursor)
  {
    Integer localInteger = (Integer)paramObject;
    int i1;
    if ((paramCursor != null) && (paramCursor.getCount() > 0))
    {
      paramObject = new com.gau.go.launcherex.gowidget.weather.model.x();
      ((com.gau.go.launcherex.gowidget.weather.model.x)paramObject).b(5);
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
      if ((!this.c.isEmpty()) && (b(((com.gau.go.launcherex.gowidget.weather.model.x)paramObject).b()) == null))
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
        if (this.aW != null)
        {
          i1 = this.aW.getIntExtra("extra_appwidget_ids", 0);
          if ((i1 != 0) && (i1 == localInteger.intValue()))
          {
            a(this.aW);
            this.aW = null;
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
          Log.d("appwidget_days_41_helper", "new widgetId > " + localInteger);
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
      localWeatherBean = b(paramx.b());
    }
    if (localWeatherBean == null) {
      return true;
    }
    paramx = localWeatherBean.k.j();
    String str = localWeatherBean.k.k();
    if ((this.aN) && (this.aR.d()))
    {
      int i1 = localWeatherBean.k.n();
      return r.a(paramx, str, this.aR.b(i1));
    }
    return r.a(paramx, str);
  }
  
  private int b(int paramInt, boolean paramBoolean)
  {
    return r.a(this.i, paramInt, paramBoolean);
  }
  
  private Time b(com.gau.go.launcherex.gowidget.weather.model.x paramx)
  {
    WeatherBean localWeatherBean = null;
    if (paramx != null) {
      localWeatherBean = b(paramx.b());
    }
    if (localWeatherBean != null)
    {
      int i1 = localWeatherBean.k.n();
      return this.aR.b(i1);
    }
    return this.aR.b(55536);
  }
  
  private WeatherBean b(String paramString)
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
        localx.b(5);
        return localx;
        localx.a("");
      }
    }
  }
  
  private void b()
  {
    Log.d("appwidget_days_41_helper", "refreshUI");
    if (!this.aI) {
      break label17;
    }
    for (;;)
    {
      label17:
      return;
      if (!TextUtils.isEmpty(this.aM))
      {
        if (this.C == 0)
        {
          e(this.b);
          if (this.C == 0) {
            break;
          }
        }
        if (this.c == null) {
          break;
        }
        int[] arrayOfInt = AppWidgetManager.getInstance(this.b).getAppWidgetIds(new ComponentName(this.b, AppWidgetDays41Provider.class));
        Log.d("appwidget_days_41_helper", "共找到有" + arrayOfInt.length + "个该系统widget样式");
        int i1 = 0;
        while (i1 < arrayOfInt.length)
        {
          Log.d("appwidget_days_41_helper", "第" + i1 + "个widgetID：" + arrayOfInt[i1]);
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
    if ((this.ar != 0) && (this.as != 0))
    {
      if (this.aL)
      {
        paramRemoteViews.setViewVisibility(this.ar, 4);
        paramRemoteViews.setViewVisibility(this.as, 0);
      }
    }
    else {
      return;
    }
    paramRemoteViews.setViewVisibility(this.ar, 0);
    paramRemoteViews.setViewVisibility(this.as, 4);
  }
  
  private void b(Context paramContext, RemoteViews paramRemoteViews, com.gau.go.launcherex.gowidget.weather.model.x paramx)
  {
    int i2 = this.c.size();
    Object localObject = b(paramContext);
    int i1;
    if (localObject != null)
    {
      if (this.U != 0) {
        paramRemoteViews.setOnClickPendingIntent(this.U, (PendingIntent)localObject);
      }
      if (this.V != 0) {
        paramRemoteViews.setOnClickPendingIntent(this.V, (PendingIntent)localObject);
      }
      if (this.X != 0) {
        paramRemoteViews.setOnClickPendingIntent(this.X, (PendingIntent)localObject);
      }
      if (this.W != 0) {
        paramRemoteViews.setOnClickPendingIntent(this.W, (PendingIntent)localObject);
      }
      i1 = 0;
      while (i1 < this.au.length)
      {
        if (this.au[i1] != 0) {
          paramRemoteViews.setOnClickPendingIntent(this.au[i1], (PendingIntent)localObject);
        }
        i1 += 1;
      }
    }
    localObject = a(paramContext);
    if (localObject != null)
    {
      if (this.H != 0) {
        paramRemoteViews.setOnClickPendingIntent(this.H, (PendingIntent)localObject);
      }
      if (this.I != 0) {
        paramRemoteViews.setOnClickPendingIntent(this.I, (PendingIntent)localObject);
      }
      if (this.J != 0) {
        paramRemoteViews.setOnClickPendingIntent(this.J, (PendingIntent)localObject);
      }
      if (this.K != 0) {
        paramRemoteViews.setOnClickPendingIntent(this.K, (PendingIntent)localObject);
      }
      if (this.L != 0) {
        paramRemoteViews.setOnClickPendingIntent(this.L, (PendingIntent)localObject);
      }
      if (this.P != 0) {
        paramRemoteViews.setOnClickPendingIntent(this.P, (PendingIntent)localObject);
      }
      if (this.G != 0) {
        paramRemoteViews.setOnClickPendingIntent(this.G, (PendingIntent)localObject);
      }
      if (this.Q != 0) {
        paramRemoteViews.setOnClickPendingIntent(this.Q, (PendingIntent)localObject);
      }
      if (this.R != 0) {
        paramRemoteViews.setOnClickPendingIntent(this.R, (PendingIntent)localObject);
      }
      if (this.S != 0) {
        paramRemoteViews.setOnClickPendingIntent(this.S, (PendingIntent)localObject);
      }
      if (this.T != 0) {
        paramRemoteViews.setOnClickPendingIntent(this.T, (PendingIntent)localObject);
      }
    }
    localObject = e(paramContext, paramx);
    if (localObject != null)
    {
      if (this.ac != 0) {
        paramRemoteViews.setOnClickPendingIntent(this.ac, (PendingIntent)localObject);
      }
      if (this.ad != 0) {
        paramRemoteViews.setOnClickPendingIntent(this.ad, (PendingIntent)localObject);
      }
      if (this.E != 0) {
        paramRemoteViews.setOnClickPendingIntent(this.E, (PendingIntent)localObject);
      }
      if (this.F != 0) {
        paramRemoteViews.setOnClickPendingIntent(this.F, (PendingIntent)localObject);
      }
      if (this.ah != 0) {
        paramRemoteViews.setOnClickPendingIntent(this.ah, (PendingIntent)localObject);
      }
      if (this.ak != 0) {
        paramRemoteViews.setOnClickPendingIntent(this.ak, (PendingIntent)localObject);
      }
      if (this.al != 0) {
        paramRemoteViews.setOnClickPendingIntent(this.al, (PendingIntent)localObject);
      }
      if (this.am != 0) {
        paramRemoteViews.setOnClickPendingIntent(this.am, (PendingIntent)localObject);
      }
      if (this.ap != 0) {
        paramRemoteViews.setOnClickPendingIntent(this.ap, (PendingIntent)localObject);
      }
      if (this.ao != 0) {
        paramRemoteViews.setOnClickPendingIntent(this.ao, (PendingIntent)localObject);
      }
      if (this.O != 0) {
        paramRemoteViews.setOnClickPendingIntent(this.O, (PendingIntent)localObject);
      }
      if (this.an != 0) {
        paramRemoteViews.setOnClickPendingIntent(this.an, (PendingIntent)localObject);
      }
      i1 = 0;
      while (i1 < this.av.length)
      {
        if (this.av[i1] != 0) {
          paramRemoteViews.setOnClickPendingIntent(this.av[i1], (PendingIntent)localObject);
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
      while (i1 < this.aw.length)
      {
        if (this.aw[i1] != 0) {
          paramRemoteViews.setOnClickPendingIntent(this.aw[i1], (PendingIntent)localObject);
        }
        i1 += 1;
      }
      i1 = 0;
      while (i1 < this.ax.length)
      {
        if (this.ax[i1] != 0) {
          paramRemoteViews.setOnClickPendingIntent(this.ax[i1], (PendingIntent)localObject);
        }
        i1 += 1;
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
    if ((this.aI) && (i2 > 1))
    {
      localObject = new Intent(paramContext, AppWidgetService.class);
      ((Intent)localObject).putExtra("appwidget_service_request", 21);
      ((Intent)localObject).putExtra("request_extra_appwidget_type", 5);
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
        if (this.Y != 0) {
          paramRemoteViews.setOnClickPendingIntent(this.Y, (PendingIntent)localObject);
        }
        if (this.Z != 0) {
          paramRemoteViews.setOnClickPendingIntent(this.Z, (PendingIntent)localObject);
        }
        if (this.ab != 0) {
          paramRemoteViews.setOnClickPendingIntent(this.ab, (PendingIntent)localObject);
        }
      }
      if (this.at != 0)
      {
        localObject = a(paramContext, paramx);
        if (localObject != null)
        {
          paramRemoteViews.setViewVisibility(this.at, 0);
          paramRemoteViews.setOnClickPendingIntent(this.at, (PendingIntent)localObject);
        }
      }
      if ((this.aI) && (i2 != 0))
      {
        localObject = c(paramContext);
        if ((this.ar != 0) && (localObject != null)) {
          paramRemoteViews.setOnClickPendingIntent(this.ar, (PendingIntent)localObject);
        }
      }
      if (this.aI)
      {
        paramContext = d(paramContext, paramx);
        if ((this.aB != 0) && (paramContext != null)) {
          paramRemoteViews.setOnClickPendingIntent(this.aB, paramContext);
        }
        if (this.aC != 0) {
          paramRemoteViews.setOnClickPendingIntent(this.aC, paramContext);
        }
        if (this.aD != 0) {
          paramRemoteViews.setOnClickPendingIntent(this.aD, paramContext);
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
    if ((TextUtils.isEmpty(this.aM)) || (this.aM.contains("app_widget_theme"))) {}
    for (RemoteViews localRemoteViews = new RemoteViews(paramContext.getPackageName(), this.C);; localRemoteViews = new RemoteViews(this.aM, this.C))
    {
      a(paramContext, localRemoteViews, paramx);
      b(paramContext, localRemoteViews, paramx);
      c(paramContext, localRemoteViews, paramx);
      g(paramContext, localRemoteViews, paramx);
      d(paramContext, localRemoteViews, paramx);
      a(paramContext, localRemoteViews);
      b(paramContext, localRemoteViews);
      f(paramContext, localRemoteViews, paramx);
      e(paramContext, localRemoteViews, paramx);
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
    if ((this.N != 0) && (this.m != 0)) {
      paramRemoteViews.setImageViewResource(this.N, this.m);
    }
    if ((this.M != 0) && (this.s != 0)) {
      paramRemoteViews.setImageViewResource(this.M, this.s);
    }
    paramx = b(paramx);
    int i2 = paramx.hour;
    int i1 = i2;
    if (!r.b(paramContext))
    {
      i2 %= 12;
      i1 = i2;
      if (i2 == 0) {
        i1 = 12;
      }
    }
    i2 = paramx.minute;
    if ((this.I != 0) && (this.f != null) && (this.f[0] != 0)) {
      paramRemoteViews.setImageViewResource(this.I, r.a(i1 / 10, this.f));
    }
    if ((this.J != 0) && (this.f != null) && (this.f[0] != 0)) {
      paramRemoteViews.setImageViewResource(this.J, r.a(i1 % 10, this.f));
    }
    if (this.K != 0)
    {
      if ((this.g != null) && (this.g[0] != 0)) {
        paramRemoteViews.setImageViewResource(this.K, r.a(i2 / 10, this.g));
      }
    }
    else
    {
      if (this.L != 0)
      {
        if ((this.g == null) || (this.g[0] == 0)) {
          break label729;
        }
        paramRemoteViews.setImageViewResource(this.L, r.a(i2 % 10, this.g));
      }
      label273:
      if (this.Q != 0) {
        paramRemoteViews.setTextViewText(this.Q, r.e(i1) + ":" + r.e(i2));
      }
      if (this.R != 0) {
        paramRemoteViews.setTextViewText(this.R, r.e(i1));
      }
      if (this.S != 0) {
        paramRemoteViews.setTextViewText(this.S, r.e(i2));
      }
      if (!r.b(paramContext)) {
        break label781;
      }
      if (this.G != 0)
      {
        if (this.v == 0) {
          break label768;
        }
        paramRemoteViews.setViewVisibility(this.G, 0);
        paramRemoteViews.setImageViewResource(this.G, this.v);
      }
      label402:
      if (this.T != 0) {
        paramRemoteViews.setViewVisibility(this.T, 8);
      }
      if (this.P != 0) {
        paramRemoteViews.setTextViewText(this.P, r.e(i1) + ":" + r.e(i2));
      }
      label466:
      if (this.aR == null) {
        break label1045;
      }
      paramContext = this.aR.a(paramx);
      label482:
      i1 = this.k[paramx.weekDay];
      if (this.U != 0) {
        paramRemoteViews.setTextViewText(this.U, this.aU.getString(i1) + "  " + paramContext);
      }
      if (this.V != 0) {
        paramRemoteViews.setTextViewText(this.V, paramContext);
      }
      if (this.X != 0) {
        paramRemoteViews.setTextViewText(this.X, this.aU.getString(i1));
      }
      if (this.W != 0)
      {
        if (TextUtils.isEmpty(this.B)) {
          break label1121;
        }
        paramContext = this.aU.getString(this.l[paramx.month]);
        switch (this.aH)
        {
        }
      }
    }
    for (paramContext = String.format(this.aU.getString(2131166568), new Object[] { this.B, paramContext, Integer.valueOf(paramx.monthDay) });; paramContext = String.format(this.aU.getString(2131166569), new Object[] { this.B, paramContext, Integer.valueOf(paramx.monthDay) }))
    {
      paramContext = Html.fromHtml(paramContext);
      paramRemoteViews.setTextViewText(this.W, paramContext);
      return;
      if ((this.f == null) || (this.f[0] == 0)) {
        break;
      }
      paramRemoteViews.setImageViewResource(this.K, r.a(i2 / 10, this.f));
      break;
      label729:
      if ((this.f == null) || (this.f[0] == 0)) {
        break label273;
      }
      paramRemoteViews.setImageViewResource(this.L, r.a(i2 % 10, this.f));
      break label273;
      label768:
      paramRemoteViews.setViewVisibility(this.G, 8);
      break label402;
      label781:
      if ((paramx.hour >= 0) && (paramx.hour <= 11))
      {
        if ((this.G != 0) && (this.y != 0))
        {
          paramRemoteViews.setViewVisibility(this.G, 0);
          paramRemoteViews.setImageViewResource(this.G, this.y);
        }
        if (this.T != 0)
        {
          paramRemoteViews.setViewVisibility(this.T, 0);
          paramRemoteViews.setTextViewText(this.T, "AM");
        }
        if (this.P == 0) {
          break label466;
        }
        paramRemoteViews.setTextViewText(this.P, r.e(i1) + ":" + r.e(i2) + " " + "AM");
        break label466;
      }
      if ((this.G != 0) && (this.o != 0))
      {
        paramRemoteViews.setViewVisibility(this.G, 0);
        paramRemoteViews.setImageViewResource(this.G, this.o);
      }
      if (this.T != 0)
      {
        paramRemoteViews.setViewVisibility(this.T, 0);
        paramRemoteViews.setTextViewText(this.T, "PM");
      }
      if (this.P == 0) {
        break label466;
      }
      paramRemoteViews.setTextViewText(this.P, r.e(i1) + ":" + r.e(i2) + " " + "PM");
      break label466;
      label1045:
      paramContext = paramx.month + "/" + paramx.monthDay;
      break label482;
    }
    label1121:
    paramContext = this.aU.getString(this.l[paramx.month]);
    switch (this.aH)
    {
    }
    for (paramContext = paramContext + " " + paramx.monthDay;; paramContext = paramx.monthDay + " " + paramContext)
    {
      paramRemoteViews.setTextViewText(this.W, paramContext);
      return;
    }
  }
  
  private PendingIntent d(Context paramContext, com.gau.go.launcherex.gowidget.weather.model.x paramx)
  {
    int i1 = 393216;
    if (!this.aN)
    {
      paramx = new Intent();
      paramx.setClass(paramContext, BillingActivity.class);
      paramx.putExtra("recommend_type", 4);
      paramx.putExtra("recommend_enterance", 12);
      return PendingIntent.getActivity(paramContext, 0, paramx, 134217728);
    }
    Intent localIntent = new Intent(paramContext, AppWidgetService.class);
    localIntent.putExtra("appwidget_service_request", 22);
    localIntent.putExtra("request_extra_appwidget_type", 5);
    if (paramx != null)
    {
      localIntent.putExtra("extra_appwidget_ids", paramx.a());
      i1 = 393216 + paramx.a();
    }
    return PendingIntent.getService(paramContext, i1, localIntent, 134217728);
  }
  
  private void d(Context paramContext)
  {
    AppWidgetManager localAppWidgetManager = AppWidgetManager.getInstance(paramContext);
    if (localAppWidgetManager != null) {
      localAppWidgetManager.updateAppWidget(new ComponentName(paramContext, AppWidgetDays41Provider.class), null);
    }
  }
  
  private void d(Context paramContext, RemoteViews paramRemoteViews, com.gau.go.launcherex.gowidget.weather.model.x paramx)
  {
    if (paramx != null) {}
    for (int i1 = a(paramx.b());; i1 = 0)
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
        paramContext = (WeatherBean)this.c.get(i2);
        if (paramContext != null) {}
      }
      label149:
      label205:
      label257:
      label313:
      label406:
      label623:
      label636:
      label665:
      label694:
      label709:
      label731:
      label743:
      label745:
      label758:
      label782:
      for (;;)
      {
        return;
        i1 = com.gau.go.launcherex.gowidget.weather.util.q.a(paramContext.k.a(this.aG));
        if (i1 != 55536) {
          if (this.an != 0)
          {
            paramRemoteViews.setViewVisibility(this.an, 0);
            if (this.aG == 1) {
              paramRemoteViews.setTextViewText(this.an, String.valueOf(i1) + "°C");
            }
          }
          else if ((this.h != null) && (this.h[0] != 0))
          {
            if (this.ai != 0)
            {
              if (i1 >= 0) {
                break label623;
              }
              paramRemoteViews.setViewVisibility(this.ai, 0);
              if (this.t != 0) {
                paramRemoteViews.setImageViewResource(this.ai, this.t);
              }
            }
            i1 = Math.abs(i1);
            i2 = i1 / 100;
            if ((this.ae != 0) && (this.h != null) && (this.h[0] != 0))
            {
              if (i2 != 0) {
                break label636;
              }
              paramRemoteViews.setViewVisibility(this.ae, 8);
            }
            i3 = (i1 - i2 * 100) / 10;
            if ((this.af != 0) && (this.h != null) && (this.h[0] != 0))
            {
              if ((i3 != 0) || (i2 != 0)) {
                break label665;
              }
              paramRemoteViews.setViewVisibility(this.af, 8);
            }
            if ((this.ag != 0) && (this.h != null) && (this.h[0] != 0))
            {
              paramRemoteViews.setImageViewResource(this.ag, r.a(i1 % 10, this.h));
              paramRemoteViews.setViewVisibility(this.ag, 0);
            }
            if (this.aj != 0)
            {
              if ((this.w == 0) || (this.x == 0)) {
                break label709;
              }
              if (this.aG != 1) {
                break label694;
              }
              paramRemoteViews.setImageViewResource(this.aj, this.w);
            }
          }
        }
        for (i1 = 1;; i1 = 0)
        {
          if (i1 != 0) {
            break label782;
          }
          if (this.an != 0)
          {
            paramRemoteViews.setViewVisibility(this.an, 0);
            if (this.aG != 1) {
              break label731;
            }
            paramRemoteViews.setTextViewText(this.an, "--°C");
          }
          for (;;)
          {
            if ((this.ai == 0) || (this.ae == 0) || (this.af == 0) || (this.ag == 0) || (this.t == 0)) {
              break label743;
            }
            paramRemoteViews.setViewVisibility(this.ai, 8);
            paramRemoteViews.setViewVisibility(this.ae, 8);
            paramRemoteViews.setImageViewResource(this.af, this.t);
            paramRemoteViews.setViewVisibility(this.af, 0);
            paramRemoteViews.setImageViewResource(this.ag, this.t);
            paramRemoteViews.setViewVisibility(this.ag, 0);
            if (this.aj == 0) {
              break;
            }
            if ((this.w == 0) || (this.x == 0)) {
              break label758;
            }
            if (this.aG != 1) {
              break label745;
            }
            paramRemoteViews.setImageViewResource(this.aj, this.w);
            return;
            paramRemoteViews.setTextViewText(this.an, String.valueOf(i1) + "°F");
            break label149;
            paramRemoteViews.setViewVisibility(this.ai, 8);
            break label205;
            paramRemoteViews.setImageViewResource(this.ae, r.a(i2, this.h));
            paramRemoteViews.setViewVisibility(this.ae, 0);
            break label257;
            paramRemoteViews.setImageViewResource(this.af, r.a(i3, this.h));
            paramRemoteViews.setViewVisibility(this.af, 0);
            break label313;
            paramRemoteViews.setImageViewResource(this.aj, this.x);
            break label406;
            if (this.u == 0) {
              break label406;
            }
            paramRemoteViews.setImageViewResource(this.aj, this.u);
            break label406;
            paramRemoteViews.setTextViewText(this.an, "--°F");
          }
          break;
          paramRemoteViews.setImageViewResource(this.aj, this.x);
          return;
          if (this.u == 0) {
            break;
          }
          paramRemoteViews.setImageViewResource(this.aj, this.u);
          return;
        }
      }
    }
  }
  
  private PendingIntent e(Context paramContext, com.gau.go.launcherex.gowidget.weather.model.x paramx)
  {
    Object localObject = "";
    if (paramx != null) {
      localObject = paramx.b();
    }
    localObject = WeatherDetailActivity.a(this.b, (String)localObject, true, 9, "", -1);
    ((Intent)localObject).addFlags(67108864);
    if (paramx != null) {}
    for (int i1 = paramx.a() + 262144;; i1 = 262144) {
      return PendingIntent.getActivity(paramContext, i1, (Intent)localObject, 134217728);
    }
  }
  
  private void e(Context paramContext)
  {
    Log.d("appwidget_days_41_helper", "loadThemeRes");
    if (TextUtils.isEmpty(this.aM)) {}
    String str;
    do
    {
      return;
      str = com.gau.go.launcherex.gowidget.weather.globaltheme.c.d.a(paramContext, this.aM);
      this.C = 0;
      if (!this.aM.contains("app_widget_theme"))
      {
        a(paramContext, this.aM, "z_appwidget_days_m_provider", "systemwidget_weatherwidget.xml");
        if (this.C == 0) {
          this.aM = "app_widget_theme_white";
        }
      }
    } while (this.C != 0);
    a(paramContext, paramContext.getPackageName(), c.a(4, str), c.a(str));
  }
  
  private void e(Context paramContext, RemoteViews paramRemoteViews, com.gau.go.launcherex.gowidget.weather.model.x paramx)
  {
    if (paramx != null) {}
    for (int i1 = a(paramx.b());; i1 = 0)
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
      if ((i3 != 0) && (this.O != 0))
      {
        paramContext = r.a(paramContext, ((WeatherBean)this.c.get(i2)).k.f());
        if (paramContext.equals("-10000")) {
          paramRemoteViews.setTextViewText(this.O, this.aU.getString(2131165888) + " : " + "--");
        }
      }
      else
      {
        return;
      }
      paramRemoteViews.setTextViewText(this.O, paramContext);
      return;
    }
  }
  
  private void f(Context paramContext, RemoteViews paramRemoteViews, com.gau.go.launcherex.gowidget.weather.model.x paramx)
  {
    int i2;
    if (paramx != null) {
      i2 = a(paramx.b());
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
          Object localObject = this.aR.c(i2);
          localObject = r.a(paramx.g, (Time)localObject, true);
          if (this.av[0] != 0)
          {
            if (i1 < ((ArrayList)localObject).size()) {
              break label798;
            }
            i1 = 0;
            if (((ArrayList)localObject).size() > this.aE) {
              break label352;
            }
            if (this.aB != 0) {
              paramRemoteViews.setViewVisibility(this.aB, 8);
            }
            if (this.aC != 0) {
              paramRemoteViews.setViewVisibility(this.aC, 4);
            }
            if (this.aD != 0) {
              paramRemoteViews.setViewVisibility(this.aD, 4);
            }
            label196:
            String str = y.f(this.b);
            if ((str == null) || ((!str.equals("200")) && (!str.equals("414")))) {
              break label547;
            }
            label232:
            paramx = paramx.n();
            i2 = 0;
            label240:
            if (i2 >= this.aE) {
              break label662;
            }
            if (i1 + i2 >= ((ArrayList)localObject).size()) {
              break label601;
            }
            a(paramContext, paramRemoteViews, i1 + i2, paramx, (List)localObject, this.av[i2], this.aA[i2], this.aw[i2], this.ax[i2], this.ay[i2], this.au[i2], this.az[i2]);
          }
          for (;;)
          {
            i2 += 1;
            break label240;
            if (i1 < ((ArrayList)localObject).size() - 1) {
              break label798;
            }
            i1 = 0;
            break;
            label352:
            if (this.aB != 0) {
              paramRemoteViews.setViewVisibility(this.aB, 0);
            }
            if ((this.aC != 0) && (this.A != 0)) {
              paramRemoteViews.setImageViewResource(this.aC, this.A);
            }
            if ((this.aD != 0) && (this.z != 0)) {
              paramRemoteViews.setImageViewResource(this.aD, this.z);
            }
            if (i1 == 0)
            {
              if ((this.aB != 0) && (this.z != 0)) {
                paramRemoteViews.setImageViewResource(this.aB, this.z);
              }
              if (this.aC != 0) {
                paramRemoteViews.setViewVisibility(this.aC, 4);
              }
              if (this.aD == 0) {
                break label196;
              }
              paramRemoteViews.setViewVisibility(this.aD, 0);
              break label196;
            }
            if ((this.aB != 0) && (this.A != 0)) {
              paramRemoteViews.setImageViewResource(this.aB, this.A);
            }
            if (this.aC != 0) {
              paramRemoteViews.setViewVisibility(this.aC, 0);
            }
            if (this.aD == 0) {
              break label196;
            }
            paramRemoteViews.setViewVisibility(this.aD, 4);
            break label196;
            label547:
            if (this.aB != 0) {
              paramRemoteViews.setViewVisibility(this.aB, 8);
            }
            if (this.aC != 0) {
              paramRemoteViews.setViewVisibility(this.aC, 8);
            }
            if (this.aD == 0) {
              break label232;
            }
            paramRemoteViews.setViewVisibility(this.aD, 8);
            break label232;
            label601:
            a(paramContext, paramRemoteViews, 0, null, null, this.av[i2], this.aA[i2], this.aw[i2], this.ax[i2], this.ay[i2], this.au[i2], this.az[i2]);
          }
        }
      }
      label662:
      for (i1 = 0;; i1 = 1)
      {
        if (i1 != 0)
        {
          i1 = 0;
          while (i1 < this.aE)
          {
            a(paramContext, paramRemoteViews, 0, null, null, this.av[i1], this.aA[i1], this.aw[i1], this.ax[i1], this.ay[i1], this.au[i1], this.az[i1]);
            i1 += 1;
          }
          if (this.aB != 0) {
            paramRemoteViews.setViewVisibility(this.aB, 4);
          }
          if (this.aC != 0) {
            paramRemoteViews.setViewVisibility(this.aC, 4);
          }
          if (this.aD != 0) {
            paramRemoteViews.setViewVisibility(this.aD, 4);
          }
        }
        return;
        label798:
        break;
      }
      i2 = 0;
    }
  }
  
  private void g(Context paramContext, RemoteViews paramRemoteViews, com.gau.go.launcherex.gowidget.weather.model.x paramx)
  {
    if (paramx != null) {}
    for (int i1 = a(paramx.b());; i1 = 0)
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
          if (this.aa != 0)
          {
            paramRemoteViews.setViewVisibility(this.aa, 8);
            if (this.n != 0) {
              paramRemoteViews.setImageViewResource(this.aa, this.n);
            }
          }
          if (this.ab != 0) {
            paramRemoteViews.setViewVisibility(this.ab, 8);
          }
          if (this.Z != 0) {
            paramRemoteViews.setTextViewText(this.Z, ((WeatherBean)localObject).d());
          }
          localNowBean = ((WeatherBean)localObject).k;
          if ((this.ac != 0) && (this.i != null) && (this.i[0] != 0)) {
            paramRemoteViews.setImageViewResource(this.ac, b(localNowBean.d(), a(paramx)));
          }
          i1 = com.gau.go.launcherex.gowidget.weather.util.q.a(localNowBean.b(this.aG));
          i2 = com.gau.go.launcherex.gowidget.weather.util.q.a(localNowBean.c(this.aG));
          if (this.ah != 0)
          {
            if ((i1 == 55536) || (i2 == 55536)) {
              break label1051;
            }
            if ((!localNowBean.e().equals("--")) && (!TextUtils.isEmpty(localNowBean.e())))
            {
              localObject = localNowBean.e() + "," + i1 + "°/" + i2 + "° ," + localNowBean.b();
              paramRemoteViews.setTextViewText(this.ah, (CharSequence)localObject);
            }
          }
          else
          {
            if (this.E != 0)
            {
              if ((localNowBean.e().equals("--")) || (TextUtils.isEmpty(localNowBean.e()))) {
                break label1177;
              }
              paramRemoteViews.setTextViewText(this.E, localNowBean.e());
            }
            label382:
            if (this.F != 0)
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
              paramRemoteViews.setTextViewText(this.F, ((StringBuffer)localObject).toString());
            }
            if ((this.ap != 0) && (!localNowBean.b().equals("--"))) {
              paramRemoteViews.setTextViewText(this.ap, this.aU.getString(2131166456) + localNowBean.b());
            }
            if (this.ak != 0)
            {
              if ((i1 == 55536) || (i2 == 55536)) {
                break label1229;
              }
              paramRemoteViews.setTextViewText(this.ak, i1 + "°/" + i2 + "° ");
            }
            label633:
            if (this.al != 0)
            {
              if (i1 == 55536) {
                break label1243;
              }
              paramRemoteViews.setTextViewText(this.al, i1 + "° ");
            }
            label677:
            if (this.am != 0)
            {
              if (i2 == 55536) {
                break label1257;
              }
              paramRemoteViews.setTextViewText(this.am, i2 + "° ");
            }
            label721:
            if (this.ao != 0)
            {
              localObject = localNowBean.b();
              if (r.a((String)localObject)) {
                break label1271;
              }
              paramContext = paramContext.getText(2131165323).toString();
              paramRemoteViews.setTextViewText(this.ao, paramContext);
            }
          }
        }
      }
      label763:
      for (i1 = 1;; i1 = 0)
      {
        if (i1 == 0)
        {
          if (this.E != 0) {
            paramRemoteViews.setTextViewText(this.E, "--");
          }
          if (this.F != 0) {
            paramRemoteViews.setTextViewText(this.F, "--");
          }
          if (this.ah != 0) {
            paramRemoteViews.setTextViewText(this.ah, "--");
          }
          if (this.ap != 0) {
            paramRemoteViews.setTextViewText(this.ap, "--");
          }
          if (this.ak != 0) {
            paramRemoteViews.setTextViewText(this.ak, "--");
          }
          if (this.al != 0) {
            paramRemoteViews.setTextViewText(this.al, "--");
          }
          if (this.am != 0) {
            paramRemoteViews.setTextViewText(this.al, "--");
          }
          if (this.ao != 0) {
            paramRemoteViews.setTextViewText(this.ao, "--");
          }
          if (this.Z != 0)
          {
            if (this.aI) {
              break label1463;
            }
            paramRemoteViews.setTextViewText(this.Z, this.aU.getString(2131166457));
          }
        }
        for (;;)
        {
          if (this.ab != 0) {
            paramRemoteViews.setViewVisibility(this.ab, 8);
          }
          if ((this.ac != 0) && (this.i != null) && (this.i[0] != 0)) {
            paramRemoteViews.setImageViewResource(this.ac, b(0, a(paramx)));
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
          localObject = this.aU.getString(2131165323);
          break;
          label1177:
          paramRemoteViews.setTextViewText(this.E, this.aU.getString(2131165323));
          break label382;
          label1198:
          ((StringBuffer)localObject).append("--°/--°");
          break label452;
          label1210:
          ((StringBuffer)localObject).append(this.aU.getString(2131165323));
          break label497;
          label1229:
          paramRemoteViews.setTextViewText(this.ak, "--°/--° ");
          break label633;
          label1243:
          paramRemoteViews.setTextViewText(this.al, "--° ");
          break label677;
          label1257:
          paramRemoteViews.setTextViewText(this.am, "--° ");
          break label721;
          label1271:
          i1 = this.aF;
          float f1 = localNowBean.a();
          if (!r.b(f1))
          {
            paramRemoteViews.setTextViewText(this.ao, this.aU.getString(2131165880) + " : " + (String)localObject);
            break label763;
          }
          paramContext = a(paramContext, i1, f1);
          if (i1 == 5)
          {
            paramRemoteViews.setTextViewText(this.ao, this.aU.getString(2131165880) + " : " + (String)localObject + " ,  " + paramContext);
            break label763;
          }
          paramRemoteViews.setTextViewText(this.ao, this.aU.getString(2131165880) + " : " + paramContext + " , " + (String)localObject);
          break label763;
          label1463:
          if (this.d) {
            paramRemoteViews.setTextViewText(this.Z, this.aU.getString(2131166458));
          } else {
            paramRemoteViews.setTextViewText(this.Z, this.aU.getString(2131166455));
          }
        }
      }
    }
  }
  
  public void a()
  {
    this.aI = false;
    if (this.aW != null) {
      this.aW = null;
    }
    this.aR.b();
    this.b.unregisterReceiver(this.aV);
    this.a.clear();
    this.c.clear();
    ab.a(this.b).b(this);
    x.a(this.b).b(this);
    a.a().a("AppWidgetDays41ProviderHelper unregisterReceiver", "插件错误.txt");
    Log.d("appwidget_days_41_helper", "appwidget_day_41_helper ==============================> onDestroy");
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
              Log.d("appwidget_days_41_helper", "deal_action:" + (String)localObject);
              if ((!this.aI) && (((String)localObject).equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_APPWIDGET_DAYS_41_CITY_CHANGE"))) {
                this.aW = paramIntent;
              }
              if (!"com.gau.go.launcherex.gowidget.weatherwidget.ACTION_APPWIDGET_ENABLED_UPDATE_PREVIEW".equals(localObject)) {
                break;
              }
            } while (paramIntent.getIntExtra("extra_widget_type", 0) != 5);
            this.aO = paramIntent.getBooleanExtra("extra_enabled_widget_update_preview", this.aO);
          } while (!this.aO);
          this.aP = paramIntent.getStringExtra("extra_app_widget_theme_package");
          b();
          return;
          if (((String)localObject).equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_APPWIDGET_DATA_READY"))
          {
            b();
            return;
          }
          if ((((String)localObject).equals("android.intent.action.TIME_TICK")) || (((String)localObject).equals("android.intent.action.TIME_SET")) || (((String)localObject).equals("android.intent.action.DATE_CHANGED")) || (((String)localObject).equals("android.intent.action.TIMEZONE_CHANGED")))
          {
            if (((String)localObject).equals("android.intent.action.TIMEZONE_CHANGED")) {
              this.aR.a();
            }
            for (;;)
            {
              b();
              Log.d("appwidget_days_41_helper", "刷新时间成功");
              return;
              if (this.aR.b(0).minute % 10 == 0) {
                this.aR.a();
              }
            }
          }
          if (((String)localObject).equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_REFRESH_STARTED"))
          {
            this.aL = true;
            b();
            return;
          }
          if (((String)localObject).equals("com.gau.go.launcherex.gowidget.weatherwidget.goweather.ACTION_UPDATE_DATA"))
          {
            this.aL = false;
            b();
            return;
          }
          if (!((String)localObject).equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_APPWIDGET_DAYS_41_CITY_CHANGE")) {
            break;
          }
          Log.d("appwidget_days_41_helper", "切换城市 > mAllHasLoaded = " + this.aI);
          i2 = this.c.size();
        } while (i2 == 0);
        i3 = paramIntent.getIntExtra("extra_appwidget_ids", 0);
        Log.d("appwidget_days_41_helper", "change city widgetId > " + i3);
        paramIntent = (com.gau.go.launcherex.gowidget.weather.model.x)this.a.get(i3);
      } while (paramIntent == null);
      if (this.aW != null) {
        this.aW = null;
      }
      Log.d("appwidget_days_41_helper", "before change cityId > " + paramIntent.b());
      i3 = a(paramIntent.b());
      i2 = (i3 + 1) % i2;
    } while (i3 == i2);
    Object localObject = (WeatherBean)this.c.get(i2);
    if (localObject != null) {
      if (((WeatherBean)localObject).e() != 2) {
        break label890;
      }
    }
    for (;;)
    {
      paramIntent.c(i1);
      paramIntent.a(((WeatherBean)localObject).c());
      v.a(this.b).b(paramIntent);
      Log.d("appwidget_days_41_helper", "after change cityId > " + paramIntent.b());
      b(this.b, paramIntent);
      return;
      if (((String)localObject).equals("appwidget_language_change"))
      {
        this.aU = com.gau.go.launcherex.gowidget.language.d.a(this.b).a();
        if (this.aU == null) {
          this.aU = this.b.getResources();
        }
        b();
        return;
      }
      if (((String)localObject).equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_APPWIDGET_DAYS_41_NEXT_PAGE"))
      {
        i1 = paramIntent.getIntExtra("extra_appwidget_ids", 0);
        Log.d("appwidget_days_41_helper", "change forecast widgetId > " + i1);
        paramIntent = (com.gau.go.launcherex.gowidget.weather.model.x)this.a.get(i1);
        if (paramIntent == null) {
          break;
        }
        i1 = i2;
        if (paramIntent.f() == 0) {
          if (this.av[0] == 0) {
            break label718;
          }
        }
        label718:
        for (i1 = this.aE;; i1 = this.aE - 1)
        {
          paramIntent.d(i1);
          b(this.b, paramIntent);
          return;
        }
      }
      if ((((String)localObject).equals("android.appwidget.action.APPWIDGET_UPDATE")) || (((String)localObject).equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_WIDGET_ADD_APPWIDGETDAYS41")))
      {
        b();
        return;
      }
      if (((String)localObject).equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_WIDGET_DELETE_APPWIDGETDAYS41"))
      {
        if (AppWidgetManager.getInstance(this.b).getAppWidgetIds(new ComponentName(this.b, AppWidgetDays41Provider.class)).length == 0)
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
      label890:
      i1 = 0;
    }
  }
  
  public void a(com.gau.go.launcherex.gowidget.weather.model.q paramq)
  {
    boolean bool = false;
    this.aG = paramq.g;
    this.aF = paramq.q;
    this.aH = paramq.k;
    this.aR.a(1, this.aH);
    this.aN = paramq.J;
    if (this.aN)
    {
      com.gau.go.launcherex.gowidget.weather.c.g localg = this.aR;
      if (paramq.r == 1) {
        bool = true;
      }
      localg.a(bool);
    }
    for (;;)
    {
      paramq = paramq.G;
      if (!paramq.equals(this.aM))
      {
        this.aM = paramq;
        e(this.b);
      }
      if (!this.aK) {
        this.aK = true;
      }
      if ((!this.aI) && (this.aJ) && (this.aK))
      {
        this.aI = true;
        b();
      }
      return;
      this.aR.a(false);
    }
  }
  
  public void a(String paramString, com.gau.go.launcherex.gowidget.weather.model.q paramq)
  {
    Log.d("appwidget_days_41_helper", "onLoadSettingBeanDone_key = " + paramString);
    if (TextUtils.isEmpty(paramString))
    {
      a(paramq);
      return;
    }
    b(paramString, paramq);
  }
  
  public void a(ArrayList paramArrayList)
  {
    Log.d("appwidget_days_41_helper", "onLoadWeatherBeanDone");
    b(paramArrayList);
    if (this.aI) {
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
        if (!this.aN) {
          break label51;
        }
        this.aR.a(bool1);
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
            this.aR.a(false);
            break label40;
            if (!paramString.equals("tempUnit")) {
              break label95;
            }
            i1 = paramq.g;
          } while (this.aG == i1);
          this.aG = i1;
          b();
          return;
          if (!paramString.equals("windUnit")) {
            break label128;
          }
          i1 = paramq.q;
        } while (this.aF == i1);
        this.aF = i1;
        b();
        return;
        if (paramString.equals("app_widget_theme"))
        {
          paramString = paramq.G;
          if (!paramString.equals(this.aM))
          {
            this.aM = paramString;
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
      } while (this.aH == i1);
      this.aH = i1;
      this.aR.a(1, this.aH);
      b();
      return;
    } while (!paramString.equals("Google_play_billing"));
    this.aN = paramq.J;
    if (this.aN)
    {
      paramString = this.aR;
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
      this.aR.a(false);
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
    if (!this.aJ) {
      this.aJ = true;
    }
    if ((!this.aI) && (this.aJ) && (this.aK))
    {
      this.aI = true;
      b();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/systemwidget/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */