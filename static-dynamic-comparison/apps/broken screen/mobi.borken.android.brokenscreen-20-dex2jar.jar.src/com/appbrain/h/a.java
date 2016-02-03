package com.appbrain.h;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.RelativeLayout.LayoutParams;

public final class a
{
  private ViewGroup a;
  
  public a(ViewGroup paramViewGroup)
  {
    this.a = paramViewGroup;
  }
  
  public final void a(View paramView)
  {
    if ((paramView.getAnimation() != null) && (!paramView.getAnimation().hasEnded())) {
      return;
    }
    paramView.measure(0, 0);
    c localc = new c(this, paramView, paramView.getMeasuredWidth());
    paramView.setVisibility(0);
    paramView.getLayoutParams().width = 1;
    paramView.requestLayout();
    localc.setDuration(200L);
    paramView.startAnimation(localc);
  }
  
  public final void a(View paramView, Animation.AnimationListener paramAnimationListener)
  {
    if ((paramView.getAnimation() != null) && (!paramView.getAnimation().hasEnded())) {
      return;
    }
    Object localObject = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
    localObject = new b(this, paramView, ((RelativeLayout.LayoutParams)localObject).leftMargin, ((RelativeLayout.LayoutParams)localObject).rightMargin, ((RelativeLayout.LayoutParams)localObject).topMargin, ((RelativeLayout.LayoutParams)localObject).bottomMargin);
    ((Animation)localObject).setDuration(200L);
    ((Animation)localObject).setAnimationListener(paramAnimationListener);
    paramView.startAnimation((Animation)localObject);
  }
  
  public final void b(View paramView)
  {
    if ((paramView.getAnimation() != null) && (!paramView.getAnimation().hasEnded())) {
      return;
    }
    paramView.measure(0, 0);
    d locald = new d(this, paramView, paramView.getMeasuredWidth());
    paramView.setVisibility(0);
    locald.setDuration(200L);
    paramView.startAnimation(locald);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/appbrain/h/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */