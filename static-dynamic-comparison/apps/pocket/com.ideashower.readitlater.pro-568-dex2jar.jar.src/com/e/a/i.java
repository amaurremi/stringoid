package com.e.a;

import com.e.a.b.a.s;
import java.io.InputStream;
import java.net.SecureCacheResponse;
import java.security.Principal;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import javax.net.ssl.SSLPeerUnverifiedException;

class i
  extends SecureCacheResponse
{
  private final g a;
  private final com.e.a.b.g b;
  private final InputStream c;
  
  public i(g paramg, com.e.a.b.g paramg1)
  {
    this.a = paramg;
    this.b = paramg1;
    this.c = e.a(paramg1);
  }
  
  public InputStream getBody()
  {
    return this.c;
  }
  
  public String getCipherSuite()
  {
    return g.c(this.a);
  }
  
  public Map getHeaders()
  {
    return g.b(this.a).a(true);
  }
  
  public List getLocalCertificateChain()
  {
    if ((g.e(this.a) == null) || (g.e(this.a).length == 0)) {
      return null;
    }
    return Arrays.asList((Object[])g.e(this.a).clone());
  }
  
  public Principal getLocalPrincipal()
  {
    if ((g.e(this.a) == null) || (g.e(this.a).length == 0)) {
      return null;
    }
    return ((X509Certificate)g.e(this.a)[0]).getSubjectX500Principal();
  }
  
  public Principal getPeerPrincipal()
  {
    if ((g.d(this.a) == null) || (g.d(this.a).length == 0)) {
      throw new SSLPeerUnverifiedException(null);
    }
    return ((X509Certificate)g.d(this.a)[0]).getSubjectX500Principal();
  }
  
  public List getServerCertificateChain()
  {
    if ((g.d(this.a) == null) || (g.d(this.a).length == 0)) {
      throw new SSLPeerUnverifiedException(null);
    }
    return Arrays.asList((Object[])g.d(this.a).clone());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/e/a/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */