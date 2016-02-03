package com.amazon.inapp.purchasing;

import java.util.UUID;

abstract class Request
{
  private final String _requestId = UUID.randomUUID().toString();
  
  String getRequestId()
  {
    return this._requestId;
  }
  
  abstract Runnable getRunnable();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazon/inapp/purchasing/Request.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */