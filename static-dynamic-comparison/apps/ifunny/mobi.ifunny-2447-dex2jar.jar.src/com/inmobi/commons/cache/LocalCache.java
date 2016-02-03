package com.inmobi.commons.cache;

import com.inmobi.commons.internal.FileOperations;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import org.json.JSONException;
import org.json.JSONObject;

public final class LocalCache {
    public static final String FILENAME = "inmobi.cache";
    private static String a = "{url:'https://inmobisdk-a.akamaihd.net/sdk/configs/400/rootConfig.json'}";
    private static JSONObject b = new JSONObject();

    public static JSONObject addToCache(String paramString, JSONObject paramJSONObject) {
        synchronized (b) {
            if (b.toString().equals("{}")) {
                initRoot();
            }
            b.put(paramString, paramJSONObject);
            b();
            return null;
        }
    }

    private static void b() {
        new Thread(new LocalCache.a()).start();
    }

    private static void c() {
        synchronized (b) {
            try {
                String str = b.toString();
                FileOperations.writeStringToFile(InternalSDKUtil.getContext(), "inmobi.cache", str, false);
                return;
            } catch (Exception localException) {
                for (; ; ) {
                    Log.internal("[InMobi]-4.5.1", "Unable to save all configs to persistent memory", localException);
                }
            }
        }
    }

    public static JSONObject getCacheForProduct(String paramString) {
        if (b.toString().equals("{}")) {
            initRoot();
        }
        try {
            paramString = b.getJSONObject(paramString);
            return paramString;
        } catch (JSONException paramString) {
        }
        return null;
    }

    public static JSONObject getRoot() {
        return b;
    }

    /* Error */
    public static void initRoot() {
        // Byte code:
        //   0: getstatic 24	com/inmobi/commons/cache/LocalCache:b	Lorg/json/JSONObject;
        //   3: invokevirtual 35	org/json/JSONObject:toString	()Ljava/lang/String;
        //   6: ldc 37
        //   8: invokevirtual 43	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   11: ifne +4 -> 15
        //   14: return
        //   15: getstatic 24	com/inmobi/commons/cache/LocalCache:b	Lorg/json/JSONObject;
        //   18: astore_2
        //   19: aload_2
        //   20: monitorenter
        //   21: invokestatic 71	com/inmobi/commons/internal/InternalSDKUtil:getContext	()Landroid/content/Context;
        //   24: ldc 8
        //   26: invokestatic 102	com/inmobi/commons/internal/FileOperations:readFileAsString	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
        //   29: astore_1
        //   30: aload_1
        //   31: ifnull +14 -> 45
        //   34: aload_1
        //   35: astore_0
        //   36: ldc 104
        //   38: aload_1
        //   39: invokevirtual 43	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   42: ifeq +14 -> 56
        //   45: ldc 79
        //   47: ldc 106
        //   49: invokestatic 109	com/inmobi/commons/internal/Log:internal	(Ljava/lang/String;Ljava/lang/String;)V
        //   52: getstatic 17	com/inmobi/commons/cache/LocalCache:a	Ljava/lang/String;
        //   55: astore_0
        //   56: new 19	org/json/JSONObject
        //   59: dup
        //   60: aload_0
        //   61: invokespecial 112	org/json/JSONObject:<init>	(Ljava/lang/String;)V
        //   64: putstatic 24	com/inmobi/commons/cache/LocalCache:b	Lorg/json/JSONObject;
        //   67: aload_2
        //   68: monitorexit
        //   69: getstatic 24	com/inmobi/commons/cache/LocalCache:b	Lorg/json/JSONObject;
        //   72: invokevirtual 35	org/json/JSONObject:toString	()Ljava/lang/String;
        //   75: ldc 37
        //   77: invokevirtual 43	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   80: ifeq -66 -> 14
        //   83: new 19	org/json/JSONObject
        //   86: dup
        //   87: getstatic 17	com/inmobi/commons/cache/LocalCache:a	Ljava/lang/String;
        //   90: invokespecial 112	org/json/JSONObject:<init>	(Ljava/lang/String;)V
        //   93: putstatic 24	com/inmobi/commons/cache/LocalCache:b	Lorg/json/JSONObject;
        //   96: return
        //   97: astore_0
        //   98: ldc 79
        //   100: ldc 114
        //   102: aload_0
        //   103: invokestatic 87	com/inmobi/commons/internal/Log:internal	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   106: return
        //   107: astore_0
        //   108: ldc 79
        //   110: ldc 116
        //   112: aload_0
        //   113: invokestatic 87	com/inmobi/commons/internal/Log:internal	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   116: goto -49 -> 67
        //   119: astore_0
        //   120: aload_2
        //   121: monitorexit
        //   122: aload_0
        //   123: athrow
        //   124: astore_0
        //   125: ldc 79
        //   127: ldc 118
        //   129: aload_0
        //   130: invokestatic 87	com/inmobi/commons/internal/Log:internal	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   133: goto -66 -> 67
        // Local variable table:
        //   start	length	slot	name	signature
        //   35	26	0	str1	String
        //   97	6	0	localJSONException1	JSONException
        //   107	6	0	localIOException	java.io.IOException
        //   119	4	0	localObject	Object
        //   124	6	0	localJSONException2	JSONException
        //   29	10	1	str2	String
        // Exception table:
        //   from	to	target	type
        //   83	96	97	org/json/JSONException
        //   21	30	107	java/io/IOException
        //   36	45	107	java/io/IOException
        //   45	56	107	java/io/IOException
        //   56	67	107	java/io/IOException
        //   21	30	119	finally
        //   36	45	119	finally
        //   45	56	119	finally
        //   56	67	119	finally
        //   67	69	119	finally
        //   108	116	119	finally
        //   120	122	119	finally
        //   125	133	119	finally
        //   21	30	124	org/json/JSONException
        //   36	45	124	org/json/JSONException
        //   45	56	124	org/json/JSONException
        //   56	67	124	org/json/JSONException
    }

    public static void reset() {
        b = new JSONObject();
        c();
        initRoot();
    }

    public static void saveRoot(JSONObject paramJSONObject) {
        b = paramJSONObject;
        b();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/commons/cache/LocalCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */