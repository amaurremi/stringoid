package com.amazon.inapp.purchasing;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import java.util.HashMap;
import java.util.Map;

class HandlerManager
{
  private static volatile Map<String, HandlerAdapter> HANDLER_ADAPTERS = new HashMap();
  private static volatile HandlerAdapter MAIN_HANDLER_ADAPTER = null;
  
  static HandlerAdapter getHandlerAdapter(String paramString)
  {
    if (!HANDLER_ADAPTERS.containsKey(paramString)) {}
    try
    {
      if (!HANDLER_ADAPTERS.containsKey(paramString))
      {
        Object localObject = new HandlerThread(paramString);
        ((HandlerThread)localObject).start();
        localObject = new HandlerAdapter(new Handler(((HandlerThread)localObject).getLooper()));
        HANDLER_ADAPTERS.put(paramString, localObject);
      }
      return (HandlerAdapter)HANDLER_ADAPTERS.get(paramString);
    }
    finally {}
  }
  
  static HandlerAdapter getMainHandlerAdapter()
  {
    if (MAIN_HANDLER_ADAPTER == null) {}
    try
    {
      if (MAIN_HANDLER_ADAPTER == null) {
        MAIN_HANDLER_ADAPTER = new HandlerAdapter(new Handler(PurchasingManager.getObserverContext().getMainLooper()));
      }
      return MAIN_HANDLER_ADAPTER;
    }
    finally {}
  }
  
  static void setHandlerAdapter(String paramString, HandlerAdapter paramHandlerAdapter)
  {
    HANDLER_ADAPTERS.put(paramString, paramHandlerAdapter);
  }
  
  static void setMainHandlerAdapter(HandlerAdapter paramHandlerAdapter)
  {
    MAIN_HANDLER_ADAPTER = paramHandlerAdapter;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazon/inapp/purchasing/HandlerManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */