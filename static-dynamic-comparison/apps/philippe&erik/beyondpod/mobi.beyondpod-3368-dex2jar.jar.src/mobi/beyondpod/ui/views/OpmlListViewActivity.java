package mobi.beyondpod.ui.views;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.SparseBooleanArray;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import mobi.beyondpod.BeyondPodApplication;
import mobi.beyondpod.aggregators.AggregatorLoginHelper;
import mobi.beyondpod.downloadengine.RssFeedCatcher;
import mobi.beyondpod.downloadengine.RssFeedCatcher.FeedUpdateListener;
import mobi.beyondpod.downloadengine.UpdateAndDownloadManager;
import mobi.beyondpod.rsscore.Configuration;
import mobi.beyondpod.rsscore.Feed;
import mobi.beyondpod.rsscore.FeedList;
import mobi.beyondpod.rsscore.categories.FeedCategory;
import mobi.beyondpod.rsscore.helpers.AnalyticsTracker;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.helpers.SimpleMessageBus;
import mobi.beyondpod.rsscore.helpers.StringUtils;
import mobi.beyondpod.rsscore.repository.FeedRepository;
import mobi.beyondpod.rsscore.repository.FeedRepository.FeedSearchArguments;
import mobi.beyondpod.rsscore.repository.RepositoryEvents.RepositoryEvent;
import mobi.beyondpod.rsscore.repository.RepositoryEvents.RepositoryEventListener;
import mobi.beyondpod.rsscore.rss.RssFeedCache;
import mobi.beyondpod.rsscore.rss.parsers.FeedParseData;
import mobi.beyondpod.ui.core.ActionBarActivityBase;
import mobi.beyondpod.ui.core.ActionBarHelper;
import mobi.beyondpod.ui.dialogs.SelectCategoryDialog;
import mobi.beyondpod.ui.dialogs.SelectCategoryDialog.OnCategorySelectedListener;

public class OpmlListViewActivity
  extends ActionBarActivityBase
  implements RepositoryEvents.RepositoryEventListener
{
  private static final String BEYOND_POD_IS_LOADING_S;
  private static final String CONNECTING;
  private static final String DOWNLOADED;
  private static final String ERROR;
  private static final String IMPORT_FEEDS = CoreHelper.LoadResourceString(2131297074);
  private static final String LOADING;
  private static final String LOADING_OPML;
  private static final String NUM_FEEDS = CoreHelper.LoadResourceString(2131296967);
  private static final String SELECTED_DIRECTORY_IS_CURRENTLY_UNAVAILABLE_PLEASE_TRY_AGAIN_LATER;
  private static final String TAG = OpmlListViewActivity.class.getSimpleName();
  private static final String UPDATE_CANCELED = CoreHelper.LoadResourceString(2131297065);
  private static final String UPDATE_FAILED;
  private OpmlViewAdapter _Adapter;
  RssFeedCatcher _Catcher = new RssFeedCatcher();
  Feed _CurrentFeed;
  private RssFeedCatcher.FeedUpdateListener _FeedUpdateListener = new RssFeedCatcher.FeedUpdateListener()
  {
    public void OnFeedUpdateCompleted(Feed paramAnonymousFeed)
    {
      OpmlListViewActivity.this.OnCacheAvailable();
    }
    
    public void OnFeedUpdateError(Feed paramAnonymousFeed, Exception paramAnonymousException)
    {
      OpmlListViewActivity.this.DismissProgressDialog();
      OpmlListViewActivity.this.ShowToast(OpmlListViewActivity.UPDATE_FAILED + "\n\n" + paramAnonymousException.getMessage());
      OpmlListViewActivity.this.SetTitle(OpmlListViewActivity.ERROR);
    }
    
    public void OnFeedUpdateProgress(Feed paramAnonymousFeed)
    {
      OpmlListViewActivity.this.SetTitle(OpmlListViewActivity.DOWNLOADED + " " + paramAnonymousFeed.UpdatePercent() + " %");
    }
    
    public void OnFeedUpdateStarted(Feed paramAnonymousFeed)
    {
      OpmlListViewActivity.this.SetTitle(OpmlListViewActivity.CONNECTING);
    }
    
    public void OnFeedUpdateTerminated(Feed paramAnonymousFeed)
    {
      OpmlListViewActivity.this.DismissProgressDialog();
      OpmlListViewActivity.this.ShowToast(OpmlListViewActivity.UPDATE_CANCELED);
      OpmlListViewActivity.this.SetTitle(OpmlListViewActivity.UPDATE_CANCELED);
    }
  };
  Handler _Handler = new Handler();
  View _ImportSelected;
  Feed _LastSelectedFeed;
  private ListView _ListView = null;
  Thread _LoaderThread;
  ProgressDialog _ProgressDialog;
  private FeedList _RecentlyImportedFeeds = new FeedList();
  Feed _SearchFeed;
  SelectCategoryDialog _SelectCategoryDialog;
  
  static
  {
    CONNECTING = CoreHelper.LoadResourceString(2131297066);
    DOWNLOADED = CoreHelper.LoadResourceString(2131297067);
    ERROR = CoreHelper.LoadResourceString(2131297068);
    UPDATE_FAILED = CoreHelper.LoadResourceString(2131297069);
    BEYOND_POD_IS_LOADING_S = CoreHelper.LoadResourceString(2131297070);
    SELECTED_DIRECTORY_IS_CURRENTLY_UNAVAILABLE_PLEASE_TRY_AGAIN_LATER = CoreHelper.LoadResourceString(2131297071);
    LOADING_OPML = CoreHelper.LoadResourceString(2131297072);
    LOADING = CoreHelper.LoadResourceString(2131297073);
  }
  
  private void DismissProgressDialog()
  {
    this._ListView.postDelayed(new Runnable()
    {
      public void run()
      {
        if ((OpmlListViewActivity.this._ProgressDialog != null) && (OpmlListViewActivity.this._ProgressDialog.isShowing())) {
          OpmlListViewActivity.this._ProgressDialog.dismiss();
        }
      }
    }, 500L);
  }
  
  private void LoadFeed(Uri paramUri)
  {
    for (;;)
    {
      try
      {
        if ("opml".equals(paramUri.getScheme()))
        {
          paramUri = UUID.fromString((String)paramUri.getPathSegments().get(0));
          this._CurrentFeed = ((Feed)Configuration.TempFeedHolder.get(paramUri));
          Configuration.TempFeedHolder.remove(paramUri);
          if (this._CurrentFeed != null)
          {
            if (this._CurrentFeed.IsGReaderFeed())
            {
              this._SearchFeed = this._CurrentFeed;
              SetRootFeed(this._CurrentFeed);
              return;
            }
            runOnUiThread(new Runnable()
            {
              public void run()
              {
                OpmlListViewActivity.this.showDialog(0);
              }
            });
            CoreHelper.WriteLogEntryInProduction(TAG, "Importing OPML! HasUrl: " + this._CurrentFeed.HasUrl() + ", URL:" + this._CurrentFeed.getFeedUri() + ", Scheme:[" + this._CurrentFeed.getFeedUri().getScheme() + "], CacheAge:" + RssFeedCache.GetCachedAgeFor(this._CurrentFeed));
            if ((!this._CurrentFeed.HasUrl()) || ("file".equals(this._CurrentFeed.getFeedUri().getScheme())) || ((RssFeedCache.HasCachedFileFor(this._CurrentFeed)) && (RssFeedCache.GetCachedAgeFor(this._CurrentFeed) <= 24.0D))) {
              continue;
            }
            this._Catcher.UpdateFeed(this._CurrentFeed, true);
          }
        }
      }
      catch (Exception paramUri)
      {
        ShowToast(paramUri.getMessage());
        DismissProgressDialog();
        continue;
        paramUri = ERROR;
        continue;
      }
      if (this._CurrentFeed == null) {
        continue;
      }
      paramUri = this._CurrentFeed.getName();
      SetTitle(paramUri);
      return;
      OnCacheAvailable();
    }
  }
  
  private void OnCacheAvailable()
  {
    try
    {
      SetTitle(LOADING);
      CoreHelper.WriteLogEntryInProduction(TAG, LOADING_OPML + ": " + RssFeedCache.GetFeedDownloadPath(this._CurrentFeed.getFeedUri()));
      FeedParseData localFeedParseData = new FeedParseData(0);
      RssFeedCache.LoadFromCache(this._CurrentFeed, localFeedParseData);
      if ((localFeedParseData.Feed != null) && (localFeedParseData.ParsedFeedType == 3))
      {
        this._SearchFeed = localFeedParseData.Feed;
        SetRootFeed(this._SearchFeed);
      }
      for (;;)
      {
        DismissProgressDialog();
        SetTitle(this._CurrentFeed.getName());
        return;
        ShowToast(SELECTED_DIRECTORY_IS_CURRENTLY_UNAVAILABLE_PLEASE_TRY_AGAIN_LATER);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ShowToast(localException.getMessage());
      }
    }
  }
  
  private void RefreshTitle()
  {
    int i = getCheckedFeeds().size();
    Object localObject;
    if (this._Adapter.numCheckableFeeds() == 0) {
      if (this._CurrentFeed != null)
      {
        localObject = this._CurrentFeed.getName();
        SetTitle((String)localObject);
        label38:
        getActionBarHelper().invalidateOptionsMenu();
        localObject = this._ImportSelected;
        if (getCheckedFeeds().size() <= 0) {
          break label168;
        }
      }
    }
    label168:
    for (i = 0;; i = 8)
    {
      ((View)localObject).setVisibility(i);
      return;
      localObject = ERROR;
      break;
      if (i > 0)
      {
        SetTitle(String.format("%s/" + NUM_FEEDS, new Object[] { Integer.valueOf(getCheckedFeeds().size()), Integer.valueOf(this._Adapter.numCheckableFeeds()) }));
        break label38;
      }
      SetTitle(String.format(NUM_FEEDS, new Object[] { Integer.valueOf(this._Adapter.numCheckableFeeds()) }));
      break label38;
    }
  }
  
  private void ShowToast(final String paramString)
  {
    runOnUiThread(new Runnable()
    {
      public void run()
      {
        Toast.makeText(OpmlListViewActivity.this, paramString, 1).show();
      }
    });
  }
  
  private FeedList getCheckedFeeds()
  {
    SparseBooleanArray localSparseBooleanArray = this._ListView.getCheckedItemPositions();
    FeedList localFeedList = new FeedList();
    int i = 0;
    for (;;)
    {
      if (i >= this._Adapter.getCount()) {
        return localFeedList;
      }
      if (localSparseBooleanArray.get(i)) {
        localFeedList.add(this._Adapter.getFeedAtPosition(i));
      }
      i += 1;
    }
  }
  
  public void BatchImport()
  {
    if (this._Adapter == null) {}
    final FeedList localFeedList;
    do
    {
      return;
      localFeedList = getCheckedFeeds();
    } while (localFeedList.size() <= 0);
    String str2 = RootFeed().getName();
    String str1 = str2;
    if (RootFeed().CanNavigateUp()) {
      if (!StringUtils.EqualsIgnoreCase("Video", str2))
      {
        str1 = str2;
        if (!StringUtils.EqualsIgnoreCase("Audio", str2)) {}
      }
      else
      {
        str1 = RootFeed().ParentFeed().getName();
      }
    }
    this._SelectCategoryDialog = new SelectCategoryDialog(this, new SelectCategoryDialog.OnCategorySelectedListener()
    {
      public void onCategorySelected(FeedCategory paramAnonymousFeedCategory)
      {
        if (paramAnonymousFeedCategory == null) {
          return;
        }
        Feed.AddSubscriptionsInCategory(localFeedList, paramAnonymousFeedCategory);
        OpmlListViewActivity.this._ListView.clearChoices();
        OpmlListViewActivity.this._Adapter.notifyDataSetChanged();
      }
    });
    this._SelectCategoryDialog.CreateDialog(str1).show();
  }
  
  public void BulkSelect()
  {
    Object localObject = getString(2131297141);
    String str = getString(2131297142);
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(this);
    DialogInterface.OnClickListener local11 = new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        switch (paramAnonymousInt)
        {
        }
        for (;;)
        {
          OpmlListViewActivity.this._ListView.invalidateViews();
          OpmlListViewActivity.this.RefreshTitle();
          return;
          paramAnonymousInt = 0;
          while (paramAnonymousInt < OpmlListViewActivity.this._Adapter.getCount())
          {
            paramAnonymousDialogInterface = OpmlListViewActivity.this._Adapter.getFeedAtPosition(paramAnonymousInt);
            if ((paramAnonymousDialogInterface != null) && (OpmlListViewActivity.this._Adapter.IsFeedImportable(paramAnonymousDialogInterface))) {
              OpmlListViewActivity.this._ListView.setItemChecked(paramAnonymousInt, true);
            }
            paramAnonymousInt += 1;
          }
          OpmlListViewActivity.this._ListView.clearChoices();
        }
      }
    };
    localObject = localBuilder.setItems(new String[] { localObject, str }, local11);
    ((AlertDialog.Builder)localObject).setCancelable(true).setNegativeButton(2131296315, null);
    ((AlertDialog.Builder)localObject).create().show();
  }
  
  public void OnRepositoryEvent(RepositoryEvents.RepositoryEvent paramRepositoryEvent)
  {
    if (paramRepositoryEvent.Type == 5) {
      this._Adapter.Refresh();
    }
    for (;;)
    {
      RefreshTitle();
      return;
      if (paramRepositoryEvent.Type == 6) {
        this._RecentlyImportedFeeds.add(paramRepositoryEvent.Feed);
      }
    }
  }
  
  Feed RootFeed()
  {
    return this._Adapter.getRootFeed();
  }
  
  public void SetRootFeed(final Feed paramFeed)
  {
    runOnUiThread(new Runnable()
    {
      public void run()
      {
        OpmlListViewActivity.this._Adapter.SetRootFeed(paramFeed);
        OpmlListViewActivity.this.RefreshTitle();
      }
    });
  }
  
  public void SetTitle(final String paramString)
  {
    runOnUiThread(new Runnable()
    {
      public void run()
      {
        OpmlListViewActivity.this.getWindow().setTitle(paramString);
        OpmlListViewActivity.this.onTitleChanged(paramString, 0);
      }
    });
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (!FeedRepository.IsRepositoryAvailable())
    {
      CoreHelper.WriteTraceEntry(TAG, "Closing view because the repository is not Loaded");
      finish();
      return;
    }
    setContentView(2130903143);
    this._ImportSelected = findViewById(2131231126);
    this._ImportSelected.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        OpmlListViewActivity.this.BatchImport();
      }
    });
    this._ListView = ((ListView)findViewById(2131231124));
    this._ListView.setItemsCanFocus(false);
    this._ListView.setChoiceMode(2);
    this._ListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        OpmlListViewActivity.this._LastSelectedFeed = OpmlListViewActivity.this._Adapter.getFeedAtPosition(paramAnonymousInt);
        if (OpmlListViewActivity.this._LastSelectedFeed != null)
        {
          paramAnonymousView = OpmlListViewActivity.this._Adapter.getRootFeed();
          if ((!paramAnonymousView.CanNavigateUp()) || (!OpmlListViewActivity.this._LastSelectedFeed.equals(FeedRepository.getGoUpPlaceholder()))) {
            break label88;
          }
          OpmlListViewActivity.this.SetRootFeed(paramAnonymousView.ParentFeed());
          ((ListView)paramAnonymousAdapterView).clearChoices();
        }
        for (;;)
        {
          OpmlListViewActivity.this.RefreshTitle();
          return;
          label88:
          if (OpmlListViewActivity.this._LastSelectedFeed.SubFeeds().size() > 0)
          {
            OpmlListViewActivity.this.SetRootFeed(OpmlListViewActivity.this._LastSelectedFeed);
            ((ListView)paramAnonymousAdapterView).clearChoices();
          }
          else if (!OpmlListViewActivity.this._Adapter.IsFeedImportable(OpmlListViewActivity.this._LastSelectedFeed))
          {
            OpmlListViewActivity.this._ListView.setItemChecked(paramAnonymousInt, false);
          }
        }
      }
    });
    this._Adapter = new OpmlViewAdapter(this, this._ListView);
    this._ListView.setAdapter(this._Adapter);
    this._Catcher.setFeedUpdateListener(this._FeedUpdateListener);
    SetTitle(IMPORT_FEEDS);
    this._LoaderThread = new Thread(new Runnable()
    {
      public void run()
      {
        OpmlListViewActivity.this.LoadFeed(OpmlListViewActivity.this.getIntent().getData());
      }
    });
    this._LoaderThread.setName("OPML Loader");
    this._LoaderThread.start();
    AnalyticsTracker.OnViewDisplayed("Feed Import View");
    BeyondPodApplication.MessageBus.Subscribe(this, RepositoryEvents.RepositoryEvent.class);
    getActionBarHelper().setDisplayOptions(4, 4);
  }
  
  protected Dialog onCreateDialog(int paramInt)
  {
    if (paramInt == 0)
    {
      this._ProgressDialog = new ProgressDialog(this);
      if (this._CurrentFeed != null) {
        this._ProgressDialog.setMessage(String.format(BEYOND_POD_IS_LOADING_S, new Object[] { this._CurrentFeed.getName() }));
      }
      this._ProgressDialog.setIndeterminate(true);
      this._ProgressDialog.setCancelable(true);
      return this._ProgressDialog;
    }
    return super.onCreateDialog(paramInt);
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(2131755011, paramMenu);
    MenuItem localMenuItem = paramMenu.findItem(2131231251);
    if (localMenuItem != null)
    {
      if (this._Adapter.numCheckableFeeds() > 0)
      {
        bool = true;
        localMenuItem.setVisible(bool);
        localMenuItem.setEnabled(bool);
      }
    }
    else
    {
      localMenuItem = paramMenu.findItem(2131231253);
      if (localMenuItem != null) {
        if ((this._CurrentFeed == null) || (!this._CurrentFeed.IsGReaderFeed())) {
          break label113;
        }
      }
    }
    label113:
    for (boolean bool = true;; bool = false)
    {
      localMenuItem.setVisible(bool);
      localMenuItem.setEnabled(bool);
      return super.onCreateOptionsMenu(paramMenu);
      bool = false;
      break;
    }
  }
  
  protected void onDestroy()
  {
    if ((this._LoaderThread != null) && (this._LoaderThread.isAlive())) {
      this._LoaderThread.stop();
    }
    BeyondPodApplication.MessageBus.Unsubscribe(this, RepositoryEvents.RepositoryEvent.class);
    if ((this._RecentlyImportedFeeds.size() > 0) && (!UpdateAndDownloadManager.IsWorking())) {
      UpdateAndDownloadManager.StartQuickUpdate(this._RecentlyImportedFeeds);
    }
    if ((this._SelectCategoryDialog != null) && (this._SelectCategoryDialog.isShowing())) {
      this._SelectCategoryDialog.dismiss();
    }
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    Feed localFeed = RootFeed();
    if ((localFeed != null) && (paramInt == 4) && (localFeed.CanNavigateUp()))
    {
      SetRootFeed(localFeed.ParentFeed());
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    if ("android.intent.action.SEARCH".equals(paramIntent.getAction()))
    {
      FeedRepository.FeedSearchArguments localFeedSearchArguments = new FeedRepository.FeedSearchArguments(paramIntent.getStringExtra("query"));
      SetRootFeed(FeedRepository.SearchForFeeds(this._SearchFeed, localFeedSearchArguments));
    }
    super.onNewIntent(paramIntent);
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      return false;
      onSearchRequested();
      return true;
      if ((RootFeed() != null) && (RootFeed().CanNavigateUp()))
      {
        SetRootFeed(RootFeed().ParentFeed());
        return true;
      }
      finish();
      return true;
      BulkSelect();
      continue;
      AggregatorLoginHelper.ClearLogin();
      Toast.makeText(this, 2131297126, 1).show();
      finish();
    }
  }
  
  public Object onRetainNonConfigurationInstance()
  {
    Configuration.TempFeedHolder.put(this._CurrentFeed.ID(), this._CurrentFeed);
    return this._CurrentFeed;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/views/OpmlListViewActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */