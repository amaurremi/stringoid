package mobi.beyondpod.ui.views;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import mobi.beyondpod.downloadengine.EnclosureDownloadManager;
import mobi.beyondpod.downloadengine.EnclosureDownloadManager.DownloadableEnclosure;
import mobi.beyondpod.downloadengine.EnclosureDownloadManager.EnclosureBatchDownloadListener;
import mobi.beyondpod.downloadengine.RssFeedUpdateManager;
import mobi.beyondpod.downloadengine.RssFeedUpdateManager.FeedBatchUpdateListener;
import mobi.beyondpod.downloadengine.UpdateAndDownloadManager;
import mobi.beyondpod.downloadengine.UpdateAndDownloadManager.UpdateAndDownloadListener;
import mobi.beyondpod.rsscore.Feed;
import mobi.beyondpod.rsscore.Track;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.repository.FeedRepository;
import mobi.beyondpod.rsscore.repository.FlashStorageLocation;
import mobi.beyondpod.rsscore.rss.entities.RssEnclosure;
import mobi.beyondpod.ui.commands.CommandManager;
import mobi.beyondpod.ui.core.ActionBarActivityBase;
import mobi.beyondpod.ui.core.ActionBarHelper;

public class UpdateAndDownloadQueueActivityDialog
  extends ActionBarActivityBase
  implements View.OnClickListener
{
  private static final String TAG = UpdateAndDownloadQueueActivityDialog.class.getSimpleName();
  private UpdateAndDownloadQueueViewAdapter _Adapter;
  ListView _Content;
  private EnclosureDownloadManager.EnclosureBatchDownloadListener _EnclosureBatchUpdateListener = new EnclosureDownloadManager.EnclosureBatchDownloadListener()
  {
    public void OnAnotherDownloadIsInProgress() {}
    
    public void OnEnclosureBatchDownloadCanceled() {}
    
    public void OnEnclosureBatchDownloadCompleted()
    {
      UpdateAndDownloadQueueActivityDialog.this.RefreshQueue();
    }
    
    public void OnEnclosureBatchDownloadStarted()
    {
      UpdateAndDownloadQueueActivityDialog.this.RefreshQueue();
    }
    
    public void OnEnclosureBatchEnclosureDownloadStarting(Track paramAnonymousTrack, boolean paramAnonymousBoolean)
    {
      UpdateAndDownloadQueueActivityDialog.this.RefreshQueue();
    }
    
    public void OnEnclosureDownloadCanceled(Track paramAnonymousTrack) {}
    
    public void OnEnclosureDownloadCompleted(Track paramAnonymousTrack) {}
    
    public void OnEnclosureDownloadFailed(Track paramAnonymousTrack, Exception paramAnonymousException) {}
    
    public void OnEnclosureDownloadProgress(Track paramAnonymousTrack)
    {
      UpdateAndDownloadQueueActivityDialog.this.RefreshQueue();
    }
    
    public void OnEnclosureDownloadStarted(Track paramAnonymousTrack)
    {
      UpdateAndDownloadQueueActivityDialog.this.RefreshQueue();
    }
    
    public void OnEnclosureDownloadTerminated(Track paramAnonymousTrack) {}
    
    public void OnUnableToEstablishNetworkConnection() {}
  };
  Button _OKButton;
  private View.OnClickListener _OnOKListener = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      UpdateAndDownloadManager.TerminateAll();
      UpdateAndDownloadQueueActivityDialog.this.finish();
    }
  };
  private RssFeedUpdateManager.FeedBatchUpdateListener _RssFeedUpdateListener = new RssFeedUpdateManager.FeedBatchUpdateListener()
  {
    public void OnAnotherUpdateIsInProgress() {}
    
    public void OnFeedBatchUpdateCanceled() {}
    
    public void OnFeedBatchUpdateCompleted()
    {
      UpdateAndDownloadQueueActivityDialog.this.RefreshQueue();
    }
    
    public void OnFeedBatchUpdateStarted(Feed paramAnonymousFeed)
    {
      UpdateAndDownloadQueueActivityDialog.this.RefreshQueue();
    }
    
    public void OnFeedBatchUpdateUnableToEstablishNetworkConnection() {}
    
    public void OnFeedUpdateCompleted(Feed paramAnonymousFeed) {}
    
    public void OnFeedUpdateProgress(Feed paramAnonymousFeed)
    {
      UpdateAndDownloadQueueActivityDialog.this.RefreshQueue();
    }
    
    public void OnFeedUpdateStarted(Feed paramAnonymousFeed)
    {
      UpdateAndDownloadQueueActivityDialog.this.RefreshQueue();
    }
    
    public void OnInsufficientSpaceAtDownloadLocation(FlashStorageLocation paramAnonymousFlashStorageLocation) {}
  };
  private UpdateAndDownloadManager.UpdateAndDownloadListener _UpdateAndDownloadListener = new UpdateAndDownloadManager.UpdateAndDownloadListener()
  {
    public void OnAnotherDownloadIsInProgress() {}
    
    public void OnUnableToEstablishNetworkConnection() {}
    
    public void ProcessingCanceled(int paramAnonymousInt) {}
    
    public void ProcessingCompleted(int paramAnonymousInt) {}
    
    public void ProcessingStarted(int paramAnonymousInt)
    {
      UpdateAndDownloadQueueActivityDialog.this.RefreshQueue();
    }
    
    public void UpdateAndDownloadBatchCompleted() {}
    
    public void UpdateAndDownloadBatchStarted() {}
  };
  
  private void RefreshQueue()
  {
    runOnUiThread(new Runnable()
    {
      public void run()
      {
        UpdateAndDownloadQueueActivityDialog.this._Adapter.Refresh();
        Button localButton = UpdateAndDownloadQueueActivityDialog.this._OKButton;
        if ((UpdateAndDownloadManager.HasWorkToDo()) || (EnclosureDownloadManager.QueueCount() > 0)) {}
        for (int i = 2131296883;; i = 2131296882)
        {
          localButton.setText(i);
          return;
        }
      }
    });
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getTag() == null) {}
    do
    {
      return;
      paramView = (UpdateAndDownloadQueueViewAdapter.QueleListDataItem)paramView.getTag();
    } while ((paramView.Feed != null) || (paramView.Enclosure.Enclosure == null));
    if (paramView.Enclosure.Enclosure.PlayableState() == 5)
    {
      EnclosureDownloadManager.TerminateCurrentDownload();
      return;
    }
    EnclosureDownloadManager.RemoveFromQueue(paramView.Enclosure.Enclosure);
    RefreshQueue();
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
    setContentView(2130903172);
    this._OKButton = ((Button)findViewById(2131230928));
    findViewById(2131230929).setVisibility(8);
    this._OKButton = ((Button)findViewById(2131230928));
    this._OKButton.setOnClickListener(this._OnOKListener);
    this._Content = ((ListView)findViewById(2131231216));
    this._Adapter = new UpdateAndDownloadQueueViewAdapter(this);
    this._Content.setAdapter(this._Adapter);
    this._Content.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        if ((UpdateAndDownloadManager.HasWorkToDo()) || (EnclosureDownloadManager.QueueCount() > 0)) {
          return;
        }
        CommandManager.CmdShowUpdateLog(UpdateAndDownloadQueueActivityDialog.this);
      }
    });
    getActionBarHelper().setDisplayOptions(4, 4);
  }
  
  public boolean onMenuItemSelected(int paramInt, MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
      return false;
    }
    finish();
    return true;
  }
  
  protected void onPause()
  {
    super.onPause();
    EnclosureDownloadManager.removeEnclosureBatchDownloadListener(this._EnclosureBatchUpdateListener);
    UpdateAndDownloadManager.removeUpdateAndDownloadListener(this._UpdateAndDownloadListener);
    RssFeedUpdateManager.removeFeedBatchUpdateListener(this._RssFeedUpdateListener);
  }
  
  protected void onResume()
  {
    super.onResume();
    EnclosureDownloadManager.addEnclosureBatchDownloadListener(this._EnclosureBatchUpdateListener);
    UpdateAndDownloadManager.addUpdateAndDownloadListener(this._UpdateAndDownloadListener);
    RssFeedUpdateManager.addFeedBatchUpdateListener(this._RssFeedUpdateListener);
    RefreshQueue();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/views/UpdateAndDownloadQueueActivityDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */