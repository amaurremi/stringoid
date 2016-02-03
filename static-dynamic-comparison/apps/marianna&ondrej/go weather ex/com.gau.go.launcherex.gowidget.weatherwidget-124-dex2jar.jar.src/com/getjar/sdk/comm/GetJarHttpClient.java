package com.getjar.sdk.comm;

import android.content.Context;
import com.getjar.sdk.config.GetJarConfig;
import com.getjar.sdk.config.SettingsManager.Scope;
import com.getjar.sdk.exceptions.CommunicationException;
import com.getjar.sdk.logging.Area;
import com.getjar.sdk.logging.Logger;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;

public class GetJarHttpClient
  extends DefaultHttpClient
{
  private GetJarHttpClient(ClientConnectionManager paramClientConnectionManager, HttpParams paramHttpParams)
  {
    super(paramClientConnectionManager, paramHttpParams);
  }
  
  public static GetJarHttpClient newInstance(Context paramContext, String paramString, int paramInt1, int paramInt2)
  {
    try
    {
      BasicHttpParams localBasicHttpParams = new BasicHttpParams();
      HttpConnectionParams.setStaleCheckingEnabled(localBasicHttpParams, false);
      HttpConnectionParams.setConnectionTimeout(localBasicHttpParams, paramInt1);
      HttpConnectionParams.setSoTimeout(localBasicHttpParams, paramInt2);
      HttpConnectionParams.setSocketBufferSize(localBasicHttpParams, 8192);
      HttpClientParams.setRedirecting(localBasicHttpParams, false);
      HttpProtocolParams.setUserAgent(localBasicHttpParams, paramString);
      paramString = new SchemeRegistry();
      paramContext = newSSLSocketFactoryInstance(paramContext);
      paramString.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 8080));
      paramString.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
      paramString.register(new Scheme("https", paramContext, 8443));
      paramString.register(new Scheme("https", paramContext, 443));
      paramContext = new GetJarHttpClient(new ThreadSafeClientConnManager(localBasicHttpParams, paramString), localBasicHttpParams);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      Logger.e(Area.COMM.value(), paramContext, "GetJarHttpClient: newInstance() failed", new Object[0]);
      throw new CommunicationException(paramContext);
    }
  }
  
  private static SSLSocketFactory newSSLSocketFactoryInstance(Context paramContext)
  {
    Logger.d(Area.COMM.value(), "GetJarHttpClient: newSSLSocketFactoryInstance() START", new Object[0]);
    boolean bool2 = false;
    boolean bool3 = false;
    boolean bool1 = bool3;
    if (paramContext != null)
    {
      boolean bool4 = GetJarConfig.getInstance(paramContext).hasValue("service.request.allow_untrusted_ssl", SettingsManager.Scope.CLIENT);
      Logger.v(Area.COMM.value(), "GetJarHttpClient: newSSLSocketFactoryInstance() config: overrideExists:%1$s", new Object[] { Boolean.valueOf(bool4) });
      bool1 = bool3;
      bool2 = bool4;
      if (bool4)
      {
        bool1 = GetJarConfig.getInstance(paramContext).getBooleanValue("service.request.allow_untrusted_ssl", Boolean.valueOf(false), SettingsManager.Scope.CLIENT).booleanValue();
        Logger.v(Area.COMM.value(), "GetJarHttpClient: newSSLSocketFactoryInstance() config: allowUntrustedSsl:%1$s", new Object[] { Boolean.valueOf(bool1) });
        bool2 = bool4;
      }
    }
    if (!bool2) {
      bool1 = false;
    }
    Logger.v(Area.COMM.value(), "GetJarHttpClient: newSSLSocketFactoryInstance() overrideExists:%1$s allowUntrustedSsl:%2$s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
    if (bool1) {}
    for (;;)
    {
      try
      {
        paramContext = KeyStore.getInstance("BKS");
        paramContext.load(null, null);
        paramContext = new SSLSocketFactoryTrustAll(paramContext);
        throw new CommunicationException(paramContext);
      }
      catch (KeyStoreException paramContext)
      {
        try
        {
          paramContext.setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
          Logger.v(Area.COMM.value(), "GetJarHttpClient: newSSLSocketFactoryInstance() returning a new instance of %1$s", new Object[] { paramContext.getClass().getSimpleName() });
          Logger.d(Area.COMM.value(), "GetJarHttpClient: newSSLSocketFactoryInstance() DONE", new Object[0]);
          return paramContext;
        }
        catch (UnrecoverableKeyException paramContext)
        {
          for (;;) {}
        }
        catch (KeyManagementException paramContext)
        {
          continue;
        }
        catch (IOException paramContext)
        {
          continue;
        }
        catch (CertificateException paramContext)
        {
          continue;
        }
        catch (NoSuchAlgorithmException paramContext)
        {
          continue;
        }
        catch (KeyStoreException paramContext)
        {
          continue;
        }
        paramContext = paramContext;
        throw new CommunicationException(paramContext);
      }
      catch (NoSuchAlgorithmException paramContext)
      {
        throw new CommunicationException(paramContext);
      }
      catch (CertificateException paramContext)
      {
        throw new CommunicationException(paramContext);
      }
      catch (IOException paramContext)
      {
        throw new CommunicationException(paramContext);
      }
      catch (KeyManagementException paramContext)
      {
        throw new CommunicationException(paramContext);
      }
      catch (UnrecoverableKeyException paramContext) {}
      paramContext = SSLSocketFactory.getSocketFactory();
      paramContext.setHostnameVerifier(SSLSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/comm/GetJarHttpClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */