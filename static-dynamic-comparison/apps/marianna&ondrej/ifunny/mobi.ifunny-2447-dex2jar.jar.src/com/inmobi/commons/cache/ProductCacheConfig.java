package com.inmobi.commons.cache;

import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.network.RequestBuilderUtils;

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
        extends ProductConfig {
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

    public ProductCacheConfig(JSONObject paramJSONObject) {
        try {
            loadFromJSON(paramJSONObject);
            return;
        } catch (Exception paramJSONObject) {
            Log.internal("[InMobi]-4.5.1", "JSON retrieved is invalid.");
        }
    }

    public ProductCacheConfig(JSONObject paramJSONObject, CacheController.Committer paramCommitter) {
        this(paramJSONObject);
        this.f = paramCommitter;
    }

    private void a() {
        for (; ; ) {
            String str;
            try {
                ProductCacheConfig.b localb = c();
                str = ProductCacheConfig.b.a(localb);
                if (str == null) {
                    break;
                }
                if (this.d != null) {
                    if (this.d.validate(a(str))) {
                        setData(str);
                        setTimestamp((int) (System.currentTimeMillis() / 1000L));
                        this.g = ProductCacheConfig.b.b(localb);
                        Log.internal("[InMobi]-4.5.1", "Product with url " + getUrl() + " accepted data " + getRawData());
                        this.f.onCommit();
                        return;
                    }
                    throw new IOException("Invalid config.");
                }
            } catch (Exception localException) {
                Log.internal("[InMobi]-4.5.1", "Error connecting to url, or " + getUrl() + " did not return 200. Purge cache update.", localException);
                throw localException;
            }
            setData(str);
        }
        setTimestamp((int) (System.currentTimeMillis() / 1000L));
        this.g = ProductCacheConfig.b.b(localException);
        this.f.onCommit();
    }

    private void b() {
        if (!this.b.compareAndSet(false, true)) {
            return;
        }
        this.e.rescheduleTimer(new ProductCacheConfig.a(this));
    }

    private ProductCacheConfig.b c() {
        Object localObject2 = "";
        Object localObject1 = new HashMap();
        RequestBuilderUtils.fillIdentityMap((Map) localObject1, null, true);
        RequestBuilderUtils.fillAppInfoMap((Map) localObject1);
        localObject1 = InternalSDKUtil.encodeMapAndconvertToDelimitedString((Map) localObject1, "&");
        if ((localObject1 != null) && (!"".equals(localObject1))) {
            if (getUrl().endsWith("?")) {
                localObject1 = getUrl() + (String) localObject1;
            }
        }
        Object localObject3;
        int i;
        for (; ; ) {
            localObject3 = new URL((String) localObject1);
            Log.internal("[InMobi]-4.5.1", "Sending request to " + (String) localObject1 + " to retreive cache..");
            localObject3 = (HttpURLConnection) ((URL) localObject3).openConnection();
            ((HttpURLConnection) localObject3).setRequestProperty("User-Agent", InternalSDKUtil.getUserAgent());
            ((HttpURLConnection) localObject3).setIfModifiedSince(this.g);
            ((HttpURLConnection) localObject3).setRequestMethod("GET");
            i = ((HttpURLConnection) localObject3).getResponseCode();
            if (i != 304) {
                break;
            }
            localObject1 = new ProductCacheConfig.b(this, null);
            ProductCacheConfig.b.a((ProductCacheConfig.b) localObject1, null);
            ProductCacheConfig.b.a((ProductCacheConfig.b) localObject1, ((HttpURLConnection) localObject3).getLastModified());
            return (ProductCacheConfig.b) localObject1;
            if (getUrl().contains("?")) {
                localObject1 = getUrl() + "&" + (String) localObject1;
            } else {
                localObject1 = getUrl() + "?" + (String) localObject1;
                continue;
                localObject1 = getUrl();
            }
        }
        if (i != 200) {
            throw new IOException("Server did not return 200. ");
        }
        BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(((HttpURLConnection) localObject3).getInputStream()));
        for (localObject1 = localObject2; ; localObject1 = (String) localObject1 + (String) localObject2) {
            localObject2 = localBufferedReader.readLine();
            if (localObject2 == null) {
                break;
            }
        }
        localBufferedReader.close();
        localObject2 = new ProductCacheConfig.b(this, null);
        ProductCacheConfig.b.a((ProductCacheConfig.b) localObject2, (String) localObject1);
        ProductCacheConfig.b.a((ProductCacheConfig.b) localObject2, ((HttpURLConnection) localObject3).getLastModified());
        return (ProductCacheConfig.b) localObject2;
    }

    public ProductConfig getConfig() {
        return this;
    }

    public String getData(CacheController.Validator paramValidator) {
        if (paramValidator != null) {
            this.d = paramValidator;
        }
        setRetryNumber(0);
        int i = (int) (System.currentTimeMillis() / 1000L);
        if (getTimestamp() + getExpiry() - i <= 0) {
            b();
        }
        return getRawData();
    }

    public String getData(Map<String, String> paramMap, CacheController.Validator paramValidator) {
        if (paramMap != null) {
            this.c = paramMap;
        }
        return getData(paramValidator);
    }

    public Map<String, String> getMap() {
        return this.c;
    }

    public CacheController.Validator getValidator() {
        return this.d;
    }

    public final void loadFromJSON(JSONObject paramJSONObject) {
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

    protected void reset() {
        setExpiry(0);
        setRetryInterval(0);
        setMaxRetry(0);
        setTimestamp(0);
        setUrl(null);
        setProtocol(null);
        setData(null);
    }

    public void setMap(Map<String, String> paramMap) {
        this.c = paramMap;
    }

    public void setValidator(CacheController.Validator paramValidator) {
        this.d = paramValidator;
    }

    /* Error */
    public JSONObject toJSON() {
        // Byte code:
        //   0: new 364	org/json/JSONObject
        //   3: dup
        //   4: invokespecial 365	org/json/JSONObject:<init>	()V
        //   7: astore_1
        //   8: new 364	org/json/JSONObject
        //   11: dup
        //   12: new 120	java/lang/StringBuilder
        //   15: dup
        //   16: invokespecial 121	java/lang/StringBuilder:<init>	()V
        //   19: ldc_w 367
        //   22: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   25: aload_0
        //   26: invokevirtual 290	com/inmobi/commons/cache/ProductCacheConfig:getExpiry	()I
        //   29: invokevirtual 370	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   32: ldc_w 372
        //   35: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   38: ldc_w 374
        //   41: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   44: aload_0
        //   45: invokevirtual 346	com/inmobi/commons/cache/ProductCacheConfig:getMaxRetry	()I
        //   48: invokevirtual 370	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   51: ldc_w 372
        //   54: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   57: ldc_w 376
        //   60: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   63: aload_0
        //   64: invokevirtual 349	com/inmobi/commons/cache/ProductCacheConfig:getRetryInterval	()I
        //   67: invokevirtual 370	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   70: ldc_w 372
        //   73: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   76: ldc_w 378
        //   79: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   82: aload_0
        //   83: invokevirtual 381	com/inmobi/commons/cache/ProductCacheConfig:getProtocol	()Ljava/lang/String;
        //   86: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   89: ldc_w 383
        //   92: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   95: aload_0
        //   96: invokevirtual 287	com/inmobi/commons/cache/ProductCacheConfig:getTimestamp	()I
        //   99: invokevirtual 370	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   102: ldc_w 385
        //   105: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   108: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   111: invokespecial 386	org/json/JSONObject:<init>	(Ljava/lang/String;)V
        //   114: astore_2
        //   115: aload_2
        //   116: ldc_w 329
        //   119: aload_0
        //   120: invokevirtual 131	com/inmobi/commons/cache/ProductCacheConfig:getUrl	()Ljava/lang/String;
        //   123: invokevirtual 390	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
        //   126: pop
        //   127: aload_2
        //   128: ldc_w 353
        //   131: aload_0
        //   132: invokevirtual 136	com/inmobi/commons/cache/ProductCacheConfig:getRawData	()Ljava/lang/String;
        //   135: invokevirtual 390	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
        //   138: pop
        //   139: aload_2
        //   140: ldc_w 323
        //   143: aload_0
        //   144: getfield 118	com/inmobi/commons/cache/ProductCacheConfig:g	J
        //   147: invokevirtual 393	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
        //   150: pop
        //   151: aload_2
        //   152: areturn
        //   153: astore_2
        //   154: ldc 67
        //   156: new 120	java/lang/StringBuilder
        //   159: dup
        //   160: invokespecial 121	java/lang/StringBuilder:<init>	()V
        //   163: ldc_w 395
        //   166: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   169: aload_0
        //   170: invokevirtual 131	com/inmobi/commons/cache/ProductCacheConfig:getUrl	()Ljava/lang/String;
        //   173: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   176: ldc_w 397
        //   179: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   182: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   185: aload_2
        //   186: invokestatic 157	com/inmobi/commons/internal/Log:internal	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
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

    public String toString() {
        return toJSON().toString();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/commons/cache/ProductCacheConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */