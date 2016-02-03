package mobi.beyondpod.sync;

import java.util.Date;
import mobi.beyondpod.BeyondPodApplication;
import mobi.beyondpod.R.string;
import mobi.beyondpod.rsscore.helpers.AnalyticsTracker;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.helpers.CoreHelper.DeviceNetworkConnection;

public class ChangeSyncManager
{
  private static final String APPLYING_REMOTE_CHANGES = CoreHelper.LoadResourceString(R.string.cds_notification_applying_remote_changes);
  private static final String CHECKING_FOR_REMOTE_CHANGES = CoreHelper.LoadResourceString(R.string.cds_notification_checking_for_remote_changes);
  private static final String PUBLISHING_LOCAL_CHANGES = CoreHelper.LoadResourceString(R.string.cds_notification_publishing_local_changes);
  private static final String SYNCING_LOCAL_CHANGES = CoreHelper.LoadResourceString(R.string.cds_notification_syncing_local_changes);
  private static final String TAG = ChangeSyncManager.class.getSimpleName();
  static SyncWorker _Syncer = null;
  
  public static boolean IsSyncing()
  {
    return (_Syncer != null) && (_Syncer.IsWorking());
  }
  
  public static void StopSyncing()
  {
    if (IsSyncing()) {
      _Syncer.Stop();
    }
  }
  
  public static boolean SyncChanges(ChangeSyncStatusResult paramChangeSyncStatusResult)
    throws Exception
  {
    TrackedChangeBase.LogSyncEvent(TAG, "", null);
    TrackedChangeBase.LogSyncEvent(TAG, "--- Starting Episode Sync: " + new Date() + " ---", null);
    if (!ChangeTracker.IsTrackingEnabled())
    {
      CoreHelper.WriteTraceEntry(TAG, "--- Episode Sync is disabled! Exiting...");
      if (paramChangeSyncStatusResult != null) {
        paramChangeSyncStatusResult.SyncCompleted(false);
      }
    }
    do
    {
      do
      {
        do
        {
          return false;
          if (CoreHelper.GetDeviceNetworkConnection().IsConnectedToNetwork()) {
            break;
          }
          TrackedChangeBase.LogSyncEvent(TAG, "--- Device is offline! Sync cancelled ---", null);
        } while (paramChangeSyncStatusResult == null);
        paramChangeSyncStatusResult.SyncCompleted(false);
        return false;
        if (_Syncer == null) {
          break;
        }
        TrackedChangeBase.LogSyncEvent(TAG, "--- Another Episode Sync is already in progress! Exiting...", null);
      } while (paramChangeSyncStatusResult == null);
      paramChangeSyncStatusResult.SyncCompleted(false);
      return false;
      AnalyticsTracker.OnChangeSync(0);
      _Syncer = new SyncWorker(new SyncWorker.QueueListener()
      {
        public void OnQueueCompleted(boolean paramAnonymousBoolean)
        {
          BeyondPodApplication.GetInstance().ClearChangeSyncNotification();
          ChangeSyncManager._Syncer = null;
          TrackedChangeBase.LogSyncEvent(ChangeSyncManager.TAG, "--- Episode Sync completed: " + new Date() + " ---", null);
          if (ChangeSyncManager.this != null) {
            ChangeSyncManager.this.SyncCompleted(paramAnonymousBoolean);
          }
        }
        
        public void OnQueueProgress(int paramAnonymousInt)
        {
          switch (paramAnonymousInt)
          {
          default: 
            return;
          case 0: 
            BeyondPodApplication.GetInstance().SetChangeSyncNotification(ChangeSyncManager.SYNCING_LOCAL_CHANGES, ChangeSyncManager.PUBLISHING_LOCAL_CHANGES);
            return;
          case 1: 
            BeyondPodApplication.GetInstance().SetChangeSyncNotification(ChangeSyncManager.SYNCING_LOCAL_CHANGES, ChangeSyncManager.CHECKING_FOR_REMOTE_CHANGES);
            return;
          }
          BeyondPodApplication.GetInstance().SetChangeSyncNotification(ChangeSyncManager.SYNCING_LOCAL_CHANGES, ChangeSyncManager.APPLYING_REMOTE_CHANGES);
        }
        
        public void OnQueueStarted()
        {
          BeyondPodApplication.GetInstance().SetChangeSyncNotification(ChangeSyncManager.SYNCING_LOCAL_CHANGES, "");
        }
      });
      try
      {
        _Syncer.ExecuteQueuedRequests();
        return true;
      }
      catch (Exception localException)
      {
        TrackedChangeBase.LogSyncEvent(TAG, "--- Unable to start sync! Reason: " + localException.getMessage(), null);
      }
    } while (paramChangeSyncStatusResult == null);
    paramChangeSyncStatusResult.SyncCompleted(false);
    return false;
  }
  
  public static abstract interface ChangeSyncStatusResult
  {
    public abstract void SyncCompleted(boolean paramBoolean);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/sync/ChangeSyncManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */