package com.skplanet.tad.mraid.controller.util;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnInfoListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.MediaController;
import android.widget.ProgressBar;
import android.widget.VideoView;
import com.skplanet.tad.common.a;
import com.skplanet.tad.mraid.controller.MraidController.PlayerProperties;

public class MraidPlayer
  extends VideoView
  implements MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener
{
  private MraidController.PlayerProperties a;
  private AudioManager b = (AudioManager)getContext().getSystemService("audio");
  private MraidPlayerListener c;
  private String d;
  private FrameLayout e;
  private boolean f;
  
  public MraidPlayer(Context paramContext)
  {
    super(paramContext);
  }
  
  void a()
  {
    if ((this.a != null) && (this.a.showControl()))
    {
      MediaController localMediaController = new MediaController(getContext());
      setMediaController(localMediaController);
      localMediaController.setAnchorView(this);
    }
  }
  
  void b()
  {
    if (this.d == null)
    {
      if (this.c != null) {
        this.c.onError();
      }
      return;
    }
    this.d = MraidUtils.convert(this.d.trim());
    setVideoURI(Uri.parse(this.d));
    a();
    c();
  }
  
  void c()
  {
    setOnCompletionListener(this);
    setOnErrorListener(this);
    setOnPreparedListener(this);
    f();
    if ((this.a != null) && (this.a.isAutoPlay())) {
      start();
    }
  }
  
  void d()
  {
    if (this.b != null) {
      this.b.setStreamMute(3, false);
    }
  }
  
  void e()
  {
    ViewGroup localViewGroup = (ViewGroup)getParent();
    if (localViewGroup != null) {
      localViewGroup.removeView(this);
    }
  }
  
  void f()
  {
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
    this.e = new FrameLayout(getContext());
    this.e.setLayoutParams(localLayoutParams);
    this.e.addView(new ProgressBar(getContext()));
    ((ViewGroup)getParent()).addView(this.e);
  }
  
  void g()
  {
    if (this.e != null) {
      ((ViewGroup)getParent()).removeView(this.e);
    }
  }
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    a.c("MraidPlayer.onCompletion()");
    if (this.a != null)
    {
      if (this.a.doLoop()) {
        start();
      }
      while (!this.a.exitOnComplete()) {
        return;
      }
      releasePlayer();
      return;
    }
    releasePlayer();
  }
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    a.c("MraidPlayer.onError() what : " + paramInt1);
    g();
    e();
    if (this.c != null) {
      this.c.onError();
    }
    return false;
  }
  
  public boolean onInfo(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    a.c("MraidPlayer.onInfo() what : " + paramInt1);
    return false;
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 24) || (paramInt == 25)) {
      d();
    }
    return false;
  }
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    a.c("MraidPlayer.onPrepared()");
    g();
    if (this.c != null) {
      this.c.onPrepared();
    }
  }
  
  public void playAudio()
  {
    b();
  }
  
  public void playVideo()
  {
    if ((this.a != null) && (this.a.doMute())) {
      this.b.setStreamMute(3, true);
    }
    b();
  }
  
  public void releasePlayer()
  {
    if (this.f) {}
    do
    {
      return;
      this.f = true;
      stopPlayback();
      e();
      if ((this.a != null) && (this.a.doMute())) {
        d();
      }
    } while (this.c == null);
    this.c.onComplete();
  }
  
  public void setListener(MraidPlayerListener paramMraidPlayerListener)
  {
    this.c = paramMraidPlayerListener;
  }
  
  public void setPlayData(MraidController.PlayerProperties paramPlayerProperties, String paramString)
  {
    this.f = false;
    this.a = paramPlayerProperties;
    this.d = paramString;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/skplanet/tad/mraid/controller/util/MraidPlayer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */