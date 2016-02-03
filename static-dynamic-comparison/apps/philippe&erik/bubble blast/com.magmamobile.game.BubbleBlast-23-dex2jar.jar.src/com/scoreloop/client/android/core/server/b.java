package com.scoreloop.client.android.core.server;

import com.scoreloop.client.android.core.utils.Base64;
import com.scoreloop.client.android.core.utils.Logger;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;
import org.json.JSONArray;
import org.json.JSONException;

class b
{
  private final HttpClient a;
  private String b;
  private final URI c;
  private String d;
  
  b(URI paramURI)
  {
    this.c = paramURI;
    this.a = new DefaultHttpClient();
    paramURI = this.a.getParams();
    HttpConnectionParams.setSoTimeout(paramURI, 90000);
    HttpConnectionParams.setConnectionTimeout(paramURI, 10000);
  }
  
  /* Error */
  private JSONArray a(HttpPost paramHttpPost, Object paramObject)
    throws e
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: aload_2
    //   3: invokevirtual 57	java/lang/Object:toString	()Ljava/lang/String;
    //   6: invokevirtual 60	com/scoreloop/client/android/core/server/b:a	(Lorg/apache/http/client/methods/HttpPost;Ljava/lang/String;)Ljava/lang/String;
    //   9: astore_1
    //   10: new 62	org/json/JSONArray
    //   13: dup
    //   14: aload_1
    //   15: invokespecial 65	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   18: astore_2
    //   19: aload_0
    //   20: ldc 67
    //   22: aload_2
    //   23: iconst_4
    //   24: invokevirtual 70	org/json/JSONArray:toString	(I)Ljava/lang/String;
    //   27: invokespecial 73	com/scoreloop/client/android/core/server/b:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   30: aload_2
    //   31: areturn
    //   32: astore_1
    //   33: new 75	com/scoreloop/client/android/core/server/g
    //   36: dup
    //   37: ldc 77
    //   39: aload_1
    //   40: invokespecial 80	com/scoreloop/client/android/core/server/g:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   43: athrow
    //   44: astore_1
    //   45: new 75	com/scoreloop/client/android/core/server/g
    //   48: dup
    //   49: ldc 82
    //   51: aload_1
    //   52: invokespecial 80	com/scoreloop/client/android/core/server/g:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   55: athrow
    //   56: astore_1
    //   57: new 84	com/scoreloop/client/android/core/server/c
    //   60: dup
    //   61: aload_1
    //   62: invokespecial 87	com/scoreloop/client/android/core/server/c:<init>	(Ljava/lang/Throwable;)V
    //   65: athrow
    //   66: astore_1
    //   67: new 43	com/scoreloop/client/android/core/server/e
    //   70: dup
    //   71: ldc 89
    //   73: aload_1
    //   74: invokespecial 90	com/scoreloop/client/android/core/server/e:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   77: athrow
    //   78: astore_2
    //   79: aload_0
    //   80: ldc 92
    //   82: aload_1
    //   83: invokespecial 94	com/scoreloop/client/android/core/server/b:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   86: new 75	com/scoreloop/client/android/core/server/g
    //   89: dup
    //   90: ldc 96
    //   92: aload_2
    //   93: invokespecial 80	com/scoreloop/client/android/core/server/g:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   96: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	97	0	this	b
    //   0	97	1	paramHttpPost	HttpPost
    //   0	97	2	paramObject	Object
    // Exception table:
    //   from	to	target	type
    //   0	10	32	org/apache/http/client/HttpResponseException
    //   0	10	44	org/apache/http/client/ClientProtocolException
    //   0	10	56	java/io/InterruptedIOException
    //   0	10	66	java/io/IOException
    //   10	30	78	org/json/JSONException
  }
  
  private void a(String paramString1, String paramString2)
  {
    Logger.a("doJSONRequest", "\n ");
    Logger.a("doJSONRequest", paramString1);
    paramString1 = paramString2.split("\\},\\n");
    int i = 0;
    while (i < paramString1.length - 1)
    {
      Logger.a("doJSONRequest", paramString1[i] + "},\n");
      i += 1;
    }
    Logger.a("doJSONRequest", paramString1[i]);
  }
  
  private void a(JSONArray paramJSONArray)
  {
    try
    {
      String str = paramJSONArray.toString(4);
      paramJSONArray = str;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        paramJSONArray = paramJSONArray.toString();
      }
    }
    a("Request:\n", paramJSONArray);
  }
  
  private void b(String paramString1, String paramString2)
  {
    Logger.b("doJSONRequest", "\n ");
    Logger.b("doJSONRequest", paramString1);
    paramString1 = paramString2.split("\\},\\n");
    int i = 0;
    while (i < paramString1.length - 1)
    {
      Logger.b("doJSONRequest", paramString1[i] + "},\n");
      i += 1;
    }
    Logger.b("doJSONRequest", paramString1[i]);
  }
  
  String a(HttpPost paramHttpPost, String paramString)
    throws IOException, ClientProtocolException
  {
    if ((this.d == null) || (this.b == null)) {
      throw new IllegalStateException("Try setting password and username first");
    }
    paramHttpPost.setHeader("Content-Type", b());
    paramHttpPost.setHeader("Accept", b());
    paramHttpPost.setHeader("X-Scoreloop-SDK-Version", "1");
    String str = this.d + ":" + this.b;
    paramHttpPost.setHeader("Authorization", "Basic " + Base64.a(str.getBytes()));
    try
    {
      paramHttpPost.setEntity(new StringEntity(paramString, "UTF8"));
      paramHttpPost = new BufferedReader(new InputStreamReader(this.a.execute(paramHttpPost).getEntity().getContent()));
      paramString = new StringBuffer();
      for (;;)
      {
        str = paramHttpPost.readLine();
        if (str == null) {
          break;
        }
        paramString.append(str);
        paramString.append('\n');
      }
      paramHttpPost.close();
    }
    catch (UnsupportedEncodingException paramHttpPost)
    {
      throw new IllegalStateException();
    }
    return paramString.toString();
  }
  
  HttpPost a()
  {
    return new HttpPost(this.c);
  }
  
  JSONArray a(HttpPost paramHttpPost, JSONArray paramJSONArray)
    throws e
  {
    a(paramJSONArray);
    return a(paramHttpPost, paramJSONArray);
  }
  
  void a(String paramString)
  {
    this.b = paramString;
  }
  
  byte[] a(HttpPost paramHttpPost, byte[] paramArrayOfByte)
    throws IOException, ClientProtocolException
  {
    if ((this.d == null) || (this.b == null)) {
      throw new IllegalStateException("Try setting password and username first");
    }
    paramHttpPost.setHeader("Content-Type", b());
    paramHttpPost.setHeader("Accept", b());
    paramHttpPost.setHeader("X-Scoreloop-SDK-Version", "1");
    String str = this.d + ":" + this.b;
    paramHttpPost.setHeader("Authorization", "Basic " + Base64.a(str.getBytes()));
    paramHttpPost.setEntity(new ByteArrayEntity(paramArrayOfByte));
    paramArrayOfByte = this.a.execute(paramHttpPost).getEntity();
    paramHttpPost = new byte[(int)paramArrayOfByte.getContentLength()];
    paramArrayOfByte = new BufferedInputStream(paramArrayOfByte.getContent());
    int j = paramHttpPost.length;
    int i = 0;
    while (j > 0)
    {
      int k = paramArrayOfByte.read(paramHttpPost, i, j);
      if (k == -1) {
        throw new IllegalStateException("Premature EOF");
      }
      j -= k;
      i += k;
    }
    paramArrayOfByte.close();
    return paramHttpPost;
  }
  
  String b()
  {
    return "application/json";
  }
  
  void b(String paramString)
  {
    this.d = paramString;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/scoreloop/client/android/core/server/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */