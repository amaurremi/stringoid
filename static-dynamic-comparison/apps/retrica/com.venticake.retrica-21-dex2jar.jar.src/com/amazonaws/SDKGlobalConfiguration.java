package com.amazonaws;

import java.util.concurrent.atomic.AtomicInteger;

public class SDKGlobalConfiguration
{
  private static final AtomicInteger globalTimeOffset = new AtomicInteger(0);
  
  public static int getGlobalTimeOffset()
  {
    return globalTimeOffset.get();
  }
  
  public static void setGlobalTimeOffset(int paramInt)
  {
    globalTimeOffset.set(paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/SDKGlobalConfiguration.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */