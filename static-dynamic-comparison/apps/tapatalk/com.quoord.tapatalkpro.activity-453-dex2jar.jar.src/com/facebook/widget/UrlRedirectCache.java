package com.facebook.widget;

import android.content.Context;
import com.facebook.internal.FileLruCache;
import com.facebook.internal.FileLruCache.Limits;
import com.facebook.internal.Utility;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;

class UrlRedirectCache {
    private static final String REDIRECT_CONTENT_TAG = TAG + "_Redirect";
    static final String TAG = UrlRedirectCache.class.getSimpleName();
    private static volatile FileLruCache urlRedirectCache;

    static void cacheUrlRedirect(Context paramContext, URL paramURL1, URL paramURL2) {
        if ((paramURL1 == null) || (paramURL2 == null)) {
            return;
        }
        Context localContext2 = null;
        Context localContext1 = null;
        try {
            paramContext = getCache(paramContext).openPutStream(paramURL1.toString(), REDIRECT_CONTENT_TAG);
            localContext1 = paramContext;
            localContext2 = paramContext;
            paramContext.write(paramURL2.toString().getBytes());
            return;
        } catch (IOException paramContext) {
        } finally {
            Utility.closeQuietly(localContext2);
        }
    }

    static FileLruCache getCache(Context paramContext)
            throws IOException {
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
    static URL getRedirectedUrl(Context paramContext, URL paramURL) {
        // Byte code:
        //   0: aload_1
        //   1: ifnonnull +5 -> 6
        //   4: aconst_null
        //   5: areturn
        //   6: aload_1
        //   7: invokevirtual 56	java/net/URL:toString	()Ljava/lang/String;
        //   10: astore_1
        //   11: aconst_null
        //   12: astore 7
        //   14: aconst_null
        //   15: astore 5
        //   17: aconst_null
        //   18: astore 6
        //   20: aconst_null
        //   21: astore 4
        //   23: aload_0
        //   24: invokestatic 53	com/facebook/widget/UrlRedirectCache:getCache	(Landroid/content/Context;)Lcom/facebook/internal/FileLruCache;
        //   27: astore 9
        //   29: iconst_0
        //   30: istore_2
        //   31: aconst_null
        //   32: astore_0
        //   33: aload 9
        //   35: aload_1
        //   36: getstatic 42	com/facebook/widget/UrlRedirectCache:REDIRECT_CONTENT_TAG	Ljava/lang/String;
        //   39: invokevirtual 101	com/facebook/internal/FileLruCache:get	(Ljava/lang/String;Ljava/lang/String;)Ljava/io/InputStream;
        //   42: astore 4
        //   44: aload 4
        //   46: ifnonnull +28 -> 74
        //   49: aload 7
        //   51: astore 4
        //   53: iload_2
        //   54: ifeq +13 -> 67
        //   57: new 55	java/net/URL
        //   60: dup
        //   61: aload_1
        //   62: invokespecial 102	java/net/URL:<init>	(Ljava/lang/String;)V
        //   65: astore 4
        //   67: aload_0
        //   68: invokestatic 78	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
        //   71: aload 4
        //   73: areturn
        //   74: iconst_1
        //   75: istore_2
        //   76: new 104	java/io/InputStreamReader
        //   79: dup
        //   80: aload 4
        //   82: invokespecial 107	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
        //   85: astore_1
        //   86: aload_1
        //   87: astore 4
        //   89: aload_1
        //   90: astore 5
        //   92: aload_1
        //   93: astore 6
        //   95: sipush 128
        //   98: newarray <illegal type>
        //   100: astore_0
        //   101: aload_1
        //   102: astore 4
        //   104: aload_1
        //   105: astore 5
        //   107: aload_1
        //   108: astore 6
        //   110: new 21	java/lang/StringBuilder
        //   113: dup
        //   114: invokespecial 108	java/lang/StringBuilder:<init>	()V
        //   117: astore 8
        //   119: aload_1
        //   120: astore 4
        //   122: aload_1
        //   123: astore 5
        //   125: aload_1
        //   126: astore 6
        //   128: aload_1
        //   129: aload_0
        //   130: iconst_0
        //   131: aload_0
        //   132: arraylength
        //   133: invokevirtual 112	java/io/InputStreamReader:read	([CII)I
        //   136: istore_3
        //   137: iload_3
        //   138: ifgt +40 -> 178
        //   141: aload_1
        //   142: astore 4
        //   144: aload_1
        //   145: astore 5
        //   147: aload_1
        //   148: astore 6
        //   150: aload_1
        //   151: invokestatic 78	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
        //   154: aload_1
        //   155: astore 4
        //   157: aload_1
        //   158: astore 5
        //   160: aload_1
        //   161: astore 6
        //   163: aload 8
        //   165: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   168: astore 8
        //   170: aload_1
        //   171: astore_0
        //   172: aload 8
        //   174: astore_1
        //   175: goto -142 -> 33
        //   178: aload_1
        //   179: astore 4
        //   181: aload_1
        //   182: astore 5
        //   184: aload_1
        //   185: astore 6
        //   187: aload 8
        //   189: aload_0
        //   190: iconst_0
        //   191: iload_3
        //   192: invokevirtual 115	java/lang/StringBuilder:append	([CII)Ljava/lang/StringBuilder;
        //   195: pop
        //   196: goto -77 -> 119
        //   199: astore_0
        //   200: aload 4
        //   202: invokestatic 78	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
        //   205: aconst_null
        //   206: areturn
        //   207: astore_0
        //   208: aload 5
        //   210: invokestatic 78	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
        //   213: aconst_null
        //   214: areturn
        //   215: astore_0
        //   216: aload 6
        //   218: invokestatic 78	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
        //   221: aload_0
        //   222: athrow
        //   223: astore_1
        //   224: aload_0
        //   225: astore 6
        //   227: aload_1
        //   228: astore_0
        //   229: goto -13 -> 216
        //   232: astore_1
        //   233: aload_0
        //   234: astore 5
        //   236: goto -28 -> 208
        //   239: astore_1
        //   240: aload_0
        //   241: astore 4
        //   243: goto -43 -> 200
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	246	0	paramContext	Context
        //   0	246	1	paramURL	URL
        //   30	46	2	i	int
        //   136	56	3	j	int
        //   21	221	4	localObject1	Object
        //   15	220	5	localObject2	Object
        //   18	208	6	localObject3	Object
        //   12	38	7	localObject4	Object
        //   117	71	8	localObject5	Object
        //   27	7	9	localFileLruCache	FileLruCache
        // Exception table:
        //   from	to	target	type
        //   23	29	199	java/net/MalformedURLException
        //   95	101	199	java/net/MalformedURLException
        //   110	119	199	java/net/MalformedURLException
        //   128	137	199	java/net/MalformedURLException
        //   150	154	199	java/net/MalformedURLException
        //   163	170	199	java/net/MalformedURLException
        //   187	196	199	java/net/MalformedURLException
        //   23	29	207	java/io/IOException
        //   95	101	207	java/io/IOException
        //   110	119	207	java/io/IOException
        //   128	137	207	java/io/IOException
        //   150	154	207	java/io/IOException
        //   163	170	207	java/io/IOException
        //   187	196	207	java/io/IOException
        //   23	29	215	finally
        //   95	101	215	finally
        //   110	119	215	finally
        //   128	137	215	finally
        //   150	154	215	finally
        //   163	170	215	finally
        //   187	196	215	finally
        //   33	44	223	finally
        //   57	67	223	finally
        //   76	86	223	finally
        //   33	44	232	java/io/IOException
        //   57	67	232	java/io/IOException
        //   76	86	232	java/io/IOException
        //   33	44	239	java/net/MalformedURLException
        //   57	67	239	java/net/MalformedURLException
        //   76	86	239	java/net/MalformedURLException
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/facebook/widget/UrlRedirectCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */