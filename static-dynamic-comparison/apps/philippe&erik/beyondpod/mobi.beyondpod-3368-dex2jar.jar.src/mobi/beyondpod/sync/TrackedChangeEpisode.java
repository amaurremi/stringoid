package mobi.beyondpod.sync;

import java.io.File;
import java.util.Collection;
import java.util.Iterator;
import mobi.beyondpod.BeyondPodApplication;
import mobi.beyondpod.rsscore.Configuration;
import mobi.beyondpod.rsscore.Feed;
import mobi.beyondpod.rsscore.Track;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.helpers.StringUtils;
import mobi.beyondpod.rsscore.repository.FeedRepository;
import mobi.beyondpod.rsscore.rss.ItemStateHistory;
import mobi.beyondpod.services.player.PlayList;
import mobi.beyondpod.ui.commands.CommandManagerBase;
import mobi.beyondpod.ui.core.MusicUtils;

public class TrackedChangeEpisode
  extends TrackedChangeBase
{
  private static final int BLOB_CURR_POS = 3;
  private static final int BLOB_EPISODE_URL = 2;
  private static final int BLOB_FEED_URL = 0;
  private static final int BLOB_FILE_NAME = 1;
  private static final int BLOB_MARKED_PLAYED = 6;
  private static final int BLOB_START_POS = 4;
  private static final int BLOB_TOTAL_DURATION = 5;
  private static final String TAG = TrackedChangeEpisode.class.getSimpleName();
  int _CurrentPosition;
  String _EpisodeUrl;
  String _FeedUrl;
  String _FileName;
  boolean _MarkedPlayed;
  int _PlaybackStartPosition;
  int _TotalDuration;
  
  public TrackedChangeEpisode(int paramInt, Track paramTrack)
  {
    super(paramInt);
    this._EpisodeUrl = paramTrack.getUrl();
    this._CurrentPosition = ((int)paramTrack.getPlayedTime());
    this._PlaybackStartPosition = this._CurrentPosition;
    this._TotalDuration = ((int)paramTrack.getTotalTime());
    this._FileName = new File(paramTrack.TrackPath()).getName();
    this._FeedUrl = paramTrack.getParentFeed().getFeedUrl();
    this._MarkedPlayed = paramTrack.IsPlayed();
  }
  
  public TrackedChangeEpisode(Long paramLong, long paramLong1, int paramInt1, int paramInt2, String paramString)
  {
    super(paramLong, paramLong1, paramInt1, paramInt2, paramString);
    paramLong = ParseBlob();
    paramInt1 = 0;
    for (;;)
    {
      if (paramInt1 == paramLong.length) {
        return;
      }
      LoadFromBlob(paramInt1, paramLong[paramInt1]);
      paramInt1 += 1;
    }
  }
  
  private Track FindLocalTrack()
  {
    if (!StringUtils.IsNullOrEmpty(this._EpisodeUrl)) {
      return FeedRepository.GetTrackByUrl(EpisodeUrl());
    }
    Iterator localIterator = FeedRepository.GetAllTracks().iterator();
    Track localTrack;
    do
    {
      if (!localIterator.hasNext()) {
        return null;
      }
      localTrack = (Track)localIterator.next();
    } while (!localTrack.TrackPath().contains(this._FileName));
    return localTrack;
  }
  
  private void HandleEpisodeDeleted()
  {
    Track localTrack = FindLocalTrack();
    if (!ChangeTracker.AllowRemoteEpisodeDeletions()) {
      TrackedChangeBase.LogSyncEvent(TAG, "   --- APPLY remote EPISODE DELETED. Remote Deletions are not allowed! Ingoring deletion of episode:" + this._FeedUrl + " => " + this._EpisodeUrl, this);
    }
    for (;;)
    {
      updateSyncStatusTo(4);
      return;
      if (localTrack != null)
      {
        if (localTrack.AllowAutoDelete())
        {
          localTrack.ChangeTrackingEnabled = false;
          FeedRepository.DeleteTrackSync(localTrack);
          ItemStateHistory.MarkTracksItemAsRead(localTrack);
          if (Configuration.ForceMediaDatabaseRescanOnDownloadOrDelete()) {
            MusicUtils.ForceMediaScanFor(FeedRepository.getRootPath());
          }
          TrackedChangeBase.LogSyncEvent(TAG, "   --- APPLY remote EPISODE DELETED. Episode:" + this._FeedUrl + " => " + this._EpisodeUrl, this);
        }
        else
        {
          TrackedChangeBase.LogSyncEvent(TAG, "   --- APPLY remote EPISODE DELETED. Local episode is currently 'LOCKED'! Ingoring deletion of episode:" + this._FeedUrl + " => " + this._EpisodeUrl, this);
        }
      }
      else {
        TrackedChangeBase.LogSyncEvent(TAG, "   --- APPLY remote EPISODE DELETED. Episode does not exist! Ignoring... Episode:" + this._FeedUrl + " => " + this._EpisodeUrl, this);
      }
    }
  }
  
  private void HandleEpisodeDownloaded()
  {
    if (FindLocalTrack() != null) {
      TrackedChangeBase.LogSyncEvent(TAG, "   --- APPLY remote EPISODE DOWNLOADED. Episode:" + this._FeedUrl + " => " + this._EpisodeUrl, this);
    }
    for (;;)
    {
      updateSyncStatusTo(4);
      return;
      TrackedChangeBase.LogSyncEvent(TAG, "   --- APPLY remote EPISODE DOWNLOADED. Episode does not exist! Ignoring... Episode:" + this._FeedUrl + " => " + this._EpisodeUrl, this);
    }
  }
  
  private void HandleEpisodePlayed()
  {
    Track localTrack = FindLocalTrack();
    if (!ChangeTracker.AllowRemoteEpisodeModifications()) {
      TrackedChangeBase.LogSyncEvent(TAG, "   --- APPLY remote EPISODE PLAYED. Remote modifications are not allowed! Ignoring... Episode:" + this._FeedUrl + " => " + this._EpisodeUrl, this);
    }
    for (;;)
    {
      updateSyncStatusTo(4);
      return;
      if (localTrack != null)
      {
        long l3 = localTrack.getPlayedTime();
        long l4 = localTrack.getTotalTime();
        boolean bool = localTrack.IsPlayed();
        long l2 = CurrentPosition();
        long l1 = l2;
        if (Configuration.CDSSyncFurthestPlayedPositionOnly())
        {
          l1 = l2;
          if (l2 < l3) {
            l1 = l3;
          }
        }
        label133:
        String str;
        StringBuilder localStringBuilder;
        if ((l4 == 0L) && (TotalDuration() > 0))
        {
          l2 = TotalDuration();
          localTrack.InitializePlayedTimes(l1, l2, this._MarkedPlayed);
          int j = 0;
          localObject = BeyondPodApplication.GetInstance().PlayList().CurrentTrack();
          int i = j;
          if (localObject != null)
          {
            i = j;
            if (localObject == localTrack)
            {
              j = 1;
              i = j;
              if (localTrack.getCurrentPlayState() != 1)
              {
                CommandManagerBase.CmdLoadCurrentTrack();
                i = j;
              }
            }
          }
          str = TAG;
          localStringBuilder = new StringBuilder("   --- APPLY remote EPISODE PLAYED. Episode: ").append(localTrack.DisplayName()).append(", Play Position: ").append(l3).append(" (").append(CoreHelper.FormatTimeAsString(l3)).append(")").append(" => ").append(localTrack.getPlayedTime()).append(" (").append(CoreHelper.FormatTimeAsString(localTrack.getPlayedTime())).append(")").append(", Duration: ").append(l4).append(" (").append(CoreHelper.FormatTimeAsString(l4)).append(")").append(" => ").append(localTrack.getTotalTime()).append(" (").append(CoreHelper.FormatTimeAsString(localTrack.getTotalTime())).append(")").append(", Played: ").append(bool).append(" => ").append(localTrack.IsPlayed());
          if (i == 0) {
            break label487;
          }
          localObject = ", CPT";
          label384:
          localStringBuilder = localStringBuilder.append((String)localObject);
          if (l1 == CurrentPosition()) {
            break label495;
          }
        }
        label487:
        label495:
        for (Object localObject = ", Received pos: " + CurrentPosition() + " (" + CoreHelper.FormatTimeAsString(CurrentPosition()) + ") was ignored because it was before the current position";; localObject = "")
        {
          TrackedChangeBase.LogSyncEvent(str, (String)localObject, this);
          if (!localTrack.IsPlayed()) {
            break;
          }
          ItemStateHistory.MarkTracksItemAsRead(localTrack);
          break;
          l2 = l4;
          break label133;
          localObject = "";
          break label384;
        }
      }
      TrackedChangeBase.LogSyncEvent(TAG, "   --- APPLY remote EPISODE PLAYED. Episode does not exist! Ignoring... Episode:" + this._FeedUrl + " => " + this._EpisodeUrl, this);
    }
  }
  
  private void HandleEpisodeUpdated()
  {
    Track localTrack = FindLocalTrack();
    if (!ChangeTracker.AllowRemoteEpisodeModifications()) {
      TrackedChangeBase.LogSyncEvent(TAG, "   --- APPLY remote EPISODE UPDATED. Remote modifications are not allowed! Ignoring... Episode:" + this._FeedUrl + " => " + this._EpisodeUrl, this);
    }
    for (;;)
    {
      updateSyncStatusTo(4);
      return;
      if (localTrack != null)
      {
        long l1 = localTrack.getPlayedTime();
        long l2 = localTrack.getTotalTime();
        boolean bool = localTrack.IsPlayed();
        localTrack.InitializePlayedTimes(l1, TotalDuration(), bool);
        TrackedChangeBase.LogSyncEvent(TAG, "   --- APPLY remote EPISODE UPDATED. Episode: " + localTrack.DisplayName() + " Duration: " + l2 + " (" + CoreHelper.FormatTimeAsString(l2) + ")" + " => " + localTrack.getTotalTime() + " (" + CoreHelper.FormatTimeAsString(localTrack.getTotalTime()) + ")" + ", Played: " + bool + " => " + localTrack.IsPlayed(), this);
      }
      else
      {
        TrackedChangeBase.LogSyncEvent(TAG, "   --- APPLY remote EPISODE UPDATED. Episode does not exist! Ignoring... Episode:" + this._FeedUrl + " => " + this._EpisodeUrl, this);
      }
    }
  }
  
  public void ApplyRemoteChange()
  {
    if (SyncStatus() != 3) {
      return;
    }
    if (!IsValid())
    {
      TrackedChangeBase.LogSyncEvent(TAG, "   --- APPLY remote change for invalid episode: " + this._FeedUrl + ". Change ignored!", this);
      updateSyncStatusTo(4);
      return;
    }
    switch (ChangeType())
    {
    case 10: 
    case 11: 
    case 12: 
    case 13: 
    case 14: 
    default: 
      return;
    case 7: 
      HandleEpisodeDownloaded();
      return;
    case 9: 
      HandleEpisodeDeleted();
      return;
    case 15: 
      HandleEpisodeUpdated();
      return;
    }
    HandleEpisodePlayed();
  }
  
  public int CurrentPosition()
  {
    return this._CurrentPosition;
  }
  
  public String EpisodeUrl()
  {
    return this._EpisodeUrl;
  }
  
  public String FileName()
  {
    return this._FileName;
  }
  
  public String FriendlyName()
  {
    StringBuilder localStringBuilder = new StringBuilder("Pos: ").append(this._CurrentPosition).append(" (").append(CoreHelper.FormatTimeAsString(this._CurrentPosition)).append(")").append(", Dur: ").append(this._TotalDuration).append(" (").append(CoreHelper.FormatTimeAsString(this._TotalDuration)).append(")");
    if (this._MarkedPlayed)
    {
      str = " - Played";
      localStringBuilder = localStringBuilder.append(str).append(" (");
      if (!StringUtils.IsNullOrEmpty(this._EpisodeUrl)) {
        break label137;
      }
    }
    label137:
    for (String str = this._FileName;; str = this._EpisodeUrl)
    {
      return str + ")";
      str = "";
      break;
    }
  }
  
  public boolean IsValid()
  {
    return (FeedRepository.GetFeedByUrl(this._FeedUrl) != null) && (FindLocalTrack() != null);
  }
  
  protected void LoadFromBlob(int paramInt, String paramString)
  {
    boolean bool = true;
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      this._FeedUrl = paramString;
      return;
    case 1: 
      this._FileName = paramString;
      return;
    case 2: 
      this._EpisodeUrl = paramString;
      return;
    case 3: 
      this._CurrentPosition = StringUtils.SafeParseInt(paramString, -1);
      return;
    case 4: 
      this._PlaybackStartPosition = StringUtils.SafeParseInt(paramString, -1);
      return;
    case 5: 
      this._TotalDuration = StringUtils.SafeParseInt(paramString, -1);
      return;
    }
    if (StringUtils.SafeParseInt(paramString, 0) == 1) {}
    for (;;)
    {
      this._MarkedPlayed = bool;
      return;
      bool = false;
    }
  }
  
  public boolean MarkedPlayed()
  {
    return this._MarkedPlayed;
  }
  
  public String MessageId()
  {
    StringBuilder localStringBuilder;
    if (this._MessageId == null)
    {
      localStringBuilder = new StringBuilder(String.valueOf(this._FeedUrl)).append("|");
      if (!StringUtils.IsNullOrEmpty(this._EpisodeUrl)) {
        break label60;
      }
    }
    label60:
    for (String str = this._FileName;; str = this._EpisodeUrl)
    {
      this._MessageId = str;
      return this._MessageId;
    }
  }
  
  public int PlaybackStartPosition()
  {
    return this._PlaybackStartPosition;
  }
  
  public void PrepareForSave()
  {
    String str2 = this._FeedUrl;
    String str3 = this._FileName;
    String str4 = this._EpisodeUrl;
    int i = this._CurrentPosition;
    int j = this._PlaybackStartPosition;
    int k = this._TotalDuration;
    if (this._MarkedPlayed) {}
    for (String str1 = "1";; str1 = "0")
    {
      SaveToBlob(new String[] { str2, str3, str4, String.valueOf(i), String.valueOf(j), String.valueOf(k), str1 });
      return;
    }
  }
  
  public int TotalDuration()
  {
    return this._TotalDuration;
  }
  
  public void UpdateTo(TrackedChangeBase paramTrackedChangeBase)
  {
    if (!(paramTrackedChangeBase instanceof TrackedChangeEpisode)) {
      throw new ClassCastException("Trying to update TrackedChangeEpisode from " + paramTrackedChangeBase.getClass().getSimpleName());
    }
    TrackedChangeEpisode localTrackedChangeEpisode = (TrackedChangeEpisode)paramTrackedChangeBase;
    super.UpdateTo(paramTrackedChangeBase);
    this._EpisodeUrl = localTrackedChangeEpisode.EpisodeUrl();
    this._PlaybackStartPosition = localTrackedChangeEpisode.PlaybackStartPosition();
    this._CurrentPosition = localTrackedChangeEpisode.CurrentPosition();
    this._TotalDuration = localTrackedChangeEpisode.TotalDuration();
    this._FileName = localTrackedChangeEpisode.FileName();
    this._MarkedPlayed = localTrackedChangeEpisode.MarkedPlayed();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/sync/TrackedChangeEpisode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */