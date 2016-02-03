package com.gtp.go.weather.sharephoto.c;

import android.content.ContentProviderOperation;
import android.content.ContentProviderOperation.Builder;
import android.content.ContentResolver;
import android.content.Context;
import android.content.OperationApplicationException;
import android.os.AsyncTask;
import android.os.RemoteException;
import com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider;
import com.jiubang.goweather.b.e;
import com.jiubang.goweather.e.a;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

class f
  extends AsyncTask
{
  private ConcurrentHashMap b;
  private ConcurrentHashMap c;
  private ConcurrentHashMap d;
  
  public f(d paramd, ConcurrentHashMap paramConcurrentHashMap1, ConcurrentHashMap paramConcurrentHashMap2, ConcurrentHashMap paramConcurrentHashMap3)
  {
    this.b = paramConcurrentHashMap1;
    this.c = paramConcurrentHashMap2;
    this.d = paramConcurrentHashMap3;
  }
  
  private void a(ArrayList paramArrayList, com.jiubang.goweather.b.c paramc, JSONObject paramJSONObject, ConcurrentHashMap paramConcurrentHashMap)
  {
    Iterator localIterator = paramConcurrentHashMap.keySet().iterator();
    com.gtp.go.weather.sharephoto.b.c localc;
    ArrayList localArrayList;
    e locale;
    if (localIterator.hasNext())
    {
      localc = (com.gtp.go.weather.sharephoto.b.c)paramConcurrentHashMap.get((Long)localIterator.next());
      localArrayList = new ArrayList();
      localArrayList.add(new BasicNameValuePair("phead", paramJSONObject.toString()));
      localArrayList.add(new BasicNameValuePair("userId", localc.a()));
      localArrayList.add(new BasicNameValuePair("imageId", localc.b() + ""));
      if ((localc.d() != 2) && (localc.d() != 1)) {
        break label203;
      }
      localArrayList.add(new BasicNameValuePair("isFavour", localc.c() + ""));
      locale = new e("http://gows.goforandroid.com/goweatherexSns/image/imageFavour", "POST");
    }
    for (;;)
    {
      label197:
      if (locale == null) {}
      label203:
      int i;
      com.jiubang.goweather.b.f localf;
      Object localObject;
      label362:
      do
      {
        return;
        if (localc.d() != 3) {
          break label701;
        }
        localArrayList.add(new BasicNameValuePair("illegalType", localc.c() + ""));
        locale = new e("http://gows.goforandroid.com/goweatherexSns/image/accuse", "POST");
        break label197;
        locale.a(localArrayList);
        i = 0;
        if (i >= 3) {
          break;
        }
        localf = new com.jiubang.goweather.b.f();
        localObject = null;
        if ((localc.d() != 2) && (localc.d() != 1)) {
          break label517;
        }
        localArrayList.add(new BasicNameValuePair("isFavour", localc.c() + ""));
        localObject = paramc.a("http://gows.goforandroid.com/goweatherexSns/image/imageFavour", locale, localf);
      } while (localObject == null);
      if (localObject != null) {}
      try
      {
        localObject = new JSONObject(a.a((InputStream)localObject, "ISO-8859-1")).optJSONObject("head");
        if (localObject != null)
        {
          j = ((JSONObject)localObject).optInt("result", -1);
          if (j == 1)
          {
            com.gtp.a.a.b.c.a("UploadLikeAndBgHandler", "upload resultString == 1, photoId = " + localc.b());
            localc.a(true);
            if (localc.d() != 1) {
              break label585;
            }
            paramArrayList.add(ContentProviderOperation.newDelete(WeatherContentProvider.x).withSelection("photo_id=? and data_type=?", new String[] { String.valueOf(localc.b()), String.valueOf(1) }).build());
          }
        }
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          localIOException.printStackTrace();
          i += 1;
          break;
          if (localc.d() != 3) {
            break label362;
          }
          localArrayList.add(new BasicNameValuePair("illegalType", localc.c() + ""));
          InputStream localInputStream = paramc.a("http://gows.goforandroid.com/goweatherexSns/image/accuse", locale, localf);
          break label362;
          int j = -1;
        }
        if (localc.d() == 2) {
          paramArrayList.add(ContentProviderOperation.newDelete(WeatherContentProvider.x).withSelection("photo_id=? and data_type=?", new String[] { String.valueOf(localc.b()), String.valueOf(2) }).build());
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          label517:
          label585:
          localJSONException.printStackTrace();
        }
      }
      if (localc.d() != 3) {
        break;
      }
      paramArrayList.add(ContentProviderOperation.newDelete(WeatherContentProvider.x).withSelection("photo_id=? and data_type=?", new String[] { String.valueOf(localc.b()), String.valueOf(3) }).build());
      break;
      label701:
      locale = null;
    }
  }
  
  protected ArrayList a(Void... paramVarArgs)
  {
    paramVarArgs = com.jiubang.goweather.b.d.a();
    JSONObject localJSONObject = com.gtp.go.weather.sharephoto.a.f.a(d.a(this.a));
    ArrayList localArrayList = new ArrayList();
    a(localArrayList, paramVarArgs, localJSONObject, this.c);
    a(localArrayList, paramVarArgs, localJSONObject, this.b);
    a(localArrayList, paramVarArgs, localJSONObject, this.d);
    paramVarArgs.a();
    return localArrayList;
  }
  
  protected void a(ArrayList paramArrayList)
  {
    super.onPostExecute(paramArrayList);
    if ((paramArrayList != null) && (!paramArrayList.isEmpty())) {}
    try
    {
      d.a(this.a).getContentResolver().applyBatch("com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider", paramArrayList);
      if (this.b != null)
      {
        paramArrayList = this.b.keySet().iterator();
        while (paramArrayList.hasNext())
        {
          localLong = (Long)paramArrayList.next();
          localc1 = (com.gtp.go.weather.sharephoto.b.c)this.b.get(localLong);
          if ((localc1 != null) && (localc1.e())) {
            d.c(this.a).remove(localLong);
          }
        }
      }
    }
    catch (RemoteException paramArrayList)
    {
      for (;;)
      {
        if (com.gtp.a.a.b.c.a()) {
          paramArrayList.printStackTrace();
        }
      }
    }
    catch (OperationApplicationException paramArrayList)
    {
      Long localLong;
      com.gtp.go.weather.sharephoto.b.c localc1;
      for (;;)
      {
        if (com.gtp.a.a.b.c.a()) {
          paramArrayList.printStackTrace();
        }
      }
      com.gtp.go.weather.sharephoto.b.c localc2;
      if (this.c != null)
      {
        paramArrayList = this.c.keySet().iterator();
        while (paramArrayList.hasNext())
        {
          localLong = (Long)paramArrayList.next();
          localc1 = (com.gtp.go.weather.sharephoto.b.c)this.c.get(localLong);
          localc2 = (com.gtp.go.weather.sharephoto.b.c)d.d(this.a).get(localLong);
          if ((localc1 != null) && (localc2 != null) && (localc1.e()) && (localc1.c() == localc2.c())) {
            d.d(this.a).remove(localLong);
          }
        }
      }
      if (this.d != null)
      {
        paramArrayList = this.d.keySet().iterator();
        while (paramArrayList.hasNext())
        {
          localLong = (Long)paramArrayList.next();
          localc1 = (com.gtp.go.weather.sharephoto.b.c)this.d.get(localLong);
          localc2 = (com.gtp.go.weather.sharephoto.b.c)d.e(this.a).get(localLong);
          if ((localc1 != null) && (localc2 != null) && (localc1.e()) && (localc1.c() == localc2.c())) {
            d.e(this.a).remove(localLong);
          }
        }
      }
      if ((d.c(this.a).size() == 0) && (d.d(this.a).size() == 0) && (d.e(this.a).size() == 0))
      {
        d.a(this.a).unregisterReceiver(d.f(this.a));
        d.a(this.a, false);
        return;
      }
      d.a(this.a, System.currentTimeMillis() + 300000L);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/c/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */