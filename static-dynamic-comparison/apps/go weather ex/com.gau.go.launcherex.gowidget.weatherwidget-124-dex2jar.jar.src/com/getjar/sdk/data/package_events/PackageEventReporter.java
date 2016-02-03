package com.getjar.sdk.data.package_events;

import com.getjar.sdk.comm.CommContext;
import com.getjar.sdk.comm.Operation;
import com.getjar.sdk.data.DatabaseRecordBase;
import com.getjar.sdk.data.RecordSyncedListener;
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

class PackageEventReporter
  extends ReportUsageReporter
{
  private static volatile PackageEventReporter _Instance = null;
  
  private PackageEventReporter(CommContext paramCommContext)
  {
    super(paramCommContext);
  }
  
  public static PackageEventReporter getInstance(CommContext paramCommContext)
  {
    if (paramCommContext == null) {
      try
      {
        throw new IllegalArgumentException("'commContext' cannot be NULL");
      }
      finally {}
    }
    if (_Instance == null) {
      _Instance = new PackageEventReporter(paramCommContext);
    }
    paramCommContext = _Instance;
    return paramCommContext;
  }
  
  protected boolean handleResults(RecordSyncedListener paramRecordSyncedListener, Operation paramOperation, List<ReportUsageData> paramList, HashMap<ReportUsageData, ? extends DatabaseRecordBase> paramHashMap)
  {
    boolean bool = super.handleResults(paramRecordSyncedListener, paramOperation, paramList, paramHashMap);
    paramRecordSyncedListener.purgeSyncedRecords();
    return bool;
  }
  
  protected void sendUnsyncedData()
  {
    List localList = PackageEventDatabase.getInstance().loadUnsyncedRecords();
    HashMap localHashMap1 = new HashMap();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = localList.iterator();
    PackageEventRecord localPackageEventRecord;
    if (localIterator.hasNext()) {
      localPackageEventRecord = (PackageEventRecord)localIterator.next();
    }
    for (;;)
    {
      try
      {
        switch (localPackageEventRecord.getEventType())
        {
        case ???: 
          throw new IllegalStateException(String.format(Locale.US, "Unrecognized EventType [%1$s]", new Object[] { localPackageEventRecord.getEventType().name() }));
        }
      }
      catch (Exception localException1)
      {
        Logger.e(Area.USAGE.value(), localException1, "Bad database record loaded", new Object[0]);
        try
        {
          PackageEventDatabase.getInstance().deleteRecord(localPackageEventRecord.getId());
        }
        catch (Exception localException2)
        {
          Logger.e(Area.USAGE.value(), localException2, "deleteRecord failed", new Object[0]);
        }
      }
      break;
      for (Object localObject = ReportUsageData.UsageType.INSTALLED;; localObject = ReportUsageData.UsageType.UNINSTALLED)
      {
        HashMap localHashMap2 = new HashMap();
        localHashMap2.put("business.event.timestamp", Utility.epochToISO8601(localPackageEventRecord.getTimestamp()));
        localHashMap2.put("business.event.type", ((ReportUsageData.UsageType)localObject).name());
        HashMap localHashMap3 = new HashMap();
        int i = RewardUtility.prepAppDataForReportUsage(localPackageEventRecord.getPackageName(), (ReportUsageData.UsageType)localObject, this._commContext.getApplicationContext(), localHashMap3);
        localObject = new ReportUsageData(localPackageEventRecord.getPackageName(), (ReportUsageData.UsageType)localObject, localHashMap2, localHashMap3, i);
        localHashMap1.put(localObject, localPackageEventRecord);
        localArrayList.add(localObject);
        break;
      }
      if (localArrayList.size() > 0) {
        reportUsageInChunks(UsageManager.getInstance(this._commContext.getApplicationContext()).getBackgroundBatchCount(), PackageEventDatabase.getInstance(), localArrayList, localHashMap1);
      }
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/data/package_events/PackageEventReporter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */