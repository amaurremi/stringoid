package com.android.a.a;

import com.android.a.p;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpTrace;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.params.HttpConnectionParams;

public class g
  implements j
{
  protected final HttpClient a;
  
  public g(HttpClient paramHttpClient)
  {
    this.a = paramHttpClient;
  }
  
  private static void a(HttpEntityEnclosingRequestBase paramHttpEntityEnclosingRequestBase, p paramp)
  {
    paramp = paramp.q();
    if (paramp != null) {
      paramHttpEntityEnclosingRequestBase.setEntity(new ByteArrayEntity(paramp));
    }
  }
  
  private static void a(HttpUriRequest paramHttpUriRequest, Map paramMap)
  {
    Iterator localIterator = paramMap.keySet().iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return;
      }
      String str = (String)localIterator.next();
      paramHttpUriRequest.setHeader(str, (String)paramMap.get(str));
    }
  }
  
  static HttpUriRequest b(p paramp, Map paramMap)
  {
    switch (paramp.a())
    {
    default: 
      throw new IllegalStateException("Unknown request method.");
    case -1: 
      paramMap = paramp.m();
      if (paramMap != null)
      {
        HttpPost localHttpPost = new HttpPost(paramp.d());
        localHttpPost.addHeader("Content-Type", paramp.l());
        localHttpPost.setEntity(new ByteArrayEntity(paramMap));
        return localHttpPost;
      }
      return new HttpGet(paramp.d());
    case 0: 
      return new HttpGet(paramp.d());
    case 3: 
      return new HttpDelete(paramp.d());
    case 1: 
      paramMap = new HttpPost(paramp.d());
      paramMap.addHeader("Content-Type", paramp.p());
      a(paramMap, paramp);
      return paramMap;
    case 2: 
      paramMap = new HttpPut(paramp.d());
      paramMap.addHeader("Content-Type", paramp.p());
      a(paramMap, paramp);
      return paramMap;
    case 4: 
      return new HttpHead(paramp.d());
    case 5: 
      return new HttpOptions(paramp.d());
    case 6: 
      return new HttpTrace(paramp.d());
    }
    paramMap = new h(paramp.d());
    paramMap.addHeader("Content-Type", paramp.p());
    a(paramMap, paramp);
    return paramMap;
  }
  
  public HttpResponse a(p paramp, Map paramMap)
  {
    HttpUriRequest localHttpUriRequest = b(paramp, paramMap);
    a(localHttpUriRequest, paramMap);
    a(localHttpUriRequest, paramp.i());
    a(localHttpUriRequest, paramp);
    paramMap = localHttpUriRequest.getParams();
    int i = paramp.t();
    HttpConnectionParams.setConnectionTimeout(paramMap, 15000);
    HttpConnectionParams.setSoTimeout(paramMap, i);
    return this.a.execute(localHttpUriRequest);
  }
  
  protected void a(HttpUriRequest paramHttpUriRequest, p paramp) {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/android/a/a/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */