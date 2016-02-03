package com.getjar.sdk.utilities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build.VERSION;
import com.getjar.sdk.Account.Status;
import com.getjar.sdk.GetjarException;
import com.getjar.sdk.comm.UserAgentValuesManager;
import com.getjar.sdk.comm.auth.AccountHistoryInfo;
import com.getjar.sdk.comm.auth.AccountHistoryManager;
import com.getjar.sdk.comm.auth.AndroidAccountUserAuthProvider;
import com.getjar.sdk.comm.auth.ApplicationTokenDatabase;
import com.getjar.sdk.data.ReportUsageData.UsageType;
import com.getjar.sdk.data.cache.AdManager.AdType;
import com.getjar.sdk.data.earning.EarnStateDatabase;
import com.getjar.sdk.data.earning.EarningMonitor;
import com.getjar.sdk.logging.Area;
import com.getjar.sdk.logging.Logger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class RewardUtility
{
  public static final String DEVELOPER_REFERENCES = "GetJarDeveloperReferences";
  public static final int INSTALL_APP_CAP = 500;
  public static final String REWARD_URL = "http://rewards.getjar.com/";
  public static final String _PreferencesWebSettingName = "GetJarSDKWebSettingPrefs";
  
  public static boolean checkPermission(Context paramContext, String paramString)
  {
    if (paramContext == null) {
      throw new IllegalArgumentException("'context' can not be null");
    }
    if (StringUtility.isNullOrEmpty(paramString)) {
      throw new IllegalArgumentException("'permission' can not be null or empty");
    }
    return paramContext.checkCallingOrSelfPermission(paramString) == 0;
  }
  
  public static JSONArray getAccountsJson(Context paramContext)
  {
    Logger.v(Area.AUTH.value(), "RewardUtility: getAccountsJson() START", new Object[0]);
    JSONArray localJSONArray = new JSONArray();
    Object localObject2;
    Object localObject1;
    Object localObject3;
    Object localObject4;
    JSONObject localJSONObject;
    for (;;)
    {
      try
      {
        AccountHistoryManager.initialize(paramContext);
        localObject2 = new AndroidAccountUserAuthProvider().getCachedAccountName(paramContext);
        localObject1 = localObject2;
        if (StringUtility.isNullOrEmpty((String)localObject2)) {
          localObject1 = AccountHistoryManager.getInstance().getCurrentAccountName();
        }
        localObject2 = new ArrayList();
        localObject3 = AccountHistoryManager.getInstance().getAccounts().iterator();
        if (!((Iterator)localObject3).hasNext()) {
          break;
        }
        localObject4 = (AccountHistoryInfo)((Iterator)localObject3).next();
        if (!StringUtility.isNullOrEmpty(((AccountHistoryInfo)localObject4).getAccountName()))
        {
          localJSONObject = new JSONObject();
          ((List)localObject2).add(((AccountHistoryInfo)localObject4).getAccountName().toLowerCase(Locale.US));
          localJSONObject.put("account_name", ((AccountHistoryInfo)localObject4).getAccountName());
          localJSONObject.put("provider_filter", ((AccountHistoryInfo)localObject4).getProviderFilter());
          localJSONObject.put("timestamp_created", ((AccountHistoryInfo)localObject4).getTimestampCreated());
          localJSONObject.put("timestamp_last_auth", ((AccountHistoryInfo)localObject4).getTimestampLastAuth());
          if (((AccountHistoryInfo)localObject4).getAccountName().equalsIgnoreCase((String)localObject1))
          {
            localJSONObject.put("status", Account.Status.CURRENT.name());
            localJSONArray.put(localJSONObject);
          }
          else
          {
            localJSONObject.put("status", Account.Status.PREVIOUS.name());
          }
        }
      }
      catch (JSONException paramContext)
      {
        throw new GetjarException(paramContext);
      }
      finally
      {
        Logger.v(Area.AUTH.value(), "RewardUtility: getAccountsJson() FINISH", new Object[0]);
      }
    }
    paramContext = AndroidAccountUserAuthProvider.getAndroidAccountNames(paramContext);
    int j;
    int i;
    if (paramContext != null)
    {
      localObject3 = new AndroidAccountUserAuthProvider().getProviderFilter();
      j = paramContext.length;
      i = 0;
      break label430;
      if (((List)localObject2).contains(localJSONObject.toString().toLowerCase(Locale.US))) {
        break label445;
      }
      localObject4 = new JSONObject();
      ((JSONObject)localObject4).put("account_name", localJSONObject.toString());
      ((JSONObject)localObject4).put("provider_filter", localObject3);
      if (localJSONObject.toString().equalsIgnoreCase((String)localObject1)) {
        ((JSONObject)localObject4).put("status", Account.Status.CURRENT.name());
      }
      for (;;)
      {
        localJSONArray.put(localObject4);
        break;
        ((JSONObject)localObject4).put("status", Account.Status.UNKNOWN.name());
      }
    }
    label430:
    label445:
    label450:
    for (;;)
    {
      Logger.v(Area.AUTH.value(), "RewardUtility: getAccountsJson() FINISH", new Object[0]);
      return localJSONArray;
      for (;;)
      {
        if (i >= j) {
          break label450;
        }
        localJSONObject = paramContext[i];
        if (localJSONObject != null) {
          break;
        }
        i += 1;
      }
    }
  }
  
  public static Map<String, ?> getWebSharedPrefsMap(Context paramContext)
  {
    return paramContext.getSharedPreferences("GetJarSDKWebSettingPrefs", 0).getAll();
  }
  
  public static int prepAppDataForReportUsage(String paramString, ReportUsageData.UsageType paramUsageType, Context paramContext, Map<String, String> paramMap)
  {
    if (StringUtility.isNullOrEmpty(paramString)) {
      throw new IllegalArgumentException("'packageName' cannot be NULL or empty");
    }
    if (paramContext == null) {
      throw new IllegalArgumentException("'context' cannot be NULL");
    }
    if (paramMap == null) {
      throw new IllegalArgumentException("'appMetadata' cannot be NULL");
    }
    paramMap.put("android.package.name", paramString);
    paramMap.put("device.platform", "android");
    paramMap.put("device.platform_version", Build.VERSION.RELEASE);
    int j = 0;
    int i = j;
    if (!ReportUsageData.UsageType.UNINSTALLED.equals(paramUsageType))
    {
      i = j;
      if (ReportUsageData.UsageType.FOUND_UNINSTALLED.equals(paramUsageType)) {}
    }
    try
    {
      paramUsageType = paramContext.getPackageManager().getPackageInfo(paramString, 128);
      paramMap.put("android.package.version_code", Integer.toString(paramUsageType.versionCode));
      paramMap.put("android.package.version_name", paramUsageType.versionName);
      i = paramUsageType.applicationInfo.flags;
      return i;
    }
    catch (Exception paramUsageType)
    {
      Logger.w(Area.CONFIG.value(), "Failed to get versionCode, versionName, and app flags [packageName:'%1$s' error:'%2$s']", new Object[] { paramString, paramUsageType.getClass().getName() });
    }
    return 0;
  }
  
  public static void requestInstall(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, Constants.RequestInstallType paramRequestInstallType, String paramString6, String paramString7, AdManager.AdType paramAdType, Context paramContext)
  {
    if (StringUtility.isNullOrEmpty(paramString1)) {
      throw new IllegalArgumentException("'thePackageName' cannot be NULL or empty");
    }
    if (StringUtility.isNullOrEmpty(paramString2)) {
      throw new IllegalArgumentException("'theFriendlyName' cannot be NULL or empty");
    }
    if (StringUtility.isNullOrEmpty(paramString3)) {
      throw new IllegalArgumentException("'theDownloadUrl' cannot be NULL or empty");
    }
    if (StringUtility.isNullOrEmpty(paramString4)) {
      throw new IllegalArgumentException("'theAppMetadata' cannot be NULL or empty");
    }
    if (StringUtility.isNullOrEmpty(paramString5)) {
      throw new IllegalArgumentException("'theTrackingMetadata' cannot be NULL or empty");
    }
    if (paramAdType == null) {
      throw new IllegalArgumentException("'adType' cannot be null");
    }
    if (paramRequestInstallType == null) {
      throw new IllegalArgumentException("'theRequestType' cannot be NULL");
    }
    Logger.d(Area.PURCHASE.value() | Area.EARN.value() | Area.TRANSACTION.value(), "RewardUtility: requestInstall(packageName:%1$s, friendlyName:%2$s, downloadUrl:%3$s, requestType:%4$s)", new Object[] { paramString1, paramString2, paramString3, paramRequestInstallType.name() });
    Logger.v(Area.PURCHASE.value() | Area.EARN.value() | Area.TRANSACTION.value(), "RewardUtility: requestInstall() applicationMetadata: %1$s", new Object[] { paramString4 });
    Logger.v(Area.PURCHASE.value() | Area.EARN.value() | Area.TRANSACTION.value(), "RewardUtility: requestInstall() trackingMetadata: %1$s", new Object[] { paramString5 });
    try
    {
      HashMap localHashMap = Utility.jsonArrayStringToMap(paramString5);
      paramString5 = paramString6;
      if (paramString6 == null) {
        paramString5 = "";
      }
      localHashMap.put("ads.placement", paramString5);
      if (!StringUtility.isNullOrEmpty(paramString7)) {
        localHashMap.put("earn.currency_key", paramString7);
      }
      localHashMap.put("ads.layout_type", paramAdType.name());
      localHashMap.put("client_app.token", ApplicationTokenDatabase.getInstance(paramContext).getApplicationToken());
      localHashMap.put("legacy.device.user_agent", UserAgentValuesManager.getInstance().getWebKitUserAgent(paramContext));
      boolean bool2 = false;
      paramString5 = paramContext.getPackageManager().getInstalledPackages(0).iterator();
      do
      {
        bool1 = bool2;
        if (!paramString5.hasNext()) {
          break;
        }
      } while (!paramString1.equals(((PackageInfo)paramString5.next()).packageName));
      boolean bool1 = true;
      localHashMap.put("ads.already_installed", String.valueOf(bool1));
      paramString5 = new JSONObject(localHashMap);
      paramString6 = new JSONArray();
      paramString6.put(paramString5);
      paramString5 = paramString6.toString();
      if (Constants.RequestInstallType.EARN.equals(paramRequestInstallType))
      {
        EarnStateDatabase.getInstance(paramContext).addAppState(paramString1, paramString2, paramString4, paramString5, paramString7);
        Logger.v(Area.PURCHASE.value() | Area.EARN.value() | Area.TRANSACTION.value() | Area.STORAGE.value(), "RewardUtility: requestInstall() starting usage monitoring thread", new Object[0]);
        EarningMonitor.getInstance(paramContext).ensureMonitoring();
      }
      Logger.d(Area.PURCHASE.value() | Area.EARN.value() | Area.TRANSACTION.value(), "RewardUtility: requestInstall() Pushing download URL to the Android OS [downloadURl: %1$s]", new Object[] { paramString3 });
      paramString1 = new Intent("android.intent.action.VIEW", Uri.parse(paramString3));
      paramString1.addFlags(268435456);
      paramString1.addFlags(134217728);
      paramString1.addFlags(1073741824);
      paramContext.startActivity(paramString1);
      return;
    }
    catch (JSONException paramString1)
    {
      throw new GetjarException(paramString1);
    }
  }
  
  public static void saveGetJarTimestamp(Context paramContext)
  {
    if (paramContext == null) {
      throw new IllegalArgumentException("Must have a valid context.");
    }
    paramContext.getSharedPreferences("GetJarDeveloperReferences", 0).edit().putLong("timestamp", System.currentTimeMillis()).commit();
  }
  
  public static void saveWebUrlData(Context paramContext, String paramString)
  {
    if (paramContext == null) {
      throw new IllegalArgumentException("Must have a valid context.");
    }
    if (StringUtility.isNullOrEmpty(paramString)) {
      throw new IllegalArgumentException("Must provide a non-null, non-empty url.");
    }
    paramContext = paramContext.getSharedPreferences("GetJarSDKWebSettingPrefs", 0).edit();
    paramContext.putLong("web.timestamp", System.currentTimeMillis()).commit();
    paramContext.putString("web.last.known", paramString).commit();
    paramContext.commit();
    Logger.v(Area.STORAGE.value(), "Last known URL updated to '%1$s'", new Object[] { paramString });
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/utilities/RewardUtility.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */