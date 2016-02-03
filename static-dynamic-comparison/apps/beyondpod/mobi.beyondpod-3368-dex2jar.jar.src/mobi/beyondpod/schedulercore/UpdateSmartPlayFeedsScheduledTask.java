package mobi.beyondpod.schedulercore;

import mobi.beyondpod.rsscore.helpers.TimeSpan;

public class UpdateSmartPlayFeedsScheduledTask
  extends ScheduledTask
{
  public static final String UPDATE_SMARTPLAY_FEEDS_TASK_ID = "BPT#UPDATE_SMARTPLAY_FEEDS";
  
  public UpdateSmartPlayFeedsScheduledTask()
  {
    super("BPT#UPDATE_SMARTPLAY_FEEDS");
    SetOperation(new OperationUpdateSmartplayFeeds());
    this.Event = new Event(null, 15, TimeSpan.fromMinutes(1.0D));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/schedulercore/UpdateSmartPlayFeedsScheduledTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */