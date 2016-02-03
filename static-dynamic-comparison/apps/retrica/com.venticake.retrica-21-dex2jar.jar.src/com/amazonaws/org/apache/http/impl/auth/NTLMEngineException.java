package com.amazonaws.org.apache.http.impl.auth;

import com.amazonaws.org.apache.http.auth.AuthenticationException;
import org.apache.http.annotation.Immutable;

@Immutable
public class NTLMEngineException
  extends AuthenticationException
{
  public NTLMEngineException() {}
  
  public NTLMEngineException(String paramString)
  {
    super(paramString);
  }
  
  public NTLMEngineException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/impl/auth/NTLMEngineException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */