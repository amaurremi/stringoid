package com.amazonaws.org.apache.http.impl.auth;

import com.amazonaws.org.apache.http.auth.AuthScheme;
import com.amazonaws.org.apache.http.auth.AuthSchemeFactory;
import com.amazonaws.org.apache.http.params.HttpParams;
import org.apache.http.annotation.Immutable;

@Immutable
public class NTLMSchemeFactory
  implements AuthSchemeFactory
{
  public AuthScheme newInstance(HttpParams paramHttpParams)
  {
    return new NTLMScheme(new NTLMEngineImpl());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/impl/auth/NTLMSchemeFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */