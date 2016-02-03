package mobi.beyondpod.ui.views;

import android.annotation.TargetApi;
import android.app.AlertDialog.Builder;
import android.app.MediaRouteActionProvider;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View.OnSystemUiVisibilityChangeListener;
import android.view.Window;
import android.widget.ShareActionProvider;
import android.widget.Toast;
import java.util.List;
import mobi.beyondpod.BeyondPodApplication;
import mobi.beyondpod.rsscore.Feed;
import mobi.beyondpod.rsscore.Track;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.helpers.DateTime;
import mobi.beyondpod.rsscore.helpers.SimpleMessageBus;
import mobi.beyondpod.rsscore.helpers.StringUtils;
import mobi.beyondpod.rsscore.repository.FeedRepository;
import mobi.beyondpod.services.player.PlayList;
import mobi.beyondpod.services.player.PlayListEvents.PlayListEvent;
import mobi.beyondpod.services.player.impl.ChromecastDevice;
import mobi.beyondpod.ui.commands.CommandManager;
import mobi.beyondpod.ui.core.MovieViewCounter;
import mobi.beyondpod.ui.core.MusicUtils;
import mobi.beyondpod.ui.core.mediarouter.MediaRouteDiscoveryFragment;
import mobi.beyondpod.ui.core.mediarouter.MediaRouteDiscoveryFragment.IDiscoveryFragmentOwner;
import mobi.beyondpod.ui.views.base.BPMediaController;
import mobi.beyondpod.ui.views.base.BPMediaController.IViewOwner;

public class MovieView
  extends FragmentActivity
  implements BPMediaController.IViewOwner, MediaRouteDiscoveryFragment.IDiscoveryFragmentOwner
{
  private static final String TAG = "MovieView";
  private boolean _FinishOnCompletion;
  private boolean _IsCommandResume = false;
  int _LastSystemUiVis;
  BPMediaController _MediaController;
  private MovieViewControl _MovieViewControl;
  Track _Track;
  
  private static void ExecuteActionDeleteCurrentTrackIfAllowed(Track paramTrack)
  {
    if (paramTrack.AllowAutoDelete())
    {
      FeedRepository.DeleteTrackAsync(paramTrack);
      if (mobi.beyondpod.rsscore.Configuration.ForceMediaDatabaseRescanOnDownloadOrDelete()) {
        MusicUtils.ForceMediaScanFor(paramTrack.TrackPath());
      }
    }
  }
  
  private void ExecuteActionDoNothing()
  {
    BeyondPodApplication.MessageBus.PublishEvent(new PlayListEvents.PlayListEvent(PlayList(), 3));
    finish();
  }
  
  private void ExecuteActionPlayNextPosition(Track paramTrack)
  {
    CommandManager.CmdPlayNextTrack();
    finish();
  }
  
  private void ExecuteActionPlayPreviousPosition(Track paramTrack)
  {
    CommandManager.CmdPlayPreviousTrack();
    finish();
  }
  
  private void HandleServiceCommand(Intent paramIntent)
  {
    this._IsCommandResume = true;
    String str = paramIntent.getStringExtra("command");
    CoreHelper.WriteTraceEntry("MovieView", "===#####==== Received MediaButtonEvent! Command: " + str + " intent: " + paramIntent);
    if ("resume".equals(str)) {
      this._MovieViewControl.play();
    }
    do
    {
      return;
      if ("togglepause".equals(str))
      {
        this._MediaController.DoPlayPause();
        return;
      }
      if ("pause".equals(str))
      {
        this._MovieViewControl.pause();
        return;
      }
      if ("stop".equals(str))
      {
        this._MovieViewControl.stop();
        return;
      }
      if ("skiptoend".equals(str))
      {
        this._MediaController.DoSkipToEnd();
        return;
      }
      if ("skipforward".equals(str))
      {
        this._MediaController.DoSkipForward();
        return;
      }
      if ("skipbackword".equals(str))
      {
        this._MediaController.DoSkipBack();
        return;
      }
      if ("playnext".equals(str))
      {
        GoToNextTrack();
        return;
      }
    } while (!"playprevious".equals(str));
    GoToPreviousTrack();
  }
  
  private void LoadCurrentTrackFromIntent(Intent paramIntent)
  {
    this._Track = FeedRepository.GetTrackByPath(paramIntent.getAction());
    if (this._Track == null) {
      finish();
    }
    paramIntent = null;
    if (this._Track.getParentFeed().HasUrl()) {
      paramIntent = DateTime.FormatDateTime(this._Track.getLastModifiedDate());
    }
    BPMediaController localBPMediaController = this._MediaController;
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf(this._Track.DisplayName()));
    if (StringUtils.IsNullOrEmpty(paramIntent)) {}
    for (paramIntent = "";; paramIntent = " • " + paramIntent)
    {
      localBPMediaController.setTitle(paramIntent, this._Track.getParentFeed().getName());
      return;
    }
  }
  
  private void LockInLandscapeIfNeeded()
  {
    if ((mobi.beyondpod.rsscore.Configuration.OrientationLock() == 3) && (getResources().getConfiguration().hardKeyboardHidden != 1) && (getResources().getConfiguration().orientation == 2)) {
      setRequestedOrientation(0);
    }
  }
  
  private static PlayList PlayList()
  {
    return BeyondPodApplication.GetInstance().PlayList();
  }
  
  private static void PlayTrackInternal(Track paramTrack)
  {
    CommandManager.CmdPlayTrack(BeyondPodApplication.GetInstance().getApplicationContext(), paramTrack);
  }
  
  public void DoPause()
  {
    this._MovieViewControl.pause();
  }
  
  public void DoStart()
  {
    this._MovieViewControl.play();
  }
  
  public void GoToNextTrack()
  {
    this._MovieViewControl.stop();
    ExecuteActionPlayNextPosition(this._Track);
  }
  
  public void GoToPreviousTrack()
  {
    this._MovieViewControl.stop();
    ExecuteActionPlayPreviousPosition(this._Track);
  }
  
  public void HandleEndOfPlaybackFor(Track paramTrack)
  {
    if (paramTrack == null) {
      return;
    }
    CoreHelper.WriteTraceEntry("MovieView", "===#####==== Completed the playback of video: " + paramTrack.DisplayName());
    PlayList().OnTrackPlaybackComplete(false);
    finish();
  }
  
  public void HideNavigation()
  {
    setNavVisibility(false);
  }
  
  public void RequestCloseView()
  {
    finish();
  }
  
  public void ShowNavigation()
  {
    setNavVisibility(true);
  }
  
  public void SkipToEnd()
  {
    this._MovieViewControl.SkipToEnd();
    HandleEndOfPlaybackFor(this._Track);
  }
  
  public void onConfigurationChanged(android.content.res.Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    LockInLandscapeIfNeeded();
  }
  
  public void onConnectedToDevice(String paramString)
  {
    Toast.makeText(this, getResources().getString(2131297088, new Object[] { paramString }), 1).show();
    finish();
  }
  
  public void onConnectionRefused()
  {
    Toast.makeText(this, 2131297091, 1).show();
  }
  
  @TargetApi(11)
  public void onCreate(Bundle paramBundle)
  {
    getWindow().addFlags(0x80000 | 0x400000);
    super.onCreate(paramBundle);
    MovieViewCounter.AddInstance();
    if (!FeedRepository.IsRepositoryAvailable())
    {
      CoreHelper.WriteTraceEntry("MovieView", "Closing view because the repository is not Loaded");
      finish();
      return;
    }
    paramBundle = getIntent();
    setContentView(2130903136);
    this._MediaController = ((BPMediaController)findViewById(2131231101));
    this._MediaController.Initialize(this);
    if (CoreHelper.ApiLevel() > 10) {
      this._MediaController.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener()
      {
        public void onSystemUiVisibilityChange(int paramAnonymousInt)
        {
          int i = MovieView.this._LastSystemUiVis;
          MovieView.this._LastSystemUiVis = paramAnonymousInt;
          if ((((i ^ paramAnonymousInt) & 0x2) != 0) && ((paramAnonymousInt & 0x2) == 0)) {
            MovieView.this._MediaController.show(3000L);
          }
        }
      });
    }
    LoadCurrentTrackFromIntent(paramBundle);
    FragmentManager localFragmentManager = getSupportFragmentManager();
    if (localFragmentManager.findFragmentByTag("DiscoveryFragment") == null)
    {
      MediaRouteDiscoveryFragment localMediaRouteDiscoveryFragment = new MediaRouteDiscoveryFragment();
      localMediaRouteDiscoveryFragment.setOwner(this);
      localMediaRouteDiscoveryFragment.setRouteSelector(BeyondPodApplication.GetInstance().ChromecastDevice().getRouteSelector());
      localFragmentManager.beginTransaction().add(localMediaRouteDiscoveryFragment, "DiscoveryFragment").commit();
    }
    this._MovieViewControl = new MovieViewControl(this._MediaController, this)
    {
      public void onCompletion(boolean paramAnonymousBoolean)
      {
        if ((MovieView.this._FinishOnCompletion) && (paramAnonymousBoolean) && (!PlaybackFailed()))
        {
          this._CurrentTrack.MarkPlayed();
          MovieView.this.HandleEndOfPlaybackFor(this._CurrentTrack);
        }
      }
      
      public boolean onError(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        super.onError(paramAnonymousMediaPlayer, paramAnonymousInt1, paramAnonymousInt2);
        paramAnonymousInt1 = 0;
        if (paramAnonymousInt2 == 64532) {
          paramAnonymousInt1 = 1;
        }
        paramAnonymousMediaPlayer = new AlertDialog.Builder(MovieView.this);
        if (paramAnonymousInt1 != 0)
        {
          paramAnonymousInt2 = 2131296725;
          paramAnonymousMediaPlayer.setMessage(paramAnonymousInt2);
          if (paramAnonymousInt1 == 0) {
            break label156;
          }
        }
        label156:
        for (paramAnonymousInt2 = 2131296724;; paramAnonymousInt2 = 2131296722)
        {
          paramAnonymousMediaPlayer.setTitle(paramAnonymousInt2);
          paramAnonymousMediaPlayer.setPositiveButton(2131296752, new DialogInterface.OnClickListener()
          {
            public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              MovieView.this.finish();
            }
          });
          if (paramAnonymousInt1 == 0)
          {
            paramAnonymousMediaPlayer.setNegativeButton(2131296756, new DialogInterface.OnClickListener()
            {
              public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                CommandManager.CmdStartHtmlViewActivity(mobi.beyondpod.rsscore.Configuration.FAQVideoPlayerHelpURL(), "BeyondPod FAQ", false);
                MovieView.this.finish();
              }
            });
            if (CoreHelper.GetExternalPlayersFor(MovieView.this._Track.TrackPath(), "video/*").size() > 1) {
              paramAnonymousMediaPlayer.setNeutralButton(2131296755, new DialogInterface.OnClickListener()
              {
                public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  CommandManager.CmdOpenExternalPlayer(MovieView.this, MovieView.this._Track);
                  MovieView.this.finish();
                }
              });
            }
          }
          paramAnonymousMediaPlayer.setOnCancelListener(new DialogInterface.OnCancelListener()
          {
            public void onCancel(DialogInterface paramAnonymous2DialogInterface)
            {
              MovieView.this.finish();
            }
          });
          paramAnonymousMediaPlayer.show();
          return true;
          paramAnonymousInt2 = 2131296723;
          break;
        }
      }
      
      public void onPrepared(MediaPlayer paramAnonymousMediaPlayer)
      {
        super.onPrepared(paramAnonymousMediaPlayer);
        CoreHelper.WriteTraceEntry("MovieView", "Movie Prepared!");
      }
    };
    if (paramBundle.hasExtra("android.intent.extra.screenOrientation"))
    {
      int i = paramBundle.getIntExtra("android.intent.extra.screenOrientation", -1);
      if (i != getRequestedOrientation()) {
        setRequestedOrientation(i);
      }
    }
    if (mobi.beyondpod.rsscore.Configuration.OrientationLock() == 2) {
      setRequestedOrientation(0);
    }
    for (;;)
    {
      this._FinishOnCompletion = paramBundle.getBooleanExtra("android.intent.extra.finishOnCompletion", true);
      getWindow().setVolumeControlStream(3);
      this._MediaController.HideNavigationDelayed(3000L);
      this._MovieViewControl.PlayTrack(this._Track);
      return;
      if (mobi.beyondpod.rsscore.Configuration.OrientationLock() == 1) {
        setRequestedOrientation(1);
      } else {
        LockInLandscapeIfNeeded();
      }
    }
  }
  
  protected void onDestroy()
  {
    if (this._MovieViewControl != null) {
      this._MovieViewControl.stop();
    }
    MovieViewCounter.RemoveInstance();
    super.onDestroy();
  }
  
  public void onDisconnectFromDevice() {}
  
  public void onIncompatiblePlayServices()
  {
    ChromecastDevice.checkGooglePlaySevices(this, true);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && ((!this._MovieViewControl.IsPlaying()) || (!this._MediaController.isVisible())))
    {
      finish();
      return true;
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (this._MovieViewControl.IsPlaying()) && (this._MediaController.isVisible()))
    {
      this._MediaController.HideNavigationDelayed(100L);
      return true;
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    if ("mobi.beyondpod.services.musicservicecommand".equals(paramIntent.getAction())) {
      HandleServiceCommand(paramIntent);
    }
    for (;;)
    {
      super.onNewIntent(paramIntent);
      return;
      LoadCurrentTrackFromIntent(paramIntent);
      this._MovieViewControl.PlayTrack(this._Track);
    }
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
      return false;
    }
    RequestCloseView();
    return true;
  }
  
  public void onPause()
  {
    this._MovieViewControl.onPause();
    super.onPause();
  }
  
  @TargetApi(16)
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    paramMenu.clear();
    if (CoreHelper.ApiLevel() > 15) {
      paramMenu.add("Media Route").setActionProvider(new MediaRouteActionProvider(this)).setShowAsAction(2);
    }
    Object localObject = PlayList().CurrentTrack();
    if ((CoreHelper.ApiLevel() > 13) && (localObject != null))
    {
      localObject = CommandManager.BuildShareEpisodeIntent(this, (Track)localObject);
      if (localObject != null)
      {
        ShareActionProvider localShareActionProvider = new ShareActionProvider(this);
        localShareActionProvider.setShareHistoryFileName("share_history.xml");
        localShareActionProvider.setShareIntent((Intent)localObject);
        paramMenu.add(2131296671).setActionProvider(new ShareActionProvider(this)).setShowAsAction(2);
      }
    }
    return true;
  }
  
  protected void onResume()
  {
    super.onResume();
    this._MediaController.show(3000L);
  }
  
  protected void onStop()
  {
    this._MovieViewControl.onVideoWindowHidden(mobi.beyondpod.rsscore.Configuration.PauseVideoOnScreenOff());
    super.onStop();
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    if (paramBoolean) {
      this._MovieViewControl.onResume(this._IsCommandResume);
    }
    this._IsCommandResume = false;
  }
  
  @TargetApi(11)
  void setNavVisibility(boolean paramBoolean)
  {
    CoreHelper.WriteTraceEntry("MovieView", "Set Nav Visibility to:" + paramBoolean);
    if (CoreHelper.ApiLevel() > 10)
    {
      int i = 1792;
      if (!paramBoolean) {
        i = 0x700 | 0x7;
      }
      this._MediaController.setSystemUiVisibility(i);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/views/MovieView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */