package mobi.beyondpod.ui.views.feedsettings;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.MediaStore.Images.Media;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.UUID;
import mobi.beyondpod.downloadengine.RssFeedCatcher;
import mobi.beyondpod.downloadengine.RssFeedCatcher.FeedUpdateListener;
import mobi.beyondpod.rsscore.Feed;
import mobi.beyondpod.rsscore.FeedURLPatcher;
import mobi.beyondpod.rsscore.FeedURLPatcher.PatchResult;
import mobi.beyondpod.rsscore.StartupContentBuilder;
import mobi.beyondpod.rsscore.categories.FeedCategories;
import mobi.beyondpod.rsscore.categories.FeedCategory;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.helpers.StringUtils;
import mobi.beyondpod.rsscore.repository.FeedRepository;
import mobi.beyondpod.rsscore.rss.EnclosureDownloadHistory;
import mobi.beyondpod.rsscore.rss.RssFeedCache;
import mobi.beyondpod.rsscore.rss.entities.RssFeed;
import mobi.beyondpod.rsscore.rss.parsers.FeedParseData;
import mobi.beyondpod.sync.ChangeTracker;
import mobi.beyondpod.ui.commands.CommandManager;
import mobi.beyondpod.ui.commands.RefreshVirtualFeedTask;
import mobi.beyondpod.ui.commands.RefreshVirtualFeedTask.ITrackImageRefreshProgress;
import mobi.beyondpod.ui.core.ActionBarActivityBase;
import mobi.beyondpod.ui.core.FeedImageCache;

public class FeedPropertiesView
  extends ActionBarActivityBase
{
  protected static final int ACTIVITY_SELECT_IMAGE = 0;
  private static final String ADD_FEED = CoreHelper.LoadResourceString(2131297049);
  private static final String ADD_VIRTUAL_FEED;
  private static final String CHECKING_FEED_INFORMATION;
  private static final String CHECKING_FOR_ALTERNATIVES = CoreHelper.LoadResourceString(2131297147);
  private static final String CONNECTING;
  private static final String EDIT_FEED = CoreHelper.LoadResourceString(2131297050);
  private static final String EDIT_VIRTUAL_FEED = CoreHelper.LoadResourceString(2131297051);
  private static final String LOCATING_RSS_FEEDS;
  private static final String PATCHED_FEED_MSG = CoreHelper.LoadResourceString(2131297146);
  private static final String RETRIEVING_FEED;
  private static final String TAG = FeedPropertiesView.class.getSimpleName();
  private static final String UPDATING_DOWNLOAD_HISTORY;
  Button _CancelButton;
  RssFeedCatcher _Catcher = new RssFeedCatcher();
  View.OnClickListener _ClearCustomImageListener = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      if (FeedPropertiesView.this._CurrentFeed != null)
      {
        FeedImageCache.DeleteCustomImageForFeed(FeedPropertiesView.this._CurrentFeed);
        FeedPropertiesView.this.RefreshActiveSection();
      }
    }
  };
  View.OnClickListener _ClearHistoryListener = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      if (FeedPropertiesView.this._CurrentFeed != null) {
        new FeedPropertiesView.CmdAddRemoveAllEnclosuresToFeedHistory(FeedPropertiesView.this, null).execute(new Boolean[] { Boolean.valueOf(true) });
      }
    }
  };
  Feed _CurrentFeed;
  private boolean _CurrentFeedIsNew = false;
  private RssFeedCatcher.FeedUpdateListener _FeedUpdateListener = new RssFeedCatcher.FeedUpdateListener()
  {
    private void AnalyzeURL(String paramAnonymousString)
    {
      int j = 2131296764;
      int i = j;
      if (!StringUtils.IsNullOrEmpty(paramAnonymousString))
      {
        if (paramAnonymousString.endsWith(".mp3")) {
          j = 2131296765;
        }
        if (!paramAnonymousString.startsWith("http://"))
        {
          i = j;
          if (!paramAnonymousString.startsWith("https://")) {}
        }
        else
        {
          FeedPropertiesView.this.SetTitle(FeedPropertiesView.CHECKING_FOR_ALTERNATIVES);
          FeedURLPatcher.PatchResult localPatchResult = FeedURLPatcher.TryPatchFeedUrl(paramAnonymousString);
          if (localPatchResult.IsPatched())
          {
            FeedPropertiesView.this.ShowPatchFound(localPatchResult.PatchedURL());
            return;
          }
          i = j;
          if (IsItunesFeed(paramAnonymousString)) {
            i = 2131296766;
          }
        }
      }
      FeedPropertiesView.this.ShowError(ConstructFeedErroressage(i));
    }
    
    private String ConstructFeedErroressage(int paramAnonymousInt)
    {
      return FeedPropertiesView.this.getString(2131296763, new Object[] { FeedPropertiesView.this.getString(paramAnonymousInt) });
    }
    
    boolean IsItunesFeed(String paramAnonymousString)
    {
      return (!StringUtils.IsNullOrEmpty(paramAnonymousString)) && ((paramAnonymousString.startsWith("http://phobos.apple.com")) || (paramAnonymousString.startsWith("http://itunes.apple.com")) || (paramAnonymousString.startsWith("https://phobos.apple.com")) || (paramAnonymousString.startsWith("https://itunes.apple.com")));
    }
    
    public void OnFeedUpdateCompleted(Feed paramAnonymousFeed)
    {
      paramAnonymousFeed = FeedPropertiesView.this._Catcher.LastFeedParseData();
      if ((paramAnonymousFeed != null) && (!paramAnonymousFeed.HasParseFailed()))
      {
        if (FeedPropertiesView.this._CurrentFeed.IsGReaderFeed()) {
          FeedPropertiesView.this._CurrentFeed.setLastServerModifiedDate(null);
        }
        if (FeedPropertiesView.this._CurrentFeedIsNew) {
          CommandManager.CmdOpenFeed(FeedPropertiesView.this._CurrentFeed);
        }
        FeedPropertiesView.this._CurrentFeedIsNew = false;
        FeedPropertiesView.this.finish();
        return;
      }
      if (FeedPropertiesView.this._CurrentFeed != null)
      {
        AnalyzeURL(FeedPropertiesView.this._CurrentFeed.getFeedUrl());
        return;
      }
      FeedPropertiesView.this.ShowError(ConstructFeedErroressage(2131296764));
    }
    
    public void OnFeedUpdateError(Feed paramAnonymousFeed, Exception paramAnonymousException)
    {
      paramAnonymousException = FeedPropertiesView.this.getString(2131296762, new Object[] { paramAnonymousException.getMessage() });
      if (paramAnonymousFeed.IsGReaderFeed())
      {
        AnalyzeURL(paramAnonymousFeed.getFeedUrl());
        return;
      }
      FeedPropertiesView.this.ShowError(paramAnonymousException);
    }
    
    public void OnFeedUpdateProgress(Feed paramAnonymousFeed)
    {
      FeedPropertiesView.this.SetTitle(FeedPropertiesView.RETRIEVING_FEED + ": " + paramAnonymousFeed.UpdatePercent() + " %");
    }
    
    public void OnFeedUpdateStarted(Feed paramAnonymousFeed)
    {
      FeedPropertiesView.this.SetTitle(FeedPropertiesView.CONNECTING);
    }
    
    public void OnFeedUpdateTerminated(Feed paramAnonymousFeed)
    {
      if (FeedPropertiesView.this._ProgressDialog != null) {
        FeedPropertiesView.this._ProgressDialog.dismiss();
      }
    }
  };
  View.OnClickListener _MarkDownloadedListener = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      if (FeedPropertiesView.this._CurrentFeed != null) {
        new FeedPropertiesView.CmdAddRemoveAllEnclosuresToFeedHistory(FeedPropertiesView.this, null).execute(new Boolean[] { Boolean.valueOf(false) });
      }
    }
  };
  Button _OKButton;
  private View.OnClickListener _OnCancelListener = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      FeedPropertiesView.this.finish();
    }
  };
  private View.OnClickListener _OnOKListener = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      FeedPropertiesView.this.SaveChanges();
    }
  };
  ProgressDialog _ProgressDialog;
  View.OnClickListener _SelectCustomImageListener = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      if (FeedPropertiesView.this._CurrentFeed != null)
      {
        paramAnonymousView = new Intent("android.intent.action.PICK", MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        FeedPropertiesView.this.startActivityForResult(paramAnonymousView, 0);
      }
    }
  };
  View _SettingsRoot;
  ScrollView _SettingsScroll;
  SettingsSectionBase _SettingsSection;
  
  static
  {
    LOCATING_RSS_FEEDS = CoreHelper.LoadResourceString(2131297043);
    CONNECTING = CoreHelper.LoadResourceString(2131297044);
    RETRIEVING_FEED = CoreHelper.LoadResourceString(2131297045);
    CHECKING_FEED_INFORMATION = CoreHelper.LoadResourceString(2131297046);
    UPDATING_DOWNLOAD_HISTORY = CoreHelper.LoadResourceString(2131297047);
    ADD_VIRTUAL_FEED = CoreHelper.LoadResourceString(2131297048);
  }
  
  private void RefreshActiveSection()
  {
    this._SettingsSection.Refresh(this._CurrentFeed);
  }
  
  private void SaveChanges()
  {
    if (!this._SettingsSection.ValidateControls(this._CurrentFeed)) {
      return;
    }
    if (this._CurrentFeed == null)
    {
      this._CurrentFeedIsNew = true;
      this._CurrentFeed = Feed.CreateAndAddFeedWithDefaults("", "", "");
    }
    int i = this._CurrentFeed.getPodcastDownloadAction();
    String str = this._CurrentFeed.getName();
    FeedCategory localFeedCategory1 = this._CurrentFeed.getCategories().getPrimary();
    FeedCategory localFeedCategory2 = this._CurrentFeed.getCategories().getSecondary();
    this._SettingsSection.SaveToFeed(this._CurrentFeed);
    this._CurrentFeed.EnsureFeedPathIsUnique();
    if (i != this._CurrentFeed.getPodcastDownloadAction())
    {
      if ((this._CurrentFeed.getPodcastDownloadAction() != 5) && (this._CurrentFeed.getPodcastDownloadAction() != 4)) {
        break label241;
      }
      this._CurrentFeed.setForceFeedItemSort(2);
      this._CurrentFeed.setTrackSortOrder(2);
    }
    for (;;)
    {
      if (((!this._CurrentFeedIsNew) && ((!StringUtils.Equals(str, this._CurrentFeed.getName())) || (localFeedCategory1 != this._CurrentFeed.getCategories().getPrimary()))) || (localFeedCategory2 != this._CurrentFeed.getCategories().getSecondary())) {
        ChangeTracker.AddLocalFeedChange(3, this._CurrentFeed, 60);
      }
      FeedRepository.SaveRepositoryAsync();
      StartupContentBuilder.BackupRepositoriesAsync();
      if (!this._SettingsSection.HasFeedAddressChanged()) {
        break label291;
      }
      if (!this._SettingsSection.IsURLFeed()) {
        break;
      }
      CheckIfFeedIsValid(this._CurrentFeed);
      return;
      label241:
      this._CurrentFeed.setForceFeedItemSort(-1);
      this._CurrentFeed.setTrackSortOrder(-1);
    }
    new RefreshVirtualFeedTask(new RefreshVirtualFeedTask.ITrackImageRefreshProgress()
    {
      public void OnRefreshCompleted()
      {
        if (FeedPropertiesView.this._ProgressDialog != null) {
          FeedPropertiesView.this._ProgressDialog.dismiss();
        }
        if (FeedPropertiesView.this._CurrentFeedIsNew) {
          CommandManager.CmdOpenFeed(FeedPropertiesView.this._CurrentFeed);
        }
        FeedPropertiesView.this._CurrentFeedIsNew = false;
        FeedPropertiesView.this.finish();
      }
      
      public void OnRefreshProgress(int paramAnonymousInt)
      {
        FeedPropertiesView.this.SetTitle(FeedPropertiesView.RETRIEVING_FEED + " " + paramAnonymousInt + " %");
      }
      
      public void OnRefreshStarted()
      {
        FeedPropertiesView.this.showDialog(2);
      }
    }).execute(new Feed[] { this._CurrentFeed });
    return;
    label291:
    this._CurrentFeedIsNew = false;
    finish();
  }
  
  protected void CheckIfFeedIsValid(Feed paramFeed)
  {
    if (this._Catcher.IsUpdating())
    {
      this._Catcher.Stop();
      return;
    }
    this._Catcher.setFeedUpdateListener(this._FeedUpdateListener);
    this._Catcher.UpdateFeed(paramFeed, true);
    showDialog(1);
  }
  
  public void SetTitle(final String paramString)
  {
    runOnUiThread(new Runnable()
    {
      public void run()
      {
        if (FeedPropertiesView.this._ProgressDialog != null) {
          FeedPropertiesView.this._ProgressDialog.setMessage(paramString);
        }
      }
    });
  }
  
  void ShowError(final String paramString)
  {
    runOnUiThread(new Runnable()
    {
      public void run()
      {
        if (FeedPropertiesView.this._ProgressDialog != null) {
          FeedPropertiesView.this._ProgressDialog.dismiss();
        }
        AlertDialog.Builder localBuilder = new AlertDialog.Builder(FeedPropertiesView.this);
        localBuilder.setMessage(paramString);
        localBuilder.setTitle(2131296761);
        localBuilder.setPositiveButton(2131296315, null);
        localBuilder.setNeutralButton(2131296758, new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            FeedPropertiesView.this._CurrentFeedIsNew = false;
            FeedPropertiesView.this.finish();
          }
        });
        localBuilder.setNegativeButton(2131296757, new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            CommandManager.CmdStartHtmlViewActivity(mobi.beyondpod.rsscore.Configuration.FeedURLErrorHelpURL(FeedPropertiesView.this._CurrentFeed.getFeedUrl()), FeedPropertiesView.LOCATING_RSS_FEEDS, false);
          }
        }).show();
      }
    });
  }
  
  void ShowPatchFound(final String paramString)
  {
    runOnUiThread(new Runnable()
    {
      public void run()
      {
        if (FeedPropertiesView.this._ProgressDialog != null) {
          FeedPropertiesView.this._ProgressDialog.dismiss();
        }
        AlertDialog.Builder localBuilder = new AlertDialog.Builder(FeedPropertiesView.this);
        localBuilder.setMessage(String.format(FeedPropertiesView.PATCHED_FEED_MSG, new Object[] { paramString }));
        localBuilder.setTitle(2131296761);
        localBuilder.setNegativeButton(2131296754, null);
        localBuilder.setPositiveButton(2131296753, new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            FeedPropertiesView.this._SettingsSection.PatchFeedUrl(this.val$patched);
            FeedPropertiesView.this.SaveChanges();
          }
        });
        localBuilder.show();
      }
    });
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    }
    do
    {
      return;
    } while (paramInt2 != -1);
    Object localObject = new String[1];
    localObject[0] = "_data";
    paramIntent = getContentResolver().query(paramIntent.getData(), (String[])localObject, null, null, null);
    paramIntent.moveToFirst();
    localObject = paramIntent.getString(paramIntent.getColumnIndex(localObject[0]));
    paramIntent.close();
    if (StringUtils.IsNullOrEmpty((String)localObject)) {
      Toast.makeText(this, 2131297139, 1).show();
    }
    FeedImageCache.SetCustomFeedImage(this._CurrentFeed, (String)localObject);
    RefreshActiveSection();
  }
  
  public void onConfigurationChanged(android.content.res.Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    paramConfiguration = (FrameLayout.LayoutParams)this._SettingsRoot.getLayoutParams();
    int i = (int)getResources().getDimension(2131492955);
    paramConfiguration.rightMargin = i;
    paramConfiguration.leftMargin = i;
    this._SettingsRoot.setLayoutParams(paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (!FeedRepository.IsRepositoryAvailable())
    {
      CoreHelper.WriteTraceEntry(TAG, "Closing view because the repository is not Loaded");
      finish();
      return;
    }
    getWindow().setSoftInputMode(3);
    setContentView(2130903117);
    this._OKButton = ((Button)findViewById(2131230928));
    this._CancelButton = ((Button)findViewById(2131230929));
    int i;
    try
    {
      this._CurrentFeed = FeedRepository.GetFeedById(UUID.fromString(getIntent().getType()));
      i = 0;
      if (this._CurrentFeed != null) {
        if (this._CurrentFeed.getType() == 1)
        {
          this._SettingsSection = new VirtualFeedSection(this);
          i = 1;
          if (this._CurrentFeed == null) {
            break label379;
          }
          if (i == 0) {
            break label372;
          }
          paramBundle = EDIT_VIRTUAL_FEED;
          setTitle(paramBundle + " - " + this._CurrentFeed.getName());
          this._SettingsSection.Show();
          this._SettingsSection.LoadFromFeed(this._CurrentFeed);
          this._CancelButton.setOnClickListener(this._OnCancelListener);
          this._OKButton.setOnClickListener(this._OnOKListener);
          if (getIntent() != null)
          {
            i = getIntent().getIntExtra("FocusControl", -1);
            if (i > 0) {
              this._SettingsSection.focusControl(i);
            }
          }
          this._SettingsRoot = findViewById(2131231048);
          this._SettingsScroll = ((ScrollView)findViewById(2131231049));
          this._SettingsScroll.setFadingEdgeLength((int)getResources().getDimension(2131492952));
          this._SettingsScroll.setVerticalFadingEdgeEnabled(true);
          return;
        }
      }
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        this._CurrentFeed = null;
        continue;
        this._SettingsSection = new FeedCommonSection(this);
        continue;
        paramBundle = getIntent().getDataString();
        if ((!StringUtils.IsNullOrEmpty(paramBundle)) && (paramBundle.startsWith("/")))
        {
          this._SettingsSection = new VirtualFeedSection(this);
          i = 1;
        }
        else
        {
          this._SettingsSection = new FeedCommonSection(this);
          continue;
          label372:
          paramBundle = EDIT_FEED;
        }
      }
    }
    label379:
    if (i != 0) {}
    for (paramBundle = ADD_VIRTUAL_FEED;; paramBundle = ADD_FEED)
    {
      setTitle(paramBundle);
      break;
    }
  }
  
  protected Dialog onCreateDialog(int paramInt)
  {
    this._ProgressDialog = new ProgressDialog(this);
    this._ProgressDialog.setIndeterminate(true);
    ProgressDialog localProgressDialog = this._ProgressDialog;
    Object localObject;
    if (paramInt == 0)
    {
      localObject = UPDATING_DOWNLOAD_HISTORY;
      localProgressDialog.setMessage((CharSequence)localObject);
      localObject = this._ProgressDialog;
      if (paramInt >= 2) {
        break label84;
      }
    }
    label84:
    for (boolean bool = true;; bool = false)
    {
      ((ProgressDialog)localObject).setCancelable(bool);
      this._ProgressDialog.setOnDismissListener(new DialogInterface.OnDismissListener()
      {
        public void onDismiss(DialogInterface paramAnonymousDialogInterface)
        {
          FeedPropertiesView.this._Catcher.Stop();
        }
      });
      return this._ProgressDialog;
      localObject = CHECKING_FEED_INFORMATION;
      break;
    }
  }
  
  protected void onDestroy()
  {
    if ((this._CurrentFeed != null) && (this._CurrentFeedIsNew)) {
      FeedRepository.DeleteFeedAndRelatedFoldersAsync(this._CurrentFeed);
    }
    super.onDestroy();
  }
  
  protected void onPrepareDialog(int paramInt, Dialog paramDialog)
  {
    if (this._ProgressDialog != null)
    {
      this._ProgressDialog.setIndeterminate(false);
      this._ProgressDialog.setIndeterminate(true);
    }
    super.onPrepareDialog(paramInt, paramDialog);
  }
  
  private class CmdAddRemoveAllEnclosuresToFeedHistory
    extends AsyncTask<Boolean, Void, Void>
  {
    private CmdAddRemoveAllEnclosuresToFeedHistory() {}
    
    public Void doInBackground(Boolean... paramVarArgs)
    {
      if (paramVarArgs != null) {
        try
        {
          FeedParseData localFeedParseData = new FeedParseData(0);
          RssFeedCache.LoadFromCache(FeedPropertiesView.this._CurrentFeed, localFeedParseData);
          if ((localFeedParseData.RssFeed != null) && (localFeedParseData.RssFeed.Items.size() > 0))
          {
            if (paramVarArgs[0].booleanValue()) {
              EnclosureDownloadHistory.RemoveAllEnclosuresForFeed(localFeedParseData.RssFeed);
            }
            for (;;)
            {
              EnclosureDownloadHistory.SaveHistorySync();
              break;
              EnclosureDownloadHistory.AddAllEnclosures(localFeedParseData.RssFeed);
            }
          }
          return null;
        }
        catch (Exception paramVarArgs) {}
      }
    }
    
    protected void onPostExecute(Void paramVoid)
    {
      if (FeedPropertiesView.this._ProgressDialog != null) {
        FeedPropertiesView.this._ProgressDialog.dismiss();
      }
    }
    
    protected void onPreExecute()
    {
      FeedPropertiesView.this.showDialog(0);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/views/feedsettings/FeedPropertiesView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */