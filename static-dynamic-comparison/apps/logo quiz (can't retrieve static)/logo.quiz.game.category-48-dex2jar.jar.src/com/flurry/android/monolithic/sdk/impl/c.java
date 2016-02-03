package com.flurry.android.monolithic.sdk.impl;

import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.flurry.android.FlurryFullscreenTakeoverActivity;

public final class c
  implements aw
{
  private View b;
  private int c;
  private ax d;
  private FrameLayout e;
  
  private c(FlurryFullscreenTakeoverActivity paramFlurryFullscreenTakeoverActivity) {}
  
  public void a(ar paramar)
  {
    if (this.b == null) {
      return;
    }
    ((ViewGroup)this.a.getWindow().getDecorView()).removeView(this.e);
    this.e.removeView(this.b);
    if (this.d != null) {
      this.d.a();
    }
    this.a.setRequestedOrientation(this.c);
    this.d = null;
    this.e = null;
    this.b = null;
  }
  
  public void a(ar paramar, View paramView, int paramInt, ax paramax)
  {
    if (this.b != null) {
      a(paramar);
    }
    this.b = paramView;
    this.c = this.a.getRequestedOrientation();
    this.d = paramax;
    this.e = new FrameLayout(this.a);
    this.e.setBackgroundColor(-16777216);
    this.e.addView(this.b, new FrameLayout.LayoutParams(-1, -1, 17));
    ((ViewGroup)this.a.getWindow().getDecorView()).addView(this.e, -1, -1);
    this.a.setRequestedOrientation(paramInt);
  }
  
  public void a(ar paramar, View paramView, ax paramax)
  {
    a(paramar, paramView, this.a.getRequestedOrientation(), paramax);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */