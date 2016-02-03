package com.mapbar.android.location;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.params.ConnRouteParams;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;

public final class u
{
  private static StringBuffer k = null;
  private Context a;
  private s b;
  private ConnectivityManager c;
  private int d = 0;
  private int e = 0;
  private String f = "";
  private int g = 0;
  private int h;
  private boolean i = false;
  private boolean j = false;
  private String l = "10.0.0.172";
  
  public u(Context paramContext, int paramInt1, int paramInt2)
  {
    this.a = paramContext;
    this.d = 3;
    this.e = 0;
    this.b = s.a(paramContext);
    this.c = this.b.a;
  }
  
  private String b()
  {
    try
    {
      if (k == null)
      {
        localObject2 = "";
        localObject1 = localObject2;
      }
    }
    catch (Exception localException1)
    {
      Object localObject2;
      Object localObject1;
      PackageInfo localPackageInfo;
      label86:
      return "";
    }
    try
    {
      localPackageInfo = this.a.getPackageManager().getPackageInfo(this.a.getPackageName(), 0);
      localObject1 = localObject2;
      localObject2 = URLEncoder.encode(localPackageInfo.applicationInfo.loadLabel(this.a.getPackageManager()).toString(), "utf-8");
      localObject1 = localObject2;
      localObject2 = (String)localObject2 + "_" + localPackageInfo.versionName;
      localObject1 = localObject2;
    }
    catch (Exception localException2)
    {
      break label86;
    }
    localObject2 = new StringBuffer();
    k = (StringBuffer)localObject2;
    ((StringBuffer)localObject2).append("Android_CellLocation_").append(g.a).append("_").append(p.b(this.a.getPackageName()) + "@" + (String)localObject1).append(";").append(l.a).append(";").append(l.b).append(";").append(Build.BRAND).append(";").append(Build.MODEL).append(";").append(Build.VERSION.SDK);
    localObject1 = k.toString();
    return (String)localObject1;
  }
  
  private byte[] b(String paramString)
  {
    localDefaultHttpClient = new DefaultHttpClient();
    if (this.e == 0) {
      paramString = new HttpPost(paramString);
    }
    for (;;)
    {
      if (this.i)
      {
        localObject = localDefaultHttpClient.getParams();
        ConnRouteParams.setDefaultProxy((HttpParams)localObject, new HttpHost(this.l, 80));
        paramString.setParams((HttpParams)localObject);
      }
      Object localObject = new BasicHttpParams();
      HttpConnectionParams.setConnectionTimeout((HttpParams)localObject, 20000);
      HttpConnectionParams.setSoTimeout((HttpParams)localObject, 20000);
      paramString.setParams((HttpParams)localObject);
      localObject = l.a(this.a);
      if ((localObject != null) && (((String)localObject).trim().length() > 0)) {
        paramString.addHeader("maptag", (String)localObject);
      }
      paramString.addHeader("IMEI", l.a);
      paramString.setHeader("User-Agent", b());
      paramString.addHeader("s_n", b());
      int m = this.e;
      try
      {
        localObject = localDefaultHttpClient.execute(paramString);
        this.h = ((HttpResponse)localObject).getStatusLine().getStatusCode();
        if (this.h == 200)
        {
          localObject = EntityUtils.toByteArray(((HttpResponse)localObject).getEntity());
          return (byte[])localObject;
          paramString = new HttpGet(paramString);
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        for (;;)
        {
          this.h = 413;
          paramString.abort();
          localDefaultHttpClient.getConnectionManager().shutdown();
        }
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        for (;;)
        {
          this.h = 400;
          paramString.abort();
          localDefaultHttpClient.getConnectionManager().shutdown();
        }
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          this.h = 502;
          paramString.abort();
          localDefaultHttpClient.getConnectionManager().shutdown();
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          this.h = 503;
          paramString.abort();
          localDefaultHttpClient.getConnectionManager().shutdown();
        }
      }
      finally
      {
        localDefaultHttpClient.getConnectionManager().shutdown();
      }
    }
    return null;
  }
  
  private String c(String paramString)
  {
    localDefaultHttpClient = new DefaultHttpClient();
    if (this.e == 0) {
      paramString = new HttpPost(paramString);
    }
    for (;;)
    {
      if (this.i)
      {
        localObject = localDefaultHttpClient.getParams();
        ConnRouteParams.setDefaultProxy((HttpParams)localObject, new HttpHost(this.l, 80));
        paramString.setParams((HttpParams)localObject);
      }
      Object localObject = new BasicHttpParams();
      HttpConnectionParams.setConnectionTimeout((HttpParams)localObject, 20000);
      HttpConnectionParams.setSoTimeout((HttpParams)localObject, 20000);
      paramString.setParams((HttpParams)localObject);
      localObject = l.a(this.a);
      if ((localObject != null) && (((String)localObject).trim().length() > 0)) {
        paramString.addHeader("maptag", (String)localObject);
      }
      paramString.addHeader("IMEI", l.a);
      paramString.setHeader("User-Agent", b());
      paramString.addHeader("s_n", b());
      int m = this.e;
      try
      {
        localObject = localDefaultHttpClient.execute(paramString);
        this.h = ((HttpResponse)localObject).getStatusLine().getStatusCode();
        if (this.h == 200)
        {
          localObject = EntityUtils.toString(((HttpResponse)localObject).getEntity(), "utf-8");
          return (String)localObject;
          paramString = new HttpGet(paramString);
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        for (;;)
        {
          this.h = 413;
          paramString.abort();
          localDefaultHttpClient.getConnectionManager().shutdown();
        }
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        for (;;)
        {
          this.h = 400;
          paramString.abort();
          localDefaultHttpClient.getConnectionManager().shutdown();
        }
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          this.h = 502;
          paramString.abort();
          localDefaultHttpClient.getConnectionManager().shutdown();
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          this.h = 503;
          paramString.abort();
          localDefaultHttpClient.getConnectionManager().shutdown();
        }
      }
      finally
      {
        localDefaultHttpClient.getConnectionManager().shutdown();
      }
    }
    return null;
  }
  
  private InputStream d(String paramString)
  {
    localDefaultHttpClient = new DefaultHttpClient();
    if (this.e == 0) {
      paramString = new HttpPost(paramString);
    }
    for (;;)
    {
      if (this.i)
      {
        localObject = localDefaultHttpClient.getParams();
        ConnRouteParams.setDefaultProxy((HttpParams)localObject, new HttpHost(this.l, 80));
        paramString.setParams((HttpParams)localObject);
      }
      Object localObject = new BasicHttpParams();
      HttpConnectionParams.setConnectionTimeout((HttpParams)localObject, 20000);
      HttpConnectionParams.setSoTimeout((HttpParams)localObject, 20000);
      paramString.setParams((HttpParams)localObject);
      localObject = l.a(this.a);
      if ((localObject != null) && (((String)localObject).trim().length() > 0)) {
        paramString.addHeader("maptag", (String)localObject);
      }
      paramString.addHeader("IMEI", l.a);
      paramString.setHeader("User-Agent", b());
      paramString.addHeader("s_n", b());
      int m = this.e;
      try
      {
        localObject = localDefaultHttpClient.execute(paramString);
        this.h = ((HttpResponse)localObject).getStatusLine().getStatusCode();
        if (this.h == 200)
        {
          localObject = ((HttpResponse)localObject).getEntity().getContent();
          return (InputStream)localObject;
          paramString = new HttpGet(paramString);
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        for (;;)
        {
          this.h = 413;
          paramString.abort();
          localDefaultHttpClient.getConnectionManager().shutdown();
        }
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        for (;;)
        {
          this.h = 400;
          paramString.abort();
          localDefaultHttpClient.getConnectionManager().shutdown();
        }
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          this.h = 502;
          paramString.abort();
          localDefaultHttpClient.getConnectionManager().shutdown();
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          this.h = 503;
          paramString.abort();
          localDefaultHttpClient.getConnectionManager().shutdown();
        }
      }
      finally
      {
        localDefaultHttpClient.getConnectionManager().shutdown();
      }
    }
    return null;
  }
  
  public final Object a()
  {
    Object localObject = this.c.getActiveNetworkInfo();
    if (localObject != null)
    {
      int m = ((NetworkInfo)localObject).getType();
      if ((m != 1) && (m == 0))
      {
        localObject = ((NetworkInfo)localObject).getExtraInfo();
        if (localObject != null)
        {
          localObject = ((String)localObject).toLowerCase();
          if (((String)localObject).indexOf("cmwap") == -1) {
            break label94;
          }
          this.i = true;
        }
      }
    }
    for (;;)
    {
      switch (this.d)
      {
      case 2: 
      default: 
        return null;
        label94:
        if (((String)localObject).indexOf("ctwap") != -1)
        {
          this.i = true;
          this.l = "10.0.0.200";
        }
        else if (((String)localObject).indexOf("3gwap") != -1)
        {
          this.i = true;
        }
        break;
      }
    }
    return b(this.f);
    return d(this.f);
    return c(this.f);
  }
  
  public final void a(String paramString)
  {
    this.f = paramString;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/mapbar/android/location/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */