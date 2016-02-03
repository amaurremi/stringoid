package com.jumptap.adtag.listeners;

import com.jumptap.adtag.JtAdWidgetSettings;

public abstract interface JtAdViewInnerListener
{
  public abstract String getAdRequestId();
  
  public abstract JtAdWidgetSettings getWidgetSettings();
  
  public abstract void handleClicks(String paramString);
  
  public abstract void hide();
  
  public abstract void onAdError(int paramInt);
  
  public abstract void onBeginAdInteraction();
  
  public abstract void onEndAdInteraction();
  
  public abstract void onInterstitialDismissed();
  
  public abstract void onNewAd();
  
  public abstract void onNoAdFound();
  
  public abstract boolean post(Runnable paramRunnable);
  
  public abstract void resize(int paramInt1, int paramInt2, boolean paramBoolean);
  
  public abstract void resizeWithCallback(boolean paramBoolean, int paramInt1, int paramInt2, String paramString1, int paramInt3, String paramString2);
  
  public abstract void setContent(String paramString1, String paramString2);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/jumptap/adtag/listeners/JtAdViewInnerListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */