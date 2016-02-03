package com.gau.go.launcherex.goweather.ad;

import com.gtp.a.a.b.c;
import java.io.IOException;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;

class b
  implements Runnable
{
  b(a parama, String paramString) {}
  
  public void run()
  {
    Object localObject1;
    if (com.jiubang.goweather.e.a.b(a.a(this.b))) {
      localObject1 = new HttpGet(this.a);
    }
    try
    {
      localObject1 = a.b(this.b).execute((HttpUriRequest)localObject1);
      if ((localObject1 != null) && (((HttpResponse)localObject1).getStatusLine().getStatusCode() == 200)) {
        c.a("ad", "访问监控url成功！");
      }
      return;
    }
    catch (ClientProtocolException localClientProtocolException)
    {
      for (;;)
      {
        localClientProtocolException.printStackTrace();
        Object localObject2 = null;
      }
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        localIOException.printStackTrace();
        Object localObject3 = null;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/goweather/ad/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */