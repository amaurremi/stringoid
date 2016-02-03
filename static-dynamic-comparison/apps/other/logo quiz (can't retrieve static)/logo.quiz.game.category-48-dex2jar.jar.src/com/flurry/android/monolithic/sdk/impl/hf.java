package com.flurry.android.monolithic.sdk.impl;

import com.flurry.android.impl.appcloud.AppCloudModule;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
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

public class hf
  extends he
{
  protected static final String a = hf.class.getSimpleName();
  
  public hf(HashMap<String, Object> paramHashMap)
  {
    super(paramHashMap);
  }
  
  private oh a(List<NameValuePair> paramList)
    throws Exception
  {
    oh localoh = new oh(oe.b);
    int i = 0;
    if (i < paramList.size())
    {
      Object localObject;
      if (((NameValuePair)paramList.get(i)).getName().equals("file"))
      {
        localObject = ((NameValuePair)paramList.get(i)).getValue().split("/");
        localObject = localObject[(localObject.length - 1)];
        localoh.a("file", new ol(new File(((NameValuePair)paramList.get(i)).getValue()), (String)localObject, "application/octet-stream", "utf-8"));
      }
      for (;;)
      {
        i += 1;
        break;
        localObject = ((NameValuePair)paramList.get(i)).getName();
        if ((localObject != "filename") && (localObject != "file")) {
          localoh.a((String)localObject, new om(((NameValuePair)paramList.get(i)).getValue()));
        }
      }
    }
    return localoh;
  }
  
  public void a()
  {
    b("PostOperation Thread");
    for (;;)
    {
      try
      {
        this.f = ((fr)this.h.get("del"));
        this.g = ((fs)this.h.get("del_internal"));
        str = a((String)this.h.get("url"));
        localObject2 = new HttpPost(str);
        ja.a(4, a, "Put operation URL = " + str);
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
      ((HttpPost)localObject2).setEntity(a((List)this.h.get("data")));
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
        this.g.a(paramJSONObject, this.f, gx.a, this.h);
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/hf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */