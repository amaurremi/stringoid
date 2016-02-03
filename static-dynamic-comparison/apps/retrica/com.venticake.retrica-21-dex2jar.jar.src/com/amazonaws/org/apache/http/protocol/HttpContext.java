package com.amazonaws.org.apache.http.protocol;

public abstract interface HttpContext
{
  public abstract Object getAttribute(String paramString);
  
  public abstract void setAttribute(String paramString, Object paramObject);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/protocol/HttpContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */