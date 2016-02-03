package mobi.beyondpod.schedulercore;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import mobi.beyondpod.rsscore.categories.CategoryManager;
import mobi.beyondpod.rsscore.categories.FeedCategory;

public class ScheduleUtils
{
  private static TaskStartTimeSorter _startTimeSorter = new TaskStartTimeSorter();
  
  public static ScheduledTask GetEarliestTask(ArrayList<ScheduledTask> paramArrayList)
  {
    if (paramArrayList.size() == 0) {
      return null;
    }
    Collections.sort(paramArrayList, _startTimeSorter);
    return (ScheduledTask)paramArrayList.get(0);
  }
  
  public static ScheduledTask GetScheduledTaskForCategory(FeedCategory paramFeedCategory)
  {
    Iterator localIterator = ScheduledTasksManager.Tasks().iterator();
    ScheduledTask localScheduledTask;
    OperationBase localOperationBase;
    do
    {
      if (!localIterator.hasNext()) {
        return null;
      }
      localScheduledTask = (ScheduledTask)localIterator.next();
      localOperationBase = localScheduledTask.Operation();
    } while ((!(localOperationBase instanceof OperationUpdateCategory)) || (!paramFeedCategory.Value().equals(((OperationUpdateCategory)localOperationBase).getCategoryToUpdate())));
    return localScheduledTask;
  }
  
  public static boolean IsSingleSchedule()
  {
    boolean bool = true;
    ScheduledTask localScheduledTask = GetScheduledTaskForCategory(CategoryManager.AllFeeds);
    if ((localScheduledTask == null) || (!localScheduledTask.Active)) {
      bool = false;
    }
    while (ScheduledTasksManager.ActiveTaskCount() == 1) {
      return bool;
    }
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/schedulercore/ScheduleUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */