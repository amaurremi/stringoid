package com.gau.go.gostaticsdk.b;

import android.content.Context;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy.Type;
import java.net.URL;

public abstract class a
{
  protected HttpURLConnection a;
  protected Context b;
  
  public a(Context paramContext)
  {
    this.b = paramContext;
  }
  
  public int a(String paramString, int paramInt)
  {
    if (paramString != null) {}
    for (;;)
    {
      try
      {
        if ((!paramString.trim().equals("null")) && (!paramString.trim().equals("")))
        {
          paramString = new URL(paramString);
          com.gau.go.gostaticsdk.f.d.a("StatisticsManager", paramString.toString());
          if (com.gau.go.gostaticsdk.f.d.a(this.b))
          {
            paramInt = com.gau.go.gostaticsdk.f.d.b(this.b);
            if (paramInt == 1) {}
          }
        }
        else
        {
          try
          {
            Object localObject1;
            if (com.gau.go.gostaticsdk.f.d.b(this.b) == 2)
            {
              localObject1 = android.net.Proxy.getDefaultHost();
              paramInt = android.net.Proxy.getDefaultPort();
              localObject1 = new java.net.Proxy(Proxy.Type.HTTP, new InetSocketAddress((String)localObject1, paramInt));
              if (localObject1 != null)
              {
                paramString = (HttpURLConnection)paramString.openConnection((java.net.Proxy)localObject1);
                paramString.setDoOutput(true);
                paramString.setDoInput(true);
                paramString.setRequestMethod("POST");
                paramString.setUseCaches(false);
                paramString.setInstanceFollowRedirects(true);
                paramString.setConnectTimeout(30000);
                paramString.setReadTimeout(30000);
                paramString.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                this.a = paramString;
                return 0;
                if (com.gau.go.gostaticsdk.d.a(this.b).a())
                {
                  if (paramInt == 19)
                  {
                    paramString = new URL(com.gau.go.gostaticsdk.d.a + "&is_response_json=1");
                    continue;
                  }
                  paramString = new URL(com.gau.go.gostaticsdk.d.a);
                  continue;
                }
                if (paramInt == 19)
                {
                  paramString = new URL("http://goupdate.3g.cn/GOClientData/DR?ptl=10&is_zip=1&is_response_json=1");
                  continue;
                }
                paramString = new URL("http://goupdate.3g.cn/GOClientData/DR?ptl=10&is_zip=1");
              }
            }
            else
            {
              localObject1 = com.gau.go.gostaticsdk.f.d.c(this.b);
              paramInt = com.gau.go.gostaticsdk.f.d.d(this.b);
              localObject1 = new java.net.Proxy(Proxy.Type.HTTP, new InetSocketAddress((String)localObject1, paramInt));
              continue;
            }
          }
          catch (Exception localException)
          {
            localObject2 = null;
            continue;
            paramString = (HttpURLConnection)paramString.openConnection();
            continue;
          }
        }
        Object localObject2 = null;
      }
      catch (MalformedURLException paramString)
      {
        return 2;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return 1;
      }
    }
  }
  
  public void a(com.gau.go.gostaticsdk.a.a parama)
  {
    if (2 == a(parama.p, parama.a))
    {
      parama.f = 3;
      return;
    }
    b(parama);
  }
  
  public abstract void b(com.gau.go.gostaticsdk.a.a parama);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/gostaticsdk/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */