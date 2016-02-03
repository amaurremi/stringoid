package com.google.analytics.tracking.android;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

class Utils
{
  private static final char[] HEXBYTES = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  
  public static String filterCampaign(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Object localObject2 = paramString;
    Object localObject1 = localObject2;
    if (paramString.contains("?"))
    {
      paramString = paramString.split("[\\?]");
      localObject1 = localObject2;
      if (paramString.length > 1) {
        localObject1 = paramString[1];
      }
    }
    if (((String)localObject1).contains("%3D")) {}
    while (((String)localObject1).contains("=")) {
      try
      {
        paramString = URLDecoder.decode((String)localObject1, "UTF-8");
        paramString = parseURLParameters(paramString);
        localObject1 = new String[9];
        localObject1[0] = "dclid";
        localObject1[1] = "utm_source";
        localObject1[2] = "gclid";
        localObject1[3] = "utm_campaign";
        localObject1[4] = "utm_medium";
        localObject1[5] = "utm_term";
        localObject1[6] = "utm_content";
        localObject1[7] = "utm_id";
        localObject1[8] = "gmob_t";
        localObject2 = new StringBuilder();
        int i = 0;
        while (i < localObject1.length)
        {
          if (!TextUtils.isEmpty((CharSequence)paramString.get(localObject1[i])))
          {
            if (((StringBuilder)localObject2).length() > 0) {
              ((StringBuilder)localObject2).append("&");
            }
            ((StringBuilder)localObject2).append(localObject1[i]).append("=").append((String)paramString.get(localObject1[i]));
          }
          i += 1;
        }
        paramString = (String)localObject1;
      }
      catch (UnsupportedEncodingException paramString)
      {
        return null;
      }
    }
    return null;
    return ((StringBuilder)localObject2).toString();
  }
  
  static int fromHexDigit(char paramChar)
  {
    char c = paramChar - '0';
    paramChar = c;
    if (c > '\t') {
      paramChar = c - '\007';
    }
    return paramChar;
  }
  
  static String getLanguage(Locale paramLocale)
  {
    if (paramLocale == null) {}
    while (TextUtils.isEmpty(paramLocale.getLanguage())) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramLocale.getLanguage().toLowerCase());
    if (!TextUtils.isEmpty(paramLocale.getCountry())) {
      localStringBuilder.append("-").append(paramLocale.getCountry().toLowerCase());
    }
    return localStringBuilder.toString();
  }
  
  static byte[] hexDecode(String paramString)
  {
    byte[] arrayOfByte = new byte[paramString.length() / 2];
    int i = 0;
    while (i < arrayOfByte.length)
    {
      arrayOfByte[i] = ((byte)(fromHexDigit(paramString.charAt(i * 2)) << 4 | fromHexDigit(paramString.charAt(i * 2 + 1))));
      i += 1;
    }
    return arrayOfByte;
  }
  
  static String hexEncode(byte[] paramArrayOfByte)
  {
    char[] arrayOfChar = new char[paramArrayOfByte.length * 2];
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      int j = paramArrayOfByte[i] & 0xFF;
      arrayOfChar[(i * 2)] = HEXBYTES[(j >> 4)];
      arrayOfChar[(i * 2 + 1)] = HEXBYTES[(j & 0xF)];
      i += 1;
    }
    return new String(arrayOfChar);
  }
  
  public static Map<String, String> parseURLParameters(String paramString)
  {
    HashMap localHashMap = new HashMap();
    paramString = paramString.split("&");
    int j = paramString.length;
    int i = 0;
    if (i < j)
    {
      String[] arrayOfString = paramString[i].split("=");
      if (arrayOfString.length > 1) {
        localHashMap.put(arrayOfString[0], arrayOfString[1]);
      }
      for (;;)
      {
        i += 1;
        break;
        if ((arrayOfString.length == 1) && (arrayOfString[0].length() != 0)) {
          localHashMap.put(arrayOfString[0], null);
        }
      }
    }
    return localHashMap;
  }
  
  public static void putIfAbsent(Map<String, String> paramMap, String paramString1, String paramString2)
  {
    if (!paramMap.containsKey(paramString1)) {
      paramMap.put(paramString1, paramString2);
    }
  }
  
  public static boolean safeParseBoolean(String paramString, boolean paramBoolean)
  {
    boolean bool = paramBoolean;
    if (paramString != null)
    {
      if ((!paramString.equalsIgnoreCase("true")) && (!paramString.equalsIgnoreCase("yes")) && (!paramString.equalsIgnoreCase("1"))) {
        break label37;
      }
      bool = true;
    }
    label37:
    do
    {
      return bool;
      if ((paramString.equalsIgnoreCase("false")) || (paramString.equalsIgnoreCase("no"))) {
        break;
      }
      bool = paramBoolean;
    } while (!paramString.equalsIgnoreCase("0"));
    return false;
  }
  
  public static double safeParseDouble(String paramString)
  {
    return safeParseDouble(paramString, 0.0D);
  }
  
  public static double safeParseDouble(String paramString, double paramDouble)
  {
    if (paramString == null) {
      return paramDouble;
    }
    try
    {
      double d = Double.parseDouble(paramString);
      return d;
    }
    catch (NumberFormatException paramString) {}
    return paramDouble;
  }
  
  public static long safeParseLong(String paramString)
  {
    if (paramString == null) {
      return 0L;
    }
    try
    {
      long l = Long.parseLong(paramString);
      return l;
    }
    catch (NumberFormatException paramString) {}
    return 0L;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/google/analytics/tracking/android/Utils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */