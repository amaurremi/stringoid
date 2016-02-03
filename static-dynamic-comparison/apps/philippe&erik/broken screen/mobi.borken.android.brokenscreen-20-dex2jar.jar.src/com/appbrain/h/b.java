package com.appbrain.h;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.RelativeLayout.LayoutParams;

final class b
  extends Animation
{
  b(a parama, View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  protected final void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    paramTransformation = (RelativeLayout.LayoutParams)this.a.getLayoutParams();
    if (paramFloat >= 1.0F)
    {
      paramTransformation.leftMargin = 0;
      paramTransformation.rightMargin = 0;
      paramTransformation.topMargin = 0;
    }
    for (paramTransformation.bottomMargin = 0;; paramTransformation.bottomMargin = ((int)(this.e * (1.0F - paramFloat))))
    {
      this.a.requestLayout();
      return;
      paramTransformation.leftMargin = ((int)(this.b * (1.0F - paramFloat)));
      paramTransformation.rightMargin = ((int)(this.c * (1.0F - paramFloat)));
      paramTransformation.topMargin = ((int)(this.d * (1.0F - paramFloat)));
    }
  }
  
  public final boolean willChangeBounds()
  {
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/appbrain/h/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */