package com.vladium.emma;

import com.vladium.util.exception.AbstractException;

public class EMMAException
  extends AbstractException
{
  public EMMAException() {}
  
  public EMMAException(String paramString)
  {
    super(paramString);
  }
  
  public EMMAException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
  
  public EMMAException(String paramString, Object[] paramArrayOfObject)
  {
    super(paramString, paramArrayOfObject);
  }
  
  public EMMAException(String paramString, Object[] paramArrayOfObject, Throwable paramThrowable)
  {
    super(paramString, paramArrayOfObject, paramThrowable);
  }
  
  public EMMAException(Throwable paramThrowable)
  {
    super(paramThrowable);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/emma/EMMAException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */