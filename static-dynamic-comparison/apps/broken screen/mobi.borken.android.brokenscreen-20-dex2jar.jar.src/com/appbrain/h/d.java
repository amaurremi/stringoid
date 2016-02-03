package com.appbrain.h;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

final class d
  extends Animation
{
  d(a parama, View paramView, int paramInt) {}
  
  protected final void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    if (paramFloat < 1.0F)
    {
      int i = (int)(this.b * (1.0F - paramFloat));
      if (i != 0)
      {
        this.a.getLayoutParams().width = i;
        this.a.requestLayout();
        return;
      }
    }
    this.a.getLayoutParams().width = -2;
    this.a.setVisibility(8);
  }
  
  public final boolean willChangeBounds()
  {
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/appbrain/h/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */