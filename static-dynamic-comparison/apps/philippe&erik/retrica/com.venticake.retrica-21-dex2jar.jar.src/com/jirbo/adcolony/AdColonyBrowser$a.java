package com.jirbo.adcolony;

import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

class AdColonyBrowser$a
  extends View
{
  Rect a = new Rect();
  Paint b = new Paint();
  
  public AdColonyBrowser$a(AdColonyBrowser paramAdColonyBrowser, Activity paramActivity)
  {
    super(paramActivity);
  }
  
  public void a()
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(this.c.r.getWidth(), this.c.r.getHeight());
    localLayoutParams.topMargin = ((this.c.l.getHeight() - this.c.d.g) / 2);
    localLayoutParams.leftMargin = (this.c.l.getWidth() / 10 + this.c.d.b() + this.c.d.f);
    if ((AdColonyBrowser.z) && (this.c.d.b() != 0))
    {
      this.c.m.removeView(this.c.r);
      this.c.m.addView(this.c.r, localLayoutParams);
      AdColonyBrowser.z = false;
    }
    if (this.c.r.getLayoutParams() == null) {
      return;
    }
    this.c.r.getLayoutParams().height = this.c.d.g;
    this.c.r.getLayoutParams().width = this.c.d.f;
  }
  
  public boolean a(ADCImage paramADCImage, int paramInt1, int paramInt2)
  {
    return (paramInt1 < paramADCImage.b() + paramADCImage.f + 16) && (paramInt1 > paramADCImage.b() - 16) && (paramInt2 < paramADCImage.c() + paramADCImage.g + 16) && (paramInt2 > paramADCImage.c() - 16);
  }
  
  public void b()
  {
    this.c.n = false;
    this.c.o = false;
    this.c.p = false;
    this.c.q = false;
    invalidate();
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    getDrawingRect(this.a);
    int i = (this.c.l.getHeight() - this.c.c.g) / 2;
    if (!AdColonyBrowser.v)
    {
      this.c.c.a(paramCanvas, this.c.c.f, i);
      if (AdColonyBrowser.w) {
        break label643;
      }
      this.c.f.a(paramCanvas, this.c.c.b() + this.c.l.getWidth() / 10 + this.c.c.f, i);
      label113:
      if (!AdColonyBrowser.x) {
        break label693;
      }
      this.c.d.a(paramCanvas, this.c.f.b() + this.c.f.f + this.c.l.getWidth() / 10, i);
    }
    for (;;)
    {
      this.c.g.a(paramCanvas, this.c.l.getWidth() - this.c.g.f * 2, i);
      if (this.c.n)
      {
        this.c.h.c(this.c.c.b() - this.c.h.f / 2 + this.c.c.f / 2, this.c.c.c() - this.c.h.g / 2 + this.c.c.g / 2);
        this.c.h.a(paramCanvas);
      }
      if (this.c.o)
      {
        this.c.h.c(this.c.f.b() - this.c.h.f / 2 + this.c.f.f / 2, this.c.f.c() - this.c.h.g / 2 + this.c.f.g / 2);
        this.c.h.a(paramCanvas);
      }
      if (this.c.p)
      {
        this.c.h.c(this.c.e.b() - this.c.h.f / 2 + this.c.e.f / 2, this.c.e.c() - this.c.h.g / 2 + this.c.e.g / 2);
        this.c.h.a(paramCanvas);
      }
      if (this.c.q)
      {
        this.c.h.c(this.c.g.b() - this.c.h.f / 2 + this.c.g.f / 2, this.c.g.c() - this.c.h.g / 2 + this.c.g.g / 2);
        this.c.h.a(paramCanvas);
      }
      a();
      return;
      this.c.j.a(paramCanvas, this.c.c.f, i);
      break;
      label643:
      this.c.k.a(paramCanvas, this.c.c.b() + this.c.l.getWidth() / 10 + this.c.c.f, i);
      break label113;
      label693:
      this.c.e.a(paramCanvas, this.c.f.b() + this.c.f.f + this.c.l.getWidth() / 10, i);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    int j = (int)paramMotionEvent.getX();
    int k = (int)paramMotionEvent.getY();
    if (i == 0)
    {
      if ((a(this.c.c, j, k)) && (AdColonyBrowser.v))
      {
        this.c.n = true;
        invalidate();
        return true;
      }
      if ((a(this.c.f, j, k)) && (AdColonyBrowser.w))
      {
        this.c.o = true;
        invalidate();
        return true;
      }
      if (a(this.c.e, j, k))
      {
        this.c.p = true;
        invalidate();
        return true;
      }
      if (a(this.c.g, j, k))
      {
        this.c.q = true;
        invalidate();
        return true;
      }
    }
    if (i == 1)
    {
      if ((a(this.c.c, j, k)) && (AdColonyBrowser.v))
      {
        this.c.b.goBack();
        b();
        return true;
      }
      if ((a(this.c.f, j, k)) && (AdColonyBrowser.w))
      {
        this.c.b.goForward();
        b();
        return true;
      }
      if ((a(this.c.e, j, k)) && (AdColonyBrowser.x))
      {
        this.c.b.stopLoading();
        b();
        return true;
      }
      if ((a(this.c.e, j, k)) && (!AdColonyBrowser.x))
      {
        this.c.b.reload();
        b();
        return true;
      }
      if (a(this.c.g, j, k))
      {
        AdColonyBrowser.C = true;
        this.c.b.loadData("", "text/html", "utf-8");
        AdColonyBrowser.w = false;
        AdColonyBrowser.v = false;
        AdColonyBrowser.x = false;
        b();
        this.c.finish();
        return true;
      }
      b();
    }
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/jirbo/adcolony/AdColonyBrowser$a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */