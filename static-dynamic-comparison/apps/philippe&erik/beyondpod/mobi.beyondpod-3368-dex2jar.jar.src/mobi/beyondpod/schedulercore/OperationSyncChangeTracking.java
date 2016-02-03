package mobi.beyondpod.schedulercore;

import java.util.UUID;
import mobi.beyondpod.rsscore.Configuration;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.helpers.TimeSpan;
import mobi.beyondpod.sync.ChangeSyncManager;
import mobi.beyondpod.sync.ChangeSyncManager.ChangeSyncStatusResult;
import mobi.beyondpod.sync.ChangeTracker;
import mobi.beyondpod.sync.TrackedChangeBase;

public class OperationSyncChangeTracking
  extends OperationBase
{
  private static final int MAX_RETRY_INTERVAL = 120;
  public static final UUID OperationID = UUID.fromString("AABBCCDD-0C02-4314-B8C4-4FEDED56EEE0");
  private static final int RETRY_INTERVAL = 15;
  private static String TAG = OperationSyncChangeTracking.class.getSimpleName();
  
  OperationSyncChangeTracking()
  {
    super("BeyondPod Sync Change Tracking", "BeyondPod Sync Change Tracking", OperationID);
  }
  
  public OperationBase CreateInstance(String paramString)
  {
    return new OperationSyncChangeTracking();
  }
  
  public void Execute(OperationBase.OperationCompletedCallback paramOperationCompletedCallback)
  {
    super.Execute(paramOperationCompletedCallback);
    CoreHelper.WriteTraceEntry(TAG, "Starting a Change Tracking Sync");
    if (!ChangeSyncManager.IsSyncing()) {
      try
      {
        ChangeSyncManager.SyncChanges(new ChangeSyncManager.ChangeSyncStatusResult()
        {
          public void SyncCompleted(boolean paramAnonymousBoolean)
          {
            int i;
            if (ChangeTracker.IsTrackingEnabled())
            {
              if (!ChangeTracker.HasUploadPendingChanges()) {
                break label98;
              }
              i = Configuration.CDSSyncRetryInterval();
              if (i >= 120) {
                break label86;
              }
              if (i != 0) {
                break label79;
              }
              i = 15;
              Configuration.setCDSSyncRetryInterval(i);
              TrackedChangeBase.LogSyncEvent(OperationSyncChangeTracking.TAG, "#### There are still pending changes! Retrying sync in " + i + " min", null);
              ScheduledTasksManager.ScheduleSyncTaskIfSyncIsEnabled(i, TimeSpan.fromMinutes(1.0D), false);
            }
            for (;;)
            {
              OperationSyncChangeTracking.this.OnOperationCompleted();
              return;
              label79:
              i *= 2;
              break;
              label86:
              TrackedChangeBase.LogSyncEvent(OperationSyncChangeTracking.TAG, "#### There are still pending changes, but we reached the max retry interval of 120 min. Giving up!", null);
              continue;
              label98:
              Configuration.setCDSSyncRetryInterval(0);
            }
          }
        });
        return;
      }
      catch (Exception paramOperationCompletedCallback)
      {
        CoreHelper.LogException(TAG, "Unable to start Change Sync", paramOperationCompletedCallback);
        OnOperationCompleted();
        return;
      }
    }
    CoreHelper.WriteLogEntry(TAG, "Another Change Sync is already in progress! Skipping sync!");
    OnOperationCompleted();
  }
  
  public String Name()
  {
    return this._Name;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/schedulercore/OperationSyncChangeTracking.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */