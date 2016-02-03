package com.flurry.android;

import android.content.Context;
import android.widget.VideoView;

final class ce
  extends VideoView
{
  public ce(Context paramContext)
  {
    super(paramContext);
    setFocusable(true);
    setFocusableInTouchMode(true);
  }
  
  public final void seekTo(int paramInt)
  {
    if (paramInt < getCurrentPosition()) {
      super.seekTo(paramInt);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/android/ce.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */