package com.gau.go.launcherex.gowidget.weather.util;

import android.content.ContentProviderOperation;
import android.content.ContentProviderOperation.Builder;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.os.Environment;
import android.text.TextUtils;
import com.gau.go.launcherex.gowidget.statistics.y;
import com.gau.go.launcherex.gowidget.weather.model.ExtremeCityIdBean;
import com.gau.go.launcherex.gowidget.weather.model.NowBean;
import com.gau.go.launcherex.gowidget.weather.model.RequestBean;
import com.gau.go.launcherex.gowidget.weather.model.WeatherBean;
import com.gau.go.launcherex.gowidget.weather.model.q;
import com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider;
import com.gau.go.launcherex.gowidget.weather.service.NotifyService;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class f
  extends com.gau.go.launcherex.gowidget.weather.c.b
{
  private static f b = null;
  private Context a = null;
  private i c = null;
  private Map d = new HashMap();
  private com.gau.go.launcherex.gowidget.weather.c.e e;
  private q f;
  private j g;
  
  private f(Context paramContext)
  {
    this.a = paramContext;
    this.g = new j(this);
    paramContext = new IntentFilter("android.intent.action.LOCALE_CHANGED");
    this.a.registerReceiver(this.g, paramContext);
    this.c = new i(this, this.a.getContentResolver());
  }
  
  private ContentValues a(com.jiubang.goweather.a.a parama)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("cityName", parama.c());
    String str = parama.a();
    if ((str != null) && (str.length() > 0)) {
      localContentValues.put("state", str);
    }
    str = parama.b();
    if ((str != null) && (str.length() > 0)) {
      localContentValues.put("country", str);
    }
    localContentValues.put("cityId", parama.d());
    localContentValues.put("updateTime", Long.valueOf(parama.m()));
    localContentValues.put("tz_offset", Integer.valueOf(parama.t()));
    localContentValues.put("latitude", Float.valueOf(parama.e()));
    localContentValues.put("longitude", Float.valueOf(parama.f()));
    localContentValues.put("hasRadar", Integer.valueOf(parama.g()));
    localContentValues.put("hasSatellite", Integer.valueOf(parama.h()));
    localContentValues.put("northeast", parama.j());
    localContentValues.put("southwest", parama.l());
    localContentValues.put("cityJsonString", parama.v());
    localContentValues.put("timestamp", Long.valueOf(parama.n()));
    parama = parama.p();
    localContentValues.put("sequence", Integer.valueOf(0));
    localContentValues.put("city_my_location", Integer.valueOf(1));
    localContentValues.put("nowDesp", parama.t());
    localContentValues.put("type", Integer.valueOf(parama.u()));
    localContentValues.put("nowTempValue", Float.valueOf(r.a(parama.v())));
    localContentValues.put("lowTempValue", Float.valueOf(r.a(parama.s())));
    localContentValues.put("highTempValue", Float.valueOf(r.a(parama.r())));
    localContentValues.put("humidityValue", Integer.valueOf(parama.w()));
    localContentValues.put("windDirection", parama.q());
    localContentValues.put("windStrength", parama.h());
    localContentValues.put("windStrengthValue", Float.valueOf(parama.f()));
    localContentValues.put("windType", Integer.valueOf(parama.g()));
    localContentValues.put("barometerValue", Float.valueOf(parama.k()));
    localContentValues.put("visibilityValue", Float.valueOf(parama.j()));
    localContentValues.put("dewpointValue", Float.valueOf(parama.l()));
    localContentValues.put("uvIndexValue", Float.valueOf(parama.m()));
    localContentValues.put("sunrise", parama.n());
    localContentValues.put("sunset", parama.o());
    localContentValues.put("pop", Integer.valueOf(parama.p()));
    localContentValues.put("rainFall", Float.valueOf(parama.x()));
    localContentValues.put("feelslikeValue", Float.valueOf(parama.i()));
    return localContentValues;
  }
  
  private WeatherBean a(String paramString1, String paramString2, int paramInt)
  {
    WeatherBean localWeatherBean = new WeatherBean();
    localWeatherBean.e(this.d.size());
    localWeatherBean.a(paramInt);
    localWeatherBean.c(paramString1);
    localWeatherBean.e(paramString2);
    localWeatherBean.h();
    localWeatherBean.g();
    localWeatherBean.i();
    localWeatherBean.j();
    this.d.put(paramString1, localWeatherBean);
    return localWeatherBean;
  }
  
  public static f a(Context paramContext)
  {
    try
    {
      if (b == null) {
        b = new f(paramContext);
      }
      paramContext = b;
      return paramContext;
    }
    finally {}
  }
  
  private void a(int paramInt1, int paramInt2, ArrayList paramArrayList1, ArrayList paramArrayList2, int paramInt3, int paramInt4)
  {
    Intent localIntent = new Intent("com.gau.go.launcherex.gowidget.weatherwidget.goweather.ACTION_UPDATE_DATA");
    localIntent.putExtra("weather_update_status", paramInt1);
    localIntent.putExtra("weather_update_errorcode", paramInt2);
    localIntent.putExtra("update_weather_data", paramArrayList1);
    localIntent.putExtra("weather_status", paramArrayList2);
    localIntent.putExtra("weather_update_way", paramInt3);
    localIntent.putExtra("request", paramInt4);
    this.a.sendBroadcast(localIntent);
  }
  
  private void a(com.jiubang.goweather.a.a parama, WeatherBean paramWeatherBean, ArrayList paramArrayList)
  {
    int j = parama.s();
    int i = 0;
    while (i < j)
    {
      Object localObject = parama.e(i);
      int k = ((com.jiubang.goweather.a.b)localObject).i();
      if ((paramWeatherBean.d(k) == null) && (!r.c(((com.jiubang.goweather.a.b)localObject).b())))
      {
        localObject = new ExtremeCityIdBean();
        ((ExtremeCityIdBean)localObject).a(parama.d());
        ((ExtremeCityIdBean)localObject).a(k);
        paramArrayList.add(localObject);
      }
      i += 1;
    }
  }
  
  private void b(ArrayList paramArrayList)
  {
    int j = 1;
    Object localObject1;
    if (paramArrayList != null)
    {
      localObject1 = this.f.F;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label265;
      }
      if (((String)localObject1).contains("#")) {
        localObject1 = ((String)localObject1).split("#");
      }
    }
    for (;;)
    {
      if ((localObject1 != null) && (localObject1.length > 0))
      {
        Object localObject2 = new ArrayList();
        int i = 0;
        for (;;)
        {
          if (i < localObject1.length)
          {
            ((ArrayList)localObject2).add(localObject1[i]);
            i += 1;
            continue;
            localObject1 = new String[] { localObject1 };
            break;
          }
        }
        paramArrayList = paramArrayList.iterator();
        while (paramArrayList.hasNext()) {
          ((ArrayList)localObject2).remove((String)paramArrayList.next());
        }
        if (((ArrayList)localObject2).size() < localObject1.length)
        {
          paramArrayList = new StringBuffer();
          localObject1 = ((ArrayList)localObject2).iterator();
          i = j;
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = (String)((Iterator)localObject1).next();
            if (i != 0)
            {
              paramArrayList.append((String)localObject2);
              i = 0;
            }
            for (;;)
            {
              break;
              paramArrayList.append("#" + (String)localObject2);
            }
          }
          paramArrayList = paramArrayList.toString();
          this.e.b(paramArrayList);
          this.e.a(WeatherContentProvider.g, "setting_key", "no_alerts_cities", "setting_value", paramArrayList);
        }
      }
      return;
      label265:
      localObject1 = null;
    }
  }
  
  /* Error */
  private ArrayList c(Cursor paramCursor)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: iconst_0
    //   3: istore_3
    //   4: iconst_0
    //   5: istore 4
    //   7: aload_1
    //   8: invokeinterface 459 1 0
    //   13: istore 5
    //   15: iload 5
    //   17: ifeq +95 -> 112
    //   20: iload 4
    //   22: istore_3
    //   23: new 273	com/gau/go/launcherex/gowidget/weather/model/WeatherBean
    //   26: dup
    //   27: invokespecial 274	com/gau/go/launcherex/gowidget/weather/model/WeatherBean:<init>	()V
    //   30: astore 6
    //   32: aload 6
    //   34: aload_1
    //   35: invokevirtual 461	com/gau/go/launcherex/gowidget/weather/model/WeatherBean:a	(Landroid/database/Cursor;)V
    //   38: aload 6
    //   40: invokevirtual 462	com/gau/go/launcherex/gowidget/weather/model/WeatherBean:c	()Ljava/lang/String;
    //   43: astore 7
    //   45: aload 7
    //   47: invokestatic 387	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   50: ifne +158 -> 208
    //   53: aload_0
    //   54: getfield 36	com/gau/go/launcherex/gowidget/weather/util/f:d	Ljava/util/Map;
    //   57: aload 7
    //   59: invokeinterface 466 2 0
    //   64: checkcast 273	com/gau/go/launcherex/gowidget/weather/model/WeatherBean
    //   67: astore 8
    //   69: aload 8
    //   71: ifnull +82 -> 153
    //   74: aload 8
    //   76: invokevirtual 468	com/gau/go/launcherex/gowidget/weather/model/WeatherBean:e	()I
    //   79: iconst_2
    //   80: if_icmpne +13 -> 93
    //   83: aload 8
    //   85: aload 6
    //   87: invokevirtual 470	com/gau/go/launcherex/gowidget/weather/model/WeatherBean:q	()I
    //   90: invokevirtual 282	com/gau/go/launcherex/gowidget/weather/model/WeatherBean:e	(I)V
    //   93: iload_3
    //   94: istore_2
    //   95: iload_2
    //   96: istore_3
    //   97: aload_1
    //   98: invokeinterface 473 1 0
    //   103: istore 5
    //   105: iload_2
    //   106: istore_3
    //   107: iload 5
    //   109: ifne -86 -> 23
    //   112: aload_1
    //   113: invokeinterface 476 1 0
    //   118: iload_2
    //   119: ifeq +110 -> 229
    //   122: new 363	java/util/ArrayList
    //   125: dup
    //   126: invokespecial 397	java/util/ArrayList:<init>	()V
    //   129: astore_1
    //   130: aload_1
    //   131: getstatic 478	com/gau/go/launcherex/gowidget/weather/provider/WeatherContentProvider:a	Landroid/net/Uri;
    //   134: invokestatic 484	android/content/ContentProviderOperation:newDelete	(Landroid/net/Uri;)Landroid/content/ContentProviderOperation$Builder;
    //   137: ldc_w 486
    //   140: aconst_null
    //   141: invokevirtual 492	android/content/ContentProviderOperation$Builder:withSelection	(Ljava/lang/String;[Ljava/lang/String;)Landroid/content/ContentProviderOperation$Builder;
    //   144: invokevirtual 496	android/content/ContentProviderOperation$Builder:build	()Landroid/content/ContentProviderOperation;
    //   147: invokevirtual 367	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   150: pop
    //   151: aload_1
    //   152: areturn
    //   153: aload 6
    //   155: invokevirtual 292	com/gau/go/launcherex/gowidget/weather/model/WeatherBean:g	()V
    //   158: aload 6
    //   160: invokevirtual 290	com/gau/go/launcherex/gowidget/weather/model/WeatherBean:h	()V
    //   163: aload 6
    //   165: invokevirtual 296	com/gau/go/launcherex/gowidget/weather/model/WeatherBean:j	()V
    //   168: aload 6
    //   170: invokevirtual 294	com/gau/go/launcherex/gowidget/weather/model/WeatherBean:i	()V
    //   173: aload_0
    //   174: getfield 36	com/gau/go/launcherex/gowidget/weather/util/f:d	Ljava/util/Map;
    //   177: aload 7
    //   179: aload 6
    //   181: invokeinterface 299 3 0
    //   186: pop
    //   187: goto -94 -> 93
    //   190: astore 6
    //   192: aload 6
    //   194: invokevirtual 499	java/lang/Exception:printStackTrace	()V
    //   197: aload_1
    //   198: invokeinterface 476 1 0
    //   203: iload_3
    //   204: istore_2
    //   205: goto -87 -> 118
    //   208: iconst_1
    //   209: istore_2
    //   210: goto -115 -> 95
    //   213: astore 6
    //   215: aload_1
    //   216: invokeinterface 476 1 0
    //   221: aload 6
    //   223: athrow
    //   224: astore 6
    //   226: goto -34 -> 192
    //   229: aconst_null
    //   230: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	231	0	this	f
    //   0	231	1	paramCursor	Cursor
    //   1	209	2	i	int
    //   3	201	3	j	int
    //   5	16	4	k	int
    //   13	95	5	bool	boolean
    //   30	150	6	localWeatherBean1	WeatherBean
    //   190	3	6	localException1	Exception
    //   213	9	6	localObject	Object
    //   224	1	6	localException2	Exception
    //   43	135	7	str	String
    //   67	17	8	localWeatherBean2	WeatherBean
    // Exception table:
    //   from	to	target	type
    //   23	69	190	java/lang/Exception
    //   74	93	190	java/lang/Exception
    //   153	187	190	java/lang/Exception
    //   7	15	213	finally
    //   23	69	213	finally
    //   74	93	213	finally
    //   97	105	213	finally
    //   153	187	213	finally
    //   192	197	213	finally
    //   7	15	224	java/lang/Exception
    //   97	105	224	java/lang/Exception
  }
  
  private void d(Cursor paramCursor)
  {
    try
    {
      if (paramCursor.moveToFirst())
      {
        int i = paramCursor.getColumnIndex("cityId");
        boolean bool;
        do
        {
          Object localObject1 = paramCursor.getString(i);
          localObject1 = (WeatherBean)this.d.get(localObject1);
          if (localObject1 != null) {
            ((WeatherBean)localObject1).b(paramCursor);
          }
          bool = paramCursor.moveToNext();
        } while (bool);
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return;
    }
    finally
    {
      paramCursor.close();
    }
  }
  
  private void e(Cursor paramCursor)
  {
    try
    {
      if (paramCursor.moveToFirst())
      {
        int i = paramCursor.getColumnIndex("cityId");
        boolean bool;
        do
        {
          Object localObject1 = paramCursor.getString(i);
          localObject1 = (WeatherBean)this.d.get(localObject1);
          if (localObject1 != null) {
            ((WeatherBean)localObject1).c(paramCursor);
          }
          bool = paramCursor.moveToNext();
        } while (bool);
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return;
    }
    finally
    {
      paramCursor.close();
    }
  }
  
  private void f(Cursor paramCursor)
  {
    try
    {
      if (paramCursor.moveToFirst())
      {
        boolean bool;
        do
        {
          com.gau.go.launcherex.gowidget.weather.model.c localc = WeatherBean.d(paramCursor);
          WeatherBean localWeatherBean = (WeatherBean)this.d.get(localc.j());
          if (localWeatherBean != null)
          {
            localc.a(r.c(localc.d()));
            localWeatherBean.l.put(Integer.valueOf(localc.k()), localc);
          }
          bool = paramCursor.moveToNext();
        } while (bool);
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return;
    }
    finally
    {
      paramCursor.close();
    }
  }
  
  private boolean m()
  {
    boolean bool = false;
    com.jiubang.goweather.a.a locala = com.gau.go.launcherex.gowidget.weather.c.a.a(this.a);
    if (locala != null)
    {
      bool = true;
      ContentValues localContentValues = a(locala);
      this.c.a(13, locala, WeatherContentProvider.a, localContentValues);
    }
    return bool;
  }
  
  private void n()
  {
    this.c.a(3, null, WeatherContentProvider.e, com.gau.go.launcherex.gowidget.weather.e.i.a(), null, null, "cityId");
  }
  
  public int a(String paramString, ArrayList paramArrayList)
  {
    int j = paramArrayList.size();
    if ((j > 1) && (!"".equals(paramString)))
    {
      int i = 0;
      while (i < j)
      {
        if (((WeatherBean)paramArrayList.get(i)).c().equals(paramString)) {
          return i;
        }
        i += 1;
      }
    }
    return 0;
  }
  
  public com.gau.go.launcherex.gowidget.weather.c.g a()
  {
    return com.gau.go.launcherex.gowidget.weather.c.c.a(this.a).g();
  }
  
  public WeatherBean a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return (WeatherBean)this.d.get(paramString);
    }
    return null;
  }
  
  public void a(int paramInt1, int paramInt2, List paramList, int paramInt3, int paramInt4)
  {
    if (paramList.isEmpty()) {}
    ArrayList localArrayList;
    do
    {
      return;
      localArrayList = new ArrayList();
      Object localObject1 = new ArrayList();
      int j = paramList.size();
      int i = 0;
      Object localObject3;
      if (i < j)
      {
        localObject2 = (com.jiubang.goweather.a.a)paramList.get(i);
        localObject3 = (WeatherBean)this.d.get(((com.jiubang.goweather.a.a)localObject2).c);
        if (localObject3 != null) {
          if (((com.jiubang.goweather.a.a)localObject2).a == 1)
          {
            a((com.jiubang.goweather.a.a)localObject2, (WeatherBean)localObject3, localArrayList);
            ((WeatherBean)localObject3).a((com.jiubang.goweather.a.a)localObject2, ((com.jiubang.goweather.a.a)localObject2).c);
          }
        }
        for (;;)
        {
          i += 1;
          break;
          ((ArrayList)localObject1).add(localObject2);
        }
      }
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        paramList.remove((com.jiubang.goweather.a.a)((Iterator)localObject1).next());
      }
      localObject1 = new ArrayList();
      Object localObject2 = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject3 = (com.jiubang.goweather.a.a)paramList.next();
        ((ArrayList)localObject1).add(((com.jiubang.goweather.a.a)localObject3).c);
        ((ArrayList)localObject2).add(Integer.valueOf(((com.jiubang.goweather.a.a)localObject3).a));
      }
      a(paramInt1, paramInt2, (ArrayList)localObject1, (ArrayList)localObject2, paramInt3, paramInt4);
    } while (localArrayList.isEmpty());
    paramList = new Intent("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_UPDATE_EXTREME_WEATHER");
    paramList.putParcelableArrayListExtra("extra_extreme_city_ids", localArrayList);
    this.a.sendBroadcast(paramList);
  }
  
  public void a(Cursor paramCursor)
  {
    try
    {
      if (paramCursor.moveToFirst())
      {
        int i = paramCursor.getColumnIndex("cityId");
        boolean bool;
        do
        {
          Object localObject1 = paramCursor.getString(i);
          localObject1 = (WeatherBean)this.d.get(localObject1);
          if (localObject1 != null) {
            ((WeatherBean)localObject1).f(paramCursor);
          }
          bool = paramCursor.moveToNext();
        } while (bool);
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return;
    }
    finally
    {
      paramCursor.close();
    }
  }
  
  public void a(WeatherBean paramWeatherBean, ArrayList paramArrayList)
  {
    paramWeatherBean = paramWeatherBean.l.entrySet().iterator();
    while (paramWeatherBean.hasNext())
    {
      Object localObject = (Map.Entry)paramWeatherBean.next();
      ExtremeCityIdBean localExtremeCityIdBean = new ExtremeCityIdBean();
      localObject = (com.gau.go.launcherex.gowidget.weather.model.c)((Map.Entry)localObject).getValue();
      localExtremeCityIdBean.a(((com.gau.go.launcherex.gowidget.weather.model.c)localObject).j());
      localExtremeCityIdBean.a(((com.gau.go.launcherex.gowidget.weather.model.c)localObject).k());
      paramArrayList.add(localExtremeCityIdBean);
    }
  }
  
  public void a(com.gau.go.launcherex.gowidget.weather.model.b paramb)
  {
    WeatherBean localWeatherBean = (WeatherBean)this.d.get(paramb.a());
    Object localObject = g();
    int i;
    if (localWeatherBean != null) {
      if (localObject != null) {
        if (!paramb.a().equals(((WeatherBean)localObject).c()))
        {
          i = ((WeatherBean)localObject).e();
          if (i == 3)
          {
            ((WeatherBean)localObject).a(1);
            localWeatherBean.a(3);
          }
        }
        else
        {
          label72:
          if (this.f.o == 2)
          {
            this.e.a(this.f.m, this.f.p, paramb.a(), this.f.o, this.f.C);
            this.e.c();
          }
          if (localWeatherBean == null) {
            break label401;
          }
          localObject = localWeatherBean.c();
          paramb = localWeatherBean.d();
        }
      }
    }
    for (long l = localWeatherBean.k.g();; l = 0L)
    {
      a((String)localObject, paramb, l);
      return;
      if (i != 2) {
        break;
      }
      this.d.remove(((WeatherBean)localObject).c());
      break;
      localWeatherBean.a(3);
      break label72;
      if (localObject != null)
      {
        i = ((WeatherBean)localObject).e();
        if (i == 2)
        {
          this.d.remove(((WeatherBean)localObject).c());
          ((WeatherBean)localObject).c(paramb.a());
          ((WeatherBean)localObject).e(paramb.b());
          ((WeatherBean)localObject).a(paramb.d());
          ((WeatherBean)localObject).b(paramb.c());
          ((WeatherBean)localObject).k.l(paramb.h());
          ((WeatherBean)localObject).k.k(paramb.j());
          ((WeatherBean)localObject).k.q(paramb.i());
          ((WeatherBean)localObject).k.r(paramb.k());
          ((WeatherBean)localObject).f();
          ((WeatherBean)localObject).g();
          ((WeatherBean)localObject).i();
          ((WeatherBean)localObject).j();
          ((WeatherBean)localObject).h();
          this.d.put(paramb.a(), localObject);
          break label72;
        }
        if (i != 3) {
          break label72;
        }
        ((WeatherBean)localObject).a(1);
        a(paramb.a(), paramb.b(), 2);
        break label72;
      }
      a(paramb.a(), paramb.b(), 2);
      break label72;
      label401:
      localObject = paramb.a();
      paramb = paramb.b();
    }
  }
  
  public void a(com.gau.go.launcherex.gowidget.weather.model.b paramb, int paramInt1, int paramInt2)
  {
    Object localObject = a(paramb.a());
    if (localObject == null)
    {
      localObject = new WeatherBean();
      ((WeatherBean)localObject).e(paramInt1);
      ((WeatherBean)localObject).c(paramb.a());
      ((WeatherBean)localObject).d(paramb.a());
      ((WeatherBean)localObject).e(paramb.b());
      ((WeatherBean)localObject).a(paramb.d());
      ((WeatherBean)localObject).b(paramb.c());
      ((WeatherBean)localObject).a(1);
      ((WeatherBean)localObject).k.l(paramb.h());
      ((WeatherBean)localObject).k.k(paramb.j());
      ((WeatherBean)localObject).k.q(paramb.i());
      ((WeatherBean)localObject).k.r(paramb.k());
      ((WeatherBean)localObject).k.h(paramb.e());
      ((WeatherBean)localObject).h();
      ((WeatherBean)localObject).g();
      ((WeatherBean)localObject).i();
      ((WeatherBean)localObject).j();
      this.d.put(paramb.a(), localObject);
      localObject = new Intent("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_ADD_CITY");
      ((Intent)localObject).putExtra("city_code", paramb.a());
      ((Intent)localObject).putExtra("city_name", paramb.b());
      ((Intent)localObject).putExtra("city_index", paramInt1);
      ((Intent)localObject).putExtra("gowidget_Id", paramInt2);
      this.a.sendBroadcast((Intent)localObject);
      return;
    }
    ((WeatherBean)localObject).a(3);
  }
  
  public void a(com.gau.go.launcherex.gowidget.weather.model.c paramc)
  {
    Object localObject = new ContentValues();
    ((ContentValues)localObject).put("cityId", paramc.j());
    ((ContentValues)localObject).put("description", paramc.f());
    ((ContentValues)localObject).put("exp_time", paramc.d());
    ((ContentValues)localObject).put("level", Integer.valueOf(paramc.h()));
    ((ContentValues)localObject).put("message", paramc.i());
    ((ContentValues)localObject).put("phenomena", paramc.g());
    ((ContentValues)localObject).put("publish_time", paramc.c());
    ((ContentValues)localObject).put("type", paramc.e());
    ((ContentValues)localObject).put("alert_id", Integer.valueOf(paramc.k()));
    ((ContentValues)localObject).put("tz_offset", Integer.valueOf(paramc.a()));
    ((ContentValues)localObject).put("has_read", Integer.valueOf(0));
    this.c.a(0, null, WeatherContentProvider.k, (ContentValues)localObject);
    WeatherBean localWeatherBean = (WeatherBean)this.d.get(paramc.j());
    if (r.c(paramc.d())) {
      paramc.a(true);
    }
    if (localWeatherBean != null)
    {
      localObject = new ExtremeCityIdBean();
      ((ExtremeCityIdBean)localObject).a(paramc.j());
      ((ExtremeCityIdBean)localObject).a(paramc.k());
      if (!paramc.b())
      {
        localWeatherBean.l.put(Integer.valueOf(paramc.k()), paramc);
        paramc = new ArrayList();
        paramc.add(localObject);
        localObject = new Intent("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_UPDATE_EXTREME_WEATHER");
        ((Intent)localObject).putParcelableArrayListExtra("extra_extreme_city_ids", paramc);
        this.a.sendBroadcast((Intent)localObject);
      }
    }
  }
  
  public void a(o paramo)
  {
    super.a(paramo);
    this.e = com.gau.go.launcherex.gowidget.weather.c.c.a(this.a).f();
    this.f = this.e.a();
    this.c.a(2, null, WeatherContentProvider.a, com.gau.go.launcherex.gowidget.weather.e.b.a(), null, null, null);
  }
  
  public void a(String paramString, com.gau.go.launcherex.gowidget.weather.model.c paramc)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("exp_time", paramc.d());
    localContentValues.put("type", paramc.e());
    localContentValues.put("description", paramc.f());
    localContentValues.put("phenomena", paramc.g());
    localContentValues.put("publish_time", paramc.c());
    localContentValues.put("level", Integer.valueOf(paramc.h()));
    localContentValues.put("tz_offset", Integer.valueOf(paramc.a()));
    localContentValues.put("message", paramc.i());
    if (paramc.m()) {}
    for (int i = 1;; i = 0)
    {
      localContentValues.put("has_read", Integer.valueOf(i));
      this.c.a(0, null, WeatherContentProvider.k, localContentValues, "alert_id=" + paramc.k() + " and " + "cityId" + "='" + paramString + "'", null);
      return;
    }
  }
  
  public void a(String paramString1, String paramString2, long paramLong)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(new RequestBean(paramString1, paramString2, paramLong));
      paramString1 = new Intent("com.gau.go.launcherex.gowidget.weather.service.NotifyService");
      paramString1.putExtra("notify_request", 21);
      paramString1.putParcelableArrayListExtra("req_arg", localArrayList);
      this.a.startService(paramString1);
    }
  }
  
  public void a(ArrayList paramArrayList)
  {
    String str = com.go.weatherex.city.c.a().b();
    int k = b(str);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Object localObject1 = paramArrayList.iterator();
    Object localObject3;
    while (((Iterator)localObject1).hasNext())
    {
      localObject3 = (String)((Iterator)localObject1).next();
      localObject4 = (WeatherBean)this.d.remove(localObject3);
      if (localObject4 != null)
      {
        String[] arrayOfString = new String[1];
        arrayOfString[0] = localObject3;
        localArrayList1.add(ContentProviderOperation.newDelete(WeatherContentProvider.a).withSelection("cityId=?", arrayOfString).build());
        localArrayList1.add(ContentProviderOperation.newDelete(WeatherContentProvider.b).withSelection("cityId=?", arrayOfString).build());
        localArrayList1.add(ContentProviderOperation.newDelete(WeatherContentProvider.f).withSelection("cityId=?", arrayOfString).build());
        localArrayList1.add(ContentProviderOperation.newDelete(WeatherContentProvider.e).withSelection("cityId=?", arrayOfString).build());
        localArrayList1.add(ContentProviderOperation.newDelete(WeatherContentProvider.k).withSelection("cityId=?", arrayOfString).build());
        if (((WeatherBean)localObject4).o() > 0) {
          a((WeatherBean)localObject4, localArrayList2);
        }
        if (this.f.n.equals(localObject3)) {
          this.e.d();
        }
        com.gau.go.launcherex.gowidget.gcm.b.a(this.a).a((String)localObject3);
        d((String)localObject3);
      }
    }
    b(paramArrayList);
    Object localObject4 = d();
    int m = ((ArrayList)localObject4).size();
    localObject1 = new ContentValues();
    int i = 0;
    while (i < m)
    {
      localObject3 = (WeatherBean)((ArrayList)localObject4).get(i);
      ((WeatherBean)localObject3).e(i);
      ((ContentValues)localObject1).put("sequence", Integer.valueOf(i));
      localArrayList1.add(ContentProviderOperation.newUpdate(WeatherContentProvider.a).withValues((ContentValues)localObject1).withSelection("cityId='" + ((WeatherBean)localObject3).c() + "'", null).build());
      i += 1;
    }
    if (paramArrayList.contains(str)) {
      if (k >= m - 1) {
        i = m - 1;
      }
    }
    Object localObject2;
    for (localObject1 = ((WeatherBean)((ArrayList)localObject4).get(i)).c();; localObject2 = str)
    {
      localObject3 = localObject1;
      int j = i;
      if (i == -1) {
        try
        {
          throw new IndexOutOfBoundsException("[size]=" + m + "|[currentIdx]=" + k + "|[currentCityId]=" + str + "|[newCurIdx]=" + i + "|[newCurCityId]=" + (String)localObject1);
        }
        catch (Exception localException)
        {
          localObject3 = new Intent(this.a, NotifyService.class);
          ((Intent)localObject3).putExtra("notify_request", 38);
          ((Intent)localObject3).putExtra("request_extra_runtime_crash_title", "Error : DataManager.java:972");
          ((Intent)localObject3).putExtra("request_extra_runtime_crash_text", y.a(localException, "#"));
          this.a.startService((Intent)localObject3);
          localObject3 = ((WeatherBean)((ArrayList)localObject4).get(0)).c();
          j = 0;
        }
      }
      if (!localArrayList1.isEmpty()) {
        this.c.a(11, new h(this, paramArrayList, j, (String)localObject3), "com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider", localArrayList1);
      }
      if (!localArrayList2.isEmpty()) {
        this.e.a(localArrayList2);
      }
      this.e.b(paramArrayList);
      return;
      i = k;
      break;
      localObject2 = paramArrayList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (String)((Iterator)localObject2).next();
        this.d.remove(localObject3);
      }
      i = ((ArrayList)localObject4).indexOf(a(str));
    }
  }
  
  public int b(String paramString)
  {
    paramString = a(paramString);
    if (paramString != null) {
      return paramString.q();
    }
    return -1;
  }
  
  public void b()
  {
    this.a.unregisterReceiver(this.g);
  }
  
  public void b(Cursor paramCursor)
  {
    try
    {
      if (paramCursor.moveToFirst())
      {
        int i = paramCursor.getColumnIndex("cityId");
        boolean bool;
        do
        {
          Object localObject1 = paramCursor.getString(i);
          localObject1 = (WeatherBean)this.d.get(localObject1);
          if (localObject1 != null) {
            ((WeatherBean)localObject1).e(paramCursor);
          }
          bool = paramCursor.moveToNext();
        } while (bool);
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return;
    }
    finally
    {
      paramCursor.close();
    }
  }
  
  public void b(String paramString, com.gau.go.launcherex.gowidget.weather.model.c paramc)
  {
    if ((paramc != null) && (this.d != null))
    {
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("has_read", Integer.valueOf(1));
      Object localObject = (WeatherBean)this.d.get(paramString);
      if (localObject != null)
      {
        localObject = ((WeatherBean)localObject).d(paramc.k());
        if (localObject != null) {
          ((com.gau.go.launcherex.gowidget.weather.model.c)localObject).c(true);
        }
        this.c.a(0, null, WeatherContentProvider.k, localContentValues, "alert_id=" + paramc.k() + " and " + "cityId" + "='" + paramString + "'", null);
      }
    }
  }
  
  public Map c()
  {
    return this.d;
  }
  
  public boolean c(String paramString)
  {
    return this.d.remove(paramString) != null;
  }
  
  public ArrayList d()
  {
    Object localObject = this.d.entrySet();
    ArrayList localArrayList = new ArrayList();
    localObject = ((Set)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList.add(((Map.Entry)((Iterator)localObject).next()).getValue());
    }
    Collections.sort(localArrayList, new g(this));
    return localArrayList;
  }
  
  public void d(String paramString)
  {
    File localFile = new File(Environment.getExternalStorageDirectory(), "/GOWeatherEX/download/maps" + File.separator + "radar_" + paramString + ".png");
    if ((localFile != null) && (localFile.exists())) {
      localFile.delete();
    }
    paramString = new File(Environment.getExternalStorageDirectory(), "/GOWeatherEX/download/maps" + File.separator + "satellite_" + paramString + ".png");
    if ((paramString != null) && (paramString.exists())) {
      paramString.delete();
    }
  }
  
  public int e()
  {
    return this.d.size();
  }
  
  public String e(String paramString)
  {
    paramString = (WeatherBean)this.d.get(paramString);
    if (paramString != null) {
      return paramString.d();
    }
    return null;
  }
  
  public ArrayList f()
  {
    return new ArrayList(this.d.values());
  }
  
  public boolean f(String paramString)
  {
    return this.d.get(paramString) != null;
  }
  
  public WeatherBean g()
  {
    if (!this.d.isEmpty())
    {
      Iterator localIterator = this.d.values().iterator();
      while (localIterator.hasNext())
      {
        WeatherBean localWeatherBean = (WeatherBean)localIterator.next();
        if (localWeatherBean.e() != 1) {
          return localWeatherBean;
        }
      }
    }
    return null;
  }
  
  public boolean g(String paramString)
  {
    paramString = (WeatherBean)this.d.get(paramString);
    if (paramString != null) {
      return paramString.e() != 1;
    }
    return false;
  }
  
  public String h()
  {
    WeatherBean localWeatherBean = g();
    if (localWeatherBean != null) {
      return localWeatherBean.c();
    }
    return null;
  }
  
  public void i()
  {
    if (e() != 0)
    {
      ArrayList localArrayList = new ArrayList();
      Object localObject = this.d.values().iterator();
      while (((Iterator)localObject).hasNext())
      {
        WeatherBean localWeatherBean = (WeatherBean)((Iterator)localObject).next();
        RequestBean localRequestBean = new RequestBean();
        localRequestBean.a = localWeatherBean.c();
        localRequestBean.b = localWeatherBean.d();
        localRequestBean.c = localWeatherBean.k.g();
        localArrayList.add(localRequestBean);
      }
      localObject = new Intent("com.gau.go.launcherex.gowidget.weather.service.NotifyService");
      ((Intent)localObject).putExtra("notify_request", 22);
      ((Intent)localObject).putParcelableArrayListExtra("req_arg", localArrayList);
      this.a.startService((Intent)localObject);
    }
  }
  
  public boolean j()
  {
    if (!this.d.isEmpty())
    {
      Iterator localIterator = this.d.values().iterator();
      while (localIterator.hasNext()) {
        if (((WeatherBean)localIterator.next()).r()) {
          return true;
        }
      }
    }
    return false;
  }
  
  public void k()
  {
    Object localObject2 = a(this.a).c().entrySet();
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = new ArrayList();
    localObject2 = ((Set)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Iterator localIterator = ((WeatherBean)((Map.Entry)((Iterator)localObject2).next()).getValue()).n().entrySet().iterator();
      while (localIterator.hasNext())
      {
        com.gau.go.launcherex.gowidget.weather.model.c localc = (com.gau.go.launcherex.gowidget.weather.model.c)((Map.Entry)localIterator.next()).getValue();
        if (r.c(localc.d()))
        {
          localc.a(true);
          ExtremeCityIdBean localExtremeCityIdBean = new ExtremeCityIdBean();
          localExtremeCityIdBean.a(localc.j());
          localExtremeCityIdBean.a(localc.k());
          localArrayList.add(localExtremeCityIdBean);
        }
        else
        {
          localc.a(false);
        }
      }
    }
    if (((ArrayList)localObject1).size() > 0)
    {
      localObject2 = new Intent("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_UPDATE_EXTREME_WEATHER");
      ((Intent)localObject2).putParcelableArrayListExtra("extra_extreme_city_ids", (ArrayList)localObject1);
      ((Intent)localObject2).putExtra("extra_extreme_notify", false);
      this.a.sendBroadcast((Intent)localObject2);
    }
    if (localArrayList.size() > 0)
    {
      localObject1 = new Intent("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_DELETE_EXPIRED_EXTREME_WEATHER");
      ((Intent)localObject1).putParcelableArrayListExtra("extra_extreme_city_ids", localArrayList);
      this.a.sendBroadcast((Intent)localObject1);
    }
  }
  
  public void l()
  {
    Object localObject2 = a(this.a).c().entrySet();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Object localObject1 = new ArrayList();
    localObject2 = ((Set)localObject2).iterator();
    int j = 0;
    int i;
    if (((Iterator)localObject2).hasNext())
    {
      Map localMap = ((WeatherBean)((Map.Entry)((Iterator)localObject2).next()).getValue()).n();
      Iterator localIterator = localMap.entrySet().iterator();
      for (i = j; localIterator.hasNext(); i = 1)
      {
        label104:
        com.gau.go.launcherex.gowidget.weather.model.c localc = (com.gau.go.launcherex.gowidget.weather.model.c)((Map.Entry)localIterator.next()).getValue();
        if (((!r.c(localc.d())) || (!localc.m())) && (!r.d(localc.d()))) {
          break label104;
        }
        ((ArrayList)localObject1).add(Integer.valueOf(localc.k()));
        localArrayList1.add(Integer.valueOf(localc.k()));
        ExtremeCityIdBean localExtremeCityIdBean = new ExtremeCityIdBean();
        localExtremeCityIdBean.a(localc.j());
        localExtremeCityIdBean.a(localc.k());
        localArrayList2.add(localExtremeCityIdBean);
      }
      int m = ((ArrayList)localObject1).size();
      int k = 0;
      for (;;)
      {
        j = i;
        if (k >= m) {
          break;
        }
        localMap.remove(((ArrayList)localObject1).get(k));
        k += 1;
      }
    }
    if (j != 0)
    {
      localObject1 = new Intent("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_DELETE_EXPIRED_EXTREME_WEATHER");
      ((Intent)localObject1).putParcelableArrayListExtra("extra_extreme_city_ids", localArrayList2);
      this.a.sendBroadcast((Intent)localObject1);
      localArrayList2 = new ArrayList();
      j = localArrayList1.size();
      i = 0;
      while (i < j)
      {
        localArrayList2.add(ContentProviderOperation.newDelete(WeatherContentProvider.k).withSelection("alert_id='" + localArrayList1.get(i) + "'", null).build());
        i += 1;
      }
      this.c.a(0, null, "com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider", localArrayList2);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/util/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */