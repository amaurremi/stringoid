package com.google.ads.internal;

import android.app.Activity;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.MediaController;
import android.widget.VideoView;
import com.google.ads.m;
import com.google.ads.util.b;
import com.google.ads.util.f;
import com.google.ads.util.i.b;
import java.lang.ref.WeakReference;

public class AdVideoView
  extends FrameLayout
  implements MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener
{
  private static final a b = (a)a.a.b();
  public MediaController a;
  private final WeakReference<Activity> c;
  private final AdWebView d;
  private long e;
  private final VideoView f;
  private String g;
  
  public AdVideoView(Activity paramActivity, AdWebView paramAdWebView)
  {
    super(paramActivity);
    this.c = new WeakReference(paramActivity);
    this.d = paramAdWebView;
    this.f = new VideoView(paramActivity);
    paramActivity = new FrameLayout.LayoutParams(-1, -1, 17);
    addView(this.f, paramActivity);
    this.a = null;
    this.g = null;
    this.e = 0L;
    a();
    this.f.setOnCompletionListener(this);
    this.f.setOnPreparedListener(this);
    this.f.setOnErrorListener(this);
  }
  
  protected void a()
  {
    new a(this).a();
  }
  
  public void a(int paramInt)
  {
    this.f.seekTo(paramInt);
  }
  
  public void a(MotionEvent paramMotionEvent)
  {
    this.f.onTouchEvent(paramMotionEvent);
  }
  
  public void b()
  {
    if (!TextUtils.isEmpty(this.g))
    {
      this.f.setVideoPath(this.g);
      return;
    }
    b.a(this.d, "onVideoEvent", "{'event': 'error', 'what': 'no_src'}");
  }
  
  public void c()
  {
    this.f.pause();
  }
  
  public void d()
  {
    this.f.start();
  }
  
  public void e()
  {
    this.f.stopPlayback();
  }
  
  void f()
  {
    long l = this.f.getCurrentPosition();
    if (this.e != l)
    {
      float f1 = (float)l / 1000.0F;
      b.a(this.d, "onVideoEvent", "{'event': 'timeupdate', 'time': " + f1 + "}");
      this.e = l;
    }
  }
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    b.a(this.d, "onVideoEvent", "{'event': 'ended'}");
  }
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    b.e("Video threw error! <what:" + paramInt1 + ", extra:" + paramInt2 + ">");
    b.a(this.d, "onVideoEvent", "{'event': 'error', 'what': '" + paramInt1 + "', 'extra': '" + paramInt2 + "'}");
    return true;
  }
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    float f1 = this.f.getDuration() / 1000.0F;
    b.a(this.d, "onVideoEvent", "{'event': 'canplaythrough', 'duration': '" + f1 + "'}");
  }
  
  public void setMediaControllerEnabled(boolean paramBoolean)
  {
    Activity localActivity = (Activity)this.c.get();
    if (localActivity == null)
    {
      b.e("adActivity was null while trying to enable controls on a video.");
      return;
    }
    if (paramBoolean)
    {
      if (this.a == null) {
        this.a = new MediaController(localActivity);
      }
      this.f.setMediaController(this.a);
      return;
    }
    if (this.a != null) {
      this.a.hide();
    }
    this.f.setMediaController(null);
  }
  
  public void setSrc(String paramString)
  {
    this.g = paramString;
  }
  
  private static class a
    implements Runnable
  {
    private final WeakReference<AdVideoView> a;
    
    public a(AdVideoView paramAdVideoView)
    {
      this.a = new WeakReference(paramAdVideoView);
    }
    
    public void a()
    {
      ((Handler)m.a().c.a()).postDelayed(this, 250L);
    }
    
    public void run()
    {
      AdVideoView localAdVideoView = (AdVideoView)this.a.get();
      if (localAdVideoView == null)
      {
        b.d("The video must be gone, so cancelling the timeupdate task.");
        return;
      }
      localAdVideoView.f();
      ((Handler)m.a().c.a()).postDelayed(this, 250L);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/google/ads/internal/AdVideoView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */