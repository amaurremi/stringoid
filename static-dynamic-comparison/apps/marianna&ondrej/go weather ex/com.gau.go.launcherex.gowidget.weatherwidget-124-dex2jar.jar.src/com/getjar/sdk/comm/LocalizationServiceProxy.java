package com.getjar.sdk.comm;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import com.getjar.sdk.comm.auth.AuthManager;
import com.getjar.sdk.config.GetJarConfig;
import com.getjar.sdk.config.SettingsManager.Scope;
import com.getjar.sdk.exceptions.ConfigurationException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Locale;

public class LocalizationServiceProxy
  extends ServiceProxyBase
{
  private static final String _CONTRACT_VERSION = "20121130";
  private static volatile LocalizationServiceProxy _Instance = null;
  private static final String _URL_TEMPLATE_GOLD_BUCKETS = String.format(Locale.US, "%1$s%2$s", new Object[] { "%1$slocalization/platforms/android/gold_offers/?country_code=%2$s&version=", "20121130" });
  
  public static LocalizationServiceProxy getInstance()
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
        _Instance = new LocalizationServiceProxy();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public Operation getGoldOffers(CommContext paramCommContext)
  {
    if (paramCommContext == null) {
      throw new IllegalArgumentException("The required parameter 'commContext' was not provided");
    }
    AuthManager.initialize(paramCommContext.getApplicationContext());
    AuthManager.getInstance().waitOnAuth();
    String str = paramCommContext.getApplicationContext().getResources().getConfiguration().locale.getCountry();
    try
    {
      str = String.format(Locale.US, _URL_TEMPLATE_GOLD_BUCKETS, new Object[] { GetJarConfig.getInstance(paramCommContext, true).getDirectiveValue("service.localization_service.endpoint", SettingsManager.Scope.CLIENT), URLEncoder.encode(str, "UTF-8") });
      paramCommContext = makeAsyncGETRequestForJson("getGoldOffers", Operation.Priority.MEDIUM, paramCommContext, str, null, null, true, false, true);
      return paramCommContext;
    }
    catch (UnsupportedEncodingException paramCommContext)
    {
      throw new ConfigurationException(paramCommContext);
    }
  }
  
  protected Request.ServiceName getServiceName()
  {
    return Request.ServiceName.LOCALIZATION;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/comm/LocalizationServiceProxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */