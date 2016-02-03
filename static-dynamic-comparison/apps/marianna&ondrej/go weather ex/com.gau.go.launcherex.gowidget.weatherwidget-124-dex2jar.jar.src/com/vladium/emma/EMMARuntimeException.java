package com.vladium.emma;

import com.vladium.util.exception.AbstractRuntimeException;

public class EMMARuntimeException
  extends AbstractRuntimeException
{
  public EMMARuntimeException() {}
  
  public EMMARuntimeException(String paramString)
  {
    super(paramString);
  }
  
  public EMMARuntimeException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
  
  public EMMARuntimeException(String paramString, Object[] paramArrayOfObject)
  {
    super(paramString, paramArrayOfObject);
  }
  
  public EMMARuntimeException(String paramString, Object[] paramArrayOfObject, Throwable paramThrowable)
  {
    super(paramString, paramArrayOfObject, paramThrowable);
  }
  
  public EMMARuntimeException(Throwable paramThrowable)
  {
    super(paramThrowable);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/emma/EMMARuntimeException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */