package mobi.beyondpod.rsscore;

import android.database.Cursor;
import android.net.Uri;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;
import mobi.beyondpod.BeyondPodApplication;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.helpers.FileUtils;
import mobi.beyondpod.rsscore.helpers.MediaFile;
import mobi.beyondpod.rsscore.helpers.Path;
import mobi.beyondpod.rsscore.helpers.StringUtils;
import mobi.beyondpod.rsscore.repository.FeedRepository;
import mobi.beyondpod.services.player.PlayList;
import mobi.beyondpod.sync.ChangeTracker;
import mobi.beyondpod.ui.core.MusicUtils;

public class Track
{
  private static final String TAG = "Track";
  private static final ArrayList<String> m_InternalPlayerExtensions = new ArrayList();
  public boolean ChangeTrackingEnabled = true;
  private int m_BufferedPercent = 100;
  private String m_ContentMimeType;
  private Integer m_ContentType = null;
  private int m_CurrentPlayState = 2;
  private boolean m_Deleted = false;
  private long m_DownloadSize = 0L;
  private int m_DownloadStatus = 0;
  private long m_DownloadedPortion = 0L;
  private Date m_LastModifiedDate;
  private boolean m_Locked = false;
  private boolean m_Modified = false;
  private Feed m_ParentFeed;
  private String m_Path;
  private boolean m_Played = false;
  private long m_PlayedTime;
  private String m_Protocol = "";
  private long m_SizeOnDisk = 0L;
  private int m_SortOrder = 10000;
  private Long m_StorageRowID;
  private long m_TotalTime;
  private String m_TrackDescription;
  private String m_TrackImagePath;
  private Uri m_Uri = null;
  private String m_Url;
  private String m_postTitle;
  private String m_postUrl;
  private String m_rssItemID;
  private String m_trackName = null;
  
  static
  {
    ReloadSupportedFileTypes();
  }
  
  public Track(File paramFile, Feed paramFeed)
    throws IOException
  {
    this(paramFile.getPath(), paramFeed);
    this.m_LastModifiedDate = new Date(paramFile.lastModified());
    this.m_SizeOnDisk = paramFile.length();
  }
  
  public Track(String paramString, Feed paramFeed)
  {
    this.m_Path = paramString;
    this.m_TotalTime = 0L;
    this.m_PlayedTime = 0L;
    this.m_ParentFeed = paramFeed;
    this.m_Protocol = "";
    this.m_Played = false;
  }
  
  private String GetDefaultTrackName()
  {
    String str2 = Path.GetFileNameWithoutExtension(TrackPath()).replace("_", " ");
    String str1 = str2;
    if (!IsSupportedFileType())
    {
      String str3 = Path.GetExtension(TrackPath());
      str1 = str2;
      if (!StringUtils.IsNullOrEmpty(str3)) {
        str1 = str2 + String.format(" (%s)", new Object[] { str3 });
      }
    }
    return str1;
  }
  
  public static boolean IsSupportedExtension(String paramString)
  {
    if (StringUtils.IsNullOrEmpty(paramString)) {
      return true;
    }
    return m_InternalPlayerExtensions.contains(paramString.toLowerCase());
  }
  
  private void MarkModified()
  {
    this.m_Modified = true;
    PublishTrackChangedEvent();
  }
  
  private void PublishTrackChangedEvent()
  {
    FeedRepository.NotifyTrackChanged(this);
  }
  
  public static void ReloadSupportedFileTypes()
  {
    m_InternalPlayerExtensions.clear();
    if (StringUtils.IsNullOrEmpty(Configuration.getInternalPlayerSupportedFileExtensions())) {}
    for (;;)
    {
      return;
      String[] arrayOfString = Configuration.getInternalPlayerSupportedFileExtensions().toLowerCase().split(",");
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str = arrayOfString[i].trim();
        if (!StringUtils.IsNullOrEmpty(str)) {
          m_InternalPlayerExtensions.add(str);
        }
        i += 1;
      }
    }
  }
  
  public boolean AllowAutoDelete()
  {
    if (Locked()) {}
    while ((HasDownloadStarted()) && (!IsFullyDownloaded())) {
      return false;
    }
    return this.m_ParentFeed.CanDeleteTracks();
  }
  
  public boolean BelongsTo(Feed paramFeed)
  {
    Object localObject = getParentFeed();
    Feed localFeed;
    do
    {
      if (((Feed)localObject).equals(paramFeed)) {
        return true;
      }
      localFeed = ((Feed)localObject).ParentFeed();
      localObject = localFeed;
    } while (localFeed != null);
    return false;
  }
  
  public void ClearPlayed()
  {
    if (getPlayedTime() == 0L) {}
    for (int i = 1;; i = 0)
    {
      this.m_Played = false;
      setPlayedTime(0L);
      if (i != 0) {
        ChangeTracker.AddLocalEpisodePlayedChange(this);
      }
      return;
    }
  }
  
  public String ContentMimeType()
  {
    return this.m_ContentMimeType;
  }
  
  public int ContentType()
  {
    if (this.m_ContentType == null)
    {
      if (StringUtils.IsNullOrEmpty(this.m_ContentMimeType)) {
        MusicUtils.LoadID3InfoForTrack(this, false, null, null, false);
      }
      this.m_ContentType = Integer.valueOf(MediaFile.MapMimeToContentType(this.m_ContentMimeType));
      if ((this.m_ContentType.intValue() == 0) || (this.m_ContentType.intValue() == -1)) {
        this.m_ContentType = Integer.valueOf(MediaFile.MapMimeToContentType(MediaFile.ConvertToStreamableMimeType(this.m_ContentMimeType, getUrl(), TrackPath())));
      }
    }
    return this.m_ContentType.intValue();
  }
  
  public void Delete()
  {
    new File(TrackPath()).delete();
    this.m_Deleted = true;
  }
  
  public String DisplayName()
  {
    String str1 = null;
    if (Configuration.PodcastNamingScheme() == 0) {
      str1 = TrackPostTitle();
    }
    String str2 = str1;
    if (StringUtils.IsNullOrEmpty(str1)) {
      str2 = getName();
    }
    return str2;
  }
  
  public boolean EnsureTrackHasContentTypeAndImage()
  {
    return EnsureTrackHasContentTypeAndImage(null);
  }
  
  public boolean EnsureTrackHasContentTypeAndImage(Cursor paramCursor)
  {
    boolean bool = false;
    if ((!HasContentType()) || (!HasImage()))
    {
      MusicUtils.LoadID3InfoForTrack(this, false, null, paramCursor, true);
      bool = true;
    }
    return bool;
  }
  
  public boolean Exists()
  {
    if (StringUtils.IsNullOrEmpty(TrackPath())) {
      return false;
    }
    return FileUtils.Exists(TrackPath());
  }
  
  public boolean HasContentType()
  {
    return this.m_ContentMimeType != null;
  }
  
  public boolean HasDownloadStarted()
  {
    return (Exists()) || (this.m_DownloadedPortion > 0L);
  }
  
  public boolean HasImage()
  {
    return (this.m_TrackImagePath != null) && (this.m_TrackImagePath.length() > 0);
  }
  
  public boolean HasUrl()
  {
    return !StringUtils.IsNullOrEmpty(getUrl());
  }
  
  public void InitRowID(Long paramLong)
  {
    this.m_StorageRowID = paramLong;
  }
  
  public void InitializePlayedTimes(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    this.m_TotalTime = paramLong2;
    this.m_PlayedTime = paramLong1;
    this.m_Played = paramBoolean;
    MarkModified();
  }
  
  public boolean IsFullyDownloaded()
  {
    if (Exists())
    {
      if (StringUtils.IsNullOrEmpty(getUrl())) {}
      while ((getDownloadSize() > 0L) && (getDownloadedPortion() == getDownloadSize())) {
        return true;
      }
    }
    return false;
  }
  
  public boolean IsModified()
  {
    return this.m_Modified;
  }
  
  public boolean IsNew()
  {
    return (!IsPlayed()) && ((getTotalTime() == 0L) || ((getTotalTime() > 0L) && (getPlayedTime() == 0L)));
  }
  
  public boolean IsPartialyPlayed()
  {
    return (!IsNew()) && (!IsPlayed());
  }
  
  public boolean IsPlayed()
  {
    return (this.m_Played) || ((getTotalTime() > 0L) && (getTotalTime() - getPlayedTime() < 5L));
  }
  
  public boolean IsRemoteEpisode()
  {
    return StringUtils.Equals("REMOTE_ADD", getProtocol());
  }
  
  public boolean IsSupportedFileType()
  {
    return IsSupportedExtension(Path.GetExtension(this.m_Path));
  }
  
  public boolean IsUsingParentImage()
  {
    return this.m_ParentFeed.TopLevelParentID().toString().equals(this.m_TrackImagePath);
  }
  
  public void LoadTrackNameFromFile()
  {
    if (Exists()) {
      MusicUtils.LoadID3InfoForTrack(this, false, null, null, false);
    }
  }
  
  public boolean Locked()
  {
    return this.m_Locked;
  }
  
  public void MarkPlayed()
  {
    if (getTotalTime() == 0L)
    {
      this.m_Played = true;
      MarkModified();
      ChangeTracker.AddLocalEpisodePlayedChange(this);
      return;
    }
    setPlayedTime(getTotalTime());
  }
  
  public void PatchTrackPathForCurrentRoot(boolean paramBoolean)
  {
    if ((TrackPath() != null) && (TrackPath().startsWith("/")))
    {
      String str = FeedRepository.PatchRootPath(TrackPath());
      if ((paramBoolean) || (FileUtils.Exists(str)) || (!HasDownloadStarted()))
      {
        CoreHelper.WriteTraceEntry("Track", "Patching track path from:" + this.m_Path + " => " + str);
        this.m_Path = str;
      }
    }
  }
  
  public boolean PatchTrackPathToMatchParent()
  {
    if ((HasUrl()) && (!StringUtils.IsNullOrEmpty(TrackPath())))
    {
      File localFile1 = new File(TrackPath());
      File localFile2 = new File(getParentFeed().getFeedPath());
      if (!StringUtils.EqualsIgnoreCase(localFile2.getAbsolutePath(), localFile1.getParent()))
      {
        this.m_Path = new File(localFile2, localFile1.getName()).getAbsolutePath();
        MarkModified();
        return true;
      }
    }
    return false;
  }
  
  public float PlaybackVolumeBoost()
  {
    return getParentFeed().PlaybackVolumeBoost();
  }
  
  public float PlayedAsFraction()
  {
    if (IsPlayed()) {
      return 1.0F;
    }
    if (IsNew()) {
      return 0.0F;
    }
    return (float)getPlayedTime() / (float)getTotalTime();
  }
  
  public String PlayedTimeAsString()
  {
    return CoreHelper.FormatTimeAsString(getPlayedTime());
  }
  
  public float PrefrredPlaybackSpeed()
  {
    return getParentFeed().PrefrredPlaybackSpeed();
  }
  
  public Long RowID()
  {
    return this.m_StorageRowID;
  }
  
  public String RssItemID()
  {
    return this.m_rssItemID;
  }
  
  public void SetIsModified(boolean paramBoolean)
  {
    this.m_Modified = paramBoolean;
  }
  
  public boolean ShouldRememberPlayedPosition()
  {
    return this.m_ParentFeed.ShouldRememberPlayedPosition();
  }
  
  public boolean TemporaryLocked()
  {
    return equals(BeyondPodApplication.GetInstance().PlayList().CurrentTrack());
  }
  
  public String TotalTimeAsMinuteString()
  {
    return CoreHelper.FormatSecondsAsMinutes(getTotalTime());
  }
  
  public String TotalTimeAsString()
  {
    return CoreHelper.FormatTimeAsString(getTotalTime());
  }
  
  public String TrackDescription()
  {
    return this.m_TrackDescription;
  }
  
  public String TrackImagePath()
  {
    return this.m_TrackImagePath;
  }
  
  public String TrackPath()
  {
    return this.m_Path;
  }
  
  public String TrackPostTitle()
  {
    return this.m_postTitle;
  }
  
  public String TrackPostUrl()
  {
    return this.m_postUrl;
  }
  
  public int getBufferedPercent()
  {
    return this.m_BufferedPercent;
  }
  
  public int getCurrentPlayState()
  {
    return this.m_CurrentPlayState;
  }
  
  public float getDownloadPercent()
  {
    if ((getDownloadedPortion() == 0L) || (getDownloadSize() == 0L)) {
      return 0.0F;
    }
    return (float)getDownloadedPortion() / (float)getDownloadSize() * 100.0F;
  }
  
  public long getDownloadSize()
  {
    return this.m_DownloadSize;
  }
  
  public int getDownloadStatus()
  {
    return this.m_DownloadStatus;
  }
  
  public long getDownloadedPortion()
  {
    return this.m_DownloadedPortion;
  }
  
  public boolean getIsDeleted()
  {
    return this.m_Deleted;
  }
  
  public Date getLastModifiedDate()
  {
    if ((this.m_LastModifiedDate == null) && (Exists())) {
      this.m_LastModifiedDate = FileUtils.GetLastWriteTime(TrackPath());
    }
    return this.m_LastModifiedDate;
  }
  
  public String getName()
  {
    if (this.m_trackName == null) {
      this.m_trackName = GetDefaultTrackName();
    }
    return this.m_trackName;
  }
  
  public Feed getParentFeed()
  {
    return this.m_ParentFeed;
  }
  
  public long getPlayedTime()
  {
    return this.m_PlayedTime;
  }
  
  public String getProtocol()
  {
    return this.m_Protocol;
  }
  
  public long getSizeOnDisk()
  {
    if (this.m_SizeOnDisk > 0L) {
      return this.m_SizeOnDisk;
    }
    return this.m_DownloadSize;
  }
  
  public int getSortOrder()
  {
    return this.m_SortOrder;
  }
  
  public long getTotalTime()
  {
    return this.m_TotalTime;
  }
  
  public Uri getUri()
  {
    if (this.m_Uri != null) {
      return this.m_Uri;
    }
    if (StringUtils.IsNullOrEmpty(this.m_Url)) {
      return null;
    }
    this.m_Uri = Uri.parse(this.m_Url);
    return this.m_Uri;
  }
  
  public String getUrl()
  {
    return this.m_Url;
  }
  
  public void setBufferedPercent(int paramInt)
  {
    if (this.m_BufferedPercent != paramInt)
    {
      this.m_BufferedPercent = paramInt;
      PublishTrackChangedEvent();
    }
  }
  
  public void setContentMimeType(String paramString)
  {
    this.m_ContentMimeType = paramString;
    this.m_ContentType = null;
    MarkModified();
  }
  
  public void setCurrentPlayState(int paramInt)
  {
    if (this.m_CurrentPlayState != paramInt)
    {
      this.m_CurrentPlayState = paramInt;
      if ((this.m_CurrentPlayState == 2) || (this.m_CurrentPlayState == -1))
      {
        if (!ShouldRememberPlayedPosition()) {
          ClearPlayed();
        }
        if ((!Configuration.AllowSeekingOfInternetStreams()) && (!HasDownloadStarted()) && (!IsPlayed())) {
          ClearPlayed();
        }
      }
      BeyondPodApplication.GetInstance().PlayList().OnTrackPlayStateCahged(this);
      PublishTrackChangedEvent();
    }
  }
  
  public void setDownloadSize(long paramLong)
  {
    if (this.m_DownloadSize != paramLong)
    {
      this.m_DownloadSize = paramLong;
      this.m_Modified = true;
    }
  }
  
  public void setDownloadStatus(int paramInt)
  {
    this.m_DownloadStatus = paramInt;
  }
  
  public void setDownloadedPortion(long paramLong)
  {
    if (this.m_DownloadedPortion != paramLong)
    {
      this.m_DownloadedPortion = paramLong;
      this.m_Modified = true;
    }
  }
  
  public void setLastModifiedDate(Date paramDate)
  {
    this.m_LastModifiedDate = paramDate;
  }
  
  public void setLocked(boolean paramBoolean)
  {
    if (this.m_Locked != paramBoolean)
    {
      this.m_Locked = paramBoolean;
      MarkModified();
    }
  }
  
  public void setName(String paramString)
  {
    this.m_trackName = paramString;
    MarkModified();
  }
  
  public void setParentFeed(Feed paramFeed)
  {
    this.m_ParentFeed = paramFeed;
  }
  
  public void setPlayedTime(long paramLong)
  {
    if (this.m_PlayedTime != paramLong) {}
    for (int i = 1;; i = 0)
    {
      this.m_PlayedTime = paramLong;
      if (this.m_PlayedTime > 0L) {
        this.m_Played = false;
      }
      MarkModified();
      if (i != 0) {
        ChangeTracker.AddLocalEpisodePlayedChange(this);
      }
      return;
    }
  }
  
  public void setProtocol(String paramString)
  {
    this.m_Protocol = paramString;
    MarkModified();
  }
  
  public void setRssItemID(String paramString)
  {
    if (StringUtils.Equals(this.m_rssItemID, paramString)) {
      return;
    }
    this.m_rssItemID = paramString;
    MarkModified();
  }
  
  public void setSortOrder(int paramInt)
  {
    this.m_SortOrder = paramInt;
    MarkModified();
  }
  
  public void setTotalTime(long paramLong)
  {
    if (this.m_TotalTime != paramLong) {}
    for (int i = 1;; i = 0)
    {
      this.m_TotalTime = paramLong;
      MarkModified();
      if (i != 0) {
        ChangeTracker.AddLocalEpisodeUpdatedChange(this);
      }
      return;
    }
  }
  
  public void setTrackDescription(String paramString)
  {
    this.m_TrackDescription = paramString;
    MarkModified();
  }
  
  public void setTrackImagePath(String paramString)
  {
    this.m_TrackImagePath = paramString;
    MarkModified();
  }
  
  public void setTrackPostTitle(String paramString)
  {
    if (paramString != null) {}
    for (this.m_postTitle = paramString.trim();; this.m_postTitle = null)
    {
      MarkModified();
      return;
    }
  }
  
  public void setTrackPostUrl(String paramString)
  {
    this.m_postUrl = paramString;
    MarkModified();
  }
  
  public void setUrl(String paramString)
  {
    if (!StringUtils.Equals(this.m_Url, paramString))
    {
      this.m_Url = paramString;
      MarkModified();
    }
  }
  
  public void setUseParentImage()
  {
    setTrackImagePath(this.m_ParentFeed.TopLevelParentID().toString());
  }
  
  public String toString()
  {
    return String.format("Track: %s (%s/%s)", new Object[] { getName(), TotalTimeAsString(), PlayedTimeAsString() });
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/rsscore/Track.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */