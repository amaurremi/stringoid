package mobi.beyondpod.rsscore;

import android.content.Context;
import android.util.AttributeSet;
import mobi.beyondpod.ui.commands.CommandManager;

public class ScheduledUpdatesPreference
  extends AutoUpdatePreference
{
  public static final String PREFERENCE_KEY = "ScheduledUpdatesPreference";
  
  public ScheduledUpdatesPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void Refresh()
  {
    RefreshWhatIsScheduled();
  }
  
  protected void onClick()
  {
    CommandManager.CmdSetUpdateSchedule(null, getContext(), true);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/rsscore/ScheduledUpdatesPreference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */