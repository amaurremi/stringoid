package com.getjar.sdk.exceptions;

import com.getjar.sdk.GetjarException;
import com.getjar.sdk.comm.Result;

public class ServiceException
  extends GetjarException
{
  private Result _requestResult = null;
  
  public ServiceException(String paramString, Result paramResult)
  {
    super(paramString);
    this._requestResult = paramResult;
  }
  
  public Result getRequestResult()
  {
    return this._requestResult;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/exceptions/ServiceException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */