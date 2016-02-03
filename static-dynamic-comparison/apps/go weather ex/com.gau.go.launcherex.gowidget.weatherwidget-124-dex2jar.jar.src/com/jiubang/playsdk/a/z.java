package com.jiubang.playsdk.a;

import com.android.a.a.g;
import com.android.a.p;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.message.BasicNameValuePair;

public class z
  extends g
{
  public z(HttpClient paramHttpClient)
  {
    super(paramHttpClient);
  }
  
  private static List a(Map paramMap)
  {
    ArrayList localArrayList = new ArrayList(paramMap.size());
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localArrayList.add(new BasicNameValuePair(str, (String)paramMap.get(str)));
    }
    return localArrayList;
  }
  
  protected void a(HttpUriRequest paramHttpUriRequest, p paramp)
  {
    if (((paramHttpUriRequest instanceof HttpEntityEnclosingRequest)) && ((paramp instanceof o)))
    {
      HttpEntityEnclosingRequest localHttpEntityEnclosingRequest = (HttpEntityEnclosingRequest)paramHttpUriRequest;
      localHttpEntityEnclosingRequest.removeHeaders("Content-Type");
      UrlEncodedFormEntity localUrlEncodedFormEntity = new UrlEncodedFormEntity(a(((o)paramp).j()), "UTF-8");
      localUrlEncodedFormEntity.setChunked(false);
      localHttpEntityEnclosingRequest.setEntity(localUrlEncodedFormEntity);
    }
    super.a(paramHttpUriRequest, paramp);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/playsdk/a/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */