package com.getjar.sdk.exceptions;

import com.getjar.sdk.GetjarException;

public class CommunicationException
  extends GetjarException
{
  private static final long serialVersionUID = 7148297634011153457L;
  
  public CommunicationException() {}
  
  public CommunicationException(String paramString)
  {
    super(paramString);
  }
  
  public CommunicationException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
  
  public CommunicationException(Throwable paramThrowable)
  {
    super(paramThrowable);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/exceptions/CommunicationException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */