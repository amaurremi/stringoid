package com.getjar.sdk.exceptions;

import com.getjar.sdk.GetjarException;

public class UnauthorizedException
  extends GetjarException
{
  private static final long serialVersionUID = -5296673299391290459L;
  
  public UnauthorizedException() {}
  
  public UnauthorizedException(String paramString)
  {
    super(paramString);
  }
  
  public UnauthorizedException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
  
  public UnauthorizedException(Throwable paramThrowable)
  {
    super(paramThrowable);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/exceptions/UnauthorizedException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */