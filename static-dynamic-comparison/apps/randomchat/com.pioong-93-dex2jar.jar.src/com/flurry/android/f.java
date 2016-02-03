package com.flurry.android;

import android.widget.VideoView;

final class f
{
  private f(FlurryFullscreenTakeoverActivity paramFlurryFullscreenTakeoverActivity, byte paramByte) {}
  
  public final boolean a(String paramString, boolean paramBoolean)
  {
    if (FlurryFullscreenTakeoverActivity.c(paramString))
    {
      FlurryFullscreenTakeoverActivity.a(this.h, new VideoView(this.h));
      FlurryFullscreenTakeoverActivity.a(this.h).setFocusable(true);
      FlurryFullscreenTakeoverActivity.a(this.h).setFocusableInTouchMode(true);
      FlurryFullscreenTakeoverActivity.a(this.h, paramBoolean);
      FlurryFullscreenTakeoverActivity.a(this.h, paramString);
      return true;
    }
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/android/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */