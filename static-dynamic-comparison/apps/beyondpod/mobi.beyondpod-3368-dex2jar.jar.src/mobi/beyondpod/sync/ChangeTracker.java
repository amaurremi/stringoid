package mobi.beyondpod.sync;

import android.os.Build;
import android.os.Handler;
import android.provider.Settings.Secure;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import mobi.beyondpod.BeyondPodApplication;
import mobi.beyondpod.downloadengine.UpdateAndDownloadManager;
import mobi.beyondpod.rsscore.Configuration;
import mobi.beyondpod.rsscore.Feed;
import mobi.beyondpod.rsscore.FeedList;
import mobi.beyondpod.rsscore.Track;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.helpers.SimpleMessageBus;
import mobi.beyondpod.rsscore.helpers.StringUtils;
import mobi.beyondpod.rsscore.helpers.TimeSpan;
import mobi.beyondpod.rsscore.repository.DatabaseHelper;
import mobi.beyondpod.rsscore.repository.FeedRepository;
import mobi.beyondpod.rsscore.repository.RepositoryEvents.RepositoryEvent;
import mobi.beyondpod.rsscore.repository.RepositoryPersistence;
import mobi.beyondpod.rsscore.rss.LicenseManager;
import mobi.beyondpod.rsscore.rss.entities.RssFeedItem;
import mobi.beyondpod.schedulercore.ScheduledTasksManager;

public class ChangeTracker
{
  private static final String TAG = ChangeTracker.class.getSimpleName();
  private static final boolean _EnclosureStreamableTrackAddedEnabled = true;
  private static final boolean _EpisodeDeletionsTrackingEnabled = true;
  private static final boolean _EpisodePlayedTrackingEnabled = true;
  private static final boolean _FeedTrackingEnabled = true;
  private static boolean _IsInitialized = false;
  private static final boolean _PostTrackingEnabled = false;
  private static FeedList _RecentlyImportedFeeds;
  private static Runnable _SaveHistoryRunnable = new Runnable()
  {
    public void run() {}
  };
  private static boolean _SavingHistory;
  private static ArrayList<TrackedChangeBase> m_history = new ArrayList();
  
  static
  {
    _RecentlyImportedFeeds = new FeedList();
  }
  
  public static void AddLocalEpisodeDeletedChange(Track paramTrack)
  {
    if (!IsTrackingEnabled()) {
      return;
    }
    if (!_IsInitialized)
    {
      CoreHelper.WriteTraceEntryInDebug(TAG, "Trying to add tracked Episode change before initializing the change tracking repository!");
      return;
    }
    if (!paramTrack.ChangeTrackingEnabled)
    {
      CoreHelper.WriteTraceEntryInDebug(TAG, "-------AddLocalEpisodeDeletedChange was ignored because change tracking is temporary disabled for episode: " + paramTrack.getName());
      paramTrack.ChangeTrackingEnabled = true;
      return;
    }
    if (paramTrack.getParentFeed().getType() == 1)
    {
      CoreHelper.WriteTraceEntryInDebug(TAG, "-------AddLocalEpisodeDeletedChange was ignored because episode " + paramTrack.getName() + " belongs to a virtual feed!");
      return;
    }
    AddPendingChangeInternal(new TrackedChangeEpisode(9, paramTrack), 300);
  }
  
  public static void AddLocalEpisodePlayedChange(Track paramTrack)
  {
    if (!IsTrackingEnabled()) {
      return;
    }
    if (!_IsInitialized)
    {
      CoreHelper.WriteTraceEntryInDebug(TAG, "Trying to AddLocalEpisodePlayedChange before initializing the change tracking repository!");
      return;
    }
    if (paramTrack.getParentFeed().getType() == 1)
    {
      CoreHelper.WriteTraceEntryInDebug(TAG, "-------AddLocalEpisodePlayedChange was ignored because the episode '" + paramTrack.getName() + "' belongs to a virtual feed!");
      return;
    }
    AddPendingChangeInternal(new TrackedChangeEpisode(8, paramTrack), 300);
  }
  
  public static void AddLocalEpisodeUpdatedChange(Track paramTrack)
  {
    if (!IsTrackingEnabled()) {
      return;
    }
    if (!_IsInitialized)
    {
      CoreHelper.WriteTraceEntryInDebug(TAG, "Trying to AddLocalEpisodeUpdatedChange before initializing the change tracking repository!");
      return;
    }
    if (paramTrack.getParentFeed().getType() == 1)
    {
      CoreHelper.WriteTraceEntryInDebug(TAG, "-------AddLocalEpisodeUpdatedChange was ignored because the episode '" + paramTrack.getName() + "' belongs to a virtual feed!");
      return;
    }
    AddPendingChangeInternal(new TrackedChangeEpisode(15, paramTrack), 300);
  }
  
  public static void AddLocalFeedChange(int paramInt1, Feed paramFeed, int paramInt2)
  {
    if (!IsTrackingEnabled()) {
      return;
    }
    if (!_IsInitialized)
    {
      CoreHelper.WriteTraceEntryInDebug(TAG, "Trying to add tracked Feed change before initializing the change tracking repository!");
      return;
    }
    if (!paramFeed.ChangeTrackingEnabled)
    {
      CoreHelper.WriteTraceEntryInDebug(TAG, "-------Change ignored because was disabled for the current feed!");
      paramFeed.ChangeTrackingEnabled = true;
      return;
    }
    if (paramFeed.getType() == 1)
    {
      CoreHelper.WriteTraceEntryInDebug(TAG, "-------Change ignored because the feed is a Virtual Feed!");
      return;
    }
    if ((paramInt1 == 1) || (paramInt1 == 3) || (paramInt1 == 14))
    {
      AddPendingChangeInternal(new TrackedChangeFeed(paramInt1, paramFeed), paramInt2);
      return;
    }
    CoreHelper.WriteTraceEntryInDebug(TAG, "-------Change ignored because CHANGE_TYPE_FEED_DELETED is not allowed!");
  }
  
  public static void AddLocalPostChange(int paramInt, RssFeedItem paramRssFeedItem)
  {
    IsTrackingEnabled();
  }
  
  public static void AddLocalStreamableEpisodeAddedChange(Track paramTrack)
  {
    if (!IsTrackingEnabled()) {
      return;
    }
    if (!_IsInitialized)
    {
      CoreHelper.WriteTraceEntryInDebug(TAG, "Trying to add tracked Episode change before initializing the change tracking repository!");
      return;
    }
    String str = paramTrack.getParentFeed().getFeedUrl();
    if (StringUtils.IsNullOrEmpty(str))
    {
      CoreHelper.WriteTraceEntryInDebug(TAG, "AddLocalStreamableEpisodeAddedChange is not supported for Virtual feeds. Ignoring...");
      return;
    }
    if (!paramTrack.ChangeTrackingEnabled)
    {
      CoreHelper.WriteTraceEntryInDebug(TAG, "-------AddLocalStreamableEpisodeAddedChange was ignored because was temporary disabled for episode: " + paramTrack.getName());
      paramTrack.ChangeTrackingEnabled = true;
      return;
    }
    AddPendingChangeInternal(new TrackedChangeEnclosure(4, RssFeedItem.BuildMockRssItem(str, paramTrack.RssItemID(), paramTrack.DisplayName(), paramTrack.TrackPostUrl(), paramTrack.getLastModifiedDate(), paramTrack.TrackDescription(), paramTrack.getUrl(), paramTrack.ContentMimeType(), Long.valueOf(paramTrack.getDownloadSize())).Enclosure()), 300);
  }
  
  private static void AddPendingChangeInternal(TrackedChangeBase paramTrackedChangeBase, int paramInt)
  {
    paramTrackedChangeBase.setSyncStatus(2);
    synchronized (History())
    {
      TrackedChangeBase localTrackedChangeBase = FindExistingUpPendingChangeFor(paramTrackedChangeBase);
      if (localTrackedChangeBase != null)
      {
        localTrackedChangeBase.UpdateTo(paramTrackedChangeBase);
        ScheduledTasksManager.ScheduleSyncTaskIfSyncIsEnabled(paramInt, TimeSpan.fromSeconds(1.0D), false);
        SaveHistoryAsync();
        return;
      }
      History().add(paramTrackedChangeBase);
    }
  }
  
  public static void AddPendingRemoteChanges(List<TrackedChangeBase> paramList)
  {
    long l1 = Configuration.LastRemoteChangeTimeStamp();
    long l2 = l1;
    if (paramList != null)
    {
      l2 = l1;
      if (paramList.size() <= 0) {}
    }
    synchronized (History())
    {
      paramList = paramList.iterator();
      TrackedChangeBase localTrackedChangeBase1;
      for (;;)
      {
        if (!paramList.hasNext()) {}
        do
        {
          SaveHistoryAsync();
          l2 = l1;
          if (Configuration.LastRemoteChangeTimeStamp() != l2)
          {
            Configuration.setLastRemoteChangeTimeStamp(l2);
            TrackedChangeBase.LogSyncEvent(TAG, " --- Last remote change timestamp moved to: " + new Date(l2), null);
          }
          return;
          localTrackedChangeBase1 = (TrackedChangeBase)paramList.next();
        } while (localTrackedChangeBase1.SyncStatus() != 3);
        TrackedChangeBase localTrackedChangeBase2 = FindExistingDownPendingChangeFor(localTrackedChangeBase1);
        TrackedChangeBase.LogSyncEvent(TAG, "   --- DOWN sync =>" + localTrackedChangeBase1, localTrackedChangeBase1);
        if (localTrackedChangeBase2 == null) {
          break;
        }
        localTrackedChangeBase2.UpdateTo(localTrackedChangeBase1);
        if (l1 < localTrackedChangeBase1.TimeStamp()) {
          l1 = localTrackedChangeBase1.TimeStamp();
        }
      }
      History().add(localTrackedChangeBase1);
    }
  }
  
  public static boolean AllowRemoteEpisodeAdditions()
  {
    return true;
  }
  
  public static boolean AllowRemoteEpisodeDeletions()
  {
    return Configuration.CDSAllowRemoteEpisodeDeletions();
  }
  
  public static boolean AllowRemoteEpisodeModifications()
  {
    return true;
  }
  
  public static boolean AllowRemoteFeedAdditions()
  {
    return Configuration.CDSAllowRemoteFeeds() == 1;
  }
  
  public static boolean AllowRemoteFeedDeletions()
  {
    return false;
  }
  
  public static boolean AllowRemoteFeedModifications()
  {
    return AllowRemoteFeedAdditions();
  }
  
  public static boolean AlwaysAcceptRemoteFeedPush()
  {
    return Configuration.CDSAllowRemoteFeeds() == 2;
  }
  
  public static int ApplyPendingRemoteChangesSync()
  {
    if (!IsTrackingEnabled())
    {
      j = 0;
      return j;
    }
    int i = 0;
    int j = 0;
    _RecentlyImportedFeeds.clear();
    for (;;)
    {
      synchronized (m_history)
      {
        Object localObject1 = new ArrayList();
        Iterator localIterator = History().iterator();
        if (!localIterator.hasNext())
        {
          if (((ArrayList)localObject1).size() > 0)
          {
            Collections.sort((List)localObject1, TrackedChangeBase.TimestampComparator);
            TrackedChangeBase.LogSyncEvent(TAG, " --- Applying " + ((ArrayList)localObject1).size() + " remote changes...", null);
            localObject1 = ((ArrayList)localObject1).iterator();
            i = j;
            if (((Iterator)localObject1).hasNext()) {
              break label251;
            }
            TrackedChangeBase.LogSyncEvent(TAG, " --- Changes applied!", null);
          }
          BeyondPodApplication.MessageBus.PublishEventAsync(new RepositoryEvents.RepositoryEvent(15));
          SaveHistoryAsync();
          FeedRepository.SaveRepositoryAsync();
          j = i;
          if (_RecentlyImportedFeeds.size() <= 0) {
            break;
          }
          j = i;
          if (UpdateAndDownloadManager.IsWorking()) {
            break;
          }
          CoreHelper.WriteTraceEntryInDebug(TAG, " --- Refreshing " + _RecentlyImportedFeeds.size() + " recently imported feeds...");
          UpdateAndDownloadManager.StartQuickUpdate(_RecentlyImportedFeeds);
          _RecentlyImportedFeeds.clear();
          return i;
        }
        TrackedChangeBase localTrackedChangeBase = (TrackedChangeBase)localIterator.next();
        if (localTrackedChangeBase.SyncStatus() != 3) {
          continue;
        }
        ((ArrayList)localObject1).add(localTrackedChangeBase);
      }
      label251:
      ((TrackedChangeBase)((Iterator)localObject2).next()).ApplyRemoteChange();
      i += 1;
    }
  }
  
  public static void CleanAllRecords()
  {
    CleanRecordsInternal(false);
  }
  
  private static void CleanRecordsInternal(boolean paramBoolean)
  {
    int i = 0;
    for (;;)
    {
      Object localObject3;
      TrackedChangeBase localTrackedChangeBase;
      synchronized (m_history)
      {
        localObject3 = new ArrayList();
        Object localObject1 = Calendar.getInstance();
        ((Calendar)localObject1).setTime(new Date());
        ((Calendar)localObject1).add(2, -1);
        Object localObject4 = ((Calendar)localObject1).getTime();
        Iterator localIterator = History().iterator();
        if (!localIterator.hasNext())
        {
          m_history.removeAll((Collection)localObject3);
          localObject3 = TAG;
          localObject4 = new StringBuilder("*** Cleaned ").append(i);
          if (!paramBoolean) {
            break label259;
          }
          localObject1 = " stale";
          CoreHelper.WriteTraceEntry((String)localObject3, (String)localObject1 + " sync records");
          if (i > 0) {
            SaveHistoryAsync();
          }
          return;
        }
        localTrackedChangeBase = (TrackedChangeBase)localIterator.next();
        if ((paramBoolean) && (!IsStaleRecord(localTrackedChangeBase, ((Date)localObject4).getTime()))) {
          continue;
        }
        String str2 = TAG;
        StringBuilder localStringBuilder = new StringBuilder("Cleaning ");
        if (paramBoolean)
        {
          localObject1 = "stale";
          CoreHelper.WriteTraceEntry(str2, (String)localObject1 + " record for: " + localTrackedChangeBase);
          i += 1;
          if (localTrackedChangeBase.RowID().longValue() == -1L) {
            break label248;
          }
          localTrackedChangeBase.MarkDeleted();
        }
      }
      String str1 = "";
      continue;
      label248:
      ((ArrayList)localObject3).add(localTrackedChangeBase);
      continue;
      label259:
      str1 = "";
    }
  }
  
  public static void CleanStaleRecords()
  {
    CleanRecordsInternal(true);
  }
  
  public static String DeviceID()
  {
    return Build.MANUFACTURER + " " + Build.MODEL + " " + Settings.Secure.getString(BeyondPodApplication.GetInstance().getContentResolver(), "android_id");
  }
  
  public static void DumpHistory()
  {
    CoreHelper.WriteTraceEntry(TAG, "*************** Unsynchronized Changes **************");
    ArrayList localArrayList = (ArrayList)History().clone();
    Collections.sort(localArrayList, TrackedChangeBase.TimestampComparator);
    int i = 0;
    Iterator localIterator = localArrayList.iterator();
    for (;;)
    {
      if (!localIterator.hasNext())
      {
        CoreHelper.WriteTraceEntry(TAG, "********** Dump Completed - " + i + " of " + localArrayList.size() + " records *******************");
        return;
      }
      TrackedChangeBase localTrackedChangeBase = (TrackedChangeBase)localIterator.next();
      if ((IsChangeUploadPending(localTrackedChangeBase)) || (IsChangeDownPending(localTrackedChangeBase)))
      {
        i += 1;
        CoreHelper.WriteTraceEntry(TAG, "   * " + localTrackedChangeBase.toString());
      }
    }
  }
  
  private static TrackedChangeBase FindExistingDownPendingChangeFor(TrackedChangeBase paramTrackedChangeBase)
  {
    Iterator localIterator = History().iterator();
    TrackedChangeBase localTrackedChangeBase;
    do
    {
      if (!localIterator.hasNext()) {
        return null;
      }
      localTrackedChangeBase = (TrackedChangeBase)localIterator.next();
    } while ((!localTrackedChangeBase.MessageId().equals(paramTrackedChangeBase.MessageId())) || (localTrackedChangeBase.ChangeType() != paramTrackedChangeBase.ChangeType()) || (!IsChangeDownPending(localTrackedChangeBase)));
    return localTrackedChangeBase;
  }
  
  private static TrackedChangeBase FindExistingUpPendingChangeFor(TrackedChangeBase paramTrackedChangeBase)
  {
    Iterator localIterator = History().iterator();
    TrackedChangeBase localTrackedChangeBase;
    do
    {
      if (!localIterator.hasNext()) {
        return null;
      }
      localTrackedChangeBase = (TrackedChangeBase)localIterator.next();
    } while ((!localTrackedChangeBase.MessageId().equals(paramTrackedChangeBase.MessageId())) || (localTrackedChangeBase.ChangeType() != paramTrackedChangeBase.ChangeType()) || (!IsChangeUploadPending(localTrackedChangeBase)));
    return localTrackedChangeBase;
  }
  
  public static boolean HasUploadPendingChanges()
  {
    if (!_IsInitialized) {
      return false;
    }
    do
    {
      synchronized (m_history)
      {
        Iterator localIterator = History().iterator();
        if (!localIterator.hasNext()) {
          return false;
        }
      }
    } while (!IsChangeUploadPending((TrackedChangeBase)((Iterator)localObject).next()));
    return true;
  }
  
  private static ArrayList<TrackedChangeBase> History()
  {
    return m_history;
  }
  
  public static void InitializeHistory()
  {
    if (!IsTrackingEnabled())
    {
      CoreHelper.WriteTraceEntry(TAG, "Change Tracking is disabled! Ignoring...");
      return;
    }
    if (_IsInitialized)
    {
      CoreHelper.WriteTraceEntry(TAG, "Change Tracking already initialized! Ignoring...");
      return;
    }
    History().clear();
    localDatabaseHelper = new DatabaseHelper(BeyondPodApplication.GetInstance().getApplicationContext());
    try
    {
      localDatabaseHelper.LoadTrackedChanges(m_history);
      CoreHelper.WriteTraceEntry(TAG, "Loaded " + m_history.size() + " change tracking records!");
      _IsInitialized = true;
      localDatabaseHelper.cleanup();
      CleanStaleRecords();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        CoreHelper.LogException(TAG, "Unable to load the change history from database", localException);
        localDatabaseHelper.cleanup();
      }
    }
    finally
    {
      localDatabaseHelper.cleanup();
    }
  }
  
  private static boolean IsChangeDownPending(TrackedChangeBase paramTrackedChangeBase)
  {
    return (!paramTrackedChangeBase.IsMarkedForDeletion()) && (paramTrackedChangeBase.SyncStatus() == 3);
  }
  
  private static boolean IsChangeUploadPending(TrackedChangeBase paramTrackedChangeBase)
  {
    return (!paramTrackedChangeBase.IsMarkedForDeletion()) && (paramTrackedChangeBase.SyncStatus() == 2);
  }
  
  public static boolean IsDeviceTimeCorrect(Date paramDate)
  {
    return Math.abs(new Date().getTime() - paramDate.getTime()) < 120000L;
  }
  
  public static boolean IsInitialized()
  {
    return _IsInitialized;
  }
  
  private static boolean IsStaleRecord(TrackedChangeBase paramTrackedChangeBase, long paramLong)
  {
    if ((paramTrackedChangeBase.SyncStatus() == 4) || (paramTrackedChangeBase.SyncStatus() == 1)) {}
    while (paramLong > paramTrackedChangeBase.TimeStamp()) {
      return true;
    }
    return false;
  }
  
  public static boolean IsSyncLicenseValid()
  {
    return !LicenseManager.IfInRestrictedMode();
  }
  
  public static boolean IsTrackingEnabled()
  {
    return (IsSyncLicenseValid()) && (Configuration.CDSEnabled()) && (!StringUtils.IsNullOrEmpty(Configuration.CDSUserName())) && (!StringUtils.IsNullOrEmpty(Configuration.CDSPassword()));
  }
  
  public static void OnFeedImported(Feed paramFeed)
  {
    _RecentlyImportedFeeds.add(paramFeed);
  }
  
  public static ArrayList<TrackedChangeBase> PendingUploadChanges()
  {
    ArrayList localArrayList2 = new ArrayList();
    if (!_IsInitialized)
    {
      CoreHelper.WriteTraceEntryInDebug(TAG, "Trying to add tracked change before initializing the change tracking repository!");
      return localArrayList2;
    }
    synchronized (m_history)
    {
      Iterator localIterator = History().iterator();
      TrackedChangeBase localTrackedChangeBase;
      do
      {
        if (!localIterator.hasNext())
        {
          Collections.sort(localArrayList2, TrackedChangeBase.TimestampComparator);
          return localArrayList2;
        }
        localTrackedChangeBase = (TrackedChangeBase)localIterator.next();
      } while (!IsChangeUploadPending(localTrackedChangeBase));
      localArrayList2.add(localTrackedChangeBase);
    }
  }
  
  public static void SaveHistoryAsync()
  {
    RepositoryPersistence.RepositoryHandler().removeCallbacks(_SaveHistoryRunnable);
    RepositoryPersistence.RepositoryHandler().postDelayed(_SaveHistoryRunnable, 1000L);
  }
  
  private static void SaveHistoryInternal()
  {
    for (;;)
    {
      synchronized (m_history)
      {
        if (_SavingHistory) {
          return;
        }
        _SavingHistory = true;
        DatabaseHelper localDatabaseHelper = new DatabaseHelper(BeyondPodApplication.GetInstance().getApplicationContext());
        localDatabaseHelper.beginTransaction();
        localArrayList2 = new ArrayList();
        try
        {
          localIterator = History().iterator();
          if (localIterator.hasNext()) {
            break label93;
          }
          localDatabaseHelper.setTransactionSuccessful();
          localDatabaseHelper.endTransaction();
          localDatabaseHelper.cleanup();
          History().removeAll(localArrayList2);
          _SavingHistory = false;
        }
        catch (Exception localException)
        {
          Iterator localIterator;
          TrackedChangeBase localTrackedChangeBase;
          CoreHelper.LogException(TAG, "Failed to save change history to the database!", localException);
          ((DatabaseHelper)localObject1).endTransaction();
          ((DatabaseHelper)localObject1).cleanup();
          History().removeAll(localArrayList2);
          _SavingHistory = false;
          continue;
        }
        finally
        {
          ((DatabaseHelper)localObject1).endTransaction();
          ((DatabaseHelper)localObject1).cleanup();
          History().removeAll(localArrayList2);
          _SavingHistory = false;
        }
        return;
      }
      label93:
      localTrackedChangeBase = (TrackedChangeBase)localIterator.next();
      if ((localTrackedChangeBase.IsNew()) || (localTrackedChangeBase.IsModified()))
      {
        localTrackedChangeBase.PrepareForSave();
        ((DatabaseHelper)localObject1).SaveTrackedChange(localTrackedChangeBase);
      }
      if ((localTrackedChangeBase.IsMarkedForDeletion()) && (((DatabaseHelper)localObject1).DeleteTrackedChange(localTrackedChangeBase))) {
        localArrayList2.add(localTrackedChangeBase);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/sync/ChangeTracker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */