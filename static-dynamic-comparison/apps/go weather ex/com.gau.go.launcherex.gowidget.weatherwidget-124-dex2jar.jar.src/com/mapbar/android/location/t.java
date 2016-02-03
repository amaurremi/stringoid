package com.mapbar.android.location;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import org.apache.http.Header;
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

public final class t
  extends q<Object, Integer, Object>
{
  private static StringBuffer l = null;
  private Context a;
  private s b;
  private ConnectivityManager c;
  private int d = 0;
  private int e = 0;
  private String f = "";
  private int g;
  private int h = 0;
  private int i;
  private boolean j = false;
  private boolean k = false;
  private String m = "10.0.0.172";
  private b.e n;
  private b.f o;
  
  public t(Context paramContext, int paramInt1, int paramInt2)
  {
    this.a = paramContext;
    this.d = 3;
    this.e = 0;
    this.b = s.a(paramContext);
    this.c = this.b.a;
  }
  
  private byte[] b(String paramString)
  {
    int i3 = 0;
    localDefaultHttpClient = new DefaultHttpClient();
    if (this.e == 0) {
      paramString = new HttpPost(paramString);
    }
    for (;;)
    {
      if (this.j)
      {
        localObject = localDefaultHttpClient.getParams();
        ConnRouteParams.setDefaultProxy((HttpParams)localObject, new HttpHost(this.m, 80));
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
      paramString.setHeader("User-Agent", f());
      paramString.addHeader("s_n", f());
      int i1 = this.e;
      try
      {
        localObject = localDefaultHttpClient.execute(paramString);
        Header[] arrayOfHeader = ((HttpResponse)localObject).getHeaders("Server");
        int i2 = i3;
        int i4;
        if (arrayOfHeader != null)
        {
          i4 = arrayOfHeader.length;
          i1 = 0;
        }
        for (;;)
        {
          i2 = i3;
          if (i1 < i4)
          {
            String str = arrayOfHeader[i1].getValue();
            if ((str != null) && ("mapbarserver".equals(str.toLowerCase()))) {
              i2 = 1;
            }
          }
          else
          {
            if (i2 == 0) {
              break label337;
            }
            this.i = ((HttpResponse)localObject).getStatusLine().getStatusCode();
            if (this.o != null) {
              this.o.a(this, this.i);
            }
            if (this.i != 200) {
              break label355;
            }
            localObject = EntityUtils.toByteArray(((HttpResponse)localObject).getEntity());
            return (byte[])localObject;
            paramString = new HttpGet(paramString);
            break;
          }
          i1 += 1;
        }
        label337:
        if (this.o != null) {
          this.o.a(this, 401);
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        for (;;)
        {
          if (this.o != null) {
            this.o.a(this, 413);
          }
          paramString.abort();
          localDefaultHttpClient.getConnectionManager().shutdown();
        }
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        for (;;)
        {
          if (this.o != null) {
            this.o.a(this, 400);
          }
          paramString.abort();
          localDefaultHttpClient.getConnectionManager().shutdown();
        }
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          if (this.o != null) {
            this.o.a(this, 500);
          }
          paramString.abort();
          localDefaultHttpClient.getConnectionManager().shutdown();
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          label355:
          if (this.o != null) {
            this.o.a(this, 503);
          }
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
    int i3 = 0;
    localDefaultHttpClient = new DefaultHttpClient();
    if (this.e == 0) {
      paramString = new HttpPost(paramString);
    }
    for (;;)
    {
      if (this.j)
      {
        localObject = localDefaultHttpClient.getParams();
        ConnRouteParams.setDefaultProxy((HttpParams)localObject, new HttpHost(this.m, 80));
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
      paramString.setHeader("User-Agent", f());
      paramString.addHeader("s_n", f());
      int i1 = this.e;
      try
      {
        localObject = localDefaultHttpClient.execute(paramString);
        Header[] arrayOfHeader = ((HttpResponse)localObject).getHeaders("Server");
        int i2 = i3;
        int i4;
        if (arrayOfHeader != null)
        {
          i4 = arrayOfHeader.length;
          i1 = 0;
        }
        for (;;)
        {
          i2 = i3;
          if (i1 < i4)
          {
            String str = arrayOfHeader[i1].getValue();
            if ((str != null) && ("mapbarserver".equals(str.toLowerCase()))) {
              i2 = 1;
            }
          }
          else
          {
            if (i2 == 0) {
              break label339;
            }
            this.i = ((HttpResponse)localObject).getStatusLine().getStatusCode();
            if (this.o != null) {
              this.o.a(this, this.i);
            }
            if (this.i != 200) {
              break label357;
            }
            localObject = EntityUtils.toString(((HttpResponse)localObject).getEntity(), "utf-8");
            return (String)localObject;
            paramString = new HttpGet(paramString);
            break;
          }
          i1 += 1;
        }
        label339:
        if (this.o != null) {
          this.o.a(this, 401);
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        for (;;)
        {
          if (this.o != null) {
            this.o.a(this, 413);
          }
          paramString.abort();
          localDefaultHttpClient.getConnectionManager().shutdown();
        }
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        for (;;)
        {
          if (this.o != null) {
            this.o.a(this, 400);
          }
          paramString.abort();
          localDefaultHttpClient.getConnectionManager().shutdown();
        }
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          if (this.o != null) {
            this.o.a(this, 500);
          }
          paramString.abort();
          localDefaultHttpClient.getConnectionManager().shutdown();
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          label357:
          if (this.o != null) {
            this.o.a(this, 503);
          }
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
    int i3 = 0;
    localDefaultHttpClient = new DefaultHttpClient();
    if (this.e == 0) {
      paramString = new HttpPost(paramString);
    }
    for (;;)
    {
      if (this.j)
      {
        localObject = localDefaultHttpClient.getParams();
        ConnRouteParams.setDefaultProxy((HttpParams)localObject, new HttpHost(this.m, 80));
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
      paramString.setHeader("User-Agent", f());
      paramString.addHeader("s_n", f());
      int i1 = this.e;
      try
      {
        localObject = localDefaultHttpClient.execute(paramString);
        Header[] arrayOfHeader = ((HttpResponse)localObject).getHeaders("Server");
        int i2 = i3;
        int i4;
        if (arrayOfHeader != null)
        {
          i4 = arrayOfHeader.length;
          i1 = 0;
        }
        for (;;)
        {
          i2 = i3;
          if (i1 < i4)
          {
            String str = arrayOfHeader[i1].getValue();
            if ((str != null) && ("mapbarserver".equals(str.toLowerCase()))) {
              i2 = 1;
            }
          }
          else
          {
            if (i2 == 0) {
              break label339;
            }
            this.i = ((HttpResponse)localObject).getStatusLine().getStatusCode();
            if (this.o != null) {
              this.o.a(this, this.i);
            }
            if (this.i != 200) {
              break label357;
            }
            localObject = ((HttpResponse)localObject).getEntity().getContent();
            return (InputStream)localObject;
            paramString = new HttpGet(paramString);
            break;
          }
          i1 += 1;
        }
        label339:
        if (this.o != null) {
          this.o.a(this, 401);
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        for (;;)
        {
          if (this.o != null) {
            this.o.a(this, 413);
          }
          paramString.abort();
          localDefaultHttpClient.getConnectionManager().shutdown();
        }
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        for (;;)
        {
          if (this.o != null) {
            this.o.a(this, 400);
          }
          paramString.abort();
          localDefaultHttpClient.getConnectionManager().shutdown();
        }
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          if (this.o != null) {
            this.o.a(this, 500);
          }
          paramString.abort();
          localDefaultHttpClient.getConnectionManager().shutdown();
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          label357:
          if (this.o != null) {
            this.o.a(this, 503);
          }
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
  
  private String f()
  {
    i1 = 0;
    try
    {
      if (l == null) {
        break label51;
      }
      if ((l.a == null) || (l.a.trim().length() == 0)) {
        break label278;
      }
      if (!"000000000000001".equals(l.a)) {}
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        label51:
        Object localObject2;
        Object localObject1;
        continue;
        i1 = 1;
        continue;
        if (i1 == 0) {}
      }
    }
    if (i1 != 0)
    {
      g();
      break label283;
      localObject2 = "";
      localObject1 = localObject2;
      try
      {
        PackageInfo localPackageInfo = this.a.getPackageManager().getPackageInfo(this.a.getPackageName(), 0);
        localObject1 = localObject2;
        localObject2 = URLEncoder.encode(localPackageInfo.applicationInfo.loadLabel(this.a.getPackageManager()).toString(), "utf-8");
        localObject1 = localObject2;
        localObject2 = (String)localObject2 + "_" + localPackageInfo.versionName;
        localObject1 = localObject2;
      }
      catch (Exception localException2)
      {
        for (;;) {}
      }
      localObject2 = new StringBuffer();
      l = (StringBuffer)localObject2;
      ((StringBuffer)localObject2).append("Android_CellLocation_").append(g.a).append("_").append(p.b(this.a.getPackageName()) + "@" + (String)localObject1).append(";").append(l.a).append(";").append(l.b).append(";").append(Build.BRAND).append(";").append(Build.MODEL).append(";").append(Build.VERSION.SDK);
      return l.toString();
    }
  }
  
  private void g()
  {
    try
    {
      TelephonyManager localTelephonyManager = (TelephonyManager)this.a.getSystemService("phone");
      l.a = localTelephonyManager.getDeviceId();
      l.b = localTelephonyManager.getSimSerialNumber();
      return;
    }
    catch (Exception localException) {}
  }
  
  public final Object a()
  {
    Object localObject = this.c.getActiveNetworkInfo();
    if (localObject != null)
    {
      int i1 = ((NetworkInfo)localObject).getType();
      if ((i1 != 1) && (i1 == 0))
      {
        localObject = ((NetworkInfo)localObject).getExtraInfo();
        if (localObject != null)
        {
          localObject = ((String)localObject).toLowerCase();
          if (((String)localObject).indexOf("cmwap") == -1) {
            break label162;
          }
          this.j = true;
        }
      }
    }
    i.a("HttpHander", this.f);
    switch (this.d)
    {
    case 2: 
    default: 
      localObject = null;
    }
    for (;;)
    {
      i.a("HttpHander", "mStatusCode=" + this.i + "; " + this.f);
      if (this.n != null) {
        this.n.a(this, localObject);
      }
      return null;
      label162:
      if (((String)localObject).indexOf("ctwap") != -1)
      {
        this.j = true;
        this.m = "10.0.0.200";
        break;
      }
      if (((String)localObject).indexOf("3gwap") == -1) {
        break;
      }
      this.j = true;
      break;
      localObject = b(this.f);
      continue;
      localObject = d(this.f);
      continue;
      localObject = c(this.f);
    }
  }
  
  public final void a(int paramInt)
  {
    this.g = paramInt;
  }
  
  public final void a(b.e parame)
  {
    this.n = parame;
  }
  
  public final void a(b.f paramf)
  {
    this.o = paramf;
  }
  
  public final void a(String paramString)
  {
    this.f = paramString;
  }
  
  public final int e()
  {
    return this.g;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/mapbar/android/location/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */