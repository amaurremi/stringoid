package com.scoreloop.client.android.core.server;

import com.scoreloop.client.android.core.utils.Logger;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import org.apache.http.client.methods.HttpPost;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class a
{
  private String a = null;
  private Boolean b = Boolean.valueOf(false);
  private b c;
  private final BayeuxConnectionObserver d;
  private String e;
  private URI f;
  
  a(URL paramURL, BayeuxConnectionObserver paramBayeuxConnectionObserver, byte[] paramArrayOfByte)
  {
    if (paramBayeuxConnectionObserver == null) {
      throw new IllegalArgumentException("Observer can't be null");
    }
    try
    {
      this.f = paramURL.toURI();
      this.d = paramBayeuxConnectionObserver;
      if (paramArrayOfByte != null)
      {
        this.c = new d(this.f, paramArrayOfByte);
        return;
      }
    }
    catch (URISyntaxException paramURL)
    {
      throw new IllegalArgumentException("Malformed URL");
    }
    this.c = new b(this.f);
  }
  
  private void a(a parama, Integer paramInteger, JSONObject paramJSONObject1, String paramString, JSONObject paramJSONObject2)
    throws e
  {
    if (paramString == null) {
      throw new IllegalArgumentException("Request's channel can't be null !");
    }
    if (this.a == null)
    {
      Logger.a("BayeuxConnection", "executeRequest(): about to handshake");
      b(parama);
      Logger.a("ServerCommThread", "executeRequest(): handshake completed");
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("clientId", b());
      localJSONObject.put("channel", paramString);
      localJSONObject.put("data", paramJSONObject1);
      localJSONObject.put("id", paramInteger);
      paramInteger = paramJSONObject2;
      if (this.e != null)
      {
        paramInteger = paramJSONObject2;
        if (paramJSONObject2 == null) {
          paramInteger = new JSONObject();
        }
        paramInteger.put("token", this.e);
      }
      localJSONObject.putOpt("ext", paramInteger);
      a(parama, localJSONObject);
      return;
    }
    catch (JSONException parama)
    {
      throw new e(parama);
    }
  }
  
  private void a(a parama, JSONObject paramJSONObject)
    throws e
  {
    Object localObject1 = new JSONArray();
    ((JSONArray)localObject1).put(paramJSONObject);
    parama = a.a(parama);
    paramJSONObject = this.c.a(parama, (JSONArray)localObject1);
    int m = paramJSONObject.length();
    int i = 0;
    int j = 0;
    if (i < m) {
      for (;;)
      {
        String str;
        Object localObject2;
        try
        {
          localObject1 = paramJSONObject.getJSONObject(i);
          str = ((JSONObject)localObject1).getString("channel");
          localObject2 = ((JSONObject)localObject1).opt("data");
          if (((JSONObject)localObject1).has("id"))
          {
            parama = Integer.valueOf(((JSONObject)localObject1).optInt("id"));
            JSONObject localJSONObject = ((JSONObject)localObject1).optJSONObject("ext");
            if (localJSONObject != null)
            {
              int k = localJSONObject.optInt("status");
              j = k;
              if (localJSONObject.has("token"))
              {
                this.e = localJSONObject.getString("token");
                j = k;
              }
            }
            if (!"/meta/handshake".equalsIgnoreCase(str)) {
              break label184;
            }
            c((JSONObject)localObject1);
            i += 1;
            break;
          }
          parama = null;
          continue;
          if (!"/meta/connect".equalsIgnoreCase(str)) {
            break label203;
          }
        }
        catch (JSONException parama)
        {
          throw new g();
        }
        label184:
        a((JSONObject)localObject1);
        continue;
        label203:
        if ("/meta/disconnect".equalsIgnoreCase(str)) {
          b((JSONObject)localObject1);
        } else {
          this.d.a(this, parama, localObject2, str, j);
        }
      }
    }
  }
  
  private void a(JSONObject paramJSONObject)
    throws e
  {}
  
  private void b(a parama)
    throws e
  {
    JSONObject localJSONObject1 = new JSONObject();
    try
    {
      localJSONObject1.put("channel", "/meta/handshake");
      localJSONObject1.put("version", "1");
      Object localObject = new JSONArray();
      ((JSONArray)localObject).put("request-response");
      localJSONObject1.put("supportedConnectionTypes", localObject);
      localObject = new JSONObject();
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("version", "3");
      ((JSONObject)localObject).put("api", localJSONObject2);
      localJSONObject1.put("ext", localObject);
      a(parama, this.d.b(this, localJSONObject1));
      return;
    }
    catch (JSONException parama)
    {
      throw new IllegalStateException();
    }
  }
  
  private void b(JSONObject paramJSONObject)
    throws e
  {}
  
  private void c(JSONObject paramJSONObject)
    throws e
  {
    try
    {
      this.a = paramJSONObject.getString("clientId");
      this.b = Boolean.valueOf(true);
      this.d.a(this, paramJSONObject);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      throw new g(paramJSONObject);
    }
  }
  
  a a()
  {
    return new a(this.c, null);
  }
  
  void a(a parama)
    throws e
  {
    a(parama, Integer.valueOf(parama.a), parama.c, parama.b, parama.d);
  }
  
  void a(String paramString)
  {
    this.c.a(paramString);
  }
  
  String b()
  {
    return this.a;
  }
  
  void b(String paramString)
  {
    this.c.b(paramString);
  }
  
  class a
  {
    protected int a;
    protected String b;
    protected JSONObject c;
    protected JSONObject d;
    private HttpPost f = null;
    
    private a(b paramb) {}
    
    private HttpPost b()
    {
      try
      {
        this.f = a.a(a.this).a();
        HttpPost localHttpPost = this.f;
        return localHttpPost;
      }
      finally {}
    }
    
    public void a()
    {
      try
      {
        if (this.f != null) {
          this.f.abort();
        }
        return;
      }
      finally {}
    }
    
    public void a(int paramInt, String paramString, JSONObject paramJSONObject1, JSONObject paramJSONObject2)
    {
      this.a = paramInt;
      this.b = paramString;
      this.c = paramJSONObject1;
      this.d = paramJSONObject2;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/scoreloop/client/android/core/server/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */