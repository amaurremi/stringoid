package com.getjar.sdk.data.install_state;

import com.getjar.sdk.comm.CommContext;
import com.getjar.sdk.data.ReportUsageData;
import com.getjar.sdk.data.ReportUsageData.UsageType;
import com.getjar.sdk.data.ReportUsageReporter;
import com.getjar.sdk.data.usage.UsageManager;
import com.getjar.sdk.logging.Area;
import com.getjar.sdk.logging.Logger;
import com.getjar.sdk.utilities.RewardUtility;
import com.getjar.sdk.utilities.Utility;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

class InstallStateReporter
  extends ReportUsageReporter
{
  private static volatile InstallStateReporter _Instance = null;
  private CommContext commContext;
  
  private InstallStateReporter(CommContext paramCommContext)
  {
    super(paramCommContext);
    this.commContext = paramCommContext;
  }
  
  public static InstallStateReporter getInstance(CommContext paramCommContext)
  {
    if (paramCommContext == null) {
      try
      {
        throw new IllegalArgumentException("'commContext' cannot be NULL");
      }
      finally {}
    }
    if (_Instance == null) {
      _Instance = new InstallStateReporter(paramCommContext);
    }
    paramCommContext = _Instance;
    return paramCommContext;
  }
  
  protected void sendUnsyncedData()
  {
    Object localObject = UnsyncedInstallStateDatabase.getInstance().loadAllRecords();
    HashMap localHashMap1 = new HashMap();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = ((List)localObject).iterator();
    if (localIterator.hasNext())
    {
      InstallStateRecord localInstallStateRecord = (InstallStateRecord)localIterator.next();
      for (;;)
      {
        try
        {
          if (!InstallStateManager.InstallState.FOUND_INSTALLED.equals(localInstallStateRecord.getStatus())) {
            break label227;
          }
          localObject = ReportUsageData.UsageType.FOUND_INSTALLED;
          HashMap localHashMap2 = new HashMap();
          localHashMap2.put("business.event.timestamp", Utility.epochToISO8601(localInstallStateRecord.getTimestamp()));
          localHashMap2.put("business.event.type", ((ReportUsageData.UsageType)localObject).name());
          HashMap localHashMap3 = new HashMap();
          int i = RewardUtility.prepAppDataForReportUsage(localInstallStateRecord.getPackageName(), (ReportUsageData.UsageType)localObject, this._commContext.getApplicationContext(), localHashMap3);
          localObject = new ReportUsageData(localInstallStateRecord.getPackageName(), (ReportUsageData.UsageType)localObject, localHashMap2, localHashMap3, i);
          localHashMap1.put(localObject, localInstallStateRecord);
          localArrayList.add(localObject);
        }
        catch (Exception localException1)
        {
          Logger.e(Area.USAGE.value(), localException1, "Bad database record loaded", new Object[0]);
          try
          {
            UnsyncedInstallStateDatabase.getInstance().deleteRecord(localInstallStateRecord.getId());
          }
          catch (Exception localException2)
          {
            Logger.e(Area.USAGE.value(), localException2, "deleteRecord failed", new Object[0]);
          }
        }
        break;
        label227:
        if (!InstallStateManager.InstallState.FOUND_UNINSTALLED.equals(localInstallStateRecord.getStatus())) {
          break label248;
        }
        ReportUsageData.UsageType localUsageType = ReportUsageData.UsageType.FOUND_UNINSTALLED;
      }
      label248:
      throw new IllegalStateException(String.format(Locale.US, "Unrecognized InstallStateRecord state [%1$s]", new Object[] { localInstallStateRecord.getStatus().name() }));
    }
    if (localArrayList.size() > 0) {
      reportUsageInChunks(UsageManager.getInstance(this._commContext.getApplicationContext()).getBackgroundBatchCount(), InstallStateManager.getInstance(this.commContext.getApplicationContext()), localArrayList, localHashMap1);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/data/install_state/InstallStateReporter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */