package com.jirbo.adcolony;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.MediaController;
import android.widget.MediaController.MediaPlayerControl;
import java.io.FileDescriptor;
import java.io.IOException;

class e
  extends SurfaceView
  implements MediaController.MediaPlayerControl
{
  static final int e = -1;
  static final int f = 0;
  static final int g = 1;
  static final int h = 2;
  static final int i = 3;
  static final int j = 4;
  static final int k = 5;
  static final int l = 6;
  static final int m = 7;
  static final int n = 8;
  MediaPlayer.OnErrorListener A;
  int B;
  boolean C;
  boolean D;
  boolean E;
  boolean F;
  int G;
  MediaPlayer.OnVideoSizeChangedListener H = new MediaPlayer.OnVideoSizeChangedListener()
  {
    public void onVideoSizeChanged(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      e.this.s = paramAnonymousMediaPlayer.getVideoWidth();
      e.this.t = paramAnonymousMediaPlayer.getVideoHeight();
      if ((e.this.s != 0) && (e.this.t != 0)) {
        e.this.getHolder().setFixedSize(e.this.s, e.this.t);
      }
    }
  };
  MediaPlayer.OnPreparedListener I = new MediaPlayer.OnPreparedListener()
  {
    public void onPrepared(MediaPlayer paramAnonymousMediaPlayer)
    {
      e.this.o = 2;
      e locale1 = e.this;
      e locale2 = e.this;
      e.this.E = true;
      locale2.D = true;
      locale1.C = true;
      if (e.this.y != null) {
        e.this.y.onPrepared(e.this.r);
      }
      if (e.this.w != null) {
        e.this.w.setEnabled(true);
      }
      e.this.s = paramAnonymousMediaPlayer.getVideoWidth();
      e.this.t = paramAnonymousMediaPlayer.getVideoHeight();
      int i = e.this.B;
      if (i != 0) {
        e.this.seekTo(i);
      }
      if ((e.this.s != 0) && (e.this.t != 0))
      {
        e.this.getHolder().setFixedSize(e.this.s, e.this.t);
        if ((e.this.u == e.this.s) && (e.this.v == e.this.t))
        {
          if (e.this.p != 3) {
            break label249;
          }
          e.this.start();
          if (e.this.w != null) {
            e.this.w.show();
          }
        }
      }
      label249:
      while (e.this.p != 3)
      {
        do
        {
          return;
        } while ((e.this.isPlaying()) || ((i == 0) && (e.this.getCurrentPosition() <= 0)) || (e.this.w == null));
        e.this.w.show(0);
        return;
      }
      e.this.start();
    }
  };
  SurfaceHolder.Callback J = new SurfaceHolder.Callback()
  {
    public void surfaceChanged(SurfaceHolder paramAnonymousSurfaceHolder, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
    {
      int i = 1;
      e.this.u = paramAnonymousInt2;
      e.this.v = paramAnonymousInt3;
      if (e.this.p == 3)
      {
        paramAnonymousInt1 = 1;
        if ((e.this.s != paramAnonymousInt2) || (e.this.t != paramAnonymousInt3)) {
          break label134;
        }
      }
      label134:
      for (paramAnonymousInt2 = i;; paramAnonymousInt2 = 0)
      {
        if ((e.this.r != null) && (paramAnonymousInt1 != 0) && (paramAnonymousInt2 != 0))
        {
          if (e.this.B != 0) {
            e.this.seekTo(e.this.B);
          }
          e.this.start();
          if (e.this.w != null) {
            e.this.w.show();
          }
        }
        return;
        paramAnonymousInt1 = 0;
        break;
      }
    }
    
    public void surfaceCreated(SurfaceHolder paramAnonymousSurfaceHolder)
    {
      e.this.q = paramAnonymousSurfaceHolder;
      if ((e.this.r != null) && (e.this.o == 6) && (e.this.p == 7))
      {
        e.this.r.setDisplay(e.this.q);
        e.this.d();
        return;
      }
      e.a(e.this);
    }
    
    public void surfaceDestroyed(SurfaceHolder paramAnonymousSurfaceHolder)
    {
      e.this.q = null;
      if (e.this.w != null) {
        e.this.w.hide();
      }
      if (e.this.o != 6) {
        e.a(e.this, true);
      }
    }
  };
  private MediaPlayer.OnCompletionListener K = new MediaPlayer.OnCompletionListener()
  {
    public void onCompletion(MediaPlayer paramAnonymousMediaPlayer)
    {
      e.this.o = 5;
      e.this.p = 5;
      if (e.this.w != null) {
        e.this.w.hide();
      }
      if (e.this.x != null) {
        e.this.x.onCompletion(e.this.r);
      }
    }
  };
  private MediaPlayer.OnErrorListener L = new MediaPlayer.OnErrorListener()
  {
    public boolean onError(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      Log.d(e.this.a, "Error: " + paramAnonymousInt1 + "," + paramAnonymousInt2);
      e.this.o = -1;
      e.this.p = -1;
      if (e.this.w != null) {
        e.this.w.hide();
      }
      if ((e.this.A != null) && (e.this.A.onError(e.this.r, paramAnonymousInt1, paramAnonymousInt2))) {}
      while (e.this.getWindowToken() == null) {
        return true;
      }
      e.this.b().getResources();
      if (paramAnonymousInt1 == 200) {}
      for (paramAnonymousMediaPlayer = "Invalid progressive playback";; paramAnonymousMediaPlayer = "Unknown error")
      {
        new AlertDialog.Builder(e.this.b()).setTitle("ERROR").setMessage(paramAnonymousMediaPlayer).setPositiveButton("OKAY", new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            if (e.this.x != null) {
              e.this.x.onCompletion(e.this.r);
            }
          }
        }).setCancelable(false).show();
        return true;
      }
    }
  };
  private MediaPlayer.OnBufferingUpdateListener M = new MediaPlayer.OnBufferingUpdateListener()
  {
    public void onBufferingUpdate(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt)
    {
      e.this.z = paramAnonymousInt;
    }
  };
  String a = "ADCCustomVideoView";
  Uri b;
  FileDescriptor c;
  int d;
  int o = 0;
  int p = 0;
  SurfaceHolder q = null;
  MediaPlayer r = null;
  int s;
  int t;
  int u;
  int v;
  MediaController w;
  MediaPlayer.OnCompletionListener x;
  MediaPlayer.OnPreparedListener y;
  int z;
  
  e(Context paramContext)
  {
    super(paramContext);
    e();
  }
  
  public e(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    e();
  }
  
  public e(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    e();
  }
  
  e(Context paramContext, boolean paramBoolean)
  {
    super(paramContext);
    this.F = paramBoolean;
    e();
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.r != null)
    {
      this.r.reset();
      this.r.release();
      this.r = null;
      this.o = 0;
      if (paramBoolean) {
        this.p = 0;
      }
    }
  }
  
  private void e()
  {
    this.s = 0;
    this.t = 0;
    getHolder().addCallback(this.J);
    getHolder().setType(3);
    setFocusable(true);
    setFocusableInTouchMode(true);
    if (this.F) {
      requestFocus();
    }
    this.o = 0;
    this.p = 0;
  }
  
  private void f()
  {
    if (((this.b == null) && (this.c == null)) || (this.q == null)) {
      return;
    }
    Intent localIntent = new Intent("com.android.music.musicservicecommand");
    localIntent.putExtra("command", "pause");
    b().sendBroadcast(localIntent);
    a(false);
    try
    {
      this.r = new MediaPlayer();
      this.r.setOnPreparedListener(this.I);
      this.r.setOnVideoSizeChangedListener(this.H);
      this.d = -1;
      this.r.setOnCompletionListener(this.K);
      this.r.setOnErrorListener(this.L);
      this.r.setOnBufferingUpdateListener(this.M);
      this.z = 0;
      if (this.b != null)
      {
        this.r.setDataSource(b(), this.b);
        this.r.setDisplay(this.q);
        this.r.setAudioStreamType(3);
        this.r.setScreenOnWhilePlaying(true);
        this.r.prepare();
        this.o = 1;
        g();
        return;
      }
    }
    catch (IOException localIOException)
    {
      while (this.b != null)
      {
        Log.w(this.a, "Unable to open content: " + this.b, localIOException);
        this.o = -1;
        this.p = -1;
        this.L.onError(this.r, 1, 0);
        localIOException.printStackTrace();
        return;
        this.r.setDataSource(this.c);
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      if (this.b == null) {
        break label364;
      }
    }
    Log.w(this.a, "Unable to open content: " + this.b, localIllegalArgumentException);
    for (;;)
    {
      this.o = -1;
      this.p = -1;
      this.L.onError(this.r, 1, 0);
      localIllegalArgumentException.printStackTrace();
      return;
      Log.w(this.a, "Unable to open content");
      break;
      label364:
      Log.w(this.a, "Unable to open content");
    }
  }
  
  private void g()
  {
    if ((this.r != null) && (this.w != null))
    {
      this.w.setMediaPlayer(this);
      if (!(getParent() instanceof View)) {
        break label60;
      }
    }
    label60:
    for (Object localObject = (View)getParent();; localObject = this)
    {
      this.w.setAnchorView((View)localObject);
      this.w.setEnabled(i());
      return;
    }
  }
  
  private void h()
  {
    if (this.w.isShowing())
    {
      this.w.hide();
      return;
    }
    this.w.show();
  }
  
  private boolean i()
  {
    return (this.r != null) && (this.o != -1) && (this.o != 0) && (this.o != 1);
  }
  
  public int a(int paramInt1, int paramInt2)
  {
    int i1 = View.MeasureSpec.getMode(paramInt2);
    paramInt2 = View.MeasureSpec.getSize(paramInt2);
    switch (i1)
    {
    case 0: 
    default: 
      return paramInt1;
    case -2147483648: 
      return Math.min(paramInt1, paramInt2);
    }
    return paramInt2;
  }
  
  public void a()
  {
    if (this.r != null)
    {
      this.r.stop();
      this.r.release();
      this.r = null;
      this.o = 0;
      this.p = 0;
    }
  }
  
  public void a(MediaPlayer.OnCompletionListener paramOnCompletionListener)
  {
    this.x = paramOnCompletionListener;
  }
  
  public void a(MediaPlayer.OnErrorListener paramOnErrorListener)
  {
    this.A = paramOnErrorListener;
  }
  
  public void a(MediaPlayer.OnPreparedListener paramOnPreparedListener)
  {
    this.y = paramOnPreparedListener;
  }
  
  public void a(Uri paramUri)
  {
    this.b = paramUri;
    this.B = 0;
    f();
    requestLayout();
    invalidate();
  }
  
  public void a(MediaController paramMediaController)
  {
    if (this.w != null) {
      this.w.hide();
    }
    this.w = paramMediaController;
    g();
  }
  
  public void a(FileDescriptor paramFileDescriptor)
  {
    this.c = paramFileDescriptor;
    this.B = 0;
    f();
    requestLayout();
    invalidate();
  }
  
  public void a(String paramString)
  {
    a(Uri.parse(paramString));
  }
  
  Activity b()
  {
    return AdColony.activity();
  }
  
  public void c()
  {
    if (i())
    {
      this.r.stop();
      this.G = this.o;
      this.o = 6;
      this.p = 6;
    }
  }
  
  public boolean canPause()
  {
    return this.C;
  }
  
  public boolean canSeekBackward()
  {
    return this.D;
  }
  
  public boolean canSeekForward()
  {
    return this.E;
  }
  
  public void d()
  {
    if ((this.q == null) && (this.o == 6)) {
      this.p = 7;
    }
    do
    {
      return;
      if ((this.r != null) && (this.o == 6))
      {
        this.r.start();
        this.o = this.G;
        this.p = this.G;
        return;
      }
    } while (this.o != 8);
    f();
  }
  
  public int getAudioSessionId()
  {
    return 0;
  }
  
  public int getBufferPercentage()
  {
    if (this.r != null) {
      return this.z;
    }
    return 0;
  }
  
  public int getCurrentPosition()
  {
    if (i()) {
      return this.r.getCurrentPosition();
    }
    return 0;
  }
  
  public int getDuration()
  {
    if (i())
    {
      if (this.d > 0) {
        return this.d;
      }
      this.d = this.r.getDuration();
      return this.d;
    }
    this.d = -1;
    return this.d;
  }
  
  public boolean isPlaying()
  {
    return (i()) && (this.r.isPlaying());
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    int i1;
    if ((paramInt != 4) && (paramInt != 24) && (paramInt != 25) && (paramInt != 82) && (paramInt != 5) && (paramInt != 6)) {
      i1 = 1;
    }
    while ((i()) && (i1 != 0) && (this.w != null)) {
      if ((paramInt == 79) || (paramInt == 85))
      {
        if (this.r.isPlaying())
        {
          pause();
          this.w.show();
          return true;
          i1 = 0;
        }
        else
        {
          start();
          this.w.hide();
          return true;
        }
      }
      else
      {
        if ((paramInt != 86) || (!this.r.isPlaying())) {
          break label141;
        }
        pause();
        this.w.show();
      }
    }
    for (;;)
    {
      return super.onKeyDown(paramInt, paramKeyEvent);
      label141:
      h();
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i1 = getDefaultSize(this.s, paramInt1);
    int i2 = getDefaultSize(this.t, paramInt2);
    paramInt1 = i2;
    paramInt2 = i1;
    if (this.s > 0)
    {
      paramInt1 = i2;
      paramInt2 = i1;
      if (this.t > 0)
      {
        if (this.s * i2 <= this.t * i1) {
          break label80;
        }
        paramInt1 = this.t * i1 / this.s;
        paramInt2 = i1;
      }
    }
    for (;;)
    {
      setMeasuredDimension(paramInt2, paramInt1);
      return;
      label80:
      paramInt1 = i2;
      paramInt2 = i1;
      if (this.s * i2 < this.t * i1)
      {
        paramInt2 = this.s * i2 / this.t;
        paramInt1 = i2;
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((i()) && (this.w != null)) {
      h();
    }
    return false;
  }
  
  public boolean onTrackballEvent(MotionEvent paramMotionEvent)
  {
    if ((i()) && (this.w != null)) {
      h();
    }
    return false;
  }
  
  public void pause()
  {
    if ((i()) && (this.r.isPlaying()))
    {
      this.r.pause();
      this.o = 4;
    }
    this.p = 4;
  }
  
  public void seekTo(int paramInt)
  {
    if (i())
    {
      this.r.seekTo(paramInt);
      this.B = 0;
      return;
    }
    this.B = paramInt;
  }
  
  public void start()
  {
    if (i())
    {
      this.r.start();
      this.o = 3;
    }
    this.p = 3;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/jirbo/adcolony/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */