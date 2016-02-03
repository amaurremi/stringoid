package mobi.beyondpod.schedulercore;

import java.util.Comparator;

public class TaskStartTimeSorter
  implements Comparator<ScheduledTask>
{
  public int compare(ScheduledTask paramScheduledTask1, ScheduledTask paramScheduledTask2)
  {
    if (paramScheduledTask1.equals(paramScheduledTask2)) {
      return 0;
    }
    return ScheduledTask.Compare(paramScheduledTask1, paramScheduledTask2);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/schedulercore/TaskStartTimeSorter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */