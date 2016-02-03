package com.inmobi.monetization;

import android.os.Handler;
import com.inmobi.commons.internal.Log;
import com.inmobi.monetization.internal.abstraction.INativeAdListener;

class a
  implements INativeAdListener
{
  a(IMNative paramIMNative) {}
  
  public void onNativeRequestFailed(final IMErrorCode paramIMErrorCode)
  {
    try
    {
      IMNative.a(this.a, IMNative.a.f);
      IMNative.e(this.a).post(new a(paramIMErrorCode));
      return;
    }
    catch (Exception paramIMErrorCode)
    {
      Log.debug("[InMobi]-[Monetization]", "Failed to give callback");
    }
  }
  
  public void onNativeRequestSucceeded(IMNative paramIMNative)
  {
    try
    {
      IMNative.a(this.a, IMNative.a.c);
      IMNative.a(this.a, IMNative.c(paramIMNative));
      IMNative.b(this.a, IMNative.a(paramIMNative));
      IMNative.c(this.a, IMNative.b(paramIMNative));
      IMNative.a(this.a, true);
      IMNative.e(this.a).post(new b());
      return;
    }
    catch (Exception paramIMNative)
    {
      Log.debug("[InMobi]-[Monetization]", "Failed to give callback");
    }
  }
  
  class a
    implements Runnable
  {
    a(IMErrorCode paramIMErrorCode) {}
    
    public void run()
    {
      if (IMNative.d(a.this.a) != null) {
        IMNative.d(a.this.a).onNativeRequestFailed(paramIMErrorCode);
      }
    }
  }
  
  class b
    implements Runnable
  {
    b() {}
    
    public void run()
    {
      try
      {
        if (IMNative.d(a.this.a) != null) {
          IMNative.d(a.this.a).onNativeRequestSucceeded(a.this.a);
        }
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        Log.debug("[InMobi]-[Monetization]", "Failed to give callback");
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/inmobi/monetization/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */