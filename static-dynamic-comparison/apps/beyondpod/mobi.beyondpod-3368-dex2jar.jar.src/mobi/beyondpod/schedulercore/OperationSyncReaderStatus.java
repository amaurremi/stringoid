package mobi.beyondpod.schedulercore;

import java.util.UUID;
import mobi.beyondpod.aggregators.AggregatorLoginHelper;
import mobi.beyondpod.aggregators.AggregatorLoginHelper.GSyncStatusResult;
import mobi.beyondpod.rsscore.helpers.CoreHelper;

public class OperationSyncReaderStatus
  extends OperationBase
{
  public static final UUID OperationID = UUID.fromString("FFAACCDD-0C02-4314-B8C4-4FEDE4C83C80");
  private static String TAG = OperationSyncReaderStatus.class.getSimpleName();
  
  OperationSyncReaderStatus()
  {
    super("BeyondPod Sync Google Reader Subscriptions", "BeyondPod Sync Google Reader Subscriptions", OperationID);
  }
  
  public OperationBase CreateInstance(String paramString)
  {
    return new OperationSyncReaderStatus();
  }
  
  public void Execute(OperationBase.OperationCompletedCallback paramOperationCompletedCallback)
  {
    super.Execute(paramOperationCompletedCallback);
    CoreHelper.WriteTraceEntry(TAG, "Starting a Scheduled Google Sync");
    if (!AggregatorLoginHelper.IsSyncing()) {
      try
      {
        AggregatorLoginHelper.SyncItemStatus(new AggregatorLoginHelper.GSyncStatusResult()
        {
          public void SyncCompleted(boolean paramAnonymousBoolean, int paramAnonymousInt1, int paramAnonymousInt2)
          {
            if (paramAnonymousInt2 >= 0) {
              ScheduledTasksManager.ScheduleGoogleSynUpdateIfNeeded();
            }
            OperationSyncReaderStatus.this.OnOperationCompleted();
          }
        });
        return;
      }
      catch (Exception paramOperationCompletedCallback)
      {
        CoreHelper.LogException(TAG, "Unable to start Google Sync", paramOperationCompletedCallback);
        OnOperationCompleted();
        return;
      }
    }
    CoreHelper.WriteLogEntry(TAG, "Another Google Sync is already in progress! Skipping sync!");
    OnOperationCompleted();
  }
  
  public String Name()
  {
    return this._Name;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/schedulercore/OperationSyncReaderStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */