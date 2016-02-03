package com.parse.signpost.exception;

public abstract class OAuthException
  extends Exception
{
  public OAuthException(String paramString)
  {
    super(paramString);
  }
  
  public OAuthException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
  
  public OAuthException(Throwable paramThrowable)
  {
    super(paramThrowable);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/parse/signpost/exception/OAuthException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */