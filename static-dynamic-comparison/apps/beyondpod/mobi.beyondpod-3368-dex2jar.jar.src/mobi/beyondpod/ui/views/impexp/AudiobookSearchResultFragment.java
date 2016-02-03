package mobi.beyondpod.ui.views.impexp;

import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import com.android.volley.Response.ErrorListener;
import mobi.beyondpod.rsscore.helpers.StringUtils;
import mobi.beyondpod.ui.commands.CommandManager;

public class AudiobookSearchResultFragment
  extends SearchResultFragmentBase
{
  static final String FILTER_ALL = "*";
  protected static final String GENRE_FILTER_TAG = "GENRE_FILTER";
  protected static final String LANGUAGE_FILTER_TAG = "LANGUAGE_FILTER";
  protected AdapterView.OnItemSelectedListener _FilterSelectedListener = new AdapterView.OnItemSelectedListener()
  {
    public void onItemSelected(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
    {
      paramAnonymousView = AudiobookSearchResultFragment.this._GenreFilter;
      String str = AudiobookSearchResultFragment.this._LanguageFilter;
      if (paramAnonymousAdapterView == AudiobookSearchResultFragment.this._GenreSpinner) {
        if (paramAnonymousInt == 0) {
          AudiobookSearchResultFragment.this._GenreFilter = "*";
        }
      }
      for (;;)
      {
        if ((!StringUtils.Equals(paramAnonymousView, AudiobookSearchResultFragment.this._GenreFilter)) || (!StringUtils.Equals(str, AudiobookSearchResultFragment.this._LanguageFilter))) {
          AudiobookSearchResultFragment.this.DoSearch(AudiobookSearchResultFragment.this._Query);
        }
        return;
        AudiobookSearchResultFragment.this._GenreFilter = AudiobookSearchResultFragment.this.getResources().getStringArray(2131624005)[paramAnonymousInt];
        continue;
        if (paramAnonymousInt == 0) {
          AudiobookSearchResultFragment.this._LanguageFilter = "*";
        } else {
          AudiobookSearchResultFragment.this._LanguageFilter = AudiobookSearchResultFragment.this.getResources().getStringArray(2131624006)[paramAnonymousInt];
        }
      }
    }
    
    public void onNothingSelected(AdapterView<?> paramAnonymousAdapterView) {}
  };
  protected String _GenreFilter = "*";
  private Spinner _GenreSpinner;
  View _Header;
  protected String _LanguageFilter = "*";
  private Spinner _LanguageSpinner;
  
  private void RefreshFilter()
  {
    this._GenreSpinner.setOnItemSelectedListener(null);
    this._LanguageSpinner.setOnItemSelectedListener(null);
    String[] arrayOfString1 = getResources().getStringArray(2131624005);
    String[] arrayOfString2 = getResources().getStringArray(2131624006);
    int j = 0;
    int k = 0;
    int i = 0;
    if (i == arrayOfString1.length) {
      label51:
      i = 0;
    }
    for (;;)
    {
      if (i == arrayOfString2.length) {
        i = k;
      }
      while (arrayOfString2[i].equals(this._LanguageFilter))
      {
        this._GenreSpinner.setSelection(j);
        this._LanguageSpinner.setSelection(i);
        this._GenreSpinner.setOnItemSelectedListener(this._FilterSelectedListener);
        this._LanguageSpinner.setOnItemSelectedListener(this._FilterSelectedListener);
        return;
        if (arrayOfString1[i].equals(this._GenreFilter))
        {
          j = i;
          break label51;
        }
        i += 1;
        break;
      }
      i += 1;
    }
  }
  
  protected View BuildContents(LayoutInflater paramLayoutInflater, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2130903070, null);
    this._Header = paramLayoutInflater.findViewById(2131230824);
    this._Header.setVisibility(8);
    this._GenreSpinner = ((Spinner)this._Header.findViewById(2131230825));
    this._LanguageSpinner = ((Spinner)this._Header.findViewById(2131230826));
    ArrayAdapter localArrayAdapter = ArrayAdapter.createFromResource(getActivity(), 2131624005, 17367048);
    localArrayAdapter.setDropDownViewResource(17367049);
    this._GenreSpinner.setAdapter(localArrayAdapter);
    localArrayAdapter = ArrayAdapter.createFromResource(getActivity(), 2131624006, 17367048);
    localArrayAdapter.setDropDownViewResource(17367049);
    this._LanguageSpinner.setAdapter(localArrayAdapter);
    this._ResultView = ((ListView)paramLayoutInflater.findViewById(2131230827));
    ((ListView)this._ResultView).setItemsCanFocus(false);
    this._ResultView.setFadingEdgeLength((int)getResources().getDimension(2131492952));
    this._ResultView.setVerticalFadingEdgeEnabled(true);
    if (paramBundle != null)
    {
      super.onRestoreInstanceState(paramBundle);
      this._GenreFilter = paramBundle.getString("GENRE_FILTER");
      this._LanguageFilter = paramBundle.getString("LANGUAGE_FILTER");
      paramBundle = this._Header;
      if (!StringUtils.IsNullOrEmpty(this._Query)) {
        break label248;
      }
    }
    label248:
    for (int i = 0;; i = 8)
    {
      paramBundle.setVisibility(i);
      RefreshFilter();
      this._Adapter = new AudiobookSearchResultsListViewAdapter(getActivity(), 2130903069, this._SearchResults, this._ImageLoader);
      return paramLayoutInflater;
    }
  }
  
  public void DoSearch(String paramString)
  {
    if (paramString == null) {
      return;
    }
    View localView = this._Header;
    if (StringUtils.IsNullOrEmpty(this._Query)) {}
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      super.DoSearchInternal(paramString);
      return;
    }
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
  
  protected void callSearch(String paramString, int paramInt, SearchResultFragmentBase.SearchSuccessListener paramSearchSuccessListener, Response.ErrorListener paramErrorListener)
    throws FeedSearchService.ServiceException
  {
    if (!StringUtils.IsNullOrEmpty(paramString))
    {
      this._FeedSearchService.findByAudioBookQuery(paramString, paramInt, this.PAGE_SIZE, paramSearchSuccessListener, paramErrorListener);
      return;
    }
    this._FeedSearchService.findByAudioBookCategory(this._GenreFilter, this._LanguageFilter, paramInt, this.PAGE_SIZE, paramSearchSuccessListener, paramErrorListener);
  }
  
  CharSequence getEmptyText()
  {
    if (StringUtils.IsNullOrEmpty(this._Query)) {
      return getResources().getString(2131297254, new Object[] { this._GenreFilter + ", " + this._LanguageFilter });
    }
    return getResources().getString(2131297254, new Object[] { this._Query });
  }
  
  int getHeaderViewsCount()
  {
    return ((ListView)this._ResultView).getHeaderViewsCount();
  }
  
  protected void onAfterDataLoaded(boolean paramBoolean, String paramString) {}
  
  void onBeforeDataLoaded(boolean paramBoolean, String paramString)
  {
    paramString = this._Header;
    if (StringUtils.IsNullOrEmpty(this._Query)) {}
    for (int i = 0;; i = 8)
    {
      paramString.setVisibility(i);
      return;
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if (paramBundle == null) {
      DoSearch("");
    }
    return paramLayoutInflater;
  }
  
  public void onPrepareOptionsMenu(Menu paramMenu)
  {
    MenuItem localMenuItem = paramMenu.findItem(2131231231);
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
    paramBundle.putString("GENRE_FILTER", this._GenreFilter);
    paramBundle.putString("LANGUAGE_FILTER", this._LanguageFilter);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/views/impexp/AudiobookSearchResultFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */