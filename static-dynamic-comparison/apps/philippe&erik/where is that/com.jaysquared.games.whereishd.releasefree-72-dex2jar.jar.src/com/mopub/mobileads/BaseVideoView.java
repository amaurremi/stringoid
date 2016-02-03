package com.mopub.mobileads;

import android.content.Context;
import android.widget.VideoView;

abstract class BaseVideoView
  extends VideoView
{
  public BaseVideoView(Context paramContext)
  {
    super(paramContext);
  }
  
  void onPause() {}
  
  void onResume() {}
  
  public static abstract interface BaseVideoViewListener
  {
    public abstract void showCloseButton();
    
    public abstract void videoClicked();
    
    public abstract void videoCompleted(boolean paramBoolean);
    
    public abstract void videoError(boolean paramBoolean);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/mopub/mobileads/BaseVideoView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */