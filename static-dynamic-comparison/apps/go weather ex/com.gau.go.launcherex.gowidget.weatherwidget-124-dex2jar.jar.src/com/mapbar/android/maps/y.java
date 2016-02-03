package com.mapbar.android.maps;

import android.content.Context;
import android.net.ConnectivityManager;

public class y
{
  private static y a;
  private Context b;
  private ConnectivityManager c;
  
  private y(Context paramContext)
  {
    this.b = paramContext;
    this.c = ((ConnectivityManager)this.b.getSystemService("connectivity"));
  }
  
  public static y a(Context paramContext)
  {
    if (a == null) {
      a = new y(paramContext);
    }
    return a;
  }
  
  public final ConnectivityManager a()
  {
    return this.c;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/mapbar/android/maps/y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */