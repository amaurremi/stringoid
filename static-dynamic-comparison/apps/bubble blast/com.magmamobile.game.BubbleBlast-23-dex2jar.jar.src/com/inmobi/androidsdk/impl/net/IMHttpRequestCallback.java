package com.inmobi.androidsdk.impl.net;

public abstract interface IMHttpRequestCallback
{
  public static final int HTTP_FAILURE = 1;
  public static final int HTTP_SUCCESS = 0;
  
  public abstract void notifyResult(int paramInt, Object paramObject);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/inmobi/androidsdk/impl/net/IMHttpRequestCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */