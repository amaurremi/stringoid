package com.bluebird.mobile.tools.animations;

import android.util.Log;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import com.google.android.gms.ads.AdListener;

public class FlipAdListener
  extends AdListener
{
  private String TAG = "FlipAdListener";
  private View adView;
  
  public FlipAdListener(View paramView)
  {
    this.adView = paramView;
  }
  
  public void onAdLoaded()
  {
    try
    {
      Flip3dAnimation localFlip3dAnimation = new Flip3dAnimation(90.0F, 0.0F, 0.0F, 0.0F);
      localFlip3dAnimation.setDuration(500L);
      localFlip3dAnimation.setFillAfter(true);
      localFlip3dAnimation.setInterpolator(new DecelerateInterpolator());
      this.adView.startAnimation(localFlip3dAnimation);
      return;
    }
    catch (Exception localException)
    {
      Log.e(this.TAG, "Error in animatin ad after receive.", localException);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/bluebird/mobile/tools/animations/FlipAdListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */