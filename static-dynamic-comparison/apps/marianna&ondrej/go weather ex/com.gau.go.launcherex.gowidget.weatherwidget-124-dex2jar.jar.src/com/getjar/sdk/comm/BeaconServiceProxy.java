package com.getjar.sdk.comm;

import com.getjar.sdk.comm.auth.AuthManager;
import com.getjar.sdk.config.GetJarConfig;
import com.getjar.sdk.config.SettingsManager.Scope;
import java.util.HashMap;
import java.util.Locale;

public class BeaconServiceProxy
  extends ServiceProxyBase
{
  private static final String _CONTRACT_VERSION = "20131120";
  private static volatile BeaconServiceProxy _Instance = null;
  private static final String _URL_TEMPLATE_PRODUCT_BEACON = String.format(Locale.US, "%1$s%2$s", new Object[] { "%1$s?version=", "20131120" });
  
  public static BeaconServiceProxy getInstance()
  {
    if (_Instance == null) {
      makeTheInstance();
    }
    return _Instance;
  }
  
  private static void makeTheInstance()
  {
    try
    {
      if (_Instance == null) {
        _Instance = new BeaconServiceProxy();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  protected Request.ServiceName getServiceName()
  {
    return Request.ServiceName.BEACON;
  }
  
  public Operation sendBeaconData(CommContext paramCommContext, HashMap<String, String> paramHashMap, boolean paramBoolean)
    throws Exception
  {
    if (paramCommContext == null) {
      throw new IllegalArgumentException("The required parameter 'commContext' was not provided");
    }
    if ((paramHashMap == null) || (paramHashMap.isEmpty())) {
      throw new IllegalArgumentException("The required parameter 'postData' was not provided");
    }
    AuthManager.initialize(paramCommContext.getApplicationContext());
    AuthManager.getInstance().waitOnAuth();
    String str = String.format(Locale.US, _URL_TEMPLATE_PRODUCT_BEACON, new Object[] { GetJarConfig.getInstance(paramCommContext, true).getDirectiveValue("service.beacon.endpoint", SettingsManager.Scope.CLIENT) });
    return makeAsyncPOSTRequestForJson("sendBeaconData", Operation.Priority.MEDIUM, paramCommContext, str, paramHashMap, null, null, paramBoolean, true, true);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/comm/BeaconServiceProxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */