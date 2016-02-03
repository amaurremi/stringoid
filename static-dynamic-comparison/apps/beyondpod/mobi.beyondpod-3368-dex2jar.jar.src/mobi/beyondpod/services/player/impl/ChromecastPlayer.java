package mobi.beyondpod.services.player.impl;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaInfo.Builder;
import com.google.android.gms.cast.MediaMetadata;
import com.google.android.gms.cast.MediaStatus;
import com.google.android.gms.common.images.WebImage;
import java.io.IOException;
import mobi.beyondpod.BeyondPodApplication;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.helpers.DateTime;
import mobi.beyondpod.services.player.MediaPlaybackService;

@TargetApi(16)
public class ChromecastPlayer
{
  private static final int MEDIA_BUFFERING_UPDATE = 3;
  private static final int MEDIA_ERROR = 100;
  public static final int MEDIA_ERROR_IO = -1004;
  public static final int MEDIA_ERROR_MALFORMED = -1007;
  public static final int MEDIA_ERROR_NOT_VALID_FOR_PROGRESSIVE_PLAYBACK = 200;
  public static final int MEDIA_ERROR_SERVER_DIED = 100;
  public static final int MEDIA_ERROR_TIMED_OUT = -110;
  public static final int MEDIA_ERROR_UNKNOWN = 1;
  public static final int MEDIA_ERROR_UNSUPPORTED = -1010;
  private static final int MEDIA_INFO = 200;
  public static final int MEDIA_INFO_BAD_INTERLEAVING = 800;
  public static final int MEDIA_INFO_BUFFERING_END = 702;
  public static final int MEDIA_INFO_BUFFERING_START = 701;
  public static final int MEDIA_INFO_METADATA_UPDATE = 802;
  public static final int MEDIA_INFO_NOT_SEEKABLE = 801;
  public static final int MEDIA_INFO_STARTED_AS_NEXT = 2;
  public static final int MEDIA_INFO_TIMED_TEXT_ERROR = 900;
  public static final int MEDIA_INFO_UNKNOWN = 1;
  public static final int MEDIA_INFO_VIDEO_RENDERING_START = 3;
  public static final int MEDIA_INFO_VIDEO_TRACK_LAGGING = 700;
  private static final int MEDIA_NOP = 0;
  private static final int MEDIA_PLAYBACK_COMPLETE = 2;
  private static final int MEDIA_PREPARED = 1;
  private static final int MEDIA_SEEK_COMPLETE = 4;
  private static final int MEDIA_SET_VIDEO_SIZE = 5;
  public static final int MSG_ERROR_CHROMECAST = 101010;
  public static final int MSG_ERROR_EXTRA_INVALID_MESSAGE_STREAM = 100;
  public static final int MSG_ERROR_EXTRA_SESSION_INTERRUPTED = 200;
  private static final String TAG = "ChromecastPlayer";
  String _DataSource;
  private boolean _IsPlaying = false;
  private int _LastKnownPosition = 0;
  private ChromecastDevice.MediaControlChannel _MediaControlChannel;
  private ChromecastDevice.MediaFeedbackChannel _MediaFeedbackChannel;
  private MediaInfo _MediaInfo;
  private EventHandler mEventHandler;
  private OnBufferingUpdateListener mOnBufferingUpdateListener;
  private OnCompletionListener mOnCompletionListener;
  private OnErrorListener mOnErrorListener;
  private OnInfoListener mOnInfoListener;
  private OnPreparedListener mOnPreparedListener;
  private OnSeekCompleteListener mOnSeekCompleteListener;
  private OnVideoSizeChangedListener mOnVideoSizeChangedListener;
  private PowerManager.WakeLock mWakeLock = null;
  
  public ChromecastPlayer(Context paramContext)
  {
    paramContext = Looper.myLooper();
    if (paramContext != null) {
      this.mEventHandler = new EventHandler(this, paramContext);
    }
    for (;;)
    {
      this._MediaControlChannel = BeyondPodApplication.GetInstance().ChromecastDevice().getMediaControlChannel();
      this._MediaControlChannel.setNotificationListener(new ChromecastDevice.MediaControlChannel.StreamNotificationListener()
      {
        public void onLoadCompleted()
        {
          ChromecastPlayer.this.postEvent(new int[] { 3, 100 });
          ChromecastPlayer.this.postEvent(new int[] { 1 });
        }
        
        public void onLoadFailed()
        {
          ChromecastPlayer.this.postEvent(new int[] { 100 });
        }
        
        public void onSeekCompleted()
        {
          ChromecastPlayer.this.postEvent(new int[] { 4 });
        }
        
        public void onSeekFailed()
        {
          ChromecastPlayer.this.postEvent(new int[] { 100 });
        }
        
        public void onSessionInterrupted(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          paramAnonymousInt2 = 100;
          ChromecastPlayer localChromecastPlayer = ChromecastPlayer.this;
          if (paramAnonymousInt1 == 3) {
            paramAnonymousInt2 = 200;
          }
          localChromecastPlayer.postEvent(new int[] { 100, 101010, paramAnonymousInt2 });
        }
      });
      this._MediaFeedbackChannel = BeyondPodApplication.GetInstance().ChromecastDevice().getMediaFeedbackChannel();
      this._MediaFeedbackChannel.setNotificationListener(new ChromecastDevice.MediaFeedbackChannel.FeedbackNotificationListener()
      {
        public void onPlaybackComplete(String paramAnonymousString)
        {
          if (paramAnonymousString.equals(ChromecastPlayer.this._DataSource))
          {
            CoreHelper.WriteTraceEntry("ChromecastPlayer", "Detected 'playback complete' event!");
            ChromecastPlayer.this.pause();
            ChromecastPlayer.this.postEvent(new int[] { 2 });
            return;
          }
          CoreHelper.WriteTraceEntry("ChromecastPlayer", "Detected 'playback complete' but not for our DataSource! DataSource: " + ChromecastPlayer.this._DataSource + ", event contentId: " + paramAnonymousString);
        }
        
        public void onPlaybackError()
        {
          ChromecastPlayer.this.postEvent(new int[] { 100 });
        }
        
        public void onVideoFocusGain()
        {
          CoreHelper.WriteTraceEntry("ChromecastPlayer", "Got 'videoFocusGain' event!");
        }
        
        public void onVideoFocusLost()
        {
          CoreHelper.WriteTraceEntry("ChromecastPlayer", "Video input was switched away! Is playing: " + ChromecastPlayer.this.isPlaying());
          if (ChromecastPlayer.this.isPlaying())
          {
            CoreHelper.WriteTraceEntry("ChromecastPlayer", "Pausing Chromecast playback...");
            Intent localIntent = new Intent(BeyondPodApplication.GetInstance(), MediaPlaybackService.class);
            localIntent.setAction("mobi.beyondpod.services.musicservicecommand");
            localIntent.putExtra("command", "pause");
            BeyondPodApplication.GetInstance().startService(localIntent);
          }
        }
      });
      return;
      paramContext = Looper.getMainLooper();
      if (paramContext != null) {
        this.mEventHandler = new EventHandler(this, paramContext);
      } else {
        this.mEventHandler = null;
      }
    }
  }
  
  private void postEvent(int... paramVarArgs)
  {
    if (this.mEventHandler != null)
    {
      Message localMessage = this.mEventHandler.obtainMessage(paramVarArgs[0]);
      if (paramVarArgs.length > 1) {
        localMessage.arg1 = paramVarArgs[1];
      }
      if (paramVarArgs.length > 2) {
        localMessage.arg2 = paramVarArgs[2];
      }
      this.mEventHandler.sendMessage(localMessage);
    }
  }
  
  private void resetInternal()
  {
    stayAwake(false);
    this.mEventHandler.removeCallbacksAndMessages(null);
  }
  
  private void stayAwake(boolean paramBoolean)
  {
    if (this.mWakeLock != null)
    {
      if ((!paramBoolean) || (this.mWakeLock.isHeld())) {
        break label29;
      }
      this.mWakeLock.acquire();
    }
    label29:
    while ((paramBoolean) || (!this.mWakeLock.isHeld())) {
      return;
    }
    this.mWakeLock.release();
  }
  
  public int getCurrentPosition()
  {
    try
    {
      if ((this._MediaControlChannel != null) && (this._MediaControlChannel.getMediaStatus() != null))
      {
        if (this._MediaControlChannel.getMediaStatus().getPlayerState() == 1) {
          return this._LastKnownPosition;
        }
        this._LastKnownPosition = ((int)this._MediaControlChannel.getApproximateStreamPosition());
        int i = this._LastKnownPosition;
        return i;
      }
    }
    catch (Exception localException)
    {
      CoreHelper.WriteTraceErrorInDebug("ChromecastPlayer", "=== Unable to getPosition from remote media!" + localException.getMessage());
    }
    return 0;
  }
  
  public int getDuration()
  {
    try
    {
      if (this._MediaControlChannel != null)
      {
        long l = this._MediaControlChannel.getStreamDuration();
        return (int)l;
      }
    }
    catch (Exception localException)
    {
      CoreHelper.WriteTraceErrorInDebug("ChromecastPlayer", "=== Unable to getDuration from remote media!" + localException.getMessage());
    }
    return 0;
  }
  
  public boolean isPlaying()
  {
    if (this._MediaControlChannel != null) {
      return this._IsPlaying;
    }
    return false;
  }
  
  public void pause()
    throws IllegalStateException
  {
    stop();
  }
  
  public void prepare()
    throws IOException, IllegalStateException
  {
    throw new IllegalStateException("Not supported!");
  }
  
  public void prepareAsync()
  {
    CoreHelper.WriteTraceEntryInDebug("ChromecastPlayer", "Chromecast Prepare Started for: " + this._DataSource);
    if (this._MediaControlChannel == null)
    {
      postEvent(new int[] { 100, 101010, 100 });
      return;
    }
    try
    {
      MediaInfo localMediaInfo = this._MediaControlChannel.getMediaInfo();
      if ((this._MediaControlChannel.hasRemotePlayerLoadedMedia()) && (localMediaInfo != null) && (localMediaInfo.getContentId() != null) && (localMediaInfo.getContentId().equals(this._DataSource)))
      {
        CoreHelper.WriteTraceEntryInDebug("ChromecastPlayer", "Found that media is already loaded! Nothing to do.");
        postEvent(new int[] { 1 });
        return;
      }
    }
    catch (Exception localException)
    {
      postEvent(new int[] { 100 });
      CoreHelper.WriteTraceErrorInDebug("ChromecastPlayer", "Unable to open remote media!" + localException.getMessage());
      return;
    }
    this._MediaControlChannel.load(this._MediaInfo);
    postEvent(new int[] { 3, 40 });
  }
  
  public void release()
  {
    resetInternal();
    this.mOnBufferingUpdateListener = null;
    this.mOnCompletionListener = null;
    this.mOnErrorListener = null;
    this.mOnInfoListener = null;
    this.mOnPreparedListener = null;
    this.mOnSeekCompleteListener = null;
    this.mOnVideoSizeChangedListener = null;
    if (this._MediaControlChannel != null) {
      this._MediaControlChannel.setNotificationListener(null);
    }
    this._MediaControlChannel = null;
    if (this._MediaFeedbackChannel != null) {
      this._MediaFeedbackChannel.setNotificationListener(null);
    }
    this._MediaFeedbackChannel = null;
    CoreHelper.WriteTraceEntry("ChromecastPlayer", "Chromecast Player Released!");
  }
  
  public void reset()
  {
    resetInternal();
    CoreHelper.WriteTraceEntry("ChromecastPlayer", "Chromecast Player Reset!");
  }
  
  public void seekTo(int paramInt)
    throws IllegalStateException
  {
    if (this._MediaControlChannel != null)
    {
      if (Math.abs(getCurrentPosition() - paramInt) < 2000) {
        postEvent(new int[] { 4 });
      }
    }
    else {
      return;
    }
    try
    {
      this._MediaControlChannel.seek(this._MediaInfo, paramInt);
      return;
    }
    catch (Exception localException)
    {
      postEvent(new int[] { 100 });
      CoreHelper.WriteTraceErrorInDebug("ChromecastPlayer", "=== Unable to seek remote media!" + localException.getMessage());
    }
  }
  
  public void setAudioStreamType(int paramInt) {}
  
  public void setDataSource(IMediaPlayerImpl.TrackMetadata paramTrackMetadata)
    throws IOException, IllegalArgumentException, SecurityException, IllegalStateException
  {
    this._DataSource = paramTrackMetadata.TrackURL;
    this._LastKnownPosition = 0;
    MediaMetadata localMediaMetadata = new MediaMetadata();
    localMediaMetadata.addImage(new WebImage(Uri.parse(paramTrackMetadata.TrackImageUrl)));
    localMediaMetadata.putString("com.google.android.gms.cast.metadata.TITLE", paramTrackMetadata.TrackName);
    localMediaMetadata.putString("com.google.android.gms.cast.metadata.SUBTITLE", DateTime.FormatDateTimeToday(paramTrackMetadata.TrackDate));
    this._MediaInfo = new MediaInfo.Builder(this._DataSource).setStreamType(1).setContentType(paramTrackMetadata.MimeType).setMetadata(localMediaMetadata).build();
  }
  
  public void setOnBufferingUpdateListener(OnBufferingUpdateListener paramOnBufferingUpdateListener)
  {
    this.mOnBufferingUpdateListener = paramOnBufferingUpdateListener;
  }
  
  public void setOnCompletionListener(OnCompletionListener paramOnCompletionListener)
  {
    this.mOnCompletionListener = paramOnCompletionListener;
  }
  
  public void setOnErrorListener(OnErrorListener paramOnErrorListener)
  {
    this.mOnErrorListener = paramOnErrorListener;
  }
  
  public void setOnInfoListener(OnInfoListener paramOnInfoListener)
  {
    this.mOnInfoListener = paramOnInfoListener;
  }
  
  public void setOnPreparedListener(OnPreparedListener paramOnPreparedListener)
  {
    this.mOnPreparedListener = paramOnPreparedListener;
  }
  
  public void setOnSeekCompleteListener(OnSeekCompleteListener paramOnSeekCompleteListener)
  {
    this.mOnSeekCompleteListener = paramOnSeekCompleteListener;
  }
  
  public void setOnVideoSizeChangedListener(OnVideoSizeChangedListener paramOnVideoSizeChangedListener)
  {
    this.mOnVideoSizeChangedListener = paramOnVideoSizeChangedListener;
  }
  
  public void setVolume(float paramFloat1, float paramFloat2) {}
  
  public void setWakeMode(Context paramContext, int paramInt)
  {
    int i = 0;
    int j = 0;
    if (this.mWakeLock != null)
    {
      i = j;
      if (this.mWakeLock.isHeld())
      {
        i = 1;
        this.mWakeLock.release();
      }
      this.mWakeLock = null;
    }
    this.mWakeLock = ((PowerManager)paramContext.getSystemService("power")).newWakeLock(0x20000000 | paramInt, ChromecastPlayer.class.getName());
    this.mWakeLock.setReferenceCounted(false);
    if (i != 0) {
      this.mWakeLock.acquire();
    }
  }
  
  public void start()
    throws IllegalStateException
  {
    try
    {
      if (this._MediaControlChannel != null)
      {
        this._IsPlaying = true;
        this._MediaControlChannel.play();
        stayAwake(true);
      }
      return;
    }
    catch (Exception localException)
    {
      postEvent(new int[] { 100 });
      CoreHelper.WriteTraceErrorInDebug("ChromecastPlayer", "=== Unable to start remote media!" + localException.getMessage());
    }
  }
  
  public void stop()
    throws IllegalStateException
  {
    try
    {
      if (this._MediaControlChannel != null) {
        this._MediaControlChannel.pause();
      }
      stayAwake(false);
      this._IsPlaying = false;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        CoreHelper.WriteTraceErrorInDebug("ChromecastPlayer", "=== Unable to stop remote media!" + localException.getMessage());
      }
    }
  }
  
  private class EventHandler
    extends Handler
  {
    private ChromecastPlayer mMediaPlayer;
    
    public EventHandler(ChromecastPlayer paramChromecastPlayer, Looper paramLooper)
    {
      super();
      this.mMediaPlayer = paramChromecastPlayer;
    }
    
    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default: 
        CoreHelper.WriteTraceEntry("ChromecastPlayer", "Unknown message type " + paramMessage.what);
      }
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return;
              } while (ChromecastPlayer.this.mOnPreparedListener == null);
              ChromecastPlayer.this.mOnPreparedListener.onPrepared(this.mMediaPlayer);
              return;
              if (ChromecastPlayer.this.mOnCompletionListener != null) {
                ChromecastPlayer.this.mOnCompletionListener.onCompletion(this.mMediaPlayer);
              }
              ChromecastPlayer.this.stayAwake(false);
              return;
            } while (ChromecastPlayer.this.mOnBufferingUpdateListener == null);
            ChromecastPlayer.this.mOnBufferingUpdateListener.onBufferingUpdate(this.mMediaPlayer, paramMessage.arg1);
            return;
          } while (ChromecastPlayer.this.mOnSeekCompleteListener == null);
          ChromecastPlayer.this.mOnSeekCompleteListener.onSeekComplete(this.mMediaPlayer);
          return;
        } while (ChromecastPlayer.this.mOnVideoSizeChangedListener == null);
        ChromecastPlayer.this.mOnVideoSizeChangedListener.onVideoSizeChanged(this.mMediaPlayer, paramMessage.arg1, paramMessage.arg2);
        return;
        CoreHelper.WriteTraceErrorInDebug("ChromecastPlayer", "Error (" + paramMessage.arg1 + "," + paramMessage.arg2 + ")");
        ChromecastPlayer.this._IsPlaying = false;
        boolean bool = false;
        if (ChromecastPlayer.this.mOnErrorListener != null) {
          bool = ChromecastPlayer.this.mOnErrorListener.onError(this.mMediaPlayer, paramMessage.arg1, paramMessage.arg2);
        }
        if ((ChromecastPlayer.this.mOnCompletionListener != null) && (!bool)) {
          ChromecastPlayer.this.mOnCompletionListener.onCompletion(this.mMediaPlayer);
        }
        ChromecastPlayer.this.stayAwake(false);
        return;
        if (paramMessage.arg1 != 700) {
          CoreHelper.WriteTraceEntry("ChromecastPlayer", "Info (" + paramMessage.arg1 + "," + paramMessage.arg2 + ")");
        }
      } while (ChromecastPlayer.this.mOnInfoListener == null);
      ChromecastPlayer.this.mOnInfoListener.onInfo(this.mMediaPlayer, paramMessage.arg1, paramMessage.arg2);
    }
  }
  
  public static abstract interface OnBufferingUpdateListener
  {
    public abstract void onBufferingUpdate(ChromecastPlayer paramChromecastPlayer, int paramInt);
  }
  
  public static abstract interface OnCompletionListener
  {
    public abstract void onCompletion(ChromecastPlayer paramChromecastPlayer);
  }
  
  public static abstract interface OnErrorListener
  {
    public abstract boolean onError(ChromecastPlayer paramChromecastPlayer, int paramInt1, int paramInt2);
  }
  
  public static abstract interface OnInfoListener
  {
    public abstract boolean onInfo(ChromecastPlayer paramChromecastPlayer, int paramInt1, int paramInt2);
  }
  
  public static abstract interface OnPreparedListener
  {
    public abstract void onPrepared(ChromecastPlayer paramChromecastPlayer);
  }
  
  public static abstract interface OnSeekCompleteListener
  {
    public abstract void onSeekComplete(ChromecastPlayer paramChromecastPlayer);
  }
  
  public static abstract interface OnVideoSizeChangedListener
  {
    public abstract void onVideoSizeChanged(ChromecastPlayer paramChromecastPlayer, int paramInt1, int paramInt2);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/services/player/impl/ChromecastPlayer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */