package com.getjar.sdk.exceptions;

public class AuthException
  extends CommunicationException
{
  private static final long serialVersionUID = 5769887837521180082L;
  
  public AuthException() {}
  
  public AuthException(String paramString)
  {
    super(paramString);
  }
  
  public AuthException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
  
  public AuthException(Throwable paramThrowable)
  {
    super(paramThrowable);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/exceptions/AuthException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */