package com.jirbo.adcolony;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.media.MediaPlayer;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;

class AdColonyNativeAdView$b
  extends View
{
  boolean a;
  
  public AdColonyNativeAdView$b(AdColonyNativeAdView paramAdColonyNativeAdView, Context paramContext)
  {
    super(paramContext);
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    this.b.g = ((ViewGroup)getParent().getParent());
    Rect localRect = new Rect();
    if ((this.b.V != null) && (!this.b.V.isPlaying()) && (this.b.l)) {
      this.a = false;
    }
    if ((getLocalVisibleRect(localRect)) && (Build.VERSION.SDK_INT >= 14) && (this.b.w)) {
      if ((!this.b.l) || ((this.b.l) && ((localRect.top == 0) || (localRect.bottom - localRect.top > this.b.getNativeAdHeight()))))
      {
        if (((this.a) || (this.b.r) || (this.b.V == null) || (this.b.V.isPlaying()) || (this.b.x) || (this.b.E.a(true)) || (!this.b.q)) || (!this.b.q))
        {
          l.c.b("[ADC] Native Ad Starting");
          this.b.b();
          this.b.q = true;
          this.b.E.j = "native";
          this.b.E.k = "native";
        }
      }
      else
      {
        this.a = true;
        label274:
        if ((!this.b.r) && (!q.c()) && (this.b.V != null) && (!this.b.V.isPlaying()))
        {
          setVisibility(0);
          this.b.K.setVisibility(8);
          this.b.r = true;
        }
        if ((this.b.r) || (this.b.V == null) || (!this.b.V.isPlaying())) {
          break label640;
        }
        setVisibility(8);
        this.b.K.setVisibility(0);
      }
    }
    for (;;)
    {
      if ((!this.b.x) && (!this.b.r)) {
        invalidate();
      }
      return;
      if ((!this.b.s) && (this.b.V != null) && (q.c()) && (!this.b.V.isPlaying()) && (this.b.d.hasWindowFocus()) && (!a.t))
      {
        l.c.b("[ADC] Native Ad Resuming");
        a.l.d.b("video_resumed", this.b.E);
        if (!this.b.o) {
          this.b.b(true);
        }
        this.b.setVolume(this.b.ar);
        this.b.V.seekTo(this.b.E.o);
        this.b.V.start();
        break;
      }
      if ((this.b.r) || (this.b.q) || (a.l.a(this.b.E.g, true, false))) {
        break;
      }
      this.b.r = true;
      setVisibility(0);
      this.b.K.setVisibility(8);
      break;
      this.a = false;
      break label274;
      label640:
      if ((this.b.r) || (this.b.s))
      {
        paramCanvas.drawARGB(255, 0, 0, 0);
        this.b.K.setVisibility(8);
        this.b.H.a(paramCanvas, (this.b.ai - this.b.H.f) / 2, (this.b.aj - this.b.H.g) / 2);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/jirbo/adcolony/AdColonyNativeAdView$b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */