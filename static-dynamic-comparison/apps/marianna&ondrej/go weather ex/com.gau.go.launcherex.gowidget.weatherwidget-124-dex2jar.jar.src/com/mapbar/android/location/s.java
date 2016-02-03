package com.mapbar.android.location;

import android.content.Context;
import android.net.ConnectivityManager;

public final class s
{
  private static s b;
  ConnectivityManager a;
  private Context c;
  
  private s(Context paramContext)
  {
    this.c = paramContext;
    this.a = ((ConnectivityManager)this.c.getSystemService("connectivity"));
  }
  
  public static s a(Context paramContext)
  {
    if (b == null) {
      b = new s(paramContext);
    }
    return b;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/mapbar/android/location/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */