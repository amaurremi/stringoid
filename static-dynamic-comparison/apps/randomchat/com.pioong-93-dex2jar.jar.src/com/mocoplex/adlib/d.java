package com.mocoplex.adlib;

import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.zip.GZIPInputStream;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpEntity;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.HttpVersion;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.HttpEntityWrapper;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.HttpContext;

public final class d
  implements Runnable
{
  private String a;
  private int b;
  private Handler c;
  private String d;
  private UrlEncodedFormEntity e;
  private ByteArrayEntity f;
  private ArrayList g;
  
  public d()
  {
    this(new Handler());
  }
  
  public d(Handler paramHandler)
  {
    this.c = paramHandler;
  }
  
  private String a()
  {
    String str = "";
    int i = 0;
    for (;;)
    {
      if (i >= this.g.size()) {
        return str;
      }
      BasicNameValuePair localBasicNameValuePair = (BasicNameValuePair)this.g.get(i);
      str = new StringBuilder(String.valueOf(new StringBuilder(String.valueOf(new StringBuilder(String.valueOf(str)).append(localBasicNameValuePair.getName()).toString())).append("=").toString())).append(localBasicNameValuePair.getValue()).toString() + ";";
      i += 1;
    }
  }
  
  private void a(HttpResponse paramHttpResponse)
    throws IllegalStateException, IOException
  {
    paramHttpResponse = new BufferedReader(new InputStreamReader(paramHttpResponse.getEntity().getContent(), "UTF-8"));
    char[] arrayOfChar = new char['Ѐ'];
    StringWriter localStringWriter = new StringWriter();
    for (;;)
    {
      int i = paramHttpResponse.read(arrayOfChar);
      if (i == -1)
      {
        paramHttpResponse = localStringWriter.toString();
        paramHttpResponse = Message.obtain(this.c, 2, paramHttpResponse);
        this.c.sendMessage(paramHttpResponse);
        return;
      }
      localStringWriter.write(arrayOfChar, 0, i);
    }
  }
  
  public final void a(String paramString, UrlEncodedFormEntity paramUrlEncodedFormEntity)
  {
    this.b = 1;
    this.a = paramString;
    this.e = paramUrlEncodedFormEntity;
    a.a().a(this);
  }
  
  public final void a(String paramString, ByteArrayEntity paramByteArrayEntity, ArrayList paramArrayList)
  {
    this.b = 1;
    this.a = paramString;
    this.f = paramByteArrayEntity;
    this.g = paramArrayList;
    a.a().a(this);
  }
  
  public final void run()
  {
    this.c.sendMessage(Message.obtain(this.c, 0));
    Object localObject1 = new BasicHttpParams();
    HttpProtocolParams.setVersion((HttpParams)localObject1, HttpVersion.HTTP_1_1);
    ((HttpParams)localObject1).setParameter("http.protocol.version", HttpVersion.HTTP_1_1);
    Object localObject3 = new DefaultHttpClient((HttpParams)localObject1);
    ((DefaultHttpClient)localObject3).addRequestInterceptor(new HttpRequestInterceptor()
    {
      public final void process(HttpRequest paramAnonymousHttpRequest, HttpContext paramAnonymousHttpContext)
      {
        if (!paramAnonymousHttpRequest.containsHeader("Accept-Encoding")) {
          paramAnonymousHttpRequest.addHeader("Accept-Encoding", "gzip");
        }
      }
    });
    ((DefaultHttpClient)localObject3).addResponseInterceptor(new HttpResponseInterceptor()
    {
      public final void process(HttpResponse paramAnonymousHttpResponse, HttpContext paramAnonymousHttpContext)
      {
        paramAnonymousHttpContext = paramAnonymousHttpResponse.getEntity().getContentEncoding();
        int j;
        int i;
        if (paramAnonymousHttpContext != null)
        {
          paramAnonymousHttpContext = paramAnonymousHttpContext.getElements();
          j = paramAnonymousHttpContext.length;
          i = 0;
        }
        for (;;)
        {
          if (i >= j) {
            return;
          }
          if (paramAnonymousHttpContext[i].getName().equalsIgnoreCase("gzip"))
          {
            paramAnonymousHttpResponse.setEntity(new d.a(paramAnonymousHttpResponse.getEntity()));
            return;
          }
          i += 1;
        }
      }
    });
    HttpConnectionParams.setSoTimeout(((DefaultHttpClient)localObject3).getParams(), 5000);
    localObject1 = null;
    try
    {
      switch (this.b)
      {
      case 0: 
        for (;;)
        {
          if (this.b < 4) {
            a((HttpResponse)localObject1);
          }
          localObject1 = a.a();
          ((a)localObject1).a.remove(this);
          ((a)localObject1).b();
          return;
          localObject1 = ((DefaultHttpClient)localObject3).execute(new HttpGet(this.a));
        }
      case 1: 
        localObject1 = new HttpPost(this.a);
        if (this.f != null)
        {
          ((HttpPost)localObject1).setEntity(this.f);
          ((HttpPost)localObject1).setHeader("Content-type", "application/octet-stream");
          ((HttpPost)localObject1).setHeader("Cookie", a());
          ((HttpPost)localObject1).setHeader("Content-type", "application/octet-stream");
        }
        for (;;)
        {
          localObject1 = ((DefaultHttpClient)localObject3).execute((HttpUriRequest)localObject1);
          break;
          ((HttpPost)localObject1).setEntity(this.e);
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        this.c.sendMessage(Message.obtain(this.c, 1, localException));
        continue;
        Object localObject2 = new HttpPut(this.a);
        ((HttpPut)localObject2).setEntity(new StringEntity(this.d));
        localObject2 = ((DefaultHttpClient)localObject3).execute((HttpUriRequest)localObject2);
        continue;
        localObject2 = ((DefaultHttpClient)localObject3).execute(new HttpDelete(this.a));
        continue;
        localObject2 = ((DefaultHttpClient)localObject3).execute(new HttpGet(this.a));
        localObject3 = BitmapFactory.decodeStream(new BufferedHttpEntity(((HttpResponse)localObject2).getEntity()).getContent());
        this.c.sendMessage(Message.obtain(this.c, 2, localObject3));
      }
    }
  }
  
  static final class a
    extends HttpEntityWrapper
  {
    public a(HttpEntity paramHttpEntity)
    {
      super();
    }
    
    public final InputStream getContent()
      throws IOException
    {
      return new GZIPInputStream(this.wrappedEntity.getContent());
    }
    
    public final long getContentLength()
    {
      return -1L;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/mocoplex/adlib/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */