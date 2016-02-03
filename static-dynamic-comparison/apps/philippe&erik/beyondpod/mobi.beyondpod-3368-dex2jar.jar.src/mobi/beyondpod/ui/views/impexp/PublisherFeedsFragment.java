package mobi.beyondpod.ui.views.impexp;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import com.android.volley.Response.ErrorListener;
import mobi.beyondpod.rsscore.helpers.StringUtils;

public class PublisherFeedsFragment
  extends FeedSearchResultFragment
{
  private static final String PUBLISHER_NAME_TAG = "PUBLISHER_NAME";
  protected static final String PUBLISHER_TAG = "#PUBLISHER:#";
  String _PublisherName;
  
  protected View BuildContents(LayoutInflater paramLayoutInflater, Bundle paramBundle)
  {
    if (paramBundle != null) {
      this._PublisherName = paramBundle.getString("PUBLISHER_NAME");
    }
    return super.BuildContents(paramLayoutInflater, paramBundle);
  }
  
  public void LoadPublisherFeeds(String paramString1, String paramString2)
  {
    if (StringUtils.IsNullOrEmpty(paramString2)) {
      return;
    }
    this._PublisherName = paramString1;
    DoSearch("#PUBLISHER:#" + paramString2);
  }
  
  protected void callSearch(String paramString, int paramInt, SearchResultFragmentBase.SearchSuccessListener paramSearchSuccessListener, Response.ErrorListener paramErrorListener)
    throws FeedSearchService.ServiceException
  {
    this._FeedSearchService.getPublisherFeeds(paramString.replace("#PUBLISHER:#", ""), this._FilterTag, paramInt, this.PAGE_SIZE, paramSearchSuccessListener, paramErrorListener);
  }
  
  CharSequence getEmptyText()
  {
    return getResources().getString(2131297254, new Object[] { this._PublisherName }) + BuildFilterForEmptyText();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    setHasOptionsMenu(true);
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if (paramBundle == null) {
      LoadPublisherFeeds(getArguments().getString("publisherName"), getArguments().getString("publisherId"));
    }
    return paramLayoutInflater;
  }
  
  public void onPrepareOptionsMenu(Menu paramMenu)
  {
    MenuItem localMenuItem = paramMenu.findItem(2131231230);
    if (localMenuItem != null)
    {
      localMenuItem.setVisible(false);
      localMenuItem.setEnabled(false);
    }
    super.onPrepareOptionsMenu(paramMenu);
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putString("PUBLISHER_NAME", this._PublisherName);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/views/impexp/PublisherFeedsFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */