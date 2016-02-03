package com.admob.android.ads;

import android.view.animation.Transformation;
import android.view.animation.TranslateAnimation;

public final class l
  extends TranslateAnimation
{
  public l(int paramInt1, float paramFloat1, int paramInt2, float paramFloat2, int paramInt3, float paramFloat3, int paramInt4, float paramFloat4)
  {
    super(0, paramFloat1, 0, paramFloat2, 0, paramFloat3, 0, paramFloat4);
  }
  
  protected final void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    if ((paramFloat >= 0.0D) || (paramFloat <= 1.0D)) {
      super.applyTransformation(paramFloat, paramTransformation);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/hangman/com.games.HangManGame-14-dex2jar.jar!/com/admob/android/ads/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */