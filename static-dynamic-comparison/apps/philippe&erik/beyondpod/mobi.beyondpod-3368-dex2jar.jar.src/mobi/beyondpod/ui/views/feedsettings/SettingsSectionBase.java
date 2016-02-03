package mobi.beyondpod.ui.views.feedsettings;

import android.view.View;
import android.view.ViewStub;
import android.view.Window;
import mobi.beyondpod.rsscore.Feed;

public abstract class SettingsSectionBase
{
  protected View _InflatedContent;
  protected boolean _IsDataLoaded;
  protected FeedPropertiesView _Owner;
  protected int _StubId;
  
  SettingsSectionBase(FeedPropertiesView paramFeedPropertiesView)
  {
    this._Owner = paramFeedPropertiesView;
  }
  
  abstract boolean HasFeedAddressChanged();
  
  public void Hide()
  {
    if (this._InflatedContent != null) {
      this._InflatedContent.setVisibility(8);
    }
  }
  
  protected abstract void Initialize();
  
  public boolean IsDataLoaded()
  {
    return this._IsDataLoaded;
  }
  
  public abstract boolean IsURLFeed();
  
  public boolean IsVisible()
  {
    return (this._InflatedContent != null) && (this._InflatedContent.getVisibility() == 0);
  }
  
  public void LoadFromFeed(Feed paramFeed)
  {
    this._IsDataLoaded = true;
  }
  
  abstract void PatchFeedUrl(String paramString);
  
  abstract void Refresh(Feed paramFeed);
  
  public abstract void SaveToFeed(Feed paramFeed);
  
  public void Show()
  {
    if (this._InflatedContent != null) {
      this._InflatedContent.setVisibility(0);
    }
    ViewStub localViewStub;
    do
    {
      return;
      localViewStub = (ViewStub)this._Owner.findViewById(this._StubId);
    } while (localViewStub == null);
    this._InflatedContent = localViewStub.inflate();
    Initialize();
    this._Owner.getWindow().setSoftInputMode(3);
  }
  
  public abstract boolean ValidateControls(Feed paramFeed);
  
  public void focusControl(int paramInt)
  {
    View localView = this._Owner.findViewById(paramInt);
    if (localView != null) {
      localView.requestFocus();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/views/feedsettings/SettingsSectionBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */