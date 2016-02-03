package com.amazonaws;

public enum Protocol
{
  HTTP("http"),  HTTPS("https");
  
  private final String protocol;
  
  private Protocol(String paramString)
  {
    this.protocol = paramString;
  }
  
  public String toString()
  {
    return this.protocol;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/Protocol.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */