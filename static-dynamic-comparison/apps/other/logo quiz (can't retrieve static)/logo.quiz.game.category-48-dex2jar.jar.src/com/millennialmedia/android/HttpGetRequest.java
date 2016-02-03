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

class HttpGetRequest
{
  private HttpClient client;
  private HttpGet getRequest;
  
  HttpGetRequest()
  {
    BasicHttpParams localBasicHttpParams = new BasicHttpParams();
    HttpConnectionParams.setConnectionTimeout(localBasicHttpParams, 10000);
    this.client = new DefaultHttpClient(localBasicHttpParams);
    this.getRequest = new HttpGet();
  }
  
  HttpGetRequest(int paramInt)
  {
    BasicHttpParams localBasicHttpParams = new BasicHttpParams();
    HttpConnectionParams.setConnectionTimeout(localBasicHttpParams, 10000);
    HttpConnectionParams.setSoTimeout(localBasicHttpParams, paramInt);
    this.client = new DefaultHttpClient(localBasicHttpParams);
    this.getRequest = new HttpGet();
  }
  
  /* Error */
  static String convertStreamToString(java.io.InputStream paramInputStream)
    throws IOException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aconst_null
    //   3: astore_3
    //   4: aload_0
    //   5: ifnonnull +13 -> 18
    //   8: new 44	java/io/IOException
    //   11: dup
    //   12: ldc 48
    //   14: invokespecial 51	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   17: athrow
    //   18: new 53	java/io/BufferedReader
    //   21: dup
    //   22: new 55	java/io/InputStreamReader
    //   25: dup
    //   26: aload_0
    //   27: invokespecial 58	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   30: sipush 4096
    //   33: invokespecial 61	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   36: astore_0
    //   37: new 63	java/lang/StringBuilder
    //   40: dup
    //   41: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   44: astore_1
    //   45: aload_0
    //   46: invokevirtual 68	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   49: astore_2
    //   50: aload_2
    //   51: ifnull +60 -> 111
    //   54: aload_1
    //   55: new 63	java/lang/StringBuilder
    //   58: dup
    //   59: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   62: aload_2
    //   63: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: ldc 74
    //   68: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   74: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: pop
    //   78: goto -33 -> 45
    //   81: astore_2
    //   82: aload_0
    //   83: astore_1
    //   84: aload_2
    //   85: invokestatic 83	com/millennialmedia/android/MMSDK$Log:d	(Ljava/lang/Throwable;)V
    //   88: aload_0
    //   89: astore_1
    //   90: new 44	java/io/IOException
    //   93: dup
    //   94: ldc 85
    //   96: invokespecial 51	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   99: athrow
    //   100: astore_0
    //   101: aload_1
    //   102: ifnull +7 -> 109
    //   105: aload_1
    //   106: invokevirtual 88	java/io/BufferedReader:close	()V
    //   109: aload_0
    //   110: athrow
    //   111: aload_0
    //   112: ifnull +7 -> 119
    //   115: aload_0
    //   116: invokevirtual 88	java/io/BufferedReader:close	()V
    //   119: aload_1
    //   120: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   123: areturn
    //   124: astore_0
    //   125: aload_0
    //   126: invokestatic 83	com/millennialmedia/android/MMSDK$Log:d	(Ljava/lang/Throwable;)V
    //   129: goto -10 -> 119
    //   132: astore_1
    //   133: aload_1
    //   134: invokestatic 83	com/millennialmedia/android/MMSDK$Log:d	(Ljava/lang/Throwable;)V
    //   137: goto -28 -> 109
    //   140: astore_2
    //   141: aload_0
    //   142: astore_1
    //   143: aload_2
    //   144: astore_0
    //   145: goto -44 -> 101
    //   148: astore_2
    //   149: aload_3
    //   150: astore_0
    //   151: goto -69 -> 82
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	154	0	paramInputStream	java.io.InputStream
    //   1	119	1	localObject1	Object
    //   132	2	1	localIOException	IOException
    //   142	1	1	localInputStream	java.io.InputStream
    //   49	14	2	str	String
    //   81	4	2	localOutOfMemoryError1	OutOfMemoryError
    //   140	4	2	localObject2	Object
    //   148	1	2	localOutOfMemoryError2	OutOfMemoryError
    //   3	147	3	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   37	45	81	java/lang/OutOfMemoryError
    //   45	50	81	java/lang/OutOfMemoryError
    //   54	78	81	java/lang/OutOfMemoryError
    //   18	37	100	finally
    //   84	88	100	finally
    //   90	100	100	finally
    //   115	119	124	java/io/IOException
    //   105	109	132	java/io/IOException
    //   37	45	140	finally
    //   45	50	140	finally
    //   54	78	140	finally
    //   18	37	148	java/lang/OutOfMemoryError
  }
  
  static void log(String[] paramArrayOfString)
  {
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0)) {
      Utils.ThreadUtils.execute(new Runnable()
      {
        public void run()
        {
          String[] arrayOfString = this.val$urls;
          int j = arrayOfString.length;
          int i = 0;
          for (;;)
          {
            if (i < j)
            {
              String str = arrayOfString[i];
              MMSDK.Log.v("Logging event to: %s", new Object[] { str });
              try
              {
                new HttpGetRequest().get(str);
                i += 1;
              }
              catch (Exception localException)
              {
                for (;;)
                {
                  MMSDK.Log.v(localException.getMessage());
                }
              }
            }
          }
        }
      });
    }
  }
  
  HttpResponse get(String paramString)
    throws Exception
  {
    Object localObject = null;
    HttpResponse localHttpResponse = null;
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      this.getRequest.setURI(new URI(paramString));
      localHttpResponse = this.client.execute(this.getRequest);
      paramString = localHttpResponse;
    }
    catch (OutOfMemoryError paramString)
    {
      MMSDK.Log.e("Out of memory!");
      return null;
    }
    catch (Exception localException)
    {
      do
      {
        paramString = (String)localObject;
      } while (localException == null);
      MMSDK.Log.e("Error connecting:" + localException.getMessage());
    }
    return paramString;
    return null;
  }
  
  void trackConversion(String paramString, boolean paramBoolean, long paramLong, TreeMap<String, String> paramTreeMap)
    throws Exception
  {
    int i;
    if (paramBoolean) {
      i = 1;
    }
    StringBuilder localStringBuilder;
    for (;;)
    {
      try
      {
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
        paramTreeMap = (Map.Entry)paramString.next();
        localStringBuilder.append(String.format("&%s=%s", new Object[] { paramTreeMap.getKey(), URLEncoder.encode((String)paramTreeMap.getValue(), "UTF-8") }));
        continue;
        i = 0;
      }
      catch (IOException paramString)
      {
        MMSDK.Log.e("Conversion tracking error: %s", new Object[] { paramString.getMessage() });
        return;
      }
    }
    paramString = localStringBuilder.toString();
    MMSDK.Log.d("Sending conversion tracker report: %s", new Object[] { paramString });
    this.getRequest.setURI(new URI(paramString));
    paramString = this.client.execute(this.getRequest);
    if (paramString.getStatusLine().getStatusCode() == 200)
    {
      MMSDK.Log.v("Successful conversion tracking event: %d", new Object[] { Integer.valueOf(paramString.getStatusLine().getStatusCode()) });
      return;
    }
    MMSDK.Log.e("Conversion tracking error: %d", new Object[] { Integer.valueOf(paramString.getStatusLine().getStatusCode()) });
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/millennialmedia/android/HttpGetRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */