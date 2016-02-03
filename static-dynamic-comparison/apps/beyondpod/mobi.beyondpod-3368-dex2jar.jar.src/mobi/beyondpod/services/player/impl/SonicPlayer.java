package mobi.beyondpod.services.player.impl;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.Process;
import java.io.IOException;
import java.nio.ByteBuffer;
import mobi.beyondpod.rsscore.Configuration;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import org.vinuxproject.sonic.AndroidAudioDevice;
import org.vinuxproject.sonic.Sonic;

@TargetApi(16)
public class SonicPlayer
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
  private static final String TAG = "SonicPlayer";
  private static final long TIMEOUT_US = 1L;
  String _DataSource;
  int _SelectedTrack;
  private AndroidAudioDevice mAudioTrack;
  int mChannelCount;
  MediaCodec mCodec;
  long mDuration = -1L;
  private EventHandler mEventHandler;
  MediaExtractor mExtractor;
  long mMustSeekToPosition = -1L;
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
      SonicPlayer.this.playInternal();
    }
  };
  Runnable preparingRunnable = new Runnable()
  {
    public void run()
    {
      try
      {
        SonicPlayer.this.prepare();
        return;
      }
      catch (Exception localException)
      {
        SonicPlayer.this.mState = -1;
        SonicPlayer.this.postEvent(new int[] { 100 });
      }
    }
  };
  Runnable seekingRunnable = new Runnable()
  {
    public void run()
    {
      SonicPlayer.this.mExtractor.seekTo(SonicPlayer.this.mMustSeekToPosition, 2);
      SonicPlayer.this.mMustSeekToPosition = -1L;
      SonicPlayer.this.postEvent(new int[] { 4 });
    }
  };
  
  public SonicPlayer()
  {
    Looper localLooper = Looper.myLooper();
    if (localLooper != null)
    {
      this.mEventHandler = new EventHandler(this, localLooper);
      this.mPlayerWorker = new PlayerWorker(null);
      this.mPlayerWorker.setName("SonicPlayer Worker Thread");
      this.mPlayerWorker.start();
    }
    for (;;)
    {
      if (this.mPlayerWorker._IsReady)
      {
        return;
        localLooper = Looper.getMainLooper();
        if (localLooper != null)
        {
          this.mEventHandler = new EventHandler(this, localLooper);
          break;
        }
        this.mEventHandler = null;
        break;
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
    return (CoreHelper.ApiLevel() > 15) && (Configuration.EnableSonicAudioPlugin()) && (!Configuration.ForceMpg123Player());
  }
  
  private void playInternal()
  {
    if ((this.mExtractor == null) || (this.mAudioTrack == null) || (this.mCodec == null)) {
      throw new IllegalStateException("Data source not prepared!");
    }
    ByteBuffer[] arrayOfByteBuffer3 = this.mCodec.getInputBuffers();
    ByteBuffer[] arrayOfByteBuffer1 = this.mCodec.getOutputBuffers();
    int i = 0;
    try
    {
      if (Thread.interrupted())
      {
        j = i;
        break label695;
        k = playSonicBuffer();
        j = i;
        if (k <= 0) {
          break label705;
        }
        Thread.sleep(100L);
        CoreHelper.WriteTraceEntry("SonicPlayer", "Waiting for Sonic to finish...");
        j = i - 1;
        break label705;
        label95:
        j = this.mAudioTrack.getHeadPosition();
        i = 0;
        break label718;
        label108:
        this.mCodec.flush();
        this.mAudioTrack.flush();
        postEvent(new int[] { 2 });
        this.mState = 7;
      }
      else
      {
        if (this.mMustSeekToPosition >= 0L)
        {
          this.mCodec.flush();
          this.mAudioTrack.flush();
          this.mSonic.flush();
          this.mExtractor.seekTo(this.mMustSeekToPosition, 2);
          this.mMustSeekToPosition = -1L;
          this.mAudioTrack.play();
          postEvent(new int[] { 4 });
        }
        if (!this.mAudioTrack.isPlaying())
        {
          CoreHelper.WriteTraceEntry("SonicPlayer", "Playing runnable found that the audioTrack is not Playing. Stopping the playback loop...");
          j = i;
        }
      }
    }
    catch (Exception localException)
    {
      this.mState = -1;
      postEvent(new int[] { 100 });
      return;
    }
    int m = this.mCodec.dequeueInputBuffer(1L);
    int j = i;
    Object localObject1;
    long l;
    if (m >= 0)
    {
      localObject1 = arrayOfByteBuffer3[m];
      j = this.mExtractor.readSampleData((ByteBuffer)localObject1, 0);
      l = 0L;
      if (j >= 0) {
        break label465;
      }
      i = 1;
      j = 0;
      label296:
      localObject1 = this.mCodec;
      if (i == 0) {
        break label728;
      }
    }
    label465:
    label695:
    label705:
    label718:
    label727:
    label728:
    for (int k = 4;; k = 0)
    {
      ((MediaCodec)localObject1).queueInputBuffer(m, 0, j, l, k);
      j = i;
      if (i == 0)
      {
        this.mExtractor.advance();
        j = i;
        localObject1 = new MediaCodec.BufferInfo();
        k = this.mCodec.dequeueOutputBuffer((MediaCodec.BufferInfo)localObject1, 1L);
        if (k >= 0)
        {
          if ((this.mSonicInBuffer == null) || (this.mSonicInBuffer.length < ((MediaCodec.BufferInfo)localObject1).size)) {
            this.mSonicInBuffer = new byte[((MediaCodec.BufferInfo)localObject1).size * 2];
          }
          Object localObject2 = localException[k];
          ((ByteBuffer)localObject2).get(this.mSonicInBuffer, 0, ((MediaCodec.BufferInfo)localObject1).size);
          ((ByteBuffer)localObject2).clear();
          if (((MediaCodec.BufferInfo)localObject1).size > 0) {
            this.mSonic.putBytes(this.mSonicInBuffer, ((MediaCodec.BufferInfo)localObject1).size);
          }
          playSonicBuffer();
          this.mCodec.releaseOutputBuffer(k, false);
          i = j;
          break;
          l = this.mExtractor.getSampleTime();
          break label296;
        }
        if (k == -3)
        {
          ByteBuffer[] arrayOfByteBuffer2 = this.mCodec.getOutputBuffers();
          i = j;
          break;
        }
        if (k == -2)
        {
          localObject1 = this.mCodec.getOutputFormat();
          this.mSampleRate = ((MediaFormat)localObject1).getInteger("sample-rate");
          this.mChannelCount = ((MediaFormat)localObject1).getInteger("channel-count");
          postEvent(new int[] { 200, this.mSampleRate, this.mChannelCount });
          this.mSonic.setSampleRate(this.mSampleRate);
          this.mSonic.setNumChannels(this.mChannelCount);
          this.mAudioTrack.setRateAndChannels(this.mSampleRate, this.mChannelCount);
          i = j;
          break;
        }
        i = j;
        if (k != -1) {
          break;
        }
        CoreHelper.WriteTraceEntry("SonicPlayer", "Playback timeout... waiting for more data at: " + this.mExtractor.getSampleTime());
        i = j;
        break;
      }
      do
      {
        Thread.sleep(500L);
        k = this.mAudioTrack.getHeadPosition();
        if (j == k) {
          break label108;
        }
        j = k;
        CoreHelper.WriteTraceEntry("SonicPlayer", "Waiting for AudioTrack to finish... " + k);
        i += 1;
        continue;
        if (j == 0) {
          break label727;
        }
        i = 10;
        break;
        if (k <= 0) {
          break label95;
        }
        i = j;
        if (j > 0) {
          break;
        }
        break label95;
      } while (i != 10);
      break label108;
      return;
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
    this.mEventHandler.removeCallbacksAndMessages(null);
    playerPlaybackHandler().removeCallbacksAndMessages(null);
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
    if (this.mCodec != null)
    {
      this.mCodec.stop();
      this.mCodec.release();
      this.mCodec = null;
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
  
  public int getCurrentPosition()
  {
    if (this.mExtractor == null) {
      return -1;
    }
    long l = this.mExtractor.getSampleTime();
    if (l < 0L) {
      return getDuration();
    }
    return (int)(l / 1000L);
  }
  
  public int getDuration()
  {
    if (this.mDuration > 0L) {}
    for (long l = this.mDuration / 1000L;; l = this.mDuration) {
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
    this.mExtractor.setDataSource(this._DataSource);
    int i = 0;
    for (;;)
    {
      if (i >= this.mExtractor.getTrackCount()) {}
      for (;;)
      {
        if (this.mCodec != null) {
          break label231;
        }
        this.mState = -1;
        postEvent(new int[] { 100 });
        return;
        MediaFormat localMediaFormat = this.mExtractor.getTrackFormat(i);
        CoreHelper.WriteTraceEntry("SonicPlayer", "Prepare found track: " + localMediaFormat.toString());
        String str = localMediaFormat.getString("mime");
        if (!str.startsWith("audio/")) {
          break;
        }
        this._SelectedTrack = i;
        this.mExtractor.selectTrack(this._SelectedTrack);
        this.mCodec = MediaCodec.createDecoderByType(str);
        if (this.mCodec != null)
        {
          this.mCodec.configure(localMediaFormat, null, null, 0);
          this.mDuration = localMediaFormat.getLong("durationUs");
          this.mChannelCount = localMediaFormat.getInteger("channel-count");
          this.mSampleRate = localMediaFormat.getInteger("sample-rate");
        }
      }
      i += 1;
    }
    label231:
    this.mSonic = new Sonic(this.mSampleRate, this.mChannelCount);
    this.mAudioTrack = new AndroidAudioDevice(this.mSampleRate, this.mChannelCount);
    this.mCodec.start();
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
    this.mPlayerWorker.release();
    this.mPlayerWorker = null;
    CoreHelper.WriteTraceEntry("SonicPlayer", "SonicPlayer Released!");
  }
  
  public void reset()
  {
    resetInternal();
    this.mState = 0;
    CoreHelper.WriteTraceEntry("SonicPlayer", "SonicPlayer Reset!");
  }
  
  public void seekTo(int paramInt)
    throws IllegalStateException
  {
    if ((this.mState != 5) && (this.mState != 3) && (this.mState != 4) && (this.mState != 7)) {
      throw new IllegalStateException("seekTo() invoked without first calling prepare()");
    }
    this.mMustSeekToPosition = paramInt;
    this.mMustSeekToPosition *= 1000L;
    if (!isPlaying())
    {
      playerPlaybackHandler().removeCallbacks(this.seekingRunnable);
      playerPlaybackHandler().post(this.seekingRunnable);
    }
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
    this._DataSource = paramString;
    if (this.mExtractor != null) {
      reset();
    }
    this.mExtractor = new MediaExtractor();
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
    this.mWakeLock = ((PowerManager)paramContext.getSystemService("power")).newWakeLock(0x20000000 | paramInt, SonicPlayer.class.getName());
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
    private SonicPlayer mMediaPlayer;
    
    public EventHandler(SonicPlayer paramSonicPlayer, Looper paramLooper)
    {
      super();
      this.mMediaPlayer = paramSonicPlayer;
    }
    
    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default: 
        CoreHelper.WriteTraceEntry("SonicPlayer", "Unknown message type " + paramMessage.what);
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
              } while (SonicPlayer.this.mOnPreparedListener == null);
              SonicPlayer.this.mOnPreparedListener.onPrepared(this.mMediaPlayer);
              return;
              if (SonicPlayer.this.mOnCompletionListener != null) {
                SonicPlayer.this.mOnCompletionListener.onCompletion(this.mMediaPlayer);
              }
              SonicPlayer.this.stayAwake(false);
              return;
            } while (SonicPlayer.this.mOnBufferingUpdateListener == null);
            SonicPlayer.this.mOnBufferingUpdateListener.onBufferingUpdate(this.mMediaPlayer, paramMessage.arg1);
            return;
          } while (SonicPlayer.this.mOnSeekCompleteListener == null);
          SonicPlayer.this.mOnSeekCompleteListener.onSeekComplete(this.mMediaPlayer);
          return;
        } while (SonicPlayer.this.mOnVideoSizeChangedListener == null);
        SonicPlayer.this.mOnVideoSizeChangedListener.onVideoSizeChanged(this.mMediaPlayer, paramMessage.arg1, paramMessage.arg2);
        return;
        CoreHelper.WriteTraceErrorInDebug("SonicPlayer", "Error (" + paramMessage.arg1 + "," + paramMessage.arg2 + ")");
        boolean bool = false;
        if (SonicPlayer.this.mOnErrorListener != null) {
          bool = SonicPlayer.this.mOnErrorListener.onError(this.mMediaPlayer, paramMessage.arg1, paramMessage.arg2);
        }
        if ((SonicPlayer.this.mOnCompletionListener != null) && (!bool)) {
          SonicPlayer.this.mOnCompletionListener.onCompletion(this.mMediaPlayer);
        }
        SonicPlayer.this.stayAwake(false);
        return;
        if (paramMessage.arg1 != 700) {
          CoreHelper.WriteTraceEntry("SonicPlayer", "Info (" + paramMessage.arg1 + "," + paramMessage.arg2 + ")");
        }
      } while (SonicPlayer.this.mOnInfoListener == null);
      SonicPlayer.this.mOnInfoListener.onInfo(this.mMediaPlayer, paramMessage.arg1, paramMessage.arg2);
    }
  }
  
  public static abstract interface OnBufferingUpdateListener
  {
    public abstract void onBufferingUpdate(SonicPlayer paramSonicPlayer, int paramInt);
  }
  
  public static abstract interface OnCompletionListener
  {
    public abstract void onCompletion(SonicPlayer paramSonicPlayer);
  }
  
  public static abstract interface OnErrorListener
  {
    public abstract boolean onError(SonicPlayer paramSonicPlayer, int paramInt1, int paramInt2);
  }
  
  public static abstract interface OnInfoListener
  {
    public abstract boolean onInfo(SonicPlayer paramSonicPlayer, int paramInt1, int paramInt2);
  }
  
  public static abstract interface OnPreparedListener
  {
    public abstract void onPrepared(SonicPlayer paramSonicPlayer);
  }
  
  public static abstract interface OnSeekCompleteListener
  {
    public abstract void onSeekComplete(SonicPlayer paramSonicPlayer);
  }
  
  public static abstract interface OnVideoSizeChangedListener
  {
    public abstract void onVideoSizeChanged(SonicPlayer paramSonicPlayer, int paramInt1, int paramInt2);
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
      CoreHelper.WriteTraceEntry("SonicPlayer", "SonicPlayer woker thread finalized!");
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
      CoreHelper.WriteTraceEntry("SonicPlayer", "SonicPlayer woker thread released!");
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
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/services/player/impl/SonicPlayer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */