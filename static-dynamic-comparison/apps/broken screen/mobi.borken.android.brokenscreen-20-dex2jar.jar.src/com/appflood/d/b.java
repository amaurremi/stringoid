package com.appflood.d;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnInfoListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnSeekCompleteListener;
import android.net.Uri;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import com.appflood.e.j;
import java.io.IOException;
import java.util.HashMap;

public final class b
  implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, SurfaceHolder.Callback
{
  private b a;
  private c b;
  private a c;
  private d d;
  private boolean e = false;
  private MediaPlayer.OnErrorListener f;
  private boolean g = false;
  private int h = 0;
  private MediaPlayer.OnCompletionListener i;
  private MediaPlayer.OnSeekCompleteListener j;
  private int k = 0;
  private int l = 0;
  private MediaPlayer m;
  private SurfaceHolder n;
  private Context o;
  private String p;
  
  public b(SurfaceView paramSurfaceView, String paramString)
  {
    this.p = paramString;
    this.n = paramSurfaceView.getHolder();
    this.n.addCallback(this);
    this.o = paramSurfaceView.getContext();
    this.n.setType(3);
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.b != null) {
      this.b.a(paramBoolean);
    }
  }
  
  public final void a(int paramInt)
  {
    if (this.m != null)
    {
      new StringBuilder("setCurrentposition ").append(paramInt).toString();
      j.a();
      this.m.seekTo(paramInt);
    }
  }
  
  public final void a(MediaPlayer.OnCompletionListener paramOnCompletionListener)
  {
    this.i = paramOnCompletionListener;
  }
  
  public final void a(MediaPlayer.OnErrorListener paramOnErrorListener)
  {
    this.f = paramOnErrorListener;
  }
  
  public final void a(MediaPlayer.OnSeekCompleteListener paramOnSeekCompleteListener)
  {
    this.j = paramOnSeekCompleteListener;
  }
  
  public final void a(a parama)
  {
    this.c = parama;
  }
  
  public final void a(b paramb)
  {
    this.a = paramb;
  }
  
  public final void a(c paramc)
  {
    this.b = paramc;
  }
  
  public final void a(d paramd)
  {
    this.d = paramd;
  }
  
  public final boolean a()
  {
    return this.g;
  }
  
  public final void b()
  {
    this.g = true;
  }
  
  public final void c()
  {
    if ((this.m != null) && (this.m.isPlaying()))
    {
      this.m.pause();
      new StringBuilder("pausedVideo ").append(this.m.isPlaying()).toString();
      j.a();
    }
  }
  
  public final void d()
  {
    if (this.m != null)
    {
      new StringBuilder("restart ").append(this.m.isPlaying()).toString();
      j.a();
      this.m.start();
      if (this.h > 0)
      {
        this.m.seekTo(this.h);
        this.h = 0;
      }
      this.g = false;
    }
  }
  
  public final boolean e()
  {
    if (this.m != null)
    {
      new StringBuilder("isPlaying ").append(this.m.isPlaying()).toString();
      j.a();
      return this.m.isPlaying();
    }
    return false;
  }
  
  public final int f()
  {
    if (this.m != null)
    {
      new StringBuilder("getDuration ").append(this.m.getDuration()).toString();
      j.a();
      return this.m.getDuration();
    }
    return 0;
  }
  
  public final int g()
  {
    if (this.m != null) {
      return this.m.getCurrentPosition();
    }
    return 0;
  }
  
  public final void h()
  {
    this.g = true;
    if (this.m != null)
    {
      this.m.stop();
      this.m.release();
      this.m = null;
    }
  }
  
  public final void onBufferingUpdate(MediaPlayer paramMediaPlayer, int paramInt)
  {
    new StringBuilder("onBufferingUpdate ").append(paramInt).append(" mpwwww  ").append(paramMediaPlayer.getVideoWidth()).append(" hhh ").append(paramMediaPlayer.getVideoHeight()).toString();
    j.a();
    this.k = paramMediaPlayer.getVideoWidth();
    this.l = paramMediaPlayer.getVideoHeight();
    paramInt = this.k;
    paramInt = this.l;
    if (this.d != null)
    {
      paramMediaPlayer = new HashMap();
      paramMediaPlayer.put("result_height", Integer.valueOf(this.l));
      paramMediaPlayer.put("result_width", Integer.valueOf(this.k));
      if ((!this.e) && (this.k > 0) && (this.l > 0))
      {
        paramMediaPlayer.put("result_code", Integer.valueOf(1));
        this.d.a(paramMediaPlayer);
        this.e = true;
      }
    }
  }
  
  public final boolean onInfo(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    new StringBuilder("onInfo             buffer what ").append(paramInt1).toString();
    j.a();
    switch (paramInt1)
    {
    }
    for (;;)
    {
      return false;
      j.a();
      if (this.c != null)
      {
        paramMediaPlayer = this.c;
        continue;
        if (this.c != null) {
          paramMediaPlayer = this.c;
        }
        j.a();
      }
    }
  }
  
  public final void onPrepared(MediaPlayer paramMediaPlayer)
  {
    this.k = paramMediaPlayer.getVideoWidth();
    this.l = paramMediaPlayer.getVideoHeight();
    new StringBuilder("Media player onPrepared ").append(this.k).toString();
    j.a();
    if ((this.l > 0) && (this.k > 0))
    {
      a(true);
      return;
    }
    a(false);
  }
  
  public final void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    new StringBuilder("Media player surface changed ").append(paramInt1).append(paramInt2).append(paramInt3).toString();
    j.a();
  }
  
  public final void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    
    try
    {
      if (j.a(this.p)) {
        return;
      }
      this.e = false;
      if (this.m != null) {
        this.m.reset();
      }
      if (this.m == null) {
        this.m = new MediaPlayer();
      }
      if ((this.h > 0) && (this.a != null)) {
        this.a.a(this.h);
      }
      this.m.setDataSource(this.o, Uri.parse(this.p));
      this.m.setDisplay(paramSurfaceHolder);
      this.m.setAudioStreamType(3);
      this.m.setOnPreparedListener(this);
      this.m.setOnBufferingUpdateListener(this);
      this.m.setOnInfoListener(this);
      this.m.setOnErrorListener(this.f);
      this.m.setOnCompletionListener(this.i);
      this.m.setOnSeekCompleteListener(this.j);
      this.m.prepareAsync();
      return;
    }
    catch (IllegalArgumentException paramSurfaceHolder)
    {
      paramSurfaceHolder.printStackTrace();
      return;
    }
    catch (SecurityException paramSurfaceHolder)
    {
      paramSurfaceHolder.printStackTrace();
      return;
    }
    catch (IllegalStateException paramSurfaceHolder)
    {
      paramSurfaceHolder.printStackTrace();
      return;
    }
    catch (IOException paramSurfaceHolder)
    {
      paramSurfaceHolder.printStackTrace();
    }
  }
  
  public final void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    
    if (this.m != null)
    {
      this.h = this.m.getCurrentPosition();
      this.m.stop();
    }
  }
  
  public static abstract interface a {}
  
  public static abstract interface b
  {
    public abstract void a(int paramInt);
  }
  
  public static abstract interface c
  {
    public abstract void a(boolean paramBoolean);
  }
  
  public static abstract interface d
  {
    public abstract void a(HashMap<String, Integer> paramHashMap);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/appflood/d/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */