package com.amazonaws.org.apache.http.auth;

import org.apache.http.annotation.Immutable;

@Immutable
public class InvalidCredentialsException
  extends AuthenticationException
{
  public InvalidCredentialsException() {}
  
  public InvalidCredentialsException(String paramString)
  {
    super(paramString);
  }
  
  public InvalidCredentialsException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/auth/InvalidCredentialsException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */