package mobi.beyondpod.ui.views.impexp;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.GridView;
import com.android.volley.Response.ErrorListener;
import mobi.beyondpod.BeyondPodApplication;
import mobi.beyondpod.rsscore.helpers.StringUtils;

public class PublishersFragment
  extends SearchResultFragmentBase
{
  protected View BuildContents(LayoutInflater paramLayoutInflater, Bundle paramBundle)
  {
    this.PAGE_SIZE = 80;
    paramLayoutInflater = paramLayoutInflater.inflate(2130903156, null);
    this._ResultView = ((GridView)paramLayoutInflater.findViewById(2131231166));
    this._ResultView.setFadingEdgeLength((int)getResources().getDimension(2131492952));
    this._ResultView.setVerticalFadingEdgeEnabled(true);
    int i = (int)getActivity().getResources().getDimension(2131492954);
    int j = (int)getActivity().getResources().getDimension(2131492953);
    ((GridView)this._ResultView).setHorizontalSpacing(i);
    ((GridView)this._ResultView).setVerticalSpacing(j);
    ((GridView)this._ResultView).setStretchMode(2);
    ((GridView)this._ResultView).setNumColumns(getResources().getInteger(2131361812));
    if (paramBundle != null) {
      super.onRestoreInstanceState(paramBundle);
    }
    this._Adapter = new PublishersGridViewAdapter(getActivity(), 2130903155, this._SearchResults, this._ImageLoader);
    return paramLayoutInflater;
  }
  
  public void DoSearch(String paramString)
  {
    if (paramString == null) {
      return;
    }
    super.DoSearchInternal(paramString);
  }
  
  void ItemSelected(FeedSearchResult paramFeedSearchResult)
  {
    Intent localIntent = new Intent(BeyondPodApplication.GetInstance(), PublisherResultsView.class);
    localIntent.putExtra("publisherId", paramFeedSearchResult.getLink());
    localIntent.putExtra("publisherName", paramFeedSearchResult.getTitle());
    startActivity(localIntent);
  }
  
  protected void callSearch(String paramString, int paramInt, SearchResultFragmentBase.SearchSuccessListener paramSearchSuccessListener, Response.ErrorListener paramErrorListener)
    throws FeedSearchService.ServiceException
  {
    if (StringUtils.Equals(paramString, "Publishers")) {
      this._FeedSearchService.getPublishers(2, paramInt, this.PAGE_SIZE, paramSearchSuccessListener, paramErrorListener);
    }
    while (!StringUtils.Equals(paramString, "Regions")) {
      return;
    }
    this._FeedSearchService.getPublishers(3, paramInt, this.PAGE_SIZE, paramSearchSuccessListener, paramErrorListener);
  }
  
  CharSequence getEmptyText()
  {
    return getResources().getString(2131297254, new Object[] { this._Query });
  }
  
  int getHeaderViewsCount()
  {
    return 0;
  }
  
  protected void onAfterDataLoaded(boolean paramBoolean, String paramString) {}
  
  void onBeforeDataLoaded(boolean paramBoolean, String paramString) {}
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/views/impexp/PublishersFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */