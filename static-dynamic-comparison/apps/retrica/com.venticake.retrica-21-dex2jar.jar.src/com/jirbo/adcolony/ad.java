package com.jirbo.adcolony;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.Display;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout.LayoutParams;
import java.util.ArrayList;

class ad
  extends h
{
  boolean G;
  
  public ad(String paramString, AdColonyV4VCAd paramAdColonyV4VCAd)
  {
    this.E = paramString;
    this.F = paramAdColonyV4VCAd;
    if (!a()) {
      return;
    }
    AdColony.activity().addContentView(this, new FrameLayout.LayoutParams(-1, -1, 17));
  }
  
  void c()
  {
    Display localDisplay = a.b().getWindowManager().getDefaultDisplay();
    int i = localDisplay.getWidth();
    int j = localDisplay.getHeight();
    if (this.n) {}
    for (double d1 = 12.0D;; d1 = 16.0D)
    {
      this.w = ((i - this.a.f) / 2);
      this.x = ((j - this.a.g) / 2 - 80);
      this.y = (this.w + this.a.f / 2);
      this.z = (this.x + this.a.g / 2);
      i = this.x;
      double d2 = this.a.g;
      double d3 = this.h.g;
      this.C = ((int)(d2 - (d1 * o + d3)) + i);
      this.A = (this.y - this.h.f / 2);
      return;
    }
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
    if ((k == this.F.getViewsPerReward()) || (k == 0))
    {
      a(this.E, "video. You earned");
      if (r)
      {
        a("Thanks for watching the sponsored", this.y, (int)(this.z - j * 2.5D), paramCanvas);
        a("video. You earned " + p + ".", this.y, (int)(this.z - j * 1.5D), paramCanvas);
        this.b.a(paramCanvas, this.y - this.b.f / 2, this.z - this.b.g / 2);
        if (this.G) {
          break label658;
        }
        this.h.a(paramCanvas, this.A, this.C);
      }
    }
    for (;;)
    {
      c("Ok", this.A, this.C, paramCanvas);
      if (i != 128) {
        invalidate();
      }
      return;
      a("Thanks for watching the sponsored", this.y, (int)(this.z - j * 2.8D), paramCanvas);
      a("video. You earned " + p, this.y, (int)(this.z - j * 2.05D), paramCanvas);
      a(q + ".", this.y, (int)(this.z - j * 1.3D), paramCanvas);
      break;
      a(this.E, "to earn ");
      if (k == 1) {}
      for (String str = "video";; str = "videos")
      {
        if (!r) {
          break label517;
        }
        a("Thank you. Watch " + k + " more " + str, this.y, (int)(this.z - j * 2.5D), paramCanvas);
        a("to earn " + p + ".", this.y, (int)(this.z - j * 1.5D), paramCanvas);
        break;
      }
      label517:
      a("Thank you. Watch " + k + " more " + str, this.y, (int)(this.z - j * 2.8D), paramCanvas);
      a("to earn " + p, this.y, (int)(this.z - j * 2.05D), paramCanvas);
      a(q + ".", this.y, (int)(this.z - j * 1.3D), paramCanvas);
      break;
      label658:
      this.g.a(paramCanvas, this.A, this.C);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int j = (int)paramMotionEvent.getX();
    int k = (int)paramMotionEvent.getY();
    if (paramMotionEvent.getAction() == 1)
    {
      if ((a(j, k, this.A, this.C)) && (this.G))
      {
        a.G = null;
        ((ViewGroup)getParent()).removeView(this);
        int i = 0;
        while (i < a.Z.size())
        {
          ((Bitmap)a.Z.get(i)).recycle();
          i += 1;
        }
        a.Z.clear();
        a.v = true;
      }
      this.G = false;
      invalidate();
    }
    if ((paramMotionEvent.getAction() == 0) && (a(j, k, this.A, this.C)))
    {
      this.G = true;
      invalidate();
    }
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/jirbo/adcolony/ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */