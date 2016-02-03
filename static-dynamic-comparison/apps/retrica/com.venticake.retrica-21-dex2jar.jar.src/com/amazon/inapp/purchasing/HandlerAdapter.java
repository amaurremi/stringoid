package com.amazon.inapp.purchasing;

import android.os.Handler;

class HandlerAdapter
{
  private Handler _handler;
  
  HandlerAdapter(Handler paramHandler)
  {
    this._handler = paramHandler;
  }
  
  boolean post(Runnable paramRunnable)
  {
    return this._handler.post(paramRunnable);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazon/inapp/purchasing/HandlerAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */