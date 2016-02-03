package mobi.beyondpod.ui.views;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;
import mobi.beyondpod.BeyondPodApplication;
import mobi.beyondpod.rsscore.Track;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.helpers.TimeSpan;
import mobi.beyondpod.rsscore.repository.FeedRepository;
import mobi.beyondpod.schedulercore.ScheduledTasksManager;
import mobi.beyondpod.services.player.TrackMetadataPublisher;
import mobi.beyondpod.ui.views.base.BPMediaController;

public class MovieViewControl
  implements MediaPlayer.OnErrorListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnPreparedListener
{
  private static final String CMDNAME = "command";
  private static final String CMDPAUSE = "pause";
  private static final String CONNECTING_TO_S = CoreHelper.LoadResourceString(2131297083);
  private static final String PLAYBACK_ERROR;
  private static final String PREPARING_STREAM = CoreHelper.LoadResourceString(2131297107);
  private static final String SERVICECMD = "com.android.music.musicservicecommand";
  private static final String TAG = "MovieViewControl";
  Context _Context;
  Track _CurrentTrack;
  Handler _Handler = new Handler();
  private boolean _IsPrepared = false;
  BPMediaController _MediaController;
  private TrackMetadataPublisher _MetadataPublisher;
  private boolean _PlaybackFailed = false;
  private int _PositionWhenPaused = -1;
  private final View _ProgressView;
  View _SeekGroup;
  private boolean _StartAfterSeek = false;
  ImageView _StreamableImage;
  TextView _TrackName;
  View _TransportControls;
  private final VideoView _VideoView;
  private boolean _WasPlayingWhenPaused = false;
  Runnable mPlayingChecker = new Runnable()
  {
    public void run()
    {
      if (MovieViewControl.this._IsPrepared)
      {
        MovieViewControl.this._CurrentTrack.setPlayedTime(MovieViewControl.this._VideoView.getCurrentPosition() / 1000);
        MovieViewControl.this._Handler.postDelayed(MovieViewControl.this.mPlayingChecker, 5000L);
        MovieViewControl.this._TrackName.setText("");
        MovieViewControl.this._ProgressView.setVisibility(8);
        MovieViewControl.this._TransportControls.setVisibility(0);
        MovieViewControl.this._SeekGroup.setVisibility(0);
        if (MovieViewControl.this._MediaController.isVisible()) {
          MovieViewControl.this._MediaController.HideNavigationDelayed(3000L);
        }
        MovieViewControl.this._MediaController.UpdateTimeAndPosition();
        return;
      }
      MovieViewControl.this._Handler.postDelayed(MovieViewControl.this.mPlayingChecker, 250L);
      if ((MovieViewControl.this._CurrentTrack.getUrl() != null) && (!MovieViewControl.this._CurrentTrack.Exists())) {
        MovieViewControl.this._TrackName.setText(String.format(MovieViewControl.CONNECTING_TO_S, new Object[] { MovieViewControl.this._CurrentTrack.getUri().getHost() }));
      }
      for (;;)
      {
        MovieViewControl.this._MediaController.show(3600000L);
        break;
        MovieViewControl.this._TrackName.setText(MovieViewControl.PREPARING_STREAM);
      }
    }
  };
  
  static
  {
    PLAYBACK_ERROR = CoreHelper.LoadResourceString(2131297079);
  }
  
  public MovieViewControl(BPMediaController paramBPMediaController, Context paramContext)
  {
    this._Context = paramContext;
    this._MediaController = paramBPMediaController;
    this._VideoView = ((VideoView)paramBPMediaController.findViewById(2131231102));
    this._ProgressView = paramBPMediaController.findViewById(2131231106);
    this._MetadataPublisher = TrackMetadataPublisher.getInstance();
    this._VideoView.setOnErrorListener(this);
    this._VideoView.setOnCompletionListener(this);
    this._VideoView.setOnPreparedListener(this);
    this._TrackName = ((TextView)paramBPMediaController.findViewById(2131231112));
    this._StreamableImage = ((ImageView)paramBPMediaController.findViewById(2131230850));
    this._TransportControls = paramBPMediaController.findViewById(2131231107);
    this._SeekGroup = paramBPMediaController.findViewById(2131231113);
  }
  
  private void PrepareAndStartPlayback(boolean paramBoolean)
  {
    if (this._CurrentTrack == null) {
      return;
    }
    CoreHelper.WriteTraceEntry("MovieViewControl", "Preparing video track '" + this._CurrentTrack.getName() + "', Url: " + this._CurrentTrack.getUrl() + ", Exists: " + this._CurrentTrack.Exists());
    this._IsPrepared = false;
    this._VideoView.stopPlayback();
    if (this._CurrentTrack.IsPlayed()) {
      this._CurrentTrack.ClearPlayed();
    }
    this._StartAfterSeek = paramBoolean;
    this._CurrentTrack.setCurrentPlayState(3);
    this._MetadataPublisher.PublishTrackInformation(this._CurrentTrack, true);
    if (this._CurrentTrack.Exists())
    {
      this._StreamableImage.setVisibility(8);
      this._ProgressView.setVisibility(8);
      this._TransportControls.setVisibility(0);
      this._SeekGroup.setVisibility(0);
      this._VideoView.setVideoPath(this._CurrentTrack.TrackPath());
    }
    for (;;)
    {
      this._Handler.removeCallbacksAndMessages(null);
      this._Handler.postDelayed(this.mPlayingChecker, 250L);
      return;
      if (this._CurrentTrack.getUrl() != null)
      {
        this._ProgressView.setVisibility(0);
        this._TransportControls.setVisibility(8);
        this._SeekGroup.setVisibility(8);
        this._StreamableImage.setVisibility(0);
        this._VideoView.postDelayed(new Runnable()
        {
          public void run()
          {
            MovieViewControl.this._VideoView.setVideoURI(Uri.parse(MovieViewControl.this._CurrentTrack.getUrl()));
          }
        }, 500L);
      }
    }
  }
  
  private void SaveCurrentTrackPosition()
  {
    int i = this._VideoView.getCurrentPosition();
    if ((this._IsPrepared) && (this._CurrentTrack != null) && (i > 0) && (!this._CurrentTrack.IsPlayed()))
    {
      CoreHelper.WriteTraceEntry("MovieViewControl", "Saving current position of '" + this._CurrentTrack.getName() + "' => " + i / 1000);
      this._CurrentTrack.setPlayedTime(i / 1000);
      FeedRepository.SaveRepositoryAsync();
    }
  }
  
  public boolean IsPlaying()
  {
    return (this._VideoView != null) && (this._VideoView.isPlaying());
  }
  
  public void PlayTrack(Track paramTrack)
  {
    this._VideoView.requestFocus();
    Intent localIntent = new Intent("com.android.music.musicservicecommand");
    localIntent.putExtra("command", "pause");
    this._Context.sendBroadcast(localIntent);
    this._VideoView.stopPlayback();
    this._PositionWhenPaused = -1;
    this._CurrentTrack = paramTrack;
    PrepareAndStartPlayback(true);
    this._MediaController.show(3600000L);
  }
  
  public boolean PlaybackFailed()
  {
    return this._PlaybackFailed;
  }
  
  public void SkipToEnd()
  {
    stop();
    this._IsPrepared = false;
    this._PositionWhenPaused = -1;
    this._CurrentTrack.MarkPlayed();
  }
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    onCompletion(this._IsPrepared);
  }
  
  public void onCompletion(boolean paramBoolean) {}
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    CoreHelper.WriteTraceEntry("MovieViewControl", "Playback Error! Code1:" + paramInt1 + ",  Code2:" + paramInt2);
    this._PlaybackFailed = true;
    this._TrackName.setText(PLAYBACK_ERROR);
    this._Handler.removeCallbacksAndMessages(null);
    this._ProgressView.setVisibility(8);
    this._TransportControls.setVisibility(0);
    this._SeekGroup.setVisibility(0);
    return false;
  }
  
  public void onPause()
  {
    this._Handler.removeCallbacksAndMessages(null);
    SaveCurrentTrackPosition();
    this._PositionWhenPaused = this._VideoView.getCurrentPosition();
    this._WasPlayingWhenPaused = this._VideoView.isPlaying();
  }
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    if (this._CurrentTrack != null)
    {
      this._CurrentTrack.setCurrentPlayState(4);
      this._MetadataPublisher.PublishTrackInformation(this._CurrentTrack, false);
      this._IsPrepared = true;
      this._CurrentTrack.setTotalTime(paramMediaPlayer.getDuration() / 1000);
      if (!this._CurrentTrack.IsPartialyPlayed()) {
        break label122;
      }
      int i = (int)(this._CurrentTrack.getPlayedTime() * 1000L);
      this._VideoView.seekTo(i);
      if (this._StartAfterSeek) {
        play();
      }
    }
    for (;;)
    {
      this._StartAfterSeek = false;
      this._Handler.removeCallbacks(this.mPlayingChecker);
      this._Handler.postDelayed(this.mPlayingChecker, 500L);
      return;
      label122:
      if (this._StartAfterSeek) {
        play();
      }
    }
  }
  
  public void onResume(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this._PositionWhenPaused = -1;
      this._WasPlayingWhenPaused = false;
    }
    do
    {
      do
      {
        return;
      } while (this._PositionWhenPaused < 0);
      if (!this._VideoView.isPlaying()) {
        PrepareAndStartPlayback(false);
      }
      this._PositionWhenPaused = -1;
    } while (!this._WasPlayingWhenPaused);
    this._MediaController.show(3600000L);
  }
  
  public void onVideoWindowHidden(boolean paramBoolean)
  {
    if (paramBoolean) {
      pause();
    }
  }
  
  public void pause()
  {
    SaveCurrentTrackPosition();
    this._CurrentTrack.setCurrentPlayState(0);
    this._MetadataPublisher.PublishTrackInformation(this._CurrentTrack, false);
    BeyondPodApplication.GetInstance().SetPlayerPauseNotification(BeyondPodApplication.GetInstance().getApplicationContext(), this._CurrentTrack);
    this._VideoView.pause();
    ScheduledTasksManager.ScheduleSyncTaskIfSyncIsEnabled(15, TimeSpan.fromSeconds(1.0D), false);
  }
  
  public void play()
  {
    CoreHelper.WriteTraceEntry("MovieViewControl", "Starting playback of '" + this._CurrentTrack.getName() + "' <= " + this._CurrentTrack.getPlayedTime());
    this._CurrentTrack.setCurrentPlayState(1);
    this._MetadataPublisher.PublishTrackInformation(this._CurrentTrack, false);
    this._VideoView.start();
  }
  
  public void stop()
  {
    SaveCurrentTrackPosition();
    this._CurrentTrack.setCurrentPlayState(2);
    this._MetadataPublisher.PublishTrackInformation(this._CurrentTrack, false);
    BeyondPodApplication.GetInstance().SetPlayerPauseNotification(BeyondPodApplication.GetInstance().getApplicationContext(), this._CurrentTrack);
    this._VideoView.stopPlayback();
    ScheduledTasksManager.ScheduleSyncTaskIfSyncIsEnabled(15, TimeSpan.fromSeconds(1.0D), false);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/views/MovieViewControl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */