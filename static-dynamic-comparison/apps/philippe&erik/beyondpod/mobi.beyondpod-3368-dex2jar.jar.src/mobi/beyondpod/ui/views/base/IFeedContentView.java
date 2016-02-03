package mobi.beyondpod.ui.views.base;

import android.os.Bundle;
import mobi.beyondpod.rsscore.Feed;
import mobi.beyondpod.ui.core.MasterViewState;

public abstract interface IFeedContentView
  extends IView
{
  public abstract boolean IsEmpty();
  
  public abstract boolean IsProgressEnabled();
  
  public abstract void OnActivityDestroy();
  
  public abstract void RefreshOnNextActivate();
  
  public abstract void RestoreCurrentState(MasterViewState paramMasterViewState);
  
  public abstract void RestoreFeedContentState(Bundle paramBundle);
  
  public abstract void SaveCurrentState(MasterViewState paramMasterViewState);
  
  public abstract void SaveFeedContentState(Bundle paramBundle);
  
  public abstract void setCurrentFeed(Feed paramFeed);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/views/base/IFeedContentView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */