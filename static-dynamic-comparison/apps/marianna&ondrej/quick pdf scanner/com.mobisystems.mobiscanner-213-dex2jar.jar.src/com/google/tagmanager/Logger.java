package com.google.tagmanager;

public abstract interface Logger
{
  public abstract void A(String paramString);
  
  public abstract void B(String paramString);
  
  public abstract void C(String paramString);
  
  public abstract void D(String paramString);
  
  public static enum LogLevel
  {
    private LogLevel() {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/tagmanager/Logger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */