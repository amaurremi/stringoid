package mobi.beyondpod.schedulercore;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;
import mobi.beyondpod.BeyondPodApplication;
import mobi.beyondpod.downloadengine.UpdateAndDownloadEvents.UpdateAndDownloadEvent;
import mobi.beyondpod.downloadengine.UpdateAndDownloadEvents.UpdateAndDownloadEventListener;
import mobi.beyondpod.downloadengine.UpdateAndDownloadManager;
import mobi.beyondpod.rsscore.FeedList;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.helpers.SimpleMessageBus;
import mobi.beyondpod.services.player.SmartPlaylistTemplate;
import mobi.beyondpod.services.player.SmartPlaylistTemplate.SmartPlaylistEntry;
import mobi.beyondpod.ui.commands.CommandManagerBase;

public class OperationUpdateSmartplayFeeds
  extends OperationBase
{
  public static final UUID OperationID = UUID.fromString("F1B1C1D1-0C02-4314-B8C4-4FEDE4C83C80");
  private static String TAG = OperationUpdateSmartplayFeeds.class.getSimpleName();
  UpdateAndDownloadEvents.UpdateAndDownloadEventListener _OnUpdateAndDownloadHandler = new UpdateAndDownloadEvents.UpdateAndDownloadEventListener()
  {
    public void OnUpdateAndDownloadEvent(UpdateAndDownloadEvents.UpdateAndDownloadEvent paramAnonymousUpdateAndDownloadEvent)
    {
      if (paramAnonymousUpdateAndDownloadEvent.Type == UpdateAndDownloadEvents.UpdateAndDownloadEvent.UPDATE_AND_DOWNLOAD_COMPLETED)
      {
        CoreHelper.WriteTraceEntry(OperationUpdateSmartplayFeeds.TAG, "SmartPlay Update and Download Completed!");
        BeyondPodApplication.MessageBus.Unsubscribe(OperationUpdateSmartplayFeeds.this._OnUpdateAndDownloadHandler, UpdateAndDownloadEvents.UpdateAndDownloadEvent.class);
        OperationUpdateSmartplayFeeds.this.OnOperationCompleted();
      }
    }
  };
  
  OperationUpdateSmartplayFeeds()
  {
    super("BeyondPod Update Smartplay feeds", "BeyondPod Update Smartplay feeds", OperationID);
  }
  
  public OperationBase CreateInstance(String paramString)
  {
    return new OperationUpdateSmartplayFeeds();
  }
  
  public void Execute(OperationBase.OperationCompletedCallback paramOperationCompletedCallback)
  {
    super.Execute(paramOperationCompletedCallback);
    if (!UpdateAndDownloadManager.IsWorking())
    {
      Object localObject = new SmartPlaylistTemplate();
      paramOperationCompletedCallback = new FeedList();
      localObject = ((SmartPlaylistTemplate)localObject).Entries().iterator();
      for (;;)
      {
        if (!((Iterator)localObject).hasNext())
        {
          if (paramOperationCompletedCallback.size() != 0) {
            break;
          }
          CoreHelper.WriteLogEntry(TAG, "SmartPlay list has no feeds! Nothing to do!");
          OnOperationCompleted();
          return;
        }
        paramOperationCompletedCallback.addAll(((SmartPlaylistTemplate.SmartPlaylistEntry)((Iterator)localObject).next()).GetFeeds());
      }
      CoreHelper.WriteTraceEntry(TAG, String.format("Starting the update of %s feeds in SmartPlay", new Object[] { Integer.valueOf(paramOperationCompletedCallback.size()) }));
      BeyondPodApplication.MessageBus.Subscribe(this._OnUpdateAndDownloadHandler, UpdateAndDownloadEvents.UpdateAndDownloadEvent.class);
      CommandManagerBase.CmdUpdateFeeds(paramOperationCompletedCallback, true);
      return;
    }
    CoreHelper.WriteLogEntry(TAG, "SmartPlay update found another update is already in progress! Skipping update!");
    OnOperationCompleted();
  }
  
  public String Name()
  {
    return this._Name;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/schedulercore/OperationUpdateSmartplayFeeds.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */