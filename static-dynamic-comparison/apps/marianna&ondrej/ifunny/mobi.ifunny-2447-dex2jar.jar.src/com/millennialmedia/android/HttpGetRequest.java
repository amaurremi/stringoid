package com.millennialmedia.android;

import android.text.TextUtils;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;

class HttpGetRequest {
    private HttpClient a;
    private HttpGet b;

    HttpGetRequest() {
        BasicHttpParams localBasicHttpParams = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(localBasicHttpParams, 10000);
        this.a = new DefaultHttpClient(localBasicHttpParams);
        this.b = new HttpGet();
    }

    HttpGetRequest(int paramInt) {
        BasicHttpParams localBasicHttpParams = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(localBasicHttpParams, 10000);
        HttpConnectionParams.setSoTimeout(localBasicHttpParams, paramInt);
        this.a = new DefaultHttpClient(localBasicHttpParams);
        this.b = new HttpGet();
    }

    /* Error */
    static String a(java.io.InputStream paramInputStream) {
        // Byte code:
        //   0: aload_0
        //   1: ifnonnull +13 -> 14
        //   4: new 43	java/io/IOException
        //   7: dup
        //   8: ldc 45
        //   10: invokespecial 48	java/io/IOException:<init>	(Ljava/lang/String;)V
        //   13: athrow
        //   14: new 50	java/io/BufferedReader
        //   17: dup
        //   18: new 52	java/io/InputStreamReader
        //   21: dup
        //   22: aload_0
        //   23: invokespecial 55	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
        //   26: sipush 4096
        //   29: invokespecial 58	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
        //   32: astore_1
        //   33: aload_1
        //   34: astore_0
        //   35: new 60	java/lang/StringBuilder
        //   38: dup
        //   39: invokespecial 61	java/lang/StringBuilder:<init>	()V
        //   42: astore_2
        //   43: aload_1
        //   44: astore_0
        //   45: aload_1
        //   46: invokevirtual 65	java/io/BufferedReader:readLine	()Ljava/lang/String;
        //   49: astore_3
        //   50: aload_3
        //   51: ifnull +70 -> 121
        //   54: aload_1
        //   55: astore_0
        //   56: aload_2
        //   57: new 60	java/lang/StringBuilder
        //   60: dup
        //   61: invokespecial 61	java/lang/StringBuilder:<init>	()V
        //   64: aload_3
        //   65: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   68: ldc 71
        //   70: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   73: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   76: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   79: pop
        //   80: goto -37 -> 43
        //   83: astore_2
        //   84: aload_1
        //   85: astore_0
        //   86: ldc 76
        //   88: ldc 78
        //   90: aload_2
        //   91: invokestatic 83	com/millennialmedia/android/MMLog:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   94: aload_1
        //   95: astore_0
        //   96: new 43	java/io/IOException
        //   99: dup
        //   100: ldc 85
        //   102: invokespecial 48	java/io/IOException:<init>	(Ljava/lang/String;)V
        //   105: athrow
        //   106: astore_2
        //   107: aload_0
        //   108: astore_1
        //   109: aload_2
        //   110: astore_0
        //   111: aload_1
        //   112: ifnull +7 -> 119
        //   115: aload_1
        //   116: invokevirtual 88	java/io/BufferedReader:close	()V
        //   119: aload_0
        //   120: athrow
        //   121: aload_1
        //   122: ifnull +7 -> 129
        //   125: aload_1
        //   126: invokevirtual 88	java/io/BufferedReader:close	()V
        //   129: aload_2
        //   130: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   133: areturn
        //   134: astore_0
        //   135: ldc 76
        //   137: ldc 90
        //   139: aload_0
        //   140: invokestatic 83	com/millennialmedia/android/MMLog:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   143: goto -14 -> 129
        //   146: astore_1
        //   147: ldc 76
        //   149: ldc 90
        //   151: aload_1
        //   152: invokestatic 83	com/millennialmedia/android/MMLog:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   155: goto -36 -> 119
        //   158: astore_0
        //   159: aconst_null
        //   160: astore_1
        //   161: goto -50 -> 111
        //   164: astore_2
        //   165: aconst_null
        //   166: astore_1
        //   167: goto -83 -> 84
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	170	0	paramInputStream	java.io.InputStream
        //   32	94	1	localObject1	Object
        //   146	6	1	localIOException	IOException
        //   160	7	1	localObject2	Object
        //   42	15	2	localStringBuilder	StringBuilder
        //   83	8	2	localOutOfMemoryError1	OutOfMemoryError
        //   106	24	2	localObject3	Object
        //   164	1	2	localOutOfMemoryError2	OutOfMemoryError
        //   49	16	3	str	String
        // Exception table:
        //   from	to	target	type
        //   35	43	83	java/lang/OutOfMemoryError
        //   45	50	83	java/lang/OutOfMemoryError
        //   56	80	83	java/lang/OutOfMemoryError
        //   35	43	106	finally
        //   45	50	106	finally
        //   56	80	106	finally
        //   86	94	106	finally
        //   96	106	106	finally
        //   125	129	134	java/io/IOException
        //   115	119	146	java/io/IOException
        //   14	33	158	finally
        //   14	33	164	java/lang/OutOfMemoryError
    }

    static void a(String[] paramArrayOfString) {
        if ((paramArrayOfString != null) && (paramArrayOfString.length > 0)) {
            Utils.ThreadUtils.a(new HttpGetRequest .1 (paramArrayOfString));
        }
    }

    HttpResponse a(String paramString) {
        Object localObject2 = null;
        Object localObject1 = localObject2;
        if (!TextUtils.isEmpty(paramString)) {
        }
        try {
            this.b.setURI(new URI(paramString));
            localObject1 = this.a.execute(this.b);
            return (HttpResponse) localObject1;
        } catch (OutOfMemoryError paramString) {
            MMLog.a("HttpGetRequest", "Out of memory!", paramString);
            return null;
        } catch (Exception paramString) {
            do {
                localObject1 = localObject2;
            } while (paramString == null);
            MMLog.a("HttpGetRequest", "Error connecting:", paramString);
        }
        return null;
    }

    void a(String paramString, boolean paramBoolean, long paramLong, TreeMap<String, String> paramTreeMap) {
        int i = 1;
        if (paramBoolean) {
        }
        StringBuilder localStringBuilder;
        for (; ; ) {
            try {
                localStringBuilder = new StringBuilder("http://cvt.mydas.mobi/handleConversion?firstlaunch=" + i);
                if (paramString != null) {
                    localStringBuilder.append("&goalId=" + paramString);
                }
                if (paramLong > 0L) {
                    localStringBuilder.append("&installtime=" + paramLong / 1000L);
                }
                if (paramTreeMap == null) {
                    break;
                }
                paramString = paramTreeMap.entrySet().iterator();
                if (!paramString.hasNext()) {
                    break;
                }
                paramTreeMap = (Map.Entry) paramString.next();
                localStringBuilder.append(String.format("&%s=%s", new Object[]{paramTreeMap.getKey(), URLEncoder.encode((String) paramTreeMap.getValue(), "UTF-8")}));
                continue;
                i = 0;
            } catch (IOException paramString) {
                MMLog.a("HttpGetRequest", "Conversion tracking error: ", paramString);
                return;
            }
        }
        paramString = localStringBuilder.toString();
        MMLog.b("HttpGetRequest", String.format("Sending conversion tracker report: %s", new Object[]{paramString}));
        this.b.setURI(new URI(paramString));
        paramString = this.a.execute(this.b);
        if (paramString.getStatusLine().getStatusCode() == 200) {
            MMLog.a("HttpGetRequest", String.format("Successful conversion tracking event: %d", new Object[]{Integer.valueOf(paramString.getStatusLine().getStatusCode())}));
            return;
        }
        MMLog.e("HttpGetRequest", String.format("Conversion tracking error: %d", new Object[]{Integer.valueOf(paramString.getStatusLine().getStatusCode())}));
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/HttpGetRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */