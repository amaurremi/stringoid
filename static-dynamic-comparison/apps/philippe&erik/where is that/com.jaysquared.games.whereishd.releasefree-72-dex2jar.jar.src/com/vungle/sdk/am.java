package com.vungle.sdk;

import android.util.Log;

final class am
  implements aj.a
{
  al.a a;
  
  am(al paramal) {}
  
  public final void a()
  {
    Log.e("RequestAd", "Failed to acquire advert.");
    ak.j = false;
    ak.k = Boolean.valueOf(false);
    this.a.a(e.k);
  }
  
  public final void a(aj.c paramc)
  {
    new StringBuilder(" -- Directory:  ").append(String.valueOf(paramc.a()));
    new StringBuilder(" -- PreRoll:    ").append(String.valueOf(paramc.c()));
    new StringBuilder(" -- PostRoll:   ").append(String.valueOf(paramc.d()));
    new StringBuilder(" -- Video:      ").append(String.valueOf(paramc.b()));
    new StringBuilder(" -- Expiration: ").append(String.valueOf(paramc.b));
    ak.j = true;
    ak.k = Boolean.valueOf(false);
    this.a.a(e.k);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/vungle/sdk/am.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */