package com.flurry.android.monolithic.sdk.impl;

import android.content.Context;
import android.widget.VideoView;

public class n
  extends VideoView
{
  public n(Context paramContext)
  {
    super(paramContext);
    setFocusable(true);
    setFocusableInTouchMode(true);
  }
  
  public void seekTo(int paramInt)
  {
    if (paramInt < getCurrentPosition()) {
      super.seekTo(paramInt);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */