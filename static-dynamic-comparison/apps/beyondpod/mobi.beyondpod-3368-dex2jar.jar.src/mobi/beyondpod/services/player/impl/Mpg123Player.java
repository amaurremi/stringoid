package mobi.beyondpod.services.player.impl;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.Process;
import com.badlogic.gdx.audio.io.BadLogicAudioDecoder;
import java.io.File;
import java.io.IOException;
import mobi.beyondpod.rsscore.Configuration;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.helpers.MediaFile;
import mobi.beyondpod.rsscore.helpers.MediaFile.MediaFileType;
import mobi.beyondpod.rsscore.helpers.StringUtils;
import org.vinuxproject.sonic.AndroidAudioDevice;
import org.vinuxproject.sonic.Sonic;

public class Mpg123Player
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
  private static final int PLAYER_STATE_ERROR = -1;
  private static final int PLAYER_STATE_IDLE = 0;
  private static final int PLAYER_STATE_INITIALIZED = 1;
  private static final int PLAYER_STATE_PAUSED = 5;
  private static final int PLAYER_STATE_PLAYBACK_COMPLETED = 7;
  private static final int PLAYER_STATE_PREPARED = 3;
  private static final int PLAYER_STATE_PREPARING = 2;
  private static final int PLAYER_STATE_RELEASED = -2;
  private static final int PLAYER_STATE_STARTED = 4;
  private static final int PLAYER_STATE_STOPPED = 6;
  private static final String TAG = "Mpg123Player";
  String _DataSource;
  int _SelectedTrack;
  private AndroidAudioDevice mAudioTrack;
  int mChannelCount;
  long mDuration = -1L;
  private EventHandler mEventHandler;
  BadLogicAudioDecoder mExtractor;
  volatile long mMustSeekToPosition = -1L;
  private OnBufferingUpdateListener mOnBufferingUpdateListener;
  private OnCompletionListener mOnCompletionListener;
  private OnErrorListener mOnErrorListener;
  private OnInfoListener mOnInfoListener;
  private OnPreparedListener mOnPreparedListener;
  private OnSeekCompleteListener mOnSeekCompleteListener;
  private OnVideoSizeChangedListener mOnVideoSizeChangedListener;
  private PlayerWorker mPlayerWorker;
  int mSampleRate;
  Sonic mSonic;
  byte[] mSonicInBuffer;
  byte[] mSonicOutBuffer;
  private int mState = 0;
  private PowerManager.WakeLock mWakeLock = null;
  Runnable playingRunnable = new Runnable()
  {
    public void run()
    {
      Mpg123Player.this.playInternal();
    }
  };
  Runnable preparingRunnable = new Runnable()
  {
    public void run()
    {
      try
      {
        Mpg123Player.this.prepare();
        return;
      }
      catch (Exception localException)
      {
        CoreHelper.LogException("Mpg123Player", "Failed to prepare Async!", localException);
        Mpg123Player.this.mState = -1;
        Mpg123Player.this.postEvent(new int[] { 100 });
      }
    }
  };
  SeekRunnable seekingRunnable;
  
  public Mpg123Player()
  {
    Looper localLooper = Looper.myLooper();
    if (localLooper != null)
    {
      this.mEventHandler = new EventHandler(this, localLooper);
      return;
    }
    localLooper = Looper.getMainLooper();
    if (localLooper != null)
    {
      this.mEventHandler = new EventHandler(this, localLooper);
      return;
    }
    this.mEventHandler = null;
  }
  
  private boolean IsCurrentlySeeking()
  {
    return (this.seekingRunnable != null) && (this.seekingRunnable.IsSeeking());
  }
  
  private void StartPlayerWorker()
  {
    CoreHelper.WriteTraceEntry("Mpg123Player", "### Mpg123Player - Starting player worker...");
    if (this.mPlayerWorker != null) {
      this.mPlayerWorker.release();
    }
    this.mPlayerWorker = new PlayerWorker(null);
    this.mPlayerWorker.setName("Mpg123Player Worker Thread");
    this.mPlayerWorker.start();
    for (;;)
    {
      if (this.mPlayerWorker._IsReady) {
        return;
      }
      try
      {
        Thread.sleep(10L);
      }
      catch (InterruptedException localInterruptedException) {}
    }
  }
  
  public static boolean isSonicLibraryInstalled()
  {
    return (CoreHelper.ApiLevel() > 7) && (Configuration.EnableSonicAudioPlugin());
  }
  
  private void playInternal()
  {
    if ((this.mExtractor == null) || (this.mAudioTrack == null)) {
      throw new IllegalStateException("Data source not prepared!");
    }
    int i = 0;
    int k;
    label68:
    label81:
    label286:
    do
    {
      for (;;)
      {
        try
        {
          if (Thread.interrupted())
          {
            break;
            k = playSonicBuffer();
            j = i;
            if (k <= 0) {
              break label346;
            }
            Thread.sleep(100L);
            CoreHelper.WriteTraceEntry("Mpg123Player", "Waiting for Sonic to finish...");
            j = i - 1;
            break label346;
            j = this.mAudioTrack.getHeadPosition();
            i = 0;
            break label359;
            CoreHelper.WriteTraceEntry("Mpg123Player", "Track completed!");
            this.mAudioTrack.flush();
            postEvent(new int[] { 2 });
            this.mState = 7;
          }
          else
          {
            if (this.mMustSeekToPosition >= 0L)
            {
              this.mAudioTrack.flush();
              this.mSonic.flush();
              this.mExtractor.seekTo(this.mMustSeekToPosition);
              this.mMustSeekToPosition = -1L;
              this.mAudioTrack.play();
              postEvent(new int[] { 4 });
            }
            if (!this.mAudioTrack.isPlaying()) {
              CoreHelper.WriteTraceEntry("Mpg123Player", "Playing runnable found that the audioTrack is not Playing. Stopping the playback loop...");
            }
          }
        }
        catch (Exception localException)
        {
          this.mState = -1;
          postEvent(new int[] { 100 });
          return;
        }
        j = this.mExtractor.decodeMP3();
        if (j <= 0) {
          break label369;
        }
        if ((this.mSonicInBuffer == null) || (this.mSonicInBuffer.length < j * 2)) {
          this.mSonicInBuffer = new byte[j * 2];
        }
        j = this.mExtractor.getPCMData(this.mSonicInBuffer);
        this.mSonic.putBytes(this.mSonicInBuffer, j);
        playSonicBuffer();
      }
      Thread.sleep(500L);
      k = this.mAudioTrack.getHeadPosition();
    } while (j == k);
    int j = k;
    CoreHelper.WriteTraceEntry("Mpg123Player", "Waiting for AudioTrack to finish... " + k);
    i += 1;
    for (;;)
    {
      if (i != 0)
      {
        i = 10;
        break;
        label346:
        if (k <= 0) {
          break label68;
        }
        i = j;
        if (j > 0) {
          break;
        }
        break label68;
        label359:
        if (i != 10) {
          break label286;
        }
        break label81;
      }
      return;
      label369:
      i = 1;
    }
  }
  
  private int playSonicBuffer()
  {
    int i = this.mSonic.availableBytes();
    if (i > 0)
    {
      if ((this.mSonicOutBuffer == null) || (this.mSonicOutBuffer.length < i)) {
        this.mSonicOutBuffer = new byte[i * 2];
      }
      this.mSonic.receiveBytes(this.mSonicOutBuffer, i);
      this.mAudioTrack.writeSamples(this.mSonicOutBuffer, i);
    }
    return i;
  }
  
  private Handler playerPlaybackHandler()
  {
    return this.mPlayerWorker.workerHandler;
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
    this.mMustSeekToPosition = -1L;
    this.mEventHandler.removeCallbacksAndMessages(null);
    if (this.mPlayerWorker != null)
    {
      this.mPlayerWorker.release();
      this.mPlayerWorker.interrupt();
    }
    this.mPlayerWorker = null;
    this.seekingRunnable = null;
    if (this.mAudioTrack != null)
    {
      this.mAudioTrack.release();
      this.mAudioTrack = null;
    }
    if (this.mExtractor != null)
    {
      this.mExtractor.release();
      this.mExtractor = null;
    }
    if (this.mSonic != null)
    {
      this.mSonic.close();
      this.mSonic = null;
    }
    this.mSonicInBuffer = null;
    this.mSonicOutBuffer = null;
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
  
  public static boolean verifyFormatIsSupported(String paramString1, String paramString2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!StringUtils.IsNullOrEmpty(paramString1))
    {
      bool1 = bool2;
      if (new File(paramString1).exists())
      {
        MediaFile.MediaFileType localMediaFileType = MediaFile.getFileType(paramString1);
        if ((localMediaFileType == null) || (localMediaFileType.fileType != 1)) {
          break label93;
        }
      }
    }
    label93:
    for (bool1 = true; bool1; bool1 = false)
    {
      CoreHelper.WriteTraceEntry("Mpg123Player", "Episode " + paramString1 + ", (" + paramString2 + ") is supported");
      return bool1;
    }
    CoreHelper.WriteTraceEntry("Mpg123Player", "Episode " + paramString1 + ", (" + paramString2 + ") is NOT supported!");
    return bool1;
  }
  
  public int getCurrentPosition()
  {
    if (this.mExtractor == null) {
      return -1;
    }
    if (IsCurrentlySeeking()) {
      return (int)this.seekingRunnable.getSeekToPos();
    }
    long l = this.mExtractor.getCurrentPos();
    if (l < 0L) {
      return getDuration();
    }
    return (int)l;
  }
  
  public int getDuration()
  {
    if (this.mDuration > 0L) {}
    for (long l = this.mDuration;; l = this.mDuration) {
      return (int)l;
    }
  }
  
  public float getPitch()
  {
    if (this.mSonic != null) {
      return this.mSonic.getPitch();
    }
    return 1.0F;
  }
  
  public float getPlaybackSpeed()
  {
    if (this.mSonic != null) {
      return this.mSonic.getSpeed();
    }
    return 1.0F;
  }
  
  public boolean isPlaying()
  {
    return (this.mAudioTrack != null) && (this.mAudioTrack.isPlaying());
  }
  
  public void pause()
    throws IllegalStateException
  {
    stayAwake(false);
    this.mAudioTrack.pause();
    this.mState = 5;
  }
  
  public void prepare()
    throws IOException, IllegalStateException
  {
    if ((this.mState != 1) && (this.mState != 6)) {
      throw new IllegalStateException("prepare() invoked from invalid state: " + this.mState);
    }
    if (!this.mExtractor.setDataSource(this._DataSource))
    {
      this.mState = -1;
      throw new IOException("Invalid media format: " + this._DataSource);
    }
    this.mDuration = this.mExtractor.getSampleTime();
    this.mChannelCount = this.mExtractor.getChannelCount();
    this.mSampleRate = this.mExtractor.getSampleRate();
    this.mSonic = new Sonic(this.mSampleRate, this.mChannelCount);
    this.mAudioTrack = new AndroidAudioDevice(this.mSampleRate, this.mChannelCount);
    this.mState = 3;
    postEvent(new int[] { 1 });
  }
  
  public void prepareAsync()
    throws IllegalStateException
  {
    if ((this.mState != 1) && (this.mState != 6)) {
      throw new IllegalStateException("prepare() invoked from invalid state: " + this.mState);
    }
    this.mState = 2;
    playerPlaybackHandler().removeCallbacks(this.preparingRunnable);
    playerPlaybackHandler().post(this.preparingRunnable);
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
    this.mState = -2;
    CoreHelper.WriteTraceEntry("Mpg123Player", "Mpg123Player Released!");
  }
  
  public void reset()
  {
    resetInternal();
    this.mState = 0;
    CoreHelper.WriteTraceEntry("Mpg123Player", "Mpg123Player Reset!");
  }
  
  public void seekTo(int paramInt)
    throws IllegalStateException
  {
    if ((this.mState != 5) && (this.mState != 3) && (this.mState != 4) && (this.mState != 7)) {
      throw new IllegalStateException("seekTo() invoked without first calling prepare()");
    }
    if (IsCurrentlySeeking())
    {
      CoreHelper.WriteTraceEntry("Mpg123Player", "Received new seek request while onother one is pending. Seek ignored!");
      return;
    }
    if (!isPlaying())
    {
      CoreHelper.WriteTraceEntry("Mpg123Player", "  Preparing to seek... (not playing, posting to handler)");
      this.seekingRunnable = new SeekRunnable(paramInt);
      playerPlaybackHandler().removeCallbacksAndMessages(null);
      playerPlaybackHandler().post(this.seekingRunnable);
      return;
    }
    this.mMustSeekToPosition = paramInt;
    CoreHelper.WriteTraceEntry("Mpg123Player", "  Seeking while player is playing...");
  }
  
  public void setAudioStreamType(int paramInt)
  {
    if (this.mAudioTrack != null) {
      this.mAudioTrack.setAudioStreamType(paramInt);
    }
  }
  
  public void setDataSource(String paramString)
    throws IOException, IllegalArgumentException, SecurityException, IllegalStateException
  {
    if (this.mState != 0) {
      throw new IllegalStateException("setDataSource() invoked from invalid state: " + this.mState);
    }
    StartPlayerWorker();
    this._DataSource = paramString;
    if (this.mExtractor != null) {
      reset();
    }
    this.mExtractor = new BadLogicAudioDecoder();
    this.mState = 1;
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
  
  public void setPitch(float paramFloat)
  {
    if (this.mSonic != null) {
      this.mSonic.setPitch(paramFloat);
    }
  }
  
  public void setPlaybackSpeed(float paramFloat)
  {
    if (this.mSonic != null) {
      this.mSonic.setSpeed(paramFloat);
    }
  }
  
  public void setVolume(float paramFloat1, float paramFloat2)
  {
    if (this.mAudioTrack != null) {
      this.mAudioTrack.setVolume(paramFloat1, paramFloat2);
    }
  }
  
  public void setVolumeBoost(float paramFloat)
  {
    if (this.mSonic != null) {
      this.mSonic.setVolume(paramFloat);
    }
  }
  
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
    this.mWakeLock = ((PowerManager)paramContext.getSystemService("power")).newWakeLock(0x20000000 | paramInt, Mpg123Player.class.getName());
    this.mWakeLock.setReferenceCounted(false);
    if (i != 0) {
      this.mWakeLock.acquire();
    }
  }
  
  public void start()
    throws IllegalStateException
  {
    if (this.mState == 4) {
      return;
    }
    if ((this.mState != 5) && (this.mState != 3) && (this.mState != 7)) {
      throw new IllegalStateException("start() invoked from invalid state: " + this.mState);
    }
    if (IsCurrentlySeeking())
    {
      CoreHelper.WriteTraceEntry("Mpg123Player", "start() invoked while player is seeking! Ignoring...");
      return;
    }
    stayAwake(true);
    this.mAudioTrack.play();
    playerPlaybackHandler().removeCallbacks(this.playingRunnable);
    playerPlaybackHandler().post(this.playingRunnable);
    this.mState = 4;
  }
  
  public void stop()
    throws IllegalStateException
  {
    stayAwake(false);
    this.mAudioTrack.stop();
    this.mState = 6;
  }
  
  private class EventHandler
    extends Handler
  {
    private Mpg123Player mMediaPlayer;
    
    public EventHandler(Mpg123Player paramMpg123Player, Looper paramLooper)
    {
      super();
      this.mMediaPlayer = paramMpg123Player;
    }
    
    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default: 
        CoreHelper.WriteTraceEntry("Mpg123Player", "Unknown message type " + paramMessage.what);
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
              } while (Mpg123Player.this.mOnPreparedListener == null);
              Mpg123Player.this.mOnPreparedListener.onPrepared(this.mMediaPlayer);
              return;
              if (Mpg123Player.this.mOnCompletionListener != null) {
                Mpg123Player.this.mOnCompletionListener.onCompletion(this.mMediaPlayer);
              }
              Mpg123Player.this.stayAwake(false);
              return;
            } while (Mpg123Player.this.mOnBufferingUpdateListener == null);
            Mpg123Player.this.mOnBufferingUpdateListener.onBufferingUpdate(this.mMediaPlayer, paramMessage.arg1);
            return;
          } while (Mpg123Player.this.mOnSeekCompleteListener == null);
          Mpg123Player.this.mOnSeekCompleteListener.onSeekComplete(this.mMediaPlayer);
          return;
        } while (Mpg123Player.this.mOnVideoSizeChangedListener == null);
        Mpg123Player.this.mOnVideoSizeChangedListener.onVideoSizeChanged(this.mMediaPlayer, paramMessage.arg1, paramMessage.arg2);
        return;
        CoreHelper.WriteTraceErrorInDebug("Mpg123Player", "Error (" + paramMessage.arg1 + "," + paramMessage.arg2 + ")");
        boolean bool = false;
        if (Mpg123Player.this.mOnErrorListener != null) {
          bool = Mpg123Player.this.mOnErrorListener.onError(this.mMediaPlayer, paramMessage.arg1, paramMessage.arg2);
        }
        if ((Mpg123Player.this.mOnCompletionListener != null) && (!bool)) {
          Mpg123Player.this.mOnCompletionListener.onCompletion(this.mMediaPlayer);
        }
        Mpg123Player.this.stayAwake(false);
        return;
        if (paramMessage.arg1 != 700) {
          CoreHelper.WriteTraceEntry("Mpg123Player", "Info (" + paramMessage.arg1 + "," + paramMessage.arg2 + ")");
        }
      } while (Mpg123Player.this.mOnInfoListener == null);
      Mpg123Player.this.mOnInfoListener.onInfo(this.mMediaPlayer, paramMessage.arg1, paramMessage.arg2);
    }
  }
  
  public static abstract interface OnBufferingUpdateListener
  {
    public abstract void onBufferingUpdate(Mpg123Player paramMpg123Player, int paramInt);
  }
  
  public static abstract interface OnCompletionListener
  {
    public abstract void onCompletion(Mpg123Player paramMpg123Player);
  }
  
  public static abstract interface OnErrorListener
  {
    public abstract boolean onError(Mpg123Player paramMpg123Player, int paramInt1, int paramInt2);
  }
  
  public static abstract interface OnInfoListener
  {
    public abstract boolean onInfo(Mpg123Player paramMpg123Player, int paramInt1, int paramInt2);
  }
  
  public static abstract interface OnPreparedListener
  {
    public abstract void onPrepared(Mpg123Player paramMpg123Player);
  }
  
  public static abstract interface OnSeekCompleteListener
  {
    public abstract void onSeekComplete(Mpg123Player paramMpg123Player);
  }
  
  public static abstract interface OnVideoSizeChangedListener
  {
    public abstract void onVideoSizeChanged(Mpg123Player paramMpg123Player, int paramInt1, int paramInt2);
  }
  
  private static class PlayerWorker
    extends Thread
  {
    private volatile boolean _IsReady = false;
    Looper looper;
    private Handler workerHandler;
    
    protected void finalize()
      throws Throwable
    {
      super.finalize();
      CoreHelper.WriteTraceEntry("Mpg123Player", "Mpg123Player worker thread finalized!");
    }
    
    public void release()
    {
      if (this.workerHandler != null)
      {
        this.workerHandler.removeCallbacksAndMessages(null);
        this.workerHandler = null;
      }
      if (this.looper != null) {
        this.looper.quit();
      }
      CoreHelper.WriteTraceEntry("Mpg123Player", "### Mpg123Player worker thread released!");
    }
    
    public void run()
    {
      Process.setThreadPriority(-16);
      Looper.prepare();
      this.looper = Looper.myLooper();
      this.workerHandler = new Handler();
      this._IsReady = true;
      Looper.loop();
    }
  }
  
  private class SeekRunnable
    implements Runnable
  {
    boolean _isSeeking = false;
    long _seekToPos;
    
    SeekRunnable(long paramLong)
    {
      this._seekToPos = paramLong;
    }
    
    boolean IsSeeking()
    {
      return this._isSeeking;
    }
    
    long getSeekToPos()
    {
      return this._seekToPos;
    }
    
    public void run()
    {
      try
      {
        this._isSeeking = true;
        Mpg123Player.this.mExtractor.seekTo(this._seekToPos);
        Mpg123Player.this.postEvent(new int[] { 4 });
        this._isSeeking = false;
        return;
      }
      catch (Exception localException)
      {
        CoreHelper.LogException("Mpg123Player", "Failed to seek!", localException);
        Mpg123Player.this.mState = -1;
        Mpg123Player.this.postEvent(new int[] { 100 });
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/services/player/impl/Mpg123Player.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */