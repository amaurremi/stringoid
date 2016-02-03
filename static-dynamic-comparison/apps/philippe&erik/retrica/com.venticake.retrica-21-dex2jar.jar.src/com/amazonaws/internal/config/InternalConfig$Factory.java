package com.amazonaws.internal.config;

public class InternalConfig$Factory
{
  private static final InternalConfig SINGELTON;
  
  static
  {
    try
    {
      InternalConfig localInternalConfig = InternalConfig.load();
      SINGELTON = localInternalConfig;
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (Exception localException)
    {
      throw new IllegalStateException("Fatal: Failed to load the internal config for AWS Java SDK", localException);
    }
  }
  
  public static InternalConfig getInternalConfig()
  {
    return SINGELTON;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/internal/config/InternalConfig$Factory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */