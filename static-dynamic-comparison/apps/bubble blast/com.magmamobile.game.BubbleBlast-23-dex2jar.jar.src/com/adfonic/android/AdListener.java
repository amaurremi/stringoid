package com.adfonic.android;

public abstract interface AdListener
{
  public abstract void onClick();
  
  public abstract void onDismissScreen();
  
  public abstract void onInternalError();
  
  public abstract void onInvalidRequest();
  
  public abstract void onLeaveApplication();
  
  public abstract void onNetworkError();
  
  public abstract void onNoFill();
  
  public abstract void onPresentScreen();
  
  public abstract void onReceivedAd();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/adfonic/android/AdListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */