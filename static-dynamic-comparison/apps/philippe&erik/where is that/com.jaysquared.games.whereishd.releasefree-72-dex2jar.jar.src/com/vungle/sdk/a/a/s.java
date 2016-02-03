package com.vungle.sdk.a.a;

import android.content.Context;
import android.os.Bundle;
import com.vungle.sdk.ak;
import com.vungle.sdk.ba;

public abstract class s
  extends g
{
  void d()
  {
    super.d();
  }
  
  final Bundle f()
  {
    Bundle localBundle = super.f();
    localBundle.putString("X-VUNGLE-BUNDLE-ID", ak.e().getPackageName());
    localBundle.putString("X-VUNGLE-LANGUAGE", ba.b());
    localBundle.putString("X-VUNGLE-TIMEZONE", ba.c());
    String str = c();
    if ((str != null) && (str.startsWith("https"))) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        localBundle.putString("X-VUNG-AUTHORIZATION", ba.c(g()));
        localBundle.putString("X-VUNG-DATE", String.valueOf(System.currentTimeMillis()));
      }
      return localBundle;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/vungle/sdk/a/a/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */