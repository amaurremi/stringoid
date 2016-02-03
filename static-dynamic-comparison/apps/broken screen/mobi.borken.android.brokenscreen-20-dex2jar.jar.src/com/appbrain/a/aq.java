package com.appbrain.a;

import android.os.Handler;
import android.os.HandlerThread;

public final class aq
{
  private static Handler a;
  
  public static Handler a()
  {
    try
    {
      if (a == null)
      {
        localObject1 = new HandlerThread("applift_background");
        ((HandlerThread)localObject1).start();
        a = new Handler(((HandlerThread)localObject1).getLooper());
      }
      Object localObject1 = a;
      return (Handler)localObject1;
    }
    finally {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/appbrain/a/aq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */