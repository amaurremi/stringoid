package mobi.beyondpod.ui.dialogs;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;
import mobi.beyondpod.rsscore.Feed;
import mobi.beyondpod.ui.core.FeedImageCache;
import mobi.beyondpod.ui.views.PlayerView.Worker;
import mobi.beyondpod.ui.views.base.AlbumView;

public class PreviewPlayerControl
  implements MediaPlayer.OnErrorListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnPreparedListener
{
  private static final int ALBUM_ART_DECODED = 3;
  private static final String CMDNAME = "command";
  private static final String CMDPAUSE = "pause";
  private static final int GET_ALBUM_ART = 2;
  private static final String SERVICECMD = "com.android.music.musicservicecommand";
  AlbumView _Album;
  private AlbumArtHandler _AlbumArtHandler;
  private PlayerView.Worker _AlbumArtWorker;
  Context _Context;
  Feed _CurrentFeed;
  private final Handler _Handler = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      if (paramAnonymousMessage.what == 3)
      {
        PreviewPlayerControl.this._Album.setArtwork((Bitmap)paramAnonymousMessage.obj, false);
        PreviewPlayerControl.this._Album.invalidate();
      }
    }
  };
  boolean _IsAudio = false;
  private MediaController mMediaController;
  Runnable mPlayingChecker = new Runnable()
  {
    public void run()
    {
      if (PreviewPlayerControl.this.mVideoView.isPlaying())
      {
        PreviewPlayerControl.this.mProgressView.setVisibility(8);
        return;
      }
      PreviewPlayerControl.this._Handler.postDelayed(PreviewPlayerControl.this.mPlayingChecker, 250L);
    }
  };
  private int mPositionWhenPaused = -1;
  private final View mProgressView;
  private final Uri mUri;
  private final VideoView mVideoView;
  private boolean mWasPlayingWhenPaused = false;
  
  public PreviewPlayerControl(View paramView, Context paramContext, Uri paramUri, Feed paramFeed, int paramInt)
  {
    this._Context = paramContext;
    ((Activity)paramContext).setVolumeControlStream(3);
    this._AlbumArtWorker = new PlayerView.Worker("preview album art worker");
    this._AlbumArtHandler = new AlbumArtHandler(this._AlbumArtWorker.getLooper());
    this.mVideoView = ((VideoView)paramView.findViewById(2131231102));
    this.mProgressView = paramView.findViewById(2131231165);
    this.mUri = paramUri;
    this._Handler.postDelayed(this.mPlayingChecker, 250L);
    this.mVideoView.setOnErrorListener(this);
    this.mVideoView.setOnCompletionListener(this);
    this.mVideoView.setVideoURI(this.mUri);
    this.mVideoView.setOnPreparedListener(this);
    this.mMediaController = new MediaController(paramContext);
    this.mVideoView.setMediaController(this.mMediaController);
    this.mVideoView.requestFocus();
    paramUri = new Intent("com.android.music.musicservicecommand");
    paramUri.putExtra("command", "pause");
    paramContext.sendBroadcast(paramUri);
    this.mVideoView.start();
    this._Album = ((AlbumView)paramView.findViewById(2131231133));
    if (paramInt == 1) {}
    for (boolean bool = true;; bool = false)
    {
      this._IsAudio = bool;
      this._CurrentFeed = paramFeed;
      paramContext = (BitmapDrawable)paramContext.getResources().getDrawable(2130838062);
      paramContext.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
      if (!this._IsAudio) {
        break;
      }
      paramView = paramView.findViewById(2131231164);
      paramView.setVisibility(0);
      paramView.setBackgroundDrawable(paramContext);
      return;
    }
    paramView.setBackgroundDrawable(paramContext);
  }
  
  public void onCompletion() {}
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    onCompletion();
  }
  
  public void onDestroy()
  {
    this._AlbumArtWorker.quit();
  }
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    this._Handler.removeCallbacksAndMessages(null);
    this.mProgressView.setVisibility(8);
    return false;
  }
  
  public void onPause()
  {
    this._Handler.removeCallbacksAndMessages(null);
    this.mPositionWhenPaused = this.mVideoView.getCurrentPosition();
    this.mWasPlayingWhenPaused = this.mVideoView.isPlaying();
    this.mVideoView.stopPlayback();
  }
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    if (this._IsAudio)
    {
      this.mMediaController.show();
      this._AlbumArtHandler.SendSetCurrentArtMessage();
    }
  }
  
  public void onResume()
  {
    if (this.mPositionWhenPaused >= 0)
    {
      this.mVideoView.setVideoURI(this.mUri);
      this.mVideoView.seekTo(this.mPositionWhenPaused);
      this.mPositionWhenPaused = -1;
      if (this.mWasPlayingWhenPaused) {
        this.mMediaController.show(0);
      }
    }
  }
  
  private class AlbumArtHandler
    extends Handler
  {
    public AlbumArtHandler(Looper paramLooper)
    {
      super();
    }
    
    public void SendSetCurrentArtMessage()
    {
      removeMessages(2);
      obtainMessage(2).sendToTarget();
    }
    
    public void handleMessage(Message paramMessage)
    {
      if (paramMessage.what == 2)
      {
        if ((PreviewPlayerControl.this._Album.getWidth() != 0) && (PreviewPlayerControl.this._Album.getHeight() != 0)) {
          break label53;
        }
        removeMessages(2);
        sendMessageDelayed(obtainMessage(2), 500L);
      }
      label53:
      do
      {
        do
        {
          return;
          paramMessage = PreviewPlayerControl.this._Handler.obtainMessage(3, null);
          PreviewPlayerControl.this._Handler.removeMessages(3);
          PreviewPlayerControl.this._Handler.sendMessageDelayed(paramMessage, 300L);
        } while (PreviewPlayerControl.this._CurrentFeed == null);
        paramMessage = FeedImageCache.GetSizedFeedImageFor(PreviewPlayerControl.this._CurrentFeed, PreviewPlayerControl.this._Album.getWidth(), PreviewPlayerControl.this._Album.getHeight());
      } while (paramMessage == null);
      paramMessage = PreviewPlayerControl.this._Handler.obtainMessage(3, paramMessage);
      PreviewPlayerControl.this._Handler.removeMessages(3);
      PreviewPlayerControl.this._Handler.sendMessage(paramMessage);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/dialogs/PreviewPlayerControl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */