package com.gau.go.launcherex.goweather.ad;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import android.util.SparseArray;
import com.gau.go.launcherex.goweather.ad.a.a;
import com.gau.go.launcherex.goweather.ad.a.b;
import com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider;
import com.jiubang.goweather.b.d;
import com.jiubang.goweather.b.f;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class e
  extends AsyncTask
{
  e(c paramc) {}
  
  private int a(String paramString, a parama)
  {
    int i = 0;
    com.gtp.a.a.b.c.a("ad", "jsonResult -- " + paramString);
    if (!"".equals(paramString))
    {
      JSONArray localJSONArray = null;
      int j;
      try
      {
        paramString = new JSONObject(paramString);
        if (paramString == null) {
          break label298;
        }
        paramString.optInt("version", 1);
        j = paramString.optInt("status", 0);
        if (j == 1)
        {
          parama.a(paramString.optLong("interval", 1440L) * 60L * 1000L);
          parama.a(paramString.optInt("overcount", 3));
          parama.a(paramString.optString("id"));
          a(paramString.optString("img"));
          parama.b(paramString.optString("monitor"));
          parama.b(paramString.optInt("pcount"));
          parama.c(paramString.optString("purl"));
          localJSONArray = paramString.optJSONArray("ads");
          if (localJSONArray != null)
          {
            localSparseArray = new SparseArray();
            int k = localJSONArray.length();
            while (i < k)
            {
              JSONObject localJSONObject = localJSONArray.optJSONObject(i);
              if (localJSONObject != null)
              {
                b localb = new b();
                localb.a = localJSONObject.optInt("weather");
                localb.b = localJSONObject.optString("text");
                localb.c = localJSONObject.optString("url");
                localSparseArray.put(localb.a, localb);
              }
              i += 1;
            }
          }
        }
      }
      catch (JSONException paramString)
      {
        SparseArray localSparseArray;
        for (;;)
        {
          paramString.printStackTrace();
          paramString = localJSONArray;
        }
        parama.a(localSparseArray);
        parama.d(paramString.optString("timestamp"));
      }
      return j;
    }
    label298:
    return 0;
  }
  
  private List a(String paramString1, String paramString2)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new BasicNameValuePair("Version", String.valueOf(1)));
    if (paramString1 != null) {}
    for (;;)
    {
      localArrayList.add(new BasicNameValuePair("ID", paramString1));
      localArrayList.add(new BasicNameValuePair("UID", Settings.Secure.getString(c.f(this.a).getContentResolver(), "android_id")));
      localArrayList.add(new BasicNameValuePair("AID", String.valueOf(2)));
      localArrayList.add(new BasicNameValuePair("Test", String.valueOf(0)));
      localArrayList.add(new BasicNameValuePair("Timestamp", paramString2));
      return localArrayList;
      paramString1 = "0";
    }
  }
  
  private void a()
  {
    c.f(this.a).getContentResolver().delete(WeatherContentProvider.s, null, null);
  }
  
  private void a(a parama)
  {
    ContentResolver localContentResolver = c.f(this.a).getContentResolver();
    SparseArray localSparseArray = parama.f();
    if (localSparseArray != null)
    {
      int j = localSparseArray.size();
      ContentValues localContentValues = new ContentValues();
      int i = 0;
      while (i < j)
      {
        localContentValues.put("ad_id", parama.a());
        localContentValues.put("ad_interval", Long.valueOf(parama.b()));
        localContentValues.put("ad_monitor", parama.e());
        localContentValues.put("ad_overcount", Integer.valueOf(parama.c()));
        localContentValues.put("ad_img", parama.d());
        localContentValues.put("pcount", Integer.valueOf(parama.g()));
        localContentValues.put("purl", parama.h());
        localContentValues.put("timestamp", parama.i());
        b localb = (b)localSparseArray.valueAt(i);
        localContentValues.put("ad_weather", Integer.valueOf(localb.a));
        localContentValues.put("ad_text", localb.b);
        localContentValues.put("ad_url", localb.c);
        localContentResolver.insert(WeatherContentProvider.s, localContentValues);
        localContentValues.clear();
        i += 1;
      }
    }
  }
  
  /* Error */
  private void a(String paramString)
  {
    // Byte code:
    //   0: ldc 39
    //   2: aload_1
    //   3: invokevirtual 45	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6: ifne +34 -> 40
    //   9: aload_0
    //   10: getfield 10	com/gau/go/launcherex/goweather/ad/e:a	Lcom/gau/go/launcherex/goweather/ad/c;
    //   13: invokestatic 188	com/gau/go/launcherex/goweather/ad/c:f	(Lcom/gau/go/launcherex/goweather/ad/c;)Landroid/content/Context;
    //   16: ldc_w 304
    //   19: iconst_0
    //   20: invokevirtual 308	android/content/Context:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   23: astore_2
    //   24: aload_2
    //   25: aload_1
    //   26: invokevirtual 312	java/lang/String:getBytes	()[B
    //   29: invokevirtual 318	java/io/FileOutputStream:write	([B)V
    //   32: aload_2
    //   33: invokevirtual 321	java/io/FileOutputStream:flush	()V
    //   36: aload_2
    //   37: invokevirtual 324	java/io/FileOutputStream:close	()V
    //   40: return
    //   41: astore_1
    //   42: aload_1
    //   43: invokevirtual 325	java/io/FileNotFoundException:printStackTrace	()V
    //   46: return
    //   47: astore_1
    //   48: aload_1
    //   49: athrow
    //   50: astore_1
    //   51: aload_1
    //   52: invokevirtual 326	java/io/IOException:printStackTrace	()V
    //   55: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	56	0	this	e
    //   0	56	1	paramString	String
    //   23	14	2	localFileOutputStream	java.io.FileOutputStream
    // Exception table:
    //   from	to	target	type
    //   9	40	41	java/io/FileNotFoundException
    //   9	40	47	finally
    //   42	46	47	finally
    //   51	55	47	finally
    //   9	40	50	java/io/IOException
  }
  
  protected f a(Void... paramVarArgs)
  {
    Object localObject = new com.jiubang.goweather.b.e("http://appad.3g.cn:8080/goad/ad", "POST");
    paramVarArgs = c.g(this.a);
    ((com.jiubang.goweather.b.e)localObject).a(a(paramVarArgs.a(), paramVarArgs.i()));
    f localf = new f();
    com.jiubang.goweather.b.c localc = d.a();
    if (localc.a(localf, c.f(this.a)))
    {
      localObject = localc.b("http://appad.3g.cn:8080/goad/ad", (com.jiubang.goweather.b.e)localObject, localf);
      int i;
      if (localObject != null)
      {
        i = a((String)localObject, paramVarArgs);
        if (i != 1) {
          break label152;
        }
        a();
        a(paramVarArgs);
      }
      for (;;)
      {
        localf.b(1);
        if ((paramVarArgs.g() != 0) && (!TextUtils.isEmpty(paramVarArgs.h()))) {
          c.a(this.a, paramVarArgs.g(), paramVarArgs.b(), paramVarArgs.h());
        }
        return localf;
        label152:
        if ((i != 0) && (i == -1)) {
          a();
        }
      }
    }
    localf.b(11);
    localf.c(3);
    return localf;
  }
  
  protected void a(f paramf)
  {
    Message localMessage = c.b(this.a).obtainMessage();
    switch (paramf.c())
    {
    default: 
      localMessage.obj = Long.valueOf(3600000L);
      localMessage.what = 1;
    }
    for (;;)
    {
      c.b(this.a).sendMessage(localMessage);
      return;
      localMessage.obj = Long.valueOf(c.h(this.a));
      localMessage.what = 1;
      continue;
      if (paramf.e() != 3) {
        break;
      }
      localMessage.what = 2;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/goweather/ad/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */