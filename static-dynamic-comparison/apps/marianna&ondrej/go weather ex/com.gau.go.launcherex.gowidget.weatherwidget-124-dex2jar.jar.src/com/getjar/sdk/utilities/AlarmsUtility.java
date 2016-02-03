package com.getjar.sdk.utilities;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.getjar.sdk.config.GetJarConfig;
import com.getjar.sdk.config.SettingsManager.Scope;
import com.getjar.sdk.data.metadata.PackageMonitor;
import com.getjar.sdk.data.usage.UsageManager;
import com.getjar.sdk.logging.Area;
import com.getjar.sdk.logging.Logger;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public final class AlarmsUtility
{
  private static final String _KeyLastRunTimestampUsageReporting = "UsageReportingLastRunTimestamp";
  private static final List<String> _SUPPORTED_OPERATIONS = new ArrayList(2);
  private static final long _VoucherRedemptionCheckInterval = 120000L;
  
  static
  {
    _SUPPORTED_OPERATIONS.add("usageAndEventTracking");
    _SUPPORTED_OPERATIONS.add("usageMonitoringAlarm");
  }
  
  private static boolean checkLastRun(Context paramContext, String paramString, long paramLong)
  {
    paramContext = paramContext.getSharedPreferences("GetJarClientPrefs", 0);
    if (!paramContext.contains(paramString)) {}
    long l;
    do
    {
      return true;
      l = paramContext.getLong(paramString, 0L);
    } while ((l == 0L) || (l + paramLong < System.currentTimeMillis()));
    return false;
  }
  
  private static void clearLastRunTimestamp(Context paramContext, String paramString)
  {
    paramContext = paramContext.getSharedPreferences("GetJarClientPrefs", 0).edit();
    paramContext.remove(paramString).commit();
    paramContext.commit();
  }
  
  public static void clearLastRunTimestampUsageReporting(Context paramContext)
  {
    if (paramContext == null) {
      throw new IllegalArgumentException("'context' can not be NULL");
    }
    clearLastRunTimestamp(paramContext, "UsageReportingLastRunTimestamp");
  }
  
  public static void ensureBackgroundMonitoringAlarm(Context paramContext)
  {
    try
    {
      Logger.d(Area.USAGE.value(), "Alarms: startBackgroundMonitoring() -- START", new Object[0]);
      if (paramContext == null) {
        throw new IllegalArgumentException("'context' can not be NULL");
      }
    }
    finally {}
    Long localLong;
    try
    {
      if (!UsageManager.getInstance(paramContext).isMonitoringEnabled()) {
        Logger.d(Area.USAGE.value(), "Alarms: startBackgroundMonitoring(): Usage monitoring is disabled for this app, not scheduling alarm", new Object[0]);
      }
      for (;;)
      {
        return;
        localLong = Long.valueOf(Long.parseLong(GetJarConfig.getInstance(paramContext).getDirectiveValue("usage.monitoring.alarm_interval", SettingsManager.Scope.CLIENT)));
        if ((localLong != null) && (localLong.longValue() > 0L)) {
          break;
        }
        Logger.e(Area.USAGE.value(), "Alarms: startBackgroundMonitoring(): Missing or bad value found for '%1$s', not scheduling alarm", new Object[] { "usage.monitoring.alarm_interval" });
      }
      Logger.d(Area.USAGE.value(), "Alarms: startBackgroundMonitoring() -- END", new Object[0]);
    }
    catch (Exception paramContext)
    {
      Logger.e(Area.USAGE.value(), paramContext, "Alarms: ERROR: unable to start background USAGE monitoring", new Object[0]);
    }
    for (;;)
    {
      break;
      scheduleAlarm(paramContext, "usageMonitoringAlarm", 0L, Utility.convertMillSec(localLong.longValue()), 2);
    }
  }
  
  public static void ensureBackgroundReportingAlarm(Context paramContext)
  {
    try
    {
      Logger.d(Area.USAGE.value(), "Alarms: startBackgroundReporting() -- START", new Object[0]);
      if (paramContext == null) {
        throw new IllegalArgumentException("'context' can not be NULL");
      }
    }
    finally {}
    for (;;)
    {
      try
      {
        if ((!UsageManager.getInstance(paramContext).isUsageSessionBackgroundSendEnabled()) && (!UsageManager.getInstance(paramContext).isUsageInstallBackgroundSendEnabled()))
        {
          Logger.d(Area.USAGE.value(), "Alarms: startBackgroundReporting(): Usage reporting is disabled for this app, not scheduling alarm", new Object[0]);
          return;
        }
        Long localLong = Long.valueOf(Utility.convertMillSec(Long.parseLong(GetJarConfig.getInstance(paramContext).getDirectiveValue("usage.background.send.interval", SettingsManager.Scope.CLIENT))));
        if ((localLong != null) && (localLong.longValue() > 0L)) {
          ensureUsageReportingAlarm(paramContext, localLong.longValue());
        }
      }
      catch (Exception paramContext)
      {
        Logger.e(Area.USAGE.value(), paramContext, "Alarms: ERROR: unable to start background USAGE reporting", new Object[0]);
        continue;
      }
      Logger.d(Area.USAGE.value(), "Alarms: startBackgroundReporting() -- END", new Object[0]);
    }
  }
  
  private static void ensureUsageReportingAlarm(Context paramContext, long paramLong)
  {
    try
    {
      Logger.d(Area.USAGE.value(), "Alarms: ensureUsageReportingAlarm() -- START: usageReportingInterval=%1$d", new Object[] { Long.valueOf(paramLong) });
      if (paramContext == null) {
        throw new IllegalArgumentException("'context' can not be NULL");
      }
    }
    finally {}
    if (checkLastRun(paramContext, "UsageReportingLastRunTimestamp", paramLong)) {
      scheduleAlarm(paramContext, "usageAndEventTracking", 20000L, paramLong, 1);
    }
    for (;;)
    {
      Logger.d(Area.USAGE.value(), "Alarms: ensureUsageReportingAlarm() -- END", new Object[0]);
      return;
      Logger.v(Area.USAGE.value(), "Alarms: ensureUsageReportingAlarm() -- Alarm does not need to be scheduled or run at this time", new Object[0]);
    }
  }
  
  private static void scheduleAlarm(Context paramContext, String paramString, long paramLong1, long paramLong2, int paramInt)
  {
    if (paramContext == null) {
      throw new IllegalArgumentException("'context' can not be NULL");
    }
    if (StringUtility.isNullOrEmpty(paramString)) {
      throw new IllegalArgumentException("'operation' can not be NULL or empty");
    }
    if (!_SUPPORTED_OPERATIONS.contains(paramString)) {
      throw new IllegalArgumentException(String.format(Locale.US, "Unsupported operation value '%1$s'", new Object[] { paramString }));
    }
    Logger.d(Area.USAGE.value(), "Alarms: scheduleAlarm() [operation:%1$s start:%2$d, interval:%3$d, requestCode:%4$d]", new Object[] { paramString, Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(paramInt) });
    Intent localIntent = new Intent();
    localIntent.setClass(paramContext, PackageMonitor.class);
    localIntent.putExtra(paramString, paramString);
    paramString = PendingIntent.getBroadcast(paramContext, paramInt, localIntent, 134217728);
    ((AlarmManager)paramContext.getSystemService("alarm")).setRepeating(0, System.currentTimeMillis() + paramLong1, paramLong2, paramString);
  }
  
  public static void scheduleVoucherRedemptionCheck(Context paramContext, String paramString)
  {
    if (paramContext == null) {
      try
      {
        throw new IllegalArgumentException("'context' cannot be NULL");
      }
      finally {}
    }
    if (StringUtility.isNullOrEmpty(paramString)) {
      throw new IllegalArgumentException("'voucherToken' cannot be NULL or empty");
    }
    Logger.d(Area.UI.value() | Area.REDEEM.value() | Area.OFFER.value(), "Alarms: scheduleVoucherRedemptionCheck() [voucherToken:%1$s]", new Object[] { paramString });
    Intent localIntent = new Intent();
    localIntent.setClass(paramContext, PackageMonitor.class);
    localIntent.putExtra("voucherRedemptionCheck", "voucherRedemptionCheck");
    localIntent.putExtra("voucherToken", paramString);
    paramString = PendingIntent.getBroadcast(paramContext, paramString.hashCode(), localIntent, 134217728);
    ((AlarmManager)paramContext.getSystemService("alarm")).set(0, System.currentTimeMillis() + 120000L, paramString);
  }
  
  private static void updateLastRunTimestamp(Context paramContext, String paramString)
  {
    paramContext = paramContext.getSharedPreferences("GetJarClientPrefs", 0).edit();
    paramContext.putLong(paramString, System.currentTimeMillis()).commit();
    paramContext.commit();
  }
  
  public static void updateLastRunTimestampUsageReporting(Context paramContext)
  {
    if (paramContext == null) {
      throw new IllegalArgumentException("'context' can not be NULL");
    }
    updateLastRunTimestamp(paramContext, "UsageReportingLastRunTimestamp");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/utilities/AlarmsUtility.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */