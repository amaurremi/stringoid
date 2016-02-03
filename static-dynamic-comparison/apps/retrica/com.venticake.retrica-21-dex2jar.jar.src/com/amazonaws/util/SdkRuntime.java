package com.amazonaws.util;

public enum SdkRuntime
{
  public static boolean shouldAbort()
  {
    return Thread.interrupted();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/util/SdkRuntime.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */