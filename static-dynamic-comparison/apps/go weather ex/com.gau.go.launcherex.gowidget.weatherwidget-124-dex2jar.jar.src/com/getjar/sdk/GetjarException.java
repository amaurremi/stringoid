package com.getjar.sdk;

public class GetjarException
  extends RuntimeException
{
  private static final long serialVersionUID = -127143903208982659L;
  
  public GetjarException() {}
  
  public GetjarException(String paramString)
  {
    super(paramString);
  }
  
  public GetjarException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
  
  public GetjarException(Throwable paramThrowable)
  {
    super(paramThrowable);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/GetjarException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */