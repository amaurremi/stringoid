package com.amazonaws.org.apache.http.client;

import com.amazonaws.org.apache.http.conn.routing.HttpRoute;

public abstract interface BackoffManager
{
  public abstract void backOff(HttpRoute paramHttpRoute);
  
  public abstract void probe(HttpRoute paramHttpRoute);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/client/BackoffManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */