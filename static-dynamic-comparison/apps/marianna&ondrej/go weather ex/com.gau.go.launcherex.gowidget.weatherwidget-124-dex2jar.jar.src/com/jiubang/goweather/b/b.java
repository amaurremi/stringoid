package com.jiubang.goweather.b;

import android.text.TextUtils;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.SocketTimeoutException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.Set;
import java.util.zip.GZIPInputStream;
import org.apache.http.Header;
import org.apache.http.HeaderIterator;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

public class b
  extends c
{
  private HttpClient c;
  private HttpEntity d;
  private SimpleDateFormat e = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", Locale.US);
  
  private InputStream a(HttpResponse paramHttpResponse, f paramf)
  {
    this.d = paramHttpResponse.getEntity();
    if (this.d != null) {
      for (;;)
      {
        try
        {
          paramHttpResponse = this.d.getContent();
          GZIPInputStream localGZIPInputStream;
          localIOException1.printStackTrace();
        }
        catch (IllegalStateException localIllegalStateException1)
        {
          for (;;)
          {
            try
            {
              paramf.f(this.d.getContentLength());
              if ((paramHttpResponse == null) || (!paramf.a())) {
                return paramHttpResponse;
              }
            }
            catch (IOException localIOException3)
            {
              continue;
            }
            catch (IllegalStateException localIllegalStateException2)
            {
              continue;
            }
            try
            {
              localGZIPInputStream = new GZIPInputStream(paramHttpResponse);
              return localGZIPInputStream;
            }
            catch (IOException localIOException2)
            {
              localIOException2.printStackTrace();
            }
          }
          localIllegalStateException1 = localIllegalStateException1;
          paramHttpResponse = null;
          localIllegalStateException1.printStackTrace();
          continue;
        }
        catch (IOException localIOException1)
        {
          paramHttpResponse = null;
        }
        paramf.b(11);
        paramf.c(7);
      }
    }
    try
    {
      paramHttpResponse.close();
      paramf.b(11);
      paramf.c(9);
      return null;
    }
    catch (IOException paramHttpResponse)
    {
      for (;;)
      {
        paramHttpResponse.printStackTrace();
      }
    }
    return paramHttpResponse;
  }
  
  /* Error */
  private String b(HttpResponse paramHttpResponse, f paramf)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 7
    //   6: aconst_null
    //   7: astore 8
    //   9: aload_0
    //   10: aload_1
    //   11: invokeinterface 42 1 0
    //   16: putfield 44	com/jiubang/goweather/b/b:d	Lorg/apache/http/HttpEntity;
    //   19: aload 5
    //   21: astore 4
    //   23: aload_0
    //   24: getfield 44	com/jiubang/goweather/b/b:d	Lorg/apache/http/HttpEntity;
    //   27: ifnull +80 -> 107
    //   30: aload_0
    //   31: getfield 44	com/jiubang/goweather/b/b:d	Lorg/apache/http/HttpEntity;
    //   34: invokeinterface 50 1 0
    //   39: astore_3
    //   40: aload 5
    //   42: astore 4
    //   44: aload_3
    //   45: ifnull +62 -> 107
    //   48: aload_2
    //   49: invokevirtual 63	com/jiubang/goweather/b/f:a	()Z
    //   52: ifeq +224 -> 276
    //   55: new 65	java/util/zip/GZIPInputStream
    //   58: dup
    //   59: aload_3
    //   60: invokespecial 68	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   63: astore 5
    //   65: aload 5
    //   67: astore_1
    //   68: aload 5
    //   70: aconst_null
    //   71: aload_2
    //   72: invokestatic 89	com/jiubang/goweather/e/a:a	(Ljava/io/InputStream;Ljava/lang/String;Lcom/jiubang/goweather/b/f;)Ljava/lang/String;
    //   75: astore 4
    //   77: aload 4
    //   79: astore_1
    //   80: aload 5
    //   82: ifnull +11 -> 93
    //   85: aload 5
    //   87: invokevirtual 90	java/util/zip/GZIPInputStream:close	()V
    //   90: aload 4
    //   92: astore_1
    //   93: aload_1
    //   94: astore 4
    //   96: aload_3
    //   97: ifnull +10 -> 107
    //   100: aload_3
    //   101: invokevirtual 83	java/io/InputStream:close	()V
    //   104: aload_1
    //   105: astore 4
    //   107: aload 4
    //   109: areturn
    //   110: astore_1
    //   111: aload_1
    //   112: invokevirtual 71	java/lang/IllegalStateException:printStackTrace	()V
    //   115: aload_2
    //   116: aload_1
    //   117: invokevirtual 93	com/jiubang/goweather/b/f:a	(Ljava/lang/Throwable;)V
    //   120: aconst_null
    //   121: astore_3
    //   122: goto -82 -> 40
    //   125: astore_1
    //   126: aload_1
    //   127: invokevirtual 72	java/io/IOException:printStackTrace	()V
    //   130: aload_2
    //   131: aload_1
    //   132: invokevirtual 93	com/jiubang/goweather/b/f:a	(Ljava/lang/Throwable;)V
    //   135: aload_2
    //   136: bipush 11
    //   138: invokevirtual 76	com/jiubang/goweather/b/f:b	(I)V
    //   141: aload_2
    //   142: bipush 7
    //   144: invokevirtual 78	com/jiubang/goweather/b/f:c	(I)V
    //   147: aconst_null
    //   148: astore_3
    //   149: goto -109 -> 40
    //   152: astore 6
    //   154: aconst_null
    //   155: astore 4
    //   157: aload 4
    //   159: astore_1
    //   160: aload 6
    //   162: invokevirtual 72	java/io/IOException:printStackTrace	()V
    //   165: aload 4
    //   167: astore_1
    //   168: aload_2
    //   169: aload 6
    //   171: invokevirtual 93	com/jiubang/goweather/b/f:a	(Ljava/lang/Throwable;)V
    //   174: aload 4
    //   176: astore_1
    //   177: aload_3
    //   178: invokevirtual 83	java/io/InputStream:close	()V
    //   181: aload 4
    //   183: astore_1
    //   184: aload_2
    //   185: bipush 11
    //   187: invokevirtual 76	com/jiubang/goweather/b/f:b	(I)V
    //   190: aload 4
    //   192: astore_1
    //   193: aload_2
    //   194: bipush 9
    //   196: invokevirtual 78	com/jiubang/goweather/b/f:c	(I)V
    //   199: aload 8
    //   201: astore_1
    //   202: aload 4
    //   204: ifnull -111 -> 93
    //   207: aload 4
    //   209: invokevirtual 90	java/util/zip/GZIPInputStream:close	()V
    //   212: aload 8
    //   214: astore_1
    //   215: goto -122 -> 93
    //   218: astore 4
    //   220: aload 4
    //   222: invokevirtual 72	java/io/IOException:printStackTrace	()V
    //   225: aload 7
    //   227: astore_1
    //   228: aload_2
    //   229: aload 4
    //   231: invokevirtual 93	com/jiubang/goweather/b/f:a	(Ljava/lang/Throwable;)V
    //   234: goto -141 -> 93
    //   237: astore 5
    //   239: aload 4
    //   241: astore_1
    //   242: aload 5
    //   244: invokevirtual 72	java/io/IOException:printStackTrace	()V
    //   247: aload 4
    //   249: astore_1
    //   250: aload_2
    //   251: aload 5
    //   253: invokevirtual 93	com/jiubang/goweather/b/f:a	(Ljava/lang/Throwable;)V
    //   256: goto -75 -> 181
    //   259: astore 4
    //   261: aload_1
    //   262: astore_3
    //   263: aload 4
    //   265: astore_1
    //   266: aload_3
    //   267: ifnull +7 -> 274
    //   270: aload_3
    //   271: invokevirtual 90	java/util/zip/GZIPInputStream:close	()V
    //   274: aload_1
    //   275: athrow
    //   276: aload_3
    //   277: aconst_null
    //   278: aload_2
    //   279: invokestatic 89	com/jiubang/goweather/e/a:a	(Ljava/io/InputStream;Ljava/lang/String;Lcom/jiubang/goweather/b/f;)Ljava/lang/String;
    //   282: astore_1
    //   283: goto -190 -> 93
    //   286: astore_3
    //   287: aload_3
    //   288: invokevirtual 72	java/io/IOException:printStackTrace	()V
    //   291: aload_2
    //   292: aload_3
    //   293: invokevirtual 93	com/jiubang/goweather/b/f:a	(Ljava/lang/Throwable;)V
    //   296: aload_1
    //   297: areturn
    //   298: astore_3
    //   299: aload_3
    //   300: invokevirtual 72	java/io/IOException:printStackTrace	()V
    //   303: aload_2
    //   304: aload_3
    //   305: invokevirtual 93	com/jiubang/goweather/b/f:a	(Ljava/lang/Throwable;)V
    //   308: goto -34 -> 274
    //   311: astore 5
    //   313: aload 5
    //   315: invokevirtual 72	java/io/IOException:printStackTrace	()V
    //   318: aload 4
    //   320: astore_1
    //   321: aload 5
    //   323: astore 4
    //   325: goto -97 -> 228
    //   328: astore_1
    //   329: aconst_null
    //   330: astore_3
    //   331: goto -65 -> 266
    //   334: astore 6
    //   336: aload 5
    //   338: astore 4
    //   340: goto -183 -> 157
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	343	0	this	b
    //   0	343	1	paramHttpResponse	HttpResponse
    //   0	343	2	paramf	f
    //   39	238	3	localObject1	Object
    //   286	7	3	localIOException1	IOException
    //   298	7	3	localIOException2	IOException
    //   330	1	3	localObject2	Object
    //   21	187	4	localObject3	Object
    //   218	30	4	localIOException3	IOException
    //   259	60	4	localObject4	Object
    //   323	16	4	localIOException4	IOException
    //   1	85	5	localGZIPInputStream	GZIPInputStream
    //   237	15	5	localIOException5	IOException
    //   311	26	5	localIOException6	IOException
    //   152	18	6	localIOException7	IOException
    //   334	1	6	localIOException8	IOException
    //   4	222	7	localObject5	Object
    //   7	206	8	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   30	40	110	java/lang/IllegalStateException
    //   30	40	125	java/io/IOException
    //   55	65	152	java/io/IOException
    //   207	212	218	java/io/IOException
    //   177	181	237	java/io/IOException
    //   68	77	259	finally
    //   160	165	259	finally
    //   168	174	259	finally
    //   177	181	259	finally
    //   184	190	259	finally
    //   193	199	259	finally
    //   242	247	259	finally
    //   250	256	259	finally
    //   100	104	286	java/io/IOException
    //   270	274	298	java/io/IOException
    //   85	90	311	java/io/IOException
    //   55	65	328	finally
    //   68	77	334	java/io/IOException
  }
  
  private void b()
  {
    if (this.d != null) {}
    try
    {
      this.d.consumeContent();
      this.d = null;
      if (this.c != null) {
        this.c.getConnectionManager().shutdown();
      }
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        localIOException.printStackTrace();
      }
    }
  }
  
  public InputStream a(String paramString, e parame, f paramf)
  {
    Object localObject1;
    Object localObject2;
    if ((!TextUtils.isEmpty(paramString)) && ((paramString.startsWith("http://")) || (paramString.startsWith("https://"))))
    {
      localObject1 = new BasicHttpParams();
      HttpConnectionParams.setConnectionTimeout((HttpParams)localObject1, parame.b());
      HttpConnectionParams.setSoTimeout((HttpParams)localObject1, parame.c());
      if (!TextUtils.isEmpty(this.a)) {
        ((HttpParams)localObject1).setParameter("http.route.default-proxy", new HttpHost(this.a, this.b));
      }
      this.c = new DefaultHttpClient((HttpParams)localObject1);
      if (parame.h().equalsIgnoreCase("GET"))
      {
        paramString = new HttpGet(paramString);
        localObject1 = parame.d().entrySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (Map.Entry)((Iterator)localObject1).next();
          paramString.addHeader((String)((Map.Entry)localObject2).getKey(), (String)((Map.Entry)localObject2).getValue());
        }
        paramString.addHeader("accept-encoding", "gzip,deflate");
      }
    }
    for (;;)
    {
      if (paramString != null)
      {
        if (parame.a()) {
          paramString.addHeader("User-Agent", "Mozilla/5.0 (Linux; U; Android 2.2; en-us; Nexus One Build/FRF91) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1");
        }
        try
        {
          parame = this.c.execute(paramString);
          paramString = parame;
        }
        catch (ClientProtocolException paramString)
        {
          for (;;)
          {
            paramString.printStackTrace();
            paramf.b(11);
            paramf.c(5);
            paramf.a(paramString.getMessage());
            paramString = null;
          }
        }
        catch (ConnectTimeoutException paramString)
        {
          for (;;)
          {
            paramString.printStackTrace();
            paramf.b(11);
            paramf.c(6);
            paramf.a(paramString.getMessage());
            paramString = null;
          }
        }
        catch (SocketTimeoutException paramString)
        {
          for (;;)
          {
            paramString.printStackTrace();
            paramf.b(11);
            paramf.c(12);
            paramf.a(paramString.getMessage());
            paramString = null;
          }
        }
        catch (IOException paramString)
        {
          for (;;)
          {
            paramString.printStackTrace();
            paramf.b(11);
            paramf.c(7);
            paramf.a(paramString.getMessage());
            paramString = null;
          }
        }
        catch (NullPointerException parame)
        {
          for (;;)
          {
            parame.printStackTrace();
            paramString.abort();
            paramf.b(11);
            paramf.c(13);
            paramf.a(parame.getMessage());
            paramString = null;
          }
        }
        catch (Exception paramString)
        {
          for (;;)
          {
            paramString.printStackTrace();
            paramString = null;
          }
        }
        catch (OutOfMemoryError paramString)
        {
          for (;;)
          {
            paramString.printStackTrace();
            paramString = null;
          }
        }
        if (paramString != null)
        {
          parame = paramString.headerIterator();
          for (;;)
          {
            if ((parame != null) && (parame.hasNext()))
            {
              localObject2 = parame.nextHeader();
              localObject1 = ((Header)localObject2).getName().toLowerCase(Locale.US);
              localObject2 = ((Header)localObject2).getValue();
              if ((localObject1 != null) && ((((String)localObject1).equalsIgnoreCase("Content-Encoding")) || (((String)localObject1).equalsIgnoreCase("X_Enc"))) && ((((String)localObject2).indexOf("gzip") != -1) || (((String)localObject2).indexOf("x-gzip") != -1))) {
                paramf.a(true);
              }
            }
            else
            {
              parame = paramString.getFirstHeader("Date");
              if (parame == null) {}
            }
            try
            {
              parame = this.e.parse(parame.getValue());
              if (parame != null) {
                paramf.e(parame.getTime());
              }
            }
            catch (Exception parame)
            {
              int i;
              for (;;)
              {
                parame.printStackTrace();
              }
              if ((i < 500) || (i >= 600)) {
                break label806;
              }
              paramf.b(11);
              paramf.c(-1);
              return null;
              paramf.b(11);
              paramf.c(8);
            }
            i = paramString.getStatusLine().getStatusCode();
            if (i != 200) {
              break label777;
            }
            return a(paramString, paramf);
            if (!parame.h().equalsIgnoreCase("POST")) {
              break label834;
            }
            localObject1 = new HttpPost(paramString);
            paramString = parame.d().entrySet().iterator();
            while (paramString.hasNext())
            {
              localObject2 = (Map.Entry)paramString.next();
              ((HttpRequestBase)localObject1).addHeader((String)((Map.Entry)localObject2).getKey(), (String)((Map.Entry)localObject2).getValue());
            }
            if (parame.e() != null)
            {
              paramString = new ByteArrayEntity(parame.e());
              ((HttpPost)localObject1).setEntity(paramString);
              paramString = (String)localObject1;
              break;
            }
            if (parame.f() != null)
            {
              try
              {
                ((HttpPost)localObject1).setEntity(new UrlEncodedFormEntity(parame.f(), "UTF-8"));
                paramString = (String)localObject1;
              }
              catch (UnsupportedEncodingException paramString)
              {
                paramString.printStackTrace();
                paramString = (String)localObject1;
              }
              break;
            }
            paramString = (String)localObject1;
            if (parame.g() == null) {
              break;
            }
            ((HttpPost)localObject1).setEntity(parame.g());
            paramString = (String)localObject1;
            break;
          }
        }
      }
      for (;;)
      {
        label777:
        label806:
        return null;
        paramf.b(11);
        paramf.c(4);
      }
      label834:
      paramString = null;
    }
  }
  
  public void a()
  {
    if (this.d != null) {}
    try
    {
      this.d.consumeContent();
      this.d = null;
      if (this.c != null) {
        this.c.getConnectionManager().shutdown();
      }
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        localIOException.printStackTrace();
      }
    }
  }
  
  public String b(String paramString, e parame, f paramf)
  {
    Object localObject1;
    Object localObject2;
    if ((!TextUtils.isEmpty(paramString)) && ((paramString.startsWith("http://")) || (paramString.startsWith("https://"))))
    {
      localObject1 = new BasicHttpParams();
      HttpConnectionParams.setConnectionTimeout((HttpParams)localObject1, parame.b());
      HttpConnectionParams.setSoTimeout((HttpParams)localObject1, parame.c());
      if (!TextUtils.isEmpty(this.a)) {
        ((HttpParams)localObject1).setParameter("http.route.default-proxy", new HttpHost(this.a, this.b));
      }
      this.c = new DefaultHttpClient((HttpParams)localObject1);
      if (parame.h().equalsIgnoreCase("GET"))
      {
        paramString = new HttpGet(paramString);
        localObject1 = parame.d().entrySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (Map.Entry)((Iterator)localObject1).next();
          paramString.addHeader((String)((Map.Entry)localObject2).getKey(), (String)((Map.Entry)localObject2).getValue());
        }
        paramString.addHeader("accept-encoding", "gzip,deflate");
      }
    }
    for (;;)
    {
      if (paramString != null)
      {
        if (parame.a()) {
          paramString.addHeader("User-Agent", "Mozilla/5.0 (Linux; U; Android 2.2; en-us; Nexus One Build/FRF91) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1");
        }
        try
        {
          parame = this.c.execute(paramString);
          paramString = parame;
        }
        catch (ClientProtocolException paramString)
        {
          for (;;)
          {
            paramString.printStackTrace();
            paramf.b(11);
            paramf.c(5);
            paramf.a(paramString.getMessage());
            paramf.a(paramString);
            paramString = null;
          }
        }
        catch (ConnectTimeoutException paramString)
        {
          for (;;)
          {
            paramString.printStackTrace();
            paramf.b(11);
            paramf.c(6);
            paramf.a(paramString.getMessage());
            paramf.a(paramString);
            paramString = null;
          }
        }
        catch (SocketTimeoutException paramString)
        {
          for (;;)
          {
            paramString.printStackTrace();
            paramf.b(11);
            paramf.c(12);
            paramf.a(paramString.getMessage());
            paramf.a(paramString);
            paramString = null;
          }
        }
        catch (IOException paramString)
        {
          for (;;)
          {
            paramString.printStackTrace();
            paramf.b(11);
            paramf.c(7);
            paramf.a(paramString.getMessage());
            paramf.a(paramString);
            paramString = null;
          }
        }
        catch (NullPointerException parame)
        {
          for (;;)
          {
            parame.printStackTrace();
            paramString.abort();
            paramf.b(11);
            paramf.c(13);
            paramf.a(parame.getMessage());
            paramf.a(parame);
            paramString = null;
          }
        }
        catch (Exception paramString)
        {
          for (;;)
          {
            int i;
            paramString.printStackTrace();
            paramf.a(paramString);
            paramString = null;
            continue;
            if ((i < 500) || (i >= 600)) {
              break;
            }
            paramf.b(11);
            paramf.c(-1);
            paramString = null;
          }
          paramf.b(11);
          paramf.c(8);
        }
        if (paramString != null)
        {
          parame = paramString.headerIterator();
          for (;;)
          {
            if ((parame != null) && (parame.hasNext()))
            {
              localObject2 = parame.nextHeader();
              localObject1 = ((Header)localObject2).getName().toLowerCase(Locale.US);
              localObject2 = ((Header)localObject2).getValue();
              if ((localObject1 != null) && ((((String)localObject1).equalsIgnoreCase("Content-Encoding")) || (((String)localObject1).equalsIgnoreCase("X_Enc"))) && ((((String)localObject2).indexOf("gzip") != -1) || (((String)localObject2).indexOf("x-gzip") != -1))) {
                paramf.a(true);
              }
            }
            else
            {
              i = paramString.getStatusLine().getStatusCode();
              paramf.g(i);
              if (i == 200)
              {
                paramString = b(paramString, paramf);
                b();
                return paramString;
                if (!parame.h().equalsIgnoreCase("POST")) {
                  break label853;
                }
                localObject1 = new HttpPost(paramString);
                paramString = parame.d().entrySet().iterator();
                while (paramString.hasNext())
                {
                  localObject2 = (Map.Entry)paramString.next();
                  ((HttpRequestBase)localObject1).addHeader((String)((Map.Entry)localObject2).getKey(), (String)((Map.Entry)localObject2).getValue());
                }
                if (parame.e() != null)
                {
                  paramString = new ByteArrayEntity(parame.e());
                  ((HttpPost)localObject1).setEntity(paramString);
                  paramString = (String)localObject1;
                  break;
                }
                if (parame.f() != null)
                {
                  try
                  {
                    ((HttpPost)localObject1).setEntity(new UrlEncodedFormEntity(parame.f(), "UTF-8"));
                    paramString = (String)localObject1;
                  }
                  catch (UnsupportedEncodingException paramString)
                  {
                    paramString.printStackTrace();
                    paramf.a(paramString);
                    paramString = (String)localObject1;
                  }
                  break;
                }
                paramString = (String)localObject1;
                if (parame.g() == null) {
                  break;
                }
                ((HttpPost)localObject1).setEntity(parame.g());
                paramString = (String)localObject1;
                break;
              }
            }
          }
        }
      }
      for (;;)
      {
        paramString = null;
        break;
        paramf.a("请求URL不合法：" + paramString);
        paramf.b(11);
        paramf.c(4);
      }
      label853:
      paramString = null;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/goweather/b/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */