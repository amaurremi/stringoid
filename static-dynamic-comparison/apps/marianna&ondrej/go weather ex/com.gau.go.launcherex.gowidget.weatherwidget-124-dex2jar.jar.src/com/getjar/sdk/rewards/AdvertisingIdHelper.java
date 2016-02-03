package com.getjar.sdk.rewards;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.getjar.sdk.config.GetJarConfig;
import com.getjar.sdk.config.SettingsManager.Scope;
import com.getjar.sdk.data.install_state.InstallStateManager;
import com.getjar.sdk.data.metadata.PackageMonitor;
import com.getjar.sdk.logging.Area;
import com.getjar.sdk.logging.Logger;
import com.getjar.sdk.utilities.AlarmsUtility;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AdvertisingIdHelper
{
  private static final ExecutorService _ExecutorService = ;
  private static volatile AdvertisingIdHelper _Instance;
  private static final Object _InstanceLock = new Object();
  private static final String _PrefesFileName = "AdvertisingIdPrefs";
  private static final String _PrefsKeyAdvertisingId = "advertisingIdKey";
  private volatile AdvertisingIdClient.Info _adClientInfo = null;
  private final Context _context;
  private volatile Throwable _googlePlayError = null;
  
  private AdvertisingIdHelper(Context paramContext)
  {
    if (paramContext == null) {
      throw new IllegalArgumentException("'context' cannot be null");
    }
    this._context = paramContext;
    _ExecutorService.execute(new Runnable()
    {
      public void run()
      {
        AdvertisingIdHelper.this.initAdClientInfo();
      }
    });
  }
  
  public static AdvertisingIdHelper getInstance(Context paramContext)
  {
    if (paramContext == null) {
      throw new IllegalArgumentException("'context' cannot be null");
    }
    if (_Instance == null) {}
    synchronized (_InstanceLock)
    {
      if (_Instance == null) {
        _Instance = new AdvertisingIdHelper(paramContext);
      }
      return _Instance;
    }
  }
  
  private void handleAdvertisingIDChangeWork()
  {
    try
    {
      Logger.d(Area.USAGE.value(), "AdvertisingIdHelper: handleAdvertisingIDChangeWork() START", new Object[0]);
      if (this._adClientInfo != null)
      {
        Object localObject1 = this._adClientInfo.getId();
        Logger.d(Area.USAGE.value(), "AdvertisingIdHelper: handleAdvertisingIDChangeWork() advertisingId:%1$s", new Object[] { localObject1 });
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          Object localObject3 = this._context.getSharedPreferences("AdvertisingIdPrefs", 0);
          String str = ((SharedPreferences)localObject3).getString("advertisingIdKey", "");
          Logger.d(Area.USAGE.value(), "AdvertisingIdHelper: handleAdvertisingIDChangeWork() cachedAdvertisingId:%1$s", new Object[] { str });
          if (!((String)localObject1).equals(str))
          {
            Logger.d(Area.USAGE.value(), "AdvertisingIdHelper: handleAdvertisingIDChangeWork() updating cached Advertising ID", new Object[0]);
            localObject3 = ((SharedPreferences)localObject3).edit();
            ((SharedPreferences.Editor)localObject3).putString("advertisingIdKey", (String)localObject1);
            ((SharedPreferences.Editor)localObject3).commit();
            if (!TextUtils.isEmpty(str))
            {
              Logger.d(Area.USAGE.value(), "AdvertisingIdHelper: handleAdvertisingIDChangeWork() Advertising ID has changed, doing work...", new Object[0]);
              InstallStateManager.getInstance(this._context).clearInstallState();
              AlarmsUtility.clearLastRunTimestampUsageReporting(this._context);
              localObject1 = new Intent();
              ((Intent)localObject1).setClass(this._context, PackageMonitor.class);
              ((Intent)localObject1).putExtra("usageAndEventTracking", "usageAndEventTracking");
              this._context.sendBroadcast((Intent)localObject1);
            }
          }
        }
      }
      return;
    }
    catch (Exception localException)
    {
      Logger.e(Area.USAGE.value(), localException, "AdvertisingIdHelper: handleAdvertisingIDChangeWork() failed", new Object[0]);
      return;
    }
    finally
    {
      Logger.d(Area.USAGE.value(), "AdvertisingIdHelper: handleAdvertisingIDChangeWork() DONE", new Object[0]);
    }
  }
  
  private void initAdClientInfo()
  {
    if ((this._adClientInfo == null) && (this._googlePlayError == null)) {}
    try
    {
      Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient");
      this._adClientInfo = AdvertisingIdClient.getAdvertisingIdInfo(this._context);
      _ExecutorService.execute(new Runnable()
      {
        public void run()
        {
          AdvertisingIdHelper.this.handleAdvertisingIDChangeWork();
        }
      });
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      this._googlePlayError = localClassNotFoundException;
      Logger.w(Area.CONFIG.value() | Area.AUTH.value(), "AdvertisingIdHelper: initAdClientInfo() Unable to find com.google.android.gms.ads.identifier.AdvertisingIdClient. Please add a reference to the google-play-services_lib library project.", new Object[0]);
      return;
    }
    catch (Exception localException)
    {
      this._googlePlayError = localException;
      Logger.w(Area.CONFIG.value() | Area.AUTH.value(), localException, "AdvertisingIdHelper: initAdClientInfo() Error getting Advertising ID", new Object[0]);
    }
  }
  
  public void addDataToMap(Map<String, String> paramMap)
  {
    if (paramMap == null) {
      throw new IllegalArgumentException("'map' cannot be null");
    }
    paramMap.put("android.device.google_play.ads.advertising_id", getId());
    paramMap.put("android.device.google_play.ads.limit_tracking_enabled", Boolean.toString(isLimitAdTrackingEnabled()));
    paramMap.put("android.device.google_play.ads.retrieve_error", Boolean.toString(hasError()));
  }
  
  public String getId()
  {
    initAdClientInfo();
    if (this._adClientInfo != null) {
      return this._adClientInfo.getId();
    }
    return null;
  }
  
  public boolean hasError()
  {
    initAdClientInfo();
    return this._googlePlayError != null;
  }
  
  public boolean isLimitAdTrackingEnabled()
  {
    initAdClientInfo();
    if (this._adClientInfo != null) {
      return this._adClientInfo.isLimitAdTrackingEnabled();
    }
    return GetJarConfig.getInstance(this._context).getBooleanValue("ads.android.limit_tracking_enabled", Boolean.valueOf(true), SettingsManager.Scope.CLIENT).booleanValue();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/rewards/AdvertisingIdHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */