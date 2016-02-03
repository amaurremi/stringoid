package com.gau.go.launcherex.gowidget.weather.b;

import android.content.ContentProviderOperation;
import android.content.ContentProviderOperation.Builder;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.OperationApplicationException;
import android.os.AsyncTask;
import android.os.RemoteException;
import android.text.TextUtils;
import com.gau.go.launcherex.gowidget.weather.model.WeatherBean;
import com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider;
import com.gau.go.launcherex.gowidget.weather.util.f;
import java.util.ArrayList;

class ad
  extends AsyncTask
{
  private com.gau.go.launcherex.gowidget.weather.model.b b;
  private String c;
  
  ad(aa paramaa) {}
  
  private int a(com.gau.go.launcherex.gowidget.weather.model.b paramb, WeatherBean paramWeatherBean)
  {
    int i = 1;
    int k = 1;
    int j = 1;
    ArrayList localArrayList = new ArrayList();
    if (paramWeatherBean != null)
    {
      k = paramWeatherBean.e();
      if (!paramWeatherBean.c().equals(paramb.a()))
      {
        if (k != 2) {
          break label532;
        }
        if (f.a(aa.b(this.a)).a(paramb.a()) == null) {
          break label340;
        }
        localArrayList.add(ContentProviderOperation.newDelete(WeatherContentProvider.a).withSelection("cityId='" + paramWeatherBean.c() + "'", null).build());
        localArrayList.add(ContentProviderOperation.newDelete(WeatherContentProvider.b).withSelection("cityId='" + paramWeatherBean.c() + "'", null).build());
        localArrayList.add(ContentProviderOperation.newDelete(WeatherContentProvider.e).withSelection("cityId='" + paramWeatherBean.c() + "'", null).build());
        localArrayList.add(ContentProviderOperation.newDelete(WeatherContentProvider.f).withSelection("cityId='" + paramWeatherBean.c() + "'", null).build());
        paramWeatherBean = new ContentValues();
        paramWeatherBean.put("city_my_location", Integer.valueOf(3));
        localArrayList.add(ContentProviderOperation.newUpdate(WeatherContentProvider.a).withValues(paramWeatherBean).withSelection("cityId=?", new String[] { paramb.a() }).build());
        i = j;
      }
      for (;;)
      {
        aa.a(this.a, localArrayList, paramb.a());
        try
        {
          aa.b(this.a).getContentResolver().applyBatch("com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider", localArrayList);
          return i;
        }
        catch (RemoteException paramb)
        {
          ContentValues localContentValues;
          paramb.printStackTrace();
          return 0;
        }
        catch (OperationApplicationException paramb)
        {
          paramb.printStackTrace();
          return 0;
        }
        catch (IllegalArgumentException paramb)
        {
          label340:
          paramb.printStackTrace();
        }
        localContentValues = aa.a(this.a, paramb, 2, false);
        localArrayList.add(ContentProviderOperation.newUpdate(WeatherContentProvider.a).withValues(localContentValues).withSelection("cityId=?", new String[] { paramWeatherBean.c() }).build());
        localArrayList.add(ContentProviderOperation.newDelete(WeatherContentProvider.b).withSelection("cityId='" + paramWeatherBean.c() + "'", null).build());
        localArrayList.add(ContentProviderOperation.newDelete(WeatherContentProvider.e).withSelection("cityId='" + paramWeatherBean.c() + "'", null).build());
        localArrayList.add(ContentProviderOperation.newDelete(WeatherContentProvider.f).withSelection("cityId='" + paramWeatherBean.c() + "'", null).build());
        i = j;
        continue;
        label532:
        i = j;
        if (k == 3)
        {
          localContentValues = new ContentValues();
          localContentValues.put("city_my_location", Integer.valueOf(1));
          localArrayList.add(ContentProviderOperation.newUpdate(WeatherContentProvider.a).withValues(localContentValues).withSelection("cityId=?", new String[] { paramWeatherBean.c() }).build());
          localContentValues.clear();
          if (f.a(aa.b(this.a)).a(paramb.a()) != null)
          {
            localContentValues.put("city_my_location", Integer.valueOf(3));
            localArrayList.add(ContentProviderOperation.newUpdate(WeatherContentProvider.a).withValues(localContentValues).withSelection("cityId=?", new String[] { paramb.a() }).build());
            i = 2;
          }
          else
          {
            paramWeatherBean = aa.a(this.a, paramb, 2, true);
            localArrayList.add(ContentProviderOperation.newInsert(WeatherContentProvider.a).withValues(paramWeatherBean).build());
            i = j;
          }
        }
      }
    }
    paramWeatherBean = f.a(aa.b(this.a)).a(paramb.a());
    if (paramWeatherBean == null)
    {
      paramWeatherBean = aa.a(this.a, paramb, 2, true);
      localArrayList.add(ContentProviderOperation.newInsert(WeatherContentProvider.a).withValues(paramWeatherBean).build());
      i = k;
    }
    for (;;)
    {
      aa.a(this.a, localArrayList, paramb.a());
      break;
      i = k;
      if (paramWeatherBean.e() == 1)
      {
        paramWeatherBean = new ContentValues();
        paramWeatherBean.put("city_my_location", Integer.valueOf(3));
        localArrayList.add(ContentProviderOperation.newUpdate(WeatherContentProvider.a).withValues(paramWeatherBean).withSelection("cityId=?", new String[] { paramb.a() }).build());
        i = 2;
      }
    }
    return 0;
  }
  
  protected Integer a(Object... paramVarArgs)
  {
    this.b = ((com.gau.go.launcherex.gowidget.weather.model.b)paramVarArgs[0]);
    paramVarArgs = (WeatherBean)paramVarArgs[1];
    if (paramVarArgs != null) {
      this.c = paramVarArgs.c();
    }
    return Integer.valueOf(a(this.b, paramVarArgs));
  }
  
  protected void a(Integer paramInteger)
  {
    f.a(aa.b(this.a)).a(this.b);
    if (paramInteger.intValue() == 1) {
      aa.a(this.a, 4, this.b.a(), this.b.b(), 2, this.c);
    }
    for (;;)
    {
      paramInteger = com.gau.go.launcherex.gowidget.gcm.b.a(aa.b(this.a));
      if (!TextUtils.isEmpty(this.c)) {
        paramInteger.a(this.c);
      }
      paramInteger.b(this.b.a());
      aa.a(this.a, false);
      aa.a(this.a, this.b);
      return;
      if (paramInteger.intValue() == 2) {
        aa.a(this.a, 4, this.b.a(), this.b.b(), 3, this.c);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/b/ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */