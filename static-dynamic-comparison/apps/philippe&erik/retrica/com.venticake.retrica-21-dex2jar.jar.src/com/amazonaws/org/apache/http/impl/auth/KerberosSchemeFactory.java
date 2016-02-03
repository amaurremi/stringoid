package com.amazonaws.org.apache.http.impl.auth;

import com.amazonaws.org.apache.http.auth.AuthScheme;
import com.amazonaws.org.apache.http.auth.AuthSchemeFactory;
import com.amazonaws.org.apache.http.params.HttpParams;
import org.apache.http.annotation.Immutable;

@Immutable
public class KerberosSchemeFactory
  implements AuthSchemeFactory
{
  private final boolean stripPort;
  
  public KerberosSchemeFactory()
  {
    this(false);
  }
  
  public KerberosSchemeFactory(boolean paramBoolean)
  {
    this.stripPort = paramBoolean;
  }
  
  public AuthScheme newInstance(HttpParams paramHttpParams)
  {
    return new KerberosScheme(this.stripPort);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/impl/auth/KerberosSchemeFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */