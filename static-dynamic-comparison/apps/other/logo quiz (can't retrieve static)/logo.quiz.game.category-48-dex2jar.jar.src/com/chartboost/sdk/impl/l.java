package com.chartboost.sdk.impl;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.chartboost.sdk.Chartboost;
import com.chartboost.sdk.Libraries.CBUtility;

public class l
{
  private static boolean a = false;
  
  public static boolean a()
  {
    try
    {
      Object localObject = Chartboost.sharedChartboost().getContext();
      if ((a) && (CBUtility.a((Context)localObject))) {
        return false;
      }
      localObject = (ConnectivityManager)((Context)localObject).getSystemService("connectivity");
      if (localObject != null)
      {
        localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
        if (localObject != null)
        {
          boolean bool = ((NetworkInfo)localObject).isConnectedOrConnecting();
          if (bool) {
            return true;
          }
        }
      }
      return false;
    }
    catch (Exception localException) {}
    return true;
  }
  
  public static int b()
  {
    try
    {
      Object localObject = (ConnectivityManager)Chartboost.sharedChartboost().getContext().getSystemService("connectivity");
      if (localObject != null)
      {
        localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
        if ((localObject != null) && (((NetworkInfo)localObject).isConnectedOrConnecting()))
        {
          int i = ((NetworkInfo)localObject).getType();
          if (i == 1) {
            return 1;
          }
          return 2;
        }
        return 0;
      }
      return -1;
    }
    catch (Exception localException) {}
    return -1;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/chartboost/sdk/impl/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */