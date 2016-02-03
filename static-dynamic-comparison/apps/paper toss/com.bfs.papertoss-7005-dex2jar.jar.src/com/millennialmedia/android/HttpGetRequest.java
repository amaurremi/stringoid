package com.millennialmedia.android;

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

class HttpGetRequest
{
  private HttpClient client = new DefaultHttpClient();
  private HttpGet getRequest = new HttpGet();
  
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
    //   8: new 31	java/io/IOException
    //   11: dup
    //   12: ldc 35
    //   14: invokespecial 38	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   17: athrow
    //   18: new 40	java/io/BufferedReader
    //   21: dup
    //   22: new 42	java/io/InputStreamReader
    //   25: dup
    //   26: aload_0
    //   27: invokespecial 45	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   30: sipush 4096
    //   33: invokespecial 48	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   36: astore_0
    //   37: new 50	java/lang/StringBuilder
    //   40: dup
    //   41: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   44: astore_1
    //   45: aload_0
    //   46: invokevirtual 55	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   49: astore_2
    //   50: aload_2
    //   51: ifnull +60 -> 111
    //   54: aload_1
    //   55: new 50	java/lang/StringBuilder
    //   58: dup
    //   59: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   62: aload_2
    //   63: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: ldc 61
    //   68: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   74: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: pop
    //   78: goto -33 -> 45
    //   81: astore_2
    //   82: aload_0
    //   83: astore_1
    //   84: aload_2
    //   85: invokestatic 70	com/millennialmedia/android/MMAdViewSDK$Log:d	(Ljava/lang/Throwable;)V
    //   88: aload_0
    //   89: astore_1
    //   90: new 31	java/io/IOException
    //   93: dup
    //   94: ldc 72
    //   96: invokespecial 38	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   99: athrow
    //   100: astore_0
    //   101: aload_1
    //   102: ifnull +7 -> 109
    //   105: aload_1
    //   106: invokevirtual 75	java/io/BufferedReader:close	()V
    //   109: aload_0
    //   110: athrow
    //   111: aload_0
    //   112: ifnull +7 -> 119
    //   115: aload_0
    //   116: invokevirtual 75	java/io/BufferedReader:close	()V
    //   119: aload_1
    //   120: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   123: areturn
    //   124: astore_0
    //   125: aload_0
    //   126: invokestatic 70	com/millennialmedia/android/MMAdViewSDK$Log:d	(Ljava/lang/Throwable;)V
    //   129: goto -10 -> 119
    //   132: astore_1
    //   133: aload_1
    //   134: invokestatic 70	com/millennialmedia/android/MMAdViewSDK$Log:d	(Ljava/lang/Throwable;)V
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
  
  static void log(String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0)) {
      new Thread(new Runnable()
      {
        public void run()
        {
          MMAdViewSDK.Log.v("Logging event to: %s", new Object[] { this.val$url });
          HttpGetRequest localHttpGetRequest = new HttpGetRequest();
          try
          {
            localHttpGetRequest.get(this.val$url);
            return;
          }
          catch (Exception localException)
          {
            MMAdViewSDK.Log.v(localException.getMessage());
          }
        }
      }).start();
    }
  }
  
  static void log(String[] paramArrayOfString)
  {
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0)) {
      new Thread(new Runnable()
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
              MMAdViewSDK.Log.v("Logging event to: %s", new Object[] { str });
              try
              {
                new HttpGetRequest().get(str);
                i += 1;
              }
              catch (Exception localException)
              {
                for (;;)
                {
                  MMAdViewSDK.Log.v(localException.getMessage());
                }
              }
            }
          }
        }
      }).start();
    }
  }
  
  HttpResponse get(String paramString)
    throws Exception
  {
    try
    {
      this.getRequest.setURI(new URI(paramString));
      paramString = this.client.execute(this.getRequest);
      return paramString;
    }
    catch (OutOfMemoryError paramString)
    {
      MMAdViewSDK.Log.e("Out of memory!");
    }
    return null;
  }
  
  void trackConversion(String paramString1, String paramString2, boolean paramBoolean, long paramLong, TreeMap<String, String> paramTreeMap)
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
        if (paramString1 != null) {
          localStringBuilder.append("&goalId=" + paramString1);
        }
        if (paramString2 != null)
        {
          if (!paramString2.startsWith("mmh_")) {
            break label246;
          }
          localStringBuilder.append("&hdid=" + URLEncoder.encode(paramString2));
        }
        if (paramLong > 0L) {
          localStringBuilder.append("&installtime=" + paramLong / 1000L);
        }
        if (paramTreeMap == null) {
          break;
        }
        paramString1 = paramTreeMap.entrySet().iterator();
        if (!paramString1.hasNext()) {
          break;
        }
        paramString2 = (Map.Entry)paramString1.next();
        localStringBuilder.append(String.format("&%s=%s", new Object[] { paramString2.getKey(), URLEncoder.encode((String)paramString2.getValue(), "UTF-8") }));
        continue;
        i = 0;
      }
      catch (IOException paramString1)
      {
        MMAdViewSDK.Log.e("Unable to track conversion. %s", new Object[] { paramString1.getMessage() });
        return;
      }
      continue;
      label246:
      localStringBuilder.append("&auid=" + URLEncoder.encode(paramString2));
    }
    paramString1 = localStringBuilder.toString();
    MMAdViewSDK.Log.d("Sending conversion tracker report: %s", new Object[] { paramString1 });
    this.getRequest.setURI(new URI(paramString1));
    paramString1 = this.client.execute(this.getRequest);
    if (paramString1.getStatusLine().getStatusCode() == 200)
    {
      MMAdViewSDK.Log.v("Conversion tracker reponse code: %d", new Object[] { Integer.valueOf(paramString1.getStatusLine().getStatusCode()) });
      return;
    }
    MMAdViewSDK.Log.e("Conversion tracker unable to complete report: %d", new Object[] { Integer.valueOf(paramString1.getStatusLine().getStatusCode()) });
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/paper toss/com.bfs.papertoss-7005-dex2jar.jar!/com/millennialmedia/android/HttpGetRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */