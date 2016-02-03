package com.ideashower.readitlater.util;

import android.os.Build;

public class f
{
  private static boolean a = false;
  
  public static boolean a()
  {
    String str;
    if (Build.MANUFACTURER.equals("HTC"))
    {
      str = Build.MODEL;
      if (str != null) {
        break label21;
      }
    }
    label21:
    do
    {
      do
      {
        return false;
        str = str.toLowerCase();
        if (!str.startsWith("htc")) {
          break;
        }
      } while ((!str.equalsIgnoreCase("HTC_Flyer_P512_NA")) && (!str.equalsIgnoreCase("HTC Flyer P510e")) && (!str.equalsIgnoreCase("HTC Flyer P512")) && (!str.equalsIgnoreCase("HTC Flyer")));
      return true;
    } while (!str.equalsIgnoreCase("PG41200"));
    return true;
  }
  
  public static boolean b()
  {
    return (Build.MANUFACTURER.equalsIgnoreCase("ZTE")) && ((Build.MODEL.equalsIgnoreCase("blade")) || (Build.MODEL.equalsIgnoreCase("p729c")));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/util/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */