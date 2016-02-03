package com.getjar.sdk.exceptions;

import com.getjar.sdk.GetjarException;

public class TransactionException
  extends GetjarException
{
  private static final long serialVersionUID = 1766816765706005035L;
  
  public TransactionException() {}
  
  public TransactionException(String paramString)
  {
    super(paramString);
  }
  
  public TransactionException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
  
  public TransactionException(Throwable paramThrowable)
  {
    super(paramThrowable);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/exceptions/TransactionException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */