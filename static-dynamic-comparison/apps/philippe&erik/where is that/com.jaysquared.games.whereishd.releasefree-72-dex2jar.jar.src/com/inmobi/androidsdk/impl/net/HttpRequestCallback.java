package com.inmobi.androidsdk.impl.net;

public abstract interface HttpRequestCallback
{
  public static final int HTTP_FAILURE = 1;
  public static final int HTTP_SUCCESS = 0;
  
  public abstract void notifyResult(int paramInt, Object paramObject);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/inmobi/androidsdk/impl/net/HttpRequestCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */