package com.jtpgodorncrqoeurl;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.VideoView;

public class AdPlayer
  extends VideoView
  implements MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener
{
  private static String g = "Loading. Please Wait..";
  private static String h = "AdOrmma Player";
  private AdController.PlayerProperties a;
  private AudioManager b = (AudioManager)getContext().getSystemService("audio");
  private AdPlayerListener c;
  private int d;
  private String e;
  private RelativeLayout f;
  private boolean i;
  
  public AdPlayer(Context paramContext)
  {
    super(paramContext);
    Log.d(h, "Initialized!!!");
  }
  
  private void a()
  {
    Log.d(h, "Content URL - " + this.e);
    this.e = this.e.trim();
    this.e = AdUtils.convert(this.e);
    if ((this.e == null) && (this.c != null))
    {
      b();
      this.c.onError();
    }
    do
    {
      return;
      setVideoURI(Uri.parse(this.e));
      Object localObject;
      if (this.a.showControl())
      {
        localObject = new MediaController(getContext());
        setMediaController((MediaController)localObject);
        ((MediaController)localObject).setAnchorView(this);
      }
      setOnCompletionListener(this);
      setOnErrorListener(this);
      setOnPreparedListener(this);
      if ((!this.a.inline) && (!this.a.inline))
      {
        this.f = new RelativeLayout(getContext());
        this.f.setLayoutParams(getLayoutParams());
        localObject = new TextView(getContext());
        ((TextView)localObject).setText(g);
        ((TextView)localObject).setTextColor(-1);
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        localLayoutParams.addRule(13);
        this.f.addView((View)localObject, localLayoutParams);
        ((ViewGroup)getParent()).addView(this.f);
      }
    } while (!this.a.isAutoPlay());
    start();
  }
  
  private void b()
  {
    ViewGroup localViewGroup = (ViewGroup)getParent();
    if (localViewGroup != null) {
      localViewGroup.removeView(this);
    }
  }
  
  private void c()
  {
    if (this.f != null) {
      ((ViewGroup)getParent()).removeView(this.f);
    }
  }
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    if (this.a.doLoop()) {
      start();
    }
    while ((!this.a.exitOnComplete()) && (!this.a.inline)) {
      return;
    }
    releasePlayer();
  }
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    Log.i(h, "Player error : " + paramInt1);
    c();
    b();
    if (this.c != null) {
      this.c.onError();
    }
    return false;
  }
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    c();
    if (this.c != null) {
      this.c.onPrepared();
    }
  }
  
  public void playAudio()
  {
    a();
  }
  
  public void playVideo()
  {
    if (this.a.doMute())
    {
      this.d = this.b.getStreamVolume(3);
      this.b.setStreamVolume(3, 0, 4);
    }
    a();
  }
  
  public void releasePlayer()
  {
    if (this.i) {}
    do
    {
      return;
      this.i = true;
      stopPlayback();
      b();
      if ((this.a != null) && (this.a.doMute())) {
        this.b.setStreamVolume(3, this.d, 4);
      }
    } while (this.c == null);
    this.c.onComplete();
  }
  
  public void setListener(AdPlayerListener paramAdPlayerListener)
  {
    this.c = paramAdPlayerListener;
  }
  
  public void setPlayData(AdController.PlayerProperties paramPlayerProperties, String paramString)
  {
    this.i = false;
    this.a = paramPlayerProperties;
    this.e = paramString;
    Log.d(h, "Setting data - " + this.e);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/rage meme camera free/com.troll.face-25-dex2jar.jar!/com/jtpgodorncrqoeurl/AdPlayer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */