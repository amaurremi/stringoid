package com.getjar.sdk.config;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.AssetManager;
import com.getjar.sdk.comm.CommContext;
import com.getjar.sdk.comm.auth.AuthManager;
import com.getjar.sdk.comm.auth.AuthManager.AuthListener;
import com.getjar.sdk.exceptions.ConfigurationException;
import com.getjar.sdk.logging.Area;
import com.getjar.sdk.logging.Logger;
import com.getjar.sdk.utilities.OverridesUtility;
import com.getjar.sdk.utilities.StringUtility;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONException;
import org.json.JSONObject;

public class GetJarConfig
{
  private static final String CONFIG_PREFS = "GetJarConfig";
  private static final String CONFIG_PREFS_KEY = "config";
  private static final String DEFAULT_CONFIG_FILE = "config.ini";
  private static final String DEFAULT_LOOKUP_KEY = "default";
  public static final String KEY_ADS_ASSET_ICON_CACHE_LRU_CAP = "ads.asset.icon.cache.lru_cap";
  public static final String KEY_ADS_ASSET_ICON_CACHE_TTL = "ads.asset.icon.cache.ttl";
  public static final String KEY_ADS_ASSET_ICON_SIZE = "ads.asset.icon.size";
  public static final String KEY_ADS_ASSET_INTERSTITIAL_CACHE_LRU_CAP = "ads.asset.interstitial.cache.lru_cap";
  public static final String KEY_ADS_ASSET_INTERSTITIAL_CACHE_TTL = "ads.asset.interstitial.cache.ttl";
  public static final String KEY_ADS_CACHE_AD_COUNT = "ads.cache.ad_count";
  public static final String KEY_ADS_CACHE_FILTERING_MAX_REQUEST_COUNT = "ads.cache.filtering.max_request_count";
  public static final String KEY_ADS_CACHE_FILTERING_STEP_UP_DELTA = "ads.cache.filtering.step_up_delta";
  public static final String KEY_ADS_CACHE_PREPARE_ON_GET = "ads.cache.prepare_on_get";
  public static final String KEY_ADS_GOOGLE_PLAY_LIMIT_TRACKING_ENABLED = "ads.android.limit_tracking_enabled";
  public static final String KEY_ADS_SERVICE_ENDPOINT = "service.ads.endpoint";
  public static final String KEY_AUTH_SERVICE_ENDPOINT = "service.auth_service.endpoint";
  public static final String KEY_BEACON_CACHE_LRU_CAP = "beacon.cache.lru_cap";
  public static final String KEY_BEACON_CACHE_TTL = "beacon.cache.ttl";
  public static final String KEY_BEACON_SERVICE_ENDPOINT = "service.beacon.endpoint";
  public static final String KEY_CONFIG_SERVICE_ENDPOINT = "service.config.endpoint";
  public static final String KEY_DOWNLOAD_MATCH_TTL = "download.match.ttl";
  public static final String KEY_EARN_INCENTIVIZED_MONITORING_IN_FOCUS_TIME = "earn.incentivized.monitoring.in_focus_time";
  public static final String KEY_EARN_NON_INCENTIVIZED_MONITORING_IN_FOCUS_TIME = "earn.non_incentivized.monitoring.in_focus_time";
  public static final String KEY_EARN_ON_OPEN_MONITORING_INTERVAL = "earn.on.open.monitoring.interval";
  public static final String KEY_EARN_URL = "webview.earn_url";
  public static final String KEY_EXTERNAL_APSALAR_API_KEY = "external.apsalar.api_key";
  public static final String KEY_EXTERNAL_APSALAR_SECRET = "external.apsalar.secret";
  public static final String KEY_EXTERNAL_URBANAIRSHIP_APP_KEY = "external.urbanairship.app_key";
  public static final String KEY_EXTERNAL_URBANAIRSHIP_APP_SECRET = "external.urbanairship.app_secret";
  public static final String KEY_EXTERNAL_URBANAIRSHIP_GCM_SENDER = "external.urbanairship.gcm_sender";
  public static final String KEY_EXTERNAL_URBANAIRSHIP_IN_PRODUCTION = "external.urbanairship.in_production";
  public static final String KEY_IMAGE_SERVICE_ENDPOINT = "service.image.endpoint";
  public static final String KEY_INTERSTITIAL_SCOPE_ADS_DISPLAY_TIMEOUT_MILLISECONDS = "interstitial_scope.ads.display_timeout_milliseconds";
  public static final String KEY_INTERSTITIAL_SCOPE_TEMPLATE_ENDPOINT = "interstitial_scope.template.endpoint";
  public static final String KEY_INTERSTITIAL_SCOPE_TEMPLATE_ID = "interstitial_scope.template.id";
  public static final String KEY_INTERSTITIAL_SCOPE_TEMPLATE_VERSION = "interstitial_scope.template.version";
  public static final String KEY_INTERSTITIAL_SCOPE_USAGE_REQUEST_SEND_AREAS = "interstitial_scope.usage.request.send.areas";
  public static final String KEY_INTERSTITIAL_SCOPE_USAGE_REQUEST_SEND_MAX_INSTALLED_COUNT = "interstitial_scope.usage.request.send.max_installed_count";
  public static final String KEY_LICENSE_IGNORE_REQUEST_INTERVAL = "license.ignore.request.interval";
  public static final String KEY_LICENSE_REFRESH_INTERVAL = "license.refresh.interval";
  public static final String KEY_LICENSE_SERVICE_ENDPOINT = "service.license_service.endpoint";
  public static final String KEY_LOCALIZATION_SERVICE_ENDPOINT = "service.localization_service.endpoint";
  public static final String KEY_LOGGING_ENDPOINT = "service.logging.endpoint";
  public static final String KEY_LOGGING_LOGCAT_AREAS = "logging.logcat.areas";
  public static final String KEY_LOGGING_LOGCAT_ENABLED = "logging.logcat.enabled";
  public static final String KEY_LOGGING_LOGCAT_LEVEL = "logging.logcat.level";
  public static final String KEY_LOGGING_REMOTE_AREAS = "logging.remote.areas";
  public static final String KEY_LOGGING_REMOTE_ENABLED = "logging.remote.enabled";
  public static final String KEY_LOGGING_REMOTE_LEVEL = "logging.remote.level";
  public static final String KEY_LOGGING_REMOTE_MAX_BATCH_COUNT = "logging.remote.max_batch_count";
  public static final String KEY_LOGGING_REMOTE_MAX_WAIT_INTERVAL = "logging.remote.max_wait_interval";
  public static final String KEY_MANAGED_PURCHASE_URL = "webview.managed_purchase_url";
  public static final String KEY_PURCHASE_URL = "webview.purchase_url";
  public static final String KEY_REPORT_USAGE_ENDPOINT = "service.report_usage.endpoint";
  public static final String KEY_SERVICE_REQUEST_COMPRESS = "service.request.compress";
  public static final String KEY_SERVICE_REQUEST_UNCOMPRESSED_LIMIT = "service.request.uncompressed_limit";
  public static final String KEY_SETTINGS_IGNORE_REQUEST_INTERVAL = "settings.ignore.request.interval";
  public static final String KEY_SHOP_URL = "webview.shop_url";
  public static final String KEY_TRANSACTION_FAIL_ABANDON_TIME = "transaction.fail.abandon.time";
  public static final String KEY_TRANSACTION_FAIL_RETRY_INTERVAL = "transaction.fail.retry.time";
  public static final String KEY_TRANSACTION_SERVICE_ENDPOINT = "service.transaction_service.endpoint";
  public static final String KEY_USAGE_ANALYTICS_TRACKING_ENABLED = "usage.analytics.tracking.enabled";
  public static final String KEY_USAGE_ANALYTICS_TRACKING_INTERFACE = "usage.analytics.tracking.interface";
  public static final String KEY_USAGE_BACKGROUND_SEND_BATCH_COUNT = "usage.background.send.batch_count";
  public static final String KEY_USAGE_BACKGROUND_SEND_INTERVAL = "usage.background.send.interval";
  public static final String KEY_USAGE_BACKGROUND_TYPE_FILTER = "usage.background.type_filter";
  public static final String KEY_USAGE_INSTALL_BACKGROUND_SEND_ENABLED = "usage.install.background.send.enabled";
  public static final String KEY_USAGE_MONITORING_ALARM_INTERVAL = "usage.monitoring.alarm_interval";
  public static final String KEY_USAGE_MONITORING_ENABLED = "usage.monitoring.enabled";
  public static final String KEY_USAGE_MONITORING_INTERVAL = "usage.monitoring.interval";
  public static final String KEY_USAGE_MONITORING_TRACKING_INTERVAL = "usage.monitoring.tracking_interval";
  public static final String KEY_USAGE_PACKAGE_FILTER_REGEX = "usage.package_filter.regex";
  public static final String KEY_USAGE_PACKAGE_FILTER_SYSTEM = "usage.package_filter.system";
  public static final String KEY_USAGE_REQUEST_SEND_ENABLED = "usage.request.send.enabled";
  public static final String KEY_USAGE_REQUEST_SEND_MAX_COUNT = "usage.request.send.max_count";
  public static final String KEY_USAGE_REQUEST_SEND_SORT = "usage.request.send.sort";
  public static final String KEY_USAGE_REQUEST_TIME_WINDOW = "usage.request.time_window";
  public static final String KEY_USAGE_REQUEST_TIME_WINDOW_COUNT = "usage.request.time_window_count";
  public static final String KEY_USAGE_SESSION_BACKGROUND_SEND_ENABLED = "usage.session.background.send.enabled";
  public static final String KEY_VOUCHER_SERVICE_ENDPOINT = "service.voucher_service.endpoint";
  public static final String KEY_VOUCHER_UNREDEEMED_REQUEST_INTERVAL = "voucher.unredeemed_request_interval";
  public static final String KEY_WALLET_URL = "webview.wallet_url";
  public static final String KEY_WEBVIEW_SAVED_URL_TTL = "webview.saved_url.ttl";
  public static final String KEY_WEBVIEW_SLEEP_RELOAD_INTERVAL = "webview.sleep_reload.interval";
  private static Map<String, GetJarConfig> sInstances = new HashMap();
  private static final String[] sRequiredKeys = { "service.voucher_service.endpoint", "service.transaction_service.endpoint", "service.auth_service.endpoint", "service.license_service.endpoint", "service.ads.endpoint", "service.image.endpoint", "service.beacon.endpoint", "service.config.endpoint", "webview.shop_url", "webview.earn_url", "webview.wallet_url", "webview.purchase_url", "webview.managed_purchase_url", "transaction.fail.retry.time", "license.refresh.interval", "license.ignore.request.interval", "settings.ignore.request.interval", "transaction.fail.abandon.time", "usage.background.send.interval", "webview.saved_url.ttl", "download.match.ttl", "earn.on.open.monitoring.interval", "earn.incentivized.monitoring.in_focus_time", "earn.non_incentivized.monitoring.in_focus_time", "usage.monitoring.interval", "usage.monitoring.alarm_interval", "usage.monitoring.tracking_interval", "usage.monitoring.enabled", "service.request.compress", "service.request.uncompressed_limit", "service.logging.endpoint", "usage.package_filter.system", "usage.session.background.send.enabled", "usage.install.background.send.enabled", "usage.background.send.batch_count", "usage.request.send.enabled", "usage.request.send.max_count", "usage.request.send.sort", "usage.request.time_window", "usage.request.time_window_count", "usage.analytics.tracking.enabled", "logging.logcat.enabled", "logging.logcat.level", "logging.logcat.areas", "logging.remote.enabled", "logging.remote.level", "logging.remote.areas", "logging.remote.max_batch_count", "logging.remote.max_wait_interval", "ads.cache.ad_count", "ads.cache.prepare_on_get", "ads.cache.filtering.max_request_count", "ads.cache.filtering.step_up_delta", "ads.asset.icon.size", "ads.asset.icon.cache.ttl", "ads.asset.icon.cache.lru_cap", "ads.asset.interstitial.cache.ttl", "ads.asset.interstitial.cache.lru_cap", "ads.android.limit_tracking_enabled", "interstitial_scope.ads.display_timeout_milliseconds", "interstitial_scope.template.id", "interstitial_scope.template.version", "interstitial_scope.template.endpoint", "interstitial_scope.usage.request.send.areas", "interstitial_scope.usage.request.send.max_installed_count", "beacon.cache.lru_cap", "beacon.cache.ttl", "voucher.unredeemed_request_interval" };
  private final AuthManager.AuthListener _authListener = new AuthManager.AuthListener()
  {
    private final String _id = UUID.randomUUID().toString();
    
    public int compare(AuthManager.AuthListener paramAnonymousAuthListener1, AuthManager.AuthListener paramAnonymousAuthListener2)
    {
      return paramAnonymousAuthListener1.getUniqueId().compareTo(paramAnonymousAuthListener2.getUniqueId());
    }
    
    public boolean equals(Object paramAnonymousObject)
    {
      if ((paramAnonymousObject == null) || (!(paramAnonymousObject instanceof AuthManager.AuthListener))) {
        return false;
      }
      return getUniqueId().equals(((AuthManager.AuthListener)paramAnonymousObject).getUniqueId());
    }
    
    public String getUniqueId()
    {
      return this._id;
    }
    
    public int hashCode()
    {
      return getUniqueId().hashCode();
    }
    
    public void notifyAuthCompleted(boolean paramAnonymousBoolean)
    {
      GetJarConfig.this.notifyChangeListeners(SettingsManager.Scope.CLIENT);
    }
    
    public String toString()
    {
      return getUniqueId();
    }
  };
  private final ConfigChangedListener _configChangedListener = new ConfigChangedListener()
  {
    private final String uniqueId = UUID.randomUUID().toString();
    
    public int compare(ConfigChangedListener paramAnonymousConfigChangedListener1, ConfigChangedListener paramAnonymousConfigChangedListener2)
    {
      return paramAnonymousConfigChangedListener1.getUniqueId().compareTo(paramAnonymousConfigChangedListener2.getUniqueId());
    }
    
    public String getUniqueId()
    {
      return this.uniqueId;
    }
    
    public void onConfigChanged(SettingsManager.Scope paramAnonymousScope)
    {
      GetJarConfig.this.notifyChangeListeners(paramAnonymousScope);
    }
  };
  private final ConcurrentLinkedQueue<ConfigChangedListener> _configChangedListeners = new ConcurrentLinkedQueue();
  private Context androidContext;
  private CommContext mCommContext;
  private JSONObject mDirectives;
  
  private GetJarConfig(Context paramContext)
  {
    if (paramContext == null) {
      throw new IllegalArgumentException("'androidContext' cannot be null");
    }
    initialize(paramContext);
  }
  
  private GetJarConfig(CommContext paramCommContext, boolean paramBoolean)
  {
    initialize(paramCommContext, paramBoolean);
  }
  
  private JSONObject _getDefaultDirectives()
    throws IOException
  {
    HashMap localHashMap = new HashMap();
    Object localObject2 = null;
    try
    {
      localObject1 = new BufferedReader(new InputStreamReader(this.androidContext.getAssets().open("config.ini")));
      try
      {
        for (;;)
        {
          localObject2 = ((BufferedReader)localObject1).readLine();
          if (localObject2 == null) {
            break;
          }
          localObject2 = ((String)localObject2).split("=", 2);
          if (localObject2.length == 2) {
            localHashMap.put(localObject2[0], localObject2[1]);
          }
        }
        if (localObject1 == null) {
          break label86;
        }
      }
      finally {}
    }
    finally
    {
      for (;;)
      {
        Object localObject1 = localObject3;
        Object localObject4 = localObject5;
      }
    }
    ((BufferedReader)localObject1).close();
    label86:
    throw ((Throwable)localObject3);
    if (localObject1 != null) {
      ((BufferedReader)localObject1).close();
    }
    return new JSONObject(localHashMap);
  }
  
  private void _persistIntoSharedPrefs(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      try
      {
        throw new IllegalArgumentException("Must have a valid json object.");
      }
      finally {}
    }
    this.mCommContext.getApplicationContext().getSharedPreferences("GetJarConfig", 0).edit().putString("config", paramJSONObject.toString());
    Logger.d(Area.CONFIG.value() | Area.STORAGE.value(), "_persistIntoSharedPrefs() -- OK: stored key=config, val=" + paramJSONObject.toString(), new Object[0]);
  }
  
  private boolean _validateJsonDirectives(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      throw new IllegalArgumentException("Must have a valid json object.");
    }
    try
    {
      String[] arrayOfString = sRequiredKeys;
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str = arrayOfString[i];
        if (paramJSONObject.has(str))
        {
          boolean bool = StringUtility.isNullOrEmpty(paramJSONObject.getString(str));
          if (!bool) {}
        }
        else
        {
          return false;
        }
        i += 1;
      }
      return true;
    }
    catch (JSONException paramJSONObject)
    {
      Logger.e(Area.CONFIG.value(), paramJSONObject, "_validateJsonDirectives failed", new Object[0]);
      return false;
    }
  }
  
  public static GetJarConfig getInstance(Context paramContext)
  {
    if (paramContext == null) {
      try
      {
        throw new IllegalArgumentException("'androidContext' cannot be null");
      }
      finally {}
    }
    OverridesUtility.initialize(paramContext);
    if (sInstances.containsKey("default"))
    {
      Logger.d(Area.CONFIG.value(), "GetJarConfig()::getInstance() -- re-using existing GetJarConfig instance", new Object[0]);
      paramContext = (GetJarConfig)sInstances.get("default");
    }
    for (;;)
    {
      return paramContext;
      Logger.d(Area.CONFIG.value(), "GetJarConfig()::getInstance() -- creating a new GetJarConfig instance", new Object[0]);
      paramContext = new GetJarConfig(paramContext);
      sInstances.put("default", paramContext);
    }
  }
  
  public static GetJarConfig getInstance(CommContext paramCommContext, boolean paramBoolean)
  {
    if (paramCommContext == null) {
      try
      {
        throw new IllegalArgumentException("Must supply a valid GetJarContext.");
      }
      finally {}
    }
    OverridesUtility.initialize(paramCommContext.getApplicationContext());
    if (sInstances.containsKey("default"))
    {
      Logger.d(Area.CONFIG.value(), "GetJarConfig()::getInstance() -- re-using existing GetJarConfig instance", new Object[0]);
      paramCommContext = (GetJarConfig)sInstances.get("default");
    }
    for (;;)
    {
      return paramCommContext;
      Logger.d(Area.CONFIG.value(), "GetJarConfig()::getInstance() -- creating a new GetJarConfig instance", new Object[0]);
      paramCommContext = new GetJarConfig(paramCommContext, paramBoolean);
      sInstances.put("default", paramCommContext);
    }
  }
  
  private void initialize(Context paramContext)
  {
    if (paramContext == null) {
      try
      {
        throw new IllegalArgumentException("'androidContext' cannot be null");
      }
      finally {}
    }
    this.androidContext = paramContext;
    int k = 0;
    int j = 0;
    int i = k;
    try
    {
      JSONObject localJSONObject = _getDefaultDirectives();
      i = k;
      if (_validateJsonDirectives(localJSONObject))
      {
        i = k;
        this.mDirectives = localJSONObject;
        i = 1;
        j = 1;
        Logger.d(Area.CONFIG.value(), "_initialize() -- OK: config is ready (using DEFAULTS)..", new Object[0]);
      }
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        Logger.e(Area.CONFIG.value(), localIOException, "_initialize() failed", new Object[0]);
        j = i;
      }
      AuthManager.initialize(paramContext);
      AuthManager.getInstance().registerCallbacks(this._authListener);
      SettingsManager.getInstance(paramContext).setChangeListener(this._configChangedListener);
    }
    if (j == 0)
    {
      Logger.e(Area.CONFIG.value(), "** FATAL ERROR: invalid configuration, unable to proceed..", new Object[0]);
      throw new ConfigurationException("** FATAL ERROR: invalid configuration, unable to proceed..");
    }
  }
  
  private void initialize(CommContext paramCommContext, boolean paramBoolean)
  {
    int m;
    try
    {
      this.mDirectives = null;
      this.mCommContext = paramCommContext;
      m = 0;
      n = 0;
      k = 0;
      j = 0;
      if (this.mCommContext == null) {
        throw new IllegalArgumentException("'theCommContext' can not be NULL");
      }
    }
    finally {}
    if (this.mCommContext.getApplicationContext() == null) {
      throw new IllegalArgumentException("'theCommContext.getApplicationContext()' can not be NULL");
    }
    this.androidContext = paramCommContext.getApplicationContext();
    i = m;
    if (0 == 0)
    {
      Logger.d(Area.CONFIG.value() | Area.STORAGE.value(), "#2: _initialize() -- unable to fetch server config, trying to read from SharedPrefs file..", new Object[0]);
      paramCommContext = this.mCommContext.getApplicationContext().getSharedPreferences("GetJarConfig", 0).getString("config", null);
      paramBoolean = StringUtility.isNullOrEmpty(paramCommContext);
      i = m;
      if (paramBoolean) {}
    }
    for (;;)
    {
      try
      {
        paramCommContext = new JSONObject(paramCommContext);
        i = k;
      }
      catch (JSONException paramCommContext)
      {
        i = n;
        continue;
      }
      try
      {
        if (_validateJsonDirectives(paramCommContext))
        {
          i = k;
          this.mDirectives = paramCommContext;
          i = 1;
          j = 1;
          Logger.d(Area.CONFIG.value() | Area.STORAGE.value(), "_initialize() -- OK: config is ready (from SharedPrefs)..", new Object[0]);
        }
        i = j;
        k = i;
        if (i == 0)
        {
          Logger.d(Area.CONFIG.value() | Area.STORAGE.value(), "#3: _initialize() -- unable to read form SharedPrefs file, using DEFAULTS..", new Object[0]);
          j = i;
        }
      }
      catch (JSONException paramCommContext)
      {
        continue;
      }
      try
      {
        paramCommContext = _getDefaultDirectives();
        k = i;
        j = i;
        if (_validateJsonDirectives(paramCommContext))
        {
          j = i;
          this.mDirectives = paramCommContext;
          j = i;
          _persistIntoSharedPrefs(this.mDirectives);
          j = 1;
          k = 1;
          Logger.d(Area.CONFIG.value() | Area.STORAGE.value(), "_initialize() -- OK: config is ready (using DEFAULTS)..", new Object[0]);
        }
      }
      catch (IOException paramCommContext)
      {
        Logger.e(Area.CONFIG.value() | Area.STORAGE.value(), paramCommContext, "_initialize() failed", new Object[0]);
        k = j;
        continue;
        return;
      }
      if (k != 0) {
        continue;
      }
      Logger.e(Area.CONFIG.value(), "** FATAL ERROR: invalid configuration, unable to proceed..", new Object[0]);
      throw new ConfigurationException("** FATAL ERROR: invalid configuration, unable to proceed..");
      Logger.e(Area.CONFIG.value() | Area.STORAGE.value(), paramCommContext, "_initialize() failed", new Object[0]);
    }
  }
  
  private void notifyChangeListeners(SettingsManager.Scope paramScope)
  {
    Iterator localIterator = this._configChangedListeners.iterator();
    while (localIterator.hasNext())
    {
      ConfigChangedListener localConfigChangedListener = (ConfigChangedListener)localIterator.next();
      if (localConfigChangedListener != null) {
        localConfigChangedListener.onConfigChanged(paramScope);
      }
    }
  }
  
  protected void finalize()
    throws Throwable
  {
    AuthManager.getInstance().unregisterCallbacks(this._authListener);
    SettingsManager.getInstance(this.androidContext).clearChangeListener();
    super.finalize();
  }
  
  public Boolean getBooleanValue(String paramString, Boolean paramBoolean, SettingsManager.Scope paramScope)
  {
    if (StringUtility.isNullOrEmpty(paramString)) {
      throw new IllegalArgumentException("'key' cannot be null or empty");
    }
    if (paramBoolean == null) {}
    for (String str = null;; str = String.valueOf(paramBoolean))
    {
      paramString = getDirectiveValue(paramString, str, paramScope);
      if ((!StringUtility.isNullOrEmpty(paramString)) || (paramBoolean != null)) {
        break;
      }
      return null;
    }
    return Boolean.valueOf(Boolean.parseBoolean(paramString));
  }
  
  public String getDirectiveValue(String paramString, SettingsManager.Scope paramScope)
  {
    Logger.v(Area.CONFIG.value(), "GetJarConfig getDirectiveValue() START [key='%1$s']", new Object[] { paramString });
    try
    {
      if (StringUtility.isNullOrEmpty(paramString)) {
        throw new IllegalArgumentException("Must have a valid key.");
      }
    }
    finally
    {
      Logger.v(Area.CONFIG.value(), "GetJarConfig getDirectiveValue() FINISHED [key='%1$s']", new Object[] { paramString });
    }
    if (paramScope == null) {
      throw new IllegalArgumentException("'scope' cannot be null");
    }
    String str = OverridesUtility.getValue(paramString, null);
    if (!StringUtility.isNullOrEmpty(str))
    {
      Logger.v(Area.CONFIG.value(), "GetJarConfig getDirectiveValue() Using OVERRIDE defined value: '%1$s' = '%2$s'", new Object[] { paramString, str });
      paramScope = str.trim();
      Logger.v(Area.CONFIG.value(), "GetJarConfig getDirectiveValue() FINISHED [key='%1$s']", new Object[] { paramString });
      return paramScope;
    }
    paramScope = SettingsManager.getInstance(this.androidContext).getValue(paramString, paramScope);
    if (!StringUtility.isNullOrEmpty(paramScope))
    {
      Logger.v(Area.CONFIG.value(), "GetJarConfig getDirectiveValue() Using SERVER defined value: '%1$s' = '%2$s'", new Object[] { paramString, paramScope });
      paramScope = paramScope.trim();
      Logger.v(Area.CONFIG.value(), "GetJarConfig getDirectiveValue() FINISHED [key='%1$s']", new Object[] { paramString });
      return paramScope;
    }
    try
    {
      str = this.mDirectives.getString(paramString);
      paramScope = str;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        Logger.v(Area.CONFIG.value(), "GetJarConfig getDirectiveValue() %1$s: %2$s", new Object[] { localJSONException.getClass().getSimpleName(), localJSONException.getMessage() });
      }
      throw new ConfigurationException("ERROR: no value found for config directive=" + paramString);
    }
    if (!StringUtility.isNullOrEmpty(paramScope))
    {
      Logger.v(Area.CONFIG.value(), "GetJarConfig getDirectiveValue() Using CONFIG value: '%1$s' = '%2$s'", new Object[] { paramString, paramScope });
      paramScope = paramScope.trim();
      Logger.v(Area.CONFIG.value(), "GetJarConfig getDirectiveValue() FINISHED [key='%1$s']", new Object[] { paramString });
      return paramScope;
    }
  }
  
  public String getDirectiveValue(String paramString1, String paramString2, SettingsManager.Scope paramScope)
  {
    if (StringUtility.isNullOrEmpty(paramString1)) {
      throw new IllegalArgumentException("Must have a valid key.");
    }
    try
    {
      paramScope = getDirectiveValue(paramString1, paramScope);
      return paramScope;
    }
    catch (ConfigurationException paramScope)
    {
      Logger.v(Area.CONFIG.value(), "GetJarConfig getDirectiveValue() Using DEFAULT value: '%1$s' = '%2$s'", new Object[] { paramString1, paramString2 });
    }
    return paramString2;
  }
  
  public Integer getIntegerValue(String paramString, Integer paramInteger, SettingsManager.Scope paramScope)
  {
    if (StringUtility.isNullOrEmpty(paramString)) {
      throw new IllegalArgumentException("'key' cannot be null or empty");
    }
    if (paramInteger == null) {}
    for (String str = null;; str = String.valueOf(paramInteger))
    {
      paramString = getDirectiveValue(paramString, str, paramScope);
      if ((!StringUtility.isNullOrEmpty(paramString)) || (paramInteger != null)) {
        break;
      }
      return null;
    }
    try
    {
      int i = Integer.parseInt(paramString);
      return Integer.valueOf(i);
    }
    catch (NumberFormatException paramString)
    {
      throw new ConfigurationException(paramString);
    }
  }
  
  public boolean hasValue(String paramString, SettingsManager.Scope paramScope)
  {
    boolean bool = false;
    if (StringUtility.isNullOrEmpty(paramString)) {
      throw new IllegalArgumentException("'key' cannot be null or empty");
    }
    if (paramScope == null) {
      throw new IllegalArgumentException("'scope' cannot be null");
    }
    try
    {
      paramString = getDirectiveValue(paramString, paramScope);
      if (paramString != null) {
        bool = true;
      }
      return bool;
    }
    catch (ConfigurationException paramString) {}
    return false;
  }
  
  public void registerChangeListener(ConfigChangedListener paramConfigChangedListener)
  {
    if (paramConfigChangedListener == null) {
      throw new IllegalArgumentException("'listener' cannot be null");
    }
    if (!this._configChangedListeners.contains(paramConfigChangedListener)) {
      this._configChangedListeners.add(paramConfigChangedListener);
    }
  }
  
  public void unregisterChangeListener(ConfigChangedListener paramConfigChangedListener)
  {
    if (paramConfigChangedListener == null) {
      throw new IllegalArgumentException("'listener' cannot be null");
    }
    this._configChangedListeners.remove(paramConfigChangedListener);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/config/GetJarConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */