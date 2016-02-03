package com.google.android.gms.wearable;

public abstract interface MessageEvent
{
  public abstract byte[] getData();
  
  public abstract String getPath();
  
  public abstract int getRequestId();
  
  public abstract String getSourceNodeId();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/wearable/MessageEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */