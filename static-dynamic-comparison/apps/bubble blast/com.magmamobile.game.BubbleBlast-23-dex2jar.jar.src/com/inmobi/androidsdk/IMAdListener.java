package com.inmobi.androidsdk;

public abstract interface IMAdListener
{
  public abstract void onAdRequestCompleted(IMAdView paramIMAdView);
  
  public abstract void onAdRequestFailed(IMAdView paramIMAdView, IMAdRequest.ErrorCode paramErrorCode);
  
  public abstract void onDismissAdScreen(IMAdView paramIMAdView);
  
  public abstract void onLeaveApplication(IMAdView paramIMAdView);
  
  public abstract void onShowAdScreen(IMAdView paramIMAdView);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/inmobi/androidsdk/IMAdListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */