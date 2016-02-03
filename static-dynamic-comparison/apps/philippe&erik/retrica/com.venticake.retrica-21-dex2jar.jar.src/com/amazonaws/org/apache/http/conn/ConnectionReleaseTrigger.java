package com.amazonaws.org.apache.http.conn;

public abstract interface ConnectionReleaseTrigger
{
  public abstract void abortConnection();
  
  public abstract void releaseConnection();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/conn/ConnectionReleaseTrigger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */