package com.jirbo.adcolony;

import android.app.Activity;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

class ADCNetwork
{
  public static String lowercase_hex_digits = "0123456789abcdef";
  public static final int timeout_seconds = 30;
  public static String uppercase_hex_digits;
  public static String url_encoding_map = "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx  x          xxxxxxx                          xxxx x                          xxxxx";
  
  static
  {
    uppercase_hex_digits = "0123456789ABCDEF";
  }
  
  static boolean connected()
  {
    return (using_wifi()) || (using_mobile());
  }
  
  public static int hex_character_to_value(char paramChar)
  {
    int i = uppercase_hex_digits.indexOf(paramChar);
    if (i >= 0) {
      return i;
    }
    paramChar = lowercase_hex_digits.indexOf(paramChar);
    if (paramChar >= 0) {
      return paramChar;
    }
    return 0;
  }
  
  public static String status()
  {
    if (using_wifi()) {
      return "wifi";
    }
    if (using_mobile()) {
      return "cell";
    }
    return "offline";
  }
  
  public static String url_decoded(String paramString)
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
            break label103;
          }
          c2 = paramString.charAt(i + 2);
          label67:
          i += 2;
          localStringBuilder.append((char)(hex_character_to_value(c1) << 8 | hex_character_to_value(c2)));
        }
      }
      for (;;)
      {
        i += 1;
        break;
        c1 = '0';
        break label51;
        label103:
        c2 = '0';
        break label67;
        localStringBuilder.append(c1);
      }
    }
    return localStringBuilder.toString();
  }
  
  public static String url_encoded(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int j = paramString.length();
    int i = 0;
    if (i < j)
    {
      char c = paramString.charAt(i);
      if ((c < '') && (url_encoding_map.charAt(c) == ' ')) {
        localStringBuilder.append(c);
      }
      for (;;)
      {
        i += 1;
        break;
        localStringBuilder.append('%');
        int k = c >> '\004' & 0xF;
        int m = c & 0xF;
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
  
  static boolean using_mobile()
  {
    NetworkInfo localNetworkInfo = ((ConnectivityManager)AdColony.activity().getSystemService("connectivity")).getActiveNetworkInfo();
    if (localNetworkInfo == null) {}
    int i;
    do
    {
      return false;
      i = localNetworkInfo.getType();
    } while ((i != 0) && (i < 2));
    return true;
  }
  
  static boolean using_wifi()
  {
    boolean bool = true;
    NetworkInfo localNetworkInfo = ((ConnectivityManager)AdColony.activity().getSystemService("connectivity")).getActiveNetworkInfo();
    if (localNetworkInfo == null) {
      return false;
    }
    if (localNetworkInfo.getType() == 1) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/jirbo/adcolony/ADCNetwork.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */