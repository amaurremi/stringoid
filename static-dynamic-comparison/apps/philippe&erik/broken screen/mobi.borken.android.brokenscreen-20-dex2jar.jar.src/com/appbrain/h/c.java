package com.appbrain.h;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

final class c
  extends Animation
{
  c(a parama, View paramView, int paramInt) {}
  
  protected final void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    this.a.setVisibility(0);
    if (paramFloat >= 1.0F) {}
    for (this.a.getLayoutParams().width = -2;; this.a.getLayoutParams().width = Math.max(1, (int)(this.b * paramFloat)))
    {
      this.a.requestLayout();
      return;
    }
  }
  
  public final boolean willChangeBounds()
  {
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/appbrain/h/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */