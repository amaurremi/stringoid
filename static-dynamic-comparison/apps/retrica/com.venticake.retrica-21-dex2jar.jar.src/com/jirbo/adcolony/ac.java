package com.jirbo.adcolony;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import java.util.ArrayList;

class ac
  extends h
{
  boolean G;
  boolean H;
  
  public ac(String paramString, AdColonyV4VCAd paramAdColonyV4VCAd)
  {
    this.E = paramString;
    this.F = paramAdColonyV4VCAd;
    if (!a()) {}
    do
    {
      return;
      AdColony.activity().addContentView(this, new FrameLayout.LayoutParams(-1, -1, 17));
    } while (!this.n);
    this.C += 20;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    c();
    int j = (int)(System.currentTimeMillis() - this.v) * 255 / 1000;
    int i = j;
    if (j > 128) {
      i = 128;
    }
    paramCanvas.drawARGB(i, 0, 0, 0);
    this.a.a(paramCanvas, this.w, this.x);
    j = b() * 3 / 2;
    int k = this.F.getRemainingViewsUntilReward();
    if (this.F.getViewsPerReward() == 1)
    {
      a(this.E, "");
      if (!r)
      {
        a("Watch a video to earn", this.y, (int)(this.z - j * this.i), paramCanvas);
        a(p, this.y, (int)(this.z - j * this.j), paramCanvas);
        a(q + ".", this.y, (int)(this.z - j * this.k), paramCanvas);
        this.b.a(paramCanvas, this.y - this.b.f / 2, this.z - this.b.g / 2);
        if (this.H) {
          break label694;
        }
        this.c.a(paramCanvas, this.A, this.C);
        label258:
        if (this.G) {
          break label713;
        }
        this.e.a(paramCanvas, this.B, this.C);
      }
    }
    for (;;)
    {
      c("Yes", this.A, this.C, paramCanvas);
      c("No", this.B, this.C, paramCanvas);
      if (i != 128) {
        invalidate();
      }
      return;
      a("Watch a video to earn", this.y, (int)(this.z - j * this.l), paramCanvas);
      a(p + ".", this.y, (int)(this.z - j * this.m), paramCanvas);
      break;
      if (k == 1) {}
      for (String str = "video";; str = "videos")
      {
        a(this.E, "" + k + " more " + str + " to earn )?");
        if (r) {
          break label597;
        }
        a("Watch a sponsored video now (Only", this.y, (int)(this.z - j * this.i), paramCanvas);
        a("" + k + " more " + str + " to earn " + p, this.y, (int)(this.z - j * this.j), paramCanvas);
        a(q + ")?", this.y, (int)(this.z - j * this.k), paramCanvas);
        break;
      }
      label597:
      a("Watch a sponsored video now (Only", this.y, (int)(this.z - j * this.l), paramCanvas);
      a("" + k + " more " + str + " to earn " + p + ")?", this.y, (int)(this.z - j * this.m), paramCanvas);
      break;
      label694:
      this.d.a(paramCanvas, this.A, this.C);
      break label258;
      label713:
      this.f.a(paramCanvas, this.B, this.C);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int j = (int)paramMotionEvent.getX();
    int k = (int)paramMotionEvent.getY();
    if (paramMotionEvent.getAction() == 1)
    {
      if ((a(j, k, this.A, this.C)) && (this.H))
      {
        a.G = null;
        ((ViewGroup)getParent()).removeView(this);
        this.F.c(true);
        this.G = false;
        this.H = false;
        invalidate();
      }
    }
    else if (paramMotionEvent.getAction() == 0)
    {
      if (!a(j, k, this.A, this.C)) {
        break label212;
      }
      this.H = true;
      invalidate();
    }
    label212:
    while (!a(j, k, this.B, this.C))
    {
      return true;
      if ((!a(j, k, this.B, this.C)) || (!this.G)) {
        break;
      }
      a.G = null;
      ((ViewGroup)getParent()).removeView(this);
      this.F.c(false);
      a.v = true;
      int i = 0;
      while (i < a.Z.size())
      {
        ((Bitmap)a.Z.get(i)).recycle();
        i += 1;
      }
      a.Z.clear();
      break;
    }
    this.G = true;
    invalidate();
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/jirbo/adcolony/ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */