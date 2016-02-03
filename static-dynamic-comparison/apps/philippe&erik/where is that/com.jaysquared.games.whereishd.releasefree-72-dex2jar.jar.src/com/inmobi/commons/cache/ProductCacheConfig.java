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
import java.util.Timer;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public class ProductCacheConfig
  extends ProductConfig
{
  public static final int DEFAULT_EXPIRY = 432000;
  public static final int DEFAULT_INTERVAL = 60;
  public static final int DEFAULT_MAX_RETRY = 3;
  private static Timer a = new Timer();
  private AtomicBoolean b = new AtomicBoolean(false);
  private Map<String, String> c = new HashMap();
  private CacheController.Validator d = null;
  private RetryMechanism e = new RetryMechanism(3, 60000, a);
  private CacheController.Committer f;
  private long g;
  
  public ProductCacheConfig(JSONObject paramJSONObject)
  {
    try
    {
      loadFromJSON(paramJSONObject);
      return;
    }
    catch (Exception paramJSONObject)
    {
      Log.internal("[InMobi]-4.1.1", "JSON retrieved is invalid.");
    }
  }
  
  public ProductCacheConfig(JSONObject paramJSONObject, CacheController.Committer paramCommitter)
  {
    this(paramJSONObject);
    this.f = paramCommitter;
  }
  
  private void a()
    throws Exception
  {
    for (;;)
    {
      String str;
      try
      {
        b localb = c();
        str = b.a(localb);
        if (str == null) {
          break;
        }
        if (this.d != null)
        {
          if (this.d.validate(a(str)))
          {
            setData(str);
            setTimestamp((int)(System.currentTimeMillis() / 1000L));
            this.g = b.b(localb);
            Log.internal("[InMobi]-4.1.1", "Product with url " + getUrl() + " accepted data " + getRawData());
            this.f.onCommit();
            return;
          }
          throw new IOException("Invalid config.");
        }
      }
      catch (Exception localException)
      {
        Log.internal("[InMobi]-4.1.1", "Error connecting to url, or " + getUrl() + " did not return 200. Purge cache update.", localException);
        throw localException;
      }
      setData(str);
    }
    setTimestamp((int)(System.currentTimeMillis() / 1000L));
    this.g = b.b(localException);
    this.f.onCommit();
  }
  
  private void b()
  {
    if (!this.b.compareAndSet(false, true)) {
      return;
    }
    this.e.rescheduleTimer(new a());
  }
  
  private b c()
    throws IOException
  {
    Object localObject2 = "";
    Object localObject1 = UIDUtil.bindToGetParam(this.c);
    if ((localObject1 != null) && (!"".equals(localObject1))) {
      if (getUrl().endsWith("?")) {
        localObject1 = getUrl() + (String)localObject1;
      }
    }
    Object localObject3;
    int i;
    for (;;)
    {
      localObject3 = new URL((String)localObject1);
      Log.internal("[InMobi]-4.1.1", "Sending request to " + (String)localObject1 + " to retreive cache..");
      localObject3 = (HttpURLConnection)((URL)localObject3).openConnection();
      InternalSDKUtil.addCommonPropertiesToConnection((HttpURLConnection)localObject3);
      ((HttpURLConnection)localObject3).setIfModifiedSince(this.g);
      ((HttpURLConnection)localObject3).setRequestMethod("GET");
      i = ((HttpURLConnection)localObject3).getResponseCode();
      if (i != 304) {
        break;
      }
      localObject1 = new b(null);
      b.a((b)localObject1, null);
      b.a((b)localObject1, ((HttpURLConnection)localObject3).getLastModified());
      return (b)localObject1;
      if (getUrl().contains("?"))
      {
        localObject1 = getUrl() + "&" + (String)localObject1;
      }
      else
      {
        localObject1 = getUrl() + "?" + (String)localObject1;
        continue;
        localObject1 = getUrl();
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
    b.a((b)localObject2, (String)localObject1);
    b.a((b)localObject2, ((HttpURLConnection)localObject3).getLastModified());
    return (b)localObject2;
  }
  
  public ProductConfig getConfig()
  {
    return this;
  }
  
  public String getData(CacheController.Validator paramValidator)
  {
    if (paramValidator != null) {
      this.d = paramValidator;
    }
    setRetryNumber(0);
    int i = (int)(System.currentTimeMillis() / 1000L);
    if (getTimestamp() + getExpiry() - i <= 0) {
      b();
    }
    return getRawData();
  }
  
  public String getData(Map<String, String> paramMap, CacheController.Validator paramValidator)
  {
    if (paramMap != null) {
      this.c = paramMap;
    }
    return getData(paramValidator);
  }
  
  public Map<String, String> getMap()
  {
    return this.c;
  }
  
  public CacheController.Validator getValidator()
  {
    return this.d;
  }
  
  public final void loadFromJSON(JSONObject paramJSONObject)
  {
    setExpiry(InternalSDKUtil.getIntFromJSON(paramJSONObject, "expiry", 432000));
    setMaxRetry(InternalSDKUtil.getIntFromJSON(paramJSONObject, "maxRetry", 3));
    setRetryInterval(InternalSDKUtil.getIntFromJSON(paramJSONObject, "retryInterval", 60));
    this.g = InternalSDKUtil.getLongFromJSON(paramJSONObject, "lastModified", 0L);
    setUrl(InternalSDKUtil.getStringFromJSON(paramJSONObject, "url", ""));
    setProtocol(InternalSDKUtil.getStringFromJSON(paramJSONObject, "protocol", "json"));
    this.e = new RetryMechanism(getMaxRetry(), getRetryInterval() * 1000, a);
    setTimestamp(InternalSDKUtil.getIntFromJSON(paramJSONObject, "timestamp", 0));
    setData(InternalSDKUtil.getStringFromJSON(paramJSONObject, "data", null));
  }
  
  protected void reset()
  {
    setExpiry(0);
    setRetryInterval(0);
    setMaxRetry(0);
    setTimestamp(0);
    setUrl(null);
    setProtocol(null);
    setData(null);
  }
  
  public void setMap(Map<String, String> paramMap)
  {
    this.c = paramMap;
  }
  
  public void setValidator(CacheController.Validator paramValidator)
  {
    this.d = paramValidator;
  }
  
  /* Error */
  public JSONObject toJSON()
  {
    // Byte code:
    //   0: new 354	org/json/JSONObject
    //   3: dup
    //   4: invokespecial 355	org/json/JSONObject:<init>	()V
    //   7: astore_1
    //   8: new 354	org/json/JSONObject
    //   11: dup
    //   12: new 122	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   19: ldc_w 357
    //   22: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: aload_0
    //   26: invokevirtual 279	com/inmobi/commons/cache/ProductCacheConfig:getExpiry	()I
    //   29: invokevirtual 360	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   32: ldc_w 362
    //   35: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: ldc_w 364
    //   41: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: aload_0
    //   45: invokevirtual 335	com/inmobi/commons/cache/ProductCacheConfig:getMaxRetry	()I
    //   48: invokevirtual 360	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   51: ldc_w 362
    //   54: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: ldc_w 366
    //   60: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: aload_0
    //   64: invokevirtual 338	com/inmobi/commons/cache/ProductCacheConfig:getRetryInterval	()I
    //   67: invokevirtual 360	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   70: ldc_w 362
    //   73: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: ldc_w 368
    //   79: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: aload_0
    //   83: invokevirtual 371	com/inmobi/commons/cache/ProductCacheConfig:getProtocol	()Ljava/lang/String;
    //   86: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: ldc_w 373
    //   92: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: aload_0
    //   96: invokevirtual 276	com/inmobi/commons/cache/ProductCacheConfig:getTimestamp	()I
    //   99: invokevirtual 360	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   102: ldc_w 375
    //   105: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   111: invokespecial 376	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   114: astore_2
    //   115: aload_2
    //   116: ldc_w 318
    //   119: aload_0
    //   120: invokevirtual 133	com/inmobi/commons/cache/ProductCacheConfig:getUrl	()Ljava/lang/String;
    //   123: invokevirtual 380	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   126: pop
    //   127: aload_2
    //   128: ldc_w 342
    //   131: aload_0
    //   132: invokevirtual 138	com/inmobi/commons/cache/ProductCacheConfig:getRawData	()Ljava/lang/String;
    //   135: invokevirtual 380	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   138: pop
    //   139: aload_2
    //   140: ldc_w 312
    //   143: aload_0
    //   144: getfield 120	com/inmobi/commons/cache/ProductCacheConfig:g	J
    //   147: invokevirtual 383	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   150: pop
    //   151: aload_2
    //   152: areturn
    //   153: astore_2
    //   154: ldc 71
    //   156: new 122	java/lang/StringBuilder
    //   159: dup
    //   160: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   163: ldc_w 385
    //   166: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: aload_0
    //   170: invokevirtual 133	com/inmobi/commons/cache/ProductCacheConfig:getUrl	()Ljava/lang/String;
    //   173: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: ldc_w 387
    //   179: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   185: aload_2
    //   186: invokestatic 159	com/inmobi/commons/internal/Log:internal	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   189: aload_1
    //   190: areturn
    //   191: astore_3
    //   192: aload_2
    //   193: astore_1
    //   194: aload_3
    //   195: astore_2
    //   196: goto -42 -> 154
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	199	0	this	ProductCacheConfig
    //   7	187	1	localObject1	Object
    //   114	38	2	localJSONObject	JSONObject
    //   153	40	2	localJSONException1	org.json.JSONException
    //   195	1	2	localObject2	Object
    //   191	4	3	localJSONException2	org.json.JSONException
    // Exception table:
    //   from	to	target	type
    //   8	115	153	org/json/JSONException
    //   115	151	191	org/json/JSONException
  }
  
  public String toString()
  {
    return toJSON().toString();
  }
  
  class a
    implements RetryMechanism.RetryRunnable
  {
    a() {}
    
    public void completed()
    {
      ProductCacheConfig.b(ProductCacheConfig.this).set(false);
    }
    
    public void run()
      throws Exception
    {
      try
      {
        if (InternalSDKUtil.checkNetworkAvailibility(InternalSDKUtil.getContext()))
        {
          ProductCacheConfig.a(ProductCacheConfig.this);
          return;
        }
        throw new IOException("Network unavailable");
      }
      catch (Exception localException)
      {
        throw localException;
      }
    }
  }
  
  private class b
  {
    private String b;
    private long c;
    
    private b() {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/inmobi/commons/cache/ProductCacheConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */