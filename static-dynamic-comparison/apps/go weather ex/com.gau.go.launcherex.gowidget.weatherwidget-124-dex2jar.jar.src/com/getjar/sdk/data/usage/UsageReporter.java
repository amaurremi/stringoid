package com.getjar.sdk.data.usage;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.getjar.sdk.comm.CommContext;
import com.getjar.sdk.comm.Operation;
import com.getjar.sdk.comm.Result;
import com.getjar.sdk.data.DatabaseRecordBase;
import com.getjar.sdk.data.RecordSyncedListener;
import com.getjar.sdk.data.ReportUsageData;
import com.getjar.sdk.data.ReportUsageData.UsageType;
import com.getjar.sdk.data.ReportUsageReporter;
import com.getjar.sdk.exceptions.CommunicationException;
import com.getjar.sdk.logging.Area;
import com.getjar.sdk.logging.Logger;
import com.getjar.sdk.utilities.RewardUtility;
import com.getjar.sdk.utilities.Utility;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ExecutionException;

public class UsageReporter
  extends ReportUsageReporter
{
  private static volatile UsageReporter _Instance = null;
  private static final String _LAST_SEND_TIME_FILE = "lastUsageSendFile";
  private static final String _LAST_SEND_TIME_KEY = "lastUsageSendTime";
  private final Object _sendDataLock = new Object();
  
  private UsageReporter(CommContext paramCommContext)
  {
    super(paramCommContext);
  }
  
  public static UsageReporter getInstance(CommContext paramCommContext)
  {
    if (paramCommContext == null) {
      try
      {
        throw new IllegalArgumentException("'commContext' cannot be NULL");
      }
      finally {}
    }
    if (_Instance == null) {
      _Instance = new UsageReporter(paramCommContext);
    }
    paramCommContext = _Instance;
    return paramCommContext;
  }
  
  private void updateLastSend(long paramLong)
  {
    try
    {
      SharedPreferences.Editor localEditor = this._commContext.getApplicationContext().getSharedPreferences("lastUsageSendFile", 0).edit();
      localEditor.putLong("lastUsageSendTime", paramLong).commit();
      localEditor.commit();
      Logger.v(Area.USAGE.value(), "UsageReporter: updateLastSend() updated", new Object[0]);
      return;
    }
    catch (Exception localException)
    {
      Logger.e(Area.USAGE.value(), localException, "UsageReporter: updateLastSend() failed", new Object[0]);
    }
  }
  
  protected boolean handleResults(RecordSyncedListener paramRecordSyncedListener, Operation paramOperation, List<ReportUsageData> paramList, HashMap<ReportUsageData, ? extends DatabaseRecordBase> paramHashMap)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramOperation == null) {
      bool1 = true;
    }
    for (;;)
    {
      paramRecordSyncedListener = UsageDatabase.getInstance(this._commContext.getApplicationContext());
      if (!bool1) {
        break label209;
      }
      paramOperation = paramList.iterator();
      for (;;)
      {
        if (!paramOperation.hasNext()) {
          break label209;
        }
        paramList = (ReportUsageData)paramOperation.next();
        try
        {
          paramList = (DatabaseRecordBase)paramHashMap.get(paramList);
          if (!(paramList instanceof ApplicationSessionEvent)) {
            break;
          }
          paramRecordSyncedListener.appSessionSetAsSynced(paramList.getId());
          Logger.v(Area.USAGE.value(), "Usage: UsageReporter: handleResults() Updated application session record as synced [id:%1$d]", new Object[] { Long.valueOf(paramList.getId()) });
        }
        catch (Exception paramList)
        {
          Logger.e(Area.USAGE.value(), paramList, "Usage: UsageReporter: handleResults() Failed to find a Session for an App Usage", new Object[0]);
        }
      }
      try
      {
        paramRecordSyncedListener = paramOperation.get();
        bool1 = bool2;
        if (paramRecordSyncedListener != null)
        {
          boolean bool3 = paramRecordSyncedListener.isSuccessfulResponse();
          bool1 = bool2;
          if (bool3) {
            bool1 = true;
          }
        }
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
    throw new IllegalStateException(String.format(Locale.US, "Usage: UsageReporter: handleResults() Unrecognized session event type [%1$s]", new Object[] { paramList.getClass().getName() }));
    label209:
    return bool1;
  }
  
  public void sendUnsyncedData()
  {
    synchronized (this._sendDataLock)
    {
      long l1 = System.currentTimeMillis();
      try
      {
        long l2 = this._commContext.getApplicationContext().getSharedPreferences("lastUsageSendFile", 0).getLong("lastUsageSendTime", 0L);
        long l3 = UsageManager.getInstance(this._commContext.getApplicationContext()).getBackgroundSendIntervalMilliseconds();
        if (l1 - l2 < l3)
        {
          Logger.v(Area.USAGE.value(), "UsageReporter: Exiting sendUnsyncedData bacause last send occured less than '%1$d' seconds ago.", new Object[] { Long.valueOf(l3 / 1000L) });
          return;
        }
      }
      catch (Exception localException1)
      {
        Logger.e(Area.USAGE.value(), localException1, "UsageReporter: SharedPreferences read failed", new Object[0]);
        UsageDatabase localUsageDatabase = UsageDatabase.getInstance(this._commContext.getApplicationContext());
        Object localObject3 = localUsageDatabase.appSessionLoadUnsynced();
        HashMap localHashMap1 = new HashMap();
        ArrayList localArrayList = new ArrayList();
        localObject3 = ((List)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          ApplicationSessionEvent localApplicationSessionEvent = (ApplicationSessionEvent)((Iterator)localObject3).next();
          try
          {
            Object localObject4 = ReportUsageData.UsageType.APP_SESSION;
            HashMap localHashMap2 = new HashMap();
            localHashMap2.put("business.event.phone.session_id", localApplicationSessionEvent.getSessionId());
            localHashMap2.put("business.event.app.session_id", UsageDatabase.getNewApplicationSessionID());
            localHashMap2.put("business.event.timestamp", Utility.epochToISO8601(localApplicationSessionEvent.getTimestamp()));
            localHashMap2.put("business.event.duration", String.valueOf(localApplicationSessionEvent.getDuration()));
            localHashMap2.put("business.event.type", ((ReportUsageData.UsageType)localObject4).name());
            localHashMap2.put("business.event.reason", localApplicationSessionEvent.getReason());
            HashMap localHashMap3 = new HashMap();
            int i = RewardUtility.prepAppDataForReportUsage(localApplicationSessionEvent.getPackageName(), (ReportUsageData.UsageType)localObject4, this._commContext.getApplicationContext(), localHashMap3);
            localObject4 = new ReportUsageData(localApplicationSessionEvent.getPackageName(), (ReportUsageData.UsageType)localObject4, localHashMap2, localHashMap3, i);
            localHashMap1.put(localObject4, localApplicationSessionEvent);
            localArrayList.add(localObject4);
          }
          catch (Exception localException3)
          {
            Logger.e(Area.USAGE.value(), localException3, "Bad application session record loaded", new Object[0]);
            try
            {
              localUsageDatabase.deleteAppSession(localApplicationSessionEvent.getId());
            }
            catch (Exception localException2) {}
          }
        }
        boolean bool = false;
        if (localArrayList.size() > 0) {
          bool = reportUsageInChunks(UsageManager.getInstance(this._commContext.getApplicationContext()).getBackgroundBatchCount(), null, localArrayList, localHashMap1);
        }
        if (bool) {
          updateLastSend(l1);
        }
        return;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/data/usage/UsageReporter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */