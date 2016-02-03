package com.flurry.android.monolithic.sdk.impl;

import android.widget.VideoView;
import com.flurry.android.FlurryFullscreenTakeoverActivity;
import com.flurry.android.impl.ads.FlurryAdModule;

public final class d
  implements az
{
  private d(FlurryFullscreenTakeoverActivity paramFlurryFullscreenTakeoverActivity) {}
  
  public boolean a(ar paramar, String paramString, boolean paramBoolean)
  {
    if (FlurryFullscreenTakeoverActivity.a(this.a, paramString))
    {
      FlurryFullscreenTakeoverActivity.a(this.a, new VideoView(this.a));
      FlurryFullscreenTakeoverActivity.a(this.a).setFocusable(true);
      FlurryFullscreenTakeoverActivity.a(this.a).setFocusableInTouchMode(true);
      FlurryFullscreenTakeoverActivity.a(this.a, paramBoolean);
      FlurryFullscreenTakeoverActivity.b(this.a, paramString);
    }
    boolean bool;
    do
    {
      return true;
      if (!FlurryFullscreenTakeoverActivity.c(this.a, paramString)) {
        break;
      }
      bool = paramBoolean;
      if (!paramBoolean) {
        bool = FlurryFullscreenTakeoverActivity.a(this.a, paramString, paramar.getUrl());
      }
      FlurryAdModule.getInstance().a().a(this.a, paramString, FlurryFullscreenTakeoverActivity.b(this.a));
    } while (!bool);
    paramar.post(new e(this, paramar));
    return true;
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */