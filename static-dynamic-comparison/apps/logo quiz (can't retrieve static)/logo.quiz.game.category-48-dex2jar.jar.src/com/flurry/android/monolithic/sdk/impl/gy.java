package com.flurry.android.monolithic.sdk.impl;

import com.flurry.android.impl.appcloud.AppCloudModule;
import java.util.HashMap;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.message.AbstractHttpMessage;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.json.JSONTokener;

public class gy
  extends he
{
  protected static final String a = gy.class.getSimpleName();
  
  public gy(HashMap<String, Object> paramHashMap)
  {
    super(paramHashMap);
  }
  
  public void a()
  {
    b("GetOperation Thread");
    for (;;)
    {
      try
      {
        this.f = ((fr)this.h.get("del"));
        this.g = ((fs)this.h.get("del_internal"));
        str = a((String)this.h.get("url"));
        localObject2 = new HttpGet(str);
        ja.a(4, a, "Get operation URL = " + str);
        if (AppCloudModule.c())
        {
          this.d = iz.a(new BasicHttpParams());
          this.e = new BasicHttpContext();
          this.e.setAttribute("http.cookie-store", new BasicCookieStore());
          str = (String)this.d.execute((HttpUriRequest)localObject2, new BasicResponseHandler(), this.e);
          localObject2 = new JSONTokener(str);
          ((JSONTokener)localObject2).skipPast("(");
          localObject2 = (JSONObject)((JSONTokener)localObject2).nextValue();
          ja.a(4, a, "responseText = " + str);
          if ((((JSONObject)localObject2).getInt("code") != 400) && (((JSONObject)localObject2).has("APPCLOUD_USER_SESSION"))) {
            gr.a = ((JSONObject)localObject2).getString("APPCLOUD_USER_SESSION");
          }
          a((JSONObject)localObject2);
          return;
        }
      }
      catch (Exception localException)
      {
        String str;
        Object localObject2;
        ja.a(6, a, "Exception during communication with server: ", localException);
        a(null);
        return;
      }
      finally
      {
        if (this.d == null) {
          continue;
        }
        this.d.getConnectionManager().shutdown();
      }
      this.d = iz.b(new BasicHttpParams());
      a((AbstractHttpMessage)localObject2, this.h);
      str = EntityUtils.toString(this.d.execute(this.c, (HttpRequest)localObject2, new BasicHttpContext()).getEntity()).toString();
      localObject2 = new JSONObject(str);
    }
  }
  
  protected void a(JSONObject paramJSONObject)
  {
    try
    {
      paramJSONObject = new fq(paramJSONObject);
      if (this.g != null)
      {
        this.g.a(paramJSONObject, this.f, gx.c, this.h);
        return;
      }
      this.f.a(paramJSONObject);
      return;
    }
    catch (Exception paramJSONObject)
    {
      ja.a(6, a, "Exception in onPostExecute: ", paramJSONObject);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/gy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */