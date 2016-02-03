package com.getjar.sdk.comm;

public class ExternalRequestProxy
  extends ServiceProxyBase
{
  public static String REQUEST_TYPE = "EXTERNAL";
  private static volatile ExternalRequestProxy _Instance = null;
  private static final Object _InstanceLock = new Object();
  
  public static ExternalRequestProxy getInstance()
  {
    if (_Instance == null) {}
    synchronized (_InstanceLock)
    {
      if (_Instance == null) {
        _Instance = new ExternalRequestProxy();
      }
      return _Instance;
    }
  }
  
  protected Request.ServiceName getServiceName()
  {
    return Request.ServiceName.EXTERNAL;
  }
  
  public Operation makeRequest(CommContext paramCommContext, String paramString, Operation.Priority paramPriority)
  {
    return makeAsyncGETRequestForJson(REQUEST_TYPE, paramPriority, paramCommContext, paramString, null, null, true, true, true);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/comm/ExternalRequestProxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */