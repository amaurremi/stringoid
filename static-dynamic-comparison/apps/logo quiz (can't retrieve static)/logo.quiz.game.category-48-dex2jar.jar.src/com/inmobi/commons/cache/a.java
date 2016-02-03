package com.inmobi.commons.cache;

import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.uid.UIDUtil;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

class a
  extends ProductConfig
{
  CacheController.Validator a = null;
  AtomicBoolean b = new AtomicBoolean(false);
  Map<String, String> c = new HashMap();
  RetryMechanism d = new RetryMechanism(3, 60000);
  private CacheController.e e;
  private long f;
  
  public a(JSONObject paramJSONObject)
  {
    try
    {
      a(paramJSONObject);
      return;
    }
    catch (Exception paramJSONObject) {}
  }
  
  public a(JSONObject paramJSONObject, CacheController.e parame)
  {
    this(paramJSONObject);
    this.e = parame;
  }
  
  private void b()
    throws IOException
  {
    for (;;)
    {
      String str;
      try
      {
        b localb = d();
        str = localb.a;
        if (str == null) {
          break;
        }
        if (this.a != null)
        {
          str = this.a.validate(str);
          if (str != null)
          {
            this.data = str;
            this.timestamp = ((int)(System.currentTimeMillis() / 1000L));
            this.f = localb.b;
            this.e.a();
            this.b.set(false);
            return;
          }
          throw new IOException("Invalid config.");
        }
      }
      catch (IOException localIOException)
      {
        Log.internal("IMCOMMONS_3.7.1", "Error connecting to url, or " + this.url + " did not return 200. Purge cache update.");
        this.b.set(false);
        throw localIOException;
      }
      this.data = str;
    }
    this.timestamp = ((int)(System.currentTimeMillis() / 1000L));
    this.f = localIOException.b;
    this.e.a();
    this.b.set(false);
  }
  
  private void c()
  {
    if (this.b.compareAndSet(false, true)) {
      this.d.rescheduleTimer(new a());
    }
  }
  
  private b d()
    throws IOException
  {
    Object localObject2 = "";
    Object localObject1 = UIDUtil.bindToGetParam(this.c);
    if ((localObject1 != null) && (!"".equals(localObject1))) {
      if (this.url.endsWith("?")) {
        localObject1 = this.url + (String)localObject1;
      }
    }
    Object localObject3;
    int i;
    for (;;)
    {
      localObject3 = new URL((String)localObject1);
      Log.internal("IMCOMMONS_3.7.1", "Sending request to " + (String)localObject1 + " to retreive cache..");
      localObject3 = (HttpURLConnection)((URL)localObject3).openConnection();
      ((HttpURLConnection)localObject3).setIfModifiedSince(this.f);
      ((HttpURLConnection)localObject3).setRequestMethod("GET");
      i = ((HttpURLConnection)localObject3).getResponseCode();
      if (i != 304) {
        break;
      }
      localObject1 = new b(null);
      ((b)localObject1).a = null;
      ((b)localObject1).b = ((HttpURLConnection)localObject3).getLastModified();
      return (b)localObject1;
      if (this.url.contains("?"))
      {
        localObject1 = this.url + "&" + (String)localObject1;
      }
      else
      {
        localObject1 = this.url + "?" + (String)localObject1;
        continue;
        localObject1 = this.url;
      }
    }
    if (i != 200) {
      throw new IOException("Server did not return 200. ");
    }
    BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(((HttpURLConnection)localObject3).getInputStream()));
    for (localObject1 = localObject2;; localObject1 = (String)localObject1 + (String)localObject2)
    {
      localObject2 = localBufferedReader.readLine();
      if (localObject2 == null) {
        break;
      }
    }
    localBufferedReader.close();
    localObject2 = new b(null);
    ((b)localObject2).a = ((String)localObject1);
    ((b)localObject2).b = ((HttpURLConnection)localObject3).getLastModified();
    return (b)localObject2;
  }
  
  public String a(CacheController.Validator paramValidator)
  {
    if (paramValidator != null) {
      this.a = paramValidator;
    }
    this.retryNumber = 0;
    int i = (int)(System.currentTimeMillis() / 1000L);
    if (this.timestamp + this.expiry - i <= 0) {
      c();
    }
    return this.data;
  }
  
  public String a(Map<String, String> paramMap, CacheController.Validator paramValidator)
  {
    if (paramMap != null) {
      this.c = paramMap;
    }
    return a(paramValidator);
  }
  
  /* Error */
  public JSONObject a()
  {
    // Byte code:
    //   0: new 242	org/json/JSONObject
    //   3: dup
    //   4: invokespecial 243	org/json/JSONObject:<init>	()V
    //   7: astore_1
    //   8: new 242	org/json/JSONObject
    //   11: dup
    //   12: new 111	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   19: ldc -11
    //   21: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: aload_0
    //   25: getfield 230	com/inmobi/commons/cache/a:expiry	I
    //   28: invokevirtual 248	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   31: ldc -6
    //   33: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: ldc -4
    //   38: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: aload_0
    //   42: getfield 255	com/inmobi/commons/cache/a:maxRetry	I
    //   45: invokevirtual 248	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   48: ldc -6
    //   50: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: ldc_w 257
    //   56: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: aload_0
    //   60: getfield 260	com/inmobi/commons/cache/a:retryInterval	I
    //   63: invokevirtual 248	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   66: ldc -6
    //   68: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: ldc_w 262
    //   74: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: aload_0
    //   78: getfield 265	com/inmobi/commons/cache/a:protocol	Ljava/lang/String;
    //   81: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: ldc_w 267
    //   87: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: aload_0
    //   91: getfield 91	com/inmobi/commons/cache/a:timestamp	I
    //   94: invokevirtual 248	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   97: ldc_w 269
    //   100: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   106: invokespecial 270	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   109: astore_2
    //   110: aload_2
    //   111: ldc_w 271
    //   114: aload_0
    //   115: getfield 121	com/inmobi/commons/cache/a:url	Ljava/lang/String;
    //   118: invokevirtual 275	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   121: pop
    //   122: aload_2
    //   123: ldc_w 276
    //   126: aload_0
    //   127: getfield 79	com/inmobi/commons/cache/a:data	Ljava/lang/String;
    //   130: invokevirtual 275	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   133: pop
    //   134: aload_2
    //   135: ldc_w 278
    //   138: aload_0
    //   139: getfield 95	com/inmobi/commons/cache/a:f	J
    //   142: invokevirtual 281	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   145: pop
    //   146: aload_2
    //   147: areturn
    //   148: astore_2
    //   149: ldc 109
    //   151: new 111	java/lang/StringBuilder
    //   154: dup
    //   155: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   158: ldc_w 283
    //   161: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: aload_0
    //   165: getfield 121	com/inmobi/commons/cache/a:url	Ljava/lang/String;
    //   168: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: ldc_w 285
    //   174: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   180: aload_2
    //   181: invokestatic 288	com/inmobi/commons/internal/Log:internal	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   184: aload_1
    //   185: areturn
    //   186: astore_3
    //   187: aload_2
    //   188: astore_1
    //   189: aload_3
    //   190: astore_2
    //   191: goto -42 -> 149
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	194	0	this	a
    //   7	182	1	localObject1	Object
    //   109	38	2	localJSONObject	JSONObject
    //   148	40	2	localJSONException1	org.json.JSONException
    //   190	1	2	localObject2	Object
    //   186	4	3	localJSONException2	org.json.JSONException
    // Exception table:
    //   from	to	target	type
    //   8	110	148	org/json/JSONException
    //   110	146	186	org/json/JSONException
  }
  
  public void a(JSONObject paramJSONObject)
  {
    this.expiry = ((int)InternalSDKUtil.getLongFromJSON(paramJSONObject, "expiry", 432000L));
    this.maxRetry = ((int)InternalSDKUtil.getLongFromJSON(paramJSONObject, "maxRetry", 3L));
    this.retryInterval = ((int)InternalSDKUtil.getLongFromJSON(paramJSONObject, "retryInterval", 60L));
    this.f = InternalSDKUtil.getLongFromJSON(paramJSONObject, "lastModified", 0L);
    this.url = InternalSDKUtil.getStringFromJSON(paramJSONObject, "url", "");
    this.protocol = InternalSDKUtil.getStringFromJSON(paramJSONObject, "protocol", "json");
    this.d = new RetryMechanism(this.maxRetry, this.retryInterval * 1000);
    this.timestamp = ((int)InternalSDKUtil.getLongFromJSON(paramJSONObject, "timestamp", 0L));
    this.data = InternalSDKUtil.getStringFromJSON(paramJSONObject, "data", null);
  }
  
  public String toString()
  {
    return a().toString();
  }
  
  class a
    implements RetryMechanism.RetryRunnable
  {
    a() {}
    
    public void completed() {}
    
    public void run()
      throws Exception
    {
      try
      {
        if (InternalSDKUtil.checkNetworkAvailibility(InternalSDKUtil.getContext())) {
          a.a(a.this);
        }
        return;
      }
      catch (Exception localException)
      {
        a.this.b.set(false);
        throw localException;
      }
    }
  }
  
  private class b
  {
    String a;
    long b;
    
    private b() {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/inmobi/commons/cache/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */