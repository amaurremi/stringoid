package com.amazonaws.org.apache.http.auth;

import com.amazonaws.org.apache.http.ProtocolException;
import org.apache.http.annotation.Immutable;

@Immutable
public class AuthenticationException
  extends ProtocolException
{
  public AuthenticationException() {}
  
  public AuthenticationException(String paramString)
  {
    super(paramString);
  }
  
  public AuthenticationException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/auth/AuthenticationException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */