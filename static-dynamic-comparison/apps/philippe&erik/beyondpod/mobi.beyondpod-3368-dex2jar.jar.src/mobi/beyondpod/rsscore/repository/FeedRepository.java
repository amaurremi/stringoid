package mobi.beyondpod.rsscore.repository;

import android.os.Handler;
import java.io.File;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mobi.beyondpod.BeyondPodApplication;
import mobi.beyondpod.rsscore.Configuration;
import mobi.beyondpod.rsscore.Feed;
import mobi.beyondpod.rsscore.FeedList;
import mobi.beyondpod.rsscore.StartupContentBuilder;
import mobi.beyondpod.rsscore.Track;
import mobi.beyondpod.rsscore.TrackDictionary;
import mobi.beyondpod.rsscore.TrackFilter;
import mobi.beyondpod.rsscore.TrackList;
import mobi.beyondpod.rsscore.TrackSorter;
import mobi.beyondpod.rsscore.categories.CategoryList;
import mobi.beyondpod.rsscore.categories.CategoryManager;
import mobi.beyondpod.rsscore.categories.FeedCategories;
import mobi.beyondpod.rsscore.categories.FeedCategory;
import mobi.beyondpod.rsscore.helpers.AnalyticsTracker;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.helpers.DateTime;
import mobi.beyondpod.rsscore.helpers.FileUtils;
import mobi.beyondpod.rsscore.helpers.Path;
import mobi.beyondpod.rsscore.helpers.SimpleMessageBus;
import mobi.beyondpod.rsscore.helpers.StringUtils;
import mobi.beyondpod.rsscore.helpers.TimeSpan;
import mobi.beyondpod.rsscore.rss.RssFeedCache;
import mobi.beyondpod.schedulercore.ScheduledTask;
import mobi.beyondpod.sync.ChangeTracker;
import mobi.beyondpod.ui.core.FeedImageCache;
import mobi.beyondpod.ui.core.MusicUtils;
import mobi.beyondpod.ui.core.volley.DiskBasedCacheBP;

public final class FeedRepository
{
  public static final UUID FEED_SEARCH_RESULT_ROOT_ID = ;
  public static int RepositoryLoadKind = 0;
  private static final String TAG = "FeedRepository";
  private static final Feed _GoUpPlaceholder;
  static long _LastSavedTime;
  public static long _RepEndLoadTime;
  public static long _RepEndSaveTime;
  public static long _RepStartLoadTime;
  public static long _RepStartSaveTime;
  public static long _RepXMlReadEndTime;
  private static volatile int _RepositoryState;
  private static final Feed _RootFeed = new Feed(null, null);
  static File _RootPatchKey = null;
  private static String _RootPath;
  static TrackDictionary _TrackDictionary;
  
  static
  {
    _GoUpPlaceholder = new Feed(UUID.randomUUID(), _RootFeed);
    _TrackDictionary = new TrackDictionary();
    _LastSavedTime = System.currentTimeMillis();
    _RepositoryState = -1;
    RepositoryLoadKind = -1;
    _GoUpPlaceholder.setName("..");
  }
  
  public static TrackList AllResumableDownloads()
  {
    FilterTracks(new TrackFilter()
    {
      public boolean apply(Track paramAnonymousTrack)
      {
        return (paramAnonymousTrack != null) && (paramAnonymousTrack.HasDownloadStarted()) && (!paramAnonymousTrack.IsFullyDownloaded());
      }
    });
  }
  
  public static void AutoSaveRepository() {}
  
  public static boolean CanRepositoryBeLoaded()
  {
    return (CoreHelper.ExternalStorageState().equals("mounted")) && (!StringUtils.IsNullOrEmpty(Configuration.EnclosureDownloadRoot()));
  }
  
  public static void ClearTrackImageCaches()
  {
    Iterator localIterator = _TrackDictionary.values().iterator();
    for (;;)
    {
      if (!localIterator.hasNext())
      {
        SaveRepositoryAsync();
        return;
      }
      ((Track)localIterator.next()).setTrackImagePath(null);
    }
  }
  
  public static String ConvertToAbsolutePath(String paramString)
  {
    String str = paramString;
    if (paramString != null)
    {
      str = paramString;
      if (paramString.startsWith("~")) {
        str = Configuration.EnclosureDownloadRoot() + paramString.substring(1);
      }
    }
    return str;
  }
  
  public static String ConvertToRelativePath(String paramString)
  {
    String str = paramString;
    if (paramString != null)
    {
      str = paramString;
      if (paramString.startsWith(Configuration.EnclosureDownloadRoot())) {
        str = "~" + paramString.substring(Configuration.EnclosureDownloadRoot().length());
      }
    }
    return str;
  }
  
  public static void DeleteAllRepositoryFiles() {}
  
  public static void DeleteFeedAndRelatedFoldersAsync(Feed paramFeed)
  {
    RepositoryPersistence.RepositoryHandler().post(new Runnable()
    {
      public void run()
      {
        FeedRepository.DeleteFeedAndRelatedFoldersSync(FeedRepository.this);
      }
    });
  }
  
  public static void DeleteFeedAndRelatedFoldersSync(Feed paramFeed)
  {
    for (;;)
    {
      int i;
      try
      {
        if (paramFeed.getType() == 1)
        {
          RemoveFromTrackDictionary(paramFeed.TracksAndSubTracks());
          paramFeed.SubFeeds().clear();
          getRootFeed().SubFeeds().remove(paramFeed);
          RepositoryPersistence.DeleteFeed(paramFeed);
          if (Configuration.getActiveFeedFilter() == paramFeed) {
            Configuration.setActiveFeedFilter(null);
          }
          OnFeedDeleted(paramFeed);
          RssFeedCache.DeleteFeedCacheFor(paramFeed);
          FeedImageCache.DeleteImageCacheFor(paramFeed);
          SaveRepositoryAsync();
          StartupContentBuilder.BackupRepositoriesAsync();
          if (!Configuration.ForceMediaDatabaseRescanOnDownloadOrDelete()) {
            break;
          }
          MusicUtils.ForceMediaScanFor(paramFeed.getFeedPath());
          return;
        }
        Object localObject = (Track[])paramFeed.Tracks().toArray(new Track[paramFeed.Tracks().size()]);
        int j = localObject.length;
        i = 0;
        if (i >= j)
        {
          if (!FileUtils.DirectoryExists(paramFeed.getFeedPath())) {
            continue;
          }
          localObject = new File(paramFeed.getFeedPath());
          if (((File)localObject).list().length != 0) {
            break label215;
          }
          ((File)localObject).delete();
          CoreHelper.WriteTraceEntry("FeedRepository", "Deleting feed download folder: " + paramFeed.getFeedPath());
          continue;
        }
        DeleteTrackSync(localException[i]);
      }
      catch (Exception localException)
      {
        CoreHelper.LogException("FeedRepository", "Failed to delete feed: " + paramFeed.getName(), localException);
        return;
      }
      i += 1;
      continue;
      label215:
      CoreHelper.WriteLogEntry("FeedRepository", "Unable to delete feed download folder: " + paramFeed.getFeedPath());
    }
  }
  
  public static void DeleteOldTracksForFeed(Feed paramFeed, boolean paramBoolean)
    throws Exception
  {
    paramFeed = GetOldTracksForFeed(paramFeed, paramBoolean).iterator();
    for (;;)
    {
      if (!paramFeed.hasNext()) {
        return;
      }
      DeleteTrackAsync((Track)paramFeed.next());
    }
  }
  
  public static void DeleteScheduledTask(ScheduledTask paramScheduledTask)
  {
    RepositoryPersistence.DeleteScheduledTask(paramScheduledTask);
  }
  
  public static void DeleteTrackAsync(Track paramTrack)
  {
    RepositoryPersistence.RepositoryHandler().post(new Runnable()
    {
      public void run()
      {
        FeedRepository.DeleteTrackSync(FeedRepository.this);
      }
    });
  }
  
  public static void DeleteTrackSync(Track paramTrack)
  {
    CoreHelper.WriteTraceEntry("FeedRepository", "Deleting track: " + paramTrack.getName() + " ...");
    try
    {
      OnTrackBeforeDelete(paramTrack);
      if (DiskBasedCacheBP.deleteFileForKey("episode://" + paramTrack.TrackPath())) {
        CoreHelper.WriteTraceEntry("FeedRepository", "Deleted track episode image cache");
      }
      paramTrack.Delete();
      synchronized (_TrackDictionary)
      {
        _TrackDictionary.remove(paramTrack.TrackPath());
        paramTrack.getParentFeed().Tracks().remove(paramTrack);
        ChangeTracker.AddLocalEpisodeDeletedChange(paramTrack);
        OnTrackDeleted(paramTrack);
        RepositoryPersistence.DeleteTrack(paramTrack);
        return;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      CoreHelper.WriteLogEntry("FeedRepository", "Unable to delete track! Reason:" + localThrowable.getMessage());
      BeyondPodApplication.MessageBus.PublishEventAsync(RepositoryEvents.RepositoryEvent.FromException(new Exception("Unable to delete track " + paramTrack.DisplayName() + "!\n" + localThrowable.getMessage())));
    }
  }
  
  public static TrackList FilterTracks(TrackFilter paramTrackFilter)
  {
    TrackList localTrackList = new TrackList();
    Iterator localIterator = _TrackDictionary.values().iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return localTrackList;
      }
      Track localTrack = (Track)localIterator.next();
      if (paramTrackFilter.apply(localTrack)) {
        localTrackList.add(localTrack);
      }
    }
  }
  
  public static Track FindOrCreateLocalTrack(Feed paramFeed, String paramString1, Date paramDate, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, boolean paramBoolean)
  {
    Object localObject;
    if (!paramFeed.EnsureFeedHasDownloadPath()) {
      localObject = null;
    }
    String str;
    do
    {
      return (Track)localObject;
      str = Path.Combine(paramFeed.getFeedPath(), CoreHelper.CreateFileNameFromUrl(paramString1, paramFeed.getForceUniqueTrackNames(), paramFeed.getName(), paramString2, paramString3));
      localTrack = GetTrackByPathOrUrl(str, paramString1);
      localObject = localTrack;
    } while (localTrack != null);
    Track localTrack = new Track(str, paramFeed);
    if (!StringUtils.IsNullOrEmpty(paramString4)) {
      localTrack.setName(paramString4);
    }
    localTrack.setUrl(paramString1);
    localTrack.setProtocol("rss");
    if (paramDate != null) {}
    for (;;)
    {
      localTrack.setLastModifiedDate(paramDate);
      localTrack.setRssItemID(paramString2);
      localTrack.setTrackDescription(paramString5);
      localTrack.setTrackPostTitle(paramString4);
      localTrack.setTrackPostUrl(paramString6);
      if (!StringUtils.IsNullOrEmpty(paramString3)) {
        localTrack.setContentMimeType(paramString3);
      }
      RepositoryPersistence.AddChildTrack(paramFeed, localTrack, true);
      localObject = localTrack;
      if (!paramBoolean) {
        break;
      }
      ChangeTracker.AddLocalStreamableEpisodeAddedChange(localTrack);
      return localTrack;
      paramDate = new Date();
    }
  }
  
  public static Collection<Track> GetAllTracks()
  {
    return _TrackDictionary.values();
  }
  
  public static Feed GetFeedById(UUID paramUUID)
  {
    return GetFeedByIdInternal(getRootFeed(), paramUUID);
  }
  
  private static Feed GetFeedByIdInternal(Feed paramFeed, UUID paramUUID)
  {
    if (paramFeed.ID().equals(paramUUID)) {
      return paramFeed;
    }
    paramFeed = paramFeed.SubFeeds().iterator();
    Feed localFeed;
    do
    {
      do
      {
        if (!paramFeed.hasNext()) {
          return null;
        }
        localFeed = (Feed)paramFeed.next();
        if (localFeed.ID().equals(paramUUID)) {
          return localFeed;
        }
      } while (localFeed.SubFeeds().size() <= 0);
      localFeed = GetFeedByIdInternal(localFeed, paramUUID);
    } while (localFeed == null);
    return localFeed;
  }
  
  public static Feed GetFeedByUrl(String paramString)
  {
    Iterator localIterator = getRootFeed().SubFeeds().iterator();
    Feed localFeed;
    do
    {
      if (!localIterator.hasNext()) {
        return null;
      }
      localFeed = (Feed)localIterator.next();
    } while (!StringUtils.EqualsIgnoreCase(localFeed.getFeedUrl(), paramString));
    return localFeed;
  }
  
  public static int GetFeedCount()
  {
    return getRootFeed().SubFeeds().size();
  }
  
  public static FeedList GetFeedsInCategory(FeedCategory paramFeedCategory)
  {
    FeedList localFeedList = new FeedList();
    Iterator localIterator = getRootFeed().SubFeeds().iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return localFeedList;
      }
      Feed localFeed = (Feed)localIterator.next();
      if ((paramFeedCategory == CategoryManager.AllFeeds) || ((localFeed.getCategories() != null) && (localFeed.getCategories().IsOfCategory(paramFeedCategory)))) {
        localFeedList.add(localFeed);
      }
    }
  }
  
  public static TrackList GetOldTracksForFeed(Feed paramFeed, int paramInt, TimeSpan paramTimeSpan, boolean paramBoolean)
  {
    TrackList localTrackList = new TrackList();
    if ((!paramFeed.AllowsEnclosures()) || (paramFeed.Tracks().size() == 0) || (!paramFeed.CanDeleteTracks())) {
      return localTrackList;
    }
    Object localObject1 = new TrackList();
    paramFeed = paramFeed.Tracks().iterator();
    label53:
    Object localObject2;
    if (!paramFeed.hasNext())
    {
      paramFeed = new TrackSorter();
      paramFeed.SortOrder = 2;
      Collections.sort((List)localObject1, paramFeed);
      paramFeed = new TrackList();
      localObject2 = ((TrackList)localObject1).iterator();
      label96:
      if (((Iterator)localObject2).hasNext()) {
        break label239;
      }
      paramTimeSpan = paramFeed.iterator();
      label111:
      if (paramTimeSpan.hasNext()) {
        break label299;
      }
      localTrackList.addAll(paramFeed);
      int i = paramInt;
      if (paramBoolean) {
        i = paramInt - 1;
      }
      if (((TrackList)localObject1).size() > i) {
        localTrackList.addAll(((TrackList)localObject1).subList(0, ((TrackList)localObject1).size() - i));
      }
      paramFeed = new TrackList();
      paramTimeSpan = localTrackList.iterator();
    }
    for (;;)
    {
      if (!paramTimeSpan.hasNext())
      {
        if (paramFeed.size() <= 0) {
          break;
        }
        localTrackList.removeAll(paramFeed);
        return localTrackList;
        localObject2 = (Track)paramFeed.next();
        if (!((Track)localObject2).AllowAutoDelete()) {
          break label53;
        }
        ((TrackList)localObject1).add(localObject2);
        break label53;
        label239:
        Track localTrack = (Track)((Iterator)localObject2).next();
        Date localDate = paramTimeSpan.SubstractFrom(new Date());
        if ((localTrack.getLastModifiedDate() == null) || (localTrack.getLastModifiedDate().getTime() >= localDate.getTime())) {
          break label96;
        }
        paramFeed.add(localTrack);
        break label96;
        label299:
        ((TrackList)localObject1).remove((Track)paramTimeSpan.next());
        break label111;
      }
      localObject1 = (Track)paramTimeSpan.next();
      if (((Track)localObject1).TemporaryLocked()) {
        paramFeed.add(localObject1);
      }
    }
  }
  
  public static TrackList GetOldTracksForFeed(Feed paramFeed, boolean paramBoolean)
  {
    return GetOldTracksForFeed(paramFeed, paramFeed.getKeepAtMostPodcasts(), paramFeed.getMaximumPodcastAge(), paramBoolean);
  }
  
  public static String GetRepositoryLoadStatistics()
  {
    return String.format("Loaded %d feeds and %d podcasts\n%s", new Object[] { Integer.valueOf(getRootFeed().SubFeeds().size()), Integer.valueOf(GetTrackCount()), "" });
  }
  
  public static long GetRepositoryLoadTimeInSec()
  {
    return (_RepEndLoadTime - _RepStartLoadTime) / 1000L;
  }
  
  public static long GetRepositorySaveTimeInSec()
  {
    return (_RepEndSaveTime - _RepStartSaveTime) / 1000L;
  }
  
  public static Track GetTrackByPath(String paramString)
  {
    if (StringUtils.IsNullOrEmpty(paramString)) {
      return null;
    }
    Iterator localIterator = _TrackDictionary.values().iterator();
    Track localTrack;
    do
    {
      if (!localIterator.hasNext()) {
        return null;
      }
      localTrack = (Track)localIterator.next();
    } while (!StringUtils.EqualsIgnoreCase(localTrack.TrackPath(), paramString));
    return localTrack;
  }
  
  public static Track GetTrackByPathOrUrl(String paramString1, String paramString2)
  {
    Object localObject;
    if (StringUtils.IsNullOrEmpty(paramString1))
    {
      localObject = null;
      return (Track)localObject;
    }
    Iterator localIterator = _TrackDictionary.values().iterator();
    Track localTrack;
    do
    {
      if (!localIterator.hasNext()) {
        return null;
      }
      localTrack = (Track)localIterator.next();
      localObject = localTrack;
      if (StringUtils.EqualsIgnoreCase(localTrack.TrackPath(), paramString1)) {
        break;
      }
    } while ((StringUtils.IsNullOrEmpty(paramString2)) || (!StringUtils.EqualsIgnoreCase(localTrack.getUrl(), paramString2)));
    return localTrack;
  }
  
  public static Track GetTrackByUrl(String paramString)
  {
    if (StringUtils.IsNullOrEmpty(paramString)) {
      return null;
    }
    Iterator localIterator = _TrackDictionary.values().iterator();
    Track localTrack;
    do
    {
      if (!localIterator.hasNext()) {
        return null;
      }
      localTrack = (Track)localIterator.next();
    } while (!StringUtils.EqualsIgnoreCase(localTrack.getUrl(), paramString));
    return localTrack;
  }
  
  public static int GetTrackCount()
  {
    return _TrackDictionary.size();
  }
  
  public static FeedList GetUpdatableFeedsInCategory(FeedCategory paramFeedCategory)
  {
    FeedList localFeedList = new FeedList();
    Iterator localIterator = getRootFeed().SubFeeds().iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return localFeedList;
      }
      Feed localFeed = (Feed)localIterator.next();
      if ((CategoryManager.IsInCategory(localFeed, paramFeedCategory)) && (localFeed.HasUrl())) {
        localFeedList.add(localFeed);
      }
    }
  }
  
  public static Feed GetVirtualFeedByDownloadPath(String paramString)
  {
    return GetVirtualFeedByDownloadPathInternal(getRootFeed(), paramString);
  }
  
  private static Feed GetVirtualFeedByDownloadPathInternal(Feed paramFeed, String paramString)
  {
    Iterator localIterator = paramFeed.SubFeeds().iterator();
    do
    {
      Feed localFeed;
      do
      {
        if (!localIterator.hasNext()) {
          paramFeed = null;
        }
        do
        {
          return paramFeed;
          localFeed = (Feed)localIterator.next();
          if (localFeed.getFeedPath() == null) {
            break;
          }
          paramFeed = localFeed;
        } while (localFeed.getFeedPath().compareToIgnoreCase(paramString) == 0);
      } while (localFeed.SubFeeds().size() <= 0);
      paramFeed = GetVirtualFeedByDownloadPathInternal(localFeed, paramString);
    } while (paramFeed == null);
    return paramFeed;
  }
  
  public static long GetXMLReadTimeInSec()
  {
    return (_RepXMlReadEndTime - _RepStartLoadTime) / 1000L;
  }
  
  public static boolean InitializeAndLoadRepository()
  {
    if (!CanRepositoryBeLoaded())
    {
      BeyondPodApplication.MessageBus.PublishEvent(new RepositoryEvents.RepositoryEvent(-1));
      return false;
    }
    try
    {
      setRootPath(Configuration.EnclosureDownloadRoot());
      boolean bool = RepositoryPersistence.LoadRepository();
      return bool;
    }
    catch (Exception localException)
    {
      CoreHelper.LogException("FeedRepository", "Failed to load the Feed Repository. Reason: ", localException);
    }
    return false;
  }
  
  public static boolean IsDownloadFolderInUse(String paramString)
  {
    Iterator localIterator = getRootFeed().SubFeeds().iterator();
    do
    {
      if (!localIterator.hasNext()) {
        return false;
      }
    } while (!StringUtils.EqualsIgnoreCase(((Feed)localIterator.next()).getFeedPath(), paramString));
    return true;
  }
  
  public static boolean IsEmpty()
  {
    return getRootFeed().SubFeeds().size() == 0;
  }
  
  public static boolean IsRepositoryAvailable()
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (_RepositoryState != 2)
    {
      bool1 = bool2;
      if (_RepositoryState != 1)
      {
        bool1 = bool2;
        if (_RepositoryState != 3) {
          bool1 = false;
        }
      }
    }
    return bool1;
  }
  
  public static Date LongTermRepositoryBackupDate()
  {
    return RepositoryPersistence.LongTermRepositoryBackupDate();
  }
  
  public static void NotifyCategoryEvent(int paramInt)
  {
    if (_RepositoryState != 2) {
      return;
    }
    BeyondPodApplication.MessageBus.PublishEventAsync(new RepositoryEvents.RepositoryEvent(paramInt));
    SaveRepositoryAsync();
  }
  
  public static void NotifyFeedChanged(Feed paramFeed)
  {
    if (_RepositoryState != 2) {
      return;
    }
    BeyondPodApplication.MessageBus.PublishEventAsync(new RepositoryEvents.RepositoryEvent(5, paramFeed));
    AutoSaveRepository();
  }
  
  public static void NotifyTrackChanged(Track paramTrack)
  {
    if (_RepositoryState != 2) {
      return;
    }
    BeyondPodApplication.MessageBus.PublishEventAsync(new RepositoryEvents.RepositoryEvent(11, paramTrack));
    AutoSaveRepository();
  }
  
  private static void OnFeedDeleted(Feed paramFeed)
  {
    BeyondPodApplication.MessageBus.PublishEventAsync(new RepositoryEvents.RepositoryEvent(7, paramFeed));
  }
  
  static void OnRepositoryLoadComplete()
  {
    long l = System.currentTimeMillis();
    _LastSavedTime = l;
    _RepEndLoadTime = l;
    CoreHelper.WriteTraceEntry("FeedRepository", "Repository load completed!");
    _RepositoryState = 2;
    BeyondPodApplication.MessageBus.PublishEventAsync(new RepositoryEvents.RepositoryEvent(2));
    AnalyticsTracker.OnRepositoryTracksLoaded(GetTrackCount());
    DateTime.PrimeTimeZones();
  }
  
  static void OnRepositoryLoadStart()
  {
    _RepStartLoadTime = System.currentTimeMillis();
    CoreHelper.WriteTraceEntry("FeedRepository", "Repository load started...");
    _RepositoryState = 0;
    BeyondPodApplication.MessageBus.PublishEvent(new RepositoryEvents.RepositoryEvent(0));
  }
  
  static void OnRepositorySaveComplete()
  {
    long l = System.currentTimeMillis();
    _LastSavedTime = l;
    _RepEndSaveTime = l;
    CoreHelper.WriteTraceEntry("FeedRepository", "Repository save completed!");
    _RepositoryState = 2;
    BeyondPodApplication.MessageBus.PublishEventAsync(new RepositoryEvents.RepositoryEvent(4));
  }
  
  static void OnRepositorySaveStart()
  {
    CoreHelper.WriteTraceEntry("FeedRepository", "Repository save started...");
    _RepStartSaveTime = System.currentTimeMillis();
    _RepositoryState = 3;
    BeyondPodApplication.MessageBus.PublishEventAsync(new RepositoryEvents.RepositoryEvent(3));
  }
  
  static void OnRepositoryScaningForChanges()
  {
    _RepXMlReadEndTime = System.currentTimeMillis();
    CoreHelper.WriteTraceEntry("FeedRepository", "Repository Reading completed!");
    _RepositoryState = 1;
    BeyondPodApplication.MessageBus.PublishEventAsync(new RepositoryEvents.RepositoryEvent(1));
    AnalyticsTracker.OnRepositoryFeedsLoaded(GetFeedCount());
  }
  
  static void OnTrackAdded(Track paramTrack)
  {
    if (_RepositoryState != 2) {
      return;
    }
    BeyondPodApplication.MessageBus.PublishEventAsync(new RepositoryEvents.RepositoryEvent(8, paramTrack));
  }
  
  private static void OnTrackBeforeDelete(Track paramTrack)
  {
    BeyondPodApplication.MessageBus.PublishEventAsync(new RepositoryEvents.RepositoryEvent(9, paramTrack));
  }
  
  private static void OnTrackDeleted(Track paramTrack)
  {
    BeyondPodApplication.MessageBus.PublishEventAsync(new RepositoryEvents.RepositoryEvent(10, paramTrack));
  }
  
  public static String PatchRootPath(String paramString)
  {
    if (StringUtils.IsNullOrEmpty(paramString)) {}
    int i;
    do
    {
      return paramString;
      if (_RootPatchKey == null) {
        _RootPatchKey = Configuration.ConstructEnclosureDownloadRoot(Configuration.ConstructBeyondPodRootIn("/"));
      }
      i = paramString.indexOf(_RootPatchKey.getPath());
    } while (i < 0);
    return CoreHelper.ExternalStorageDirectory().getAbsolutePath() + paramString.substring(i);
  }
  
  public static void RefreshFeed(Feed paramFeed)
  {
    RemoveFromTrackDictionary(paramFeed.TracksAndSubTracks());
    paramFeed.SubFeeds().clear();
    RepositoryPersistence.BuildFeedList(paramFeed, new TrackDictionary());
  }
  
  /* Error */
  public static void RemoveFromTrackDictionary(TrackList paramTrackList)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: getstatic 64	mobi/beyondpod/rsscore/repository/FeedRepository:_TrackDictionary	Lmobi/beyondpod/rsscore/TrackDictionary;
    //   8: astore_1
    //   9: aload_1
    //   10: monitorenter
    //   11: aload_0
    //   12: invokevirtual 329	mobi/beyondpod/rsscore/TrackList:iterator	()Ljava/util/Iterator;
    //   15: astore_2
    //   16: aload_2
    //   17: invokeinterface 141 1 0
    //   22: ifne +37 -> 59
    //   25: aload_1
    //   26: monitorexit
    //   27: aload_0
    //   28: invokestatic 741	mobi/beyondpod/rsscore/repository/RepositoryPersistence:DeleteTracks	(Lmobi/beyondpod/rsscore/TrackList;)V
    //   31: return
    //   32: astore_0
    //   33: ldc 22
    //   35: new 162	java/lang/StringBuilder
    //   38: dup
    //   39: ldc_w 743
    //   42: invokespecial 168	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   45: aload_0
    //   46: invokevirtual 744	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   49: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   55: invokestatic 322	mobi/beyondpod/rsscore/helpers/CoreHelper:WriteLogEntry	(Ljava/lang/String;Ljava/lang/String;)V
    //   58: return
    //   59: aload_2
    //   60: invokeinterface 148 1 0
    //   65: checkcast 150	mobi/beyondpod/rsscore/Track
    //   68: astore_3
    //   69: getstatic 64	mobi/beyondpod/rsscore/repository/FeedRepository:_TrackDictionary	Lmobi/beyondpod/rsscore/TrackDictionary;
    //   72: aload_3
    //   73: invokevirtual 354	mobi/beyondpod/rsscore/Track:TrackPath	()Ljava/lang/String;
    //   76: invokevirtual 367	mobi/beyondpod/rsscore/TrackDictionary:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   79: pop
    //   80: goto -64 -> 16
    //   83: astore_0
    //   84: aload_1
    //   85: monitorexit
    //   86: aload_0
    //   87: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	88	0	paramTrackList	TrackList
    //   15	45	2	localIterator	Iterator
    //   68	5	3	localTrack	Track
    // Exception table:
    //   from	to	target	type
    //   5	11	32	java/lang/Exception
    //   27	31	32	java/lang/Exception
    //   86	88	32	java/lang/Exception
    //   11	16	83	finally
    //   16	27	83	finally
    //   59	80	83	finally
    //   84	86	83	finally
  }
  
  public static int RepositoryLoadState()
  {
    return _RepositoryState;
  }
  
  public static void SaveAndUnloadRepositoryAsync() {}
  
  public static void SaveRepositoryAsOpml(String paramString)
    throws Exception
  {
    RepositoryPersistence.SaveRepositoryAsOpml(paramString);
  }
  
  public static void SaveRepositoryAsync() {}
  
  public static void SaveRepositorySync() {}
  
  public static CategoryList SearchForCategory(FeedSearchArguments paramFeedSearchArguments)
  {
    CategoryList localCategoryList = new CategoryList();
    if ((paramFeedSearchArguments == null) || (!paramFeedSearchArguments.IsValid())) {}
    for (;;)
    {
      return localCategoryList;
      Iterator localIterator = CategoryManager.GetCategoriesForAssignment().iterator();
      while (localIterator.hasNext())
      {
        FeedCategory localFeedCategory = (FeedCategory)localIterator.next();
        if (paramFeedSearchArguments.Matches(localFeedCategory)) {
          localCategoryList.add(localFeedCategory);
        }
      }
    }
  }
  
  public static Feed SearchForFeeds(Feed paramFeed, FeedSearchArguments paramFeedSearchArguments)
  {
    Feed localFeed = new Feed(FEED_SEARCH_RESULT_ROOT_ID, paramFeed);
    if (paramFeed == null) {
      return localFeed;
    }
    if ((paramFeedSearchArguments == null) || (!paramFeedSearchArguments.IsValid())) {
      return paramFeed;
    }
    SearchForFeeds(localFeed, paramFeed, paramFeedSearchArguments);
    return localFeed;
  }
  
  private static void SearchForFeeds(Feed paramFeed1, Feed paramFeed2, FeedSearchArguments paramFeedSearchArguments)
  {
    paramFeed2 = paramFeed2.SubFeeds().iterator();
    for (;;)
    {
      if (!paramFeed2.hasNext()) {
        return;
      }
      Feed localFeed = (Feed)paramFeed2.next();
      if (paramFeedSearchArguments.Matches(localFeed)) {
        paramFeed1.SubFeeds().add(localFeed);
      }
      if (localFeed.SubFeeds().size() > 0) {
        SearchForFeeds(paramFeed1, localFeed, paramFeedSearchArguments);
      }
    }
  }
  
  public static TrackList SearchForTracks(Feed paramFeed, FeedSearchArguments paramFeedSearchArguments)
  {
    TrackList localTrackList = new TrackList();
    if ((paramFeedSearchArguments == null) || (!paramFeedSearchArguments.IsValid())) {
      return localTrackList;
    }
    if (paramFeed == null) {}
    for (paramFeed = _TrackDictionary.values();; paramFeed = paramFeed.Tracks())
    {
      paramFeed = paramFeed.iterator();
      while (paramFeed.hasNext())
      {
        Track localTrack = (Track)paramFeed.next();
        if (paramFeedSearchArguments.Matches(localTrack)) {
          localTrackList.add(localTrack);
        }
      }
      break;
    }
  }
  
  public static void UnloadRepository()
  {
    CoreHelper.WriteTraceEntry("FeedRepository", "Unloading the Feed Repository!");
    getRootFeed().SubFeeds().clear();
    _TrackDictionary.clear();
    _RepositoryState = -1;
    CategoryManager.Clear();
  }
  
  public static Feed getGoUpPlaceholder()
  {
    return _GoUpPlaceholder;
  }
  
  public static Feed getRootFeed()
  {
    return _RootFeed;
  }
  
  public static String getRootPath()
  {
    return _RootPath;
  }
  
  public static void setRootPath(String paramString)
  {
    CoreHelper.WriteTraceEntry("FeedRepository", "Repository Root: " + paramString);
    _RootPath = paramString;
    _RootFeed.setFeedPath(_RootPath);
  }
  
  public static class FeedSearchArguments
  {
    public boolean LeafFeedsOnly = true;
    private Pattern SearchPattern;
    private String SearchString;
    
    public FeedSearchArguments(String paramString)
    {
      if (StringUtils.IsNullOrEmpty(paramString)) {
        return;
      }
      this.SearchString = paramString.trim();
      this.SearchPattern = Pattern.compile(paramString, 10);
    }
    
    public boolean IsValid()
    {
      return !StringUtils.IsNullOrEmpty(this.SearchString);
    }
    
    public boolean Matches(Feed paramFeed)
    {
      String str = paramFeed.getName();
      return (str != null) && (this.SearchPattern.matcher(str).find()) && ((!this.LeafFeedsOnly) || (paramFeed.SubFeeds().size() == 0));
    }
    
    public boolean Matches(Track paramTrack)
    {
      String str = paramTrack.DisplayName();
      paramTrack = paramTrack.TrackDescription();
      return ((str != null) && (this.SearchPattern.matcher(str).find())) || ((paramTrack != null) && (this.SearchPattern.matcher(paramTrack).find()));
    }
    
    public boolean Matches(FeedCategory paramFeedCategory)
    {
      paramFeedCategory = paramFeedCategory.Name();
      return (paramFeedCategory != null) && (this.SearchPattern.matcher(paramFeedCategory).find());
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/rsscore/repository/FeedRepository.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */