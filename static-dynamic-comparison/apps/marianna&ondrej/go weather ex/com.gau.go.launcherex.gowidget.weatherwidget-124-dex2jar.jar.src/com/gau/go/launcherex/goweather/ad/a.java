package com.gau.go.launcherex.goweather.ad;

import android.content.Context;
import android.text.TextUtils;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;

public class a
{
  private Context a;
  private ExecutorService b;
  private HttpClient c;
  
  public a(Context paramContext)
  {
    this.a = paramContext;
    this.b = Executors.newFixedThreadPool(1);
    paramContext = new BasicHttpParams();
    HttpConnectionParams.setConnectionTimeout(paramContext, 15000);
    HttpConnectionParams.setSoTimeout(paramContext, 15000);
    this.c = new DefaultHttpClient(paramContext);
  }
  
  public void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      String str = paramString;
      if (!paramString.startsWith("http://"))
      {
        str = paramString;
        if (!paramString.startsWith("https://")) {
          str = "http://" + paramString;
        }
      }
      this.b.execute(new b(this, str));
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/goweather/ad/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */