package com.gau.go.launcherex.gowidget.weather.globaltheme.a;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.AsyncTask;
import android.text.TextUtils;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressLint({"DefaultLocale"})
class c
  extends AsyncTask
{
  private c(a parama) {}
  
  private void a(int paramInt, SharedPreferences.Editor paramEditor)
  {
    com.gau.go.launcherex.gowidget.weather.globaltheme.a.a.b localb = new com.gau.go.launcherex.gowidget.weather.globaltheme.a.a.b(paramInt);
    paramEditor.putString("key_adid_location_" + localb.b(), localb.a());
  }
  
  protected Integer a(Object... paramVarArgs)
  {
    int j = 0;
    long l1 = a.a(this.a).getLong("key_adid_request_time", 0L);
    long l2 = System.currentTimeMillis();
    int i = a.a(this.a).getInt("key_adid_request_frequency", 0);
    l1 = l2 - l1;
    if ((l1 > 0L) && (l1 <= 60000 * i))
    {
      com.gtp.a.a.b.c.a("adid", "未达到再次获取广告ID数据的时间，还差" + (i * 60000 - l1) + "毫秒更新");
      return Integer.valueOf(0);
    }
    paramVarArgs = "";
    Object localObject1 = a.a(this.a, a.b(this.a));
    if (localObject1 != null) {
      paramVarArgs = ((JSONObject)localObject1).toString();
    }
    com.gtp.a.a.b.c.a("adid", "postData --> " + paramVarArgs);
    if (TextUtils.isEmpty(paramVarArgs)) {
      return Integer.valueOf(0);
    }
    localObject1 = a.b(this.a, a.b(this.a));
    com.gtp.a.a.b.c.a("adid", "url --> " + (String)localObject1);
    paramVarArgs = com.gau.go.launcherex.gowidget.weather.globaltheme.a.b.b.a(a.b(this.a), (String)localObject1, 0, 1, paramVarArgs);
    com.gtp.a.a.b.c.a("adid", "result --> " + paramVarArgs);
    if (TextUtils.isEmpty(paramVarArgs)) {
      return Integer.valueOf(0);
    }
    i = j;
    JSONObject localJSONObject1;
    int k;
    SharedPreferences.Editor localEditor;
    ArrayList localArrayList;
    int m;
    int n;
    label447:
    Object localObject2;
    Object localObject3;
    try
    {
      localJSONObject1 = new JSONObject(paramVarArgs);
      i = j;
      j = localJSONObject1.optJSONObject("result").optInt("status", 0);
      if (j == 1)
      {
        i = j;
        JSONArray localJSONArray1 = new JSONArray(localJSONObject1.getString("ads").toString());
        if (localJSONArray1 != null)
        {
          i = j;
          k = localJSONArray1.length();
          i = j;
          localEditor = a.a(this.a).edit();
          if (k > 0)
          {
            i = j;
            localArrayList = new ArrayList();
            m = 0;
            if (m < k)
            {
              i = j;
              com.gau.go.launcherex.gowidget.weather.globaltheme.a.a.b localb = new com.gau.go.launcherex.gowidget.weather.globaltheme.a.a.b();
              i = j;
              for (;;)
              {
                try
                {
                  JSONObject localJSONObject2 = localJSONArray1.getJSONObject(m);
                  i = j;
                  localb.a(localJSONObject2.getInt("location"));
                  i = j;
                  JSONArray localJSONArray2 = localJSONObject2.getJSONArray("reqSDKBean");
                  if (localJSONArray2 != null)
                  {
                    i = j;
                    localObject1 = localb.c();
                    i = j;
                    paramVarArgs = localb.d();
                    n = 0;
                    i = j;
                    if (n < localJSONArray2.length())
                    {
                      i = j;
                      JSONObject localJSONObject3 = localJSONArray2.getJSONObject(n);
                      localObject2 = paramVarArgs;
                      localObject3 = localObject1;
                      if (localJSONObject3 == null) {
                        break label1031;
                      }
                      i = j;
                      localObject2 = new StringBuilder();
                      i = j;
                      if (TextUtils.isEmpty((CharSequence)localObject1))
                      {
                        localObject1 = "";
                        i = j;
                        localObject3 = (String)localObject1 + localJSONObject3.getString("reqSDK").toLowerCase();
                        i = j;
                        localObject1 = new StringBuilder();
                        i = j;
                        if (TextUtils.isEmpty(paramVarArgs))
                        {
                          paramVarArgs = "";
                          i = j;
                          localObject2 = paramVarArgs + localJSONObject3.getString("reqId").toLowerCase();
                          break label1031;
                        }
                      }
                      else
                      {
                        i = j;
                        localObject1 = (String)localObject1 + "|";
                        continue;
                      }
                      i = j;
                      paramVarArgs = paramVarArgs + "|";
                      continue;
                    }
                    i = j;
                    localb.a((String)localObject1);
                    i = j;
                    localb.b(paramVarArgs);
                  }
                  i = j;
                  if (!localJSONObject2.getBoolean("isOpen")) {
                    continue;
                  }
                  n = 1;
                  i = j;
                  localb.b(n);
                  i = j;
                  localb.c(localJSONObject2.getInt("reqNum"));
                  i = j;
                  localb.d(localJSONObject2.optInt("reqSelf", 0));
                  i = j;
                  localArrayList.add(localb);
                  i = j;
                  localEditor.putString("key_adid_location_" + localb.b(), localb.a());
                }
                catch (Exception paramVarArgs)
                {
                  i = j;
                  if (!com.gtp.a.a.b.c.a()) {
                    continue;
                  }
                  i = j;
                  paramVarArgs.printStackTrace();
                  continue;
                }
                m += 1;
                break;
                n = 0;
              }
              return Integer.valueOf(j);
            }
          }
        }
      }
    }
    catch (JSONException paramVarArgs)
    {
      j = i;
      if (com.gtp.a.a.b.c.a())
      {
        paramVarArgs.printStackTrace();
        j = i;
      }
    }
    label1031:
    label1047:
    label1052:
    for (;;)
    {
      i = j;
      if (localArrayList.size() == 1)
      {
        i = j;
        paramVarArgs = (com.gau.go.launcherex.gowidget.weather.globaltheme.a.a.b)localArrayList.get(0);
        i = j;
        if (paramVarArgs.b() == 1)
        {
          i = j;
          a(2, localEditor);
          break label1047;
        }
      }
      for (;;)
      {
        if (i != 0)
        {
          i = j;
          a(2, localEditor);
          i = j;
          a(1, localEditor);
        }
        i = j;
        m = localJSONObject1.optInt("reqFrequency", 480);
        k = m;
        if (m == -1) {
          k = 480;
        }
        i = j;
        com.gtp.a.a.b.c.a("adid", "广告更新频率：reqFrequency = " + k);
        i = j;
        localEditor.putInt("key_adid_request_frequency", k);
        i = j;
        localEditor.putLong("key_adid_request_time", System.currentTimeMillis());
        i = j;
        localEditor.commit();
        break label1052;
        i = j;
        if (paramVarArgs.b() == 2)
        {
          i = j;
          a(1, localEditor);
          break label1047;
          i = j;
          k = localArrayList.size();
          if (k == 0)
          {
            i = 1;
            continue;
            i = 1;
            continue;
          }
          i = 0;
          continue;
          k = 0;
          break;
          n += 1;
          paramVarArgs = (Object[])localObject2;
          localObject1 = localObject3;
          break label447;
        }
        i = 0;
      }
    }
  }
  
  protected void a(Integer paramInteger)
  {
    super.onPostExecute(paramInteger);
    if (paramInteger.intValue() == 1) {}
    a.a(this.a, false);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/globaltheme/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */