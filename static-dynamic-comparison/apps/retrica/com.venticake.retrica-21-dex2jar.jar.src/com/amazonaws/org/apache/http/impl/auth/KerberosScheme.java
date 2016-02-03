package com.amazonaws.org.apache.http.impl.auth;

import com.amazonaws.org.apache.http.Header;
import com.amazonaws.org.apache.http.HttpRequest;
import com.amazonaws.org.apache.http.auth.Credentials;
import com.amazonaws.org.apache.http.protocol.HttpContext;
import org.ietf.jgss.Oid;

public class KerberosScheme
  extends GGSSchemeBase
{
  public KerberosScheme()
  {
    super(false);
  }
  
  public KerberosScheme(boolean paramBoolean)
  {
    super(paramBoolean);
  }
  
  public Header authenticate(Credentials paramCredentials, HttpRequest paramHttpRequest, HttpContext paramHttpContext)
  {
    return super.authenticate(paramCredentials, paramHttpRequest, paramHttpContext);
  }
  
  protected byte[] generateToken(byte[] paramArrayOfByte, String paramString)
  {
    return generateGSSToken(paramArrayOfByte, new Oid("1.2.840.113554.1.2.2"), paramString);
  }
  
  public String getRealm()
  {
    return null;
  }
  
  public String getSchemeName()
  {
    return "Kerberos";
  }
  
  public boolean isConnectionBased()
  {
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/impl/auth/KerberosScheme.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */