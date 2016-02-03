package mobi.beyondpod.schedulercore;

import mobi.beyondpod.rsscore.helpers.TimeSpan;

public class SyncGoogleReaderScheduledTask
  extends ScheduledTask
{
  public static final String GOOGLE_SYNC_TASK_ID = "BPT#SYNC_GOOGLE_READER";
  
  public SyncGoogleReaderScheduledTask()
  {
    super("BPT#SYNC_GOOGLE_READER");
    SetOperation(new OperationSyncReaderStatus());
    this.Event = new Event(null, 15, TimeSpan.fromMinutes(1.0D));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/schedulercore/SyncGoogleReaderScheduledTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */