package mobi.beyondpod.services.player;

import android.annotation.TargetApi;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.AudioManager;
import mobi.beyondpod.BeyondPodApplication;
import mobi.beyondpod.rsscore.Configuration;
import mobi.beyondpod.rsscore.Feed;
import mobi.beyondpod.rsscore.Track;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.helpers.DateTime;
import mobi.beyondpod.ui.core.FeedImageCache;
import mobi.beyondpod.ui.core.volley.ImageUtils;

public class TrackMetadataPublisher
{
  private static final String TAG = TrackMetadataPublisher.class.getSimpleName();
  static TrackMetadataPublisher _Instance;
  static PendingIntent _MediaButtonReceiverIntent;
  RemoteControlClientHelper2 _RemoteControlClientCompat;
  
  static
  {
    Context localContext = BeyondPodApplication.GetInstance().getApplicationContext();
    Intent localIntent = new Intent("android.intent.action.MEDIA_BUTTON");
    localIntent.setComponent(new ComponentName(localContext, MediaButtonIntentReceiver.class));
    _MediaButtonReceiverIntent = PendingIntent.getBroadcast(localContext, 0, localIntent, 0);
  }
  
  private static void ScrobbleTrack(Track paramTrack, boolean paramBoolean)
  {
    boolean bool = false;
    Object localObject;
    label143:
    label323:
    StringBuilder localStringBuilder;
    if (Configuration.ScrobbleEnabled())
    {
      if (paramBoolean)
      {
        str = "com.android.music.metachanged";
        localObject = new Intent(str);
        ((Intent)localObject).putExtra("artist", paramTrack.getParentFeed().getName());
        if (paramTrack.getParentFeed().HasUrl()) {
          break label484;
        }
        ((Intent)localObject).putExtra("album", paramTrack.getParentFeed().getName());
        ((Intent)localObject).putExtra("track", paramTrack.DisplayName());
        BeyondPodApplication.GetInstance().sendBroadcast((Intent)localObject);
        CoreHelper.WriteTraceEntry(TAG, "Published Google Music 'metachanged' broadcast for track: " + paramTrack.DisplayName());
        ((Intent)localObject).setAction("net.jjc1138.android.scrobbler.action.MUSIC_STATUS");
        ((Intent)localObject).putExtra("album", paramTrack.getParentFeed().getName());
        if (paramTrack.getCurrentPlayState() != 1) {
          break label558;
        }
        paramBoolean = true;
        ((Intent)localObject).putExtra("playing", paramBoolean);
        ((Intent)localObject).putExtra("secs", (int)paramTrack.getTotalTime());
        ((Intent)localObject).putExtra("source", "P");
        BeyondPodApplication.GetInstance().sendBroadcast((Intent)localObject);
      }
    }
    else
    {
      localObject = new Intent("mobi.beyondpod.action.PLAYBACK_STATUS");
      ((Intent)localObject).putExtra("artist", paramTrack.getParentFeed().getName());
      ((Intent)localObject).putExtra("album", paramTrack.getParentFeed().getName());
      ((Intent)localObject).putExtra("track", paramTrack.DisplayName());
      paramBoolean = bool;
      if (paramTrack.getCurrentPlayState() == 1) {
        paramBoolean = true;
      }
      ((Intent)localObject).putExtra("playing", paramBoolean);
      ((Intent)localObject).putExtra("feed-name", paramTrack.getParentFeed().getName());
      ((Intent)localObject).putExtra("feed-url", paramTrack.getParentFeed().getFeedUrl());
      ((Intent)localObject).putExtra("episode-name", paramTrack.DisplayName());
      ((Intent)localObject).putExtra("episode-url", paramTrack.getUrl());
      if (!paramTrack.Exists()) {
        break label563;
      }
      str = paramTrack.TrackPath();
      ((Intent)localObject).putExtra("episode-file", str);
      ((Intent)localObject).putExtra("episode-post-url", paramTrack.TrackPostUrl());
      ((Intent)localObject).putExtra("episode-mime", paramTrack.ContentMimeType());
      ((Intent)localObject).putExtra("episode-summary", paramTrack.TrackDescription());
      ((Intent)localObject).putExtra("episode-duration", paramTrack.getTotalTime());
      ((Intent)localObject).putExtra("episode-position", paramTrack.getPlayedTime());
      BeyondPodApplication.GetInstance().sendBroadcast((Intent)localObject);
      localObject = TAG;
      localStringBuilder = new StringBuilder("Scrobbling track: ").append(paramTrack.DisplayName());
      if (paramTrack.getCurrentPlayState() != 1) {
        break label568;
      }
    }
    label484:
    label558:
    label563:
    label568:
    for (String str = " playing ";; str = " paused ")
    {
      CoreHelper.WriteTraceEntry((String)localObject, str + "(" + paramTrack.getPlayedTime() + "/" + paramTrack.getTotalTime() + ")");
      return;
      str = "com.android.music.playstatechanged";
      break;
      localStringBuilder = new StringBuilder(String.valueOf(DateTime.FormatDateTimeToday(paramTrack.getLastModifiedDate())));
      if (paramTrack.getTotalTime() > 0L) {}
      for (str = " - " + paramTrack.TotalTimeAsMinuteString();; str = "")
      {
        ((Intent)localObject).putExtra("album", str);
        break;
      }
      paramBoolean = false;
      break label143;
      str = null;
      break label323;
    }
  }
  
  public static TrackMetadataPublisher getInstance()
  {
    if (_Instance == null) {
      _Instance = new TrackMetadataPublisher();
    }
    return _Instance;
  }
  
  @TargetApi(14)
  public void PublishTrackInformation(Track paramTrack, long paramLong, boolean paramBoolean)
  {
    int j = 200;
    for (;;)
    {
      try
      {
        if ((paramTrack != BeyondPodApplication.GetInstance().PlayList().CurrentTrack()) || (paramTrack == null))
        {
          CoreHelper.WriteTraceEntry(TAG, "Trying to publish metadata for incorrect track! Ignoring...");
          return;
        }
        if (this._RemoteControlClientCompat == null) {
          this._RemoteControlClientCompat = RemoteControlClientHelper2.getInstance(_MediaButtonReceiverIntent);
        }
        this._RemoteControlClientCompat.registerRemoteControlClient((AudioManager)BeyondPodApplication.GetInstance().getApplicationContext().getSystemService("audio"));
        ScrobbleTrack(paramTrack, paramBoolean);
        if (BeyondPodApplication.GetInstance().IsLockScreenWidgetInstalled()) {
          break label377;
        }
        switch (paramTrack.getCurrentPlayState())
        {
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        Bitmap localBitmap2;
        Bitmap localBitmap1;
        CoreHelper.WriteLogEntry(TAG, "Out of memory error while publishing track metadata for: " + paramTrack);
        return;
        i = 2;
        continue;
        i = 9;
        continue;
        i = 3;
        continue;
        i = 8;
        continue;
        i = 2;
        continue;
        i = 6;
        continue;
        i = 600;
        continue;
        RemoteControlClientHelper2 localRemoteControlClientHelper2 = this._RemoteControlClientCompat;
        long l = paramLong;
        if (paramLong >= 0L) {
          continue;
        }
        l = paramTrack.getPlayedTime() * 1000L;
        localRemoteControlClientHelper2.setPlaybackState(i, l, 1.0F);
        return;
      }
      catch (Exception localException)
      {
        CoreHelper.WriteTraceEntry(TAG, "Failed to publish track metadata for: " + paramTrack + ", Error: " + localException.getClass().getName() + ", Msg: " + localException.getMessage());
      }
      if (paramBoolean)
      {
        this._RemoteControlClientCompat.setTransportControlFlags(223);
        if (CoreHelper.ApiLevel() <= 18)
        {
          i = j;
          localBitmap2 = ImageUtils.LoadEpisodeImage(paramTrack, i, i);
          localBitmap1 = localBitmap2;
          if (localBitmap2 == null) {
            localBitmap1 = FeedImageCache.GetSizedFeedImageFor(paramTrack.getParentFeed(), 200, 200);
          }
          this._RemoteControlClientCompat.editMetadata(paramTrack, localBitmap1);
          return;
        }
      }
      label377:
      return;
      int i = 2;
    }
  }
  
  public void PublishTrackInformation(Track paramTrack, boolean paramBoolean)
  {
    PublishTrackInformation(paramTrack, -1L, paramBoolean);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/services/player/TrackMetadataPublisher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */