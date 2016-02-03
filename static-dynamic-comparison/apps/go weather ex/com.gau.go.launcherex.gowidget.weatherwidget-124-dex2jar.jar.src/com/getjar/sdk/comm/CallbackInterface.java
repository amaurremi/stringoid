package com.getjar.sdk.comm;

public abstract interface CallbackInterface
{
  public abstract void serviceRequestFailed(Result paramResult, Exception paramException, String paramString, CommContext paramCommContext);
  
  public abstract void serviceRequestRetry(Exception paramException, String paramString, CommContext paramCommContext, int paramInt);
  
  public abstract void serviceRequestSucceeded(Result paramResult, String paramString, CommContext paramCommContext);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/comm/CallbackInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */