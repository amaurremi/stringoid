package mobi.beyondpod.ui.views;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.TouchDelegate;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;
import com.aocate.media.MediaPlayer;
import java.lang.ref.WeakReference;
import java.text.DecimalFormat;
import mobi.beyondpod.BeyondPodApplication;
import mobi.beyondpod.downloadengine.UpdateAndDownloadManager;
import mobi.beyondpod.rsscore.Feed;
import mobi.beyondpod.rsscore.Track;
import mobi.beyondpod.rsscore.helpers.AnalyticsTracker;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.helpers.DateTime;
import mobi.beyondpod.rsscore.helpers.SimpleMessageBus;
import mobi.beyondpod.rsscore.helpers.StringUtils;
import mobi.beyondpod.rsscore.repository.FeedRepository;
import mobi.beyondpod.rsscore.repository.RepositoryEvents.RepositoryEvent;
import mobi.beyondpod.rsscore.repository.RepositoryEvents.RepositoryEventListener;
import mobi.beyondpod.rsscore.rss.LicenseManager;
import mobi.beyondpod.services.player.ChromecastUtils;
import mobi.beyondpod.services.player.IMediaPlaybackService;
import mobi.beyondpod.services.player.IMediaPlaybackService.Stub;
import mobi.beyondpod.services.player.PlayList;
import mobi.beyondpod.services.player.PlayListEvents.PlayListEvent;
import mobi.beyondpod.services.player.PlayListEvents.PlayListEventListener;
import mobi.beyondpod.services.player.PlayerUtils;
import mobi.beyondpod.services.player.SmartPlaylistTemplate;
import mobi.beyondpod.services.player.impl.ChromecastDevice;
import mobi.beyondpod.services.player.impl.MediaPlayerFactory;
import mobi.beyondpod.ui.commands.CommandManager;
import mobi.beyondpod.ui.core.ActionBarHelper;
import mobi.beyondpod.ui.core.FeedImageCache;
import mobi.beyondpod.ui.core.SimpleMenu;
import mobi.beyondpod.ui.core.volley.ImageUtils;
import mobi.beyondpod.ui.dialogs.PurchaseSpeedUpLibraryDialog;
import mobi.beyondpod.ui.dialogs.SelectSpeedDialog;
import mobi.beyondpod.ui.dialogs.SelectSpeedDialog.PlaybackSpeedSelectedListener;
import mobi.beyondpod.ui.dialogs.SetSleepTimerDialog;
import mobi.beyondpod.ui.dialogs.SetSleepTimerDialog.SleepTimeSelectedListener;
import mobi.beyondpod.ui.views.base.AlbumView;
import mobi.beyondpod.ui.views.base.CommonMenuHandler;
import mobi.beyondpod.ui.views.base.IView;
import mobi.beyondpod.ui.views.base.RepeatingImageButton;
import mobi.beyondpod.ui.views.base.RepeatingImageButton.RepeatListener;
import mobi.beyondpod.ui.views.base.SlidingTray;
import mobi.beyondpod.ui.views.base.SlidingTray.OnDrawerCloseListener;
import mobi.beyondpod.ui.views.base.SlidingTray.OnDrawerOpenListener;
import mobi.beyondpod.ui.views.base.SlidingTray.OnDrawerScrollListener;
import mobi.beyondpod.ui.views.base.TitleBarBase.TitleInfo;
import mobi.beyondpod.ui.views.notifications.UserNotificationManager;

public class PlayerView
  extends FrameLayout
  implements IView, PlayListEvents.PlayListEventListener, RepositoryEvents.RepositoryEventListener, PlaylistEditorListView.IPlaylitOwner
{
  private static final int ALBUM_ART_DECODED = 3;
  private static final int ALBUM_ART_DECODED_NO_TRACK = 4;
  private static final int GET_ALBUM_ART = 2;
  private static final int MENU_CLEAR_PLAYLIST = 2;
  private static final int MENU_DOWNLOAD_PLAYLIST = 8;
  private static final int MENU_EDIT_PLAYLIST = 7;
  private static final int MENU_PLAY_ALL_IN_CATEGORY = 4;
  private static final int MENU_PLAY_SMART_PLAYLIST = 3;
  private static final int MENU_STOP_SERVICE = 1;
  private static final String NOW_PLAYING = CoreHelper.LoadResourceString(2131297086);
  private static final String PLAYBACK_ERROR = CoreHelper.LoadResourceString(2131297079);
  private static final String PLAYBACK_ERROR_CANT_CAST = CoreHelper.LoadResourceString(2131297090);
  private static final String PLAYBACK_ERROR_STREAMING_DISABLED = CoreHelper.LoadResourceString(2131297080);
  private static final String PREPARING_STREAM_S = CoreHelper.LoadResourceString(2131297084);
  private static final int REFRESH = 1;
  private static final int SLEEP_TIMER_INACTIVE = 112;
  private static final String TAG = PlayerView.class.getSimpleName();
  AlbumView _Album;
  private AlbumArtHandler _AlbumArtHandler;
  private Worker _AlbumArtWorker;
  private TextView _CurrentTime;
  private long _Duration;
  Animation _EnterAnimation;
  Animation _ExitAnimation;
  private final Handler _Handler = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      if (paramAnonymousMessage.what == 1) {
        PlayerView.this.queueNextRefresh(PlayerView.access$21(PlayerView.this));
      }
      do
      {
        return;
        if (paramAnonymousMessage.what == 3)
        {
          PlayerView.this._Album.setVisibility(0);
          PlayerView.this._Album.setArtwork((Bitmap)paramAnonymousMessage.obj, PlayerView.this._IsActive);
          return;
        }
      } while (paramAnonymousMessage.what != 4);
      PlayerView.this._Album.clearBitmap();
      PlayerView.this._Album.setVisibility(4);
    }
  };
  private boolean _IsActive = false;
  View _ItemArea;
  protected long _LastSeekEventTime;
  protected boolean _ManualSeekInProgress;
  int _NotificationId = -1;
  long _NotificationOnTime = 0L;
  private ServiceConnection _Osc = new ServiceConnection()
  {
    public void onServiceConnected(ComponentName paramAnonymousComponentName, IBinder paramAnonymousIBinder)
    {
      PlayerView.this._Service = IMediaPlaybackService.Stub.asInterface(paramAnonymousIBinder);
      if (PlayerUtils.sService == null) {
        PlayerUtils.sService = PlayerView.this._Service;
      }
      if (PlayerView.this._Service == null) {
        return;
      }
      PlayerView.this._Owner.runOnUiThread(new Runnable()
      {
        public void run()
        {
          PlayerView.this.updateTrackInfo();
          PlayerView.this.setPauseButtonImage();
          PlayerView.this._Paused = false;
          PlayerView.this.queueNextRefresh(PlayerView.access$21(PlayerView.this));
        }
      });
    }
    
    public void onServiceDisconnected(ComponentName paramAnonymousComponentName) {}
  };
  private IPlayerOwner _Owner;
  private boolean _Paused;
  ImageButton _PlayPause;
  private View.OnClickListener _PlayPauseListener = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      if (PlayList.IsEmpty()) {
        CommandManager.CmdPlaySmartPlayList(PlayerView.this.getContext());
      }
      while (PlayerView.this.CurrentTrack() == null) {
        return;
      }
      PlayerView.this.doPauseResume();
    }
  };
  private TextView _PlaybackSpeed;
  private View _PlaybackSpeedExtender;
  DecimalFormat _PlaybackSpeedFormat = new DecimalFormat("#.##x");
  ImageButton _PlaylistEmptyPlay;
  PlaylistEditorListView _PlaylistListView;
  SlidingTray _PlaylistTray;
  private long _PosOverride = -1L;
  ProgressBar _PrepareProgress;
  private SeekBar _Progress;
  private Drawable _ProgressThumb;
  private int _ProgressThumbOffest;
  private SeekBar.OnSeekBarChangeListener _SeekListener = new SeekBar.OnSeekBarChangeListener()
  {
    public void onProgressChanged(SeekBar paramAnonymousSeekBar, int paramAnonymousInt, boolean paramAnonymousBoolean)
    {
      if (PlayerView.this._Service == null) {}
      do
      {
        do
        {
          return;
        } while (!paramAnonymousBoolean);
        long l = SystemClock.elapsedRealtime();
        if (l - PlayerView.this._LastSeekEventTime > 150L)
        {
          PlayerView.this._LastSeekEventTime = l;
          PlayerView.this._PosOverride = (PlayerView.this._Duration * paramAnonymousInt / 1000L);
          PlayerView.this._SeekTime.setText(CoreHelper.FormatTimeAsString(PlayerView.this._PosOverride / 1000L, true));
          PlayerView.this.updateRemainigTime(PlayerView.this._PosOverride);
          PlayerView.this._CurrentTime.setText(PlayerView.this._SeekTime.getText());
        }
      } while (PlayerView.this._ManualSeekInProgress);
      onStopTrackingTouch(paramAnonymousSeekBar);
    }
    
    public void onStartTrackingTouch(SeekBar paramAnonymousSeekBar)
    {
      PlayerView.this._ManualSeekInProgress = true;
      PlayerView.this._LastSeekEventTime = 0L;
      PlayerView.this._SeekTime.setText(PlayerView.this._CurrentTime.getText());
      PlayerView.this._SeekTime.setVisibility(0);
    }
    
    public void onStopTrackingTouch(SeekBar paramAnonymousSeekBar)
    {
      try
      {
        if (PlayerView.this._Service != null) {
          PlayerView.this._Service.seek(PlayerView.this._PosOverride);
        }
        PlayerView.this._PosOverride = -1L;
        PlayerView.this._SeekTime.setVisibility(8);
        PlayerView.this._ManualSeekInProgress = false;
        PlayerView.this._LastSeekEventTime = 0L;
        return;
      }
      catch (RemoteException paramAnonymousSeekBar)
      {
        for (;;) {}
      }
    }
  };
  private TextView _SeekTime;
  SelectSpeedDialog _SelectSpeedDialog;
  private IMediaPlaybackService _Service = null;
  private Runnable _ServiceConnectionRunnable = new Runnable()
  {
    public void run()
    {
      if (!PlayerUtils.bindToService(PlayerView.this.getContext(), PlayerView.this._Osc)) {
        Toast.makeText(PlayerView.this.getContext(), "Unable to bind to the player service!", 0).show();
      }
    }
  };
  RepeatingImageButton _SkipBack;
  private View.OnClickListener _SkipBackClickListener = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      if (PlayerView.this._Service == null) {
        return;
      }
      try
      {
        long l = PlayerView.this._Service.position() - mobi.beyondpod.rsscore.Configuration.getBackwardSkipInterval() * 1000;
        if (l > 0L)
        {
          PlayerView.this._Service.seek(l);
          return;
        }
        PlayerView.this._Service.seek(0L);
        return;
      }
      catch (RemoteException paramAnonymousView) {}
    }
  };
  private RepeatingImageButton.RepeatListener _SkipBackLongClickListener = new RepeatingImageButton.RepeatListener()
  {
    public void onRepeat(View paramAnonymousView, long paramAnonymousLong, int paramAnonymousInt)
    {
      PlayerView.this.scanBackward(paramAnonymousInt, paramAnonymousLong);
    }
  };
  RepeatingImageButton _SkipForward;
  private View.OnClickListener _SkipForwardClickListener = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      if (PlayerView.this._Service == null) {
        return;
      }
      try
      {
        long l1 = PlayerView.this._Service.position() + mobi.beyondpod.rsscore.Configuration.getForwardSkipInterval() * 1000;
        long l2 = PlayerView.this._Service.duration();
        if (l1 > l2)
        {
          PlayerView.this._Service.seek(l2 - 1000L);
          return;
        }
        PlayerView.this._Service.seek(l1);
        return;
      }
      catch (RemoteException paramAnonymousView) {}
    }
  };
  private RepeatingImageButton.RepeatListener _SkipForwardLongClickListener = new RepeatingImageButton.RepeatListener()
  {
    public void onRepeat(View paramAnonymousView, long paramAnonymousLong, int paramAnonymousInt)
    {
      PlayerView.this.scanForward(paramAnonymousInt, paramAnonymousLong);
    }
  };
  ImageButton _SkipToEnd;
  private View.OnClickListener _SkipToEndClickListener = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      if (mobi.beyondpod.rsscore.Configuration.SkipToEndButtonClickType() == 1) {
        PlayerView.this.DoSkipToEnd();
      }
    }
  };
  private View.OnLongClickListener _SkipToEndLongClickListener = new View.OnLongClickListener()
  {
    public boolean onLongClick(View paramAnonymousView)
    {
      if (mobi.beyondpod.rsscore.Configuration.SkipToEndButtonClickType() == 2) {
        PlayerView.this.DoSkipToEnd();
      }
      return false;
    }
  };
  private View.OnClickListener _SleepClickListener = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      PlayerView.this.SetSleepTime();
    }
  };
  ImageView _SleepIcon;
  private View.OnLongClickListener _SleepLongClickListener = new View.OnLongClickListener()
  {
    public boolean onLongClick(View paramAnonymousView)
    {
      int i = Integer.MIN_VALUE;
      paramAnonymousView = PlayerView.this;
      if (PlayerView.this.getTimetoSleep() == Integer.MIN_VALUE) {
        i = 0;
      }
      paramAnonymousView.setSleepTo(i);
      return true;
    }
  };
  TextView _SleepText;
  ImageView _SleepTimeImage;
  SetSleepTimerDialog _SleepTimerDialog;
  private long _StartSeekPos = 0L;
  TextView _StreamableImage;
  private TitleBarBase.TitleInfo _Title = new TitleBarBase.TitleInfo();
  private TextView _TotalTime;
  TextView _TrackDescription;
  TextView _TrackName;
  
  public PlayerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public PlayerView(Context paramContext, IPlayerOwner paramIPlayerOwner)
  {
    super(paramContext);
    this._Owner = paramIPlayerOwner;
    ((Activity)getContext()).setVolumeControlStream(3);
    this._AlbumArtWorker = new Worker("album art worker");
    this._AlbumArtHandler = new AlbumArtHandler(this._AlbumArtWorker.getLooper(), this._Handler);
    paramContext = ((Activity)getContext()).getLayoutInflater().inflate(2130903146, this);
    this._SkipBack = ((RepeatingImageButton)paramContext.findViewById(2131231108));
    this._SkipBack.setOnClickListener(this._SkipBackClickListener);
    this._SkipBack.setRepeatListener(this._SkipBackLongClickListener, 260L);
    this._SkipForward = ((RepeatingImageButton)paramContext.findViewById(2131231110));
    this._SkipForward.setOnClickListener(this._SkipForwardClickListener);
    this._SkipForward.setRepeatListener(this._SkipForwardLongClickListener, 260L);
    this._SkipToEnd = ((ImageButton)paramContext.findViewById(2131231111));
    this._SkipToEnd.setOnClickListener(this._SkipToEndClickListener);
    this._SkipToEnd.setOnLongClickListener(this._SkipToEndLongClickListener);
    this._PlayPause = ((ImageButton)paramContext.findViewById(2131231109));
    this._PlayPause.setOnClickListener(this._PlayPauseListener);
    this._PlaylistEmptyPlay = ((ImageButton)paramContext.findViewById(2131231134));
    if (this._PlaylistEmptyPlay != null) {
      this._PlaylistEmptyPlay.setOnClickListener(this._PlayPauseListener);
    }
    this._TrackName = ((TextView)paramContext.findViewById(2131231112));
    this._TrackDescription = ((TextView)paramContext.findViewById(2131231136));
    this._ItemArea = paramContext.findViewById(2131230978);
    this._ItemArea.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (PlayerView.this.CurrentTrack() != null) {
          CommandManager.CmdOpenTrackPropertiesDialog(PlayerView.this.CurrentTrack());
        }
      }
    });
    this._SleepIcon = ((ImageView)paramContext.findViewById(2131231140));
    this._SleepIcon.setOnClickListener(this._SleepClickListener);
    this._SleepIcon.setOnLongClickListener(this._SleepLongClickListener);
    this._SleepTimeImage = ((ImageView)paramContext.findViewById(2131231139));
    this._SleepTimeImage.setOnClickListener(this._SleepClickListener);
    this._SleepTimeImage.setOnLongClickListener(this._SleepLongClickListener);
    this._SleepText = ((TextView)paramContext.findViewById(2131231138));
    this._SleepText.setOnClickListener(this._SleepClickListener);
    this._SleepText.setOnLongClickListener(this._SleepLongClickListener);
    this._SleepIcon.setAlpha(112);
    this._SleepText.setVisibility(8);
    this._StreamableImage = ((TextView)paramContext.findViewById(2131230850));
    this._CurrentTime = ((TextView)findViewById(2131231114));
    this._TotalTime = ((TextView)findViewById(2131231115));
    this._SeekTime = ((TextView)findViewById(2131231141));
    this._PlaybackSpeed = ((TextView)findViewById(2131231142));
    this._PlaybackSpeedExtender = findViewById(2131231143);
    this._PlaybackSpeed.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        PlayerView.this.CyclePlaybackSpeed();
      }
    });
    this._PlaybackSpeed.setOnLongClickListener(new View.OnLongClickListener()
    {
      public boolean onLongClick(View paramAnonymousView)
      {
        PlayerView.this.SelectPlaybackSpeed();
        return true;
      }
    });
    this._PlaybackSpeedExtender.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        PlayerView.this.CyclePlaybackSpeed();
      }
    });
    this._PlaybackSpeedExtender.setOnLongClickListener(new View.OnLongClickListener()
    {
      public boolean onLongClick(View paramAnonymousView)
      {
        PlayerView.this.SelectPlaybackSpeed();
        return true;
      }
    });
    this._Progress = ((SeekBar)findViewById(16908301));
    if ((this._Progress instanceof SeekBar)) {
      this._Progress.setOnSeekBarChangeListener(this._SeekListener);
    }
    this._ProgressThumb = getResources().getDrawable(2130837990);
    this._ProgressThumbOffest = this._Progress.getThumbOffset();
    this._Progress.setThumb(this._ProgressThumb);
    this._Progress.setMax(1000);
    this._Album = ((AlbumView)findViewById(2131231133));
    this._PrepareProgress = ((ProgressBar)findViewById(2131231106));
    this._PlaylistTray = ((SlidingTray)findViewById(2131231144));
    this._PlaylistListView = ((PlaylistEditorListView)findViewById(2131231145));
    if (this._PlaylistTray != null)
    {
      this._PlaylistListView.InitializeView(this);
      this._PlaylistListView.setFadingEdgeLength(30);
      this._PlaylistListView.setVerticalFadingEdgeEnabled(true);
      this._PlaylistTray.setOnDrawerCloseListener(new SlidingTray.OnDrawerCloseListener()
      {
        public void onDrawerClosed(boolean paramAnonymousBoolean)
        {
          PlayerView.this._PlaylistTray.getHandle().setPressed(false);
          PlayerView.this._PlaylistTray.getHandle().setSelected(false);
          mobi.beyondpod.rsscore.Configuration.setPlayerPlaylistVisible(false);
          PlayerView.this._Paused = false;
          PlayerView.this.queueNextRefresh(500L);
        }
      });
      this._PlaylistTray.setOnDrawerOpenListener(new SlidingTray.OnDrawerOpenListener()
      {
        public void onDrawerOpened(boolean paramAnonymousBoolean)
        {
          PlayerView.this._PlaylistTray.getHandle().setSelected(true);
          PlayerView.this._PlaylistTray.getHandle().setPressed(false);
          PlayerView.this._Paused = true;
          PlayerView.this._Handler.removeMessages(1);
          mobi.beyondpod.rsscore.Configuration.setPlayerPlaylistVisible(true);
          PlayerView.this._PlaylistListView.SelectCurrentEpisode();
        }
      });
      this._PlaylistTray.setOnDrawerScrollListener(new SlidingTray.OnDrawerScrollListener()
      {
        public void onScrollEnded() {}
        
        public void onScrollStarted()
        {
          PlayerView.this._Paused = true;
          PlayerView.this._Handler.removeMessages(1);
        }
      });
    }
    paramContext.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public void onGlobalLayout()
      {
        if (PlayerView.this._Album.getTouchDelegate() == null)
        {
          Rect localRect = new Rect();
          PlayerView.this._Album.getHitRect(localRect);
          int i = (int)PlayerView.this.getResources().getDimension(2131492907);
          if (localRect.height() > i) {
            localRect.top += i;
          }
          i = localRect.width() - localRect.height();
          if (i > 0) {
            localRect.inset(i / 2, 0);
          }
          PlayerView.this._Album.setTouchDelegate(new TouchDelegate(localRect, PlayerView.this._PlayPause));
          PlayerView.this.updateTrackInfo();
          PlayerView.this.TogglePlaylistInternal(mobi.beyondpod.rsscore.Configuration.PlayerPlaylistVisible(), false);
        }
      }
    });
  }
  
  private boolean CanChangePlaybackSpeed()
  {
    try
    {
      if (this._Service != null)
      {
        boolean bool = this._Service.canChangePlaybackSpeed();
        return bool;
      }
    }
    catch (RemoteException localRemoteException) {}
    return false;
  }
  
  private float CurrentPlaybackSpeed()
  {
    try
    {
      if (this._Service != null)
      {
        float f = this._Service.getCurrentPlaybackSpeed();
        return f;
      }
    }
    catch (RemoteException localRemoteException) {}
    return 1.0F;
  }
  
  private Track CurrentTrack()
  {
    return PlayList().CurrentTrack();
  }
  
  private void CyclePlaybackSpeed()
  {
    if (!MediaPlayerFactory.IsSpeedAlterationPlayerInstalled(getContext()))
    {
      ShowSpeedAlterationPromo();
      return;
    }
    if (!SupportsSpeedAlteration())
    {
      ShowSpeedAlterationNotSupported();
      return;
    }
    if (CurrentPlaybackSpeed() == mobi.beyondpod.rsscore.Configuration.PlaybackSpeedNormal())
    {
      SetPlaybackSpeed(mobi.beyondpod.rsscore.Configuration.PlaybackSpeed1(), -1.0F);
      return;
    }
    if (CurrentPlaybackSpeed() == mobi.beyondpod.rsscore.Configuration.PlaybackSpeed1())
    {
      SetPlaybackSpeed(mobi.beyondpod.rsscore.Configuration.PlaybackSpeed2(), -1.0F);
      return;
    }
    SetPlaybackSpeed(mobi.beyondpod.rsscore.Configuration.PlaybackSpeedNormal(), -1.0F);
  }
  
  private void DoCleanup()
  {
    this._Paused = true;
    BeyondPodApplication.MessageBus.Unsubscribe(this, RepositoryEvents.RepositoryEvent.class);
    BeyondPodApplication.MessageBus.Unsubscribe(this, PlayListEvents.PlayListEvent.class);
    removeCallbacks(this._ServiceConnectionRunnable);
    this._Handler.removeCallbacksAndMessages(null);
    this._AlbumArtHandler.removeCallbacksAndMessages(null);
    PlayerUtils.unbindFromService(getContext());
    this._Service = null;
  }
  
  private void DoSkipToEnd() {}
  
  private PlayList PlayList()
  {
    return BeyondPodApplication.GetInstance().PlayList();
  }
  
  private int PlayerType()
  {
    if (this._Service != null) {
      try
      {
        int i = this._Service.playerType();
        return i;
      }
      catch (RemoteException localRemoteException) {}
    }
    return -1;
  }
  
  private void SelectPlaybackSpeed()
  {
    if (!MediaPlayerFactory.IsSpeedAlterationPlayerInstalled(getContext()))
    {
      ShowSpeedAlterationPromo();
      return;
    }
    if (!SupportsSpeedAlteration())
    {
      ShowSpeedAlterationNotSupported();
      return;
    }
    float f1 = 1.0F;
    try
    {
      float f2 = this._Service.getCurrentPlaybackSpeed();
      f1 = f2;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;) {}
    }
    this._SelectSpeedDialog = new SelectSpeedDialog(getContext(), new SelectSpeedDialog.PlaybackSpeedSelectedListener()
    {
      public void onPlaybackSpeedSelected(float paramAnonymousFloat)
      {
        PlayerView.this.SetPlaybackSpeed(paramAnonymousFloat, -1.0F);
      }
    }, f1);
    this._SelectSpeedDialog.show(this._PlaybackSpeed);
  }
  
  private void SetPlaybackSpeed(float paramFloat1, float paramFloat2)
  {
    try
    {
      mobi.beyondpod.rsscore.Configuration.setDefaultPlaybackSpeed(paramFloat1);
      if (this._Service != null) {
        this._Service.setPlaybackSpeed(paramFloat1, paramFloat2);
      }
      refreshNow();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;) {}
    }
  }
  
  private void SetSleepTime()
  {
    UserNotificationManager.TipNotifySleepSetting(this._Owner.ContentRoot());
    int j = mobi.beyondpod.rsscore.Configuration.PlayerSleepTimeout();
    int i = j;
    if (j == 9999) {
      i = Integer.MIN_VALUE;
    }
    if ((i != 0) && (getTimetoSleep() == 0))
    {
      setSleepTo(i);
      return;
    }
    this._SleepTimerDialog = new SetSleepTimerDialog(getContext(), new SetSleepTimerDialog.SleepTimeSelectedListener()
    {
      public void onCategorySelected(int paramAnonymousInt)
      {
        PlayerView.this.setSleepTo(paramAnonymousInt);
      }
    });
    this._SleepTimerDialog.show(this._SleepIcon);
  }
  
  private void ShowSpeedAlterationNotSupported()
  {
    if ((CurrentTrack() != null) && (!CurrentTrack().Exists())) {}
    for (int i = 2131296785;; i = 2131296784)
    {
      int j = i;
      if (LicenseManager.IfInRestrictedMode())
      {
        j = i;
        if (!MediaPlayer.isPrestoLibraryInstalled(getContext())) {
          j = 2131296786;
        }
      }
      Toast.makeText(getContext(), j, 1).show();
      return;
    }
  }
  
  private void ShowSpeedAlterationPromo()
  {
    if ((mobi.beyondpod.rsscore.Configuration.IsSonicSpeedAlterationSupported()) && (LicenseManager.IfInRestrictedMode()))
    {
      Toast.makeText(getContext(), 2131296786, 1).show();
      return;
    }
    PurchaseSpeedUpLibraryDialog.ShowDialog(getContext());
  }
  
  private boolean SupportsSpeedAlteration()
  {
    try
    {
      if (this._Service != null)
      {
        boolean bool = this._Service.supportsSpeedAlteration();
        return bool;
      }
    }
    catch (RemoteException localRemoteException) {}
    return false;
  }
  
  private void TogglePlaylistInternal(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this._PlaylistTray == null) {}
    do
    {
      return;
      this._PlaylistListView.Refresh();
    } while (((paramBoolean1) && (IsPlaylistVisible())) || ((!paramBoolean1) && (!IsPlaylistVisible())));
    if (paramBoolean2)
    {
      if (paramBoolean1)
      {
        this._PlaylistTray.animateOpen();
        return;
      }
      this._PlaylistTray.animateClose();
      return;
    }
    if (paramBoolean1)
    {
      this._PlaylistTray.open();
      return;
    }
    this._PlaylistTray.close();
  }
  
  private void doPauseResume()
  {
    try
    {
      if (this._Service != null)
      {
        if (this._Service.isPlaying()) {
          this._Service.pause();
        }
        for (;;)
        {
          refreshNow();
          setPauseButtonImage();
          return;
          this._Service.startAndFadeIn();
        }
      }
      return;
    }
    catch (RemoteException localRemoteException) {}
  }
  
  private int getTimetoSleep()
  {
    if (this._Service == null) {
      return 0;
    }
    try
    {
      int i = this._Service.gettimetosleep();
      return i;
    }
    catch (RemoteException localRemoteException) {}
    return 0;
  }
  
  private void queueNextRefresh(long paramLong)
  {
    if (!this._Paused)
    {
      Message localMessage = this._Handler.obtainMessage(1);
      this._Handler.removeMessages(1);
      this._Handler.sendMessageDelayed(localMessage, paramLong);
    }
  }
  
  private long refreshNow()
  {
    if (this._Service == null) {
      return 500L;
    }
    for (;;)
    {
      try
      {
        long l1;
        long l2;
        float f;
        if (this._NotificationId != -1)
        {
          this._SleepIcon.setVisibility(4);
          this._SleepText.setVisibility(0);
          this._SleepTimeImage.setVisibility(8);
          this._SleepText.setText(this._NotificationId);
          if (SystemClock.elapsedRealtime() - this._NotificationOnTime > 2000L) {
            this._NotificationId = -1;
          }
          if (this._PosOverride >= 0L) {
            continue;
          }
          l1 = this._Service.position();
          l2 = 1000L - l1 % 1000L;
          localObject = CurrentTrack();
          if ((l1 < 0L) || (this._Duration <= 0L) || (localObject == null)) {
            continue;
          }
          localObject = CoreHelper.FormatTimeAsString(l1 / 1000L, true);
          this._CurrentTime.setText((CharSequence)localObject);
          f = this._Service.getCurrentPlaybackSpeed();
          if (!shouldShowPlaybckSpeedControls()) {
            continue;
          }
          this._PlaybackSpeed.setVisibility(0);
          str2 = "";
          localObject = str2;
          if (mobi.beyondpod.rsscore.Configuration.DBGShowPlayerType() != 0)
          {
            localObject = str2;
            if (this._Service == null) {}
          }
        }
        switch (PlayerType())
        {
        default: 
          this._PlaybackSpeed.setText(this._PlaybackSpeedFormat.format(f) + (String)localObject);
          this._PlaybackSpeedExtender.setVisibility(this._PlaybackSpeed.getVisibility());
          updateRemainigTime(l1);
          if (this._Service.isPlaying())
          {
            this._CurrentTime.setVisibility(0);
            updateProgress((int)(1000L * l1 / this._Duration));
            return l2;
            i = getTimetoSleep();
            if (i != 0)
            {
              this._SleepIcon.setVisibility(0);
              this._SleepText.setVisibility(0);
              this._SleepIcon.setAlpha(255);
              if (i > 0)
              {
                this._SleepText.setText(Integer.toString(i));
                this._SleepText.setVisibility(0);
                this._SleepTimeImage.setVisibility(4);
                continue;
              }
              this._SleepText.setVisibility(4);
              this._SleepTimeImage.setVisibility(0);
              this._SleepText.setCompoundDrawables(null, getContext().getResources().getDrawable(2130838003), null, null);
              continue;
            }
            this._SleepText.setVisibility(4);
            this._SleepTimeImage.setVisibility(4);
            this._SleepIcon.setAlpha(112);
            localObject = this._SleepIcon;
            if (!PlayList.IsEmpty()) {
              break label730;
            }
            i = 4;
            ((ImageView)localObject).setVisibility(i);
            continue;
            l1 = this._PosOverride;
            continue;
            this._PlaybackSpeed.setVisibility(8);
            continue;
          }
          i = this._CurrentTime.getVisibility();
          localObject = this._CurrentTime;
          if (this._PosOverride >= 0L) {
            break label783;
          }
          if (i != 4) {
            break label788;
          }
          break label783;
          ((TextView)localObject).setVisibility(i);
          l2 = 500L;
          continue;
          if ((l1 < 0L) && (localObject != null) && ((((Track)localObject).getCurrentPlayState() == -1) || (((Track)localObject).getCurrentPlayState() == 0) || (((Track)localObject).getCurrentPlayState() == 2)))
          {
            CoreHelper.WriteTraceEntry(TAG, "Found that playback service has not yet loaded the current episode (" + localObject + "), State:" + ((Track)localObject).getCurrentPlayState() + ")! Loading now...");
            this._CurrentTime.setText("...");
            updateProgress(-1);
            this._PlaybackSpeed.setVisibility(8);
            this._PlaybackSpeedExtender.setVisibility(8);
            CommandManager.CmdLoadCurrentTrack();
            return 2500L;
          }
          this._CurrentTime.setText("");
          updateProgress(-1);
          this._PlaybackSpeed.setVisibility(8);
          this._PlaybackSpeedExtender.setVisibility(8);
          return 1000L;
        }
      }
      catch (RemoteException localRemoteException)
      {
        Object localObject;
        String str2;
        return 500L;
      }
      localObject = str2;
      continue;
      label730:
      int i = 0;
      continue;
      String str1 = "u";
      continue;
      str1 = "a";
      continue;
      str1 = "p";
      continue;
      str1 = "v";
      continue;
      str1 = "s";
      continue;
      str1 = "m";
      continue;
      label783:
      i = 0;
      continue;
      label788:
      i = 4;
    }
  }
  
  private void scanBackward(int paramInt, long paramLong)
  {
    if (this._Service == null) {
      return;
    }
    if (paramInt == 0) {}
    for (;;)
    {
      try
      {
        this._StartSeekPos = this._Service.position();
        this._LastSeekEventTime = 0L;
        return;
      }
      catch (RemoteException localRemoteException)
      {
        long l2;
        long l1;
        return;
      }
      l2 = this._StartSeekPos - paramLong;
      l1 = l2;
      if (l2 < 0L)
      {
        this._StartSeekPos = 0L;
        l1 = l2 + this._StartSeekPos;
      }
      if ((paramLong - this._LastSeekEventTime > 250L) || (paramInt < 0))
      {
        this._Service.seek(l1);
        this._LastSeekEventTime = paramLong;
      }
      if (paramInt >= 0)
      {
        this._PosOverride = l1;
        refreshNow();
        return;
      }
      this._PosOverride = -1L;
      continue;
      if (paramLong < 5000L) {
        paramLong *= 10L;
      } else {
        paramLong = 50000L + (paramLong - 5000L) * 40L;
      }
    }
  }
  
  private void scanForward(int paramInt, long paramLong)
  {
    if (this._Service == null) {
      return;
    }
    if (paramInt == 0) {}
    for (;;)
    {
      try
      {
        this._StartSeekPos = this._Service.position();
        this._LastSeekEventTime = 0L;
        return;
      }
      catch (RemoteException localRemoteException)
      {
        long l2;
        long l3;
        long l1;
        return;
      }
      l2 = this._StartSeekPos + paramLong;
      l3 = this._Service.duration();
      l1 = l2;
      if (l2 >= l3)
      {
        this._StartSeekPos = (l3 - 1000L);
        l1 = this._StartSeekPos;
      }
      if ((paramLong - this._LastSeekEventTime > 250L) || (paramInt < 0))
      {
        this._Service.seek(l1);
        this._LastSeekEventTime = paramLong;
      }
      if (paramInt >= 0)
      {
        this._PosOverride = l1;
        refreshNow();
        return;
      }
      this._PosOverride = -1L;
      continue;
      if (paramLong < 5000L) {
        paramLong *= 10L;
      } else {
        paramLong = 50000L + (paramLong - 5000L) * 40L;
      }
    }
  }
  
  private void setPauseButtonImage()
  {
    for (;;)
    {
      try
      {
        if ((this._Service != null) && (this._Service.isPlaying()))
        {
          localImageButton = this._PlayPause;
          if (this._PlayPause.getTag() == null) {
            break label78;
          }
          i = 2130837918;
          localImageButton.setImageResource(i);
          return;
        }
        ImageButton localImageButton = this._PlayPause;
        if (this._PlayPause.getTag() != null)
        {
          i = 2130837925;
          localImageButton.setImageResource(i);
          return;
        }
      }
      catch (RemoteException localRemoteException)
      {
        return;
      }
      int i = 2130837924;
      continue;
      label78:
      i = 2130837917;
    }
  }
  
  private void setSleepTo(int paramInt)
  {
    if (this._Service == null) {
      return;
    }
    try
    {
      this._Service.gotosleepin(paramInt);
      refreshNow();
      return;
    }
    catch (RemoteException localRemoteException) {}
  }
  
  private void updateProgress(int paramInt)
  {
    if (paramInt < 0)
    {
      this._Progress.setProgress(0);
      this._ProgressThumb.mutate().setAlpha(0);
      return;
    }
    this._ProgressThumb.mutate().setAlpha(255);
    this._Progress.setProgress(paramInt);
  }
  
  private void updateRemainigTime(long paramLong)
  {
    TextView localTextView = this._TotalTime;
    if ((this._Duration <= 0L) || (this._Duration > 500000000L))
    {
      str = "";
      localTextView.setText(str);
      return;
    }
    if (this._Duration - paramLong > 1000L) {}
    for (String str = "-";; str = "")
    {
      str = str + CoreHelper.FormatTimeAsString((this._Duration - paramLong) / 1000L, true);
      break;
    }
  }
  
  private void updateTrackInfo()
  {
    for (;;)
    {
      int i;
      int j;
      boolean bool;
      Track localTrack;
      long l;
      try
      {
        Object localObject = this._AlbumArtHandler;
        i = this._Album.getWidth();
        j = this._Album.getHeight();
        if (!this._Album.hasBitmap()) {
          break label1059;
        }
        bool = false;
        ((AlbumArtHandler)localObject).updateAlbumArt(i, j, bool);
        localTrack = CurrentTrack();
        if (localTrack == null) {
          break label872;
        }
        if (this._PlaylistEmptyPlay != null) {
          this._PlaylistEmptyPlay.setVisibility(8);
        }
        if (!localTrack.HasDownloadStarted()) {
          break label1064;
        }
        i = 0;
        localObject = this._StreamableImage;
        if (i == 0) {
          break label1069;
        }
        j = 0;
        ((TextView)localObject).setVisibility(j);
        if ((localTrack.getCurrentPlayState() == 3) && (localTrack.HasUrl()) && (i != 0))
        {
          this._Duration = -1L;
          this._TotalTime.setText("");
          this._PrepareProgress.setVisibility(0);
          this._Progress.setSecondaryProgress(localTrack.getBufferedPercent() * 10);
          this._StreamableImage.setText(String.format(PREPARING_STREAM_S, new Object[] { Integer.valueOf(localTrack.getBufferedPercent()) }));
          this._Progress.setVisibility(0);
          return;
        }
        this._StreamableImage.setText(2131297204);
        this._PrepareProgress.setVisibility(8);
        localObject = null;
        if (localTrack.getParentFeed().HasUrl()) {
          localObject = DateTime.FormatDateTimeToday(localTrack.getLastModifiedDate());
        }
        if (localTrack.getCurrentPlayState() != 7) {
          break label498;
        }
        this._TrackName.setText(PLAYBACK_ERROR + "\n" + localTrack.DisplayName());
        if (this._TrackDescription != null)
        {
          this._TrackName.setText(localTrack.DisplayName());
          this._TrackDescription.setText(PLAYBACK_ERROR);
          if (this._Service == null) {
            break label835;
          }
          l = this._Service.duration();
          this._Duration = l;
          if (this._PosOverride >= 0L) {
            break label863;
          }
          if (this._Service == null) {
            break label849;
          }
          l = this._Service.position();
          updateRemainigTime(l);
          this._Progress.setSecondaryProgress(localTrack.getBufferedPercent() * 10);
          if (this._Service != null) {
            continue;
          }
          if (this._Duration <= 0L) {
            break label1075;
          }
          l = 1000L * l / this._Duration;
          updateProgress((int)l);
          this._PlaybackSpeed.setVisibility(8);
          continue;
        }
        this._TrackName.setText(PLAYBACK_ERROR + "\n" + localTrack.DisplayName());
      }
      catch (Exception localException)
      {
        CoreHelper.LogException(TAG, "Failed to update TrackInfo!", localException);
        return;
      }
      this._TrackDescription.setText("");
      continue;
      label498:
      if (localTrack.getCurrentPlayState() == 8)
      {
        if (this._TrackDescription != null)
        {
          this._TrackName.setText(localTrack.DisplayName());
          this._TrackDescription.setText(PLAYBACK_ERROR_STREAMING_DISABLED);
        }
        else
        {
          this._TrackName.setText(PLAYBACK_ERROR_STREAMING_DISABLED + "\n" + localTrack.DisplayName());
          this._TrackDescription.setText("");
        }
      }
      else if (localTrack.getCurrentPlayState() == 9)
      {
        this._TrackName.setText(PLAYBACK_ERROR_CANT_CAST + " - " + localTrack.DisplayName());
      }
      else
      {
        String str;
        if (StringUtils.IsNullOrEmpty(localException)) {
          str = "";
        }
        for (;;)
        {
          if (ChromecastDevice.IsConnected())
          {
            if (this._TrackDescription != null)
            {
              this._TrackDescription.setText(ChromecastUtils.buildCastingToTitle(null));
              this._TrackName.setText(localTrack.DisplayName() + str);
              break;
              str = " • " + str;
              continue;
            }
            this._TrackName.setText(ChromecastUtils.buildCastingToTitle(localTrack.DisplayName()));
            break;
          }
        }
        this._TrackName.setText(localTrack.DisplayName() + str);
        if (this._TrackDescription != null)
        {
          TextView localTextView = this._TrackDescription;
          if (StringUtils.IsNullOrEmpty(localTrack.TrackDescription())) {}
          for (str = localTrack.getParentFeed().getName();; str = localTrack.TrackDescription())
          {
            localTextView.setText(str);
            break;
          }
          label835:
          l = localTrack.getTotalTime() * 1000L;
          continue;
          label849:
          l = localTrack.getPlayedTime() * 1000L;
          continue;
          label863:
          l = this._PosOverride;
          continue;
          label872:
          this._Progress.setVisibility(4);
          if (this._TrackDescription != null) {
            this._TrackDescription.setText("");
          }
          this._Duration = -1L;
          this._TotalTime.setText("");
          this._StreamableImage.setVisibility(8);
          this._Progress.setSecondaryProgress(1000);
          this._PrepareProgress.setVisibility(8);
          if ((FeedRepository.RepositoryLoadState() == 2) || (FeedRepository.RepositoryLoadState() == 3))
          {
            if (PlayList.IsEmpty())
            {
              if (SmartPlaylistTemplate.IsConfigured())
              {
                this._TrackName.setText(2131296942);
                if (this._PlaylistEmptyPlay != null) {
                  this._PlaylistEmptyPlay.setVisibility(0);
                }
              }
              else
              {
                this._TrackName.setText(2131296943);
                if (this._PlaylistEmptyPlay != null) {
                  this._PlaylistEmptyPlay.setVisibility(8);
                }
              }
            }
            else
            {
              this._TrackName.setText(2131296944);
              if (this._PlaylistEmptyPlay != null) {
                this._PlaylistEmptyPlay.setVisibility(8);
              }
            }
          }
          else {
            this._TrackName.setText(2131296904);
          }
          return;
          label1059:
          bool = true;
          continue;
          label1064:
          i = 1;
          continue;
          label1069:
          j = 8;
          continue;
          label1075:
          l = 0L;
        }
      }
    }
  }
  
  public boolean AllowScrollLeftRightFor(float paramFloat1, float paramFloat2)
  {
    if (CoreHelper.ApiLevel() < 14) {}
    int i;
    int j;
    do
    {
      return true;
      int[] arrayOfInt = new int[2];
      this._Progress.getLocationInWindow(arrayOfInt);
      i = arrayOfInt[0];
      j = arrayOfInt[1];
    } while ((paramFloat1 < i) || (paramFloat1 > this._Progress.getWidth() + i) || (paramFloat2 < j) || (paramFloat2 > this._Progress.getHeight() + j));
    getParent().requestDisallowInterceptTouchEvent(true);
    return false;
  }
  
  public boolean CanScrollLeft()
  {
    return this._PosOverride >= 0L;
  }
  
  public boolean CanScrollRight()
  {
    return this._PosOverride >= 0L;
  }
  
  public TitleBarBase.TitleInfo GetViewTitle()
  {
    this._Title.PrimaryTitle = NOW_PLAYING;
    this._Title.SubTitle = String.valueOf(PlayList().PlaylistSize());
    return this._Title;
  }
  
  public boolean HandleContextMenu(MenuItem paramMenuItem)
  {
    if (IsPlaylistVisible()) {
      return this._PlaylistListView.onContextItemSelected(paramMenuItem);
    }
    return false;
  }
  
  public boolean HandleOptionsMenu(int paramInt, MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    case 5: 
    case 6: 
    default: 
      if (CommonMenuHandler.HandleCommonMenu(paramMenuItem, getContext())) {
        return true;
      }
      break;
    case 1: 
      this._Service = null;
      PlayerUtils.stopService(getContext());
      return true;
    case 2: 
      if (mobi.beyondpod.rsscore.Configuration.KeepCurrentEpisodeForClearPlaylist()) {}
      for (boolean bool = false;; bool = true)
      {
        CommandManager.CmdEmptyPlaylist(false, bool);
        return true;
      }
    case 7: 
      CommandManager.CmdOpenManagePlaylistView(true);
      return true;
    case 8: 
      if (UpdateAndDownloadManager.IsWorking())
      {
        CommandManager.CmdShowDownloadQueue();
        return true;
      }
      CommandManager.CmdDownloadAllInPlaylistManually(getContext());
      return true;
    case 3: 
      CommandManager.CmdPlaySmartPlayList(getContext());
      return true;
    case 4: 
      CommandManager.CmdPlayAllInCategory(getContext());
      return true;
    }
    return false;
  }
  
  public boolean IsActive()
  {
    return this._IsActive;
  }
  
  public boolean IsCurrentlyPlaying()
  {
    if (this._Service == null) {
      return false;
    }
    try
    {
      boolean bool = this._Service.isPlaying();
      return bool;
    }
    catch (RemoteException localRemoteException) {}
    return false;
  }
  
  public boolean IsEmpty()
  {
    return PlayList().CurrentTrack() == null;
  }
  
  public boolean IsPlaylistVisible()
  {
    return (this._PlaylistTray != null) && (this._PlaylistTray.isOpened());
  }
  
  void OnActivityDestroy()
  {
    DoCleanup();
    this._AlbumArtWorker.quit();
    this._Album.clearBitmap();
  }
  
  public void OnAfterActivate()
  {
    AnalyticsTracker.OnViewDisplayed("Player View");
    PlayerUtils.unbindFromService(getContext());
    this._Service = null;
    postDelayed(this._ServiceConnectionRunnable, 300L);
    BeyondPodApplication.MessageBus.Subscribe(this, RepositoryEvents.RepositoryEvent.class);
    BeyondPodApplication.MessageBus.Subscribe(this, PlayListEvents.PlayListEvent.class);
    ImageButton localImageButton = this._SkipToEnd;
    if (mobi.beyondpod.rsscore.Configuration.SkipToEndButtonClickType() == 3) {}
    for (int i = 8;; i = 0)
    {
      localImageButton.setVisibility(i);
      this._Owner.RefreshActiveViewTitle();
      TogglePlaylistInternal(mobi.beyondpod.rsscore.Configuration.PlayerPlaylistVisible(), false);
      if ((mobi.beyondpod.rsscore.Configuration.OrientationLock() == 3) && (getContext().getResources().getConfiguration().hardKeyboardHidden != 1) && (getContext().getResources().getConfiguration().orientation == 2))
      {
        this._Owner.setRequestedOrientation(0);
        Toast.makeText(getContext(), 2131296548, 0).show();
      }
      if (!this._Album.hasBitmap()) {
        updateTrackInfo();
      }
      this._IsActive = true;
      return;
    }
  }
  
  public void OnAfterDeactivate(boolean paramBoolean)
  {
    if (this._SleepTimerDialog != null) {
      this._SleepTimerDialog.dismiss();
    }
    if (this._SelectSpeedDialog != null) {
      this._SelectSpeedDialog.dismiss();
    }
    DoCleanup();
    if (mobi.beyondpod.rsscore.Configuration.OrientationLock() == 3) {
      this._Owner.setRequestedOrientation(-1);
    }
    this._IsActive = false;
  }
  
  public void OnBeforeActivate()
  {
    updateTrackInfo();
  }
  
  public void OnPlayListEvent(final PlayListEvents.PlayListEvent paramPlayListEvent)
  {
    this._Owner.runOnUiThread(new Runnable()
    {
      public void run()
      {
        if (paramPlayListEvent.Type == 1)
        {
          PlayerView.this.updateTrackInfo();
          PlayerView.this._PlaylistListView.RefreshTrack(PlayerView.this.PlayList().CurrentTrack());
          return;
        }
        if (paramPlayListEvent.Type == 0)
        {
          PlayerView.this._PlaylistListView.Refresh();
          return;
        }
        PlayerView.this._PlaylistListView.RefreshTrack(PlayerView.this.PlayList().CurrentTrack());
      }
    });
  }
  
  public void OnRepositoryEvent(RepositoryEvents.RepositoryEvent paramRepositoryEvent)
  {
    if (paramRepositoryEvent.Type == 11)
    {
      if (paramRepositoryEvent.Track != null)
      {
        if ((CurrentTrack() != null) && (CurrentTrack().equals(paramRepositoryEvent.Track))) {
          updateTrackInfo();
        }
        if ((this._PlaylistListView != null) && (IsPlaylistVisible())) {
          this._PlaylistListView.RefreshTrack(paramRepositoryEvent.Track);
        }
      }
      setPauseButtonImage();
    }
    if (paramRepositoryEvent.Type == 2) {
      CommandManager.CmdLoadCurrentTrack();
    }
  }
  
  public View PlayListView()
  {
    return this._PlaylistListView;
  }
  
  public void PrepareContextMenu(ContextMenu paramContextMenu, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    if (IsPlaylistVisible()) {
      this._PlaylistListView.onCreateContextMenu(paramContextMenu, null, paramContextMenuInfo);
    }
  }
  
  public boolean PrepareOptionsMenu(Menu paramMenu)
  {
    paramMenu.clear();
    int i;
    if (!PlayList.IsEmpty())
    {
      paramMenu.add(0, 2, 0, 2131296656).setIcon(2130837945);
      paramMenu.add(0, 7, 1, 2131297157).setIcon(2130837951);
      if (BeyondPodApplication.GetInstance().PlayList().HasEpisodesToDownload())
      {
        if (!UpdateAndDownloadManager.IsWorking()) {
          break label153;
        }
        i = 2131296646;
        paramMenu.add(0, 8, 2, i).setIcon(2130837950);
      }
    }
    if (SmartPlaylistTemplate.IsConfigured()) {
      paramMenu.add(0, 3, 3, 2131296692).setIcon(2130837966);
    }
    if ((ActionBarHelper.HasPermanentMenuKey()) && (CoreHelper.ApiLevel() <= 15)) {}
    for (boolean bool = false;; bool = true)
    {
      CommonMenuHandler.AddMoreMenuAt(paramMenu, 6, 161, bool);
      return true;
      label153:
      i = 2131296650;
      break;
    }
  }
  
  public SimpleMenu PreparePopupOptionsMenu()
  {
    SimpleMenu localSimpleMenu = new SimpleMenu(getContext(), this._Owner.ContentRoot().findViewById(2131230867));
    PrepareOptionsMenu(localSimpleMenu);
    return localSimpleMenu;
  }
  
  public void RefreshTitle()
  {
    this._Owner.RefreshActiveViewTitle();
  }
  
  public void TogglePlaylist(boolean paramBoolean)
  {
    if (this._PlaylistListView == null)
    {
      CommandManager.CmdOpenManagePlaylistView(false);
      return;
    }
    TogglePlaylistInternal(paramBoolean, true);
  }
  
  public boolean shouldShowPlaybckSpeedControls()
  {
    if (!mobi.beyondpod.rsscore.Configuration.EnableAudioPlugins()) {}
    while ((!CanChangePlaybackSpeed()) && (SupportsSpeedAlteration())) {
      return false;
    }
    return true;
  }
  
  private static class AlbumArtHandler
    extends Handler
  {
    int _RequestingTrack = 0;
    WeakReference<Handler> _UIHandler;
    
    public AlbumArtHandler(Looper paramLooper, Handler paramHandler)
    {
      super();
      this._UIHandler = new WeakReference(paramHandler);
    }
    
    private void sendMessageToUI(int paramInt, Bitmap paramBitmap)
    {
      Handler localHandler = (Handler)this._UIHandler.get();
      if (localHandler != null)
      {
        paramBitmap = localHandler.obtainMessage(paramInt, paramBitmap);
        localHandler.removeMessages(paramInt);
        localHandler.sendMessage(paramBitmap);
      }
    }
    
    public void handleMessage(Message paramMessage)
    {
      if ((paramMessage.what != 2) || (paramMessage.arg1 == 0) || (paramMessage.arg2 == 0)) {}
      Track localTrack;
      int i;
      do
      {
        return;
        localTrack = BeyondPodApplication.GetInstance().PlayList().CurrentTrack();
        if ((localTrack == null) || (StringUtils.IsNullOrEmpty(localTrack.TrackPath())))
        {
          this._RequestingTrack = 0;
          sendMessageToUI(4, null);
          return;
        }
        i = localTrack.TrackPath().hashCode();
      } while (this._RequestingTrack == i);
      Bitmap localBitmap2 = ImageUtils.LoadEpisodeImage(localTrack, paramMessage.arg1, paramMessage.arg2);
      Bitmap localBitmap1 = localBitmap2;
      if (localBitmap2 == null) {
        localBitmap1 = FeedImageCache.GetSizedFeedImageFor(localTrack.getParentFeed(), paramMessage.arg1, paramMessage.arg2);
      }
      paramMessage = localBitmap1;
      if (localBitmap1 == null) {}
      try
      {
        paramMessage = new BitmapFactory.Options();
        paramMessage.inPreferredConfig = Bitmap.Config.ARGB_8888;
        paramMessage = BitmapFactory.decodeResource(BeyondPodApplication.GetInstance().getResources(), 2130837600, paramMessage);
        sendMessageToUI(3, paramMessage);
        this._RequestingTrack = i;
        return;
      }
      catch (OutOfMemoryError paramMessage)
      {
        for (;;)
        {
          CoreHelper.WriteLogEntry(PlayerView.TAG, "Unable to load episode artwork. OutOfMemory error!");
          paramMessage = localBitmap1;
        }
      }
    }
    
    public void updateAlbumArt(int paramInt1, int paramInt2, boolean paramBoolean)
    {
      if (paramBoolean) {
        this._RequestingTrack = 0;
      }
      removeMessages(2);
      obtainMessage(2, paramInt1, paramInt2, null).sendToTarget();
    }
  }
  
  public static abstract interface IPlayerOwner
  {
    public abstract void ActivatePlayer();
    
    public abstract ViewGroup ContentRoot();
    
    public abstract void RefreshActiveViewTitle();
    
    public abstract void runOnUiThread(Runnable paramRunnable);
    
    public abstract void setRequestedOrientation(int paramInt);
  }
  
  public static class Worker
    implements Runnable
  {
    private final Object mLock = new Object();
    private Looper mLooper;
    
    public Worker(String arg1)
    {
      ??? = new Thread(null, this, ???);
      ???.setPriority(1);
      ???.start();
      synchronized (this.mLock)
      {
        for (;;)
        {
          if (this.mLooper != null) {
            return;
          }
          try
          {
            this.mLock.wait();
          }
          catch (InterruptedException localInterruptedException) {}
        }
      }
    }
    
    public Looper getLooper()
    {
      return this.mLooper;
    }
    
    public void quit()
    {
      this.mLooper.quit();
    }
    
    public void run()
    {
      synchronized (this.mLock)
      {
        Looper.prepare();
        this.mLooper = Looper.myLooper();
        this.mLock.notifyAll();
        Looper.loop();
        return;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/views/PlayerView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */