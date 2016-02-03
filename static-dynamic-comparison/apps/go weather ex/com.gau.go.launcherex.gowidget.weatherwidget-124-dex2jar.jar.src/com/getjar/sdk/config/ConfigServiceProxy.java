package com.getjar.sdk.config;

import com.getjar.sdk.comm.CommContext;
import com.getjar.sdk.comm.Operation;
import com.getjar.sdk.comm.Operation.Priority;
import com.getjar.sdk.comm.Request.ServiceName;
import com.getjar.sdk.comm.ServiceProxyBase;
import com.getjar.sdk.comm.auth.AuthManager;
import com.getjar.sdk.exceptions.CommunicationException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Locale;

public class ConfigServiceProxy
  extends ServiceProxyBase
{
  private static final String _CONTRACT_VERSION = "20140428";
  private static volatile ConfigServiceProxy _Instance = null;
  private static final String _URL_TEMPLATE_CONFIG = String.format(Locale.US, "%1$s%2$s", new Object[] { "%1$ssettings/app/settings/%2$s?version=", "20140428" });
  
  public static ConfigServiceProxy getInstance()
  {
    try
    {
      if (_Instance == null) {
        makeTheInstance();
      }
      ConfigServiceProxy localConfigServiceProxy = _Instance;
      return localConfigServiceProxy;
    }
    finally {}
  }
  
  private static void makeTheInstance()
  {
    if (_Instance == null) {
      _Instance = new ConfigServiceProxy();
    }
  }
  
  public Operation getConfig(CommContext paramCommContext, SettingsManager.Scope paramScope)
  {
    if (paramCommContext == null) {
      throw new IllegalArgumentException("The required parameter 'commContext' was not provided");
    }
    if (paramScope == null) {
      throw new IllegalArgumentException("'scope' cannot be null");
    }
    AuthManager.initialize(paramCommContext.getApplicationContext());
    AuthManager.getInstance().waitOnAuth();
    try
    {
      paramScope = String.format(Locale.US, _URL_TEMPLATE_CONFIG, new Object[] { GetJarConfig.getInstance(paramCommContext, true).getDirectiveValue("service.config.endpoint", SettingsManager.Scope.CLIENT), URLEncoder.encode(paramScope.name(), "UTF-8") });
      return makeAsyncGETRequestForJson("getConfig", Operation.Priority.LOW, paramCommContext, paramScope, null, null, true, true, true);
    }
    catch (UnsupportedEncodingException paramCommContext)
    {
      throw new CommunicationException(paramCommContext);
    }
  }
  
  protected Request.ServiceName getServiceName()
  {
    return Request.ServiceName.CONFIG;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/config/ConfigServiceProxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */