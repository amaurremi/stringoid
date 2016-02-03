package com.getjar.sdk.exceptions;

import com.getjar.sdk.GetjarException;

public class ConfigurationException
  extends GetjarException
{
  private static final long serialVersionUID = 5108870908395296453L;
  
  public ConfigurationException() {}
  
  public ConfigurationException(String paramString)
  {
    super(paramString);
  }
  
  public ConfigurationException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
  
  public ConfigurationException(Throwable paramThrowable)
  {
    super(paramThrowable);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/exceptions/ConfigurationException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */