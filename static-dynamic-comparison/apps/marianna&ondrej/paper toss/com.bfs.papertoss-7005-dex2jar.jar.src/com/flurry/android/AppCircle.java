package com.flurry.android;

import android.content.Context;
import android.view.View;
import java.util.List;

public class AppCircle
{
  public void acceptOffer(Context paramContext, long paramLong)
  {
    FlurryAgent.a(paramContext, paramLong);
  }
  
  public void addUserCookie(String paramString1, String paramString2)
  {
    FlurryAgent.addUserCookie(paramString1, paramString2);
  }
  
  public void clearUserCookies() {}
  
  public List getAllOffers()
  {
    return FlurryAgent.b("");
  }
  
  public List getAllOffers(String paramString)
  {
    return FlurryAgent.b(paramString);
  }
  
  public View getHook(Context paramContext, String paramString, int paramInt)
  {
    return FlurryAgent.a(paramContext, paramString, paramInt);
  }
  
  public Offer getOffer()
  {
    return getOffer("");
  }
  
  public Offer getOffer(String paramString)
  {
    return FlurryAgent.a(paramString);
  }
  
  public boolean hasAds()
  {
    return FlurryAgent.d();
  }
  
  public boolean isLaunchCanvasOnBannerClicked()
  {
    return FlurryAgent.a();
  }
  
  public boolean isLaunchCatalogOnBannerClicked()
  {
    return FlurryAgent.a();
  }
  
  public void launchCanvasOnBannerClicked(boolean paramBoolean)
  {
    FlurryAgent.a(paramBoolean);
  }
  
  public void launchCatalogOnBannerClicked(boolean paramBoolean)
  {
    FlurryAgent.a(paramBoolean);
  }
  
  public void openCatalog(Context paramContext)
  {
    openCatalog(paramContext, "");
  }
  
  public void openCatalog(Context paramContext, String paramString)
  {
    FlurryAgent.a(paramContext, paramString);
  }
  
  public void removeOffers(List paramList)
  {
    FlurryAgent.a(paramList);
  }
  
  public void setAppCircleCallback(AppCircleCallback paramAppCircleCallback)
  {
    FlurryAgent.a(paramAppCircleCallback);
  }
  
  public void setDefaultNoAdsMessage(String paramString)
  {
    FlurryAgent.setDefaultNoAdsMessage(paramString);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/paper toss/com.bfs.papertoss-7005-dex2jar.jar!/com/flurry/android/AppCircle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */