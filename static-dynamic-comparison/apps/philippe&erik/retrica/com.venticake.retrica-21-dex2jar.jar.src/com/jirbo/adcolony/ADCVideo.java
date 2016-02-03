package com.jirbo.adcolony;

import android.app.Activity;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public abstract class ADCVideo
  extends Activity
{
  static int a;
  static int b;
  static int c;
  static boolean d;
  static boolean e;
  static boolean f;
  static boolean g;
  static Activity h;
  static boolean i;
  static boolean j;
  String A = "";
  boolean B = true;
  boolean C = true;
  e D;
  ae E;
  AdColonyAd F;
  VideoView G;
  FrameLayout H;
  FrameLayout I;
  FrameLayout J;
  Rect K = new Rect();
  ADCImage L;
  ADCVideo.a M;
  FileInputStream N;
  boolean k;
  boolean l;
  boolean m;
  boolean n;
  boolean o;
  double p;
  double q;
  long r;
  long s;
  int t;
  int u;
  int v;
  int w;
  int x;
  int y;
  int z;
  
  static void a()
  {
    a = 0;
    d = false;
    e = false;
    g = false;
  }
  
  void a(String paramString)
  {
    this.A = paramString;
    g = true;
    this.G = new VideoView(this);
    paramString = Uri.parse(paramString);
    this.G.setVideoURI(paramString);
    new MediaController(this).setMediaPlayer(this.G);
    this.G.setLayoutParams(new FrameLayout.LayoutParams(this.t, this.u, 17));
    this.J.addView(this.G);
    this.J.addView(this.M);
    setContentView(this.J);
    this.G.setOnCompletionListener(new MediaPlayer.OnCompletionListener()
    {
      public void onCompletion(MediaPlayer paramAnonymousMediaPlayer)
      {
        ADCVideo.this.setContentView(ADCVideo.this.H);
        ADCVideo.this.J.removeAllViews();
        ADCVideo.g = false;
      }
    });
    this.G.setOnPreparedListener(new MediaPlayer.OnPreparedListener()
    {
      public void onPrepared(MediaPlayer paramAnonymousMediaPlayer)
      {
        ADCVideo.this.J.removeViewAt(1);
      }
    });
    this.G.start();
  }
  
  boolean b()
  {
    boolean bool = false;
    Display localDisplay = getWindowManager().getDefaultDisplay();
    this.t = localDisplay.getWidth();
    this.u = localDisplay.getHeight();
    this.z = -16777216;
    getWindow().setBackgroundDrawable(new ColorDrawable(this.z));
    int i1 = this.t;
    int i2 = this.u;
    this.x = i1;
    this.y = i2;
    if (a.B)
    {
      a.B = false;
      bool = true;
    }
    return bool;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    int i2 = 1;
    a.W = false;
    super.onCreate(paramBundle);
    h = this;
    if (!a.i("video_enabled"))
    {
      bool = true;
      a.O = bool;
      if (a.i("end_card_enabled")) {
        break label139;
      }
    }
    label139:
    for (boolean bool = true;; bool = false)
    {
      a.N = bool;
      a.P = a.i("load_timeout_enabled");
      a.Q = a.h("load_timeout");
      i1 = 0;
      while (i1 < a.ac.size())
      {
        if (a.ac.get(i1) != null)
        {
          paramBundle = (AdColonyNativeAdView)a.ac.get(i1);
          if (paramBundle.V != null) {
            paramBundle.M.setVisibility(4);
          }
          if (paramBundle.K != null) {
            paramBundle.K.setVisibility(4);
          }
        }
        i1 += 1;
      }
      bool = false;
      break;
    }
    this.F = a.H;
    e = this.F.r;
    requestWindowFeature(1);
    getWindow().setFlags(1024, 1024);
    if (!a.m)
    {
      if (Build.VERSION.SDK_INT >= 10) {
        setRequestedOrientation(6);
      }
      for (;;)
      {
        setVolumeControlStream(3);
        this.D = new e(this);
        this.H = new FrameLayout(this);
        this.E = new ae(this);
        this.J = new FrameLayout(this);
        this.M = new ADCVideo.a(this, this);
        this.L = new ADCImage(a.j("browser_icon"));
        AdColonyBrowser.A = false;
        a.I = this;
        a.J = this;
        return;
        setRequestedOrientation(0);
      }
    }
    int i3 = getResources().getConfiguration().orientation;
    if ((i3 == 0) || (i3 == 6) || (i3 == 2)) {}
    for (int i1 = 6;; i1 = 7)
    {
      a.w = i1;
      if ((Build.VERSION.SDK_INT < 10) || (Build.MODEL.equals("Kindle Fire"))) {
        break label378;
      }
      setRequestedOrientation(a.w);
      break;
    }
    label378:
    if (Build.MODEL.equals("Kindle Fire"))
    {
      getRequestedOrientation();
      i1 = i2;
      switch (((WindowManager)getSystemService("window")).getDefaultDisplay().getRotation())
      {
      default: 
        i1 = 8;
      }
    }
    for (;;)
    {
      a.w = i1;
      setRequestedOrientation(i1);
      break;
      i1 = 0;
      continue;
      i1 = 9;
      continue;
      i1 = i3;
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (!a.W) {}
    a.v = true;
    a.I = null;
    a.W = true;
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4) {
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((w.H != null) && (w.H.onKeyDown(paramInt, paramKeyEvent))) {}
    label134:
    do
    {
      do
      {
        do
        {
          return true;
          if (paramInt != 4) {
            break label134;
          }
          if (!d) {
            break;
          }
          if (g)
          {
            this.G.stopPlayback();
            g = false;
            this.J.removeAllViews();
            setContentView(this.H);
            return true;
          }
        } while ((this.E == null) || (this.E.t != 0));
        a.W = true;
        this.E.f();
        return true;
      } while ((this.E == null) || (!this.E.L) || (!this.E.N));
      a.W = true;
      this.E.g();
      return true;
    } while (paramInt == 82);
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  public void onPause()
  {
    i = false;
    if (g)
    {
      if (this.G != null)
      {
        b = this.G.getCurrentPosition();
        this.G.stopPlayback();
      }
      if (d)
      {
        View localView = new View(this);
        localView.setBackgroundColor(-16777216);
        setContentView(localView);
        this.s = System.currentTimeMillis();
        if (!isFinishing()) {
          this.q += (this.s - this.r) / 1000.0D;
        }
      }
      if (this.D == null) {
        break label207;
      }
      if (this.D.getCurrentPosition() != 0) {
        a = this.D.getCurrentPosition();
      }
      this.D.a();
      this.D.setBackgroundColor(-16777216);
    }
    for (;;)
    {
      this.E.z = true;
      this.E.H = false;
      this.E.G = false;
      this.E.I = false;
      this.E.u = 0;
      this.E.t = 0;
      this.E.invalidate();
      super.onPause();
      return;
      b = 0;
      break;
      label207:
      a = 0;
    }
  }
  
  public void onResume()
  {
    i = true;
    super.onResume();
    if (a.a()) {
      finish();
    }
    b();
    if (this.B)
    {
      this.B = false;
      if (!d)
      {
        if (this.E.P) {
          this.I.addView(this.E.a);
        }
        if (this.E.P) {
          this.I.setVisibility(4);
        }
        if (Build.MODEL.equals("Kindle Fire")) {
          this.E.m = 20;
        }
        if (Build.MODEL.equals("SCH-I800")) {
          this.E.m = 25;
        }
        this.H.addView(this.D, new FrameLayout.LayoutParams(this.x, this.y, 17));
        if (this.E.P) {
          this.H.addView(this.I, new FrameLayout.LayoutParams(this.t, this.u - this.E.m, 17));
        }
        this.H.addView(this.E, new FrameLayout.LayoutParams(this.t, this.u, 17));
      }
    }
    if (g)
    {
      this.J.removeView(this.M);
      this.J.addView(this.M);
      setContentView(this.J);
    }
    for (;;)
    {
      this.D.a(this.E);
      this.D.a(this.E);
      try
      {
        this.N = new FileInputStream(a.j("video_filepath"));
        this.D.a(this.N.getFD());
        if (!j) {
          onWindowFocusChanged(true);
        }
        if (a.O)
        {
          this.E.a();
          this.E.c();
        }
        return;
      }
      catch (IOException localIOException)
      {
        a.e("Unable to play video: " + a.j("video_filepath"));
        finish();
      }
      setContentView(this.H);
      if (d) {
        this.r = System.currentTimeMillis();
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      j = false;
      if ((!d) && (i)) {
        if (this.D != null)
        {
          if (c != 0) {
            a = c;
          }
          c = 0;
          this.D.seekTo(a);
          if (!a.m) {
            break label131;
          }
          Handler localHandler = new Handler();
          Runnable local1 = new Runnable()
          {
            public void run()
            {
              ADCVideo.this.D.setBackgroundColor(0);
            }
          };
          this.D.setBackgroundColor(-16777216);
          localHandler.postDelayed(local1, 900L);
          if (!w.G)
          {
            this.E.R = false;
            this.D.start();
          }
          this.E.requestFocus();
          this.E.invalidate();
        }
      }
      label131:
      do
      {
        return;
        this.D.setBackgroundColor(0);
        break;
        if (g)
        {
          if (this.G != null)
          {
            this.G.seekTo(b);
            this.G.start();
            return;
          }
          if (this.J != null) {
            this.J.removeAllViews();
          }
          setContentView(this.H);
          return;
        }
      } while (!d);
      this.E.invalidate();
      return;
    }
    if (i)
    {
      a = this.D.getCurrentPosition();
      this.D.pause();
    }
    j = true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/jirbo/adcolony/ADCVideo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */