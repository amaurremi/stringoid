package com.amazonaws.org.apache.http;

public abstract interface StatusLine
{
  public abstract ProtocolVersion getProtocolVersion();
  
  public abstract String getReasonPhrase();
  
  public abstract int getStatusCode();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/StatusLine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */