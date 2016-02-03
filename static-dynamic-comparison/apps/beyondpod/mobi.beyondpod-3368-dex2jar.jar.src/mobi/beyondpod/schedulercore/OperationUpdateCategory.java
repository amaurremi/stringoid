package mobi.beyondpod.schedulercore;

import java.util.Iterator;
import java.util.UUID;
import mobi.beyondpod.BeyondPodApplication;
import mobi.beyondpod.downloadengine.UpdateAndDownloadEvents.UpdateAndDownloadEvent;
import mobi.beyondpod.downloadengine.UpdateAndDownloadEvents.UpdateAndDownloadEventListener;
import mobi.beyondpod.downloadengine.UpdateAndDownloadManager;
import mobi.beyondpod.rsscore.Feed;
import mobi.beyondpod.rsscore.FeedList;
import mobi.beyondpod.rsscore.categories.CategoryManager;
import mobi.beyondpod.rsscore.categories.FeedCategory;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.helpers.SimpleMessageBus;
import mobi.beyondpod.rsscore.repository.FeedRepository;
import mobi.beyondpod.sync.ChangeTracker;
import mobi.beyondpod.ui.commands.CommandManagerBase;

public class OperationUpdateCategory
  extends OperationBase
{
  public static final UUID OperationID = UUID.fromString("ABC76FEC-0C02-4314-B8C4-4FEDE4C83C80");
  private static String TAG = OperationUpdateCategory.class.getSimpleName();
  private String _CategoryToUpdate = "Favorites";
  UpdateAndDownloadEvents.UpdateAndDownloadEventListener _OnUpdateAndDownloadHandler = new UpdateAndDownloadEvents.UpdateAndDownloadEventListener()
  {
    public void OnUpdateAndDownloadEvent(UpdateAndDownloadEvents.UpdateAndDownloadEvent paramAnonymousUpdateAndDownloadEvent)
    {
      if (paramAnonymousUpdateAndDownloadEvent.Type == UpdateAndDownloadEvents.UpdateAndDownloadEvent.UPDATE_AND_DOWNLOAD_COMPLETED)
      {
        CoreHelper.WriteTraceEntry(OperationUpdateCategory.TAG, "Update and Download Completed!");
        BeyondPodApplication.MessageBus.Unsubscribe(OperationUpdateCategory.this._OnUpdateAndDownloadHandler, UpdateAndDownloadEvents.UpdateAndDownloadEvent.class);
        OperationUpdateCategory.this.OnOperationCompleted();
      }
    }
  };
  
  OperationUpdateCategory()
  {
    super("BeyondPod Update Category", "BeyondPod Update Category", OperationID);
  }
  
  public OperationBase CreateInstance(String paramString)
  {
    OperationUpdateCategory localOperationUpdateCategory = new OperationUpdateCategory();
    localOperationUpdateCategory.setCategoryToUpdate(paramString);
    return localOperationUpdateCategory;
  }
  
  public void Execute(OperationBase.OperationCompletedCallback paramOperationCompletedCallback)
  {
    super.Execute(paramOperationCompletedCallback);
    if (!UpdateAndDownloadManager.IsWorking())
    {
      paramOperationCompletedCallback = CategoryManager.GetCategoryByValue(getCategoryToUpdate());
      if (paramOperationCompletedCallback == CategoryManager.CategoryNull)
      {
        CoreHelper.WriteLogEntry(TAG, "Category " + getCategoryToUpdate() + " does not exist! Nothing to do!");
        OnOperationCompleted();
        return;
      }
      FeedList localFeedList = new FeedList();
      Iterator localIterator = FeedRepository.getRootFeed().SubFeeds().iterator();
      for (;;)
      {
        if (!localIterator.hasNext())
        {
          if (localFeedList.size() != 0) {
            break;
          }
          CoreHelper.WriteLogEntry(TAG, "Category " + getCategoryToUpdate() + " has no feeds! Nothing to do!");
          OnOperationCompleted();
          return;
        }
        Feed localFeed = (Feed)localIterator.next();
        if (CategoryManager.IsInCategory(localFeed, paramOperationCompletedCallback)) {
          localFeedList.add(localFeed);
        }
      }
      CoreHelper.WriteTraceEntry(TAG, String.format("Starting the update of %s feeds in category %s", new Object[] { Integer.valueOf(localFeedList.size()), paramOperationCompletedCallback.Name() }));
      BeyondPodApplication.MessageBus.Subscribe(this._OnUpdateAndDownloadHandler, UpdateAndDownloadEvents.UpdateAndDownloadEvent.class);
      CommandManagerBase.CmdUpdateFeeds(localFeedList, true);
      return;
    }
    CoreHelper.WriteLogEntry(TAG, "Another update is already in progress! Skipping update!");
    OnOperationCompleted();
  }
  
  public String Name()
  {
    return this._Name + ": " + getCategoryToUpdate();
  }
  
  public String SerializedData()
  {
    return getCategoryToUpdate();
  }
  
  public long StartTimeBias()
  {
    if (ChangeTracker.IsTrackingEnabled()) {
      return GenerateRandomOffest(1000L, 30000L);
    }
    return super.StartTimeBias();
  }
  
  public String getCategoryToUpdate()
  {
    return this._CategoryToUpdate;
  }
  
  public void setCategoryToUpdate(String paramString)
  {
    this._CategoryToUpdate = paramString;
    this.m_IsModified = true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/schedulercore/OperationUpdateCategory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */