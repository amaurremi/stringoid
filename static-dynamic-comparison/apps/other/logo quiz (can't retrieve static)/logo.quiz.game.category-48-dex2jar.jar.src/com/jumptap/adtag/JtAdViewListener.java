package com.jumptap.adtag;

public abstract interface JtAdViewListener
{
  public abstract void onAdError(JtAdView paramJtAdView, int paramInt1, int paramInt2);
  
  public abstract void onBannerClicked(JtAdView paramJtAdView, int paramInt);
  
  public abstract void onBeginAdInteraction(JtAdView paramJtAdView, int paramInt);
  
  public abstract void onContract(JtAdView paramJtAdView, int paramInt);
  
  public abstract void onEndAdInteraction(JtAdView paramJtAdView, int paramInt);
  
  public abstract void onExpand(JtAdView paramJtAdView, int paramInt);
  
  public abstract void onFocusChange(JtAdView paramJtAdView, int paramInt, boolean paramBoolean);
  
  public abstract void onHide(JtAdView paramJtAdView, int paramInt);
  
  public abstract void onInterstitialDismissed(JtAdView paramJtAdView, int paramInt);
  
  public abstract void onLaunchActivity(JtAdView paramJtAdView, int paramInt);
  
  public abstract void onNewAd(JtAdView paramJtAdView, int paramInt, String paramString);
  
  public abstract void onNoAdFound(JtAdView paramJtAdView, int paramInt);
  
  public abstract void onReturnFromActivity(JtAdView paramJtAdView, int paramInt);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/jumptap/adtag/JtAdViewListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */