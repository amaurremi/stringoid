package mobi.beyondpod.ui.views.impexp;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import mobi.beyondpod.BeyondPodApplication;
import mobi.beyondpod.downloadengine.UpdateAndDownloadManager;
import mobi.beyondpod.rsscore.FeedList;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.helpers.FileUtils;
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
import mobi.beyondpod.ui.views.FolderBrowserDialog;
import mobi.beyondpod.ui.views.feedsettings.FeedPropertiesView;

public class AddFeedView
  extends ActionBarFragmentActivityBase
  implements PopularCategoriesFragment.PopularCagtegoryOwner, ImageLoader.ImageLoaderProvider
{
  private static final int MENU_ADD_BY_URL = 2;
  private static final int MENU_IMPORT_OPML = 5;
  private static final int MENU_IMPORT_READER = 3;
  private static final int MENU_IMPORT_SD_CARD = 4;
  public static final int PUBLISHER_RESULTS_FRAGMENT = 1;
  public static final int SEARCH_RESULTS_FRAGMENT = 0;
  private static final String TAG = AddFeedView.class.getSimpleName();
  private static final String TAG_ACTIVE_RESULT_FRAGMENT = "ACTIVE_FRAGMENT";
  private static final String TAG_QUERY = "QUERY";
  private int _ActiveResultFragment;
  private ImageLoader _ImageLoader;
  String _Query = null;
  private FeedList _RecentlyImportedFeeds = new FeedList();
  private final RepositoryEvents.RepositoryEventListener _RepositoryListener = new RepositoryEvents.RepositoryEventListener()
  {
    public void OnRepositoryEvent(RepositoryEvents.RepositoryEvent paramAnonymousRepositoryEvent)
    {
      if (paramAnonymousRepositoryEvent.Type == 6) {
        AddFeedView.this._RecentlyImportedFeeds.add(paramAnonymousRepositoryEvent.Feed);
      }
    }
  };
  
  private void OpenPopular(String paramString)
  {
    this._Query = null;
    String str = paramString;
    if (StringUtils.IsNullOrEmpty(paramString)) {
      str = "News";
    }
    TogglePopularCategories(true);
    ShowResultsFragment(0);
    paramString = getSupportFragmentManager();
    ((PopularCategoriesFragment)paramString.findFragmentById(2131230806)).SetActiveCategory(str);
    ((FeedSearchResultFragment)paramString.findFragmentById(2131230807)).LoadCategory(str);
  }
  
  private void OpenPublishers(String paramString)
  {
    this._Query = null;
    String str = paramString;
    if (StringUtils.IsNullOrEmpty(paramString)) {
      str = "Publishers";
    }
    TogglePopularCategories(true);
    ShowResultsFragment(1);
    paramString = getSupportFragmentManager();
    ((PopularCategoriesFragment)paramString.findFragmentById(2131230806)).SetActiveCategory(str);
    ((PublishersFragment)paramString.findFragmentById(2131230808)).DoSearch(str);
  }
  
  private boolean ShowImportOption(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 2: 
      OpenAddFeedDialog("http://");
      finish();
      return true;
    case 3: 
      startActivity(new Intent(this, ImportFeedlyActivity.class));
      finish();
      return true;
    case 5: 
      startActivity(new Intent(this, ImportOPMLActivity.class));
      finish();
      return true;
    }
    startActivityForResult(new Intent(this, FolderBrowserDialog.class), 101);
    return true;
  }
  
  private void ShowImportUsingPopup()
  {
    String str1 = getResources().getString(2131297264);
    String str2 = getResources().getString(2131296963);
    String str3 = getResources().getString(2131296964);
    String str4 = getResources().getString(2131296962);
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(this).setTitle(2131296861);
    DialogInterface.OnClickListener local2 = new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        if (paramAnonymousInt == 0) {
          AddFeedView.this.ShowImportOption(2);
        }
        for (;;)
        {
          paramAnonymousDialogInterface.dismiss();
          return;
          if (paramAnonymousInt == 1) {
            AddFeedView.this.ShowImportOption(4);
          } else if (paramAnonymousInt == 2) {
            AddFeedView.this.ShowImportOption(5);
          } else {
            AddFeedView.this.ShowImportOption(3);
          }
        }
      }
    };
    localBuilder.setItems(new String[] { str1, str2, str3, str4 }, local2).create().show();
  }
  
  private void ShowResultsFragment(int paramInt)
  {
    Object localObject = getSupportFragmentManager();
    Fragment localFragment1 = ((FragmentManager)localObject).findFragmentById(2131230807);
    Fragment localFragment2 = ((FragmentManager)localObject).findFragmentById(2131230808);
    localObject = ((FragmentManager)localObject).beginTransaction();
    if (paramInt == 0)
    {
      ((FragmentTransaction)localObject).show(localFragment1);
      ((FragmentTransaction)localObject).hide(localFragment2);
    }
    for (;;)
    {
      ((FragmentTransaction)localObject).setTransition(0);
      ((FragmentTransaction)localObject).commitAllowingStateLoss();
      this._ActiveResultFragment = paramInt;
      return;
      ((FragmentTransaction)localObject).hide(localFragment1);
      ((FragmentTransaction)localObject).show(localFragment2);
    }
  }
  
  private void TogglePopularCategories(boolean paramBoolean)
  {
    Object localObject = getSupportFragmentManager();
    Fragment localFragment = ((FragmentManager)localObject).findFragmentById(2131230806);
    localObject = ((FragmentManager)localObject).beginTransaction();
    if (paramBoolean)
    {
      ((FragmentTransaction)localObject).show(localFragment);
      ((FragmentTransaction)localObject).setTransition(4097);
    }
    for (;;)
    {
      ((FragmentTransaction)localObject).commitAllowingStateLoss();
      return;
      ((FragmentTransaction)localObject).hide(localFragment);
      ((FragmentTransaction)localObject).setTransition(4099);
    }
  }
  
  boolean OpenAddFeedDialog(String paramString)
  {
    if (StringUtils.IsNullOrEmpty(paramString)) {}
    do
    {
      return false;
      paramString = paramString.trim();
      localObject = paramString.toLowerCase();
    } while ((!((String)localObject).startsWith("http")) && (!((String)localObject).startsWith("feed")) && (!FileUtils.Exists((String)localObject)) && (!FileUtils.Exists(paramString)));
    paramString = Uri.parse(paramString);
    Object localObject = new Intent(this, FeedPropertiesView.class);
    ((Intent)localObject).setData(paramString);
    startActivity((Intent)localObject);
    return true;
  }
  
  public void OpenFeedSearch(String paramString)
  {
    String str = paramString;
    if (paramString != null) {
      str = paramString.trim();
    }
    if (StringUtils.IsNullOrEmpty(str)) {}
    while (OpenAddFeedDialog(str)) {
      return;
    }
    this._Query = str;
    ShowResultsFragment(0);
    TogglePopularCategories(false);
    ((FeedSearchResultFragment)getSupportFragmentManager().findFragmentById(2131230807)).DoSearch(str);
  }
  
  public ImageLoader getImageLoaderInstance()
  {
    return this._ImageLoader;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 == -1) && (paramIntent != null))
    {
      OpenAddFeedDialog(paramIntent.getData().getPath().replace("file://", ""));
      finish();
    }
  }
  
  public void onCategoryChanged(String paramString)
  {
    if ((StringUtils.Equals(paramString, "Publishers")) || (StringUtils.Equals(paramString, "Regions")))
    {
      OpenPublishers(paramString);
      return;
    }
    OpenPopular(paramString);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this._ImageLoader = new ImageLoaderFeedSearch(this);
    if (!FeedRepository.IsRepositoryAvailable())
    {
      CoreHelper.WriteTraceEntry(TAG, "Closing view because the repository is not Loaded");
      finish();
      return;
    }
    BeyondPodApplication.MessageBus.Subscribe(this._RepositoryListener, RepositoryEvents.RepositoryEvent.class);
    setContentView(2130903066);
    getActionBarHelper().setDisplayOptions(4, 4);
    if (paramBundle == null)
    {
      paramBundle = null;
      if (getIntent() != null) {
        paramBundle = getIntent().getStringExtra("Query");
      }
      if (paramBundle != null)
      {
        OpenFeedSearch(paramBundle);
        return;
      }
      OpenPublishers(null);
      return;
    }
    this._Query = paramBundle.getString("QUERY");
    TogglePopularCategories(StringUtils.IsNullOrEmpty(this._Query));
    ShowResultsFragment(paramBundle.getInt("ACTIVE_FRAGMENT"));
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(2131755008, paramMenu);
    onPrepareOptionsMenu(paramMenu);
    return super.onCreateOptionsMenu(paramMenu);
  }
  
  protected void onDestroy()
  {
    BeyondPodApplication.MessageBus.Unsubscribe(this._RepositoryListener, RepositoryEvents.RepositoryEvent.class);
    if ((this._RecentlyImportedFeeds.size() > 0) && (!UpdateAndDownloadManager.IsWorking())) {
      UpdateAndDownloadManager.StartQuickUpdate(this._RecentlyImportedFeeds);
    }
    this._ImageLoader.release();
    super.onDestroy();
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    if ("android.intent.action.SEARCH".equals(paramIntent.getAction())) {
      OpenFeedSearch(paramIntent.getStringExtra("query"));
    }
    super.onNewIntent(paramIntent);
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == 2131231232) {
      ShowImportUsingPopup();
    }
    do
    {
      return true;
      switch (paramMenuItem.getItemId())
      {
      }
    } while (ShowImportOption(paramMenuItem.getItemId()));
    return super.onOptionsItemSelected(paramMenuItem);
    finish();
    return true;
    onSearchRequested();
    return true;
  }
  
  @TargetApi(14)
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    Object localObject1;
    if (Build.VERSION.SDK_INT < 14)
    {
      Object localObject2 = getSupportFragmentManager();
      localObject1 = ((FragmentManager)localObject2).findFragmentById(2131230806);
      localObject2 = ((FragmentManager)localObject2).findFragmentById(2131230807);
      if (((Fragment)localObject2).isVisible()) {
        ((Fragment)localObject2).onPrepareOptionsMenu(paramMenu);
      }
    }
    for (;;)
    {
      return super.onPrepareOptionsMenu(paramMenu);
      if (((Fragment)localObject1).isVisible())
      {
        ((Fragment)localObject1).onPrepareOptionsMenu(paramMenu);
        continue;
        localObject1 = paramMenu.findItem(2131231232);
        if (localObject1 != null) {
          ((MenuItem)localObject1).setShowAsActionFlags(6);
        }
      }
    }
  }
  
  public boolean onQueryTextSubmit(String paramString)
  {
    OpenFeedSearch(paramString);
    return true;
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putString("QUERY", this._Query);
    paramBundle.putInt("ACTIVE_FRAGMENT", this._ActiveResultFragment);
  }
  
  public void supportInvalidateOptionsMenu()
  {
    if (Build.VERSION.SDK_INT < 14) {
      getActionBarHelper().invalidateOptionsMenu();
    }
    super.supportInvalidateOptionsMenu();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/views/impexp/AddFeedView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */