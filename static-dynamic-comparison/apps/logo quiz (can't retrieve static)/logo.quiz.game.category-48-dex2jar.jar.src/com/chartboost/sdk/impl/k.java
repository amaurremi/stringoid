package com.chartboost.sdk.impl;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Build.VERSION;
import com.chartboost.sdk.CBPreferences;
import com.chartboost.sdk.Chartboost;
import com.chartboost.sdk.Libraries.CBLogging;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.http.client.HttpClient;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.scheme.SocketFactory;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;

public final class k
{
  private static ExecutorService a = null;
  private static ThreadFactory b = null;
  private static HttpClient c = null;
  
  public static ExecutorService a()
  {
    if (b == null) {
      b = new ThreadFactory()
      {
        private final AtomicInteger a = new AtomicInteger(1);
        
        public Thread newThread(Runnable paramAnonymousRunnable)
        {
          return new Thread(paramAnonymousRunnable, "Chartboost Thread #" + this.a.getAndIncrement());
        }
      };
    }
    if (a == null) {
      a = Executors.newFixedThreadPool(5, b);
    }
    return a;
  }
  
  private static String b(Application paramApplication, String paramString)
  {
    try
    {
      String str = paramApplication.getPackageManager().getPackageInfo(paramApplication.getPackageName(), 0).versionName;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramApplication.getPackageName());
      localStringBuilder.append("/");
      localStringBuilder.append(str);
      localStringBuilder.append(" (");
      localStringBuilder.append("Linux; U; Android ");
      localStringBuilder.append(Build.VERSION.RELEASE);
      localStringBuilder.append("; ");
      localStringBuilder.append(Locale.getDefault());
      localStringBuilder.append("; ");
      localStringBuilder.append(Build.PRODUCT);
      localStringBuilder.append(")");
      if (paramString != null)
      {
        localStringBuilder.append(" ");
        localStringBuilder.append(paramString);
      }
      return localStringBuilder.toString();
    }
    catch (PackageManager.NameNotFoundException paramApplication)
    {
      throw new RuntimeException(paramApplication);
    }
  }
  
  protected static HttpClient b()
  {
    if (c != null) {
      return c;
    }
    try
    {
      final Object localObject1 = (Application)Chartboost.sharedChartboost().getContext().getApplicationContext();
      c = new DefaultHttpClient()
      {
        protected SocketFactory a()
        {
          try
          {
            Object localObject1 = Class.forName("android.net.SSLSessionCache");
            Object localObject2 = ((Class)localObject1).getConstructor(new Class[] { Context.class }).newInstance(new Object[] { localObject1 });
            localObject1 = (SocketFactory)Class.forName("android.net.SSLCertificateSocketFactory").getMethod("getHttpSocketFactory", new Class[] { Integer.TYPE, localObject1 }).invoke(null, new Object[] { Integer.valueOf(this.a.getTimeout()), localObject2 });
            return (SocketFactory)localObject1;
          }
          catch (Exception localException)
          {
            CBLogging.b("CBAsync:HttpClientProvider", "Unable to use android.net.SSLCertificateSocketFactory to get a SSL session caching socket factory, falling back to a non-caching socket factory", localException);
          }
          return SSLSocketFactory.getSocketFactory();
        }
        
        protected ClientConnectionManager createClientConnectionManager()
        {
          SchemeRegistry localSchemeRegistry = new SchemeRegistry();
          localSchemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
          localSchemeRegistry.register(new Scheme("https", a(), 443));
          HttpParams localHttpParams = getParams();
          HttpConnectionParams.setConnectionTimeout(localHttpParams, this.a.getTimeout());
          HttpConnectionParams.setSoTimeout(localHttpParams, this.a.getTimeout());
          HttpProtocolParams.setUserAgent(localHttpParams, k.a(localObject1, HttpProtocolParams.getUserAgent(localHttpParams)));
          return new ThreadSafeClientConnManager(localHttpParams, localSchemeRegistry);
        }
      };
      localObject1 = c;
      return (HttpClient)localObject1;
    }
    catch (Exception localException1)
    {
      CBLogging.b("CBAsync", "Exception raised getting a Chartboost HTTPClient on which to run any network request", localException1);
      try
      {
        Object localObject3 = new DefaultHttpClient();
        Object localObject2 = ((HttpClient)localObject3).getConnectionManager();
        localObject3 = ((HttpClient)localObject3).getParams();
        c = new DefaultHttpClient(new ThreadSafeClientConnManager((HttpParams)localObject3, ((ClientConnectionManager)localObject2).getSchemeRegistry()), (HttpParams)localObject3);
        localObject2 = c;
        return (HttpClient)localObject2;
      }
      catch (Exception localException2)
      {
        CBLogging.b("CBAsync", "Exception raised creating a simple HTTP client", localException1);
        c = new DefaultHttpClient();
      }
    }
    return c;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/chartboost/sdk/impl/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */