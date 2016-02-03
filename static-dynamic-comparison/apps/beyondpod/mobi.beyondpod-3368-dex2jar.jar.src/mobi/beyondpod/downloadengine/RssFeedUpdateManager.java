package mobi.beyondpod.downloadengine;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mobi.beyondpod.BeyondPodApplication;
import mobi.beyondpod.aggregators.AggregatorLoginHelper;
import mobi.beyondpod.aggregators.AggregatorLoginHelper.AuthenticationException;
import mobi.beyondpod.rsscore.Configuration;
import mobi.beyondpod.rsscore.Feed;
import mobi.beyondpod.rsscore.FeedList;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.helpers.CoreHelper.IssuficientStorageSpaceException;
import mobi.beyondpod.rsscore.helpers.CoreHelper.UnableToEstablishNetworkConnectionException;
import mobi.beyondpod.rsscore.helpers.GenericQueue;
import mobi.beyondpod.rsscore.repository.FeedRepository;
import mobi.beyondpod.rsscore.repository.FlashStorageLocation;

public class RssFeedUpdateManager
{
  private static final String TAG = RssFeedUpdateManager.class.getSimpleName();
  private static ArrayList<FeedBatchUpdateListener> _FeedBatchUpdateListeners;
  private static int _FeedCountAtBatchStart;
  static RssFeedCatcher.FeedUpdateListener _FeedUpdateListener;
  private static int _FeedsFailedCount;
  private static int _FeedsUnchangedCount;
  private static int _FeedsWithNewContentCount;
  private static final DownloadStatisticsList _UpdateStatistics;
  private static boolean m_AtQueueStart;
  private static final RssFeedCatcher m_Catcher = new RssFeedCatcher();
  private static final HashMap<String, RetryInfo> m_RetryList;
  private static final GenericQueue<Feed> m_UpdateQueue = new GenericQueue();
  
  static
  {
    m_AtQueueStart = false;
    m_RetryList = new HashMap();
    _UpdateStatistics = new DownloadStatisticsList();
    _FeedBatchUpdateListeners = new ArrayList();
    _FeedUpdateListener = new RssFeedCatcher.FeedUpdateListener()
    {
      public void OnFeedUpdateCompleted(Feed paramAnonymousFeed)
      {
        if (RssFeedUpdateManager.m_RetryList.containsKey(paramAnonymousFeed.getFeedUrl())) {
          RssFeedUpdateManager.m_RetryList.remove(paramAnonymousFeed.getFeedUrl());
        }
        synchronized (RssFeedUpdateManager._FeedBatchUpdateListeners)
        {
          Iterator localIterator = RssFeedUpdateManager._FeedBatchUpdateListeners.iterator();
          if (!localIterator.hasNext())
          {
            FeedRepository.NotifyFeedChanged(paramAnonymousFeed);
            RssFeedUpdateManager.UpdateStatistics(paramAnonymousFeed);
            RssFeedUpdateManager.DoNextFeed(true);
            return;
          }
          ((RssFeedUpdateManager.FeedBatchUpdateListener)localIterator.next()).OnFeedUpdateCompleted(paramAnonymousFeed);
        }
      }
      
      public void OnFeedUpdateError(Feed paramAnonymousFeed, Exception paramAnonymousException)
      {
        FeedRepository.NotifyFeedChanged(paramAnonymousFeed);
        RssFeedUpdateManager.UpdateStatistics(paramAnonymousFeed);
        if ((paramAnonymousException instanceof CoreHelper.UnableToEstablishNetworkConnectionException))
        {
          RssFeedUpdateManager.TerminateAllUpdates();
          return;
        }
        if (RssFeedUpdateManager.ShouldRetry(paramAnonymousFeed, paramAnonymousException)) {}
        for (boolean bool = false;; bool = true)
        {
          RssFeedUpdateManager.DoNextFeed(bool);
          return;
        }
      }
      
      public void OnFeedUpdateProgress(Feed paramAnonymousFeed)
      {
        if ((RssFeedUpdateManager.m_RetryList.containsKey(paramAnonymousFeed.getFeedUrl())) && (((RssFeedUpdateManager.RetryInfo)RssFeedUpdateManager.m_RetryList.get(paramAnonymousFeed.getFeedUrl())).IsCancelable())) {
          RssFeedUpdateManager.m_RetryList.remove(paramAnonymousFeed.getFeedUrl());
        }
        synchronized (RssFeedUpdateManager._FeedBatchUpdateListeners)
        {
          Iterator localIterator = RssFeedUpdateManager._FeedBatchUpdateListeners.iterator();
          if (!localIterator.hasNext()) {
            return;
          }
          ((RssFeedUpdateManager.FeedBatchUpdateListener)localIterator.next()).OnFeedUpdateProgress(paramAnonymousFeed);
        }
      }
      
      public void OnFeedUpdateStarted(Feed paramAnonymousFeed)
      {
        if (RssFeedUpdateManager.IsAtQueueStart()) {
          RssFeedUpdateManager.OnUpdateBatchStarted();
        }
        synchronized (RssFeedUpdateManager._FeedBatchUpdateListeners)
        {
          Iterator localIterator = RssFeedUpdateManager._FeedBatchUpdateListeners.iterator();
          if (!localIterator.hasNext())
          {
            FeedRepository.NotifyFeedChanged(paramAnonymousFeed);
            return;
          }
          ((RssFeedUpdateManager.FeedBatchUpdateListener)localIterator.next()).OnFeedUpdateStarted(paramAnonymousFeed);
        }
      }
      
      public void OnFeedUpdateTerminated(Feed paramAnonymousFeed)
      {
        FeedRepository.NotifyFeedChanged(paramAnonymousFeed);
      }
    };
    m_Catcher.setFeedUpdateListener(_FeedUpdateListener);
  }
  
  public static Feed CurrentFeed()
  {
    if (m_UpdateQueue.size() == 0) {
      return null;
    }
    return (Feed)m_UpdateQueue.peek();
  }
  
  private static void DoNextFeed(boolean paramBoolean)
  {
    if (m_UpdateQueue.size() > 0)
    {
      if (!paramBoolean) {
        break label28;
      }
      m_UpdateQueue.dequeue();
    }
    for (;;)
    {
      m_AtQueueStart = false;
      UpdateQueuedFeeds();
      return;
      label28:
      CoreHelper.KeepDeviceAwake();
      CoreHelper.WriteLogEntryInProduction(TAG, "@@@@@ Sleeping before feed update retry...");
      CoreHelper.nap(10);
    }
  }
  
  public static int FeedCountAtBatchStart()
  {
    return _FeedCountAtBatchStart;
  }
  
  public static int FeedsFailedCount()
  {
    return Statistics().GetFailedDownloads().size();
  }
  
  public static int FeedsUnchangedCount()
  {
    return _FeedsUnchangedCount;
  }
  
  public static int FeedsWithNewContentCount()
  {
    return _FeedsWithNewContentCount;
  }
  
  public static boolean IsAtQueueStart()
  {
    return m_AtQueueStart;
  }
  
  public static boolean IsUpdating()
  {
    return (m_Catcher.IsUpdating()) || (m_UpdateQueue.size() > 0);
  }
  
  static void OnUpdateBatchCompleted()
  {
    CoreHelper.WriteTraceEntry(TAG, "Update Batch Completed!");
    synchronized (_FeedBatchUpdateListeners)
    {
      Iterator localIterator = _FeedBatchUpdateListeners.iterator();
      if (!localIterator.hasNext()) {
        return;
      }
      ((FeedBatchUpdateListener)localIterator.next()).OnFeedBatchUpdateCompleted();
    }
  }
  
  static void OnUpdateBatchStarted()
  {
    CoreHelper.WriteTraceEntry(TAG, "Update Batch Started!");
    _UpdateStatistics.clear();
    _UpdateStatistics.DownloadTime = new Date();
    _UpdateStatistics.IsUnattended = UpdateAndDownloadManager.IsUnattended();
    _FeedCountAtBatchStart = QueueCount();
  }
  
  private static boolean PrepareForUpdate()
  {
    Object localObject1 = new FlashStorageLocation(Configuration.RssCachePath());
    if (!CoreHelper.IsAlreadyConnectedOrWiFiShouldBeTurnedOnDuringUpdate())
    {
      CoreHelper.WriteLogEntryInProduction(TAG, "Found that the device has no Internet connection and the WiFi should not be turned on! Canceling Downloads...");
      synchronized (_FeedBatchUpdateListeners)
      {
        localObject1 = _FeedBatchUpdateListeners.iterator();
        if (!((Iterator)localObject1).hasNext()) {
          return false;
        }
        ((FeedBatchUpdateListener)((Iterator)localObject1).next()).OnFeedBatchUpdateUnableToEstablishNetworkConnection();
      }
    }
    if ((m_Catcher.IsUpdating()) || (EnclosureDownloadManager.IsDownloading())) {
      for (;;)
      {
        synchronized (_FeedBatchUpdateListeners)
        {
          Iterator localIterator1 = _FeedBatchUpdateListeners.iterator();
          if (!localIterator1.hasNext()) {
            return false;
          }
        }
        ((FeedBatchUpdateListener)((Iterator)localObject3).next()).OnAnotherUpdateIsInProgress();
      }
    }
    if (!((FlashStorageLocation)localObject3).CheckIfSpaceIsAvailable(204800L)) {
      for (;;)
      {
        Iterator localIterator2;
        synchronized (_FeedBatchUpdateListeners)
        {
          localIterator2 = _FeedBatchUpdateListeners.iterator();
          if (!localIterator2.hasNext()) {
            return false;
          }
        }
        ((FeedBatchUpdateListener)localIterator2.next()).OnInsufficientSpaceAtDownloadLocation(localFlashStorageLocation);
      }
    }
    ResetUpdateCounters();
    m_RetryList.clear();
    m_UpdateQueue.clear();
    m_AtQueueStart = true;
    return true;
  }
  
  public static int QueueCount()
  {
    return m_UpdateQueue.size();
  }
  
  public static void ResetUpdateCounters()
  {
    _FeedsUnchangedCount = 0;
    _FeedCountAtBatchStart = 0;
    _FeedsWithNewContentCount = 0;
    _FeedsFailedCount = 0;
  }
  
  private static boolean ShouldRetry(Feed paramFeed, Exception paramException)
  {
    int i = 1;
    if ((paramException instanceof CoreHelper.IssuficientStorageSpaceException))
    {
      i = 0;
      BeyondPodApplication.PokeWiFiIfNeeded(paramException);
      paramFeed = paramFeed.getFeedUrl();
      if (i == 0) {
        break label96;
      }
      if (!m_RetryList.containsKey(paramFeed)) {
        break label76;
      }
      ((RetryInfo)m_RetryList.get(paramFeed)).DoRetry();
    }
    for (;;)
    {
      return ((RetryInfo)m_RetryList.get(paramFeed)).CanRetry();
      if (!(paramException instanceof AggregatorLoginHelper.AuthenticationException)) {
        break;
      }
      AggregatorLoginHelper.ClearAccountToken();
      i = 1;
      break;
      label76:
      m_RetryList.put(paramFeed, new RetryInfo(paramException, 1));
      continue;
      label96:
      m_RetryList.put(paramFeed, new RetryInfo(paramException, 0));
    }
  }
  
  public static DownloadStatisticsList Statistics()
  {
    return _UpdateStatistics;
  }
  
  public static void TerminateAllUpdates()
  {
    if (m_Catcher.IsUpdating()) {
      m_Catcher.Stop();
    }
    if (m_UpdateQueue.hasItems()) {
      m_UpdateQueue.clear();
    }
    synchronized (_FeedBatchUpdateListeners)
    {
      Iterator localIterator = _FeedBatchUpdateListeners.iterator();
      if (!localIterator.hasNext()) {
        return;
      }
      ((FeedBatchUpdateListener)localIterator.next()).OnFeedBatchUpdateCanceled();
    }
  }
  
  private static void UpdateFeedInternal(Feed paramFeed)
  {
    if ((paramFeed == null) || (!paramFeed.HasUrl())) {
      throw new IllegalArgumentException("Error updating feed: both Feed and Feed.URL are required parameters");
    }
    synchronized (_FeedBatchUpdateListeners)
    {
      Iterator localIterator = _FeedBatchUpdateListeners.iterator();
      if (!localIterator.hasNext())
      {
        m_Catcher.UpdateFeed(paramFeed, false);
        return;
      }
      ((FeedBatchUpdateListener)localIterator.next()).OnFeedBatchUpdateStarted(paramFeed);
    }
  }
  
  public static void UpdateFeeds(FeedList paramFeedList)
  {
    if (!PrepareForUpdate()) {
      return;
    }
    paramFeedList = paramFeedList.iterator();
    for (;;)
    {
      if (!paramFeedList.hasNext())
      {
        UpdateQueuedFeeds();
        return;
      }
      Feed localFeed = (Feed)paramFeedList.next();
      m_UpdateQueue.enqueue(localFeed);
    }
  }
  
  public static FeedList UpdateQueue()
  {
    FeedList localFeedList = new FeedList();
    int i = 0;
    for (;;)
    {
      if (i == m_UpdateQueue.size()) {
        return localFeedList;
      }
      localFeedList.add((Feed)m_UpdateQueue.get(i));
      i += 1;
    }
  }
  
  private static void UpdateQueuedFeeds()
  {
    if (CurrentFeed() != null)
    {
      UpdateFeedInternal(CurrentFeed());
      return;
    }
    OnUpdateBatchCompleted();
  }
  
  private static void UpdateStatistics(Feed paramFeed)
  {
    if (m_Catcher.Statistics() != null)
    {
      m_Catcher.Statistics().OwnerFeed = paramFeed;
      if (!m_Catcher.Statistics().HasErrors()) {
        break label53;
      }
      _FeedsFailedCount += 1;
    }
    for (;;)
    {
      _UpdateStatistics.add(m_Catcher.Statistics());
      return;
      label53:
      if (paramFeed.HasNewContent()) {
        _FeedsWithNewContentCount += 1;
      } else {
        _FeedsUnchangedCount += 1;
      }
    }
  }
  
  public static void addFeedBatchUpdateListener(FeedBatchUpdateListener paramFeedBatchUpdateListener)
  {
    synchronized (_FeedBatchUpdateListeners)
    {
      if (_FeedBatchUpdateListeners.contains(paramFeedBatchUpdateListener)) {
        return;
      }
      _FeedBatchUpdateListeners.add(paramFeedBatchUpdateListener);
      return;
    }
  }
  
  public static void removeFeedBatchUpdateListener(FeedBatchUpdateListener paramFeedBatchUpdateListener)
  {
    synchronized (_FeedBatchUpdateListeners)
    {
      if (!_FeedBatchUpdateListeners.contains(paramFeedBatchUpdateListener)) {
        return;
      }
      _FeedBatchUpdateListeners.remove(paramFeedBatchUpdateListener);
      return;
    }
  }
  
  public static abstract interface FeedBatchUpdateListener
  {
    public abstract void OnAnotherUpdateIsInProgress();
    
    public abstract void OnFeedBatchUpdateCanceled();
    
    public abstract void OnFeedBatchUpdateCompleted();
    
    public abstract void OnFeedBatchUpdateStarted(Feed paramFeed);
    
    public abstract void OnFeedBatchUpdateUnableToEstablishNetworkConnection();
    
    public abstract void OnFeedUpdateCompleted(Feed paramFeed);
    
    public abstract void OnFeedUpdateProgress(Feed paramFeed);
    
    public abstract void OnFeedUpdateStarted(Feed paramFeed);
    
    public abstract void OnInsufficientSpaceAtDownloadLocation(FlashStorageLocation paramFlashStorageLocation);
  }
  
  private static class RetryInfo
  {
    public Exception Reason;
    public int RetryCount;
    
    RetryInfo(Exception paramException, int paramInt)
    {
      this.RetryCount = paramInt;
      this.Reason = paramException;
    }
    
    public boolean CanRetry()
    {
      return this.RetryCount > 0;
    }
    
    public void DoRetry()
    {
      this.RetryCount -= 1;
    }
    
    public boolean IsCancelable()
    {
      return !(this.Reason instanceof AggregatorLoginHelper.AuthenticationException);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/downloadengine/RssFeedUpdateManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */