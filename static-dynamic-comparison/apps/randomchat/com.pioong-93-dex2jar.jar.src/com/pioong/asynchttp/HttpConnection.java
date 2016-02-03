package com.pioong.asynchttp;

import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import com.pioong.global.Network;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.io.Writer;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.StatusLine;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;

public class HttpConnection
  implements Runnable
{
  private static final int BITMAP = 4;
  private static final int DELETE = 3;
  public static final int DID_ERROR = 1;
  public static final int DID_START = 0;
  public static final int DID_SUCCEED = 2;
  private static final int GET = 0;
  private static final int POST = 1;
  private static final int PUT = 2;
  private String data;
  private UrlEncodedFormEntity entity;
  private Handler handler;
  private int method;
  private String url;
  
  public HttpConnection()
  {
    this(new Handler());
  }
  
  public HttpConnection(Handler paramHandler)
  {
    this.handler = paramHandler;
  }
  
  public static String post2(String paramString, UrlEncodedFormEntity paramUrlEncodedFormEntity)
  {
    paramString = new HttpPost(paramString);
    paramString.setEntity(paramUrlEncodedFormEntity);
    paramUrlEncodedFormEntity = new BasicHttpParams();
    HttpProtocolParams.setVersion(paramUrlEncodedFormEntity, HttpVersion.HTTP_1_1);
    paramUrlEncodedFormEntity.setParameter("http.protocol.version", HttpVersion.HTTP_1_1);
    paramUrlEncodedFormEntity = new DefaultHttpClient(paramUrlEncodedFormEntity);
    HttpConnectionParams.setSoTimeout(paramUrlEncodedFormEntity.getParams(), 5000);
    try
    {
      paramString = paramUrlEncodedFormEntity.execute(paramString);
      if (paramString.getStatusLine().getStatusCode() != 200) {
        return null;
      }
      paramString = new BufferedReader(new InputStreamReader(paramString.getEntity().getContent(), "UTF-8"));
      paramUrlEncodedFormEntity = new char['Ѐ'];
      StringWriter localStringWriter = new StringWriter();
      for (;;)
      {
        int i = paramString.read(paramUrlEncodedFormEntity);
        if (i == -1) {
          return localStringWriter.toString();
        }
        localStringWriter.write(paramUrlEncodedFormEntity, 0, i);
      }
      return null;
    }
    catch (Exception paramString) {}
  }
  
  private void processBitmapEntity(HttpEntity paramHttpEntity)
    throws IOException
  {
    paramHttpEntity = BitmapFactory.decodeStream(new BufferedHttpEntity(paramHttpEntity).getContent());
    this.handler.sendMessage(Message.obtain(this.handler, 2, paramHttpEntity));
  }
  
  private void processEntity(HttpResponse paramHttpResponse)
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
        paramHttpResponse = Message.obtain(this.handler, 2, paramHttpResponse);
        this.handler.sendMessage(paramHttpResponse);
        return;
      }
      localStringWriter.write(arrayOfChar, 0, i);
    }
  }
  
  public void bitmap(String paramString)
  {
    create(4, paramString, null);
  }
  
  public void create(int paramInt, String paramString1, String paramString2)
  {
    this.method = paramInt;
    this.url = paramString1;
    this.data = paramString2;
    ConnectionManager.getInstance().push(this);
  }
  
  public void create2(int paramInt, String paramString, UrlEncodedFormEntity paramUrlEncodedFormEntity)
  {
    this.method = paramInt;
    this.url = paramString;
    this.entity = paramUrlEncodedFormEntity;
    ConnectionManager.getInstance().push(this);
  }
  
  public void delete(String paramString)
  {
    create(3, paramString, null);
  }
  
  public void get(String paramString)
  {
    create(0, paramString, null);
  }
  
  public void post(String paramString, UrlEncodedFormEntity paramUrlEncodedFormEntity)
  {
    create2(1, paramString, paramUrlEncodedFormEntity);
  }
  
  public void put(String paramString1, String paramString2)
  {
    create(2, paramString1, paramString2);
  }
  
  public void run()
  {
    this.handler.sendMessage(Message.obtain(this.handler, 0));
    Object localObject = new BasicHttpParams();
    HttpProtocolParams.setVersion((HttpParams)localObject, HttpVersion.HTTP_1_1);
    ((HttpParams)localObject).setParameter("http.protocol.version", HttpVersion.HTTP_1_1);
    DefaultHttpClient localDefaultHttpClient = new DefaultHttpClient((HttpParams)localObject);
    localObject = this.url;
    Network.getInstance();
    if (((String)localObject).indexOf(Network.URL_FINDROOM) >= 0) {
      HttpConnectionParams.setSoTimeout(localDefaultHttpClient.getParams(), 60000);
    }
    for (;;)
    {
      localObject = null;
      try
      {
        switch (this.method)
        {
        case 0: 
        case 1: 
        case 2: 
        case 3: 
        case 4: 
          for (;;)
          {
            if (this.method < 4) {
              processEntity((HttpResponse)localObject);
            }
            ConnectionManager.getInstance().didComplete(this);
            return;
            HttpConnectionParams.setSoTimeout(localDefaultHttpClient.getParams(), 5000);
            break;
            localObject = localDefaultHttpClient.execute(new HttpGet(this.url));
            continue;
            localObject = new HttpPost(this.url);
            ((HttpPost)localObject).setEntity(this.entity);
            localObject = localDefaultHttpClient.execute((HttpUriRequest)localObject);
            continue;
            localObject = new HttpPut(this.url);
            ((HttpPut)localObject).setEntity(new StringEntity(this.data));
            localObject = localDefaultHttpClient.execute((HttpUriRequest)localObject);
            continue;
            localObject = localDefaultHttpClient.execute(new HttpDelete(this.url));
            continue;
            localObject = localDefaultHttpClient.execute(new HttpGet(this.url));
            processBitmapEntity(((HttpResponse)localObject).getEntity());
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          this.handler.sendMessage(Message.obtain(this.handler, 1, localException));
        }
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/pioong/asynchttp/HttpConnection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */