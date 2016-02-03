package mobi.beyondpod.ui.views.impexp;

import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import mobi.beyondpod.BeyondPodApplication;
import mobi.beyondpod.downloadengine.UpdateAndDownloadManager;
import mobi.beyondpod.rsscore.FeedList;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.helpers.SimpleMessageBus;
import mobi.beyondpod.rsscore.helpers.StringUtils;
import mobi.beyondpod.rsscore.repository.FeedRepository;
import mobi.beyondpod.rsscore.repository.RepositoryEvents.RepositoryEvent;
import mobi.beyondpod.rsscore.repository.RepositoryEvents.RepositoryEventListener;
import mobi.beyondpod.ui.core.ActionBarFragmentActivityBase;
import mobi.beyondpod.ui.core.ActionBarHelper;
import mobi.beyondpod.ui.core.volley.ImageLoader;
import mobi.beyondpod.ui.core.volley.ImageLoader.ImageLoaderProvider;
import mobi.beyondpod.ui.core.volley.ImageLoaderFeedSearch;

public class PublisherResultsView
  extends ActionBarFragmentActivityBase
  implements ImageLoader.ImageLoaderProvider
{
  public static final String EXTRA_PUBLISHER_ID = "publisherId";
  public static final String EXTRA_PUBLISHER_NAME = "publisherName";
  public static final String FRAGMENT_AUDIOBOK = "AUDIOBOOKS";
  public static final String FRAGMENT_PUBLISHER = "PUBLISHER";
  private static final String TAG = PublisherResultsView.class.getSimpleName();
  String _PublisherID;
  String _PublisherName;
  private FeedList _RecentlyImportedFeeds = new FeedList();
  private final RepositoryEvents.RepositoryEventListener _RepositoryListener = new RepositoryEvents.RepositoryEventListener()
  {
    public void OnRepositoryEvent(RepositoryEvents.RepositoryEvent paramAnonymousRepositoryEvent)
    {
      if (paramAnonymousRepositoryEvent.Type == 6) {
        PublisherResultsView.this._RecentlyImportedFeeds.add(paramAnonymousRepositoryEvent.Feed);
      }
    }
  };
  private ImageLoader mImageLoader;
  
  private void BuildResultsFragment(View paramView, String paramString1, String paramString2)
  {
    paramView = getSupportFragmentManager();
    if (IsAudiobookPublisher())
    {
      paramString1 = new AudiobookSearchResultFragment();
      paramString1.setArguments(getIntent().getExtras());
      paramView.beginTransaction().add(2131230805, paramString1, "AUDIOBOOKS").commit();
      return;
    }
    paramString1 = new PublisherFeedsFragment();
    paramString1.setArguments(getIntent().getExtras());
    paramView.beginTransaction().add(2131230805, paramString1, "PUBLISHER").commit();
  }
  
  private boolean IsAudiobookPublisher()
  {
    return StringUtils.Equals("69", this._PublisherID);
  }
  
  public ImageLoader getImageLoaderInstance()
  {
    return this.mImageLoader;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mImageLoader = new ImageLoaderFeedSearch(this);
    if (!FeedRepository.IsRepositoryAvailable())
    {
      CoreHelper.WriteTraceEntry(TAG, "Closing view because the repository is not Loaded");
      finish();
      return;
    }
    BeyondPodApplication.MessageBus.Subscribe(this._RepositoryListener, RepositoryEvents.RepositoryEvent.class);
    setContentView(2130903157);
    getActionBarHelper().setDisplayOptions(4, 4);
    if (paramBundle == null)
    {
      if (getIntent() != null)
      {
        this._PublisherName = getIntent().getStringExtra("publisherName");
        this._PublisherID = getIntent().getStringExtra("publisherId");
      }
      if (this._PublisherID != null) {
        BuildResultsFragment(findViewById(2131230805), this._PublisherID, this._PublisherName);
      }
      setTitle(this._PublisherName);
      return;
    }
    this._PublisherID = paramBundle.getString("publisherId");
    this._PublisherName = paramBundle.getString("publisherName");
    FragmentManager localFragmentManager = getSupportFragmentManager();
    if (IsAudiobookPublisher()) {}
    for (paramBundle = "AUDIOBOOKS";; paramBundle = "PUBLISHER")
    {
      paramBundle = localFragmentManager.findFragmentByTag(paramBundle);
      if (paramBundle == null) {
        break;
      }
      ((SearchResultFragmentBase)paramBundle).setImageLoader(this.mImageLoader);
      break;
    }
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(2131755014, paramMenu);
    onPrepareOptionsMenu(paramMenu);
    return super.onCreateOptionsMenu(paramMenu);
  }
  
  protected void onDestroy()
  {
    BeyondPodApplication.MessageBus.Unsubscribe(this._RepositoryListener, RepositoryEvents.RepositoryEvent.class);
    if ((this._RecentlyImportedFeeds.size() > 0) && (!UpdateAndDownloadManager.IsWorking())) {
      UpdateAndDownloadManager.StartQuickUpdate(this._RecentlyImportedFeeds);
    }
    this.mImageLoader.release();
    super.onDestroy();
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    if ("android.intent.action.SEARCH".equals(paramIntent.getAction())) {
      onQueryTextSubmit(paramIntent.getStringExtra("query"));
    }
    super.onNewIntent(paramIntent);
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
      return super.onOptionsItemSelected(paramMenuItem);
    case 2131231230: 
      onSearchRequested();
      return true;
    }
    finish();
    return true;
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    FragmentManager localFragmentManager;
    if (Build.VERSION.SDK_INT < 14)
    {
      localFragmentManager = getSupportFragmentManager();
      if (!IsAudiobookPublisher()) {
        break label38;
      }
    }
    label38:
    for (String str = "AUDIOBOOKS";; str = "PUBLISHER")
    {
      localFragmentManager.findFragmentByTag(str).onPrepareOptionsMenu(paramMenu);
      return super.onPrepareOptionsMenu(paramMenu);
    }
  }
  
  public boolean onQueryTextSubmit(String paramString)
  {
    Fragment localFragment = getSupportFragmentManager().findFragmentByTag("AUDIOBOOKS");
    if (localFragment != null) {
      ((AudiobookSearchResultFragment)localFragment).DoSearch(paramString);
    }
    return true;
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putString("publisherName", this._PublisherName);
    paramBundle.putString("publisherId", this._PublisherID);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/views/impexp/PublisherResultsView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */