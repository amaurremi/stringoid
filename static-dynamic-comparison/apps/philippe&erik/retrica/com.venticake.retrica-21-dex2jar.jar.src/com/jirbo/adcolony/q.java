package com.jirbo.adcolony;

import android.app.Activity;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

class q
{
  public static final int a = 30;
  public static String b = "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx  x          xxxxxxx                          xxxx x                          xxxxx";
  public static String c = "0123456789ABCDEF";
  public static String d = "0123456789abcdef";
  
  public static int a(char paramChar)
  {
    char c1 = c.indexOf(paramChar);
    if (c1 >= 0) {
      paramChar = c1;
    }
    do
    {
      return paramChar;
      c1 = d.indexOf(paramChar);
      paramChar = c1;
    } while (c1 >= 0);
    return 0;
  }
  
  public static String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int j = paramString.length();
    int i = 0;
    if (i < j)
    {
      char c1 = paramString.charAt(i);
      if ((c1 < '') && (b.charAt(c1) == ' ')) {
        localStringBuilder.append(c1);
      }
      for (;;)
      {
        i += 1;
        break;
        localStringBuilder.append('%');
        int k = c1 >> '\004' & 0xF;
        int m = c1 & 0xF;
        if (k < 10) {
          localStringBuilder.append((char)(k + 48));
        }
        for (;;)
        {
          if (m >= 10) {
            break label141;
          }
          localStringBuilder.append((char)(m + 48));
          break;
          localStringBuilder.append((char)(k + 65 - 10));
        }
        label141:
        localStringBuilder.append((char)(m + 65 - 10));
      }
    }
    return localStringBuilder.toString();
  }
  
  static boolean a()
  {
    NetworkInfo localNetworkInfo = ((ConnectivityManager)AdColony.activity().getSystemService("connectivity")).getActiveNetworkInfo();
    if (localNetworkInfo == null) {
      return false;
    }
    if (localNetworkInfo.getType() == 1) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static String b(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int j = paramString.length();
    int i = 0;
    if (i < j)
    {
      char c1 = paramString.charAt(i);
      label51:
      char c2;
      if (c1 == '%') {
        if (i + 1 < j)
        {
          c1 = paramString.charAt(i + 1);
          if (i + 2 >= j) {
            break label107;
          }
          c2 = paramString.charAt(i + 2);
          label67:
          int k = a(c1);
          localStringBuilder.append((char)(a(c2) | k << 8));
          i += 2;
        }
      }
      for (;;)
      {
        i += 1;
        break;
        c1 = '0';
        break label51;
        label107:
        c2 = '0';
        break label67;
        localStringBuilder.append(c1);
      }
    }
    return localStringBuilder.toString();
  }
  
  static boolean b()
  {
    NetworkInfo localNetworkInfo = ((ConnectivityManager)AdColony.activity().getSystemService("connectivity")).getActiveNetworkInfo();
    if (localNetworkInfo == null) {
      return false;
    }
    int i = localNetworkInfo.getType();
    if ((i == 0) || (i >= 2)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  static boolean c()
  {
    return (a()) || (b());
  }
  
  public static String d()
  {
    if (a()) {
      return "wifi";
    }
    if (b()) {
      return "cell";
    }
    return "offline";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/jirbo/adcolony/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */