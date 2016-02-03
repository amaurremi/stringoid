package com.skplanet.tad.videoplayer.activity.core;

import android.app.Activity;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnInfoListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import com.skplanet.tad.videoplayer.util.b;

public class d
{
  public static String L = "LG-SU760";
  public Activity M;
  public Resources N;
  public MediaPlayer O;
  public TadSurfaceView P;
  public SurfaceHolder Q;
  public String R;
  public int S = 0;
  public int T = 0;
  public boolean U = true;
  public boolean V = false;
  public boolean W = false;
  public boolean X = false;
  SurfaceHolder.Callback Y = new SurfaceHolder.Callback()
  {
    public void surfaceChanged(SurfaceHolder paramAnonymousSurfaceHolder, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
    {
      b.a("surfaceChanged/ width= " + paramAnonymousInt2 + "/ height= " + paramAnonymousInt3);
      if (d.this.U)
      {
        d.this.U = false;
        d.this.a(d.this.R);
      }
      if (!d.this.U) {
        d.this.o();
      }
    }
    
    public void surfaceCreated(SurfaceHolder paramAnonymousSurfaceHolder)
    {
      b.a("surfaceCreated");
    }
    
    public void surfaceDestroyed(SurfaceHolder paramAnonymousSurfaceHolder)
    {
      b.a("surfaceDestroyed");
      d.this.s();
      d.this.M.finish();
    }
  };
  MediaPlayer.OnErrorListener Z = new MediaPlayer.OnErrorListener()
  {
    public boolean onError(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      b.a("onError-what:" + paramAnonymousInt1 + ",extra:" + paramAnonymousInt2);
      if (paramAnonymousInt1 != -38)
      {
        d.this.d(1);
        d.this.i();
        d.this.s();
        d.this.M.finish();
      }
      return false;
    }
  };
  MediaPlayer.OnCompletionListener aa = new MediaPlayer.OnCompletionListener()
  {
    public void onCompletion(MediaPlayer paramAnonymousMediaPlayer)
    {
      d.this.X = false;
      b.a("onCompletion");
      if (paramAnonymousMediaPlayer != null) {
        d.this.T = paramAnonymousMediaPlayer.getDuration();
      }
      d.this.V = true;
      d.this.j();
    }
  };
  MediaPlayer.OnBufferingUpdateListener ab = new MediaPlayer.OnBufferingUpdateListener()
  {
    public void onBufferingUpdate(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt)
    {
      if (paramAnonymousInt < 100) {
        b.a("onBufferingUpdate percent: " + paramAnonymousInt);
      }
      b.a("onBufferingUpdate percent: " + paramAnonymousInt);
      if (!d.this.W)
      {
        d.this.c(paramAnonymousInt);
        paramAnonymousMediaPlayer = d.this;
        if (paramAnonymousInt != 100) {
          break label105;
        }
      }
      label105:
      for (boolean bool = true;; bool = false)
      {
        paramAnonymousMediaPlayer.W = bool;
        if ((paramAnonymousInt < 99) && (d.this.V)) {
          d.this.V = false;
        }
        return;
      }
    }
  };
  
  private void a(String paramString, int paramInt)
  {
    b.a("VideoPlayer--playVideo(String playUrl, int seekTime)");
    q();
    this.R = paramString;
    this.O.setAudioStreamType(3);
    this.O.setDisplay(this.Q);
    this.P.setMediaPlayer(this.O);
    try
    {
      this.O.setDataSource(this.M, Uri.parse(paramString));
      b.b("mediaPlayer.prepare()");
      this.O.prepare();
      b.a("VideoPlay -> playVideo seekTime: " + paramInt);
      if (paramInt > 0) {
        this.O.seekTo(paramInt);
      }
      this.O.start();
      this.V = false;
      if ((a.a()) && (this.O != null))
      {
        this.O.setVolume(0.0F, 0.0F);
        a.a(true);
      }
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      d(1);
      this.M.finish();
    }
  }
  
  private void b(String paramString)
  {
    b.a("VideoPlayer--playVideo");
    this.X = false;
    a(paramString, 0);
  }
  
  public void a(final String paramString)
  {
    b.a("VideoPlayer--playAd");
    this.X = false;
    c(0);
    f();
    new AsyncTask()
    {
      protected Integer a(Integer... paramAnonymousVarArgs)
      {
        d.a(d.this, paramString);
        d.this.X = false;
        return null;
      }
      
      protected void a(Integer paramAnonymousInteger)
      {
        super.onPostExecute(paramAnonymousInteger);
        d.this.g();
        if (2 == d.this.N.getConfiguration().orientation) {
          d.this.k();
        }
        d.this.h();
      }
    }.execute(new Integer[] { null, null, null });
  }
  
  protected void c(int paramInt) {}
  
  protected void d(int paramInt) {}
  
  protected void f() {}
  
  protected void f(int paramInt)
  {
    b.a("VideoPlayer--seek");
    if (this.O != null)
    {
      if (!Build.MODEL.contains(L)) {
        break label82;
      }
      this.O.seekTo(paramInt);
      if (!this.O.isPlaying())
      {
        this.O.reset();
        a(this.R, paramInt);
      }
    }
    for (;;)
    {
      b.a("surfaceView.setBackgroundColor(Color.TRANSPARENT)2");
      this.P.setBackgroundColor(0);
      this.V = false;
      this.X = false;
      return;
      label82:
      this.O.seekTo(paramInt);
      this.O.start();
    }
  }
  
  protected void g() {}
  
  protected void h() {}
  
  protected void i() {}
  
  protected void j() {}
  
  protected void k() {}
  
  protected void o() {}
  
  protected void p()
  {
    this.P = new TadSurfaceView(this.M);
    this.Q = this.P.getHolder();
    this.Q.addCallback(this.Y);
    this.Q.setType(3);
  }
  
  protected void q()
  {
    b.a("VideoPlayer--mediaCreate");
    this.W = false;
    if (this.O != null) {
      this.O.stop();
    }
    try
    {
      this.O.reset();
      this.O.release();
      this.O = null;
      this.O = new MediaPlayer();
      this.O.setOnErrorListener(this.Z);
      this.O.setOnCompletionListener(this.aa);
      this.O.setOnBufferingUpdateListener(this.ab);
      this.O.setOnPreparedListener(new MediaPlayer.OnPreparedListener()
      {
        public void onPrepared(MediaPlayer paramAnonymousMediaPlayer)
        {
          b.b("OnPreparedListener.onPrepared()");
        }
      });
      this.O.setOnInfoListener(new MediaPlayer.OnInfoListener()
      {
        public boolean onInfo(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          b.a("onInfo what :" + paramAnonymousInt1 + " / extra :" + paramAnonymousInt2);
          if ((paramAnonymousInt1 == 1) && (paramAnonymousInt2 == 44))
          {
            b.a("surfaceView.setBackgroundColor(Color.TRANSPARENT)1");
            d.this.P.setBackgroundColor(0);
          }
          if (paramAnonymousInt1 == 1) {
            b.a("what = " + paramAnonymousInt1 + " : MEDIA_INFO_UNKNOWN");
          }
          if (paramAnonymousInt1 == 700) {
            b.a("what = " + paramAnonymousInt1 + " : MEDIA_INFO_VIDEO_TRACK_LAGGING");
          }
          if (paramAnonymousInt1 == 701) {
            b.a("what = " + paramAnonymousInt1 + " : MEDIA_INFO_BUFFERING_START");
          }
          if (paramAnonymousInt1 == 702) {
            b.a("what = " + paramAnonymousInt1 + " : MEDIA_INFO_BUFFERING_END");
          }
          if (paramAnonymousInt1 == 800)
          {
            b.a("what = " + paramAnonymousInt1 + " : MEDIA_INFO_BAD_INTERLEAVING");
            d.this.d(1);
            d.this.i();
            d.this.s();
            d.this.M.finish();
          }
          if (paramAnonymousInt1 == 801) {
            b.a("what = " + paramAnonymousInt1 + " : MEDIA_INFO_NOT_SEEKABLE");
          }
          if (paramAnonymousInt1 == 802) {
            b.a("what = " + paramAnonymousInt1 + " : MEDIA_INFO_METADATA_UPDATE");
          }
          return false;
        }
      });
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  protected void r()
  {
    b.a("rePlay");
    if (this.O != null) {}
    for (;;)
    {
      try
      {
        String str = Build.MODEL;
        b.a("deviceName = " + Build.MODEL);
        if (!str.contains(L)) {
          continue;
        }
        b.a("if(deviceName.contains(LGSU760))");
        this.O.reset();
        b(this.R);
        this.V = false;
        b.a("surfaceView.setBackgroundColor(Color.TRANSPARENT)3");
        this.P.setBackgroundColor(0);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        continue;
      }
      this.X = false;
      return;
      b.a("else {");
      if (this.O.isPlaying())
      {
        b.a("if (mediaPlayer.isPlaying()) {");
        this.O.stop();
      }
      this.O.start();
      this.V = false;
      this.O.seekTo(0);
    }
  }
  
  protected void s()
  {
    b.a("mediaPlayer-stop");
    if (this.O != null)
    {
      this.O.stop();
      this.O.release();
      this.O = null;
    }
  }
  
  public void t()
  {
    if ((this.O != null) && (this.O.isPlaying())) {
      this.O.pause();
    }
  }
  
  public void u()
  {
    if (this.O != null) {
      this.O.start();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/skplanet/tad/videoplayer/activity/core/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */