package com.vungle.publisher;

public abstract interface EventListener
{
  public abstract void onAdEnd();
  
  public abstract void onAdStart();
  
  public abstract void onAdUnavailable(String paramString);
  
  public abstract void onCachedAdAvailable();
  
  public abstract void onVideoView(boolean paramBoolean, int paramInt1, int paramInt2);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/EventListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */