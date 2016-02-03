package com.amazonaws.org.apache.http.client.methods;

import com.amazonaws.org.apache.http.conn.ClientConnectionRequest;
import com.amazonaws.org.apache.http.conn.ConnectionReleaseTrigger;

public abstract interface AbortableHttpRequest
{
  public abstract void abort();
  
  public abstract void setConnectionRequest(ClientConnectionRequest paramClientConnectionRequest);
  
  public abstract void setReleaseTrigger(ConnectionReleaseTrigger paramConnectionReleaseTrigger);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/client/methods/AbortableHttpRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */