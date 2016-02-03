package mobi.beyondpod.rsscore;

import android.content.Context;
import android.preference.Preference;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Toast;
import java.util.Iterator;
import java.util.List;
import mobi.beyondpod.R.string;
import mobi.beyondpod.rsscore.categories.CategoryManager;
import mobi.beyondpod.rsscore.categories.FeedCategory;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.helpers.StringUtils;
import mobi.beyondpod.schedulercore.OperationUpdateCategory;
import mobi.beyondpod.schedulercore.ScheduledTask;
import mobi.beyondpod.schedulercore.ScheduledTasksManager;

public class AutoUpdatePreference
  extends Preference
{
  private static final String THERE_ARE_NO_SCHEDULED_UPDATES = CoreHelper.LoadResourceString(R.string.there_are_no_scheduled_updates);
  private static final String UPDATES_ARE_SCHEDULED_FOR_CATEGORIES = CoreHelper.LoadResourceString(R.string.updates_are_scheduled_for_categories);
  
  public AutoUpdatePreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    RefreshWhatIsScheduled();
  }
  
  protected void RefreshWhatIsScheduled()
  {
    Object localObject1 = "";
    Iterator localIterator = ScheduledTasksManager.ActiveTasks().iterator();
    for (;;)
    {
      if (!localIterator.hasNext())
      {
        if (!StringUtils.IsNullOrEmpty((String)localObject1)) {
          break;
        }
        setSummary(THERE_ARE_NO_SCHEDULED_UPDATES);
        return;
      }
      Object localObject3 = ((ScheduledTask)localIterator.next()).Operation();
      if ((localObject3 != null) && ((localObject3 instanceof OperationUpdateCategory)))
      {
        Object localObject2 = localObject1;
        if (((String)localObject1).length() > 0) {
          localObject2 = localObject1 + ", ";
        }
        localObject3 = CategoryManager.GetCategoryByValue(((OperationUpdateCategory)localObject3).getCategoryToUpdate());
        localObject1 = localObject2;
        if (localObject3 != null) {
          localObject1 = localObject2 + ((FeedCategory)localObject3).Name();
        }
      }
    }
    setSummary(UPDATES_ARE_SCHEDULED_FOR_CATEGORIES + ": " + ((String)localObject1).trim());
  }
  
  protected void onBindView(View paramView)
  {
    RefreshWhatIsScheduled();
    super.onBindView(paramView);
  }
  
  protected void onClick()
  {
    Toast.makeText(getContext(), R.string.settings_automaticUpdates_notification, 1).show();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/rsscore/AutoUpdatePreference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */