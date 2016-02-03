package mobi.beyondpod.services.player;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.RemoteException;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import java.io.IOException;
import mobi.beyondpod.BeyondPodApplication;
import mobi.beyondpod.rsscore.Configuration;
import mobi.beyondpod.rsscore.Feed;
import mobi.beyondpod.rsscore.Track;
import mobi.beyondpod.rsscore.helpers.AnalyticsTracker;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.helpers.NotificationHelper;
import mobi.beyondpod.rsscore.helpers.StringUtils;
import mobi.beyondpod.rsscore.helpers.TimeSpan;
import mobi.beyondpod.rsscore.repository.FeedRepository;
import mobi.beyondpod.rsscore.rss.ItemStateHistory;
import mobi.beyondpod.schedulercore.ScheduledTasksManager;
import mobi.beyondpod.services.player.impl.ChromecastDevice;
import mobi.beyondpod.services.player.impl.IMediaPlayerImpl;
import mobi.beyondpod.services.player.impl.IMediaPlayerImpl.OnBufferingUpdateListener;
import mobi.beyondpod.services.player.impl.IMediaPlayerImpl.OnCompletionListener;
import mobi.beyondpod.services.player.impl.IMediaPlayerImpl.OnErrorListener;
import mobi.beyondpod.services.player.impl.IMediaPlayerImpl.OnInfoListener;
import mobi.beyondpod.services.player.impl.IMediaPlayerImpl.OnPreparedListener;
import mobi.beyondpod.services.player.impl.IMediaPlayerImpl.OnSeekCompleteListener;
import mobi.beyondpod.services.player.impl.IMediaPlayerImpl.TrackMetadata;
import mobi.beyondpod.services.player.impl.MediaPlayerFactory;
import mobi.beyondpod.services.player.impl.MediaPlayerTrackBacked;
import mobi.beyondpod.ui.commands.CommandManagerBase;

public class MediaPlaybackService
  extends Service
{
  public static final String CMDNAME = "command";
  public static final String CMDOPEN_AND_PLAY = "open";
  public static final String CMDOPTION = "commandOption";
  public static final String CMDOPTIONPLAY = "play";
  public static final String CMDPAUSE = "pause";
  public static final String CMDRESUME = "resume";
  public static final String CMDSTOP = "stop";
  public static final String CMDTOGGLEPAUSE = "togglepause";
  public static final String CMD_LOAD_CURRENT_TRACK = "loadcurrenttrack";
  public static final String CMD_PLAY_NEXT = "playnext";
  public static final String CMD_PLAY_PREVIOUS = "playprevious";
  public static final String CMD_SEEK_TO_LOCATION = "seekToLocation";
  public static final String CMD_SET_PLAYBACK_SPEED_1 = "setPlaybackSpeedSpeed1";
  public static final String CMD_SET_PLAYBACK_SPEED_2 = "setPlaybackSpeedSpeed2";
  public static final String CMD_SET_PLAYBACK_SPEED_NORMAL = "setPlaybackSpeedNormal";
  public static final String CMD_SKIP_BACKWARD = "skipbackword";
  public static final String CMD_SKIP_FORWARD = "skipforward";
  public static final String CMD_SKIP_TO_END = "skiptoend";
  public static final String CMD_START_PLAYBACK_ON_LOAD = "startPlaybackOnLoad";
  public static final String CMD_STOP_SERVICE = "stopService";
  private static final int FADEIN = 6;
  private static int FADE_IN_TICK = 100;
  private static final int IDLE_DELAY = 60000;
  public static final int PLAYBACKSERVICE_STATUS = 1;
  private static final int PLAYBACK_ERROR_OCCURED = 7;
  private static final int PLAY_POSITION_CHANGED = 4;
  private static final int RELEASE_WAKELOCK = 2;
  private static final int SERVER_DIED = 3;
  public static final String SERVICECMD = "mobi.beyondpod.services.musicservicecommand";
  public static final int SERVICE_STATUS = 1;
  public static final String SERVICE_WIDGET_CMD_NEXT_TRACK = "mobi.beyondpod.services.musicservicewidgetcommand.nexttrack";
  public static final String SERVICE_WIDGET_CMD_PLAY_PAUSE = "mobi.beyondpod.services.musicservicewidgetcommand.playpause";
  public static final String SERVICE_WIDGET_CMD_SKIP_BACK = "mobi.beyondpod.services.musicservicewidgetcommand.skipback";
  public static final String SERVICE_WIDGET_CMD_SKIP_FORWARD = "mobi.beyondpod.services.musicservicewidgetcommand.skipforward";
  public static final String SERVICE_WIDGET_CMD_SKIP_TO_END = "mobi.beyondpod.services.musicservicewidgetcommand.skiptoend";
  public static final String SERVICE_WIDGET_CMD_START_SMARTPLAY = "mobi.beyondpod.services.musicservicewidgetcommand.startsmartplay";
  public static final String SERVICE_WIDGET_CMD_STOP = "mobi.beyondpod.services.musicservicewidgetcommand.stop";
  private static final int SLEEP_TIMEOUT_TICK = 5;
  public static boolean ServiceIsRunning = false;
  private static String TAG = MediaPlaybackService.class.getSimpleName();
  public static final String TRACKPOS = "trackPos";
  private static final int TRACK_ENDED = 1;
  private static int _LastBufferPercent = -1;
  private BroadcastReceiver _BatteryStateReceiver = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      boolean bool2 = true;
      paramAnonymousContext = paramAnonymousIntent.getAction();
      if (paramAnonymousContext.equals("android.intent.action.BATTERY_CHANGED")) {
        if (MediaPlaybackService.this._Player != null)
        {
          i = paramAnonymousIntent.getIntExtra("plugged", -1);
          paramAnonymousContext = MediaPlaybackService.this._Player;
          bool1 = bool2;
          if (i != 1)
          {
            bool1 = bool2;
            if (i != 2) {
              bool1 = false;
            }
          }
          MediaPlaybackService.MultiPlayer.access$0(paramAnonymousContext, bool1);
        }
      }
      while ((!paramAnonymousContext.equals("android.intent.action.ACTION_POWER_DISCONNECTED")) || (!Configuration.PauseOnPowerDisconnect()) || (MediaPlaybackService.this._Player == null) || (!MediaPlaybackService.this._Player.isPlaying()))
      {
        int i;
        boolean bool1;
        return;
      }
      CoreHelper.WriteTraceEntry(MediaPlaybackService.TAG, "Detected power disconnect! Pausing...");
      MediaPlaybackService.this.pause();
    }
  };
  IMediaPlayerImpl.OnBufferingUpdateListener _BufferingUpdateListener = new IMediaPlayerImpl.OnBufferingUpdateListener()
  {
    public void onBufferingUpdate(IMediaPlayerImpl paramAnonymousIMediaPlayerImpl, int paramAnonymousInt)
    {
      if (paramAnonymousInt != MediaPlaybackService._LastBufferPercent)
      {
        CoreHelper.WriteTraceEntry(MediaPlaybackService.TAG, "-----> Buffering: " + paramAnonymousInt + "%");
        MediaPlaybackService._LastBufferPercent = paramAnonymousInt;
      }
      paramAnonymousIMediaPlayerImpl = MediaPlaybackService.this.CurrentPlayingTrack();
      if (paramAnonymousIMediaPlayerImpl != null) {
        paramAnonymousIMediaPlayerImpl.setBufferedPercent(paramAnonymousInt);
      }
    }
  };
  private Handler _DelayedStopHandler = new Handler()
  {
    @SuppressLint({"HandlerLeak"})
    public void handleMessage(Message paramAnonymousMessage)
    {
      if ((MediaPlaybackService.this.isPlaying()) || (MediaPlaybackService.this._IsPreparing) || (MediaPlaybackService.this._ResumeAfterCall) || (MediaPlaybackService.this._ServiceInUse) || (MediaPlaybackService.this._MediaplayerHandler.hasMessages(1)))
      {
        if (MediaPlaybackService.this._IsPreparing) {
          CoreHelper.WriteLogEntryInDebug(MediaPlaybackService.TAG, "Player service autoshutdown found that track is still preparing. Ignoring shutdown...");
        }
        return;
      }
      MediaPlaybackService.this.stopSelf(MediaPlaybackService.this._ServiceStartId);
    }
  };
  long _IdleStateStartTime;
  IMediaPlayerImpl.OnInfoListener _InfoListener = new IMediaPlayerImpl.OnInfoListener()
  {
    public boolean onInfo(IMediaPlayerImpl paramAnonymousIMediaPlayerImpl, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      switch (paramAnonymousInt1)
      {
      default: 
        CoreHelper.WriteTraceEntry(MediaPlaybackService.TAG, "******** Info Received! What:" + paramAnonymousInt1 + " Extra:" + paramAnonymousInt2);
      }
      for (;;)
      {
        return false;
        CoreHelper.WriteTraceEntry(MediaPlaybackService.TAG, "******** Info Received! MEDIA_INFO_BAD_INTERLEAVING, Extra:" + paramAnonymousInt2);
        continue;
        CoreHelper.WriteTraceEntry(MediaPlaybackService.TAG, "******** Info Received! MEDIA_INFO_METADATA_UPDATE, Extra:" + paramAnonymousInt2);
        continue;
        CoreHelper.WriteTraceEntry(MediaPlaybackService.TAG, "******** Info Received! MEDIA_INFO_NOT_SEEKABLE, Extra:" + paramAnonymousInt2);
        continue;
        CoreHelper.WriteTraceEntry(MediaPlaybackService.TAG, "******** Info Received! MEDIA_INFO_UNKNOWN, Extra:" + paramAnonymousInt2);
        continue;
        CoreHelper.WriteTraceEntry(MediaPlaybackService.TAG, "******** Info Received! MediaPlayer.MEDIA_INFO_VIDEO_TRACK_LAGGING, Extra:" + paramAnonymousInt2);
      }
    }
  };
  private BroadcastReceiver _IntentReceiver = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      paramAnonymousContext = paramAnonymousIntent.getStringExtra("command");
      String str = paramAnonymousIntent.getStringExtra("commandOption");
      CoreHelper.WriteTraceEntry(MediaPlaybackService.TAG, "*** PlaybackSertvice received Command: " + paramAnonymousContext + ", Option: " + str);
      int i;
      if ("open".equals(paramAnonymousContext))
      {
        i = paramAnonymousIntent.getIntExtra("trackPos", -1);
        if (i >= 0) {
          MediaPlaybackService.this.openAndPlay(i);
        }
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
                do
                {
                  do
                  {
                    do
                    {
                      return;
                      if ("resume".equals(paramAnonymousContext))
                      {
                        MediaPlaybackService.this.startAndFadeIn();
                        return;
                      }
                      if ("togglepause".equals(paramAnonymousContext))
                      {
                        if (MediaPlaybackService.this.isPlaying())
                        {
                          MediaPlaybackService.this.pause();
                          return;
                        }
                        MediaPlaybackService.this.startAndFadeIn();
                        return;
                      }
                      if ("pause".equals(paramAnonymousContext))
                      {
                        MediaPlaybackService.this.pause();
                        return;
                      }
                      if ("stop".equals(paramAnonymousContext))
                      {
                        MediaPlaybackService.this.stop();
                        return;
                      }
                      if (!"skiptoend".equals(paramAnonymousContext)) {
                        break;
                      }
                    } while (!MediaPlaybackService.this.IsMultiPlayerInitialized());
                    if (MediaPlaybackService.this._Player.isPlaying()) {
                      MediaPlaybackService.this.pause();
                    }
                    MediaPlaybackService.this._MediaplayerHandler.sendEmptyMessage(1);
                    return;
                    if (!"skipforward".equals(paramAnonymousContext)) {
                      break;
                    }
                  } while (!MediaPlaybackService.this.IsMultiPlayerInitialized());
                  l2 = MediaPlaybackService.this._Player.position() + Configuration.getForwardSkipInterval() * 1000;
                  long l3 = MediaPlaybackService.this._Player.duration();
                  l1 = l2;
                  if (l2 >= l3) {
                    l1 = l3 - 1000L;
                  }
                  MediaPlaybackService.this._Player.seek(l1);
                } while (str == null);
                MediaPlaybackService.this.startAndFadeIn();
                return;
                if (!"skipbackword".equals(paramAnonymousContext)) {
                  break;
                }
              } while (!MediaPlaybackService.this.IsMultiPlayerInitialized());
              l2 = MediaPlaybackService.this._Player.position() - Configuration.getBackwardSkipInterval() * 1000;
              l1 = l2;
              if (l2 < 0L) {
                l1 = 0L;
              }
              MediaPlaybackService.this._Player.seek(l1);
            } while (str == null);
            MediaPlaybackService.this.startAndFadeIn();
            return;
            if (!"seekToLocation".equals(paramAnonymousContext)) {
              break;
            }
          } while (!MediaPlaybackService.this.IsMultiPlayerInitialized());
          long l2 = paramAnonymousIntent.getLongExtra("seekToLocation", 0L);
          long l1 = l2;
          if (l2 < 0L) {
            l1 = 0L;
          }
          MediaPlaybackService.this._Player.seek(l1);
        } while (str == null);
        MediaPlaybackService.this.startAndFadeIn();
        return;
        if ("playnext".equals(paramAnonymousContext))
        {
          if ((MediaPlaybackService.this.PlayList().GetCurrentPlayingTrackPosition() == MediaPlaybackService.this.PlayList().PlaylistSize() - 1) && (Configuration.PlaylistEndAction() == 2))
          {
            MediaPlaybackService.this.PlayList().ExecuteActionPlayNextPosition(Configuration.PlaylistEndAction());
            return;
          }
          int j = MediaPlaybackService.this.PlayList().GetNextTrackPosition();
          i = j;
          if (j < 0) {
            i = 0;
          }
          MediaPlaybackService.this.openAndPlay(i);
          return;
        }
        if ("playprevious".equals(paramAnonymousContext))
        {
          MediaPlaybackService.this.openAndPlay(MediaPlaybackService.this.PlayList().GetPreviousTrackPosition());
          return;
        }
        if ("loadcurrenttrack".equals(paramAnonymousContext))
        {
          boolean bool = paramAnonymousIntent.getBooleanExtra("startPlaybackOnLoad", false);
          MediaPlaybackService.this.LoadCurrentTrack(bool);
          return;
        }
        if ("stopService".equals(paramAnonymousContext))
        {
          MediaPlaybackService.this._DelayedStopHandler.sendEmptyMessage(60000);
          return;
        }
        if ("setPlaybackSpeedNormal".equals(paramAnonymousContext))
        {
          MediaPlaybackService.this.setPlaybackSpeed(Configuration.PlaybackSpeedNormal(), -1.0F);
          return;
        }
        if ("setPlaybackSpeedSpeed1".equals(paramAnonymousContext))
        {
          MediaPlaybackService.this.setPlaybackSpeed(Configuration.PlaybackSpeed1(), -1.0F);
          return;
        }
      } while (!"setPlaybackSpeedSpeed2".equals(paramAnonymousContext));
      MediaPlaybackService.this.setPlaybackSpeed(Configuration.PlaybackSpeed2(), -1.0F);
    }
  };
  private boolean _IsPreparing = false;
  private boolean _IsSeeking = false;
  long _LoadDataStartTime;
  private Handler _MediaplayerHandler = new Handler()
  {
    float _CurrentVolume = 1.0F;
    
    @SuppressLint({"HandlerLeak"})
    public void handleMessage(Message paramAnonymousMessage)
    {
      boolean bool = false;
      switch (paramAnonymousMessage.what)
      {
      default: 
      case 6: 
      case 3: 
      case 1: 
      case 2: 
      case 4: 
        do
        {
          do
          {
            do
            {
              return;
              if (MediaPlaybackService.this.isPlaying()) {
                break;
              }
              this._CurrentVolume = 0.0F;
              MediaPlaybackService.this._Player.setVolume(this._CurrentVolume);
            } while ((!MediaPlaybackService.this.play()) || (!MediaPlaybackService.this._Player.isInitialized()));
            MediaPlaybackService.this._MediaplayerHandler.sendEmptyMessageDelayed(6, MediaPlaybackService.FADE_IN_TICK);
            return;
            this._CurrentVolume += 0.1F;
            if (this._CurrentVolume < 1.0F) {
              MediaPlaybackService.this._MediaplayerHandler.sendEmptyMessageDelayed(6, MediaPlaybackService.FADE_IN_TICK);
            }
            for (;;)
            {
              MediaPlaybackService.this._Player.setVolume(this._CurrentVolume);
              return;
              this._CurrentVolume = 1.0F;
            }
            CoreHelper.WriteTraceEntry(MediaPlaybackService.TAG, "******** Media Player has died! Preparing Playback Again...");
          } while (MediaPlaybackService.this.PlayList().CurrentTrack() == null);
          MediaPlaybackService.this.PreparePlaybackSource(MediaPlaybackService.access$4(MediaPlaybackService.this).CurrentTrack());
          return;
          paramAnonymousMessage = MediaPlaybackService.this.CurrentPlayingTrack();
          if (paramAnonymousMessage != null)
          {
            if (paramAnonymousMessage.getTotalTime() > paramAnonymousMessage.getPlayedTime()) {
              CoreHelper.WriteTraceEntry(MediaPlaybackService.TAG, "Episode '" + paramAnonymousMessage.DisplayName() + "' has incorrect duration. Reported: " + paramAnonymousMessage.TotalTimeAsString() + ", Actual: " + paramAnonymousMessage.PlayedTimeAsString());
            }
            paramAnonymousMessage.MarkPlayed();
            paramAnonymousMessage.setCurrentPlayState(2);
            MediaPlaybackService.this._MetadataPublisher.PublishTrackInformation(paramAnonymousMessage, false);
          }
          if (MediaPlaybackService.this._TimeToSleep == Integer.MIN_VALUE)
          {
            MediaPlaybackService.this._TimeToSleep = 0;
            if (paramAnonymousMessage != null) {
              ItemStateHistory.MarkTracksItemAsRead(paramAnonymousMessage);
            }
          }
          for (;;)
          {
            if (paramAnonymousMessage != null) {
              FeedRepository.SaveRepositoryAsync();
            }
            MediaPlaybackService.this.gotoIdleState(true);
            return;
            localObject = MediaPlaybackService.this.PlayList();
            if (MediaPlaybackService.this._TimeToSleep > 0) {
              bool = true;
            }
            ((PlayList)localObject).OnTrackPlaybackComplete(bool);
          }
          MediaPlaybackService.this._WakeLock.release();
          return;
          Object localObject = MediaPlaybackService.this.CurrentPlayingTrack();
          if (localObject != null)
          {
            if (MediaPlaybackService.this.VerifyCurrentTrack(MediaPlaybackService.this._Player, (Track)localObject, 1))
            {
              long l = MediaPlaybackService.this._Player.position() / 1000L;
              if (((Track)localObject).getPlayedTime() != l) {
                ((Track)localObject).setPlayedTime(l);
              }
            }
            if (!PlayList.AllowStreaming((Track)localObject))
            {
              CoreHelper.WriteTraceEntry(MediaPlaybackService.TAG, "  Playback monitor found a streaming track when streaming is not allowed! Stopping playback...");
              MediaPlaybackService.this.stop(true);
              return;
            }
          }
        } while (paramAnonymousMessage.arg1 != 0);
        MediaPlaybackService.MultiPlayer.access$1(MediaPlaybackService.this._Player, 5000L);
        return;
      case 5: 
        paramAnonymousMessage = MediaPlaybackService.this;
        paramAnonymousMessage._TimeToSleep -= 1;
        if (MediaPlaybackService.this._TimeToSleep > 0)
        {
          MediaPlaybackService.this.scheduleSleepTick();
          return;
        }
        MediaPlaybackService.this.pause();
        return;
      }
      paramAnonymousMessage = MediaPlaybackService.this.CurrentPlayingTrack();
      if (paramAnonymousMessage != null)
      {
        paramAnonymousMessage.setCurrentPlayState(7);
        MediaPlaybackService.this._MetadataPublisher.PublishTrackInformation(paramAnonymousMessage, false);
      }
      MediaPlaybackService.this._StartPlaybackAfterSeek = false;
      MediaPlaybackService.this._StartPlaybackAfterPrepare = false;
      MediaPlaybackService.this.gotoIdleState(true);
    }
  };
  private TrackMetadataPublisher _MetadataPublisher;
  private PhoneStateListener _PhoneStateListener = new PhoneStateListener()
  {
    private boolean IsEnabled()
    {
      return (CoreHelper.ApiLevel() <= 7) || (!Configuration.PauseOnNotification());
    }
    
    public void onCallStateChanged(int paramAnonymousInt, String paramAnonymousString)
    {
      boolean bool2 = true;
      boolean bool1 = true;
      if (paramAnonymousInt == 1) {
        if (((AudioManager)MediaPlaybackService.this.getSystemService("audio")).getStreamVolume(2) > 0)
        {
          CoreHelper.WriteTraceEntry(MediaPlaybackService.TAG, "Phone is in state CALL_STATE_RINGING! Is currently Playing:" + MediaPlaybackService.this.isPlaying());
          paramAnonymousString = MediaPlaybackService.this;
          if (((!MediaPlaybackService.this.isPlaying()) && (!MediaPlaybackService.this._ResumeAfterCall)) || (MediaPlaybackService.this.PlayList().CurrentTrack() == null)) {
            break label126;
          }
          paramAnonymousString._ResumeAfterCall = bool1;
          if (IsEnabled())
          {
            CoreHelper.WriteTraceEntry(MediaPlaybackService.TAG, "Pausing playback...");
            MediaPlaybackService.this.pause();
          }
          MediaButtonIntentReceiver.StopListeningForMediaButton();
        }
      }
      label126:
      do
      {
        do
        {
          return;
          bool1 = false;
          break;
          if (paramAnonymousInt == 2)
          {
            paramAnonymousString = MediaPlaybackService.this;
            if (((MediaPlaybackService.this.isPlaying()) || (MediaPlaybackService.this._ResumeAfterCall)) && (MediaPlaybackService.this.PlayList().CurrentTrack() != null)) {}
            for (bool1 = bool2;; bool1 = false)
            {
              paramAnonymousString._ResumeAfterCall = bool1;
              CoreHelper.WriteTraceEntry(MediaPlaybackService.TAG, "Phone is in state CALL_STATE_OFFHOOK! Is currently Playing:" + MediaPlaybackService.this.isPlaying());
              if (IsEnabled())
              {
                CoreHelper.WriteTraceEntry(MediaPlaybackService.TAG, "Pausing playback...");
                MediaPlaybackService.this.pause();
              }
              MediaButtonIntentReceiver.StopListeningForMediaButton();
              return;
            }
          }
        } while (paramAnonymousInt != 0);
        CoreHelper.WriteTraceEntry(MediaPlaybackService.TAG, "Phone is in state CALL_STATE_IDLE! Was playing when phone rang:" + MediaPlaybackService.this._ResumeAfterCall + ", Allow Resume: " + Configuration.AllowResumeAfterCall());
        if ((MediaPlaybackService.this._ResumeAfterCall) && (Configuration.AllowResumeAfterCall()) && (IsEnabled()))
        {
          CoreHelper.WriteTraceEntry(MediaPlaybackService.TAG, "Resuming playback after phone call...");
          MediaPlaybackService.this._MediaplayerHandler.postDelayed(new Runnable()
          {
            public void run()
            {
              MediaPlaybackService.this.startAndFadeIn();
            }
          }, 1000L);
        }
        MediaPlaybackService.this._ResumeAfterCall = false;
      } while (MediaPlaybackService.this.PlayList().PlaylistSize() <= 0);
      MediaButtonIntentReceiver.StartListeningForMediaButton();
    }
  };
  private MultiPlayer _Player;
  private boolean _ResumeAfterCall = false;
  private BroadcastReceiver _ScreenWakeUpReceiver = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      if ((Configuration.PreventKeyguard()) && (MediaPlaybackService.this._Player != null) && (MediaPlaybackService.this._Player.isPlaying()))
      {
        CoreHelper.WriteTraceEntry(MediaPlaybackService.TAG, "Screen is now on and we have to open the player UI above the Keyguard");
        paramAnonymousIntent = new Intent(paramAnonymousContext, BeyondPodApplication.GetInstance().MasterViewClass());
        paramAnonymousIntent.setFlags(536870912);
        paramAnonymousIntent.addFlags(268435456);
        paramAnonymousIntent.addFlags(131072);
        paramAnonymousIntent.setData(Uri.parse("mobi.beyondpod.services.player.LockScreenWakeUp"));
        paramAnonymousContext.startActivity(paramAnonymousIntent);
      }
    }
  };
  IMediaPlayerImpl.OnSeekCompleteListener _SeekCompleteListener = new IMediaPlayerImpl.OnSeekCompleteListener()
  {
    public void onSeekComplete(IMediaPlayerImpl paramAnonymousIMediaPlayerImpl)
    {
      CoreHelper.WriteTraceEntry(MediaPlaybackService.TAG, "  Seek Complete!");
      MediaPlaybackService.this._IsSeeking = false;
      paramAnonymousIMediaPlayerImpl = MediaPlaybackService.this.CurrentPlayingTrack();
      if (paramAnonymousIMediaPlayerImpl == null) {
        return;
      }
      CoreHelper.WriteTraceEntry(MediaPlaybackService.TAG, "  Currently at position: " + MediaPlaybackService.this._Player.position() + " (supposed to be at: " + paramAnonymousIMediaPlayerImpl.getPlayedTime() * 1000L + ")");
      if (MediaPlaybackService.this._StartPlaybackAfterSeek)
      {
        MediaPlaybackService.this._StartPlaybackAfterSeek = false;
        CoreHelper.WriteTraceEntry(MediaPlaybackService.TAG, "  Starting Playback after seek...");
        MediaPlaybackService.this.startAndFadeIn();
      }
      for (;;)
      {
        if ((!MediaPlaybackService.this.isPlaying()) && (!MediaPlaybackService.this._StartPlaybackAfterSeek) && (!MediaPlaybackService.this._IsPreparing)) {
          MediaPlaybackService.this.gotoIdleState(false);
        }
        Object localObject;
        if ((!MediaPlaybackService.this.isPlaying()) && (!MediaPlaybackService.this._IsPreparing) && (MediaPlaybackService.this.position() >= 0L))
        {
          localObject = MediaPlaybackService.MultiPlayer.access$2(MediaPlaybackService.this._Player).obtainMessage(4);
          ((Message)localObject).arg1 = 10;
          MediaPlaybackService.MultiPlayer.access$2(MediaPlaybackService.this._Player).removeMessages(4);
          MediaPlaybackService.MultiPlayer.access$2(MediaPlaybackService.this._Player).sendMessageDelayed((Message)localObject, 500L);
        }
        MediaPlaybackService.this._MetadataPublisher.PublishTrackInformation(paramAnonymousIMediaPlayerImpl, MediaPlaybackService.this._Player.position(), false);
        return;
        if ((paramAnonymousIMediaPlayerImpl.getBufferedPercent() < 100) && (!Configuration.AllowSeekingOfInternetStreams()))
        {
          long l1 = 0L;
          if (paramAnonymousIMediaPlayerImpl.getBufferedPercent() > 0) {
            l1 = ((float)MediaPlaybackService.this.duration() * (paramAnonymousIMediaPlayerImpl.getBufferedPercent() / 100.0F));
          }
          if (MediaPlaybackService.this.position() > l1)
          {
            CoreHelper.WriteTraceEntry(MediaPlaybackService.TAG, "  Seeked past the buffer! Current Position:" + MediaPlaybackService.this.position() + ", Max Seek Position: " + l1);
            localObject = MediaPlaybackService.this._Player;
            long l2 = l1;
            if (l1 > 1000L) {
              l2 = l1 - 1000L;
            }
            ((MediaPlaybackService.MultiPlayer)localObject).seek(l2);
          }
        }
      }
    }
  };
  private boolean _ServiceInUse = false;
  private int _ServiceStartId = -1;
  private boolean _StartPlaybackAfterPrepare = false;
  protected boolean _StartPlaybackAfterSeek;
  private int _TimeToSleep;
  private PowerManager.WakeLock _WakeLock;
  IMediaPlayerImpl.OnPreparedListener _preparedlistener = new IMediaPlayerImpl.OnPreparedListener()
  {
    public void onPrepared(IMediaPlayerImpl paramAnonymousIMediaPlayerImpl)
    {
      MediaPlaybackService.this._IsPreparing = false;
      paramAnonymousIMediaPlayerImpl = MediaPlaybackService.this.CurrentPlayingTrack();
      long l;
      if (paramAnonymousIMediaPlayerImpl != null)
      {
        paramAnonymousIMediaPlayerImpl.setCurrentPlayState(4);
        MediaPlaybackService.this._MetadataPublisher.PublishTrackInformation(paramAnonymousIMediaPlayerImpl, false);
        BeyondPodApplication.GetInstance().SetPlayerNotification(MediaPlaybackService.this, paramAnonymousIMediaPlayerImpl);
        MediaPlaybackService.this._Player.InitializeOnCompletionListener();
        if (!MediaPlaybackService.this.IsMultiPlayerInitialized()) {
          break label167;
        }
        l = paramAnonymousIMediaPlayerImpl.getPlayedTime() * 1000L;
        CoreHelper.WriteTraceEntry(MediaPlaybackService.TAG, "  Playback prepared! Must seek to:" + l + ", Start Playback:" + MediaPlaybackService.this._StartPlaybackAfterPrepare);
        if (l <= 0L) {
          MediaPlaybackService.this.StartPlaybackIfNeeded();
        }
      }
      else
      {
        return;
      }
      if (paramAnonymousIMediaPlayerImpl.Exists())
      {
        MediaPlaybackService.this.SeekAtStart(l);
        return;
      }
      if (!Configuration.AllowSeekingOfInternetStreams())
      {
        MediaPlaybackService.this.StartPlaybackIfNeeded();
        return;
      }
      MediaPlaybackService.this.SeekAtStart(l);
      return;
      label167:
      MediaPlaybackService.this.stop(true);
    }
  };
  private final IMediaPlaybackService.Stub mBinder = new IMediaPlaybackService.Stub()
  {
    public boolean canChangePlaybackSpeed()
      throws RemoteException
    {
      return MediaPlaybackService.this.canChangePlaybackSpeed();
    }
    
    public long duration()
    {
      return MediaPlaybackService.this.duration();
    }
    
    public float getCurrentPlaybackSpeed()
      throws RemoteException
    {
      return MediaPlaybackService.this.getCurrentPlaybackSpeed();
    }
    
    public int gettimetosleep()
      throws RemoteException
    {
      return MediaPlaybackService.this.gettimetosleep();
    }
    
    public void gotosleepin(int paramAnonymousInt)
      throws RemoteException
    {
      MediaPlaybackService.this.gotosleepin(paramAnonymousInt);
    }
    
    public boolean isPlaying()
    {
      return MediaPlaybackService.this.isPlaying();
    }
    
    public void open(int paramAnonymousInt)
    {
      MediaPlaybackService.this.openAndPlay(paramAnonymousInt);
    }
    
    public void pause()
    {
      MediaPlaybackService.this.pause();
    }
    
    public void play()
    {
      MediaPlaybackService.this.play();
    }
    
    public int playerType()
      throws RemoteException
    {
      return MediaPlaybackService.this.playerType();
    }
    
    public long position()
    {
      return MediaPlaybackService.this.position();
    }
    
    public long seek(long paramAnonymousLong)
    {
      return MediaPlaybackService.this.seek(paramAnonymousLong);
    }
    
    public void setPlaybackSpeed(float paramAnonymousFloat1, float paramAnonymousFloat2)
      throws RemoteException
    {
      MediaPlaybackService.this.setPlaybackSpeed(paramAnonymousFloat1, paramAnonymousFloat2);
    }
    
    public void startAndFadeIn()
      throws RemoteException
    {
      MediaPlaybackService.this.startAndFadeIn();
    }
    
    public void stop()
    {
      MediaPlaybackService.this.stop();
    }
    
    public boolean supportsSpeedAlteration()
      throws RemoteException
    {
      return MediaPlaybackService.this.supportsSpeedAlteration();
    }
  };
  
  private Track CurrentPlayingTrack()
  {
    return PlayList().CurrentTrack();
  }
  
  private void DoFunkyHTCIncredibleHack()
  {
    if (this._Player.supportsSpeedAlteration()) {
      return;
    }
    this._Player.setVolume(0.0F);
    this._Player.start();
    try
    {
      Thread.sleep(10L);
      this._Player.pause();
      this._Player.setVolume(1.0F);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;) {}
    }
  }
  
  private float GetDefaultSpeedForTrack(Track paramTrack)
  {
    float f = paramTrack.PrefrredPlaybackSpeed();
    if (f > 0.0F) {
      return f;
    }
    return Configuration.DefaultPlaybackSpeed();
  }
  
  private boolean HandleCommandInternal(Intent paramIntent)
  {
    if (FeedRepository.RepositoryLoadState() == 2)
    {
      String str;
      if (paramIntent != null)
      {
        str = paramIntent.getAction();
        if (!"mobi.beyondpod.services.musicservicecommand".equals(str)) {
          break label36;
        }
        this._IntentReceiver.onReceive(this, paramIntent);
      }
      for (;;)
      {
        return true;
        label36:
        if (("mobi.beyondpod.services.musicservicewidgetcommand.playpause".equals(str)) || ("mobi.beyondpod.services.musicservicewidgetcommand.skiptoend".equals(str)) || ("mobi.beyondpod.services.musicservicewidgetcommand.startsmartplay".equals(str)) || ("mobi.beyondpod.services.musicservicewidgetcommand.skipback".equals(str)) || ("mobi.beyondpod.services.musicservicewidgetcommand.skipforward".equals(str)) || ("mobi.beyondpod.services.musicservicewidgetcommand.nexttrack".equals(str)) || ("mobi.beyondpod.services.musicservicewidgetcommand.stop".equals(str))) {
          HandleWidgetCommandInternal(paramIntent);
        }
      }
    }
    return false;
  }
  
  private void HandleWidgetCommandInternal(Intent paramIntent)
  {
    AnalyticsTracker.OnWidgetCommand(paramIntent.getAction());
    if ((PlayList().PlaylistSize() == 0) || (paramIntent.getAction().equals("mobi.beyondpod.services.musicservicewidgetcommand.startsmartplay"))) {
      if (SmartPlaylistTemplate.IsConfigured())
      {
        CoreHelper.WriteTraceEntry(TAG, "Widget command received. Playlist is empty or forced smartPlay. Starting SmartPlay...");
        CommandManagerBase.CmdPlaySmartPlayList(this);
      }
    }
    label194:
    label216:
    label339:
    for (;;)
    {
      return;
      Track localTrack = PlayList().CurrentTrack();
      int i = 0;
      Intent localIntent;
      if (localTrack != null)
      {
        i = PlayList().GetCurrentPlayingTrackPosition();
        CoreHelper.WriteTraceEntry(TAG, "Widget command received. Resuming " + localTrack.DisplayName());
        localIntent = new Intent("mobi.beyondpod.services.musicservicecommand");
        if (!paramIntent.getAction().equals("mobi.beyondpod.services.musicservicewidgetcommand.playpause")) {
          break label216;
        }
        if ((IsMultiPlayerInitialized()) && (localTrack != null)) {
          break label194;
        }
        CoreHelper.WriteTraceEntry(TAG, "Widget command received invoked OpenAndPlay");
        localIntent.putExtra("command", "open");
        localIntent.putExtra("trackPos", i);
      }
      for (;;)
      {
        if (BeyondPodApplication.GetInstance().SendCommandToVideoPlayer(localIntent)) {
          break label339;
        }
        this._IntentReceiver.onReceive(this, localIntent);
        return;
        CoreHelper.WriteTraceEntry(TAG, "Widget command received. No Current Track. Starting from track 0");
        break;
        CoreHelper.WriteTraceEntry(TAG, "Widget command received invoked TogglePlayPause");
        localIntent.putExtra("command", "togglepause");
        continue;
        if (paramIntent.getAction().equals("mobi.beyondpod.services.musicservicewidgetcommand.skiptoend")) {
          localIntent.putExtra("command", "skiptoend");
        } else if (paramIntent.getAction().equals("mobi.beyondpod.services.musicservicewidgetcommand.skipback")) {
          localIntent.putExtra("command", "skipbackword");
        } else if (paramIntent.getAction().equals("mobi.beyondpod.services.musicservicewidgetcommand.skipforward")) {
          localIntent.putExtra("command", "skipforward");
        } else if (paramIntent.getAction().equals("mobi.beyondpod.services.musicservicewidgetcommand.nexttrack")) {
          localIntent.putExtra("command", "playnext");
        } else if (paramIntent.getAction().equals("mobi.beyondpod.services.musicservicewidgetcommand.stop")) {
          localIntent.putExtra("command", "stop");
        }
      }
    }
  }
  
  private void HandletCommandWhenPlaylistLoads(Intent paramIntent)
  {
    try
    {
      this._LoadDataStartTime = System.currentTimeMillis();
      if (FeedRepository.RepositoryLoadState() == -1)
      {
        Notification localNotification = BeyondPodApplication.GetInstance().GetDefaultNotificationForService(this, "Loading feeds...");
        NotificationHelper.getInstance().StartForegroundAndShowNotification(this, 1, localNotification);
        CoreHelper.WriteTraceEntry(TAG, "******* MediaPlaybackService HandleCommand found that repository is not loaded! (repo state is: " + FeedRepository.RepositoryLoadState() + ") Loading repository...");
        if (!FeedRepository.InitializeAndLoadRepository())
        {
          CoreHelper.WriteLogEntry(TAG, "MediaPlayBack Service - the repository failed to load! Giving Up!");
          BeyondPodApplication.GetInstance().RefreshWidgets();
          stopSelf();
          return;
        }
      }
      long l1;
      long l2;
      do
      {
        if (HandleCommandInternal(paramIntent)) {
          break;
        }
        CoreHelper.WriteTraceEntry(TAG, "MediaPlayBack Service - Repository is still loading...");
        Thread.sleep(1000L);
        l1 = System.currentTimeMillis();
        l2 = this._LoadDataStartTime;
      } while (l1 - l2 < 20000L);
    }
    catch (Exception paramIntent)
    {
      for (;;)
      {
        CoreHelper.LogException(TAG, "MediaPlayBack Service - Failed to process Command!", paramIntent);
      }
    }
    CoreHelper.WriteLogEntry(TAG, "MediaPlayBack Service - is taking too long to load! Giving Up!");
    stopSelf();
    return;
  }
  
  private boolean IsMultiPlayerInitialized()
  {
    if (this._Player == null)
    {
      CoreHelper.WriteLogEntry(TAG, "!!!!! Player operation invoked but the Player instance is NULL! Reinitializing the Player!");
      InitializePlayer();
      return false;
    }
    return this._Player.isInitialized();
  }
  
  private void LoadCurrentTrack(boolean paramBoolean)
  {
    Track localTrack = CurrentPlayingTrack();
    if (localTrack != null)
    {
      this._StartPlaybackAfterPrepare = paramBoolean;
      PreparePlaybackSource(localTrack);
      return;
    }
    CoreHelper.WriteTraceEntry(TAG, "  LoadCurrentTrack found that there is no Current Track. Ignoring...");
  }
  
  private void OpenAndPlayCurrentTrack()
  {
    int j = PlayList().GetCurrentPlayingTrackPosition();
    int i = j;
    if (j < 0) {
      i = 0;
    }
    openAndPlay(i);
  }
  
  private PlayList PlayList()
  {
    return BeyondPodApplication.GetInstance().PlayList();
  }
  
  private void PreparePlaybackSource(Track paramTrack)
  {
    this._IdleStateStartTime = 0L;
    this._Player._Handler.removeMessages(4);
    if (ChromecastDevice.IsConnected())
    {
      CoreHelper.WriteTraceEntry(TAG, "  Preparing playback to a Chromecast device! (" + paramTrack + ")");
      if (StringUtils.IsNullOrEmpty(paramTrack.getUrl()))
      {
        CoreHelper.WriteTraceEntry(TAG, "Chromecast Player can handle only internet media!");
        paramTrack.setCurrentPlayState(9);
        return;
      }
      paramTrack.setBufferedPercent(0);
      paramTrack.setCurrentPlayState(3);
      this._Player.setDataSourceChromecast(new IMediaPlayerImpl.TrackMetadata(paramTrack.getUrl(), paramTrack.DisplayName(), paramTrack.ContentMimeType(), paramTrack.getParentFeed().getFeedImageUrl(), paramTrack.getParentFeed().getName(), paramTrack.getLastModifiedDate()));
      this._MetadataPublisher.PublishTrackInformation(paramTrack, true);
      BeyondPodApplication.GetInstance().SetPlayerNotification(this, paramTrack);
      return;
    }
    if ((!PlayList.AllowStreaming(paramTrack)) || ((Configuration.AllowVideosInPlaylist()) && (paramTrack.ContentType() == 2)))
    {
      paramTrack.setCurrentPlayState(2);
      this._Player.setDataSourceVideoTrack(paramTrack);
      gotoIdleState(true);
      return;
    }
    if (paramTrack.Exists())
    {
      float f = GetDefaultSpeedForTrack(paramTrack);
      CoreHelper.WriteTraceEntry(TAG, "  Preparing playback source Sync! (" + paramTrack + ", Playback Speed: " + f + ")");
      paramTrack.setCurrentPlayState(3);
      this._Player.setDataSource(paramTrack.TrackPath(), paramTrack.ContentMimeType(), f);
    }
    for (;;)
    {
      this._MetadataPublisher.PublishTrackInformation(paramTrack, true);
      BeyondPodApplication.GetInstance().SetPlayerNotification(this, paramTrack);
      return;
      CoreHelper.WriteTraceEntry(TAG, "  Preparing playback source Async! (" + paramTrack + ")");
      paramTrack.setBufferedPercent(0);
      paramTrack.setCurrentPlayState(3);
      this._Player.setDataSourceAsync(paramTrack.getUrl());
    }
  }
  
  private void SeekAtStart(long paramLong)
  {
    if (this._StartPlaybackAfterPrepare)
    {
      this._StartPlaybackAfterSeek = true;
      this._StartPlaybackAfterPrepare = false;
    }
    if (Configuration.getInternalPlayerSupportedFileExtensions().contains("blipstart")) {
      DoFunkyHTCIncredibleHack();
    }
    this._Player.seek(paramLong);
  }
  
  private void StartPlaybackIfNeeded()
  {
    if (this._StartPlaybackAfterPrepare)
    {
      this._StartPlaybackAfterPrepare = false;
      startAndFadeIn();
      return;
    }
    gotoIdleState(false);
  }
  
  private boolean VerifyCurrentTrack(MultiPlayer paramMultiPlayer, Track paramTrack, int paramInt)
  {
    paramMultiPlayer = paramMultiPlayer.getCurrentMediaPath();
    if (StringUtils.IsNullOrEmpty(paramMultiPlayer)) {}
    while ((!StringUtils.Equals(paramMultiPlayer, paramTrack.TrackPath())) && (!StringUtils.Equals(paramMultiPlayer, paramTrack.getUrl()))) {
      return false;
    }
    return true;
  }
  
  private boolean canChangePlaybackSpeed()
  {
    if (IsMultiPlayerInitialized()) {
      return this._Player.canChangePlaybackSpeed();
    }
    return false;
  }
  
  private float getCurrentPlaybackSpeed()
  {
    if (IsMultiPlayerInitialized()) {
      return this._Player.getCurrentPlaybackSpeed();
    }
    return 1.0F;
  }
  
  private int gettimetosleep()
  {
    return this._TimeToSleep;
  }
  
  private void gotoIdleState(boolean paramBoolean)
  {
    this._IdleStateStartTime = System.currentTimeMillis();
    CoreHelper.WriteTraceEntry(TAG, "Service autoshutdown scheduled from gotoIdleState");
    this._DelayedStopHandler.removeCallbacksAndMessages(null);
    Object localObject = this._DelayedStopHandler.obtainMessage();
    this._DelayedStopHandler.sendMessageDelayed((Message)localObject, 60000L);
    localObject = NotificationHelper.getInstance();
    if (paramBoolean) {}
    for (int i = 1;; i = -1)
    {
      ((NotificationHelper)localObject).StopForeground(this, i);
      if (!paramBoolean) {
        BeyondPodApplication.GetInstance().SetPlayerPauseNotification(this, CurrentPlayingTrack());
      }
      return;
    }
  }
  
  private void gotosleepin(int paramInt)
  {
    this._TimeToSleep = paramInt;
    if (paramInt > 0)
    {
      scheduleSleepTick();
      return;
    }
    this._MediaplayerHandler.removeMessages(5);
  }
  
  private void handleCommand(Intent paramIntent, int paramInt)
  {
    this._ServiceStartId = paramInt;
    CoreHelper.WriteTraceEntry(TAG, "Service autoshutdown scheduled from onStart");
    this._DelayedStopHandler.removeCallbacksAndMessages(null);
    Message localMessage = this._DelayedStopHandler.obtainMessage();
    this._DelayedStopHandler.sendMessageDelayed(localMessage, 60000L);
    if (!HandleCommandInternal(paramIntent)) {
      HandletCommandWhenPlaylistLoads(paramIntent);
    }
  }
  
  private void scheduleSleepTick()
  {
    this._MediaplayerHandler.removeMessages(5);
    this._MediaplayerHandler.sendMessageDelayed(this._MediaplayerHandler.obtainMessage(5), 60000L);
  }
  
  private void setPlaybackSpeed(float paramFloat1, float paramFloat2)
  {
    if (IsMultiPlayerInitialized()) {
      this._Player.setPlaybackSpeed(paramFloat1, paramFloat2);
    }
  }
  
  private void stop(boolean paramBoolean)
  {
    this._MediaplayerHandler.removeMessages(6);
    if (IsMultiPlayerInitialized())
    {
      if (isPlaying()) {
        pause();
      }
      this._Player.stop();
    }
    Track localTrack = CurrentPlayingTrack();
    if (localTrack != null)
    {
      localTrack.setCurrentPlayState(2);
      this._MetadataPublisher.PublishTrackInformation(localTrack, false);
    }
    while (paramBoolean)
    {
      gotoIdleState(true);
      return;
      CoreHelper.WriteTraceEntry(TAG, "Trying to stop playback, but there was no current track. Ignoring...");
    }
    NotificationHelper.getInstance().StopForeground(this, -1);
  }
  
  private boolean supportsSpeedAlteration()
  {
    if (IsMultiPlayerInitialized()) {
      return this._Player.supportsSpeedAlteration();
    }
    return false;
  }
  
  void InitializePlayer()
  {
    this._Player = new MultiPlayer();
    this._Player.setHandler(this._MediaplayerHandler);
    CoreHelper.WriteTraceEntry(TAG, "MultiPlayer Initialized!");
  }
  
  void ReleasePlayer()
  {
    if (this._Player != null) {
      this._Player.release();
    }
    this._Player = null;
    CoreHelper.WriteTraceEntry(TAG, "MultiPlayer Released!");
  }
  
  public long duration()
  {
    if (IsMultiPlayerInitialized())
    {
      long l2 = this._Player.duration();
      long l1 = l2;
      if (l2 <= 0L)
      {
        Track localTrack = CurrentPlayingTrack();
        if (!this._IsPreparing)
        {
          l1 = l2;
          if (!this._IsSeeking) {}
        }
        else
        {
          l1 = l2;
          if (localTrack != null)
          {
            l1 = l2;
            if (localTrack.getPlayedTime() > 0L) {
              l1 = localTrack.getTotalTime() * 1000L;
            }
          }
        }
      }
      return l1;
    }
    return -1L;
  }
  
  public boolean isPlaying()
  {
    if (IsMultiPlayerInitialized()) {
      return this._Player.isPlaying();
    }
    return false;
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    this._DelayedStopHandler.removeCallbacksAndMessages(null);
    paramIntent = this._DelayedStopHandler.obtainMessage();
    this._DelayedStopHandler.sendMessageDelayed(paramIntent, 60000L);
    this._ServiceInUse = true;
    return this.mBinder;
  }
  
  public void onCreate()
  {
    super.onCreate();
    CoreHelper.WriteTraceEntry(TAG, "--------------------------- MediaPlayback Service is Created!---------------------------");
    AnalyticsTracker.StartSession(this);
    ServiceIsRunning = true;
    InitializePlayer();
    if (!Configuration.RichPlayerNotication()) {
      NotificationHelper.getInstance().ClearNotification(this, 1);
    }
    this._WakeLock = ((PowerManager)getSystemService("power")).newWakeLock(1, getClass().getName());
    this._WakeLock.setReferenceCounted(false);
    ((TelephonyManager)getSystemService("phone")).listen(this._PhoneStateListener, 32);
    registerReceiver(this._IntentReceiver, new IntentFilter("mobi.beyondpod.services.musicservicecommand"));
    Object localObject = new IntentFilter("android.intent.action.BATTERY_CHANGED");
    ((IntentFilter)localObject).addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
    registerReceiver(this._BatteryStateReceiver, (IntentFilter)localObject);
    localObject = new IntentFilter("android.intent.action.SCREEN_ON");
    registerReceiver(this._ScreenWakeUpReceiver, (IntentFilter)localObject);
    this._MetadataPublisher = TrackMetadataPublisher.getInstance();
    LoadCurrentTrack(false);
    CoreHelper.WriteTraceEntry(TAG, "Service autoshutdown scheduled from onCreate");
    localObject = this._DelayedStopHandler.obtainMessage();
    this._DelayedStopHandler.sendMessageDelayed((Message)localObject, 60000L);
  }
  
  public void onDestroy()
  {
    if (isPlaying()) {
      CoreHelper.WriteLogEntry(TAG, "Service being destroyed while still playing.");
    }
    ReleasePlayer();
    this._DelayedStopHandler.removeCallbacksAndMessages(null);
    this._MediaplayerHandler.removeCallbacksAndMessages(null);
    ((TelephonyManager)getSystemService("phone")).listen(this._PhoneStateListener, 0);
    unregisterReceiver(this._BatteryStateReceiver);
    unregisterReceiver(this._ScreenWakeUpReceiver);
    unregisterReceiver(this._IntentReceiver);
    this._WakeLock.release();
    if ((Configuration.RichPlayerNotication()) && (NotificationHelper.getInstance().IsNotificationShowing(1))) {
      BeyondPodApplication.GetInstance().SetPlayerPauseNotification(this, CurrentPlayingTrack());
    }
    CoreHelper.WriteTraceEntry(TAG, "--------------------------- MediaPlayback service is Destroyed! ---------------------------");
    AnalyticsTracker.EndSession(this);
    ServiceIsRunning = false;
    super.onDestroy();
  }
  
  public void onRebind(Intent paramIntent)
  {
    this._DelayedStopHandler.removeCallbacksAndMessages(null);
    paramIntent = this._DelayedStopHandler.obtainMessage();
    this._DelayedStopHandler.sendMessageDelayed(paramIntent, 60000L);
    this._ServiceInUse = true;
  }
  
  public void onStart(Intent paramIntent, int paramInt)
  {
    handleCommand(paramIntent, paramInt);
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    handleCommand(paramIntent, paramInt2);
    return 2;
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    this._ServiceInUse = false;
    if ((isPlaying()) || (this._ResumeAfterCall)) {
      return true;
    }
    if ((PlayList().PlaylistSize() > 0) || (this._MediaplayerHandler.hasMessages(1)))
    {
      CoreHelper.WriteTraceEntry(TAG, "Service autoshutdown scheduled from onUnbind");
      paramIntent = this._DelayedStopHandler.obtainMessage();
      this._DelayedStopHandler.sendMessageDelayed(paramIntent, 60000L);
      return true;
    }
    stopSelf(this._ServiceStartId);
    return true;
  }
  
  public void openAndPlay(int paramInt)
  {
    try
    {
      Track localTrack = PlayList().GetTrackAtPosition(paramInt);
      if (localTrack == null) {
        return;
      }
      if ((localTrack.Exists()) || (localTrack.HasUrl()))
      {
        pause();
        if (localTrack.IsPlayed()) {
          localTrack.ClearPlayed();
        }
        PlayList().SetCurrentTrack(paramInt);
        this._StartPlaybackAfterPrepare = true;
        PreparePlaybackSource(localTrack);
      }
      return;
    }
    finally {}
  }
  
  public void pause()
  {
    AudioFocusHelper.getInstance().ReleaseAudioFocus();
    this._MediaplayerHandler.removeMessages(6);
    if (isPlaying())
    {
      this._Player.pause();
      Track localTrack = CurrentPlayingTrack();
      if ((localTrack == null) || (localTrack.getCurrentPlayState() != 1)) {
        break label108;
      }
      if (VerifyCurrentTrack(this._Player, localTrack, 2)) {
        localTrack.setPlayedTime(this._Player.position() / 1000L);
      }
      localTrack.setCurrentPlayState(0);
      this._MetadataPublisher.PublishTrackInformation(localTrack, false);
      ScheduledTasksManager.ScheduleSyncTaskIfSyncIsEnabled(15, TimeSpan.fromSeconds(1.0D), false);
      FeedRepository.SaveRepositoryAsync();
    }
    for (;;)
    {
      gotoIdleState(false);
      return;
      label108:
      CoreHelper.WriteTraceEntry(TAG, "Trying to pause track that is null or not playing. Ignoring...");
    }
  }
  
  public boolean play()
  {
    if (FeedRepository.RepositoryLoadState() == -1)
    {
      CoreHelper.WriteLogEntry(TAG, "MediaPlaybackService play() is called but the feed repository is not initialized! Command Ignoried!");
      return false;
    }
    Track localTrack = CurrentPlayingTrack();
    if ((localTrack != null) && ((localTrack.getCurrentPlayState() == 7) || (localTrack.getCurrentPlayState() == 8) || (localTrack.getCurrentPlayState() == 9))) {
      OpenAndPlayCurrentTrack();
    }
    for (;;)
    {
      return true;
      if (IsMultiPlayerInitialized())
      {
        Intent localIntent = new Intent("com.android.music.musicservicecommand");
        localIntent.putExtra("command", "pause");
        sendBroadcast(localIntent);
        if (localTrack != null)
        {
          if (localTrack.getCurrentPlayState() == 3)
          {
            CoreHelper.WriteTraceEntry(TAG, "MediaPlaybackService play() was called while the player is preparing! Playback will start after Prepare is Complete!");
            this._StartPlaybackAfterPrepare = true;
            return false;
          }
          if ((!AudioFocusHelper.getInstance().TrySetAudioFocus()) && (!Configuration.getInternalPlayerSupportedFileExtensions().contains("ignorefocus"))) {
            return false;
          }
          int i = Configuration.ResumeReplayDuration();
          if ((i > 0) && (!localTrack.IsPlayed()) && (System.currentTimeMillis() - this._IdleStateStartTime > 60000L))
          {
            long l2 = (localTrack.getPlayedTime() - i) * 1000L;
            long l1 = l2;
            if (l2 < 0L) {
              l1 = 0L;
            }
            CoreHelper.WriteTraceEntry(TAG, "### Replaying the last " + i + " secs. Moving from: " + position() + " (" + CoreHelper.FormatTimeAsString(position() / 1000L) + ") to " + l1 + " (" + CoreHelper.FormatTimeAsString(l1 / 1000L) + ")");
            this._IdleStateStartTime = System.currentTimeMillis();
            this._StartPlaybackAfterSeek = true;
            this._Player.seek(l1);
            if (this._Player.playerType() != 2) {
              return false;
            }
          }
          this._Player.setVolumeBoost(localTrack.PlaybackVolumeBoost());
          this._Player.start();
          if (this._Player.playerType() == 2) {
            return true;
          }
          localTrack.setCurrentPlayState(1);
          this._MetadataPublisher.PublishTrackInformation(localTrack, false);
          if (localTrack.getTotalTime() <= 0L) {
            localTrack.setTotalTime(this._Player.duration() / 1000L);
          }
          BeyondPodApplication.GetInstance().SetPlayerNotification(this, CurrentPlayingTrack());
        }
        else
        {
          CoreHelper.WriteLogEntry(TAG, "MediaPlaybackService play() was called with 'null' CurrentPlayingTrack()");
          return false;
        }
      }
      else
      {
        if (PlayList().PlaylistSize() <= 0) {
          break;
        }
        OpenAndPlayCurrentTrack();
      }
    }
    CoreHelper.WriteTraceEntry(TAG, "MediaPlaybackService play() was called with empty playlist");
    return false;
  }
  
  protected int playerType()
  {
    if (IsMultiPlayerInitialized()) {
      return this._Player.playerType();
    }
    return -1;
  }
  
  public long position()
  {
    if (IsMultiPlayerInitialized())
    {
      long l2 = this._Player.position();
      long l1 = l2;
      if (l2 <= 0L)
      {
        Track localTrack = CurrentPlayingTrack();
        if (!this._IsPreparing)
        {
          l1 = l2;
          if (!this._IsSeeking) {}
        }
        else
        {
          l1 = l2;
          if (localTrack != null)
          {
            l1 = l2;
            if (localTrack.getPlayedTime() > 0L) {
              l1 = localTrack.getPlayedTime() * 1000L;
            }
          }
        }
      }
      return l1;
    }
    return -1L;
  }
  
  public long seek(long paramLong)
  {
    if (IsMultiPlayerInitialized())
    {
      long l = paramLong;
      if (paramLong < 0L) {
        l = 0L;
      }
      paramLong = l;
      if (l > this._Player.duration()) {
        paramLong = this._Player.duration();
      }
      return this._Player.seek(paramLong);
    }
    return -1L;
  }
  
  public void startAndFadeIn()
  {
    if ((Configuration.EnableFadeInOnPlaybackStart()) && (this._Player.playerType() == 0))
    {
      this._MediaplayerHandler.sendEmptyMessageDelayed(6, FADE_IN_TICK);
      return;
    }
    play();
  }
  
  public void stop()
  {
    stop(true);
  }
  
  private class MultiPlayer
  {
    private String _CurrentMediaPath;
    int _CurrentWakeMode = -1;
    private Handler _Handler;
    private boolean _IsInitialized = false;
    private IMediaPlayerImpl _MediaPlayer = MediaPlayerFactory.CreatePlayer(MediaPlaybackService.this);
    IMediaPlayerImpl.OnCompletionListener _completionListener = new IMediaPlayerImpl.OnCompletionListener()
    {
      public void onCompletion(IMediaPlayerImpl paramAnonymousIMediaPlayerImpl)
      {
        String str = MediaPlaybackService.TAG;
        StringBuilder localStringBuilder = new StringBuilder("  Media Player OnCompleted!");
        if (MediaPlaybackService.this.CurrentPlayingTrack() == null)
        {
          paramAnonymousIMediaPlayerImpl = "No Track";
          CoreHelper.WriteTraceEntry(str, paramAnonymousIMediaPlayerImpl);
          MediaPlaybackService.this._WakeLock.acquire(30000L);
          MediaPlaybackService.access$0(MediaPlaybackService.this)._Handler.removeMessages(4);
          if ((CoreHelper.ApiLevel() >= 8) && (MediaPlaybackService.this.CurrentPlayingTrack() != null) && (!MediaPlaybackService.this.CurrentPlayingTrack().Exists()) && (MediaPlaybackService.this.CurrentPlayingTrack().getBufferedPercent() <= 95)) {
            break label216;
          }
          MediaPlaybackService.MultiPlayer.this._Handler.sendEmptyMessage(1);
        }
        for (;;)
        {
          MediaPlaybackService.MultiPlayer.this._Handler.sendEmptyMessageDelayed(2, 2000L);
          return;
          paramAnonymousIMediaPlayerImpl = "Track Exists: " + MediaPlaybackService.this.CurrentPlayingTrack().Exists() + ", Buffered: " + MediaPlaybackService.this.CurrentPlayingTrack().getBufferedPercent() + "%";
          break;
          label216:
          CoreHelper.WriteLogEntryInProduction(MediaPlaybackService.TAG, "####### OnCompleted event was Ignored because a streaming track did not finish playing!");
          MediaPlaybackService.MultiPlayer.this._Handler.sendEmptyMessage(7);
        }
      }
    };
    IMediaPlayerImpl.OnErrorListener _errorListener = new IMediaPlayerImpl.OnErrorListener()
    {
      public boolean onError(IMediaPlayerImpl paramAnonymousIMediaPlayerImpl, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        CoreHelper.WriteTraceEntry(MediaPlaybackService.TAG, "  Media Player OnError! What:" + paramAnonymousInt1 + ", Extra:" + paramAnonymousInt2);
        MediaPlaybackService.this._IsPreparing = false;
        MediaPlaybackService.this._IsSeeking = false;
        MediaPlaybackService.this._MediaplayerHandler.removeCallbacksAndMessages(null);
        if ((paramAnonymousInt1 == 101010) && (paramAnonymousInt2 == 200))
        {
          CoreHelper.WriteTraceEntry(MediaPlaybackService.TAG, "  Our Chromecast session was interrupted! Stopping any playback... ");
          MediaPlaybackService.MultiPlayer.this.stop();
          MediaPlaybackService.this._StartPlaybackAfterPrepare = false;
          MediaPlaybackService.this._StartPlaybackAfterSeek = false;
          return true;
        }
        if ((paramAnonymousInt1 < 0) || (paramAnonymousInt1 == 100))
        {
          MediaPlaybackService.this._StartPlaybackAfterPrepare = false;
          MediaPlaybackService.this._StartPlaybackAfterSeek = false;
          MediaPlaybackService.MultiPlayer.this.RecreatePlayer();
          label158:
          switch (paramAnonymousInt1)
          {
          }
        }
        for (;;)
        {
          MediaPlaybackService.MultiPlayer.this._Handler.sendMessageDelayed(MediaPlaybackService.MultiPlayer.this._Handler.obtainMessage(7), 1000L);
          return true;
          MediaPlaybackService.MultiPlayer.this._MediaPlayer.reset();
          break label158;
          CoreHelper.WriteLogEntry(MediaPlaybackService.TAG, "******** MEDIA_ERROR_SERVER_DIED, Extra:" + paramAnonymousInt2);
          if (FeedRepository.RepositoryLoadState() == -1) {
            break;
          }
          MediaPlaybackService.MultiPlayer.this._Handler.sendMessageDelayed(MediaPlaybackService.MultiPlayer.this._Handler.obtainMessage(3), 2000L);
          return true;
          CoreHelper.WriteLogEntry(MediaPlaybackService.TAG, "******** MEDIA_ERROR_UNKNOWN, Extra:" + paramAnonymousInt2);
        }
      }
    };
    
    public MultiPlayer()
    {
      UpdatePlayerWakeMode(CoreHelper.IsDevicePlugged());
    }
    
    private void RecreatePlayer()
    {
      this._IsInitialized = false;
      MediaPlaybackService.this._IsPreparing = false;
      MediaPlaybackService.this._IsSeeking = false;
      this._MediaPlayer.release();
      this._MediaPlayer = MediaPlayerFactory.CreatePlayer(MediaPlaybackService.this);
      this._CurrentWakeMode = 1;
      this._MediaPlayer.setWakeMode(MediaPlaybackService.this, this._CurrentWakeMode);
      CoreHelper.WriteLogEntry(MediaPlaybackService.TAG, "******** Media Player was recreated due to internal Error!");
    }
    
    private void UpdatePlayerWakeMode(boolean paramBoolean)
    {
      int j;
      int i;
      if (this._MediaPlayer != null)
      {
        j = 1;
        if (Configuration.PlayerPlaybackScreenPowerState() != 3) {
          break label50;
        }
        i = 6;
      }
      for (;;)
      {
        if (this._CurrentWakeMode != i)
        {
          this._CurrentWakeMode = i;
          this._MediaPlayer.setWakeMode(MediaPlaybackService.this, this._CurrentWakeMode);
        }
        return;
        label50:
        if (Configuration.PlayerPlaybackScreenPowerState() == 4)
        {
          i = 10;
        }
        else if ((Configuration.PlayerPlaybackScreenPowerState() == 1) && (paramBoolean))
        {
          i = 6;
        }
        else
        {
          i = j;
          if (Configuration.PlayerPlaybackScreenPowerState() == 2)
          {
            i = j;
            if (paramBoolean) {
              i = 10;
            }
          }
        }
      }
    }
    
    private void configureSelectedPlayer(IMediaPlayerImpl paramIMediaPlayerImpl, String paramString)
      throws IllegalArgumentException, IllegalStateException, IOException
    {
      paramIMediaPlayerImpl.setOnPreparedListener(MediaPlaybackService.this._preparedlistener);
      paramIMediaPlayerImpl.setOnErrorListener(this._errorListener);
      paramIMediaPlayerImpl.setOnSeekCompleteListener(MediaPlaybackService.this._SeekCompleteListener);
      paramIMediaPlayerImpl.setOnInfoListener(MediaPlaybackService.this._InfoListener);
      paramIMediaPlayerImpl.setOnBufferingUpdateListener(MediaPlaybackService.this._BufferingUpdateListener);
      this._CurrentMediaPath = paramString;
      paramIMediaPlayerImpl.setDataSource(paramString);
      if (paramIMediaPlayerImpl.supportsSpeedAlteration())
      {
        this._IsInitialized = true;
        InitializeOnCompletionListener();
      }
      for (;;)
      {
        paramIMediaPlayerImpl.setAudioStreamType(3);
        paramIMediaPlayerImpl.prepare();
        return;
        paramIMediaPlayerImpl.setOnCompletionListener(null);
      }
    }
    
    private void handlePrepareException(Exception paramException)
    {
      MediaPlaybackService.this._IsPreparing = false;
      this._IsInitialized = false;
      CoreHelper.WriteTraceEntry(MediaPlaybackService.TAG, "Unable to setDataSource! Reason: " + CoreHelper.ExtractExceptionMessages(paramException));
      if (this._errorListener != null) {
        this._errorListener.onError(this._MediaPlayer, 1, 0);
      }
    }
    
    private void queueNextRefresh(long paramLong)
    {
      isPlaying();
      Message localMessage = this._Handler.obtainMessage(4);
      this._Handler.removeMessages(4);
      this._Handler.sendMessageDelayed(localMessage, paramLong);
    }
    
    private void setDataSource(String paramString1, String paramString2, float paramFloat)
    {
      try
      {
        if (this._MediaPlayer.isPlaying()) {
          stop();
        }
        MediaPlaybackService.this._IsPreparing = true;
        this._MediaPlayer.reset();
        this._MediaPlayer = MediaPlayerFactory.SwitchToLocalPlayerIfNeeded(this._MediaPlayer, paramFloat, MediaPlaybackService.this, this._CurrentWakeMode, paramString1, paramString2);
        configureSelectedPlayer(this._MediaPlayer, paramString1);
      }
      catch (IOException paramString2)
      {
        for (;;)
        {
          if (this._MediaPlayer.playerType() == 4)
          {
            CoreHelper.WriteLogEntry(MediaPlaybackService.TAG, "Mpg123 player was unable to handle media! Switching to Android player...");
            this._MediaPlayer = MediaPlayerFactory.SwitchToStreamingPlayerIfNeeded(this._MediaPlayer, MediaPlaybackService.this, this._CurrentWakeMode);
            try
            {
              configureSelectedPlayer(this._MediaPlayer, paramString1);
            }
            catch (Exception paramString1)
            {
              handlePrepareException(paramString1);
              return;
            }
          }
          else
          {
            handlePrepareException(paramString2);
          }
        }
      }
      catch (Exception paramString1)
      {
        handlePrepareException(paramString1);
      }
      this._MediaPlayer.setPlaybackSpeed(paramFloat);
      this._IsInitialized = true;
      AnalyticsTracker.OnPlaybackStarted("Local Content");
      return;
    }
    
    private void setDataSourceAsync(String paramString)
    {
      try
      {
        if (this._MediaPlayer.isPlaying()) {
          stop();
        }
        MediaPlaybackService.this._IsPreparing = true;
        this._MediaPlayer.reset();
        this._MediaPlayer = MediaPlayerFactory.SwitchToStreamingPlayerIfNeeded(this._MediaPlayer, MediaPlaybackService.this, this._CurrentWakeMode);
        this._CurrentMediaPath = paramString;
        this._MediaPlayer.setDataSource(paramString);
        this._MediaPlayer.setAudioStreamType(3);
        this._MediaPlayer.setOnPreparedListener(MediaPlaybackService.this._preparedlistener);
        this._MediaPlayer.prepareAsync();
        this._MediaPlayer.setOnCompletionListener(null);
        this._MediaPlayer.setOnErrorListener(this._errorListener);
        this._MediaPlayer.setOnSeekCompleteListener(MediaPlaybackService.this._SeekCompleteListener);
        this._MediaPlayer.setOnInfoListener(MediaPlaybackService.this._InfoListener);
        this._MediaPlayer.setOnBufferingUpdateListener(MediaPlaybackService.this._BufferingUpdateListener);
        this._IsInitialized = true;
        AnalyticsTracker.OnPlaybackStarted("Streaming Content");
        return;
      }
      catch (Exception paramString)
      {
        do
        {
          MediaPlaybackService.this._IsPreparing = false;
          this._IsInitialized = false;
          CoreHelper.LogException(MediaPlaybackService.TAG, "Unable to setDataSourceAsync! Reason: ", paramString);
        } while (this._errorListener == null);
        this._errorListener.onError(this._MediaPlayer, 1, 0);
      }
    }
    
    private void setDataSourceChromecast(IMediaPlayerImpl.TrackMetadata paramTrackMetadata)
    {
      try
      {
        if (this._MediaPlayer.isPlaying()) {
          stop();
        }
        MediaPlaybackService.this._IsPreparing = true;
        this._MediaPlayer.reset();
        this._MediaPlayer = MediaPlayerFactory.SwitchToChromecastPlayerIfNeeded(this._MediaPlayer, MediaPlaybackService.this, this._CurrentWakeMode);
        this._CurrentMediaPath = paramTrackMetadata.TrackURL;
        this._MediaPlayer.setDataSource(paramTrackMetadata);
        this._MediaPlayer.setAudioStreamType(3);
        this._MediaPlayer.setOnPreparedListener(MediaPlaybackService.this._preparedlistener);
        this._MediaPlayer.prepareAsync();
        this._MediaPlayer.setOnCompletionListener(null);
        this._MediaPlayer.setOnErrorListener(this._errorListener);
        this._MediaPlayer.setOnSeekCompleteListener(MediaPlaybackService.this._SeekCompleteListener);
        this._MediaPlayer.setOnInfoListener(MediaPlaybackService.this._InfoListener);
        this._MediaPlayer.setOnBufferingUpdateListener(MediaPlaybackService.this._BufferingUpdateListener);
        this._IsInitialized = true;
        AnalyticsTracker.OnPlaybackStarted("Streaming Content via Chromecast");
        return;
      }
      catch (Exception paramTrackMetadata)
      {
        do
        {
          MediaPlaybackService.this._IsPreparing = false;
          this._IsInitialized = false;
          CoreHelper.LogException(MediaPlaybackService.TAG, "Unable to setDataSourceChromecast! Reason: ", paramTrackMetadata);
        } while (this._errorListener == null);
        this._errorListener.onError(this._MediaPlayer, 1, 0);
      }
    }
    
    private void setDataSourceVideoTrack(Track paramTrack)
    {
      if (this._MediaPlayer.isPlaying()) {
        stop();
      }
      MediaPlaybackService.this._IsPreparing = false;
      MediaPlaybackService.this._IsSeeking = false;
      this._MediaPlayer.reset();
      this._MediaPlayer.release();
      this._MediaPlayer = new MediaPlayerTrackBacked(MediaPlaybackService.this, paramTrack);
      this._IsInitialized = true;
      if (MediaPlaybackService.this._StartPlaybackAfterPrepare)
      {
        MediaPlaybackService.this._StartPlaybackAfterPrepare = false;
        this._MediaPlayer.start();
      }
    }
    
    public void InitializeOnCompletionListener()
    {
      this._MediaPlayer.setOnCompletionListener(this._completionListener);
    }
    
    public boolean canChangePlaybackSpeed()
    {
      return (this._MediaPlayer.canSetSpeed()) && (this._MediaPlayer.canSetPitch());
    }
    
    public long duration()
    {
      return this._MediaPlayer.getDuration();
    }
    
    public String getCurrentMediaPath()
    {
      return this._CurrentMediaPath;
    }
    
    public float getCurrentPlaybackSpeed()
    {
      return this._MediaPlayer.getCurrentSpeedMultiplier();
    }
    
    public boolean isInitialized()
    {
      return this._IsInitialized;
    }
    
    public boolean isPlaying()
    {
      return this._MediaPlayer.isPlaying();
    }
    
    public void pause()
    {
      this._Handler.removeMessages(4);
      this._MediaPlayer.pause();
      CoreHelper.WriteTraceEntry(MediaPlaybackService.TAG, "*** Player Paused!");
    }
    
    public int playerType()
    {
      return this._MediaPlayer.playerType();
    }
    
    public long position()
    {
      return this._MediaPlayer.getCurrentPosition();
    }
    
    public void release()
    {
      stop();
      this._MediaPlayer.release();
    }
    
    public long seek(long paramLong)
    {
      CoreHelper.WriteTraceEntry(MediaPlaybackService.TAG, "  Media Player Seeking to:" + paramLong);
      MediaPlaybackService.this._IsSeeking = true;
      try
      {
        this._MediaPlayer.seekTo((int)paramLong);
        return paramLong;
      }
      catch (Exception localException)
      {
        CoreHelper.WriteTraceEntry(MediaPlaybackService.TAG, "  Failed to seek! Reason: " + localException.getMessage());
        MediaPlaybackService.this._IsSeeking = false;
      }
      return 0L;
    }
    
    public void setHandler(Handler paramHandler)
    {
      this._Handler = paramHandler;
    }
    
    public void setPlaybackSpeed(float paramFloat1, float paramFloat2)
    {
      if (paramFloat2 >= 0.0F) {
        this._MediaPlayer.setPlaybackPitch(paramFloat2);
      }
      if (paramFloat1 > 0.0F) {
        this._MediaPlayer.setPlaybackSpeed(paramFloat1);
      }
    }
    
    public void setVolume(float paramFloat)
    {
      this._MediaPlayer.setVolume(paramFloat, paramFloat);
    }
    
    public void setVolumeBoost(float paramFloat)
    {
      this._MediaPlayer.setVolumeBoost(paramFloat);
    }
    
    public void start()
    {
      this._MediaPlayer.start();
      CoreHelper.WriteTraceEntry(MediaPlaybackService.TAG, "*** Player Started!");
      queueNextRefresh(5000L);
    }
    
    public void stop()
    {
      this._IsInitialized = false;
      MediaPlaybackService.this._IsPreparing = false;
      MediaPlaybackService.this._IsSeeking = false;
      this._Handler.removeMessages(4);
      this._MediaPlayer.reset();
      CoreHelper.WriteTraceEntry(MediaPlaybackService.TAG, "*** Player Stopped (reset)!");
    }
    
    public boolean supportsSpeedAlteration()
    {
      return this._MediaPlayer.supportsSpeedAlteration();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/services/player/MediaPlaybackService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */