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
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

public class a
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
  private int J;
  private int K;
  private int L;
  private int M;
  private int N;
  private int O;
  private int P;
  private int Q;
  private int R;
  private Intent S;
  private c T;
  private SparseArray f = new SparseArray();
  private Time g = new Time();
  private int h = 1;
  private Resources i;
  private int[] j = new int[10];
  private int[] k = new int[10];
  private an l = null;
  private boolean m = false;
  private String n = "app_widget_theme_white";
  private boolean o = false;
  private boolean p = false;
  private boolean q = false;
  private d r = null;
  private com.gau.go.launcherex.gowidget.weather.c.g s = null;
  private boolean t = false;
  private int u;
  private int v;
  private int w;
  private int x;
  private int y;
  private int z;
  
  public a(Context paramContext)
  {
    this.b = paramContext;
    this.i = com.gau.go.launcherex.gowidget.language.d.a(this.b).a();
    if (this.i == null) {
      this.i = this.b.getResources();
    }
    this.s = new com.gau.go.launcherex.gowidget.weather.c.g(paramContext);
    this.r = new d(paramContext.getContentResolver(), this);
    this.o = false;
    this.T = new c(this, null);
    paramContext = new IntentFilter();
    paramContext.addAction("android.intent.action.TIME_TICK");
    paramContext.addAction("android.intent.action.TIME_SET");
    paramContext.addAction("android.intent.action.DATE_CHANGED");
    paramContext.addAction("android.intent.action.TIMEZONE_CHANGED");
    paramContext.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_NEW_THEME_FLAG_CHANGE");
    paramContext.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_APPWIDGET_DATA_READY");
    paramContext.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_REFRESH_STARTED");
    paramContext.addAction("com.gau.go.launcherex.gowidget.weatherwidget.goweather.ACTION_UPDATE_DATA");
    paramContext.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_INITIALIZED_CITY");
    this.b.registerReceiver(this.T, paramContext);
    com.gtp.a.a.a.a.a().a("AppWidget21ProviderHelper registerReceiver", "插件错误.txt");
    paramContext = ab.a(this.b);
    paramContext.a(this);
    if (paramContext.a) {
      b(paramContext.a());
    }
    paramContext = x.a(this.b);
    paramContext.a(this);
    if (paramContext.a) {
      a(paramContext.a());
    }
  }
  
  private int a(int paramInt, com.gau.go.launcherex.gowidget.weather.model.x paramx)
  {
    return r.a(this.k, paramInt, a(paramx));
  }
  
  private int a(int paramInt, boolean paramBoolean)
  {
    int[] arrayOfInt = this.j;
    int i1 = arrayOfInt[0];
    switch (paramInt)
    {
    default: 
      return i1;
    case 0: 
      return arrayOfInt[0];
    case 1: 
      return arrayOfInt[1];
    case 2: 
      return arrayOfInt[2];
    case 3: 
      return arrayOfInt[3];
    case 4: 
      return arrayOfInt[4];
    case 5: 
      return arrayOfInt[5];
    case 6: 
      return arrayOfInt[6];
    case 7: 
      return arrayOfInt[7];
    case 8: 
      return arrayOfInt[8];
    }
    return arrayOfInt[9];
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
    if (this.m)
    {
      paramContext = (com.gau.go.launcherex.gowidget.weather.model.x)this.f.get(paramInt);
      if (paramContext != null)
      {
        String str = a;
        Log.d("appwidget_21_helper", "mPreviewTheme: " + this.n);
        if ((!TextUtils.isEmpty(this.n)) && (!this.n.equals(str)))
        {
          a = this.n;
          paramContext.c(a);
          e(this.b);
        }
        RemoteViews localRemoteViews = c(this.b, paramContext);
        if (!str.equals(a))
        {
          a = str;
          paramContext.c(a);
          e(this.b);
        }
        a(localRemoteViews);
      }
    }
  }
  
  private void a(Context paramContext, RemoteViews paramRemoteViews, com.gau.go.launcherex.gowidget.weather.model.x paramx)
  {
    if (this.D != 0)
    {
      if (this.B == 0) {
        break label27;
      }
      paramRemoteViews.setImageViewResource(this.D, this.B);
    }
    label27:
    while ((this.A == 0) || (this.x == 0)) {
      return;
    }
    this.g.setToNow();
    if (a(paramx))
    {
      paramRemoteViews.setImageViewResource(this.D, this.A);
      return;
    }
    paramRemoteViews.setImageViewResource(this.D, this.x);
  }
  
  private void a(RemoteViews paramRemoteViews)
  {
    if (paramRemoteViews == null) {
      return;
    }
    Intent localIntent = new Intent("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_APPWIDGET_UPDATE_PREVIEW");
    localIntent.putExtra("extra_widget_preview", paramRemoteViews);
    localIntent.putExtra("extra_widget_type", 3);
    this.b.sendBroadcast(localIntent);
  }
  
  private void a(Object paramObject, Cursor paramCursor)
  {
    Integer localInteger = (Integer)paramObject;
    int i1;
    if ((paramCursor != null) && (paramCursor.getCount() > 0))
    {
      paramObject = new com.gau.go.launcherex.gowidget.weather.model.x();
      ((com.gau.go.launcherex.gowidget.weather.model.x)paramObject).b(3);
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
        if (this.S != null)
        {
          i1 = this.S.getIntExtra("extra_appwidget_ids", 0);
          if ((i1 != 0) && (i1 == localInteger.intValue()))
          {
            a(this.S);
            this.S = null;
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
          Log.d("appwidget_21_helper", "new widgetId > " + localInteger);
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
    if ((this.t) && (this.s.d()))
    {
      int i1 = localWeatherBean.k.n();
      return r.a(paramx, str, this.s.b(i1));
    }
    return r.a(paramx, str);
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
        break label89;
      }
    }
    label89:
    for (paramInt = 1;; paramInt = 0)
    {
      localx.c(paramInt);
      for (;;)
      {
        localx.b(3);
        return localx;
        localx.a("");
      }
    }
  }
  
  private void b()
  {
    Log.d("appwidget_21_helper", "refreshUI");
    if (TextUtils.isEmpty(a)) {
      a = "app_widget_theme_white";
    }
    int[] arrayOfInt = AppWidgetManager.getInstance(this.b).getAppWidgetIds(new ComponentName(this.b, AppWidget21Provider.class));
    Log.d("appwidget_21_helper", "共找到有" + arrayOfInt.length + "个该系统widget样式");
    int i1 = 0;
    while (i1 < arrayOfInt.length)
    {
      Log.d("appwidget_21_helper", "第" + i1 + "个widgetID：" + arrayOfInt[i1]);
      if (i1 == 0) {
        a(this.b, arrayOfInt[i1]);
      }
      a(arrayOfInt[i1]);
      i1 += 1;
    }
  }
  
  private void b(Context paramContext, RemoteViews paramRemoteViews, com.gau.go.launcherex.gowidget.weather.model.x paramx)
  {
    int i1 = 196608;
    Object localObject = d(paramContext, paramx);
    if (localObject != null)
    {
      if (this.J != 0) {
        paramRemoteViews.setOnClickPendingIntent(this.J, (PendingIntent)localObject);
      }
      if (this.K != 0) {
        paramRemoteViews.setOnClickPendingIntent(this.K, (PendingIntent)localObject);
      }
      if (this.I != 0) {
        paramRemoteViews.setOnClickPendingIntent(this.I, (PendingIntent)localObject);
      }
      if (this.Q != 0) {
        paramRemoteViews.setOnClickPendingIntent(this.Q, (PendingIntent)localObject);
      }
    }
    if (this.c.size() > 1)
    {
      localObject = new Intent(paramContext, AppWidgetService.class);
      ((Intent)localObject).putExtra("appwidget_service_request", 21);
      ((Intent)localObject).putExtra("request_extra_appwidget_type", 3);
      if (paramx != null)
      {
        ((Intent)localObject).putExtra("extra_appwidget_ids", paramx.a());
        i1 = 196608 + paramx.a();
      }
    }
    for (paramContext = PendingIntent.getService(paramContext, i1, (Intent)localObject, 134217728);; paramContext = (Context)localObject)
    {
      if (paramContext != null)
      {
        if (this.F != 0) {
          paramRemoteViews.setOnClickPendingIntent(this.F, paramContext);
        }
        if (this.G != 0) {
          paramRemoteViews.setOnClickPendingIntent(this.G, paramContext);
        }
        if (this.H != 0) {
          paramRemoteViews.setOnClickPendingIntent(this.H, paramContext);
        }
      }
      return;
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
    int i1;
    int i2;
    if (paramx != null)
    {
      i1 = b(paramx.b());
      i2 = paramx.a();
    }
    for (;;)
    {
      if (i2 == 0) {
        return null;
      }
      RemoteViews localRemoteViews;
      label71:
      int i3;
      if (this.C != 0) {
        if ((TextUtils.isEmpty(a)) || (a.contains("app_widget_theme")))
        {
          localRemoteViews = new RemoteViews(paramContext.getPackageName(), this.C);
          a(paramContext, localRemoteViews, paramx);
          b(paramContext, localRemoteViews, paramx);
          i3 = this.c.size();
          if (i1 >= 0)
          {
            i2 = i1;
            if (i1 < i3) {}
          }
          else
          {
            i2 = 0;
          }
          if (i3 == 0) {
            break label1351;
          }
          paramContext = (WeatherBean)this.c.get(i2);
          if (paramContext == null) {
            break label1351;
          }
          if (this.E != 0)
          {
            localRemoteViews.setViewVisibility(this.E, 8);
            if (this.u != 0) {
              localRemoteViews.setImageViewResource(this.E, this.u);
            }
          }
          if (this.H != 0) {
            localRemoteViews.setViewVisibility(this.H, 8);
          }
          if (this.G != 0) {
            localRemoteViews.setTextViewText(this.G, paramContext.d());
          }
          paramContext = paramContext.k;
          if (this.I != 0)
          {
            if ((!paramContext.e().equals("--")) && (!TextUtils.isEmpty(paramContext.e()))) {
              break label1072;
            }
            localRemoteViews.setTextViewText(this.I, this.i.getString(2131165323));
          }
          label268:
          if ((this.J != 0) && (this.k != null) && (this.k[0] != 0)) {
            localRemoteViews.setImageViewResource(this.J, a(paramContext.d(), paramx));
          }
        }
      }
      label367:
      label510:
      label567:
      label617:
      label673:
      label766:
      label809:
      label1072:
      label1088:
      label1139:
      label1188:
      label1217:
      label1246:
      label1262:
      label1285:
      label1300:
      label1316:
      label1344:
      label1351:
      for (i1 = 1;; i1 = 0)
      {
        if (i1 == 0)
        {
          if (this.I != 0) {
            localRemoteViews.setTextViewText(this.I, "--");
          }
          if (this.G != 0)
          {
            if (this.o) {
              break label1088;
            }
            localRemoteViews.setTextViewText(this.G, this.i.getString(2131166457));
          }
          if (this.H != 0) {
            localRemoteViews.setViewVisibility(this.H, 8);
          }
          if ((this.J != 0) && (this.k != null) && (this.k[0] != 0)) {
            localRemoteViews.setImageViewResource(this.J, a(0, paramx));
          }
        }
        if (i3 != 0)
        {
          paramContext = (WeatherBean)this.c.get(i2);
          if (paramContext == null) {
            break label1344;
          }
        }
        for (i1 = com.gau.go.launcherex.gowidget.weather.util.q.a(paramContext.k.a(this.h));; i1 = 55536)
        {
          if (i1 != 55536)
          {
            if (this.P != 0)
            {
              if (i1 >= 0) {
                break label1139;
              }
              localRemoteViews.setViewVisibility(this.P, 0);
              if (this.v != 0) {
                localRemoteViews.setImageViewResource(this.P, this.v);
              }
            }
            if (this.Q != 0)
            {
              localRemoteViews.setViewVisibility(this.Q, 0);
              if (this.h == 1) {
                localRemoteViews.setTextViewText(this.Q, String.valueOf(i1) + "°C");
              }
            }
            else
            {
              i1 = Math.abs(i1);
              i2 = i1 / 100;
              if ((this.L != 0) && (this.j != null) && (this.j[0] != 0))
              {
                if (i2 != 0) {
                  break label1188;
                }
                localRemoteViews.setViewVisibility(this.L, 8);
              }
              i3 = (i1 - i2 * 100) / 10;
              if ((this.N != 0) && (this.j != null) && (this.j[0] != 0))
              {
                if ((i3 != 0) || (i2 != 0)) {
                  break label1217;
                }
                localRemoteViews.setViewVisibility(this.N, 8);
              }
              if ((this.O != 0) && (this.j != null) && (this.j[0] != 0))
              {
                localRemoteViews.setImageViewResource(this.O, a(i1 % 10, false));
                localRemoteViews.setViewVisibility(this.O, 0);
              }
              if (this.M != 0)
              {
                if ((this.y == 0) || (this.z == 0)) {
                  break label1262;
                }
                if (this.h != 1) {
                  break label1246;
                }
                localRemoteViews.setImageViewResource(this.M, this.y);
              }
            }
          }
          for (i1 = 1;; i1 = 0)
          {
            if (i1 == 0)
            {
              if (this.Q != 0)
              {
                localRemoteViews.setViewVisibility(this.Q, 0);
                if (this.h != 1) {
                  break label1285;
                }
                localRemoteViews.setTextViewText(this.Q, "--°C");
              }
              if ((this.P != 0) && (this.L != 0) && (this.N != 0) && (this.O != 0) && (this.v != 0))
              {
                localRemoteViews.setViewVisibility(this.P, 8);
                localRemoteViews.setViewVisibility(this.L, 8);
                localRemoteViews.setImageViewResource(this.N, this.v);
                localRemoteViews.setViewVisibility(this.N, 0);
                localRemoteViews.setImageViewResource(this.O, this.v);
                localRemoteViews.setViewVisibility(this.O, 0);
                if (this.M != 0)
                {
                  if ((this.y == 0) || (this.z == 0)) {
                    break label1316;
                  }
                  if (this.h != 1) {
                    break label1300;
                  }
                  localRemoteViews.setImageViewResource(this.M, this.y);
                }
              }
            }
            for (;;)
            {
              if (this.R != 0) {
                localRemoteViews.setViewVisibility(this.R, 8);
              }
              com.gtp.a.a.c.c.a(localRemoteViews, 1);
              return localRemoteViews;
              localRemoteViews = new RemoteViews(a, this.C);
              break label71;
              e(paramContext);
              if (this.C == 0) {
                break;
              }
              if ((TextUtils.isEmpty(a)) || (a.contains("app_widget_theme")))
              {
                localRemoteViews = new RemoteViews(paramContext.getPackageName(), this.C);
                break label71;
              }
              localRemoteViews = new RemoteViews(a, this.C);
              break label71;
              localRemoteViews.setTextViewText(this.I, paramContext.e());
              break label268;
              if (this.d)
              {
                localRemoteViews.setTextViewText(this.G, this.i.getString(2131166458));
                break label367;
              }
              localRemoteViews.setTextViewText(this.G, this.i.getString(2131166455));
              break label367;
              localRemoteViews.setViewVisibility(this.P, 8);
              break label510;
              localRemoteViews.setTextViewText(this.Q, String.valueOf(i1) + "°F");
              break label567;
              localRemoteViews.setImageViewResource(this.L, a(i2, false));
              localRemoteViews.setViewVisibility(this.L, 0);
              break label617;
              localRemoteViews.setImageViewResource(this.N, a(i3, false));
              localRemoteViews.setViewVisibility(this.N, 0);
              break label673;
              localRemoteViews.setImageViewResource(this.M, this.z);
              break label766;
              if (this.w == 0) {
                break label766;
              }
              localRemoteViews.setImageViewResource(this.M, this.w);
              break label766;
              localRemoteViews.setTextViewText(this.Q, "--°F");
              break label809;
              localRemoteViews.setImageViewResource(this.M, this.z);
              continue;
              if (this.w != 0) {
                localRemoteViews.setImageViewResource(this.M, this.w);
              }
            }
          }
        }
      }
      i2 = 0;
      i1 = 0;
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
  
  private PendingIntent d(Context paramContext, com.gau.go.launcherex.gowidget.weather.model.x paramx)
  {
    Object localObject = "";
    if (paramx != null) {
      localObject = paramx.b();
    }
    localObject = WeatherDetailActivity.a(this.b, (String)localObject, true, 10, "", -1);
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
      localAppWidgetManager.updateAppWidget(new ComponentName(paramContext, AppWidget21Provider.class), null);
    }
  }
  
  private void e(Context paramContext)
  {
    int i1 = 1;
    Log.d("appwidget_21_helper", "loadThemeRes");
    if (TextUtils.isEmpty(a)) {}
    label89:
    label667:
    label687:
    label737:
    label741:
    for (;;)
    {
      return;
      Object localObject = com.gau.go.launcherex.gowidget.weather.globaltheme.c.d.a(paramContext, a);
      String str;
      f localf;
      if (a.contains("app_widget_theme"))
      {
        str = paramContext.getPackageName();
        this.C = 0;
        localf = f.a(paramContext);
        localf.a(paramContext, str);
        if (!a.contains("app_widget_theme"))
        {
          if (!str.equals(paramContext.getPackageName())) {
            break label667;
          }
          if (i1 != 0)
          {
            this.C = localf.a("z_appwidget_s_provider_ex", str);
            if (this.C == 0) {
              a = "app_widget_theme_white";
            }
          }
        }
        if (this.C == 0)
        {
          str = paramContext.getPackageName();
          this.C = localf.a(com.gau.go.launcherex.gowidget.weather.globaltheme.c.a(2, (String)localObject), str);
        }
        if (this.C == 0) {
          continue;
        }
        this.D = localf.b("goweatherex_widget_s_bg", str);
        this.J = localf.b("goweatherex_widget_s_weather_icon", str);
        this.F = localf.b("goweatherex_widget_s_layout_city", str);
        this.E = localf.b("goweatherex_widget_s_img_next", str);
        this.G = localf.b("goweatherex_widget_s_city_name", str);
        this.H = localf.b("goweatherex_widget_s_text_next_city", str);
        this.I = localf.b("goweatherex_widget_s_weather_desp", str);
        this.K = localf.b("goweatherex_widget_s_layout_now_temp", str);
        this.P = localf.b("goweatherex_widget_s_temp_minus", str);
        this.L = localf.b("goweatherex_widget_s_temp_num_1", str);
        this.N = localf.b("goweatherex_widget_s_temp_num_2", str);
        this.O = localf.b("goweatherex_widget_s_temp_num_3", str);
        this.M = localf.b("goweatherex_widget_s_temp_unit", str);
        this.Q = localf.b("goweatherex_widget_s_text_temp", str);
        this.R = localf.b("goweatherex_widget_s_extreme_icon", str);
        if (a.contains("app_widget_theme")) {
          break label687;
        }
        localObject = "systemwidget_weatherwidget.xml";
        InputStream localInputStream = com.gau.go.launcherex.gowidget.weather.f.g.a(paramContext, str, (String)localObject);
        if (localInputStream != null) {
          break label737;
        }
      }
      for (paramContext = com.gau.go.launcherex.gowidget.weather.f.g.b(paramContext, str, ((String)localObject).replace(".xml", ""));; paramContext = localException)
      {
        if (paramContext == null) {
          break label741;
        }
        localObject = com.gau.go.launcherex.gowidget.weather.f.g.a(paramContext);
        if (this.l == null) {
          this.l = new an();
        }
        an.a = str;
        this.l.a("systemwidget_style", String.valueOf(21));
        if (localObject != null) {
          new am().a((XmlPullParser)localObject, this.l);
        }
        try
        {
          paramContext.close();
          this.B = localf.c(this.l.a("go_weatherex_widget_bg"), str);
          this.A = localf.c(this.l.a("go_weatherex_widget_bg_day"), str);
          this.x = localf.c(this.l.a("go_weatherex_widget_bg_night"), str);
          this.u = localf.c(this.l.a("go_weatherex_widget_change_city"), str);
          this.w = localf.c(this.l.a("go_weatherex_widget_temp_unit"), str);
          this.y = localf.c(this.l.a("go_weatherex_widget_temp_unit_centigrade"), str);
          this.z = localf.c(this.l.a("go_weatherex_widget_temp_unit_fahrenheit"), str);
          this.v = localf.c(this.l.a("go_weatherex_widget_temp_minus"), str);
          i1 = 0;
          for (;;)
          {
            if (i1 < 10)
            {
              this.k[i1] = localf.c(an.c[i1], str);
              i1 += 1;
              continue;
              str = a;
              break;
              try
              {
                paramContext.getPackageManager().getPackageInfo(str, 0);
              }
              catch (Exception localException)
              {
                i1 = 0;
              }
              break label89;
              localObject = com.gau.go.launcherex.gowidget.weather.globaltheme.c.a((String)localObject);
            }
          }
        }
        catch (IOException paramContext)
        {
          for (;;)
          {
            paramContext.printStackTrace();
          }
          i1 = 0;
        }
        while (i1 < 10)
        {
          this.j[i1] = localf.c(an.d[i1], str);
          i1 += 1;
        }
        break;
      }
    }
  }
  
  public void a()
  {
    this.o = false;
    if (this.S != null) {
      this.S = null;
    }
    this.s.b();
    this.b.unregisterReceiver(this.T);
    this.f.clear();
    this.c.clear();
    ab.a(this.b).b(this);
    x.a(this.b).b(this);
    com.gtp.a.a.a.a.a().a("AppWidget21ProviderHelper unregisterReceiver", "插件错误.txt");
    Log.d("appwidget_21_helper", "appwidget_21_helper ==============================> onDestroy");
  }
  
  public void a(Intent paramIntent)
  {
    int i2 = 0;
    int i1 = 0;
    if (paramIntent == null) {}
    do
    {
      Object localObject;
      do
      {
        for (;;)
        {
          return;
          localObject = paramIntent.getAction();
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            Log.d("appwidget_21_helper", "deal_action:" + (String)localObject);
            if (!this.o)
            {
              if (((String)localObject).equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_APPWIDGET21_CITY_CHANGE"))
              {
                this.S = paramIntent;
                return;
              }
              if ((((String)localObject).equals("android.appwidget.action.APPWIDGET_UPDATE")) || (!((String)localObject).equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_WIDGET_ADD_APPWIDGET21"))) {}
            }
            else if ("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_APPWIDGET_ENABLED_UPDATE_PREVIEW".equals(localObject))
            {
              if (paramIntent.getIntExtra("extra_widget_type", 0) == 3)
              {
                this.m = paramIntent.getBooleanExtra("extra_enabled_widget_update_preview", this.m);
                if (this.m)
                {
                  this.n = paramIntent.getStringExtra("extra_app_widget_theme_package");
                  b();
                }
              }
            }
            else
            {
              if ((((String)localObject).equals("android.intent.action.TIME_SET")) || (((String)localObject).equals("android.intent.action.TIME_TICK")) || (((String)localObject).equals("android.intent.action.DATE_CHANGED")) || (((String)localObject).equals("android.intent.action.TIMEZONE_CHANGED")) || (((String)localObject).equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_APPWIDGET_DATA_READY")))
              {
                if (((String)localObject).equals("android.intent.action.TIMEZONE_CHANGED")) {
                  this.s.a();
                }
                b();
                return;
              }
              if (((String)localObject).equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_REFRESH_STARTED"))
              {
                b();
                return;
              }
              if (((String)localObject).equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_APPWIDGET21_CITY_CHANGE"))
              {
                Log.d("appwidget_21_helper", "切换城市 > mAllHasLoaded = " + this.o);
                i2 = this.c.size();
                if (i2 != 0)
                {
                  int i3 = paramIntent.getIntExtra("extra_appwidget_ids", 0);
                  Log.d("appwidget_21_helper", "change city widgetId > " + i3);
                  paramIntent = (com.gau.go.launcherex.gowidget.weather.model.x)this.f.get(i3);
                  if (paramIntent != null)
                  {
                    if (this.S != null) {
                      this.S = null;
                    }
                    Log.d("appwidget_21_helper", "before change cityId > " + paramIntent.b());
                    i3 = b(paramIntent.b());
                    i2 = (i3 + 1) % i2;
                    if (i3 != i2)
                    {
                      localObject = (WeatherBean)this.c.get(i2);
                      if (localObject != null)
                      {
                        if (((WeatherBean)localObject).e() == 2) {
                          i1 = 1;
                        }
                        paramIntent.c(i1);
                        paramIntent.a(((WeatherBean)localObject).c());
                        v.a(this.b).b(paramIntent);
                      }
                      Log.d("appwidget_21_helper", "after change cityId > " + paramIntent.b());
                      b(this.b, paramIntent);
                    }
                  }
                }
              }
              else
              {
                if (((String)localObject).equals("appwidget_language_change"))
                {
                  this.i = com.gau.go.launcherex.gowidget.language.d.a(this.b).a();
                  if (this.i == null) {
                    this.i = this.b.getResources();
                  }
                  b();
                  return;
                }
                if ((((String)localObject).equals("android.appwidget.action.APPWIDGET_UPDATE")) || (((String)localObject).equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_WIDGET_ADD_APPWIDGET21")))
                {
                  b();
                  return;
                }
                if (!((String)localObject).equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_WIDGET_DELETE_APPWIDGET21")) {
                  break;
                }
                if (AppWidgetManager.getInstance(this.b).getAppWidgetIds(new ComponentName(this.b, AppWidget21Provider.class)).length == 0)
                {
                  this.f.clear();
                  return;
                }
                paramIntent = paramIntent.getIntArrayExtra("extra_appwidget_ids");
                if (paramIntent != null)
                {
                  i1 = i2;
                  while (i1 < paramIntent.length)
                  {
                    this.f.remove(paramIntent[i1]);
                    i1 += 1;
                  }
                }
              }
            }
          }
        }
      } while (!((String)localObject).equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_INITIALIZED_CITY"));
      i1 = paramIntent.getIntExtra("city_location_state", 3);
      paramIntent = paramIntent.getStringExtra("city_location_id");
    } while ((i1 == 4) && (!TextUtils.isEmpty(paramIntent)));
    this.d = false;
    b();
  }
  
  public void a(com.gau.go.launcherex.gowidget.weather.model.q paramq)
  {
    boolean bool = false;
    this.h = paramq.g;
    this.t = paramq.J;
    if (this.t)
    {
      com.gau.go.launcherex.gowidget.weather.c.g localg = this.s;
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
        e(this.b);
      }
      if (!this.q) {
        this.q = true;
      }
      if ((!this.o) && (this.p) && (this.q))
      {
        this.o = true;
        b();
      }
      return;
      this.s.a(false);
    }
  }
  
  public void a(String paramString, com.gau.go.launcherex.gowidget.weather.model.q paramq)
  {
    Log.d("appwidget_21_helper", "onLoadSettingBeanDone_key = " + paramString);
    if (TextUtils.isEmpty(paramString))
    {
      a(paramq);
      return;
    }
    b(paramString, paramq);
  }
  
  public void a(ArrayList paramArrayList)
  {
    Log.d("appwidget_21_helper", "onLoadWeatherBeanDone");
    b(paramArrayList);
    if (this.o) {
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
        if (!this.t) {
          break label51;
        }
        this.s.a(bool1);
        label40:
        b();
      }
    }
    label51:
    label95:
    do
    {
      int i1;
      do
      {
        return;
        bool1 = false;
        break;
        this.s.a(false);
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
          d(this.b);
        }
        e(this.b);
        b();
        return;
      }
    } while (!paramString.equals("Google_play_billing"));
    this.t = paramq.J;
    if (this.t)
    {
      paramString = this.s;
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
      this.s.a(false);
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
    if (!this.p) {
      this.p = true;
    }
    if ((!this.o) && (this.p) && (this.q))
    {
      this.o = true;
      b();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/systemwidget/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */