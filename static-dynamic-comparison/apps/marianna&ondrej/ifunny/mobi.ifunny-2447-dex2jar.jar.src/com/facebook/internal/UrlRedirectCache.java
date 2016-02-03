package com.facebook.internal;

import android.content.Context;
import com.facebook.LoggingBehavior;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;

class UrlRedirectCache {
    private static final String REDIRECT_CONTENT_TAG = TAG + "_Redirect";
    static final String TAG = UrlRedirectCache.class.getSimpleName();
    private static volatile FileLruCache urlRedirectCache;

    static void cacheUriRedirect(Context paramContext, URI paramURI1, URI paramURI2) {
        if ((paramURI1 == null) || (paramURI2 == null)) {
            return;
        }
        Context localContext = null;
        try {
            paramContext = getCache(paramContext).openPutStream(paramURI1.toString(), REDIRECT_CONTENT_TAG);
            localContext = paramContext;
            Utility.closeQuietly(paramURI2);
        } catch (IOException paramContext) {
            try {
                paramContext.write(paramURI2.toString().getBytes());
                Utility.closeQuietly(paramContext);
                return;
            } finally {
                paramURI2 = paramContext;
            }
            paramContext = paramContext;
            Utility.closeQuietly(localContext);
            return;
        } finally {
            paramContext =finally;
            paramURI2 = null;
            paramURI1 = paramContext;
        }
        throw paramURI1;
    }

    static void clearCache(Context paramContext) {
        try {
            getCache(paramContext).clearCache();
            return;
        } catch (IOException paramContext) {
            Logger.log(LoggingBehavior.CACHE, 5, TAG, "clearCache failed " + paramContext.getMessage());
        }
    }

    static FileLruCache getCache(Context paramContext) {
        try {
            if (urlRedirectCache == null) {
                urlRedirectCache = new FileLruCache(paramContext.getApplicationContext(), TAG, new FileLruCache.Limits());
            }
            paramContext = urlRedirectCache;
            return paramContext;
        } finally {
        }
    }

    /* Error */
    static URI getRedirectedUri(Context paramContext, URI paramURI) {
        // Byte code:
        //   0: iconst_0
        //   1: istore_2
        //   2: aload_1
        //   3: ifnonnull +5 -> 8
        //   6: aconst_null
        //   7: areturn
        //   8: aload_1
        //   9: invokevirtual 48	java/net/URI:toString	()Ljava/lang/String;
        //   12: astore_1
        //   13: aload_0
        //   14: invokestatic 45	com/facebook/internal/UrlRedirectCache:getCache	(Landroid/content/Context;)Lcom/facebook/internal/FileLruCache;
        //   17: astore 4
        //   19: aconst_null
        //   20: astore_0
        //   21: aload 4
        //   23: aload_1
        //   24: getstatic 35	com/facebook/internal/UrlRedirectCache:REDIRECT_CONTENT_TAG	Ljava/lang/String;
        //   27: invokevirtual 115	com/facebook/internal/FileLruCache:get	(Ljava/lang/String;Ljava/lang/String;)Ljava/io/InputStream;
        //   30: astore_3
        //   31: aload_3
        //   32: ifnull +75 -> 107
        //   35: new 117	java/io/InputStreamReader
        //   38: dup
        //   39: aload_3
        //   40: invokespecial 120	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
        //   43: astore_1
        //   44: sipush 128
        //   47: newarray <illegal type>
        //   49: astore_0
        //   50: new 21	java/lang/StringBuilder
        //   53: dup
        //   54: invokespecial 24	java/lang/StringBuilder:<init>	()V
        //   57: astore_3
        //   58: aload_1
        //   59: aload_0
        //   60: iconst_0
        //   61: aload_0
        //   62: arraylength
        //   63: invokevirtual 124	java/io/InputStreamReader:read	([CII)I
        //   66: istore_2
        //   67: iload_2
        //   68: ifle +21 -> 89
        //   71: aload_3
        //   72: aload_0
        //   73: iconst_0
        //   74: iload_2
        //   75: invokevirtual 127	java/lang/StringBuilder:append	([CII)Ljava/lang/StringBuilder;
        //   78: pop
        //   79: goto -21 -> 58
        //   82: astore_0
        //   83: aload_1
        //   84: invokestatic 72	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
        //   87: aconst_null
        //   88: areturn
        //   89: aload_1
        //   90: invokestatic 72	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
        //   93: aload_3
        //   94: invokevirtual 33	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   97: astore_3
        //   98: aload_1
        //   99: astore_0
        //   100: iconst_1
        //   101: istore_2
        //   102: aload_3
        //   103: astore_1
        //   104: goto -83 -> 21
        //   107: iload_2
        //   108: ifeq +18 -> 126
        //   111: new 47	java/net/URI
        //   114: dup
        //   115: aload_1
        //   116: invokespecial 130	java/net/URI:<init>	(Ljava/lang/String;)V
        //   119: astore_1
        //   120: aload_0
        //   121: invokestatic 72	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
        //   124: aload_1
        //   125: areturn
        //   126: aload_0
        //   127: invokestatic 72	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
        //   130: aconst_null
        //   131: areturn
        //   132: astore_0
        //   133: aconst_null
        //   134: astore_1
        //   135: aload_1
        //   136: invokestatic 72	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
        //   139: aconst_null
        //   140: areturn
        //   141: astore_0
        //   142: aconst_null
        //   143: astore_1
        //   144: aload_1
        //   145: invokestatic 72	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
        //   148: aload_0
        //   149: athrow
        //   150: astore_0
        //   151: goto -7 -> 144
        //   154: astore_3
        //   155: aload_0
        //   156: astore_1
        //   157: aload_3
        //   158: astore_0
        //   159: goto -15 -> 144
        //   162: astore_0
        //   163: goto -28 -> 135
        //   166: astore_1
        //   167: aload_0
        //   168: astore_1
        //   169: goto -34 -> 135
        //   172: astore_0
        //   173: aconst_null
        //   174: astore_1
        //   175: goto -92 -> 83
        //   178: astore_1
        //   179: aload_0
        //   180: astore_1
        //   181: goto -98 -> 83
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	184	0	paramContext	Context
        //   0	184	1	paramURI	URI
        //   1	107	2	i	int
        //   30	73	3	localObject1	Object
        //   154	4	3	localObject2	Object
        //   17	5	4	localFileLruCache	FileLruCache
        // Exception table:
        //   from	to	target	type
        //   44	58	82	java/net/URISyntaxException
        //   58	67	82	java/net/URISyntaxException
        //   71	79	82	java/net/URISyntaxException
        //   89	98	82	java/net/URISyntaxException
        //   13	19	132	java/io/IOException
        //   13	19	141	finally
        //   44	58	150	finally
        //   58	67	150	finally
        //   71	79	150	finally
        //   89	98	150	finally
        //   21	31	154	finally
        //   35	44	154	finally
        //   111	120	154	finally
        //   44	58	162	java/io/IOException
        //   58	67	162	java/io/IOException
        //   71	79	162	java/io/IOException
        //   89	98	162	java/io/IOException
        //   21	31	166	java/io/IOException
        //   35	44	166	java/io/IOException
        //   111	120	166	java/io/IOException
        //   13	19	172	java/net/URISyntaxException
        //   21	31	178	java/net/URISyntaxException
        //   35	44	178	java/net/URISyntaxException
        //   111	120	178	java/net/URISyntaxException
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/internal/UrlRedirectCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */