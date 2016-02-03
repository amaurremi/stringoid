package com.gau.go.launcherex.gowidget.weather.systemwidget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
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
import com.gau.go.launcherex.gowidget.weather.globaltheme.c;
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
import org.xmlpull.v1.XmlPullParser;

public class e
  extends u
  implements aa, ae
{
  public static String a = "app_widget_theme_white";
  private int A;
  private int B;
  private int C;
  private int D;
  private int E;
  private int F;
  private int G;
  private int H;
  private int I;
  private String J = "";
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
  private int[] aA = new int[10];
  private int[] aB = new int[10];
  private int[] aC = new int[10];
  private int aD = 0;
  private int[] aE = { 2131165326, 2131165327, 2131165328, 2131165329, 2131165330, 2131165331, 2131165332 };
  private g aF;
  private Intent aG;
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
  private int[] az = new int[10];
  private SparseArray f = new SparseArray();
  private Resources g;
  private int h;
  private int i;
  private com.gau.go.launcherex.gowidget.weather.c.g j;
  private boolean k = false;
  private boolean l = false;
  private boolean m = false;
  private boolean n = false;
  private boolean o = false;
  private boolean p = false;
  private String q = "app_widget_theme_white";
  private h r;
  private boolean s = false;
  private f t = null;
  private ao u = null;
  private int[] v = { 2131166553, 2131166554, 2131166555, 2131166556, 2131166557, 2131166558, 2131166559, 2131166560, 2131166561, 2131166562, 2131166563, 2131166564 };
  private int w;
  private int x;
  private int y;
  private int z;
  
  public e(Context paramContext)
  {
    this.b = paramContext;
    this.g = com.gau.go.launcherex.gowidget.language.d.a(paramContext).a();
    if (this.g == null) {
      this.g = paramContext.getResources();
    }
    this.j = new com.gau.go.launcherex.gowidget.weather.c.g(paramContext);
    this.t = f.a(paramContext);
    this.t.a(paramContext, a);
    this.r = new h(paramContext.getContentResolver(), this);
    this.aF = new g(this, null);
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
    paramContext.registerReceiver(this.aF, (IntentFilter)localObject);
    a.a().a("AppWidget41ProviderHelper registerReceiver", "插件错误.txt");
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
    return r.a(this.aC, paramInt, paramBoolean);
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
      return this.j.b(i1);
    }
    return this.j.b(55536);
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
    this.r.a(1, Integer.valueOf(paramInt), WeatherContentProvider.t, new String[] { "current_cityid", "widget_location_type" }, "widget_id=?", new String[] { String.valueOf(paramInt) }, null);
  }
  
  private void a(Context paramContext, int paramInt)
  {
    if (this.p)
    {
      paramContext = (com.gau.go.launcherex.gowidget.weather.model.x)this.f.get(paramInt);
      if (paramContext != null)
      {
        String str = a;
        Log.d("appwidget_41_helper", "mPreviewTheme: " + this.q);
        if ((!TextUtils.isEmpty(this.q)) && (!this.q.equals(str)))
        {
          a = this.q;
          paramContext.c(a);
          d(this.b);
        }
        RemoteViews localRemoteViews = c(this.b, paramContext);
        if (!str.equals(a))
        {
          a = str;
          paramContext.c(a);
          d(this.b);
        }
        a(localRemoteViews);
      }
    }
  }
  
  private void a(Context paramContext, RemoteViews paramRemoteViews, com.gau.go.launcherex.gowidget.weather.model.x paramx)
  {
    int i1 = 0;
    if (paramx != null) {
      i1 = b(paramx.b());
    }
    int i4;
    if (this.L != 0)
    {
      if (this.E != 0) {
        paramRemoteViews.setImageViewResource(this.L, this.E);
      }
    }
    else
    {
      i4 = this.c.size();
      if ((i1 >= 0) && (i1 < i4)) {
        break label3842;
      }
    }
    label973:
    label1016:
    label1145:
    label1209:
    label1239:
    label1430:
    label1689:
    label1734:
    label1804:
    label1849:
    label1906:
    label1950:
    label2080:
    label2242:
    label2298:
    label2350:
    label2406:
    label2499:
    label2542:
    label2680:
    label2736:
    label2928:
    label2967:
    label2980:
    label3246:
    label3328:
    label3460:
    label3481:
    label3493:
    label3512:
    label3526:
    label3540:
    label3624:
    label3637:
    label3666:
    label3695:
    label3710:
    label3732:
    label3746:
    label3761:
    label3814:
    label3828:
    label3842:
    for (int i2 = 0;; i2 = i1)
    {
      Object localObject1 = b(paramContext);
      if (localObject1 != null)
      {
        if (this.ab != 0) {
          paramRemoteViews.setOnClickPendingIntent(this.ab, (PendingIntent)localObject1);
        }
        if (this.ac != 0) {
          paramRemoteViews.setOnClickPendingIntent(this.ac, (PendingIntent)localObject1);
        }
        if (this.aa != 0) {
          paramRemoteViews.setOnClickPendingIntent(this.aa, (PendingIntent)localObject1);
        }
        if (this.Z != 0) {
          paramRemoteViews.setOnClickPendingIntent(this.Z, (PendingIntent)localObject1);
        }
      }
      localObject1 = a(paramContext);
      if (localObject1 != null)
      {
        if (this.R != 0) {
          paramRemoteViews.setOnClickPendingIntent(this.R, (PendingIntent)localObject1);
        }
        if (this.N != 0) {
          paramRemoteViews.setOnClickPendingIntent(this.N, (PendingIntent)localObject1);
        }
        if (this.O != 0) {
          paramRemoteViews.setOnClickPendingIntent(this.O, (PendingIntent)localObject1);
        }
        if (this.P != 0) {
          paramRemoteViews.setOnClickPendingIntent(this.P, (PendingIntent)localObject1);
        }
        if (this.Q != 0) {
          paramRemoteViews.setOnClickPendingIntent(this.Q, (PendingIntent)localObject1);
        }
        if (this.S != 0) {
          paramRemoteViews.setOnClickPendingIntent(this.S, (PendingIntent)localObject1);
        }
        if (this.M != 0) {
          paramRemoteViews.setOnClickPendingIntent(this.M, (PendingIntent)localObject1);
        }
        if (this.T != 0) {
          paramRemoteViews.setOnClickPendingIntent(this.T, (PendingIntent)localObject1);
        }
        if (this.U != 0) {
          paramRemoteViews.setOnClickPendingIntent(this.U, (PendingIntent)localObject1);
        }
        if (this.V != 0) {
          paramRemoteViews.setOnClickPendingIntent(this.V, (PendingIntent)localObject1);
        }
        if (this.W != 0) {
          paramRemoteViews.setOnClickPendingIntent(this.W, (PendingIntent)localObject1);
        }
      }
      Object localObject2 = e(paramContext, paramx);
      if (localObject2 != null)
      {
        if (this.as != 0) {
          paramRemoteViews.setOnClickPendingIntent(this.as, (PendingIntent)localObject2);
        }
        if (this.ai != 0) {
          paramRemoteViews.setOnClickPendingIntent(this.ai, (PendingIntent)localObject2);
        }
        if (this.ah != 0) {
          paramRemoteViews.setOnClickPendingIntent(this.ah, (PendingIntent)localObject2);
        }
        if (this.ap != 0) {
          paramRemoteViews.setOnClickPendingIntent(this.ap, (PendingIntent)localObject2);
        }
        if (this.aq != 0) {
          paramRemoteViews.setOnClickPendingIntent(this.aq, (PendingIntent)localObject2);
        }
        if (this.ar != 0) {
          paramRemoteViews.setOnClickPendingIntent(this.ar, (PendingIntent)localObject2);
        }
        if (this.at != 0) {
          paramRemoteViews.setOnClickPendingIntent(this.at, (PendingIntent)localObject2);
        }
        if (this.ao != 0) {
          paramRemoteViews.setOnClickPendingIntent(this.ao, (PendingIntent)localObject2);
        }
      }
      localObject1 = localObject2;
      if (this.k)
      {
        localObject1 = localObject2;
        if (this.c.size() > 1)
        {
          localObject1 = new Intent(paramContext, AppWidgetService.class);
          ((Intent)localObject1).putExtra("appwidget_service_request", 21);
          ((Intent)localObject1).putExtra("request_extra_appwidget_type", 2);
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
        if (this.ad != 0) {
          paramRemoteViews.setOnClickPendingIntent(this.ad, (PendingIntent)localObject1);
        }
        if (this.ae != 0) {
          paramRemoteViews.setOnClickPendingIntent(this.ae, (PendingIntent)localObject1);
        }
        if (this.ag != 0) {
          paramRemoteViews.setOnClickPendingIntent(this.ag, (PendingIntent)localObject1);
        }
      }
      if (this.ax != 0)
      {
        localObject1 = a(paramContext, paramx);
        if (localObject1 != null)
        {
          paramRemoteViews.setViewVisibility(this.ax, 0);
          paramRemoteViews.setOnClickPendingIntent(this.ax, (PendingIntent)localObject1);
        }
      }
      if ((this.k) && (i4 != 0))
      {
        localObject1 = c(paramContext);
        if ((this.au != 0) && (localObject1 != null)) {
          paramRemoteViews.setOnClickPendingIntent(this.au, (PendingIntent)localObject1);
        }
      }
      if ((this.X != 0) && (this.B != 0)) {
        paramRemoteViews.setImageViewResource(this.X, this.B);
      }
      if ((this.Y != 0) && (this.I != 0)) {
        paramRemoteViews.setImageViewResource(this.Y, this.I);
      }
      localObject2 = a(paramx);
      int i3 = ((Time)localObject2).hour;
      i1 = i3;
      if (!r.b(paramContext))
      {
        i3 %= 12;
        i1 = i3;
        if (i3 == 0) {
          i1 = 12;
        }
      }
      i3 = ((Time)localObject2).minute;
      if ((this.N != 0) && (this.az != null) && (this.az[0] != 0)) {
        paramRemoteViews.setImageViewResource(this.N, r.a(i1 / 10, this.az));
      }
      if ((this.O != 0) && (this.az != null) && (this.az[0] != 0)) {
        paramRemoteViews.setImageViewResource(this.O, r.a(i1 % 10, this.az));
      }
      if (this.P != 0)
      {
        if ((this.aA != null) && (this.aA[0] != 0)) {
          paramRemoteViews.setImageViewResource(this.P, r.a(i3 / 10, this.aA));
        }
      }
      else
      {
        if (this.Q != 0)
        {
          if ((this.aA == null) || (this.aA[0] == 0)) {
            break label2928;
          }
          paramRemoteViews.setImageViewResource(this.Q, r.a(i3 % 10, this.aA));
        }
        if (this.T != 0) {
          paramRemoteViews.setTextViewText(this.T, r.e(i1) + ":" + r.e(i3));
        }
        if (this.U != 0) {
          paramRemoteViews.setTextViewText(this.U, r.e(i1));
        }
        if (this.V != 0) {
          paramRemoteViews.setTextViewText(this.V, r.e(i3));
        }
        if (!r.b(paramContext)) {
          break label2980;
        }
        if (this.M != 0)
        {
          if (this.A == 0) {
            break label2967;
          }
          paramRemoteViews.setViewVisibility(this.M, 0);
          paramRemoteViews.setImageViewResource(this.M, this.A);
        }
        if (this.W != 0) {
          paramRemoteViews.setViewVisibility(this.W, 8);
        }
        if (this.S != 0) {
          paramRemoteViews.setTextViewText(this.S, r.e(i1) + ":" + r.e(i3));
        }
        i1 = this.aE[localObject2.weekDay];
        if (this.j == null) {
          break label3246;
        }
        localObject1 = this.j.a((Time)localObject2);
        if (this.aa != 0) {
          paramRemoteViews.setTextViewText(this.aa, this.g.getString(i1));
        }
        if (this.ab != 0) {
          paramRemoteViews.setTextViewText(this.ab, (CharSequence)localObject1);
        }
        if (this.ac != 0) {
          paramRemoteViews.setTextViewText(this.ac, this.g.getString(i1) + "  " + (String)localObject1);
        }
        if (this.Z != 0)
        {
          if (TextUtils.isEmpty(this.J)) {
            break label3328;
          }
          localObject1 = this.g.getString(this.v[localObject2.month]);
        }
        switch (this.i)
        {
        default: 
          localObject1 = String.format(this.g.getString(2131166568), new Object[] { this.J, localObject1, Integer.valueOf(((Time)localObject2).monthDay) });
          localObject1 = Html.fromHtml((String)localObject1);
          paramRemoteViews.setTextViewText(this.Z, (CharSequence)localObject1);
          if (i4 != 0)
          {
            localObject1 = (WeatherBean)this.c.get(i2);
            if (localObject1 != null)
            {
              if (this.af != 0)
              {
                paramRemoteViews.setViewVisibility(this.af, 8);
                if (this.F != 0) {
                  paramRemoteViews.setImageViewResource(this.af, this.F);
                }
              }
              if (this.ag != 0) {
                paramRemoteViews.setViewVisibility(this.ag, 8);
              }
              if (this.ae != 0) {
                paramRemoteViews.setTextViewText(this.ae, ((WeatherBean)localObject1).d());
              }
              localObject1 = ((WeatherBean)localObject1).k;
              if ((this.as != 0) && (this.aC != null) && (this.aC[0] != 0)) {
                paramRemoteViews.setImageViewResource(this.as, a(((NowBean)localObject1).d(), b(paramx)));
              }
              i1 = com.gau.go.launcherex.gowidget.weather.util.q.a(((NowBean)localObject1).b(this.h));
              i3 = com.gau.go.launcherex.gowidget.weather.util.q.a(((NowBean)localObject1).c(this.h));
              if (this.ah != 0)
              {
                if ((i1 != 55536) && (i3 != 55536)) {
                  paramRemoteViews.setTextViewText(this.ah, i1 + "°/" + i3 + "°");
                }
              }
              else
              {
                if (this.ar != 0)
                {
                  if ((((NowBean)localObject1).e().equals("--")) || (TextUtils.isEmpty(((NowBean)localObject1).e()))) {
                    break label3460;
                  }
                  paramRemoteViews.setTextViewText(this.ar, ((NowBean)localObject1).e());
                }
                if (this.at != 0)
                {
                  localObject2 = new StringBuffer();
                  if ((i1 == 55536) || (i3 == 55536)) {
                    break label3481;
                  }
                  ((StringBuffer)localObject2).append(i1 + "°/" + i3 + "°");
                  ((StringBuffer)localObject2).append(", ");
                  if ((((NowBean)localObject1).e().equals("--")) || (TextUtils.isEmpty(((NowBean)localObject1).e()))) {
                    break label3493;
                  }
                  ((StringBuffer)localObject2).append(((NowBean)localObject1).e());
                  paramRemoteViews.setTextViewText(this.at, ((StringBuffer)localObject2).toString());
                }
                if (this.ap != 0)
                {
                  if (i1 == 55536) {
                    break label3512;
                  }
                  paramRemoteViews.setTextViewText(this.ap, i1 + "° ");
                }
                if (this.aq != 0)
                {
                  if (i3 == 55536) {
                    break label3526;
                  }
                  paramRemoteViews.setTextViewText(this.aq, i3 + "° ");
                }
              }
            }
          }
          break;
        }
      }
      for (i1 = 1;; i1 = 0)
      {
        if (i1 == 0)
        {
          if (this.ar != 0) {
            paramRemoteViews.setTextViewText(this.ar, "--");
          }
          if (this.at != 0) {
            paramRemoteViews.setTextViewText(this.at, "--");
          }
          if (this.ah != 0) {
            paramRemoteViews.setTextViewText(this.ah, "--");
          }
          if (this.ap != 0) {
            paramRemoteViews.setTextViewText(this.ap, "--");
          }
          if (this.aq != 0) {
            paramRemoteViews.setTextViewText(this.ap, "--");
          }
          if (this.ae != 0)
          {
            if (this.k) {
              break label3540;
            }
            paramRemoteViews.setTextViewText(this.ae, this.g.getString(2131166457));
          }
          if (this.ag != 0) {
            paramRemoteViews.setViewVisibility(this.ag, 8);
          }
          if ((this.as != 0) && (this.aC != null) && (this.aC[0] != 0)) {
            paramRemoteViews.setImageViewResource(this.as, a(0, b(paramx)));
          }
        }
        if (i4 != 0)
        {
          paramx = (WeatherBean)this.c.get(i2);
          if (paramx == null) {
            break label3828;
          }
        }
        for (i1 = com.gau.go.launcherex.gowidget.weather.util.q.a(paramx.k.a(this.h));; i1 = 55536)
        {
          int i5;
          if (i1 != 55536) {
            if (this.ao != 0)
            {
              paramRemoteViews.setViewVisibility(this.ao, 0);
              if (this.h == 1) {
                paramRemoteViews.setTextViewText(this.ao, String.valueOf(i1) + "°C");
              }
            }
            else if ((this.aB != null) && (this.aB[0] != 0))
            {
              if (this.an != 0)
              {
                if (i1 >= 0) {
                  break label3624;
                }
                paramRemoteViews.setViewVisibility(this.an, 0);
                if (this.C != 0) {
                  paramRemoteViews.setImageViewResource(this.an, this.C);
                }
              }
              i1 = Math.abs(i1);
              i3 = i1 / 100;
              if ((this.aj != 0) && (this.aB != null) && (this.aB[0] != 0))
              {
                if (i3 != 0) {
                  break label3637;
                }
                paramRemoteViews.setViewVisibility(this.aj, 8);
              }
              i5 = (i1 - i3 * 100) / 10;
              if ((this.ak != 0) && (this.aB != null) && (this.aB[0] != 0))
              {
                if ((i5 != 0) || (i3 != 0)) {
                  break label3666;
                }
                paramRemoteViews.setViewVisibility(this.ak, 8);
              }
              if ((this.al != 0) && (this.aB != null) && (this.aB[0] != 0))
              {
                paramRemoteViews.setImageViewResource(this.al, r.a(i1 % 10, this.aB));
                paramRemoteViews.setViewVisibility(this.al, 0);
              }
              if (this.am != 0)
              {
                if ((this.G == 0) || (this.H == 0)) {
                  break label3710;
                }
                if (this.h != 1) {
                  break label3695;
                }
                paramRemoteViews.setImageViewResource(this.am, this.G);
              }
            }
          }
          for (i1 = 1;; i1 = 0)
          {
            if (i1 == 0)
            {
              if (this.ao != 0)
              {
                paramRemoteViews.setViewVisibility(this.ao, 0);
                if (this.h != 1) {
                  break label3732;
                }
                paramRemoteViews.setTextViewText(this.ao, "--°C");
              }
              if ((this.an != 0) && (this.aj != 0) && (this.ak != 0) && (this.al != 0) && (this.aD != 0))
              {
                paramRemoteViews.setViewVisibility(this.an, 8);
                paramRemoteViews.setViewVisibility(this.aj, 8);
                paramRemoteViews.setImageViewResource(this.ak, this.aD);
                paramRemoteViews.setViewVisibility(this.ak, 0);
                paramRemoteViews.setImageViewResource(this.al, this.aD);
                paramRemoteViews.setViewVisibility(this.al, 0);
                if (this.am != 0)
                {
                  if ((this.G == 0) || (this.H == 0)) {
                    break label3761;
                  }
                  if (this.h != 1) {
                    break label3746;
                  }
                  paramRemoteViews.setImageViewResource(this.am, this.G);
                }
              }
            }
            if (this.ay != 0) {
              paramRemoteViews.setViewVisibility(this.ay, 8);
            }
            if ((this.au != 0) && (this.av != 0))
            {
              if (this.o)
              {
                paramRemoteViews.setViewVisibility(this.au, 4);
                paramRemoteViews.setViewVisibility(this.av, 0);
              }
            }
            else if ((i4 != 0) && (this.aw != 0))
            {
              paramx = (WeatherBean)this.c.get(i2);
              if (paramx == null) {
                break label3814;
              }
            }
            for (long l1 = paramx.k.f();; l1 = -10000L)
            {
              paramContext = r.a(paramContext, l1);
              if (paramContext.equals("-10000"))
              {
                paramRemoteViews.setTextViewText(this.aw, this.g.getString(2131165888) + " : " + "--");
                return;
                if ((this.w == 0) || (this.x == 0)) {
                  break;
                }
                if (b(paramx))
                {
                  paramRemoteViews.setImageViewResource(this.L, this.w);
                  break;
                }
                paramRemoteViews.setImageViewResource(this.L, this.x);
                break;
                if ((this.az == null) || (this.az[0] == 0)) {
                  break label973;
                }
                paramRemoteViews.setImageViewResource(this.P, r.a(i3 / 10, this.az));
                break label973;
                if ((this.az == null) || (this.az[0] == 0)) {
                  break label1016;
                }
                paramRemoteViews.setImageViewResource(this.Q, r.a(i3 % 10, this.az));
                break label1016;
                paramRemoteViews.setViewVisibility(this.M, 8);
                break label1145;
                if ((((Time)localObject2).hour >= 0) && (((Time)localObject2).hour <= 11))
                {
                  if ((this.M != 0) && (this.z != 0))
                  {
                    paramRemoteViews.setViewVisibility(this.M, 0);
                    paramRemoteViews.setImageViewResource(this.M, this.z);
                  }
                  if (this.W != 0)
                  {
                    paramRemoteViews.setViewVisibility(this.W, 0);
                    paramRemoteViews.setTextViewText(this.W, "AM");
                  }
                  if (this.S == 0) {
                    break label1209;
                  }
                  paramRemoteViews.setTextViewText(this.S, r.e(i1) + ":" + r.e(i3) + " " + "AM");
                  break label1209;
                }
                if ((this.M != 0) && (this.y != 0))
                {
                  paramRemoteViews.setViewVisibility(this.M, 0);
                  paramRemoteViews.setImageViewResource(this.M, this.y);
                }
                if (this.W != 0)
                {
                  paramRemoteViews.setViewVisibility(this.W, 0);
                  paramRemoteViews.setTextViewText(this.W, "PM");
                }
                if (this.S == 0) {
                  break label1209;
                }
                paramRemoteViews.setTextViewText(this.S, r.e(i1) + ":" + r.e(i3) + " " + "PM");
                break label1209;
                localObject1 = ((Time)localObject2).month + "/" + ((Time)localObject2).monthDay;
                break label1239;
                localObject1 = String.format(this.g.getString(2131166569), new Object[] { this.J, localObject1, Integer.valueOf(((Time)localObject2).monthDay) });
                break label1430;
                localObject1 = this.g.getString(this.v[localObject2.month]);
                switch (this.i)
                {
                }
                for (localObject1 = (String)localObject1 + " " + ((Time)localObject2).monthDay;; localObject1 = ((Time)localObject2).monthDay + " " + (String)localObject1)
                {
                  paramRemoteViews.setTextViewText(this.Z, (CharSequence)localObject1);
                  break;
                }
                paramRemoteViews.setTextViewText(this.ah, "--°/--°");
                break label1689;
                paramRemoteViews.setTextViewText(this.ar, this.g.getString(2131165323));
                break label1734;
                ((StringBuffer)localObject2).append("--°/--°");
                break label1804;
                ((StringBuffer)localObject2).append(this.g.getString(2131165323));
                break label1849;
                paramRemoteViews.setTextViewText(this.ap, "--° ");
                break label1906;
                paramRemoteViews.setTextViewText(this.aq, "--° ");
                break label1950;
                if (this.d)
                {
                  paramRemoteViews.setTextViewText(this.ae, this.g.getString(2131166458));
                  break label2080;
                }
                paramRemoteViews.setTextViewText(this.ae, this.g.getString(2131166455));
                break label2080;
                paramRemoteViews.setTextViewText(this.ao, String.valueOf(i1) + "°F");
                break label2242;
                paramRemoteViews.setViewVisibility(this.an, 8);
                break label2298;
                paramRemoteViews.setImageViewResource(this.aj, r.a(i3, this.aB));
                paramRemoteViews.setViewVisibility(this.aj, 0);
                break label2350;
                paramRemoteViews.setImageViewResource(this.ak, r.a(i5, this.aB));
                paramRemoteViews.setViewVisibility(this.ak, 0);
                break label2406;
                paramRemoteViews.setImageViewResource(this.am, this.H);
                break label2499;
                if (this.D == 0) {
                  break label2499;
                }
                paramRemoteViews.setImageViewResource(this.am, this.D);
                break label2499;
                paramRemoteViews.setTextViewText(this.ao, "--°F");
                break label2542;
                paramRemoteViews.setImageViewResource(this.am, this.H);
                break label2680;
                if (this.D == 0) {
                  break label2680;
                }
                paramRemoteViews.setImageViewResource(this.am, this.D);
                break label2680;
                paramRemoteViews.setViewVisibility(this.au, 0);
                paramRemoteViews.setViewVisibility(this.av, 4);
                break label2736;
              }
              paramRemoteViews.setTextViewText(this.aw, paramContext);
              return;
            }
          }
        }
      }
    }
  }
  
  private void a(Context paramContext, f paramf, String paramString1, String paramString2)
  {
    Object localObject;
    if (!a.contains("app_widget_theme"))
    {
      paramString2 = "systemwidget_weatherwidget.xml";
      localObject = com.gau.go.launcherex.gowidget.weather.f.g.a(paramContext, paramString1, paramString2);
      if (localObject != null) {
        break label598;
      }
    }
    label598:
    for (paramString2 = com.gau.go.launcherex.gowidget.weather.f.g.b(paramContext, paramString1, paramString2.replace(".xml", ""));; paramString2 = (String)localObject)
    {
      if (paramString2 == null) {}
      do
      {
        return;
        paramString2 = c.a(paramString2);
        break;
        localObject = com.gau.go.launcherex.gowidget.weather.f.g.a(paramString2);
        if (this.u == null) {
          this.u = new ao();
        }
        ao.a = paramString1;
        this.u.a("systemwidget_style", String.valueOf(41));
        if (localObject != null) {
          new am().a((XmlPullParser)localObject, this.u);
        }
        try
        {
          paramString2.close();
          this.E = paramf.c(this.u.a("go_weatherex_widget_bg"), paramString1);
          this.w = paramf.c(this.u.a("go_weatherex_widget_bg_day"), paramString1);
          this.x = paramf.c(this.u.a("go_weatherex_widget_bg_night"), paramString1);
          this.y = paramf.c(this.u.a("go_weatherex_widget_time_pm"), paramString1);
          this.z = paramf.c(this.u.a("go_weatherex_widget_time_am"), paramString1);
          paramString2 = this.u.a("go_weatherex_widget_time_ampm_empty");
          this.J = this.u.a("go_weatherex_widget_date_style_color");
          this.A = paramf.c(paramString2, paramString1);
          this.B = paramf.c(this.u.a("go_weatherex_widget_time_bg"), paramString1);
          this.F = paramf.c(this.u.a("go_weatherex_widget_change_city"), paramString1);
          this.I = paramf.c(this.u.a("go_weatherex_widget_time_divider"), paramString1);
          this.D = paramf.c(this.u.a("go_weatherex_widget_temp_unit"), paramString1);
          this.G = paramf.c(this.u.a("go_weatherex_widget_temp_unit_centigrade"), paramString1);
          this.H = paramf.c(this.u.a("go_weatherex_widget_temp_unit_fahrenheit"), paramString1);
          this.C = paramf.c(this.u.a("go_weatherex_widget_temp_minus"), paramString1);
          i1 = 0;
          while (i1 < 10)
          {
            this.aC[i1] = paramf.c(ao.c[i1], paramString1);
            i1 += 1;
          }
        }
        catch (IOException paramString2)
        {
          for (;;)
          {
            paramString2.printStackTrace();
          }
          int i1 = 0;
          while (i1 < 10)
          {
            this.az[i1] = paramf.c(ao.d[i1], paramString1);
            i1 += 1;
          }
          i1 = 0;
          while (i1 < 10)
          {
            this.aA[i1] = paramf.c(ao.e[i1], paramString1);
            i1 += 1;
          }
          i1 = 0;
          while (i1 < 10)
          {
            this.aB[i1] = paramf.c(ao.f[i1], paramString1);
            i1 += 1;
          }
          this.aD = this.C;
        }
      } while (!paramString1.equals(paramContext.getPackageName()));
      this.s = paramContext.getSharedPreferences("goweatherex_info", 0).getBoolean("new_theme", false);
      return;
    }
  }
  
  private void a(RemoteViews paramRemoteViews)
  {
    if (paramRemoteViews == null) {
      return;
    }
    Intent localIntent = new Intent("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_APPWIDGET_UPDATE_PREVIEW");
    localIntent.putExtra("extra_widget_preview", paramRemoteViews);
    localIntent.putExtra("extra_widget_type", 2);
    this.b.sendBroadcast(localIntent);
  }
  
  private void a(Object paramObject, Cursor paramCursor)
  {
    Integer localInteger = (Integer)paramObject;
    int i1;
    if ((paramCursor != null) && (paramCursor.getCount() > 0))
    {
      paramObject = new com.gau.go.launcherex.gowidget.weather.model.x();
      ((com.gau.go.launcherex.gowidget.weather.model.x)paramObject).b(2);
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
        if (this.aG != null)
        {
          i1 = this.aG.getIntExtra("extra_appwidget_ids", 0);
          if ((i1 != 0) && (i1 == localInteger.intValue()))
          {
            a(this.aG);
            this.aG = null;
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
          Log.d("appwidget_41_helper", "new widgetId > " + localInteger);
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
        localx.b(2);
        return localx;
        localx.a("");
      }
    }
  }
  
  private void b()
  {
    Log.d("appwidget_41_helper", "refreshUI");
    if (TextUtils.isEmpty(a)) {
      a = "app_widget_theme_white";
    }
    int[] arrayOfInt = AppWidgetManager.getInstance(this.b).getAppWidgetIds(new ComponentName(this.b, AppWidget41Provider.class));
    Log.d("appwidget_41_helper", "共找到有" + arrayOfInt.length + "个该系统widget样式");
    int i1 = 0;
    while (i1 < arrayOfInt.length)
    {
      Log.d("appwidget_41_helper", "第" + i1 + "个widgetID：" + arrayOfInt[i1]);
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
          paramx = new RemoteViews(paramContext.getPackageName(), 2130903072);
          paramx.setOnClickPendingIntent(2131230955, a(paramContext, "market://details?id=com.gau.go.weatherex.systemwidgetskin.moonlightskin"));
        }
      }
      for (;;)
      {
        paramContext = AppWidgetManager.getInstance(paramContext);
        if ((paramx == null) || (paramContext == null) || (i1 == 0)) {
          break;
        }
        paramContext.updateAppWidget(i1, paramx);
        return;
        if (!this.e)
        {
          this.e = true;
          d(paramContext);
        }
        paramx = c(paramContext, paramx);
        continue;
        paramx = c(paramContext, paramx);
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
    if ((this.n) && (this.j.d()))
    {
      int i1 = localWeatherBean.k.n();
      return r.a(paramx, str, this.j.b(i1));
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
      if (this.K == 0) {
        break label100;
      }
    }
    for (Object localObject1 = new RemoteViews((String)localObject1, this.K);; localObject1 = new RemoteViews((String)localObject1, this.K))
    {
      localObject2 = localObject1;
      if (this.K == 0) {
        break;
      }
      a(paramContext, (RemoteViews)localObject1, paramx);
      return (RemoteViews)localObject1;
      localObject1 = a;
      break label48;
      label100:
      d(paramContext);
      if (this.K == 0) {
        break label130;
      }
    }
    label130:
    return null;
  }
  
  private void d(Context paramContext)
  {
    Log.d("appwidget_41_helper", "loadThemeRes");
    if (TextUtils.isEmpty(a)) {
      return;
    }
    String str2 = com.gau.go.launcherex.gowidget.weather.globaltheme.c.d.a(paramContext, a);
    String str1;
    label46:
    int i1;
    if (a.contains("app_widget_theme"))
    {
      str1 = paramContext.getPackageName();
      if (this.t == null) {
        this.t = f.a(paramContext);
      }
      this.t.a(paramContext, str1);
      this.K = 0;
      if (!a.contains("app_widget_theme"))
      {
        if (!str1.equals(paramContext.getPackageName())) {
          break label773;
        }
        i1 = 1;
      }
    }
    for (;;)
    {
      if (i1 != 0)
      {
        this.K = this.t.a("z_appwidget_m_provider_ex", str1);
        if (this.K == 0) {
          a = "app_widget_theme_white";
        }
      }
      if (this.K == 0)
      {
        str1 = paramContext.getPackageName();
        this.K = this.t.a(c.a(1, str2), str1);
      }
      if (this.K == 0) {
        break;
      }
      this.L = this.t.b("goweatherex_widget_m_bg", str1);
      this.as = this.t.b("goweatherex_widget_m_weather_icon", str1);
      this.ah = this.t.b("goweatherex_widget_m_low_high_temp", str1);
      this.aq = this.t.b("goweatherex_widget_m_low_temp", str1);
      this.ap = this.t.b("goweatherex_widget_m_high_temp", str1);
      this.ad = this.t.b("goweatherex_widget_m_layout_city", str1);
      this.af = this.t.b("goweatherex_widget_m_img_next", str1);
      this.ae = this.t.b("goweatherex_widget_m_city_name", str1);
      this.ag = this.t.b("goweatherex_widget_m_text_next_city", str1);
      this.ai = this.t.b("goweatherex_widget_m_layout_now_temp", str1);
      this.an = this.t.b("goweatherex_widget_m_temp_minus", str1);
      this.aj = this.t.b("goweatherex_widget_m_temp_num_1", str1);
      this.ak = this.t.b("goweatherex_widget_m_temp_num_2", str1);
      this.al = this.t.b("goweatherex_widget_m_temp_num_3", str1);
      this.am = this.t.b("goweatherex_widget_m_temp_unit", str1);
      this.ao = this.t.b("goweatherex_widget_m_text_temp", str1);
      this.ar = this.t.b("goweatherex_widget_m_weather_desp", str1);
      this.at = this.t.b("goweatherex_widget_m_weather_temp_desp", str1);
      this.M = this.t.b("goweatherex_widget_m_am_pm", str1);
      this.aa = this.t.b("goweatherex_widget_m_weekday", str1);
      this.ac = this.t.b("goweatherex_widget_m_date_week", str1);
      this.ab = this.t.b("goweatherex_widget_m_date", str1);
      this.Z = this.t.b("goweatherex_widget_m_style_date", str1);
      this.N = this.t.b("goweatherex_widget_m_hour_num_1", str1);
      this.O = this.t.b("goweatherex_widget_m_hour_num_2", str1);
      this.P = this.t.b("goweatherex_widget_m_min_num_1", str1);
      this.Q = this.t.b("goweatherex_widget_m_min_num_2", str1);
      this.R = this.t.b("goweatherex_widget_m_time", str1);
      this.X = this.t.b("goweatherex_widget_m_timeboard", str1);
      this.Y = this.t.b("goweatherex_widget_m_time_divider", str1);
      this.au = this.t.b("goweatherex_widget_m_weather_refresh", str1);
      this.av = this.t.b("goweatherex_widget_m_refresh_progress", str1);
      this.ay = this.t.b("goweatherex_widget_m_extreme_icon", str1);
      this.ax = this.t.b("goweatherex_widget_m_theme_select", str1);
      this.S = this.t.b("goweatherex_widget_m_text_time_ampm", str1);
      this.T = this.t.b("goweatherex_widget_m_text_time", str1);
      this.U = this.t.b("goweatherex_widget_m_text_time_hour", str1);
      this.V = this.t.b("goweatherex_widget_m_text_time_min", str1);
      this.W = this.t.b("goweatherex_widget_m_text_am_pm", str1);
      a(paramContext, this.t, str1, str2);
      return;
      str1 = a;
      break label46;
      try
      {
        label773:
        paramContext.getPackageManager().getPackageInfo(str1, 0);
        i1 = 1;
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
    localObject = WeatherDetailActivity.a(this.b, (String)localObject, true, 9, "", -1);
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
      localAppWidgetManager.updateAppWidget(new ComponentName(paramContext, AppWidget41Provider.class), null);
    }
  }
  
  public void a()
  {
    this.k = false;
    if (this.aG != null) {
      this.aG = null;
    }
    this.j.b();
    this.b.unregisterReceiver(this.aF);
    this.f.clear();
    this.c.clear();
    ab.a(this.b).b(this);
    x.a(this.b).b(this);
    a.a().a("AppWidget41ProviderHelper unregisterReceiver", "插件错误.txt");
    Log.d("appwidget_41_helper", "appwidget_41_helper ==============================> onDestroy");
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
    int i3;
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
              Log.d("appwidget_41_helper", "deal_action:" + (String)localObject);
              if ((!this.k) && (((String)localObject).equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_APPWIDGET41_CITY_CHANGE"))) {
                this.aG = paramIntent;
              }
              if (!"com.gau.go.launcherex.gowidget.weatherwidget.ACTION_APPWIDGET_ENABLED_UPDATE_PREVIEW".equals(localObject)) {
                break;
              }
            } while (paramIntent.getIntExtra("extra_widget_type", 0) != 2);
            this.p = paramIntent.getBooleanExtra("extra_enabled_widget_update_preview", this.p);
          } while (!this.p);
          this.q = paramIntent.getStringExtra("extra_app_widget_theme_package");
          b();
          return;
          if (((String)localObject).equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_APPWIDGET_DATA_READY"))
          {
            b();
            return;
          }
          if ((((String)localObject).equals("android.intent.action.TIME_SET")) || (((String)localObject).equals("android.intent.action.TIME_TICK")) || (((String)localObject).equals("android.intent.action.DATE_CHANGED")) || (((String)localObject).equals("android.intent.action.TIMEZONE_CHANGED")) || (((String)localObject).equals("android.intent.action.SCREEN_ON")))
          {
            if (((String)localObject).equals("android.intent.action.TIMEZONE_CHANGED")) {
              this.j.a();
            }
            for (;;)
            {
              b();
              Log.d("appwidget_41_helper", "刷新时间成功");
              return;
              if (this.j.b(0).minute % 10 == 0) {
                this.j.a();
              }
            }
          }
          if (((String)localObject).equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_REFRESH_STARTED"))
          {
            this.o = true;
            b();
            return;
          }
          if (((String)localObject).equals("com.gau.go.launcherex.gowidget.weatherwidget.goweather.ACTION_UPDATE_DATA"))
          {
            this.o = false;
            b();
            return;
          }
          if (!((String)localObject).equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_APPWIDGET41_CITY_CHANGE")) {
            break;
          }
          Log.d("appwidget_41_helper", "切换城市 > mAllHasLoaded = " + this.k);
          i2 = this.c.size();
        } while (i2 == 0);
        i3 = paramIntent.getIntExtra("extra_appwidget_ids", 0);
        Log.d("appwidget_41_helper", "change city widgetId > " + i3);
        paramIntent = (com.gau.go.launcherex.gowidget.weather.model.x)this.f.get(i3);
      } while (paramIntent == null);
      if (this.aG != null) {
        this.aG = null;
      }
      Log.d("appwidget_41_helper", "before change cityId > " + paramIntent.b());
      i3 = b(paramIntent.b());
      i2 = (i3 + 1) % i2;
    } while (i3 == i2);
    Object localObject = (WeatherBean)this.c.get(i2);
    if (localObject != null) {
      if (((WeatherBean)localObject).e() != 2) {
        break label833;
      }
    }
    for (;;)
    {
      paramIntent.c(i1);
      paramIntent.a(((WeatherBean)localObject).c());
      v.a(this.b).b(paramIntent);
      Log.d("appwidget_41_helper", "after change cityId > " + paramIntent.b());
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
        if (i1 == 0) {
          this.s = false;
        }
        for (;;)
        {
          b();
          return;
          if (i1 == 1) {
            this.s = true;
          }
        }
      }
      if ((((String)localObject).equals("android.appwidget.action.APPWIDGET_UPDATE")) || (((String)localObject).equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_WIDGET_ADD_APPWIDGET41")))
      {
        b();
        return;
      }
      if (((String)localObject).equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_WIDGET_DELETE_APPWIDGET41"))
      {
        if (AppWidgetManager.getInstance(this.b).getAppWidgetIds(new ComponentName(this.b, AppWidget41Provider.class)).length == 0)
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
      label833:
      i1 = 0;
    }
  }
  
  public void a(com.gau.go.launcherex.gowidget.weather.model.q paramq)
  {
    boolean bool = false;
    this.h = paramq.g;
    this.i = paramq.k;
    this.j.a(1, this.i);
    this.n = paramq.J;
    if (this.n)
    {
      com.gau.go.launcherex.gowidget.weather.c.g localg = this.j;
      if (paramq.r == 1) {
        bool = true;
      }
      localg.a(bool);
    }
    for (;;)
    {
      paramq = paramq.G;
      if (!paramq.equals(a))
      {
        a = paramq;
        d(this.b);
      }
      if (!this.m) {
        this.m = true;
      }
      if ((!this.k) && (this.l) && (this.m))
      {
        this.k = true;
        b();
      }
      return;
      this.j.a(false);
    }
  }
  
  public void a(String paramString, com.gau.go.launcherex.gowidget.weather.model.q paramq)
  {
    Log.d("appwidget_41_helper", "onLoadSettingBeanDone_key = " + paramString);
    if (TextUtils.isEmpty(paramString))
    {
      a(paramq);
      return;
    }
    b(paramString, paramq);
  }
  
  public void a(ArrayList paramArrayList)
  {
    Log.d("appwidget_41_helper", "onLoadWeatherBeanDone");
    b(paramArrayList);
    if (this.k) {
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
        if (!this.n) {
          break label51;
        }
        this.j.a(bool1);
        label40:
        b();
      }
    }
    label51:
    label95:
    label190:
    do
    {
      int i1;
      do
      {
        do
        {
          return;
          bool1 = false;
          break;
          this.j.a(false);
          break label40;
          if (!paramString.equals("tempUnit")) {
            break label95;
          }
          i1 = paramq.g;
        } while (this.h == i1);
        this.h = i1;
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
          break label190;
        }
        i1 = paramq.k;
      } while (this.i == i1);
      this.i = i1;
      this.j.a(1, this.i);
      b();
      return;
    } while (!paramString.equals("Google_play_billing"));
    this.n = paramq.J;
    if (this.n)
    {
      paramString = this.j;
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
      this.j.a(false);
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
    if (!this.l) {
      this.l = true;
    }
    if ((!this.k) && (this.l) && (this.m))
    {
      this.k = true;
      b();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/systemwidget/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */