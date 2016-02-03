package mobi.beyondpod.schedulercore;

import mobi.beyondpod.rsscore.helpers.TimeSpan;

public class SyncChangeTrackingScheduledTask
  extends ScheduledTask
{
  public static final String CHANGE_TRACKING_SYNC_TASK_ID = "BPT#SYNC_CHANGE_TRACKING";
  
  public SyncChangeTrackingScheduledTask()
  {
    super("BPT#SYNC_CHANGE_TRACKING");
    SetOperation(new OperationSyncChangeTracking());
    this.Event = new Event(null, 20, TimeSpan.fromMinutes(1.0D));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/schedulercore/SyncChangeTrackingScheduledTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */