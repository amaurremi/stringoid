package com.gau.go.launcherex.gowidget.weather.b;

import android.content.ContentProviderOperation;
import android.content.ContentProviderOperation.Builder;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.OperationApplicationException;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.RemoteException;
import com.gau.go.launcherex.gowidget.weather.model.RequestBean;
import com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider;
import com.gau.go.launcherex.gowidget.weather.util.r;
import com.jiubang.goweather.a.a;
import com.jiubang.goweather.a.b;
import com.jiubang.goweather.a.c;
import com.jiubang.goweather.a.d;
import com.jiubang.goweather.a.e;
import com.jiubang.goweather.a.f;
import com.jiubang.goweather.a.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class bk
  extends AsyncTask
{
  bk(bg parambg) {}
  
  private bj a(bj parambj, ContentResolver paramContentResolver)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = bj.a(parambj);
    int j = localArrayList2.size();
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        a locala = (a)localArrayList2.get(i);
        if (locala.a == 1)
        {
          Iterator localIterator = bj.e(parambj).iterator();
          while (localIterator.hasNext())
          {
            RequestBean localRequestBean = (RequestBean)localIterator.next();
            if ((localRequestBean != null) && (localRequestBean.a != null) && (localRequestBean.a.equals(locala.c)))
            {
              a(locala, localRequestBean.a, localArrayList1);
              a(localRequestBean.a, localArrayList1);
              b(locala, localArrayList1);
              a(locala, localArrayList1);
              b(locala, localArrayList1, paramContentResolver);
              a(locala, localArrayList1, paramContentResolver);
            }
          }
          if (localArrayList1.size() <= 0) {}
        }
        try
        {
          paramContentResolver.applyBatch("com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider", localArrayList1);
          localArrayList1.clear();
          i += 1;
        }
        catch (RemoteException localRemoteException)
        {
          for (;;)
          {
            localRemoteException.printStackTrace();
          }
        }
        catch (OperationApplicationException localOperationApplicationException)
        {
          for (;;)
          {
            localOperationApplicationException.printStackTrace();
          }
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          for (;;)
          {
            localIllegalArgumentException.printStackTrace();
          }
        }
      }
    }
    return parambj;
  }
  
  private void a(a parama, String paramString, ArrayList paramArrayList)
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
    localContentValues.put("aqi", Integer.valueOf(parama.y()));
    localContentValues.put("qualityType", Integer.valueOf(parama.a()));
    localContentValues.put("pm25", Integer.valueOf(parama.b()));
    localContentValues.put("pm10", Integer.valueOf(parama.c()));
    localContentValues.put("so2", Integer.valueOf(parama.d()));
    localContentValues.put("no2", Integer.valueOf(parama.e()));
    paramArrayList.add(ContentProviderOperation.newUpdate(WeatherContentProvider.a).withValues(localContentValues).withSelection("cityId='" + paramString + "'", null).build());
  }
  
  private void a(a parama, ArrayList paramArrayList)
  {
    int j = parama.r();
    int i = 0;
    while (i < j)
    {
      d locald = parama.d(i);
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("cityId", parama.d());
      localContentValues.put("date_long", locald.c());
      localContentValues.put("hour", Integer.valueOf(locald.f()));
      localContentValues.put("status", locald.g());
      localContentValues.put("type", Integer.valueOf(locald.j()));
      localContentValues.put("windDirection", locald.d());
      localContentValues.put("windStrength", locald.e());
      localContentValues.put("windStrengthValue", Float.valueOf(locald.b()));
      localContentValues.put("windType", Integer.valueOf(locald.a()));
      localContentValues.put("tempValue", Float.valueOf(r.a(locald.h())));
      localContentValues.put("humidityValue", Integer.valueOf(locald.i()));
      localContentValues.put("pop", Integer.valueOf(locald.k()));
      paramArrayList.add(ContentProviderOperation.newInsert(WeatherContentProvider.e).withValues(localContentValues).build());
      i += 1;
    }
  }
  
  private void a(a parama, ArrayList paramArrayList, ContentResolver paramContentResolver)
  {
    int k = parama.u();
    int i = 0;
    while (i < k)
    {
      paramContentResolver = parama.g(i);
      Object localObject = new ContentValues();
      ((ContentValues)localObject).put("cityId", parama.d());
      ((ContentValues)localObject).put("date_time", Long.valueOf(paramContentResolver.a));
      ((ContentValues)localObject).put("pollen_index", Float.valueOf(paramContentResolver.b));
      paramArrayList.add(ContentProviderOperation.newInsert(WeatherContentProvider.G).withValues((ContentValues)localObject).build());
      int m = paramContentResolver.a();
      int j = 0;
      while (j < m)
      {
        localObject = paramContentResolver.a(j);
        ContentValues localContentValues = new ContentValues();
        localContentValues.put("cityId", parama.d());
        localContentValues.put("date_time", Long.valueOf(paramContentResolver.a));
        localContentValues.put("name", ((g)localObject).a);
        localContentValues.put("type", Integer.valueOf(((g)localObject).b));
        localContentValues.put("url", ((g)localObject).c);
        paramArrayList.add(ContentProviderOperation.newInsert(WeatherContentProvider.H).withValues(localContentValues).build());
        j += 1;
      }
      i += 1;
    }
  }
  
  private void a(String paramString, ArrayList paramArrayList)
  {
    paramArrayList.add(ContentProviderOperation.newDelete(WeatherContentProvider.b).withSelection("cityId='" + paramString + "'", null).build());
    paramArrayList.add(ContentProviderOperation.newDelete(WeatherContentProvider.e).withSelection("cityId='" + paramString + "'", null).build());
    paramArrayList.add(ContentProviderOperation.newDelete(WeatherContentProvider.f).withSelection("cityId='" + paramString + "'", null).build());
    paramArrayList.add(ContentProviderOperation.newDelete(WeatherContentProvider.G).withSelection("cityId='" + paramString + "'", null).build());
    paramArrayList.add(ContentProviderOperation.newDelete(WeatherContentProvider.H).withSelection("cityId='" + paramString + "'", null).build());
  }
  
  private void b(a parama, ArrayList paramArrayList)
  {
    int j = parama.q();
    int i = 0;
    while (i < j)
    {
      c localc = parama.c(i);
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("lowTempValue", Float.valueOf(r.a(localc.i())));
      localContentValues.put("highTempValue", Float.valueOf(r.a(localc.h())));
      localContentValues.put("weekDate", localc.e());
      localContentValues.put("windDir", localc.c());
      localContentValues.put("windType", Integer.valueOf(localc.b()));
      localContentValues.put("windStrengthValue", Float.valueOf(localc.a()));
      localContentValues.put("windStrength", localc.d());
      localContentValues.put("type", Integer.valueOf(localc.g()));
      localContentValues.put("cityId", parama.d());
      localContentValues.put("status", localc.f());
      localContentValues.put("pop", Integer.valueOf(localc.j()));
      localContentValues.put("date_long", localc.m());
      localContentValues.put("status_day", localc.k());
      localContentValues.put("status_night", localc.l());
      paramArrayList.add(ContentProviderOperation.newInsert(WeatherContentProvider.b).withValues(localContentValues).build());
      i += 1;
    }
  }
  
  private void b(a parama, ArrayList paramArrayList, ContentResolver paramContentResolver)
  {
    int k = parama.s();
    int j = 0;
    b localb;
    Object localObject;
    if (j < k)
    {
      localb = parama.e(j);
      localObject = WeatherContentProvider.k;
      String str = "alert_id='" + localb.i() + "' and " + "cityId" + "='" + parama.d() + "'";
      localObject = paramContentResolver.query((Uri)localObject, new String[] { "cityId" }, str, null, null);
      if (localObject == null) {
        break label429;
      }
    }
    for (;;)
    {
      try
      {
        ((Cursor)localObject).moveToFirst();
        i = ((Cursor)localObject).getCount();
        if (i <= 0) {
          break label423;
        }
        i = 1;
        ((Cursor)localObject).close();
        localObject = new ContentValues();
        ((ContentValues)localObject).put("cityId", parama.d());
        ((ContentValues)localObject).put("description", localb.d());
        ((ContentValues)localObject).put("exp_time", localb.b());
        ((ContentValues)localObject).put("alert_id", Integer.valueOf(localb.i()));
        ((ContentValues)localObject).put("level", Integer.valueOf(localb.f()));
        ((ContentValues)localObject).put("message", localb.g());
        ((ContentValues)localObject).put("phenomena", localb.e());
        ((ContentValues)localObject).put("publish_time", localb.a());
        ((ContentValues)localObject).put("type", localb.c());
        ((ContentValues)localObject).put("tz_offset", Integer.valueOf(localb.j()));
        ((ContentValues)localObject).put("has_read", Integer.valueOf(0));
        if (i == 0)
        {
          paramArrayList.add(ContentProviderOperation.newInsert(WeatherContentProvider.k).withValues((ContentValues)localObject).build());
          j += 1;
        }
      }
      finally
      {
        ((Cursor)localObject).close();
      }
      continue;
      return;
      label423:
      int i = 0;
      continue;
      label429:
      i = 0;
    }
  }
  
  protected bj a(Object... paramVarArgs)
  {
    bj localbj = (bj)paramVarArgs[0];
    a(localbj, (ContentResolver)paramVarArgs[1]);
    return localbj;
  }
  
  protected void a(bj parambj)
  {
    bg.a(this.a, parambj);
    bg.b(this.a);
    new bi(this.a, null).execute(new bj[] { parambj });
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/b/bk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */