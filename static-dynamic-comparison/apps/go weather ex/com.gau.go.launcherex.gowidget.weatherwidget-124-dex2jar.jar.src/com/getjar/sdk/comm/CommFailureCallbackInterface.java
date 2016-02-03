package com.getjar.sdk.comm;

public abstract interface CommFailureCallbackInterface
{
  public abstract void authorizationFailure(String paramString);
  
  public abstract void networkFailure();
  
  public abstract void serviceFailure(Result paramResult);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/comm/CommFailureCallbackInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */