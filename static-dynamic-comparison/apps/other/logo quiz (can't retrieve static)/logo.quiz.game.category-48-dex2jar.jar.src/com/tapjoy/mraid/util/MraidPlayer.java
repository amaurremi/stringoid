package com.tapjoy.mraid.util;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.VideoView;
import com.tapjoy.TapjoyLog;
import com.tapjoy.mraid.controller.Abstract.PlayerProperties;
import com.tapjoy.mraid.listener.Player;

public class MraidPlayer
  extends VideoView
  implements MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener
{
  private static String TAG = "MRAID Player";
  private static String transientText = "Loading. Please Wait..";
  private AudioManager aManager = (AudioManager)getContext().getSystemService("audio");
  private ImageButton closeImageButton;
  private String contentURL;
  private boolean isReleased;
  private Player listener;
  private int mutedVolume;
  private Abstract.PlayerProperties playProperties;
  private RelativeLayout transientLayout;
  
  public MraidPlayer(Context paramContext)
  {
    super(paramContext);
  }
  
  void addTransientMessage()
  {
    if (this.playProperties.inline) {
      return;
    }
    this.transientLayout = new RelativeLayout(getContext());
    this.transientLayout.setLayoutParams(getLayoutParams());
    TextView localTextView = new TextView(getContext());
    localTextView.setText(transientText);
    localTextView.setTextColor(-1);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(13);
    this.transientLayout.addView(localTextView, localLayoutParams);
    ((ViewGroup)getParent()).addView(this.transientLayout);
  }
  
  void clearTransientMessage()
  {
    if (this.transientLayout != null) {
      ((ViewGroup)getParent()).removeView(this.transientLayout);
    }
  }
  
  void displayControl()
  {
    if (this.playProperties.showControl())
    {
      MediaController localMediaController = new MediaController(getContext());
      setMediaController(localMediaController);
      localMediaController.setAnchorView(this);
    }
  }
  
  public ImageButton getCloseImageButton()
  {
    return this.closeImageButton;
  }
  
  void loadContent()
  {
    this.contentURL = this.contentURL.trim();
    this.contentURL = Utils.convert(this.contentURL);
    if ((this.contentURL == null) && (this.listener != null))
    {
      removeView();
      this.listener.onError();
      return;
    }
    setVideoURI(Uri.parse(this.contentURL));
    TapjoyLog.d("player", Uri.parse(this.contentURL).toString());
    displayControl();
    startContent();
  }
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    if (this.playProperties.doLoop()) {
      start();
    }
    while ((!this.playProperties.exitOnComplete()) && (!this.playProperties.inline)) {
      return;
    }
    releasePlayer();
  }
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    TapjoyLog.i(TAG, "Player error : " + paramInt1);
    clearTransientMessage();
    removeView();
    if (this.listener != null) {
      this.listener.onError();
    }
    return false;
  }
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    clearTransientMessage();
    if (this.listener != null) {
      this.listener.onPrepared();
    }
  }
  
  public void playAudio()
  {
    loadContent();
  }
  
  public void playVideo()
  {
    if (this.playProperties.doMute())
    {
      this.mutedVolume = this.aManager.getStreamVolume(3);
      this.aManager.setStreamVolume(3, 0, 4);
    }
    loadContent();
  }
  
  public void releasePlayer()
  {
    if (this.isReleased) {}
    do
    {
      return;
      this.isReleased = true;
      stopPlayback();
      removeView();
      if ((this.playProperties != null) && (this.playProperties.doMute())) {
        unMute();
      }
    } while (this.listener == null);
    this.listener.onComplete();
  }
  
  void removeView()
  {
    ViewGroup localViewGroup = (ViewGroup)getParent();
    if (localViewGroup != null) {
      localViewGroup.removeAllViews();
    }
  }
  
  public void setListener(Player paramPlayer)
  {
    this.listener = paramPlayer;
  }
  
  public void setPlayData(Abstract.PlayerProperties paramPlayerProperties, String paramString)
  {
    this.isReleased = false;
    this.playProperties = paramPlayerProperties;
    this.contentURL = paramString;
  }
  
  void startContent()
  {
    setOnCompletionListener(this);
    setOnErrorListener(this);
    setOnPreparedListener(this);
    if (!this.playProperties.inline) {
      addTransientMessage();
    }
    if (this.playProperties.isAutoPlay()) {
      start();
    }
  }
  
  void unMute()
  {
    this.aManager.setStreamVolume(3, this.mutedVolume, 4);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/tapjoy/mraid/util/MraidPlayer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */