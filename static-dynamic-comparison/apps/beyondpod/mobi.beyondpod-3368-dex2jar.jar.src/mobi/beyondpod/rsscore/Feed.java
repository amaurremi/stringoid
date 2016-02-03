package mobi.beyondpod.rsscore;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.net.Uri;
import android.widget.Toast;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.UUID;
import mobi.beyondpod.BeyondPodApplication;
import mobi.beyondpod.R.string;
import mobi.beyondpod.aggregators.AggregatorLoginHelper;
import mobi.beyondpod.rsscore.categories.CategoryManager;
import mobi.beyondpod.rsscore.categories.FeedCategories;
import mobi.beyondpod.rsscore.categories.FeedCategory;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.helpers.FileUtils;
import mobi.beyondpod.rsscore.helpers.NetworkCredential;
import mobi.beyondpod.rsscore.helpers.Path;
import mobi.beyondpod.rsscore.helpers.SimpleMessageBus;
import mobi.beyondpod.rsscore.helpers.StringUtils;
import mobi.beyondpod.rsscore.helpers.TimeSpan;
import mobi.beyondpod.rsscore.repository.FeedRepository;
import mobi.beyondpod.rsscore.repository.RepositoryEvents.RepositoryEvent;
import mobi.beyondpod.ui.dialogs.SelectCategoryDialog;
import mobi.beyondpod.ui.dialogs.SelectCategoryDialog.OnCategorySelectedListener;

public class Feed
{
  private static final int FEED_ALREADY_EXIST = -3;
  private static final int FEED_INVALID_URL = -2;
  private static final int FEED_NULL = -1;
  private static final int FEED_OK = 0;
  private static final String FEED_S_WAS_ADDED_IN_CATEGORY = CoreHelper.LoadResourceString(R.string.feed_s_was_added_in_category);
  public static String MNT_SDCARD_MOUNT = "/mnt/sdcard/";
  @SuppressLint({"SdCardPath"})
  public static String OLD_SDCARD_MOUNT;
  private static final String TAG;
  private static final String THE_URL_OF_THIS_FEED_S_DOES_NOT_APPEAR_TO_BE_VALID;
  private static final String THIS_FEED_ALREADY_EXISTS_IN_CATEGORY = CoreHelper.LoadResourceString(R.string.this_feed_already_exists_in_category);
  public boolean ChangeTrackingEnabled = true;
  public boolean DownloadFailed = false;
  public boolean IsTransient = false;
  public int NumDownloadedEnclosures = 0;
  public int NumEnclosuresAvailableForDownload = 0;
  public String TransientEpisodeUrl;
  public boolean UpdateFailed = false;
  private Boolean _MNT_PATH_EXIST = null;
  private int _PreferredEnclosureIndex = 0;
  private int m_AllowAutoTrackDeletions = 2;
  private FeedCategories m_Category = new FeedCategories();
  private UUID m_FeedID = null;
  private String m_FeedImageUrl;
  private int m_FeedPlayer = -1;
  private int m_FeedType = 0;
  private Uri m_FeedUri;
  private String m_FeedUrl;
  private final FeedList m_Feeds = new FeedList();
  private boolean m_ForceUniqueNames = false;
  private boolean m_HasNewContent = false;
  private int m_IncludeInOneStepDownload = 1;
  private int m_ItemFilter = 0;
  private int m_ItemFingerprintAlgorithm = 1;
  private int m_ItemSortOrder = -1;
  private int m_KeepAtMostPodcasts;
  private String m_LastItemID = null;
  private Date m_LastModifiedDate = null;
  private Date m_LastServerModifiedDate = null;
  private boolean m_LeftTruncateLongTrackNames = false;
  private int m_MaxNumPodcastsToDownload;
  private TimeSpan m_MaxPodcastAge;
  private boolean m_Modified = true;
  private String m_Name;
  private int m_NumUnreadItems = 0;
  private final Feed m_ParentFeed;
  private String m_Path;
  private boolean m_RememberPlayedPosition = true;
  private Long m_StorageRowID;
  private int m_TrackSortOrder = -1;
  private final TrackList m_Tracks = new TrackList();
  private long m_UpdateSize;
  private long m_UpdatedPortion;
  private String m_UserName;
  private int m_getMaxNumGReaderItemsToGet = 0;
  
  static
  {
    THE_URL_OF_THIS_FEED_S_DOES_NOT_APPEAR_TO_BE_VALID = CoreHelper.LoadResourceString(R.string.the_url_of_this_feed_s_does_not_appear_to_be_valid);
    TAG = Feed.class.getSimpleName();
    OLD_SDCARD_MOUNT = "/sdcard/";
  }
  
  public Feed(File paramFile, Feed paramFeed)
    throws IOException
  {
    this(paramFeed);
    this.m_Path = paramFile.getPath();
  }
  
  public Feed(UUID paramUUID, Feed paramFeed)
  {
    this(paramFeed);
    this.m_FeedID = paramUUID;
  }
  
  public Feed(UUID paramUUID, Feed paramFeed, String paramString1, String paramString2, int paramInt)
  {
    this(paramFeed);
    this.m_FeedID = paramUUID;
    this.m_Name = paramString1;
    this.m_FeedUrl = paramString2;
    this.m_FeedType = paramInt;
  }
  
  private Feed(Feed paramFeed)
  {
    this.m_ParentFeed = paramFeed;
  }
  
  public static void AddSubscriptionInCategory(Context paramContext, Feed paramFeed, FeedCategory paramFeedCategory, boolean paramBoolean)
  {
    FeedList localFeedList = new FeedList();
    localFeedList.add(paramFeed);
    paramFeedCategory = AddSubscriptionsInCategory(localFeedList, paramFeedCategory);
    if (paramFeedCategory.size() == 1) {
      if (paramBoolean)
      {
        paramFeedCategory = (Feed)paramFeedCategory.get(0);
        Toast.makeText(paramContext, String.format(FEED_S_WAS_ADDED_IN_CATEGORY, new Object[] { paramFeed.getName(), paramFeedCategory.getCategories().getPrimary().Name() }), 1).show();
      }
    }
    do
    {
      return;
      switch (CheckIfFeedCanBeAdded(paramFeed))
      {
      default: 
        return;
      case -3: 
        paramFeed = FeedRepository.GetFeedByUrl(paramFeed.getFeedUrl());
      }
    } while (paramFeed == null);
    Toast.makeText(paramContext, String.format(THIS_FEED_ALREADY_EXISTS_IN_CATEGORY, new Object[] { paramFeed.getCategories().getPrimary().Name() }), 1).show();
    return;
    Toast.makeText(paramContext, "NULL Feed", 1).show();
    return;
    Toast.makeText(paramContext, String.format(THE_URL_OF_THIS_FEED_S_DOES_NOT_APPEAR_TO_BE_VALID, new Object[] { paramFeed.getFeedUrl() }), 1).show();
  }
  
  public static FeedList AddSubscriptionsInCategory(FeedList paramFeedList, FeedCategory paramFeedCategory)
  {
    FeedList localFeedList = new FeedList();
    Iterator localIterator = paramFeedList.iterator();
    Object localObject;
    do
    {
      if (!localIterator.hasNext())
      {
        FeedRepository.SaveRepositoryAsync();
        StartupContentBuilder.BackupRepositoriesAsync();
        return localFeedList;
      }
      localObject = (Feed)localIterator.next();
    } while (CheckIfFeedCanBeAdded((Feed)localObject) != 0);
    Feed localFeed = CreateAndAddFeedWithDefaults(((Feed)localObject).getFeedUrl(), ((Feed)localObject).getName(), ((Feed)localObject).getFeedImageUrl());
    if ((AggregatorLoginHelper.IsLoggedIn()) && (((Feed)localObject).getType() == 5))
    {
      localFeed.setType(5);
      localFeed.setMaxNumGReaderItemsToGet(Configuration.getGlobalDefaultMaximumGReaderItemsToGet());
    }
    if (((Feed)localObject).getType() == 6)
    {
      localFeed.setForceUniqueTrackNames(((Feed)localObject).getForceUniqueTrackNames());
      if (!StringUtils.IsNullOrEmpty(((Feed)localObject).getFeedImageUrl())) {
        localFeed.setFeedImageUrl(((Feed)localObject).getFeedImageUrl());
      }
      localFeed.setTrackSortOrder(((Feed)localObject).getTrackSortOrder());
      localFeed.setAllowAutoTrackDeletions(((Feed)localObject).getAllowAutoTrackDeletions());
    }
    FeedCategory localFeedCategory = Configuration.getActiveFeedCategory();
    paramFeedList = null;
    if (paramFeedCategory != null) {
      paramFeedList = paramFeedCategory.Name();
    }
    for (;;)
    {
      localObject = localFeedCategory;
      if (!StringUtils.IsNullOrEmpty(paramFeedList))
      {
        paramFeedList = CategoryManager.GetCategoryByValue(paramFeedList);
        localObject = localFeedCategory;
        if (paramFeedList != CategoryManager.CategoryNull) {
          localObject = paramFeedList;
        }
      }
      localFeed.getCategories().setPrimary((FeedCategory)localObject);
      localFeedList.add(localFeed);
      break;
      if (((Feed)localObject).ParentFeed() != null) {
        paramFeedList = ((Feed)localObject).ParentFeed().getName();
      }
    }
  }
  
  private static int CheckIfFeedCanBeAdded(Feed paramFeed)
  {
    int i = 0;
    if (paramFeed == null) {
      i = -1;
    }
    do
    {
      return i;
      if (!CoreHelper.IsUrlValid(paramFeed.getFeedUrl(), false)) {
        return -2;
      }
    } while (FeedRepository.GetFeedByUrl(paramFeed.getFeedUrl()) == null);
    return -3;
  }
  
  public static Feed CreateAndAddFeedWithDefaults(String paramString1, String paramString2, String paramString3)
  {
    Feed localFeed = new Feed(UUID.randomUUID(), FeedRepository.getRootFeed());
    localFeed.setFeedUrl(paramString1);
    localFeed.setName(paramString2);
    localFeed.setForceUniqueTrackNames(true);
    localFeed.setPodcastDownloadAction(Configuration.getGlobalDefaultPodcastDownloadAction());
    localFeed.setMaxNumberPodcastsToDownload(Configuration.getGlobalDefaultNumberPodcastsToDownload());
    localFeed.setKeepAtMostPodcasts(Configuration.getGlobalDefaultKeepAtMostPodcasts());
    localFeed.setMaximumPodcastAge(Configuration.getGlobalDefaultMaximumPodcastAge());
    localFeed.setItemFingerprintAlgorithm(-1);
    if (!StringUtils.IsNullOrEmpty(paramString3)) {
      localFeed.setFeedImageUrl(paramString3);
    }
    if ((localFeed.getPodcastDownloadAction() == 5) || (localFeed.getPodcastDownloadAction() == 4))
    {
      localFeed.setForceFeedItemSort(2);
      localFeed.setTrackSortOrder(2);
    }
    localFeed.EnsureFeedPathIsUnique();
    localFeed.getCategories().setPrimary(Configuration.getActiveFeedCategory());
    FeedRepository.getRootFeed().SubFeeds().add(localFeed);
    BeyondPodApplication.MessageBus.PublishEventAsync(new RepositoryEvents.RepositoryEvent(6, localFeed));
    return localFeed;
  }
  
  public static Feed CreateTransientFeed(String paramString1, String paramString2)
  {
    Feed localFeed = new Feed(UUID.randomUUID(), FeedRepository.getRootFeed());
    localFeed.IsTransient = true;
    localFeed.setFeedUrl(paramString1);
    localFeed.setName(paramString2);
    localFeed.setForceUniqueTrackNames(true);
    localFeed.setPodcastDownloadAction(2);
    localFeed.setMaxNumberPodcastsToDownload(0);
    localFeed.setKeepAtMostPodcasts(0);
    localFeed.setMaximumPodcastAge(Configuration.getGlobalDefaultMaximumPodcastAge());
    localFeed.setForceFeedItemSort(3);
    localFeed.setTrackSortOrder(3);
    return localFeed;
  }
  
  public static String MakeValidFolderName(String paramString1, String paramString2)
  {
    String str = "";
    if (!StringUtils.IsNullOrEmpty(paramString2)) {
      str = paramString2.replaceAll("[^a-zA-Z0-9 - ]", "").trim();
    }
    paramString2 = str;
    if (str.length() > 30) {
      paramString2 = str.substring(0, 30);
    }
    str = paramString2;
    if (paramString2.length() < 3) {
      str = "Feed_" + Long.toString(new Date().getTime());
    }
    paramString2 = Path.Combine(paramString1, str.trim());
    paramString1 = paramString2;
    if (FileUtils.DirectoryExists(paramString2))
    {
      paramString1 = paramString2;
      if (FeedRepository.IsDownloadFolderInUse(paramString2)) {
        paramString1 = paramString2 + "_" + Long.toString(new Date().getTime());
      }
    }
    return paramString1;
  }
  
  private void MarkModified()
  {
    this.m_Modified = true;
    PublishFeedChangedEvent();
  }
  
  private boolean PatchGeneratedFeedPath()
  {
    if (FileUtils.DirectoryExists(getFeedPath())) {
      try
      {
        String str = MakeValidFolderName(FeedRepository.getRootPath(), getName());
        if (FileUtils.RenameTo(getFeedPath(), str))
        {
          setFeedPath(str);
          return true;
        }
      }
      catch (Throwable localThrowable)
      {
        CoreHelper.LogException(TAG, "Failed to patch feed download path for: " + getFeedPath() + "! Reason: ", localThrowable);
      }
    }
    return false;
  }
  
  private void PublishFeedChangedEvent()
  {
    FeedRepository.NotifyFeedChanged(this);
  }
  
  public static void SubscribeToFeedAndPromptForCategory(Context paramContext, final Feed paramFeed, String paramString, final boolean paramBoolean)
  {
    new SelectCategoryDialog(paramContext, new SelectCategoryDialog.OnCategorySelectedListener()
    {
      public void onCategorySelected(FeedCategory paramAnonymousFeedCategory)
      {
        if (paramAnonymousFeedCategory == null) {
          return;
        }
        Feed.AddSubscriptionInCategory(Feed.this, paramFeed, paramAnonymousFeedCategory, paramBoolean);
      }
    }).CreateDialog(paramString).show();
  }
  
  public boolean AllowsEnclosures()
  {
    return !StringUtils.IsNullOrEmpty(getFeedPath());
  }
  
  public boolean CanDeleteTracks()
  {
    int i = getAllowAutoTrackDeletions();
    if (i == 0) {}
    do
    {
      return true;
      if (i == 1) {
        return false;
      }
    } while ((i != 2) || (this.m_ParentFeed == null));
    return this.m_ParentFeed.CanDeleteTracks();
  }
  
  public boolean CanNavigateUp()
  {
    return ParentFeed() != null;
  }
  
  public void ClearTracksAndSubFeeds()
  {
    FeedRepository.RemoveFromTrackDictionary(TracksAndSubTracks());
    SubFeeds().clear();
  }
  
  public NetworkCredential Credentials()
  {
    if ((!StringUtils.IsNullOrEmpty(getUserName())) && (!StringUtils.IsNullOrEmpty(getPassword()))) {
      return new NetworkCredential(getUserName(), getPassword());
    }
    return null;
  }
  
  public boolean DownloadPathExists()
  {
    String str = getFeedPath();
    return (str != null) && (FileUtils.DirectoryExists(str));
  }
  
  public boolean EnsureFeedHasDownloadPath()
  {
    if (!FileUtils.DirectoryExists(getFeedPath()))
    {
      if (!FeedRepository.getRootFeed().DownloadPathExists()) {
        return false;
      }
      try
      {
        Object localObject2 = MakeValidFolderName(FeedRepository.getRootPath(), getName());
        Object localObject1 = localObject2;
        if (!StringUtils.IsNullOrEmpty(getFeedPath()))
        {
          String str = new File(getFeedPath()).getName();
          localObject1 = localObject2;
          if (!StringUtils.IsNullOrEmpty(str))
          {
            localObject1 = MakeValidFolderName(FeedRepository.getRootPath(), str);
            CoreHelper.WriteTraceEntry(TAG, "Found feed with an invalid download path, but was able to patch it to:" + (String)localObject1);
          }
        }
        FileUtils.CreateDirectory((String)localObject1);
        setFeedPath((String)localObject1);
        localObject1 = Tracks().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (Track)((Iterator)localObject1).next();
          if (((Track)localObject2).PatchTrackPathToMatchParent()) {
            CoreHelper.WriteTraceEntry(TAG, "Found streamable episode with download path that does not match parent! Patched to:" + ((Track)localObject2).TrackPath());
          }
        }
        return true;
      }
      catch (Throwable localThrowable)
      {
        return false;
      }
    }
  }
  
  public void EnsureFeedPathIsUnique()
  {
    if ((!StringUtils.IsNullOrEmpty(getFeedPath())) || (StringUtils.IsNullOrEmpty(getName()))) {
      return;
    }
    String str = MakeValidFolderName(FeedRepository.getRootPath(), getName());
    Iterator localIterator = FeedRepository.getRootFeed().SubFeeds().iterator();
    for (;;)
    {
      if (!localIterator.hasNext())
      {
        if (!FileUtils.CreateDirectory(str)) {
          break;
        }
        setFeedPath(str);
        return;
      }
      if (StringUtils.EqualsIgnoreCase(((Feed)localIterator.next()).getFeedPath(), str)) {
        str = str.concat("_" + Long.toString(new Date().getTime()));
      }
    }
  }
  
  public String GetRawFeedPath()
  {
    return this.m_Path;
  }
  
  public boolean HasNewContent()
  {
    return this.m_HasNewContent;
  }
  
  public boolean HasPodcasts()
  {
    return (AllowsEnclosures()) && (Tracks().size() > 0);
  }
  
  public boolean HasUnreadItems()
  {
    return this.m_NumUnreadItems > 0;
  }
  
  public boolean HasUri()
  {
    return (HasUrl()) && (getFeedUri() != null);
  }
  
  public boolean HasUrl()
  {
    return !StringUtils.IsNullOrEmpty(getFeedUrl());
  }
  
  public UUID ID()
  {
    if (this.m_FeedID == null)
    {
      this.m_FeedID = UUID.randomUUID();
      MarkModified();
    }
    return this.m_FeedID;
  }
  
  public void InitRowID(Long paramLong)
  {
    this.m_StorageRowID = paramLong;
  }
  
  public boolean IsGReaderFeed()
  {
    return getType() == 5;
  }
  
  public boolean IsModified()
  {
    return (this.m_Modified) || (getCategories().getIsModified());
  }
  
  public boolean IsSubFeed()
  {
    return ((ParentFeed() != null) && (ParentFeed().ParentFeed() != null)) || (equals(FeedRepository.getGoUpPlaceholder()));
  }
  
  public boolean MayHaveUnreadItems()
  {
    if (!HasUri()) {}
    while ((HasUnreadItems()) || (getLastServerModifiedDate() == null)) {
      return true;
    }
    return false;
  }
  
  public int NumUnreadItems()
  {
    return this.m_NumUnreadItems;
  }
  
  public Feed ParentFeed()
  {
    return this.m_ParentFeed;
  }
  
  public void PatchFeedPathForCurrentRoot(boolean paramBoolean)
  {
    if ((HasUrl()) && (getFeedPath() != null))
    {
      String str = FeedRepository.PatchRootPath(getFeedPath());
      if ((paramBoolean) || (FileUtils.DirectoryExists(str)))
      {
        CoreHelper.WriteTraceEntry(TAG, "Patching feed path from:" + getFeedPath() + " => " + str);
        setFeedPath(str);
      }
    }
  }
  
  public void PatchFeedPathForMntRoot()
  {
    if (this._MNT_PATH_EXIST == null) {
      this._MNT_PATH_EXIST = Boolean.valueOf(Configuration.EnclosureDownloadRoot().startsWith(MNT_SDCARD_MOUNT));
    }
    if (!this._MNT_PATH_EXIST.booleanValue()) {}
    while ((!HasUrl()) || (this.m_Path == null) || (!this.m_Path.startsWith(OLD_SDCARD_MOUNT))) {
      return;
    }
    CoreHelper.WriteTraceEntry(TAG, "Patched old sdcard mount for feed: " + this.m_Path);
    setFeedPath(MNT_SDCARD_MOUNT + this.m_Path.substring(OLD_SDCARD_MOUNT.length()));
  }
  
  public float PlaybackVolumeBoost()
  {
    if (IsSubFeed()) {
      return this.m_ParentFeed.PlaybackVolumeBoost();
    }
    String str = getUserName();
    if ((!StringUtils.IsNullOrEmpty(str)) && (str.length() == 2) && (str.startsWith("+")))
    {
      int i = StringUtils.SafeParseInt(str.substring(1), 1);
      if ((i > 0) && (i < 10)) {
        return i;
      }
    }
    return 1.0F;
  }
  
  public float PrefrredPlaybackSpeed()
  {
    if (IsSubFeed()) {
      return this.m_ParentFeed.PrefrredPlaybackSpeed();
    }
    int i = getFeedPlayer();
    if ((i < 30) || (i > 300))
    {
      if (Configuration.UseAudioPluginForConfiguredFeedsOnly()) {
        return 1.0F;
      }
      return Configuration.DefaultPlaybackSpeed();
    }
    return i / 100.0F;
  }
  
  public Long RowID()
  {
    return this.m_StorageRowID;
  }
  
  public void SetIsModified(boolean paramBoolean)
  {
    this.m_Modified = paramBoolean;
    getCategories().SetIsModified(paramBoolean);
  }
  
  public boolean ShouldRememberPlayedPosition()
  {
    if (IsSubFeed()) {
      return this.m_ParentFeed.ShouldRememberPlayedPosition();
    }
    return getShouldRememberPlayedPosition();
  }
  
  public FeedList SubFeeds()
  {
    return this.m_Feeds;
  }
  
  public UUID TopLevelParentID()
  {
    if (IsSubFeed()) {
      return this.m_ParentFeed.TopLevelParentID();
    }
    return ID();
  }
  
  public void Touch()
  {
    MarkModified();
  }
  
  public TrackList Tracks()
  {
    return this.m_Tracks;
  }
  
  public TrackList TracksAndSubTracks()
  {
    if (Tracks().size() > 0) {
      return Tracks();
    }
    TrackList localTrackList = new TrackList();
    Iterator localIterator = SubFeeds().iterator();
    for (;;)
    {
      if (!localIterator.hasNext())
      {
        Collections.sort(localTrackList, new TrackSorter(getLocalOrInheritedTrackSortOrder()));
        return localTrackList;
      }
      localTrackList.addAll(((Feed)localIterator.next()).TracksAndSubTracks());
    }
  }
  
  public void UpdateNameIfDefault(String paramString)
  {
    if (((StringUtils.EqualsIgnoreCase(getName(), getFeedUrl())) || (StringUtils.IsNullOrEmpty(getName()))) && (!StringUtils.IsNullOrEmpty(paramString)))
    {
      setName(paramString);
      PatchGeneratedFeedPath();
    }
  }
  
  public int UpdatePercent()
  {
    if ((getUpdatedPortion() >= 0L) && (getUpdateSize() >= 0L) && (getUpdateSize() >= getUpdatedPortion())) {
      return (int)((float)getUpdatedPortion() / (float)getUpdateSize() * 100.0F);
    }
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject instanceof Feed)) {}
      for (;;)
      {
        paramObject = (Feed)paramObject;
        if (paramObject != null) {
          break;
        }
        return false;
        paramObject = null;
      }
      if (ID() != null) {
        return ID().equals(((Feed)paramObject).ID());
      }
    } while (ID() == ((Feed)paramObject).ID());
    return false;
  }
  
  public int getAllowAutoTrackDeletions()
  {
    if (equals(FeedRepository.getRootFeed())) {
      if (!Configuration.getAllowAutoTrackDeletions()) {
        break label28;
      }
    }
    label28:
    for (int i = 0;; i = 1)
    {
      this.m_AllowAutoTrackDeletions = i;
      return this.m_AllowAutoTrackDeletions;
    }
  }
  
  public FeedCategories getCategories()
  {
    if ((this.m_Category.getIsUnassigned()) && (ParentFeed() != null) && (ParentFeed() != FeedRepository.getRootFeed())) {
      return ParentFeed().getCategories();
    }
    return this.m_Category;
  }
  
  public String getFeedImageUrl()
  {
    return this.m_FeedImageUrl;
  }
  
  public String getFeedPath()
  {
    if (StringUtils.IsNullOrEmpty(this.m_Path)) {
      return this.m_Path;
    }
    return this.m_Path;
  }
  
  public int getFeedPlayer()
  {
    return this.m_FeedPlayer;
  }
  
  public Uri getFeedUri()
  {
    if (this.m_FeedUri == null) {
      this.m_FeedUri = CoreHelper.SafeCreateUri(this.m_FeedUrl);
    }
    return this.m_FeedUri;
  }
  
  public String getFeedUrl()
  {
    return this.m_FeedUrl;
  }
  
  public int getForceFeedItemSort()
  {
    return this.m_ItemSortOrder;
  }
  
  public boolean getForceUniqueTrackNames()
  {
    return this.m_ForceUniqueNames;
  }
  
  public int getItemFilter()
  {
    return this.m_ItemFilter;
  }
  
  public int getItemFingerprintAlgorithm()
  {
    return this.m_ItemFingerprintAlgorithm;
  }
  
  public int getKeepAtMostPodcasts()
  {
    return this.m_KeepAtMostPodcasts;
  }
  
  public String getLastItemID()
  {
    return this.m_LastItemID;
  }
  
  public Date getLastModifiedDate()
  {
    return this.m_LastModifiedDate;
  }
  
  public Date getLastServerModifiedDate()
  {
    return this.m_LastServerModifiedDate;
  }
  
  public boolean getLeftTruncateLongTrackNames()
  {
    return this.m_LeftTruncateLongTrackNames;
  }
  
  public int getLocalOrInheritedTrackSortOrder()
  {
    Object localObject = this;
    Feed localFeed;
    do
    {
      if (((Feed)localObject).m_TrackSortOrder != -1) {
        return ((Feed)localObject).m_TrackSortOrder;
      }
      localFeed = ((Feed)localObject).ParentFeed();
      localObject = localFeed;
    } while (localFeed != null);
    return Configuration.getPodcastsSortOrder();
  }
  
  public int getMaxNumGReaderItemsToGet()
  {
    return this.m_getMaxNumGReaderItemsToGet;
  }
  
  public int getMaxNumberPodcastToDownload()
  {
    return this.m_MaxNumPodcastsToDownload;
  }
  
  public TimeSpan getMaximumPodcastAge()
  {
    if (this.m_MaxPodcastAge != null) {
      return this.m_MaxPodcastAge;
    }
    return Configuration.getGlobalDefaultMaximumPodcastAge();
  }
  
  public String getName()
  {
    if (this.m_Name == null)
    {
      if (getFeedPath() != null) {
        return Path.GetFileName(getFeedPath()).replace("_", " ");
      }
      return "";
    }
    return this.m_Name;
  }
  
  public String getPassword()
  {
    return Configuration.GetFeedPrivateData(ID());
  }
  
  public int getPodcastDownloadAction()
  {
    return this.m_IncludeInOneStepDownload;
  }
  
  public int getPreferredEnclosureIndex()
  {
    return this._PreferredEnclosureIndex;
  }
  
  public boolean getShouldRememberPlayedPosition()
  {
    return this.m_RememberPlayedPosition;
  }
  
  public int getTrackSortOrder()
  {
    if (this.m_TrackSortOrder == -1) {
      return Configuration.getPodcastsSortOrder();
    }
    return this.m_TrackSortOrder;
  }
  
  public int getType()
  {
    if ((this.m_FeedType == 4) || (this.m_FeedType == 5) || (this.m_FeedType == 6)) {
      return this.m_FeedType;
    }
    if ((HasUrl()) && (AllowsEnclosures())) {
      return 3;
    }
    if (!HasUrl()) {
      return 1;
    }
    return 2;
  }
  
  public int getUnplayedTrackCount()
  {
    if (SubFeeds().size() > 0) {
      return SubFeeds().getUnplayedTrackCount();
    }
    return Tracks().getUnplayedTrackCount();
  }
  
  public long getUpdateSize()
  {
    return this.m_UpdateSize;
  }
  
  public long getUpdatedPortion()
  {
    return this.m_UpdatedPortion;
  }
  
  public String getUserName()
  {
    return this.m_UserName;
  }
  
  public int hashCode()
  {
    return this.m_FeedID.hashCode();
  }
  
  public void setAllowAutoTrackDeletions(int paramInt)
  {
    this.m_AllowAutoTrackDeletions = paramInt;
    MarkModified();
  }
  
  public void setCategories(FeedCategories paramFeedCategories)
  {
    if (this.m_Category != paramFeedCategories)
    {
      this.m_Category = paramFeedCategories;
      MarkModified();
    }
  }
  
  public void setFeedImageUrl(String paramString)
  {
    if (!StringUtils.Equals(this.m_FeedImageUrl, paramString))
    {
      MarkModified();
      this.m_FeedImageUrl = paramString;
    }
  }
  
  public void setFeedPath(String paramString)
  {
    if (!StringUtils.Equals(this.m_Path, paramString))
    {
      this.m_Path = paramString;
      MarkModified();
    }
  }
  
  public void setFeedPlayer(int paramInt)
  {
    if (this.m_FeedPlayer != paramInt)
    {
      this.m_FeedPlayer = paramInt;
      MarkModified();
    }
  }
  
  public void setFeedUrl(String paramString)
  {
    if (!StringUtils.Equals(this.m_FeedUrl, paramString))
    {
      MarkModified();
      this.m_FeedUrl = paramString;
      this.m_FeedUri = null;
    }
  }
  
  public void setForceFeedItemSort(int paramInt)
  {
    int i = paramInt;
    if (paramInt == 0) {
      i = -1;
    }
    paramInt = i;
    if (i == 1) {
      paramInt = 2;
    }
    if (this.m_ItemSortOrder != paramInt)
    {
      this.m_ItemSortOrder = paramInt;
      MarkModified();
    }
  }
  
  public void setForceUniqueTrackNames(boolean paramBoolean)
  {
    this.m_ForceUniqueNames = paramBoolean;
    MarkModified();
  }
  
  public void setHasNewContent(boolean paramBoolean)
  {
    if (this.m_HasNewContent != paramBoolean)
    {
      this.m_HasNewContent = paramBoolean;
      MarkModified();
    }
  }
  
  public void setItemFilter(int paramInt)
  {
    this.m_ItemFilter = paramInt;
  }
  
  public void setItemFingerprintAlgorithm(int paramInt)
  {
    if (paramInt != this.m_ItemFingerprintAlgorithm)
    {
      this.m_ItemFingerprintAlgorithm = paramInt;
      MarkModified();
    }
  }
  
  public void setKeepAtMostPodcasts(int paramInt)
  {
    if (paramInt != this.m_KeepAtMostPodcasts)
    {
      this.m_KeepAtMostPodcasts = paramInt;
      MarkModified();
    }
  }
  
  public void setLastItemID(String paramString)
  {
    if (!StringUtils.Equals(this.m_LastItemID, paramString))
    {
      MarkModified();
      this.m_LastItemID = paramString;
    }
  }
  
  public void setLastModifiedDate(Date paramDate)
  {
    if (this.m_LastModifiedDate != paramDate)
    {
      MarkModified();
      this.m_LastModifiedDate = paramDate;
    }
  }
  
  public void setLastServerModifiedDate(Date paramDate)
  {
    if (this.m_LastServerModifiedDate != paramDate)
    {
      MarkModified();
      this.m_LastServerModifiedDate = paramDate;
    }
  }
  
  public void setLeftTruncateLongTrackNames(boolean paramBoolean)
  {
    this.m_LeftTruncateLongTrackNames = paramBoolean;
    MarkModified();
  }
  
  public void setLocalOrInheritedTrackSortOrder(int paramInt)
  {
    for (Feed localFeed = this;; localFeed = localFeed.ParentFeed()) {
      if (!localFeed.IsSubFeed())
      {
        localFeed.setTrackSortOrder(paramInt);
        return;
      }
    }
  }
  
  public void setMaxNumGReaderItemsToGet(int paramInt)
  {
    this.m_getMaxNumGReaderItemsToGet = paramInt;
    MarkModified();
  }
  
  public void setMaxNumberPodcastsToDownload(int paramInt)
  {
    if (paramInt != this.m_MaxNumPodcastsToDownload)
    {
      this.m_MaxNumPodcastsToDownload = paramInt;
      MarkModified();
    }
  }
  
  public void setMaximumPodcastAge(TimeSpan paramTimeSpan)
  {
    if ((this.m_MaxPodcastAge == null) || (paramTimeSpan != this.m_MaxPodcastAge))
    {
      this.m_MaxPodcastAge = paramTimeSpan;
      MarkModified();
    }
  }
  
  public void setName(String paramString)
  {
    if (!StringUtils.Equals(this.m_Name, paramString))
    {
      this.m_Name = paramString;
      MarkModified();
    }
  }
  
  public void setNumUnreadItems(int paramInt)
  {
    if (this.m_NumUnreadItems != paramInt)
    {
      this.m_NumUnreadItems = paramInt;
      MarkModified();
    }
  }
  
  public void setPassword(String paramString)
  {
    if (StringUtils.Equals(getPassword(), paramString)) {
      return;
    }
    Configuration.StoreFeedPrivateData(ID(), paramString);
  }
  
  public void setPodcastDownloadAction(int paramInt)
  {
    if (this.m_IncludeInOneStepDownload != paramInt)
    {
      this.m_IncludeInOneStepDownload = paramInt;
      MarkModified();
    }
  }
  
  public void setPreferredEnclosureIndex(int paramInt)
  {
    if (this._PreferredEnclosureIndex != paramInt)
    {
      MarkModified();
      this._PreferredEnclosureIndex = paramInt;
    }
  }
  
  public void setShouldRememberPlayedPosition(boolean paramBoolean)
  {
    this.m_RememberPlayedPosition = paramBoolean;
    MarkModified();
  }
  
  public void setTrackSortOrder(int paramInt)
  {
    if (this.m_TrackSortOrder != paramInt)
    {
      this.m_TrackSortOrder = paramInt;
      MarkModified();
    }
  }
  
  public void setType(int paramInt)
  {
    if (this.m_FeedType != paramInt)
    {
      MarkModified();
      this.m_FeedType = paramInt;
    }
  }
  
  public void setUpdateSize(long paramLong)
  {
    this.m_UpdateSize = paramLong;
  }
  
  public void setUpdatedPortion(long paramLong)
  {
    this.m_UpdatedPortion = paramLong;
  }
  
  public void setUserName(String paramString)
  {
    if (StringUtils.Equals(this.m_UserName, paramString)) {
      return;
    }
    this.m_UserName = paramString;
    MarkModified();
  }
  
  public String toString()
  {
    return getName();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/rsscore/Feed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */