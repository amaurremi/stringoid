package com.getjar.sdk.data;

import com.getjar.sdk.comm.CommContext;
import com.getjar.sdk.comm.Operation;
import com.getjar.sdk.comm.ReportUsageProxy;
import com.getjar.sdk.comm.Result;
import com.getjar.sdk.exceptions.CommunicationException;
import com.getjar.sdk.logging.Area;
import com.getjar.sdk.logging.Logger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;

public abstract class ReportUsageReporter
{
  protected final CommContext _commContext;
  
  protected ReportUsageReporter(CommContext paramCommContext)
  {
    if (paramCommContext == null) {
      throw new IllegalArgumentException("'commContext' cannot be NULL");
    }
    this._commContext = paramCommContext;
  }
  
  protected boolean handleResults(RecordSyncedListener paramRecordSyncedListener, Operation paramOperation, List<ReportUsageData> paramList, HashMap<ReportUsageData, ? extends DatabaseRecordBase> paramHashMap)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramOperation == null) {
      bool1 = true;
    }
    while ((bool1) && (paramRecordSyncedListener != null))
    {
      paramOperation = paramList.iterator();
      for (;;)
      {
        if (paramOperation.hasNext())
        {
          paramList = (ReportUsageData)paramOperation.next();
          try
          {
            paramList = (DatabaseRecordBase)paramHashMap.get(paramList);
            paramRecordSyncedListener.onRecordSynced(paramList.getId());
            Logger.v(Area.USAGE.value() | Area.STORAGE.value(), "Usage: InstallStateReporter: handleResults() Updated record as synced [id:%1$d]", new Object[] { Long.valueOf(paramList.getId()) });
          }
          catch (Exception paramList)
          {
            Logger.e(Area.USAGE.value() | Area.STORAGE.value(), paramList, "Usage: InstallStateReporter: handleResults() Failed", new Object[0]);
          }
          continue;
          try
          {
            paramOperation = paramOperation.get();
            bool1 = bool2;
            if (paramOperation == null) {
              break;
            }
            boolean bool3 = paramOperation.isSuccessfulResponse();
            bool1 = bool2;
            if (!bool3) {
              break;
            }
            bool1 = true;
          }
          catch (InterruptedException paramRecordSyncedListener)
          {
            throw new CommunicationException(paramRecordSyncedListener);
          }
          catch (ExecutionException paramRecordSyncedListener)
          {
            throw new CommunicationException(paramRecordSyncedListener);
          }
        }
      }
    }
    return bool1;
  }
  
  protected boolean reportUsageInChunks(int paramInt, RecordSyncedListener paramRecordSyncedListener, List<ReportUsageData> paramList, HashMap<ReportUsageData, ? extends DatabaseRecordBase> paramHashMap)
  {
    Logger.d(Area.USAGE.value(), "Usage: UsageReporter: reportUsageInChunks() START", new Object[0]);
    ArrayList localArrayList = new ArrayList(paramList.size());
    int i = 0;
    while (i < paramList.size())
    {
      localArrayList.add(paramList.get(i));
      if (localArrayList.size() >= paramInt)
      {
        Logger.d(Area.USAGE.value(), "Usage: UsageReporter: reportUsageInChunks() Calling reportApplicationUsage for %1$d records", new Object[] { Integer.valueOf(localArrayList.size()) });
        handleResults(paramRecordSyncedListener, ReportUsageProxy.getInstance().reportApplicationUsage(this._commContext, localArrayList), localArrayList, paramHashMap);
        localArrayList.clear();
      }
      i += 1;
    }
    boolean bool = true;
    if (localArrayList.size() > 0)
    {
      Logger.d(Area.USAGE.value(), "Usage: UsageReporter: reportUsageInChunks() Calling reportApplicationUsage for %1$d records", new Object[] { Integer.valueOf(localArrayList.size()) });
      bool = true & handleResults(paramRecordSyncedListener, ReportUsageProxy.getInstance().reportApplicationUsage(this._commContext, localArrayList), localArrayList, paramHashMap);
      localArrayList.clear();
    }
    Logger.d(Area.USAGE.value(), "Usage: UsageReporter: reportUsageInChunks() -- DONE", new Object[0]);
    return bool;
  }
  
  protected abstract void sendUnsyncedData();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/data/ReportUsageReporter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */