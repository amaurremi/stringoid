package com.getjar.sdk.comm;

import com.getjar.sdk.comm.auth.AuthManager;
import com.getjar.sdk.config.GetJarConfig;
import com.getjar.sdk.config.SettingsManager.Scope;
import com.getjar.sdk.data.DeviceMetadata;
import com.getjar.sdk.data.cache.AdManager;
import com.getjar.sdk.data.install_state.InstallStateManager;
import com.getjar.sdk.data.install_state.InstallStateRecord;
import com.getjar.sdk.data.usage.UsageManager;
import com.getjar.sdk.exceptions.CommunicationException;
import com.getjar.sdk.logging.Area;
import com.getjar.sdk.logging.Logger;
import com.getjar.sdk.rewards.AdvertisingIdHelper;
import com.getjar.sdk.rewards.GetJarJavaScriptInterface;
import com.getjar.sdk.utilities.StringUtility;
import com.getjar.sdk.utilities.SystemUtility;
import com.getjar.sdk.utilities.Utility;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

public class AdsServiceProxy
  extends ServiceProxyBase
{
  private static final String _CONTRACT_VERSION = "20140904";
  private static volatile AdsServiceProxy _Instance = null;
  private static final String _URL_TEMPLATE_GET_ADS = String.format(Locale.US, "%1$s%2$s%3$s", new Object[] { "%1$sproduct/ads/interstitial_plus?version=", "20140904", "&l=%2$d&user_lookup_id=%3$s" });
  
  private void addUsageToPostData(CommContext paramCommContext, HashMap<String, String> paramHashMap)
    throws Exception
  {
    Object localObject = AdManager.getInstance().getActiveUsageAreas(paramCommContext);
    boolean bool2 = ((List)localObject).contains("INSTALLED");
    boolean bool1 = ((List)localObject).contains("RECENTLY_USED");
    boolean bool3 = ((List)localObject).contains("AGGREGATE_SESSION");
    if (!UsageManager.getInstance(paramCommContext.getApplicationContext()).isMonitoringEnabled()) {
      bool1 = false;
    }
    if (bool3)
    {
      String str = GetJarJavaScriptInterface.getUsageSessionRecords(paramCommContext.getApplicationContext());
      localObject = str;
      if (new JSONObject(str).length() <= 0) {
        localObject = "{\"records\" : []}";
      }
      paramHashMap.put("usage_session_records", localObject);
    }
    if (bool1) {
      paramHashMap.put("recently_used_apps", formatMarketplaceItemsJSON(SystemUtility.getRecentlyRunAppsFromOS(paramCommContext.getApplicationContext())));
    }
    if (bool2)
    {
      localObject = InstallStateManager.getInstance(paramCommContext.getApplicationContext()).getUnsyncedRecords(paramCommContext);
      paramHashMap.put("install_items", formatMarketplaceItemsFromInstallState((List)localObject));
      InstallStateManager.getInstance(paramCommContext.getApplicationContext()).moveRecordsToSyncedDB(paramCommContext, (List)localObject);
    }
    Logger.d(Area.COMM.value(), "AdsServiceProxy: getAds() addUsageToPostData() shouldSendInstalled:%1$s shouldSendRecentlyUsed:%2$s shouldSendAggregateUsage:%3$s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1), Boolean.valueOf(bool3) });
  }
  
  private static String formatMarketplaceItemsFromInstallState(List<InstallStateRecord> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append('[');
    if (paramList != null)
    {
      int j = paramList.size();
      if (j > 0)
      {
        int i = 0;
        while (i < j)
        {
          localStringBuilder.append("{\"marketplace\":\"marketplace.google_play\",\"marketplace_item_id\":\"");
          localStringBuilder.append(((InstallStateRecord)paramList.get(i)).getPackageName());
          localStringBuilder.append("\"},");
          i += 1;
        }
        localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
      }
    }
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
  
  private static String formatMarketplaceItemsJSON(List<String> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append('[');
    if (paramList != null)
    {
      int j = paramList.size();
      if (j > 0)
      {
        int i = 0;
        while (i < j)
        {
          localStringBuilder.append("{\"marketplace\":\"marketplace.google_play\",\"marketplace_item_id\":\"");
          localStringBuilder.append((String)paramList.get(i));
          localStringBuilder.append("\"},");
          i += 1;
        }
        localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
      }
    }
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
  
  public static AdsServiceProxy getInstance()
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
        _Instance = new AdsServiceProxy();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public Operation getAds(CommContext paramCommContext, int paramInt, String paramString, boolean paramBoolean)
    throws Exception
  {
    if (paramCommContext == null) {
      throw new IllegalArgumentException("The required parameter 'commContext' was not provided");
    }
    if (paramInt <= 0) {
      throw new IllegalArgumentException("'adCount' must be greater than zero");
    }
    if (StringUtility.isNullOrEmpty(paramString)) {
      throw new IllegalArgumentException("'currencyKey' can not be NULL or empty");
    }
    HashMap localHashMap = new HashMap(4);
    localHashMap.put("source_filter", "marketplace.google_play");
    localHashMap.put("device_filter", UserAgentValuesManager.getInstance().getWebKitUserAgent(paramCommContext.getApplicationContext()));
    localHashMap.put("currency_key", paramString);
    paramString = new HashMap(paramCommContext.getDeviceMetadata().getMetadata());
    AdvertisingIdHelper.getInstance(paramCommContext.getApplicationContext()).addDataToMap(paramString);
    if ((paramString == null) || (paramString.size() <= 0))
    {
      Logger.w(Area.COMM.value(), "AdsServiceProxy: getAds() failed to get device metadata", new Object[0]);
      localHashMap.put("device_data", "");
    }
    for (;;)
    {
      addUsageToPostData(paramCommContext, localHashMap);
      AuthManager.initialize(paramCommContext.getApplicationContext());
      AuthManager.getInstance().waitOnAuth();
      try
      {
        paramString = String.format(Locale.US, _URL_TEMPLATE_GET_ADS, new Object[] { GetJarConfig.getInstance(paramCommContext, true).getDirectiveValue("service.ads.endpoint", SettingsManager.Scope.CLIENT), Integer.valueOf(paramInt), URLEncoder.encode(AuthManager.getInstance().getUserAccessId(), "UTF-8") });
        return makeAsyncPOSTRequestForJson("getAds", Operation.Priority.MEDIUM, paramCommContext, paramString, localHashMap, null, null, paramBoolean, true, true);
      }
      catch (UnsupportedEncodingException paramCommContext)
      {
        throw new CommunicationException(paramCommContext);
      }
      localHashMap.put("device_data", Utility.mapToJsonString(paramString));
    }
  }
  
  protected Request.ServiceName getServiceName()
  {
    return Request.ServiceName.ADS;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/comm/AdsServiceProxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */