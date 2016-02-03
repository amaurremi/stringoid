package com.android.a.a;

import com.android.a.p;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolVersion;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.message.BasicStatusLine;

public class k
  implements j
{
  private final l a;
  private final SSLSocketFactory b;
  
  public k()
  {
    this(null);
  }
  
  public k(l paraml)
  {
    this(paraml, null);
  }
  
  public k(l paraml, SSLSocketFactory paramSSLSocketFactory)
  {
    this.a = paraml;
    this.b = paramSSLSocketFactory;
  }
  
  private HttpURLConnection a(URL paramURL, p paramp)
  {
    HttpURLConnection localHttpURLConnection = a(paramURL);
    int i = paramp.t();
    localHttpURLConnection.setConnectTimeout(i);
    localHttpURLConnection.setReadTimeout(i);
    localHttpURLConnection.setUseCaches(false);
    localHttpURLConnection.setDoInput(true);
    if (("https".equals(paramURL.getProtocol())) && (this.b != null)) {
      ((HttpsURLConnection)localHttpURLConnection).setSSLSocketFactory(this.b);
    }
    return localHttpURLConnection;
  }
  
  private static HttpEntity a(HttpURLConnection paramHttpURLConnection)
  {
    BasicHttpEntity localBasicHttpEntity = new BasicHttpEntity();
    try
    {
      InputStream localInputStream1 = paramHttpURLConnection.getInputStream();
      localBasicHttpEntity.setContent(localInputStream1);
      localBasicHttpEntity.setContentLength(paramHttpURLConnection.getContentLength());
      localBasicHttpEntity.setContentEncoding(paramHttpURLConnection.getContentEncoding());
      localBasicHttpEntity.setContentType(paramHttpURLConnection.getContentType());
      return localBasicHttpEntity;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        InputStream localInputStream2 = paramHttpURLConnection.getErrorStream();
      }
    }
  }
  
  static void a(HttpURLConnection paramHttpURLConnection, p paramp)
  {
    switch (paramp.a())
    {
    default: 
      throw new IllegalStateException("Unknown method type.");
    case -1: 
      byte[] arrayOfByte = paramp.m();
      if (arrayOfByte != null)
      {
        paramHttpURLConnection.setDoOutput(true);
        paramHttpURLConnection.setRequestMethod("POST");
        paramHttpURLConnection.addRequestProperty("Content-Type", paramp.l());
        paramHttpURLConnection = new DataOutputStream(paramHttpURLConnection.getOutputStream());
        paramHttpURLConnection.write(arrayOfByte);
        paramHttpURLConnection.close();
      }
      return;
    case 0: 
      paramHttpURLConnection.setRequestMethod("GET");
      return;
    case 3: 
      paramHttpURLConnection.setRequestMethod("DELETE");
      return;
    case 1: 
      paramHttpURLConnection.setRequestMethod("POST");
      b(paramHttpURLConnection, paramp);
      return;
    case 2: 
      paramHttpURLConnection.setRequestMethod("PUT");
      b(paramHttpURLConnection, paramp);
      return;
    case 4: 
      paramHttpURLConnection.setRequestMethod("HEAD");
      return;
    case 5: 
      paramHttpURLConnection.setRequestMethod("OPTIONS");
      return;
    case 6: 
      paramHttpURLConnection.setRequestMethod("TRACE");
      return;
    }
    b(paramHttpURLConnection, paramp);
    paramHttpURLConnection.setRequestMethod("PATCH");
  }
  
  private static void b(HttpURLConnection paramHttpURLConnection, p paramp)
  {
    byte[] arrayOfByte = paramp.q();
    if (arrayOfByte != null)
    {
      paramHttpURLConnection.setDoOutput(true);
      paramHttpURLConnection.addRequestProperty("Content-Type", paramp.p());
      paramHttpURLConnection = new DataOutputStream(paramHttpURLConnection.getOutputStream());
      paramHttpURLConnection.write(arrayOfByte);
      paramHttpURLConnection.close();
    }
  }
  
  protected HttpURLConnection a(URL paramURL)
  {
    return (HttpURLConnection)paramURL.openConnection();
  }
  
  public HttpResponse a(p paramp, Map paramMap)
  {
    Object localObject = paramp.d();
    HashMap localHashMap = new HashMap();
    localHashMap.putAll(paramp.i());
    localHashMap.putAll(paramMap);
    String str;
    if (this.a != null)
    {
      str = this.a.a((String)localObject);
      paramMap = str;
      if (str == null) {
        throw new IOException("URL blocked by rewriter: " + (String)localObject);
      }
    }
    else
    {
      paramMap = (Map)localObject;
    }
    paramMap = a(new URL(paramMap), paramp);
    localObject = localHashMap.keySet().iterator();
    for (;;)
    {
      if (!((Iterator)localObject).hasNext())
      {
        a(paramMap, paramp);
        paramp = new ProtocolVersion("HTTP", 1, 1);
        if (paramMap.getResponseCode() != -1) {
          break;
        }
        throw new IOException("Could not retrieve response code from HttpUrlConnection.");
      }
      str = (String)((Iterator)localObject).next();
      paramMap.addRequestProperty(str, (String)localHashMap.get(str));
    }
    paramp = new BasicHttpResponse(new BasicStatusLine(paramp, paramMap.getResponseCode(), paramMap.getResponseMessage()));
    paramp.setEntity(a(paramMap));
    paramMap = paramMap.getHeaderFields().entrySet().iterator();
    for (;;)
    {
      if (!paramMap.hasNext()) {
        return paramp;
      }
      localObject = (Map.Entry)paramMap.next();
      if (((Map.Entry)localObject).getKey() != null) {
        paramp.addHeader(new BasicHeader((String)((Map.Entry)localObject).getKey(), (String)((List)((Map.Entry)localObject).getValue()).get(0)));
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/android/a/a/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */