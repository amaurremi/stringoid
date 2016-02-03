package com.inmobi.commons.cache;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.inmobi.commons.internal.CommonsException;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.uid.UIDUtil;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public final class CacheController
{
  private static Map<String, ProductCacheConfig> a = new HashMap();
  private static ProductCacheConfig b = null;
  private static boolean c = true;
  private static Map<String, Validator> d = new HashMap();
  private static Map<String, Map<String, String>> e = new HashMap();
  
  /* Error */
  static void a()
  {
    // Byte code:
    //   0: getstatic 44	com/inmobi/commons/cache/CacheController:d	Ljava/util/Map;
    //   3: astore_0
    //   4: aload_0
    //   5: monitorenter
    //   6: getstatic 44	com/inmobi/commons/cache/CacheController:d	Ljava/util/Map;
    //   9: invokeinterface 56 1 0
    //   14: invokeinterface 62 1 0
    //   19: astore_1
    //   20: aload_1
    //   21: invokeinterface 68 1 0
    //   26: ifeq +107 -> 133
    //   29: aload_1
    //   30: invokeinterface 72 1 0
    //   35: checkcast 74	java/lang/String
    //   38: astore_2
    //   39: invokestatic 80	com/inmobi/commons/internal/InternalSDKUtil:getContext	()Landroid/content/Context;
    //   42: invokestatic 84	com/inmobi/commons/internal/InternalSDKUtil:checkNetworkAvailibility	(Landroid/content/Context;)Z
    //   45: ifeq -25 -> 20
    //   48: getstatic 46	com/inmobi/commons/cache/CacheController:e	Ljava/util/Map;
    //   51: astore_3
    //   52: aload_3
    //   53: monitorenter
    //   54: getstatic 46	com/inmobi/commons/cache/CacheController:e	Ljava/util/Map;
    //   57: aload_2
    //   58: invokeinterface 88 2 0
    //   63: checkcast 52	java/util/Map
    //   66: astore 4
    //   68: aload_3
    //   69: monitorexit
    //   70: aload_2
    //   71: aconst_null
    //   72: aload 4
    //   74: getstatic 44	com/inmobi/commons/cache/CacheController:d	Ljava/util/Map;
    //   77: aload_2
    //   78: invokeinterface 88 2 0
    //   83: checkcast 9	com/inmobi/commons/cache/CacheController$Validator
    //   86: invokestatic 92	com/inmobi/commons/cache/CacheController:getConfig	(Ljava/lang/String;Landroid/content/Context;Ljava/util/Map;Lcom/inmobi/commons/cache/CacheController$Validator;)Lcom/inmobi/commons/cache/ProductConfig;
    //   89: pop
    //   90: goto -70 -> 20
    //   93: astore_3
    //   94: ldc 94
    //   96: new 96	java/lang/StringBuilder
    //   99: dup
    //   100: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   103: ldc 99
    //   105: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: aload_2
    //   109: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   115: invokestatic 113	com/inmobi/commons/internal/Log:internal	(Ljava/lang/String;Ljava/lang/String;)V
    //   118: goto -98 -> 20
    //   121: astore_1
    //   122: aload_0
    //   123: monitorexit
    //   124: aload_1
    //   125: athrow
    //   126: astore 4
    //   128: aload_3
    //   129: monitorexit
    //   130: aload 4
    //   132: athrow
    //   133: aload_0
    //   134: monitorexit
    //   135: getstatic 40	com/inmobi/commons/cache/CacheController:b	Lcom/inmobi/commons/cache/ProductCacheConfig;
    //   138: ifnull +14 -> 152
    //   141: getstatic 40	com/inmobi/commons/cache/CacheController:b	Lcom/inmobi/commons/cache/ProductCacheConfig;
    //   144: aconst_null
    //   145: checkcast 9	com/inmobi/commons/cache/CacheController$Validator
    //   148: invokevirtual 119	com/inmobi/commons/cache/ProductCacheConfig:getData	(Lcom/inmobi/commons/cache/CacheController$Validator;)Ljava/lang/String;
    //   151: pop
    //   152: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   3	131	0	localMap1	Map
    //   19	11	1	localIterator	Iterator
    //   121	4	1	localObject1	Object
    //   38	71	2	str	String
    //   93	36	3	localCommonsException	CommonsException
    //   66	7	4	localMap3	Map
    //   126	5	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   39	54	93	com/inmobi/commons/internal/CommonsException
    //   70	90	93	com/inmobi/commons/internal/CommonsException
    //   130	133	93	com/inmobi/commons/internal/CommonsException
    //   6	20	121	finally
    //   20	39	121	finally
    //   39	54	121	finally
    //   70	90	121	finally
    //   94	118	121	finally
    //   122	124	121	finally
    //   130	133	121	finally
    //   133	135	121	finally
    //   54	70	126	finally
    //   128	130	126	finally
  }
  
  private static boolean b(Map<String, Object> paramMap)
  {
    try
    {
      paramMap = InternalSDKUtil.populateToNewMap((Map)paramMap.get("AND"), (Map)paramMap.get("common"), true);
      c(paramMap);
      Iterator localIterator = paramMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = paramMap.get((String)localIterator.next());
        if ((localObject instanceof Map)) {
          c((Map)localObject);
        }
      }
      return true;
    }
    catch (Exception paramMap)
    {
      return false;
    }
  }
  
  private static void c(Map<String, Object> paramMap)
  {
    InternalSDKUtil.getIntFromMap(paramMap, "expiry", 1, 2147483647L);
    InternalSDKUtil.getIntFromMap(paramMap, "maxRetry", 0, 2147483647L);
    InternalSDKUtil.getIntFromMap(paramMap, "retryInterval", 1, 2147483647L);
    InternalSDKUtil.getStringFromMap(paramMap, "url");
    InternalSDKUtil.getStringFromMap(paramMap, "protocol");
  }
  
  private static void d()
  {
    InternalSDKUtil.getContext().registerReceiver(new d(), new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
  }
  
  private static void e()
  {
    Log.verbose("[InMobi]-4.1.1", "Bootstrapping cache.");
    LocalCache.initRoot();
    Iterator localIterator = LocalCache.getRoot().keys();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      try
      {
        Object localObject = LocalCache.getRoot().get(str);
        if ((localObject instanceof JSONObject))
        {
          localObject = new ProductCacheConfig((JSONObject)localObject, new c(str));
          ProductCacheConfig localProductCacheConfig = (ProductCacheConfig)a.get(str);
          if (localProductCacheConfig != null)
          {
            ((ProductCacheConfig)localObject).setValidator(localProductCacheConfig.getValidator());
            ((ProductCacheConfig)localObject).setMap(localProductCacheConfig.getMap());
          }
          a.put(str, localObject);
        }
      }
      catch (JSONException localJSONException)
      {
        Log.internal("[InMobi]-4.1.1", "Unable to dump config from persistent memory to products in memory", localJSONException);
      }
    }
    if (b == null)
    {
      b = new ProductCacheConfig(LocalCache.getRoot(), new b());
      b.getData(UIDUtil.getMap(InternalSDKUtil.getContext(), null), new a());
    }
    for (;;)
    {
      InternalSDKUtil.initialize(InternalSDKUtil.getContext());
      return;
      b.loadFromJSON(LocalCache.getRoot());
    }
  }
  
  /* Error */
  private static void f()
  {
    // Byte code:
    //   0: new 194	org/json/JSONObject
    //   3: dup
    //   4: getstatic 40	com/inmobi/commons/cache/CacheController:b	Lcom/inmobi/commons/cache/ProductCacheConfig;
    //   7: invokevirtual 248	com/inmobi/commons/cache/ProductCacheConfig:getRawData	()Ljava/lang/String;
    //   10: invokespecial 249	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   13: astore_0
    //   14: aload_0
    //   15: ldc 127
    //   17: invokevirtual 253	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   20: aload_0
    //   21: ldc -127
    //   23: invokevirtual 253	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   26: iconst_1
    //   27: invokestatic 257	com/inmobi/commons/internal/InternalSDKUtil:populateToNewJSON	(Lorg/json/JSONObject;Lorg/json/JSONObject;Z)Lorg/json/JSONObject;
    //   30: astore_0
    //   31: aload_0
    //   32: ldc_w 259
    //   35: invokestatic 265	java/lang/System:currentTimeMillis	()J
    //   38: ldc2_w 266
    //   41: ldiv
    //   42: l2i
    //   43: invokevirtual 270	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   46: pop
    //   47: aload_0
    //   48: invokevirtual 197	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   51: astore_1
    //   52: aload_1
    //   53: invokeinterface 68 1 0
    //   58: ifeq +119 -> 177
    //   61: aload_1
    //   62: invokeinterface 72 1 0
    //   67: checkcast 74	java/lang/String
    //   70: astore_3
    //   71: invokestatic 192	com/inmobi/commons/cache/LocalCache:getRoot	()Lorg/json/JSONObject;
    //   74: aload_3
    //   75: invokevirtual 200	org/json/JSONObject:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   78: astore_2
    //   79: aload_2
    //   80: instanceof 194
    //   83: ifeq -31 -> 52
    //   86: getstatic 38	com/inmobi/commons/cache/CacheController:a	Ljava/util/Map;
    //   89: aload_3
    //   90: invokeinterface 88 2 0
    //   95: checkcast 115	com/inmobi/commons/cache/ProductCacheConfig
    //   98: astore_3
    //   99: aload_3
    //   100: ifnull -48 -> 52
    //   103: aload_2
    //   104: checkcast 194	org/json/JSONObject
    //   107: ldc_w 259
    //   110: iconst_0
    //   111: invokevirtual 270	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   114: pop
    //   115: aload_2
    //   116: checkcast 194	org/json/JSONObject
    //   119: ldc_w 272
    //   122: aload_3
    //   123: invokevirtual 248	com/inmobi/commons/cache/ProductCacheConfig:getRawData	()Ljava/lang/String;
    //   126: invokevirtual 275	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   129: pop
    //   130: goto -78 -> 52
    //   133: astore_2
    //   134: ldc 94
    //   136: new 96	java/lang/StringBuilder
    //   139: dup
    //   140: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   143: ldc_w 277
    //   146: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: aload_2
    //   150: invokevirtual 280	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   153: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   159: invokestatic 283	com/inmobi/commons/internal/Log:debug	(Ljava/lang/String;Ljava/lang/String;)V
    //   162: goto -110 -> 52
    //   165: astore_1
    //   166: ldc 94
    //   168: ldc_w 285
    //   171: invokestatic 113	com/inmobi/commons/internal/Log:internal	(Ljava/lang/String;Ljava/lang/String;)V
    //   174: goto -127 -> 47
    //   177: aload_0
    //   178: invokestatic 288	com/inmobi/commons/cache/LocalCache:saveRoot	(Lorg/json/JSONObject;)V
    //   181: invokestatic 290	com/inmobi/commons/cache/CacheController:e	()V
    //   184: invokestatic 292	com/inmobi/commons/cache/CacheController:a	()V
    //   187: return
    //   188: astore_2
    //   189: goto -137 -> 52
    //   192: astore_0
    //   193: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   13	165	0	localJSONObject	JSONObject
    //   192	1	0	localJSONException1	JSONException
    //   51	11	1	localIterator	Iterator
    //   165	1	1	localJSONException2	JSONException
    //   78	38	2	localObject1	Object
    //   133	17	2	localException	Exception
    //   188	1	2	localJSONException3	JSONException
    //   70	53	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   71	79	133	java/lang/Exception
    //   79	99	133	java/lang/Exception
    //   103	130	133	java/lang/Exception
    //   31	47	165	org/json/JSONException
    //   71	79	188	org/json/JSONException
    //   0	31	192	org/json/JSONException
  }
  
  public static ProductConfig getConfig(String paramString, Context paramContext, Map<String, String> paramMap, Validator paramValidator)
    throws CommonsException
  {
    if (paramValidator != null) {}
    synchronized (d)
    {
      d.put(paramString, paramValidator);
      if (paramMap == null) {}
    }
    synchronized (e)
    {
      e.put(paramString, paramMap);
      if (!c) {
        break label103;
      }
      if (InternalSDKUtil.getContext() != null) {
        break label93;
      }
      if (paramContext == null)
      {
        throw new CommonsException(1);
        paramString = finally;
        throw paramString;
      }
    }
    InternalSDKUtil.setContext(paramContext);
    label93:
    c = false;
    e();
    d();
    label103:
    b.getData((Validator)null);
    paramString = (ProductCacheConfig)a.get(paramString);
    if (paramString == null) {
      throw new CommonsException(2);
    }
    paramString.getData(paramMap, paramValidator);
    return paramString;
  }
  
  public static abstract interface Committer
  {
    public abstract void onCommit();
  }
  
  public static abstract interface Validator
  {
    public abstract boolean validate(Map<String, Object> paramMap);
  }
  
  static final class a
    implements CacheController.Validator
  {
    public boolean validate(Map<String, Object> paramMap)
    {
      return CacheController.a(paramMap);
    }
  }
  
  static final class b
    implements CacheController.Committer
  {
    public void onCommit() {}
  }
  
  static final class c
    implements CacheController.Committer
  {
    c(String paramString) {}
    
    public void onCommit()
    {
      try
      {
        ProductCacheConfig localProductCacheConfig = (ProductCacheConfig)CacheController.b().get(this.a);
        if (localProductCacheConfig == null) {
          return;
        }
        LocalCache.addToCache(this.a, localProductCacheConfig.toJSON());
        return;
      }
      catch (JSONException localJSONException)
      {
        Log.internal("[InMobi]-4.1.1", "Unable to add json to persistent memory", localJSONException);
      }
    }
  }
  
  static final class d
    extends BroadcastReceiver
  {
    public void onReceive(Context paramContext, Intent paramIntent) {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/inmobi/commons/cache/CacheController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */