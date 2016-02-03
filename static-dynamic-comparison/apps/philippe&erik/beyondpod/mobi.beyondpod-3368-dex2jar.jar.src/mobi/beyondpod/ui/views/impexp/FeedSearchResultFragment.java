package mobi.beyondpod.ui.views.impexp;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;
import com.android.volley.Response.ErrorListener;
import java.util.ArrayList;
import java.util.Iterator;
import mobi.beyondpod.rsscore.Configuration;
import mobi.beyondpod.rsscore.Feed;
import mobi.beyondpod.rsscore.FeedList;
import mobi.beyondpod.rsscore.categories.CategoryManager;
import mobi.beyondpod.rsscore.helpers.StringUtils;
import mobi.beyondpod.rsscore.repository.FeedRepository;
import mobi.beyondpod.ui.commands.CommandManager;
import mobi.beyondpod.ui.core.ActionBarFragmentActivityBase;
import mobi.beyondpod.ui.core.ActionBarHelper;
import org.json.JSONArray;

public class FeedSearchResultFragment
  extends SearchResultFragmentBase
{
  protected static final String CATEGORY_TAG = "#CATEGORY:#";
  static final String FILTER_ALL = "*";
  static final String FILTER_AUDIO = "audio";
  static final String FILTER_TEXT = "text";
  static final String FILTER_VIDEO = "video";
  private static final int MENU_SHOW_ALL = 101;
  private static final int MENU_SHOW_AUDIO_ONLY = 102;
  private static final int MENU_SHOW_VIDEO_ONLY = 103;
  protected static final String PLAIN_SEARCH_TAG = "#SEARCH:#";
  protected static final String SEARCH_FILTER_TAG = "SEARCH_FILTER";
  protected String _FilterTag = "*";
  String _MediaFilterType = null;
  
  private void ApplyFilter(int paramInt)
  {
    if (paramInt == 101)
    {
      this._FilterTag = "*";
      DoSearch(this._Query);
    }
    do
    {
      return;
      if (paramInt == 102)
      {
        this._FilterTag = "audio";
        DoSearch(this._Query);
        return;
      }
    } while (paramInt != 103);
    this._FilterTag = "video";
    DoSearch(this._Query);
  }
  
  private void ShowFilterUsingPopup()
  {
    int i;
    if (StringUtils.Equals("audio", this._FilterTag)) {
      i = 1;
    }
    for (;;)
    {
      String str1 = getActivity().getResources().getString(2131297257);
      String str2 = getActivity().getResources().getString(2131297258);
      String str3 = getActivity().getResources().getString(2131297259);
      AlertDialog.Builder localBuilder = new AlertDialog.Builder(getActivity()).setTitle(2131297261);
      DialogInterface.OnClickListener local1 = new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          if (paramAnonymousInt == 1) {
            FeedSearchResultFragment.this.ApplyFilter(102);
          }
          for (;;)
          {
            paramAnonymousDialogInterface.dismiss();
            return;
            if (paramAnonymousInt == 2) {
              FeedSearchResultFragment.this.ApplyFilter(103);
            } else {
              FeedSearchResultFragment.this.ApplyFilter(101);
            }
          }
        }
      };
      localBuilder.setSingleChoiceItems(new String[] { str1, str2, str3 }, i, local1).create().show();
      return;
      if (StringUtils.Equals("video", this._FilterTag)) {
        i = 2;
      } else {
        i = 0;
      }
    }
  }
  
  private String formatUserFeeds()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = FeedRepository.getRootFeed().SubFeeds().iterator();
    for (;;)
    {
      if (!localIterator.hasNext())
      {
        if (localStringBuilder.length() != 0) {
          break;
        }
        return "*";
      }
      Feed localFeed = (Feed)localIterator.next();
      if ((CategoryManager.IsInCategory(localFeed, Configuration.getActiveFeedCategory())) && (localFeed.HasUrl()) && (localStringBuilder.length() < 1000))
      {
        if (localStringBuilder.length() > 0) {
          localStringBuilder.append("|");
        }
        localStringBuilder.append(localFeed.getFeedUrl());
      }
    }
    return localStringBuilder.toString();
  }
  
  protected View BuildContents(LayoutInflater paramLayoutInflater, Bundle paramBundle)
  {
    setHasOptionsMenu(true);
    paramLayoutInflater = paramLayoutInflater.inflate(2130903121, null);
    this._ResultView = ((ListView)paramLayoutInflater.findViewById(2131230827));
    ((ListView)this._ResultView).setItemsCanFocus(false);
    this._ResultView.setFadingEdgeLength((int)getResources().getDimension(2131492952));
    this._ResultView.setVerticalFadingEdgeEnabled(true);
    ((ListView)this._ResultView).setHeaderDividersEnabled(false);
    if (paramBundle != null)
    {
      super.onRestoreInstanceState(paramBundle);
      this._FilterTag = paramBundle.getString("SEARCH_FILTER");
    }
    this._Adapter = new FeedSearchResultsListViewAdapter(getActivity(), 2130903122, this._SearchResults, this._ImageLoader);
    return paramLayoutInflater;
  }
  
  protected String BuildFilterForEmptyText()
  {
    if (StringUtils.Equals(this._FilterTag, "video")) {
      return " - " + getResources().getString(2131297259);
    }
    if (StringUtils.Equals(this._FilterTag, "audio")) {
      return " - " + getResources().getString(2131297258);
    }
    return "";
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
    Uri localUri = Uri.parse(paramFeedSearchResult.getLink());
    if (paramFeedSearchResult.getOriginatingFeed() == null) {}
    for (String str = paramFeedSearchResult.getTitle();; str = paramFeedSearchResult.getOriginatingFeed())
    {
      CommandManager.CmdOpenFeedPreview(localUri, str, paramFeedSearchResult.getEpisodeUrl(), false);
      return;
    }
  }
  
  public void LoadCategory(String paramString)
  {
    if (StringUtils.IsNullOrEmpty(paramString)) {
      return;
    }
    DoSearch("#CATEGORY:#" + paramString);
  }
  
  protected void callSearch(String paramString, int paramInt, SearchResultFragmentBase.SearchSuccessListener paramSearchSuccessListener, Response.ErrorListener paramErrorListener)
    throws FeedSearchService.ServiceException
  {
    if (StringUtils.Equals(paramString, "Publishers")) {
      this._FeedSearchService.getPublishers(2, paramInt, this.PAGE_SIZE, paramSearchSuccessListener, paramErrorListener);
    }
    while (paramString.startsWith("#CATEGORY:#"))
    {
      String str = paramString.replace("#CATEGORY:#", "");
      if (StringUtils.Equals("Recommended", str))
      {
        this._FeedSearchService.getRecommendedFeeds(formatUserFeeds(), this._FilterTag, paramInt, this.PAGE_SIZE, paramSearchSuccessListener, paramErrorListener);
        return;
        if (StringUtils.Equals(paramString, "Regions")) {
          this._FeedSearchService.getPublishers(3, paramInt, this.PAGE_SIZE, paramSearchSuccessListener, paramErrorListener);
        }
      }
      else
      {
        if (StringUtils.Equals("Trending", str))
        {
          this._FeedSearchService.getTrendingEpisodes(formatUserFeeds(), this._FilterTag, paramInt, this.PAGE_SIZE, paramSearchSuccessListener, paramErrorListener);
          return;
        }
        this._FeedSearchService.findByPopularCategory(paramString.replace("#CATEGORY:#", ""), this._FilterTag, paramInt, this.PAGE_SIZE, paramSearchSuccessListener, paramErrorListener);
        return;
      }
    }
    this._FeedSearchService.findByQuery(paramString, this._FilterTag, paramInt, this.PAGE_SIZE, paramSearchSuccessListener, paramErrorListener);
  }
  
  CharSequence getEmptyText()
  {
    return getResources().getString(2131297254, new Object[] { this._Query.replace("#CATEGORY:#", "") }) + BuildFilterForEmptyText();
  }
  
  int getHeaderViewsCount()
  {
    return ((ListView)this._ResultView).getHeaderViewsCount();
  }
  
  protected void onAfterDataLoaded(boolean paramBoolean, String paramString)
  {
    ((ActionBarFragmentActivityBase)getActivity()).getActionBarHelper().invalidateOptionsMenu();
  }
  
  void onBeforeDataLoaded(boolean paramBoolean, String paramString)
  {
    this._MediaFilterType = paramString;
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    ShowFilterUsingPopup();
    ((ActionBarFragmentActivityBase)getActivity()).getActionBarHelper().invalidateOptionsMenu();
    return true;
  }
  
  public void onPrepareOptionsMenu(Menu paramMenu)
  {
    MenuItem localMenuItem = paramMenu.findItem(2131231231);
    if (localMenuItem != null)
    {
      if (((this._SearchResults.size() == 0) && (StringUtils.Equals("*", this._FilterTag))) || (StringUtils.IsNullOrEmpty(this._MediaFilterType)) || ("#SEARCH:#".equals(this._MediaFilterType)))
      {
        localMenuItem.setVisible(false);
        localMenuItem.setEnabled(false);
        return;
      }
      localMenuItem.setVisible(true);
      localMenuItem.setEnabled(true);
      if (!StringUtils.Equals("audio", this._FilterTag)) {
        break label118;
      }
      localMenuItem.setTitle(2131297258);
    }
    for (;;)
    {
      super.onPrepareOptionsMenu(paramMenu);
      return;
      label118:
      if (StringUtils.Equals("video", this._FilterTag)) {
        localMenuItem.setTitle(2131297259);
      } else {
        localMenuItem.setTitle(2131297257);
      }
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putString("SEARCH_FILTER", this._FilterTag);
  }
  
  protected void parseJSONResults(String paramString, JSONArray paramJSONArray, Object[] paramArrayOfObject)
    throws FeedSearchService.ServiceException
  {
    super.parseJSONResults(paramString, paramJSONArray, paramArrayOfObject);
    if (paramString.startsWith("#CATEGORY:#"))
    {
      paramArrayOfObject[1] = "#CATEGORY:#";
      return;
    }
    paramArrayOfObject[1] = "#SEARCH:#";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/views/impexp/FeedSearchResultFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */