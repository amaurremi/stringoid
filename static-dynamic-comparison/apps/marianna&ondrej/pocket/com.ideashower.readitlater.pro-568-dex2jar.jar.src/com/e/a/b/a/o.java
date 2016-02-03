package com.e.a.b.a;

import com.e.a.m;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.SecureCacheResponse;
import java.net.URL;
import java.security.Permission;
import java.security.Principal;
import java.security.cert.Certificate;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public final class o
  extends HttpsURLConnection
{
  private final p a;
  
  public o(URL paramURL, m paramm)
  {
    super(paramURL);
    this.a = new p(this, paramURL, paramm, null);
  }
  
  private SSLSocket b()
  {
    if ((this.a.c == null) || (this.a.c.f == -1L)) {
      throw new IllegalStateException("Connection has not yet been established");
    }
    if ((this.a.c instanceof n)) {
      return ((n)this.a.c).t();
    }
    return null;
  }
  
  public f a()
  {
    return this.a.b();
  }
  
  public void addRequestProperty(String paramString1, String paramString2)
  {
    this.a.addRequestProperty(paramString1, paramString2);
  }
  
  public void connect()
  {
    this.connected = true;
    this.a.connect();
  }
  
  public void disconnect()
  {
    this.a.disconnect();
  }
  
  public boolean getAllowUserInteraction()
  {
    return this.a.getAllowUserInteraction();
  }
  
  public String getCipherSuite()
  {
    Object localObject = this.a.e();
    if (localObject != null) {
      return ((SecureCacheResponse)localObject).getCipherSuite();
    }
    localObject = b();
    if (localObject != null) {
      return ((SSLSocket)localObject).getSession().getCipherSuite();
    }
    return null;
  }
  
  public int getConnectTimeout()
  {
    return this.a.getConnectTimeout();
  }
  
  public Object getContent()
  {
    return this.a.getContent();
  }
  
  public Object getContent(Class[] paramArrayOfClass)
  {
    return this.a.getContent(paramArrayOfClass);
  }
  
  public String getContentEncoding()
  {
    return this.a.getContentEncoding();
  }
  
  public int getContentLength()
  {
    return this.a.getContentLength();
  }
  
  public String getContentType()
  {
    return this.a.getContentType();
  }
  
  public long getDate()
  {
    return this.a.getDate();
  }
  
  public boolean getDefaultUseCaches()
  {
    return this.a.getDefaultUseCaches();
  }
  
  public boolean getDoInput()
  {
    return this.a.getDoInput();
  }
  
  public boolean getDoOutput()
  {
    return this.a.getDoOutput();
  }
  
  public InputStream getErrorStream()
  {
    return this.a.getErrorStream();
  }
  
  public long getExpiration()
  {
    return this.a.getExpiration();
  }
  
  public String getHeaderField(int paramInt)
  {
    return this.a.getHeaderField(paramInt);
  }
  
  public String getHeaderField(String paramString)
  {
    return this.a.getHeaderField(paramString);
  }
  
  public long getHeaderFieldDate(String paramString, long paramLong)
  {
    return this.a.getHeaderFieldDate(paramString, paramLong);
  }
  
  public int getHeaderFieldInt(String paramString, int paramInt)
  {
    return this.a.getHeaderFieldInt(paramString, paramInt);
  }
  
  public String getHeaderFieldKey(int paramInt)
  {
    return this.a.getHeaderFieldKey(paramInt);
  }
  
  public Map getHeaderFields()
  {
    return this.a.getHeaderFields();
  }
  
  public HostnameVerifier getHostnameVerifier()
  {
    return this.a.a.h();
  }
  
  public long getIfModifiedSince()
  {
    return this.a.getIfModifiedSince();
  }
  
  public InputStream getInputStream()
  {
    return this.a.getInputStream();
  }
  
  public boolean getInstanceFollowRedirects()
  {
    return this.a.getInstanceFollowRedirects();
  }
  
  public long getLastModified()
  {
    return this.a.getLastModified();
  }
  
  public Certificate[] getLocalCertificates()
  {
    Certificate[] arrayOfCertificate = null;
    Object localObject = this.a.e();
    if (localObject != null)
    {
      localObject = ((SecureCacheResponse)localObject).getLocalCertificateChain();
      if (localObject != null) {
        arrayOfCertificate = (Certificate[])((List)localObject).toArray(new Certificate[((List)localObject).size()]);
      }
    }
    do
    {
      return arrayOfCertificate;
      localObject = b();
    } while (localObject == null);
    return ((SSLSocket)localObject).getSession().getLocalCertificates();
  }
  
  public Principal getLocalPrincipal()
  {
    Object localObject = this.a.e();
    if (localObject != null) {
      return ((SecureCacheResponse)localObject).getLocalPrincipal();
    }
    localObject = b();
    if (localObject != null) {
      return ((SSLSocket)localObject).getSession().getLocalPrincipal();
    }
    return null;
  }
  
  public OutputStream getOutputStream()
  {
    return this.a.getOutputStream();
  }
  
  public Principal getPeerPrincipal()
  {
    Object localObject = this.a.e();
    if (localObject != null) {
      return ((SecureCacheResponse)localObject).getPeerPrincipal();
    }
    localObject = b();
    if (localObject != null) {
      return ((SSLSocket)localObject).getSession().getPeerPrincipal();
    }
    return null;
  }
  
  public Permission getPermission()
  {
    return this.a.getPermission();
  }
  
  public int getReadTimeout()
  {
    return this.a.getReadTimeout();
  }
  
  public String getRequestMethod()
  {
    return this.a.getRequestMethod();
  }
  
  public Map getRequestProperties()
  {
    return this.a.getRequestProperties();
  }
  
  public String getRequestProperty(String paramString)
  {
    return this.a.getRequestProperty(paramString);
  }
  
  public int getResponseCode()
  {
    return this.a.getResponseCode();
  }
  
  public String getResponseMessage()
  {
    return this.a.getResponseMessage();
  }
  
  public SSLSocketFactory getSSLSocketFactory()
  {
    return this.a.a.g();
  }
  
  public Certificate[] getServerCertificates()
  {
    Certificate[] arrayOfCertificate = null;
    Object localObject = this.a.e();
    if (localObject != null)
    {
      localObject = ((SecureCacheResponse)localObject).getServerCertificateChain();
      if (localObject != null) {
        arrayOfCertificate = (Certificate[])((List)localObject).toArray(new Certificate[((List)localObject).size()]);
      }
    }
    do
    {
      return arrayOfCertificate;
      localObject = b();
    } while (localObject == null);
    return ((SSLSocket)localObject).getSession().getPeerCertificates();
  }
  
  public URL getURL()
  {
    return this.a.getURL();
  }
  
  public boolean getUseCaches()
  {
    return this.a.getUseCaches();
  }
  
  public void setAllowUserInteraction(boolean paramBoolean)
  {
    this.a.setAllowUserInteraction(paramBoolean);
  }
  
  public void setChunkedStreamingMode(int paramInt)
  {
    this.a.setChunkedStreamingMode(paramInt);
  }
  
  public void setConnectTimeout(int paramInt)
  {
    this.a.setConnectTimeout(paramInt);
  }
  
  public void setDefaultUseCaches(boolean paramBoolean)
  {
    this.a.setDefaultUseCaches(paramBoolean);
  }
  
  public void setDoInput(boolean paramBoolean)
  {
    this.a.setDoInput(paramBoolean);
  }
  
  public void setDoOutput(boolean paramBoolean)
  {
    this.a.setDoOutput(paramBoolean);
  }
  
  public void setFixedLengthStreamingMode(int paramInt)
  {
    this.a.setFixedLengthStreamingMode(paramInt);
  }
  
  public void setHostnameVerifier(HostnameVerifier paramHostnameVerifier)
  {
    this.a.a.a(paramHostnameVerifier);
  }
  
  public void setIfModifiedSince(long paramLong)
  {
    this.a.setIfModifiedSince(paramLong);
  }
  
  public void setInstanceFollowRedirects(boolean paramBoolean)
  {
    this.a.setInstanceFollowRedirects(paramBoolean);
  }
  
  public void setReadTimeout(int paramInt)
  {
    this.a.setReadTimeout(paramInt);
  }
  
  public void setRequestMethod(String paramString)
  {
    this.a.setRequestMethod(paramString);
  }
  
  public void setRequestProperty(String paramString1, String paramString2)
  {
    this.a.setRequestProperty(paramString1, paramString2);
  }
  
  public void setSSLSocketFactory(SSLSocketFactory paramSSLSocketFactory)
  {
    this.a.a.a(paramSSLSocketFactory);
  }
  
  public void setUseCaches(boolean paramBoolean)
  {
    this.a.setUseCaches(paramBoolean);
  }
  
  public String toString()
  {
    return this.a.toString();
  }
  
  public boolean usingProxy()
  {
    return this.a.usingProxy();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/e/a/b/a/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */