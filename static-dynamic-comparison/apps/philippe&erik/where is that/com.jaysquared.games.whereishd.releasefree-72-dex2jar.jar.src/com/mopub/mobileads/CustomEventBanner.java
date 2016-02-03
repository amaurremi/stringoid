package com.mopub.mobileads;

import android.content.Context;
import android.view.View;
import java.util.Map;

public abstract class CustomEventBanner
{
  protected abstract void loadBanner(Context paramContext, CustomEventBannerListener paramCustomEventBannerListener, Map<String, Object> paramMap, Map<String, String> paramMap1);
  
  protected abstract void onInvalidate();
  
  public static abstract interface CustomEventBannerListener
  {
    public abstract void onBannerClicked();
    
    public abstract void onBannerCollapsed();
    
    public abstract void onBannerExpanded();
    
    public abstract void onBannerFailed(MoPubErrorCode paramMoPubErrorCode);
    
    public abstract void onBannerLoaded(View paramView);
    
    public abstract void onLeaveApplication();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/mopub/mobileads/CustomEventBanner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */