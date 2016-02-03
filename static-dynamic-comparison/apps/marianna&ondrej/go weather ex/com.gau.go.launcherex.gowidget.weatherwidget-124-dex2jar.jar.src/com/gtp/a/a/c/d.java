package com.gtp.a.a.c;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

public class d
{
  private static String a = "";
  
  public static int a(Context paramContext)
  {
    paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    if (paramContext != null)
    {
      Log.d("PhoneMachine", "网络类型：" + paramContext.getType());
      switch (paramContext.getType())
      {
      default: 
        return 0;
      case 1: 
        return 1;
      case 0: 
        Log.d("PhoneMachine", "手机网制类型：" + paramContext.getSubtype());
        switch (paramContext.getSubtype())
        {
        default: 
          return 0;
        case 1: 
        case 2: 
        case 4: 
        case 7: 
          return 2;
        case 3: 
        case 5: 
        case 6: 
        case 8: 
        case 9: 
        case 10: 
        case 11: 
        case 12: 
        case 14: 
        case 15: 
          return 3;
        case 13: 
          return 4;
        }
        return 0;
      }
      return 5;
    }
    return 0;
  }
  
  public static boolean b(Context paramContext)
  {
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext != null)
    {
      paramContext = paramContext.getActiveNetworkInfo();
      if ((paramContext != null) && (paramContext.isConnected())) {
        return true;
      }
    }
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/a/a/c/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */