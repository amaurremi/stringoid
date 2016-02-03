package com.jirbo.adcolony;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import android.widget.ImageView;
import java.io.FileInputStream;

class AdColonyNativeAdView$a
  extends TextureView
  implements TextureView.SurfaceTextureListener
{
  boolean a = false;
  boolean b = false;
  
  AdColonyNativeAdView$a(AdColonyNativeAdView paramAdColonyNativeAdView, Context paramContext)
  {
    this(paramAdColonyNativeAdView, paramContext, false);
  }
  
  AdColonyNativeAdView$a(AdColonyNativeAdView paramAdColonyNativeAdView, Context paramContext, boolean paramBoolean)
  {
    super(paramContext);
    setSurfaceTextureListener(this);
    setWillNotDraw(false);
    this.a = paramBoolean;
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    this.c.L.setVisibility(0);
    this.c.h = paramSurfaceTexture;
    if ((this.c.r) || (this.a)) {}
    for (;;)
    {
      return;
      this.c.W = new Surface(paramSurfaceTexture);
      if (this.c.V != null) {
        this.c.V.release();
      }
      this.c.i = paramInt1;
      this.c.j = paramInt2;
      this.c.V = new MediaPlayer();
      try
      {
        this.c.at = new FileInputStream(this.c.f);
        this.c.V.setDataSource(this.c.at.getFD());
        this.c.V.setSurface(this.c.W);
        this.c.V.setOnCompletionListener(this.c);
        this.c.V.setOnPreparedListener(this.c);
        this.c.V.setOnErrorListener(this.c);
        this.c.V.prepareAsync();
        l.c.b("[ADC] Native Ad Prepare called.");
        this.b = true;
        paramSurfaceTexture = new Handler();
        Runnable local1 = new Runnable()
        {
          public void run()
          {
            if ((!AdColonyNativeAdView.a.this.c.w) && (!AdColonyNativeAdView.a.this.c.x))
            {
              AdColonyNativeAdView.a.this.b = false;
              AdColonyNativeAdView.a.this.c.r = true;
              AdColonyNativeAdView.a.this.c.K.setVisibility(8);
            }
          }
        };
        if (!this.b)
        {
          paramSurfaceTexture.postDelayed(local1, 1800L);
          return;
        }
      }
      catch (Exception paramSurfaceTexture)
      {
        this.c.r = true;
        this.c.K.setVisibility(8);
      }
    }
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    l.c.b("[ADC] Native surface destroyed");
    this.c.w = false;
    this.c.K.setVisibility(4);
    this.c.L.setVisibility(0);
    return true;
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    l.c.b("[ADC] onSurfaceTextureSizeChanged");
  }
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if ((i != 1) || (!a.v) || ((f1 > this.c.ai - this.c.I.f + 8) && (f2 < this.c.I.g + 8) && (!this.c.r) && (this.c.V != null) && (this.c.V.isPlaying()))) {}
    do
    {
      return true;
      a.H = this.c.E;
      a.l.a.a(this.c.e, this.c.E.i);
      ADCVideo.a();
      this.c.E.j = "native";
      this.c.E.k = "fullscreen";
      this.c.E.q = true;
      this.c.E.r = this.c.z;
    } while (((!this.c.w) && (!this.c.r)) || (!q.c()));
    if (this.c.F != null) {
      this.c.F.onAdColonyNativeAdStarted(true, this.c);
    }
    if ((this.c.V != null) && (this.c.V.isPlaying()))
    {
      ADCVideo.c = this.c.V.getCurrentPosition();
      this.c.E.n = this.c.E.m;
      this.c.V.pause();
      this.c.r = true;
      a.v = false;
      a.l.d.b("video_expanded", this.c.E);
      if (!a.m) {
        break label555;
      }
      l.a.b("Launching AdColonyOverlay");
      a.b().startActivity(new Intent(a.b(), AdColonyOverlay.class));
    }
    for (;;)
    {
      if (this.c.r)
      {
        paramMotionEvent = this.c.E.h.k;
        paramMotionEvent.d += 1;
        a.l.a("start", "{\"ad_slot\":" + this.c.E.h.k.d + ", \"replay\":" + this.c.E.r + "}", this.c.E);
        a.l.h.a(this.c.E.g, this.c.E.i.d);
      }
      this.c.z = true;
      return true;
      this.c.E.n = 0.0D;
      ADCVideo.c = 0;
      break;
      label555:
      l.a.b("Launching AdColonyFullscreen");
      a.b().startActivity(new Intent(a.b(), AdColonyFullscreen.class));
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/jirbo/adcolony/AdColonyNativeAdView$a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */