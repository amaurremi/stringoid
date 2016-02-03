package com.jirbo.adcolony;

import android.graphics.Canvas;
import android.view.KeyEvent;
import android.view.MotionEvent;

class w
  extends h
{
  static boolean G;
  static w H;
  boolean I;
  boolean J;
  ADCVideo K;
  
  public w(ADCVideo paramADCVideo, AdColonyV4VCAd paramAdColonyV4VCAd)
  {
    this.K = paramADCVideo;
    this.F = paramAdColonyV4VCAd;
    paramADCVideo.D.pause();
    H = this;
    if (!a()) {}
  }
  
  void c()
  {
    int i = this.K.t;
    int j = this.K.u;
    this.w = ((i - this.a.f) / 2);
    this.x = ((j - this.a.g) / 2);
    this.y = (this.w + this.a.f / 2);
    this.z = (this.x + this.a.g / 2);
    this.C = (this.x + (int)(this.a.g - (this.c.g + o * 16.0D)));
    this.A = (this.w + (int)(o * 16.0D));
    this.B = (this.w + (int)(this.a.f - (this.c.f + o * 16.0D)));
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    int i = 128;
    if (this.K.D == null) {
      return;
    }
    G = true;
    c();
    int j = (int)(System.currentTimeMillis() - this.v) * 255 / 1000;
    if (j > 128) {}
    for (;;)
    {
      paramCanvas.drawARGB(i, 0, 0, 0);
      this.a.a(paramCanvas, this.w, this.x);
      i = b() * 3 / 2;
      a("Completion is required to receive", this.y, (int)(this.z - i * 2.75D), paramCanvas);
      a("your reward.", this.y, this.z - i * 2, paramCanvas);
      a("Are you sure you want to skip?", this.y, (int)(this.z - i * 1.25D), paramCanvas);
      this.b.a(paramCanvas, this.y - this.b.f / 2, this.z - this.b.g / 2);
      if (!this.I)
      {
        this.c.a(paramCanvas, this.A, this.C);
        if (this.J) {
          break label280;
        }
        this.e.a(paramCanvas, this.B, this.C);
      }
      for (;;)
      {
        c("Yes", this.A, this.C, paramCanvas);
        c("No", this.B, this.C, paramCanvas);
        return;
        this.d.a(paramCanvas, this.A, this.C);
        break;
        label280:
        this.f.a(paramCanvas, this.B, this.C);
      }
      i = j;
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (this.K.D == null) {}
    while (paramInt != 4) {
      return false;
    }
    return true;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = true;
    ADCVideo localADCVideo = this.K;
    boolean bool1;
    if (ADCVideo.d)
    {
      H = null;
      bool1 = this.K.E.onTouchEvent(paramMotionEvent);
    }
    int i;
    int j;
    label169:
    label214:
    do
    {
      return bool1;
      i = (int)paramMotionEvent.getX();
      j = (int)paramMotionEvent.getY();
      if (paramMotionEvent.getAction() == 1)
      {
        if ((!a(i, j, this.A, this.C)) || (!this.I)) {
          break label169;
        }
        H = null;
        G = false;
        a.u = false;
        a.W = true;
        a.K.b(this.F);
        AdColonyBrowser.A = true;
        this.K.finish();
      }
      for (;;)
      {
        this.I = false;
        this.J = false;
        invalidate();
        bool1 = bool2;
        if (paramMotionEvent.getAction() != 0) {
          break;
        }
        if (!a(i, j, this.A, this.C)) {
          break label214;
        }
        this.I = true;
        invalidate();
        return true;
        if ((a(i, j, this.B, this.C)) && (this.J))
        {
          H = null;
          G = false;
          this.K.D.start();
        }
      }
      bool1 = bool2;
    } while (!a(i, j, this.B, this.C));
    this.J = true;
    invalidate();
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/jirbo/adcolony/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */