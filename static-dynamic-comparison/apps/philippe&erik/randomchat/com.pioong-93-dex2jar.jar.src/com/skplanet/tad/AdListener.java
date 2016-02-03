package com.skplanet.tad;

public abstract interface AdListener
{
  public abstract void onAdClicked();
  
  public abstract void onAdExpandClosed();
  
  public abstract void onAdExpanded();
  
  public abstract void onAdFailed(ErrorCode paramErrorCode);
  
  public abstract void onAdLoaded();
  
  public abstract void onAdReceived();
  
  public abstract void onAdResizeClosed();
  
  public abstract void onAdResized();
  
  public abstract void onAdWillLoad();
  
  public abstract void onAdWillReceive();
  
  public static enum ErrorCode
  {
    static
    {
      NOT_FOUND_ACTIVITY_ERROR = new ErrorCode("NOT_FOUND_ACTIVITY_ERROR", 2);
      CLIENTID_DENIED_ERROR = new ErrorCode("CLIENTID_DENIED_ERROR", 3);
      INVAILD_SLOT_NUMBER = new ErrorCode("INVAILD_SLOT_NUMBER", 4);
      CONNECTION_ERROR = new ErrorCode("CONNECTION_ERROR", 5);
      NETWORK_ERROR = new ErrorCode("NETWORK_ERROR", 6);
      RECEIVE_AD_ERROR = new ErrorCode("RECEIVE_AD_ERROR", 7);
      LOAD_AD_ERROR = new ErrorCode("LOAD_AD_ERROR", 8);
      SHOW_ERROR = new ErrorCode("SHOW_ERROR", 9);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/skplanet/tad/AdListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */