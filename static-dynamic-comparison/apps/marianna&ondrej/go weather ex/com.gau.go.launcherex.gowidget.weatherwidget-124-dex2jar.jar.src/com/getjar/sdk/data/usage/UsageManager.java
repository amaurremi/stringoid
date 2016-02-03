package com.getjar.sdk.data.usage;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.getjar.sdk.config.ConfigChangedListener;
import com.getjar.sdk.config.GetJarConfig;
import com.getjar.sdk.config.SettingsManager.Scope;
import com.getjar.sdk.data.ReportUsageData.UsageType;
import com.getjar.sdk.data.earning.EarnStateRecord;
import com.getjar.sdk.logging.Area;
import com.getjar.sdk.logging.Logger;
import com.getjar.sdk.utilities.StringUtility;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UsageManager
{
  private static final int BACKGROUND_SEND_BATCH_COUNT = 50;
  private static final boolean BACKGROUND_SEND_ENABLED = false;
  private static final int BACKGROUND_SEND_INTERVAL_SECONDS = 7200;
  private static Comparator<AggregateUsageRecord> ComparatorPackageName;
  private static Comparator<AggregateUsageRecord> ComparatorTimestampStart;
  private static Comparator<AggregateUsageRecord> ComparatorTimestampStop;
  private static Comparator<AggregateUsageRecord> ComparatorTotalSessionsCount = new Comparator()
  {
    public int compare(AggregateUsageRecord paramAnonymousAggregateUsageRecord1, AggregateUsageRecord paramAnonymousAggregateUsageRecord2)
    {
      return paramAnonymousAggregateUsageRecord2.getTotalSessionsCount() - paramAnonymousAggregateUsageRecord1.getTotalSessionsCount();
    }
  };
  private static Comparator<AggregateUsageRecord> ComparatorTotalUseDuration;
  private static final int REQUEST_MAX_COUNT = 10;
  private static final int REQUEST_TIME_WINDOW_COUNT = 7;
  private static final int REQUEST_TIME_WINDOW_SECONDS = 86400;
  private static final boolean USAGE_FILTER_SYSTEM_ENABLED = true;
  private static final boolean USAGE_MONITORING_ENABLED = true;
  private static final boolean USAGE_REQUEST_SEND_ENABLED = false;
  private static volatile UsageManager _Instance;
  private static Object typeFilterLock = new Object();
  private ConfigChangedListener _configChangedListener = new ConfigChangedListener()
  {
    private String _id = UUID.randomUUID().toString();
    
    public int compare(ConfigChangedListener paramAnonymousConfigChangedListener1, ConfigChangedListener paramAnonymousConfigChangedListener2)
    {
      return paramAnonymousConfigChangedListener1.getUniqueId().compareTo(paramAnonymousConfigChangedListener2.getUniqueId());
    }
    
    public boolean equals(Object paramAnonymousObject)
    {
      if ((paramAnonymousObject == null) || (!(paramAnonymousObject instanceof ConfigChangedListener))) {
        return false;
      }
      return getUniqueId().equals(((ConfigChangedListener)paramAnonymousObject).getUniqueId());
    }
    
    public String getUniqueId()
    {
      return this._id;
    }
    
    public int hashCode()
    {
      return getUniqueId().hashCode();
    }
    
    public void onConfigChanged(SettingsManager.Scope paramAnonymousScope)
    {
      Logger.d(Area.USAGE.value() | Area.CONFIG.value(), "UsageManager: onConfigChanged() called", new Object[0]);
      if (SettingsManager.Scope.CLIENT.equals(paramAnonymousScope))
      {
        UsageManager.access$002(UsageManager.this, null);
        UsageManager.access$102(UsageManager.this, null);
        UsageManager.access$202(UsageManager.this, false);
      }
    }
    
    public String toString()
    {
      return getUniqueId();
    }
  };
  private final Context _context;
  private volatile Boolean _isFilterSystemEnabled = null;
  private volatile boolean _isRegexLoaded = false;
  private volatile Pattern _regExPatternCache = null;
  private volatile String _typeFilterCache = null;
  private volatile HashSet<ReportUsageData.UsageType> _typeFilterSetCache = new HashSet();
  private volatile Map<String, Long> existingDurationMap = new ConcurrentHashMap();
  private volatile String lastKnownPhoneSessionId = null;
  
  static
  {
    _Instance = null;
    ComparatorPackageName = new Comparator()
    {
      public int compare(AggregateUsageRecord paramAnonymousAggregateUsageRecord1, AggregateUsageRecord paramAnonymousAggregateUsageRecord2)
      {
        return paramAnonymousAggregateUsageRecord2.getPackageName().compareTo(paramAnonymousAggregateUsageRecord1.getPackageName());
      }
    };
    ComparatorTimestampStart = new Comparator()
    {
      public int compare(AggregateUsageRecord paramAnonymousAggregateUsageRecord1, AggregateUsageRecord paramAnonymousAggregateUsageRecord2)
      {
        return (int)(paramAnonymousAggregateUsageRecord2.getTimestampStart() - paramAnonymousAggregateUsageRecord1.getTimestampStart());
      }
    };
    ComparatorTimestampStop = new Comparator()
    {
      public int compare(AggregateUsageRecord paramAnonymousAggregateUsageRecord1, AggregateUsageRecord paramAnonymousAggregateUsageRecord2)
      {
        return (int)(paramAnonymousAggregateUsageRecord2.getTimestampStop() - paramAnonymousAggregateUsageRecord1.getTimestampStop());
      }
    };
    ComparatorTotalUseDuration = new Comparator()
    {
      public int compare(AggregateUsageRecord paramAnonymousAggregateUsageRecord1, AggregateUsageRecord paramAnonymousAggregateUsageRecord2)
      {
        return paramAnonymousAggregateUsageRecord2.getTotalUseDuration() - paramAnonymousAggregateUsageRecord1.getTotalUseDuration();
      }
    };
  }
  
  private UsageManager(Context paramContext)
  {
    this._context = paramContext.getApplicationContext();
    GetJarConfig.getInstance(this._context).registerChangeListener(this._configChangedListener);
  }
  
  private String getBackgroundTypeFilter()
  {
    String str = GetJarConfig.getInstance(this._context).getDirectiveValue("usage.background.type_filter", null, SettingsManager.Scope.CLIENT);
    Logger.d(Area.USAGE.value() | Area.CONFIG.value(), "UsageManager getBackgroundTypeFilter: %1$s", new Object[] { str });
    return str;
  }
  
  private List<AggregateUsageRecord> getCollapsedSortedAggregateSessions()
  {
    Object localObject = getRequestSort();
    if ("android.package.name".equals(localObject)) {
      localObject = ComparatorPackageName;
    }
    for (;;)
    {
      List localList = UsageDatabase.getInstance(this._context).getAggregateSessions(getRequestTimeMilliseconds());
      Collections.sort(localList, (Comparator)localObject);
      return localList;
      if ("start_timestamp".equals(localObject))
      {
        localObject = ComparatorTimestampStart;
      }
      else if ("stop_timestamp".equals(localObject))
      {
        localObject = ComparatorTimestampStop;
      }
      else if ("duration".equals(localObject))
      {
        localObject = ComparatorTotalUseDuration;
      }
      else if ("sessions".equals(localObject))
      {
        localObject = ComparatorTotalSessionsCount;
      }
      else
      {
        Logger.e(Area.USAGE.value(), "UsageManager: Unrecognized sort column '%1$s'", new Object[] { localObject });
        localObject = ComparatorTotalUseDuration;
      }
    }
  }
  
  private String getFilterRegex()
  {
    String str = GetJarConfig.getInstance(this._context).getDirectiveValue("usage.package_filter.regex", null, SettingsManager.Scope.CLIENT);
    Logger.d(Area.USAGE.value() | Area.CONFIG.value(), "UsageManager getFilterRegex: %1$s", new Object[] { str });
    return str;
  }
  
  public static UsageManager getInstance(Context paramContext)
  {
    if (paramContext == null) {
      try
      {
        throw new IllegalArgumentException("'context' cannot be NULL");
      }
      finally {}
    }
    if (_Instance == null) {
      _Instance = new UsageManager(paramContext);
    }
    paramContext = _Instance;
    return paramContext;
  }
  
  private Pattern getPackagePattern()
  {
    Object localObject1;
    Object localObject2;
    if (!this._isRegexLoaded)
    {
      localObject1 = null;
      localObject2 = getFilterRegex();
      if (!StringUtility.isNullOrEmpty((String)localObject2)) {
        break label38;
      }
      localObject1 = null;
    }
    for (;;)
    {
      this._regExPatternCache = ((Pattern)localObject1);
      this._isRegexLoaded = true;
      return this._regExPatternCache;
      try
      {
        label38:
        localObject2 = Pattern.compile((String)localObject2);
        localObject1 = localObject2;
      }
      catch (Exception localException)
      {
        Logger.w(Area.USAGE.value() | Area.CONFIG.value(), "UsageManager: getPackagePattern() Bad regex pattern [%1$s]", new Object[] { getFilterRegex() });
      }
    }
  }
  
  private int getRequestMaxCount()
  {
    Integer localInteger2 = GetJarConfig.getInstance(this._context).getIntegerValue("usage.request.send.max_count", Integer.valueOf(10), SettingsManager.Scope.CLIENT);
    Integer localInteger1 = localInteger2;
    if (localInteger2 == null) {
      localInteger1 = Integer.valueOf(10);
    }
    Logger.d(Area.USAGE.value() | Area.CONFIG.value(), "UsageManager getRequestMaxCount: %1$s", new Object[] { localInteger1.toString() });
    return localInteger1.intValue();
  }
  
  private boolean getRequestSendEnabled()
  {
    Boolean localBoolean2 = GetJarConfig.getInstance(this._context).getBooleanValue("usage.request.send.enabled", Boolean.valueOf(false), SettingsManager.Scope.CLIENT);
    Boolean localBoolean1 = localBoolean2;
    if (localBoolean2 == null) {
      localBoolean1 = Boolean.valueOf(false);
    }
    Logger.d(Area.USAGE.value() | Area.CONFIG.value(), "UsageManager getRequestSendEnabled: %1$s", new Object[] { localBoolean1.toString() });
    return localBoolean1.booleanValue();
  }
  
  private String getRequestSort()
  {
    String str = GetJarConfig.getInstance(this._context).getDirectiveValue("usage.request.send.sort", "duration", SettingsManager.Scope.CLIENT);
    Logger.d(Area.USAGE.value() | Area.CONFIG.value(), "UsageManager getRequestSort: %1$s", new Object[] { str });
    return str;
  }
  
  private boolean getUsageInstallBackgroundSendEnabled()
  {
    Boolean localBoolean2 = GetJarConfig.getInstance(this._context).getBooleanValue("usage.install.background.send.enabled", Boolean.valueOf(false), SettingsManager.Scope.CLIENT);
    Boolean localBoolean1 = localBoolean2;
    if (localBoolean2 == null) {
      localBoolean1 = Boolean.valueOf(false);
    }
    Logger.d(Area.USAGE.value() | Area.CONFIG.value(), "UsageManager getInstallBackgroundSendEnabled: %1$s", new Object[] { localBoolean1.toString() });
    return localBoolean1.booleanValue();
  }
  
  private boolean getUsageSessionBackgroundSendEnabled()
  {
    Boolean localBoolean2 = GetJarConfig.getInstance(this._context).getBooleanValue("usage.session.background.send.enabled", Boolean.valueOf(false), SettingsManager.Scope.CLIENT);
    Boolean localBoolean1 = localBoolean2;
    if (localBoolean2 == null) {
      localBoolean1 = Boolean.valueOf(false);
    }
    Logger.d(Area.USAGE.value() | Area.CONFIG.value(), "UsageManager getUsageBackgroundSendEnabled: %1$s", new Object[] { localBoolean1.toString() });
    return localBoolean1.booleanValue();
  }
  
  private boolean isFilterSystemEnabled()
  {
    if (this._isFilterSystemEnabled == null)
    {
      Boolean localBoolean2 = GetJarConfig.getInstance(this._context).getBooleanValue("usage.package_filter.system", Boolean.valueOf(true), SettingsManager.Scope.CLIENT);
      Boolean localBoolean1 = localBoolean2;
      if (localBoolean2 == null) {
        localBoolean1 = Boolean.valueOf(true);
      }
      this._isFilterSystemEnabled = localBoolean1;
    }
    Logger.d(Area.USAGE.value() | Area.CONFIG.value(), "UsageManager isFilterSystemEnabled: %1$b", new Object[] { this._isFilterSystemEnabled });
    return this._isFilterSystemEnabled.booleanValue();
  }
  
  protected void finalize()
    throws Throwable
  {
    GetJarConfig.getInstance(this._context).unregisterChangeListener(this._configChangedListener);
    super.finalize();
  }
  
  public AggregateUsageReport getAggregateSessionsForReporting()
  {
    if (!isRequestSendEnabled()) {
      return null;
    }
    Object localObject = getCollapsedSortedAggregateSessions();
    ArrayList localArrayList = new ArrayList();
    long l2 = System.currentTimeMillis();
    long l1 = 0L;
    localObject = ((List)localObject).iterator();
    long l3;
    long l4;
    do
    {
      AggregateUsageRecord localAggregateUsageRecord;
      do
      {
        l3 = l2;
        l4 = l1;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localAggregateUsageRecord = (AggregateUsageRecord)((Iterator)localObject).next();
        l3 = l2;
        if (localAggregateUsageRecord.getTimestampStart() < l2) {
          l3 = localAggregateUsageRecord.getTimestampStart();
        }
        l4 = l1;
        if (localAggregateUsageRecord.getTimestampStop() > l1) {
          l4 = localAggregateUsageRecord.getTimestampStop();
        }
        l2 = l3;
        l1 = l4;
      } while (shouldFilterFromUsage(localAggregateUsageRecord.getPackageName()));
      localArrayList.add(localAggregateUsageRecord);
      l2 = l3;
      l1 = l4;
    } while (localArrayList.size() < getRequestMaxCount());
    return new AggregateUsageReport(l3, l4, localArrayList);
  }
  
  public int getBackgroundBatchCount()
  {
    Integer localInteger2 = GetJarConfig.getInstance(this._context).getIntegerValue("usage.background.send.batch_count", Integer.valueOf(50), SettingsManager.Scope.CLIENT);
    Integer localInteger1 = localInteger2;
    if (localInteger2 == null) {
      localInteger1 = Integer.valueOf(50);
    }
    Logger.d(Area.USAGE.value() | Area.CONFIG.value(), "UsageManager getBackgroundBatchCount: %1$s", new Object[] { localInteger1.toString() });
    return localInteger1.intValue();
  }
  
  public int getBackgroundSendIntervalMilliseconds()
  {
    Integer localInteger2 = GetJarConfig.getInstance(this._context).getIntegerValue("usage.background.send.interval", Integer.valueOf(7200), SettingsManager.Scope.CLIENT);
    Integer localInteger1 = localInteger2;
    if (localInteger2 == null) {
      localInteger1 = Integer.valueOf(7200);
    }
    localInteger1 = Integer.valueOf(localInteger1.intValue() * 1000);
    Logger.d(Area.USAGE.value() | Area.CONFIG.value(), "UsageManager getBackgroundSendIntervalMilliseconds: %1$s", new Object[] { localInteger1.toString() });
    return localInteger1.intValue();
  }
  
  public Map<String, Long> getPackageDurationForEarning(List<EarnStateRecord> paramList, long paramLong)
  {
    Object localObject1 = UsageMonitor.getInstance(this._context).getPhoneSessionId();
    label49:
    Object localObject2;
    Object localObject3;
    if (localObject1 == null)
    {
      UsageMonitor.getInstance(this._context).ensureMonitoring();
      localObject1 = new HashMap(paramList.size());
      paramList = paramList.iterator();
      if (!paramList.hasNext()) {
        break label288;
      }
      localObject2 = ((EarnStateRecord)paramList.next()).getPackageName();
      localObject3 = (Long)this.existingDurationMap.get(localObject2);
      if (localObject3 != null) {
        break label279;
      }
    }
    label279:
    for (paramLong = 0L;; paramLong = ((Long)localObject3).longValue())
    {
      ((Map)localObject1).put(localObject2, Long.valueOf(Long.valueOf(paramLong).longValue() + UsageMonitor.getInstance(this._context).getAppDuration((String)localObject2)));
      break label49;
      if ((this.lastKnownPhoneSessionId != null) && (((String)localObject1).equals(this.lastKnownPhoneSessionId))) {
        break;
      }
      this.existingDurationMap.clear();
      long l1 = System.currentTimeMillis();
      localObject2 = paramList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (EarnStateRecord)((Iterator)localObject2).next();
        String str = ((EarnStateRecord)localObject3).getPackageName();
        long l2 = ((EarnStateRecord)localObject3).getTimestampCreated();
        l2 = UsageDatabase.getInstance(this._context).getAppTotalDuration(str, l2, l1, (String)localObject1);
        this.existingDurationMap.put(str, Long.valueOf(l2));
      }
      UsageMonitor.getInstance(this._context).setMonitorIntervalInMilliseconds(paramLong);
      UsageMonitor.getInstance(this._context).setMonitorTrackingIntervalInMilliseconds(paramLong);
      this.lastKnownPhoneSessionId = ((String)localObject1);
      break;
    }
    label288:
    return (Map<String, Long>)localObject1;
  }
  
  public int getRequestTimeMilliseconds()
  {
    return getRequestTimeWindowMilliseconds() * getRequestTimeWindowCount();
  }
  
  public int getRequestTimeWindowCount()
  {
    Integer localInteger2 = GetJarConfig.getInstance(this._context).getIntegerValue("usage.request.time_window_count", Integer.valueOf(7), SettingsManager.Scope.CLIENT);
    Integer localInteger1 = localInteger2;
    if (localInteger2 == null) {
      localInteger1 = Integer.valueOf(7);
    }
    Logger.d(Area.USAGE.value() | Area.CONFIG.value(), "UsageManager getRequestTimeWindowCount: %1$s", new Object[] { localInteger1.toString() });
    return localInteger1.intValue();
  }
  
  public int getRequestTimeWindowMilliseconds()
  {
    Integer localInteger2 = GetJarConfig.getInstance(this._context).getIntegerValue("usage.request.time_window", Integer.valueOf(86400), SettingsManager.Scope.CLIENT);
    Integer localInteger1 = localInteger2;
    if (localInteger2 == null) {
      localInteger1 = Integer.valueOf(86400);
    }
    localInteger1 = Integer.valueOf(localInteger1.intValue() * 1000);
    Logger.d(Area.USAGE.value() | Area.CONFIG.value(), "UsageManager getRequestTimeWindowMilliseconds: %1$s", new Object[] { localInteger1.toString() });
    return localInteger1.intValue();
  }
  
  public boolean isMonitoringEnabled()
  {
    Boolean localBoolean2 = GetJarConfig.getInstance(this._context).getBooleanValue("usage.monitoring.enabled", Boolean.valueOf(true), SettingsManager.Scope.CLIENT);
    Boolean localBoolean1 = localBoolean2;
    if (localBoolean2 == null) {
      localBoolean1 = Boolean.valueOf(true);
    }
    Logger.d(Area.USAGE.value() | Area.CONFIG.value(), "UsageManager isMonitoringEnabled: %1$s", new Object[] { localBoolean1.toString() });
    return localBoolean1.booleanValue();
  }
  
  public boolean isRequestSendEnabled()
  {
    return (getRequestSendEnabled()) && (isMonitoringEnabled());
  }
  
  public boolean isUsageInstallBackgroundSendEnabled()
  {
    return getUsageInstallBackgroundSendEnabled();
  }
  
  public boolean isUsageSessionBackgroundSendEnabled()
  {
    return (getUsageSessionBackgroundSendEnabled()) && (isMonitoringEnabled());
  }
  
  public boolean shouldFilterFromUsage(String paramString)
  {
    Pattern localPattern = getPackagePattern();
    if ((localPattern != null) && (localPattern.matcher(paramString).matches())) {}
    for (;;)
    {
      return true;
      if (isFilterSystemEnabled()) {}
      try
      {
        int i = this._context.getPackageManager().getPackageInfo(paramString, 128).applicationInfo.flags;
        if ((i & 1L) == 1L) {}
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Logger.w(Area.USAGE.value(), "UsageManager: Failed to get app flags [packageName:'%1$s' error:'%2$s']", new Object[] { paramString, localException.getClass().getName() });
        }
      }
    }
    return false;
  }
  
  public boolean shouldFilterTypeFromUsage(ReportUsageData.UsageType paramUsageType)
  {
    if (paramUsageType == null) {
      throw new IllegalArgumentException("'usageType' cannot be null");
    }
    synchronized (typeFilterLock)
    {
      Object localObject2 = this._typeFilterCache;
      String str1 = getBackgroundTypeFilter();
      if ((localObject2 == null) || (!((String)localObject2).equals(str1)))
      {
        localObject2 = new HashSet();
        if (str1 != null)
        {
          String[] arrayOfString = str1.trim().split("\\|");
          int j = arrayOfString.length;
          int i = 0;
          while (i < j)
          {
            String str2 = arrayOfString[i];
            if (str2 != null) {}
            try
            {
              ((HashSet)localObject2).add(ReportUsageData.UsageType.valueOf(str2.trim()));
              i += 1;
            }
            catch (IllegalArgumentException localIllegalArgumentException)
            {
              Logger.w(Area.USAGE.value(), localIllegalArgumentException, "Illegal value [%s] for usage type filter", new Object[] { str2 });
              ((HashSet)localObject2).addAll(Arrays.asList(ReportUsageData.UsageType.values()));
            }
          }
        }
        this._typeFilterSetCache = ((HashSet)localObject2);
        this._typeFilterCache = str1;
      }
      boolean bool = false;
      if (this._typeFilterSetCache.contains(paramUsageType)) {
        bool = true;
      }
      Logger.d(Area.USAGE.value(), "UsageManager shouldFilterTypeFromUsage returning %s for %s", new Object[] { Boolean.toString(bool), paramUsageType.name() });
      return bool;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/data/usage/UsageManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */